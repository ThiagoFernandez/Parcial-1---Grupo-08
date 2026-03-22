package application;

import java.util.Scanner;

public class TestExercise extends Exercise {

    public TestExercise(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void run() {
        running = true;

        System.out.println("\n=== Test Exercise ===");
        System.out.println("mm: Main menu");

        while (running) {
            exerciseLogic();
        }
    }

    @Override
    protected void exerciseLogic() {
        String userInput = scanner.nextLine().toLowerCase();

        if (userInput.equals("mm")) {
            stop();
        } else {
            System.out.println("Invalid input, please try again.");
        }
    }
}