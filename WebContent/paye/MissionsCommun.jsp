<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<h:panelGrid width="100%">
    <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%">
        <h:column><h:outputText style="text-decoration:underline;" value="Mode:"/></h:column>
        <h:column>
            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misMode}" disabled="true">
                <f:selectItem itemLabel="Local" itemValue="0"/>
                <f:selectItem itemLabel="Etranger" itemValue="1"/>
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText style="text-decoration:underline;" value="Nature:"/></h:column>
        <h:column>
            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misNature}" disabled="true">
                <f:selectItem itemLabel="Formations" itemValue="0"/>
                <f:selectItem itemLabel="Réunions" itemValue="1"/>
                <f:selectItem itemLabel="Séminaires" itemValue="2"/>
                <f:selectItem itemLabel="Terrains" itemValue="3"/>
                <f:selectItem itemLabel="Visites" itemValue="4"/>
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText value="N° Mission:"/></h:column>
        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misNum}" style="width:100%" disabled="true"/></h:column>
        <h:column><h:outputText value="Etat:"/></h:column>
        <h:column>
            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misEtat}" disabled="true">
                <f:selectItem itemLabel="En cours" itemValue="0"/>
                <f:selectItem itemLabel="Approuvé" itemValue="1"/>
                <f:selectItem itemLabel="En exécution" itemValue="2"/>
                <f:selectItem itemLabel="Retour" itemValue="3"/>
                <f:selectItem itemLabel="Cloture" itemValue="4"/>
                <f:selectItem itemLabel="Annulé" itemValue="5"/>
                <f:selectItem itemLabel="Gelé" itemValue="6"/>
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText value="Date Début (JJ/MM/AAAA):"/></h:column>
        <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misDateDebut}" popup="true" disabled="true"/></h:column>
        <h:column><h:outputText value="Date de fin (JJ/MM/AAAA):"/></h:column>
        <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misDateFin}" popup="true" disabled="true"/></h:column>
        <h:column><h:outputText value="Nb jour(s) théorique(s):"/></h:column>
        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misNbJourTheo}" style="text-align:right;" disabled="true" readonly="true"/></h:column>
        <h:column><h:outputText value="Pays:"/></h:column>
        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misPays}" disabled="true"/></h:column>
        </h:panelGrid>
</h:panelGrid>
