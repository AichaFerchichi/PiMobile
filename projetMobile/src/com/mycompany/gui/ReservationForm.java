/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.entity.Covoiturage;
import com.mycompany.service.CovoiturageService;
import java.util.ArrayList;

/**
 *
 * @author imen
 */
public class ReservationForm {

    Form f;
    Resources theme;

    public ReservationForm() {
        f = new Form("Reserver", BoxLayout.y());
        theme = UIManager.initFirstTheme("/theme");
        CovoiturageService CS = new CovoiturageService();

      

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
