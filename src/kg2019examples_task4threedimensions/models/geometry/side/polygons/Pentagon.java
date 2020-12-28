package kg2019examples_task4threedimensions.models.geometry.side.polygons;

import kg2019examples_task4threedimensions.models.geometry.Side;
import kg2019examples_task4threedimensions.models.math.Vector3;

import java.util.Collection;

public class Pentagon extends Side {

    public Pentagon(Collection<Vector3> vertices) {
        super(vertices, 5);
    }
}
