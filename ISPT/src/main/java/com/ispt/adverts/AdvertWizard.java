/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.adverts;

import com.ispt.hib.core.HibCrud;
import com.ispt.users.Users;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author s1r
 */
@ManagedBean(name = "advertWizard")
@ViewScoped

public class AdvertWizard implements Serializable{
    
    public static final long serialVersionUID = 1L;
    
    private boolean skip;
    private Adverts advert = new Adverts();
    
    private static Logger logger = Logger.getLogger(AdvertWizard.class.getName());

    public Adverts getAdvert() {
        return advert;
    }
    public void setAdvert(Adverts advert) {
        this.advert = advert;
    }    
    public boolean isSkip() {
        return skip;
    }
    public void setSkip(boolean skip) {
        this.skip = skip;
    }   
    
     
    
     public void save(ActionEvent actionEvent) {
         System.out.println("*ss*******************");
         System.out.println("**ss******************"); 
         
         
        advert.setUsers(new AdvertsSave().save());
         
        boolean kayit=new HibCrud<Adverts>().create(advert);
        String kayitMsg;
        if(kayit==true){
            kayitMsg="Başarıyla Alınmıştır.";
        }else{
            kayitMsg="Alınamamıştır Lütfen Girdilerini Kontrol edin!!!";
        }
        FacesMessage msg = new FacesMessage( advert.getIsAlani(),", İş İhale İlanınız " +kayitMsg);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        
    }

    public String onFlowProcess(FlowEvent event) {
        logger.info("Şimdiki Adım:" + event.getOldStep());
        logger.info("Bir Sonraki Adım:" + event.getNewStep());

        if (skip) {
            skip = false;   
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }
    
}
