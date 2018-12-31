/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NodeMonitor;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author t7081971
 */
public class MonitorManager implements Runnable
{
    private volatile Map<NodeMonitor, Integer> monitors;

    public MonitorManager()
    {
        this.monitors = new HashMap<>();
    }
    //End of MonitorManager constructor
    
    public void addMonitor(NodeMonitor monitor)
    {
        monitors.put(monitor, monitor.getLogSize());
    }
    //End of addMonitor
    
    public void removeMonitor(NodeMonitor monitor)
    {
        if(monitors.containsKey(monitor))
        {
            monitors.remove(monitor);
        }
    }
        
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
