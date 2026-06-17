import java.util.Scanner;

public class RecursiveProduct {

    // Recursive method to calculate product
    public static double findProduct(double[] numbers, int index) {

        // Base case
        if (index == numbers.length - 1) {
            return numbers[index];
        }

        // Recursive case
        return numbers[index] * findProduct(numbers, index + 1);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double[] numbers = new double[5];

        System.out.println("Enter five numbers:");

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = input.nextDouble();
        }

        double product = findProduct(numbers, 0);

        System.out.println("\nThe product of the five numbers is: " + product);

        input.close();
    }
}