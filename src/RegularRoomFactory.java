public class RegularRoomFactory extends RoomFactory {
    @Override
    public Room createRoom() {
        return new RegularRoom();
    }
}
