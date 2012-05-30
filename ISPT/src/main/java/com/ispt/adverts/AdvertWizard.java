/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.adverts;

import com.ispt.citys.CitysAndSuburbs;
import com.ispt.hib.core.HibCrud;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author s1r
 */
@ManagedBean(name = "advertWizard")
@ViewScoped
public class AdvertWizard implements Serializable {

    public static final long serialVersionUID = 1L;
    private boolean skip;
    private Adverts advert = new Adverts();
    private Map<String, Map<String, String>> suburbsData = new HashMap<String, Map<String, String>>();
    private static Map<String, String> suburbsss = new HashMap<String, String>();
    private static Logger logger = Logger.getLogger(AdvertWizard.class.getName());
    private int wizardStep = 1;

    public int getWizardStep() {
        return wizardStep;
    }

    public void setWizardStep(int wizardStep) {
        this.wizardStep = wizardStep;
    }

    public Adverts getAdvert() {
        return advert;
    }

    public void setAdvert(Adverts advert) {
        this.advert = advert;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public  Map<String, String> getSuburbsss() {
        return suburbsss;
    }

    public void setSuburbsss(Map<String, String> suburbsss) {
        AdvertWizard.suburbsss = suburbsss;
    }

    public Map<String, Map<String, String>> getSuburbsData() {
        return suburbsData;
    }

    public void setSuburbsData(Map<String, Map<String, String>> suburbsData) {
        this.suburbsData = suburbsData;
    }

    public AdvertWizard() {
        suburbsData = new CitysAndSuburbs().getSuburbsData();
    }

    public void save(ActionEvent actionEvent) {

        advert.setUsers(new AdvertsSave().save());


        boolean kayit = new HibCrud<Adverts>().create(advert);
        String kayitMsg;
        if (kayit == true) {
            kayitMsg = "Başarıyla Alınmıştır.";
        } else {
            kayitMsg = "Alınamamıştır Lütfen Girdilerini Kontrol edin!!!";
        }

        FacesMessage msg = new FacesMessage(advert.getIsAlani(), ", İş İhale İlanınız " + kayitMsg);
        FacesContext.getCurrentInstance().addMessage(null, msg);


    }
    
    public void valueChangeMethod(){
        System.out.println("girdi");
        System.out.println("girdi");
        System.out.println("girdi");
        
        System.out.println("il: "+advert.getIl());
String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("il");
        System.out.println("id: "+id);
        System.out.println("id: "+id);
        System.out.println("id: "+id);
        System.out.println("id: "+id);
        System.out.println("id: "+id);
   
	}

    public void handleCityChange() {
        if (advert.getSehir() != null && !advert.getSehir().equals("")) {
            suburbsss = suburbsData.get(advert.getSehir());
        } else {
            suburbsss = new HashMap<String, String>();
        }
    }

    public String onFlowProcess(FlowEvent event) {
        logger.info("Şimdiki Adım:" + event.getOldStep());
        logger.info("Bir Sonraki Adım:" + event.getNewStep());
        if (event.getNewStep().equals("personal")) {
            wizardStep = 1;
            System.out.println("wizardstep persosnal "+wizardStep);
        } else if (event.getNewStep().equals("address")) {
            wizardStep = 2;
            System.out.println("wizardstep adres "+wizardStep);
        }



        if (skip) {
            skip = false;
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }
}
