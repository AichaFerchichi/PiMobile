/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.entity.Offre;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entity.Covoiturage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author pc
 */
public class CovoiturageService {
    
    public ArrayList<Covoiturage> getList() {
        ArrayList<Covoiturage> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/cov/all");
        con.addResponseListener(e->{
                JSONParser jsonp = new JSONParser();
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        System.out.println(obj);
                        Covoiturage C = new Covoiturage();
                        float nb = Float.parseFloat(obj.get("nbrePlaceDispo").toString());
                        C.setDepart(obj.get("depart").toString());
                        C.setDestination(obj.get("destination").toString());
                        C.setNbre_place_dispo((int)nb);

                       
                        listTasks.add(C);

                    }
                } catch (IOException ex) {
                }

            
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
}
