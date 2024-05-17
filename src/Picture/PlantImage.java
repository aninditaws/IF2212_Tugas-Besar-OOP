package Picture;

public enum PlantImage {
    SUNFLOWERCARD("ImagePvZ/Plants/PlantsCard/sunflowerCard.png"),
    PEASHOOTERCARD("ImagePvZ/Plants/PlantsCard/PeashooterCard.PNG"),
    WALLNUTCARD("ImagePvZ/Plants/PlantsCard/wallnutCard.png"),
    SNOWPEACARD("ImagePvZ/Plants/PlantsCard/snowpeaCard.png"),
    SQUASHCARD("ImagePvZ/Plants/PlantsCard/squashCard.png"),
    LILY_PAD_SEEDCARD("ImagePvZ/Plants/PlantsCard/lilipadCard.png"),
    CHERRYBOMBCARD("ImagePvZ/Plants/PlantsCard/CherryBombCard.png"),
    JALAPENOCARD("ImagePvZ/Plants/PlantsCard/jalapenoCard.png"),
    NIGHTPEATERCARD("ImagePvZ/Plants/PlantsCard/nightpeaterCard.png"),
    TALLNUTCARD("ImagePvZ/Plants/PlantsCard/TallNutCard.png");

    private String imagePath;

    PlantImage(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return this.imagePath;
    }
}
