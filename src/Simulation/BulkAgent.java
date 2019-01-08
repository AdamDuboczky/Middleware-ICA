/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import Agents.MetaAgent;
import Agents.Portal;
import Agents.PortalTypes;
import Agents.UserAgent;
import NodeMonitor.MonitorManager;
import NodeMonitor.NodeMonitor;
import static Simulation.BulkMessage.exec;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Adam Duboczky, Tom Taylor, Nicol Reid, Connor Hird
 */
public class BulkAgent
{
    public static ExecutorService exec = new ThreadPoolExecutor(5, 10, 2, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //Creates a monitor manager for the node monitors
        MonitorManager manager = new MonitorManager();
        exec.execute(manager);
        
        //Create a portal for the agents
        MetaAgent portal = new Portal(PortalTypes.ATC, null, exec);
        NodeMonitor n1 = new NodeMonitor();
        portal.addMonitor(n1);
        manager.addMonitor(n1);
        exec.execute(portal);
        
        MetaAgent bob = new UserAgent("Bob", portal, exec);
        
        //Create the agents and send the messages
        for(int i = 0; i < 100; i++)
        {
            MetaAgent user = new UserAgent("Agent " + i, portal, exec);
            user.sendMessage(PortalTypes.ATC, "Bob", "I'm Agent" + i + " and i've registered with the portal");
        }
        
    }
    //End of main   
}
//End of BulkAgent
