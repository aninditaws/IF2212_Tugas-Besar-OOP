import java.util.*;

public class DeckTanaman {
    private List<Plant> arrayDeck;
    public static final int MAX_DECK_SIZE = 6;

    // Inizialisation DeckTanaman
    private DeckTanaman() {
        this.arrayDeck = new ArrayList<Plant>();

    }

    // getter arrayDeck
    public List<Plant> getArrayDeck() {
        return this.arrayDeck;
    }

    // Method print tanaman yang ada di deck
    public void printDeck() {
        System.out.println("Deck:\n");
        for (Plant plant : arrayDeck) {
            System.out.println(String.format("%s", plant.getName()));
        }
    }

    // fungsi menambahkan tanaman ke dalam area
    public void plantTanaman(Plant plant, GameMap<T> area) {
        int areaRow = area.getRow();
        int areaColumn = area.getColumn();

        if (area.determineAreaType(areaRow, areaColumn) == AreaType.PLANTABLE_AREA) {
            // if (plant.getCooldownTime()) if untuk cek cooldown tanaman

            area.getArea(areaRow, areaColumn).setPlant(plant);
        } else {
            System.out.println(String.format("Tidak bisa menanam tanaman di area %s",
                    area.getArea(areaRow, areaColumn).getType()));
        }
    }

    // fungsi menggali/remove tanaman dari dalam area
    public void digTanaman(GameMap<T> area) {
        int areaRow = area.getRow();
        int areaColumn = area.getColumn();

        if (area.getArea(areaRow, areaColumn).getPlant() != null) {
            area.getArea(areaRow, areaColumn).removePlant();
        } else {
            System.out.println(String.format("Tidak bisa menggali tanaman dari area %s",
                    area.getArea(areaRow, areaColumn).getType()));
        }
    }
}