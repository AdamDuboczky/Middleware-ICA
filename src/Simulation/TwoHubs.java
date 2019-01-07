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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Adam
 */
public class TwoHubs
{
    public static ExecutorService exec = new ThreadPoolExecutor(5, 10, 2, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //Creates a monitor manager
        MonitorManager manager = new MonitorManager();
        exec.execute(manager);
        
        //Creates the portal hubs
        MetaAgent hub = new PortalHub(PortalTypes.HUB, null, exec);
        
        MetaAgent hub2 = new PortalHub(PortalTypes.HUB, hub, exec);
        
        hub.setSuperAgent(hub2);
        
        //Create portals for the hubs
        MetaAgent p1 = new Portal(PortalTypes.ATC, hub, exec);
        
        MetaAgent p2 = new Portal(PortalTypes.BAG, hub2, exec);
        
        //Create the users for the portals
        MetaAgent u1 = new UserAgent("Airplane", p1, exec);
        MetaAgent u2 = new UserAgent("Bag", p2, exec);
        
        //Send messages from the user agents
        u2.sendMessage(PortalTypes.ATC, "Airplane", "You've forgotten me!");
        u1.sendMessage(PortalTypes.BAG, "Bag", "Sorry");
    }
    
}
