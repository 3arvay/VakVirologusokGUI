/**
* Leírás: A Stun ágens hatását valósítja meg. Ennek hatása alatta virológus nem tud mozogni és ezalattmásikvirológus el tudja venni a nyersanyagait és felszereléseit.
*
*/
public class Stunned extends VAttribute
{
    /**
    * Leírás: Ez a Stunned osztály konstruktora
    *
    * @return VAttribute Stunned
    */
    Stunned() {
        Main.nameMap.put(this, "st");
        Main.printSeq(3,"call", Main.nameMap.get(this), this.getClass().getSimpleName(), new String[]{""});
        Main.printSeq(3,"answer", Main.nameMap.get(this), this.getClass().getSimpleName(), new String[]{""});
    }

    @Override
    public void AttributeChanges(Virologist v)
    {
        v.RemoveAttribute(this);
    }
}
