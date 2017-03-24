package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public interface OrderDao {

    void addOrder(Order newOrder);
    ArrayList<Order> retrieveAllOrders();
    void updateOrder(Order targetOrder, Order updatedOrder);
    Order findOrder(int orderNumber);
    int generateOrderNumber();
    public ArrayList<String> retrieveAllOrderNumbers();
    void removeOrder(Order targetOrder);
    Boolean checkForExistingOrderNumber(String requestedOrderNumber);
    Boolean checkForExistingFile(String date);
    void loadData(String date);
    void saveData(String date);

}
