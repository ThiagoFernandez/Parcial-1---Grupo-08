package application;

import java.util.Scanner;

public abstract class Exercise {
    protected  boolean running = true;
    protected Scanner scanner;

    public Exercise(Scanner scanner){
        this.scanner = scanner;
     }


     protected  abstract void exerciseLogic();

    public void run(){
        running = true; // para que se reinicie asi no se corta una vez que termina un ejercicio
        while (running){
            exerciseLogic();
        }
    }

    protected void stop(){
        running = false;
    }
}



