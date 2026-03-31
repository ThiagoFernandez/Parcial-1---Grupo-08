package application;

import listModule.ListExercise;
import listModule.SimpleArrayList;

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

            if (exercise != null) { // o sea, q no existe
                exercise.run();
            }
        }

        scnr.close();
        System.out.println("Program finished.");
    }

    private void selectExercise(Scanner scnr) {
        System.out.println("Select an exercise (-1 to quit): ");
        String option = scnr.nextLine();

        switch (option) {
            case "-1":
                running = false;
                break;
            case "1":
                exercise = new TestExercise(scnr);
                break;
            case "2":
                exercise = new MenuExercise(scnr);
                break;
            case "3":
                exercise = new Contador(scnr);
                break;
            case "4":
                exercise = new CalculadoraBasica(scnr);
                break;
            case "5":
                exercise = new ListExercise(scnr);
            case "6":
                exercise = new TestSimpleList(scnr);
            default:
                System.out.println("Invalid option. Try again.");
        }
    }
}