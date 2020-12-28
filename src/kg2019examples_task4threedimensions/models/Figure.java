package kg2019examples_task4threedimensions.models;

import kg2019examples_task4threedimensions.models.models.NewModel;

public class Figure extends NewModel {

    public Figure(NewModel model) throws CloneNotSupportedException {
        super(model.getRadius());
        NewModel clone = model.clone();
        this.side = clone.side;
    }

    @Override
    protected void computeAllVertices() {

    }
}
