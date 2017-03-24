/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.List;
import java.util.Locale;



/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class ApplicationUI {
    
    private ConsoleIO cons = new ConsoleIO();
    
    public void printWelcomeScreen() {
        cons.printString("========================================"
                     + "\n|            WELCOME TO THE            |"
                     + "\n|   SWC CORP FLOORING INC. LTD. LLC.   |"
                     + "\n|   ORDER ADMINISTRATION APPLICATION   |"
                     + "\n========================================");
    }
    
    public void printMainMenu() {
        cons.printString("\n==============  MAIN MENU  =============\n"
                + "1.\tSet Date and Save\n"
                + "2.\tAdd an Order\n"
                + "3.\tDisplay All Orders\n"
                + "4.\tEdit an Order\n"
                + "5.\tRemove an Order\n"
                + "6.\tQuit\n");
    }
    
    public void printExitMessage() {
        cons.printString("\nGOODBYE!");
    }

    public String promptForDate() {
        
        String date = cons.readString("\u25B6 Enter your desired date as MMDDYYYY, or ENTER to use today's date:"
                + "\n  (For example, for October 25 1986, your entry would be 10251986)");
        if (date.isEmpty()) {
            date = LocalDate.now().toString();
            date = formatDateToSpec(date);
        } else {
            try {
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
//                formatter = formatter.withLocale(Locale.US).withResolverStyle(ResolverStyle.SMART);
//                date = LocalDate.parse(date, formatter).toString();
                LocalDate parsedDate = cons.parseDate(date, "MMddyyyy");
                date = formatDateToSpec(parsedDate.toString());
                
            } catch (Exception e) {
                cons.printString("\n\u25B3 ERROR: Date request format is not valid. Please check and try again.");
                date = "";
            }
        }
        return date;
    }
    
    private String formatDateToSpec (String date) {
        // Maybe the *good* answer is lurking around somewhere more in DateTimeFormatter?
        // Until then, substrings it is, I guess.
        return date.substring(5, 7) + date.substring(8) + date.substring(0, 4);
    }
    
    public String thwartChicanery(String string) {
        String newString = string.replaceAll("[^\\d.]", "");
        return newString;
    }

}