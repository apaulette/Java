package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.util.ArrayList;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class OrderDaoInMemImpl implements OrderDao {

    private ArrayList<Order> allOrders;

    public OrderDaoInMemImpl() {
        allOrders = new ArrayList<>();
    }

    @Override
    public void addOrder(Order newOrder) {
        allOrders.add(newOrder);
    }

    @Override
    public ArrayList<Order> retrieveAllOrders() {
        return allOrders;
    }

    @Override
    public void updateOrder(Order targetOrder, Order updatedOrder) {
        allOrders.set(allOrders.indexOf(targetOrder), updatedOrder);
    }

    @Override
    public Order findOrder(int orderNumber) {
        Order targetOrder = null;
        for (Order order : allOrders) {
            if (order.getOrderNumber() == orderNumber) {
                targetOrder = order;
            }
        }
        return targetOrder;
    }

    @Override
    public void removeOrder(Order targetOrder) {
        allOrders.remove(targetOrder);
    }

    @Override
    public Boolean checkForExistingOrderNumber(String requestedOrderNumber) {
        boolean existingOrderNumber = false;
        for (Order order : allOrders) {
            if (order.getOrderNumber() == Integer.parseInt(requestedOrderNumber)) {
                existingOrderNumber = true;
            }
        }
        return existingOrderNumber;
    }

    @Override
    public int generateOrderNumber() {
        int maxOrderNumber = 0;
        if (allOrders.isEmpty()) {
            maxOrderNumber = 1;
        } else {
            for (int i = 0; i < allOrders.size(); i++) {
                if (allOrders.get(i).getOrderNumber() > maxOrderNumber) {
                    maxOrderNumber = allOrders.get(i).getOrderNumber();
                }
            }
            maxOrderNumber += 1;
        }
        return maxOrderNumber;
    }

    @Override
    public ArrayList<String> retrieveAllOrderNumbers() {
        ArrayList<String> allOrderNumbers = new ArrayList<String>();
        for (Order order : allOrders) {
            allOrderNumbers.add(String.valueOf(order.getOrderNumber()));
        }
        return allOrderNumbers;
    }
    
    @Override
    public Boolean checkForExistingFile(String date) {
        boolean existingFile = false;
        return existingFile;
    }
    
    @Override
    public void loadData(String date) {
    }

    @Override
    public void saveData(String date) {
    }

}
