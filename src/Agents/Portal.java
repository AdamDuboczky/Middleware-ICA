package Agents;

import Message.Message;
import Message.SysMsgTypes;
import Message.SystemMsg;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adam Duboczky, Tom Taylor, Nicol Reid, Connor Hird
 */
public class Portal extends MetaAgent
{    
     /**
      * Portal constructor
      * 
      * @param portalType Portals identifier
      * @param superAgent Agent in charge of routing to this object.
      * @param exS
      */
     public Portal(PortalTypes portalType, MetaAgent superAgent, ExecutorService exS)
     {
        super(portalType.name(), superAgent, exS);
        agentTable = new HashMap<>();
     }
     //End of Portal default constructor
     
    @Override
    protected void messageHandler(Message msg)
    {   
        if(msg.getDestPortType() == null ? PortalTypes.BROAD.name() == null : msg.getDestPortType().equals(PortalTypes.BROAD.name())) //Check if message = broadcast/null
        {
            broadcastHandler(msg);
        }
        else if (msg.getDestPortType().equals(this.name) && agentTable.containsKey(msg.getDestination())) //Check to see if correct portal & has recipient
        {
            correctHandler(msg);
        }
        else if((!msg.getLastAgent().equals(msg.getSender())) && msg.getSenderPort().equals(name)) //Check to see if this is senders portal & sender isn't last agent
        {
            returnHandler(msg);
        }
        else if(getSuperAgent() != null) //Check to see if super exists to send message
        {
            pushToSuper(new SystemMsg(msg, this.name, SysMsgTypes.NOTFOUND));
        }
        else //Log that message time out, no recipient &/or no sender.
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
            
            agentTable.forEach((t, u) ->    //Distribute to all agents, but the sender
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
    //End of broadcast
    
    /**
      * Updates the Message objects information, and forwards it to its 
      * specified meta-agent destination.
      * 
      * @param msg
      */
    private void correctHandler(Message msg)
    {
        Message message = new SystemMsg(msg, this.name, SysMsgTypes.VALID);
                
            try
            {
                agentTable.get(message.getDestination()).put(message);
                exec.execute(agentTable.get(message.getDestination()));
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(Portal.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    //End of correctMsg
    
    /**
      * Updates the Message objects information, and forwards it to the
      * meta-agent that originally sent it.
      * 
      * @param msg
      */
    private void returnHandler(Message msg)
    {
        if(agentTable.containsKey(msg.getSender())) //Check for sender in senders port
        {
            Message message = new SystemMsg(msg, this.name, SysMsgTypes.NOTFOUND);

            try
            {
                agentTable.get(msg.getSender()).put(message);
                exec.execute(agentTable.get(msg.getSender()));
            }
            catch (InterruptedException ie)
            {
                Logger.getLogger(Portal.class.getName()).log(Level.SEVERE, null, ie);
            }
        }
        else //Log no recipient & no sender
        {
            Logger.getLogger(name).log(Level.INFO, "Message from {0} couldn't find a recipient, and is itself unavailable", msg.getSender());
        }
    }
    //End of correctMsg
}
//End of Portal class