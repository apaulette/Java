package com.sg.sitelab.unitconverter;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class ConversionObject {
    
    private String conversionType;
    private String unitFrom;
    private String unitTo;
    private double number;
    private double convertedNumber;
    
    
    public String getConversionType() {
        return conversionType;
    }
    
    public void setConversionType(String conversionType) {
        this.conversionType = conversionType;
    }

    public String getUnitFrom() {
        return unitFrom;
    }

    public void setUnitFrom(String unitFrom) {
        this.unitFrom = unitFrom;
    }

    public String getUnitTo() {
        return unitTo;
    }

    public void setUnitTo(String unitTo) {
        this.unitTo = unitTo;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public double getConvertedNumber() {
        return convertedNumber;
    }

    public void setConvertedNumber(double convertedNumber) {
        this.convertedNumber = convertedNumber;
    }
    
    @Override
    public String toString(){
        String output = this.number + " " + this.unitFrom + " = " + this.convertedNumber + " " + this.unitTo;
        return output;
    }
    
}
