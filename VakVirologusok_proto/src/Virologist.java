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
                add(null);
            }
        };
        attributeList=new ArrayList<VAttribute>();
        agentList = new ArrayList<Agent>();
        f1=null;
    }

    public void SetF1 (Field f) {
        f1 = f;
    }

    public void setter(String type, String value){
        if(type.equals("amountNucleotid")){
            amountNucleotid=Integer.parseInt(value);
        }
        else if(type.equals("amountAminoacid")){
            amountAminoacid=Integer.parseInt(value);
        }
        else if(type.equals("maxAmount")){
            maxAmount=Integer.parseInt(value);
        }
        else{
            System.out.println("Hibás paramétert adtál meg");
        }
    }

    public void listAttributes(Map<String, Object> _varMap) {
        for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
            if (entry.getValue().equals(this)) {
                System.out.println(entry.getKey() + ":");
                break;
            }
        }
        System.out.println( "amountNucleotid:"+amountNucleotid+"\r\n"+
                            "amountAminoacid:"+amountAminoacid+"\r\n"+
                            "maxAmount:"+maxAmount);
        String field_temp = "null";
        for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
            if (entry.getValue().equals(f1)) {
                field_temp=entry.getKey();
                break;
            }
        }
        System.out.println("myField:"+field_temp);

        int i = 1;
        while (i <= geneticCodeList.size()) {
            for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
                if (entry.getValue().equals(geneticCodeList.get(i-1))) {
                    System.out.println("geneticCode" + i++ + ":" + entry.getKey());
                    break;
                }
            }
        }

        i = 1;
        while (i <= agentList.size()) {
            for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
                if (entry.getValue().equals(agentList.get(i-1))) {
                    System.out.println("agent" + i++ + ":" + entry.getKey());
                    break;
                }
            }
        }
        i = 1;
        int j=1;
        while (i <= gearList.size()) {
            for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
                if (!(gearList.get(i-1)==null)&& entry.getValue().equals(gearList.get(i-1))) {
                    System.out.println("gear" + j++ + ":" + entry.getKey());
                    break;
                }
            }
            i++;
        }
        i = 1;
        j=1;
        while (i <= attributeList.size()) {
            for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
                if (entry.getValue().equals(attributeList.get(i-1))) {
                    System.out.println("vattribute" + j++ + ":" + entry.getKey());
                    break;
                }
            }
            i++;
        }
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
            String temp = "-";
            for(Virologist v :  attackThese){
                if(!v.equals(this)){
                    for (Map.Entry<String, Object> entry : Main.varMap.entrySet()) {
                        if (entry.getValue().equals(this)) {
                            temp = "bv"+entry.getKey().substring(1);
                        }
                    }
                    if(!Main.varMap.containsValue(bv)) {
                        Main.varMap.put(temp, bv);
                    }
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
        if (/*!attributeList.stream().anyMatch(x->x instanceof Dancing) && */!attributeList.stream().anyMatch(x->x instanceof Stunned))
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
            String Name = "";
            for (Map.Entry<String, Object> entry : Main.varMap.entrySet()) {
                if (entry.getValue().equals(a)) {
                    Name  = entry.getKey().substring(0,entry.getKey().length()-2)+"_"+
                            (Character.getNumericValue(entry.getKey().charAt(entry.getKey().length()-1))+1);
                    /*char temp = entry.getKey().charAt(0);
                    switch (temp) {
                        case 's':
                            Name  = entry.getKey().substring(0,entry.getKey().length()-2)+
                                    (Character.getNumericValue(entry.getKey().charAt(entry.getKey().length()-1))+1);
                            break;
                        case 'd':
                            Name  = temp+entry.getKey().substring(1);
                            break;
                        case 'i':
                            Name  = temp+entry.getKey().substring(1);
                            break;
                        default:
                            Name  = temp+entry.getKey().substring(1);
                            break;
                    }*/
                }
            }
            Main.varMap.put(Name, asd);
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
            Gear g = this.StealGear(v2);
            if (g!=null)
            {
                gearList.add(g);
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
        if (v.attributeList.stream().anyMatch(x -> x instanceof Stunned))
        {
            for(Gear g : v.gearList)
            {
                if (g != null)
                {
                    return g.StealAway(this, v);
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
        if (gear.GetID()==2)
        {
            gear.Use(this,null);
        }
        return gearList.remove(gear.GetID());
    }

    /**
     * Leírás:
     * Eldobja a virológus a felszerelését ha elhasználódott
     * @param gear
     */
    public void ThrowGear(Gear gear)
    {
        this.gearList.remove(gear);
    }

    /**
     * Leírás:
     * Leveszi a virológust a játékból, meghalás esetén
     */
    public void YourKilled()
    {
        this.f1.VirologistKilled(this);
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
            if (gearList.stream().anyMatch(x -> x instanceof Gloves) && this.gearList.get(0).Use(v, a)) {
                return;
            }
            if (gearList.stream().anyMatch(x -> x instanceof Cloak) && this.gearList.get(1).Use(this, a)) {
                return;
            }
            if (a instanceof BearVirus && gearList.stream().anyMatch(x -> x instanceof Axe) && gearList.get(3).Use(v, a)) {
                return;
            }
            VAttribute asd = a.AllotAttribute(a);
            String VAname = "";
            for (Map.Entry<String, Object> entry : Main.varMap.entrySet()) {
                if (entry.getValue().equals(a)) {
                    char temp = entry.getKey().charAt(0);
                    switch (temp) {
                        case 's':
                            VAname  = temp+"t"+entry.getKey().substring(1);
                            break;
                        case 'd':
                            VAname  = temp+"i"+entry.getKey().substring(1);
                            break;
                        case 'i':
                            VAname  = temp+"m"+entry.getKey().substring(1);
                            break;
                        default:
                            VAname  = temp+"m"+entry.getKey().substring(2);
                            break;
                    }
                }
            }
            if (asd != null) {
                if(!Main.varMap.containsKey(VAname)) {
                    Main.varMap.put(VAname, asd);
                }
                else{
                    int lastIndex=Character.getNumericValue(VAname.charAt(VAname.length()-1))+1;
                    VAname=VAname.substring(0,VAname.length()-1)+lastIndex;
                    Main.varMap.put(VAname,asd);
                }
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
            gearList.add(gear.GetID(),gear.PickUp(this));
        }
    }

    public void ReceiveAgent(Agent agent)
    {
        if(!HasThisAgent(agent))
        {
            agentList.add(agent);
        }
    }
    public void ReceiveAttribute(VAttribute attribute){
        if(!attributeList.contains(attribute)){
            //attributeList.add(attribute);
        }
        attributeList.add(attribute);
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
        String VAname = "";
        for (Map.Entry<String, Object> entry : Main.varMap.entrySet()) {
            if (entry.getValue().equals(a)) {
                char temp = entry.getKey().charAt(0);
                switch (temp) {
                    case 's':
                        VAname  = temp+"t"+entry.getKey().substring(1);
                        break;
                    case 'd':
                        VAname  = temp+"i"+entry.getKey().substring(1);
                        break;
                    case 'i':
                        VAname  = temp+"m"+entry.getKey().substring(1);
                        break;
                    default:
                        VAname  = temp+"m"+entry.getKey().substring(2);
                        break;
                }
            }
        }
        Main.varMap.put(VAname, asd);
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

    /**
     * Leírás:
     * Visszaadja a virológus felszerelését
     * @param id
     * @return gear
     */
    public Gear GetGear(int id)
    {
        return this.gearList.get(id);
    }

    public void RemoveAgent(Agent a) {
        agentList.remove(a);
    }

    @Override
    public void Time() {
        for(Agent a : agentList) {
            a.Step(this);
        }
        for(VAttribute va : attributeList) {
            va.Step(this);
        }
    }
}
