/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.entity.Offre;
import com.mycompany.service.OffresBabysitterService;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class ProfilBabysitterForm extends BaseForm{
    public ProfilBabysitterForm(Resources res) {
        super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Profile");
        getContentPane().setScrollVisible(false);
         OffresBabysitterService Offres=new OffresBabysitterService();
        ArrayList<Offre> maliste=Offres.getListById();
        
       for(Offre o :maliste)
       {
       
EncodedImage encimg = EncodedImage.createFromImage(res.getImage("backgroundMobile.jpg"), false);
 URLImage urlimage = URLImage.createToStorage(encimg, o.getImage(), "http://localhost/houfinal/Utopia/projetSymfonyPIDEV/web/ressources/" + o.getImage());
 urlimage.fetch();
     ImageViewer img = new ImageViewer(urlimage);
                           
        
        
        
       // Image img = res.getImage("backgroundMobile.jpg");
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
          //  img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
       // ScaleImageLabel sl = new ScaleImageLabel(img);
       // sl.setUIID("BottomPad");
       // sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        Label facebook = new Label("786 followers", res.getImage("facebook-logo.png"), "BottomPad");
        Label twitter = new Label("486 followers", res.getImage("twitter-logo.png"), "BottomPad");
        facebook.setTextPosition(BOTTOM);
        twitter.setTextPosition(BOTTOM);
        
        add(LayeredLayout.encloseIn(
                img,
                BorderLayout.south(
                    GridLayout.encloseIn(3, 
                            facebook,
                            FlowLayout.encloseCenter(
                                new Label(res.getImage("3keaoddd.jpg"), "PictureWhiteBackgrond")),
                            twitter
                    )
                )
        ));

        TextField username = new TextField("medmaatar");
        username.setUIID("TextFieldBlack");
        addStringValue("Username", username);

        TextField email = new TextField("maatar@gmail.com", "E-Mail", 20, TextField.EMAILADDR);
        email.setUIID("TextFieldBlack");
        addStringValue("E-Mail", email);
        
        TextField password = new TextField("maatar", "Password", 20, TextField.PASSWORD);
        password.setUIID("TextFieldBlack");
        addStringValue("Password", password);

        CheckBox cb1 = CheckBox.createToggle(res.getImage("on-off-on.png"));
        cb1.setUIID("Label");
        cb1.setPressedIcon(res.getImage("on-off-off.png"));
        CheckBox cb2 = CheckBox.createToggle(res.getImage("on-off-off.png"));
        cb2.setUIID("Label");
        cb2.setPressedIcon(res.getImage("on-off-on.png"));
        
        addStringValue("Facebook", FlowLayout.encloseRightMiddle(cb1));
        addStringValue("Twitter", FlowLayout.encloseRightMiddle(cb2));
       }}
    
    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
        add(createLineSeparator(0xeeeeee));
    }
}
