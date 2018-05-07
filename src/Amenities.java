/**
 * This is the RoomDecorator class, however, it is more fitting to call it Amenities.
 */

public abstract class Amenities extends Room{
    public abstract String getRoomDescription();
    public abstract Room setUp(Room room); // a psuedo constructor, see extended classes for details
}

