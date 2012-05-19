/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.offers;

import com.ispt.login.LoginControll;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author s1r
 */
@ManagedBean
public class OfferNavigate {
    
    public String navigate(){
         FacesContext fc=FacesContext.getCurrentInstance();
         HttpSession httpses=(HttpSession)fc.getExternalContext().getSession(false);
         LoginControll nesnesi=(LoginControll)httpses.getAttribute("loginControll"); 
         RequestContext context = RequestContext.getCurrentInstance();

        FacesMessage msg = null;
        String directPage;
         
         
         boolean loggedIn=false;
         if(nesnesi.getMail()!=null){
             loggedIn=true;
             msg = new FacesMessage(FacesMessage.SEVERITY_INFO, ""," ");             
             directPage= "teklif?faces-redirect=true";
             
         }else{
             msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Lütfen Oturum açın!"," Yada Kayıt Olun!");
             directPage= "#";
         }
         FacesContext.getCurrentInstance().addMessage(null, msg);
         context.addCallbackParam("loggedIn", loggedIn);
         return directPage;
    }
}
