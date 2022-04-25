/**
* Leírás: A virológus egyik felszerelését, a köpenyt valósítja meg.
*/
import java.util.Map;
import java.util.Random;

public class Cloak extends Gear
{
    private double chance;

    /**
     * Leírás: Cloak objektum konstruktora
     */
    public Cloak()
    {
        id = 1;
        chance = 82.3;
    }
    public void setter(String value){
        double newChance=Double.parseDouble(value);
        if(newChance>=0&&newChance<=100){
            chance=newChance;
        }
        else{System.out.println("Hibás értéket adtál meg.");}
    }

    public void listAttributes(Map<String, Object> _varMap) {
        for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
            if (entry.getValue().equals(this)) {
                System.out.println(entry.getKey()+":");
                break;
            }
        }
        System.out.println( "id:"+id+"\r\n"+
                            "chance:"+chance);
    }
    /**
     * Leírás: Egy kenhető ágenst hoz létre a meglévő ágenst tudástárából.
     *
     * @param  v: A Cloak-ot viselő virológus
     * @param  a: Ágens amivel megtámadták
     * @return Boolean: true, ha sikeres a védelem; false, ha nem
     */
    @Override
    public Boolean Use(Virologist v, Agent a) {
        Random rng = new Random();
        int result = rng.nextInt(100)+1;
        return result <= chance;
    }

    /**
     * Leírás: felvételkor visszaadja a köpenyt mint felszerelést a virológusnak.
     *
     * @param  v: Aki felveszi az objektumot
     * @return Cloak: A felvett köpeny objektum
     */
    @Override
    public Cloak PickUp(Virologist v)
    {
        return this;
    }

    /**
     * Leírás: Az ellopás műveletet a köpenyt az adott virológustól.
     *
     * @param  v: Akitől elveszik az objektumot
     * @return Gear: Az ellopott köpeny objektum
     */
    @Override
    public Gear StealAway(Virologist v, Virologist v2)
    {
        return v.RemoveGear(this);
    }

    /**
     * Leírás: visszadja a chance tagváltozó értékét
     *
     * @return double: a chance tagváltozó értéke
     */
    public double GetChance()
    {
        return chance;
    }
}
