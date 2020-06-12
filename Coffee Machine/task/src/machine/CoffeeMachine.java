package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has: ");
        int waterMagazine = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milkMagazine = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int coffeeBeansMagazine = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int userOrder = scanner.nextInt();

        // How many cups is possible to make?
        int howManyCupsWater = waterMagazine / 200;
        int howManyCupsMilk= milkMagazine / 50;
        int howManyCupsCoffeeBeans = coffeeBeansMagazine / 15;
        int howManyCupsPossible = Math.min(Math.min(howManyCupsWater, howManyCupsMilk), howManyCupsCoffeeBeans);
        if (howManyCupsPossible == userOrder) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (howManyCupsPossible > userOrder) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (howManyCupsPossible - userOrder) + " more than that)");
        } else {
            System.out.println("No, I can make only " + howManyCupsPossible + " cup(s) of coffee");
        }

    }
}
