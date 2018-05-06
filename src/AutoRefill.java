public class AutoRefill extends Amenities {
    private static final double COST = 5;
    private Room room;

    public AutoRefill(Room room){ this.room = room; }

    @Override
    public String getRoomType() {
        return room.getRoomType() + "[AUTOREFILL]";
    }

    @Override
    public double cost() {
        return COST + room.cost();
    }
}

