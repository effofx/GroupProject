
public class SuiteRoomFactory extends RoomFactory {
    @Override
    public Room createRoom() {
        return new SuiteRoom();
    }
}