/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task4threedimensions.models.math;

/**
 * Класс, представляющий четырёхмерный вектор для проведения матричных вычислений над трёхмерными точками.
 * @author Alexey
 */
public class Vector4 {
    private float[] values; /*Значения хранятся в виде массива из трёх элементов*/
    
    /**
     * Создаёт экземпляр вектора на основе значений четырёх составляющих
     * @param x первая составляющая, описывающая X-координату
     * @param y вторая составляющая, описывающая Y-координату
     * @param z третья составляющая, описывающая Z-координату
     * @param w четвёртая составляющая, описывающая нормализующее значение
     */
    public Vector4(float x, float y, float z, float w) {
        values = new float[]{x, y, z, w};
    }
    public Vector4(double x, double y, double z, double w) {
        values = new float[]{(float) x, (float) y, (float) z, (float) w};
    }
    
    /**
     * Создаёт экземпляр вектора на основе значений трёх составляющих.
     * Четвёртая берётся равной нулю.
     * @param x первая составляющая, описывающая X-координату
     * @param y вторая составляющая, описывающая Y-координату
     * @param z третья составляющая, описывающая Z-координату
     */
    public Vector4(float x, float y, float z) {
        this(x, y, z, 0);
    }
    
    /**
     * Создаёт экземпляр четырёхмерного вектора на основе трёхмерного вектора
     * и четвёртой составляющей W.
     * @param v экземпляр трёхмерного вектора
     * @param w четвёртая составляющая.
     */
    public Vector4(Vector3 v, float w) {
        this(v.getX(), v.getY(), v.getZ(), w);
    }
    
    /**
     * Создаёт экземпляр четырёхмерного вектора на основе трёхмерного вектора
     * Четвёртая составляющая W принимается равной нулю.
     * @param v исходный трёхмерный вектор.
     */
    public Vector4(Vector3 v) {
        this(v, 0);
    }
    
    /**
     * Скрытый конструктор, который создаёт вектор на основе массива.
     * Данный конструктор будет удобен для использования внутри класса.
     * В связи с этим, данный конструктор просто сохраняет принятый массив
     * без дополнительных обработок и проверок.
     * @param array массив с данными
     */
    private Vector4(float[] array) {
        this.values = array;
    }
    
    /**
     * Создаёт новый четырёхмерный вектор, все компоненты которого равны нулю.
     * @return нулевой четырёхмерный вектор.
     */
    public static Vector4 zero() {
        return new Vector4(new float[4]);
    }
    
    /**
     * Умножает текущий вектор на число.
     * @param number число, на которое умножается текущий вектор
     * @return новый вектор, который является результатом умножения.
     */
    public Vector4 mul(float number) {
        float[] array = new float[4];
        for (int i = 0; i < array.length; i++)
            array[i] = number * this.at(i);
        return new Vector4(array);
    }
    
    /**
     * Складывает текущий вектор с другим.
     * @param other вектор, с которым происходит сложение
     * @return результирующий вектор.
     */
    public Vector4 add(Vector4 other) {
        float[] array = new float[4];
        for (int i = 0; i < array.length; i++)
            array[i] = this.at(i) + other.at(i);
        return new Vector4(array);
    }
    
    /**
     * Очень маленькое число для сравнений
     */
    private static final float EPSILON = 1e-10f;
    
    /**
     * Возвращает нормализованный по W четырёхмерный вектор.
     * Если W равен 0, то возвращается копия исходного вектора.
     * Если W не равен 1, то возвращается новый вектор, составляющие которого разделены на W.
     * @return новый нормализованный вектор.
     */
    public Vector4 normalized() {
        if (Math.abs(getW()) < EPSILON)
            return new Vector4(this.getX(), this.getY(), this.getZ(), 0);
        return new Vector4(this.getX() / this.getW(), this.getY() / this.getW(), this.getZ() / this.getW(), 1);
    }
    
    /**
     * Создаёт трёхмерный вектор, X, Y и Z составляющие которого равны
     * соответствующим значениям нормализованного четырёхмерного вектора.
     * @return новый трёхмерный вектор.
     */
    public Vector3 asVector3() {
        Vector4 n = this.normalized();
        return new Vector3(n.getX(), n.getY(), n.getZ());
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
     * W-составляющая вектора
     * @return W-составляющая вектора
     */
    public float getW() {
        return values[3];
    }
    
    /**
     * Метод, возвращающий составляющую вектора по порядковому номеру
     * @param idx порядковый номер
     * @return значение составляющей вектора
     */
    public float at(int idx) {
        return values[idx];
    }
}
