/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NodeMonitor;

import Message.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class NodeMonitorTest {
    
    public NodeMonitorTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of updateMonitor method, of class NodeMonitor.
     */
    @Test
    public void testUpdateMonitor() {
        System.out.println("Updating monitor with a message");
        Message message = new UserMsg("ATC", "GRND","Hello from the high ground","Phil",null);
        NodeMonitor monitor = new NodeMonitor();
        monitor.updateMonitor(message);
        assertNotNull(monitor.grabUpdate(0));
    }

    /**
     * Test of getLogSize method, of class NodeMonitor.
     */
    @Test
    public void testGetLogSize() {
        System.out.println("Checking the log size...");
        NodeMonitor instance = new NodeMonitor();
        Message message1 = new UserMsg("ATC", "GRND","Hello","Phil",null);
        Message message2 = new UserMsg("GRND", "GRND","Bye","Alex",null);
        instance.updateMonitor(message1);
        instance.updateMonitor(message2);
        int expResult = 2;
        int result = instance.getLogSize();
        assertEquals(expResult, result);
        System.out.println("Log size: " + instance.getLogSize());
    }

    /**
     * Test of grabUpdate method, of class NodeMonitor.
     */
    @Test
    public void testGrabUpdate() {
        System.out.println("Getting a message from the monitor...");
        NodeMonitor instance = new NodeMonitor();
        Message message1 = new UserMsg("PLANE", "SEC","Snake on board.","Connor",null);
        instance.updateMonitor(message1);
        Message expResult = message1;
        Message result = instance.grabUpdate(0);
        assertEquals(expResult, result);
    }
    
}
