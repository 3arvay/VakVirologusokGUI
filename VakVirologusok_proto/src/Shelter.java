import java.util.Map;

/**
* Leírás: Az óvóhely mező megvalósításáért felelős és számontartja az ott található felszerelés típusát.
*/
public class Shelter extends Field
{
    private Gear gear;
    
    /**
     * Leírás: Virológus lépését valósítja meg a óvóhely mezőre, és felveszi az adott felszerelést, ha még nincs nála az adott típusból.
     *
     * @param v: Aki a Shelter mezőre lép
     */
    @Override
    public void AddVirologist(Virologist v)
    {
        Main.printSeq(1,"call", Main.nameMap.get(this), "AddVirologist", new String[]{Main.nameMap.get(v)});
        standsHere.add(v);
        v.ReceiveGear(gear);
        Main.printSeq(1,"answer", Main.nameMap.get(this), "AddVirologist", new String[]{Main.nameMap.get(v)});
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
     * @param Gear g: A Shelterre helyezendő Gear objektum
     */
    public void SetGear(Gear g)
    {
        gear=g;
        Main.printSeq(0,"call", Main.nameMap.get(this), "SetGear", new String[]{Main.nameMap.get(g)});
        Main.printSeq(0,"answer", Main.nameMap.get(this), "SetGear", new String[]{Main.nameMap.get(g)});

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
