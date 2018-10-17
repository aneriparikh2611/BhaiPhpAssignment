/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7;

/**
 *
 * @author Aneri Parikh #000770402
 */
public abstract class TimsProduct implements Commodity {
    /*
    variable declaration 
    */
    private String name;
    private double cost;
    private double price;
    /*
    constractor
    */
    public TimsProduct(String name, double cost, double price) {
        this.name = name;
        this.cost = cost;
        this.price = price;
    }
    /**
     * 
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * 
     * @return cost
     */
    @Override
    public double getProductionCost() {
        return cost;
    }
    /**
     * 
     * @return price
     */
    @Override
    public double getRetailPrice() {
        return price;
    }
    /**
     * 
     * @return toString
     */
    @Override
    public String toString() {
        return "TimsProduct{  " + " name= " + name + ", cost= " + cost + ", price= " + price + "}";
    }

}
