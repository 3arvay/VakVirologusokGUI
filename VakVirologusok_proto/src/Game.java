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
    private View mainview = new View();

    String[] players = new String[]{"Blue","Red","Pink","Yellow","Green","Orange","Cyan","Purple"};
    private int nPlayers;
    private List<Field> fieldsInGame;
    public List<Virologist> playersInGame;
    public HashMap<Virologist,String> playersPlaying =new HashMap<>();
    public Virologist currentVirologist;
    public Field currentField;

    public Game (){
        nPlayers=0;
        fieldsInGame = new ArrayList<Field>();
        playersInGame = new ArrayList<Virologist>();
        currentVirologist = null;
        currentField = null;
    }

    /**
     * Leírás: pályaelemek létrehozása
     */
    public void StartGame()
    {
       Start startView = new Start();
       startView.pack();
       startView.setVisible(true);

       while (startView.isVisible()) { // Várunk amíg nem választ játékosszámot (lehetne szebben is)
           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }



        for(int i = 0; i < startView.playerNum; i++) { // annyi raktár és óvóhely ahány játékos, +1 field
       //for(int i = 0; i < 2; i++) { // annyi raktár és óvóhely ahány játékos, +1 field
            fieldsInGame.add(new Field());
            fieldsInGame.add(new Shelter());
            fieldsInGame.add(new Warehouse());
            Virologist v = new Virologist();
            playersInGame.add(v);
            playersPlaying.put(v,players[i]);
        }

        for(int i = 0; i < 4; i++) { // 4db labor, különböző ágensekkel
            fieldsInGame.add(new Laboratory(i));
        }

        for (Virologist v : playersInGame) { // minden játékos a kezdő mezőre
            v.SetInitialField(fieldsInGame.get(0));
        }

        SetFields();


        mainview.pack();
        mainview.setVisible(true);
        int currentIndex = 0;
        while (!CheckWin()) {
            currentVirologist = playersInGame.get(currentIndex);
            currentField = currentVirologist.GetMyField();

            if(currentVirologist.notStunned() && !currentField.equals(null)) {

                // TODO soronlévő játékos dolgai
                System.out.println(currentVirologist); // for debug

                mainview.DrawAll(currentVirologist, playersPlaying); // újonnan sorrakerült jétékos, mindet rajzolhatunk

                while (mainview.activePlayersturn) { // Várunk az 5 fő gomb valamelyikére
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mainview.activePlayersturn = true;

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
