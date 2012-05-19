/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.gmap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author s1r
 */

public class GMapCoordinate {

    Map<String, String> coordinate;

    public GMapCoordinate() {
        coordinate = new HashMap<String, String>();
        coordinate.put("Istanbul", "41.00127741148071, 28.97850003277597");
        coordinate.put("Izmit", "40.76039051588437, 29.921264315002645");
        coordinate.put("Ankara", "39.91724103289237, 32.85736050640878");
        coordinate.put("Izmir", "38.41795572791511, 27.12919201885984");
    }

    public Map<String, String> getCoordinate() {
        return coordinate;
    }


}
