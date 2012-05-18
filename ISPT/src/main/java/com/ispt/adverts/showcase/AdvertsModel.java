/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.adverts.showcase;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author s1r
 */
@ManagedBean
public class AdvertsModel implements Serializable{
    private String isAlani;
    private String sehir;
    private String butce;

    public AdvertsModel(String isAlani, String sehir, String butce) {
        this.isAlani = isAlani;
        this.sehir = sehir;
        this.butce = butce;
    }

    public String getButce() {
        return butce;
    }

    public void setButce(String butce) {
        this.butce = butce;
    }

    public String getIsAlani() {
        return isAlani;
    }

    public void setIsAlani(String isAlani) {
        this.isAlani = isAlani;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }
    
    
}
