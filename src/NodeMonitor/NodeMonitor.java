/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NodeMonitor;

/**
 *
 * @author Adam
 */
public class NodeMonitor
{
    String status;
    Monitorable monitoring;

    public NodeMonitor(Monitorable monitoring)
    {
        this.monitoring = monitoring;
        monitoring.addMonitor(this);
    }   
    
    public void update()
    {
        status = monitoring.update();
    }
    //Message
    //Adapter?
    
}
