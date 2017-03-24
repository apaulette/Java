package com.sg.conditionals.test;

import com.sg.conditionals.RemoveDel;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class RemoveDelTest {

    RemoveDel testMe = new RemoveDel();

    public RemoveDelTest() {
    }

    // Given a String, if the String "del" appears starting at index 1, 
    // return a String where that "del" has been deleted. Otherwise, 
    // return the String unchanged. 

    @Test
    public void testRemoveDel() {
        // removeDel("adelbc") -> "abc"
        assertEquals("abc", testMe.removeDel("adelbc"));
        // removeDel("adelHello") -> "aHello"
        assertEquals("aHello", testMe.removeDel("adelHello"));
        // removeDel("adedbc") -> "adedbc"
        assertEquals("adedbc", testMe.removeDel("adedbc"));
    }

}