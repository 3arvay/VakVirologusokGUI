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
        Main.printSeq(1,"call",Main.nameMap.get(this),"GetUseTime",new String[] {""});
        Main.printSeq(1,"answer",Main.nameMap.get(this),"GetUseTime",new String[] {""});
        return this.useTime;
    }
    
    /**
    * Leírás:   Immune ágens hatásának kezdetét kiváltó metódus
    *
    * @return agent, az immunitás ágens
    */
    @Override
    public Immune AllotAttribute(Agent a)
    {
        Main.printSeq(2,"call", Main.nameMap.get(this), "AllotAttribute", new String[]{Main.nameMap.get(a)});
        Immune temp = new Immune();
        Main.printSeq(2,"answer", Main.nameMap.get(this), "AllotAttribute", new String[]{""});
        return temp;
    }
     /**
    * Leírás:   Immune ágens hatásának kezdetét kiváltó metódus
    *
    * @return agent, az immunitás ágens
    */
    @Override
    public Immunity Clone(Virologist v, Agent i)
    {
        Main.printSeq(1,"call",Main.nameMap.get(this),"Clone",new String[] {Main.nameMap.get(v),Main.nameMap.get(i)});
        v.CostTakeAway(v,i);
        Immunity temp = new Immunity();
        Main.nameMap.put(temp, "i");
        Main.printSeq(1,"answer",Main.nameMap.get(this),"Clone",new String[] {""});
        return temp;
    }
    /**
    * Leírás: Az Immunity ágens hatása lejár
    *   
    * @param v Virológus, az ágenslistájából eltűnik ez a Immunity
    */
    @Override
    public void KillAgent(Virologist v)
    {
        Main.printSeq(1,"call",Main.nameMap.get(this),"KillAgent",new String[] {Main.nameMap.get(v)});
        Main.printSeq(1,"answer",Main.nameMap.get(this),"KillAgent",new String[] {""});
    }
}
