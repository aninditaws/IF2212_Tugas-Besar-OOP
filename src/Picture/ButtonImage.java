package Picture;

public enum ButtonImage implements Picture {
    PLAYBUTTON("ImagePvZ/Button/Play_Button.png");

    private String imagePath;

    ButtonImage(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return this.imagePath;
    }

}
