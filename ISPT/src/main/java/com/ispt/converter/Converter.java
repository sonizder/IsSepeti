/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.converter;

import com.ispt.adverts.AdvertsSearch;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author s1r
 */
@FacesConverter("converter")
public class Converter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
        
        if(string.length()==0 || string.equals(""))
            return null;
        
        Map<String, String> mp=new AdvertsSearch().getSuburbs();      
        Object obj=mp.get(string);
        return obj;        
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object o) {
        if (null == o || 0 == o.toString().length()) {
            return null;
        }
        return o.toString();

    }
}
