package com.mycompany.gui;



import com.mycompany.service.UserService;
import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.entity.User;
import java.util.ArrayList;


public class SignInForm extends BaseForm {

private Resources theme;


    public SignInForm(Resources res) {
        super(new BorderLayout());
        
        if(!Display.getInstance().isTablet()) {
            BorderLayout bl = (BorderLayout)getLayout();
            bl.defineLandscapeSwap(BorderLayout.NORTH, BorderLayout.EAST);
            bl.defineLandscapeSwap(BorderLayout.SOUTH, BorderLayout.CENTER);
        }
        getTitleArea().setUIID("Container");
        setUIID("SignIn");
        add(BorderLayout.NORTH, new Label(res.getImage("logoo.png"), "LogoLabel"));
        TextField username = new TextField("", "Username", 30, TextField.ANY);
        TextField password = new TextField("", "Password", 40, TextField.PASSWORD);
        username.setSingleLineTextArea(false);
        password.setSingleLineTextArea(false);
        Button signIn = new Button("Sign In");
        Button signUp = new Button("Sign Up");
        signUp.addActionListener(e -> new SignUpForm(res).show());
        signUp.setUIID("Link");
        Label doneHaveAnAccount = new Label("Don't have an account?");
        Container content = BoxLayout.encloseY(
                new FloatingHint(username),
                 createLineSeparator(),
                new FloatingHint(password),
                createLineSeparator(),
                signIn,
                FlowLayout.encloseCenter(doneHaveAnAccount, signUp)
        );
        content.setScrollableY(true);
        add(BorderLayout.SOUTH, content);
        signIn.requestFocus();
       signIn.addActionListener(e ->{
          User user=new User(username.getText(),password.getText());
               UserService serviceTask=new UserService();
               
     ArrayList<User> lis=serviceTask.log(user); 
       for ( User  us : lis) {
/*
        if(us!=null){
                                   User.setIdUserConnected(us.getId());

              theme = UIManager.initFirstTheme("/theme");

              new AccueilBabysitterForm(theme).show(); }

       }
*/

            if(us!=null)
            {
               theme = UIManager.initFirstTheme("/theme");
            AffichageGarderieForm aff=new AffichageGarderieForm(theme);
            aff.getF().show();}
            
              
       }

                
        });
    }
    
}
