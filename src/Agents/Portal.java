/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author T-A-T
 */
public class Portal extends MetaAgent
{
     protected final Map<String, MetaAgent> agentTable;
     protected String portalType;
     
     public Portal(String name, MetaAgent superAgent)
     {
        super(name, superAgent);
        agentTable = new HashMap<>();
     }
     //End of Portal default constructor
}
//End of Portal class