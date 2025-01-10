import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private String description;
    private Room[] doors; // Array av dörrar, varje dörr leder till ett annat rum
    private List<Monster> monsters; // Lista över monster i rummet

    // Konstruktor för att skapa ett rum
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.doors = new Room[2]; // Ett rum har alltid två dörrar
        this.monsters = new ArrayList<>(); // Initialiserar en tom lista med monster
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

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public boolean hasMonsters() {
        return !monsters.isEmpty();
    }
}
