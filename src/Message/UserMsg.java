/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Message;

import Agents.MetaAgent;
import java.time.LocalDateTime;

/**
 * This class is made to instantiate and interact with a user message
 * @author Adam Duboczky, Tom Taylor, Nicol Reid, Connor Hird
 */
public class UserMsg implements Message
{
    /**
     * The message to be sent round the system
     */
    private final String message;
    /**
     * The destination of the message
     */
    private final String destination;
    /**
     * The name of the sender of the message
     */
    private final String sender;
    /**
     * The type of portal which the message is being sent to
     */
    private final String destPortalType;
    /**
     * The time the message has been created
     */
    private final LocalDateTime timeStamp;
    /**
     * Constructor for user message, used to create the unwrapped message
     * @param destPortalType the type of the portal which the message is being sent to
     * @param destination The destination of the message
     * @param message The contents of the message
     * @param sender The sender of the message
     */
    public UserMsg(String destPortalType, String destination, String message, String sender)
    {
        this.destPortalType = destPortalType;
        this.destination = destination;
        this.message = message;
        this.sender = sender;
        this.timeStamp = LocalDateTime.now();
    }
    //End of UserMsg default constructor
    /**
     * Gets the contents of the message
     * @return the contents of the message as a string
     */
    @Override
    public String getUserMessage()
    {
        return message;
    }
    //End of getMessage
    /**
     * Gets the destination of the message
     * @return the destination of the message as a string
     */
    @Override
    public String getDestination()
    {
        return this.destination;
    }
    //End of getDestination
    /**
     * Gets the name of the agent which sent the message
     * @return the name of the agent which sent the message as a string
     */
    @Override
    public String getSender()
    {
        return this.sender;
    }
    //End of getSender
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
     * Gets the portal type which the agent lives on
     * @return the portal type as a string
     */
    @Override
    public String getDestPortType()
    {
        return destPortalType;
    }
    //End of getDestPortType
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
     * Not implemented in this version
     * @return 
     */
    @Override
    public String getPortVisited()
    {
        return null;
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
//End of User class