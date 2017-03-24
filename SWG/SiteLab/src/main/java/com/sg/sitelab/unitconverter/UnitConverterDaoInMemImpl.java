package com.sg.sitelab.unitconverter;


/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class UnitConverterDaoInMemImpl implements UnitConverterDao {
    
    @Override
    public ConversionObject createConversionObject() {
        ConversionObject object = new ConversionObject();
        return object;
    }
     
}
