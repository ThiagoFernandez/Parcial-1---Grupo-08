package listModule;

import java.util.Scanner;

public class ListExercise extends application.Exercise {
    private int currentPhase = 0;
    private boolean firstTime = true;

    SimpleList<String> list;

    public ListExercise(Scanner scanner) {
        super(scanner);
        System.out.println("1 - ArrayList");
        System.out.println("2 - LinkedList");

        String op = scanner.nextLine();
        if (op.equals("1")) {
            list = new SimpleArrayList<>();
        } else if (op.equals("2")) {
            list = new SimpleLinkedList<>();
        } else { stop(); }
    }

    @Override
    protected void exerciseLogic() {
        switch (currentPhase) {
            case 0 -> menuLogic();
            case 1 -> {
                System.out.println("Enter the element to add:");
                String element = scanner.nextLine();
                boolean result = list.add(element);
                System.out.println("Operation completed: " + result);
                currentPhase = 0;
            }
            case 2 -> {
                try {
                    System.out.println("Enter the index:");
                    int idx = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the element:");
                    String element = scanner.nextLine();
                    list.add(idx, element);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Error: invalid index. " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Error: please enter a valid number.");
                }
                currentPhase = 0;
            }
            case 3 -> {
                try {
                    System.out.println("Enter the index:");
                    int idx = Integer.parseInt(scanner.nextLine());
                    String removed = list.remove(idx);
                    System.out.println("Removed element: " + removed);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Error: invalid index. " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Error: please enter a valid number.");
                }
                currentPhase = 0;
            }
            case 4 -> {
                System.out.println("Enter the element to remove:");
                String element = scanner.nextLine();
                boolean result = list.remove(element);
                System.out.println("Operation completed: " + result);
                currentPhase = 0;
            }
            case 5 -> {
                list.clear();
                System.out.println("List cleared.");
                currentPhase = 0;
            }
            case 6 -> {
                System.out.println("Enter the element to search:");
                String element = scanner.nextLine();
                boolean result = list.contains(element);
                System.out.println("Is \"" + element + "\" in the list: " + result);
                currentPhase = 0;
            }
            case 7 -> {
                try {
                    System.out.println("Enter the index:");
                    int idx = Integer.parseInt(scanner.nextLine());
                    String result = list.get(idx);
                    System.out.println("Element at index " + idx + ": " + result);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Error: invalid index. " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Error: please enter a valid number.");
                }
                currentPhase = 0;
            }
            case 8 -> {
                try {
                    System.out.println("Enter the index:");
                    int idx = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the new element:");
                    String element = scanner.nextLine();
                    String replaced = list.set(idx, element);
                    System.out.println("Replaced element: " + replaced);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Error: invalid index. " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Error: please enter a valid number.");
                }
                currentPhase = 0;
            }
            case 9 -> {
                System.out.println("List size: " + list.size());
                currentPhase = 0;
            }
            case 10 -> {
                System.out.println("Is the list empty: " + list.isEmpty());
                currentPhase = 0;
            }
        }
    }

    private void menuLogic() {
        if (firstTime) {
            System.out.println("Welcome to the List Exercise!");
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
        System.out.println("Current state of the list:");
        if (list.isEmpty()) {
            System.out.println("(empty)");
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    System.out.print(list.get(i));
                } else {
                    System.out.print(list.get(i) + ", ");
                }
            }
            System.out.println();
        }
        System.out.println("Total: " + list.size());
        System.out.println("Is the list empty: " + list.isEmpty());
    }

    public String chooseOption() {
        System.out.println(
                "1.  boolean add(E element)\n" +
                        "2.  void add(int index, E element)\n" +
                        "3.  E remove(int index)\n" +
                        "4.  boolean remove(Object object)\n" +
                        "5.  void clear()\n" +
                        "6.  boolean contains(Object object)\n" +
                        "7.  E get(int index)\n" +
                        "8.  E set(int index, E element)\n" +
                        "9.  int size()\n" +
                        "10. boolean isEmpty()\n" +
                        "mm. stop()"
        );
        return scanner.nextLine().toLowerCase().strip();
    }
}