package com.sg.sitelab.tipcalculator;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class TipCalculatorDaoInMemImpl implements TipCalculatorDao {
    
    private TipCalculatorModel tipCalc;
    
    public TipCalculatorDaoInMemImpl() {
        tipCalc = new TipCalculatorModel();
    }
    
    @Override
    public TipCalculatorModel returnTipCalc() {
        return tipCalc;
    }
    
    @Override
    public void resetTipCalc() {
        tipCalc.setCheckAmount(0);
        tipCalc.setTipPercent(0);
        tipCalc.setTipAmount(0);
        tipCalc.setTotalAmount(0);
    }
    
}
