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

        vacant = isVacant(); // updating the vacancy variable

    }

    public void checkOut(RoachColony roaches, int numOfDays) {
        Room roomOfRoach = getRoomOfRoach(roaches);
        double costPerDay = roomOfRoach.cost();
        double totalCost = costPerDay * numOfDays;

        printInvoice(roomOfRoach, numOfDays, totalCost);

        rooms.remove(roomOfRoach);

        // notify all guests on the waitlist that a room has become vacant:
        notifyObservers();
        waitlist.clear();

        vacant = isVacant(); // updating the vacancy variable
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

    public void printInvoice(Room roomOfRoach, int numOfDays, double totalCost){
        System.out.println("_________________________________________________________________________");
        System.out.println("I N V O I C E       I N V O I C E       I N V O I C E       I N V O I C E\n");

        System.out.println("RoachColony \"" + roomOfRoach.getGuest().getName() + "\" has been checked out of the following room:\n");
        System.out.println(roomOfRoach);
        System.out.printf("\n%-14s: %s", "Nights stayed", numOfDays);
        System.out.printf("\n%-14s: %s\n", "Total cost", NumberFormat.getCurrencyInstance().format(totalCost));
        System.out.println("_________________________________________________________________________");
    }

    public void printRoomInfo() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("R O O M    INFORMATION");
        System.out.println("-------------------------------------------------------------------------");

        for (Room room: rooms) {
            System.out.println(room);
            System.out.println("-------------------------------------------------------------------------");
        }
    }

    public void printMotelInfo() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("M O T E L    INFORMATION");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(this);
        System.out.println("-------------------------------------------------------------------------");
    }

    @Override
    public String toString() {
        String row1 = String.format("%-14s: %s ", "Vacant", vacant);
        String row2 = String.format("\n%-14s: %d/%d", "Capacity", rooms.size(), capacity);
        String row3 = String.format("\n%-14s: %d", "Waitlist", waitlist.size());

        return row1 + row2 + row3;
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