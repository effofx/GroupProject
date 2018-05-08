/**
 May 8, 2018
 Purpose: Abstract Class for a Room object
 Input: none
 Output: String representation of the Room object and everything in it.
 **/

import java.text.NumberFormat;

public abstract class Room {
    private String roomType;
    private RoachColony guest;
    private int numOfOccupants;

    public abstract double cost();

    public Room(){
        this.roomType = roomType;
        guest = new RoachColony();
        numOfOccupants = 0;
    }

    /**
     * sprayInsecticide() is our population reducer.
     * It calculates the new number of occupants depending on if the room has a shower.
     * If the new number of occupants turns out to be negative we set the numOfOccupants
     * to be 0 since a negative population in this context means all roaches have been eradicated.
     */
    public void sprayInsecticide(){
        if(hasShower()){
            numOfOccupants -= (int)(numOfOccupants*0.25);
        }
        else{
            numOfOccupants -= (int)(numOfOccupants*0.50);
        }

        // since it doesn't make sense to have a negative occupancy
        if(numOfOccupants < 0) numOfOccupants = 0;
    }

    /**
     * throwParty() increases the numOfOccupants by their growth rate (G.R.)
     * then essentially lowers it by calling the sprayInsecticide() method.
     */
    public void throwParty(){
        numOfOccupants += numOfOccupants*guest.getGrowthRate();
        sprayInsecticide();
    }

    /**
     * - hasShower() determines if the Room obj or its children have an ANTI-SPRAY SHOWER
     *   using the roomDescription() method.
     * - Admittedly, this method is quite volatile because it uses descriptions to make comparisons.
     * - Meaning if the description of an ANTI-SPRAY SHOWER is changed, hasShower() may return
     *   the wrong boolean value IF the hasShower() has not been updated aswell.
     * - I attempt to alleviate this issue by minimizing the information needed being compared to.
     * - Another solution would be to create a boolean variable to keep track of if an ANTI-SPRAY SHOWER
     *   has been added to the room but I don't like this solution as it adds a bit of complexity to
     *   the Room class, does not take advantage of existing information, and ruins the generality of this class.
     * @return true if Room has shower, false otherwise..
     */
    public boolean hasShower(){
        String roomTypeDescription = getRoomDescription().toLowerCase(); // toLowerCase() is to minimize what the information can be
        if(roomTypeDescription.contains("shower")){
            return true;
        }
        return false;
    }

    /**
     * - amenitiesList() makes use of the getRoomDescription() method to get the list of amenities.
     * - Admittedly, this method is also volatile because the comparison used to extract out
     *   the different type of amenities depend on the amenities' description being surrounded by
     *   square brackets. Put shortly, the delimiter is '['.
     * - A solution would be to create x number of boolean variables to keep track of what type of
     *   amenities are added to the room but this solution adds a bit of complexity to
     *   the Room class, does not take advantage of existing information, and ruins the generality of this class.
     * - Another solution would be to create an ArrayList of Amenities to store the different Amenities.
     *   However, this makes using the Decorator Pattern absolutely redundant.
     * @return every Amenity the Room has.
     */
    public String amenitiesList(){
        String roomDescription = getRoomDescription();
        int indexOfFirstOccurrence = roomDescription.indexOf('[');

        String amenitiesList;
        if(indexOfFirstOccurrence == -1) amenitiesList = "[NONE]";
        else amenitiesList = roomDescription.substring(indexOfFirstOccurrence);

        return amenitiesList;
    }

    /**
     * - getRoomDescription() when called from any child class of the
     *   Room class(specifically the children of Amenities), will return the roomType plus all the amenities.
     * - This is used as the method to propagate information for the Decorator Pattern.
     * - You might notice that this function seems to do the same thing as getRoomType(),
     *   please see that method for details.
     * @return the type of room, however see above.
     */
    public String getRoomDescription(){
        return roomType;
    }

    /**
     * - getRoomType() may seem like its doing the same thing as getRoomDescription() but
     *   since it does not share the name with its children classes, the call will not result
     *   in more calls depending on where its called from. It will reliably ALWAYS return
     *   nothing BUT the type of room.
     * @return the type of room
     */
    public String getRoomType(){
        return roomType;
    }

    public void setRoomType(String type){
        this.roomType = type;
    }

    public RoachColony getGuest() {
        return guest;
    }

    public void setGuest(RoachColony guest) {
        this.guest = guest;
    }

    public int getNumOfOccupants() {
        return numOfOccupants;
    }

    public void setNumOfOccupants(int numOfOccupants) {
        this.numOfOccupants = numOfOccupants;
    }

    /**
     * Sets up information by rows for easy debugging and reading.
     * @return String representation of the Room and everything in it.
     */
    @Override
    public String toString() {
        String row1 = String.format("%-14s: [%s] [NUM. OF OCCUPANTS = %s]", "Room Type", roomType, numOfOccupants);
        String row2 = String.format("\n%-14s: %s", "Amenities", amenitiesList());
        String row3 = String.format("\n%-14s: %s", "Occupant Info", guest);
        String row4 = String.format("\n%-14s: %s per night", "Pricing", NumberFormat.getCurrencyInstance().format(cost()));

        return row1 + row2 + row3 + row4;
    }
}

