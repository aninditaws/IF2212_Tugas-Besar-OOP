import java.util.ArrayList;

public class Inventory {
    ArrayList<Plant> plantInventory = new ArrayList<Plant>();

    static final int MAX_LENGTH = 100;

    public plantInventory() {
        this.plantInventory.size() = MAX_LENGTH;
    }

    // Fungsi chooseTanaman digunakan untuk memilih tanaman yang akan digunakan
    // dan ditaruh di deck tanaman
    public void chooseTanaman(Plant plant, Plantdeck<Plant> plantDeck) {
        if (!plantDeck.contains(plant)) {
            plantDeck.add(plant);
        } else {
            System.out.println("Tanaman sudah ada di deck");
        }
    }

    public void switchPlantDeck(Plant plant, DeckTanaman deckTanaman) {
        if (deckTanaman.contains(plant)) {
            deckTanaman.remove(plant);
        } else {
            System.out.println("Tanaman tidak ada di deck");
        }
}
