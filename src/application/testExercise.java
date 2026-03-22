package application;
import java.util.Scanner;
public class testExercise extends Exercise {

    public testExercise(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected void exerciseLogic() {
        System.out.println("\nWelcome to the test exercise"
        + "\nmm: Main menu");

        String userInput = scanner.nextLine().toLowerCase();

        if (userInput.equals("mm")){
            running = false;
        } else {
            System.out.println("Invalid input, please try again.");
        }
    }
}
