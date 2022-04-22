public class BearVirus extends Agent
{

    @Override
    public int GetUseTime()
    {
        Main.printSeq(1,"call",Main.nameMap.get(this),"GetUseTime",new String[] {""});
        Main.printSeq(1,"answer",Main.nameMap.get(this),"GetUseTime",new String[] {""});
        return this.useTime;
    }

    @Override
    public VAttribute AllotAttribute(Agent a)
    {
        Main.printSeq(2,"call", Main.nameMap.get(this), "AllotAttribute", new String[]{Main.nameMap.get(a)});
        BearMode temp = new BearMode();
        Main.printSeq(2,"answer", Main.nameMap.get(this), "AllotAttribute", new String[]{""});
        return temp;
    }

    @Override
    public Agent Clone(Virologist v, Agent a)
    {
        Main.printSeq(1,"call",Main.nameMap.get(this),"Clone",new String[] {Main.nameMap.get(v),Main.nameMap.get(a)});
        v.CostTakeAway(v,a);
        BearVirus temp = new BearVirus();
        Main.nameMap.put(temp, "bv");
        Main.printSeq(1,"answer",Main.nameMap.get(this),"Clone",new String[] {""});
        return temp;
    }

    @Override
    public void KillAgent(Virologist v)
    {
        Main.printSeq(1,"call",Main.nameMap.get(this),"KillAgent",new String[] {Main.nameMap.get(v)});
        Main.printSeq(1,"answer",Main.nameMap.get(this),"KillAgent",new String[] {""});
    }
}
