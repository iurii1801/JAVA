//Лабораторная работа №3. Создание и обработка собственных исключений.
//В программе требуется:
//Создать собственное исключение (class).
//Создать метод (throw), который может возбуждать это исключение(throws).
//Написать метод, перехватывающий и обрабатывающий исключение (try-catch), возбуждаемое другим методом.
//Исключение: с консоли вводятся 10 чисел и записываются в массив. Добиться ввода только простых чисел.

package main;

import input.PrimeNumberInput;

public class Main {
    public static void main(String[] args) {
        PrimeNumberInput numberInput = new PrimeNumberInput();

        int[] primeNumbers = numberInput.inputPrimeNumbers();
        System.out.println("Все числа введены корректно: ");
        for (int num : primeNumbers) {
            System.out.print(num + " ");
        }
    }
}
