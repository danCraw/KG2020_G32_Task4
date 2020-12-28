package kg2019examples_task4threedimensions.models.models;

import kg2019examples_task4threedimensions.models.geometry.Edge;
import kg2019examples_task4threedimensions.models.geometry.Side;
import kg2019examples_task4threedimensions.models.geometry.side.SideFactory;
import kg2019examples_task4threedimensions.models.math.Vector3;
import kg2019examples_task4threedimensions.models.third.IModel;
import kg2019examples_task4threedimensions.models.geometry.Plane;
import kg2019examples_task4threedimensions.models.third.PolyLine3D;
import org.apache.commons.math3.util.Pair;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public abstract class NewModel implements IModel, Cloneable {

    public List<Side> side;
    private double radius;

    protected Map<Character, Vector3> vertices;


    public NewModel(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public List<PolyLine3D> getLines() {
        return asPolyline(side);
    }

    private ArrayList<PolyLine3D> asPolyline(List<Side> list) {
        return list.stream().map(face -> new PolyLine3D(face.getVertices(), true)).collect(Collectors.toCollection(ArrayList::new));
    }

    protected abstract void computeAllVertices();

    protected void createAllFaces(List<String> list, int num) {
        for (String str: list) {
            List<Vector3> subList = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                subList.add(vertices.get(ch));
            }
            side.add(SideFactory.getFace(subList, num));
        }
    }

    public Map<Side, List<Pair<Edge, Vector3>>> intersectWith(Plane p){
        Map<Side, List<Pair<Edge, Vector3>>> points = new HashMap<>();
        for (Side side : this.side) {
            Vector3 temp = null;
            for (Edge edge : side.getEdges()) {
                Vector3 res = edge.intersectWith(p);
                if(res != null) {
                    if (res.equals(temp)) {
                        temp = null;
                        continue;
                    }
                    if (points.containsKey(side))
                        points.get(side).add(new Pair<>(edge, res));
                    else {
                        ArrayList<Pair<Edge, Vector3>> collection = new ArrayList<Pair<Edge, Vector3>>();
                        collection.add(new Pair<Edge, Vector3>(edge, res));
                        points.put(side, collection);
                    }
                    if (res.equals(edge.getStartVector()) || res.equals(edge.getEndVector())) {
                        temp = res;
                    }
                }
            }
        }
        return points;
    }

    @Override
    public NewModel clone() throws CloneNotSupportedException {
        NewModel model = (NewModel) super.clone();
        model.side = side.stream().map(Side::clone).collect(Collectors.toCollection(ArrayList::new));
        return model;
    }

    public List<Side> getFaces() {
        return side;
    }

    public void setFaces(List<Side> c) {
        this.side = c;
    }

}
