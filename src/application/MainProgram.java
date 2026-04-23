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
        System.out.println(
                "Select an exercise (-1 to quit): " +"\n"+
                        "1. TestExercise" + "\n" +
                        "2. MenuExercise (extra)" + "\n" +
                        "3. Contador(extra)" + "\n" +
                        "4. CalculadoraBasica(extra)"+"\n"+
                        "5. ListExercise"+"\n"+
                        "6. TestSimpleList (now everything is in ListExercise)"+ "\n"
        );
        String option = scnr.nextLine();

        switch (option) {
            case "-1":
                running = false;
                break;
            case "1":
                exercise = new TestExercise(scnr);
                break;
            case "2":
                exercise = new MenuExercise(scnr); // extra
                break;
            case "3":
                exercise = new Contador(scnr); // extra
                break;
            case "4":
                exercise = new CalculadoraBasica(scnr); // extra
                break;
            case "5":
                exercise = new ListExercise(scnr);
                break;
            case "6":
                exercise = new TestSimpleList(scnr);
                break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }
}