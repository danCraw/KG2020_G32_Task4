package kg2019examples_task4threedimensions.models.models;

import kg2019examples_task4threedimensions.models.math.Vector3;
import kg2019examples_task4threedimensions.models.models.NewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static java.lang.StrictMath.sqrt;

public class Tetrahedron extends NewModel {

    public Tetrahedron(double radius) {
        super(radius);
        side = new ArrayList<>(4);
        vertices = new HashMap<>(4);
        computeAllVertices();
        createAllFaces();
    }

    @Override
    protected void computeAllVertices() {
        double size = getRadius();
        Vector3 A = new Vector3(0, size * sqrt(2. / 3.), 0);
        Vector3 B = new Vector3(size / sqrt(3), 0, 0);
        Vector3 C = new Vector3(-size / (2 * sqrt(3)), 0, -size / 2);
        Vector3 D = new Vector3(-size / (2 * sqrt(3)), 0, size / 2);

        vertices.put('A', A);
        vertices.put('B', B);
        vertices.put('C', C);
        vertices.put('D', D);
    }

    protected void createAllFaces() {
        super.createAllFaces(Arrays.asList("ABD", "ACD", "ABC", "CBD"), 3);
    }
}
