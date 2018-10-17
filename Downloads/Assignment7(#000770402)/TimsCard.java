/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7;

import java.awt.Color;
import java.util.Scanner;

/**
 *
 * @author Aneri Parikh #000770402
 */
public class TimsCard extends TimsProduct {

    private Color color;
    /**
     * 
     * @param name
     * @param cost
     * @param price 
     */
    public TimsCard(String name, double cost, double price) {
        super(name, cost, price);
    }
    /**
     * method created
     * @return 
     */
    public static TimsCard create() {
        boolean flag = false;
        int choice = 0;
        while (!flag) {
            Scanner s = new Scanner(System.in);

            System.out.println("1: $50 credits  2: $25 credits 3: $20 credits");
            System.out.println("Enter TimsCard type: ");
            choice = s.nextInt();
            if (choice == 1 || choice == 2 || choice == 3) {

                flag = true;
            }
        }

        switch (choice) {
            case 1:
                return new TimsCard("TimsCard : $50 credits ", 40, 50);

            case 2:
                return new TimsCard("TimsCard : $25 credits", 17, 25);

            case 3:
                return new TimsCard("TimsCard : $20 credits", 20, 25);

        }
        return null;

    }
    /**
     * 
     * @return color
     */
    public Color getColor() {
        return color;
    }
    /**
     * 
     * @return toString method
     */
    @Override
    public String toString() {
        return super.toString() + " [ color :" + color +"]" ;
    }

}
