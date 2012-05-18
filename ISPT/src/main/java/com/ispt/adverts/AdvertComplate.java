/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.adverts;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author s1r
 */
@ManagedBean(name="advertComplate")
public class AdvertComplate {

    private List<String> islerList;
    private List<String> malzemeList;
    private List<String> sehirlerList;

    public List<String> getIslerList() {
        return islerList;
    }

    public void setIslerList(List<String> islerList) {
        this.islerList = islerList;
    }

    public List<String> getMalzemeList() {
        return malzemeList;
    }

    public void setMalzemeList(List<String> malzemeList) {
        this.malzemeList = malzemeList;
    }

    public List<String> getSehirlerList() {
        return sehirlerList;
    }

    public void setSehirlerList(List<String> sehirlerList) {
        this.sehirlerList = sehirlerList;
    }

    public List<String> complete(String query) {
        islerList = new ArrayList<String>();
        islerList.add("Boya-Badana");
        islerList.add("Parke");
        islerList.add("Laminent");
        islerList.add("Nakliye");
        islerList.add("Temizlik");
        return islerList;
    }

    public List<String> malzemeComplete(String query) {
        malzemeList = new ArrayList<String>();
        malzemeList.add("Evet");
        malzemeList.add("Hayır");
        return malzemeList;
    }

    public List<String> sehirComplate(String query) {
        sehirlerList = new ArrayList<String>();
        sehirlerList.add("Istanbul");
        sehirlerList.add("Ankara");
        sehirlerList.add("Izmir");
        sehirlerList.add("Samsun");
        sehirlerList.add("Izmit");
        sehirlerList.add("Bursa");
        sehirlerList.add("Sakarya");
        sehirlerList.add("Balıkesir");
        sehirlerList.add("Bolu");
        sehirlerList.add("Çanakkale");
        sehirlerList.add("Edirne");
        return sehirlerList;
    }
}
