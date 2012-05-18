package com.ispt.users;
// Generated 13.May.2012 14:08:22 by Hibernate Tools 3.2.1.GA


import com.ispt.adverts.Adverts;
import java.util.HashSet;
import java.util.Set;

/**
 * Users generated by hbm2java
 */
public class Users  implements java.io.Serializable {


     private Integer idUsers;
     private String isim;
     private String soyisim;
     private String mail;
     private String sifre;
     private String telefon;
     private String sehir;
     private String il;
     private String cinsiyet;
     private Set<Adverts> advertses = new HashSet<Adverts>(0);

    public Users() {
    }

    public Users(String isim, String soyisim, String mail, String sifre, String telefon, String sehir, String il, String cinsiyet, Set<Adverts> advertses) {
       this.isim = isim;
       this.soyisim = soyisim;
       this.mail = mail;
       this.sifre = sifre;
       this.telefon = telefon;
       this.sehir = sehir;
       this.il = il;
       this.cinsiyet = cinsiyet;
       this.advertses = advertses;
    }
   
    public Integer getIdUsers() {
        return this.idUsers;
    }
    
    public void setIdUsers(Integer idUsers) {
        this.idUsers = idUsers;
    }
    public String getIsim() {
        return this.isim;
    }
    
    public void setIsim(String isim) {
        this.isim = isim;
    }
    public String getSoyisim() {
        return this.soyisim;
    }
    
    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }
    public String getMail() {
        return this.mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getSifre() {
        return this.sifre;
    }
    
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    public String getTelefon() {
        return this.telefon;
    }
    
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public String getSehir() {
        return this.sehir;
    }
    
    public void setSehir(String sehir) {
        this.sehir = sehir;
    }
    public String getIl() {
        return this.il;
    }
    
    public void setIl(String il) {
        this.il = il;
    }
    public String getCinsiyet() {
        return this.cinsiyet;
    }
    
    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }
    public Set<Adverts> getAdvertses() {
        return this.advertses;
    }
    
    public void setAdvertses(Set<Adverts> advertses) {
        this.advertses = advertses;
    }




}


