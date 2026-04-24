package queueModule;

import application.Exercise;

import java.util.Scanner;

public class QueueExercise extends Exercise {
    private int currentPhase = 0;
    private boolean firstTime = true;

    SimpleQueue<Integer>list; // el tipo de dato no necesariamente debe ser Integer, simplemente para testearlo

    public QueueExercise(Scanner scanner){
        super(scanner);
        System.out.println("1 - SimpleArrayQueue");
        System.out.println("2 - SimpleLinkedQueue");

        String op = scanner.nextLine();
        if (op.equals("1")){
            list = new SimpleArrayQueue<>();
        } else if(op.equals("2")){
            list = new SimpleLinkedQueue<>();
        } else{stop();}
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
                    list.enqueue(num);
                }
                currentPhase = 0;
            }
            case 2 -> {
                int num = 2;
                if(list.isEmpty()) {
                    System.out.println("Cannot do the operation | The list is empty ");
                } else{
                    System.out.println("Removed element: "+list.dequeue());
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
            System.out.println("Welcome to the Queue Exercise!");
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
                        "1. void enqueue(E element)" + "\n"+
                        "2. E dequeue()"+ "\n"+
                        "3. E peek()"+ "\n"+
                        "4. void clear()"+ "\n"+
                        "5. int size()"+"\n"+
                        "6. boolean isEmpty()"+"\n"+
                        "mm. stop()"
        );
        return scanner.nextLine().toLowerCase().strip();
    }

}
