public class BearVirus extends Agent{

    /**
     * Leírás: BearVirus ágens konstruktora
     */
    BearVirus() {
        useTime = -1;
        nucleotidCost = 0;
        aminoacidCost = 0;
    }

    @Override
    public int GetUseTime()
    {
        return useTime;
    }

    @Override
    public VAttribute AllotAttribute(Agent a)
    {
        return new BearMode();
    }

    @Override
    public Agent Clone(Virologist v, Agent a)
    {
        v.CostTakeAway(v,a);
        return new BearVirus();
    }

    @Override
    public void KillAgent(Virologist v) {}
}
