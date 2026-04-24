package stackModule;

import application.Exercise;

import java.util.Scanner;

public class StackExercise extends Exercise {
    private int currentPhase = 0;
    private boolean firstTime = true;

    SimpleStack<Integer>list; // el tipo de dato no necesariamente debe ser Integer, simplemente para testearlo

    public StackExercise(Scanner scanner){
        super(scanner);
        System.out.println("1 - SimpleArrayStack");
        System.out.println("2 - SimpleLinkedStack");

        String op = scanner.nextLine();
        if (op.equals("1")) {
            list = new SimpleArrayStack<>();
        } else if (op.equals("2")) {
            list = new SimpleLinkedStack<>();;
        }else{ stop();}
    }

    @Override
    protected void exerciseLogic(){
        switch (currentPhase){
            case 0 -> menuLogic();
            case 1-> {
                while (true){
                    System.out.println("Write a number | '-1' to go back to the stack menu");
                    Integer num = scanner.nextInt();
                    scanner.nextLine();
                    if(num.equals(-1)){break;}
                    list.push(num);
                }
                currentPhase = 0;
            }
            case 2 -> {
                int num = 2;
                if(list.isEmpty()) {
                    System.out.println("Cannot do the operation | The list is empty ");
                } else{
                    System.out.println("Removed element: "+list.pop());
                    System.out.println("0 to go back to the stack menu");
                    num = scanner.nextInt();
                    scanner.nextLine();
                }
                currentPhase = num;
            }
            case 3 -> {
                if(list.isEmpty()) {
                    System.out.println("Cannot do the operation | The list is empty ");
                } else{
                    System.out.println("Last element: "+list.peek());
                }
                currentPhase = 0;
            }
            case 4 -> {
                if(list.isEmpty()) {
                    System.out.println("Cannot do the operation | The list is empty ");
                } else{
                    list.clear();
                }
                currentPhase = 0;
            }
            case 5 -> {
                System.out.println("List size: "+ list.size());
                currentPhase = 0;
            }
            case 6 -> {
                System.out.println("Is the list empty: "+list.isEmpty());
                currentPhase = 0;
            }
        }
    }

    private void menuLogic() {
        if (firstTime) {
            System.out.println("Welcome to the Stack Exercise!");
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
                default -> System.out.println("Invalid input, please try again.");
            }
        }
    }
    public void showData(){
        System.out.println("This is the current state of the list: ");
        System.out.println("Is the list empty?"+ (list.isEmpty()));
        System.out.println("Total: "+ list.size());
    }
    public String chooseOption(){
        System.out.println(
                        "1. void push(E element)" + "\n"+
                        "2. E pop()"+ "\n"+
                        "3. E peek()"+ "\n"+
                        "4. void clear()"+ "\n"+
                        "5. int size()"+"\n"+
                        "6. boolean isEmpty()"+"\n"+
                        "mm. stop()"
        );
        return scanner.nextLine().toLowerCase().strip();
    }
}
