/**
 * Leírás:
 * Az ágens egyik hatását valósítja meg.
 * A virológus ennek hatása alá kerül akkor véletlenül mozog és minden útjába kerülő virológust megken BearVirus-al.
 */
public class BearMode extends VAttribute
{
    /**
     * Leírás:
     * BearMode ágens konstruktora
     */
    BearMode() {
        Main.nameMap.put(this, "bm");
        Main.printSeq(3,"call", Main.nameMap.get(this), this.getClass().getSimpleName(), new String[]{""});
        Main.printSeq(3,"answer", Main.nameMap.get(this), this.getClass().getSimpleName(), new String[]{""});
    }
}
