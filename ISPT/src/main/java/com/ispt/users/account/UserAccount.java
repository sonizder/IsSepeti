/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.users.account;

import com.ispt.adverts.Adverts;
import com.ispt.hib.core.HibCrud;
import com.ispt.login.LoginControll;
import com.ispt.offers.Offers;
import com.ispt.users.Users;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author s1r
 */
@ManagedBean
public class UserAccount {
    
    private int comingOffers=0;  
    private int comingmesaj=0;   
    private int currentAdverts=0;

    

    public int getComingOffers() {
        return comingOffers;
    }
    public void setComingOffers(int comingOffers) {
        this.comingOffers = comingOffers;
    }

    public int getComingmesaj() {
        return comingmesaj;
    }
    public void setComingmesaj(int comingmesaj) {
        this.comingmesaj = comingmesaj;
    }
    public int getCurrentAdverts() {
        return currentAdverts;
    }
    public void setCurrentAdverts(int currentAdverts) {
        this.currentAdverts = currentAdverts;
    }
    
    
  
    

    
    List<Users> usersListesi;
    
    Users user;

    public UserAccount() {
        FacesContext fc=FacesContext.getCurrentInstance();
        HttpSession httpses=(HttpSession)fc.getExternalContext().getSession(false);
        LoginControll nesnesi=(LoginControll)httpses.getAttribute("loginControll");
        System.out.println("LoginUser"+nesnesi.getMail());

        
        usersListesi=(List<Users>)new HibCrud<Users>().read("from Users where mail = '"+nesnesi.getMail()+"' and sifre = '"+nesnesi.getPassword()+"'");

        int userId=(Integer)fc.getExternalContext().getSessionMap().get("id");
        
        List<Adverts> advertsListesi=(List<Adverts>) new HibCrud<Adverts>().read("from Adverts where Users_IdUsers='"+userId+"'");

        this.currentAdverts=advertsListesi.size();        
        List<Offers> offersListesi=(List<Offers>) new HibCrud<Offers>().read("from Offers where TeklifAlanId='"+userId+"' "
                                                                                 + "and okunmusmu ='1'");
        
        
        for (int i = 0; i < offersListesi.size(); i++) {
            
            if(offersListesi.get(i).getOkunmusmu()==true){
                this.comingOffers++;
            }else{
                this.comingmesaj++;
            }
        }

    }   
    
}
/* teklif 1: GelenTeklif       1=True, 
   cevap  1: Verilen Cevap
    
   teklif 0: Yapılan Teklif    0=false.
   cevap  0: Gelen Cevap
   * 
   *
   İlan veren = Teklif Gelir, Teklife Cevap Verir.
   İş Arayan  = Teklif Yapar, teklife Cevap Gelir.
   */