import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
* Leírás:
* Létrehozza a világot. Elindítja az idő múlását a játékban, jelzi a játék végét.
*/
public class Game
{
    enum Players{
        Red,
        Blue,
        Orange,
        Purple,
        Yellow,
        Green,
        Cian,
        Pink
    }
    private int nPlayers = 0;
    private List<Field> fieldsInGame;
    public List<Virologist> playersInGame;
    public HashMap<Players,Virologist> players =new HashMap<Players,Virologist>();
    public Virologist currentVirologist;
    public Field currentField;

    public Game (){
        nPlayers=0;
        fieldsInGame=null;
        playersInGame = null;

    }

    /**
     * Leírás: pályaelemek létrehozása
     */
    public void StartGame()
    {


        for(int i = 0; i < nPlayers; i++) { // annyi raktár és óvóhely ahány játékos, +1 field
            fieldsInGame.add(new Field());
            fieldsInGame.add(new Shelter());
            fieldsInGame.add(new Warehouse());
        }

        for(int i = 0; i < 4; i++) { // 4db labor, különböző ágensekkel
            fieldsInGame.add(new Laboratory(i));
        }

        for (Virologist v : playersInGame) { // minden játékos a kezdő mezőre
            v.SetInitialField(fieldsInGame.get(0));
        }

        SetFields();

        int currentIndex = 0;

        while (!CheckWin()) {
            currentVirologist = playersInGame.get(currentIndex);
            currentField = currentVirologist.GetMyField();

            if(currentVirologist.notStunned() && !currentField.equals(null)) {

                // TODO soronlévő játékos dolgai

            }

            if(currentIndex == playersInGame.size() - 1) {
                currentIndex = 0;
            } else {
                currentIndex++;
            }
        }

    }
    
    /**
    * Leírás:
    * véget vet a játéknak
    */
    public boolean CheckWin()
    {
        for(Virologist v: playersInGame) {
            if (v.GetNumOFGeneticCodes() == 4) {
                return true;
            }
        }
        return false;
    }

    /**
    * Leírás:
    * megfelelő felszereléseket és genetikai kódokat rendeli hozzá a megfelelő mezőkhöz.
    */
    public void SetFields()
    {
        Field last = new Field();
        last.AddNeighbour(fieldsInGame.get(fieldsInGame.size() -1));
        fieldsInGame.get(fieldsInGame.size() -1).AddNeighbour(last);
        Field temp = last;

        for(Field current : fieldsInGame) {
            last.AddNeighbour(current);
            current.AddNeighbour(last);
            last = current;
        }

        fieldsInGame.add(temp);

        for(Field current : fieldsInGame) {
            int nNeighbours = new Random().nextInt(5);
            for(int i = 0; i < nNeighbours; i++) {
                int randomIndex = new Random().nextInt(fieldsInGame.size());
                if (!current.Neighbours.contains(fieldsInGame.get(randomIndex))) {
                    current.AddNeighbour(fieldsInGame.get(randomIndex));
                    fieldsInGame.get(randomIndex).AddNeighbour(current);
                }
            }
        }
    }
}
