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
 * @author T-A-T
 */
public class Main 
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
        
        //Creates NodeMonitor and add to portals/agents and MonitorManager
        
        //Creates a hub to which all of the portals are connected.
        MetaAgent hub = new PortalHub(PortalTypes.HUB, null);
        NodeMonitor n7 = new NodeMonitor();
        hub.addMonitor(n7);
        manager.addMonitor(n7);
        exec.execute(hub);
        
        //Creates the portals and creates the links to the hub.
        MetaAgent p1 = new Portal(PortalTypes.ATC, hub);
        NodeMonitor n1 = new NodeMonitor();
        p1.addMonitor(n1);
        manager.addMonitor(n1);
        exec.execute(p1);
        MetaAgent p2 = new Portal(PortalTypes.BAG, hub);
        NodeMonitor n2 = new NodeMonitor();
        p2.addMonitor(n2);
        manager.addMonitor(n2);
        exec.execute(p2);
        MetaAgent p3 = new Portal(PortalTypes.SEC, hub);
        NodeMonitor n3 = new NodeMonitor();
        p3.addMonitor(n3);
        manager.addMonitor(n3);
        exec.execute(p3);

        //Creates the agents and links them to the portals
        MetaAgent a1 = new UserAgent("Airplane", p1);
        NodeMonitor n4 = new NodeMonitor();
        a1.addMonitor(n4);
        manager.addMonitor(n4);
        exec.execute(a1);
        MetaAgent a2 = new UserAgent("Ground Staff", p2);
        NodeMonitor n5 = new NodeMonitor();
        a2.addMonitor(n5);
        manager.addMonitor(n5);
        exec.execute(a2);
        MetaAgent a3 = new UserAgent("Officer", p3);
        NodeMonitor n6 = new NodeMonitor();
        a3.addMonitor(n6);
        manager.addMonitor(n6);
        exec.execute(a3);
        
        //Sending test messages
        a3.sendMessage(PortalTypes.ATC, "Airplane" , "you smell");              //Correct
        a2.sendMessage(PortalTypes.SEC, "Officer", "Immigrant in the airport"); //Correct
//        a1.sendMessage(PortalTypes.BAG, "Airplane" , "OMG!");                   //Wrong: wrong portal and trying to send to itself
        a2.sendMessage(PortalTypes.ATC, "Airplane", "Plane inbound");           //Correct
//        a3.sendMessage(PortalTypes.ATC, "Bob" , "I love you");                  //Wrong: No user named bob
//        a2.sendMessage(PortalTypes.BROAD, "All", "The airport id now closing"); //Broadcast
    }
    //End of main
}
//End of Main class