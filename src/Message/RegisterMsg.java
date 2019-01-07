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
    /**
     * The agent which sent the registration message
     */
    public MetaAgent agent;
    /**
     * Constructor for RegisterMsg, used to create a register message
     * @param agent Used to keep track of the agent which sent the message
     */    
    public RegisterMsg(MetaAgent agent)
    {
        this.agent = agent;
    }
    /**
     * Not implemented in this version
     * @return 
     */    
    @Override
    public String getUserMessage()
    {
        return null;
    }
    /**
     * Not implemented in this version
     * @return 
     */
    @Override
    public String getDestination()
    {
        return null;
    }
    /**
     * Gets the name of the agent which sent the registration message
     * @return the name of the agent which sent the message as a string
     */
    @Override
    public String getSender()
    {
        return "Agent: " + agent.getName() + " registering with super";
    }
    /**
     * Not implemented in this version
     * @return 
     */
    @Override
    public String getDestPortType()
    {
        return null;
    }
    /**
     * Not implemented in this version
     * @return 
     */
    @Override
    public SysMsgTypes getSysMessage()
    {
        return null;
    }
    /**
     * Not implemented in this version
     * @return 
     */
    @Override
    public String getSenderPort()
    {
        return null;
    }
    /**
     * Gets the agent which sent the registration message
     * @return the agent which sent the message as type MetaAgent
     */
    @Override
    public MetaAgent getAgent()
    {
        return agent;
    }
    /**
     * Gets the hop count for the registration message
     * @return the amount of times the message is allowed to hop around the system as an int
     */
    @Override
    public int getHopCount()
    {
        return 1;
    }
    /**
     * Gets the name of the agent which the message visited last
     * @return the name of the agent as a string
     */
    @Override
    public String getLastAgent()
    {
        return agent.getName();
    }
}
//End of RegisterMsg class