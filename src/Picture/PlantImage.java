package Picture;

import java.awt.Image;

import javax.swing.ImageIcon;

public enum PlantImage {
    SUNFLOWERCARD("ImagePvZ/Plants/PlantsCard/sunflowerCard.png"),
    PEASHOOTERCARD("ImagePvZ/Plants/PlantsCard/PeashooterCard.PNG"),
    WALLNUTCARD("ImagePvZ/Plants/PlantsCard/wallnutCard.png"),
    SNOWPEACARD("ImagePvZ/Plants/PlantsCard/snowpeaCard.png"),
    SQUASHCARD("ImagePvZ/Plants/PlantsCard/squashCard.png"),
    LILY_PAD_SEEDCARD("ImagePvZ/Plants/PlantsCard/lilipadCard.png"),
    CHERRYBOMBCARD("ImagePvZ/Plants/PlantsCard/CherryBombCard.png"),
    JALAPENOCARD("ImagePvZ/Plants/PlantsCard/jalapenoCard.png"),
    REPEATERCARD("ImagePvZ/Plants/PlantsCard/repeaterCard.png"),
    TALLNUTCARD("ImagePvZ/Plants/PlantsCard/TallNutCard.png");

    // SUNFLOWER("ImagePvZ/Plants/PlantsImg/Sunflower.webp"),
    // PEASHOOTER("ImagePvZ/Plants/PlantsImg/Peashooter.webp"),
    // WALLNUT("ImagePvZ/Plants/PlantsImg/Wallnut.png"),
    // SNOWPEA("ImagePvZ/Plants/PlantsImg/Snowpea.webp"),
    // SQUASH("ImagePvZ/Plants/PlantsImg/Squash.webp"),
    // LILY_PAD("ImagePvZ/Plants/PlantsImg/Lilypad.webp"),
    // CHERRYBOMB("ImagePvZ/Plants/PlantsImg/CherryBomb.png"),
    // JALAPENO("ImagePvZ/Plants/PlantsImg/Jalapeno.webp"),
    // REPEATER("ImagePvZ/Plants/PlantsImg/Repeater.webp"),
    // TALLNUT("ImagePvZ/Plants/PlantsImg/Tallnut.webp");

    private String imagePath;

    PlantImage(String imagePath) {
        this.imagePath = imagePath;
    }

    public ImageIcon getImageIcon() {
        return new ImageIcon(this.imagePath);
    }

    public String getImagePath() {
        return this.imagePath;
    }
}
