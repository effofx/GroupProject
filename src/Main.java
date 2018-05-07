/**
    Sam Alhaqab
    Arthur Brunch
    Dan Ayasch
    Cyril Flesch

    May 8, 2018
    Purpose: the test/demonstrator class for the entire project
    Input: none
    Output: none
 **/

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int initialCapacity = 5; // making this a small number so we don't have to create many RoachColony obj
        RoachMotel motel = RoachMotel.getInstance(initialCapacity);
        ArrayList<Amenities> amenitiesRequested = new ArrayList<>(); // need to remember to clear after each checkIn()

        RoachColony r1 = new RoachColony("The Andersons", 100, 2);
        RoachColony r2 = new RoachColony("The Simpsons", 200, 4);
        RoachColony r3 = new RoachColony("The Georges", 300, 3.14);
        RoachColony r4 = new RoachColony("The Beatles", 400, 8);
        RoachColony r5 = new RoachColony("The Hamptons", 500, 3);
        RoachColony r6 = new RoachColony("The McDonalds", 650, 8.5);
        RoachColony r7 = new RoachColony("The Steeles", 340, 2.5);
        RoachColony r8 = new RoachColony("The Stacys", 725, 2.15);
        RoachColony r9 = new RoachColony("The Wagners", 941, 6);
        RoachColony r0 = new RoachColony("The Roberts", 384, 6.2);

        amenitiesRequested.add(new AntiSprayShower());
        amenitiesRequested.add(new FoodBar());
        amenitiesRequested.add(new AutoRefill());
        motel.checkIn(r1, RoomFactory.REGULAR, amenitiesRequested);
        amenitiesRequested.clear();

        amenitiesRequested.add(new Spa());
        amenitiesRequested.add(new AutoRefill());
        motel.checkIn(r2, RoomFactory.DELUXE, amenitiesRequested);
        amenitiesRequested.clear();

        amenitiesRequested.add(new FoodBar());
        motel.checkIn(r3, RoomFactory.DELUXE, amenitiesRequested);
        amenitiesRequested.clear();

        // note no amenities requested here:
        motel.checkIn(r4, RoomFactory.SUITE, amenitiesRequested);

        amenitiesRequested.add(new Spa());
        amenitiesRequested.add(new AntiSprayShower());
        amenitiesRequested.add(new AutoRefill());
        amenitiesRequested.add(new FoodBar());
        motel.checkIn(r5, RoomFactory.REGULAR, amenitiesRequested);
        amenitiesRequested.clear();

        System.out.println("Motel Information after checking in 5 roach colonies:");
        motel.printMotelInfo(); // vacancy status should be full (false)

        // roaches r6 to r8 will be added on to the waitlist since the motel should be full
        // and we'll also assume they all want the same amenities for simplicity's sake
        amenitiesRequested.add(new FoodBar());
        amenitiesRequested.add(new Spa());
        motel.checkIn(r6, RoomFactory.REGULAR, amenitiesRequested);
        motel.checkIn(r7, RoomFactory.DELUXE, amenitiesRequested);
        motel.checkIn(r8, RoomFactory.SUITE, amenitiesRequested);
        amenitiesRequested.clear();

        System.out.println("Motel Information after attempting to check in an additional 3 roach colonies:");
        motel.printMotelInfo(); // vacancy status should be full (false) but with 3 on the waitlist
        motel.printRoomInfo(); // prints all the room info that is current in the

        // throwing parties
        motel.getRoomOfRoach(r1).throwParty();
        motel.getRoomOfRoach(r2).throwParty();
        motel.getRoomOfRoach(r3).throwParty();
        motel.getRoomOfRoach(r4).throwParty();
        motel.getRoomOfRoach(r5).throwParty();

        System.out.println("Printing rooms after throwing party:");
        motel.printRoomInfo();

        // checking out RoachColony r5
        motel.checkOut(r5, 4);

        // checking in two more RoachColonies to test if waitlist was cleared:
        amenitiesRequested.add(new AntiSprayShower());
        amenitiesRequested.add(new FoodBar());
        motel.checkIn(r9, RoomFactory.REGULAR, amenitiesRequested); // this roach should make it in the motel
        amenitiesRequested.clear();

        amenitiesRequested.add(new Spa());
        motel.checkIn(r0, RoomFactory.REGULAR, amenitiesRequested); // this roach should be on the waitlist
        amenitiesRequested.clear();

        // checking out one of the roaches to trigger notifying the RoachColony on the waitlist
        motel.checkOut(r2, 7);

        motel.printMotelInfo(); // vacancy status should be true
        motel.printRoomInfo();
    }
}

