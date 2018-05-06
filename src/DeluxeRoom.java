
public class DeluxeRoom extends Room{
    private static final double COST = 75; // $75 per night

    public DeluxeRoom(){
        setRoomType("Deluxe Room");
    }

    @Override
    public double cost() {
        return COST;
    }
}

