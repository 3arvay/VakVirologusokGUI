/**
*    Az immunity ágens hatását valósítja meg. Ennek hatása alatt a virológus immunis lesz más virológusok támadásaira.
*   Immune → VAttribute
*/
public class Immune extends VAttribute
{
    /**
    * Leírás:
    *       Immune osztály konstruktora, létrehoz egy immunitás tulajdonságot
    * @return vattribute ,immune VAttribute létrehozása történik meg általa.
    */
    Immune() {
        Main.nameMap.put(this, "im");
        Main.printSeq(3,"call", Main.nameMap.get(this), this.getClass().getSimpleName(), new String[]{""});
        Main.printSeq(3,"answer", Main.nameMap.get(this), this.getClass().getSimpleName(), new String[]{""});
    }
}
