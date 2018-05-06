import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        RoachMotel motel = RoachMotel.getInstance(4);
        ArrayList<String> amenitiesRequested = new ArrayList<>(); // need to remember to clear after each checkIn()

        RoachColony roachFam1 = new RoachColony("family1", 100, 2);
        RoachColony roachFam2 = new RoachColony("family2", 200, 4);
        RoachColony roachFam3 = new RoachColony("family3", 300, 6);
        RoachColony roachFam4 = new RoachColony("family4", 400, 8);
        RoachColony roachFam5 = new RoachColony("family5", 500, 3);

        amenitiesRequested.add("shower");
        amenitiesRequested.add("foodbar");
        amenitiesRequested.add("autorefill");
        motel.checkIn(roachFam1, "regular", amenitiesRequested);
        amenitiesRequested.clear();

        amenitiesRequested.add("spa");
        amenitiesRequested.add("autorefill");
        motel.checkIn(roachFam2, "deluxe", amenitiesRequested);
        amenitiesRequested.clear();


        amenitiesRequested.add("foodbar");
        motel.checkIn(roachFam3, "deluxe", amenitiesRequested);
        motel.checkIn(roachFam4, "suite", amenitiesRequested);
        motel.checkIn(roachFam5, "regular", amenitiesRequested);
        amenitiesRequested.clear();

        motel.printRoomInfo();

        // throwing parties
        motel.getRoomOfRoach(roachFam1).throwParty();
        motel.getRoomOfRoach(roachFam2).throwParty();
        motel.getRoomOfRoach(roachFam3).throwParty();
        motel.getRoomOfRoach(roachFam4).throwParty();

        motel.printRoomInfo();



    }
}

