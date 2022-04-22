/**
* Leírás: Megvalósítja a laboratórium mezőt. Számon tartja a laboratórium falára felkarcolt genetikai kódot.
*
*/
public class Laboratory extends Field
{
    private Agent geneticCode;
    private boolean infecting;



    public Laboratory(boolean infecting_, Agent geneticCode_){
        infecting = infecting_;
        geneticCode = geneticCode_;
    }

    /**
    * Leírás: Virológus lépését valósítja meg a labor mezőre, és ha még számára ismeretlen az ott található genetikai kód, akkor megtanulja.
    *
    * @param v: Az a virológus aki rálép erre a raktár mezőre
    */
    @Override
    public void AddVirologist(Virologist v)
    {
        Main.printSeq(1,"call", Main.nameMap.get(this), "AddVirologist", new String[]{Main.nameMap.get(v)});
        standsHere.add(v);
        v.ReceiveGeneticCode(this.geneticCode);
        if(this.infecting)
        {
            BearVirus bv = new BearVirus();
            v.UnderAttack(bv);
        }
        Main.printSeq(1,"answer", Main.nameMap.get(this), "AddVirologist", new String[]{Main.nameMap.get(v)});
    }

    /**
    * Leírás:  Inicializáláskor egy adott genetikai kódot jelentő ágenst helyez el a laboratóriumban.
    *
    * @param a: Beállítja, hogy milyen ágenst lehet megtanulni abban a laborban
    */
    public void SetAgent(Agent a)
    {
        this.geneticCode = a;
    }
}
