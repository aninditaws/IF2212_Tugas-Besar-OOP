import java.util.ArrayList;

public class DeckTanaman {
    ArrayList<Plant> plantDeck = new ArrayList<Plant>();
    static final int MAX_LENGTH = 10;

    // Inizialisation DeckTanaman
    public DeckTanaman() {
        this.plantDeck.size() = MAX_LENGTH;
    }

    // fungsi menambahkan tanaman ke dalam area
    public void plantTanaman(Plant plant, Area area) {

        if (area.determineAreaType() == AreaType.PLANTABLE_AREA) {
            area.setPlant(plant);
            // cooldown tanaman
        } else {
            System.out.println(String.format("Tidak bisa menanam tanaman di area %s", area.getType()));
        }
    }

    // fungsi menggali/remove tanaman dari dalam area
    public void digTanaman(Area area) {
        if (area.getPlant() != null) {
            area.removePlant();
        } else {
            System.out.println(String.format("Tidak bisa menggali tanaman di area %s", area.getType()));
        }
    }
}