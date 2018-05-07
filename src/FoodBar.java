public class FoodBar extends Amenities {
    private static final double COST = 10;
    private Room room;

    public FoodBar(Room room){
        this.setRoomType(room.getRoomType());
        this.room = room;
    }

    @Override
    public String getRoomDescription() {
        return room.getRoomDescription() + " [FOOD BAR]";
    }

    @Override
    public double cost() {
        return COST + room.cost();
    }
}

