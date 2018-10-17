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
public class Mug extends TimsProduct {

    private Color color;
    /**
     * 
     * @param name
     * @param color
     * @param cost
     * @param price 
     */
    public Mug(String name, Color color, double cost, double price) {
        super(name, cost, price);
        this.color = color;
    }
    /**
     * method created
     * @return 
     */
    public static Mug create() {
        boolean flag = false;
        int choice = 0;
        while (!flag) {
            Scanner s = new Scanner(System.in);

            System.out.println("1: Red Mug  2: Blue Mug 3: Green Mug");
            System.out.println("Enter Mug type: ");
            choice = s.nextInt();
            if (choice == 1 || choice == 2 || choice == 3) {

                flag = true;
            }
        }

        switch (choice) {
            case 1:
                return new Mug("Mug", Color.BLUE, 20, 30);

            case 2:
                return new Mug("Mug", Color.GREEN, 20, 30);

            case 3:
                return new Mug("Mug", Color.RED, 20, 30);

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
        return super.toString() + " [ color :" + color +"]";
    }

}
