public class SprayResistantShower extends Amenities {
    private static final double COST = 25;
    private Room room;

    public SprayResistantShower(Room room){ this.room = room; }

    @Override
    public String getRoomType() {
        return room.getRoomType() + "[SPRAY RESISTANT SHOWER]";
    }

    @Override
    public double cost() {
        return COST + room.cost();
    }
}

