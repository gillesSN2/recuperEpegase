<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelListeTiers">

    <a4j:form id="formModalListeTiers">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="SELECTION DU PATIENT"/></f:facet>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableTiers"/>
                <rich:extendedDataTable rows="200" id="tableTiers" footerClass="bard" headerClass="headerTab" styleClass="bg" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.datamodelPatients}" var="tiers" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.simpleSelection}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.extDTable}">
                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionlignePatients}" reRender="idVal"/>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==77}" var="ids0">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.recuperationPatients}" reRender="idSubView,idTiers"/>
                    </c:if>
                    <rich:column label="Catégorie" sortable="true" sortBy="#{tiers.patPec}" width="10%">
                        <f:facet name="header"><h:outputText  value="Catégorie" /></f:facet>
                        <h:outputText value="#{tiers.patPec}"/>
                    </rich:column>
                    <rich:column label="N° Compte" sortable="true" sortBy="#{tiers.patImmatriculation}" width="10%">
                        <f:facet name="header"><h:outputText  value="N° Immat." /></f:facet>
                        <h:outputText value="#{tiers.patImmatriculation}"/>
                    </rich:column>
                    <rich:column label="Raison sociale ou Nom" sortable="true" sortBy="#{tiers.patNom}" width="40%" filterBy="#{tiers.patNom}">
                        <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                        <h:outputText value="#{tiers.patNom}"/>
                    </rich:column>
                    <rich:column label="Prénom" sortable="true" sortBy="#{tiers.patPrenom}" width="20%">
                        <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                        <h:outputText value="#{tiers.patPrenom}"/>
                    </rich:column>
                    <rich:column label="Civilité" sortable="true" sortBy="#{tiers.patCivilite}" width="10%">
                        <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                        <h:outputText value="#{tiers.patCivilite}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br>
            <h:panelGroup id="idVal">
                <center>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==77}" var="id77">
                        <a4j:commandButton id="idCanTiers77" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.annulePatients}" reRender="idSubView,panelPage,idDevise,panelTiers,panelTiersInformations,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne,idTiersGeneration"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers77" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.recuperationPatients}" reRender="idSubView,panelPage,idSerie,idDevise,panelDate,idpanel1,panelTiers,panelTiersInformations,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne,idTiersGeneration" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                </center>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:form>

</f:subview>