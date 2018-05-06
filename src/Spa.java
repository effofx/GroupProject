public class Spa extends Amenities {
    private static final double COST = 20;
    private Room room;

    public Spa(Room room){ this.room = room; }

    @Override
    public String getRoomType() {
        return room.getRoomType() + "[SPA]";
    }

    @Override
    public double cost() {
        return COST + room.cost();
    }
}
