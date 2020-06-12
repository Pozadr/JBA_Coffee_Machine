package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        coffeeMachine.menu();
    }

    private int waterMagazine;
    private int milkMagazine;
    private int coffeeBeansMagazine;
    private int disposableCups;
    private int money;

    public CoffeeMachine (int waterMagazine, int milkMagazine, int coffeeBeansMagazine, int disposableCups, int money) {
        this.waterMagazine = waterMagazine;
        this.milkMagazine = milkMagazine;
        this.coffeeBeansMagazine = coffeeBeansMagazine;
        this.disposableCups = disposableCups;
        this.money = money;
    }

    public void displayCoffeeMachineStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(waterMagazine + " of water");
        System.out.println(milkMagazine + " of milk");
        System.out.println(coffeeBeansMagazine + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public void menu() {
        boolean exit = true;
        Scanner scanner = new Scanner(System.in);
        while(exit) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String userDecision = scanner.next();
            switch (userDecision) {
                case "buy": {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, " +
                            "back - to main menu: ");
                    String userDecisionBuyCoffee = scanner.next();
                    switch (userDecisionBuyCoffee) {
                        case "1": {
                            buyCoffee(250,0, 16, 4);
                            break;
                        }
                        case "2": {
                            buyCoffee(350,75, 20, 7);
                            break;
                        }
                        case "3": {
                            buyCoffee(200,100, 12, 6);
                            break;
                        }
                        case "back": {
                            break;
                        }
                        default: {
                            System.out.println("Wrong input.");
                        }
                    }
                    break;
                }
                case "fill": {
                    fillCoffeeMachine();
                    break;
                }
                case "take": {
                    takeCoffeMachineMoney();
                    break;
                }
                case "remaining": {
                    displayCoffeeMachineStatus();
                    break;
                }
                case "exit": {
                    exit = false;
                    break;
                }
                default: {
                    System.out.println("Wrong input.");
                }
            }
        }
    }

    public void buyCoffee(int water, int milk, int coffeeBeans, int cost) {
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
    }

    public void fillCoffeeMachine() {
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

    public void takeCoffeMachineMoney() {
        System.out.println("I gave you $" + this.money);
        this.money = 0;
    }


}
