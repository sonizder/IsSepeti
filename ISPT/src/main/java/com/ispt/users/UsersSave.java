/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.users;



import com.ispt.hib.core.HibCrud;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

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
        
        boolean kayit=new HibCrud<Users>().create(newUsers); 
        
        String kayitMsg;
        if(kayit==true){
            kayitMsg="Kayıt İşlemi Başarılı";
        }else{
            kayitMsg="Kayıt İşlemi Başarısız!!!";
        }
        FacesMessage msg = new FacesMessage( "Hoşgeldiniz  "+newUsers.getIsim(),kayitMsg);
        FacesContext.getCurrentInstance().addMessage(null, msg);
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
    
    public boolean logIn( String mail,String sifre){
        System.out.println("mail"+ mail+" sifre "+ sifre);
        System.out.println("mail"+ mail+" sifre "+ sifre);

        List<Users> usersListesi = new ArrayList<Users>();
        usersListesi=(List<Users>)new HibCrud<Users>().read("from Users where mail = '"+mail+"' and sifre = '"+sifre+"'");
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("id", usersListesi.get(0).getIdUsers());
        
       if(usersListesi.size()>0){
           return true;
       }
       else{
           return false;
       }
        
    }
    
    //BU METHODU BURADAN KALDIR...Admin işlemi----------------------------------
    public List readUsers(String sorgu){
        
        List usersListesi = new ArrayList();
        usersListesi=new HibCrud<Users>().read(sorgu);
        
        return usersListesi;
//        for (int i = 0; i < usersListesi.size(); i++) {
//            Users theUsers=(Users) usersListesi.get(i);
//            System.out.println("************************************");
//            
//            System.out.println("adi: "+ theUsers.getIsim()+
//                    "  soyadi: "+ theUsers.getSoyisim());           
//            
//        }
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