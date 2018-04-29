/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MacBook
 */
public class AffichageForm  extends BaseForm {
 Form f;
    SpanLabel lb;
   
    public AffichageForm(Resources res) {
        
       /* Button bt = new Button("button");
        Container content = BoxLayout.encloseY(
               
                bt     
        );
         add(BorderLayout.NORTH, content);
        bt.requestFocus();*/
        super(new BorderLayout());
        if(!Display.getInstance().isTablet()) {
            BorderLayout bl = (BorderLayout)getLayout();
            bl.defineLandscapeSwap(BorderLayout.NORTH, BorderLayout.EAST);
            bl.defineLandscapeSwap(BorderLayout.SOUTH, BorderLayout.CENTER);
        }
        getTitleArea().setUIID("Container");
     
      setUIID("SignIn");
        
      
    
       
        
        
         
    }

   
    
     
       
}

   
    
     
       

