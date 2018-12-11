/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NodeMonitor;

/**
 *
 * @author T-A-T
 */
public interface Monitorable 
{
    public void addMonitor(NodeMonitor Monitor);
    
    public void removeMonitor();
    
    public boolean hasMonitor();
}
//End of Monitorable interface