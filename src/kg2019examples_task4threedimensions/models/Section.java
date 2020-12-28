package kg2019examples_task4threedimensions.models;

import kg2019examples_task4threedimensions.models.geometry.Side;
import kg2019examples_task4threedimensions.models.math.Vector3;
import kg2019examples_task4threedimensions.models.models.NewModel;

import java.util.Arrays;
import java.util.List;

public class Section extends NewModel {
    private List<Vector3> list;

    public Section(List<Vector3> list) {
        super(0);
        this.list = list;
        side = Arrays.asList(new Side(list, 0));
    }

    @Override
    protected void computeAllVertices() {
    }
}
