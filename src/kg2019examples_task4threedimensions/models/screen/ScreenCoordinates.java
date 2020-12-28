/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task4threedimensions.models.screen;

import java.util.Collection;

/**
 * Хранит составляющие экранных координат раздельно.
 * @author Alexey
 */
public class ScreenCoordinates {
    private int[] xx, yy;
    /**
     * Создаёт экземпляр на основе коллекции экранных точек
     * @param points точки
     */
    public ScreenCoordinates(Collection<ScreenPoint> points) {
        xx = new int[points.size()];
        yy = new int[points.size()];
        int i = 0;
        for (ScreenPoint p : points) {
            xx[i] = p.getI();
            yy[i] = p.getJ();
            i++;
        }
    }

    public int[] getXx() {
        return xx;
    }

    public int[] getYy() {
        return yy;
    }
    
    /**
     * Количество точек
     * @return количество точек
     */
    public int size() {
        return xx.length;
    }
}
