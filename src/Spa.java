public class Spa extends Amenities {
    private static final double COST = 20;
    private Room room;

    public Spa(Room room){
        this.setRoomType(room.getRoomType());
        this.room = room;
    }

    @Override
    public String getRoomDescription() {
        return room.getRoomDescription() + " [SPA]";
    }

    @Override
    public double cost() {
        return COST + room.cost();
    }
}
