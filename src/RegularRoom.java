/**
 May 8, 2018
 Purpose: A concrete Room class
 Input: none
 Output: none
 **/

public class RegularRoom extends Room{
    private static final double COST = 50; // $50 per night

    public RegularRoom(){
        setRoomType("Regular");
    }

    @Override
    public double cost() {
        return COST;
    }

}

