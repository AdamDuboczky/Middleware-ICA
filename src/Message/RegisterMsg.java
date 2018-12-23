/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Message;

import Agents.MetaAgent;

/**
 *
 * @authors Adam Duboczky, Tom Taylor, Nicol Reid, Connor Hird
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
     * Not implemented in this version
     * @return 
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
    public String getLastAgent()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Not implemented in this version
     * @return 
     */
    @Override
    public String getPortVisited()
    {
        return agent.getName();
    }
    /**
     * Gets the agent which sent the message
     * @return the agent which sent the message
     */
    @Override
    public MetaAgent getAgent()
    {
        return agent;
    }

    @Override
    public String getSenderPort()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
//End of RegisterMsg class