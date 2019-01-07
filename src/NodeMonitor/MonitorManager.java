/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NodeMonitor;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages all NodeMonitors in the system, is a thread and therefore implements Runnable
 * @author Adam Duboczky, Tom Taylor, Nicol Reid, Connor Hird
 */
public class MonitorManager implements Runnable
{
    private volatile Map<NodeMonitor, Integer> monitors;

    /**
     * Default constructor, initialises HashMap to store NodeMonitors
     */
    public MonitorManager()
    {
        this.monitors = new HashMap<>();
    }
    //End of MonitorManager constructor
    
    /**
     * Adds NodeMonitor to HashMap
     * @param monitor NodeMonitor to be added
     */
    public void addMonitor(NodeMonitor monitor)
    {
        monitors.put(monitor, monitor.getLogSize());
    }
    //End of addMonitor
    
    /**
     * Removes specified NodeMonitor from HashMap
     * @param monitor NodEMonitor to be removed
     */
    public void removeMonitor(NodeMonitor monitor)
    {
        if(monitors.containsKey(monitor))
        {
            monitors.remove(monitor);
        }
    }
    
    public boolean hasMonitor(NodeMonitor monitor)
    {
        return monitors.containsKey(monitor);
    }
    
    /**
     * When thread is executed inspects each NodeMonitor for information
     */
    @Override
    public void run()
    {
        while(true)
        {
            monitors.forEach((t, u) ->
            {
                if(t.getLogSize() > u)
                {
                    System.out.println(t.grabUpdate(u).getSender());
                    monitors.replace(t, new Integer(u+1));
                }
            });
        }
    }
    
}
//End of MonitorManager class
