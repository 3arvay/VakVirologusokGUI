import javax.swing.*;
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
    private View mainview; // GUI
    private Timeable time;

    String[] players; // player colors
    private List<Field> fieldsInGame;
    public List<Virologist> playersInGame;
    public HashMap<Virologist,String> playersPlaying; // player -> unique color Map
    public Virologist currentVirologist;
    public Field currentField;

    /**
     * Game osztály konstrukor
     */
    public Game (){
        mainview = new View();
        players = new String[]{"Blue","Red","Pink","Yellow","Green","Orange","Cyan","Purple"};
        fieldsInGame = new ArrayList<>();
        playersInGame = new ArrayList<>();
        playersPlaying = new HashMap<>();
        currentVirologist = null;
        currentField = null;
        time = new Timeable() {
            @Override
            public void Tick() {
                for (Virologist v : playersInGame) {
                    v.Tick();
                }
            }
        };
    }

    /**
     * Leírás: pályaelemek létrehozása
     */
    public void StartGame()
    {
       Start startView = new Start();
       startView.pack();
       startView.setVisible(true);

       while (startView.isVisible()) { // Várunk amíg nem választ játékosszámot
           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

        for(int i = 0; i < startView.playerNum; i++) { // annyi raktár és óvóhely ahány játékos, +1 field
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
        currentVirologist = playersInGame.get(currentIndex);
        while (!CheckWin()) {
            currentVirologist = playersInGame.get(currentIndex);
            currentField = currentVirologist.GetMyField();

            if( !currentField.equals(null)) {

                mainview.DrawAll(currentVirologist, playersPlaying); // újonnan sorrakerült jétékos, mindet rajzolhatunk

                while (mainview.activePlayersturn) { // Várunk az 5 fő gomb valamelyikére

                    if(currentVirologist.Stunned()) {
                        JOptionPane.showMessageDialog(mainview, "You're stunned!");
                        mainview.activePlayersturn = false;
                    }

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                mainview.activePlayersturn = true;

            }

            if(currentIndex == playersInGame.size() - 1) {
                time.Tick();
                currentIndex = 0;
            } else {
                currentIndex++;
            }
        }
        mainview.WinDialogShow(playersPlaying.get(currentVirologist));
    }

    /**
     * Leírás:
     * Ha egy játékos összegyűjtötte az összes lehetséges genetikai kódot, nyer
     * @return true: ha van nyertes; false: ha nincs
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
                if (!current.Neighbours.contains(fieldsInGame.get(randomIndex)) && !current.equals(fieldsInGame.get(randomIndex))) {
                    current.AddNeighbour(fieldsInGame.get(randomIndex));
                    fieldsInGame.get(randomIndex).AddNeighbour(current);
                }
            }
        }
    }
}
