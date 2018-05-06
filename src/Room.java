public abstract class Room {

    private String roomType;
    private RoachColony inhabitant;

    public String getRoomType(){
        return roomType;
    }

    public void setRoomType(String type){
        this.roomType = type;
    }

    public RoachColony getInhabitant() {
        return inhabitant;
    }

    public void setInhabitant(RoachColony inhabitant) {
        this.inhabitant = inhabitant;
    }

    public abstract double cost();
}

