import java.util.*;

/**
* Leírás:
* Megvalósítja az üres mezőt és ebből származik le a többi mező típus, amikre léphet egy virológus.
*/
public class Field
{
    protected List<Virologist> standsHere;
    protected List<Field> Neighbours;

    /**
    * Leírás:
    * A Field konstruktora
    */
    public Field()
    {
        standsHere = new ArrayList<Virologist>();
        Neighbours = new ArrayList<Field>();
    }

    public void listAttributes(Map<String, Object> _varMap) {
        for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
            if (entry.getValue().equals(this)) {
                System.out.println(entry.getKey()+":");
                break;
            }
        }
        int i = 1;
        while (i <= standsHere.size()) {
            for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
                if (entry.getValue().equals(standsHere.get(i-1))) {
                    System.out.println("virologist" +i++ + ":" + entry.getKey());
                    break;
                }
            }
        }
        i = 1;
        while (i <= Neighbours.size()) {
            for (Map.Entry<String, Object> entry : _varMap.entrySet()) {
                if (entry.getValue().equals(Neighbours.get(i-1))) {
                    System.out.println("neighbour" + i++ + ":" + entry.getKey());
                    break;
                }
            }
        }
    }

    /**
    * Leírás:
    * Adott mezőhöz szomszédos mezőket rendel hozzá.
    * @param f
    */
    public void AddNeighbour(Field f)
    {
        Neighbours.add(f);
    }

    /**
    * Leírás:
    * Már létező mezőhöz ad hozzá egy virológust. Ez a függvény hívódik ha a játékos lépteti a virológust.
    * @param v
    */
    public void AddVirologist(Virologist v)
    {
        standsHere.add(v);
    }

    /**
     * Leírás:
     * Már létező mezőhöz ad hozzá egy medve virológust. Ez a függvény hívódik ha a játékos lépteti a medve ágens hatása alatt levő virológust.
     * @param v
     */
    public List<Virologist> AddBear(Virologist v)
    {
        AddVirologist(v);
        return standsHere;
    }

    /**
    * Leírás:
    * Eltávolítja a virológust a mezőről, ha a játékos átlépett egy másik mezőre.
    * @param v
    */
    public void RemoveVirologist(Virologist v)
    {
        standsHere.remove(v);
    }

    /**
    * Leírás:
    * Vissza ad egy szomszédos mezőt ami nem a paraméterben levő mező.
    * @param f1
    * @return Field temp
    */
    public Field GetRandomNeighbour(Field f1) {

        Random rand = new Random();
        Field temp=Neighbours.get(rand.nextInt(Neighbours.size()));
        while (temp!=f1 & temp!=this)
        {
            temp=Neighbours.get(rand.nextInt(Neighbours.size()));
        }
        return temp;
    }

    public void VirologistKilled(Virologist v1)
    {
        standsHere.remove(v1);
    }
}
