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

        RoachMotel motel = RoachMotel.getInstance(5);
        ArrayList<String> amenitiesRequested = new ArrayList<>(); // need to remember to clear after each checkIn()

        RoachColony r1 = new RoachColony("The Andersons", 100, 2);
        RoachColony r2 = new RoachColony("The Simpsons", 200, 4);
        RoachColony r3 = new RoachColony("The Georges", 300, 6);
        RoachColony r4 = new RoachColony("The Beatles", 400, 8);
        RoachColony r5 = new RoachColony("The Hamptons", 500, 3);
        RoachColony r6 = new RoachColony("The McDonalds", 650, 2.5);
        RoachColony r7 = new RoachColony("The Steeles", 650, 2.5);
        RoachColony r8 = new RoachColony("The Stacys", 650, 2.5);
        RoachColony r9 = new RoachColony("The Wagners", 650, 2.5);
        RoachColony r0 = new RoachColony("The Roberts", 650, 2.5);

        amenitiesRequested.add("shower");
        amenitiesRequested.add("foodbar");
        amenitiesRequested.add("autorefill");
        motel.checkIn(r1, "regular", amenitiesRequested);
        amenitiesRequested.clear();

        amenitiesRequested.add("spa");
        amenitiesRequested.add("autorefill");
        motel.checkIn(r2, "deluxe", amenitiesRequested);
        amenitiesRequested.clear();

        amenitiesRequested.add("foodbar");
        motel.checkIn(r3, "deluxe", amenitiesRequested);
        amenitiesRequested.clear();

        // note no amenities requested here:
        motel.checkIn(r4, "suite", amenitiesRequested);

        amenitiesRequested.add("spa");
        amenitiesRequested.add("shower");
        amenitiesRequested.add("autorefill");
        amenitiesRequested.add("foodbar");
        motel.checkIn(r5, "regular", amenitiesRequested);
        amenitiesRequested.clear();

        motel.printMotelInfo(); // vacancy status should be full (false)

        // roaches r6 to r8 will be added on to the waitlist since the motel should be full
        // and we'll also assume they all want the same amenities for simplicity's sake
        amenitiesRequested.add("foodbar");
        amenitiesRequested.add("spa");
        motel.checkIn(r6, "suite", amenitiesRequested);
        motel.checkIn(r7, "suite", amenitiesRequested);
        motel.checkIn(r8, "suite", amenitiesRequested);
        amenitiesRequested.clear();

        motel.printRoomInfo();

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
        amenitiesRequested.add("shower");
        amenitiesRequested.add("foodbar");
        motel.checkIn(r9, "regular", amenitiesRequested); // this roach should make it in the motel
        amenitiesRequested.clear();

        amenitiesRequested.add("spa");
        motel.checkIn(r0, "regular", amenitiesRequested); // this roach should be on the waitlist
        amenitiesRequested.clear();

        motel.checkOut(r2, 7);

        motel.printMotelInfo();
    }
}

