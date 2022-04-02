/**
* Leírás: A virológus egyik felszerelését, a zsákot valósítja meg.
*/
public class Bag extends Gear
{
    private int size;

    /**
     * Leírás: visszadja a size tagváltozó értékét
     *
     * @return int: a size tagváltozó értéke
     */
    public int GetSize()
    {
        return size;
    }

    /**
     * Leírás: Bag objektum konstruktora
     */
    public Bag()
    {
        this.id = 2;
    }

    /**
     * Leírás: Felvételkor megnöveli az nyersanyagok férőhelyét a virológusnál.
     *
     * @param Virologist v: Aki a zsákot felveszi
     * @param Agent a
     * @return Boolean
     */
    @Override
    public Boolean Use(Virologist v, Agent a)
    {
        Main.printSeq(4,"call", Main.nameMap.get(this), "Use", new String[]{Main.nameMap.get(v),"a"});
        v.ExtendCapacity(size);
        Main.printSeq(4,"answer", Main.nameMap.get(this), "Use", new String[]{Main.nameMap.get(v),"a"});
        return true;
    }

    /**
     * Leírás: felvételkor átadja a zsákot mint felszerelést a virológusnak.
     *
     * @param Virologist v: Aki a zsákot felveszi
     * @return Gear: A felvett Bag objektum
     */
    @Override
    public Gear PickUp(Virologist v)
    {
        Main.printSeq(3,"call", Main.nameMap.get(this), "PickUp", new String[]{Main.nameMap.get(v)});
        this.Use(v,null);
        Main.printSeq(3,"answer", Main.nameMap.get(this), "PickUp", new String[]{Main.nameMap.get(v)});
        return this;
    }

    /**
     * Leírás: Ellopja a zsákot az adott virológustól.
     *
     * @param Virologist v: Akitől a zsákot elveszik
     * @return Gear: Az elvett Bag objektum
     */
    @Override
    public Gear StealAway(Virologist v)
    {
        v.LowerCapacity(size);
        return v.RemoveGear(this);
    }
}
