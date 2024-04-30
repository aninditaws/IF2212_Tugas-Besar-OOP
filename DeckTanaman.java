import java.util.ArrayList;

public class DeckTanaman {
    ArrayList<Plant> plantDeck = new ArrayList<Plant>();
    static final int MAX_LENGTH = 10;

    public DeckTanaman() {
        this.plantDeck.size() = MAX_LENGTH;
    }

    public void addTanaman(Plant plant) {
        if (!plantDeck.contains(plant)){
            plantDeck.add(plant);
    }   else{
        System.out.println("Tanaman sudah ada di deck");
    }

    public void plantTanaman(Plant plant, Area area) {
        if (area.determineAreaType() == AreaType.PLANTABLE_AREA) {
            area.setPlant(plant);
        } else {
            System.out.println("Area tidak bisa ditanami tanaman");
        }
    }

    public void digTanaman(Area area){ 
        if(area.getPlant() != null){  
              area.removePlant();  
            e {
            System.out.println("Tidak ada tanaman yang bisa digali");
        }
    }
}