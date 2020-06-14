package machine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        boolean exit = true;
        Scanner scanner = new Scanner(System.in);
        while(exit) {
            coffeeMachine.displayMainMenu();
            exit = coffeeMachine.checkUserInput(scanner.next());
        }
    }

}
