public class FoodBar extends Amenities {
    private static final double COST = 10;
    private Room room;

    public FoodBar(Room room){ this.room = room; }

    @Override
    public String getRoomType() {
        return room.getRoomType() + " with a FOOD BAR";
    }

    @Override
    public double cost() {
        return COST + room.cost();
    }
}

