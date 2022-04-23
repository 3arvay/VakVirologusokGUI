import java.util.Map;

/**
* Az ágenst valósítja meg és annak változóit.
*/
public abstract class Agent
{
    protected int useTime =0;
    protected int nucleotidCost;
    protected int aminoacidCost;
    private VAttribute vAttribute;
    
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
    * Leírás: visszadja a useTime tagváltozó értékét
    *
    * @return int: a hátralévő felhasználhatósági idő
    */
    public abstract int GetUseTime();
        
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

    public void listAttributes(Map<String, Object> _varMap)
    {
        for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
            if (entry.getValue().equals(this)) {
                System.out.println(entry.getKey()+":");
                break;
            }
        }
        System.out.println( "useTime:"+useTime+"nucleotidCost:"+nucleotidCost+
                "aminoacidCost:"+aminoacidCost);
    }
}
