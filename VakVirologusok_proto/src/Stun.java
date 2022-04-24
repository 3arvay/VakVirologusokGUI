/**
* Ez valósítja meg a Stun ágenst, ez kenhető virológusokra. Amelyik virológust ezzel megkenik az lebénul
*/

import java.util.Map;

/**
 *
 */
public class Stun extends Agent
{
    /**
     * Leírás: Stun ágens konstruktora
     */
    Stun() {
        useTime = 7;
        nucleotidCost = 65;
        aminoacidCost = 30;
    }

    /**
    * Leírás: Az ágens felhasználható idejét adja vissza
    *
    * @return int UseTime: Az ágens felhasználható ideje
    */
    @Override
    public int GetUseTime()
    {
        Main.printSeq(1,"call",Main.nameMap.get(this),"GetUseTime",new String[] {""});
        Main.printSeq(1,"answer",Main.nameMap.get(this),"GetUseTime",new String[] {""});
        return this.useTime;
    }
    
    /**
    * Leírás: Ágens hatásának kezdetét kiváltó metódus
    *
    * @param a: Ágens amivel támadnak
    * @return VAttribute temp: Az ágens által kifejtett hatás
    */
    @Override
    public Stunned AllotAttribute(Agent a)
    {
        Main.printSeq(2,"call", Main.nameMap.get(this), "AllotAttribute", new String[]{Main.nameMap.get(a)});
        Stunned temp = new Stunned();
        Main.printSeq(2,"answer", Main.nameMap.get(this), "AllotAttribute", new String[]{""});
        return temp;
    }
    
    /**
    * Leírás: Egy kenhető ágenst hoz létre a meglévő ágenst tudástárából.
    *
    * @param v: Az a virológus aki elkészíti az ágenst
    * @param s: A Stun ágens amit leklónoz
    * @return Agent temp: Az újonnan létrejött Stun ágens
    */
    @Override
    public Stun Clone(Virologist v,Agent s)
    {
        Main.printSeq(1,"call",Main.nameMap.get(this),"Clone",new String[] {Main.nameMap.get(v),Main.nameMap.get(s)});
        v.CostTakeAway(v,s);
        Stun temp = new Stun();
        Main.nameMap.put(temp, "s");
        Main.printSeq(1,"answer",Main.nameMap.get(this),"Clone",new String[] {""});
        return temp;

    }
    
    /**
    * Leírás: Az ágenshatása lejár
    *
    * @param v: Az a virológus akinél lejár az ágens hatása
    */
    @Override
    public void KillAgent(Virologist v)
    {
        Main.printSeq(1,"call",Main.nameMap.get(this),"KillAgent",new String[] {Main.nameMap.get(v)});
        Main.printSeq(1,"answer",Main.nameMap.get(this),"KillAgent",new String[] {""});


    }


}
