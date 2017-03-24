package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Tax;
import java.util.ArrayList;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public interface TaxDao {

    void loadData();
    ArrayList<Tax> retrieveTaxList();
    Boolean checkForState(String targetState);
    String retrieveState(String state);
    double retrieveTaxRate(String state);
}
