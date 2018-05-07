import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        RoachMotel motel = RoachMotel.getInstance(5);
        ArrayList<String> amenitiesRequested = new ArrayList<>(); // need to remember to clear after each checkIn()

        RoachColony r1 = new RoachColony("family1", 100, 2);
        RoachColony r2 = new RoachColony("family2", 200, 4);
        RoachColony r3 = new RoachColony("family3", 300, 6);
        RoachColony r4 = new RoachColony("family4", 400, 8);
        RoachColony r5 = new RoachColony("family5", 500, 3);

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

        System.out.println("-----------------------------------------------------");
        System.out.println("Printing Rooms:");
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




    }
}

