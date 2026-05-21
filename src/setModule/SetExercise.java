package setModule;

import application.Exercise;
import java.util.Scanner;

public class SetExercise extends Exercise {
    private int currentPhase = 0;
    private boolean firstTime = true;

    SimpleSet<String> set;

    public SetExercise(Scanner scanner) {
        super(scanner);
        System.out.println("1 - SimpleArraySet");
        System.out.println("2 - SimpleLinkedSet");  // fix: decía SimpleArraySet dos veces

        String op = scanner.nextLine();
        if (op.equals("1")) {
            set = new SimpleArraySet<>();
        } else if (op.equals("2")) {
            set = new SimpleLinkedSet<>();
        } else {
            System.out.println("Invalid option");
            stop();  // fix: faltaba el ;
        }
    }

    @Override
    protected void exerciseLogic() {
        switch (currentPhase) {
            case 0 -> menuLogic();
            case 1 -> {
                while (true) {
                    System.out.println("Enter an element to add | 'mm' to go back");
                    String input = scanner.nextLine().strip();
                    if (input.equalsIgnoreCase("mm")) { break; }
                    boolean result = set.add(input);
                    System.out.println(result ? "Added." : "Element already exists in the set.");
                }
                currentPhase = 0;
            }
            case 2 -> {
                if (set.isEmpty()) {
                    System.out.println("Cannot do the operation | The set is empty");
                } else {
                    System.out.println("Enter the element to remove:");
                    String input = scanner.nextLine().strip();
                    boolean result = set.remove(input);
                    System.out.println(result ? "Removed." : "Element not found.");
                }
                currentPhase = 0;
            }
            case 3 -> {
                System.out.println("Enter the element to search:");
                String input = scanner.nextLine().strip();
                System.out.println("Contains \"" + input + "\": " + set.contains(input));
                currentPhase = 0;
            }
            case 4 -> {
                if (set.isEmpty()) {
                    System.out.println("The set is already empty");
                } else {
                    set.clear();
                    System.out.println("Set cleared.");
                }
                currentPhase = 0;
            }
            case 5 -> {
                System.out.println("Is the set empty: " + set.isEmpty());
                currentPhase = 0;
            }
            case 6 -> {
                System.out.println("Set size: " + set.size());
                currentPhase = 0;
            }
            case 7 -> {
                Object[] array = set.toArray();
                if (array.length == 0) {
                    System.out.println("(empty)");
                } else {
                    for (int i = 0; i < array.length; i++) {
                        System.out.print(i == array.length - 1 ? array[i] : array[i] + ", ");
                    }
                    System.out.println();
                }
                currentPhase = 0;
            }
            case 8 -> {
                SimpleSet<String> other = readOtherSet();
                SimpleSet<String> result = set.unionWith(other);
                printSet("Union", result);
                currentPhase = 0;
            }
            case 9 -> {
                SimpleSet<String> other = readOtherSet();
                SimpleSet<String> result = set.intersectionWith(other);
                printSet("Intersection", result);
                currentPhase = 0;
            }
            case 10 -> {
                SimpleSet<String> other = readOtherSet();
                SimpleSet<String> result = set.differenceWith(other);
                printSet("Difference", result);
                currentPhase = 0;
            }
        }
    }

    private SimpleSet<String> readOtherSet() {
        SimpleSet<String> other = new SimpleArraySet<>();
        System.out.println("Enter elements for the second set one by one | 'mm' to finish");
        while (true) {
            String input = scanner.nextLine().strip();
            if (input.equalsIgnoreCase("mm")) { break; }
            other.add(input);
        }
        return other;
    }

    private void printSet(String label, SimpleSet<String> s) {
        System.out.print(label + ": { ");
        Object[] array = s.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.print(i == array.length - 1 ? array[i] : array[i] + ", ");
        }
        System.out.println(" }");
    }

    private void menuLogic() {
        if (firstTime) {
            System.out.println("Welcome to the Set Exercise!");
            firstTime = false;
        } else {
            showData();
        }
        String userOption = chooseOption();
        if (userOption.equals("mm")) {
            stop();
        } else {
            switch (userOption) {
                case "1"  -> currentPhase = 1;
                case "2"  -> currentPhase = 2;
                case "3"  -> currentPhase = 3;
                case "4"  -> currentPhase = 4;
                case "5"  -> currentPhase = 5;
                case "6"  -> currentPhase = 6;
                case "7"  -> currentPhase = 7;
                case "8"  -> currentPhase = 8;
                case "9"  -> currentPhase = 9;
                case "10" -> currentPhase = 10;
                default   -> System.out.println("Invalid input, please try again.");
            }
        }
    }

    public void showData() {
        System.out.println("Current state of the Set:");
        if (set.isEmpty()) {
            System.out.println("(empty)");
        } else {
            printSet("Elements", set);
        }
        System.out.println("Total: " + set.size());
        System.out.println("Is the set empty: " + set.isEmpty());
    }

    public String chooseOption() {
        System.out.println(
                "1.  boolean add(E element)\n" +
                        "2.  boolean remove(E element)\n" +
                        "3.  boolean contains(E element)\n" +
                        "4.  void clear()\n" +
                        "5.  boolean isEmpty()\n" +
                        "6.  int size()\n" +
                        "7.  E[] toArray()\n" +
                        "8.  SimpleSet<E> unionWith(SimpleSet<E> other)\n" +
                        "9.  SimpleSet<E> intersectionWith(SimpleSet<E> other)\n" +
                        "10. SimpleSet<E> differenceWith(SimpleSet<E> other)\n" +
                        "mm. stop()"
        );
        return scanner.nextLine().toLowerCase().strip();
    }
}