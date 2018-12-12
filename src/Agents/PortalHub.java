/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Message.Message;
import Message.SysMsgTypes;
import Message.SystemMsg;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author T-A-T
 */
public class PortalHub extends Portal
{
    private volatile Map<PortalTypes, MetaAgent> agentTable;
    
    public PortalHub(PortalTypes portType, String name, Portal superAgent)
    {
        super(portType, name, superAgent);
    }
    //End of PortalHub default constructor
    
    @Override
    protected void messageHandler(Message msg)
    {
        if(msg.getDestPortType() == PortalTypes.BROAD)
        {
            Message message = new SystemMsg(msg, this.portalType, SysMsgTypes.VALID);
            
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
        else if(agentTable.containsKey(msg.getDestPortType()))
        {
            Message message = new SystemMsg(msg, this.portalType, SysMsgTypes.VALID);
            
            try
            {
                agentTable.get(message.getDestPortType()).put(message);
            }
            catch (InterruptedException ie)
            {
                Logger.getLogger(Portal.class.getName()).log(Level.SEVERE, null, ie);
            }
        }
        else if (getSuperAgent() != null)
        {
            Message message = new SystemMsg(msg, this.portalType, SysMsgTypes.NOTFOUND);
            pushToSuper(message);
        }
        else
        {
            Message message = new SystemMsg(msg, this.portalType, SysMsgTypes.NOTFOUND);
            
            try
            {
                agentTable.get(message.getDestPortType()).put(message);
            }
            catch (InterruptedException ie)
            {
                Logger.getLogger(Portal.class.getName()).log(Level.SEVERE, null, ie);
            }
        }
    }
    //End of messageHandler
}
//End of PortalHub class