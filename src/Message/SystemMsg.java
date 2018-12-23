/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Message;

import Agents.MetaAgent;
import java.time.LocalDateTime;

/**
 *
 * @author T-A-T
 */
public class SystemMsg implements Message
{
    /**
     * The user message inside of the system message
     */
    private final Message inner;
    /**
     * The status of the system message
     */
    private final SysMsgTypes systemMsg;
    /**
     * The date and time the system message was created in the system
     */
    private final LocalDateTime timeStamp;
    /**
     * All of the portals which the message has been in/on
     */
    private final String portalVisited;
    /**
     * Constructor for system message used to create the wrappee for user message
     * @param inner The user message which is inside of the system message
     * @param portalVisited All of the portals which the message has visited
     * @param systemMsg The status of the current system message
     */
    public SystemMsg(Message inner, String portalVisited, SysMsgTypes systemMsg)
    private final String lastAgent;
    
    public SystemMsg(Message inner, String lastAgent, SysMsgTypes systemMsg)
    {
        this.inner = inner;
        this.systemMsg = systemMsg;
        this.lastAgent = lastAgent;
        this.timeStamp = LocalDateTime.now();
    }
    //End of SystemMsg default constructor
    /**
     * Gets the user message from the system message
     * @return the user message as a string
     */
    @Override
    public String getUserMessage()
    {
        return inner.getUserMessage();
    }
    //End of getMessage
    /**
     * Gets the destination of the message
     * @return the destination of the message as a string
     */
    @Override
    public String getDestination()
    {
        return inner.getDestination();
    }
    //End of getDestination
    /**
     * Gets the sender of the message
     * @return the sender of the message as a string
     */
    @Override
    public String getSender()
    {
        return inner.getSender();
    }
    //End of getSender
    /**
     * Gets the status of the message
     * @return an enum of the status of the message
     */
    @Override
    public SysMsgTypes getSysMessage()
    {
        return this.systemMsg;
    }
    //End of getSysMessage
    /**
     * Gets the portal type of the destination for the message
     * @return the portal type of the destination as a string
     */
    @Override
    public String getDestPortType()
    {
        return inner.getDestPortType();
    }
    //End of getDestPortType
    /**
     * The name of the portal which sent the message
     * @return the name of the portal which sent the message as a string
     */
    @Override
    public String getLastAgent()
    {
        Message m = this;
        
        while(this.inner.getSenderPort() != null)
        {
            m = inner;
        }
        
        return m.getPortVisited();
    }
    //End of getSenderPort
    /**
     * Gets all the portals which the message has visited
     * @return all the portals the message has visited as a string
     */
    @Override
    public String getPortVisited()
    {
        return portalVisited;
        return lastAgent;
    }
    //End of getPortVisited
    /**
     * Not implemented in this version
     * @return 
     */
    @Override
    public MetaAgent getAgent()
    {
        return null;
    }
}
//End of SystemMsg class