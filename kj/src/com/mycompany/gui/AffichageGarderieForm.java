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
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.CheckBox;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.entity.Garderies;
import com.mycompany.service.GarderieService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
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
        super("Newsfeed", BoxLayout.y());
        
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Profile");
        getContentPane().setScrollVisible(false);

        super.addSideMenu(res);
        
        tb.addSearchCommand(e -> {});
        
        
        Image img = res.getImage("backgroundMobile.jpg");
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

       
        
        add(LayeredLayout.encloseIn(
                sl,
                BorderLayout.south(
                    GridLayout.encloseIn(3, 
                           
                            FlowLayout.encloseCenter(
                                new Label(res.getImage("3keaoddd.jpg"), "PictureWhiteBackgrond"))
                           
                    )
                )
        ));

       GarderieService serviceOffre=new GarderieService();
        ArrayList<Garderies> lis=serviceOffre.getList2();
                                 
                                Container c1=new Container(BoxLayout.y());
                                  
                                 //f.add(c1);
         for (Garderies o : lis) {
               Container exp = new Container(BoxLayout.y());
               Container c2 = new Container(BoxLayout.x());
           theme = UIManager.initFirstTheme("/theme");
                     enc=EncodedImage.createFromImage(theme.getImage("logoo.png"), false);
        uRLImage=URLImage.createToStorage(enc,o.getImage(), "http://localhost:8888/houfinal/Utopia/projetSymfonyPIDEV/web/ressources/" + o.getImage(),URLImage.RESIZE_SCALE_TO_FILL);
                             uRLImage.fetch();

         ImageViewer imgV=new ImageViewer(uRLImage);
       
                c2.add(imgV)  ;    //addStringValue1("", c2);      
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
                ComboBox<Set<String>> lieu = new ComboBox<> (
          createListEntry("Bizert"),
          createListEntry("Touzeur"),
          createListEntry("Kef"),
          createListEntry("Jendouba"),
          createListEntry("Tataouine"),
          createListEntry("Beja"));
               exp.add(lieu);
               // addStringValue("", desc5,exp);
              exp.add(desc5);
               // addStringValue( "",email,exp);
                 exp.add(email);
                // addStringValue( "",desc,exp);
                  exp.add(desc);
                // addStringValue( "",desc2,exp);
        exp.add(desc2);
        
         
    // c2.add(exp)  ;
     //c1.add(c2); 
 Label bt = new Label("plus");
       
             bt.addPointerPressedListener(e ->{
                 theme = UIManager.initFirstTheme("/theme");
                 System.out.println("iddddd"+o.getIdGarderie());
                 DetailForm dt=new DetailForm(theme,o.getIdGarderie());
               dt.getF().show();
                }); c1.add(bt);
                 addStringValue("", exp); 
                 addStringValue("", c2); 
                    setUIID("SignIn");    
              
        
         }
     /*super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Profile");
        getContentPane().setScrollVisible(false);
        
        super.addSideMenu(res);
        
        tb.addSearchCommand(e -> {});
        
        
        Image img = res.getImage("profile-background.jpg");
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        Label facebook = new Label("786 followers", res.getImage("facebook-logo.png"), "BottomPad");
        Label twitter = new Label("486 followers", res.getImage("twitter-logo.png"), "BottomPad");
        facebook.setTextPosition(BOTTOM);
        twitter.setTextPosition(BOTTOM);
        
        add(LayeredLayout.encloseIn(
                sl,
                BorderLayout.south(
                    GridLayout.encloseIn(3, 
                            facebook,
                            FlowLayout.encloseCenter(
                                new Label(res.getImage("3keaoddd.jpg"), "PictureWhiteBackgrond")),
                            twitter
                    )
                )
        ));
        f = new Form();
      

     
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
              
        
         }*/

    } public Form getF() {
        return f;
    }private Set<String> createListEntry(String name) {
    Set<String> entry = new HashSet<>();
    entry.add(name);
    
    return entry;
   }

    public void setF(Form f) {
        this.f = f;
    }
      
 
    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")). add(BorderLayout.CENTER, v));
        add(createLineSeparator(0xeeeeee));
    }

}
