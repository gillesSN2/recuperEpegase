<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="listsocgrp">

    <center><h2><h:outputText value="LISTE DES SOCIETES DU GROUPE #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strraisonsociale}" styleClass="titre"/></h2></center>

    <a4j:form>

        <h:panelGrid width="100%">

            <h:panelGrid id="btnSoc" width="100px" columns="2">
                <a4j:commandButton image="/images/modifier.png" title="Modifier une structure" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.modifierStructure}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.showButtonModif}" reRender="panelStructure"/>
                <a4j:commandButton image="/images/print.png" title="Imprimer" oncomplete="javascript:Richfaces.showModalPanel('panelImp');" rendered="false"/>
            </h:panelGrid>

            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="tableSoc" footerClass="bard" headerClass="headerTab" styleClass="bg" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " border="0" width="100%" style="max-height:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.dataModelSociete}" var="soc">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.selectionStructure}" reRender="btnSoc"/>
                    <f:facet name="header"></f:facet>
                    <rich:column label="ID Structure" sortable="true" sortBy="#{soc.strId}" width="5%">
                        <f:facet name="header"><h:outputText value="ID STR"/></f:facet>
                        <h:outputText value="#{soc.strId}"/>
                    </rich:column>
                    <rich:column label="Sigle" sortable="true" sortBy="#{soc.strsigle}" width="20%">
                        <f:facet name="header"><h:outputText value="Sigle"/></f:facet>
                        <h:outputText value="#{soc.strsigle}"/>
                    </rich:column>
                    <rich:column label="Raison sociale ou Nom" sortable="true" sortBy="#{soc.strraisonsociale}" width="35%">
                        <f:facet name="header"><h:outputText value="Raison sociale"/></f:facet>
                        <h:outputText value="#{soc.strraisonsociale}"/>
                    </rich:column>
                    <rich:column label="Pays" sortable="true" sortBy="#{soc.strnompays}" width="20%">
                        <f:facet name="header"><h:outputText value="Pays"/></f:facet>
                        <h:outputText value="#{soc.strnompays}"/>
                    </rich:column>
                    <rich:column label="Devise" sortable="true" sortBy="#{soc.strdevise}" width="10%">
                        <f:facet name="header"><h:outputText value="Devise"/></f:facet>
                        <h:outputText value="#{soc.strdevise}"/>
                    </rich:column>
                    <rich:column label="Compte" sortable="true" sortBy="#{soc.strrepertoire}" width="10%">
                        <f:facet name="header"><h:outputText value="Compte"/></f:facet>
                        <h:outputText value="#{soc.strrepertoire}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </h:panelGrid>
        <br>
        <center>
            <h:panelGroup>
                <a4j:commandButton value="Mise à jour des structures du groupe" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:250px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.majStructure}" onclick="if (!confirm('Etes-vous sur de vouloir mettre à jour les structures du groupe ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente}"/>
            </h:panelGroup>
        </center>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelStructure" width="500" height="200" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.showModalPanelStructure}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.showModalPanelStructure}" var="clr">
            <f:facet name="header"><h:outputText value="GESTION DES COMPTES STRUCTURES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.annulerStructure}" image="/images/close.gif" styleClass="hidelink" reRender="panelStructure"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid width="100%" id="panGlobal">
                    <h:panelGrid columns="2" columnClasses="clos50,clos50" width="100%">
                        <h:column><h:outputText value="Numéro Compte:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.structurePeg.strrepertoire}" onkeypress="return scanToucheLettre(event)" size="10" maxlength="20" style="text-transform:uppercase"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br><br>
                <center>
                    <h:panelGroup id="buttGrp">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.validerStructure}" style="margin-top:5px;" reRender="panelStructure,tableSoc"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
