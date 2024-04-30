public class Area {
    private AreaType type;
    private Plant plant; // Plant yang ditanam di Area ini, jika ada

    public Area(AreaType type) {
        this.type = type;
        this.plant = null; // Awalnya tidak ada tanaman
    }

    public AreaType getType() {
        return type;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public void removePlant() {
        this.plant = null;
    }
}
