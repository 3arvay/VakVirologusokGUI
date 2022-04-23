public class Axe extends Gear
{
    private int durability;

    public Axe()
    {
        durability = 1;
        this.id = 3;
    }

    @Override
    public Boolean Use(Virologist v, Agent a)
    {
        if (this.durability > 0)
        {
            this.durability--;
            v.YourKilled();
        }
        return null;
    }

    @Override
    public Gear PickUp(Virologist v)
    {
        return null;
    }

    @Override
    public Gear StealAway(Virologist v, Virologist v2)
    {
        return null;
    }
}
