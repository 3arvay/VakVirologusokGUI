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
     * @param type 0: stun, 1: dance, 2:immunity, 3:amnesia
     */
    public Laboratory(int type) {
        geneticCode = new Agent[] {new Stun(), new Dance(), new Immunity(), new Amnesia()} [type];
        infecting = new Random().nextBoolean();
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
        v.SetF1(this);
        v.ReceiveGeneticCode(this.geneticCode);
        if(this.infecting)
        {
            BearVirus bv = new BearVirus();
            v.SpecialAttack(bv);
        }
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
