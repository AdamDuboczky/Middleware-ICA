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
public interface Message 
{
    /**
     * Gets the contents of the user message
     * @return Contents of the user message as a string
     */
    public abstract String getUserMessage();
    /**
     * Gets the destination of the message
     * @return destination of the message as a string
     */
    public abstract String getDestination();
    /**
     * Gets the agent which sent the message
     * @return the name of the agent which sent the message as a string
     */
    public abstract String getSender();
    /**
     * Gets the portal type of the destination
     * @return the portal type of the destination as a string
     */
    public abstract String getDestPortType();
    /**
     * Gets the status of the system message(VALID, NOTFOUND OR ERROR)
     * @return returns an enum for the status of the system message
     */
    public abstract SysMsgTypes getSysMessage();
    /**
     * Gets the sender portal of the message
     * @return the sender portal of the message as a string
     */
    public abstract String getSenderPort();
    /**
     * Gets the portals visited for the message
     * @return the portals visited as a string
     */
    public abstract String getPortVisited();
    /**
     * Gets the agent that sent the message
     * @return returns the agent which sent the message
     */
    public abstract MetaAgent getAgent();
}
//End of Message interface