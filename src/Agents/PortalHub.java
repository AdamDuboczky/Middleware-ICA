 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Message.SysMsgTypes;
import Message.SystemMsg;
import static Simulation.Main.exec;
import java.util.logging.Level;
import java.util.logging.Logger;
import Message.SuperMessage;

/**
 *
 * @author T-A-T
 */
public class PortalHub extends Portal
{
    public PortalHub(PortalTypes portType, MetaAgent superAgent)
    {
        super(portType, superAgent);
    }
    //End of PortalHub default constructor
    
    @Override
    protected void messageHandler(SuperMessage msg)
    {
        if(msg.getDestPortType().equals(msg.getLastAgent())) //Check to see if message has been to destination portal
        {
            if(agentTable.containsKey(msg.getSenderPort())) //Check to see if message sender port exists
            {
                SuperMessage message = new SystemMsg(msg, this.name, SysMsgTypes.NOTFOUND);

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
        else if(msg.getDestPortType() == null ? PortalTypes.BROAD.name() == null : msg.getDestPortType().equals(PortalTypes.BROAD.name())) //Check message = broadcast/null
        {
            SuperMessage message = new SystemMsg(msg, this.name, SysMsgTypes.VALID);
            
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
        else if(agentTable.containsKey(msg.getDestPortType()))
        {
            SuperMessage message = new SystemMsg(msg, this.name, SysMsgTypes.VALID);
            
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
        else if (getSuperAgent() != null)
        {
            SuperMessage message = new SystemMsg(msg, this.name, SysMsgTypes.NOTFOUND);
            pushToSuper(message);
        }
        else if(agentTable.containsKey(msg.getSenderPort()))
        {
            SuperMessage message = new SystemMsg(msg, this.name, SysMsgTypes.NOTFOUND);
            
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
        else
        {
            Logger.getLogger(name).log(Level.INFO, "Message from {0} timed out or couldn't find a recipient, and is itself unavailable", msg.getSender());
        }
    }
    //End of messageHandler
}
//End of PortalHub class