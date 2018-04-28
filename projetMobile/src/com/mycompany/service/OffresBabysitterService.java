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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author pc
 */
public class OffresBabysitterService {
    
    public ArrayList<Offre> getList2() {
        ArrayList<Offre> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/Babysitter/all");
        con.addResponseListener(e->{
                JSONParser jsonp = new JSONParser();
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        System.out.println(obj);
                        Offre OffreBabysitter = new Offre();
                        float age = Float.parseFloat(obj.get("age").toString());

                        OffreBabysitter.setDescription(obj.get("description").toString());
                        OffreBabysitter.setAdresse(obj.get("adresse").toString());
                        OffreBabysitter.setSexe(obj.get("sexe").toString());
                        OffreBabysitter.setNumtel(obj.get("numtel").toString());

                        OffreBabysitter.setExperience(obj.get("experience").toString());
                        OffreBabysitter.setFumeuse(obj.get("fumeuse").toString());
                        OffreBabysitter.setEnfant(obj.get("enfant").toString());
                        OffreBabysitter.setConduite(obj.get("conduite").toString());
                        OffreBabysitter.setAgregation(obj.get("agregation").toString());
                        OffreBabysitter.setDispo(obj.get("dispo").toString());
                        OffreBabysitter.setImage(obj.get("image").toString());
                        OffreBabysitter.setNfumeuse(obj.get("nfumeuse").toString());
                        OffreBabysitter.setNenfant(obj.get("nenfant").toString());
                        OffreBabysitter.setNconduite(obj.get("nconduite").toString());
                        OffreBabysitter.setNagregation(obj.get("nagregation").toString());
                       OffreBabysitter.setAge((int) age);
                        listTasks.add(OffreBabysitter);

                    }
                } catch (IOException ex) {
                }

            
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
}
