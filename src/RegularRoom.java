public class RegularRoom extends Room{
    private static final double COST = 50; // $50 per night

    public RegularRoom(){
        setRoomType("Regular Room");
    }

    @Override
    public double cost() {
        return COST;
    }
}

