/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Message.Message;
import Message.SysMsgTypes;
import Message.UserMsg;

/**
 *
 * @author T-A-T
 */
public class UserAgent extends MetaAgent
{   
    public UserAgent(String name, Portal superAgent)
    {
        super(name, superAgent);
    }
    //End of UserAgent default constructor
    
    public void sendMessage(PortalTypes destPType, String dest, String message)
    {
        superAgent.pushToSuper(new UserMsg(destPType, dest, message, this.name));
    }
    //End of sendMessage

    @Override
    protected void messageHandler(Message message)
    {
        if(message.getSysMessage() == SysMsgTypes.NOTFOUND)
        {
            System.out.println("zzz  User agent " + this.name + " sent a message that returned, 'user not found'. zzz");
        }
        else if(message.getSysMessage() == SysMsgTypes.VALID)
        {
            System.out.println("zzz  User agent " + this.name + " got a message. zzz");
        }
    }
    //End of messageHandler
}
//End of UserAgent class