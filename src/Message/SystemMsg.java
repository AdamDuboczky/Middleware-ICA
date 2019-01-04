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
     * The name of the agent which sent the message
     */
    private final String msgAgent;
    
    public SystemMsg(Message inner, String msgAgent, SysMsgTypes systemMsg)
    {
        this.inner = inner;
        this.systemMsg = systemMsg;
        this.msgAgent = msgAgent;
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
     * @return 
     */
    @Override
    public String getSenderPort()
    {
        return inner.getSenderPort();
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
    /**
     * Gets the amount of hops the message is allowed to have
     * @return the amount of hops the message is allowed as an int
     */
    @Override
    public int getHopCount()
    {
        return inner.getHopCount() + 1;
    }
    /**
     * Gets the name of the last agent which the message has visited
     * @return the name of the last agent as a string
     */
    @Override
    public String getLastAgent()
    {
        return this.msgAgent;
    }
}
//End of SystemMsg class