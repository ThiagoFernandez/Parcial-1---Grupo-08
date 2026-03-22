package application;
import java.util.Scanner;

public class MainProgram {

    private boolean running = true;
    private Exercise exercise;

    public static void main(String[] args) {
            new MainProgram().run();
    }
    private void run(){
        Scanner scanner = new Scanner(System.in);
        while (running) {
            selectExercise(scanner);
            if (exercise != null) {
                exercise.run();
            }
        }
        scanner.close();
        System.out.println("Program terminated.");
    }

    private void selectExercise(Scanner scanner){
        System.out.println("Select an exercise to run:"
                + "\n0: Terminate program"
                + "\n1: Test Exercise");
        String userInput = scanner.nextLine();

        switch (userInput){
            case "0":
                running = false;
                break;
            case "1":
                exercise = new testExercise(scanner);
                exercise.run();
                break;
            default:
                System.out.println("Invalid input. Please select a valid option.");
        }
    }
}
