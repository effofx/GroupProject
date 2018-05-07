public class AntiSprayShower extends Amenities {
    private static final double COST = 25;
    private Room room;

    public AntiSprayShower(Room room){
        this.setRoomType(room.getRoomType());
        this.room = room;
    }

    @Override
    public String getRoomDescription() {
        return room.getRoomDescription() + " [ANTI-SPRAY SHOWER]";
    }

    @Override
    public double cost() {
        return COST + room.cost();
    }
}

