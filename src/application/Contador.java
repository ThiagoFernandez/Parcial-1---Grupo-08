package application;
import java.util.Scanner;
public class Contador  extends Exercise {

    public Contador (Scanner scanner) {
        super (scanner);
    }

    @Override
    protected void exerciseLogic(){
        System.out.println("Enter a number to count up to (mm to quit): ");
        String userInput = scanner.nextLine().toLowerCase();
        if (userInput.equals("mm")){
            stop();
        }else{
            try {
                int number = Integer.parseInt(userInput);
                System.out.println("Counting up to " + number + ":");
                for (int i = 1; i<=number; i++){
                    System.out.println(i);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid number or 'mm' to quit");
            }
        }
    }

}
