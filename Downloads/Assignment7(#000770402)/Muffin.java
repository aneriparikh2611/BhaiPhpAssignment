/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7;

import java.util.Scanner;

/**
 *
 * @author Aneri Parikh #000770402
 */
public class Muffin extends TimsProduct implements Consumable {

    private String description;
    private int calorieCount;
    /**
     * 
     * @param name
     * @param discription
     * @param cost
     * @param price
     * @param calories 
     */
    private Muffin(String name, String discription, double cost, double price, int calories) {
        super(name, cost, price);
        this.description = discription;
        calorieCount = calories;
    }
    /**
     * method created
     * @return 
     */
    public static Muffin create() {
        boolean flag = false;
        int choice = 0;
        while (!flag) {
            Scanner s = new Scanner(System.in);

            System.out.println("1: chocolate chips  2: Blueberry 3: apple Pecan");
            System.out.println("Enter Muffin type: ");
            choice = s.nextInt();
            if (choice == 1 || choice == 2 || choice == 3) {

                flag = true;
            }
        }

        switch (choice) {
            case 1:
                return new Muffin("Muffin : chocolate chips", "made with real chocolate", 0.50, 1.50, 220);

            case 2:
                return new Muffin("Muffin : Blueberry", "made with real Blueberry", 0.70, 1.70, 270);

            case 3:
                return new Muffin("Muffin : apple Pecan", "made with real apple Pecan", 0.80, 1.80, 220);

        }
        return null;

    }
    /**
     * 
     * @return caloriecount
     */
    @Override
    public int getCalorieCount() {
        return calorieCount;
    }
    /**
     * 
     * @return eat
     */
    @Override
    public String getConsumptionMethod() {
        return "Eat";
    }
    /**
     * 
     * @return description
     */
    public String getDescription() {
        return description;
    }
    /**
     * 
     * @return toString method
     */
    @Override
    public String toString() {
        return super.toString() + "[ discription : " + description + " calorieCount : " + calorieCount +"]" ;
    }

}
