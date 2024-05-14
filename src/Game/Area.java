package Game;

import java.util.ArrayList;
import java.util.List;

public class Area<T> {
    private AreaType type;
    private List<T> entities;

    public Area(AreaType type) {
        this.type = type;
        this.entities = new ArrayList<>();
    }

    public AreaType getType() {
        return type;
    }

    public List<T> getEntities() {
        return entities;
    }

    public void addEntity(T entity) {
        this.entities.add(entity);
    }

    public void removeEntity(T entity) {
        this.entities.remove(entity);
    }

    public void clearEntities() {
        this.entities.clear();
    }

    public boolean containsEntity(Class<? extends T> entityType) {
        return entities.stream().anyMatch(entityType::isInstance);
    }
}