public abstract class RoomFactory {

    public Room addRoom(String roomType){
        Room room;

        room = createRoom(roomType);

        // do something

        return room;
    }

    public abstract Room createRoom(String roomType); // getRoom

}

