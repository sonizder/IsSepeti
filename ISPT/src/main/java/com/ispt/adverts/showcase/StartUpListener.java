/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.adverts.showcase;

import com.ispt.adverts.Adverts;
import com.ispt.hib.core.HibCrud;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author s1r
 */
@ManagedBean
public class StartUpListener implements ServletContextListener, Serializable{
    
public  static List<Adverts> adVtL ;
//private Adverts advertsSelected;

//    public Adverts getAdvertsSelected() {
//        return advertsSelected;
//    }
//
//    public void setAdvertsSelected(Adverts advertsSelected) {
//        this.advertsSelected = advertsSelected;
//    }

    public List<Adverts> getAdVtL() {
        return adVtL;
    }

    

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        adVtL= new ArrayList<Adverts>();
        List<Adverts> adVtListesi= new ArrayList<Adverts>();
        adVtListesi =(List<Adverts>) new HibCrud<Adverts>().read("from Adverts where anaVitrin='false'");
    
            for (int j = 0; j < adVtListesi.size(); j++) {
                adVtL.add(adVtListesi.get(j));
                adVtL.add(adVtListesi.get(j));
                adVtL.add(adVtListesi.get(j));
                adVtL.add(adVtListesi.get(j));
            }
     
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
    
}
