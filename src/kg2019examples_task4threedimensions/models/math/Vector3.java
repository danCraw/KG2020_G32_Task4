/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task4threedimensions.models.math;

import java.util.Arrays;

import static java.lang.StrictMath.abs;

/**
 * Класс, хранящий трёхмерный вектор / точку в трёхмерном пространстве.
 * @author Alexey
 */
public class Vector3 implements Cloneable{
    private float[] values; /*Значения хранятся в виде массива из трёх элементов*/
    
    /**
     * Создаёт экземпляр вектора на основе значений трёх составляющих
     * @param x первая составляющая, описывающая X-координату
     * @param y вторая составляющая, описывающая Y-координату
     * @param z третья составляющая, описывающая Z-координату
     */

    public Vector3(float x, float y, float z) {
        values = new float[]{x, y, z};
    }

    public Vector3(double x, double y, double z) {
        values = new float[]{(float) x, (float) y, (float) z};
    }
    /**
     * X-составляющая вектора
     * @return X-составляющая вектора
     */
    public float getX() {
        return values[0];
    }

    /**
     * Y-составляющая вектора
     * @return Y-составляющая вектора
     */
    public float getY() {
        return values[1];
    }

    /**
     * Z-составляющая вектора
     * @return Z-составляющая вектора
     */
    public float getZ() {
        return values[2];
    }
    
    /**
     * Метод, возвращающий составляющую вектора по порядковому номеру
     * @param idx порядковый номер
     * @return значение составляющей вектора
     */
    public float at(int idx) {
        return values[idx];
    }
    
    public static final float EPSILON = 1e-6f;
    /**
     * Метод, возвращающий длину вектора
     * @return длина вектора
     */
    public float length() {
        float lenSqr = values[0] * values[0] + values[1] * values[1] + values[2] * values[2];
        if (lenSqr < EPSILON)
            return 0;
        return (float)Math.sqrt(lenSqr);
    }

    public Vector3 sum(Vector3 vector3){
        return new Vector3(this.getX() + vector3.getX(), this.getY() + vector3.getY(), this.getZ() + vector3.getZ());
    }
    
    public Vector3 subtractVectors(Vector3 vector3){
        return new Vector3(this.getX() - vector3.getX(), this.getY() - vector3.getY(), this.getZ() - vector3.getZ());
    }

    public float scalarProduct(Vector3 vector3) {
        return this.getX() * vector3.getX() + this.getY() * vector3.getY() + this.getZ() * vector3.getZ();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector3 vector3 = (Vector3) o;

        //return Arrays.equals(values, vector3.values);
        return abs(getX() - vector3.getX()) < EPSILON
                && abs(getY() - vector3.getY()) < EPSILON
                && abs(getZ() - vector3.getZ()) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    @Override
    public Vector3 clone(){
        return new Vector3(this.getX(), this.getY(), this.getZ());
    }

    public boolean compareTo(Vector3 value) {
        return getX() == value.getX() || getY() == value.getY() || getZ() == value.getZ();
    }
}
