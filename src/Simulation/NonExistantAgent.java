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
 *
 * @author Adam Duboczky, Tom Taylor, Nicol Reid, Connor Hird
 */
public class NonExistantAgent
{
    public static ExecutorService exec = new ThreadPoolExecutor(5, 10, 2, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //Create a monitor manager for node monitors
        MonitorManager manager = new MonitorManager();
        exec.execute(manager);
        
        //Creates a portal for the agents to register to
        MetaAgent portal = new Portal(PortalTypes.ATC, null, exec);
        NodeMonitor n1 = new NodeMonitor();
        portal.addMonitor(n1);
        manager.addMonitor(n1);
        
        //Creates an agent for the portal
        MetaAgent a = new UserAgent("Airplane", portal, exec);
        
        //Send a message from the agent to a non existant one
        a.sendMessage(PortalTypes.ATC, "Adam", "Hi"); 
        
    }
    //End of main    
}
//End of NonExistantAgent
