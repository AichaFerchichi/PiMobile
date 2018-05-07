/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ext.filechooser.FileChooser;
import com.codename1.capture.Capture;
import com.codename1.components.FloatingHint;
import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.CheckBox;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.entity.Offre;
import com.mycompany.entity.User;
import com.mycompany.service.OffresBabysitterService;
import com.mycompany.service.UserService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author pc
 */
public class AjouterOffreBabysitter extends BaseForm {

    Resources theme;
    Label im=new Label();
    public AjouterOffreBabysitter(Resources res) {
        super(new BorderLayout());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.setUIID("Container");
        getTitleArea().setUIID("Container");
        Form previous = Display.getInstance().getCurrent();
        tb.setBackCommand("", e -> previous.showBack());
        setUIID("SignIn");
          UserService us=new UserService();
          ArrayList<User> maliste=new ArrayList<>();
          maliste=us.RecupererUserById();

          String aa="";
          String bb="";
          for(User u: maliste)
          {
            aa = u.getUsername();
            bb=u.getEmail();


          }
          System.out.println("mmmmm"+aa);
        TextField username = new TextField(aa, "Prenom", 20, TextField.ANY);
          username.setEnabled(false);
        TextField adresse = new TextField("", "Adresse", 20, TextField.ANY);
        TextField age = new TextField("", "Age", 20, TextField.ANY);
        TextField motivation = new TextField("", "Motivation", 20, TextField.ANY);
        TextField tel = new TextField("", "Numéro de téléphone", 20, TextField.ANY);
        TextField email = new TextField(bb, "Email", 20, TextField.ANY);
         email.setEnabled(false);
        TextField dispo = new TextField("", "Disponibilite", 20, TextField.ANY);

         ComboBox<String> sexe = new ComboBox<> (
           "Homme",
         "Femme"
          );
         ComboBox<String> experience = new ComboBox<> (
          
         "Sans experience",
         "1-2",
         "3-4",
         "4-5"

          );
         ComboBox<String> lieu = new ComboBox<> (
          
          "Pas de preferences",
          "A mon domicile",
           "Au domicile de la famille"

          );
        
        username.setSingleLineTextArea(false);
        adresse.setSingleLineTextArea(false);
        age.setSingleLineTextArea(false);
        motivation.setSingleLineTextArea(false);
        Button next = new Button("Next");
        Button signIn = new Button("Sign In");
        signIn.addActionListener(e -> previous.showBack());
        signIn.setUIID("Link");
        Label alreadHaveAnAccount = new Label("Already have an account?");
         Button imga=new Button("importer image");
         Button ajouter =new  Button("Ajouter");
               imga.addActionListener(l-> {
      ActionListener callback = e->{
   if (e != null && e.getSource() != null) {
       String filePath = (String)e.getSource();
       System.out.println(filePath);

 im.setText(filePath);
       //  Now do something with this file
   }
};
ajouter.addActionListener(e->{ 
    Offre p=new Offre();
        p.setDescription(motivation.getText());
        p.setAdresse(adresse.getText());
        p.setSexe(sexe.getSelectedItem());
        p.setNumtel(tel.getText());
        p.setExperience(experience.getSelectedItem());
        p.setLieu_baby(lieu.getSelectedItem());
        p.setAge(Integer.valueOf(age.getText()));
        p.setDispo(dispo.getText());
        p.setImage(im.getText());
        p.setId_babysitter(User.idUserConnected);
        System.out.println(p);
            OffresBabysitterService ps=new OffresBabysitterService();
            if((p.getAge()<18)||(p.getAge()>60))
            {Dialog.show("Echec", "Vous devez avoir un age entre 18 et 60 ans", "Ok", null);

            }
            else{
            Dialog.show("Succée", "Offre publiée!", "Ok", null);}
            removeAll();

            
        });
if (FileChooser.isAvailable()) {
    FileChooser.showOpenDialog(".pdf,application/pdf,.gif,image/gif,.png,image/png,.jpg,image/jpg,.tif,image/tif,.jpeg", callback);
} else {
    Display.getInstance().openGallery(callback, Display.GALLERY_IMAGE);
}
  
       });               
        Container content = BoxLayout.encloseY(
                new Label("General", "LogoLabel"),
                createLineSeparator(),
                new FloatingHint(username),
                new FloatingHint(adresse),
                new FloatingHint(age),
                sexe,
                new FloatingHint(motivation),
               // new FloatingHint(confirmPassword),
                createLineSeparator(),
                new Label("Coordonnées", "LogoLabel"),
                                createLineSeparator(),

                new FloatingHint(tel),
                new FloatingHint(email),
                                new FloatingHint(dispo),

                                                createLineSeparator(),

                new Label("A propos de moi", "LogoLabel"),
                
                                                createLineSeparator(),

                experience,
                lieu,
               
                   createLineSeparator(),

                new Label("Photo de votre offre", "LogoLabel"),
                
                                                createLineSeparator(),
                                                imga,
                                                ajouter
                

               

        );
        
        content.setScrollableY(true);
        add(BorderLayout.CENTER, content);
        
        next.requestFocus();
        
    }
      private Set<String> createListEntry(String name) {
    Set<String> entry = new HashSet<>();
    entry.add(name);
    
    return entry;
   }
    
}
