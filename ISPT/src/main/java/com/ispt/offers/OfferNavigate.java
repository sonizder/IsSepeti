/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.offers;

import com.ispt.login.LoginControll;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author s1r
 */
@ManagedBean
public class OfferNavigate {

    @ManagedProperty("#{param.foo}")
    private String foo;
    private static String leftside;
    private static String rightside;
    private static boolean gmaprender;
    

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public String getLeftside() {
        return leftside;
    }

    public void setLeftside(String leftside) {
        this.leftside = leftside;
    }

    public String getRightside() {
        return rightside;
    }

    public void setRightside(String rightside) {
        this.rightside = rightside;
    }

    public boolean isGmaprender() {
        return gmaprender;
    }

    public void setGmaprender(boolean gmaprender) {
        this.gmaprender = gmaprender;
    }
    
    

    public String navigate() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession httpses = (HttpSession) fc.getExternalContext().getSession(false);
        LoginControll nesnesi = (LoginControll) httpses.getAttribute("loginControll");
        RequestContext context = RequestContext.getCurrentInstance();

        FacesMessage msg = null;
        String directPage;


        boolean loggedIn = false;
        if (nesnesi.getMail() != null) {

            if (foo.equals("carousel")) {
                leftside = "teklifAdvDetail.xhtml";
                rightside="advertsCarousel.xhtml";
                gmaprender=true;
            } else if (foo.equals("advSearchList")) {
                leftside = "advSearchList.xhtml";
                rightside="teklifAdvDetail.xhtml";
                gmaprender=false;
            }

            loggedIn = true;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", " ");
            directPage = "teklif?faces-redirect=true";

        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Lütfen Oturum açın!", " Yada Kayıt Olun!");
            directPage = "#";
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);
        return directPage;
    }
}
