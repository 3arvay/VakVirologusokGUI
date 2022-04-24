import java.util.Map;

/**
 * Leírás: Balta felszerelés megvalósítása
 */
public class Axe extends Gear {
    private int durability;

    /**
     *
     */
    public Axe()
    {
        durability = 1;
        this.id = 3;
    }

    public void listAttributes(Map<String, Object> _varMap) {
        for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
            if (entry.getValue().equals(this)) {
                System.out.println(entry.getKey()+":");
                break;
            }
        }
        System.out.println("id:"+id+"\n"+"durability:"+durability);
    }

    @Override
    public Boolean Use(Virologist v, Agent a)
    {
        if (this.durability > 0)
        {
            this.durability--;
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
        return this;
    }

    /**
     * Leírás: Az ellopás műveletet a baltát az adott virológustól.
     *
     * @param  v: Akitől elveszik az objektumot
     * @return Gear: Az ellopott balta objektum
     */
    @Override
    public Gear StealAway(Virologist v, Virologist v2) {
        return v.RemoveGear(this);
    }
}
