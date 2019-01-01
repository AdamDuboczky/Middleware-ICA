/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Message.Message;
import Message.SysMsgTypes;
import Message.SystemMsg;
import static Simulation.Main.exec;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author T-A-T
 */
public class Portal extends MetaAgent
{    
     /**
      * Portal constructor
      * 
      * @param portalType Type of portal
      * @param superAgent Agent pointer
      */
     public Portal(PortalTypes portalType, MetaAgent superAgent)
     {
        super(portalType.name(), superAgent);
        agentTable = new HashMap<>();
     }
     //End of Portal default constructor

    /**
     * 
     * @param msg Message to be sent.
     */
    @Override
    protected void messageHandler(Message msg)
    {   
        if(msg.getDestPortType() == null ? PortalTypes.BROAD.name() == null : msg.getDestPortType().equals(PortalTypes.BROAD.name())) //Check if message = broadcast/null
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
        else if (msg.getDestPortType().equals(this.name) && agentTable.containsKey(msg.getDestination())) //Check to see if correct portal & has recipient
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
        else if(msg.getDestPortType().equals(this.name) && agentTable.containsKey(msg.getSender())) //Check to see if correct portal & has sender
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
        else if((!msg.getLastAgent().equals(msg.getSender())) && msg.getSenderPort().equals(name)) //Check to see if this is senders portal & sender isn't last agent
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
        else if(getSuperAgent() != null) //Check to see if super exists to send message
        {
            Message message = new SystemMsg(msg, this.name, SysMsgTypes.NOTFOUND);
            pushToSuper(message);
        }
        else //Log that message time out, no recipient &/or no sender.
        {
            Logger.getLogger(name).log(Level.INFO, "Message from {0} timed out or couldn't find a recipient, and is itself unavailable", msg.getSender());
        }
    }
    //End of messageHandler
}
//End of Portal class