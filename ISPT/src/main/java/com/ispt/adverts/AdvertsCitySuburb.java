/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.adverts;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author s1r
 */
public class AdvertsCitySuburb {
    
    private Map<String, String> cities = new HashMap<String, String>();
    private Map<String, Map<String, String>> suburbsData = new HashMap<String, Map<String, String>>();

    public AdvertsCitySuburb() {
        cities.put("Istanbul", "Istanbul");
        cities.put("Ankara", "Ankara");
        cities.put("Izmir", "Izmir");

        Map<String, String> suburbsIstanbul = new HashMap<String, String>();
        suburbsIstanbul.put("Kadikoy", "Kadikoy");
        suburbsIstanbul.put("Levent", "Levent");
        suburbsIstanbul.put("Cengelkoy", "Cengelkoy");

        Map<String, String> suburbsAnkara = new HashMap<String, String>();
        suburbsAnkara.put("Kecioren", "Kecioren");
        suburbsAnkara.put("Cankaya", "Cankaya");
        suburbsAnkara.put("Yenimahalle", "Yenimahalle");

        Map<String, String> suburbsIzmir = new HashMap<String, String>();
        suburbsIzmir.put("Cesme", "Cesme");
        suburbsIzmir.put("Gumuldur", "Gumuldur");
        suburbsIzmir.put("Foca", "Foca");

        suburbsData.put("Istanbul", suburbsIstanbul);
        suburbsData.put("Ankara", suburbsAnkara);
        suburbsData.put("Izmir", suburbsIzmir);
    }

    public Map<String, String> getCities() {
        return cities;
    }

    public void setCities(Map<String, String> cities) {
        this.cities = cities;
    }

    public Map<String, Map<String, String>> getSuburbsData() {
        return suburbsData;
    }

    public void setSuburbsData(Map<String, Map<String, String>> suburbsData) {
        this.suburbsData = suburbsData;
    }
    
    
}
