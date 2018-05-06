
public class DeluxeRoomFactory extends RoomFactory {
    @Override
    public Room createRoom() {
        return new DeluxeRoom();
    }
}