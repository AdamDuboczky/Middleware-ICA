/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Simulation;

import Agents.Portal;
import Agents.PortalHub;
import Agents.PortalTypes;
import Agents.UserAgent;
import NodeMonitor.MonitorManager;
import NodeMonitor.NodeMonitor;

/**
 *
 * @author T-A-T
 */
public class Main 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //Creates a which all of the portals are connected to
        PortalHub hub = new PortalHub(PortalTypes.HUB, "Portal Hub", null);        
        hub.start();
        
        //Creates the portals and creates the links to the hub
        Portal p1 = new Portal(PortalTypes.ATC, "ATC", hub);
        p1.start();
        Portal p2 = new Portal(PortalTypes.BAG, "Baggage", hub);
        p2.start();
        Portal p3 = new Portal(PortalTypes.SEC, "Security", hub);
        p3.start();

        //Creates the agents and links them to the portals
        UserAgent a1 = new UserAgent("Airplane", p1);
        a1.start();
        UserAgent a2 = new UserAgent("Ground Staff", p2);
        a2.start();
        UserAgent a3 = new UserAgent("Officer", p3);
        a3.start();
        
        //Create MonitorManager and add NodeMonitors
        MonitorManager manager = new MonitorManager();
        manager.start();
        
        //Creates NodeMonitor and add to portals/agents and MonitorManager
        NodeMonitor n1 = new NodeMonitor();
        p1.addMonitor(n1);
        manager.addMonitor(n1);
        NodeMonitor n2 = new NodeMonitor();
        p2.addMonitor(n2);
        manager.addMonitor(n2);
        NodeMonitor n3 = new NodeMonitor();
        p3.addMonitor(n3);
        manager.addMonitor(n3);
        NodeMonitor n4 = new NodeMonitor();
        a1.addMonitor(n4);
        manager.addMonitor(n4);
        NodeMonitor n5 = new NodeMonitor();
        a2.addMonitor(n5);
        manager.addMonitor(n5);
        NodeMonitor n6 = new NodeMonitor();
        a3.addMonitor(n6);
        manager.addMonitor(n6);
        NodeMonitor n7 = new NodeMonitor();
        hub.addMonitor(n7);
        manager.addMonitor(n7);
        
        //Agent.registerWithSuper(a1, "Agent1") ??????
        a3.sendMessage(PortalTypes.ATC, "Airplane" , "you smell");
        a2.sendMessage(PortalTypes.SEC, "Officer", "Immigrant in the airport");
        
        
    }
    //End of main
}
//End of Main class