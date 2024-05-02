package Zombie;
public class Zombie {
    
}
public abstract class Zombie {
    protected String name;
    protected int health;
    protected int attack_Damage;
    protected int attack_Speed;
    protected boolean isAquatic;

    public Zombie(String name, int health, int attack_Damage, int attack_Speed, boolean isAquatic) {
        this.name = name;
        this.health = health;
        this.attackDamage = attack_Damage;
        this.attackSpeed = attack_Speed;
        this.isAquatic = isAquatic;
    }

    public abstract void move();

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            isDead();
        } else {
        }
    }

    protected void isDied() {
        // Remove this zombie from the game
    }

    // Getter methods
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getAttackDamage() { return attack_Damage; }
    public int getAttackSpeed() { return attack_Speed; }
    public boolean isAquatic() { return isAquatic; }
}
