package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private int waterMagazine;
    private int milkMagazine;
    private int coffeeBeansMagazine;
    private int disposableCups;
    private int money;
    private MachineState state = MachineState.WAIT_FOR_ACTION;

    public CoffeeMachine(int waterMagazine, int milkMagazine, int coffeeBeansMagazine, int disposableCups, int money) {
        this.waterMagazine = waterMagazine;
        this.milkMagazine = milkMagazine;
        this.coffeeBeansMagazine = coffeeBeansMagazine;
        this.disposableCups = disposableCups;
        this.money = money;
    }
    /*
    // Unlock only to pass the JetBrains application testing
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        Scanner scanner = new Scanner(System.in);
        do {
            coffeeMachine.displayMainMenu();
        } while(coffeeMachine.checkUserInput(scanner.next()));
    }
     */
    private void displayCoffeeMachineStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(waterMagazine + " of water");
        System.out.println(milkMagazine + " of milk");
        System.out.println(coffeeBeansMagazine + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public void displayMainMenu() {
        switch (state) {
            case WAIT_FOR_ACTION:
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
                break;
            case WAIT_FOR_COFFEE_VARIANT:
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, " +
                        "back - to main menu: ");
                break;
            default:
                System.out.println("Fault! Wrong status of the machine.");
        }
    }

    public boolean checkUserInput(String userDecision) {
        boolean exit = true;
        switch (state) {
            case WAIT_FOR_ACTION:
                switch (userDecision) {
                    case "buy":
                        state = MachineState.WAIT_FOR_COFFEE_VARIANT;
                        break;

                    case "fill":
                        fillCoffeeMachine();
                        break;

                    case "take":
                        takeCoffeeMachineMoney();
                        break;

                    case "remaining":
                        displayCoffeeMachineStatus();
                        break;

                    case "exit":
                        exit = false;
                        break;

                    default:
                        System.out.println("Wrong input.");

                }
                break;
            case WAIT_FOR_COFFEE_VARIANT:
                switch (userDecision) {
                    case "1":  //Espresso
                        buyCoffee(CoffeeType.ESPRESSO.water, CoffeeType.ESPRESSO.milk, CoffeeType.ESPRESSO.beans,
                                CoffeeType.ESPRESSO.cost);
                        break;

                    case "2":  // Latte
                        buyCoffee(CoffeeType.LATTE.water, CoffeeType.LATTE.milk, CoffeeType.LATTE.beans,
                                CoffeeType.LATTE.cost);
                        break;

                    case "3": // Cappuccino
                        buyCoffee(CoffeeType.CAPPUCCINO.water, CoffeeType.CAPPUCCINO.milk, CoffeeType.CAPPUCCINO.beans,
                                CoffeeType.CAPPUCCINO.cost);
                        break;

                    case "back":
                        state = MachineState.WAIT_FOR_ACTION;
                        break;

                    default:
                        System.out.println("Wrong input.");

                }
                break;
            default:
                System.out.println("Wrong status of the machine!");
        }
        return exit;
    }

    private void buyCoffee(int water, int milk, int coffeeBeans, int cost) {
        if (disposableCups > 0 && this.waterMagazine >= water && this.milkMagazine >= milk
                && this. coffeeBeansMagazine >= coffeeBeans) {
            System.out.println("I have enough resources, making you a coffee!");
            this.waterMagazine -= water;
            this.milkMagazine -= milk;
            this.coffeeBeansMagazine -= coffeeBeans;
            this.money += cost;
            this.disposableCups -= 1;
        } else if (this.waterMagazine < water) {
            System.out.println("Sorry, not enough water!");
        } else if (this.milkMagazine < milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (this.coffeeBeansMagazine < coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else {
            System.out.println("Error!");
        }
        state = MachineState.WAIT_FOR_ACTION;
    }

    private void fillCoffeeMachine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has: ");
        this.waterMagazine += scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        this.milkMagazine += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        this.coffeeBeansMagazine += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        this.disposableCups += scanner.nextInt();

    }

    private void takeCoffeeMachineMoney() {
        System.out.println("I gave you $" + this.money);
        this.money = 0;
    }


}
