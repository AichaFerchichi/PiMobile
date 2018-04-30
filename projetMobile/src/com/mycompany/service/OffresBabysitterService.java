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
import com.mycompany.entity.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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
        con.setUrl("http://localhost/houfinal/Utopia/projetSymfonyPIDEV/web/app_dev.php/allOffreBabysitter");
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
                         float id=Float.parseFloat(((LinkedHashMap)obj.get("idbb")).get("id").toString());


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
                        OffreBabysitter.setId_babysitter((int) id);

                        listTasks.add(OffreBabysitter);

                    }
                } catch (IOException ex) {
                }

            
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    public ArrayList<Offre> getListById() {
        ArrayList<Offre> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/houfinal/Utopia/projetSymfonyPIDEV/web/app_dev.php/OffreBabysitterById/"+User.idUserConnected);
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
                         float id=Float.parseFloat(((LinkedHashMap)obj.get("idbb")).get("id").toString());


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
                        OffreBabysitter.setId_babysitter((int) id);

                        listTasks.add(OffreBabysitter);

                    }
                } catch (IOException ex) {
                }

            
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
}
