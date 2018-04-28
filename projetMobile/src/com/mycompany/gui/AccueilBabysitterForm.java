/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author pc
 */
public class AccueilBabysitterForm {
      Form f;
      SpanLabel lb;
      Button btn1;
      Button btn2;
      Container ctn;
    public AccueilBabysitterForm() {
   f = new Form();
   lb = new SpanLabel("Vous étes ?");
   btn1=new Button("Parent");
   btn2=new Button("Babysitter");
   ctn=new Container(BoxLayout.x());
   ctn.add(btn1);
   ctn.add(btn2);
   f.add(ctn);
   f.add(lb);
   


    }
     public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
