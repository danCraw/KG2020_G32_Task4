package kg2019examples_task4threedimensions.models.geometry.side;

import kg2019examples_task4threedimensions.models.geometry.Side;
import kg2019examples_task4threedimensions.models.geometry.side.polygons.Pentagon;
import kg2019examples_task4threedimensions.models.geometry.side.polygons.Triangle;
import kg2019examples_task4threedimensions.models.geometry.side.polygons.Square;
import kg2019examples_task4threedimensions.models.math.Vector3;

import java.util.Collection;

public class SideFactory {
    public static Side getFace(Collection<Vector3> c, int numOfSide){
        return switch (numOfSide) {
            case 3 -> new Triangle(c);
            case 4 -> new Square(c);
            case 5 -> new Pentagon(c);
            default -> null;
        };
    }
}
