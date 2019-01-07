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
     * Gets the name of the agent which sent the message
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
     * Gets the agent that sent the message
     * @return returns the agent which sent the message
     */    
    public abstract MetaAgent getAgent();
    /**
     * Gets the number of hops the message is allowed
     * @return the number of hops the message is allowed as an int
     */
    public abstract int getHopCount();
    /**
     * Gets the name of the last agent which the message was sent to
     * @return the name of the agent which the message visited last as a string
     */
    public abstract String getLastAgent();
}
//End of Message interface