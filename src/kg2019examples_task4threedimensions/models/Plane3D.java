package kg2019examples_task4threedimensions.models;


import kg2019examples_task4threedimensions.models.math.Vector3;
import kg2019examples_task4threedimensions.models.third.IModel;
import kg2019examples_task4threedimensions.models.geometry.Plane;
import kg2019examples_task4threedimensions.models.third.PolyLine3D;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Plane3D implements IModel {
    private Plane plane;

    public Plane3D(Plane plane) {
        this.plane = plane;
    }

    @Override
    public List<PolyLine3D> getLines() {
        LinkedList<PolyLine3D> lines = new LinkedList<>();
        Vector3 a = null;
        float b = 0;

        if (Float.compare(plane.getC(), 0) != 0) {
            a = plane.getABD();
            b = plane.getC();

            double res1 = -a.scalarProduct(new Vector3(-2, 2, 1)) / b;
            double res2 = -a.scalarProduct(new Vector3(-2, -2, 1)) / b;
            double res3 = -a.scalarProduct(new Vector3(2, -2, 1)) / b;
            double res4 = -a.scalarProduct(new Vector3(2, 2, 1)) / b;
            lines.add(new PolyLine3D(Arrays.asList(
                    new Vector3(-2, 2, res1),
                    new Vector3(-2, -2, res2),
                    new Vector3(2, -2, res3),
                    new Vector3(2, 2, res4)), true));


        }else{
            if(Float.compare(plane.getA(), 0) == 0 || Float.compare(plane.getB(), 0) != 0){
                a = plane.getACD();
                b = plane.getB();
                double res1 = -a.scalarProduct(new Vector3(-2, 2, 1)) / b;
                double res2 = -a.scalarProduct(new Vector3(-2, -2, 1)) / b;
                double res3 = -a.scalarProduct(new Vector3(2, -5, 1)) / b;
                double res4 = -a.scalarProduct(new Vector3(2, 2, 1)) / b;
                lines.add(new PolyLine3D(Arrays.asList(
                        new Vector3(-2, res1, 2),
                        new Vector3(-2, res2, -2),
                        new Vector3(2, res3, -2),
                        new Vector3(2, res4, 2)), true));
            }else if(Float.compare(plane.getB(), 0) == 0){
                a = plane.getBCD();
                b = plane.getA();
                double res1 = -a.scalarProduct(new Vector3(-2, 2, 1)) / b;
                double res2 = -a.scalarProduct(new Vector3(-2, -2, 1)) / b;
                double res3 = -a.scalarProduct(new Vector3(2, -2, 1)) / b;
                double res4 = -a.scalarProduct(new Vector3(2, 2, 1)) / b;
                lines.add(new PolyLine3D(Arrays.asList(
                        new Vector3( res1, -2, 2),
                        new Vector3( res2, -2,-2),
                        new Vector3( res3, 2,-2),
                        new Vector3( res4, 2,2)), true));
            }
        }

        return lines;
    }
}
