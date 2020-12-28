/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task4threedimensions.models.screen;

/**
 * Класс, описывающий координаты экранной точки.
 * @author Alexey
 */
public class ScreenPoint {
    int i, j;

    public ScreenPoint(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
    
}
