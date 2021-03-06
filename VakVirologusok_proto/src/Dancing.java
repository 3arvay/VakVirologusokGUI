/**
 * Leírás:
 * Az ágens egyik hatását valósítja meg.
 * A virológus ennek hatása alá kerül akkor vitustáncot folytat.
 */
public class Dancing extends VAttribute
{
    /**
     * Leírás:
     * Dancing attribútum konstruktora
     */
    Dancing() {
        durationtime = 5;
    }

    /**
     *
     * @param v A virológus, aki jobban lesz...
     */
    @Override
    public void AttributeChanges(Virologist v)
    {
        v.RemoveAttribute(this);
    }
}
