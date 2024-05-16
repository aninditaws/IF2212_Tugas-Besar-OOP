package Picture;

public enum FrameImage implements Picture {
    INVENTORY("ImagePvZ/Inventory/Inventory.png");

    private String imagePath;

    FrameImage(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return this.imagePath;
    }

}
