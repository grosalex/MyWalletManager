package com.example.app;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by grosalex on 20/03/14.
 */
public class Group {
    private String name;



    private List <User> userCollection=new LinkedList<User>();
    public Group(String inName){
        this.name = inName;
    }

    public User findByName(String name){
        for(int i = 0;i<userCollection.size();i++){
            if(userCollection.get(i).getName()==name){
                return userCollection.get(i);
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
    public void addUser(User user){
        this.userCollection.add(user);
    }
    public List<User> getUserCollection() {
        return userCollection;
    }
}
