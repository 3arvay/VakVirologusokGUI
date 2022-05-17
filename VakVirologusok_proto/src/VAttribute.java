/**
* Leírás: Egy ágensek hatásának a pillanatnyi aktivitását hajtják végre a leszármazottjai.
*
*/
public abstract class VAttribute
{
    protected int durationtime;

    /**
    * Leírás: Az absztrakt osztály függvénye, a leszármazottjai valósítják meg, lefuttatják a destruktort és visszavonja a hozzátartozó hatást.
    *
    */
    public abstract void AttributeChanges(Virologist v);
    
    /**
    * Leírás: Az idő folyamatos múlását folytatja.
    *
    */
    public void Step(Virologist v)
    {
        durationtime-=1;
        if(durationtime == 0)
        {
            AttributeChanges(v);
        }
    }
}
