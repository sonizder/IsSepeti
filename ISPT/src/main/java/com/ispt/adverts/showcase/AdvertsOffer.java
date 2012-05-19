/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.adverts.showcase;

import com.ispt.adverts.AdvertsSave;
import com.ispt.hib.core.HibCrud;
import com.ispt.offers.Offers;
import com.ispt.users.Users;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author s1r
 */
@ManagedBean
@ViewScoped
public class AdvertsOffer implements Serializable{
    //    private Adverts adSelected;

    private Offers offer;

    public AdvertsOffer() {
      offer=new Offers();
    }
    public Offers getOffer() {
        return offer;
    }
    public void setOffer(Offers offer) {
        this.offer = offer;
    }
    
    
    @ManagedProperty(value="#{advertsCarouselSelected}")
    private AdvertsCarouselSelected adCSelected;
    public AdvertsCarouselSelected getAdCSelected() {
        return adCSelected;
    }
    public void setAdCSelected(AdvertsCarouselSelected adCSelected) {
        this.adCSelected = adCSelected;
    }


    
    

    
     public void save(ActionEvent event){

         offer.setAdverts(adCSelected.getAdvertsSelected());         
         offer.setOkunmusmu(Boolean.TRUE);
         offer.setTeklifAlanId(adCSelected.getAdvertsSelected().getUsers().getIdUsers());
         offer.setTeklifVerenId(new AdvertsSave().save().getIdUsers());
         
        boolean kayit=new HibCrud<Offers>().create(offer); 
        
        String kayitMsg;
        if(kayit==true){
            kayitMsg="Kayıt İşlemi Başarılı";
            System.out.println("Kayıt İşlemi Başarılı");
            System.out.println("Kayıt İşlemi Başarılı");
            System.out.println("Kayıt İşlemi Başarılı");
        }else{
            kayitMsg="Kayıt İşlemi Başarısız!!!";
            System.out.println("Kayıt İşlemi Başarısız!!!");
            System.out.println("Kayıt İşlemi Başarısız!!!");
            System.out.println("Kayıt İşlemi Başarısız!!!");

        }
//        FacesMessage msg = new FacesMessage( "Hoşgeldiniz  "+offer.getTeklifAlanId(),kayitMsg);
//        FacesContext.getCurrentInstance().addMessage(null, msg);
         
        
    }
    
    
//    public void ssdd(ActionEvent event){ 
//        System.out.println("selected"+adCSelected.getAdvertsSelected().getSehir());
//
//    }
//    
    
    
}
