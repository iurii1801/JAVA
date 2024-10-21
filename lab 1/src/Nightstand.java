public class Nightstand extends Rectangle {
    private double height;

    public Nightstand(double a, double b, double height) {
        super(a, b);
        this.height = height;
    }

    public double capacity() {
        return area() * height;
    }

    public String toString() {
        return "Nightstand: side a = " + a + ", side b = " + b + ", height = " + height + ", capacity = " + capacity();
    }

    public void showCharacteristics() {
        System.out.println(toString());
    }
}
