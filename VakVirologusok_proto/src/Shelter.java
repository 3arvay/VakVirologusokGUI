/**
* Leírás: Az óvóhely mező megvalósításáért felelős és számontartja az ott található felszerelés típusát.
*/
public class Shelter extends Field
{
    private Gear gear;
    
    /**
     * Leírás: Virológus lépését valósítja meg a óvóhely mezőre, és felveszi az adott felszerelést, ha még nincs nála az adott típusból.
     *
     * @param  v: Aki a Shelter mezőre lép
     */
    @Override
    public void AddVirologist(Virologist v)
    {
        //Main.printSeq(1,"call", Main.nameMap.get(this), "AddVirologist", new String[]{Main.nameMap.get(v)});
        standsHere.add(v);
        v.ReceiveGear(gear);
        //Main.printSeq(1,"answer", Main.nameMap.get(this), "AddVirologist", new String[]{Main.nameMap.get(v)});
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
     * @param  g: A Shelterre helyezendő Gear objektum
     */
    public void SetGear(Gear g)
    {
        gear=g;
        Main.printSeq(0,"call", Main.nameMap.get(this), "SetGear", new String[]{Main.nameMap.get(g)});
        Main.printSeq(0,"answer", Main.nameMap.get(this), "SetGear", new String[]{Main.nameMap.get(g)});

    }
}
