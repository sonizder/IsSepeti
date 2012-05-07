/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.login;

import java.io.Serializable;
import java.util.Enumeration;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.servlet.http.HttpSession;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;





/**
 *
 * @author s1r
 */

class FooActionListener implements ActionListener {
public String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public FooActionListener() {
        processAction(null);
           System.out.println("HELLO  WORLDDD");
            System.out.println("HELLO  WORLDDD");
            System.out.println("HELLO  WORLDDD");

    }

        @Override
        public void processAction(ActionEvent event)
                throws AbortProcessingException {
//            String url;
            System.out.println("HELLO  WORLDDD");
            System.out.println("HELLO  WORLDDD");
            System.out.println("HELLO  WORLDDD");
            System.out.println("HELLO  WORLDDD");
            System.out.println("HELLO  WORLDDD");
            System.out.println("HELLO  WORLDDD");
            System.out.println("HELLO  WORLDDD");
            System.out.println("HELLO  WORLDDD");
//            url=new GirisKontrol().doLogout();

        }
    }


@ManagedBean(name = "uyeMenuModelBean")
@SessionScoped
public class UyeMenuModelBean implements Serializable{
private static final long serialVersionUID = -8556751897482662530L;
    private MenuModel model;
    String url="";

    public UyeMenuModelBean() {

        model = new DefaultMenuModel();

        MenuItem item = new MenuItem();
        item = new MenuItem();
        item.setValue("Çıkış");
        item.setId("cikis");
        item.setIcon("ui-icon-close");
        item.setAjax(false);
//        ExpressionFactory factory = FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
//        MethodExpression methodExpression = factory.createMethodExpression(FacesContext.getCurrentInstance().getELContext(), "#{menuBean.toggleCutState}", String.class, new Class[]{});
//        item.setActionExpression(methodExpression);
        item.addActionListener(new FooActionListener());
        url=new FooActionListener().getUrl();
        item.setUrl(url);
        item.setStyle("position: absolute; right: 10px;");

        model.addMenuItem(item);

//Menu-6 Hesabım
        Submenu submenu = new Submenu();
        submenu.setLabel("Hesabım");
        submenu.setStyleClass("hesabim");
        submenu.setIcon("ui-icon-gear");
        submenu.setStyle("position: absolute; right: 65px;");

        item = new MenuItem();
        item.setValue("Ayar 1");
        item.setUrl("#");
        item.setAjax(false);
        submenu.getChildren().add(item);

        item = new MenuItem();
        item.setValue("Ayar 2");
        item.setUrl("#");
        item.setAjax(false);
        submenu.getChildren().add(item);

        model.addSubmenu(submenu);

//Menu-7 Çıkış


    }

    

    public MenuModel getModel() {
        return model;
    }


}
