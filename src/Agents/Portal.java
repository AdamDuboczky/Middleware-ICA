/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Message.Message;
import Message.SysMsgTypes;
import Message.SystemMsg;
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
     }
     //End of Portal default constructor

    /**
     * 
     * @param msg Message to be sent.
     */
    @Override
    protected void messageHandler(Message msg)
    {   
        if (msg.getDestPortType().equals(this.name))
        {
            if (agentTable.containsKey(msg.getDestination()))
            {
                Message message = new SystemMsg(msg, this.name, SysMsgTypes.VALID);
                
                try
                {
                    agentTable.get(message.getDestination()).put(message);
                }
                catch (InterruptedException ex)
                {
                    Logger.getLogger(Portal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
                Message message = new SystemMsg(msg, this.name, SysMsgTypes.NOTFOUND);
                
                try
                {
                    agentTable.get(message.getDestination()).put(message);
                }
                catch (InterruptedException ie)
                {
                    Logger.getLogger(Portal.class.getName()).log(Level.SEVERE, null, ie);
                }
            }
        }
        else if(msg.getDestPortType() == null ? PortalTypes.BROAD.name() == null : msg.getDestPortType().equals(PortalTypes.BROAD.name()))
        {
            Message message = new SystemMsg(msg, this.name, SysMsgTypes.VALID);
            
            agentTable.forEach((t, u) ->
            {
                try
                {
                    u.put(message);
                }
                catch (InterruptedException ex)
                {
                    Logger.getLogger(Portal.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            if(getSuperAgent() != null)
            {
                pushToSuper(message);
            }
        }
        else if (getSuperAgent() != null)
        {
            Message message = new SystemMsg(msg, this.name, SysMsgTypes.NOTFOUND);
            pushToSuper(message);
        }
        else
        {
            Message message = new SystemMsg(msg, this.name, SysMsgTypes.NOTFOUND);
            
            try
            {
                agentTable.get(message.getSender()).put(message);
            }
            catch (InterruptedException ie)
            {
                Logger.getLogger(Portal.class.getName()).log(Level.SEVERE, null, ie);
            }
        }
    }
    //End of messageHandler
}
//End of Portal class