import java.util.ArrayList;

public class RoachMotel  {
    private static final int DEFAULT_CAPACITY = 10;
    private static RoachMotel instance;

    private ArrayList<Room> rooms; // maybe make this final
    private RoomFactory roomFactory;
    private final int capacity;

    private RoachMotel(){
        this(DEFAULT_CAPACITY);
    }

    private RoachMotel(int capacity){
        rooms = new ArrayList<>();
        roomFactory = new RoomFactory();
        this.capacity = capacity;
    }

    public static RoachMotel getInstance(){
        if(instance == null){
            instance = new RoachMotel();
        }
        return instance;
    }

    /**
     * This getInstance() method has a parameter incase we want to create a RoachMotel with a different capacity;
     * @param capacity is the number of rooms the RoachMotel has.
     * @return a RoachMotel object
     */
    public static RoachMotel getInstance(int capacity){
        if(instance == null){
            instance = new RoachMotel(capacity);
        }
        return instance;
    }

    public int getCapacity() {
        return capacity;
    }

    public void checkIn(RoachColony roaches, String roomType, ArrayList<String> amenities){
        if(rooms.size() < capacity){
            Room room = roomFactory.createRoom(roomType, amenities);
            room.setGuest(roaches);
            room.setNumOfOccupants(roaches.getInitPopulation());
            rooms.add(room);
        }
        else{
            System.out.println("at max cap");
            // add to waitlist
        }
    }

    public void printRoomInfo(){
        System.out.println("-----------------------------------------------------------");

        for (int i = 0; i < rooms.size(); i++) {
            System.out.println(rooms.get(i));
            System.out.println("-----------------------------------------------------------");
        }
    }

    public Room getRoomOfRoach(RoachColony roaches){
        Room roomOfInterest = null;

        for (Room room: rooms) {
            if(room.getGuest().equals(roaches)){
                roomOfInterest = room;
            }

        }
        return roomOfInterest;
    }

}

