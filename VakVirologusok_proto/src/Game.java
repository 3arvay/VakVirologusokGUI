import java.util.List;

/**
* Leírás:
* Létrehozza a világot. Elindítja az idő múlását a játékban, jelzi a játék végét.
*/
public class Game
{
    private int nPlayers;
    private int numOfAgents;
    private List<Virologist> playersInGame;
    private List<Field> fieldsInGame;

    /**
    * Leírás:
    * Game konstruktora
    */
    public void StartGame()
    {
        for(int i = 0; i < nPlayers; i++) {
            fieldsInGame.add(new Field());
        }
        for(int i = 0; i < 4; i++) {
            fieldsInGame.add(new Laboratory(i));
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

    }

    /**
    * Leírás:
    * visszadja a numOfAgents tagváltozó értékét
    * @return int numOfAgents
    */
    public int GetNumOfAgents()
    {
        return numOfAgents;
    }
}
