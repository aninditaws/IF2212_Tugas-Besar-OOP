package Game;

import java.util.List;
import Zombie.*;

public class GameMap<T> {
    public Area<T>[][] map;
    private final int width;
    private final int height;
    //row dan col itu disini trus dibuat public 

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
        map = new Area[height][width];
        initializeMap();
    }

    private void initializeMap() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = new Area<T>(determineAreaType(i, j));
            }
        }
    }

    public void addEntity(T entity, int row, int col) {
        if (row < 0 || row >= height || col < 0 || col >= width) {
            throw new IllegalArgumentException("Error! Tidak dapat meletakkan di luar map");
        }
        map[row][col].addEntity(entity);
    }

    public void removeEntity(int row, int col, int index) {
        if (row < 0 || row >= height || col < 0 || col >= width) {
            throw new IllegalArgumentException("Error! Tidak dapat meletakkan di luar map");
        }
        T removedEntity = map[row][col].getEntities().get(index);
        map[row][col].removeEntity(removedEntity);
    }



    public void moveEntity(int oldRow, int oldCol, int index, int newRow, int newCol) {
        if (oldRow < 0 || oldRow >= height || oldCol < 0 || oldCol >= width) {
            throw new IllegalArgumentException("Error! Tidak dapat meletakkan di luar map");
        }
        if (newRow < 0 || newRow >= height || newCol < 0 || newCol >= width) {
            throw new IllegalArgumentException("Error! Tidak dapat meletakkan di luar map");
        }
        map[newRow][newCol].addEntity(map[oldRow][oldCol].getEntities().get(index));
        removeEntity(oldRow, oldCol, index);
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
        } else if (col >= 1 && col <= 9) {
            if (row >= 2 && row <= 3) {
                return AreaType.WATER_AREA;
            } else {
                return AreaType.PLANTABLE_AREA;
            }
        } else if (col == 10) {
            if (row >= 2 && row <= 3) {
                return AreaType.ZOMBIE_SPAWN_WATER;
            } else {
                return AreaType.ZOMBIE_SPAWN_GROUND;
            }
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
