import java.util.ArrayList;

public class RoachMotel  {
    private static final int CAPACITY = 10;
    private static RoachMotel instance;

    private ArrayList<Room> rooms; // maybe make this final
    private RoomFactory regularRoomFactory;
    private RoomFactory deluxeRoomFactory;
    private RoomFactory suiteRoomFactory;

    private RoachMotel(){
        rooms = new ArrayList<>();
        regularRoomFactory = new RegularRoomFactory();
        deluxeRoomFactory = new DeluxeRoomFactory();
        suiteRoomFactory = new SuiteRoomFactory();

    }

    public static RoachMotel getInstance(){
        if(instance == null){
            instance = new RoachMotel();
        }
        return instance;
    }


}

