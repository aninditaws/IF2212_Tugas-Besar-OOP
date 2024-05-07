package GameMap;

public class Area<T> {
    private AreaType type;
    private T entity; // Generic entity placed in this area

    public Area(AreaType type) {
        this.type = type;
        this.entity = null; // Initially empty
    }

    public AreaType getType() {
        return type;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public void removeEntity() {
        this.entity = null;
    }
}
