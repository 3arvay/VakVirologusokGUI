import java.util.Map;

/**
* Leírás: Megvalósítja a laboratórium mezőt. Számon tartja a laboratórium falára felkarcolt genetikai kódot.
*
*/
public class Laboratory extends Field
{
    private Agent geneticCode;
    private boolean infecting;

    public Laboratory(boolean infecting_, Agent geneticCode_) {
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
        standsHere.add(v);
        v.ReceiveGeneticCode(this.geneticCode);
        if(this.infecting)
        {
            BearVirus bv = new BearVirus();
            v.SpecialAttack(bv);
        }
    }

    public void listAttributes(Map<String, Object> _varMap) {
        for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
            if (entry.getValue().equals(this)) {
                System.out.println(entry.getKey()+":");
                break;
            }
        }
        int i = 1;
        while (i <= Neighbours.size()) {
            for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
                if (entry.getValue().equals(Neighbours.get(i-1))) {
                    System.out.println("neighbour" + i++ + ":" + entry.getKey());
                    break;
                }
            }
        }
        i = 1;
        while (i <= standsHere.size()) {
            for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
                if (entry.getValue().equals(standsHere.get(i-1))) {
                    System.out.println("virologist" +i++ + ":" + entry.getKey());
                    break;
                }
            }
        }


        System.out.println( "infecting:"+infecting);

        String geneticCode_temp = null;
        for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
            if (entry.getValue().equals(geneticCode)) {
                geneticCode_temp=entry.getKey();
                break;
            }
        }
        System.out.println("geneticCode" +i++ + ":"+geneticCode_temp);

    }

    // ToDo init konstuktor, random lab


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
