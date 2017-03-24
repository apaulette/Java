package com.sg.strings.test;

import com.sg.strings.MakeTags;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class MakeTagsTest {
    
    MakeTags testMe = new MakeTags();

    public MakeTagsTest() {
    }
    
    // The web is built with HTML Strings like "<i>Yay</i>" which draws Yay 
    // as italic text. In this example, the "i" tag makes <i> and </i> which 
    // surround the word "Yay". Given tag and word Strings, create the HTML 
    // String with tags around the word, e.g. "<i>Yay</i>". 

    @Test
    public void testMakeTags() {
        
        //makeTags("i", "Yay") -> "<i>Yay</i>"
        assertEquals("<i>Yay</i>", testMe.makeTags("i", "Yay"));

        //makeTags("i", "Hello") -> "<i>Hello</i>"
        assertEquals("<i>Hello</i>", testMe.makeTags("i", "Hello"));

        //makeTags("cite", "Yay") -> "<cite>Yay</cite>"
        assertEquals("<cite>Yay</cite>", testMe.makeTags("cite", "Yay"));

    }

}