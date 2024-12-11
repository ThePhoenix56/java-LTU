public class Dungeon {

    // Initierar rummen
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
