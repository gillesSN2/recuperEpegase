<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelContactTiers">

    <a4j:form id="formModalContactTiers">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="LISTE DES CONTACTS DU TIERS: #{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieraisonsocialenom}"/></f:facet>
            <br>
            <h:panelGroup id="panelBouton">
                <center>
                    <a4j:commandButton title="Ajouter nouveau contact" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.ajouterContact}"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelContact"/>&nbsp;&nbsp;
                    <a4j:commandButton title="Modifier le contact sélectionné" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.modifierContact}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conid!=0}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelContact"/>&nbsp;&nbsp;
                    <a4j:commandButton title="Supprimer le contact sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conid!=0}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce contact ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.supprimerContact}" reRender="table,panelBouton"/>
                </center>
            </h:panelGroup>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="table" footerClass="bard" headerClass="headerTab" styleClass="bg" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.datamodelContact}"  var="resp"  activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.simpleSelection}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionContact}" reRender="panelBouton"/>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==11}" var="ids11">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==12}" var="ids12">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==13}" var="ids13">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==14}" var="ids14">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formRetourAchats.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==15}" var="ids15">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==16}" var="ids16">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formAvoirAchats.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==17}" var="ids17">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==18}" var="ids18">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFraisAchats.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==35}" var="ids35">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==8}" var="ids8">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==21}" var="ids21">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formDevisVentes.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==22}" var="ids22">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==23}" var="ids23">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==24}" var="ids24">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==25}" var="ids25">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==26}" var="ids26">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.recuperationContact}" reRender="idSubView,idPanelContact"/>
                            <a4j:commandButton id="idValTiers26" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==27}" var="id27">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formNoteDebitVentes.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==43}" var="ids43">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==127&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes!=null}" var="ids127v">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==127&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats!=null}" var="ids127a">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formAffaires.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==140}" var="ids140">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==150}" var="ids150">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==181}" var="id181">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <rich:column label="Civilité" sortable="true" sortBy="#{resp.concivilite}" width="10%">
                            <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                            <h:outputText value="#{resp.concivilite}"/>
                        </rich:column>
                        <rich:column label="Nom" sortable="true" sortBy="#{resp.connom}" width="35%">
                            <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                            <h:outputText value="#{resp.connom}"/>
                        </rich:column>
                        <rich:column label="Prénom" sortable="true" sortBy="#{resp.conprenom}" width="15%">
                            <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                            <h:outputText value="#{resp.conprenom}"/>
                        </rich:column>
                        <rich:column label="Fonction" sortable="true" sortBy="#{resp.confonction}" width="20%">
                            <f:facet name="header"><h:outputText  value="Fonction" /></f:facet>
                            <h:outputText value="#{resp.confonction}"/>
                        </rich:column>
                        <rich:column label="Mail" sortable="true" sortBy="#{resp.conmail1}" width="10%">
                            <f:facet name="header"><h:outputText  value="Mail" /></f:facet>
                            <h:outputText value="#{resp.conmail1}"/>
                        </rich:column>
                        <rich:column label="Service" sortable="true" sortBy="#{resp.conservice}" width="10%">
                            <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                            <h:outputText value="#{resp.conservice}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br>
                <h:panelGroup>
                    <center>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==11}" var="id11">
                            <a4j:commandButton id="idCanTiers11" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.annulerContact}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValTiers11" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==12}" var="id12">
                            <a4j:commandButton id="idCanTiers12" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.annulerContact}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValTiers12" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==13}" var="id13">
                            <a4j:commandButton id="idCanTiers13" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.annulerContact}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValTiers13" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==14}" var="id14">
                            <a4j:commandButton id="idCanTiers14" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formRetourAchats.annulerContact}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValTiers14" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formRetourAchats.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==15}" var="id15">
                            <a4j:commandButton id="idCanTiers15" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.annulerContact}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValTiers15" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==16}" var="id16">
                            <a4j:commandButton id="idCanTiers16" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formAvoirAchats.annulerContact}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValTiers16" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formAvoirAchats.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==17}" var="id17">
                            <a4j:commandButton id="idCanTiers17" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.annulerContact}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValTiers17" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==18}" var="id18">
                            <a4j:commandButton id="idCanTiers18" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFraisAchats.annulerContact}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValTiers18" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFraisAchats.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==35}" var="id35">
                            <a4j:commandButton id="idCanTiers35" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.annulerContact}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValTiers35" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==8}" var="id8">
                            <a4j:commandButton id="idCanTiers8" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.annulerContact}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValTiers8" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==21}" var="id21">
                            <a4j:commandButton id="idCanTiers21" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formDevisVentes.annulerContact}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValTiers21" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formDevisVentes.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==22}" var="id22">
                            <a4j:commandButton id="idCanTiers22" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.annulerContact}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValTiers22" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==23}" var="id23">
                            <a4j:commandButton id="idCanTiers23" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.annulerContact}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValTiers23" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==24}" var="id24">
                            <a4j:commandButton id="idCanTiers24" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.annulerContact}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValTiers24" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==25}" var="id25">
                            <a4j:commandButton id="idCanTiers25" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.annulerContact}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValTiers25" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==26}" var="id26">
                            <a4j:commandButton id="idCanTiers26" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.annulerContact}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValTiers26" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==27}" var="id27">
                            <a4j:commandButton id="idCanTiers27" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formNoteDebitVentes.annulerContact}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValTiers27" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formNoteDebitVentes.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==43}" var="id43">
                            <a4j:commandButton id="idCanTiers43" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.annulerContact}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValTiers43" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==127&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes!=null}" var="id127v">
                            <a4j:commandButton id="idCanTiers127v" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.annulerContact}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValTiers127v" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==127&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats!=null}" var="id127a">
                            <a4j:commandButton id="idCanTiers127a" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formAffaires.annulerContact}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValTiers127a" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formAffaires.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==140}" var="id140">
                            <a4j:commandButton id="idCanTiers140" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.annulerContact}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValTiers140" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==150}" var="id150">
                            <a4j:commandButton id="idCanTiers150" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.annulerContact}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValTiers150" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==181}" var="id181">
                            <a4j:commandButton id="idCanTiers181" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.annulerContact}" reRender="idSubView"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton id="idValTiers181" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.recuperationContact}" reRender="idSubView,idPanelContact"/>
                        </c:if>
                    </center>
                </h:panelGroup>
            </a4j:form>

        </h:panelGrid>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelContact" width="1200" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.showModalPanelContact}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.showModalPanelContact}" var="blv">
            <f:facet name="header"><h:outputText value="Gestion des contacts"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.annulerContact}" image="/images/close.gif" styleClass="hidelink" reRender="panelContact"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid styleClass="fichefournisseur" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText style="text-decoration:underline;" value="Civilité:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idcivil" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.concivilite}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.mesCivilitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Né(e) le:"/></h:column>
                    <h:column>
                        <a4j:outputPanel layout="block">
                            <rich:calendar style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.condatenaissance}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" popup="true"/>
                        </a4j:outputPanel>
                    </h:column>
                    <h:column><h:outputText value="Nom:"/></h:column>
                    <h:column><h:inputText maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.connom}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Prénom:"/></h:column>
                    <h:column><h:inputText maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conprenom}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:capitalize"/></h:column>
                    <h:column><h:outputText value="Fonction:"/></h:column>
                    <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.confonction}"/></h:column>
                    <h:column><h:outputText style="text-decoration:underline;" value="Langue:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idlan" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conlangue}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.mesLangueItems}" />
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" >
                    <h:column><h:outputText value="Service:"/></h:column>
                    <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conservice}"/></h:column>
                    <h:column><h:outputText value="Adresse:"/></h:column>
                    <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conadresse}"/></h:column>
                    <h:column><h:outputText value="Rue N°:"/></h:column>
                    <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conrue}"/></h:column>
                    <h:column><h:outputText value="Lot N°:"/></h:column>
                    <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conlot}"/></h:column>
                    <h:column><h:outputText value="Ilot N°:"/></h:column>
                    <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conilot}"/></h:column>
                    <h:column><h:outputText value="Porte N°:"/></h:column>
                    <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conporte}"/></h:column>
                    <h:column><h:outputText value="Quartier:"/></h:column>
                    <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conquartier}"/></h:column>
                    <h:column><h:outputText value="Commune:"/></h:column>
                    <h:column><h:inputText maxlength="30" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.concommune}"/></h:column>
                    <h:column><h:outputText value="Zone:"/></h:column>
                    <h:column><h:inputText maxlength="30" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conzone}"/></h:column>
                    <h:column><h:outputText value="Départ.:"/></h:column>
                    <h:column><h:inputText maxlength="30" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.condeparte}"/></h:column>
                    <h:column><h:outputText value="Bâtiment:"/></h:column>
                    <h:column><h:inputText maxlength="10" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conbatiment}"/></h:column>
                    <h:column><h:outputText value="Escalier:"/></h:column>
                    <h:column><h:inputText maxlength="10" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conescalier}"/></h:column>
                    <h:column><h:outputText value="B.P.:"/></h:column>
                    <h:column><h:inputText maxlength="20" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conbp}"/></h:column>
                    <h:column><h:outputText value="Cédex:"/></h:column>
                    <h:column><h:inputText maxlength="20" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.concedex}"/></h:column>
                    <h:column><h:outputText value="Ville:"/></h:column>
                    <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conville}"/></h:column>
                    <h:column><h:outputText style="text-decoration:underline;" value="Pays:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idpay" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.connompays}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.mesPaysItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid styleClass="fichefournisseur" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="Tél. bur.:"/></h:column>
                    <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.contelbur}"/></h:column>
                    <h:column><h:outputText value="Tél. dom.:"/></h:column>
                    <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conteldom}"/></h:column>
                    <h:column><h:outputText value="Cell. 1:"/></h:column>
                    <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.concel1}"/></h:column>
                    <h:column><h:outputText value="Cell. 2:"/></h:column>
                    <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.concel2}"/></h:column>
                    <h:column><h:outputText value="Cell. 3:"/></h:column>
                    <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.concel3}"/></h:column>
                    <h:column><h:outputText value="Fax:"/></h:column>
                    <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.confax}"/></h:column>
                    <h:column><h:outputText value="Aol:"/></h:column>
                    <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conaol}"/></h:column>
                    <h:column><h:outputText value="Skype:"/></h:column>
                    <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conskype}"/></h:column>
                    <h:column><h:outputText value="Yahoo:"/></h:column>
                    <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conyahoo}"/></h:column>
                    <h:column><h:outputText value="Msn:"/></h:column>
                    <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conmsn}"/></h:column>
                    <h:column><h:outputText value="Mail 1:"/></h:column>
                    <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conmail1}"/></h:column>
                    <h:column><h:outputText value="Mail 2:"/></h:column>
                    <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conmail2}"/></h:column>
                    <h:column><h:outputText value="Mail 3:"/></h:column>
                    <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conmail3}"/></h:column>
                    <h:column><h:outputText value="Mail 4:"/></h:column>
                    <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conmail4}"/></h:column>
                    <h:column><h:outputText value="Site Web:"/></h:column>
                    <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conweb}"/></h:column>
                    <h:column><h:outputText value="Blog:"/></h:column>
                    <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conblog}"/></h:column>
                </h:panelGrid>
                <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="Obs.:"/></h:column>
                    <h:column><h:inputText maxlength="80" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conobservation}"/></h:column>
                    <h:column><h:outputText style="text-decoration:underline;" value="Appréc.:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idapp" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.contacts.conappreciation}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.mesAppreciationsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <br/>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.validerContact}" reRender="panelContact,table"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>