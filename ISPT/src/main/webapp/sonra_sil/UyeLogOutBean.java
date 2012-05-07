/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.deneme;

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
@ManagedBean(name="uyeLogOutBean")
@SessionScoped
public class UyeLogOutBean {

    
    FacesContext context = FacesContext.getCurrentInstance();
    


   public void logOut(ActionEvent actionEvent){
   
        HttpSession httpsession= (HttpSession)context.getExternalContext().getSession(false);
        GirisDenemeBean Bean = (GirisDenemeBean)httpsession.getAttribute("sss");
        
           
            
            String info="";
        if(Bean==null){
            info+="beanNul:   ";
            System.out.println("**********beanNul: ");
            System.out.println("**********beanNul: ");
        }else if(Bean.getPassword()==null){
            info+="password NULL";
            System.out.println("***********password NULL");
            System.out.println("***********password NULL");
        }else if(Bean.getUsername()==null){
            info+="userName null";
            System.out.println("************username NULL");
            System.out.println("************username NULL");
        }else{
            System.out.println("passs:  "+Bean.getPassword());
            System.out.println("uername:  "+Bean.getUsername());            
            info+="Null Bİr şey yok!!!!";
            System.out.println("***************NULL Birşey yok");
            System.out.println("***************NULL Birşey yok");
        }
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hoşgeldin", info);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
//        this.password = Bean.getPassword();
//        this.login = Bean.getLogin();
//        Bean.setPassword("");
//        Bean.setLogin("");
//        ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
//        HttpServletResponse response = (HttpServletResponse)ectx.getResponse();
//        HttpSession session = (HttpSession)ectx.getSession(false);
//        session.invalidate();
//    
   }
   public String sss(){
       
       return "menu.xhtml";
   }
        

    
}
