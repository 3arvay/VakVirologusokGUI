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
        return this.useTime;
    }

    @Override
    public VAttribute AllotAttribute(Agent a)
    {
        BearMode temp = new BearMode();
        return temp;
    }

    @Override
    public Agent Clone(Virologist v, Agent a)
    {
        v.CostTakeAway(v,a);
        BearVirus temp = new BearVirus();
        return temp;
    }

    @Override
    public void KillAgent(Virologist v)
    {
    }
}
