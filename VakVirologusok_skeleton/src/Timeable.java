/**
* Leírás: Azok az osztályok tudják megvalósítani, amikre hatással van az idő múlása.
*
*/
public interface Timeable
{
    Timer timeable = null;
    
    /**
    * Leírás: Az idő folyamatos múlását folytatja.
    *
    */
    void Time();
}
