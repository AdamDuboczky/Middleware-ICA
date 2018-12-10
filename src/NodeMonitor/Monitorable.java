/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NodeMonitor;

/**
 * Interface to be implemented by 
 * @author t7081971
 */
public interface Monitorable 
{
    /**
     * Method to add a monitor to a class
     */  
    
    public void addMonitor();
    
    /**
     * Method to remove a monitor to a class
     */ 
    
    public void removeMonitor();
    
    /**
     * Method to check if class currently has a monitor or not
     * 
     * @return Boolean, true if class has monitor, false if not.
     */
    
    public boolean hasMonitor();
    
    /**
     * Method to return status
     * @return String to be printed to console
     */
    
    public String update();    
    
}
