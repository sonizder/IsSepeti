/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.deneme;

import com.ispt.users.UsersSave;
import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author s1r
 */
@ManagedBean(name = "girisDenemeBean")
@SessionScoped
public class GirisDenemeBean implements Serializable {

    public static final long serialVersionUID = 1L;
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void login(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        boolean loggedIn;

        boolean giris = new UsersSave().logIn(username, password);
        
        if (giris == true) {
            loggedIn = true;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hoşgeldin", username);
        } else {
            loggedIn = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Hatalı Giriş", "Geçersiz Kimlik Bilgileri.");
        }
        
        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);


    }
    public void logornot(){

        FacesContext fc=FacesContext.getCurrentInstance();
         HttpSession httpses=(HttpSession)fc.getExternalContext().getSession(false);
         GirisDenemeBean nesnesi=(GirisDenemeBean)httpses.getAttribute("girisDenemeBean");
         System.out.println("ssssssssssssssssssssssssssss");
         System.out.println("ssssssssssssssssssssssssssss");
         System.out.println("ssssssssssssssssssssssssssss");
         System.out.println("ssssssssssssssssssssssssssss");
         System.out.println("ssssssssssssssssssssssssssss");
         System.out.println("ssssssssssssssssssssssssssss");
         System.out.println("ssssssssssssssssssssssssssss");
         
         
         System.out.println("*********************"+nesnesi.username);
         System.out.println("*********************"+nesnesi.username);
         System.out.println("*********************"+nesnesi.username);
         System.out.println("*********************"+nesnesi.username);
         System.out.println("*********************"+nesnesi.username);
         System.out.println("*********************"+nesnesi.username);
         System.out.println("*********************"+nesnesi.username);
         System.out.println("*********************"+nesnesi.username);
 
         if(nesnesi==null){
             System.out.println("NULLLLLLLLLLLLLLLLLLLLLLL");
             System.out.println("NULLLLLLLLLLLLLLLLLLLLLLL");
             doRedirect("bakmadansil.xhtml");
//             return false;
         }else{
             System.out.println("nsession: "+nesnesi);
             System.out.println("nsession: "+nesnesi);
             System.out.println("nsession: "+nesnesi);
             System.out.println("nsession: "+nesnesi);
             System.out.println("nsession: "+nesnesi);
             doRedirect("bakmadansil.xhtml");
//             return true;
         }
    }

    private void doRedirect(String url) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();

            context.getExternalContext().redirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



//--------------------------------------------------------------------------------


//            GirisDenemeBean nGirisDenemeBean=new GirisDenemeBean();
//            nGirisDenemeBean.setPassword(password);
//            nGirisDenemeBean.setUsername(username);
//            
//            
//            FacesContext facesContext = FacesContext.getCurrentInstance();
//            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);                       
//            session.setAttribute("girisDenemeBean", nGirisDenemeBean);









//            FacesContext contextt = FacesContext.getCurrentInstance();
//contextt.getExternalContext().getSessionMap().put("user", current);
           






//            Enumeration e = session.getAttributeNames();
//            while (e.hasMoreElements()) {
//                String attr = (String) e.nextElement();
////                System.err.println("      attr  = " + attr);
//                System.out.println("      attr  = " + attr);
//                Object value = session.getAttribute(attr);
////                System.err.println("      value = " + value);
//                System.out.println("      value = " + value);
//            }
//            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//            Object obj=request.getSession().getAttribute("girisDenemeBean");
//            System.out.println("*******************obj"+ obj);
//            System.out.println("*******************obj"+ obj);
//            String aaa= FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
//            Object o = FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//            Object object1 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idUsers");
//            String conteksname = FacesContext.getCurrentInstance().getExternalContext().getContextName();
//            Object object2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");

//
//            FacesContext fc = FacesContext.getCurrentInstance();
//            String usrname = (String) fc.getApplication().createValueBinding("#{SessionScope.username}").getValue(fc);
// 
//            FacesContext fcc = FacesContext.getCurrentInstance();
//            String usrnm = (String) fcc.getApplication().createValueBinding("#{SessionScope.isim}").getValue(fcc);
//
//            System.out.println("*************** object1 " + object1);
//            System.out.println("*************** username " + object2);
//            System.out.println("*************** username " + usrname);
//            System.out.println("*************** usrnm " + usrnm);
//            System.out.println("*************** conteksname " + conteksname);
//            System.out.println("*************** o " + o);


//            FacesContext fcontext= FacesContext.getCurrentInstance();
//        GirisDenemeBean bean=(GirisDenemeBean)fcontext.getApplication().getVariableResolver().resolveVariable(fcontext, "loginBean");
//        String pass=bean.password;
//        String isim=bean.username;
//        
//        System.out.println("şifre: "+pass+"     isim:"+ isim);
//        System.out.println("şifre: "+pass+"     isim:"+ isim);
//        System.out.println("şifre: "+pass+"     isim:"+ isim);
//        System.out.println("şifre: "+pass+"     isim:"+ isim);
//        System.out.println("şifre: "+pass+"     isim:"+ isim);
//        System.out.println("şifre: "+pass+"     isim:"+ isim);