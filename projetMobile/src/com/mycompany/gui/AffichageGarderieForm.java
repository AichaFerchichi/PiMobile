/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.mycompany.service.OffresBabysitterService;
import com.mycompany.entity.Offre;
import com.codename1.components.FloatingHint;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
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
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.entity.Garderies;
import com.mycompany.service.GarderieService;

import java.util.ArrayList;
/**
 *
 * @author pc
 */
public class AffichageGarderieForm extends BaseForm {
    Form f;
    SpanLabel lb;
    EncodedImage enc;
    URLImage uRLImage;
    Resources theme;

  
    public AffichageGarderieForm(Resources res) {
    super(new BorderLayout());
       
        f = new Form("Nos Garderies");
      
                   
        lb = new SpanLabel("");
     
        GarderieService serviceOffre=new GarderieService();
        ArrayList<Garderies> lis=serviceOffre.getList2();
                                 
                                 Container c1=new Container(BoxLayout.y());
                                  
                                 f.add(c1);
         for (Garderies o : lis) {
               Container exp = new Container(BoxLayout.y());
               Container c2 = new Container(BoxLayout.x());
           theme = UIManager.initFirstTheme("/theme");
                     enc=EncodedImage.createFromImage(theme.getImage("logoo.png"), false);
        uRLImage=URLImage.createToStorage(enc,o.getImage(), "http://localhost:8888/houfinal/Utopia/projetSymfonyPIDEV/web/ressources/" + o.getImage(),URLImage.RESIZE_SCALE_TO_FILL);
                             uRLImage.fetch();

         ImageViewer imgV=new ImageViewer(uRLImage);
        
                c2.add(imgV)  ;         
                imgV.addPointerPressedListener(e ->{
                 theme = UIManager.initFirstTheme("/theme");
                new AffichageForm(theme).show();
                });
                                TextArea desc5 = new TextArea(o.getNom());
                desc5.setUIID("TextFieldBlack");
                desc5.setEditable(false);
                 TextArea email = new TextArea(o.getEmail());
                email.setUIID("TextFieldBlack");
                email.setEditable(false);
               TextArea desc = new TextArea(o.getDescription());
                desc.setUIID("TextFieldBlack");
                desc.setEditable(false);
                TextArea desc2 = new TextArea(o.getAdresse());
                desc2.setUIID("TextFieldBlack");
                desc2.setEditable(false);
                addStringValue("", desc5,exp);
                addStringValue( "",email,exp);
                
                 addStringValue( "",desc,exp);
                 addStringValue( "",desc2,exp);
       
        
        
     c2.add(exp)  ;
     c1.add(c2);
 Label bt = new Label("plus");
       
             bt.addPointerPressedListener(e ->{
                 theme = UIManager.initFirstTheme("/theme");
                 System.out.println("iddddd"+o.getIdGarderie());
                 DetailForm dt=new DetailForm(theme,o.getIdGarderie());
               dt.getF().show();
                }); c1.add(bt);
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
