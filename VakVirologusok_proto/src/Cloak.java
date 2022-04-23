/**
* Leírás: A virológus egyik felszerelését, a köpenyt valósítja meg.
*/
import java.util.Map;
import java.util.Random;

public class Cloak extends Gear
{
    private final double chance;

    /**
     * Leírás: Cloak objektum konstruktora
     */
    public Cloak()
    {
        this.id = 1;
        chance = 82.3;
    }

    public void listAttributes(Map<String, Object> _varMap) {
        for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
            if (entry.getValue().equals(this)) {
                System.out.println(entry.getKey()+":"+"\n");
                break;
            }
        }
        System.out.println("id:"+id+"\n"+"chance:"+chance+"\n");
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
        Main.printSeq(2,"call", Main.nameMap.get(this), "Use", new String[]{Main.nameMap.get(v), Main.nameMap.get(a)});

        Random rng = new Random();
        int result = rng.nextInt(100)+1;
        Main.printSeq(2,"answer", Main.nameMap.get(this), "Use", new String[]{""});
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
        Main.printSeq(3,"call", Main.nameMap.get(this), "PickUp", new String[]{Main.nameMap.get(v)});
        Main.printSeq(3,"answer", Main.nameMap.get(this), "PickUp", new String[]{Main.nameMap.get(v)});
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
