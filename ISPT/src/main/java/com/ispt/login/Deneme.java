/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.login;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author s1r
 */
@ManagedBean(name="deneme")
public class Deneme {
    public String dd="hoşgeldiniz.";

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }
    
    
    
}
