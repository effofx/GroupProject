import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        RoachMotel motel = RoachMotel.getInstance();
        RoachColony roachFam1 = new RoachColony("roachFam1", 100, 2);
        ArrayList<String> amenitiesRequested = new ArrayList<>(); // need to remember to clear after each checkIn()

        amenitiesRequested.add("spa");
        amenitiesRequested.add("foodbar");
        amenitiesRequested.add("shower");

        motel.checkIn(roachFam1, "regular", amenitiesRequested);

        motel.printRoomInfo();



    }
}

