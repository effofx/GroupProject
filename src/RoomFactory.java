import java.util.ArrayList;

public class RoomFactory {

    public RoomFactory(){}

    public Room createRoom(String roomType, ArrayList<String> amenities){
        roomType = roomType.toLowerCase();

        Room room = null;
        if(roomType.equals("regular")){
            room = new RegularRoom();
        }
        else if(roomType.equals("deluxe")){
            room = new DeluxeRoom();
        }
        else if(roomType.equals("suite")){
            room = new SuiteRoom();
        }

        // adding amenities to the room
        for (int i = 0; i < amenities.size(); i++) {
            if(amenities.get(i).equals("foodbar")){
                room = new FoodBar(room);
            }
            else if(amenities.get(i).equals("spa")){
                room = new Spa(room);

            }
            else if(amenities.get(i).equals("autorefill")){
                room = new AutoRefill(room);
            }
            else if(amenities.get(i).equals("shower")){
                room = new AntiSprayShower(room);
            }
            else{
                System.out.println("The amenity " + amenities + " does not exist");
            }
        }
        return room;
    }
}

