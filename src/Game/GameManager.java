package Game;

import Subscriber.EventChannel;
import Sun.Sun;
import Zombie.Zombie;
import ZombieFactory.ZombieFactory;
import ZombieFactory.ZombieType;

import java.awt.*;
import Plant.*;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import Character.Character;


public class GameManager {

    public boolean flag = false;
    public int gameTick = 0;
    private final int zombieIncrease = 2;

    public Sun sun = Sun.getInstance();

    // Time Manager
    public Thread timerThread;
    private final EventChannel channel = EventChannel.getInstance();

    public void startTimer() {
        // Membuat sebuah thread yang akan menjalankan updateGameTick setiap 1 detik (1000 milliseconds)
        timerThread = new Thread(() -> {
            try {
                while (true) {
                    gameTick += 1;
                    gameTick = gameTick % 200;
                    updateGameTick(gameTick);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Game loop is interrupted!");
            }
        });

        // Membuat thread berjalan
        timerThread.start();
    }

    public void stopTimer() {
        // Membuat thread berhenti
        timerThread.interrupt();
    }

    public synchronized void updateGameTick(int gameTick) {
//        System.out.println(new Date());
        // Publish update
        System.out.printf("- TIME : %d%n", gameTick);
        channel.publishUpdate(gameTick);
        // Mekanisme flag
        if (gameTick == 140) {
            flag = true;
            System.out.println("flag on");
        }

        if (gameTick == 145) {
            flag = false;
            System.out.println("flag off");
        }
        // Mekanisme spawning zombie
        if (gameTick > 20 && gameTick < 160 && gameTick % 3 == 0) {
            spawnZombie(gameTick);
        }
        updateGameMap();
    }

    public boolean isFlag() {
        return flag;
    }

    // Map Manager

    private final GameMap<Object> gameMap = new GameMap<>(11, 6);


    public GameMap<Object> getGameMap() {
        return gameMap;
    }

    private void spawnZombie(int gameTick) {
        // Mekanisme buat cek zombie di setiap area map

        int max = 10; // Sejumlah tipe zombie
        int min = 1;
        int randomIndex = (int) ((Math.random() * (max - min)) + min);
        ZombieType[] zombieTypes = ZombieType.values();
        ZombieFactory zombieFactory = new ZombieFactory();

        for (int i = 0; i <= (flag? 5 : 0); i += 1) {
            boolean val = new Random().nextInt(3)==0;
            int zombieCount = countZombies();
            System.out.print("Attempt spawning zombie, Zombie Count: ");
            System.out.println(zombieCount);
            if (val && zombieCount < 10 + ((flag)? 15 : 0)) {
                Point randomPosition = generateRandomZombiePosition(zombieTypes[randomIndex]);
                gameMap.map[randomPosition.y][randomPosition.x].addEntity(zombieFactory.CreateZombie(zombieTypes[randomIndex], randomPosition));
                System.out.print("Created Zombie ");
                System.out.print(zombieTypes[randomIndex].toString());
                System.out.print(" at ");
                System.out.println(randomPosition);
            }
        }
    }

    private Point generateRandomZombiePosition(ZombieType zombieType) {
        int x = 10;
        int y, max, min;
        if (zombieType == ZombieType.DOLPHINRIDER || zombieType == ZombieType.DUCKYTUBE) {
            max = 3;
            min = 2;
        } else {
            boolean spawnTop = new Random().nextInt(2)==0;
            if (spawnTop) {
                max = 1;
                min = 0;
            } else {
                max = 5;
                min = 4;
            }
        }
        y = (new Random().nextInt(2) + min);
        return new Point(x, y);
    }

    private int countZombies() {
        AtomicInteger count = new AtomicInteger();
        for (int i = 0; i < gameMap.getRow(); i += 1) {
            for (int j = 0; j < gameMap.getColumn(); j += 1) {
                gameMap.map[i][j].getEntities().forEach(character -> {
                    if (character instanceof Zombie) {
                        count.addAndGet(1);
                    }
                });
            }
        }

        return count.get();
    }

    public void updateGameMap() {
        // Iterasi setiap area entity, kalau dia zombie dan sudah berubah positionnya, pindahin
        // Kalau dead, remove dari gameMap
        for (int i = 0; i < gameMap.map.length; i += 1) {
            for (int j = 0; j < gameMap.map[i].length; j += 1) {
                List<Object> entities = gameMap.getEntities(i, j);
                handleAttackZombie(entities, i, j);
                handleAttackPlant(entities, i, j);
                for (int k = 0; k < entities.size(); k += 1) {
                    Object entity = entities.get(k);
                    if (entity instanceof Character) {
                        Character character = (Character) entity;
                        removeIfDead(character,i, j, k);
                    }
                    if (entity instanceof Zombie){
//                        System.out.println(String.format("%d = %d? %d = %d?", ((Zombie) entity).position.x, j, ((Zombie) entity).position.y, i));
                        Zombie zombie = (Zombie) entity;
                        moveIfChange(zombie, i, j, k);
                    }
                }
            }
        }
    }

    private void removeIfDead(Character character, int i , int j, int k) {
        if (character.dead) {
            gameMap.removeEntity(i, j, k);
        }
    }

    private void moveIfChange(Character character, int i, int j, int k) {
        if (character.isDead()) {
            return;
        }
        if (character.position.x != j || character.position.y != i) {
            gameMap.moveEntity(i, j, k, character.position.y, character.position.x);
            System.out.println(String.format("Moved zombie %s from %d, %d to %d, %d", character.name, j, i, character.position.x, character.position.y));
        }
    }

    private void handleAttackZombie(List<Object> entities, int i, int j) {
        List<Object> nextColPlantEntities = gameMap.getEntities(i, (Math.max(j - 1, 0))).stream().filter(entity -> entity instanceof Plant).collect(Collectors.toList());;
        for (Object entity : entities) {
            if (entity instanceof Zombie) {
                Zombie zombie = (Zombie) entity;
                // Cek di nextColEntities apakah ada plant, jika iya, walk si zombie di set menjadi false dan mulai attack plant paling "atas"
                if (!nextColPlantEntities.isEmpty()) {
                    zombie.stopWalk();
                    zombie.attack((Character) nextColPlantEntities.get(0));
                } else {
                    zombie.startWalk();
                }
            }
        }
    }

    // Plant Manager

    public long countPlantsInCell(int row, int col) {
        List<Object> entities = gameMap.getEntities(row, col);
        return entities.stream()
                .filter(entity -> entity instanceof Plant)
                .count();
    }

    public boolean checkSpending(int cost) {
        try {
            Sun.getInstance().spendSun(cost);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean addPlant(Plant plant, int row, int col) {
        // DO CHECKING
        boolean success = false;
        if (gameMap.determineAreaType(row, col) == AreaType.PLANTABLE_AREA) {
            if (!(plant instanceof Lilypad) && countPlantsInCell(row, col) == 0) {
                success = checkSpending(plant.cost);
            }
        } else if (gameMap.determineAreaType(row, col) == AreaType.WATER_AREA) {
            if ((plant instanceof Lilypad) && countPlantsInCell(row, col) == 0) {
                success = checkSpending(plant.cost);
            } else if (!(plant instanceof Lilypad) && countPlantsInCell(row, col) == 1) {
                success = checkSpending(plant.cost);
            }
        }
        if (success) {
            gameMap.addEntity(plant, row, col);
        }
        System.out.println(String.format("planting %s", success));
        return success;
    }

    private void handleAttackPlant(List<Object> entities, int i, int j) {
        for (Object entity : entities) {
            if (entity instanceof Plant) {
                Plant plant = (Plant) entity;
                plant.attack(gameMap);
            }
        }
    }

    // Win and Lose Manager
    public int checkEndCondition() {
        // 0 lose, 1 masih bermain, 2 win
        if (checkLosingCondition()) {
            return 0;
        } else if (checkWinningCondition()) {
            return 2;
        } else {
            return 1;
        }
    }

    private boolean checkLosingCondition() {
        for (int j = 0; j < gameMap.map[0].length; j += 1) {
            List<Object> entities = gameMap.getEntities(0, j);
            for (int k = 0; k < entities.size(); k += 1) {
                Object entity = entities.get(k);
                if (entity instanceof Zombie){
//                        System.out.println(String.format("%d = %d? %d = %d?", ((Zombie) entity).position.x, j, ((Zombie) entity).position.y, i));
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkWinningCondition() {
        return countZombies() == 0 && gameTick > 160;
    }
}
