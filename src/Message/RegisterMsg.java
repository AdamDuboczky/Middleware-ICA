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
public class RegisterMsg implements Message
{
    public MetaAgent agent;
    
    public RegisterMsg(MetaAgent agent)
    {
        this.agent = agent;
    }
    
    @Override
    public String getUserMessage()
    {
        return null;
    }

    @Override
    public String getDestination()
    {
        return null;
    }

    @Override
    public String getSender()
    {
        return "Agent: " + agent.getName() + " registering with super";
    }

    @Override
    public String getDestPortType()
    {
        return null;
    }

    @Override
    public SysMsgTypes getSysMessage()
    {
        return null;
    }

    @Override
    public String getLastAgent()
    {
        return agent.getName();
    }

    @Override
    public MetaAgent getAgent()
    {
        return agent;
    }
}
//End of RegisterMsg class