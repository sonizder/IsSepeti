/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.menu;

import javax.faces.bean.ManagedBean;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

/**
 *
 * @author s1r
 */
@ManagedBean(name="menuBean")
//@SessionScoped
public class MenuBean {

    private MenuModel model;

    public MenuBean() {
        model = new DefaultMenuModel();
//Menu-1  AnaSayfa         
        MenuItem item = new MenuItem();        
        item.setValue("AnaSayfa");
        item.setId("anasayfa");
        item.setIcon("ui-icon-home");
        item.setUrl("www.google.com");
        item.setStyle("margin-left: 150px;");
        model.addMenuItem(item);
        
//Menu-2 İlan Ver
        item = new MenuItem();
        item.setValue("İlan Ver");
        item.setId("ilanver");
        item.setIcon("ui-icon-script");
        item.setUrl("nn.xhtml");
        item.setStyle("padding-left: 25px;");
        model.addMenuItem(item);
        
//Menu-3 İlan Ara
        item = new MenuItem();
        item.setValue("İlan Ara");
        item.setId("ilanara");
        item.setIcon("ui-icon-circle-zoomin");
        item.setUrl("http://www.google.com");
        item.setStyle("padding-left: 25px;");
        model.addMenuItem(item);
        

//Menu-4 Oturum Aç
        item = new MenuItem();
        item.setValue("Oturum Aç");
        item.setId("oturumac");
        item.setIcon("ui-icon-close");
        item.setUrl("#");
        item.setStyle("position: absolute; right: 75px;");
        item.setOnclick("dlg.show()");
        
        model.addMenuItem(item);
        
//Menu-5 Kaydol
        item = new MenuItem();
        item.setValue("Kaydol");       
        item.setId("kaydol");       
        item.setIcon("ui-icon-close");
        item.setUrl("#");
        item.setStyle("position: absolute; right: 10px;");
        
        model.addMenuItem(item);     
    }

    public MenuModel getModel() {
        return model;
    }
}