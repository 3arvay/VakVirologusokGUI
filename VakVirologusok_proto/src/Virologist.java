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
    private List<Gear> gearList;
    private List<VAttribute> attributeList;
    private Field f1;

    /**
    * Leírás:
    * Virológus konstruktora
    */
    public Virologist(){
        amountNucleotid=0;
        amountAminoacid=0;
        maxAmount=100;
        geneticCodeList=new ArrayList<Agent>();
        gearList=new ArrayList<Gear>()
        {
            {
                add(null);
                add(null);
                add(null);
            }
        };
        attributeList=new ArrayList<VAttribute>();
        agentList = new ArrayList<Agent>();
        f1=null;
    }
    private void find(Object a, Map<String, Object> _varMap){
        for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
            if (entry.getValue().equals(a)) {
                System.out.println(entry.getKey() + ":");
                break;
            }
        }
    }
    //stathoz kell
    public void listAttributes(Map<String, Object> _varMap) {
        for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
            if (entry.getValue().equals(this)) {
                System.out.println(entry.getKey() + ":");
                break;
            }
        }
        System.out.println( "amountNucleotid:"+amountNucleotid+"\n"+
                            "amountAminoacid:"+amountAminoacid+"\n"+
                            "maxAmount:"+maxAmount);

        int i = 0;
        while (i < geneticCodeList.size()) {
            for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
                if (entry.getValue().equals(geneticCodeList.get(i))) {
                    System.out.println("virologist" + Integer.toString(i + 1) + ":" + entry.getKey());
                    i++;
                    break;
                }
            }
        }
    }
    /**
    * Leírás:
    * Ez jelzi az idő múlását a virológus számára.
    */
    public void Time()
    {
        Main.printSeq(0,"call",Main.nameMap.get(this),"Time",new String[] {""});
        for (Agent a: agentList){
            if(a.GetUseTime()<1){
                a.KillAgent(this);
                Main.printSeq(0,"answer",Main.nameMap.get(this),"Time",new String[] {""});
            }
        }
    }

    /**
    * Leírás:
    * A felhasználó mozgásműveletét valósítja meg egy szomszédos mezőre.
    * @param  f2
    */
    public void Move(Field f2)
    {   if (!attributeList.stream().anyMatch(x->x instanceof Dancing) & !attributeList.stream().anyMatch(x->x instanceof Stunned))
        {
            Main.printSeq(0, "call", Main.nameMap.get(this), "Move", new String[]{Main.nameMap.get(f2)});
            this.f1.RemoveVirologist(this);
            f2.AddVirologist(this);
            Main.printSeq(0, "answer", Main.nameMap.get(this), "Move", new String[]{Main.nameMap.get(f2)});
        }
        else if(attributeList.stream().anyMatch(x->x instanceof Dancing))
        {
            Main.printSeq(0, "call", Main.nameMap.get(this), "Move", new String[]{Main.nameMap.get(f2)});
            this.f1.RemoveVirologist(this);
            Field f3 = f2.GetRandomNeighbour(f1);
            f3.AddVirologist(this);
            Main.printSeq(0, "call", Main.nameMap.get(this), "Move", new String[]{Main.nameMap.get(f2)});
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
        Main.printSeq(0,"call",Main.nameMap.get(this),"CraftAgent",new String[] {Main.nameMap.get(v),Main.nameMap.get(a)});
        if((v.amountAminoacid - a.GetAminoacidCost()>=0))
        {
            v.agentList.add(a.Clone(v,a));
        }
        Main.printSeq(0,"answer",Main.nameMap.get(this),"CraftAgent",new String[] {""});

    }

/**
* Leírás:
* A virológus ágenst ken egy másik virológusra.
* @param  a
* @param  v
*/
    public void UseAgent(Agent a, Virologist v)
    {
        Main.printSeq(0,"call", Main.nameMap.get(this), "UseAgent", new String[]{Main.nameMap.get(a), Main.nameMap.get(v)});
        v.UnderAttack(a, this);
        Main.printSeq(0,"answer", Main.nameMap.get(this), "UseAgent", new String[]{""});
    }

/**
* Leírás:
* Másik virológustól lop, miközben az le van bénítva.
* @param  v2
* @param  opt
*/
    public void Steal(Virologist v2, String opt)
    {
        Main.printSeq(0, "call", Main.nameMap.get(this), "Steal", new String[]{Main.nameMap.get(v2), "opt"});
        if (opt.equals("Gear"))
        {
            Gear g = v2.StealGear(this);
            if (g!=null)
            {
                gearList.add(g);
            }

        }
        else if (opt.equals("Material"))
        {
            StealMaterial(v2);
        }
        Main.printSeq(0, "answer", Main.nameMap.get(this), "Steal", new String[]{""});
    }

/**
* Leírás:
* Alapanyagot lop egy lebénult virológustól.
* @param  v
*/
    public void StealMaterial(Virologist v)
    {
        Main.printSeq(1, "call", Main.nameMap.get(v), "StealMaterial", new String[]{Main.nameMap.get(this)});
        int tempAmino=v.GetAmountAminoacid();
        int tempNucleo=v.GetAmountNucleotid();
        v.SetAmountAminoacid(Math.min(v.GetMaxAmount(),amountAminoacid+v.GetAmountAminoacid()));
        v.SetAmountNucleotid(Math.min(v.GetMaxAmount(),amountNucleotid+v.GetAmountNucleotid()));
        SetAmountAminoacid(amountAminoacid-(v.GetAmountAminoacid()-tempAmino));
        SetAmountNucleotid(amountNucleotid-(v.GetAmountNucleotid()-tempNucleo));
        Main.printSeq(1, "answer", Main.nameMap.get(v), "StealMaterial", new String[]{""});

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
            Main.printSeq(1, "call", Main.nameMap.get(this), "StealGear", new String[]{Main.nameMap.get(this)});
            for(Gear g : gearList)
            {
                if (g != null)
                {
                    Main.printSeq(2, "call", Main.nameMap.get(g), "StealAway", new String[]{Main.nameMap.get(this)});
                    Gear temp = g.StealAway(v,this);
                    Main.printSeq(2, "answer", Main.nameMap.get(g), "StealAway", new String[]{""});
                    //v.gearList.add(temp.GetID(), temp);
                    Main.printSeq(1, "answer", Main.nameMap.get(this), "StealGear", new String[]{""});
                    return temp;
                }
            }
            Main.printSeq(1, "answer", Main.nameMap.get(this), "StealGear", new String[]{""});
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
        Main.printSeq(3, "call", Main.nameMap.get(this), "RemoveGear", new String[]{Main.nameMap.get(gear)});
        Main.printSeq(3, "answer", Main.nameMap.get(this), "RemoveGear", new String[]{""});
        if (gear.GetID()==2)
        {
            Main.printSeq(3, "call", Main.nameMap.get(this), "LowerCapacity", new String[]{"bSize"});
            gear.Use(this,null);
            Main.printSeq(3, "answer", Main.nameMap.get(this), "LowerCapacity", new String[]{""});
        }
        return gearList.remove(gear.GetID());
    }

/**
* Leírás:
*  Egy ágenst kenését valósítja meg egy másik virológusra.
* @param  a
* @param  v
*/
    public void UnderAttack(Agent a, Virologist v)
    {
        Main.printSeq(1,"call", Main.nameMap.get(this), "UnderAttack", new String[]{Main.nameMap.get(a), Main.nameMap.get(v)});
        if(!gearList.isEmpty()) {
            if(gearList.get(0) != null) {
                gearList.get(0).Use(v,a);
                Main.printSeq(1,"answer", Main.nameMap.get(this), "UnderAttack", new String[]{""});
                return;
            } else if (gearList.get(1) != null) {
                if(gearList.get(1).Use(v,a)) {
                    Main.printSeq(1,"answer", Main.nameMap.get(this), "UnderAttack", new String[]{""});
                    return;
                }
            }
        }
        if(!attributeList.isEmpty()) {
            if(attributeList.stream().anyMatch(x->x instanceof Immune)){
                Main.printSeq(1,"answer", Main.nameMap.get(this), "UnderAttack", new String[]{""});
                return;
            }
        }
        else {
            attributeList.add(a.AllotAttribute(a) );
        }

        Main.printSeq(1,"answer", Main.nameMap.get(this), "UnderAttack", new String[]{""});
    }

/**
* Leírás:
* Átadja a virológusnak a letapogatott genetikai kódot.
* @param  geneticCode
*/
    public void ReceiveGeneticCode(Agent geneticCode)
    {
        Main.printSeq(1,"call", Main.nameMap.get(this), "ReceiveGeneticCode", new String[]{Main.nameMap.get(geneticCode)});
        if(!HasThisAgent(geneticCode))
            LearnGeneticCode(geneticCode);
        Main.printSeq(1,"answer", Main.nameMap.get(this), "ReceiveGeneticCode", new String[]{Main.nameMap.get(geneticCode)});
    }

/**
* Leírás:
* Átadja a virológusnak a felvenni kívánt felszerelést.
* @param  gear
*/
    public void ReceiveGear(Gear gear)
    {
        Main.printSeq(2,"call", Main.nameMap.get(this), "RecieveGear", new String[]{Main.nameMap.get(gear)});
        if(!HasThisGear(gear))
        {
            gearList.add(gear.GetID(),gear.PickUp(this));

        }
        Main.printSeq(2,"answer", Main.nameMap.get(this), "RecieveGear", new String[]{Main.nameMap.get(gear)});
    }

/**
* Leírás:
* Átadja a virológusnak az adott mezőről felszedett alapanyagot.
* @param  material
* @param  amount
*/
    public void MaterialPickedUp(String material, int amount)
    {
        Main.printSeq(2,"call", Main.nameMap.get(this), "MaterialPickedUp", new String[]{"material","amount"});
        if (material.equals("aminosav")){
            amountAminoacid= Math.min(amountAminoacid + amount, maxAmount);
        }
        else if(material.equals("nukleotid")) this.amountNucleotid = Math.min(amountNucleotid + amount, maxAmount);
        Main.printSeq(2,"answer", Main.nameMap.get(this), "MaterialPickedUp", new String[]{"material","amount"});
    }

/**
* Leírás:
* A visszakenés műveletét valósítja meg, azaz a rákent ágenst visszakeni a kenőjére.
* @param  a
*/
    public void GloveAttack(Agent a)
    {
        Main.printSeq(3,"call", Main.nameMap.get(this), "GloveAttack", new String[]{Main.nameMap.get(a)});
        attributeList.add(a.AllotAttribute(a));
        Main.printSeq(3,"answer", Main.nameMap.get(this), "GloveAttack", new String[]{""});
    }

/**
* Leírás:
* Megtanulja a virológus paraméterül kapott genetikai kódot.
* @param  geneticCode
*/
    public void LearnGeneticCode(Agent geneticCode)
    {
        Main.printSeq(2,"call", Main.nameMap.get(this), "LearnGeneticCode", new String[]{Main.nameMap.get(geneticCode)});
        geneticCodeList.add(geneticCode);
        Main.printSeq(2,"answer", Main.nameMap.get(this), "LearnGeneticCode", new String[]{Main.nameMap.get(geneticCode)});
    }

/**
* Leírás:
* Levonja az ágens előállításához szükséges nyersanyagok számát a virológustól, ha az rendelkezésre áll.
* @param  v
* @param  a
*/
    public void CostTakeAway(Virologist v,Agent a)
    {
        Main.printSeq(2,"call",Main.nameMap.get(this),"CostTakeAway",new String[] {Main.nameMap.get(v),Main.nameMap.get(a)});
        v.amountNucleotid -= a.GetNucleotidCost();
        v.amountAminoacid -= a.GetAminoacidCost();
        Main.printSeq(2,"answer",Main.nameMap.get(this),"CostTakeAway",new String[] {""});
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
        for (Gear gear: gearList)
        {
            if (gear!= null)
            {
                if(gear.GetID()==g.GetID())
                {
                    return true;
                }
            }
        }
        return false;
    }

/**
* Leírás:
* Ha egy adott ágens felhasználhatóságának ideje lejár, ez a metódus távolítja el azt a virológus megfelelő listájából.
* @param  v
*/
    public void RemoveAttribute(Virologist v)
    {

    }

/**
* Leírás:
* Megnöveli a virológust nyersanyag kapacitását.
* @param  bSize
*/
    public void ExtendCapacity(int bSize)
    {
        Main.printSeq(5,"call", Main.nameMap.get(this), "ExtendCapacity", new String[]{"bSize"});
        this.maxAmount+=bSize;
        Main.printSeq(5,"answer", Main.nameMap.get(this), "ExtendCapacity", new String[]{"bSize"});
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
        Main.printSeq(0,"call",Main.nameMap.get(this),"SetInitialField",new String[]{Main.nameMap.get(f1)});
        f1.AddVirologist(this);
        Main.printSeq(0,"answer",Main.nameMap.get(this),"SetInitialField",new String[]{Main.nameMap.get(f1)});
    }
}
