package ZombieFactory;

import Zombie.*;

public class ZombieFactory {

    public Zombie CreateZombie(ZombieType zombieType) {
        switch (zombieType) {
            case NORMAL:
                return new NormalZombie();
            case CONEHEAD:
                return new ConeheadZombie();
            case POLEVAULTING:
                return new PolevaultingZombie();
            case BUCKETHEAD:
                return new BucketheadZombie();
            case DUCKYTUBE:
                return new DuckytubeZombie();
            case DOLPHINRIDER:
                return new DolphinRiderZombie();
            case FOOTBALL:
                return new FootballZombie();
            case GARGANTUAR:
                return new GargantuarZombie();
            case IMP:
                return new ImpZombie();
            case SCREENDOOR:
                return new ScreenDoorZombie();
            default:
                return new NormalZombie();
        }
    }
}
