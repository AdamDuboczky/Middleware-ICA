/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Message;

import Agents.MetaAgent;

/**
 *
 * @author T-A-T
 */
public interface Message 
{
    public abstract String getUserMessage();
    
    public abstract String getDestination();
    
    public abstract String getSender();
    
    public abstract String getDestPortType();
    
    public abstract SysMsgTypes getSysMessage();
    
    public abstract String getSenderPort();
    
    public abstract MetaAgent getAgent();
    
    public abstract int getHopCount();
    
    public abstract String getLastAgent();
}
//End of Message interface