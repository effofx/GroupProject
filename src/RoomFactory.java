public class RoomFactory {

    public Room addRoom(String roomType){
        Room room = null;

        //room = createRoom();

        // do something

        return room;
    }

    public Room createRoom(String roomType){
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

