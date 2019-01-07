package Agents;

import Message.Message;
import Message.SysMsgTypes;
import Message.SystemMsg;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adam Duboczky, Tom Taylor, Nicol Reid, Connor Hird
 */
public class PortalHub extends Portal
{
    /**
      * Portal constructor
      * 
      * @param portalType Portals identifier
      * @param superAgent Agent in charge of routing to this object.
     * @param exS
      */
    public PortalHub(PortalTypes portalType, MetaAgent superAgent, ExecutorService exS)
    {
        super(portalType, superAgent, exS);
    }
    //End of PortalHub default constructor
    
    @Override
    protected void messageHandler(Message msg)
    {
        if(msg.getDestPortType().equals(msg.getLastAgent())) //Check to see if message has been to destination portal
        {
            returnHandler(msg);
        }
        else if(msg.getDestPortType() == null ? PortalTypes.BROAD.name() == null : msg.getDestPortType().equals(PortalTypes.BROAD.name())) //Check message = broadcast/null
        {
            broadcastHandler(msg);
        }
        else if(agentTable.containsKey(msg.getDestPortType())) //Check if destination port is available
        {
            correctHandler(msg);
        }
        else if (getSuperAgent() != null)
        {
            pushToSuper(new SystemMsg(msg, this.name, SysMsgTypes.NOTFOUND));
        }
        else
        {
            Logger.getLogger(name).log(Level.INFO, "Message from {0} timed out or couldn't find a recipient, and is itself unavailable", msg.getSender());
        }
    }
    //End of messageHandler
    
    /**
      * Updates the Message objects information, and forwards it to all 
      * valid meta-agents.
      * 
      * @param msg
      */
    private void broadcastHandler(Message msg)
    {
        Message message = new SystemMsg(msg, this.name, SysMsgTypes.VALID);
            
        agentTable.forEach((t, u) -> //Send to all agents except the sender
        {
            if(!u.getName().equals(msg.getLastAgent()))
            {
                try
                {
                    u.put(message);
                    exec.execute(u);
                }
                catch (InterruptedException ex)
                {
                    Logger.getLogger(Portal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        if(getSuperAgent() != null && !msg.getLastAgent().equals(getSuperAgent().getName())) //Broadcast message to super if it hasn't already
        {
            pushToSuper(message);
        }
    }
    //End of braodcastHandler
    
    /**
      * Updates the Message objects information, and forwards it to its 
      * specified meta-agents superAgent.
      * 
      * @param msg
      */
    private void returnHandler(Message msg)
    {
        if(agentTable.containsKey(msg.getSenderPort())) //Check to see if message sender port exists
        {
            Message message = new SystemMsg(msg, this.name, SysMsgTypes.NOTFOUND);

            try
            {
                agentTable.get(msg.getSenderPort()).put(message);
                exec.execute(agentTable.get(msg.getSenderPort()));
            }
            catch (InterruptedException ie)
            {
                Logger.getLogger(Portal.class.getName()).log(Level.SEVERE, null, ie);
            }
        }
        else //Log no recipient & no sender portal
        {
            Logger.getLogger(name).log(Level.INFO, "Message from {0} couldn't find a recipient, and is itself unavailable", msg.getSender());
        }
    }
    //End of returnHandler
    
    /**
      * Updates the Message objects information, and forwards it to the sender
      * meta-agents superAgent.
      * 
      * @param msg
      */
    private void correctHandler(Message msg)
    {
        Message message = new SystemMsg(msg, this.name, SysMsgTypes.VALID);
            
        try
        {
            agentTable.get(message.getDestPortType()).put(message);
            exec.execute(agentTable.get(message.getDestPortType()));
        }
        catch (InterruptedException ie)
        {
            Logger.getLogger(Portal.class.getName()).log(Level.SEVERE, null, ie);
        }
    }
    //End of correctHandler
}
//End of PortalHub class