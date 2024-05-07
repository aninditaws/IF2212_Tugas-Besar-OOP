package GameMap;

public class GameMap {
    private Area<?>[][] map;
    private final int width;
    private final int height;

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
        map = new Area[height][width];
        initializeMap();
    }

    private void initializeMap() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = new Area<>(determineAreaType(i, j));
            }
        }
    }

    public void addEntity(Object entity, int row, int col) {
        if (row < 0 || row >= height || col < 0 || col >= width) {
            throw new IllegalArgumentException("Error! Tidak dapat meletakkan di luar map");
        }

        Area<Object> area = (Area<Object>) map[row][col];
        area.setEntity(entity);
    }

    public Area<?> getArea(int row, int col) {
        if (row < 0 || row >= height || col < 0 || col >= width) {
            throw new IllegalArgumentException("\"Error! Area tidak diketahui!");
        }
        return map[row][col];
    }

    public AreaType determineAreaType(int row, int col) {
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
        return AreaType.PLANTABLE_AREA;
    }

    public int getRow() {
        return height;
    }

    public int getColumn() {
        return width;
    }
}
