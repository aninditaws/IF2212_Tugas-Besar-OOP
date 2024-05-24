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
            case REPEATERCARD:
                imageIcon = new ImageIcon("ImagePvZ/Plant/NightpeaterCard.png");
                break;
            case TALLNUTCARD:
                imageIcon = new ImageIcon("ImagePvZ/Plant/TallnutCard.png");
                break;

            // ZOmbies Cards
            case NORMALZOMBIECARD:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie IMG/NormalZombie.png");
                break;
            case CONEHEADZOMBIECARD:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie IMG/ConeheadZombie.png");
                break;
            case BUCKETHEADZOMBIECARD:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie IMG/BucketheadZombie.png");
                break;
            case SCREENDOORZOMBIECARD:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie IMG/DoorZombie.png");
                break;
            case FOOTBALLZOMBIECARD:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie IMG/FootballZombie.png");
                break;
            case POLEVAULTINGZOMBIECARD:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie IMG/PolevaultZombie.png");
                break;
            case DUCKYTUBEZOMBIECARD:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie IMG/DuckZombie.png");
                break;
            case DOLPHINERIDERZOMBIECARD:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie IMG/DolphineZombie.png");
                break;
            case GARGANTUARZOMBIECARD:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie IMG/GargantuarZombie.png");
                break;
            case IMPZOMBIECARD:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie IMG/ImpZombie.png");
                break;

            // Plants
            case SUNFLOWER:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsImg/Sunflower.png");
                break;
            case PEASHOOTER:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsImg/Peashooter.png");
                break;
            case WALLNUT:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsImg/Wallnut.png");
                break;
            case SNOWPEA:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsImg/Snowpea.png");
                break;
            case SQUASH:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsImg/Squash.png");
                break;
            case LILY_PAD:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsImg/Lilypad.png");
                break;
            case CHERRYBOMB:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsImg/CherryBomb.png");
                break;
            case JALAPENO:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsImg/Jalapeno.png");
                break;
            case REPEATER:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsImg/Repeater.png");
                break;
            case TALLNUT:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsImg/Tallnut.png");
                break;

            // Background
            case WELCOME:
                imageIcon = new ImageIcon("ImagePvZ/Welcome/welcomePageNoButton.png");
                break;
            case PLANTSLISTBG:
                imageIcon = new ImageIcon("ImagePvZ/Plants/Plants_page/plantsListBg.png");
                break;
            case ZOMBIESLISTBG:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie List + Icon Zombies/zombiesListBg.png");
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
            case FLAG:
                imageIcon = new ImageIcon("ImagePvZ/GameFrame/flag.png");
                break;

            // Plants List
            case SUNFLOWERLIST:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsList/Sunflower.png");
                break;
            case PEASHOOTERLIST:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsList/Peashooter.png");
                break;
            case REPEATERLIST:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsList/Repeater.png");
                break;
            case LILIPADLIST:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsList/Lilypad.png");
                break;
            case TALLNUTLIST:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsList/Tall-nut.png");
                break;
            case SNOWPEALIST:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsList/SnowPea.png");
                break;
            case WALLNUTLIST:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsList/Wall-nut.png");
                break;
            case CHERRYBOMBLIST:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsList/Cherry Bomb.png");
                break;
            case JALAPENOLIST:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsList/Jalapeno.png");
                break;
            case SQUASHLIST:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsList/Squash.png");
                break;

            // Bullet List
            case BULLET:
                imageIcon = new ImageIcon("ImagePvZ/Plants/Bullet/Pea.png");
                break;

            case SLOWBULLET:
                imageIcon = new ImageIcon("ImagePvZ/Plants/Bullet/SlowPea.png");
                break;

            // Zombies List
            case NORMALZOMBIELIST:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie IMG/Zombies Card/NormalZombieCard.png");
                break;
            case CONEHEADZOMBIELIST:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie IMG/Zombies Card/ConeHeadZombieCard.png");
                break;
            case BUCKETHEADZOMBIELIST:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie IMG/Zombies Card/BucketheadZombieCard.png");
                break;
            case SCREENDOORZOMBIELIST:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie IMG/Zombies Card/ScreenDoorZombieCard.png");
                break;
            case FOOTBALLZOMBIELIST:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie IMG/Zombies Card/FootballZombieCard.png");
                break;
            case POLEVAULTINGZOMBIELIST:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie IMG/Zombies Card/PoleVaultingZombieCard.png");
                break;
            case DUCKYTUBEZOMBIELIST:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie IMG/Zombies Card/DuckyTubeZombieCard.png");
                break;
            case DOLPHINERIDERZOMBIELIST:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie IMG/Zombies Card/DolphineRiderZombieCard.png");
                break;
            // case GARGANTUARZOMBIELIST:
            // imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie IMG/Zombies
            // Card/GargantuarZombieCard.png");
            // bre
            case IMPZOMBIELIST:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie IMG/Zombies Card/ImpZombieCard.png");
                break;

            // Welcoming Button
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
            case DIGBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/GameFrame/shovel.png");
                break;

            // Plants List Button
            case ZOMBIELISTSBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsIcon/zombieListsButton.png");
                break;
            case SUNFLOWERBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsIcon/Sunflower_icon.png");
                break;
            case PEASHOOTERBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsIcon/Peashooter_icon.png");
                break;
            case REPEATERBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsIcon/Repeater_icon.png");
                break;
            case LILYPADBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsIcon/Lilypad_icon.png");
                break;
            case TALLNUTBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsIcon/Tallnut_icon.png");
                break;
            case SNOWPEABUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsIcon/Snowpea_icon.png");
                break;
            case WALLNUTBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsIcon/Wallnut_icon.png");
                break;
            case CHERRYBOMBBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsIcon/CherryBomb_icon.png");
                break;
            case JALAPENOBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsIcon/Jalapeno_icon.png");
                break;
            case SQUASHBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Plants/PlantsIcon/Squash_icon.png");
                break;

            case PLANTLISTSBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie List + Icon Zombies/plantListsButton.png");
                break;

            // Zombies List Button
            case NORMALZOMBIEBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie List + Icon Zombies/Icon Zombies/NormalZombie.png");
                break;
            case CONEHEADZOMBIEBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie List + Icon Zombies/Icon Zombies/ConeheadZombie.png");
                break;
            case BUCKETHEADZOMBIEBUTTON:
                imageIcon = new ImageIcon(
                        "ImagePvZ/Zombies/Zombie List + Icon Zombies/Icon Zombies/BucketheadZombie.png");
                break;
            case SCREENDOORZOMBIEBUTTON:
                imageIcon = new ImageIcon(
                        "ImagePvZ/Zombies/Zombie List + Icon Zombies/Icon Zombies/ScreenDoorZombie.png");
                break;
            case FOOTBALLZOMBIEBUTTON:
                imageIcon = new ImageIcon(
                        "ImagePvZ/Zombies/Zombie List + Icon Zombies/Icon Zombies/FootballZombie.png");
                break;
            case POLEVAULTINGZOMBIEBUTTON:
                imageIcon = new ImageIcon(
                        "ImagePvZ/Zombies/Zombie List + Icon Zombies/Icon Zombies/PoleVaultingZombie.png");
                break;
            case DUCKYTUBEZOMBIEBUTTON:
                imageIcon = new ImageIcon(
                        "ImagePvZ/Zombies/Zombie List + Icon Zombies/Icon Zombies/DuckyTubeZombie.png");
                break;
            case DOLPHINERIDERZOMBIEBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie List + Icon Zombies/Icon Zombies/DolphineRiderZombie.png");
                break;

            case GARGANTUARZOMBIEBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie List + Icon Zombies/Icon Zombies/GargantuarZombie.png");
                break;

            case IMPZOMBIEBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/Zombies/Zombie List + Icon Zombies/Icon Zombies/ImpZombie.png");
                break;

            // Help Button
            case MENUBACKBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/GameFrame/MenuButton.png");
                break;
            case MENUHELPBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/GameFrame/menu.png");
                break;
            case NEXTHELPBUTTON:                
                imageIcon = new ImageIcon("ImagePvZ/GameFrame/next.png");
                break;
            case BACKHELPBUTTON:
                imageIcon = new ImageIcon("ImagePvZ/GameFrame/back.png");
                break;

            // Inventory Button
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
            case LOSEGAME:
                imageIcon = new ImageIcon("ImagePvZ/GameFrame/LosePage.png");
                break;
            case WINGAME:
                imageIcon = new ImageIcon("ImagePvZ/GameFrame/WinPage.png");
                break;
            default:
                break;
        }
        return imageIcon;

    }

}
