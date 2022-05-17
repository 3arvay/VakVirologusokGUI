import java.util.Map;

/**
* Leírás: Egy ágensek hatásának a pillanatnyi aktivitását hajtják végre a leszármazottjai.
*
*/
public abstract class VAttribute
{
    protected int durationtime;


    public void setter(String value){
        try{
            durationtime=Integer.parseInt(value);
        }
        catch(NumberFormatException e){
            System.out.println("Hibás számformátumot adtál meg");
        }
    }
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
