package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Tax;
import com.sg.flooringmastery.ui.ConsoleIO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class TaxDaoFileImpl implements TaxDao {
    
    private final String FILE_NAME;
    private ArrayList<Tax> taxList;
    private final String DELIM = "\t";

    public TaxDaoFileImpl() {
        FILE_NAME = "data/tax.txt";
        taxList = new ArrayList<>();
    }    
    
    @Override
    public void loadData() {

        try (Scanner readFileIn = new Scanner(new BufferedReader(new FileReader(FILE_NAME)))) {
            String currentLine;
            String[] field;

            while (readFileIn.hasNextLine()) {
                currentLine = readFileIn.nextLine();
                field = currentLine.split(DELIM);
                
                Tax newTax = new Tax();
                newTax.setState(field[0]);
                newTax.setTaxRate(Double.parseDouble(field[1]));
                taxList.add(newTax);
            }
            readFileIn.close();
        } catch (FileNotFoundException fnf) {
            // catch error
        }
    }

    @Override
    public ArrayList<Tax> retrieveTaxList() {
        return taxList;
    }
    
    @Override
    public Boolean checkForState(String targetState) {
        boolean stateInList = false;
        for (Tax tax : taxList) {
            if (tax.getState().equalsIgnoreCase(targetState)) {
                stateInList = true;
            }
        }        
        return stateInList;
    }
    
    @Override
    public String retrieveState(String targetState) {
        String state = null;
        for (Tax tax : taxList) {
            if (tax.getState().equalsIgnoreCase(targetState)) {
                state = tax.getState();
            }
        }
        return state;
    }

    @Override
    public double retrieveTaxRate(String targetState) {
        double taxRate = 0;
        String state = null;
        for (Tax tax : taxList) {
            if (tax.getState().equalsIgnoreCase(targetState)) {
                taxRate = tax.getTaxRate();
            }
        }
        return taxRate;
    }

    
}
