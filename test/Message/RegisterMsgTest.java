/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Message;

import Agents.MetaAgent;
import Agents.UserAgent;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Adam Duboczky, Tom Taylor, Nicol Reid, Connor Hird
 */
public class RegisterMsgTest
{
    
    /**
     * Test of getAgent method, of class RegisterMsg.
     */
    @Test
    public void testGetAgent()
    {
        System.out.println("Testing the method getAgent");
        MetaAgent adam = new UserAgent("Adam", null, null);
        RegisterMsg instance = new RegisterMsg(adam);
        MetaAgent expResult = adam;
        MetaAgent result = instance.getAgent();
        System.out.println(result.getName());
        assertEquals(expResult, result);
    }

    /**
     * Test of getHopCount method, of class RegisterMsg.
     */
    @Test
    public void testGetHopCount()
    {
        System.out.println("Testing the method getHopCount");
        MetaAgent adam = new UserAgent("Adam", null, null);
        RegisterMsg instance = new RegisterMsg(adam); 
        int expResult = 1;
        int result = instance.getHopCount();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastAgent method, of class RegisterMsg.
     */
    @Test
    public void testGetLastAgent()
    {
        System.out.println("Testing the method getLastAgent");
        MetaAgent adam = new UserAgent("Adam", null, null);
        RegisterMsg instance = new RegisterMsg(adam);
        String expResult = "Adam";
        String result = instance.getLastAgent();
        System.out.println(result);        
        assertEquals(expResult, result);
    }
    
}
