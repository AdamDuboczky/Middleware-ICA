/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NodeMonitor;

/**
 * Interface to be implemented by classes for monitoring
 * @author t7081971
 */
public abstract class Monitorable 
{
    protected NodeMonitor nodeMonitor;
    /**
     * Method to add a monitor to a class
     */  
    
    public void addMonitor(NodeMonitor monitor)
    {
        nodeMonitor = monitor;
    }
    
    /**
     * Method to remove a monitor to a class
     */ 
    
    public void removeMonitor()
    {
        nodeMonitor = null;
    }
    
    /**
     * Method to check if class currently has a monitor or not
     * 
     * @return Boolean, true if class has monitor, false if not.
     */
    
    public boolean hasMonitor()
    {
        return nodeMonitor != null;
    }
    
    /**
     * Method to return status
     * @return String to be printed to console
     */
    
    public String update()
    {
        return "Not implemented yet";
    }
    
}
