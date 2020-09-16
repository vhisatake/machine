package machine;
import java.util.Objects;
import java.util.Scanner;



public class CoffeeMachine {
    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private int cash = 550;

    private final int espressoWater = 250;
    private final int espressoBean = 16;
    private final int espressoCost = 4;

    private final int latteWater = 350;
    private final int latteMilk = 75;
    private final int latteBean = 20;
    private final int latteCost = 7;

    private final int cappWater = 200;
    private final int cappMilk = 100;
    private final int cappBean = 12;
    private final int cappCost = 6;

    private Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) {
        CoffeeMachine cm = new CoffeeMachine();
        cm.getAction();

    }

    private void getAction() {
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String command = scanner.next();
            System.out.println();

            if (command.equals("exit")) {
                break;
            } else if (command.equals("buy")) {
                buy();
            } else if (command.equals("fill")) {
                fill();
            } else if (command.equals("remaining")) {
                remaining();
            } else if (command.equals("take")) {
                take();
            }
            System.out.println();
        }


    }

    private void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups do you want to add:");
        cups += scanner.nextInt();
    }

    private void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + cash + " of money");
    }



    private void take() {
        System.out.println("I gave you $" + cash);
        cash = 0;

    }

    private void buy() {


        while (true) {
            System.out.println("What do you want to buy?" +
                    " 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
            String command = scanner.next();
            if (command.equals("back")) {
                break;
            } else if (command.equals("1")) {
                if (water >= espressoWater && beans >= espressoBean && cups != 0) {
                    System.out.println("I have enough resources, making you a coffee");
                    cash += espressoCost;
                    water -= espressoWater;
                    beans -= espressoBean;
                    cups--;
                }
                else if (water < espressoWater) {
                    System.out.println("Sorry, not enough water!");
                }
                else if (beans < espressoBean) {
                    System.out.println("Sorry not enough beans!");
                }
                else if (cups == 0) {
                    System.out.println("Sorry, not enough cups!");
                }
                break;
            } else if (command.equals("2")) {
                if (water >= latteWater && milk >= latteMilk && beans >= espressoBean && cups != 0) {
                    System.out.println("I have enough resources, making you a coffee");
                    cash += latteCost;
                    water -= latteWater;
                    milk -= latteMilk;
                    beans -= latteBean;
                    cups--;
                } else if (water < latteWater) {
                    System.out.println("Sorry, not enough water!");
                } else if (milk < latteMilk) {
                    System.out.println("Sorry not enough milk!");
                } else if (beans < latteBean) {
                    System.out.println("Sorry not enough beans!");
                } else if (cups == 0) {
                    System.out.println("Sorry, not enough cups!");
                }
                break;
            } else if (command.equals("3")) {
                if (water >= cappWater && milk >= cappMilk && beans >= cappBean && cups != 0) {
                    System.out.println("I have enough resources, making you a coffee");
                    cash += cappCost;
                    water -= cappWater;
                    milk -= cappMilk;
                    beans -= cappBean;
                    cups--;
                }
                else if (water < cappWater) {
                    System.out.println("Sorry, not enough water!");
                }
                else if (milk < cappMilk) {
                    System.out.println("Sorry not enough milk!");
                }
                else if (beans < cappBean) {
                    System.out.println("Sorry not enough beans!");
                }
                else if (cups == 0) {
                    System.out.println("Sorry, not enough cups!");
                }
                break;
            }

        }
    }


}
