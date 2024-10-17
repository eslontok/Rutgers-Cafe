package com.example.project5;
/**
 * DonutHoleDonut class (extends MenuItem) creates a DonutHoleDonut object
 * @author Earl Lontok, Aristeidis Stoupas
 */
public class DonutHoleDonut extends MenuItem {

    private double cost;
    private String flavor;

    /**
     * Constructor for the DonutHoleDonut class
     * @param flavor the flavor of the DonutHoleDonut
     * @param quantity the quantity of the DonutHoleDonut
     */
    public DonutHoleDonut(String flavor, int quantity) {
        super(quantity);
        cost = Constant.DONUTHOLE_PRICE;
        this.flavor = flavor;
    }

    /**
     * Calculates the price of the DonutHoleDonut(s)
     * @return the price of the DonutHoleDonut(s)
     */
    public double itemPrice(){
        return cost * getQuantity();
    }

    /**
     * Converts the DonutHoleDonut object into a string
     * @return the DonutHoleDonut object as a string
     */
    public String toString(){
        return flavor + "(" + this.getQuantity() + ")";
    }

    /**
     * Gets the flavor of the DonutHoleDonut
     * @return the flavor of the DonutHoleDonut
     */
    public String getFlavor(){
        return flavor;
    }

}
