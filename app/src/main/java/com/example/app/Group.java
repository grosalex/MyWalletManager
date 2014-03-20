package com.example.app;

import java.util.List;

/**
 * Created by grosalex on 20/03/14.
 */
public class Group {
    private String nom;
    private List <User> userCollection;
    public Group(){

    }
    public User findByName(String name){
        for(int i = 0;i<userCollection.size();i++){
            if(userCollection[i].getName()==name){
                return userCollection[i];
            }
        }
        return null;
    }
}
