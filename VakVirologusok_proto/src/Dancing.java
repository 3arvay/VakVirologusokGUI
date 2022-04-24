/**
 * Leírás:
 * Az ágens egyik hatását valósítja meg.
 * A virológus ennek hatása alá kerül akkor vitustáncot folytat.
 */
public class Dancing extends VAttribute
{
    /**
     * Leírás:
     * Dancing ágens konstruktora
     */
    Dancing() {
        Main.nameMap.put(this, "da");
        Main.printSeq(3,"call", Main.nameMap.get(this), this.getClass().getSimpleName(), new String[]{""});
        Main.printSeq(3,"answer", Main.nameMap.get(this), this.getClass().getSimpleName(), new String[]{""});
    }

    @Override
    public void AttributeChanges(Virologist v)
    {
        v.RemoveAttribute(this);
    }
}
