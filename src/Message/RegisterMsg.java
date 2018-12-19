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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     /**
     * Not implemented in this version
     * @return 
     */
    @Override
    public String getDestination()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Not implemented in this version
     * @return 
     */
    @Override
    public String getSender()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Not implemented in this version
     * @return 
     */
    @Override
    public String getDestPortType()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Not implemented in this version
     * @return 
     */
    @Override
    public SysMsgTypes getSysMessage()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Not implemented in this version
     * @return 
     */
    @Override
    public String getSenderPort()
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
//End of RegisterMsg class