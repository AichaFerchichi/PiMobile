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
import com.mycompany.entity.Garderies;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author pc
 */
public class GarderieService {
    
    public ArrayList<Garderies> getList2() {
        ArrayList<Garderies> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost:8888/houfinal/Utopia/projetSymfonyPIDEV/web/app_dev.php/garderieAll");
        con.addResponseListener(e->{
                JSONParser jsonp = new JSONParser();
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        System.out.println(obj);
                        Garderies garderie = new Garderies();
                        //float nb_place_dispo = Float.parseFloat(obj.get("nb_place_dispo").toString());
                        
float idGarderie = Float.parseFloat(obj.get("idGarderie").toString());
                        
                        
garderie.setNom(obj.get("nom").toString());
garderie.setEmail(obj.get("Email").toString());
                        garderie.setDescription(obj.get("description").toString());
                        garderie.setAdresse(obj.get("adresse").toString());
                       garderie.setIdGarderie((int) idGarderie);

                        
                       
                        garderie.setImage(obj.get("image").toString());
                      
                       //garderie.setNb_place_dispo((int) nb_place_dispo);
                        listTasks.add(garderie);

                    }
                } catch (IOException ex) {
                }

            
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    public ArrayList<Garderies> getListById(int id) {
        ArrayList<Garderies> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost:8888/houfinal/Utopia/projetSymfonyPIDEV/web/app_dev.php/garderieById/"+id);
        con.addResponseListener(e->{
                JSONParser jsonp = new JSONParser();
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        System.out.println(obj);
                        Garderies garderie = new Garderies();
                        

garderie.setObjectif(obj.get("objectif").toString());
garderie.setProEducatif(obj.get("proEducatif").toString());
                        
                       

                        
                       
                       
                        listTasks.add(garderie);

                    }
                } catch (IOException ex) {
                }

            
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
}
