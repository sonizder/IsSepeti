/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.login;

import com.ispt.users.UsersSave;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author s1r
 */
@ManagedBean(name="loginControll")
@SessionScoped
public class LoginControll implements Serializable{

    public static final long serialVersionUID = 1L;

    private  String username;
    private  String password;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public void controll(){        
        
        RequestContext context = RequestContext.getCurrentInstance();

        FacesMessage msg = null;
        
        boolean loggedIn=false;

        boolean giris = new UsersSave().logIn(username, password);

        if (giris == true) {

            loggedIn = true;
            
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hoşgeldin", username);
            
            doRedirect("anasayfa.xhtml");
            
        } else {
            loggedIn = false;
            
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Hatalı Giriş", "Geçersiz Kimlik Bilgileri.");
            
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);

         }
        
   public void doRedirect(String url) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String logOrNot(){

         FacesContext fc=FacesContext.getCurrentInstance();
         HttpSession httpses=(HttpSession)fc.getExternalContext().getSession(false);
         LoginControll nesnesi=(LoginControll)httpses.getAttribute("loginControll");
 
         if(nesnesi.username==null){             
             return "/template/menuBarCommon.xhtml";
         }else{
             return "/template/menuBarMember.xhtml";
         }
    }
    
    public void doLogout() {
         FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
         doRedirect("anasayfa.xhtml");
    }
    
}
