public class Dungeon {
    private Room[][] rooms; // array som hanterar de olika rummen som finns i dongeon
    private int currentRoomX; // Spelarens position i x-led
    private int currentRoomY; // Spelarens position i y-led
    private Player player; // Referens till spelaren

    public Dungeon() {
        rooms = new Room[2][2]; // 2x2 = 4 rum
        currentRoomX = 0; // Startar på rum som motsvarar kortinaterna (0,0)
        currentRoomY = 0;
        player = new Player("Adventurer"); // Skapar en ny spelare

        // Skapa rummen med namn och beskrivningar
        rooms[0][0] = new Room("cave", "You stand in a large cave and a bat flies by.\nIt is dark and cold.");
        rooms[0][1] = new Room("spooky torches", "In this room, four torches hang from the walls. The light is warm.");
        rooms[1][0] = new Room("tunnel", "You have come to a narrow tunnel. Water reaches your knees.");
        rooms[1][1] = new Room("treasury", "You see a chest glowing with golden light through the keyhole.");

        // Lägg till monster i rummen
        rooms[0][1].addMonster(new Goblin());
        rooms[1][0].addMonster(new Dragon());

        // Hur rummen länkas med dörrar
        rooms[0][0].setDoors(rooms[0][1], rooms[1][0]);
        rooms[0][1].setDoors(rooms[0][0], rooms[1][1]);
        rooms[1][0].setDoors(rooms[0][0], rooms[1][1]);
        rooms[1][1].setDoors(rooms[0][1], rooms[1][0]);
    }

    public void doNarrative() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Room currentRoom = rooms[currentRoomX][currentRoomY];

            // Skriv ut beskrivning av rummet
            System.out.println(currentRoom.getDescription());

            // Kontrollera om det finns monster i rummet
            if (currentRoom.hasMonsters()) {
                for (Monster monster : currentRoom.getMonsters()) {
                    System.out.println("A " + monster.getName() + " is here!");
                    monster.attack(player); // Monster attackerar spelaren
                    player.fight(monster); // Spelaren kan slåss
                    if (monster.getHealthPoints() <= 0) {
                        currentRoom.getMonsters().remove(monster);
                        break;
                    }
                }
            }

            // Visa tillgängliga dörrar
            Room[] doors = currentRoom.getDoors();
            if (doors[0] != null) {
                System.out.println("Press 1 to enter " + doors[0].getName());
            }
            if (doors[1] != null) {
                System.out.println("Press 2 to enter " + doors[1].getName());
            }

            int choice = scanner.nextInt();
            if (choice == 1 && doors[0] != null) {
                moveToRoom(doors[0]);
            } else if (choice == 2 && doors[1] != null) {
                moveToRoom(doors[1]);
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void moveToRoom(Room nextRoom) {
        for (int x = 0; x < rooms.length; x++) {
            for (int y = 0; y < rooms[x].length; y++) {
                if (rooms[x][y] == nextRoom) {
                    currentRoomX = x;
                    currentRoomY = y;
                    System.out.println("You enter " + nextRoom.getName() + ".");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Dungeon dungeon = new Dungeon();
        dungeon.doNarrative(); // Startar spelet
    }
}
