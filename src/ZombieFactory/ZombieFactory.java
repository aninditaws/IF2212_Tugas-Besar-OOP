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
            default:
                return new NormalZombie();
        }
    }
}
