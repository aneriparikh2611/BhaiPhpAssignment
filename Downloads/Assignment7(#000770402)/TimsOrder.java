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
public class TimsOrder {
    /*
    variable declaration 
    */
    private int size;
    private String name;
    static TimsOrder timsorder;
    static TimsProduct[] timsproduct;

    private TimsOrder(String name, int size) {
        this.size = size;
        this.name = name;
    }
    /**
     * create method
     * @return timsorder
     */
    public static TimsOrder create() {
        System.out.println("Enter Name:");
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        System.out.println("Enter number of item that you order");
        int size = s.nextInt();
        timsorder = new TimsOrder(name, size);
        timsproduct = new TimsProduct[size];
        for (int i = 0; i < size; i++) {
            /*
            validation 
            */
            boolean flag = false;
            int choice = 0;
            while (!flag) {
                System.out.println("enter your Choice of item. [1 : Mug , 2 : Donut , 3 : Muffin , 4 : TimsCard]");

                choice = s.nextInt();
                if (choice == 1 || choice == 2 || choice == 3 || choice == 4) {

                    flag = true;
                }
            }
            switch (choice) {
                case 1:
                    timsproduct[i] = Mug.create();
                    break;

                case 2:
                    timsproduct[i] = Donut.create();
                    break;

                case 3:
                    timsproduct[i] = Muffin.create();
                    break;

                case 4:
                    timsproduct[i] = TimsCard.create();
                    break;

            }
        }

        return timsorder;
    }
    /**
     * 
     * @return totalamount
     */
    public double getAmountDue() {

        double totalamount = 0;
        for (int i = 0; i < timsproduct.length; i++) {
            totalamount = totalamount + timsproduct[i].getRetailPrice();
        }
        return totalamount;
    }
    /**
     * 
     * @return toString
     */
    @Override
    public String toString() {
        String Fianl = "summary of Order \n--------------------\n Order for: "  + name + " \n " ;
        String msg = " ";
        for (int i = 0; i < timsproduct.length; i++) {
            msg = msg + timsproduct[i].toString() + "\n";
        }
        return Fianl + msg;
    }

}
