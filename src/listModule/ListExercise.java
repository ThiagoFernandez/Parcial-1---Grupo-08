package listModule;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class ListExercise  extends application.Exercise{
    private int currentPhase = 0;
    private boolean firstTime = true;

    private List<String> list;

    public ListExercise(Scanner scanner){
        super(scanner);
        list = new ArrayList<>();
        //list = new LinkedList<>();
    }

    @Override
    protected void exerciseLogic(){
        switch (currentPhase){
            case 0 -> menuLogic();
            case 1 -> addElement();
            case 2 -> removeElementByIndex();
            case 3 -> removeElementByReference();
            case 4 -> clearList();
        }
    }

    private void menuLogic() {
        if (firstTime) {
            System.out.println("Welcome to the List Exercise!");
            showData();
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
        System.out.println("Is the list empty?" + "\n " + list.isEmpty());
    }

    public String chooseOption(){
        System.out.println("Please select an option(mm to quit): "
                + "\n 1. Add an element to the list"
                + "\n 2. Remove an element from the list using its index"
                + "\n 3. Remove an element from the list using its reference"
                + "\n 4. Clear the list");
        return scanner.nextLine().toLowerCase().strip();
    }

    public void addElement(){
        System.out.println("Enter the element u want to add: ");
        String element = scanner.nextLine();
        list.add(element);
        System.out.println("Element added successfully!");
        currentPhase = 0;
    }

    public void removeElementByIndex(){
        System.out.println("Enter the index of the element u want to remove: ");
        int idx = scanner.nextInt();
        scanner.nextLine(); // Consumo la linea q dejo el nextInt para evitar problemas con el scanner
        if (idx >= 0 && idx < list.size()){
            list.remove(idx);
            System.out.println("Element removed successfully!");
        } else {
            System.out.println("Invalid index, please try again.");
        }
        currentPhase = 0;
    }

    public void removeElementByReference(){
        System.out.println("Enter the element u want to remove: ");
        String element = scanner.nextLine();
        if (list.contains(element)) { // valido que este primero para evitar una exception
            list.remove(element);
            System.out.println("Element removed successfully!");
        } else {
            System.out.println("Element not found in the list, please try again.");
        }
        currentPhase = 0;
    }

    public void clearList(){
        list.clear();
        System.out.println("List cleared successfully!");
        currentPhase = 0;
    }

}
