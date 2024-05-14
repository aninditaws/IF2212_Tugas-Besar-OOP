package Zombie;
import Character.Character;
import Plant.Plant;
import Update.*;

import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;

public abstract class OldZombie extends Character implements CustomListener {
    protected String name;
    protected int health;
    protected int attack_Damage;
    protected int attack_Speed;
    protected boolean isAquatic;
    protected boolean moving;
    protected boolean plant_in_range;
    protected int time = 0 ;
    protected boolean is_slow=false;
    private ScheduledExecutorService scheduler;

    public static ArrayList<OldZombie> oldZombies = new ArrayList<OldZombie>();


    public OldZombie(String name, int health, int attack_Damage, int attack_Speed, boolean isAquatic) {
        super(name, health, attack_Damage,attack_Speed);
        this.isAquatic = isAquatic;
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

    protected boolean is_slow=false;

    public void set_slow(){
        is_slow = true;
    }

    public void moving (){

    }

    public abstract void move();
    void actionPerformed(){
        if (timer >= 60*10 && is_slow ){
            move();
            time = 0;
        }
        if (timer >= 60*5 && !is_slow ){
            move();
            timer = 0;
        } else {time++}
        if(moving){
            if(is_slowed){
                if (timer > 10){
                    X-=1;
                    Plant_In_Range();
                    timer = 0;
                }
            }
            else{
            if(timer>5){
                X-=1;
                Plant_In_Range();
                timer=0;
            }
            }
        }else{
            if(timer>60){
                Attack(target);
                Plant_In_Range();
                timer=0;
            }
        }
        timer++;
        if(X== 30){
            System.out.println("lose");
        }
    }


    }

}
    // Metode untuk memulai pergerakan zombie
    public void startMoving(Area startingArea) {
        this.currentArea = startingArea;
        scheduler.scheduleAtFixedRate(() -> move(this.currentArea), 0, 5, TimeUnit.SECONDS); // Menjadwalkan pergerakan setiap 5 detik
    }

    // Menghentikan pergerakan zombie
    public void stopMoving() {

    }

    // Menyerang tanaman di area
    public void attack(Plant.Plant plant) {
        plant.takeDamage(this.attack_Damage); // Pastikan Plant memiliki metode takeDamage
    }

    public void range (Plant.Plant plant) {

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
            this.currentArea.removeEntity(zombies); // Pastikan metode removeZombie ada di kelas Area
        }
        System.out.println(this.name + " has died.");
    }


    import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OldZombie1 extends Square implements CustomListener {
    String name = "Zombie";
    int Health =125;
    int attack_damage=100;
    int attack_speed=1;
    boolean is_aquatic=false;
    boolean moving=true;
    BufferedImage Png=null;
    boolean plant_in_range=false;
    int timer=0;
    boolean dead=false;
    boolean attack=false;
    Plant target=null;
;
    Boolean is_slowed=false;
    public void Attack(Plant plant){
        plant.damage(attack_damage);
    }
    public void Start_moving(){
        moving=true;
    }
    public void Stop_moving(){
        moving=false;
    }

    public void Plant_In_Range(){
        Start_moving();
        for (Plant plant : Screen.plants) {
            if(plant!=null){
                if(check_Range(plant)){
                    Stop_moving();
                target=plant;
                }
            }
        }
    }

    public boolean check_Range(Shapes shape){
        if(shape!=null){
            if(Y==shape.Y){
                if(X-1*Screen.tilesize<shape.getX()&&X>shape.getX()){
                    return true;
                }else
                {
                    return false;
                }
            }else{
                return false;
            }
        }
        return false;
    }

    protected OldZombie1(int X, int Y) {
        super(X, Y);
        //TODO Auto-generated constructor stub
    }

    public void Draw(Graphics2D g2) {
        try {
            Png = ImageIO.read(new File(picture));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(Png,X,Y,1*Screen.tilesize,1*Screen.tilesize,null);
    }

    @Override
    public void actionPerformed() {
        if(moving){
            if(is_slowed){
                if (timer > 10){
                    X-=1;
                    Plant_In_Range();
                    timer = 0;
                }
            }
            else{
            if(timer>5){
                X-=1;
                Plant_In_Range();
                timer=0;
            }
            }
        }else{
            if(timer>60){
                Attack(target);
                Plant_In_Range();
                timer=0;
            }
        }
        timer++;
        if(X== 30){
            System.out.println("lose");
        }
    }


}
