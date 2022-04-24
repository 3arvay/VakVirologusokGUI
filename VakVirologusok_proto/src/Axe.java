/**
 * Leírás: A virológus egyik felszerelését, a baltát valósítja meg.
 */
public class Axe extends Gear
{
    @Override
    public Boolean Use(Virologist v, Agent a) {
        return null;
    }

    /**
     * Leírás: felvételkor visszaadja a baltát mint felszerelést a virológusnak.
     *
     * @param  v: Aki felveszi az objektumot
     * @return Axe: A felvett balta objektum
     */
    @Override
    public Gear PickUp(Virologist v) {
        Main.printSeq(3,"call", Main.nameMap.get(this), "PickUp", new String[]{Main.nameMap.get(v)});
        Main.printSeq(3,"answer", Main.nameMap.get(this), "PickUp", new String[]{Main.nameMap.get(v)});
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
