/**
* Leírás: A virológus egyik felszerelését, a zsákot valósítja meg.
*/
public class Bag extends Gear
{
    private int size;

    /**
     * Leírás: Bag objektum konstruktora
     */
    Bag() {
        id = 2;
        size = 50;
    }

    /**
     * Leírás: Felvételkor megnöveli az nyersanyagok férőhelyét a virológusnál.
     *
     * @param  v: Aki a zsákot felveszi
     * @param  a: null
     * @return Boolean
     */
    @Override
    public Boolean Use(Virologist v, Agent a)
    {
        return null;
    }

    /**
     * Leírás: felvételkor átadja a zsákot mint felszerelést a virológusnak.
     *
     * @param  v: Aki a zsákot felveszi
     * @return Gear: A felvett Bag objektum
     */
    @Override
    public Gear PickUp(Virologist v)
    {
        v.ExtendCapacity(size);
        return new Bag();
    }

    /**
     * Leírás: Ellopja a zsákot az adott virológustól.
     *
     * @param v2 Virologist: Akitől a zsákot elveszik
     * @return Gear: Az elvett Bag objektum
     */
    @Override
    public Gear StealAway(Virologist v, Virologist v2)
    {
        v2.LowerCapacity(size);
        v.ExtendCapacity(size);
        Gear temp = v2.getGearList()[2];
        v2.getGearList()[2] = null;
        return temp;
    }
}
