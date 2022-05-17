/**
 * Ez valósítja meg a Stun ágenst, ez kenhető virológusokra. Amelyik virológust ezzel megkenik az lebénul
 */
public class Stun extends Agent
{
    /**
     * Leírás: Stun ágens konstruktora
     */
    Stun() {
        useTime = 6;
        nucleotidCost = 65;
        aminoacidCost = 30;
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
        return new Stunned();
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
        v.CostTakeAway(s);
        return new Stun();

    }
    
    /**
    * Leírás: Az ágenshatása lejár
    *
    * @param v: Az a virológus akinél lejár az ágens hatása
    */
    @Override
    public void KillAgent(Virologist v)
    {
        v.RemoveAgent(this);
    }
}
