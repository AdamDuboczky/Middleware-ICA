/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NodeMonitor;

import Agents.Portal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author t7081971
 */
public class MonitorManager implements Runnable
{
    private final Map<NodeMonitor, Integer> monitors;
    protected final Thread thread;

    public MonitorManager()
    {
        this.monitors = new HashMap<>();
        thread = new Thread(this);
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
    
    public void start()
    {
        thread.start();
    }
    //End of start
        
    @Override
    public void run()
    {
        while(true)
        {
            monitors.forEach((t, u) ->
            {
                if(t.getLogSize() > u)
                {
                    System.out.println(t.grabUpdate(u).toString()); 
                    u =+ 1;
                }
            });
        }
    }
    
}
//End of MonitorManager class
