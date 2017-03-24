package com.sg.sitelab.unitconverter;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Calculations {
    
    // ROUTING because I *still* don't know how to work it into DAO logic
    
    public double routeConversionType(String conversionType, String unitFrom, String unitTo, double number) {
        double result = 0;
        switch (conversionType) {
            case "Area":
                result = routeConvertArea(unitFrom, unitTo, number);
                break;
            case "Length":
                result = routeConvertLength(unitFrom, unitTo, number);
                break;                
            case "Mass":
                result = routeConvertMass(unitFrom, unitTo, number);
                break;                
            case "Temperature":
                result = routeConvertTemperature(unitFrom, unitTo, number);
                break;                
            case "Volume":
                result = routeConvertVolume(unitFrom, unitTo, number);
                break;                
        }
        return result;
    }
    public double routeConvertArea(String unitFrom, String unitTo, double number) {
        double result = 0;
        switch(unitFrom) {
            case "Square Meter":
                result = calculateSquareMeter(unitTo, number);
                break;
            case "Hectare":
                result = calculateHectare(unitTo, number);
                break;
            case "Square Inch":
                result = calculateSquareInch(unitTo, number);
                break;
            case "Square Foot":
                result = calculateSquareFoot(unitTo, number);
                break;
            case "Square Mile":
                result = calculateSquareMile(unitTo, number);
                break;
            case "Acre":
                result = calculateAcre(unitTo, number);
                break;
        }
        return result;
    }
    public double routeConvertLength(String unitFrom, String unitTo, double number) {
        double result = 0;
        switch(unitFrom) {
            case "Millimeter":
                result = calculateMillimeter(unitTo, number);
                break;
            case "Centimeter":
                result = calculateCentimeter(unitTo, number);
                break;
            case "Meter":
                result = calculateMeter(unitTo, number);
                break;
            case "Kilometer":
                result = calculateKilometer(unitTo, number);
                break;
            case "Inch":
                result = calculateInch(unitTo, number);
                break;
            case "Foot":
                result = calculateFoot(unitTo, number);
                break;
            case "Yard":
                result = calculateYard(unitTo, number);
                break;
            case "Mile":
                result = calculateMile(unitTo, number);
                break;
        }
        return result;
    }
    public double routeConvertMass(String unitFrom, String unitTo, double number) {
        double result = 0;
        switch(unitFrom) {
            case "Milligram":
                result = calculateMilligram(unitTo, number);
                break;
            case "Gram":
                result = calculateGram(unitTo, number);
                break;
            case "Kilogram":
                result = calculateKilogram(unitTo, number);
                break;
            case "Ounce":
                result = calculateOunce(unitTo, number);
                break;
            case "Pound":
                result = calculatePound(unitTo, number);
                break;
            case "Stone":
                result = calculateStone(unitTo, number);
                break;
        }
        return result;
    }
    public double routeConvertTemperature(String unitFrom, String unitTo, double number) {
        double result = 0;
        switch(unitFrom) {
            case "Celsius":
                result = calculateCelsius(unitTo, number);
                break;
            case "Fahrenheit":
                result = calculateFahrenheit(unitTo, number);
                break;
            case "Kelvin":
                result = calculateKelvin(unitTo, number);
                break;
        }
        return result;
    }
    public double routeConvertVolume(String unitFrom, String unitTo, double number) {
        double result = 0;
        switch(unitFrom) {
            case "Milliliter":
                result = calculateMilliliter(unitTo, number);
                break;
            case "Liter":
                result = calculateLiter(unitTo, number);
                break;
            case "US Fluid Ounce":
                result = calculateUsFluidOunce(unitTo, number);
                break;
            case "US Cup":
                result = calculateUsCup(unitTo, number);
                break;
            case "US Pint":
                result = calculateUsPint(unitTo, number);
                break;
            case "US Quart":
                result = calculateUsQuart(unitTo, number);
                break;
            case "US Gallon":
                result = calculateUsGallon(unitTo, number);
                break;
        }
        return result;
    }    
    

    // AREA CALCULATIONS
    public double calculateSquareMeter(String unitTo, double number) {
        double result = 0;
        switch(unitTo) {
            case "Square Meter":
                result = number;
                break;
            case "Hectare":
                result = number * 0.0001;
                break;
            case "Square Inch":
                result = number * 1550.0031;
                break;
            case "Square Foot":
                result = number * 10.763910417;
                break;
            case "Square Mile":
                result = number * 3.861018768E-7;
                break;
            case "Acre":
                result = number * 0.0002471054;
                break;
        }
        return result;
    }
    public double calculateHectare(String unitTo, double number) {
        double result = 0;
        switch(unitTo) {
            case "Square Meter":
                result = number * 10000;
                break;
            case "Hectare":
                result = number;
                break;
            case "Square Inch":
                result = number * 15500031;
                break;
            case "Square Foot":
                result = number * 107639.10417;
                break;
            case "Square Mile":
                result = number * 0.0038610188;
                break;
            case "Acre":
                result = number * 2.4710538147;
                break;
        }
        return result;
    }
    public double calculateSquareInch(String unitTo, double number) {
        double result = 0;
        switch(unitTo) {
            case "Square Meter":
                result = number * 0.00064516;
                break;
            case "Hectare":
                result = number * 6.4516E-8;
                break;
            case "Square Inch":
                result = number;
                break;
            case "Square Foot":
                result = number * 0.0069444444;
                break;
            case "Square Mile":
                result = number * 2.490974868E-10;
                break;
            case "Acre":
                result = number * 1.594225079E-7;
                break;
        }
        return result;
    }
    public double calculateSquareFoot(String unitTo, double number) {
        double result = 0;
        switch(unitTo) {
            case "Square Meter":
                result = number * 0.09290304;
                break;
            case "Hectare":
                result = number * 0.0000092903;
                break;
            case "Square Inch":
                result = number * 144;
                break;
            case "Square Foot":
                result = number;
                break;
            case "Square Mile":
                result = number * 3.58700381E-8;
                break;
            case "Acre":
                result = number * 0.0000229568;
                break;
        }
        return result;
    }
    public double calculateSquareMile(String unitTo, double number) {
        double result = 0;
        switch(unitTo) {
            case "Square Meter":
                result = number * 2589990;
                break;
            case "Hectare":
                result = number * 258.999;
                break;
            case "Square Inch":
                result = number * 4014492529L;
                break;
            case "Square Foot":
                result = number * 27878420.34;
                break;
            case "Square Mile":
                result = number;
                break;
            case "Acre":
                result = number * 640.00046695;
                break;
        }
        return result;
    }
    public double calculateAcre(String unitTo, double number) {
        double result = 0;
        switch(unitTo) {
            case "Square Meter":
                result = number * 4046.8564224;
                break;
            case "Hectare":
                result = number * 0.4046856422;
                break;
            case "Square Inch":
                result = number * 6272640;
                break;
            case "Square Foot":
                result = number * 43560;
                break;
            case "Square Mile":
                result = number * 0.0015624989;
                break;
            case "Acre":
                result = number;
                break;
        }
        return result;
    }
    
    // LENGTH CALCULATIONS
    public double calculateMillimeter(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Millimeter":
                result = number;
                break;
            case "Centimeter":
                result = number * 0.1;
                break;
            case "Meter":
                result = number * 0.001;
                break;
            case "Kilometer":
                result = number * 0.000001;
                break;
            case "Inch":
                result = number* 0.0393700787;
                break;
            case "Foot":
                result = number * 0.0032808399;
                break;
            case "Yard":
                result = number * 0.0010936133;
                break;
            case "Mile":
                result = number * 6.213688756E-7;
                break;
        }
        return result;
    }
    public double calculateCentimeter(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Millimeter":
                result = number * 10;
                break;
            case "Centimeter":
                result = number;
                break;
            case "Meter":
                result = number * 0.01;
                break;
            case "Kilometer":
                result = number * 0.00001;
                break;
            case "Inch":
                result = number* 0.3937007874;
                break;
            case "Foot":
                result = number * 0.032808399;
                break;
            case "Yard":
                result = number * 0.010936133;
                break;
            case "Mile":
                result = number * 0.0000062137;
                break;
        }
        return result;
    }
    public double calculateMeter(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Millimeter":
                result = number * 1000;
                break;
            case "Centimeter":
                result = number * 100;
                break;
            case "Meter":
                result = number;
                break;
            case "Kilometer":
                result = number * 0.001;
                break;
            case "Inch":
                result = number* 39.37007874;
                break;
            case "Foot":
                result = number * 3.280839895;
                break;
            case "Yard":
                result = number * 1.0936132983;
                break;
            case "Mile":
                result = number * 0.0006213689;
                break;
        }
        return result;
    }
    public double calculateKilometer(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Millimeter":
                result = number * 1000000;
                break;
            case "Centimeter":
                result = number * 100000;
                break;
            case "Meter":
                result = number * 1000;
                break;
            case "Kilometer":
                result = number;
                break;
            case "Inch":
                result = number* 39370.07874;
                break;
            case "Foot":
                result = number * 3280.839895;
                break;
            case "Yard":
                result = number * 1093.6132983;
                break;
            case "Mile":
                result = number * 0.6213688756;
                break;
        }
        return result;
    }
    public double calculateInch(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Millimeter":
                result = number * 25.4;
                break;
            case "Centimeter":
                result = number * 2.54;
                break;
            case "Meter":
                result = number * 0.0254;
                break;
            case "Kilometer":
                result = number * 0.0000254;
                break;
            case "Inch":
                result = number;
                break;
            case "Foot":
                result = number * 0.0833333333;
                break;
            case "Yard":
                result = number * 0.0277777778;
                break;
            case "Mile":
                result = number * 0.0000157828;
                break;
        }
        return result;
    }
    public double calculateFoot(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Millimeter":
                result = number * 304.8;
                break;
            case "Centimeter":
                result = number * 30.48;
                break;
            case "Meter":
                result = number * 0.3048;
                break;
            case "Kilometer":
                result = number * 0.0003048;
                break;
            case "Inch":
                result = number * 12;
                break;
            case "Foot":
                result = number;
                break;
            case "Yard":
                result = number * 0.3333333333;
                break;
            case "Mile":
                result = number * 0.0001893932;
                break;
        }
        return result;
    }
    public double calculateYard(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Millimeter":
                result = number * 914.4;
                break;
            case "Centimeter":
                result = number * 91.44;
                break;
            case "Meter":
                result = number * 0.9144;
                break;
            case "Kilometer":
                result = number * 0.0009144;
                break;
            case "Inch":
                result = number * 36;
                break;
            case "Foot":
                result = number * 3;
                break;
            case "Yard":
                result = number;
                break;
            case "Mile":
                result = number * 0.0005681797;
                break;
        }
        return result;
    }
    public double calculateMile(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Millimeter":
                result = number * 1609350;
                break;
            case "Centimeter":
                result = number * 160935;
                break;
            case "Meter":
                result = number * 1609.35;
                break;
            case "Kilometer":
                result = number * 1.60935;
                break;
            case "Inch":
                result = number * 63360.23622;
                break;
            case "Foot":
                result = number * 5280.019685;
                break;
            case "Yard":
                result = number * 1760.0065617;
                break;
            case "Mile":
                result = number;
                break;
        }
        return result;
    }
    
    // MASS CALCULATIONS
    public double calculateMilligram(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Milligram":
                result = number;
                break;
            case "Gram":
                result = number * 0.001;
                break;
            case "Kilogram":
                result = number * 0.000001;
                break;
            case "Ounce":
                result = number * 0.000035274;
                break;
            case "Pound":
                result = number * 0.0000022046;
                break;
            case "Stone":
                result = number * 1.5747E-7;
                break;
        }
        return result;
    }
    public double calculateGram(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Milligram":
                result = number * 1000;
                break;
            case "Gram":
                result = number;
                break;
            case "Kilogram":
                result = number * 0.001;
                break;
            case "Ounce":
                result = number * 0.0352739907;
                break;
            case "Pound":
                result = number * 0.0022046244;
                break;
            case "Stone":
                result = number * 0.0001574699999914;
                break;
        }
        return result;
    }
    public double calculateKilogram(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Milligram":
                result = number * 1000000;
                break;
            case "Gram":
                result = number * 1000;
                break;
            case "Kilogram":
                result = number;
                break;
            case "Ounce":
                result = number * 35.273990723;
                break;
            case "Pound":
                result = number * 2.2046244202;
                break;
            case "Stone":
                result = number * 0.1574699999914;
                break;
        }
        return result;
    }
    public double calculateOunce(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Milligram":
                result = number * 28349.5;
                break;
            case "Gram":
                result = number * 28.3495;
                break;
            case "Kilogram":
                result = number * 0.0283495;
                break;
            case "Ounce":
                result = number;
                break;
            case "Pound":
                result = number * 0.0625;
                break;
            case "Stone":
                result = number * 0.00446429;
                break;
        }
        return result;
    }
    public double calculatePound(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Milligram":
                result = number * 453592;
                break;
            case "Gram":
                result = number * 453.592;
                break;
            case "Kilogram":
                result = number * 0.453592;
                break;
            case "Ounce":
                result = number * 16;
                break;
            case "Pound":
                result = number;
                break;
            case "Stone":
                result = number * 0.0714286;
                break;
        }
        return result;
    }
    public double calculateStone(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Milligram":
                result = number * 6.35E+6;
                break;
            case "Gram":
                result = number * 6350.29;
                break;
            case "Kilogram":
                result = number * 6.35029;
                break;
            case "Ounce":
                result = number * 224;
                break;
            case "Pound":
                result = number * 14;
                break;
            case "Stone":
                result = number;
                break;
        }
        return result;
    }
   
    // TEMPERATURE CALCULATIONS
    public double calculateCelsius(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Celsius":
                result = number;
                break;
            case "Fahrenheit":
                result = (number * 9)/5 + 32;
                break;
            case "Kelvin":
                result = number + 273.15;
                break;
        }
        return result;
    }
    public double calculateFahrenheit(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Celsius":
                result = ((number - 32) * 5)/9;
                break;
            case "Fahrenheit":
                result = number;
                break;
            case "Kelvin":
                result = ((number + 459.67) * 5)/9;
                break;
        }
        return result;
    }
    public double calculateKelvin(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Celsius":
                result = number - 273.15;
                break;
            case "Fahrenheit":
                result = (number * 9)/5 - 459.67;
                break;
            case "Kelvin":
                result = number;
                break;
        }
        return result;
    }

    // VOLUME CALCULATIONS
    public double calculateMilliliter(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Milliliter":
                result = number;
                break;
            case "Liter":
                result = number * 0.001;
                break;
            case "US Fluid Ounce":
                result = number * 0.0338140386;
                break;
            case "US Cup":
                result = number * 0.0042267548;
                break;
            case "US Pint":
                result = number * 0.0021133774;
                break;
            case "US Quart":
                result = number * 0.0010566887;
                break;
            case "US Gallon":
                result = number * 0.0002641722;
                break;
        }
        return result;
    }
    public double calculateLiter(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Milliliter":
                result = number * 1000;
                break;
            case "Liter":
                result = number;
                break;
            case "US Fluid Ounce":
                result = number * 33.814038638;
                break;
            case "US Cup":
                result = number * 4.2267548297;
                break;
            case "US Pint":
                result = number * 2.1133774149;
                break;
            case "US Quart":
                result = number * 1.0566887074;
                break;
            case "US Gallon":
                result = number * 0.2641721769;
                break;
        }
        return result;
    }
    public double calculateUsFluidOunce(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Milliliter":
                result = number * 29.573515625;
                break;
            case "Liter":
                result = number * 0.0295735156;
                break;
            case "US Fluid Ounce":
                result = number;
                break;
            case "US Cup":
                result = number * 0.125;
                break;
            case "US Pint":
                result = number * 0.0625;
                break;
            case "US Quart":
                result = number * 0.03125;
                break;
            case "US Gallon":
                result = number * 0.0078125;
                break;
        }
        return result;
    }
    public double calculateUsCup(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Milliliter":
                result = number * 236.588125;
                break;
            case "Liter":
                result = number * 0.236588125;
                break;
            case "US Fluid Ounce":
                result = number * 8;
                break;
            case "US Cup":
                result = number;
                break;
            case "US Pint":
                result = number * 0.5;
                break;
            case "US Quart":
                result = number * 0.25;
                break;
            case "US Gallon":
                result = number * 0.0625;
                break;
        }
        return result;
    }
    public double calculateUsPint(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Milliliter":
                result = number * 473.17625;
                break;
            case "Liter":
                result = number * 0.47317625;
                break;
            case "US Fluid Ounce":
                result = number * 16;
                break;
            case "US Cup":
                result = number * 2;
                break;
            case "US Pint":
                result = number;
                break;
            case "US Quart":
                result = number * 0.5;
                break;
            case "US Gallon":
                result = number * 0.125;
                break;
        }
        return result;
    }
    public double calculateUsQuart(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Milliliter":
                result = number * 946.3525;
                break;
            case "Liter":
                result = number * 0.9463525;
                break;
            case "US Fluid Ounce":
                result = number * 32;
                break;
            case "US Cup":
                result = number * 4;
                break;
            case "US Pint":
                result = number * 2;
                break;
            case "US Quart":
                result = number;
                break;
            case "US Gallon":
                result = number * 0.25;
                break;
        }
        return result;
    }
    public double calculateUsGallon(String unitTo, double number){
        double result = 0;
        switch(unitTo) {
            case "Milliliter":
                result = number * 3785.41;
                break;
            case "Liter":
                result = number * 3.78541;
                break;
            case "US Fluid Ounce":
                result = number * 128;
                break;
            case "US Cup":
                result = number * 16;
                break;
            case "US Pint":
                result = number * 8;
                break;
            case "US Quart":
                result = number * 4;
                break;
            case "US Gallon":
                result = number;
                break;
        }
        return result;
    }
    
}
