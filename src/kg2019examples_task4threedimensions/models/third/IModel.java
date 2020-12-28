/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task4threedimensions.models.third;

import java.util.List;

/**
 * Описывает в общем виде любую модель
 * @author Alexey
 */
public interface IModel {
    /**
     * Любая модель - это набор полилиний.
     * @return Список полилиний модели.
     */
    List<PolyLine3D> getLines();
}
