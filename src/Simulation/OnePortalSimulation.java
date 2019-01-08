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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *Simulates messages being sent to another agent on the same portal
 * @author Adam Duboczky, Tom Taylor, Nicol Reid, Connor Hird
 */
public class OnePortalSimulation
{

        public static ExecutorService exec = new ThreadPoolExecutor(5, 10, 2, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //Creates a MonitorManager that manges all the node monitors, pulling their information for inspection.
        MonitorManager manager = new MonitorManager();
        exec.execute(manager);
        
        //Create a portal
        MetaAgent p1 = new Portal(PortalTypes.ATC, null, exec);
        
        //Create a node monitor
        NodeMonitor n1 = new NodeMonitor();
        
        //Add the node monitor to the portal
        p1.addMonitor(n1);
        
        //Add the node monitor to the monitor manager
        manager.addMonitor(n1);
        
        //Create all of the agents
        MetaAgent a1 = new UserAgent("Cargo Plane", p1, exec);
        MetaAgent a2 = new UserAgent("Passenger Plane", p1, exec);
        
        //Send messages from the agents
        a1.sendMessage(PortalTypes.ATC, "Passenger Plane", "I'm landing now, don't attempt a landing");
        a2.sendMessage(PortalTypes.ATC, "Cargo Plane", "I was supposed to be landing now!");
        
    }
    //End of main    
}
//End of OnePortalSimulation
