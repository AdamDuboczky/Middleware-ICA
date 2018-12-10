/*
 * 
 */
package Portals;

import Agents.Agent;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Adam
 */
public class Portal
{
    //Store connected meta agents
    private HashMap<String, Agent> mapOfPortals = new HashMap<>();
    private BlockingQueue queue;
    String portalName;
    
    Portal(String portalName)
    {
        this.portalName = portalName;
    }    
    
    void connectToHub()
    {}
    
    void processMessage()
    {}
}
