/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import Agents.MetaAgent;
import Agents.Portal;
import Agents.PortalHub;
import Agents.PortalTypes;
import Agents.UserAgent;
import NodeMonitor.MonitorManager;
import NodeMonitor.NodeMonitor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Adam Duboczky, Tom Taylor, Nicol Reid, Connor Hird
 */
public class PostEstablished
{
    public static ExecutorService exec = new ThreadPoolExecutor(5, 10, 2, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //Creates a monitor manager to hold all the monitors
        MonitorManager manager = new MonitorManager();
        exec.execute(manager);
        
        //Create the portal hub
        MetaAgent hub = new PortalHub(PortalTypes.HUB, null, exec);
        NodeMonitor n1 = new NodeMonitor();
        hub.addMonitor(n1);
        manager.addMonitor(n1);
        exec.execute(hub);
        
        //Create portals and link to the hub
        MetaAgent p1 = new Portal(PortalTypes.ATC, hub, exec);
        NodeMonitor n2 = new NodeMonitor();
        p1.addMonitor(n2);
        manager.addMonitor(n2);
        exec.execute(p1);
        
        MetaAgent p2 = new Portal(PortalTypes.BAG, hub, exec);
        NodeMonitor n3 = new NodeMonitor();
        p2.addMonitor(n2);
        manager.addMonitor(n3);
        exec.execute(p2);
        
        //Create agents which link to the portals
        MetaAgent u1 = new UserAgent("Airplane", p1, exec);        
        MetaAgent u2 = new UserAgent("Baggage clerk", p2, exec);
        
        //Send messsages through the agents
        u1.sendMessage(PortalTypes.BAG, "Baggage clerk", "Hi");
        u2.sendMessage(PortalTypes.ATC, "Airplane", "Bye");
        
        //Register a new portal
        MetaAgent p3 = new Portal(PortalTypes.SEC, hub, exec);
//        NodeMonitor n4 = new NodeMonitor();
//        p3.addMonitor(n4);
//        manager.addMonitor(n4);
        exec.execute(p3);
        
        //Register new agents
        MetaAgent u3 = new UserAgent("Cargo Plane", p1, exec);        
        MetaAgent u4 = new UserAgent("Baggage Handler", p2, exec);        
        MetaAgent u5 = new UserAgent("Security guard", p3, exec);
        
        //Send messages through new agents
        u3.sendMessage(PortalTypes.BAG, "Baggage Handler", "WHERE ARE MY BAGS?!?!");        
        u4.sendMessage(PortalTypes.ATC, "Airplane", "Do you know de way?");        
        u5.sendMessage(PortalTypes.ATC, "Airplane", "THERES A TERRORIST");
        
        ///ISSUE WHEN MONITOR IS ACCESSING INFORMATION AND ANOTHER ONE GETS REGISTERED        
    }
    //End of main    
}
//End of PostEstablished
