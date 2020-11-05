<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelListeEleves">

    <a4j:form id="formModalListeEleves">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="SELECTION DE L'ELEVE"/></f:facet>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableTiers"/>
                <rich:extendedDataTable rows="200" id="tableTiers" footerClass="bard" headerClass="headerTab" styleClass="bg" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.datamodelEleves}" var="tiers" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.simpleSelection}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.extDTable}">
                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionligneEleves}" reRender="idVal"/>
                    <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.recuperationEleves}" reRender="idSubView,idEleves"/>
                    <rich:column label="N° Compte" sortable="true" sortBy="#{tiers.tiecompte0}" width="10%">
                        <f:facet name="header"><h:outputText  value="N° dossier" /></f:facet>
                        <h:outputText value="#{tiers.eleDossier}" style="#{tiers.styleCouleur}"/>
                    </rich:column>
                    <rich:column label="Nom et Prénom" sortable="true" sortBy="#{tiers.eleNom}" width="40%" filterBy="#{tiers.eleNom}">
                        <f:facet name="header"><h:outputText  value="Nom et Prénom" /></f:facet>
                        <h:outputText value="#{tiers.eleNom}" style="#{tiers.styleCouleur}"/>
                    </rich:column>
                    <rich:column label="Prénom" sortable="true" sortBy="#{tiers.elePrenom}" width="20%">
                        <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                        <h:outputText value="#{tiers.elePrenom}" style="#{tiers.styleCouleur}"/>
                    </rich:column>
                    <rich:column label="Civilité" sortable="true" sortBy="#{tiers.eleCivilite}" width="10%">
                        <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                        <h:outputText value="#{tiers.eleCivilite}" style="#{tiers.styleCouleur}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br>
            <h:panelGroup id="idVal">
                <center>
                    <a4j:commandButton id="idCanTiers0" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.annuleEleves}" reRender="idSubView,idEleves,"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers0" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.recuperationEleves}" reRender="idSubView,idEleves" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                </center>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:form>

</f:subview>