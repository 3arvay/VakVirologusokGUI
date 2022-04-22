public class BearMode extends VAttribute
{
    BearMode() {
        Main.nameMap.put(this, "bm");
        Main.printSeq(3,"call", Main.nameMap.get(this), this.getClass().getSimpleName(), new String[]{""});
        Main.printSeq(3,"answer", Main.nameMap.get(this), this.getClass().getSimpleName(), new String[]{""});
    }
}
