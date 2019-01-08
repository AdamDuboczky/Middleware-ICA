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
 * @author Adam Duboczky, Tom Taylor, Nicol Reid, Connor Hird
 */
public class UserMsg implements Message
{
    private final String message;
    private final String destination;
    private final String sender;
    private final String senderPortalType;
    private final String destPortalType;
    private final LocalDateTime timeStamp;
    
   /**
     * Constructor for user message, used to create the unwrapped message, initialises the date and time the message was created
     * 
     * @param destPortalType the type of the portal which the message is being sent to
     * @param destination The destination of the message
     * @param message The message to be sent round the system
     * @param sender The name of the sender of the message
     * @param senderPort the portal name which the sender is connected to
     */
    public UserMsg(String destPortalType, String destination, String message, String sender, String senderPort)
    {
        this.destPortalType = destPortalType;
        this.destination = destination;
        this.message = message;
        this.sender = sender;
        this.senderPortalType = senderPort;
        this.timeStamp = LocalDateTime.now();
    }
    //End of UserMsg default constructor
    
    
    /**
     * Gets the contents of the message
     * 
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
     * 
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
     * 
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
     * Gets the portal type which the agent is connected to
     * 
     * @return the portal type as a string
     */
    @Override
    public String getDestPortType()
    {
        return destPortalType;
    }
    //End of getDestPortType
    
    /**
     * Gets the portal type which the agent receiving the message is connected to
     * 
     * @return the portal type as a string
     */
    @Override
    public String getSenderPort()
    {
        return senderPortalType;
    }
    //End of getSenderPort    
    
    /**
     * Not implemented in this version
     * @return 
     */
    @Override
    public MetaAgent getAgent()
    {
        return null;
    }
    //End of getAgent
    
    /**
     * Not implemented in this version
     * @return 
     */
    @Override
    public int getHopCount()
    {
        return 0;
    }
    //End of getHopCount
    
    /**
     * The last agent which the message was sent through
     * 
     * @return the name of the last agent as a string
     */
    @Override
    public String getLastAgent()
    {
        return this.sender;
    }
    //End of getLastAgent
}
//End of UserMsg class