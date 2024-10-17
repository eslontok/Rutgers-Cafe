package com.example.project5;

/**
 * MenuItem class (abstract) creates a MenuItem (YeastDonut, CakeDonut, DonutHoleDonut, Coffee) object
 * @author Earl Lontok, Aristeidis Stoupas
 */
public abstract class MenuItem {
    private int quantity;

    /**
     * Constructor for the MenuItem class
     * @param q the quantity of the MenuItem
     */
    public MenuItem(int q){
        quantity = q;
    }

    /**
     * Abstract method to be implemented in classes that extend the MenuItem class
     * (YeastDonut, CakeDonut, DonutHoleDonut, Coffee)
     * Determines the price of the MenuItem
     * @return the price of the MenuItem
     */
    public abstract double itemPrice();

    /**
     * Gets the quantity of the MenuItem
     * @return the quantity of the MenuItem
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * Abstract method to be implemented in classes that extend the MenuItem class
     * (YeastDonut, CakeDonut, DonutHoleDonut, Coffee)
     * Converts the MenuItem object into a string
     * @return the MenuItem object as a string
     */
    @Override
    public abstract String toString();

    /**
     * Abstract method to be implemented in classes that extend the MenuItem class
     * (YeastDonut, CakeDonut, DonutHoleDonut, Coffee)
     * Gets the flavor of the MenuItem
     * @return the flavor of the MenuItem
     */
    public abstract String getFlavor();

}
