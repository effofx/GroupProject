/**
 May 8, 2018
 Purpose: A concrete Room class
 Input: none
 Output: none
 **/

public class SuiteRoom extends Room{
    private static final double COST = 100; // $100 per night

    public SuiteRoom(){
        setRoomType("Suite");
    }

    @Override
    public double cost() {
        return COST;
    }
}
