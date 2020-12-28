package kg2019examples_task4threedimensions.models;

import kg2019examples_task4threedimensions.models.geometry.Edge;
import kg2019examples_task4threedimensions.models.geometry.Plane;
import kg2019examples_task4threedimensions.models.geometry.Side;
import kg2019examples_task4threedimensions.models.math.Vector3;
import kg2019examples_task4threedimensions.models.models.NewModel;
import org.apache.commons.math3.util.Pair;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Intersector {
    //секущая плоскость
    private Plane plane;

    public Intersector(Plane plane) {
        this.plane = plane;
    }

    public NewModel division(NewModel model, Parts parts) throws CloneNotSupportedException {
        Figure part = new Figure(model);

        switch (parts){
            case fullFigure:
                return model;
            case partTwo:
                return getSection(part.intersectWith(plane));
            case section:

            case partOne:

            default:
                return null;
        }
    }

    private NewModel getSection(Map<Side, List<Pair<Edge, Vector3>>> faceListMap){
        Queue<Edge> queueEdges = new LinkedList<>();
        for (List<Pair<Edge, Vector3>> l : faceListMap.values()) {
            if(l.size() != 2)
                continue;
            queueEdges.add(new Edge(l.get(0).getValue(), l.get(1).getValue()));
        }

        ArrayList<Edge> temp = new ArrayList<>();
        temp.add(queueEdges.poll());
        int i = 0;
        while (!queueEdges.isEmpty()) {
            Edge e = queueEdges.poll();
            if (temp.get(i).getEndVector().equals(e.getStartVector())) {
                temp.add(e);
                i++;
            } else {
                Edge e1 = e.reverse();
                if (temp.get(i).getEndVector().equals(e1.getStartVector())) {
                    temp.add(e1);
                    i++;
                }else
                    queueEdges.add(e);
            }
        }
        ArrayList<Vector3> res = temp.stream().map(Edge::getStartVector).collect(Collectors.toCollection(ArrayList::new));
        return new Section(res);
    }

    private void getPart(Figure figure, Map<Side, List<Pair<Edge, Vector3>>> points, Predicate<Vector3> predicate, Predicate<Vector3> predicate1) {
        for (Map.Entry<Side, List<Pair<Edge, Vector3>>> kv : points.entrySet()) {
            List<Vector3> temp = kv.getKey().getVertices().stream().filter(predicate).collect(Collectors.toCollection(ArrayList::new));
            if(temp.isEmpty())
                continue;
            new ArrayList<>(temp).forEach(point -> {
                        kv.getValue().forEach(pair -> {
                            if (pair.getKey().getEndVector().equals(point)) {
                                Vector3 val = pair.getValue();
                                int idx = temp.indexOf(point);
                                temp.add(idx, val);
                                pair.getKey().setFrom(val);
                            } else if (pair.getKey().getStartVector().equals(point)) {
                                Vector3 val = pair.getValue();
                                int idx = temp.indexOf(point);
                                temp.add(idx + 1, val);
                                pair.getKey().setTo(val);
                            }
                        });
                    });
            kv.getKey().setVertices(temp);
        }
        figure.setFaces(figure.getFaces()
                .stream()
                .filter(face -> {
                    return face.getVertices()
                            .stream()
                            .filter(predicate1).count() == face.getVertices().size();
                })
                .collect(Collectors.toList())
        );
    }
}
