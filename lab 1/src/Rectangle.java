public class Rectangle extends Side {
    protected double b;

    public Rectangle(double a, double b) {
        super(a);
        this.b = b;
    }

    public double area() {
        return a * b;
    }

    public String toString() {
        return "Rectangle: side a = " + a + ", side b = " + b + ", area = " + area();
    }

    public void showCharacteristics() {
        System.out.println(toString());
    }
}
