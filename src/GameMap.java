public class GameMap {
    private Area[][] map;
    private final int width = 9;
    private final int height = 6;

    public GameMap() {
        map = new Area[height][width];
        initializeMap();
    }

    private void initializeMap() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                AreaType type = determineAreaType(i, j);
                map[i][j] = new Area(type);
            }
        }
    }

    private AreaType determineAreaType(int row, int col) {
        if (col == 0) {
            return AreaType.PROTECTED_AREA;
        } else if (col >= 1 && col <= 7) {
            if (row >= 2 && row <= 3) {
                return AreaType.WATER_AREA;
            } else {
                return AreaType.PLANTABLE_AREA;
            }
        } else if (col == 8) {
            return AreaType.ZOMBIE_SPAWN;
        }
        return AreaType.PLANTABLE_AREA; // Default, should not reach here
    }

    public Area getArea(int row, int col) {
        return map[row][col];
    }
}
