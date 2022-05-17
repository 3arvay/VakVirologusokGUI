/**
* Leírás:
* Óvóhelyen található felszerelések ősosztálya.
*/
public abstract class Gear
{
    protected int id;
    protected int durability = -1;

    /**
    * Leírás:
    * A különböző felszerelések használatát valósítják meg a leszármazottjai, absztrakt metódus.
    * @param  v Virologist akivel szemben használják a felszerelést
    * @param  a Ágens ami ellen védekezni kell
    * @return Booelean
    */
    public abstract Boolean Use(Virologist v, Agent a);
    
    /**
    * Leírás:
    * Az egyes felszerelések felvételi metódusait valósítják meg a leszármazottjai, absztrakt metódus.
    * @param  v Aki felveszi
    * @return Gear gear
    */
    public abstract Gear PickUp(Virologist v);

    /**
     * Felszerelés elvétele
     * @param v Virologist aki lop
     * @param v2 akitől lopnak
     * @return az ellopott felszerelést
     */
    public abstract Gear StealAway(Virologist v, Virologist v2);

    /**
    * Leírás:
    * visszadja az id tagváltozó értékét
    * @return int id
    */
    public int GetID()
    {
        return id;
    }

    /**
     * Leírás:
     * visszadja az id durability értékét
     * @return int durability
     */
    public int GetDurability() {return durability;}
}
