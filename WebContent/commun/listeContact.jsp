<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelListeContacts">

    <a4j:form id="formModalListeContacts">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="SELECTION DU CONTACT"/></f:facet>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableContacts"/>
                <rich:extendedDataTable rows="200" id="tableContacts" footerClass="bard" headerClass="headerTab" styleClass="bg" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.datamodelContact}" var="con" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.simpleSelection}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.extDTable}">
                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionContact}" reRender="idVal"/>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==141}" var="ids140">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.recuperationContacts}" reRender="idSubView,idContact,idTiers"/>
                    </c:if>
                    <rich:column label="Catégorie" sortable="true" sortBy="#{con.tiers.tiecategorie}" width="15%">
                        <f:facet name="header"><h:outputText  value="Catégorie" /></f:facet>
                        <h:outputText value="#{con.tiers.tiecategorie}"/>
                    </rich:column>
                    <rich:column label="Civilité" sortable="true" sortBy="#{con.concivilite}" width="10%">
                        <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                        <h:outputText value="#{con.concivilite}"/>
                    </rich:column>
                    <rich:column label="Nom et Prénom" sortable="true" sortBy="#{con.conpatronyme}" width="40%">
                        <f:facet name="header"><h:outputText  value="Nom, Prénom" /></f:facet>
                        <h:outputText value="#{con.conpatronyme}"/>
                    </rich:column>
                    <rich:column label="Tiers" sortable="true" sortBy="#{con.tiers.tieraisonsocialenom}" width="35%">
                        <f:facet name="header"><h:outputText  value="Raison sociale" /></f:facet>
                        <h:outputText value="#{con.tiers.tieraisonsocialenom}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br>
            <h:panelGroup id="idVal">
                <center>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==141}" var="id140">
                        <a4j:commandButton id="idCanTiers141" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.annuleContacts}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers141" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.recuperationContacts}" reRender="idSubView,idContact,idTiers" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                </center>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:form>

</f:subview>