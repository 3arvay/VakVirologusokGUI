/**
* Az ágenst valósítja meg és annak változóit.
*/
public abstract class Agent
{
    protected int useTime;
    protected int nucleotidCost;
    protected int aminoacidCost;
    /**
     * Leírás: Ágens hatásának kezdetét kiváltó metódus
     *
     * @param a: Ágens amivel támadnak
     * @return VAttribute: az ágens által kifejtett hatás
     */
    public abstract VAttribute AllotAttribute(Agent a);
    
    /**
     * Leírás: Az ágens hatása lejár
     *
     * @param v: A kenhető ágenst tároló virológus
     */
    public abstract void KillAgent(Virologist v);
    
    /**
     * Leírás: Egy kenhető ágenst hoz létre a meglévő ágenst tudástárából.
     *
     * @param v: A kenhető ágenst tároló virológus
     * @param a: A klónozandó ágens
     * @return Agent: Az újonnan létrehozott ágens
     */
    public abstract Agent Clone(Virologist v, Agent a);
        
    /**
    * Leírás: visszadja a nucleotidCost tagváltozó értékét
    *
    * @return int: nucleotidCost tagváltozó értéke
    */
    public int GetNucleotidCost()
    {
        return nucleotidCost;
    }
    
    /**
    * Leírás: visszadja a amioacidCost tagváltozó értékét
    *
    * @return int: amioacidCost tagváltozó értéke
    */
    public int GetAminoacidCost()
    {
        return aminoacidCost;
    }

    /**
     * Leírás: Az ágens felhasználhatósági ideje csökken
     * @param v: Ezen virológus ágenseit léptetjük
     */
    public void Step(Virologist v)
    {
        useTime -= 1;
        if(useTime == 0)
        {
            KillAgent(v);
        }
    }
}
