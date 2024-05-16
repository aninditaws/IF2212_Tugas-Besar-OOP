package Picture;

public enum PlantImage implements Picture {
    SUNFLOWERCARD("ImagePvZ/Plants/PlantsCard/sunflowerCard.png"),
    PEASHOOTERCARD("ImagePvZ/Plants/PlantsCard/PeashooterCard.PNG"),
    WALLNUTCARD("ImagePvZ/Plants/PlantsCard/wallnutCard.png"),
    SNOWPEACARD("ImagePvZ/Plants/PlantsCard/SnowPea.png"),
    SQUASHCARD("ImagePvZ/Plants/PlantsCard/squash.png"),
    LILY_PAD_SEEDCARD("ImagePvZ/Plants/PlantsCard/LilyPadSeedCard.png"),
    CHERRYBOMBCARD("ImagePvZ/Plants/PlantsCard/cherrybombCard.png"),
    JALAPENOCARD("ImagePvZ/Plants/PlantsCard/jalapenoCard.png"),
    NIGHTPEATERCARD("ImagePvZ/Plants/PlantsImg/Nightpeater.png"),
    TALLNUTCARD("ImagePvZ/Plants/PlantsCard/TallNutCard.png");

    private String imagePath;

    PlantImage(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return this.imagePath;
    }
}
