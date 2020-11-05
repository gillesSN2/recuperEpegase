<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h:panelGrid styleClass="fichefournisseur" width="100%">
    <h:panelGrid  width="100%">
        <h:panelGrid  width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
            <h:column><h:outputText value="Date:"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valDate}" readonly="true"/></h:column>
            <h:column><h:outputText value="N°:"/></h:column>
            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valNum}" readonly="true"/></h:column>
            <h:column><h:outputText value="Série:"/></h:column>
            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valSerie}" readonly="true"/></h:column>
        </h:panelGrid>
        <h:panelGrid width="100%" columns="4" columnClasses="clos12d,clos21g,clos12d,clos55">
            <h:column><h:outputText value="N° Dossier:"/></h:column>
            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valDossierTransit}" readonly="true"/></h:column>
            <h:column><h:outputText value="Observation:"/></h:column>
            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.valorisationEnteteAchats.valObjet}" readonly="true"/></h:column>
        </h:panelGrid>
    </h:panelGrid>
</h:panelGrid>

<br>
