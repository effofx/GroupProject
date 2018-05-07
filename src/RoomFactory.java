/**
 May 8, 2018
 Purpose: centralization for the creation different types of Room objects
 Input: none
 Output: various types of Room objects
 **/

import java.util.ArrayList;

public class RoomFactory {
    public static final String REGULAR = "regular";
    public static final String DELUXE = "deluxe";
    public static final String SUITE = "suite";

    public RoomFactory(){}

    /**
     * createRoom() first creates a room based on roomType
     * then decorates the room with the various decorations
     *
     * @param roomType is the type of room to be instantiated
     * @param amenities is the list of amenities the guest has requested
     * @return
     */
    public Room createRoom(String roomType, ArrayList<Amenities> amenities){
        roomType = roomType.toLowerCase();

        Room room = null;
        if(roomType.equals(REGULAR)){
            room = new RegularRoom();
        }
        else if(roomType.equals(DELUXE)){
            room = new DeluxeRoom();
        }
        else if(roomType.equals(SUITE)){
            room = new SuiteRoom();
        }

        // adds the amenities
        for (Amenities amenity: amenities) {
            room = amenity.setUp(room);
        }
        return room;
    }

    /**
     * Overrided as per instructions, nothing really useful.
     * @return
     */
    @Override
    public String toString() {
        return "This is the Room Factory";
    }
}

