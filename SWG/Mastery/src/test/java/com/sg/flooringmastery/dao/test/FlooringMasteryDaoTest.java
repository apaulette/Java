package com.sg.flooringmastery.dao.test;

import com.sg.flooringmastery.dao.OrderDao;
import com.sg.flooringmastery.dto.Order;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class FlooringMasteryDaoTest {

    OrderDao testDao;
    
    public FlooringMasteryDaoTest() {
    }
    
//    Order[] baseOrders = {
//        new Order(1, "Wise", "OH", 6.25, "Wood", 100.00, 5.15, 4.75, 515.00, 475.00, 61.88, 1051.88),
//        new Order(2, "West", "IN", 6.00, "Carpet", 248.50, 2.25, 2.10, 559.13, 521.85, 64.86, 1145.83),
//        new Order(3, "White", "PA", 6.25, "Wood", 128.33, 5.15, 4.75, 660.90, 609.57, 79.40, 1349.87),
//        new Order(4, "Mosher", "OH", 6.25, "Tile", 306.00, 3.50, 4.15, 1071.00, 1269.90, 146.31, 2487.21),
//        new Order(5, "Paulette", "VA", 5.30, "Laminate", 184.67, 1.75, 2.10, 323.17, 387.81, 37.68, 748.66),
//        new Order(6, "McDonald", "IL", 6.25, "Carpet", 186.25, 2.25, 2.10, 419.06, 391.13, 50.64, 860.82),
//        new Order(7, "Steele", "MO", 4.23, "Carpet", 178.00, 2.25, 2.10, 400.50, 373.80, 32.75, 807.05),
//        new Order(8, "Winston", "TN", 7.00, "Tile", 208.00, 3.50, 4.15, 728.00, 863.20, 111.38, 1702.58),
//        new Order(9, "Hamilton", "MN", 6.88, "Laminate", 189.00, 1.75, 2.10, 330.75, 396.90, 50.06, 777.71),
//        new Order(10, "Stephens", "ND", 5.00, "Carpet", 196.67, 2.25, 2.10, 442.50, 413.00, 42.78, 898.28)
//    };

    @Before
    public void setUpClass() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        testDao = (OrderDao) ctx.getBean("daoInMemImpl");
    }
    
    @Test
    public void testAddAndFindOrder() {
        // Just following Austyn's example of putting an object in and taking it back out
        Order newOrder1 = new Order(11, "Petersheim", "VA", 5.30, "Wood", 180.75, 5.15, 4.75, 930.86, 858.56, 94.84, 1884.26);
        testDao.addOrder(newOrder1);
        Order retrievedOrder = testDao.findOrder(11);
        
        // Check after first
        assertEquals(11, retrievedOrder.getOrderNumber());
        assertEquals("Petersheim", retrievedOrder.getCustomerName());
        assertEquals(1884.26, retrievedOrder.getTotalCost(), 0.0000000001);
        
        // Add a second order
        Order newOrder2 = new Order(12, "Beresford", "VA", 5.30, "Laminate", 187.75, 1.75, 2.10, 328.56, 394.28, 38.31, 761.15);
        testDao.addOrder(newOrder2);
        retrievedOrder = testDao.findOrder(12);
        
        // Check after second
        assertEquals("VA", retrievedOrder.getState());
        assertEquals("Laminate", retrievedOrder.getProductType());
        assertEquals(38.31, retrievedOrder.getTax(), 0.0000000001);
        
    }
    
    @Test
    public void testAddAndRemoveOrder() {
        Order newOrder3 = new Order(13, "Stillwell", "VA", 5.30, "Wood", 203.50, 5.15, 4.75, 1048.03, 966.63, 106.78, 2121.43);
        Order newOrder4 = new Order(14, "Ashley", "WV", 6.00, "Carpet", 201.00, 2.25, 2.10, 452.25, 422.10, 52.46, 926.81);
        // Add two
        testDao.addOrder(newOrder3);
        testDao.addOrder(newOrder4);
        // Remove the second
        testDao.removeOrder(newOrder4);
        // Check originals versus from in the array
        assertEquals("Stillwell", testDao.findOrder(newOrder3.getOrderNumber()).getCustomerName());
        assertEquals("Wood", testDao.findOrder(newOrder3.getOrderNumber()).getProductType());
        assertEquals(5.30, testDao.findOrder(newOrder3.getOrderNumber()).getTaxRate(), 0.0000000001);
        assertEquals(null, testDao.findOrder(newOrder4.getOrderNumber()));
    }
    
    @Test
    public void testAddAndRetrieveAll() {
        int beforeSize = testDao.retrieveAllOrders().size();
        
        Order newOrder5 = new Order(15, "Frank", "KY", 6.00, "Laminate", 192.00, 1.75, 2.10, 336.00, 403.20, 44.35, 783.55);        
        Order newOrder6 = new Order(16, "Hayes", "SD", 4.00, "Wood", 206.00, 5.15, 4.75, 1060.90, 978.50, 81.58, 2120.98);        
        testDao.addOrder(newOrder5);
        testDao.addOrder(newOrder6);
        
        int afterSize = testDao.retrieveAllOrders().size();
        // Compare sie before and after
        assertEquals(0, beforeSize);
        assertEquals(2, afterSize);
    }
    
    @Test
    public void testGenerateOrderNumber() {
        // Add two order, get a theoretical next order number
        Order newOrder1 = new Order(34, "Petersheim", "VA", 5.30, "Wood", 180.75, 5.15, 4.75, 930.86, 858.56, 94.84, 1884.26);
        Order newOrder2 = new Order(17, "Beresford", "VA", 5.30, "Laminate", 187.75, 1.75, 2.10, 328.56, 394.28, 38.31, 761.15);
        testDao.addOrder(newOrder1);
        testDao.addOrder(newOrder2);
        int newOrderNumber1 = testDao.generateOrderNumber();
        
        // Add two more
        Order newOrder3 = new Order(58, "Stillwell", "VA", 5.30, "Wood", 203.50, 5.15, 4.75, 1048.03, 966.63, 106.78, 2121.43);
        Order newOrder4 = new Order(42, "Ashley", "WV", 6.00, "Carpet", 201.00, 2.25, 2.10, 452.25, 422.10, 52.46, 926.81);
        testDao.addOrder(newOrder3);
        testDao.addOrder(newOrder4);
        int newOrderNumber2 = testDao.generateOrderNumber();
        
        // Lather, rinse, repeat
        Order newOrder5 = new Order(69, "Frank", "KY", 6.00, "Laminate", 192.00, 1.75, 2.10, 336.00, 403.20, 44.35, 783.55);        
        Order newOrder6 = new Order(86, "Hayes", "SD", 4.00, "Wood", 206.00, 5.15, 4.75, 1060.90, 978.50, 81.58, 2120.98);           
        testDao.addOrder(newOrder5);
        testDao.addOrder(newOrder6);
        int newOrderNumber3 = testDao.generateOrderNumber();
        
        // Test for all three
        assertEquals(35, newOrderNumber1);
        assertEquals(59, newOrderNumber2);
        assertEquals(87, newOrderNumber3);
    }
    
    @Test
    public void testUpdateOrder() {
        Order targetOrder = new Order(1, "Wise", "OH", 6.25, "Wood", 100.00, 5.15, 4.75, 515.00, 475.00, 61.88, 1051.88);
        testDao.addOrder(targetOrder);
        String customerNameBefore = testDao.findOrder(1).getCustomerName();
        double totalCostBefore = testDao.findOrder(1).getTotalCost();
        
        Order updatedOrder = new Order(15, "White", "PA", 6.25, "Wood", 128.33, 5.15, 4.75, 660.90, 609.57, 79.40, 1349.87);
        testDao.updateOrder(targetOrder, updatedOrder);
        
        String customerNameAfter = testDao.findOrder(15).getCustomerName();
        double totalCostAfter = testDao.findOrder(15).getTotalCost();
        
        assertEquals("Wise", customerNameBefore);
        assertEquals("White", customerNameAfter);
        assertEquals(1051.88, totalCostBefore, 0.0000000001);
        assertEquals(1349.87, totalCostAfter, 0.0000000001);
        
    }
    

}