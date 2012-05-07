/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.hib.core;

import java.util.List;

/**
 *
 * @author s1r
 */
public abstract class HibCrudAbst<T> {
    public abstract void create(T domainObj);
    public abstract int delete(String sorgu);   
    public abstract List read(String sorgu);
}
