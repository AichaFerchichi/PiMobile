/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.mycompany.service.ServiceOffresBabysitter;
import com.mycompany.entity.Offre;
import com.codename1.components.FloatingHint;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;
/**
 *
 * @author pc
 */
public class AffichageOffresBaby {
    Form f;
    SpanLabel lb;
    EncodedImage enc;
    URLImage uRLImage;
    Resources theme;

  
    public AffichageOffresBaby() {
    
        f = new Form("Les profils des babysitters");
        lb = new SpanLabel("");
     
        ServiceOffresBabysitter serviceOffre=new ServiceOffresBabysitter();
        ArrayList<Offre> lis=serviceOffre.getList2();
                                 Container exp = new Container(BoxLayout.y());   
f.add(exp);
         for (Offre o : lis) {
               TextArea desc = new TextArea(o.getDescription());
                desc.setUIID("TextFieldBlack");
                desc.setEditable(false);
                TextArea desc2 = new TextArea(o.getAdresse());
                desc2.setUIID("TextFieldBlack");
                desc2.setEditable(false);
                TextArea desc3 = new TextArea(o.getExperience());
                desc3.setUIID("TextFieldBlack");
                desc3.setEditable(false);
                 addStringValue( "Description: ",desc,exp);
                 addStringValue( "Adresse: ",desc2,exp);
                 addStringValue( "Experience: ",desc3,exp);
                         theme = UIManager.initFirstTheme("/theme");
                  
      enc=EncodedImage.createFromImage(theme.getImage("round.png"), false);
        uRLImage=URLImage.createToStorage(enc, "test", "http://localhost/houfinal/Utopia/projetSymfonyPIDEV/web/ressources/" + o.getImage(),URLImage.RESIZE_SCALE_TO_FILL);
                             uRLImage.fetch();

         ImageViewer imgV=new ImageViewer(uRLImage);
        Container c=new Container();
     c.add(imgV);
                                addStringValue( " ",c,exp);
     
                    }
                  
              
        
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
