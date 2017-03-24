/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sitelab.flooringcalculator;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class FlooringCalculatorDaoInMemImpl implements FlooringCalculatorDao {
    
    private FlooringCalculatorModel floorModel;
    
    public FlooringCalculatorDaoInMemImpl(){
        floorModel = new FlooringCalculatorModel();
    }
    
    @Override
    public FlooringCalculatorModel returnFloorModel() {
        return floorModel;
    }
    
    @Override
    public void resetFloorModel() {
        floorModel.setWidth(0);
        floorModel.setLength(0);
        floorModel.setArea(0);
        floorModel.setCostPerSqFt(0);
        floorModel.setInstallationTime("");
        floorModel.setBilledIncrements(0);
        floorModel.setTotalLaborCost(0);
        floorModel.setTotalMaterialCost(0);
    }    
}
