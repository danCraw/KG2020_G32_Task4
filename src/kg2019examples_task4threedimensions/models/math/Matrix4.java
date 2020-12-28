/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task4threedimensions.models.math;

/**
 * Класс описывающий матрицу 4 на 4.
 * Такие матрицы можно использовать для применения матричных преобразований
 * @author Alexey
 */
public class Matrix4 {
    private float[] matrix;
    
    /**
     * Создаёт экземпляр матрицы на основе двумерного массива.
     * В рамках данной реализации нет необходимых проверок на
     * корректность входных аргументов.
     * @param m входная матрица.
     */
    public Matrix4(float[][] m) {
        matrix = new float[16];
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                matrix[i * 4 + j] = m[i][j];
    }
    
    /**
     * Скрытый конструктор, который создаёт экземпляр матрицы на основе
     * одномерного массива без дополнительных проверок.
     * Предполагается, что массив будет иметь правильный размер.
     * @param arr исходный массив.
     */
    private Matrix4(float[] arr) {
        matrix = arr;
    }
    
    /**
     * Возвращает значение элемента матрицы по заданным индексам
     * @param row номер строки
     * @param col номер столбца
     * @return значение соответствующей ячейки
     */
    public float getAt(int row, int col) {
        return matrix[row * 4 + col];
    }
    
    /**
     * Устанавливает значение элемента матрицы по заданным индексам
     * @param row номер строки
     * @param col номер столбца
     * @param value присваиваемое значение.
     */
    public void setAt(int row, int col, float value) {
        matrix[row * 4 + col] = value;
    }
    
    /**
     * Метод, создающий новую нулевую матрицу
     * @return созданная матрица, состоящая из нулей.
     */
    public static Matrix4 zero() {
        return new Matrix4(new float[16]);
    }
    
    /**
     * Метод, создающий матрицу, состоящую из единиц, расположенных на главной диагонали, и нулей
     * @return единичная матрица
     */
    public static Matrix4 one() {
        Matrix4 m = zero();
        for (int i = 0; i < 4; i++)
            m.setAt(i, i, 1);
        return m;
    }
    
    /**
     * Умножает матрицу на число
     * @param number число, на которое умножается матрица
     * @return новая матрица, являющаяся результатом умножения текущей матрицы на число.
     */
    public Matrix4 mul(float number) {
        float[] arr = new float[16];
        for (int i = 0; i < arr.length; i++)
            arr[i] = this.matrix[i] * number;
        return new Matrix4(arr);
    }
    
    /**
     * Умножает матрицу(M) на вектор(V) столбец справа M x V .
     * @param v вектор, на который надо умножить матрицу
     * @return новый вектор-столбец, получившийся в результате умножения текущей матрицы на вектор.
     */
    public Vector4 mul(Vector4 v) {
        float[] arr = new float[4];
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                arr[i] += this.getAt(i, j) * v.at(j);
        return new Vector4(arr[0], arr[1], arr[2], arr[3]);
    }
    
    /**
     * Умножает текущую матрицу(T) на другую матрицу(M) справа T x M.
     * @param m другая матрица
     * @return новая матрица, являющаяся результатом умножения текущей матрицы на другую.
     */
    public Matrix4 mul(Matrix4 m) {
        Matrix4 r = zero();
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                for (int k = 0; k < 4; k++)
                    r.setAt(i, j, r.getAt(i, j) + 
                            this.getAt(i, k) * m.getAt(k, j));
        return r;
    }
}
