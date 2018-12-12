/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Message;

import Agents.PortalTypes;

/**
 *
 * @author T-A-T
 */
public interface Message 
{
    public abstract String getUserMessage();
    
    public abstract String getDestination();
    
    public abstract String getSender();
    
    public abstract PortalTypes getDestPortType();
    
    public abstract SysMsgTypes getSysMessage();
}
//End of Message interface