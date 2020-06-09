import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int duration = scanner.nextInt();
        int foodCostPerDay = scanner.nextInt();
        int oneWayFlightCost = scanner.nextInt();
        int oneNightCost = scanner.nextInt();

        System.out.println((duration - 1) * oneNightCost
                + duration * foodCostPerDay
                + 2 * oneWayFlightCost);
    }
}