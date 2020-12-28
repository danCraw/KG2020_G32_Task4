package kg2019examples_task4threedimensions.models.models;

import kg2019examples_task4threedimensions.models.math.Vector3;
import kg2019examples_task4threedimensions.models.models.NewModel;

import java.util.*;

import static java.lang.StrictMath.*;

public class Dodecahedron extends NewModel {

    public Dodecahedron(double radius) {
        super(radius);
        side = new ArrayList<>(12);
        vertices = new HashMap<>(20);
        computeAllVertices();
        createAllFaces();
    }

    protected void createAllFaces(){
        super.createAllFaces(Arrays.asList("ABCDE", "FAEJO", "EDINJ", "PQLGK", "RMINS", "STOJN",
                "FKPTO", "PQRST", "DCHMI", "BCHLG", "ABGKF", "MHLQR"), 5);
    }

    @Override
    protected void computeAllVertices() {

        double size = getRadius();
        double t1 = 2.0 * Math.PI / 5.0;
        double t2 = Math.PI / 10.0;
        double t3 = 3.0 * Math.PI / 10.0;
        double t4 = Math.PI / 5.0;
        double d1 = size / 2.0 / sin(t4);
        double d2 = d1 * cos(t4);
        double d3 = d1 * cos(t2);
        double d4 = d1 * sin(t2);
        double Fx =
                (size * size - (2.0 * d3) * (2.0 * d3) -
                        (d1 * d1 - d3 * d3 - d4 * d4)) /
                        (2.0 * (d4 - d1));
        double d5 = sqrt(0.5 *
                (size * size + (2.0 * d3) * (2.0 * d3) -
                        (d1 - Fx) * (d1 - Fx) -
                        (d4 - Fx) * (d4 - Fx) - d3 * d3));
        double Fy = (Fx * Fx - d1 * d1 - d5 * d5) / (2.0 * d5);
        double Ay = d5 + Fy;

        Vector3 A = new Vector3(d1, Ay, 0);
        Vector3 B = new Vector3(d4, Ay, d3);
        Vector3 C = new Vector3(-d2, Ay, size / 2);
        Vector3 D = new Vector3(-d2, Ay, -size / 2);
        Vector3 E = new Vector3(d4, Ay, -d3);
        Vector3 F = new Vector3(Fx, Fy, 0);
        Vector3 G = new Vector3(Fx * sin(t2), Fy,
                Fx * cos(t2));
        Vector3 H = new Vector3(-Fx * sin(t3), Fy,
                Fx * cos(t3));
        Vector3 I = new Vector3(-Fx * sin(t3), Fy,
                -Fx * cos(t3));
        Vector3 J = new Vector3(Fx * sin(t2), Fy,
                -Fx * cos(t2));
        Vector3 K = new Vector3(Fx * sin(t3), -Fy,
                Fx * cos(t3));
        Vector3 L = new Vector3(-Fx * sin(t2), -Fy,
                Fx * cos(t2));
        Vector3 M = new Vector3(-Fx, -Fy, 0);
        Vector3 N = new Vector3(-Fx * sin(t2), -Fy,
                -Fx * cos(t2));
        Vector3 O = new Vector3(Fx * sin(t3), -Fy,
                -Fx * cos(t3));
        Vector3 P = new Vector3(d2, -Ay, size / 2);
        Vector3 Q = new Vector3(-d4, -Ay, d3);
        Vector3 R = new Vector3(-d1, -Ay, 0);
        Vector3 S = new Vector3(-d4, -Ay, -d3);
        Vector3 T = new Vector3(d2, -Ay, -size / 2);

        vertices.put('A', A);
        vertices.put('B', B);
        vertices.put('C', C);
        vertices.put('D', D);
        vertices.put('E', E);
        vertices.put('F', F);
        vertices.put('G', G);
        vertices.put('H', H);
        vertices.put('I', I);
        vertices.put('J', J);
        vertices.put('K', K);
        vertices.put('L', L);
        vertices.put('M', M);
        vertices.put('N', N);
        vertices.put('O', O);
        vertices.put('P', P);
        vertices.put('Q', Q);
        vertices.put('R', R);
        vertices.put('S', S);
        vertices.put('T', T);
    }
}
