/**
*    Az immunity ágens hatását valósítja meg. Ennek hatása alatt a virológus immunis lesz más virológusok támadásaira.
*   Immune → VAttribute
*/
public class Immune extends VAttribute
{
    /**
    * Leírás: Immune attribútum konstruktora
    */
    Immune() {
        durationtime = 5;
    }

    /**
     * Tulajdonság elmúlása
     * @param v Aki jobban lesz...
     */
    @Override
    public void AttributeChanges(Virologist v)
    {
        v.RemoveAttribute(this);
    }
}
