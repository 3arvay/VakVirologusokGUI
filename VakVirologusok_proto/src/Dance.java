/**
* Leírás: A vitustáncot kiváltó felkenhető ágenst valósítja meg
*/
public class Dance extends Agent
{
    /**
     * Leírás: Dance ágens konstruktora
     */
    Dance() {
        useTime = 8;
        nucleotidCost = 70;
        aminoacidCost =  40;
    }

    /**
    * Leírás: visszadja a useTime tagváltozó értékét
    *
    * @return int: a hátralévő felhasználhatósági idő
    */
    @Override
    public int GetUseTime()
    {
        return useTime;
    }

    /**
     * Leírás: Ágens hatásának kezdetét kiváltó metódus
     *
     * @param a: Ágens amivel támadnak
     * @return VAttribute: az ágens által kifejtett hatás
     */
    @Override
    public VAttribute AllotAttribute(Agent a)
    {
        return new Dancing();
    }

    /**
     * Leírás: Egy kenhető ágenst hoz létre a meglévő ágenst tudástárából.
     *
     * @param v: A kenhető ágenst tároló virológus
     * @param a: A klónozandó ágens
     * @return Agent: Az újonnan létrehozott ágens
     */
    @Override
    public Dance Clone(Virologist v, Agent a)
    {
        v.CostTakeAway(v,a);
        return new Dance();
    }

    /**
     * Leírás: Az ágens hatása lejár
     *
     * @param v: A kenhető ágenst tároló virológus
     */
    @Override
    public void KillAgent(Virologist v)
    {
        v.RemoveAgent(this);
    }
}
