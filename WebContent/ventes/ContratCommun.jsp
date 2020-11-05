<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<h:panelGrid styleClass="fichefournisseur" width="100%">
    <h:panelGrid  width="100%" columns="2" columnClasses="clos60g,clos40">
        <h:column>
            <h:panelGrid  width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                <h:column><h:outputText value="Date:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtDate}" readonly="true"/></h:column>
                <h:column><h:outputText value="N°:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtNum}" readonly="true"/></h:column>
                <h:column><h:outputText value="Série:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtSerie}" readonly="true"/></h:column>
            </h:panelGrid>
            <h:panelGrid width="100%" columns="2" columnClasses="clos12d,clos88">
                <h:column><h:outputText value="Client:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtNomTiers}" readonly="true"/></h:column>
            </h:panelGrid>
        </h:column>
        <h:column>
            <h:panelGrid  width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                <h:column><h:outputText value="H.T.:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtTotHt}" style="text-align:right;width:100%"  readonly="true" >
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="T.T.C.:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtTotTtc}" style="text-align:right;width:100%" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Contrat"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtType}" disabled="true" readonly="true">
                        <f:selectItem  itemLabel="Vente" itemValue="0"/>
                        <f:selectItem  itemLabel="Location" itemValue="1"/>
                        <f:selectItem  itemLabel="Maintenance" itemValue="20"/>
                        <f:selectItem  itemLabel="Assistance" itemValue="21"/>
                        <f:selectItem  itemLabel="Abonnement" itemValue="22"/>
                        <f:selectItem  itemLabel="Sauvegarde" itemValue="23"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Périodicité" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtType>=20}"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtPeriodicite}" disabled="true" readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.contratEnteteVentes.crtType>=20}">
                        <f:selectItem  itemLabel="Journalier" itemValue="0"  itemDisabled="true"/>
                        <f:selectItem  itemLabel="Hebdomadaire" itemValue="1" itemDisabled="true"/>
                        <f:selectItem  itemLabel="Mensuel" itemValue="2"/>
                        <f:selectItem  itemLabel="Trimestriel" itemValue="3"/>
                        <f:selectItem  itemLabel="Semestriel" itemValue="4"/>
                        <f:selectItem  itemLabel="Annuel" itemValue="5"/>
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>
        </h:column>
    </h:panelGrid>
</h:panelGrid>
