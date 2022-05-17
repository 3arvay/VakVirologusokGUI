/**
* Leírás: A Stun ágens hatását valósítja meg. Ennek hatása alatta virológus nem tud mozogni és ezalattmásikvirológus el tudja venni a nyersanyagait és felszereléseit.
*
*/
public class Stunned extends VAttribute
{
    /**
     * Leírás: Stunned attribútum konstruktora
     */
    Stunned() {
        durationtime = 3;
    }

    /**
     * Az ágens hatásának ideje lejár
     * @param v Aki jobban lesz...
     */
    @Override
    public void AttributeChanges(Virologist v)
    {
        v.RemoveAttribute(this);
    }
}
