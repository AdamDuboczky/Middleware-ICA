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
public class UserMsg implements Message
{
    private final String message;
    private final String destination;
    private final String sender;
    private final String senderPortalType;
    private final String destPortalType;
    private final LocalDateTime timeStamp;
    
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
    public String getDestPortType()
    {
        return destPortalType;
    }
    //End of getDestPortType

    @Override
    public String getSenderPort()
    {
        return senderPortalType;
    }
    //End of getPortVisited

    @Override
    public MetaAgent getAgent()
    {
        return null;
    }

    @Override
    public int getHopCount()
    {
        return 0;
    }

    @Override
    public String getLastAgent()
    {
        return this.sender;
    }
}
//End of User class