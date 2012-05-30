/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.adverts;

import com.ispt.adverts.showcase.StartUpListener;
import com.ispt.citys.CitysAndSuburbs;
import com.ispt.hib.core.HibCrud;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author s1r
 */
@ManagedBean
public class AdvertsSearch implements Serializable{

    private String city;
    private String suburb;
    private String sector;

    private Map<String, Map<String, String>> suburbsData = new HashMap<String, Map<String, String>>();
    private static Map<String, String> suburbs = new HashMap<String, String>();
    
    private List<Adverts> adSearchL;

    public AdvertsSearch() {
        adSearchL = new ArrayList<Adverts>();
        suburbsData=new CitysAndSuburbs().getSuburbsData();
    }

    public String getSector() {
        return sector;
    }
    public void setSector(String sector) {
        this.sector = sector;
    }
    public List<Adverts> getAdSearchL() {
        return adSearchL;
    }
    public void setAdSearchL(List<Adverts> adSearchL) {
        this.adSearchL = adSearchL;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getSuburb() {
        return suburb;
    }
    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }
    public Map<String, String> getSuburbs() {
        return suburbs;
    }
    public void setSuburbs(Map<String, String> suburbs) {
        this.suburbs = suburbs;
    }
    public Map<String, Map<String, String>> getSuburbsData() {
        return suburbsData;
    }
    public void setSuburbsData(Map<String, Map<String, String>> suburbsData) {
        this.suburbsData = suburbsData;
    }

    public void handleCityChange() {

        if (city != null && !city.equals("")) 
            suburbs = suburbsData.get(city);
        else 
            suburbs = new HashMap<String, String>();        
    }
//from Adverts where sehir='Ankara' and Il='ayrancı' and IsAlani='Boya-Badana'
    public void search() {
        System.out.println("city: " + city+  "   suburb" + suburb);
        String sorgu ="";
        if(!city.equals("")|| city.length()!=0){
            sorgu+="from Adverts where sehir='" + city + "'";
            if(!suburb.equals("") || suburb.length()!=0)
                sorgu+=" and Il='" + suburb + "'";
            if(!sector.equals("") || sector.length()!=0)
                sorgu+=" and IsAlani = '"+sector+"'";
        }else if(!sector.equals("")||sector.length()!=0)
            sorgu+="from Adverts where IsAlani ='"+sector+"'";
        else
            sorgu+="from Adverts";

        adSearchL = (List<Adverts>) new HibCrud<Adverts>().read(sorgu);
        StartUpListener.setAdvertsList(adSearchL);

    }

}
