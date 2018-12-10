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
public class UserMsg implements Message
{
    private final String message;
    
    public UserMsg(String msg)
    {
        message = msg;
    }
    //End of UserMsg default constructor
    
    @Override
    public String getUserMessage()
    {
        return message;
    }
    //End of getMessage

    @Override
    public String getSysMessage()
    {
        return "";
    }
    //End of getSysMessage
}
//End of User class