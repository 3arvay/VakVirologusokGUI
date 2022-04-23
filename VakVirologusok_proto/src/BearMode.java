public class BearMode extends VAttribute
{
    /**
     * Leírás: Lefuttatja a destruktort és visszavonja a hozzátartozó hatást.
     *
     */
    @Override
    public void AttributeChanges(Virologist v)
    {
        v.RemoveAttribute(this);
    }
}
