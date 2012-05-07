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
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author s1r
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{
    
public static final long serialVersionUID = 1L;

    private String username;
    private String password;

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

    public void login(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();

        FacesMessage msg = null;
        boolean loggedIn = false;

        boolean giris = new UsersSave().logIn(username, password);
        if (giris == true) {
            loggedIn = true;
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//            String aaa= FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();


            
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hoşgeldin", session.getClass().toString());            
            doRedirect("uye.xhtml");
        } else {
            loggedIn = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Hatalı Giriş", "Geçersiz Kimlik Bilgileri.");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);
        
        
    }

        private void doRedirect(String url) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();

            context.getExternalContext().redirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
//    public void sessionapp() {
//        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//
//    }

//    public void sesapp() {
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
//
//        Enumeration e = session.getAttributeNames();
//        while (e.hasMoreElements()) {
//            String attr = (String) e.nextElement();
//            System.err.println("      attr  = " + attr);
//            Object value = session.getValue(attr);
//            System.out.println("      *****************************************************attr  = " + attr);
//
//        }
//    }


}
