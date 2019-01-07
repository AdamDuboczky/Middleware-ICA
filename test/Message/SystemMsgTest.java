/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Message;

import Agents.MetaAgent;
import Agents.PortalTypes;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dub_2
 */
public class SystemMsgTest
{
    /**
     * Test of getUserMessage method, of class SystemMsg.
     */
    @Test
    public void testGetUserMessage()
    {
        System.out.println("Testing the method getUserMessage");
        SystemMsg instance = new SystemMsg(new UserMsg(PortalTypes.ATC.toString(), "tom", "Hi", "Adam", 
                                            PortalTypes.HUB.toString()), "Adam", SysMsgTypes.VALID);
        String expResult = "Hi";
        String result = instance.getUserMessage();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDestination method, of class SystemMsg.
     */
    @Test
    public void testGetDestination()
    {
        System.out.println("Testing the method getDestination");
        SystemMsg instance = new SystemMsg(new UserMsg(PortalTypes.ATC.toString(), "tom", "Hi", "Adam", 
                                            PortalTypes.HUB.toString()), "Adam", SysMsgTypes.VALID);
        String expResult = "tom";
        String result = instance.getDestination();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSender method, of class SystemMsg.
     */
    @Test
    public void testGetSender()
    {
        System.out.println("Testing the method getSender");
        SystemMsg instance = new SystemMsg(new UserMsg(PortalTypes.ATC.toString(), "tom", "Hi", "Adam", 
                                            PortalTypes.HUB.toString()), "Adam", SysMsgTypes.VALID);
        String expResult = "Adam";
        String result = instance.getSender();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSysMessage method, of class SystemMsg.
     */
    @Test
    public void testGetSysMessage()
    {
        System.out.println("Testing the method getSysMessage");
        SystemMsg instance = new SystemMsg(new UserMsg(PortalTypes.ATC.toString(), "tom", "Hi", "Adam", 
                                            PortalTypes.HUB.toString()), "Adam", SysMsgTypes.VALID);
        SysMsgTypes expResult = SysMsgTypes.VALID;
        SysMsgTypes result = instance.getSysMessage();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDestPortType method, of class SystemMsg.
     */
    @Test
    public void testGetDestPortType()
    {
        System.out.println("Testing the method getDestPortType");
        SystemMsg instance = new SystemMsg(new UserMsg(PortalTypes.ATC.toString(), "tom", "Hi", "Adam", 
                                            PortalTypes.HUB.toString()), "Adam", SysMsgTypes.VALID);
        String expResult = "ATC";
        String result = instance.getDestPortType();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSenderPort method, of class SystemMsg.
     */
    @Test
    public void testGetSenderPort()
    {
        System.out.println("Testing the method getSenderPort");
        SystemMsg instance = new SystemMsg(new UserMsg(PortalTypes.ATC.toString(), "tom", "Hi", "Adam", 
                                            PortalTypes.HUB.toString()), "Adam", SysMsgTypes.VALID);
        String expResult = "HUB";
        String result = instance.getSenderPort();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAgent method, of class SystemMsg.
     */
    @Test
    public void testGetAgent()
    {
        System.out.println("Testing the method GetAgent");
        SystemMsg instance = new SystemMsg(new UserMsg(PortalTypes.ATC.toString(), "tom", "Hi", "Adam", 
                                            PortalTypes.HUB.toString()), "Adam", SysMsgTypes.VALID);
        MetaAgent expResult = null;
        MetaAgent result = instance.getAgent();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getHopCount method, of class SystemMsg.
     */
    @Test
    public void testGetHopCount()
    {
        System.out.println("Testing the method getHopCount");
        SystemMsg instance = new SystemMsg(new UserMsg(PortalTypes.ATC.toString(), "tom", "Hi", "Adam", 
                                            PortalTypes.HUB.toString()), "Adam", SysMsgTypes.VALID);
        int expResult = 1;
        int result = instance.getHopCount();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastAgent method, of class SystemMsg.
     */
    @Test
    public void testGetLastAgent()
    {
        System.out.println("Testing the method getLastAgent");
        SystemMsg instance = new SystemMsg(new UserMsg(PortalTypes.ATC.toString(), "tom", "Hi", "Adam", 
                                            PortalTypes.HUB.toString()), "Adam", SysMsgTypes.VALID);
        String expResult = "Adam";
        String result = instance.getLastAgent();
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
}
