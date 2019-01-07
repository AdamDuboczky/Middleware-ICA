package Agents;

import Message.Message;
import Message.SysMsgTypes;
import java.util.concurrent.ExecutorService;

/**
 *
 * @author T-A-T
 */
public class UserAgent extends MetaAgent
{
    /**
     * UserAgent constructor
     * 
     * @param name Name of meta agent
     * @param superAgent Agent in charge of routing to this object.
     * @param exS
     */
    public UserAgent(String name, MetaAgent superAgent, ExecutorService exS)
    {
        super(name, superAgent, exS);
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
            System.out.println("zzz  User agent " + this.name + " got a message: " + message.getUserMessage() + " zzz");
        }
    }
    //End of messageHandler
}
//End of UserAgent class