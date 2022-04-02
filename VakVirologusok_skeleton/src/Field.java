import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    /**
    * Leírás:
    * Adott mezőhöz szomszédos mezőket rendel hozzá.
    * @param Field f
    */
    public void AddNeighbour(Field f)
    {
        Main.printSeq(0,"call", Main.nameMap.get(this), "AddNeighbour", new String[]{Main.nameMap.get(f)});
        Neighbours.add(f);
        Main.printSeq(0,"answer", Main.nameMap.get(this), "AddNeighbour", new String[]{Main.nameMap.get(f)});
    }

    /**
    * Leírás:
    * Már létező mezőhöz ad hozzá egy virológust. Ez a függvény hívódik ha a játékos lépteti a virológust.
    * @param Virologist v
    */
    public void AddVirologist(Virologist v)
    {
        Main.printSeq(1,"call", Main.nameMap.get(this), "AddVirologist", new String[]{Main.nameMap.get(v)});
        standsHere.add(v);
        Main.printSeq(1,"answer", Main.nameMap.get(this), "AddVirologist", new String[]{Main.nameMap.get(v)});
    }

    /**
    * Leírás:
    * Eltávolítja a virológust a mezőről, ha a játékos átlépett egy másik mezőre.
    * @param Virologist v
    */
    public void RemoveVirologist(Virologist v)
    {
        Main.printSeq(1,"call", Main.nameMap.get(this), "RemoveVirologist", new String[]{Main.nameMap.get(v)});
        standsHere.remove(v);
        Main.printSeq(1,"answer", Main.nameMap.get(this), "RemoveVirologist", new String[]{Main.nameMap.get(v)});
    }

    /**
    * Leírás:
    * Vissza ad egy szomszédos mezőt ami nem a paraméterben levő mező.
    * @param Field f1
    * @return Field temp
    */
    public Field GetRandomNeighbour(Field f1){
        Main.printSeq(1,"call", Main.nameMap.get(this), "GetRandomNeighbour", new String[]{Main.nameMap.get(f1)});

        Random rand = new Random();
        Field temp=Neighbours.get(rand.nextInt(Neighbours.size()));
        while (temp!=f1 & temp!=this)
        {
            temp=Neighbours.get(rand.nextInt(Neighbours.size()));
        }
        Main.printSeq(1,"answer", Main.nameMap.get(this), "GetRandomNeighbour", new String[]{""});
        return temp;
    }

    /**
    * Leírás:
    * A vitus táncos mozgást valósítja meg.
    * @param Field f2
    */
    public void GetMeSomewhere(Field f2)
    {

    }
}
