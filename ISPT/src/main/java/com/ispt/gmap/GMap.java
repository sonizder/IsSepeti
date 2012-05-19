/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.gmap;

import com.ispt.adverts.showcase.AdvertsCarouselSelected;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.Marker;

/**
 *
 * @author s1r
 */
@ManagedBean
public class GMap implements Serializable {

    DefaultMapModel simpleModel;
    String coordinate;
    
    @ManagedProperty(value = "#{advertsCarouselSelected}")
    private AdvertsCarouselSelected adCSelected;

    public AdvertsCarouselSelected getAdCSelected() {
        return adCSelected;
    }
    public void setAdCSelected(AdvertsCarouselSelected adCSelected) {
        this.adCSelected = adCSelected;
    }
    public String getCoordinate() {
        return coordinate;
    }
    public void setCoordinate(String cordinate) {
        this.coordinate = cordinate;
    }


//    public GMap() {
//        simpleModel = new DefaultMapModel();
//
//    }

    public DefaultMapModel getSimpleModel() {
        return simpleModel;
    }

    @PostConstruct
    public void advertMark() {
        simpleModel = new DefaultMapModel();
        Map<String, String> coordinate=new GMapCoordinate().getCoordinate();
        this.coordinate = coordinate.get(adCSelected.getAdvertsSelected().getSehir());
        
        String[] coordnt=this.coordinate.split(",");
        
        LatLng coord1 = new LatLng(Double.parseDouble(coordnt[0]),Double.parseDouble(coordnt[1]));

        simpleModel.addOverlay(new Marker(coord1, "Istanbul"));

    }
}
