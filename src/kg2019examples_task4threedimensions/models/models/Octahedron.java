package kg2019examples_task4threedimensions.models.models;

import kg2019examples_task4threedimensions.models.math.Vector3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Octahedron extends NewModel {

    public Octahedron(double radius) {
        super(radius);
        vertices = new HashMap<>(6);
        side = new ArrayList<>(8);
        computeAllVertices();
        createAllFaces();
    }

    @Override
    protected void computeAllVertices() {
        double size = getRadius();

        Vector3 A = new Vector3(0, size, 0);
        Vector3 B = new Vector3(size, 0, 0);
        Vector3 C = new Vector3(0, 0, -size);
        Vector3 D = new Vector3(-size, 0, 0);
        Vector3 E = new Vector3(0, 0, size);
        Vector3 F = new Vector3(0, -size, 0);

        vertices.put('A', A);
        vertices.put('B', B);
        vertices.put('C', C);
        vertices.put('D', D);
        vertices.put('E', E);
        vertices.put('F', F);
    }

    protected void createAllFaces() {
        super.createAllFaces(Arrays.asList("ABC", "ACD", "ABE", "AED", "FEB", "FED", "FBC", "FCD"), 3);
    }
}
