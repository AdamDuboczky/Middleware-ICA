/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NodeMonitor;

import Message.Message;
import Message.UserMsg;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 */
public class MonitorManagerTest {

    public MonitorManagerTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addMonitor method, of class MonitorManager.
     */
    //@Ignore
    @Test
    public void testAddMonitor() {
        System.out.println("Adding a monitor...");
        NodeMonitor monitor = new NodeMonitor();
        MonitorManager manager = new MonitorManager();
        manager.addMonitor(monitor);
        boolean expectedResult = true;
        boolean actualResult = manager.hasMonitor(monitor);
        assertEquals(expectedResult, actualResult);

    }

    /**
     * Test of removeMonitor method, of class MonitorManager.
     */
    //@Ignore
    @Test
    public void testRemoveMonitor() {
        System.out.println("Removing a monitor...");
        NodeMonitor monitor = new NodeMonitor();
        MonitorManager manager = new MonitorManager();
        manager.addMonitor(monitor);
        manager.removeMonitor(monitor);
        boolean expectedResult = false;
        boolean actualResult = manager.hasMonitor(monitor);
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Test of run method, of class MonitorManager.
     */
    //@Ignore
    @Test
    public void testRun() {
        System.out.println("Testing getting information for each  monitor...");
        MonitorManager instance = new MonitorManager();
        NodeMonitor monitor1 = new NodeMonitor();
        NodeMonitor monitor2 = new NodeMonitor();
        NodeMonitor monitor3 = new NodeMonitor();
        instance.addMonitor(monitor1);
        instance.addMonitor(monitor2);
        instance.addMonitor(monitor3);
        Message message1 = new UserMsg("ATC", "GRND","Hello from the high ground","Phil",null);
        Message message2 = new UserMsg("GRND", "ATC","Spillage on the runway","Alex",null);
        Message message3 = new UserMsg("SEC", "ATC","Please be aware of passenger X","Connor",null);
        Message message4 = new UserMsg("ATC", "PLANE","You are free to fly.","George",null);
        monitor1.updateMonitor(message1);
        monitor1.updateMonitor(message2);
        monitor1.updateMonitor(message3);
        monitor1.updateMonitor(message4);        
        (new Thread(instance)).start();
      
    }

}
