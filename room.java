public class Room {
/*
    public void doNarrative(int roomNumber) { // Rumnummer bestäms av en integer (roomNumber). doNarrative-metoden beskriver rummet och navigerings-möjligheterna
        int[] doors = {1, 2};

        switch (roomNumber) {
            case 1:
                System.out.println("You stand in a large cave and a bat flies by.\n" +
                        "It is dark and cold and you cannot see very well.\n" +
                        "\n" +
                        "Press 1 to go to the eastern door.\n" +
                        "Press 2 to go to the southern door.\n");
                break;
            case 2:
                System.out.println("In this room, four torches hang from the walls.\n" +
                        "The light is warm.\n" +
                        "\n" +
                        "Press 1 to go to the eastern door.\n" +
                        "Press 2 to go to the northern door.\n");
                break;
            case 3:
                System.out.println("You have come to a narrow tunnel.\n" +
                        "There is water on the floor that reaches your knees.\n" +
                        "\n" +
                        "Press 1 to go to the western door.\n" +
                        "Press 2 to go to the southern door.\n");
                break;
            case 4:
                System.out.println("You come in and see a chest with a golden light through the keyhole.\n" +
                        "\n" +
                        "Press 1 to go to the northern door.\n" +
                        "Press 2 to go to the western door.\n");
                break;
            default:
                System.out.println("Invalid room.");
                break;
        }
    }
}

*/

       private String name;
    private String description;
    private Room[] doors;  // Array av dörrar, varje dörr leder till ett annat rum

    // Konstruktor för att skapa ett rum
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.doors = new Room[2];  // Ett rum har alltid två dörrar
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDoors(Room door1, Room door2) {
        this.doors[0] = door1;
        this.doors[1] = door2;
    }

    public Room[] getDoors() {
        return doors;
    }
}
