/**
* Leírás:
* Egy kesztyűt, mint felszerelés valósítja meg.
*/
public class Gloves extends Gear
{
    /**
    * Leírás:
    * Gloves konstruktora
    */
    public Gloves()
    {
        durability = 3;
        id = 0;
    }

    /**
     * Leírás: visszakenés műveletét valósítja meg akkor, ha egy virológus visel kesztyűt és megtámadják, azaz a támadón érvényesül a támadó ágensének hatása.
     * @param  v Virologist akivel szemben használják a felszerelést
     * @param  a Ágens ami ellen védekezni kell
     * @return true: ha sikeres; false: ha nem
     */
    @Override
    public Boolean Use(Virologist v, Agent a) {
        if (this.durability > 0)
        {
            v.SpecialAttack(a);
            this.durability--;
            return true;
        }
        return false;
    }

    /**
     * Felszerelés felvétele
     * @param  v Aki felveszi
     * @return a felvett kesztyú
     */
    @Override
    public Gear PickUp(Virologist v)
    {
        return new Gloves();
    }

    /**
     * Felszerelés ellopása
     * @param v Virologist aki lop
     * @param v2 akitől lopnak
     * @return Az ellopott felszerelés
     */
    @Override
    public Gear StealAway(Virologist v, Virologist v2)
    {
        Gear temp = v2.getGearList()[0];
        v2.getGearList()[0] = null;
        return temp;
    }
}
