public class Main {
    public static void main(String[] args) {
        RoachMotel motel = RoachMotel.getInstance();

        RoachColony roachFam1 = new RoachColony("roachFam1", 100, 2);

        motel.checkIn(roachFam1, "regular");




    }
}

