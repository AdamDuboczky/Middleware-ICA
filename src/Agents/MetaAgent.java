/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Message.Message;
import Monitor.Monitor;
import Monitor.Monitorable;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author T-A-T
 */
public abstract class MetaAgent extends LinkedBlockingQueue<Message> implements Runnable, Monitorable
{
    protected String name;
    private final Thread thread;
    private MetaAgent superAgent;
    private Monitor monitor;
    
    public MetaAgent(String name, MetaAgent superAgent)
    {
        super();
        
        this.superAgent = superAgent;
        thread = new Thread(this);
        
        if(name != null &&)
        {
            this.name = 
        }
    }
    //End of MetaAgent default constructor
    
    public MetaAgent getSuperAgent()
    {
        return superAgent;
    }
    //End of getSuperAgent
    
    @Override
    public void run()
    {
        
    }
    //End of run

    @Override
    public void addMonitor(Monitor monitor)
    {
        this.monitor = monitor;
    }
    //End of addMonitor

    @Override
    public void removeMonitor()
    {
        monitor = null;
    }
    //End of removeMonitor

    @Override
    public boolean hasMonitor()
    {
        return monitor != null; 
    }
    //End of hasMonitor
}
//End of MetaAgent class