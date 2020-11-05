<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<h:panelGrid styleClass="fichefournisseur" width="100%">
    <h:panelGrid  width="100%" columns="2" columnClasses="clos60g,clos40">
        <h:panelGrid  width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
            <h:column><h:outputText value="Date:"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneEnteteVentes.camDate}" readonly="true"/></h:column>
            <h:column><h:outputText value="N°:"/></h:column>
            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneEnteteVentes.camNum}" readonly="true"/></h:column>
            <h:column><h:outputText value="Type:"/></h:column>
            <h:column>
                <h:selectOneMenu style="width:30%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneEnteteVentes.camType}" readonly="true" disabled="true">
                    <f:selectItem itemLabel="Sur site" itemValue="0"/>
                    <f:selectItem itemLabel="Par Mail" itemValue="1"/>
                    <f:selectItem itemLabel="Par SMS" itemValue="2"/>
                    <f:selectItem itemLabel="Mail+SMS" itemValue="3"/>
                </h:selectOneMenu>&nbsp;&nbsp;
                <h:outputText value="Série:"/>&nbsp;
                <h:inputText style="width:30%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneEnteteVentes.camSerie}" readonly="true"/>
            </h:column>
        </h:panelGrid>

    </h:panelGrid>
</h:panelGrid>

<br>
