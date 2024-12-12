//Лабораторная работа №6. Создание нитей процессов (Threads)

//Требования к программе:
//1. Данные вводятся с клавиатуры. Имеется защита от неправильного ввода.
//2. Исходные данные и результат выводятся на экран монитора.
//3. Программа тестируется на нескольких различных примерах.
//4. Работа в параллельных процессах не дублируется. Вычислительная нагрузка на каждый процесс примерно одинакова.
//5. Результаты выводить в процессе main. В начале программы вывести на консоль число доступных процессоров на компьютере.

//   Написать программу на Java с двумя нитями процессов:
//1-ый процесс ищет в векторе максимальный элемент;
//2-ой процесс ищет в векторе минимальный элемент

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Количество доступных процессоров: " + Runtime.getRuntime().availableProcessors());

        int[] vector = inputVector();

        System.out.println("Исходный вектор:");
        printArray(vector);

        Thread findMaxThread = new Thread(() -> {
            System.out.println("Работает первый процесс");
            int max = findMax(vector);
            System.out.println("Максимальное значение в векторе: " + max);
        });

        Thread findMinThread = new Thread(() -> {
            System.out.println("Работает второй процесс");
            int min = findMin(vector);
            System.out.println("Минимальное значение в векторе: " + min);
        });

        findMaxThread.start();
        findMinThread.start();

        try {
            findMaxThread.join();
            findMinThread.join();
        } catch (InterruptedException e) {
            System.err.println("Ошибка при ожидании потоков: " + e.getMessage());
        }

        System.out.println("Обработка завершена.");
    }

    public static int[] inputVector() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер вектора: ");
        int size;
        while (true) {
            try {
                size = scanner.nextInt();
                if (size <= 0) throw new IllegalArgumentException("Размер вектора должен быть положительным.");
                break;
            } catch (Exception e) {
                System.out.println("Неверный ввод. Пожалуйста, введите положительное целое число.");
                scanner.next();
            }
        }

        int[] vector = new int[size];
        System.out.println("Введите элементы вектора:");

        for (int i = 0; i < size; i++) {
            while (true) {
                try {
                    System.out.print("Элемент [" + i + "]: ");
                    vector[i] = scanner.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
                    scanner.next();
                }
            }
        }
        return vector;
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static int findMax(int[] vector) {
        int max = Integer.MIN_VALUE;
        for (int value : vector) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static int findMin(int[] vector) {
        int min = Integer.MAX_VALUE;
        for (int value : vector) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
}
