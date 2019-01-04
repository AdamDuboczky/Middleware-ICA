/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Message.RegisterMsg;
import Message.UserMsg;
import NodeMonitor.Monitorable;
import NodeMonitor.NodeMonitor;
import static Simulation.Main.exec;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import Message.SuperMessage;

/**
 *
 * @author T-A-T
 */
public abstract class MetaAgent extends LinkedBlockingQueue<SuperMessage> implements Runnable, Monitorable
{
    protected String name;
    protected MetaAgent superAgent;
    protected NodeMonitor monitor;
    protected volatile Map<String, MetaAgent> agentTable;
    
    /**
     * MetaAgent constructor
     * 
     * @param name Name of meta agent
     * @param superAgent Portal to be attached to.
     */
    public MetaAgent(String name, MetaAgent superAgent)
    {
        super();
        setSuperAgent(superAgent);
        setName(name);
    }
    //End of MetaAgent default constructor
    
    public String getName()
    {
        return this.name;
    }
    //End of getName
    
    private void setName(String name)
    {
        if(name != null)
        {
            if(this.superAgent != null)
            {
                this.name = this.superAgent.checkValidName(name);
            }
            else
            {
                this.name = name;
            }
        }
        else
        {
            this.name = this.checkValidName(name);
        }
        
    }
    //End of setName
    
    /**
      * Checks if agent already exists with the given name.
      * If it does exist, concatenate the given name with +1 to avoid exceptions.  
      * 
      * @param name Name of Agent
      * @return Valid agent name
      */
    private String checkValidName(String name)
    {
        boolean valid = false;
        
        while(valid == false)
        {
            if(agentTable.containsKey(name))
            {
                name += "1";
            }
            else
            {
                valid = true;
            }
        }
        
        return name;
    }
    //End of checkValidName
    
    public MetaAgent getSuperAgent()
    {
        return superAgent;
    }
    //End of getSuperAgent
    
    /**
     * Set the portal for the meta agent to be attached to.
     * @param superAgent
     */
    private void setSuperAgent(MetaAgent superAgent)
    {
        this.superAgent = superAgent;
        
        if(this.superAgent != null)
        {
            this.pushToSuper(new RegisterMsg(this));
        }
    }
    //End of setSuperAgent
    
    private void registerAgent(MetaAgent agent)
    {
        this.agentTable.put(agent.name, agent);
    }
    //End of registerAgent
    
    public void pushToSuper(SuperMessage message)
    {
        if(message != null)
        {
            try
            {
                superAgent.put(message);
                exec.execute(superAgent);
            }
            catch(InterruptedException ie)
            {
                Logger.getLogger(MetaAgent.class.getName()).log(Level.SEVERE, null, ie);
            }
        }
    }
    //End of pushToSuper
    
    public void sendMessage(PortalTypes destPType, String dest, String message)
    {
        pushToSuper(new UserMsg(destPType.name(), dest, message, this.name, this.superAgent.getName()));
        
    }
    //End of sendMessage
    
    @Override
    public void run()
    {
        while(!this.isEmpty())
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
    
    @Override
    public void updateMonitor(SuperMessage message)
    {
        if(this.monitor != null)
        {
            monitor.updateMonitor(message);
        }
    }
    //End of updateMonitor
    
    protected void handleMessage(SuperMessage message)
    {
        if(message != null)
        {
            if(hasMonitor())
            {
                updateMonitor(message);
            }
            
            if(message.getAgent() != null)
            {
                this.registerAgent(message.getAgent());
            }
            else if(message.getHopCount() < 15)
            {
                System.out.println("???" + message.getHopCount() + " " + message.getLastAgent() + "???"); ///THIS IS FOR TESTING PURPOSESS
                messageHandler(message);
            }
            else
            {
                Logger.getLogger(name).log(Level.INFO, "Message from {0} timed out", message.getSender());
            }
        }
    }
    //End of handleMessage
    
    protected abstract void messageHandler(SuperMessage message);
}
//End of MetaAgent class