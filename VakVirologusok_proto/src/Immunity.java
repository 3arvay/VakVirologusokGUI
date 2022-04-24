/**
* Az immunitást kiváltó ágenst valósítja meg.
*/
public class Immunity extends Agent
{
    /**
     * Leírás: Immunity ágens konstruktora
     */
    Immunity() {
        useTime = 5;
        nucleotidCost = 85;
        aminoacidCost = 80;
    }

    /**
    * Leírás:   Visszadja az ősosztálybeli useTime tagváltozó értékét
    *
    * @return useTime, a fennmaradt felhasználhatósági idő
    */
    @Override
    public int GetUseTime()
    {
        return useTime;
    }
    
    /**
    * Leírás:   Immune ágens hatásának kezdetét kiváltó metódus
    *
    * @return agent, az immunitás ágens
    */
    @Override
    public Immune AllotAttribute(Agent a)
    {
        return new Immune();
    }
     /**
    * Leírás:   Immune ágens hatásának kezdetét kiváltó metódus
    *
    * @return agent, az immunitás ágens
    */
    @Override
    public Immunity Clone(Virologist v, Agent i)
    {
        v.CostTakeAway(v,i);
        return new Immunity();
    }
    /**
    * Leírás: Az Immunity ágens hatása lejár
    *   
    * @param v Virológus, az ágenslistájából eltűnik ez a Immunity
    */
    @Override
    public void KillAgent(Virologist v)
    {
        v.RemoveAgent(this);
    }
}
