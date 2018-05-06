public abstract class Room {

    private String roomType;
    private RoachColony guest;

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

    public abstract double cost();

    @Override
    public String toString() {
        return getRoomType() + " occupied by the colony: " + guest;
    }
}

