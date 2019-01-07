package Agents;

import Message.Message;
import Message.RegisterMsg;
import Message.UserMsg;
import NodeMonitor.Monitorable;
import NodeMonitor.NodeMonitor;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adam Duboczky, Tom Taylor, Nicol Reid, Connor Hird
 */
public abstract class MetaAgent extends LinkedBlockingQueue<Message> implements Runnable, Monitorable
{
    protected String name;
    protected MetaAgent superAgent;
    protected NodeMonitor monitor;
    protected volatile Map<String, MetaAgent> agentTable;
    protected final ExecutorService exec;
    
    /**
     * MetaAgent constructor
     * 
     * @param name Name of meta agent
     * @param superAgent Agent in charge of routing to this object.
     * @param exS
     */
    public MetaAgent(String name, MetaAgent superAgent, ExecutorService exS)
    {
        super();
        exec = exS;
        setSuperAgent(superAgent);
        setName(name);
    }
    //End of MetaAgent default constructor
    
    /**
      * Sets the meta-agents name to the string parameter, unless the super-agent, 
      * if one exists, returns a more suitable name that doesn't already exist in
      * its registry.
      * 
      * @param name Name of Agent
      */
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
            this.name = this.checkValidName("");
        }
        
    }
    //End of setName
    
    /**
      * Returns the meta-agents name.
      * 
      * @return Agent name
      */
    public String getName()
    {
        return this.name;
    }
    //End of getName
    
    /**
      * Checks if meta-agent already exists in the registry with the given name.
      * If one exists, given name is concatenated with the number one,
      * until the name no longer returns positive.
      * 
      * @param name Name of new meta-agent
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
    
    /**
      * Returns the meta-agent superAgent.
      * 
      * @return Meta-agent superAgent
      */
    public MetaAgent getSuperAgent()
    {
        return superAgent;
    }
    //End of getSuperAgent
    
    /**
     * Set the meta-agent that is to route messages for this agent.
     * Then push a message to said meta-agent requesting it register this agent
     * in its registry of managed meta-agents.
     * 
     * @param superAgent
     */
    public void setSuperAgent(MetaAgent superAgent)
    {
        this.superAgent = superAgent;
        
        if(this.superAgent != null)
        {
            this.pushToSuper(new RegisterMsg(this));
        }
    }
    //End of setSuperAgent
    
    /**
      * Registers meta-agent parameter to the registry of meta-agents,
      * using the meta-agents name as its key.
      * 
      * @param agent
      */
    private void registerAgent(MetaAgent agent)
    {
        this.agentTable.put(agent.name, agent);
    }
    //End of registerAgent
    
    /**
      * Puts a non-null message in the queue of the meta-agent superAgent,
      * then assigns superAgent to the executor service queue to be run.
      * 
      * @param message
      */
    public void pushToSuper(Message message)
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
    
    /**
      * Creates a new Message of type UserMsg, then calls pushToSuper.
      * 
      * @param destPType
      * @param dest
      * @param message
      */
    public void sendMessage(PortalTypes destPType, String dest, String message)
    {
        pushToSuper(new UserMsg(destPType.name(), dest, message, this.name, this.superAgent.getName()));
        
    }
    //End of sendMessage
    
    /**
      * Cycles the meta-agent through its queue, handling messages, until empty.
      */
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

    /**
      * Sets this objects reference to a NodeMonitor object to the one provided.
      * 
      * @param monitor
      */
    @Override
    public void addMonitor(NodeMonitor monitor)
    {
        this.monitor = monitor;
    }
    //End of addMonitor

    /**
      * Removes this objects reference to a NodeMonitor object.
      */
    @Override
    public void removeMonitor()
    {
        monitor = null;
    }
    //End of removeMonitor

    /**
      * Confirms the existence of a referenced NodeMonitor object.  
      */
    @Override
    public boolean hasMonitor()
    {
        return monitor != null; 
    }
    //End of hasMonitor
    
    /**
      * Sends a non-null message to the existing NodeMonitor object referenced
      * by this object.
      * 
      * @param message
      */
    @Override
    public void updateMonitor(Message message)
    {
        if(this.monitor != null && message != null)
        {
            monitor.updateMonitor(message);
        }
    }
    //End of updateMonitor
    
    /**
      * Initiates the chain of operations that process a non-null message. 
      * 
      * @param message
      */
    protected void handleMessage(Message message)
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
    
    /**
      * Processes the Message object with regards to the type of the meta-agent.
      * 
      * @param message
      */
    protected abstract void messageHandler(Message message);
}
//End of MetaAgent class