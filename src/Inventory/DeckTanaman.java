package Inventory;

import java.util.*;

import Game.AreaType;
import Game.GameMap;
import Plant.Plant;

public class DeckTanaman {
    private List<Plant> arrayDeck;
    private int maxDeckSize;
    public static final int MAX_DECK_SIZE = 6;

    // Initialization DeckTanaman
    public DeckTanaman(int maxDeckSize) {
        this.arrayDeck = new ArrayList<Plant>();
        this.maxDeckSize = maxDeckSize;
    }

    // getter arrayDeck
    public List<Plant> getArrayDeck() {
        return this.arrayDeck;
    }

    public int getMaxDeckSize() {
        return this.maxDeckSize;
    }

    // Method print tanaman yang ada di deck
    public void printDeck() {
        System.out.println("Deck:\n");
        for (Plant plant : arrayDeck) {
            System.out.println(String.format("%s", plant.getName()));
        }
    }

    // fungsi menambahkan tanaman ke dalam area
    public void plantTanaman(Plant plant, GameMap<Plant> area) {
        int areaRow = area.getRow();
        int areaColumn = area.getColumn();

        if (area.determineAreaType(areaRow, areaColumn) == AreaType.PLANTABLE_AREA) {
            // if (plant.getCooldownTime()) if untuk cek cooldown tanaman

            area.getArea(areaRow, areaColumn).addEntity(plant);
        } else {
            System.out.println(String.format("Tidak bisa menanam tanaman di area %s",
                    area.getArea(areaRow, areaColumn).getType()));
        }
    }

    // fungsi menggali/remove tanaman dari dalam area
    public void digTanaman(GameMap<Plant> area) {
        int areaRow = area.getRow();
        int areaColumn = area.getColumn();

        if (area.getArea(areaRow, areaColumn).getEntities() != null) {
            area.getArea(areaRow, areaColumn).clearEntities();
        } else {
            System.out.println(String.format("Tidak bisa menggali tanaman dari area %s",
                    area.getArea(areaRow, areaColumn).getType()));
        }
    }
}