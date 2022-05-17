/**
* Leírás: Az egyik ágens hatását valósítja meg. A virológus elfelejti az összes addig megtanult genetikai kódot, ha ennek az ágensnek a hatása alá kerül.
*/
public class Amnesia extends Agent
{
    /**
     * Leírás: Amnesia ágens konstruktora
     */
    Amnesia() {
        useTime = 4;
        nucleotidCost = 60;
        aminoacidCost = 65;
    }

    /**
    * Leírás: visszadja a useTime tagváltozó értékét.
    *
    * @return int: a hátralévő felhasználhatósági idő
    */
    @Override
    public int GetUseTime()
    {
        return useTime;
    }

    /**
     * Leírás: Amnesia hatásának kezdetét kiváltó metódus
     *
     * @param a: Ágens amivel támadnak
     * @return VAttribute: az ágens által kifejtett hatás
     */
    @Override
    public VAttribute AllotAttribute(Agent a)
    {
        return null;
    }
    
    /**
     * Leírás: Egy kenhető ágenst hoz létre a meglévő ágenst tudástárából.
     *
     * @param v: A kenhető ágenst tároló virológus
     * @param a: A klónozandó ágens
     * @return Agent: Az újonnan létrehozott ágens
     */
    @Override
    public Amnesia Clone(Virologist v, Agent a)
    {
        v.CostTakeAway(a);
        return new Amnesia();
    }
    
    /**
     * Leírás: Az ágens hatása lejár.
     *
     * @param v: A kenhető ágenst tároló virológus
     */
    @Override
    public void KillAgent(Virologist v)
    {
        v.RemoveAgent(this);
    }
}
