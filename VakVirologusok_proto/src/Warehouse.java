import java.util.Random;
import java.util.List;

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
    */

    public Warehouse(){
        amount=1000;
        material=new String[]{"nucleotid","aminoacid"}[new Random().nextInt(2)];
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
        v.SetF1(this);
        v.MaterialPickedUp(material,amount);
        if(material.equals("aminoacid")){
            amount=Math.max(amount-(v.GetMaxAmount()-v.GetAmountAminoacid()),0);
        }
        else{
            amount=Math.max(amount-(v.GetMaxAmount()-v.GetAmountNucleotid()),0);
        }
    }

    public void SetAmount()
    {
        amount = 0;
    }

}
