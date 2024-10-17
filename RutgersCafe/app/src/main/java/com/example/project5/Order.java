package com.example.project5;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Order class creates an Order object (an Order contains a list of MenuItems)
 * @author Earl Lontok, Aristeidis Stoupas
 */
public class Order {

    DecimalFormat decForm = new DecimalFormat("#,###.00");
    private int orderNumber;
    private ArrayList<MenuItem> list = new ArrayList<MenuItem>();

    /**
     * Constructor for the Order class
     * @param x the order number of the Order
     */
    public Order(int x) {
        orderNumber = x;
    }

    /**
     * Adds a MenuItem to the Order ArrayList (list)
     * @param item the MenuItem to be added to the Order
     */
    public void add(MenuItem item){
        list.add(item);
    }

    /**
     * Removes a MenuItem from the Order ArrayList (list)
     * @param item the MenuItem to be removed from the Order
     */
    public void remove(MenuItem item){
        list.remove(item);
    }

    /**
     * Converts the Order object into a string - the resulting string is a list of the MenuItems in the Order
     * @return the Order object as a string
     */
    @Override
    public String toString(){

        String entireOrder = "Order#: " + this.orderNumber + "\n";
        for(int i = 0; i < list.size(); i++){
            MenuItem item = list.get(i);
            entireOrder += item + "\n";
        }
        double total = findTotal(this);
        entireOrder += "Total: $" + decForm.format(total);
        return entireOrder;

    }

    /**
     * A helper method the determines the total price (includes sales tax) of the Order
     * @param order the Order of interest
     * @return the total price (includes sales tax) of the Order
     */
    private double findTotal(Order order){

        double total = 0;
        double taxAmount = 0;
        for(int i = 0; i < order.getList().size(); i++){
            double itemPrice = order.getList().get(i).itemPrice();
            total += itemPrice;
        }
        taxAmount = total * Constant.SALES_TAX;
        total = total + taxAmount;
        return total;

    }

    /**
     * Gets the ArrayList (list) of the Order
     * @return the ArrayList (list) of the Order
     */
    public ArrayList<MenuItem> getList(){
        return list;
    }

    /**
     * Gets the order number of the Order
     * @return the order number of the Order
     */
    public int getOrderNumber(){
        return orderNumber;
    }


}
