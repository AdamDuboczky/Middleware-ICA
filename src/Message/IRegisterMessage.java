/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Message;

import Agents.MetaAgent;

/**
 *
 * @author Adam
 */
public interface IRegisterMessage extends SuperMessage
{
    public abstract MetaAgent getAgent();
}
