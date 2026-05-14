package stackModule;

import application.Exercise;
import java.util.Scanner;

public class StackExercise extends Exercise {
    private int currentPhase = 0;
    private boolean firstTime = true;

    SimpleStack<String> list;

    public StackExercise(Scanner scanner) {
        super(scanner);
        System.out.println("1 - SimpleArrayStack");
        System.out.println("2 - SimpleLinkedStack");

        String op = scanner.nextLine();
        if (op.equals("1")) {
            list = new SimpleArrayStack<>();
        } else if (op.equals("2")) {
            list = new SimpleLinkedStack<>();
        } else { stop(); }
    }

    @Override
    protected void exerciseLogic() {
        switch (currentPhase) {
            case 0 -> menuLogic();
            case 1 -> {
                while (true) {
                    System.out.println("Enter an element to push | 'mm' to go back");
                    String input = scanner.nextLine().strip();
                    if (input.equalsIgnoreCase("mm")) { break; }
                    list.push(input);
                }
                currentPhase = 0;
            }
            case 2 -> {
                if (list.isEmpty()) {
                    System.out.println("Cannot do the operation | The stack is empty");
                } else {
                    System.out.println("Removed element: " + list.pop());
                }
                currentPhase = 0;
            }
            case 3 -> {
                if (list.isEmpty()) {
                    System.out.println("Cannot do the operation | The stack is empty");
                } else {
                    System.out.println("Top element: " + list.peek());
                }
                currentPhase = 0;
            }
            case 4 -> {
                if (list.isEmpty()) {
                    System.out.println("The stack is already empty");
                } else {
                    list.clear();
                    System.out.println("Stack cleared.");
                }
                currentPhase = 0;
            }
            case 5 -> {
                System.out.println("Stack size: " + list.size());
                currentPhase = 0;
            }
            case 6 -> {
                System.out.println("Is the stack empty: " + list.isEmpty());
                currentPhase = 0;
            }
        }
    }

    private void menuLogic() {
        if (firstTime) {
            System.out.println("Welcome to the Stack Exercise!");
            firstTime = false;
        } else {
            showData();
        }
        String userOption = chooseOption();
        if (userOption.equals("mm")) {
            stop();
        } else {
            switch (userOption) {
                case "1" -> currentPhase = 1;
                case "2" -> currentPhase = 2;
                case "3" -> currentPhase = 3;
                case "4" -> currentPhase = 4;
                case "5" -> currentPhase = 5;
                case "6" -> currentPhase = 6;
                default  -> System.out.println("Invalid input, please try again.");
            }
        }
    }

    public void showData() {
        System.out.println("Current state of the stack:");
        System.out.println("Is the stack empty: " + list.isEmpty());
        System.out.println("Total: " + list.size());
    }

    public String chooseOption() {
        System.out.println(
                "1. void push(E element)\n" +
                        "2. E pop()\n" +
                        "3. E peek()\n" +
                        "4. void clear()\n" +
                        "5. int size()\n" +
                        "6. boolean isEmpty()\n" +
                        "mm. stop()"
        );
        return scanner.nextLine().toLowerCase().strip();
    }
}