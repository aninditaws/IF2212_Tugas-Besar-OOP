package GameMap;

import java.util.List;

public class GameMap<T> {
    private Area<T>[][] map;
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

    public void addEntity(T entity, int row, int col) {
        if (row < 0 || row >= height || col < 0 || col >= width) {
            throw new IllegalArgumentException("Error! Tidak dapat meletakkan di luar map");
        }
        map[row][col].addEntity(entity);
    }

    public List<T> getEntities(int row, int col) {
        if (row < 0 || row >= height || col < 0 || col >= width) {
            throw new IllegalArgumentException("Error! Tidak dapat melihat yang di luar map");
        }
        return map[row][col].getEntities();
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

    public Area<T> getArea(int row, int col) {
        if (row < 0 || row >= height || col < 0 || col >= width) {
            throw new IllegalArgumentException("Error! Area tidak diketahui!");
        }
        return map[row][col];
    }

    public int getRow() {
        return height;
    }

    public int getColumn() {
        return width;
    }
}
