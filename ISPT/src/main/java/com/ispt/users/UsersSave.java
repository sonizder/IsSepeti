/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.users;



import com.ispt.hib.core.HibCrud;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author s1r
 */
@ManagedBean(name="usersSave")

public class UsersSave implements Serializable{
    
    
    private Users newUsers;

    public UsersSave() {
        newUsers=new Users();
    }

    
    
    public Users getNewUsers() {
        return newUsers;
    }
    public void setNewUsers(Users newUsers) {
        this.newUsers = newUsers;
    }
    
    
    
   
    
    public void save(){
        new HibCrud<Users>().create(newUsers);     
        readUsers();
        delete();
        new HibCrud<Object>().update(22);

        
        
    }
    public void delete(){
        int id=14;
        String tName="Users";
        String param1="idUsers";
        int result=new HibCrud<String>().delete("delete "+tName+" where "+param1+" = '"+id+"'");
        
        if (result == 0) {
            System.out.println("silinecek birşey yok");
        } else {
            System.out.println("silme başarılı.");
        }
    }
    
    public boolean logIn(String isim, String mail){
        
        List usersListesi = new ArrayList();
        usersListesi=new HibCrud<Users>().read("from Users where Isim = '"+isim+"' and Mail = '"+mail+"'");
        
       if(usersListesi.size()>0){
           return true;
       }
       else{
           return false;
       }
        
    }
    
    //BU METHODU BURADAN KALDIR...Admin işlemi----------------------------------
    public void readUsers(){
        
        List usersListesi = new ArrayList();
        usersListesi=new HibCrud<Users>().read("from Users");
        
        for (int i = 0; i < usersListesi.size(); i++) {
            Users theUsers=(Users) usersListesi.get(i);
            System.out.println("************************************");
            
            System.out.println("adi: "+ theUsers.getIsim()+
                    "  soyadi: "+ theUsers.getSoyisim());           
            
        }
    }
    //--------------------------------------------------------------------------

    
}
/*
 * catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return uzytLog;
 */