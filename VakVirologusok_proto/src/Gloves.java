import java.util.Map;

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
    * Leírás:
    * visszakenés műveletét valósítja meg akkor, ha egy virológus visel kesztyűt és megtámadják, azaz a támadón érvényesül a támadó ágensének hatása.
    * @param v
    * @param a
    * @return Boolean
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
    * Leírás:
    * A kesztyű felszerelés felvételét valósítja meg, felveszi a virológus a felszerelései közé.
    * @param v
    * @return gear
    */
    @Override
    public Gear PickUp(Virologist v)
    {
        return new Gloves();
    }

    /**
    * Leírás:
    * Az ellopás műveletet valósítja meg, a kesztyűt az adott virológustól.
    * @param v
    * @return Gear gear
    */
    @Override
    public Gear StealAway(Virologist v, Virologist v2)
    {
        Gear temp = v2.getGearList()[0];
        v2.getGearList()[0] = null;
        return temp;
    }
}
