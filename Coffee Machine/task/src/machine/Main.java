package machine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        Scanner scanner = new Scanner(System.in);
        do {
            coffeeMachine.displayMainMenu();
        } while(coffeeMachine.checkUserInput(scanner.next()));
    }

}
