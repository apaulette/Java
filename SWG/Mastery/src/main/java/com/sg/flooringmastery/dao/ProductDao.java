package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Product;
import java.util.ArrayList;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public interface ProductDao {

    void loadData();
    ArrayList<Product> retrieveProductList();
    Boolean checkForProduct(String targetProduct);
    String retrieveProductType(String targetProduct);
    double retrieveMaterialCostPerSqFoot(String targetProduct);
    double retrieveLaborCostPerSqFoot(String targetProduct);

}
