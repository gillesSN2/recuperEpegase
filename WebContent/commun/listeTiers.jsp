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
            <f:facet name="header"><h:outputText value="SELECTION DU TIERS"/></f:facet>
            <br>
            <h:panelGroup id="idAjout" style="height:35px">
                <center>
                    <a4j:commandButton id="idAjt" title="Ajouter Tiers" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.ajoutTiers}" reRender="panelTiers"/>
                </center>
            </h:panelGroup>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableTiers"/>
                <rich:extendedDataTable rows="200" id="tableTiers" footerClass="bard" headerClass="headerTab" styleClass="bg" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.datamodelTiers}" var="tiers" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.simpleSelection}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.extDTable}">
                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionligneTiers}" reRender="idVal"/>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==0}" var="ids0">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.recuperationTiers}" reRender="idSubView,idTiers"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==6}" var="ids6">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==8}" var="ids8">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==11}" var="ids11">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==12}" var="ids12">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==13}" var="ids13">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==14}" var="ids14">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formRetourAchats.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==15}" var="ids15">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==16}" var="ids16">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formAvoirAchats.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==17}" var="ids17">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==18}" var="ids18">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFraisAchats.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==21}" var="ids21">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formDevisVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==22}" var="ids22">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==23}" var="ids23">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==24}" var="ids24">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==25}" var="ids25">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==26}" var="ids26">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==27}" var="ids27">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formNoteDebitVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==28}" var="ids28">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==35}" var="ids35">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==43}" var="ids43">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==60}" var="ids60">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.recuperationTiers}" reRender="idSubView,idTiers"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==62}" var="ids62">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.recuperationTiers}" reRender="idSubView,idTiers"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==63}" var="ids63">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.recuperationTiers}" reRender="idSubView,idTiers"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==65}" var="ids65">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.recuperationTiers}" reRender="idSubView,idTiers"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==66}" var="ids66">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.ormBakingBeanCaisse.formTraite.recuperationTiers}" reRender="idSubView,idBene2"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==67}" var="ids67">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.recuperationTiers}" reRender="idSubView,idBene2"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==78}" var="ids78">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.recuperationTiers}" reRender="idSubView,idTiers"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==92}" var="ids92">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.recuperationTiers}" reRender="idSubView,idTiers"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==100}" var="ids100">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.formCadeaux.recuperationTiers}" reRender="idSubView,idPanGlobal,panelButton"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==127}" var="ids127">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne,panelValide"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==140}" var="ids140">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelDate,idpanel2,idpanel1,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==142}" var="ids142">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelDate,idpanel2,idpanel1,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==150}" var="ids150">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelDate,idpanel2,idpanel1,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==160}" var="ids160">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelDate,idpanel2,idpanel1,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==161}" var="ids161">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelDate,idpanel2,idpanel1,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==162}" var="ids162">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelDate,idpanel2,idpanel1,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==163}" var="ids163">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.recuperationTiers}" reRender="idSubView,panelPage,idFournisseur,idFournisseurSuite"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==164}" var="ids164">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.recuperationTiers}" reRender="idSubView,panelPage,idFournisseur,idFournisseurSuite"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==171}" var="ids171">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelDate,idpanel2,idpanel1,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==181}" var="ids181">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>
                    </c:if>
                    <rich:column label="Catégorie" sortable="true" sortBy="#{tiers.tiecategorie}" width="10%">
                        <f:facet name="header"><h:outputText  value="Catégorie" /></f:facet>
                        <h:outputText value="#{tiers.tiecategorie}" style="#{tiers.styleCouleur}"/>
                    </rich:column>
                    <rich:column label="N° Compte" sortable="true" sortBy="#{tiers.tiecompte0}" width="10%">
                        <f:facet name="header"><h:outputText  value="N° compte" /></f:facet>
                        <h:outputText value="#{tiers.tiecompte0}" style="#{tiers.styleCouleur}"/>
                    </rich:column>
                    <rich:column label="Sigle" sortable="true" sortBy="#{tiers.tiesigle}" width="10%">
                        <f:facet name="header"><h:outputText  value="Sigle" /></f:facet>
                        <h:outputText value="#{tiers.tiesigle}" style="#{tiers.styleCouleur}"/>
                    </rich:column>
                    <rich:column label="Raison sociale ou Nom" sortable="true" sortBy="#{tiers.tieraisonsocialenom}" width="40%" filterBy="#{tiers.tieraisonsocialenom}">
                        <f:facet name="header"><h:outputText  value="Raison sociale" /></f:facet>
                        <h:outputText value="#{tiers.tieraisonsocialenom}" style="#{tiers.styleCouleur}"/>
                    </rich:column>
                    <rich:column label="Prénom" sortable="true" sortBy="#{tiers.tieprenom}" width="20%">
                        <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                        <h:outputText value="#{tiers.tieprenom}" style="#{tiers.styleCouleur}"/>
                    </rich:column>
                    <rich:column label="Civilité" sortable="true" sortBy="#{tiers.tiecivilite}" width="10%">
                        <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                        <h:outputText value="#{tiers.tiecivilite}" style="#{tiers.styleCouleur}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br>
            <h:panelGroup id="idVal">
                <center>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==0}" var="id0">
                        <a4j:commandButton id="idCanTiers0" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.annuleTiers}" reRender="idSubView,idTiers,"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers0" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.recuperationTiers}" reRender="idSubView,idTiers," rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==6}" var="id6">
                        <a4j:commandButton id="idCanTiers6" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers6" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==8}" var="id8">
                        <a4j:commandButton id="idCanTiers8" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers8" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==11}" var="id11">
                        <a4j:commandButton id="idCanTiers11" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelTiersInformations,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers11" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelTiersInformations,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==12}" var="id12">
                        <a4j:commandButton id="idCanTiers12" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelTiersInformations,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers12" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelTiersInformations,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==13}" var="id13">
                        <a4j:commandButton id="idCanTiers13" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelTiersInformations,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers13" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelTiersInformations,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==14}" var="id14">
                        <a4j:commandButton id="idCanTiers14" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formRetourAchats.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelTiersInformations,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers14" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formRetourAchats.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelTiersInformations,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==15}" var="id15">
                        <a4j:commandButton id="idCanTiers15" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelTiersInformations,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers15" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelTiersInformations,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==16}" var="id16">
                        <a4j:commandButton id="idCanTiers16" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formAvoirAchats.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelTiersInformations,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers16" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formAvoirAchats.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelTiersInformations,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==17}" var="id17">
                        <a4j:commandButton id="idCanTiers17" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelTiersInformations,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers17" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelTiersInformations,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==18}" var="id18">
                        <a4j:commandButton id="idCanTiers18" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFraisAchats.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelTiersInformations,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers18" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFraisAchats.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelTiersInformations,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==21}" var="id21">
                        <a4j:commandButton id="idCanTiers21" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formDevisVentes.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers21" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formDevisVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==22}" var="id22">
                        <a4j:commandButton id="idCanTiers22" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers22" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==23}" var="id23">
                        <a4j:commandButton id="idCanTiers23" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers23" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==24}" var="id24">
                        <a4j:commandButton id="idCanTiers24" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers24" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==25}" var="id25">
                        <a4j:commandButton id="idCanTiers25" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelTiersInformations,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne,idTiersGeneration"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers25" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelDate,idpanel1,panelTiers,panelTiersInformations,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne,idTiersGeneration" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==26}" var="id26">
                        <a4j:commandButton id="idCanTiers26" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers26" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==27}" var="id27">
                        <a4j:commandButton id="idCanTiers27" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formNoteDebitVentes.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers27" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formNoteDebitVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==28}" var="id28">
                        <a4j:commandButton id="idCanTiers28" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers28" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==35}" var="id35">
                        <a4j:commandButton id="idCanTiers35" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers35" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==43}" var="id43">
                        <a4j:commandButton id="idCanTiers43" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers43" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==60}" var="id60">
                        <a4j:commandButton id="idCanTiers60" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.annuleTiers}" reRender="idSubView,idTiers"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers60" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.recuperationTiers}" reRender="idSubView,idTiers" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==62}" var="id62">
                        <a4j:commandButton id="idCanTiers62" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.annuleTiers}" reRender="idSubView,idTiers"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers62" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.recuperationTiers}" reRender="idSubView,idTiers" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==63}" var="id63">
                        <a4j:commandButton id="idCanTiers63" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.annuleTiers}" reRender="idSubView,idTiers"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers63" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.recuperationTiers}" reRender="idSubView,idTiers" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==65}" var="id65">
                        <a4j:commandButton id="idCanTiers65" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.annuleTiers}" reRender="idSubView,idTiers"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers65" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.recuperationTiers}" reRender="idSubView,idBene2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==66}" var="id66">
                        <a4j:commandButton id="idCanTiers66" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.annuleTiers}" reRender="idSubView,idTiers"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers66" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.recuperationTiers}" reRender="idSubView,idBene2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==67}" var="id67">
                        <a4j:commandButton id="idCanTiers67" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.annuleTiers}" reRender="idSubView,idTiers"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers67" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.recuperationTiers}" reRender="idSubView,idBene2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==78}" var="id78">
                        <a4j:commandButton id="idCanTiers78" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.annuleTiers}" reRender="idSubView,idTiers"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers78" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.recuperationTiers}" reRender="idSubView,idTiers" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==92}" var="id92">
                        <a4j:commandButton id="idCanTiers92" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.annuleTiers}" reRender="idSubView,idTiers"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers92" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.recuperationTiers}" reRender="idSubView,idTiers" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==100}" var="id100">
                        <a4j:commandButton id="idCanTiers100" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.formCadeaux.annuleTiers}" reRender="idSubView,idPanGlobal,panelButton"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers100" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.formCadeaux.recuperationTiers}" reRender="idSubView,idPanGlobal,panelButton" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==127}" var="id127">
                        <a4j:commandButton id="idCanTiers127" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelTiersInformations,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne,idTiersGeneration,panelValide"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers127" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelDate,idpanel1,panelTiers,panelTiersInformations,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne,idTiersGeneration,panelValide" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==140}" var="id140">
                        <a4j:commandButton id="idCanTiers140" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelDate,idpanel2,idpanel1,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers140" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formContratVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelDate,idpanel2,idpanel1,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==142}" var="id142">
                        <a4j:commandButton id="idCanTiers142" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelTiersInformations,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne,idTiersGeneration"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers142" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureInterneVentes.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelDate,idpanel1,panelTiers,panelTiersInformations,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne,idTiersGeneration" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==150}" var="id150">
                        <a4j:commandButton id="idCanTiers150" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelTiersInformations,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne,idTiersGeneration"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers150" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelDate,idpanel1,panelTiers,panelTiersInformations,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne,idTiersGeneration" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==160}" var="id160">
                        <a4j:commandButton id="idCanTiers160" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelDate,idpanel2,idpanel1,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers160" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelDate,idpanel2,idpanel1,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==161}" var="id161">
                        <a4j:commandButton id="idCanTiers161" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelDate,idpanel2,idpanel1,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers161" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelDate,idpanel2,idpanel1,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==162}" var="id162">
                        <a4j:commandButton id="idCanTiers162" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelDate,idpanel2,idpanel1,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers162" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelDate,idpanel2,idpanel1,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==163}" var="id163">
                        <a4j:commandButton id="idCanTiers163" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.annuleTiers}" reRender="idSubView,panelPage,idFournisseur,idFournisseurSuite"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers163" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.recuperationTiers}" reRender="idSubView,panelPage,idFournisseur,idFournisseurSuite" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==164}" var="id164">
                        <a4j:commandButton id="idCanTiers164" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.annuleTiers}" reRender="idSubView,panelPage,idFournisseur,idFournisseurSuite"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers164" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.recuperationTiers}" reRender="idSubView,panelPage,idFournisseur,idFournisseurSuite" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==171}" var="id171">
                        <a4j:commandButton id="idCanTiers171" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelDate,idpanel2,idpanel1,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers171" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelDate,idpanel2,idpanel1,panelTiers,panelContact,panelValide,panelListeTiers,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==181}" var="id181">
                        <a4j:commandButton id="idCanTiers181" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.annuleTiers}" reRender="idSubView,panelPage,idDevise,panelTiers,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers181" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formNoteDebitMedical.recuperationTiers}" reRender="idSubView,panelPage,idSerie,idDevise,panelTiers,panelDate,idpanel1,panelContact,panelValide,panelListeTiers,panelTiersInformations,panelBoutonLigne,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectTiers}"/>
                    </c:if>
                </center>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelTiers" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" autosized="true" width="900" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.showModalPanelAjoutTiers}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.showModalPanelAjoutTiers}" var="cre">
            <f:facet name="header"><h:outputText value="CREATION D'UN NOUVEAU TIER"/></f:facet>
            <a4j:form id="formModalAjtTiers">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" id="idPanGlobal">
                    <h:panelGrid width="100%" id="idType" columns="2" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Sélection type de tiers:"/></h:column>
                        <h:column>
                            <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.typeTiers}">
                                <f:selectItem itemLabel="Personne Physique" itemValue="0"/>
                                <f:selectItem itemLabel="Personne Morale" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.calculCategorieTiers}" reRender="idType,idPanGlobal"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" id="idTiers">
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.typeTiers=='0'}" var="phy">
                            <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%">
                                <h:column><h:outputText style="text-decoration:underline;" value="Civilité:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" id="idCivilite" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiecivilite}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.mesCivilitesItems}" />
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.calculeGenre}" reRender="idGenre"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Genre:"/></h:column>
                                <h:column>
                                    <h:selectOneRadio id="idGenre"  style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiesexe}" >
                                        <f:selectItem itemLabel="Femme" itemValue="0"/>
                                        <f:selectItem itemLabel="Homme" itemValue="1"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Nom:"/></h:column>
                                <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieraisonsocialenom}"/></h:column>
                                <h:column><h:outputText value="Prénom:"/></h:column>
                                <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieprenom}"/></h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Catégorie:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu  style="width:100%;" id="idCategorieP" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiecategorie}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.mesCategoriesItems}" />
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.calculTiersdivers}" reRender="panGlobal"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.var_tiersDivers}"><h:outputText value="Né(e) le:" /></h:column>
                                <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.var_tiersDivers}">
                                    <a4j:outputPanel layout="block">
                                        <rich:calendar   enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiedatenaissance}" popup="true"/>
                                    </a4j:outputPanel>
                                </h:column>
                                <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.var_tiersDivers}"><h:outputText value="Lieu naissance:"/></h:column>
                                <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.var_tiersDivers}"><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tielieunaissance}"/></h:column>
                                <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.var_tiersDivers}"><h:outputText value="Marié(e) le:"/></h:column>
                                <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.var_tiersDivers}">
                                    <a4j:outputPanel layout="block">
                                        <rich:calendar   enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiedatemariage}" popup="true"/>
                                    </a4j:outputPanel>
                                </h:column>
                                <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.var_tiersDivers}"><h:outputText value="Décédé(e) le:"/></h:column>
                                <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.var_tiersDivers}">
                                    <a4j:outputPanel layout="block">
                                        <rich:calendar   enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiedatedeces}" popup="true"/>
                                    </a4j:outputPanel>
                                </h:column>
                            </h:panelGrid>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.typeTiers=='1'}" var="mor">
                            <h:panelGrid columns="4" width="100%" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35">
                                <h:column><h:outputText value="Raison sociale:"/></h:column>
                                <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieraisonsocialenom}"/></h:column>
                                <h:column><h:outputText value="Sigle/Appartenance:"/></h:column>
                                <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiesigle}"/></h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Catégorie:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" id="idCategorieM" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiecategorie}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.mesCategoriesItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.calculTiersdivers}" reRender="panGlobal"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                            </h:panelGrid>
                        </c:if>
                        <h:panelGrid width="100%" styleClass="fichefournisseur1" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.var_tiersDivers}">
                            <h:panelGrid width="100%" columns="2" columnClasses="clos15,clos85">
                                <h:column><h:outputText value="Adresse:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieadresse}"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" >
                                <h:column><h:outputText value="Rue N°:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tierue}"/></h:column>
                                <h:column><h:outputText value="Lot N°:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tielot}"/></h:column>
                                <h:column><h:outputText value="Ilot N°:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieilot}"/></h:column>
                                <h:column><h:outputText value="Porte N°:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieporte}"/></h:column>
                                <h:column><h:outputText value="Quartier:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiequartier}"/></h:column>
                                <h:column><h:outputText value="Commune:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiecommune}"/></h:column>
                                <h:column><h:outputText value="Zone:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiezone}"/></h:column>
                                <h:column><h:outputText value="Département:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiedepart}"/></h:column>
                                <h:column><h:outputText value="Bâtiment:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiebatiment}"/></h:column>
                                <h:column><h:outputText value="Escalier:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieetage}"/></h:column>
                                <h:column><h:outputText value="Boite Postale:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiebp}"/></h:column>
                                <h:column><h:outputText value="Cédex:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiecedex}"/></h:column>
                                <h:column><h:outputText value="Ville:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieville}"/></h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Pays:"/></h:column>
                                <h:column id="idpays">
                                    <h:selectOneMenu style="width:100%;" id="idPays" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tienompays}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.mesPaysItems}" />
                                        <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionPays}" reRender="idpays"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid styleClass="fichefournisseur" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.var_tiersDivers}">
                            <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                <h:column><h:outputText value="Téléphone 1:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieburtel1}"/></h:column>
                                <h:column><h:outputText value="Téléphone 2:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieburtel2}"/></h:column>
                                <h:column><h:outputText value="Cellulaire:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiecel1}"/></h:column>
                                <h:column><h:outputText value="Fax:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieburfax}"/></h:column>
                                <h:column><h:outputText value="Skype:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieskype}"/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="Mail 1:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiemail1}"/></h:column>
                                <h:column><h:outputText value="Mail 2:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiemail2}"/></h:column>
                                <h:column><h:outputText value="Mail 3:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiemail3}"/></h:column>
                                <h:column><h:outputText value="Mail 4:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiemail4}"/></h:column>
                                <h:column><h:outputText value="Mail 5:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiemail5}"/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="Site Web:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieweb}"/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGroup id="idpanval">
                    <center>
                        <a4j:commandButton id="idCanAjt" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.annuleAjoutTiers}" reRender="panelTiers"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValAjt" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.valideAjoutTiers}" reRender="panelTiers,tableTiers"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>