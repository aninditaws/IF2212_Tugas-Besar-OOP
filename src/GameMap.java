import java.util.List;
import java.util.ArrayList;

public class GameMap<T> {
    private List<T>[][] map;
    private final int width;
    private final int height;

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
        map = new ArrayList[height][width];
        initializeMap();
    }

    private void initializeMap() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
    }

    public void addEntity(T entity, int row, int col) {
        if (row < 0 || row >= height || col < 0 || col >= width) {
            throw new IllegalArgumentException("Error! Tidak dapat meletakkan di luar map");
        }
        map[row][col].add(entity);
    }

    public List<T> getEntities(int row, int col) {
        if (row < 0 || row >= height || col < 0 || col >= width) {
            throw new IllegalArgumentException("Error! Tidak dapat melihat yang di luar map");
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
