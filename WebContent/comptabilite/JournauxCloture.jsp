<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview  id="cc">

    <center> <h2><h:outputText value="CLOTURE MENSUELLE DES JOURNAUX COMPTABLES" styleClass="titre"/></h2></center>

    <a4j:form style="width:100%" id="form">
        <br><br>
        <h:panelGroup>
            <center>
                <h:panelGrid width="350px">
                    <h:panelGrid columns="2" columnClasses="clos30,clos70d" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Date de début:"/></h:column>
                        <h:column>
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.selectedExo.execptDateDebut}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="true"></rich:calendar>
                        </h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Période de fin:"/></h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.periode}" style="width:160px;" >
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.lesPeriodes}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                </h:panelGrid>
            </center>
        </h:panelGroup>
        <br><br><br>
        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
            <center>
                <h:commandButton style="width:300px" value="CLOTURER LA PERIODE SELECTIONNEE" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.cloturerPeriode}" onclick="if (!confirm('Etes-vous sur de vouloir effectuer la clôture mensuelle des journaux comptables de la période sélectionnée ?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
            </center>
        </h:panelGroup>
        <br><br><br>
    </a4j:form>

</f:subview>
