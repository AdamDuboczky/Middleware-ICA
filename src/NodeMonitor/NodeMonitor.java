/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NodeMonitor;

import Message.Message;
import java.util.ArrayList;
import java.util.List;

/**
 * Monitor to be 'attached' to a MetaAgent
 * @author T-A-T
 */
public class NodeMonitor
{
    private volatile List<Message> messageLog;
    
    /**
     * Default constructor, initialising an ArrayList which stores a log of the messages
     */
    public NodeMonitor()
    {
        messageLog = new ArrayList<>();
    }
    //End of NodeMonitor default constructor
    
    /**
     * NodeMonitor is given a copy of the Message by the MetaAgent to be stored for monitoring
     * @param message Message to be added to log
     */
    public void updateMonitor(Message message)
    {
        if(message != null)
        {
            messageLog.add(message);
        }
    }
    //End of updateMonitor
    
    /**
     * Returns the current size of the ArrayList messageLog 
     * @return int size of the ArrayList
     */
    public int getLogSize()
    {
        return messageLog.size();
    }
    //End of getLogSize
    
    /**
     * Returns a Message so that this can be inspected
     * @param index Specified index for the Message needed from ArrayList
     * @return Message selected message to be inspected
     */
    public Message grabUpdate(int index)
    {
        return messageLog.get(index);
    }
    //End of grabUpdate
}
//End of NodeMonitor class