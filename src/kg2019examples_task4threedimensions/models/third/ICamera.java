/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task4threedimensions.models.third;

import kg2019examples_task4threedimensions.models.math.Vector3;

/**
 * Описывает основную функциональность камеры - превращение координат 
 * из мировой системы координат в систему координат камеры.
 * @author Alexey
 */
public interface ICamera {
    /**
     * Преобразует точку из мировой системы координат в систему координат камеры
     * @param v преобразуемая точка
     * @return новая точка
     */
    public Vector3 w2s(Vector3 v);
}
