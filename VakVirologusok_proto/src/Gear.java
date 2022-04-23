/**
* Leírás:
* Óvóhelyen található felszerelések ősosztálya.
*/
public abstract class Gear
{
    protected int id;
    //protected int useage;

    /**
    * Leírás:
    * A különböző felszerelések használatát valósítják meg a leszármazottjai, absztrakt metódus.
    * @param  v
    * @param  a
    * @return Booelean
    */
    public abstract Boolean Use(Virologist v, Agent a);
    
    /**
    * Leírás:
    * Az egyes felszerelések felvételi metódusait valósítják meg a leszármazottjai, absztrakt metódus.
    * @param  v
    * @return Gear gear
    */
    public abstract Gear PickUp(Virologist v);
    
    /**
    * Leírás:
    * Az egyes virológustól való ellopás műveleteket valósítják meg a leszármazottjai, absztrakt metódus
    * @param  v
    * @return Gear gear
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
    * beállítja az id tagváltozó értékét
    * @param  i
    */
    public void SetID(int i)
    {
        id = i;
    }
}
