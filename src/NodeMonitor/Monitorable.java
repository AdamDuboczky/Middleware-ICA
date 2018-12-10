/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NodeMonitor;

import Monitor.NodeMonitor;

/**
 *
 * @author T-A-T
 */
public interface Monitorable 
{
    public void addNodeMonitor(NodeMonitor nodeMonitor);
    
    public void removeNodeMonitor();
    
    public boolean hasNodeMonitor();
}
//End of Monitorable interface