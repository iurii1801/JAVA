//Создайте иерархию классов Сторона – Прямоугольник – Тумбочка с одной полкой.
// Класс Прямоугольник должен содержать метод для вычисления площади прямоугольника.
// Класс Тумбочка должен содержать метод для определения вместимости. Последние два класса в иерархии должны иметь конструкторы.
// Создайте метод MAIN, в котором создается 2 Тумбочки (т.е. 2 объекта класса Тумбочка ), определяется какая из Тумбочек больше.
// Необходимо также показывать все характеристики создаваемых объектов.

public class Main {
    public static void main(String[] args) {
        Nightstand nightstand1 = new Nightstand(5, 18, 30);
        Nightstand nightstand2 = new Nightstand(4, 4, 50);

        nightstand1.showCharacteristics();
        nightstand2.showCharacteristics();

        double capacity1 = nightstand1.capacity();
        double capacity2 = nightstand2.capacity();

        if (capacity1 > capacity2) {
            System.out.println("Первая тумбочка больше второй в " + capacity1 / capacity2 + " раз(а).");
        } else if (capacity2 > capacity1) {
            System.out.println("Вторая тумбочка больше первой в " + capacity2 / capacity1 + " раз(а).");
        } else {
            System.out.println("Тумбочки равны по вместимости.");
        }
    }
}
