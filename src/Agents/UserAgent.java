/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Message.Message;
import Message.SysMsgTypes;

/**
 *
 * @author T-A-T
 */
public class UserAgent extends MetaAgent
{   
    public UserAgent(String name, MetaAgent superAgent)
    {
        super(name, superAgent);
    }
    //End of UserAgent default constructor

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