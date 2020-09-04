package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Machine machine = new Machine();

        machine.start();
    }
}

class Machine {
    public Scanner scanner = new Scanner(System.in);

    public int coffeePerUnit = 15;
    public int waterPerUnit = 200;
    public int milkPerUnit = 50;
    public int unitWanted;
    public int coffeeAmount;
    public int waterAmount;
    public int milkAmount;

    public void start() {
        fillResources();
    }

    public void fillResources() {
        System.out.println("Write how many ml of water the coffee machine has:");
        waterAmount = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        milkAmount = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        coffeeAmount = scanner.nextInt();
        resourcesCalculation();
    }

    public void resourcesCalculation () {

        int waterCount = 0;
        while (waterAmount >= waterPerUnit) {
            waterAmount -= waterPerUnit;
            waterCount++;
        }

        int milkCount = 0;
        while (milkAmount >= milkPerUnit) {
            milkAmount -= milkPerUnit;
            milkCount++;
        }

        int coffeeCount = 0;
        while (coffeeAmount >= coffeePerUnit) {
            coffeeAmount -= coffeePerUnit;
            coffeeCount++;
        }

        int min = findMinimumValue(waterCount, milkCount, coffeeCount);

        order(min);

    }

    public int findMinimumValue(int waterCount, int milkCount, int coffeeCount) {
        int min;
         if(waterCount <= milkCount && waterCount <= coffeeCount) {
             min = waterCount;
         } else if (milkCount <= waterCount && milkCount <= coffeeCount) {
             min = milkCount;
         } else {
             min = coffeeCount;
         }
         return min;
    }

    public void order(int min) {
        System.out.println("Write how many cups of coffee you will need: ");
        unitWanted = scanner.nextInt();

        if (unitWanted == min) {
            System.out.println("Yes, I can make that amount of coffee");
        }

        if (unitWanted < min) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (unitWanted - min) + " more than that)");
        }

        if (unitWanted > min) {
            System.out.println("No, I can make only " + min + " cup(s) of coffee");
        }
    }
}

/*
 System.out.println("For " + unitWanted + " cups of coffee you will need:");
        int totalWater = waterPerUnit * unitWanted;
        int totalMilk = milkPerUnit * unitWanted;
        int totalCoffee = coffeePerUnit * unitWanted;

        System.out.println(totalWater + " ml of water");
        System.out.println(totalMilk + " ml of milk");
        System.out.println(totalCoffee + " g of coffee beans");
 */
