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

    public void setter(String value){
        int newDurability=Integer.parseInt(value);
        if(newDurability>=0&&newDurability<=3) {
            durability=newDurability;
        }
        else{System.out.println("Hibás értéket adtál meg.");}
    }
}
