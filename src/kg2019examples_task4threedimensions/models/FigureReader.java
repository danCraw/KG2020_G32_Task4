package kg2019examples_task4threedimensions.models;

import kg2019examples_task4threedimensions.models.geometry.Plane;
import kg2019examples_task4threedimensions.models.models.NewModel;

public class FigureReader {
    private final Plane plane;
    private final Intersector intersector;

    public FigureReader(Plane plane) {
        this.plane = plane;
        this.intersector = new Intersector(plane);
    }

    public NewModel getCurrentPart(NewModel solid, Parts part) throws CloneNotSupportedException {
        if (solid == null || plane == null)
            return null;
        return intersector.division(solid, part);
    }

}
