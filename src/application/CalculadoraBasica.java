package application;
import java.util.Scanner;

public class CalculadoraBasica extends Exercise {

    public CalculadoraBasica(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected void exerciseLogic() {
        System.out.println("Choose an operation (+, -, *, /) or 'mm' to quit: ");
        String userInput = scanner.nextLine().strip().toLowerCase();
        if (userInput.equals("mm")) {
            stop();
        } else {
            switch (userInput) {
                case "+":
                    System.out.println("Enter the first number: ");
                    int num1 = scanner.nextInt();
                    System.out.println("Enter the second number: ");
                    int num2 = scanner.nextInt();
                    int result = num1 + num2;
                    System.out.println("Result: " + result);
                    break;
                case "-":
                    System.out.println("Enter the first number: ");
                    num1 = scanner.nextInt();
                    System.out.println("Enter the second number: ");
                    num2 = scanner.nextInt();
                    result = num1 - num2;
                    System.out.println("Result: " + result);
                    break;
                case "*":
                    System.out.println("Enter the first number: ");
                    num1 = scanner.nextInt();
                    System.out.println("Enter the second number: ");
                    num2 = scanner.nextInt();
                    result = num1 * num2;
                    System.out.println("Result: " + result);
                    break;
                case "/":
                    System.out.println("Enter the first number: ");
                    num1 = scanner.nextInt();
                    System.out.println("Enter the second number: ");
                    num2 = scanner.nextInt();
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println("Result: " + result);
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                    }
            }
        }
    }
}