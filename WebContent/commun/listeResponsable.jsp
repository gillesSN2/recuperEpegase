<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelListeResponsable">

    <a4j:form id="formModalListeResponsable">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="SELECTION DU RESPONSABLE"/></f:facet>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableResp"/>
                <rich:extendedDataTable rows="200" id="tableResp" footerClass="bard" headerClass="headerTab" styleClass="bg" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.datamodelResponsable}"  var="resp" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.simpleSelection}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.extDTable}">
                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionResponsable}" reRender="idVal"/>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==7}" var="ids7">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.recuperationResponsable}" reRender="idSubView,panDest"/>
                    </c:if>
                     <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==8}" var="ids8">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.recuperationResponsable}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==11}" var="ids11">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.recuperationResponsable}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==12}" var="ids12">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.recuperationResponsable}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==13}" var="ids13">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.recuperationResponsable}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==14}" var="ids14">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formRetourAchats.recuperationResponsable}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==15}" var="ids15">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.recuperationResponsable}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==16}" var="ids16">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formAvoirAchats.recuperationResponsable}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==17}" var="ids17">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.recuperationResponsable}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==18}" var="ids18">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFraisAchats.recuperationResponsable}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==21}" var="ids21">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formDevisVentes.recuperationResponsable}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==22}" var="ids22">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.recuperationResponsable}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==23}" var="ids23">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.recuperationResponsable}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==24}" var="ids24">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.recuperationResponsable}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==25}" var="ids25">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.recuperationResponsable}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==26}" var="ids26">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.recuperationResponsable}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==27}" var="ids27">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formNoteDebitVentes.recuperationResponsable}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==28}" var="ids28">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.recuperationResponsable}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==35}" var="ids35">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.recuperationResponsable}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${(bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature>=60&&bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature<=69)||bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==600}" var="ids60">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.recuperationResponsable}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==140}" var="ids140">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.recuperationResponsable}" reRender="idSubView,panDest"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==141}" var="ids141">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.recuperationResponsable}" reRender="idSubView,panDest"/>
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
                        <a4j:commandButton id="idCanTiers7" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.annuleResponsable}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers7" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.recuperationResponsable}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                     <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==8}" var="id8">
                        <a4j:commandButton id="idCanDestinataire8" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.annuleResponsable}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire8" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.recuperationResponsable}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==11}" var="id11">
                        <a4j:commandButton id="idCanTiers11" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.annuleResponsable}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers11" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.recuperationResponsable}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==12}" var="id12">
                        <a4j:commandButton id="idCanTiers12" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.annuleResponsable}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers12" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.recuperationResponsable}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==13}" var="id13">
                        <a4j:commandButton id="idCanTiers13" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.annuleResponsable}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers13" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.recuperationResponsable}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==14}" var="id14">
                        <a4j:commandButton id="idCanTiers14" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formRetourAchats.annuleResponsable}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers14" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formRetourAchats.recuperationResponsable}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==15}" var="id15">
                        <a4j:commandButton id="idCanTiers15" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.annuleResponsable}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers15" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.recuperationResponsable}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==16}" var="id16">
                        <a4j:commandButton id="idCanTiers16" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formAvoirAchats.annuleResponsable}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers16" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formAvoirAchats.recuperationResponsable}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==17}" var="id17">
                        <a4j:commandButton id="idCanTiers17" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.annuleResponsable}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers17" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.recuperationResponsable}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==18}" var="id18">
                        <a4j:commandButton id="idCanTiers18" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFraisAchats.annuleResponsable}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers18" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFraisAchats.recuperationResponsable}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==21}" var="id21">
                        <a4j:commandButton id="idCanDestinataire21" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formDevisVentes.annuleResponsable}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire21" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formDevisVentes.recuperationResponsable}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==22}" var="id22">
                        <a4j:commandButton id="idCanDestinataire22" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.annuleResponsable}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire22" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.recuperationResponsable}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==23}" var="id23">
                        <a4j:commandButton id="idCanDestinataire23" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.annuleResponsable}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire23" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.recuperationResponsable}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==24}" var="id24">
                        <a4j:commandButton id="idCanDestinataire24" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.annuleResponsable}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire24" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.recuperationResponsable}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==25}" var="id25">
                        <a4j:commandButton id="idCanDestinataire25" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.annuleResponsable}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire25" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.recuperationResponsable}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==26}" var="id26">
                        <a4j:commandButton id="idCanDestinataire26" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.annuleResponsable}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire26" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.recuperationResponsable}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==27}" var="id27">
                        <a4j:commandButton id="idCanDestinataire27" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formNoteDebitVentes.annuleResponsable}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire27" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formNoteDebitVentes.recuperationResponsable}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==28}" var="id28">
                        <a4j:commandButton id="idCanDestinataire28" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.annuleResponsable}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire28" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.recuperationResponsable}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==35}" var="id35">
                        <a4j:commandButton id="idCanTiers35" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.annuleResponsable}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers35" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.recuperationResponsable}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${(bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature>=60&&bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature<=69)||bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==600}" var="id60">
                        <a4j:commandButton id="idCanDestinataire60" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.annuleUtilisateur}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire60" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.recuperationUtilisateur}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==140}" var="id140">
                        <a4j:commandButton id="idCanDestinataire140" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.annuleResponsable}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire140" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.recuperationResponsable}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==141}" var="id141">
                        <a4j:commandButton id="idCanDestinataire141" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.annuleResponsable}" reRender="idSubView,panDest"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDestinataire141" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.recuperationResponsable}" reRender="idSubView,panDest" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectResponsable}"/>
                    </c:if>
                </center>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:form>

</f:subview>