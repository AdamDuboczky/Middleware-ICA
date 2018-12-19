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
 *
 * @author T-A-T
 */
public class NodeMonitor
{
    private volatile List<Message> messageLog;
    
    public NodeMonitor()
    {
        messageLog = new ArrayList<>();
    }
    //End of NodeMonitor default constructor
    
    public void updateMonitor(Message message)
    {
        if(message != null)
        {
            messageLog.add(message);
        }
    }
    //End of updateMonitor
    
    public int getLogSize()
    {
        return messageLog.size();
    }
    //End of getLogSize
    
    public Message grabUpdate(int index)
    {
        return messageLog.get(index);
    }
    //End of grabUpdate
}
//End of NodeMonitor class