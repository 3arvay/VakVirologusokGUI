import java.util.Map;
import java.util.Random;

/**
* Leírás: Megvalósítja a laboratórium mezőt. Számon tartja a laboratórium falára felkarcolt genetikai kódot.
*
*/
public class Laboratory extends Field
{
    private Agent geneticCode;
    private boolean infecting;

    public Laboratory() {
        geneticCode = new Agent[] {new Stun(), new Dance(), new Immunity(), new Amnesia()} [new Random().nextInt(4)];
        infecting = new Random().nextBoolean();
    }

    /**
    * Leírás: Virológus lépését valósítja meg a labor mezőre, és ha még számára ismeretlen az ott található genetikai kód, akkor megtanulja.
    *
    * @param value: Az a virológus aki rálép erre a raktár mezőre
    */

    public void setter(String value){
        infecting=value.equals("true");
    }
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
