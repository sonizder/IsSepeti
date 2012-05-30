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
public class StartUpListener implements ServletContextListener, Serializable {


    public static List<Adverts> adVitrinL;    
    public static List<Adverts> advertsList;



    public List<Adverts> getAdvertsList() {
        return advertsList;
    }

    public static void setAdvertsList(List<Adverts> advertsList) {
        StartUpListener.advertsList = advertsList;
    }

    public  List<Adverts> getAdVitrinL() {
        return adVitrinL;
    }

    public static void setAdVitrinL(List<Adverts> adVitrinL) {
        StartUpListener.adVitrinL = adVitrinL;
    }
    

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        
        adVitrinL = new ArrayList<Adverts>();
        adVitrinL = (List<Adverts>) new HibCrud<Adverts>().read("from Adverts where anaVitrin='false'");


        advertsList = new ArrayList<Adverts>();
        advertsList = (List<Adverts>) new HibCrud<Adverts>().read("from Adverts");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
