/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Message;

import Agents.MetaAgent;
import Agents.PortalTypes;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adam Duboczky, Tom Taylor, Nicol Reid, Connor Hird
 */
public class UserMsgTest
{
    /**
     * Test of getUserMessage method, of class UserMsg.
     */
    @Test
    public void testGetUserMessage()
    {
        System.out.println("Testing the method getUserMessage");
        UserMsg instance = new UserMsg(PortalTypes.ATC.toString(), "tom", "Hi", "Adam", PortalTypes.BROAD.toString());
        String expResult = "Hi";
        String result = instance.getUserMessage();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDestination method, of class UserMsg.
     */
    @Test
    public void testGetDestination()
    {
        System.out.println("Testing the method getDestination");
        UserMsg instance = new UserMsg(PortalTypes.ATC.toString(), "tom", "Hi", "Adam", PortalTypes.BROAD.toString());
        String expResult = "tom";
        String result = instance.getDestination();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSender method, of class UserMsg.
     */
    @Test
    public void testGetSender()
    {
        System.out.println("Testing the method getSender");
        UserMsg instance = new UserMsg(PortalTypes.ATC.toString(), "tom", "Hi", "Adam", PortalTypes.BROAD.toString());
        String expResult = "Adam";
        String result = instance.getSender();
        System.out.println(result);
        assertEquals(expResult, result);

    }

    /**
     * Test of getSysMessage method, of class UserMsg.
     */
    @Test
    public void testGetSysMessage()
    {
        System.out.println("Testing the method getSysMessage");
        UserMsg instance = new UserMsg(PortalTypes.ATC.toString(), "tom", "Hi", "Adam", PortalTypes.BROAD.toString());
        SysMsgTypes expResult = null;
        SysMsgTypes result = instance.getSysMessage();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDestPortType method, of class UserMsg.
     */
    @Test
    public void testGetDestPortType()
    {
        System.out.println("getDestPortType");
        UserMsg instance = new UserMsg(PortalTypes.ATC.toString(), "tom", "Hi", "Adam", PortalTypes.BROAD.toString());
        String expResult = "ATC";
        String result = instance.getDestPortType();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSenderPort method, of class UserMsg.
     */
    @Test
    public void testGetSenderPort()
    {
        System.out.println("getSenderPort");
        UserMsg instance = new UserMsg(PortalTypes.ATC.toString(), "tom", "Hi", "Adam", PortalTypes.BROAD.toString());
        String expResult = "BROAD";
        String result = instance.getSenderPort();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAgent method, of class UserMsg.
     */
    @Test
    public void testGetAgent()
    {
        System.out.println("Testing the method getAgent");
        UserMsg instance = new UserMsg(PortalTypes.ATC.toString(), "tom", "Hi", "Adam", PortalTypes.BROAD.toString());
        MetaAgent expResult = null;
        MetaAgent result = instance.getAgent();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getHopCount method, of class UserMsg.
     */
    @Test
    public void testGetHopCount()
    {
        System.out.println("Testing the method getHopCount");
        UserMsg instance = new UserMsg(PortalTypes.ATC.toString(), "tom", "Hi", "Adam", PortalTypes.BROAD.toString());
        int expResult = 0;
        int result = instance.getHopCount();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastAgent method, of class UserMsg.
     */
    @Test
    public void testGetLastAgent()
    {
        System.out.println("Testing method getLastAgent");
        UserMsg instance = new UserMsg(PortalTypes.ATC.toString(), "tom", "Hi", "Adam", PortalTypes.BROAD.toString());
        String expResult = "Adam";
        String result = instance.getLastAgent();
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
}
