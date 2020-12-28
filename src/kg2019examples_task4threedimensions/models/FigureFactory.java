package kg2019examples_task4threedimensions.models;

import kg2019examples_task4threedimensions.models.models.*;

public class FigureFactory {

    public static NewModel createFigure(Figures type, double radius) {
        switch (type){
            case CUBE:
                return new Cube(radius);
            case OCTAHEDRON:
                return new Octahedron(radius);
            case ICOSAHEDRON:
                return new Icosahedron(radius);
            case TETRAHEDRON:
                return new Tetrahedron(radius);
            case DODECAHEDRON:
                return new Dodecahedron(radius);
            default:
                return null;
        }
    }
}
