public abstract class RoomFactory {

    public Room addRoom(String roomType){
        Room room;

        room = createRoom();

        // do something

        return room;
    }

    public abstract Room createRoom(); // getRoom

}

