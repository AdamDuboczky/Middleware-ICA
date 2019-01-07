/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NodeMonitor;

import Message.Message;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author T7056773
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
        System.out.println("updateMonitor");
        Message message = null;
        NodeMonitor instance = new NodeMonitor();
        instance.updateMonitor(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLogSize method, of class NodeMonitor.
     */
    @Test
    public void testGetLogSize() {
        System.out.println("getLogSize");
        NodeMonitor instance = new NodeMonitor();
        int expResult = 0;
        int result = instance.getLogSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of grabUpdate method, of class NodeMonitor.
     */
    @Test
    public void testGrabUpdate() {
        System.out.println("grabUpdate");
        int index = 0;
        NodeMonitor instance = new NodeMonitor();
        Message expResult = null;
        Message result = instance.grabUpdate(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
