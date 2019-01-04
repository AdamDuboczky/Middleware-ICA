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
public interface SuperMessage 
{
    public abstract String getSender();
    /**
     * Gets the number of hops the message is allowed
     * @return the number of hops the message is allowed as an int
     */
    public abstract int getHopCount();
    /**
     * Gets the name of the last agent which the message was sent to
     * @return the name of the agent which the message visited last as a string
     */
    public abstract String getLastAgent();
}
//End of Message interface