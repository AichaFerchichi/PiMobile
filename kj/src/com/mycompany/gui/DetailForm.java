/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.entity.Garderies;
import com.mycompany.service.GarderieService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MacBook
 */
public class DetailForm  extends BaseForm {
 Form f;
    SpanLabel lb;
   
    EncodedImage enc;
    URLImage uRLImage;
    Resources theme;

    public DetailForm(Resources res,int id) {
        
       
    super(new BorderLayout());
       
        f = new Form("Plus de Détail");
      
                   
        lb = new SpanLabel("");
     
        GarderieService serviceOffre=new GarderieService();
        ArrayList<Garderies> lis=serviceOffre.getListById(id);
                                 
                                 Container c1=new Container(BoxLayout.y());
                                 
                                 f.add(c1);
         for (Garderies o : lis) {
               
                 
               Label lb1=new Label("Notre Programme");
                   TextArea objectif = new TextArea(o.getObjectif());
                objectif.setUIID("TextFieldBlack");
                objectif.setEditable(false);
                 Label lb2=new Label("Notre Objectif");
                 TextArea pro = new TextArea(o.getProEducatif());
                pro.setUIID("TextFieldBlack");
                pro.setEditable(false);
               c1.add(lb1);
                addStringValue("", pro,c1);
                c1.add(lb2);
                addStringValue( "",objectif,c1);
                
  
 
                    }
     f.setUIID("SignIn");    
     
    }

   
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
      private void addStringValue(String s,Component v, Container cont) {
        cont.add(BorderLayout.west(new Label(s,"PaddedLabel")). add(BorderLayout.CENTER, v));
              
                
    }
     
       
}

   
    
     
       

