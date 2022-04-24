import java.util.Map;

/**
* Leírás: A raktár mező megvalósításáért felelős.
*
*/
public class Warehouse extends Field
{
    private int amount;
    private String material;
    

    public Warehouse(){
        amount=100;
        material="nucleotid";
    }
    

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
