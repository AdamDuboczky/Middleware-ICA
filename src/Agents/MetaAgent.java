/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Message.Message;
import Monitor.Monitorable;
import Monitor.NodeMonitor;
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
    private NodeMonitor monitor;
    
    public MetaAgent(String name, MetaAgent superAgent)
    {
        super();
        
        this.name = name;
        this.superAgent = superAgent;
        thread = new Thread(this);
    }
    //End of MetaAgent default constructor
    
    @Override
    public void run()
    {
        
    }
    //End of run

    @Override
    public void addMonitor(NodeMonitor nodeMonitor)
    {
        
    }

    @Override
    public void removeMonitor()
    {
            }

    @Override
    public boolean hasMonitor()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
//End of MetaAgent class