/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.mycompany.entity.User;
/**
 *
 * @author MacBook
 */
public class UserService {

    public UserService() {
    }
    public void ajoutUser(User ta) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/houfinal/Utopia/projetSymfonyPIDEV/web/app_dev.php/ajoutUser/" + ta.getUsername() + "/" + ta.getEmail()+ "/" + ta.getPassword();
        con.setUrl(Url);

        System.out.println("tt");

        con.addResponseListener(e -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
   
    public ArrayList<User> log(User ta) {
         ArrayList<User> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/houfinal/Utopia/projetSymfonyPIDEV/web/app_dev.php/log/" + ta.getUsername() + "/" + ta.getPassword();
        con.setUrl(Url);

        System.out.println("tt");

        con.addResponseListener(e -> {
            JSONParser jsonp = new JSONParser();
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        System.out.println(obj);
                        User task = new User();
                        
                        float id = Float.parseFloat(obj.get("id").toString());

                       
                       
                        task.setUsername(obj.get("username").toString());
                          task.setPassword(obj.get("password").toString());
                           task.setId((int) id);


                        listTasks.add(task);

                    }
                } catch (IOException ex) {
                }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
}
