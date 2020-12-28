package kg2019examples_task4threedimensions.models.geometry;

import kg2019examples_task4threedimensions.models.math.Vector3;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import static kg2019examples_task4threedimensions.models.geometry.Edge.createEdges;

/*
Класс, описывающий грань
 */
public class Side implements Cloneable{

    private List<Vector3> vertices;

    private List<Edge> edges;

    private int num;

    public Side(Collection<Vector3> vertices, int num) {
        this.vertices = new ArrayList<>(vertices);
        this.edges = createEdges(this.vertices, num);
        this.num = num;
    }
    public List<Vector3> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vector3> vertices) {
        this.vertices = vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    @Override
    public Side clone() {
        Side side = null;
        try {
            side = (Side) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        side.vertices = vertices.stream().map(Vector3::clone).collect(Collectors.toCollection(ArrayList::new));
        side.edges = edges.stream().map(Edge::clone).collect(Collectors.toCollection(ArrayList::new));
        return side;
    }

    public int getNum() {
        return num;
    }

}
