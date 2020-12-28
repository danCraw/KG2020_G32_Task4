/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task4threedimensions.models.draw;

import java.util.Collection;
import kg2019examples_task4threedimensions.models.third.PolyLine3D;

/**
 * Интерфейс, описывающий в общем виде процесс рисования полилинии
 * @author Alexey
 */
public interface IDrawer {
    /**
     * Очищает область заданным цветом
     * @param color цвет
     */
    public void clear(int color);
    
    /**
     * Рисует все полилинии
     * @param polyline набор рисуемых полилиний.
     */
    public void draw(Collection<PolyLine3D> polyline);
}
