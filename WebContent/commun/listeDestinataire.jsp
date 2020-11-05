<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelListeDestinataire">

    <a4j:form id="formModalListeDestinataire">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="SELECTION DU DESTINATAIRE"/></f:facet>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableDest"/>
                <rich:extendedDataTable rows="200" id="tableDest" footerClass="bard" headerClass="headerTab" styleClass="bg" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.datamodelDestinataire}" var="dest" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.simpleSelection}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.extDTable}">
                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionDestinataire}" reRender="idVal"/>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==8}" var="ids8">
                       <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.recuperationDestinataire}" reRender="idSubView,idDestinataire,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==21}" var="ids21">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formDevisVentes.recuperationDestinataire}" reRender="idSubView,idDestinataire,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==22}" var="ids22">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.recuperationDestinataire}" reRender="idSubView,idDestinataire,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==23}" var="ids23">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.recuperationDestinataire}" reRender="idSubView,idDestinataire,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==24}" var="ids24">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.recuperationDestinataire}" reRender="idSubView,idDestinataire,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==25}" var="ids25">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.recuperationDestinataire}" reRender="idSubView,idDestinataire,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==26}" var="ids26">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.recuperationDestinataire}" reRender="idSubView,idDestinataire,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==27}" var="ids27">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formNoteDebitVentes.recuperationDestinataire}" reRender="idSubView,idDestinataire,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==140}" var="ids140">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.recuperationDestinataire}" reRender="idSubView,idDestinataire,panDest"/>
                    </c:if>
                    <rich:column label="Nom" sortable="true" sortBy="#{dest.anaNomFr}" width="50%">
                        <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                        <h:outputText value="#{dest.anaNomFr}"/>
                    </rich:column>
                    <rich:column label="Téléphone" sortable="true" sortBy="#{dest.anaTiersTelephone}" width="20%">
                        <f:facet name="header"><h:outputText  value="Téléphone" /></f:facet>
                        <h:outputText value="#{dest.anaTiersTelephone}"/>
                    </rich:column>
                    <rich:column label="Adresse" sortable="true" sortBy="#{dest.anaTiersAdresse}" width="30%">
                        <f:facet name="header"><h:outputText  value="Adresse" /></f:facet>
                        <h:outputText value="#{dest.anaTiersAdresse}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br>
            <h:panelGroup id="idVal">
                <center>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==8}" var="id8">
                        <a4j:commandButton id="idCanDestinataire8" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.annuleDestinataire}" reRender="idSubView,idDestinataire,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire8" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.recuperationDestinataire}" reRender="idSubView,idDestinataire,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectDestinataire}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==21}" var="id21">
                        <a4j:commandButton id="idCanDestinataire21" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formDevisVentes.annuleDestinataire}" reRender="idSubView,idDestinataire,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire21" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formDevisVentes.recuperationDestinataire}" reRender="idSubView,idDestinataire,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectDestinataire}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==22}" var="id22">
                        <a4j:commandButton id="idCanDestinataire22" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.annuleDestinataire}" reRender="idSubView,idDestinataire,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire22" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.recuperationDestinataire}" reRender="idSubView,idDestinataire,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectDestinataire}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==23}" var="id23">
                        <a4j:commandButton id="idCanDestinataire23" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.annuleDestinataire}" reRender="idSubView,idDestinataire,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire23" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.recuperationDestinataire}" reRender="idSubView,idDestinataire,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectDestinataire}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==24}" var="id24">
                        <a4j:commandButton id="idCanDestinataire24" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.annuleDestinataire}" reRender="idSubView,idDestinataire,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire24" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.recuperationDestinataire}" reRender="idSubView,idDestinataire,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectDestinataire}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==25}" var="id25">
                        <a4j:commandButton id="idCanDestinataire25" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.annuleDestinataire}" reRender="idSubView,idDestinataire,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire25" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.recuperationDestinataire}" reRender="idSubView,idDestinataire,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectDestinataire}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==26}" var="id26">
                        <a4j:commandButton id="idCanDestinataire26" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.annuleDestinataire}" reRender="idSubView,idDestinataire,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire26" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.recuperationDestinataire}" reRender="idSubView,idDestinataire,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectDestinataire}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==27}" var="id27">
                        <a4j:commandButton id="idCanDestinataire27" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formNoteDebitVentes.annuleDestinataire}" reRender="idSubView,idDestinataire,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire27" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formNoteDebitVentes.recuperationDestinataire}" reRender="idSubView,idDestinataire,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectDestinataire}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==140}" var="id140">
                        <a4j:commandButton id="idCanDestinataire140" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.annuleDestinataire}" reRender="idSubView,idDestinataire,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire140" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.recuperationDestinataire}" reRender="idSubView,idDestinataire,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectDestinataire}"/>
                    </c:if>
                </center>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:form>

</f:subview>