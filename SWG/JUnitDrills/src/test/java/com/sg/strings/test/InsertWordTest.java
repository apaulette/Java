package com.sg.strings.test;

import com.sg.strings.InsertWord;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class InsertWordTest {
  
    InsertWord testMe = new InsertWord();
    
    public InsertWordTest() {
    }
    
    //Given an "out" String length 4, such as "<<>>", and a word , return
    //a new String where the word is in the middle of the out String,
    //e.g. "<<word>>".
    //Hint: SubStrings are your friend here
    
    @Test
    public void test() {
        
        //insertWord("<<>>", "Yay") -> "<<Yay>>"
        assertEquals("<<Yay>>", testMe.insertWord("<<>>", "Yay"));
        // 
        //insertWord("<<>>", "WooHoo") -> "<<WooHoo>>"
        assertEquals("<<WooHoo>>", testMe.insertWord("<<>>", "WooHoo"));
        // 
        //insertWord("[[]]", "word") -> "[[word]]"        
        assertEquals("[[word]]", testMe.insertWord("[[]]", "word"));
        
    }

}