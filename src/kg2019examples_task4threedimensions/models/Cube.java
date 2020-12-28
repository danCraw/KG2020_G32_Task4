package kg2019examples_task4threedimensions.models;

import kg2019examples_task4threedimensions.models.math.Vector3;
import kg2019examples_task4threedimensions.models.models.NewModel;


import java.util.*;

public class Cube extends NewModel {

    public Cube(double radius) {
        super(radius);
        side = new ArrayList<>(6);
        vertices = new HashMap<>(8);
        computeAllVertices();
        createAllFaces();
    }

    @Override
    protected void computeAllVertices() {
        double size = getRadius();

        Vector3 A = new Vector3(size, size, size);
        Vector3 B  = new Vector3(size, size, -size);
        Vector3 C = new Vector3(-size, size, -size);
        Vector3 D = new Vector3(-size, size, size);
        Vector3 E = new Vector3(size, -size, size);
        Vector3 F = new Vector3(size, -size, -size);
        Vector3 G = new Vector3(-size, -size, -size);
        Vector3 H = new Vector3(-size, -size, size);

        vertices.put('A', A);
        vertices.put('B', B);
        vertices.put('C', C);
        vertices.put('D', D);
        vertices.put('E', E);
        vertices.put('F', F);
        vertices.put('G', G);
        vertices.put('H', H);
    }


    protected void createAllFaces() {
        super.createAllFaces(Arrays.asList("ABCD", "ABFE", "ADHE", "EFGH", "GCDH", "GFBC"), 4);
    }
}
