package PlantFactory;
import Plant.*;

import java.awt.*;

public class PlantFactory {

    public Plant CreatePlant(PlantType plantType, Point position) {
        switch (plantType) {
            case SUNFLOWERTYPE:
                return new Sunflower(position);
            default:
                return new Sunflower(position);
        }
    }
}
