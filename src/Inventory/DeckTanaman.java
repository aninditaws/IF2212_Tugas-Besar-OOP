package Inventory;

import java.util.*;

import Game.AreaType;
import Game.GameManager;
import Game.GameMap;
import Plant.Plant;
import Subscriber.*;

public class DeckTanaman implements Subscriber {
    private List<Plant> arrayDeck;
    private int maxDeckSize;
    public static final int MAX_DECK_SIZE = 6;

    public int[] cooldownList;

    // Initialization DeckTanaman
    public DeckTanaman(int maxDeckSize) {
        this.maxDeckSize = maxDeckSize;
        this.arrayDeck = new ArrayList<>(maxDeckSize);
        this.cooldownList = new int[maxDeckSize];
        for (int i = 0; i < maxDeckSize; i++) {
            // Korelasi index sama dengan arrayDeck
            this.cooldownList[i] = 0;
        }
        EventChannel.getInstance().subscribe(this);
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

    // ClearDeck
    public void clearDeck() {
        this.arrayDeck.clear();
    }

    public boolean isOnCooldown(int index) {
        if (cooldownList[index] > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void usePlant(int index) {
        if (!isOnCooldown(index)) {
            this.cooldownList[index] = this.arrayDeck.get(index).cooldown;
        }

    }

    public void updateCooldown() {
        for (int i = 0; i < maxDeckSize; i++) {
            if (cooldownList[i] > 0) {
                System.out.println(String.format("UPDATE COOLDOWN %s", getArrayDeck().get(i).name));
                cooldownList[i] -= 1;
            }
        }
    }

    @Override
    public void update(int gameTick) {
        updateCooldown();
    }
}