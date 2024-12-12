//Лабораторная работа №5. Generics. Обобщенные классы и методы
//
//Простое обобщение: Создайте простой обобщённый класс Box<T>,, который может хранить объект любого типа.
// Добавьте методы для установки и получения значения.
// Обобщённые методы: Добавьте в класс Box обобщённый метод compareTo(T other),
// где T должен реализовывать Comparable<T>. Метод будет сравнивать значения внутри двух коробок.

public class Main {
    public static void main(String[] args) {

        Box<Integer> intBox1 = new Box<>(10);
        Box<Integer> intBox2 = new Box<>(20);

        System.out.println("intBox1: " + intBox1);
        System.out.println("intBox2: " + intBox2);

        int comparisonResult = intBox1.compareTo(intBox2);
        System.out.println("Сравнение intBox1 и intBox2: " +
                (comparisonResult < 0 ? "intBox1 меньше" : comparisonResult > 0 ? "intBox1 больше" : "равны"));

        Box<String> strBox1 = new Box<>("Apple");
        Box<String> strBox2 = new Box<>("Banana");

        System.out.println("strBox1: " + strBox1);
        System.out.println("strBox2: " + strBox2);

        comparisonResult = strBox1.compareTo(strBox2);
        System.out.println("Сравнение strBox1 и strBox2: " +
                (comparisonResult < 0 ? "strBox1 меньше" : comparisonResult > 0 ? "strBox1 больше" : "равны"));
    }
}
