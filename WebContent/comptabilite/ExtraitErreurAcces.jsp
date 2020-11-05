<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="accesjournal" >

    <center> <h2><h:outputText value="ERREUR D'ACCES" style="color:green;"/></h2></center>

    <h:panelGrid width="100%" border="0">

        <h:panelGroup id="p1">

            <center>
                <br/><br/>
                <img src="images/lock.png" alt="work"/>
                <br/><br/><br/>
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.messageAlerte}" style="width:100%;text-align:center;font-size:20px"/>
                <br/><br/><br/><br/>
                <a4j:form>
                    <h:commandButton value="RETOUR EXTRAIT" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.fermerJournauxExtraitErreur}" styleClass="fermer" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </a4j:form>
            </center>

        </h:panelGroup>

    </h:panelGrid>

</f:subview>