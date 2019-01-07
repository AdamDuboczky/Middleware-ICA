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
 * @author Adam
 */
public class PortalToPortalLink
{

    public static ExecutorService exec = new ThreadPoolExecutor(5, 10, 2, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //Create the monitor manager for the monitoring
        MonitorManager manager = new MonitorManager();
        exec.execute(manager);
        
        //Creates a hub which all the portals are connected to
        MetaAgent hub = new PortalHub(PortalTypes.HUB, null, exec);
        //Create the node monitor
        NodeMonitor n1 = new NodeMonitor();
        //Add the node monitor to the hub
        hub.addMonitor(n1);
        //Add the node monitor to the monitor manager
        manager.addMonitor(n1);
        exec.execute(hub);
        
        //Create the portals which link to the portal hub
        MetaAgent p1 = new Portal(PortalTypes.ATC, hub, exec);
        exec.execute(p1);
        MetaAgent p2 = new Portal(PortalTypes.BAG, hub, exec);
        exec.execute(p2);
        
        //Add new node monitors to the portals
        NodeMonitor n2 = new NodeMonitor();
        p1.addMonitor(n2);
        manager.addMonitor(n2);
        
        NodeMonitor n3 = new NodeMonitor();
        p2.addMonitor(n3);
        manager.addMonitor(n3);
        
        //Create user agents for the portals
        MetaAgent u1 = new UserAgent("Airplane", p1, exec);
        exec.execute(u1);
        MetaAgent u2 = new UserAgent("Baggage Clerk", p2, exec);
        exec.execute(u2);
        
        //Send message from u1 to u2 when having to route through different portals
        u2.sendMessage(PortalTypes.ATC, "Airplane", "Customer has just come through, please wait for them");
        u1.sendMessage(PortalTypes.BAG, "Baggage Clerk", "Okay!");
    }
    
}
