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
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author T-A-T
 */
public class Portal extends MetaAgent
{
     private volatile Map<String, MetaAgent> agentTable;
     protected PortalTypes portalType;
     
     /**
      * Portal constructor
      * 
      * @param portalType Type of portal
      * @param name Name of agent
      * @param superAgent Agent pointer
      */
     public Portal(PortalTypes portalType, String name, Portal superAgent)
     {
        super(name, superAgent);
        this.portalType = portalType;
        agentTable = new ConcurrentHashMap<>();
     }
     //End of Portal default constructor

     /**
      * Checks if agent already exists with the given name.
      * If it does exist, concatenate the given name with +1 to avoid exceptions.  
      * 
      * @param name Name of Agent
      * @return Valid agent name
      */
    public String checkValidName(String name)
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
     * Insert the meta agent into the 'table'.
     * 
     * @param agent Agent to be added to super type.
     * @param name Name of agent
     */
    public void registerWithSuper(MetaAgent agent, String name)
    {
        agentTable.put(name, agent);
    }
    //End of registerWithSuper

    /**
     * 
     * @param msg Message to be sent.
     */
    @Override
    protected void messageHandler(Message msg)
    {   
        if (msg.getDestPortType().equals(this.portalType))
        {
            if (agentTable.containsKey(msg.getDestination()))
            {
                Message message = new SystemMsg(msg, this.portalType, SysMsgTypes.VALID);
                
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
                Message message = new SystemMsg(msg, this.portalType, SysMsgTypes.NOTFOUND);
                
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
        else if(msg.getDestPortType() == PortalTypes.BROAD)
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
                agentTable.get(message.getSenderPort()).put(message);
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