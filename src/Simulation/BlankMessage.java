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
 *Simulates what happens when a user sends/receives a blank message
 * @author Dub_2
 */
public class BlankMessage
{
    public static ExecutorService exec = new ThreadPoolExecutor(5, 10, 2, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

    public static void main(String[] args)
    {
        MonitorManager manager = new MonitorManager();
        exec.execute(manager);
        //Create a portal for the agents
        MetaAgent portal = new Portal(PortalTypes.ATC, null , exec);
        NodeMonitor monitor = new NodeMonitor();
        portal.addMonitor(monitor);
        manager.addMonitor(monitor);
        exec.execute(portal);
        
        //Add agents
        MetaAgent a1 = new UserAgent("Adam", portal, exec);
        MetaAgent a2 = new UserAgent("Bob", portal, exec);
        
        a1.sendMessage(PortalTypes.ATC, "Bob", "");
    }
}
