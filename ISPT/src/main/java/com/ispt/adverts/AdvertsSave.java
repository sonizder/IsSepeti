/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.adverts;

import com.ispt.login.LoginControll;
import com.ispt.users.Users;
import com.ispt.users.UsersSave;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author s1r
 */
public class AdvertsSave {
    
    public Users save(){
                
        
        FacesContext fc=FacesContext.getCurrentInstance();
        HttpSession httpses=(HttpSession)fc.getExternalContext().getSession(false);
        LoginControll loginUserN=(LoginControll)httpses.getAttribute("loginControll"); //session LoginControll üzerinde tutuluyor.
        
//        String mail=nesnesi.getMail();
//        String sifre=nesnesi.getPassword();
        
        List<Users> logUserList=new ArrayList<Users>();
        logUserList=new UsersSave().readUsers("from Users where mail = '"+loginUserN.getMail()+
                                           "' and sifre = '"+loginUserN.getPassword()+"'");
        
//        Users nesnesiUsers=new Users();
        Users userN=(Users) logUserList.get(0);
        
        System.out.println(""+userN.getCinsiyet());
        System.out.println(""+userN.getIl());
        return userN;
        
        
    }
    
}
