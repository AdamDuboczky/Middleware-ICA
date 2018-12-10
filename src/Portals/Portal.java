/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Portals;

import java.util.HashMap;

/**
 *
 * @author Adam
 */
public class Portal
{
    //Store connected meta agents
    private HashMap<String, MetaAgent> mapOfMetaAgents = new HashMap<>();
    
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
