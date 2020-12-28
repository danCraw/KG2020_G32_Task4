package kg2019examples_task4threedimensions.models.geometry;

import kg2019examples_task4threedimensions.models.math.Vector3;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Plane {

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private float A, B, C, D;

    public Plane(){
        this(0, 0, 0,  0);
    }

    public Plane(float a, float b, float c, float d) {
        this.A = a;
        this.B = b;
        this.C = c;
        this.D = d;
    }

    public Plane(Vector3 point1, Vector3 point2, Vector3 point3) {
        new Plane(buildPlane(point1, point2, point3));
    }

    private Plane(float[] arr){
        this.A = arr[0];
        this.B = arr[1];
        this.C = arr[2];
        this.D = arr[3];
    }

    private float[] buildPlane(Vector3 point1, Vector3 point2, Vector3 point3){
        float a = point2.getX() - point1.getX();
        float b = point2.getY() - point1.getY();
        float c = point2.getZ() - point1.getZ();
        float d = point3.getX() - point1.getX();
        float e = point3.getY() - point1.getY();
        float f = point3.getZ() - point1.getZ();
        float A = b * f - e * c;
        float B = a * f - d * c;
        float C = a * e - b * d;
        float D = point1.getY() * B - point1.getX() * A - point1.getZ() * C;
        return new float[]{A, -B, C, D};
    }

    public Vector3 getNormal() {
        return new Vector3(getA(), getB(), getC());
    }

    public Vector3 getABD() {
        return new Vector3(getA(), getB(), getD());
    }
    public Vector3 getACD() {
        return new Vector3(getA(), getC(), getD());
    }

    public Vector3 getBCD() {
        return new Vector3(getB(), getC(), getD());
    }

    public float getA() {
        return this.A;
    }
    public float getB() {
        return this.B;
    }

    public float getC() {
        return this.C;
    }

    public float getD() {
        return this.D;
    }

    public void setA(float newVal){
        support.firePropertyChange("A", this.A, newVal);
        this.A = newVal;
    }

    public void setB(float newVal){
        support.firePropertyChange("B", this.B, newVal);
        this.B = newVal;
    }

    public void setC(float newVal){
        support.firePropertyChange("C", this.C, newVal);
        this.C = newVal;
    }

    public void setD(float newVal){
        support.firePropertyChange("D", this.D, newVal);
        this.D = newVal;
    }

    public double valueAt(Vector3 point){
        return getNormal().scalarProduct(point) + getD();
    }

    public void setNewValue(Integer value, float num) {
        synchronized (this) {
            switch (value) {
                case 1:
                    setA(num);
                    break;
                case 2:
                    setB(num);
                    break;
                case 3:
                    setC(num);
                    break;
                case 4:
                    setD(num);
                    break;
                default:
                    break;
            }
        }
    }

    public void addPropertyChangeListener(String name, PropertyChangeListener l) {
        support.addPropertyChangeListener(name, l);
    }

    public boolean isPresent() {
        return getA() != 0 || getB() != 0 || getC() != 0;
    }

}
