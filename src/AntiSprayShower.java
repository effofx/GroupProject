public class AntiSprayShower extends Amenities {
    private static final double COST = 25;
    private Room room;

    public AntiSprayShower() {}

    public AntiSprayShower(Room room){
        this.setUp(room);
    }

    /**
     * - setUp() is essentially a psuedo explicit contructor.
     * - It is useful when we want to decorate an object but we do not know what that object is yet.
     * - It basically links up the room variable composition style just like the Decorator Pattern demands.
     * - This is useful when you have a list of Amenities but no Room obj yet.
     * - You are no longer forced to use "room = new AntiSprayShower(room)" instead we can
     *   use the default constructor to create the decorator and store it somewhere
     *   and then when we have the Room obj we want to decorate
     *   we simply call setUp() to link everything together
     *   just like how the explicit constructor traditionally does it.
     * @param room is the room object we are attempting to compose with
     */
    public AntiSprayShower setUp(Room room){
        this.setRoomType(room.getRoomType());
        this.room = room;
        return this;
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

