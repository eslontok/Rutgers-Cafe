package com.example.project5;
/**
 * YeastDonut class (extends MenuItem) creates a YeastDonut object
 * @author Earl Lontok, Aristeidis Stoupas
 */
public class YeastDonut extends MenuItem {

    private double cost;
    private String flavor;

    /**
     * Constructor for the YeastDonut class
     * @param flavor the flavor of the YeastDonut
     * @param quantity the quantity of the YeastDonut
     */
    public YeastDonut(String flavor, int quantity) {
        super(quantity);
        cost = Constant.YEAST_PRICE;
        this.flavor = flavor;
    }

    /**
     * Calculates the price of the YeastDonut(s)
     * @return the price of the YeastDonut(s)
     */
    public double itemPrice(){
        return cost * getQuantity();
    }

    /**
     * Converts the YeastDonut object into a string
     * @return the YeastDonut object as a string
     */
    public String toString(){
        return flavor + "(" + this.getQuantity() + ")";
    }

    /**
     * Gets the flavor of the YeastDonut
     * @return the flavor of the YeastDonut
     */
    public String getFlavor(){
        return flavor;
    }

}
