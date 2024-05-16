package Inventory;

import java.util.*;

import Plant.*;

public class Inventory {

    private ArrayList<Plant> plantInventory;

    public Inventory() {
        this.plantInventory = new ArrayList<Plant>();
        initializeInventory();
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
        this.addPlant(new Onehitter());
        this.addPlant(new Tallnut());
    }

    // getter Plant
    public Plant getPlant(int index) {
        return this.plantInventory.get(index);
    }

    // method addPlant
    public void addPlant(Plant plant) {
        plantInventory.add(plant);
    }

    // Method print tanaman yang ada di inventory
    public void printInventory() {
        for (Plant plant : plantInventory) {
            System.out.println(String.format("%s", plant.name));
        }
    }

    // Fungsi chooseTanaman digunakan untuk memilih tanaman yang akan digunakan
    // dan ditaruh di deck tanaman
    public void chooseTanaman(Plant plant, DeckTanaman plantDeck, Inventory inventory) {
        if (plantDeck.getArrayDeck().size() < DeckTanaman.MAX_DECK_SIZE) {
            if (!this.plantInventory.contains(plant)) {
                if (plantDeck.getArrayDeck().contains(plant)) {
                    inventory.plantInventory.add(plant);
                    System.out.println(String.format("Berhasil menambahkan %s pada deck",
                            plant.name));
                } else {
                    System.out.println(String.format("Tidak ada tanaman %s di Deck.\n", plant.name));
                }
            } else {
                System.out.println("Tanaman sudah ada di deck");
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
            } else {
                System.out.println("Tanaman yang dipilih sama");
            }
        }
    }

    // Method menukar tanaman di inventory
    public void Switch(Inventory inventory, Plant plant1, Plant plant2) {
        if (inventory.plantInventory.contains(plant1) && inventory.plantInventory.contains(plant2)) {
            int idx1 = inventory.plantInventory.indexOf(plant1);
            int idx2 = inventory.plantInventory.indexOf(plant2);

            if (idx1 != idx2) {
                inventory.plantInventory.set(idx1, plant2);
                inventory.plantInventory.set(idx2, plant1);
            } else {
                System.out.println("Tanaman yang dipilih sama");
            }
        }
    }
}
