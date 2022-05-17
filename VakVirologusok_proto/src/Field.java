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
        standsHere = new ArrayList<>();
        Neighbours = new ArrayList<>();
    }

    /**
    * Leírás:
    * Adott mezőhöz szomszédos mezőket rendel hozzá.
    * @param f jövendő szomszéd
    */
    public void AddNeighbour(Field f)
    {
        Neighbours.add(f);
    }

    /**
    * Leírás:
    * Már létező mezőhöz ad hozzá egy virológust. Ez a függvény hívódik ha a játékos lépteti a virológust.
    * @param v ide lépő virologist
    */
    public void AddVirologist(Virologist v)
    {
        standsHere.add(v);
        v.SetF1(this);
    }

    /**
     * Leírás:
     * Már létező mezőhöz ad hozzá egy medve virológust. Ez a függvény hívódik ha a játékos lépteti a medve ágens hatása alatt levő virológust.
     * @param v ide lépő virologist
     */
    public List<Virologist> AddBear(Virologist v)
    {
        AddVirologist(v);
        return standsHere;
    }

    /**
    * Leírás:
    * Eltávolítja a virológust a mezőről, ha a játékos átlépett egy másik mezőre.
    * @param v el lépő virologist
    */
    public void RemoveVirologist(Virologist v)
    {
        standsHere.remove(v);
    }

    /**
    * Leírás:
    * Vissza ad egy szomszédos mezőt ami nem a paraméterben levő mező.
    * @param f1 nem ezt a mezőt várjuk vissza!
    * @return Field temp
    */
    public Field GetRandomNeighbour(Field f1) {
        for(Field f : Neighbours) {
            if(!f.equals(f1) && !f.equals(this)) {
                return f;
            }
        }
        return f1;
    }

    /**
     *
     * @param v1 RIP
     */
    public void VirologistKilled(Virologist v1)
    {
        standsHere.remove(v1);
    }
}
