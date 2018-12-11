/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Message;

/**
 *
 * @author T-A-T
 */
public class SystemMsg implements Message
{
    private final Message inner;
    private final String systemMsg;
    
    public SystemMsg(Message inner, String sysMsg)
    {
        this.inner = inner;
        systemMsg = sysMsg;
    }
    //End of SystemMsg default constructor
    
    @Override
    public String getUserMessage()
    {
        return inner.getUserMessage();
    }
    //End of getMessage

    @Override
    public String getSysMessage()
    {
        return inner + inner.getSysMessage();
    }
}
//End of SystemMsg class