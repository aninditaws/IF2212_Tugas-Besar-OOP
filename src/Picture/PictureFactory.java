package Picture;

import javax.swing.ImageIcon;

public class PictureFactory {
    public static ImageIcon getImageIcon(Picture picture) {
        ImageIcon imageIcon = null;
        switch (picture) {
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
            case INVENTORY:
                imageIcon = new ImageIcon("ImagePvZ/Inventory/inventoryNoDeck.png");
                break;
            case SWAPBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Inventory/SwapButton.png");
                break;
            case DELETEBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Inventory/DeleteButton.png");
                break;
            case CLEARBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Inventory/ClearButton.png");
                break;
            case NEXTBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Inventory/NextButton.png");
                break;
            default:
                break;
        }
        return imageIcon;

    }

}
