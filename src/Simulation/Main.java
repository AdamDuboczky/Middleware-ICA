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
        
        PortalHub hub = new PortalHub(PortalTypes.HUB, "Portal Hub", null);
        
        Portal p1 = new Portal(PortalTypes.ONE, "P1", hub);
        Portal p2 = new Portal(PortalTypes.TWO, "p2", hub);
        Portal p3 = new Portal(PortalTypes.THREE, "p3", hub);
        Portal p4 = new Portal(PortalTypes.FOUR, "p4", hub);
        
        UserAgent a1 = new UserAgent("a1", p1);
        UserAgent a2 = new UserAgent("a2", p4);
        /*
        Needs to create portal hub,
        then all portals attached to it,
        then user agents attached to those.
        
        Also make monitors and attach those to the above objects,
        or the same monitor for all of them.
        
        Said monitor(s) need to be able to display when an update is recieved,
        so either a GUI/console interface needs to be made with a sepreate
        thread that can pull the information from the monitors, or the monitors
        need to themselves have threads and display(sout or GUI) themselves.
        */
    }
    //End of main
}
//End of Main class