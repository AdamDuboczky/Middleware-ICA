/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Message;

import Agents.MetaAgent;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adam
 */
public class RegisterMsgTest
{   
    /**
     * Test of getLastAgent method, of class RegisterMsg.
     */
    @Test
    public void testGetLastAgent()
    {
        System.out.println("getLastAgent");
        RegisterMsg instance = null;
        String expResult = "";
        String result = instance.getLastAgent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
