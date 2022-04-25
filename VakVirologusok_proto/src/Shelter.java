import java.util.Map;
import java.util.Random;

/**
* Leírás: Az óvóhely mező megvalósításáért felelős és számontartja az ott található felszerelés típusát.
*/
public class Shelter extends Field
{
    private Gear gear;

    public Shelter() {
        gear = new Gear[] {new Gloves(), new Cloak(), new Bag(), new Axe()} [new Random().nextInt(4)];
    }
    
    /**
     * Leírás: Virológus lépését valósítja meg a óvóhely mezőre, és felveszi az adott felszerelést, ha még nincs nála az adott típusból.
     *
     * @param v: Aki a Shelter mezőre lép
     */
    @Override
    public void AddVirologist(Virologist v)
    {
        standsHere.add(v);
        v.SetF1(this);
        v.ReceiveGear(gear);
    }

    /**
     * Leírás: visszadja a gear tagváltozó másolatát.
     *
     * @return Gear: a gear tagváltozó másolata
     */
    public Gear GetGear()
    {
        return gear;
    }

    /**
     * Leírás: Inicializáláskor egy adott felszerelést helyez el az óvóhelyen.
     *
     * @param g: A Shelterre helyezendő Gear objektum
     */
    public void SetGear(Gear g)
    {
        gear=g;
    }


    public void listAttributes(Map<String, Object> _varMap) {
        for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
            if (entry.getValue().equals(this)) {
                System.out.println(entry.getKey()+":");
                break;
            }
        }
        int i = 1;
        while (i <= Neighbours.size()) {
            for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
                if (entry.getValue().equals(Neighbours.get(i-1))) {
                    System.out.println("neighbour" + i++ + ":" + entry.getKey());
                    break;
                }
            }
        }
        i = 1;
        while (i <= standsHere.size()) {
            for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
                if (entry.getValue().equals(standsHere.get(i-1))) {
                    System.out.println("virologist" +i++ + ":" + entry.getKey());
                    break;
                }
            }
        }
        String gear_temp = null;
        for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
            if (entry.getValue().equals(gear)) {
                gear_temp=entry.getKey();
                break;
            }
        }
        System.out.println("gear:"+gear_temp);

    }
}
