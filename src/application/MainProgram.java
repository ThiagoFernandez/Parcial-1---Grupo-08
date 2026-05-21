package application;

import listModule.ListExercise;
import java.util.Scanner;

public class MainProgram {

    private boolean running = true;
    private Exercise exercise;

    public static void main(String[] args) {
        MainProgram app = new MainProgram();
        app.run();
    }

    private void run() {
        Scanner scnr = new Scanner(System.in);

        while (running) {
            selectExercise(scnr);

            if (exercise != null) {
                exercise.run();
            }
        }

        scnr.close();
        System.out.println("Program finished.");
    }

    private void selectExercise(Scanner scnr) {
        System.out.println(
                "Select an exercise (mm to quit):\n" +
                        "1. TestExercise\n" +
                        "2. MenuExercise (extra)\n" +
                        "3. Contador (extra)\n" +
                        "4. CalculadoraBasica (extra)\n" +
                        "5. ListExercise\n" +
                        "6. TestSimpleList\n" +
                        "7. StackExercise\n" +
                        "8. QueueExercise\n" +
                        "9. SetExercise"
        );
        String option = scnr.nextLine().toLowerCase().strip();

        switch (option) {
            case "mm" -> running = false;
            case "1"  -> exercise = new TestExercise(scnr);
            case "2"  -> exercise = new MenuExercise(scnr);
            case "3"  -> exercise = new Contador(scnr);
            case "4"  -> exercise = new CalculadoraBasica(scnr);
            case "5"  -> exercise = new ListExercise(scnr);
            case "6"  -> exercise = new TestSimpleList(scnr);
            case "7"  -> exercise = new stackModule.StackExercise(scnr);
            case "8"  -> exercise = new queueModule.QueueExercise(scnr);
            case "9"  -> exercise = new setModule.SetExercise(scnr);
            default   -> System.out.println("Invalid option. Try again.");
        }
    }
}