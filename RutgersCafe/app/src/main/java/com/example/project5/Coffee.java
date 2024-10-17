package com.example.project5;

import java.util.ArrayList;
/**
 * Coffee class (extends MenuItem) creates a Coffee object
 * @author Earl Lontok, Aristeidis Stoupas
 */
public class Coffee extends MenuItem{
    private String size;
    private ArrayList<String> addons;

    /**
     * Constructor for the Coffee class
     * @param size the size of the Coffee
     * @param addons the list of addons for the Coffee
     * @param quantity the quantity of the Coffee
     */
    public Coffee(String size, ArrayList<String> addons, int quantity)
    {
        super(quantity);
        this.size = size;
        this.addons = addons;
    }

    /**
     * Calculates the price of the Coffee
     * @return the price of the Coffee
     */
    @Override
    public double itemPrice() {
        if(size.toLowerCase().equals("short")) {
            return (Constant.SHORT_PRICE + (addons.size() * Constant.ADD_INS)) * getQuantity();
        }
        else if(size.toLowerCase().equals("tall")) {
            return (Constant.TALL_PRICE + (addons.size() * Constant.ADD_INS)) * getQuantity();
        }
        else if(size.toLowerCase().equals("grande")) {
            return (Constant.GRANDE_PRICE + (addons.size() * Constant.ADD_INS)) * getQuantity();
        }
        else return (Constant.VENTI_PRICE + (addons.size() * Constant.ADD_INS)) * getQuantity();

        }

    /**
     * Converts the Coffee object into a String
     * @return the Coffee object as a string
     */
    public String toString(){
        String sAddons = "";

        if(addons.size() == 0)
        {
            return "Coffee(" + getQuantity() + ") " + size + " [NO ADD-INS]";
        }
        else{
            for(int i = 0; i < addons.size()-1; i++){
                sAddons += (addons.get(i) + ", ");
            }
            sAddons += (addons.get(addons.size()-1));
            return "Coffee(" + getQuantity() + ") " + size + " [" + sAddons + "]";
        }
    }

    /**
     * Gets the flavor of the Coffee
     * @return the flavor of the Coffee
     */
    @Override
    public String getFlavor() {
        return null;
    }

}
