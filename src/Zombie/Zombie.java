package Zombie;
import Character.Character;

public abstract class Zombie extends Character {
    protected String name;
    protected int health;
    protected int attack_Damage;
    protected int attack_Speed;
    protected boolean isAquatic;

    public Zombie(String name, int health, int attack_Damage, int attack_Speed, boolean isAquatic) {
        super(name, health, attack_Damage,attack_Speed);
        this.isAquatic = isAquatic;
    }

    public abstract void move();

    public void takeDamage(int damage) {
        health -= damage;
        isDead();
    }

    public boolean isDead() {
        return (this.getHealth() <= 0);
    }

    // Getter methods
    public String getName() { 
        return name; 
    }

    public int getHealth() { 
        return health; 
    }

    public int getAttackDamage() { 
        return attack_Damage; 
    }

    public int getAttackSpeed() { 
        return attack_Speed; 
    }

    public boolean isAquatic() { 
        return isAquatic; 
    }
}
