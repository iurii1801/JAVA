public class Box<T extends Comparable<T>> {
    private T value;

    public Box() {}

    public Box(T value) {
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public int compareTo(Box<T> other) {
        if (value != null && other.getValue() != null) {
            return value.compareTo(other.getValue());
        }
        throw new IllegalArgumentException("Values must not be null");
    }

    public String toString() {
        return "Box{" + "value=" + value + '}';
    }
}
