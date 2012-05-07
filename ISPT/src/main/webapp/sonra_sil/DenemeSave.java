/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.deneme;

import com.ispt.users.Users;
import com.ispt.hib.core.HibCrud;
import java.io.Serializable;

/**
 *
 * @author s1r
 */
public class DenemeSave implements Serializable{
    public static final long serialVersionUID = 1L;
    
    private Deneme newdeneme;

    public Deneme getNewdeneme() {
        return newdeneme;
    }

    public void setNewdeneme(Deneme newdeneme) {
        this.newdeneme = newdeneme;
    }

    public DenemeSave(Deneme newdeneme) {
        this.newdeneme = newdeneme;
    }

    public DenemeSave() {
        newdeneme=new Deneme("22");
    }
    
    public void denemeCreate(){
        new HibCrud<Deneme>().create(newdeneme);  
        
    }
    
}
