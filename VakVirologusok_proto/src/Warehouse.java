import java.util.Random;

/**
* Leírás: A raktár mező megvalósításáért felelős.
*
*/
public class Warehouse extends Field
{
    private int amount;
    private String material;
    
    /**
    * Leírás: A Warehouse konstruktora
    *
    */
    public Warehouse(){
        amount=new Random().nextInt(200);
        material=new String[]{"nukleotid","aminoacid"}[new Random().nextInt(2)];
    }

    public void setter(String type, String value){
        if(type.equals("amount")){
            amount=Integer.parseInt(value);
        }
        else if(type.equals("material")){
            material=value;
        }
        else{System.out.println("Hibás argumentumot adtál meg");}
    }

    /**
    * Leírás: A Virológus lépését valósítja meg a raktármezőre, és automatikusan odaadja a felvehető mennyiségű anyagot a paraméterül kapott virológusnak.
    *
    * @param v: Az a virológus aki rálép erre a raktár mezőre
    */
    @Override
    public void AddVirologist(Virologist v)
    {
        Main.printSeq(1,"call", Main.nameMap.get(this), "AddVirologist", new String[]{Main.nameMap.get(v)});
        standsHere.add(v);
        v.MaterialPickedUp(material,amount);
        Main.printSeq(1,"answer", Main.nameMap.get(this), "AddVirologist", new String[]{Main.nameMap.get(v)});
    }

    /**
    * Leírás: Visszadja az amount tagváltozó értékét.
    *
    * @return int amount: A raktár mezőn található anyag mennyiség
    */
    public int GetAmount()
    {
        return amount;
    }

}
