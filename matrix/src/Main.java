public class Main {
    public static void main(String[] args) {

        Matrix matrix = new Matrix(3, 3);
        matrix.inputMatrix();
        matrix.printMatrix();

        int min = matrix.findMin();
        int max = matrix.findMax();

        System.out.println("Минимальный элемент: " + min);
        System.out.println("Максимальный элемент: " + max);
    }
}
