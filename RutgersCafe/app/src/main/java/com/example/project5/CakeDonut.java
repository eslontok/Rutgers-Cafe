package com.example.project5;
/**
 * CakeDonut class (extends MenuItem) creates a CakeDonut object
 * @author Earl Lontok, Aristeidis Stoupas
 */
public class CakeDonut extends MenuItem {
    private double cost;
    private String flavor;

    /**
     * Constructor for the CakeDonut class
     * @param flavor the flavor of the CakeDonut
     * @param quantity the quantity of the CakeDonut
     */
    public CakeDonut(String flavor, int quantity) {
        super(quantity);
        cost = Constant.CAKE_PRICE;
        this.flavor = flavor;
    }

    /**
     * Calculates the price of the CakeDonut(s)
     * @return the price of the CakeDonut(s)
     */
    public double itemPrice(){
        return cost * getQuantity();
    }

    /**
     * Converts the CakeDonut object into a String
     * @return the CakeDonut object as a string
     */
    public String toString(){
        return flavor + "(" + this.getQuantity() + ")";
    }

    /**
     * Gets the flavor of the CakeDonut
     * @return the flavor of the CakeDonut
     */
    public String getFlavor(){
        return flavor;
    }
}
