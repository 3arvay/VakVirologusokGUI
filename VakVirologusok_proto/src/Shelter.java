import java.util.Random;

/**
* Leírás: Az óvóhely mező megvalósításáért felelős és számontartja az ott található felszerelés típusát.
*/
public class Shelter extends Field
{
    private Gear gear;

    /**
     * Konstruktor, véletlenszerűen felszerelést helyez el az óvóhelyen
     */
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
}
