package com.sg.arrays.test;

import com.sg.arrays.MakePi;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class MakePiTest {
    
    MakePi testIt = new MakePi();

    public MakePiTest() {
    }
    
    //    Return an int array length n containing the first n digits of pi.
    
    @Test
    public void testMakePi() {
        //    makePi(3) -> {3, 1, 4}
        int[] array1 = new int[]{3, 1, 4};
        Assert.assertArrayEquals(array1, testIt.makePi(3));
        
        //    makePi(16) -> {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3}
        int[] array2 = new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3};
        Assert.assertArrayEquals(array2, testIt.makePi(16));
        
        //    makePi(11) -> {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5}
        int[] array3 = new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        Assert.assertArrayEquals(array3, testIt.makePi(11));
        
        //    makePi(7) -> {3, 1, 4, 1, 5, 9, 2}
        int[] array4 = new int[]{3, 1, 4, 1, 5, 9, 2};
        Assert.assertArrayEquals(array4, testIt.makePi(7)); 

    }
    
}
