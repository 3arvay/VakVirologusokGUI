/**
* Leírás: A vitustáncot kiváltó felkenhető ágenst valósítja meg
*/
public class Dance extends Agent
{
    /**
     * Leírás: Dance ágens konstruktora
     */
    Dance() {
        useTime = 8;
        nucleotidCost = 70;
        aminoacidCost =  40;
    }

    /**
    * Leírás: visszadja a useTime tagváltozó értékét
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
     * Leírás: Ágens hatásának kezdetét kiváltó metódus
     *
     * @param a: Ágens amivel támadnak
     * @return VAttribute: az ágens által kifejtett hatás
     */
    @Override
    public VAttribute AllotAttribute(Agent a)
    {
        Main.printSeq(2,"call", Main.nameMap.get(this), "AllotAttribute", new String[]{Main.nameMap.get(a)});
        Dancing temp = new Dancing();
        Main.printSeq(2,"answer", Main.nameMap.get(this), "AllotAttribute", new String[]{""});
        return temp;
    }

    /**
     * Leírás: Egy kenhető ágenst hoz létre a meglévő ágenst tudástárából.
     *
     * @param v: A kenhető ágenst tároló virológus
     * @param a: A klónozandó ágens
     * @return Agent: Az újonnan létrehozott ágens
     */
    @Override
    public Dance Clone(Virologist v, Agent a)
    {
        Main.printSeq(1,"call",Main.nameMap.get(this),"Clone",new String[] {Main.nameMap.get(v),Main.nameMap.get(a)});
        v.CostTakeAway(v,a);
        Dance temp = new Dance();
        Main.nameMap.put(temp, "d");
        Main.printSeq(1,"answer",Main.nameMap.get(this),"Clone",new String[] {""});
        return temp;
    }

    /**
     * Leírás: Az ágens hatása lejár
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
