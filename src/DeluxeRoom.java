/**
 May 8, 2018
 Purpose: A concrete Room class
 Input: none
 Output: none
 **/

public class DeluxeRoom extends Room{
    private static final double COST = 75; // $75 per night

    public DeluxeRoom(){
        setRoomType("Deluxe");
    }

    @Override
    public double cost() {
        return COST;
    }
}

