/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.entity.Offre;
import com.mycompany.entity.User;
import com.mycompany.service.OffresBabysitterService;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class AccueilBabysitterForm extends BaseForm{
      Form f;
      SpanLabel lb;
      Button btn1;
      Button btn2;
      Container ctn;
      Resources theme;
    public AccueilBabysitterForm(Resources res) {
        super(new BorderLayout());
          f = new Form();
   lb = new SpanLabel("Vous étes ?");
   btn1=new Button("Parent");
   btn2=new Button("Babysitter");
   
   
        Container content = BoxLayout.encloseY(
               
            lb,btn1,btn2
               
        );
        content.setScrollableY(true);
         add(BorderLayout.NORTH, content);
        f.requestFocus();
        
        if(!Display.getInstance().isTablet()) {
            BorderLayout bl = (BorderLayout)getLayout();
            bl.defineLandscapeSwap(BorderLayout.NORTH, BorderLayout.EAST);
            bl.defineLandscapeSwap(BorderLayout.SOUTH, BorderLayout.CENTER);
        }
      setUIID("Container");
      setUIID("SignIn");
  
   
   
    btn1.addActionListener(e ->{
               
                   new AffichageForm().show();      
      
        });

 btn2.addActionListener(e ->{
         OffresBabysitterService Offres=new OffresBabysitterService();
        ArrayList<Offre> maliste=Offres.getList2();
        
        for(Offre o :maliste)
       {
           System.out.println(o);
           if(o.getId_babysitter()==User.idUserConnected)
           {
                             theme = UIManager.initFirstTheme("/theme");

                       new  ProfilBabysitterForm(theme).show(); 
                       break;

           }
           else {
                       new  AffichageForm().show();      

            
       }
            
                
        }});
 }
    
     public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
