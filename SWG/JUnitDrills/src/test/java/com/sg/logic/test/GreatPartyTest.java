package com.sg.logic.test;

import com.sg.logic.GreatParty;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class GreatPartyTest {
    
    GreatParty testIt = new GreatParty();

    public GreatPartyTest() {
    }

    // When squirrels get together for a party, they like to have 
    // cigars. A squirrel party is successful when the number of 
    // cigars is between 40 and 60, inclusive. Unless it is the 
    // weekend, in which case there is no upper bound on the number 
    // of cigars. Return true if the party with the given values is 
    // successful, or false otherwise. 
    
    @Test
    public void testGreatParty() {
        
        // greatParty(30, false) → false
        assertFalse(testIt.greatParty(30, false));
        
        // greatParty(50, false) → true
        assertTrue(testIt.greatParty(50, false));
        
        // greatParty(70, true) → true
        assertTrue(testIt.greatParty(70, true));

    }    
    
}
