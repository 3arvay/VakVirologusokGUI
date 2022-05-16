import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
* Leírás:
* A játékos mozgásáért és a nála lévő felszerelések és ágensek számontartásáért felelős.
*/
public class Virologist implements Timeable
{
    private int amountNucleotid;
    private int amountAminoacid;
    private int maxAmount;
    private List<Agent> geneticCodeList;
    private List<Agent> agentList;
    private Gear[] gearList;
    private List<VAttribute> attributeList;
    private Field f1;

    /**
    * Leírás:
    * Virológus konstruktora
    */
    public Virologist(){
        amountNucleotid=75;
        amountAminoacid=75;
        maxAmount=100;
        geneticCodeList=new ArrayList<Agent>();
        gearList = new Gear[]{null, null, null, null};
        attributeList=new ArrayList<VAttribute>();
        agentList = new ArrayList<Agent>();
        f1=null;
    }

    public List<Agent> getAgentList(){return agentList;}
    public List<Agent> getGeneticCodeList(){return geneticCodeList;}
    public Gear[] getGearList(){return gearList;}
    public List<VAttribute> getAttributeList(){return attributeList;}

    public void SetF1 (Field f) {
        f1 = f;
    }

    /**
    * Leírás:
    * A felhasználó mozgásműveletét valósítja meg egy szomszédos mezőre.
    * @param  f2
    */
    public void Move(Field f2)
    {
        if(attributeList.stream().anyMatch(x->x instanceof BearMode))
        {
            this.f1.RemoveVirologist(this);
            Field f3 = f1.GetRandomNeighbour(f2);
            List<Virologist> attackThese = f3.AddBear(this);
            BearVirus bv = new BearVirus();
            for(Virologist v :  attackThese){
                if(!v.equals(this)){
                    v.UnderAttack(bv, this);
                }
            }
            return;
        }
        if(attributeList.stream().anyMatch(x->x instanceof Dancing))
        {
            this.f1.RemoveVirologist(this);
            Field f3 = f1.GetRandomNeighbour(f2);
            f3.AddVirologist(this);
            return;
        }
        if (!attributeList.stream().anyMatch(x->x instanceof Stunned))
        {
            f1.RemoveVirologist(this);
            f2.AddVirologist(this);
        }
    }

    /**
    * Leírás:
    * A felhasználó által kiválasztott ágenst készíti el, feltéve, hogy ismeri annak az ágensnek a genetikai kódját és van elég alapanyaga.
    * @param  v
    * @param  a
    */
    public void CraftAgent(Virologist v,Agent a)
    {
        if((v.amountAminoacid - a.GetAminoacidCost()>=0) && (v.amountNucleotid - a.GetNucleotidCost()>=0))
        {
            Agent asd = a.Clone(v,a);
            agentList.add(asd);
        }
    }

    /**
    * Leírás:
    * A virológus ágenst ken egy másik virológusra.
    * @param  a
    * @param  v
    */
    public void UseAgent(Agent a, Virologist v)
    {
        v.UnderAttack(a, this);
        this.agentList.remove(a);
    }

    /**
    * Leírás:
    * Másik virológustól lop, miközben az le van bénítva.
    * @param  v2
    * @param  opt
    */
    public void Steal(Virologist v2, String opt)
    {
        if (opt.equals("gear"))
        {
            Gear g = v2.StealGear(this);
            if (g != null)
            {
                gearList[g.GetID()] = g;
            }

        }
        else if (opt.equals("material"))
        {
            v2.StealMaterial(this);
        }
    }

    /**
    * Leírás:
    * Alapanyagot lop egy lebénult virológustól.
    * @param  v
    */
    public void StealMaterial(Virologist v)
    {
        int tempAmino=v.GetAmountAminoacid();
        int tempNucleo=v.GetAmountNucleotid();
        v.SetAmountAminoacid(Math.min(v.GetMaxAmount(),amountAminoacid+v.GetAmountAminoacid()));
        v.SetAmountNucleotid(Math.min(v.GetMaxAmount(),amountNucleotid+v.GetAmountNucleotid()));
        SetAmountAminoacid(amountAminoacid-(v.GetAmountAminoacid()-tempAmino));
        SetAmountNucleotid(amountNucleotid-(v.GetAmountNucleotid()-tempNucleo));
    }

    /**
    * Leírás:
    * Felszerelést lop egy lebénult virológustól.
    * @param  v
    */
    public Gear StealGear(Virologist v)
    {
        if (attributeList.stream().anyMatch(x -> x instanceof Stunned))
        {
            for(int i = 0; i < 4; i++) {
                if(gearList[i] != null) {
                    return gearList[i].StealAway(v, this);
                }
            }
        }
        return null;
    }

    /**
    * Leírás:
    * Kiveszi a felszerelést a virológus felszerelései közül.
    * @param  gear
    * @return Gear geartemp
    */
    public Gear RemoveGear(Gear gear)
    {
        Gear temp = gearList[gear.GetID()];
        gearList[gear.GetID()] = null;
        return temp;
    }

    /**
     * Leírás:
     * Eldobja a virológus a felszerelését ha elhasználódott
     * @param gear
     */
    public void ThrowGear(Gear gear)
    {
        gearList[gear.GetID()] = null;
    }

    /**
     * Leírás:
     * Leveszi a virológust a játékból, meghalás esetén
     */
    public void YourKilled()
    {
        this.f1.VirologistKilled(this);
        f1 = null;
    }

    /**
    * Leírás:
    *  Egy ágenst kenését valósítja meg egy másik virológusra.
    * @param  a
    * @param  v
    */
    public void UnderAttack(Agent a, Virologist v)
    {
        if(!(this.attributeList.stream().anyMatch(x->x instanceof Immune))) {
            if (gearList[0] != null && gearList[0].Use(v, a)) {
                return;
            }
            if (gearList[1] != null && gearList[1].Use(this, a)) {
                return;
            }
            if (a instanceof BearVirus && gearList[3] != null && gearList[3].Use(v, a)) {
                return;
            }
            VAttribute asd = a.AllotAttribute(a);

            if (asd != null) {
                this.attributeList.add(asd);
            } else {
                this.geneticCodeList.clear();
            }
        }
    }

    /**
    * Leírás:
    * Átadja a virológusnak a letapogatott genetikai kódot.
    * @param  geneticCode
    */
    public void ReceiveGeneticCode(Agent geneticCode)
    {
        if(!HasThisAgent(geneticCode))
            LearnGeneticCode(geneticCode);
    }

    /**
    * Leírás:
    * Átadja a virológusnak a felvenni kívánt felszerelést.
    * @param  gear
    */
    public void ReceiveGear(Gear gear)
    {
        if(!HasThisGear(gear))
        {
            int gearcount = 0;
            for(int i = 0; i < 4; i++) {
                if(gearList[i] != null) gearcount++;
            }
            if(gearcount < 3) {
                gearList[gear.GetID()] = gear.PickUp(this);
            }
        }
    }

    /**
    * Leírás:
    * Átadja a virológusnak az adott mezőről felszedett alapanyagot.
    * @param  material
    * @param  amount
    */
    public void MaterialPickedUp(String material, int amount)
    {
        if (material.equals("aminoacid")){
            amountAminoacid= Math.min(amountAminoacid + amount, maxAmount);
        }
        else if(material.equals("nucleotid"))
            amountNucleotid = Math.min(amountNucleotid + amount, maxAmount);
    }

    /**
    * Leírás:
    * A visszakenés műveletét valósítja meg, azaz a rákent ágenst visszakeni a kenőjére.
    * @param  a
    */
    public void SpecialAttack(Agent a)
    {
        VAttribute asd = a.AllotAttribute(a);
        attributeList.add(asd);
    }

    /**
    * Leírás:
    * Megtanulja a virológus paraméterül kapott genetikai kódot.
    * @param  geneticCode
    */
    public void LearnGeneticCode(Agent geneticCode)
    {
        geneticCodeList.add(geneticCode);
    }

    /**
    * Leírás:
    * Levonja az ágens előállításához szükséges nyersanyagok számát a virológustól, ha az rendelkezésre áll.
    * @param  v
    * @param  a
    */
    public void CostTakeAway(Virologist v,Agent a)
    {
        amountNucleotid -= a.GetNucleotidCost();
        amountAminoacid -= a.GetAminoacidCost();
    }

    /**
    * Leírás:
    * Megvizsgálja, hogy van-e az adott ágense.
    * @param  a
    * @return Boolean
    */
    public Boolean HasThisAgent(Agent a)
    {
        return geneticCodeList.contains(a);
    }

    /**
    * Leírás:
    * Megvizsgálja, hogy van-e az adott felszerelése.
    * @param  g
    * @return Boolean
    */
    public Boolean HasThisGear(Gear g)
    {
        return gearList[g.GetID()] != null;
    }

    /**
    * Leírás:
    * Ha egy adott ágens felhasználhatóságának ideje lejár, ez a metódus távolítja el azt a virológus megfelelő listájából.
    * @param  va
    */
    public void RemoveAttribute(VAttribute va)
    {
        this.attributeList.remove(va);
    }

    /**
    * Leírás:
    * Megnöveli a virológust nyersanyag kapacitását.
    * @param  bSize
    */
    public void ExtendCapacity(int bSize)
    {
        this.maxAmount+=bSize;
    }

    /**
    * Leírás:
    * Csökkenti a virológust nyersanyag kapacitását
    * @param  bSize
    */
    public void LowerCapacity(int bSize)
    {
        maxAmount-=bSize;
        amountNucleotid= Math.min(amountNucleotid, maxAmount);
        amountAminoacid= Math.min(amountAminoacid, maxAmount);
    }

    /**
    * Leírás:
    * visszadja a amountAminoacid tagváltozó értékét.
    * @return int amountAminoacid
    */
    public int GetAmountAminoacid()
    {
        return amountAminoacid;
    }

    /**
    * Leírás:
    * visszadja a amountNukleotid tagváltozó értékét.
    * @return int amountNucleotid
    */
    public int GetAmountNucleotid()
    {
        return amountNucleotid;
    }

    /**
    * Leírás:
    * Beállítja az aminoacid értékét.
    * @param  aa
    */
    public void SetAmountAminoacid(int aa)
    {
        amountAminoacid=aa;
    }

    /**
    * Leírás:
    * Beállítja nukleotid értékét
    * @param  an
    */
    public void SetAmountNucleotid(int an)
    {
        amountNucleotid=an;
    }

    /**
    * Leírás:
    * Visszadja a maxAmount tagváltozó értékét.
    * @return int maxAmount
    */
    public int GetMaxAmount()
    {
        return maxAmount;
    }

    /**
    * Leírás:
    * Beállítja azt a kezdő mezőt amin a Virológus áll.
    * @param  f1_
    */
    public void SetInitialField(Field f1_)
    {
        f1 = f1_;
        f1.AddVirologist(this);
    }

    public void RemoveAgent(Agent a) {
        agentList.remove(a);
    }

    @Override
    public void Time() {
        for(int i = 0; i < agentList.size(); i++) {
            agentList.get(i).Step(this);
        }
        for(int i = 0; i < attributeList.size(); i++) {
            attributeList.get(i).Step(this);
        }
    }

    public int GetNumOFGeneticCodes() {
        return geneticCodeList.size();
    }

    public Field GetMyField() {return f1;}

    public boolean Stunned() {
        return attributeList.stream().anyMatch(x -> x instanceof Stunned);
    }
}
