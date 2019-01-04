/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Message;

/**
 *
 * @author Adam
 */
public interface ISystemMessage extends InformationMessage
{
    /**
     * Gets the status of the system message(VALID, NOTFOUND OR ERROR)
     * @return returns an enum for the status of the system message
     */
    public abstract SysMsgTypes getSysMessage();
}
