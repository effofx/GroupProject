/**
 May 8, 2018
 Purpose: Amenities is the RoomDecorator class, however, "Amenities" is a more fitting name.
 Input: none
 Output: none
 **/

public abstract class Amenities extends Room{
    public abstract String getRoomDescription();
    public abstract Room setUp(Room room); // a psuedo constructor, see extended classes for details
}

