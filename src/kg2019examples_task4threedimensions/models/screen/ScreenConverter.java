/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task4threedimensions.models.screen;

import kg2019examples_task4threedimensions.models.math.Vector3;

/**
 * Класс, предоставляющий функциональность конвертирования реальных координат в экранные
 * @author Alexey
 */
public class ScreenConverter {
    double xr, yr, wr, hr;
    int ws, hs;

    public ScreenConverter(double xr, double yr, double wr, double hr, int ws, int hs) {
        this.xr = xr;
        this.yr = yr;
        this.wr = wr;
        this.hr = hr;
        this.ws = ws;
        this.hs = hs;
    }
    
    /**
     * Метод, преобразующий реальные трёхмерные координаты в экранные.
     * Z-составляющая при этом не учитывается
     * @param v исходная трёхмерная точка
     * @return результирующая экранная точка.
     */
    public ScreenPoint r2s(Vector3 v) {
        int i = (int)((v.getX() - xr) * ws / wr);
        int j = (int)((yr - v.getY()) * hs / hr);
        return new ScreenPoint(i, j);
    }
    
    /**
     * Метод, преобразующий экранные координаты в трёхмерные.
     * Z-составляющая при этом устанавливается в указанное значение
     * @param p исходная трёхмерная точка
     * @param z Z-составляющая
     * @return результирующая трёхмерная точка.
     */
    public Vector3 s2r(ScreenPoint p, float z) {
        double x = xr + p.getI() * wr / ws;
        double y = yr - p.getJ() * hr / hs;
        return new Vector3((float)x, (float)y, z);
    }
    
    /**
     * Метод, преобразующий экранные координаты в трёхмерные.
     * Z-составляющая при этом устанавливается в 0
     * @param p исходная трёхмерная точка
     * @return результирующая трёхмерная точка.
     */
    public Vector3 s2r(ScreenPoint p) {
        return s2r(p, 0);
    }
    
    /**
     * Устанавливает новый размер экрана
     * @param w ширина
     * @param h высота
     */
    public void setScreenSize(int w, int h) {
        setWs(w);
        setHs(h);
    }

    public double getHr() {
        return hr;
    }

    public void setHr(double hr) {
        this.hr = hr;
    }

    public int getHs() {
        return hs;
    }

    public void setHs(int hs) {
        this.hs = hs;
    }

    public double getWr() {
        return wr;
    }

    public void setWr(double wr) {
        this.wr = wr;
    }

    public int getWs() {
        return ws;
    }

    public void setWs(int ws) {
        this.ws = ws;
    }

    public double getXr() {
        return xr;
    }

    public void setXr(double xr) {
        this.xr = xr;
    }

    public double getYr() {
        return yr;
    }

    public void setYr(double yr) {
        this.yr = yr;
    }
    
}
