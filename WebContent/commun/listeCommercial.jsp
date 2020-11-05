<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelListeCommercial">

    <a4j:form id="formModalListeCommercial">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="SELECTION DU COMMERCIAL"/></f:facet>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableResp"/>
                <rich:extendedDataTable rows="200" id="tableResp" footerClass="bard" headerClass="headerTab" styleClass="bg" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.datamodelResponsable}"  var="resp" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.simpleSelection}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.extDTable}">
                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionCommercial}" reRender="idVal"/>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==7}" var="id7">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.recuperationCommercial}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==8}" var="id8">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.recuperationCommercial}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==21}" var="id21">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formDevisVentes.recuperationCommercial}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==22}" var="id22">
                        <a4j:commandButton id="idCanDestinataire22" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.annuleCommercial}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire22" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.recuperationCommercial}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==23}" var="id23">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.recuperationCommercial}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==24}" var="id24">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.recuperationCommercial}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==25}" var="id25">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.recuperationCommercial}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==26}" var="id26">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.recuperationCommercial}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==27}" var="id27">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formNoteDebitVentes.recuperationCommercial}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==28}" var="id28">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.recuperationCommercial}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==140}" var="id140">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.recuperationCommercial}" reRender="idSubView,panDest"/>
                    </c:if>
                    <rich:column label="Nom et prénom" sortable="true" sortBy="#{resp.usrPatronyme}" width="50%">
                        <f:facet name="header"><h:outputText  value="Nom et Prénom" /></f:facet>
                        <h:outputText value="#{resp.usrPatronyme}"/>
                    </rich:column>
                    <rich:column label="Fonction" sortable="true" sortBy="#{resp.usrFonction}" width="20%">
                        <f:facet name="header"><h:outputText  value="Fonction" /></f:facet>
                        <h:outputText value="#{resp.usrFonction}"/>
                    </rich:column>
                    <rich:column label="Service" sortable="true" sortBy="#{resp.usrService}" width="20%">
                        <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                        <h:outputText value="#{resp.usrService}"/>
                    </rich:column>
                    <rich:column label="Groupe ou Collaboration" sortable="true" sortBy="#{resp.usrCollaboration}" width="10%">
                        <f:facet name="header"><h:outputText  value="Groupe" /></f:facet>
                        <h:outputText value="#{resp.usrCollaboration}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br>
            <h:panelGroup id="idVal">
                <center>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==7}" var="id7">
                        <a4j:commandButton id="idCanDestinataire7" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.annuleCommercial}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire7" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.recuperationCommercial}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==8}" var="id8">
                        <a4j:commandButton id="idCanDestinataire8" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.annuleCommercial}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire8" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.recuperationCommercial}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==21}" var="id21">
                        <a4j:commandButton id="idCanDestinataire21" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formDevisVentes.annuleCommercial}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire21" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formDevisVentes.recuperationCommercial}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==22}" var="id22">
                        <a4j:commandButton id="idCanDestinataire22" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.annuleCommercial}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire22" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.recuperationCommercial}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==23}" var="id23">
                        <a4j:commandButton id="idCanDestinataire23" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.annuleCommercial}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire23" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.recuperationCommercial}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==24}" var="id24">
                        <a4j:commandButton id="idCanDestinataire24" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.annuleCommercial}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire24" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.recuperationCommercial}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==25}" var="id25">
                        <a4j:commandButton id="idCanDestinataire25" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.annuleCommercial}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire25" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.recuperationCommercial}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==26}" var="id26">
                        <a4j:commandButton id="idCanDestinataire26" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.annuleCommercial}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire26" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.recuperationCommercial}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==27}" var="id27">
                        <a4j:commandButton id="idCanDestinataire27" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formNoteDebitVentes.annuleCommercial}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire27" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formNoteDebitVentes.recuperationCommercial}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==28}" var="id28">
                        <a4j:commandButton id="idCanDestinataire28" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.annuleCommercial}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire28" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.recuperationCommercial}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==140}" var="id140">
                        <a4j:commandButton id="idCanDestinataire140" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.annuleCommercial}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire140" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.recuperationCommercial}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                </center>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:form>

</f:subview>