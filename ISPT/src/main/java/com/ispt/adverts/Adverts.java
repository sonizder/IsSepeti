package com.ispt.adverts;
// Generated 13.May.2012 14:08:22 by Hibernate Tools 3.2.1.GA


import com.ispt.users.Users;
import java.util.Date;

/**
 * Adverts generated by hbm2java
 */
public class Adverts  implements java.io.Serializable {


     private Integer idIlanlar;
     private Users users;
     private String isTanimi;
     private String isAciklamasi;
     private String isAlani;
     private String malzeme;
     private String sehir;
     private String il;
     private String acikAdres;
     private Date yayinSuresi;
     private String butce;
     private String anaVitrin;
     private String sektorelVitrin;
     private String ekBilgi;

    public Adverts() {
    }

	
    public Adverts(Users users) {
        this.users = users;
    }

    public Adverts(String isAlani, String sehir, String butce) {
        this.isAlani = isAlani;
        this.sehir = sehir;
        this.butce = butce;
    }

  
    
    public Adverts(Users users, String isTanimi, String isAciklamasi, String isAlani, String malzeme, String sehir, String il, String acikAdres, Date yayinSuresi, String butce, String anaVitrin, String sektorelVitrin, String ekBilgi) {
       this.users = users;
       this.isTanimi = isTanimi;
       this.isAciklamasi = isAciklamasi;
       this.isAlani = isAlani;
       this.malzeme = malzeme;
       this.sehir = sehir;
       this.il = il;
       this.acikAdres = acikAdres;
       this.yayinSuresi = yayinSuresi;
       this.butce = butce;
       this.anaVitrin = anaVitrin;
       this.sektorelVitrin = sektorelVitrin;
       this.ekBilgi = ekBilgi;
    }
   
    public Integer getIdIlanlar() {
        return this.idIlanlar;
    }
    
    public void setIdIlanlar(Integer idIlanlar) {
        this.idIlanlar = idIlanlar;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public String getIsTanimi() {
        return this.isTanimi;
    }
    
    public void setIsTanimi(String isTanimi) {
        this.isTanimi = isTanimi;
    }
    public String getIsAciklamasi() {
        return this.isAciklamasi;
    }
    
    public void setIsAciklamasi(String isAciklamasi) {
        this.isAciklamasi = isAciklamasi;
    }
    public String getIsAlani() {
        return this.isAlani;
    }
    
    public void setIsAlani(String isAlani) {
        this.isAlani = isAlani;
    }
    public String getMalzeme() {
        return this.malzeme;
    }
    
    public void setMalzeme(String malzeme) {
        this.malzeme = malzeme;
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
    public String getAcikAdres() {
        return this.acikAdres;
    }
    
    public void setAcikAdres(String acikAdres) {
        this.acikAdres = acikAdres;
    }
    public Date getYayinSuresi() {
        return this.yayinSuresi;
    }
    
    public void setYayinSuresi(Date yayinSuresi) {
        this.yayinSuresi = yayinSuresi;
    }
    public String getButce() {
        return this.butce;
    }
    
    public void setButce(String butce) {
        this.butce = butce;
    }
    public String getAnaVitrin() {
        return this.anaVitrin;
    }
    
    public void setAnaVitrin(String anaVitrin) {
        this.anaVitrin = anaVitrin;
    }
    public String getSektorelVitrin() {
        return this.sektorelVitrin;
    }
    
    public void setSektorelVitrin(String sektorelVitrin) {
        this.sektorelVitrin = sektorelVitrin;
    }
    public String getEkBilgi() {
        return this.ekBilgi;
    }
    
    public void setEkBilgi(String ekBilgi) {
        this.ekBilgi = ekBilgi;
    }




}

