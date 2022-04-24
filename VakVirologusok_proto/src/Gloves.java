import java.util.Map;

/**
* Leírás:
* Egy kesztyűt, mint felszerelés valósítja meg.
*/
public class Gloves extends Gear
{
    private int durability;

    /**
    * Leírás:
    * Gloves konstruktora
    */
    public Gloves()
    {
        durability = 3;
        this.id = 0;
    }

    public void listAttributes(Map<String, Object> _varMap) {
        for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
            if (entry.getValue().equals(this)) {
                System.out.println(entry.getKey()+":"+"\n");
                break;
            }
        }
        System.out.println("id:"+id+"\n"+"durability:"+durability+"\n");
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
            v.GloveAttack(a);
            this.durability--;
        }
        return null;
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
        Main.printSeq(3,"call", Main.nameMap.get(this), "PickUp", new String[]{Main.nameMap.get(v)});
        Main.printSeq(3,"answer", Main.nameMap.get(this), "PickUp", new String[]{Main.nameMap.get(v)});
        return this;
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
        return v.RemoveGear(this);
    }
}
