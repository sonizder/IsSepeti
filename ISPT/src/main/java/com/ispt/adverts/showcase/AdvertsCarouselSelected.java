/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.adverts.showcase;

import com.ispt.adverts.Adverts;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author s1r
 */
@ManagedBean
@SessionScoped
public class AdvertsCarouselSelected {
    
    private Adverts advertsSelected;
    

    public Adverts getAdvertsSelected() {
        return advertsSelected;
    }
    public void setAdvertsSelected(Adverts advertsSelected) {
        this.advertsSelected = advertsSelected;
    }    
    
}
