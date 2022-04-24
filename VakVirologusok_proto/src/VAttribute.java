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
    
    /**
    * Leírás: visszadja a durationtime tagváltozó értékét.
    *
    * @return int durationtime: Egy ágens hatásának ideje ami azt mutatja, hogy a virológus mennyi ideig van egy ágens hatása alatt.
    */
    public int GetDurationTime()
    {
        return durationtime;
    }
    
    /**
    * Leírás: Beállítja a durationtime tagváltozó értékét.
    *
    * @param duration: Egy szám amit majd a durationtime fog átvenni
    */
    public void SetDurationTime(int duration){
        durationtime=duration;
    }

    public void listAttributes(Map<String, Object> _varMap)
    {
        for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
            if (entry.getValue().equals(this)) {
                System.out.println(entry.getKey()+":");
                break;
            }
        }
        System.out.println( "durationTime:"+durationtime);
    }
}
