public class BearVirus extends Agent{

    /**
     * Leírás: BearVirus ágens konstruktora
     */
    BearVirus() {
        useTime = -1;
        nucleotidCost = 0;
        aminoacidCost = 0;
    }

    /**
     * @param a: Ágens amivel támadnak
     * @return Az ágens által kiváltott attribútum
     */
    @Override
    public VAttribute AllotAttribute(Agent a)
    {
        return new BearMode();
    }

    /**
     * @param v: A kenhető ágenst tároló virológus
     * @param a: A klónozandó ágens
     * @return
     */
    @Override
    public Agent Clone(Virologist v, Agent a)
    {
        v.CostTakeAway(a);
        return new BearVirus();
    }

    /**
     * @param v: A kenhető ágenst tároló virológus
     */
    @Override
    public void KillAgent(Virologist v) {}
}
