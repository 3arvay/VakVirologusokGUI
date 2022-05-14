import java.util.List;

/**
* Leírás:
* Létrehozza a világot. Elindítja az idő múlását a játékban, jelzi a játék végét.
*/
public class Game
{
    private int nPlayers;
    private List<Virologist> playersInGame;
    private List<Field> fieldsInGame;

    /**
    * Leírás: pályaelemek létrhozása
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
    }
    
    /**
    * Leírás:
    * véget vet a játéknak
    */
    public void Win()
    {

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

        for(Field current : fieldsInGame) {
            last.AddNeighbour(current);
            current.AddNeighbour(last);
            last = current;
        }
    }
}
