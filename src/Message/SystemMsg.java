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
    private final Message inner;
    private final SysMsgTypes systemMsg;
    private final LocalDateTime timeStamp;
    private final String portalVisited;
    
    public SystemMsg(Message inner, String portalVisited, SysMsgTypes systemMsg)
    {
        this.inner = inner;
        this.systemMsg = systemMsg;
        this.portalVisited = portalVisited;
        this.timeStamp = LocalDateTime.now();
    }
    //End of SystemMsg default constructor
    
    @Override
    public String getUserMessage()
    {
        return inner.getUserMessage();
    }
    //End of getMessage
    
    @Override
    public String getDestination()
    {
        return inner.getDestination();
    }
    //End of getDestination

    @Override
    public String getSender()
    {
        return inner.getSender();
    }
    //End of getSender

    @Override
    public SysMsgTypes getSysMessage()
    {
        return this.systemMsg;
    }
    //End of getSysMessage
    
    @Override
    public String getDestPortType()
    {
        return inner.getDestPortType();
    }
    //End of getDestPortType
    
    @Override
    public String getSenderPort()
    {
        Message m = this;
        
        while(this.inner.getSenderPort() != null)
        {
            m = inner;
        }
        
        return m.getPortVisited();
    }
    //End of getSenderPort
    
    @Override
    public String getPortVisited()
    {
        return portalVisited;
    }
    //End of getPortVisited
    
    @Override
    public MetaAgent getAgent()
    {
        return null;
    }
}
//End of SystemMsg class