public class RoomFactory {

    public Room createRoom(String roomType){
        roomType = roomType.toLowerCase();

        Room room = null;
        if(roomType.equals("regular")){
            room = new RegularRoom();
        }
        else if(roomType.equals("deluxe")){
            room = new DeluxeRoom();
        }
        else if(roomType.equals("suite")){
            room = new SuiteRoom();
        }
        return room;
    }

}

