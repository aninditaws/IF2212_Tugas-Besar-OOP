package Picture;

import javax.swing.ImageIcon;

public class PictureFactory {
    public static ImageIcon getImageIcon(Picture picture) {
        ImageIcon imageIcon = null;
        switch (picture) {
            // Plants Cards
            case SUNFLOWERCARD:
                imageIcon = new ImageIcon("ImagePvZ/Plant/SunflowerCard.png");
                break;
            case PEASHOOTERCARD:
                imageIcon = new ImageIcon("ImagePvZ/Plant/PeashooterCard.png");
                break;
            case WALLNUTCARD:
                imageIcon = new ImageIcon("ImagePvZ/Plant/WallnutCard.png");
                break;
            case SNOWPEACARD:
                imageIcon = new ImageIcon("ImagePvZ/Plant/SnowpeaCard.png");
                break;
            case SQUASHCARD:
                imageIcon = new ImageIcon("ImagePvZ/Plant/SquashCard.png");
                break;
            case LILY_PAD_SEEDCARD:
                imageIcon = new ImageIcon("ImagePvZ/Plant/LilypadCard.png");
                break;
            case CHERRYBOMBCARD:
                imageIcon = new ImageIcon("ImagePvZ/Plant/CherrybombCard.png");
                break;
            case JALAPENOCARD:
                imageIcon = new ImageIcon("ImagePvZ/Plant/JalapenoCard.png");
                break;
            case NIGHTPEATERCARD:
                imageIcon = new ImageIcon("ImagePvZ/Plant/NightpeaterCard.png");
                break;
            case TALLNUTCARD:
                imageIcon = new ImageIcon("ImagePvZ/Plant/TallnutCard.png");
                break;

            // Plants
            case SUNFLOWER:
                imageIcon = new ImageIcon("ImagePvZ/Plant/Sunflower.png");
                break;
            case PEASHOOTER:
                imageIcon = new ImageIcon("ImagePvZ/Plant/Peashooter.png");
                break;
            case WALLNUT:
                imageIcon = new ImageIcon("ImagePvZ/Plant/Wallnut.png");
                break;
            case SNOWPEA:
                imageIcon = new ImageIcon("ImagePvZ/Plant/Snowpea.png");
                break;
            case SQUASH:
                imageIcon = new ImageIcon("ImagePvZ/Plant/Squash.png");
                break;
            case LILY_PAD:
                imageIcon = new ImageIcon("ImagePvZ/Plant/Lilypad.png");
                break;
            case CHERRYBOMB:
                imageIcon = new ImageIcon("ImagePvZ/Plant/Cherrybomb.png");
                break;
            case JALAPENO:
                imageIcon = new ImageIcon("ImagePvZ/Plant/Jalapeno.png");
                break;
            case NIGHTPEATER:
                imageIcon = new ImageIcon("ImagePvZ/Plant/Nightpeater.png");
                break;
            case TALLNUT:
                imageIcon = new ImageIcon("ImagePvZ/Plant/Tallnut.png");
                break;

            // Background
            case WELCOME:
                imageIcon = new ImageIcon("ImagePvZ/Welcome/welcomePageNoButton.png");
                break;
            case INVENTORY:
                imageIcon = new ImageIcon("ImagePvZ/Inventory/inventoryNoButton.png");
                break;
            case GAMEDAY:
                imageIcon = new ImageIcon("ImagePvZ/GameFrame/gameFrame.png");
                break;
            case GAMENIGHT:
                imageIcon = new ImageIcon("ImagePvZ/GameFrame/gameFrameNight.png");
                break;

            // Button
            case STARTBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Welcome/Button/startButton.png");
                break;
            case PLANTSBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Welcome/Button/plantListButton.png");
                break;
            case ZOMBIESBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Welcome/Button/zombieListButton.png");
                break;
            case HELPBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Welcome/Button/helpButton.png");
                break;
            case EXITBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Welcome/Button/exitButton.png");
                break;

            case SWAPBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Inventory/Button/swapButton.png");
                break;
            case DELETEBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Inventory/Button/deleteButton.png");
                break;
            case CLEARBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Inventory/Button/clearButton.png");
                break;
            case NEXTBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Inventory/Button/playButton.png");
                break;
            case MENUBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Inventory/Button/menuButton.png");
                break;
            default:
                break;
        }
        return imageIcon;

    }

}
