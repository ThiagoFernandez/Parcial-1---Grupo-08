package application;
import java.util.Scanner;
import java.time.LocalTime;
public class MenuExercise  extends Exercise {

    public MenuExercise(Scanner scanner) {
        super (scanner);
    }

    @Override
    protected void exerciseLogic() {
        System.out.println(
                " Welcome to the Menu Exercise!"
                + "\n Please select an option(mm to quit): "
                + "\n 1. Greetings"
                + "\n 2. Show hour"
                + "\n 3. addition"
                + "\n 4. subtraction");

        String userInput = scanner.nextLine().toLowerCase();
        switch (userInput){
            case "mm" -> stop();
            case "1" -> System.out.println("Hello, thanks for try this option!");
            case "2" -> System.out.println("Current time: " + LocalTime.now());
            case "3" -> {
                System.out.println("Enter the first number: ");
                int number1 = scanner.nextInt();
                System.out.println("Enter the second number: ");
                int number2 = scanner.nextInt();
                int result = number1 + number2;
                System.out.println("The result of " + number1 + " + " + number2 + " is: " + result);
            }
            case "4" -> {
                System.out.println("Enter the first number: ");
                int number1 = scanner.nextInt();
                System.out.println("Enter the second number: ");
                int number2 = scanner.nextInt();
                System.out.println("The result of " + number1 + " - " + number2 + " is: " + (number1 - number2));
            }
            default -> System.out.println("Invalid input, please try again.");
        }
    }
}
