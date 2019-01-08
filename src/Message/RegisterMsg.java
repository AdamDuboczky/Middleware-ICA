/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Message;

import Agents.MetaAgent;

/**
 *
 * @author Adam Duboczky, Tom Taylor, Nicol Reid, Connor Hird
 */
public class RegisterMsg implements Message
{
    public MetaAgent agent;
    
    /**
     * RegisterMsg constructor
     * 
     * @param agent Used to keep track of the agent which sent the message
     */    
    public RegisterMsg(MetaAgent agent)
    {
        this.agent = agent;
    }
    //End of RegisterMsg default constructor
    
    /**
     * Not implemented in this version
     * @return 
     */    
    @Override
    public String getUserMessage()
    {
        return null;
    }
    //End of getUserMessage
    
    /**
     * Not implemented in this version
     * @return 
     */
    @Override
    public String getDestination()
    {
        return null;
    }
    //End of getDestination
    
    /**
     * Gets the name of the agent which sent the registration message
     * 
     * @return the name of the agent which sent the message as a string
     */
    @Override
    public String getSender()
    {
        return "Agent: " + agent.getName() + " registering with super";
    }
    //End of getSender
    
    /**
     * Not implemented in this version
     * @return 
     */
    @Override
    public String getDestPortType()
    {
        return null;
    }
    //End of getDestPortType
    
    /**
     * Not implemented in this version
     * @return 
     */
    @Override
    public SysMsgTypes getSysMessage()
    {
        return null;
    }
    //End of getSysMessage
    
    /**
     * Not implemented in this version
     * @return 
     */
    @Override
    public String getSenderPort()
    {
        return null;
    }
    //End of getSenderPort
    
    /**
     * Gets the agent which sent the registration message
     * 
     * @return the agent which sent the message as type MetaAgent
     */
    @Override
    public MetaAgent getAgent()
    {
        return agent;
    }
    //End of getAgent
    
    /**
     * Gets the hop count for the registration message
     * 
     * @return the amount of times the message is allowed to hop around the system as an int
     */
    @Override
    public int getHopCount()
    {
        return 1;
    }
    //End of getHopCount
    
    /**
     * Gets the name of the agent which the message visited last
     * 
     * @return the name of the agent as a string
     */
    @Override
    public String getLastAgent()
    {
        return agent.getName();
    }
    //End of getLastAgent
}
//End of RegisterMsg class