package ZombieFactory;

import Zombie.*;

import java.awt.*;

public class ZombieFactory {

    public Zombie CreateZombie(ZombieType zombieType, Point position) {
        switch (zombieType) {
            case CONEHEAD:
                return new ConeheadZombie(position);
            case POLEVAULTING:
                return new PolevaultingZombie(position);
            case BUCKETHEAD:
                return new BucketheadZombie(position);
            case DUCKYTUBE:
                return new DuckytubeZombie(position);
            case DOLPHINRIDER:
                return new DolphinRiderZombie(position);
            case FOOTBALL:
                return new FootballZombie(position);
            case GARGANTUAR:
                return new NewspaperZombie(position);
            case IMP:
                return new ImpZombie(position);
            case SCREENDOOR:
                return new ScreenDoorZombie(position);
            default:
                return new NormalZombie(position);
        }
    }
}
