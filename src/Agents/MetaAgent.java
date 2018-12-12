/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Message.Message;
import NodeMonitor.Monitorable;
import NodeMonitor.NodeMonitor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author T-A-T
 */
public abstract class MetaAgent extends LinkedBlockingQueue<Message> implements Runnable, Monitorable
{
    protected String name;
    protected final Thread thread;
    protected Portal superAgent;
    protected NodeMonitor monitor;
    
    public MetaAgent(String name, Portal superAgent)
    {
        super();
        thread = new Thread(this);
        setName(name);
        setSuperAgent(superAgent);
    }
    //End of MetaAgent default constructor
    
    public String getName()
    {
        return this.name;
    }
    //End of getName
    
    private void setName(String name)
    {
        if(name != null && this.superAgent != null)
        {
            this.name = this.superAgent.checkValidName(name);
        }
    }
    //End of setName
    
    public MetaAgent getSuperAgent()
    {
        return superAgent;
    }
    //End of getSuperAgent
    
    private void setSuperAgent(Portal superAgent)
    {
        this.superAgent = superAgent;
        
        if(this.superAgent != null)
        {
            this.superAgent.registerWithSuper(this, this.name);
        }
    }
    //End of setSuperAgent
    
    public void pushToSuper(Message message)
    {
        if(message != null)
        {
            try
            {
                superAgent.put(message);
            }
            catch(InterruptedException ie)
            {
                Logger.getLogger(MetaAgent.class.getName()).log(Level.SEVERE, null, ie);
            }
        }
    }
    //End of pushToSuper
    
    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                handleMessage(take());
            }
            catch (InterruptedException ie)
            {
                Logger.getLogger(MetaAgent.class.getName()).log(Level.SEVERE, null, ie);
            }
        }
    }
    //End of run
    
    public void start()
    {
        thread.start();
    }
    //End of start

    @Override
    public void addMonitor(NodeMonitor monitor)
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
    
    protected void updateMonitor(Message message)
    {
        if(this.monitor != null)
        {
            monitor.updateMonitor(message);
        }
    }
    //End of updateMonitor
    
    protected void handleMessage(Message message)
    {
        if(message != null)
        {
            updateMonitor(message);
            messageHandler(message);
        }
    }
    //End of handleMessage
    
    protected abstract void messageHandler(Message message);
}
//End of MetaAgent class