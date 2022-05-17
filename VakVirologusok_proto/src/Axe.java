/**
 * Leírás: Balta felszerelés megvalósítása
 */
public class Axe extends Gear {
    /**
     * Konstruktor
     */
    public Axe()
    {
        durability = 1;
        id = 3;
    }

    /**
     *
     * @param  v Virologist akivel szemben használják a felszerelést
     * @param  a Ágens ami ellen védekezni kell
     * @return
     */
    @Override
    public Boolean Use(Virologist v, Agent a)
    {
        if (durability > 0)
        {
            durability = 0;
            v.YourKilled();
            return true;
        }
        return false;
    }

    /**
     * Leírás: felvételkor visszaadja a baltát mint felszerelést a virológusnak.
     *
     * @param  v: Aki felveszi az objektumot
     * @return Axe: A felvett balta objektum
     */
    @Override
    public Gear PickUp(Virologist v) {
        return new Axe();
    }

    /**
     * Leírás: Az ellopás műveletet a baltát az adott virológustól.
     *
     * @param  v2: Akitől elveszik az objektumot
     * @return Gear: Az ellopott balta objektum
     */
    @Override
    public Gear StealAway(Virologist v, Virologist v2) {
        Gear temp = v2.getGearList()[3];
        v2.getGearList()[3] = null;
        return temp;
    }

    /**
     *
     * @return durability value
     */
    public int GetDurability() {
        return durability;
    }
}
