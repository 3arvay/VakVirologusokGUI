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
     * Leírás:   Immune ágens hatásának kezdetét kiváltó metódus
     * @param a: Ágens amivel támadnak
     * @return A kiváltott hatás
     */
    @Override
    public Immune AllotAttribute(Agent a)
    {
        return new Immune();
    }

    /**
     * Ágens másolat készítése főként kraftoláshoz
     * @param v: A kenhető ágenst tároló virológus
     * @param i Ezt klónozzuk
     * @return Az új ágens
     */
    @Override
    public Immunity Clone(Virologist v, Agent i)
    {
        v.CostTakeAway(i);
        return new Immunity();
    }

    /**
    * Leírás: Az Immunity ágens hatása lejár
    * @param v Virológus, az ágenslistájából eltűnik ez a Immunity
    */
    @Override
    public void KillAgent(Virologist v)
    {
        v.RemoveAgent(this);
    }
}
