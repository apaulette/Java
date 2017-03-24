package com.sg.flooringmastery.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class ConsoleIO {

    private Scanner sc = new Scanner(System.in);

    public Integer readInt() {
        int result = sc.nextInt();
        return result;
    }
    
    public Integer readInt(String param) {
        boolean badInput;
        int result = 0;
        do {
            try {
                System.out.println(param);
                result = sc.nextInt();
                badInput = false;
            } catch (InputMismatchException ime) {
                badInput = true;
                sc.nextLine();
            }
        } while (badInput);
        return result;
    }
    
    public Integer readInt(String param, int min, int max) {
        int result;
        do {
            result = readInt(param);
        } while (result < min || result > max);
        return result;
    }
    
    
    public Float readFloat() {
        Float result = sc.nextFloat();
        return result;
    }

    public Float readFloat(String param) {
        System.out.println(param);
        Float result = sc.nextFloat();
        return result;
    }

    public Float readFloat(String param, Float min, Float max) {
        Boolean valid = false;
        System.out.println(param);
        Float result = sc.nextFloat();
        do {
            if (result < min || result > max) {
                System.out.println(param + " between " + min + " and " + max + ":");
                result = sc.nextFloat();
            } else {
                valid = true;
                break;
            }
        } while (valid == false);
        return result;
    }
    
    
    public double readDouble() {
        double result = sc.nextDouble();
        return result;
    }
    
    public double readDouble(String param) {
        boolean badInput;
        double result = 0;
        do {
            try {
                System.out.println(param);
                result = sc.nextDouble();
                badInput = false;
            } catch (InputMismatchException ime) {
                badInput = true;
                sc.nextLine();
            }
        } while (badInput);
        return result;
    }
    
    public double readDouble(String param, double min, double max) {
        double result;
        do {
            result = readDouble(param);
        } while (result < min || result > max);
        return result;
    }    
    
    public String readString() {
        Scanner newSc = new Scanner(System.in);
        String result = newSc.nextLine().replace("\t", "");
        return result;
    }    
    public String readString(String param) {
        Scanner newSc = new Scanner(System.in);
        System.out.println(param);
        String result = newSc.nextLine().replace("\t", "");
        return result;
    }
    
    public void printString(String param) {
        System.out.println(param);
    }
    
    public LocalDate parseDate(String date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        formatter = formatter.withLocale(Locale.US).withResolverStyle(ResolverStyle.SMART);
        LocalDate parsedDate = LocalDate.parse(date, formatter);
        return parsedDate;
    }
    
    public String formatArrayToString(List listName) {
        String text = listName.toString().replace("[", "").replace("]", "");
        return text;
    }
  
    public String formatLongArrayToColumns(List listName, int everyX, String delimiter, String lineEnd) {
        // Okay, this is completely nuts. There *has* to be a better way to do this, 
        // but my StackOverflow Google-fu has failed me so far.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listName.size(); i++) {
            
            if (i % everyX == 0 && i != 0) {
                sb.append(listName.get(i));
                sb.append(lineEnd);
            } else if (i == listName.size() - 1) {
                sb.append(listName.get(i));
            } else {
                sb.append(listName.get(i));
                sb.append(delimiter);
            }
        }
        String text = sb.toString();
        return text;
    }    
    
}