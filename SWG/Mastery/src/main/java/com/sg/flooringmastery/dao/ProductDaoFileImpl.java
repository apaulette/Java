package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class ProductDaoFileImpl implements ProductDao {

    private final String FILE_NAME;
    private ArrayList<Product> productList;
    private final String DELIM = "\t";

    public ProductDaoFileImpl() {
        FILE_NAME = "data/product.txt";
        productList = new ArrayList<>();
    }

    @Override
    public void loadData() {

        try (Scanner readFileIn = new Scanner(new BufferedReader(new FileReader(FILE_NAME)))) {
            String currentLine;
            String[] field;

            while (readFileIn.hasNextLine()) {
                currentLine = readFileIn.nextLine();
                field = currentLine.split(DELIM);

                Product newProduct = new Product();
                newProduct.setProductType(field[0]);
                newProduct.setMaterialCostPerSqFoot(Double.parseDouble(field[1]));
                newProduct.setLaborCostPerSqFoot(Double.parseDouble(field[2]));
                productList.add(newProduct);
            }
            readFileIn.close();
        } catch (FileNotFoundException fnf) {
            // catch error
        }
    }

    @Override
    public ArrayList<Product> retrieveProductList() {
        return productList;
    }
    
    @Override
    public Boolean checkForProduct(String targetProduct) {
        boolean productInList = false;
        for (Product product : productList) {
            if (product.getProductType().equalsIgnoreCase(targetProduct)){
                productInList = true;
            }
        }        
        return productInList;
    }

    @Override
    public String retrieveProductType(String targetProduct) {
        String productType = null;
        for (Product product : productList) {
            if (product.getProductType().equalsIgnoreCase(targetProduct)) {
                productType = product.getProductType();
            }
        }
        return productType;
    }

    @Override
    public double retrieveMaterialCostPerSqFoot(String targetProduct) {
        double materialCost = 0;
        for (Product product : productList) {
            if (product.getProductType().equalsIgnoreCase(targetProduct)) {
                materialCost = product.getMaterialCostPerSqFoot();
            }
        }
        return materialCost;
    }

    @Override
    public double retrieveLaborCostPerSqFoot(String targetProduct) {
        double laborCost = 0;
        for (Product product : productList) {
            if (product.getProductType().equalsIgnoreCase(targetProduct)) {
                laborCost = product.getLaborCostPerSqFoot();
            }
        }
        return laborCost;
    }

}