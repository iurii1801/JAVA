package input;

import exceptions.PrimeNumberException;
import java.util.Scanner;

public class PrimeNumberInput {

    // Метод для проверки, является ли число простым
    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Метод для ввода чисел и возбуждения исключения, если число не простое
    public int[] inputPrimeNumbers() {
        Scanner scanner = new Scanner(System.in);
        int[] primeNumbers = new int[10];
        int count = 0;

        while (count < primeNumbers.length) {
            System.out.print("Введите простое число #" + (count + 1) + ": ");
            int num = scanner.nextInt();
            try {
                if (!isPrime(num)) {
                    throw new PrimeNumberException(num);
                }
                primeNumbers[count] = num;
                count++;
            } catch (PrimeNumberException e) {
                System.out.println(e.getMessage());
            }
        }
        return primeNumbers;
    }
}
