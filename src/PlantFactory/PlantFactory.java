package PlantFactory;
import Plant.*;
import Sun.Sun;

import java.awt.*;
import java.util.Objects;

public class PlantFactory {

    public Plant CreatePlant(PlantType plantType, Point position) {
        switch (plantType) {
            case SUNFLOWERTYPE:
                return new Sunflower(position);
            case CHERRYBOMBTYPE:
                return new CherryBomb(position);    
            case JALAPENOTYPE:
                return new Jalapeno(position);
            case LILYPADTYPE:
                return new Lilypad(position);    
            case PEASHOOTERTYPE:
                return new Peashooter(position);
            case REPEATERTYPE:
                return new Repeater(position);
            case SNOWPEATYPE:
                return new SnowPea(position);
            case SQUASHTYPE:
                return new Squash(position);
            case TALLNUTTYPE:
                return new Tallnut(position);
            case WALLNUTTYPE:
                return new Wallnut(position);
            default:
                return new Sunflower(position);
        }
    }

    public PlantType getPlantType(Plant plant) {
        if (plant instanceof Sunflower) {
            return PlantType.SUNFLOWERTYPE;
        } else {
            return PlantType.SUNFLOWERTYPE;
        }
    }
}
