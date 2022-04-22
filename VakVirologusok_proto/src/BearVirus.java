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
    public VAttribute AllotAttribute(Agent a) {
        return null;
    }

    @Override
    public void KillAgent(Virologist v) {

    }

    @Override
    public Agent Clone(Virologist v, Agent a) {
        return null;
    }

    @Override
    public int GetUseTime() {
        return 0;
    }
}
