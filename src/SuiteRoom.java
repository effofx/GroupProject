
public class SuiteRoom extends Room{
    private static final double COST = 100; // $100 per night

    public SuiteRoom(){
        setRoomType("Suite Room");
    }

    @Override
    public double cost() {
        return COST;
    }
}
