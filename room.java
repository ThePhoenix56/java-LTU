public class Room {

    public void describeRoom(int roomNumber) { // Rumnummer bestäms av en integer
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
