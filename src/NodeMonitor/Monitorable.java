/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NodeMonitor;

import Message.Message;

/**
 * Interface to be implemented by MetaAgents, allowing them to be monitored.
 * Allows for management/testing/debugging of the application.
 * @author Adam Duboczky, Tom Taylor, Nicol Reid, Connor Hird
 */
public interface Monitorable 
{ 
    /**
     * Method to add a NodeMonitor to a MetaAgent
     * @param monitor Monitor to be added to the agent
     */     
    public void addMonitor(NodeMonitor monitor);
    
    /**
     * Method to remove a NodeMonitor from a MetaAgent
     */    
    public void removeMonitor();
    
    /**
     * Method to check if MetaAgent currently has a NodeMonitor or not
     * 
     * @return boolean true if class has monitor, false if not.
     */    
    public boolean hasMonitor();
    
    /**
     * Method to provide updates about the MetaAgents message(s)
     * @param message 
     */    
    public void updateMonitor(Message message); 
}
//End of Monitorable interface