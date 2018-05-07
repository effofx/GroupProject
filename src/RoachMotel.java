/**
 May 8, 2018
 Purpose: Representation of a RoachMotel. Singleton and half of the Observer Pattern lives here.
          Also connects various parts of the whole project.
 Input: initial capacity
 Output: invoice, room information, motel status information.
 **/

import java.text.NumberFormat;
import java.util.ArrayList;

public class RoachMotel implements Subject {
    private static final int DEFAULT_CAPACITY = 10;
    private static RoachMotel instance;

    private ArrayList<Observer> waitlist;
    private boolean vacant;

    private ArrayList<Room> rooms; // maybe make this final
    private RoomFactory roomFactory; // what we'll use to make Room objects
    private final int capacity; // final forces us to set the capacity in the constructor so that it cannot be changed.

    private RoachMotel() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Explicit contructor in order to make an RoachMotel with various capacities.
     * @param capacity
     */
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
     * This getInstance() method has a parameter in case we want to create a RoachMotel with a different capacity.
     * @param capacity is the number of rooms the RoachMotel has.
     * @return a specific instance of a RoachMotel object
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

    /**
     * Determines vacancy status by comparing:
     * how many rooms are in the motel (and thus how many rooms are occupied)
     * versus the given capacity of the motel.
     * @return
     */
    public boolean isVacant() {
        return rooms.size() < capacity;
    }

    /**
     * - checkIn() checks in a RoachColony to the RoachMotel if there is a room available
     *   otherwise it adds them to the waitlist.
     * - The process of checking in is as follows if there is a room available:
     *   1. use a RoomFactory to create a room of the specified type and decorate with amenities
     *   2. set the specified RoachColony as a guest in the room
     *   3. set the numOfOccupants of the room to the initial population of the Roach colony.
     *          a. note that numOfOccupants and initial population are kept separately
     *          b. this is to keep debugging simple
     *   4. add the room to the list of rooms in the motel
     * - After all is said and done, we update the vacancy status.
     *
     * @param roaches is the specified RoachColony bein checked in.
     * @param roomType is the type of room the RoachColony requested.
     * @param amenities is the list of Amenities the RoachColony requested.
     */
    public void checkIn(RoachColony roaches, String roomType, ArrayList<Amenities> amenities) {
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

    /**
     * - checkOut() calculates the cost of the the stay depending on the number of days
     *   a specific RoachColony has stayed. The room type and amenity costs are all accounted for
     *   when we used the Decorator Pattern.
     * - Then it passes the data over the the printInvoice() method for a nice output.
     * - Then it notifies all the RoachColonies on the waitlist and the waitlist is not cleared.
     *   a. note that we are not adding the first person on the waitlist to the available room.
     *      this is per assignment instructions.
     * - Finally we update the vacancy status.
     * @param roaches is the RoachColony being checked out
     * @param numOfNights is the number of nights the roaches stayed for.
     */
    public void checkOut(RoachColony roaches, int numOfNights) {
        Room roomOfRoach = getRoomOfRoach(roaches);
        double costPerDay = roomOfRoach.cost();
        double totalCost = costPerDay * numOfNights;

        printInvoice(roomOfRoach, numOfNights, totalCost);

        rooms.remove(roomOfRoach);

        // notify all guests on the waitlist that a room has become vacant:
        notifyObservers();
        waitlist.clear(); // as per assignment instructions

        vacant = isVacant(); // updating the vacancy variable
    }

    /**
     * - getRoomOfRoach() finds the room belonging to a specified RoachColony.
     * @param roaches is the RoachColony we are looking for.
     * @return return the room of a RoachColony
     */
    public Room getRoomOfRoach(RoachColony roaches) {
        Room roomOfInterest = null;

        for (Room room : rooms) {
            if (room.getGuest().equals(roaches)) {
                roomOfInterest = room;
            }
        }
        return roomOfInterest;
    }

    /**
     * - printInvoice() nicely prints the invoice for the RoachColony checking out.
     * - It prints:
     *   a. the guest name with a message
     *   b. the room information belonging to the guest
     *   c. number of nights the guest stayed
     *   d. total cost
     * @param roomOfRoach is the room belonging to the RoachColony checking out.
     * @param numOfNights is the number of nights the RoachColony stayed
     * @param totalCost is the total cost accrued
     */
    public void printInvoice(Room roomOfRoach, int numOfNights, double totalCost){
        System.out.println("_________________________________________________________________________");
        System.out.println("I N V O I C E       I N V O I C E       I N V O I C E       I N V O I C E\n");

        System.out.println("RoachColony \"" + roomOfRoach.getGuest().getName() + "\" has been checked out of the following room:\n");
        System.out.println(roomOfRoach);
        System.out.printf("\n%-14s: %s", "Nights stayed", numOfNights);
        System.out.printf("\n%-14s: %s\n", "Total cost", NumberFormat.getCurrencyInstance().format(totalCost));
        System.out.println("_________________________________________________________________________");
    }

    /**
     * - printRoomInfo() outputs nicely formatted information of ALL the rooms currently in the RoachMotel.
     */
    public void printRoomInfo() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("R O O M    INFORMATION");
        System.out.println("-------------------------------------------------------------------------");

        for (Room room: rooms) {
            System.out.println(room);
            System.out.println("-------------------------------------------------------------------------");
        }
    }

    /**
     * - printMotelInfo() prints information such as vacancy status, capacity, and number of guests on the waitlist.
     */
    public void printMotelInfo() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("M O T E L    INFORMATION");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(this);
        System.out.println("-------------------------------------------------------------------------");
    }

    /**
     * @return the String representation of the RoachMotel.
     */
    @Override
    public String toString() {
        String row1 = String.format("%-14s: %s ", "Vacant", vacant);
        String row2 = String.format("\n%-14s: %d/%d", "Capacity", rooms.size(), capacity);
        String row3 = String.format("\n%-14s: %d", "Waitlist", waitlist.size());

        return row1 + row2 + row3;
    }

    /**************************** Observer Pattern Methods *******************************/
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