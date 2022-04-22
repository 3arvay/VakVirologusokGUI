/**
* Leírás: Az egyik ágens hatását valósítja meg. A virológus elfelejti az összes addig megtanult genetikai kódot, ha ennek az ágensnek a hatása alá kerül.
*/
public class Amnesia extends Agent
{
    /**
     * Leírás: Amnesia ágens konstruktora
     */
    Amnesia() {
        useTime = 4;
        nucleotidCost = 60;
        aminoacidCost = 65;
    }

    /**
    * Leírás: visszadja a useTime tagváltozó értékét.
    *
    * @return int: a hátralévő felhasználhatósági idő
    */
    @Override
    public int GetUseTime()
    {
        Main.printSeq(1,"call",Main.nameMap.get(this),"GetUseTime",new String[] {""});
        Main.printSeq(1,"answer",Main.nameMap.get(this),"GetUseTime",new String[] {""});
        return this.useTime;
    }

    /**
     * Leírás: Amnesia hatásának kezdetét kiváltó metódus
     *
     * @param a: Ágens amivel támadnak
     * @return VAttribute: az ágens által kifejtett hatás
     */
    @Override
    public VAttribute AllotAttribute(Agent a)
    {
        Main.printSeq(2,"call", Main.nameMap.get(this), "AllotAttribute", new String[]{Main.nameMap.get(a)});
        Main.printSeq(2,"answer", Main.nameMap.get(this), "AllotAttribute", new String[]{""});
        return null;
    }
    
    /**
     * Leírás: Egy kenhető ágenst hoz létre a meglévő ágenst tudástárából.
     *
     * @param v: A kenhető ágenst tároló virológus
     * @param a: A klónozandó ágens
     * @return Agent: Az újonnan létrehozott ágens
     */
    @Override
    public Amnesia Clone(Virologist v, Agent a)
    {
        Main.printSeq(1,"call",Main.nameMap.get(this),"Clone",new String[] {Main.nameMap.get(v),Main.nameMap.get(a)});
        v.CostTakeAway(v,a);
        Amnesia temp = new Amnesia();
        Main.nameMap.put(temp, "a");
        Main.printSeq(1,"answer",Main.nameMap.get(this),"Clone",new String[] {""});
        return temp;
    }
    
    /**
     * Leírás: Az ágens hatása lejár.
     *
     * @param v: A kenhető ágenst tároló virológus
     */
    @Override
    public void KillAgent(Virologist v)
    {
        Main.printSeq(1,"call",Main.nameMap.get(this),"KillAgent",new String[] {Main.nameMap.get(v)});
        Main.printSeq(1,"answer",Main.nameMap.get(this),"KillAgent",new String[] {""});
    }
}
