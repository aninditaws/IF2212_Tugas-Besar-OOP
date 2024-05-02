import java.util.*;

import Plant.Plant;

public class Inventory {

    private ArrayList<Plant> plantInventory;

    public Inventory() {
        this.plantInventory = new ArrayList<Plant>();
    }

    /* METHOD */

    // getter plantInventory
    public ArrayList<Plant> getPlantInventory() {
        return this.plantInventory;
    }

    //

    // Method print tanaman yang ada di inventory
    public void printInventory() {
        System.out.println("Inventory:\n");
        for (Plant plant : plantInventory) {
            System.out.println(String.format("%s", plant.name));
        }
    }

    // Method addPlant
    // Memastikan tanaman belum ada di Inventory
    public void addPlant(Plant plant) {
        if (!plantInventory.contains(plant)) {
            plantInventory.add(plant);
        } else {
            System.out.println(String.format("Tanaman %s sudah ada di inventory", plant.name));
        }
    }

    // Fungsi chooseTanaman digunakan untuk memilih tanaman yang akan digunakan
    // dan ditaruh di deck tanaman
    public void chooseTanaman(Plant plant, DeckTanaman plantDeck) {
        if (plantDeck.getArrayDeck().size() < DeckTanaman.MAX_DECK_SIZE) {
            if (plantInventory.contains(plant)) {
                if (!plantDeck.getArrayDeck().contains(plant)) {
                    plantDeck.getArrayDeck().add(plant);
                    // System.out.println(String.format("Berhasil menambahkan %s pada deck",
                    // plant.name));
                } else {
                    System.out.println("Tanaman sudah ada di deck");
                }
            } else {
                System.out.println(String.format("Tidak ada tanaman %s di Inventory.\n", plant.name));
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
