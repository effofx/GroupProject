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

    /**
     * We wanted to use the parent Room class' toString() so we can actually just omit this method,
     * however it is provided as per assignment instructions.
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
