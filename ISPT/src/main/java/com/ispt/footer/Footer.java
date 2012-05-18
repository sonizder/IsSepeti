/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.footer;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author s1r
 */
@ManagedBean
public class Footer {
    
    private String footertext= "IsSepeti.com © Copyright 2012";

    public String getFootertext() {
        return footertext;
    }
    
    
}

/*
 * 
 * 
 * private String firstname;
    private String lastname;
    private int age;
    private boolean skip;
    private String street;
    private String postalCode; 
    private String city;
    private String email;
    private String phone;
    private String info;
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * 
    * public class AdvertWizard {
    
    
    private boolean skip;  
      
    public User user = new User();
 
    
    private static Logger logger = Logger.getLogger(AdvertWizard.class.getName());  
  
    public User getUser() {  
        return user;  
    }  
  
    public void setUser(User user) {  
        this.user = user;  
    }  
      
    public void save(ActionEvent actionEvent) {  
        //Persist user  
          
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + user.getFirstname());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
      
    public boolean isSkip() {  
        return skip;  
    }  
  
    public void setSkip(boolean skip) {  
        this.skip = skip;  
    }  
      
    public String onFlowProcess(FlowEvent event) {  
        logger.info("Current wizard step:" + event.getOldStep());  
        logger.info("Next step:" + event.getNewStep());  
          
        if(skip) {  
            skip = false;   //reset in case user goes back  
            return "confirm";  
        }  
        else {  
            return event.getNewStep();  
        }  
    }  
}
* 
* 
* 
* 
* 
* 
* 
* 
* 
* 
* 
* 
* 
* 
* 
* 
* 
* 
* 
* 
* 
* 
* <?xml version="1.0" encoding="UTF-8"?>
<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:p="http://primefaces.org/ui"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core">

    <h:head>
        <title>TODO supply a title</title>
        <link type="text/css" rel="stylesheet" href="resource/css/componentsize.css"></link>
        <style type="text/css"> 
        </style>
    </h:head>

    <h:body>

        <h:form>

            <p:growl id="growl" sticky="true" showDetail="true"/>

            <p:wizard widgetVar="wiz"
                      flowListener="#{advertWizard.onFlowProcess}">

                <p:tab id="personal" title="Personal">

                    <p:panel header="Personal Details">

                        <h:messages errorClass="error"/>

                        <h:panelGrid columns="2" columnClasses="label, value" styleClass="grid">
                            <h:outputText value="Firstname: *" />
                            <p:inputText required="true" label="Firstname"
                                         value="#{advertWizard.user.firstname}" />

                            <h:outputText value="Lastname: *" />
                            <p:inputText required="true" label="Lastname"
                                         value="#{advertWizard.user.lastname}" />

                            <h:outputText value="Age: " />
                            <p:inputText value="#{advertWizard.user.age}" />

                            <h:outputText value="Skip to last: " />
                            <h:selectBooleanCheckbox value="#{advertWizard.skip}" />
                        </h:panelGrid>
                    </p:panel>
                </p:tab>

                <p:tab id="address" title="Address">
                    <p:panel header="Adress Details">

                        <h:messages errorClass="error"/>

                        <h:panelGrid columns="2" columnClasses="label, value">
                            <h:outputText value="Street: " />
                            <p:inputText value="#{advertWizard.user.street}" />

                            <h:outputText value="Postal Code: " />
                            <p:inputText value="#{advertWizard.user.postalCode}" />

                            <h:outputText value="City: " />
                            <p:inputText value="#{advertWizard.user.city}" />

                            <h:outputText value="Skip to last: " />
                            <h:selectBooleanCheckbox value="#{advertWizard.skip}" />
                        </h:panelGrid>
                    </p:panel>
                </p:tab>

                <p:tab id="contact" title="Contact">
                    <p:panel header="Contact Information">

                        <h:messages errorClass="error"/>

                        <h:panelGrid columns="2" columnClasses="label, value">
                            <h:outputText value="Email: *" />
                            <p:inputText required="true" label="Email"
                                         value="#{advertWizard.user.email}" />

                            <h:outputText value="Phone: " />
                            <p:inputText value="#{advertWizard.user.phone}"/>

                            <h:outputText value="Additional Info: " />
                            <p:inputText value="#{advertWizard.user.info}"/>
                        </h:panelGrid>
                    </p:panel>
                </p:tab>

                <p:tab id="confirm" title="Confirmation">
                    <p:panel header="Confirmation">

                        <h:panelGrid id="confirmation" columns="6">
                            <h:outputText value="Firstname: " />
                            <h:outputText styleClass="outputLabel"
                                          value="#{advertWizard.user.firstname}" />

                            <h:outputText value="Lastname: " />
                            <h:outputText  styleClass="outputLabel"
                                           value="#{advertWizard.user.lastname}"/>

                            <h:outputText value="Age: " />
                            <h:outputText styleClass="outputLabel"
                                          value="#{advertWizard.user.age}" />>

                            <h:outputText value="Street: " />
                            <h:outputText styleClass="outputLabel"
                                          value="#{advertWizard.user.street}" />

                            <h:outputText value="Postal Code: " />
                            <h:outputText styleClass="outputLabel"
                                          value="#{advertWizard.user.postalCode}" />

                            <h:outputText value="City: " />
                            <h:outputText styleClass="outputLabel"
                                          value="#{advertWizard.user.city}" />

                            <h:outputText value="Email: " />
                            <h:outputText styleClass="outputLabel"
                                          value="#{advertWizard.user.email}" />

                            <h:outputText value="Phone " />
                            <h:outputText styleClass="outputLabel"
                                          value="#{advertWizard.user.phone}"/>

                            <h:outputText value="Info: " />
                            <h:outputText styleClass="outputLabel"
                                          value="#{advertWizard.user.info}" />

                            <h:outputText />
                            <h:outputText />
                        </h:panelGrid>

                        <p:commandButton value="Submit" update="growl" 
                                         actionListener="#{advertWizard.save}"/>

                    </p:panel>
                </p:tab>

            </p:wizard>

        </h:form>


    </h:body>
</html>



















 */