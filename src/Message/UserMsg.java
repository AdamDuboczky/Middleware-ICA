/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Message;

import Agents.PortalTypes;
import java.time.LocalDateTime;

/**
 *
 * @author T-A-T
 */
public class UserMsg implements Message
{
    private final String message;
    private final String destination;
    private final String sender;
    private final PortalTypes destPortalType;
    private final LocalDateTime timeStamp;
    
    public UserMsg(PortalTypes destPortalType, String destination, String message, String sender)
    {
        this.destPortalType = destPortalType;
        this.destination = destination;
        this.message = message;
        this.sender = sender;
        this.timeStamp = LocalDateTime.now();
    }
    //End of UserMsg default constructor
    @Override
    public String getUserMessage()
    {
        return message;
    }
    //End of getMessage
    
    @Override
    public String getDestination()
    {
        return this.destination;
    }
    //End of getDestination

    @Override
    public String getSender()
    {
        return this.sender;
    }
    //End of getSender

    @Override
    public SysMsgTypes getSysMessage()
    {
        return null;
    }
    //End of getSysMessage

    @Override
    public PortalTypes getDestPortType()
    {
        return destPortalType;
    }
    //End of getDestPortType

    @Override
    public PortalTypes getSenderPort()
    {
        return null;
    }
    //End of getSenderPort

    @Override
    public PortalTypes getPortVisited()
    {
        return null;
    }
    //End of getPortVisited
}
//End of User class