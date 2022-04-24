import java.util.Random;

import java.util.List;

import java.util.Map;

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
    * @param amount_: Megadja mennyi darab anyag található ezen a mezőn
    * @param material_: Megadja milyen fajta angya található a mezőn
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

    @Override
    public List<Virologist> AddBear(Virologist v)
    {
        SetAmount();
        AddVirologist(v);
        return standsHere;
    }

    /**
    * Leírás: A Virológus lépését valósítja meg a raktármezőre, és automatikusan odaadja a felvehető mennyiségű anyagot a paraméterül kapott virológusnak.
    *
    * @param v: Az a virológus aki rálép erre a raktár mezőre
    */
    @Override
    public void AddVirologist(Virologist v)
    {
        standsHere.add(v);
        v.MaterialPickedUp(material,amount);
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

    public void SetAmount()
    {
        amount = 0;
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


        System.out.println( "amount:"+amount+"\n"+
                "material:"+material);

    }

}
