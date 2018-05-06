public abstract class Room {

    private String roomType;
    private RoachColony guest;
    private int numOfOccupants;

    public abstract double cost();

    public Room(){
        roomType = "none";
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
        String roomTypeDescription = getRoomType();
        if(roomTypeDescription.contains("[ANTI SPRAY SHOWER]")){
            return true;
        }
        return false;
    }

    public String getRoomType(){
        return roomType + " with ";
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
        return getRoomType() + " occupied by " + guest + " and [CURRENT POP. of " + numOfOccupants + "]";
    }
}

