package Zombie;
import Character.Character;
import GameMap.Area;
import Plant.Plant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class Zombie extends Character {
    protected String name;
    protected int health;
    protected int attack_Damage;
    protected int attack_Speed;
    protected boolean isAquatic;
    protected Area currentArea;
    private ScheduledExecutorService scheduler;

    public Zombie(String name, int health, int attack_Damage, int attack_Speed, boolean isAquatic) {
        super(name, health, attack_Damage,attack_Speed);
        this.isAquatic = isAquatic;
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
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

    // Metode abstrak yang perlu diimplementasikan oleh subclass
    public abstract void move(Area currentArea);

    // Metode untuk memulai pergerakan zombie
    public void startMoving(Area startingArea) {
        this.currentArea = startingArea;
        scheduler.scheduleAtFixedRate(() -> move(this.currentArea), 0, 5, TimeUnit.SECONDS); // Menjadwalkan pergerakan setiap 5 detik
    }

    // Menghentikan pergerakan zombie
    public void stopMoving() {
        scheduler.shutdownNow(); // Menghentikan semua tugas yang dijadwalkan
    }

    // Menyerang tanaman di area
    public void attack(Plant.Plant plant) {
        plant.takeDamage(this.attack_Damage); // Pastikan Plant memiliki metode takeDamage
    }

    public void takeDamage(int damage) {
        reduceHealth(damage);
        if (isDead()) {
            stopMoving(); // Hentikan pergerakan zombie jika mati
            die(); // Hapus zombie dari permainan
        }
    }

    public boolean isDead() {
        return (this.getHealth() <= 0);
    }

    // Menangani kematian zombie
    protected void die() {
        if (this.currentArea != null) {
            this.currentArea.removeZombie(); // Pastikan metode removeZombie ada di kelas Area
        }
        System.out.println(this.name + " has died.");
    }
