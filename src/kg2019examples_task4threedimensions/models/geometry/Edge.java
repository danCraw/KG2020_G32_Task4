package kg2019examples_task4threedimensions.models.geometry;

import kg2019examples_task4threedimensions.models.math.Vector3;

import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.abs;


/**
 * Класс, описывающий ребро многогранника
 */
public class Edge implements Cloneable{

    private Vector3 from, to;

    public Edge(Vector3 from, Vector3 to) {
        this.from = from;
        this.to = to;
    }

    public Vector3 getStartVector() {
        return from;
    }

    public Vector3 getEndVector() {
        return to;
    }


     // Метод,которые генерирует ребра по вершинам
     // c множество вершин
     // num размерность правильного n-угольника
     // @return множество ребер грани

    public static List<Edge> createEdges(List<Vector3> c, int num) {
        List<Edge> edges = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            if (i == num - 1) {
                edges.add(new Edge(c.get(i), c.get(0)));
                break;
            }
            edges.add(new Edge(c.get(i), c.get(i + 1)));
        }
        return edges;
    }

    public boolean intersectWithAllPlanes() {
        return intersectWith(new Plane(1, 0, 0, 0)) == null &&
                intersectWith(new Plane(0, 1, 0, 0)) == null &&
                        intersectWith(new Plane(0, 0, 1, 0 )) == null;
    }

    public Vector3 intersectWith(Plane p) {

        float t = -(p.getNormal().scalarProduct(from) + p.getD()) / (p.getNormal().scalarProduct(to.subtractVectors(from)));
        float x = from.getX() + (to.getX() - from.getX()) * t;
        float y = from.getY() + (to.getY() - from.getY()) * t;
        float z = from.getZ() + (to.getZ() - from.getZ()) * t;

        float x1 = from.getX();
        float y1 = from.getY();
        float z1 = from.getZ();
        float x2 = to.getX();
        float y2 = to.getY();
        float z2 = to.getZ();

        float AB = (float) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) + (z2 - z1) * (z2 - z1));
        float AP = (float) Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1) + (z - z1) * (z - z1));
        float PB = (float) Math.sqrt((x2 - x) * (x2 - x) + (y2 - y) * (y2 - y) + (z2 - z) * (z2 - z));

        if (abs(AB - (AP + PB)) < 1e-6)
            return new Vector3(x, y, z);
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (from != null ? !from.equals(edge.from) : edge.from != null) return false;
        return to != null ? to.equals(edge.to) : edge.to == null;
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        return result;
    }

    public void setFrom(Vector3 from) {
        this.from = from;
    }

    public void setTo(Vector3 to) {
        this.to = to;
    }

    @Override
    public Edge clone() {
        return new Edge(this.from.clone(), this.to.clone());
    }

    public Edge reverse() {
        return new Edge(to, from);
    }
}
