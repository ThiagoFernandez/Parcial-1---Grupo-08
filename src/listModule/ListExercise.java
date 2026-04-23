package listModule;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class ListExercise  extends application.Exercise{
    private int currentPhase = 0;
    private boolean firstTime = true;

    //private List<String> list;
    listModule.SimpleList<Integer> list;

    public ListExercise(Scanner scanner){
        super(scanner);
        System.out.println("1 - ArrayList");
        System.out.println("2 - LinkedList");

        String op = scanner.nextLine();
        if (op.equals("1")) {
            list = new SimpleArrayList<>();
        } else if (op.equals("2")) {
            list = new SimpleLinkedList<>();;
        }else{ stop();}
    }

    @Override
    protected void exerciseLogic(){
        switch (currentPhase){
            case 0 -> menuLogic();
            case 1-> {
                int userNum = scanner.nextInt();
                scanner.nextLine();
                boolean result = list.add(userNum);
                System.out.println("Operation completed: "+result);
                //break; es innecesario si uso las arrows porque no tienen fail-through
                currentPhase = 0;
            }
            case 2 -> {
                int idx = scanner.nextInt();
                scanner.nextLine();
                Integer num = scanner.nextInt();
                scanner.nextLine();
                list.add(idx, num);
                currentPhase = 0;
            }
            case 3 -> {
                int idx = scanner.nextInt();
                scanner.nextLine();
                Integer removedNumber = list.remove(idx);
                System.out.println("RemovedNumber: " + removedNumber);
                currentPhase = 0;
            }
            case 4 -> {
                Integer num = scanner.nextInt();
                scanner.nextLine();
                boolean result = list.remove(num);
                System.out.println("Operation completed: "+result);
                currentPhase = 0;
            }
            case 5 -> {
                list.clear();
                currentPhase = 0;
            }
            case 6 -> {
                Integer num = scanner.nextInt();
                scanner.nextLine();
                boolean result = list.contains(num);
                System.out.println("Is "+num+" in the list: "+result);
                currentPhase = 0;
            }
            case 7 -> {
                int idx = scanner.nextInt();
                scanner.nextLine();
                Integer result = list.get(idx);
                System.out.println(result);
                currentPhase = 0;
            }
            case 8 -> {
                int idx = scanner.nextInt();
                scanner.nextLine();
                Integer num = scanner.nextInt();
                scanner.nextLine();
                Integer removedNumber = list.set(idx, num);
                System.out.println("RemovedNumber: " + removedNumber);
                currentPhase = 0;
            }
            case 9 -> {
                int total = list.size();
                System.out.println("List lenght: " + total);
                currentPhase = 0;
            }
            case 10 -> {
                boolean state = list.isEmpty();
                System.out.println("Is the list empty: " + state);
                currentPhase = 0;
            }
        }
    }

    private void menuLogic() {
        if (firstTime) {
            System.out.println("Welcome to the List Exercise!");
            //showData();
            firstTime = false;
        } else {
            showData();
        }
        String userOption = chooseOption();
        if (userOption.equals("mm")){
            stop();
        } else {
            switch (userOption){
                case "1" -> currentPhase = 1;
                case "2" -> currentPhase = 2;
                case "3" -> currentPhase = 3;
                case "4" -> currentPhase = 4;
                case "5" -> currentPhase = 5;
                case "6" -> currentPhase = 6;
                case "7" -> currentPhase = 7;
                case "8" -> currentPhase = 8;
                case "9" -> currentPhase = 9;
                case "10" -> currentPhase = 10;
                default -> System.out.println("Invalid input, please try again.");
            }
        }
    }
    public void showData(){
        System.out.println("This is the current state of the list: ");
        if (list.isEmpty()){
            System.out.println("(empty)");
        }else{
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    System.out.print(list.get(i));
                } else {
                    System.out.print(list.get(i) + ", ");
                }
            }
        }
        System.out.println();
        System.out.println("Total: "+ list.size());
        System.out.println("Is the list empty?" + "\n " + (list.isEmpty()));
    }

    public String chooseOption(){
        System.out.println(
                        "1. boolean add(E element)" + "\n"+
                        "2. void add(int index, E element)"+ "\n"+
                        "3. E remove(int index"+ "\n"+
                        "4. boolean remove(Object object)"+ "\n"+
                        "5. void clear()"+"\n"+
                        "6. boolean contains(Object object)"+"\n"+
                        "7. E get(int index)"+"\n"+
                        "8. E set(int index, E element)" + "\n"+
                        "9. int size()"+"\n"+
                        "10. boolean isEmpty()" + "\n"+
                        "mm. stop()"
        );
        return scanner.nextLine().toLowerCase().strip();
    }


    // esto es de la entrega 2
//    public void addElement(){
//        System.out.println("Enter the element u want to add: ");
//        String element = scanner.nextLine();
//        list.add(element);
//        System.out.println("Element added successfully!");
//        currentPhase = 0;
//    }
//
//    public void removeElementByIndex(){
//        System.out.println("Enter the index of the element u want to remove: ");
//        int idx = scanner.nextInt();
//        scanner.nextLine(); // Consumo la linea q dejo el nextInt para evitar problemas con el scanner
//        if (idx >= 0 && idx < list.size()){
//            list.remove(idx);
//            System.out.println("Element removed successfully!");
//        } else {
//            System.out.println("Invalid index, please try again.");
//        }
//        currentPhase = 0;
//    }
//
//    public void removeElementByReference(){
//        System.out.println("Enter the element u want to remove: ");
//        String element = scanner.nextLine();
//        if (list.contains(element)) { // valido que este primero para evitar una exception
//            list.remove(element);
//            System.out.println("Element removed successfully!");
//        } else {
//            System.out.println("Element not found in the list, please try again.");
//        }
//        currentPhase = 0;
//    }
//
//    public void clearList(){
//        list.clear();
//        System.out.println("List cleared successfully!");
//        currentPhase = 0;
//    }

}
