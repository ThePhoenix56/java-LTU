// Basklass "Monster"
public abstract class Monster {
    private String name;
    private int healthPoints;
    private int damage;

    // Konstruktor för monster
    public Monster(String name, int healthPoints, int damage) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getDamage() {
        return damage;
    }

    // Metod för att ta skada
    public void takeDamage(int damage) {
        healthPoints -= damage;
        if (healthPoints <= 0) {
            healthPoints = 0;
            System.out.println(name + " has been defeated!");
        } else {
            System.out.println(name + " takes " + damage + " damage. Remaining health: " + healthPoints);
        }
    }

    // Abstrakt metod för unika beteenden hos olika monster
    public abstract void attack(Player player);
}

// Subklass "Dragon"
class Dragon extends Monster {
    public Dragon() {
        super("Dragon", 18, 3); // Draken har 18 hälsopoäng och gör 3 i skada
    }

    @Override
    public void attack(Player player) {
        System.out.println("The Dragon breathes fire at you!");
        player.takeDamage(getDamage());
    }
}

// Subklass "Goblin"
class Goblin extends Monster {
    public Goblin() {
        super("Goblin", 8, 1); // Goblinen har 8 hälsopoäng och gör 1 i skada
    }

    @Override
    public void attack(Player player) {
        System.out.println("The Goblin swings its club at you!");
        player.takeDamage(getDamage());
    }
}
