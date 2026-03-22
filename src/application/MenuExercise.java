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
                + "\n 2. Show hour");

        String userInput = scanner.nextLine().toLowerCase();
        switch (userInput){
            case "mm" -> stop();
            case "1" -> System.out.println("Hello, welcome to the Menu Exercise!");
            case "2" -> System.out.println("Current time: " + LocalTime.now());
            default -> System.out.println("Invalid input, please try again.");
        }
    }
}
