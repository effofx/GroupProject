public class AutoRefill extends Amenities {
    private static final double COST = 5;
    private Room room;

    public AutoRefill(Room room){
        this.setRoomType(room.getRoomType());
        this.room = room;
    }

    @Override
    public String getRoomDescription() {
        return room.getRoomDescription() + " [AUTO-REFILL]";
    }

    @Override
    public double cost() {
        return COST + room.cost();
    }
}

