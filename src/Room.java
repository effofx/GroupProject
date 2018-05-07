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


    public void sprayInsecticide(){
        if(hasShower()){
            numOfOccupants = numOfOccupants - (int)(numOfOccupants*0.25);
        }
        else{
            numOfOccupants = numOfOccupants - (int)(numOfOccupants*0.50);
        }

        // since it doesn't make sense to have a negative occupancy
        if(numOfOccupants < 0){
            numOfOccupants = 0;
        }
    }

    public void throwParty(){
        numOfOccupants *= guest.getGrowthRate();
        sprayInsecticide();
    }

    public boolean hasShower(){
        String roomTypeDescription = getRoomDescription();
        if(roomTypeDescription.contains("[ANTI SPRAY SHOWER]")){
            return true;
        }
        return false;
    }

    public String amenitiesList(){
        String roomDescription = getRoomDescription();
        int indexOfFirstOccurrence = roomDescription.indexOf('[');

        String amenitiesList;
        if(indexOfFirstOccurrence == -1){
            amenitiesList = "[NONE]";
        }
        else{
            amenitiesList = roomDescription.substring(indexOfFirstOccurrence);
        }

        return amenitiesList;
    }

    public String getRoomDescription(){
        return roomType;
    }

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

    @Override
    public String toString() {
        String row1 = String.format("%-14s: %s [NUM. OF OCCUPANTS = %s]", "Room Type", roomType, numOfOccupants);
        String row2 = String.format("\n%-14s: %s", "Amenities", amenitiesList());
        String row3 = String.format("\n%-14s: %s", "Occupant Info", guest);

        return row1 + row2 + row3;
    }
}

