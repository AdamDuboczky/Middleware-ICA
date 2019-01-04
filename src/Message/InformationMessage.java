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
public interface InformationMessage extends SuperMessage
{
    /**
     * Gets the contents of the user message
     * @return Contents of the user message as a string
     */
    public abstract String getUserMessage();
    /**
     * Gets the destination of the message
     * @return destination of the message as a string
     */
    public abstract String getDestination();
    /**
     * Gets the portal type of the destination
     * @return the portal type of the destination as a string
     */
    public abstract String getDestPortType();
    /**
     * Gets the sender portal of the message
     * @return the sender portal of the message as a string
     */    
    public abstract String getSenderPort();    
}
