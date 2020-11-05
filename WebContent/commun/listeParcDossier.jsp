<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelListeParc">

    <a4j:form id="formModalListeParc">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="SELECTION DU PARC"/></f:facet>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableParc"/>
                <rich:extendedDataTable rows="200" id="tableParc" footerClass="bard" headerClass="headerTab" styleClass="bg" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.datamodelParc}" var="prc" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.simpleSelection}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.extDTable}">
                    <a4j:support eventsQueue="maQueue"  event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionParc}" reRender="idVal"/>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==12}" var="id12">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.recuperationDossier}" reRender="idSubView,idDossier"/>
                    </c:if>
                    <rich:column  width="20%" >
                        <f:facet name="header"><h:outputText  value="IMMATRICULATION" /></f:facet>
                        <h:outputText value="#{prc.anaCode}"/>
                    </rich:column>
                    <rich:column  width="80%"  >
                        <f:facet name="header"><h:outputText  value="LIBELLE" /></f:facet>
                        <h:outputText value="#{prc.anaNomFr}" />
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br>
            <h:panelGroup id="idVal">
                <center>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==12}" var="id12">
                        <a4j:commandButton id="idCanTiers12" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.annuleDossier}" reRender="idSubView,idDossier"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers12" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.recuperationDossier}" reRender="idSubView,idDossier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectDossier}"/>
                    </c:if>
                </center>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:form>

</f:subview>