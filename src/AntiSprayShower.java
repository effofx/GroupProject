public class AntiSprayShower extends Amenities {
    private static final double COST = 25;
    private Room room;

    public AntiSprayShower(Room room){ this.room = room; }

    @Override
    public String getRoomType() {
        return room.getRoomType() + "[ANTI SPRAY SHOWER]";
    }

    @Override
    public double cost() {
        return COST + room.cost();
    }
}

