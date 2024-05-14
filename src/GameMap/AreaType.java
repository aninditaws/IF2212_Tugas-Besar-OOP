package GameMap;
public enum AreaType {
    PROTECTED_AREA, // Area yang harus dilindungi pemain
    PLANTABLE_AREA, // Area yang dapat ditanami
    WATER_AREA, // Area yang harus ditanami dengan Lilypad terlebih dahulu
    ZOMBIE_SPAWN_GROUND, // Area tempat muncul zombie
    ZOMBIE_SPAWN_WATER
}