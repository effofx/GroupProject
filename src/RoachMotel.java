import java.text.NumberFormat;
import java.util.ArrayList;

public class RoachMotel implements Subject {
    private static final int DEFAULT_CAPACITY = 10;
    private static RoachMotel instance;

    private ArrayList<Observer> waitlist;
    private boolean vacant;

    private ArrayList<Room> rooms; // maybe make this final
    private RoomFactory roomFactory;
    private final int capacity;

    private RoachMotel() {
        this(DEFAULT_CAPACITY);
    }

    private RoachMotel(int capacity) {
        rooms = new ArrayList<>();
        waitlist = new ArrayList<>();
        roomFactory = new RoomFactory();
        vacant = true;
        this.capacity = capacity;

    }

    public static RoachMotel getInstance() {
        if (instance == null) {
            instance = new RoachMotel();
        }
        return instance;
    }

    /**
     * This getInstance() method has a parameter incase we want to create a RoachMotel with a different capacity;
     *
     * @param capacity is the number of rooms the RoachMotel has.
     * @return a RoachMotel object
     */
    public static RoachMotel getInstance(int capacity) {
        if (instance == null) {
            instance = new RoachMotel(capacity);
        }
        return instance;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isVacant() {
        return rooms.size() < capacity;
    }

    public void checkIn(RoachColony roaches, String roomType, ArrayList<String> amenities) {
        if (isVacant()) {
            Room room = roomFactory.createRoom(roomType, amenities);
            room.setGuest(roaches);
            room.setNumOfOccupants(roaches.getInitPopulation());
            rooms.add(room);
        }
        else {
            // add to waitlist
            addObserver(roaches);
        }
    }

    public void checkOut(RoachColony roaches, int numOfDays) {
        Room roomOfRoach = getRoomOfRoach(roaches);
        double costPerDay = roomOfRoach.cost();
        double totalCost = costPerDay * numOfDays;

        System.out.println("___________________________________________________________________");
        System.out.println("R E C E I P T");
        System.out.println("___________________________________________________________________");
        System.out.println("RoachColony \"" + roaches.getName() + "\" has been checked out of the following room:\n");
        System.out.println(roomOfRoach);
        System.out.printf("\n%-14s: %s", "Nights stayed", numOfDays);
        System.out.printf("\n%-14s: %s\n", "Total cost", NumberFormat.getCurrencyInstance().format(totalCost));
        System.out.println("___________________________________________________________________");
        rooms.remove(roomOfRoach);

        // notify all guests on the waitlist that a room has become vacant:
        notifyObservers();
        waitlist.clear();

    }

    public void printRoomInfo() {
        System.out.println("-----------------------------------------------------------");

        for (int i = 0; i < rooms.size(); i++) {
            System.out.println(rooms.get(i));
            System.out.println("-----------------------------------------------------------");
        }
    }

    public Room getRoomOfRoach(RoachColony roaches) {
        Room roomOfInterest = null;

        for (Room room : rooms) {
            if (room.getGuest().equals(roaches)) {
                roomOfInterest = room;
            }
        }
        return roomOfInterest;
    }

    @Override
    public void addObserver(Observer o) {
        waitlist.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        waitlist.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : waitlist) {
            observer.update();
        }
    }
}