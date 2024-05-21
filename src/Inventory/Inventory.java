package Inventory;

import java.util.*;

import javax.swing.JButton;

import Plant.*;

public class Inventory {

    private ArrayList<Plant> plantInventory;
    private Map<Integer, Boolean> clickedPlants;

    private List<JButton> plantButtons;

    public Inventory() {
        this.plantInventory = new ArrayList<Plant>();
        initializeInventory();
        clickedPlants = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            clickedPlants.put(i, false);
        }
        plantButtons = new ArrayList<>();
    }

    /* METHOD */

    // getter plantInventory
    public ArrayList<Plant> getPlantInventory() {
        return this.plantInventory;
    }

    // method initializeInventory

    public void initializeInventory() {

        this.addPlant(new Sunflower());
        this.addPlant(new Peashooter());
        this.addPlant(new Wallnut());
        this.addPlant(new SnowPea());
        this.addPlant(new Squash());
        this.addPlant(new Lilypad());
        this.addPlant(new CherryBomb());
        this.addPlant(new Jalapeno());
        this.addPlant(new Repeater());
        this.addPlant(new Tallnut());
    }

    // getter Plant
    public Plant getPlant(int index) {
        return this.plantInventory.get(index);
    }

    public void clearPlants() {
        this.plantInventory.clear();
    }

    public List<JButton> getPlantButtons() {
        return plantButtons;
    }

    public void clearPlantButtons() {
        this.plantButtons.clear();
    }

    // method addPlant
    public void addPlant(Plant plant) {
        this.plantInventory.add(plant);
    }

    // method addPlantButton
    public void addPlantButton(JButton button) {
        plantButtons.add(button);
    }

    // Apus border InventoryButotn
    public void removePlantBorder(int index) {
        JButton button = plantButtons.get(index);
        button.setBorder(null);
    }

    // Method print tanaman yang ada di inventory
    public void printInventory() {
        System.out.println("Inventory :");
        for (Plant plant : plantInventory) {
            System.out.println(String.format("%s", plant.name));
        }
    }

    // Fungsi chooseTanaman digunakan untuk memilih tanaman yang akan digunakan
    // dan ditaruh di deck tanaman
    public void chooseTanaman(Plant plant, DeckTanaman plantDeck, Inventory inventory) {

        if (plantDeck.getArrayDeck().size() < plantDeck.getMaxDeckSize()) {
            if (this.plantInventory.contains(plant)) {
                if (!plantDeck.getArrayDeck().contains(plant)) {
                    plantDeck.getArrayDeck().add(plant);
                    System.out.println(String.format("Berhasil menambahkan %s pada deck",
                            plant.name));
                } else {
                    System.out.println("Tanaman sudah ada di deck");
                }
            } else {
                System.out.println(String.format("Tidak ada tanaman %s di Deck.\n", plant.name));
            }
        } else {
            System.out.println(String.format("Tidak bisa menambah %s", plant.name));
            System.out.println("Deck sudah penuh");
        }
    }

    // Method menukar tanaman di deck
    public void Switch(DeckTanaman plantDeck, Plant plant1, Plant plant2) {
        // Fungsi switch digunakan untuk mengganti tanaman yang ada di deck
        if (plantDeck.getArrayDeck().contains(plant1) && plantDeck.getArrayDeck().contains(plant2)) {

            // Mengambil index dari masing-masing tanaman
            int idx1 = plantDeck.getArrayDeck().indexOf(plant1);
            int idx2 = plantDeck.getArrayDeck().indexOf(plant2);

            if (idx1 != idx2) {
                plantDeck.getArrayDeck().set(idx1, plant2);
                plantDeck.getArrayDeck().set(idx2, plant1);
                System.out.println(
                        String.format("Berhasil menukar tanaman %s dengan tanaman %s.", plant1.name, plant2.name));
                plantDeck.printDeck();
            } else {
                System.out.println("Tanaman yang dipilih sama");
            }
        }
    }

    // Method menukar tanaman di inventory
    public void Switch(Plant plant1, Plant plant2) {
        if (this.plantInventory.contains(plant1) && this.plantInventory.contains(plant2)) {
            int idx1 = this.plantInventory.indexOf(plant1);
            int idx2 = this.plantInventory.indexOf(plant2);

            if (idx1 != idx2) {
                this.plantInventory.set(idx1, plant2);
                this.plantInventory.set(idx2, plant1);
                System.out.println(
                        String.format("Berhasil menukar tanaman %s dengan tanaman %s.", plant1.name, plant2.name));
                printInventory();
            } else {
                System.out.println("Tanaman yang dipilih sama");
            }
        }
    }

    // Method buat GUI
    // plant boolean
    public boolean isClicked(int index) {
        return clickedPlants.getOrDefault(index, false);
    }

    // plant lagi dipencet
    public void setClicked(int index, boolean clicked) {
        clickedPlants.put(index, clicked);
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.printInventory();
        inventory.clearPlants();
        inventory.printInventory();
        inventory.initializeInventory();
        inventory.printInventory();
    }
}
