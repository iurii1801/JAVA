package input;

import exceptions.PrimeNumberException;
import java.util.Scanner;

public class PrimeNumberInput {

    private boolean isPrime(int number) throws PrimeNumberException {
        if (number <= 1) {
            throw new PrimeNumberException(number);
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                throw new PrimeNumberException(number);
            }
        }
        return true;
    }

    public int[] inputPrimeNumbers() {
        Scanner scanner = new Scanner(System.in);
        int[] primeNumbers = new int[10];
        int count = 0;

        while (count < primeNumbers.length) {
            System.out.print("Введите простое число #" + (count + 1) + ": ");
            int num = scanner.nextInt();
            try {
                isPrime(num);
                primeNumbers[count] = num;
                count++;
            } catch (PrimeNumberException e) {
                System.out.println(e.getMessage());
            }
        }
        return primeNumbers;
    }
}
