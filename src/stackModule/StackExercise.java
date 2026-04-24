package stackModule;

import application.Exercise;

import java.util.Scanner;

public class StackExercise extends Exercise {
    private int currentPhase = 0;
    private boolean firstTime = true;

    SimpleStack<Integer>stack; // el tipo de dato no necesariamente debe ser Integer, simplemente para testearlo

    public StackExercise(Scanner scanner){
        super(scanner);
        System.out.println("1 - SimpleArrayStack");
        System.out.println("2 - SimpleLinkedStack");

        String op = scanner.nextLine();
        if (op.equals("1")) {
            stack = new SimpleArrayStack<>();
        } else if (op.equals("2")) {
            stack = new SimpleLinkedStack<>();
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
                    stack.push(num);
                }
                currentPhase = 0;
            }
            case 2 -> {
                int num = 2;
                if(stack.isEmpty()) {
                    System.out.println("Cannot do the operation | The stack is empty ");
                } else{
                    System.out.println("Removed element: "+stack.pop());
                    System.out.println("0 to go back to the stack menu");
                    num = scanner.nextInt();
                    scanner.nextLine();
                }
                currentPhase = num;
            }
            case 3 -> {
                if(stack.isEmpty()) {
                    System.out.println("Cannot do the operation | The stack is empty ");
                } else{
                    System.out.println("Last element: "+stack.peek());
                }
                currentPhase = 0;
            }
            case 4 -> {
                if(stack.isEmpty()) {
                    System.out.println("Cannot do the operation | The stack is empty ");
                } else{
                    stack.clear();
                }
                currentPhase = 0;
            }
            case 5 -> {
                System.out.println("stack size: "+ stack.size());
                currentPhase = 0;
            }
            case 6 -> {
                System.out.println("Is the stack empty: "+stack.isEmpty());
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
                case "6" -> currentPhase = 6;
                default -> System.out.println("Invalid input, please try again.");
            }
        }
    }
    public void showData(){
        System.out.println("This is the current state of the stack: ");
        System.out.println("Is the stack empty?"+ (stack.isEmpty()));
        System.out.println("Total: "+ stack.size());
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
