public class Dungeon {

    /* // Initierar rummen
    int[][] rooms = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};

    public void playGame() {
        Room room = new Room(); // Skapar en instance av "Room"
        room.doNarrative(1); // Nummer 1 används som ett exempel här. Det skickar den över till metoden "doNarrative"
    }

    public static void main(String[] args) {
        Dungeon dungeon = new Dungeon();
        dungeon.playGame(); // Kallar metoden "playGame" som gör att spelet börjar
    }
}
*/ 

    private Room[][] rooms;  // array som hanterar de olika rummen som finns i dongeon.
    private int currentRoomX; // Spelarens position i x-led.
    private int currentRoomY; // Spelarens position i y-led.

    // Konstruktor för att skapa dungeons rummen
    public Dungeon() {
        rooms = new Room[2][2];  // 2x2 = 4 rum.
        currentRoomX = 0;  // Startar på rum som motsvarar kortinaterna (0,0).
        currentRoomY = 0;

        // Skapa rummen med namn och beskrivningar.
        rooms[0][0] = new Room("cave", "You stand in a large cave and a bat flies by." + "\n" +
                "It is dark and cold and you cannot see very well." +
                "\n");
        rooms[0][1] = new Room("spooky torches", "In this room, four torches hang from the walls." + "\n" +
        "The light is warm." +
                "\n");
        rooms[1][0] = new Room("tunel","You have come to a narrow tunnel." +"\n" +
                "There is water on the floor that reaches your knees." +
                "\n" );
        rooms[1][1] = new Room("treasury", "You come in and see a chest with a golden light through the keyhole." +
                "\n" );

        // hur rummen länkas med dörrar.
        rooms[0][0].setDoors(rooms[0][1], rooms[1][0]);
        rooms[0][1].setDoors(rooms[0][0], rooms[1][1]);
        rooms[1][0].setDoors(rooms[0][0], rooms[1][1]);
        rooms[1][1].setDoors(rooms[0][1], rooms[1][0]);
    }

    // Metod som hanterar navigering mellan rum.
    public void doNarrative() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // skriver ut rumsbeskrivning för vars spelaren befinner sig.
            Room currentRoom = rooms[currentRoomX][currentRoomY];

            System.out.println(currentRoom.getDescription());

            // Fråga spelaren om vilken dörr de vill gå igenom.
            Room[] doors = currentRoom.getDoors();

            if (doors[0] != null) {
                System.out.println("Press 1 to enter " + doors[0].getName());
            }
            if (doors[1] != null) {
                System.out.println("Press 2 to enter " + doors[1].getName());
            }

            int choice = scanner.nextInt();

            // Hantering av spelarens inmatningar.
            if (choice == 1 && doors[0] != null) {
                moveToRoom(doors[0]);
            } else if (choice == 2 && doors[1] != null) {
                moveToRoom(doors[1]);
            } else {
                System.out.println("Press 1 och 2 to enter another room.");
            }
        }
    }

    // Metod för att gå till ett annat rum.
    private void moveToRoom(Room nextRoom) {
        for (int x = 0; x < rooms.length; x++) {
            for (int y = 0; y < rooms[x].length; y++) {
                if (rooms[x][y] == nextRoom) {
                    currentRoomX = x;
                    currentRoomY = y;
                    System.out.println("You´ve entered " + nextRoom.getName() + ".\n");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Dungeon dungeon = new Dungeon();
        dungeon.doNarrative();  // Startar programmet.
    }
}
