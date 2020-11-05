<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="listereorg">

    <a4j:form id="impgen">

        <center> <h2><h:outputText value="REORGANISATION DES BASES DE DONNEES" style="color:green;font-size:16px;"/></h2></center>

        <h:panelGrid id="impgenPG" border="0" width="100%" style="border:0px solid green;">

            <rich:column id="soc" width="100%" style="border:1px solid green;">

                <h:panelGrid id="pansoc" columns="7" width="100%">
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formInfoSysteme.etat}" style="width:130px;" >
                        <f:selectItem itemLabel="Tous Etats" itemValue="9"/>
                        <f:selectItem itemLabel="Non actif" itemValue="0"/>
                        <f:selectItem itemLabel="Actif" itemValue="1"/>
                        <f:selectItem itemLabel="Bloqué" itemValue="2"/>
                        <f:selectItem itemLabel="Cloturé" itemValue="3"/>
                    </h:selectOneMenu>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formInfoSysteme.mode}" style="width:130px;" >
                        <f:selectItem itemLabel="Tous Modes" itemValue="9"/>
                        <f:selectItem itemLabel="Full internet" itemValue="0"/>
                        <f:selectItem itemLabel="Full intranet" itemValue="1"/>
                        <f:selectItem itemLabel="Mixte" itemValue="2"/>
                        <f:selectItem itemLabel="Spécial" itemValue="3"/>
                    </h:selectOneMenu>
                    <h:selectOneMenu style="width:210;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formInfoSysteme.pays}">
                        <f:selectItem itemLabel="Tous pays" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.mesPaysItem}" />
                    </h:selectOneMenu>
                    <h:commandButton value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formInfoSysteme.chargerLesSocietes}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    <a4j:commandButton value="Tout Sélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formInfoSysteme.toutSelectionner}" reRender="tablesoc"/>
                    <a4j:commandButton value="Rien Sélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formInfoSysteme.rienSelectionner}" reRender="tablesoc"/>
                    <a4j:commandButton image="/images/executer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formInfoSysteme.reorganisationBases}" onclick="if (!confirm('Etes-vous sur de vouloir exécuter la reorganisation de(s) base(s) sélectionnée(s) ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');" oncomplete="javascript:Richfaces.hideModalPanel('panelBarProg');" reRender="panelBarProg,tablesoc"/>
                </h:panelGrid>

                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tablesoc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formInfoSysteme.dataModelBases}" headerClass="headerTab" activeClass="active-row" noDataLabel=" " width="100%" styleClass="bg" style="max-height:100%" border="0" rowClasses="rows1,rows2,rowsd" var="societe">
                        <rich:column width="5%" sortable="true" sortBy="#{societe.selectStructure}">
                            <f:facet name="header" ><h:outputText value="Sel."/></f:facet>
                            <h:selectBooleanCheckbox value="#{societe.selectStructure}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="true" sortBy="#{societe.strId}">
                            <f:facet name="header" ><h:outputText value="ID"/></f:facet>
                            <h:outputText  value="#{societe.strId}"  />
                        </rich:column >
                        <rich:column width="10%" sortable="true" sortBy="#{societe.strdtecreat}">
                            <f:facet name="header" ><h:outputText value="Création"/></f:facet>
                            <h:outputText  value="#{societe.strdtecreat}" >
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column >
                        <rich:column width="5%" sortable="true" sortBy="#{societe.libetat}">
                            <f:facet name="header" ><h:outputText value="Etat"/></f:facet>
                            <h:outputText  value="#{societe.libetat}" />
                        </rich:column >
                        <rich:column width="10%" sortable="true" sortBy="#{societe.libmode}">
                            <f:facet name="header" ><h:outputText value="Mode"/></f:facet>
                            <h:outputText  value="#{societe.libmode}"  />
                        </rich:column >
                        <rich:column width="40%" sortable="true" sortBy="#{societe.strraisonsociale}">
                            <f:facet name="header" ><h:outputText value="Raison sociale"/></f:facet>
                            <h:outputText  value="#{societe.strraisonsociale}" />
                        </rich:column >
                        <rich:column width="10%" sortable="true" sortBy="#{societe.strnompays}" >
                            <f:facet name="header" ><h:outputText value="Pays"/></f:facet>
                            <h:outputText  value="#{societe.strnompays}"  />
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:column>

        </h:panelGrid>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelBarProg" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="700" height="80" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formInfoSysteme.var_showBarProg}">
        <f:facet name="header"><h:outputText value="Reorganisation des bases en cours..."/></f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel id="progressPanel">
                    <rich:progressBar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formInfoSysteme.var_currentValue}" style="width:90%" interval="300" enabled="true" minValue="-1" maxValue="100" id="barprg" mode="ajax" ajaxSingle="true" eventsQueue="maQueueProgress" limitToList="true" reRenderAfterComplete="panelBarProg,progressPanel">
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formInfoSysteme.var_info} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formInfoSysteme.var_currentValue} %)"/>
                    </rich:progressBar>
                </a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>

</f:subview>
