/**
 * Leírás:
 * Az ágens egyik hatását valósítja meg.
 * A virológus ennek hatása alá kerül akkor véletlenül mozog és minden útjába kerülő virológust megken BearVirus-al.
 */
public class BearMode extends VAttribute {
    /**
     * Leírás:
     * BearMode attribútum konstruktora
     */
    BearMode() {
        durationtime = -1;
    }

    /**
     * Leírás: Lefuttatja a destruktort és visszavonja a hozzátartozó hatást.
     *
     */
    @Override
    public void AttributeChanges(Virologist v) {}

}