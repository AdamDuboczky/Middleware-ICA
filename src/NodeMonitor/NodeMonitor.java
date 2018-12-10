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
public class NodeMonitor implements Monitorable
{
    Monitorable monitor;

    @Override
    public void addMonitor()
    {
        
    }

    @Override
    public void removeMonitor()
    {
        monitor = null;
    }

    @Override
    public boolean hasMonitor()
    {
        return monitor != null;
    }

    @Override
    public void update(String message)
    {
        System.out.println("");
    }
    
}
