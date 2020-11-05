<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="commissionliste">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center> <h2><h:outputText value="ACTIVITES COMMERCIALES et CALCUL DES COMMISSIONS" style="color:green;"/></h2></center>

        <rich:tabPanel switchType="client" immediate="true" style="border:0px;background-color:white;">

            <rich:tab id="tabAnalyse" label="Analyse activité">
                <h:panelGrid  columns="1" width="100%" id="documentAnalyse" >
                    <h:panelGrid id="panCtrlAnalyse" styleClass="recherche" width="100%">
                        <h:panelGrid columns="11" width="100%">
                            <h:column><h:outputText value="Du"/></h:column>
                            <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                            <h:column><h:outputText value="Au"/></h:column>
                            <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType}" style="width:100px;">
                                    <f:selectItem itemLabel="Devis" itemValue="21"/>
                                    <f:selectItem itemLabel="Bons de commande" itemValue="22"/>
                                    <f:selectItem itemLabel="Bons de livraison - Retours" itemValue="23"/>
                                    <f:selectItem itemLabel="Factures + Notes de débit - Avoirs" itemValue="25"/>
                                    <f:selectItem itemLabel="Clients Sans Commande" itemValue="122"/>
                                    <f:selectItem itemLabel="Clients Sans Facture" itemValue="125"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="panCtrlAnalyse,tableAnalyse"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType<100}">
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpMode}" style="width:100px;">
                                    <f:selectItem itemLabel="C.A. HT par responsable" itemValue="0"/>
                                    <f:selectItem itemLabel="C.A. HT par commercial" itemValue="1"/>
                                    <f:selectItem itemLabel="C.A. HT par équipe" itemValue="2"/>
                                    <f:selectItem itemLabel="Sources" itemValue="10"/>
                                    <f:selectItem itemLabel="Sources par responsable" itemValue="11"/>
                                    <f:selectItem itemLabel="Sources par commercial" itemValue="12"/>
                                    <f:selectItem itemLabel="Sources par équipe" itemValue="13"/>
                                    <f:selectItem itemLabel="Points de ventes" itemValue="20"/>
                                    <f:selectItem itemLabel="Produits" itemValue="21"/>
                                    <f:selectItem itemLabel="Points de ventes et Produits" itemValue="22"/>
                                    <a4j:support eventsQueue="Maqueue" event="onchange" reRender="tableAnalyse"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType<100}">
                                <h:selectOneMenu id="idConseiller" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpIdConseillers}" style="width:200px;">
                                    <f:selectItem itemLabel="Tous les conseillers" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesCommerciauxItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType<100}">
                                <h:selectOneMenu id="idResponsable" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpIdResponsable}" style="width:200px;">
                                    <f:selectItem itemLabel="Tous les responsables" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.mesResponsablesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType<100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.optionsVentes.responsable!='0'}">
                                <h:selectOneMenu id="idCommercial" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpIdCommercial}" style="width:200px;">
                                    <f:selectItem itemLabel="Tous les commerciaux" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.mesCommerciauxItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType<100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.optionsVentes.responsable=='1'}">
                                <h:selectOneMenu id="idEquipe" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpIdEquipe}" style="width:200px;">
                                    <f:selectItem itemLabel="Toutes les équipes" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.mesEquipesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column>
                                <h:selectOneMenu id="idPdv" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpPdv}" style="width:200px;">
                                    <f:selectItem itemLabel="Tous lesPDV" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.mesPdvItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column>
                                <a4j:commandButton value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.executerRequeteAnalyse}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panCtrl,tableAnalyse,scrollTableAnalyse,pnlgrttotalAnalyse"/>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <center>
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.pageIndex}" reRender="tableAnalyse" id="scrollTableAnalyse" maxPages="20"align="left" for="tableAnalyse"/>
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableAnalyse" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.dataModelAnalyse}" var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.extDTable}">
                                <rich:column label="Catégorie" sortable="true" sortBy="#{var.docActivite}" width="200px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType>100}">
                                    <f:facet name="header"><h:outputText  value="Catégorie"/></f:facet>
                                    <h:outputText  value="#{var.docActivite}"/>
                                </rich:column>
                                <rich:column label="Tiers" sortable="true" sortBy="#{var.docNomTiers}" width="700px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType>100}">
                                    <f:facet name="header"><h:outputText  value="Nom du Client"/></f:facet>
                                    <h:outputText  value="#{var.docNomTiers}"/>
                                </rich:column>
                                <rich:column label="Conseiller" sortable="true" sortBy="#{var.docNomResponsable}" width="250px" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType<100&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpMode==0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpMode==11)}">
                                    <f:facet name="header"><h:outputText  value="Conseillers"/></f:facet>
                                    <h:outputText  value="#{var.docNomResponsable}"/>
                                </rich:column>
                                <rich:column label="Responsable" sortable="true" sortBy="#{var.docNomResponsable}" width="250px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType<100&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpMode==0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpMode==11)}">
                                    <f:facet name="header"><h:outputText  value="Respponsable"/></f:facet>
                                    <h:outputText  value="#{var.docNomResponsable}"/>
                                </rich:column>
                                <rich:column label="Commercial" sortable="true" sortBy="#{var.docNomCommercial}" width="250px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType<100&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpMode==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpMode==12)}">
                                    <f:facet name="header"><h:outputText  value="Commercial"/></f:facet>
                                    <h:outputText  value="#{var.docNomCommercial}"/>
                                </rich:column>
                                <rich:column label="Equipe" sortable="true" sortBy="#{var.docNomEquipe}" width="250px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType<100&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpMode==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpMode==13)}">
                                    <f:facet name="header"><h:outputText  value="Equipe"/></f:facet>
                                    <h:outputText  value="#{var.docNomEquipe}"/>
                                </rich:column>
                                <rich:column label="Source" sortable="true" sortBy="#{var.docSource}" width="300px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType<100&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpMode>=10&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpMode<=13)}">
                                    <f:facet name="header"><h:outputText  value="Source"/></f:facet>
                                    <h:outputText  value="#{var.docSource}"/>
                                </rich:column>
                                <rich:column label="Point de vente" sortable="true" sortBy="#{var.docPdv}" width="200px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType<100&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpMode==20||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpMode==22)}">
                                    <f:facet name="header"><h:outputText  value="PDV"/></f:facet>
                                    <h:outputText  value="#{var.docPdv}"/>
                                </rich:column>
                                <rich:column label="Produits" sortable="true" sortBy="#{var.docAnal2}" width="300px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType<100&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpMode==21||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpMode==22)}">
                                    <f:facet name="header"><h:outputText  value="Produits"/></f:facet>
                                    <h:outputText  value="#{var.docAnal2}"/>
                                </rich:column>
                                <rich:column label="Quantité" sortable="true" sortBy="#{var.docQte}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType<100&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpMode==21||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpMode==22)}">
                                    <f:facet name="header"><h:outputText  value="Quantité"/></f:facet>
                                    <h:outputText  value="#{var.docQte}" rendered="#{var.docQte!=0}"/>
                                </rich:column>
                                <rich:column label="Total H.T" sortable="true" sortBy="#{var.docTotHt}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType<100}">
                                    <f:facet name="header"><h:outputText  value="Total H.T."/></f:facet>
                                    <h:outputText  value="#{var.docTotHt}" rendered="#{var.docTotHt!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Total T.T.C." sortable="true" sortBy="#{var.docTotTtc}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType<100}">
                                    <f:facet name="header"><h:outputText  value="Total T.T.C."/></f:facet>
                                    <h:outputText  value="#{var.docTotTtc}" rendered="#{var.docTotTtc!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Total règlement" sortable="true" sortBy="#{var.docTotReglement}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType<100&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpMode!=21)}">
                                    <f:facet name="header"><h:outputText  value="Règlement"/></f:facet>
                                    <h:outputText  value="#{var.docTotReglement}" rendered="#{var.docTotReglement!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Solde" sortable="true" sortBy="#{var.reliquat}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType<100}">
                                    <f:facet name="header"><h:outputText  value="Solde"/></f:facet>
                                    <h:outputText  value="#{var.reliquat}" rendered="#{var.reliquat!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Pourcentage" sortable="true" sortBy="#{var.pourcent}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType<100}">
                                    <f:facet name="header"><h:outputText  value="%"/></f:facet>
                                    <h:outputText  value="#{var.pourcent}" rendered="#{var.pourcent!=0}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Valeur point" sortable="true" sortBy="#{var.valeurPoint}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType<100}">
                                    <f:facet name="header"><h:outputText  value="Coef Source"/></f:facet>
                                    <h:outputText  value="#{var.valeurPoint}" rendered="#{var.valeurPoint!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Total point" sortable="true" sortBy="#{var.nbPoint}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType<100}">
                                    <f:facet name="header"><h:outputText  value="Points"/></f:facet>
                                    <h:outputText  value="#{var.nbPoint}" rendered="#{var.nbPoint!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Total document" sortable="true" sortBy="#{var.nbrDoc}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType<100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpMode<21}">
                                    <f:facet name="header"><h:outputText  value="Nb doc."/></f:facet>
                                    <h:outputText  value="#{var.nbrDoc}" rendered="#{var.nbrDoc!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Total documents transformés" sortable="true" sortBy="#{var.nbrTrf}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType<100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpMode<21}">
                                    <f:facet name="header"><h:outputText  value="Nb Trf."/></f:facet>
                                    <h:outputText  value="#{var.nbrTrf}" rendered="#{var.nbrTrf!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="% de transformation" sortable="true" sortBy="#{var.valTrf}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpType<100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpMode<21}">
                                    <f:facet name="header"><h:outputText  value="% Trf."/></f:facet>
                                    <h:outputText  value="#{var.valTrf}" rendered="#{var.valTrf!=0}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                        <br/>
                        <h:panelGrid id="pnlgrttotalAnalyse" columns="5" cellspacing="1" styleClass="recherche"  width="100%">
                            <h:panelGrid  columns="2" cellspacing="3"  cellpadding="3">
                                <h:outputText value="Montant total HT" />
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.montantHt}" style="width:100%;text-align:right;" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:panelGrid>
                            <h:panelGrid  columns="2" cellspacing="3"  cellpadding="3">
                                <h:outputText value="Montant total TTC" />
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.montantCommission}" style="width:100%;text-align:right;" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:panelGrid>
                            <h:panelGrid columns="2" cellspacing="3"  cellpadding="3">
                                <h:outputText value="Total Réglements" />
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.montantReglement}" style="width:100%;text-align:right;" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:panelGrid>
                            <h:panelGrid columns="2" cellspacing="3"  cellpadding="3">
                                <h:outputText value="Solde" />
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.montantSolde}" style="width:100%;text-align:right;" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:panelGrid>
                            <h:panelGrid columns="1" cellspacing="3"  cellpadding="3">
                                <h:outputText value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.var_nb_ligne})" />
                            </h:panelGrid>
                        </h:panelGrid>
                    </center>
                </h:panelGrid>
            </rich:tab>

            <rich:tab id="tabCom" label="Calcul Commission">
                <h:panelGrid  columns="1" width="100%" id="document" >
                    <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
                        <h:panelGrid columns="9" width="100%">
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.periode}" style="width:150px;">
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesPeriodesItems}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpEtat}" style="width:100px;">
                                    <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                                    <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesEtatsItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column>
                                <h:outputText value="Responsable:" style="text-decoration:underline;"/>&nbsp;
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpResponsable}" size="10">
                                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les responsables" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.rechercheResponsable}" reRender="idSubView,panCtrl,panDest,panelListeResponsable,formModalListeResponsable" />
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.optionsVentes.responsable!='0'}">
                                <h:outputText value="Commercial:" style="text-decoration:underline;"/>&nbsp;
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpCommercial}" size="10">
                                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les commerciaux" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.rechercheCommercial}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panCtrl,panDest,panelListeCommercial,formModalListeCommercial"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panCtrl,table,scrollTable,pnlgrttotal"/>
                                <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>

                <h:panelGrid id="panelBouton" columns="6" width="300px" style="height:34px">
                    <a4j:commandButton title="Ajouter nouveau calcul" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.ajoutCalcul}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelAjoutCalcul"/>
                    <a4j:commandButton title="Consulter le document sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.consultDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                    <a4j:commandButton title="Supprimer le document sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.commissionEnteteVentes.comEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer le(s) document(s) ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.supprimerCommission}" reRender="table,panelBouton,intpTTCL,intpRGLMTL,intpSOLDL"/>
                    <a4j:commandButton title="Annuler le document sélectionné" image="/images/annuler_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.commissionEnteteVentes.comEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.sup}" onclick="if (!confirm('Etes-vous sur de vouloir annuler ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.annulerDocument}" reRender="panelAnnuler"/>
                    <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
                    <a4j:commandButton title="Bon d'encaissement du/des document(s) sélectionné(s)" image="/images/bonCaisse.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.commissionEnteteVentes.comEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.var_affiche_dollar}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.payeDocument}" reRender="panelPaye,panelPayeMultiple,panelBouton" />
                    <a4j:commandButton title="Valider le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.commissionEnteteVentes.comEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider le(s) document(s) ?')) return false" reRender="panelBouton,idEtat,idTrf"/>
                    <a4j:commandButton title="Dé-Valider le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.commissionEnteteVentes.comDateTransfert==null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.commissionEnteteVentes.comEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider le(s) document(s) ?')) return false" reRender="panelBouton,idEtat,idTrf"/>
                </h:panelGrid>

                <center>
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.var_nb_max}" style="max-height:100%;" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.datamodelCommission}" var="var">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                            <rich:column label="N° Commission" sortable="true" sortBy="#{var.comNum}" width="70px">
                                <f:facet name="header"><h:outputText  value="N°"/></f:facet>
                                <h:outputText value="#{var.comNum}"/>
                            </rich:column>
                            <rich:column label="Date Commission" sortable="true" sortBy="#{var.comDate} #{var.comNum}" width="70px">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{var.comDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Date Début" sortable="true" sortBy="#{var.comDateDebut} #{var.comNum}" width="70px">
                                <f:facet name="header"><h:outputText  value="Du" /></f:facet>
                                <h:outputText value="#{var.comDateDebut}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Date Fin" sortable="true" sortBy="#{var.comDateFin}" width="70px">
                                <f:facet name="header"><h:outputText  value="Au" /></f:facet>
                                <h:outputText value="#{var.comDateFin}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{var.comEtat}" width="50px" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                <h:outputText value="#{var.libelleEta}"/>
                            </rich:column>
                            <rich:column id="idTrf" label="Sélection" sortable="true" sortBy="#{var.var_select_ligne}" width="50px" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Sel." /></f:facet>
                                <h:selectBooleanCheckbox value="#{var.var_select_ligne}"/>
                            </rich:column>
                            <rich:column label="Responsable" sortable="true" sortBy="#{var.comNomResponsable}" width="200px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.optionsVentes.responsable!='1'}">
                                <f:facet name="header"><h:outputText  value="Respponsable"/></f:facet>
                                <h:outputText  value="#{var.comNomResponsable}"/>
                            </rich:column>
                            <rich:column label="Commercial" sortable="true" sortBy="#{var.comNomContact}" width="200px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.optionsVentes.responsable=='1'}">
                                <f:facet name="header"><h:outputText  value="Commercial"/></f:facet>
                                <h:outputText  value="#{var.comNomContact}"/>
                            </rich:column>
                            <rich:column label="Total commission" sortable="true" sortBy="#{var.comTotCommission}" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Commission"/></f:facet>
                                <h:outputText  value="#{var.comTotCommission}" rendered="#{var.comTotCommission!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Total règlement" sortable="true" sortBy="#{var.comTotReglement}" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Règlement"/></f:facet>
                                <h:outputText  value="#{var.comTotReglement}" rendered="#{var.comTotReglement!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Solde" sortable="true" sortBy="#{var.var_solde}" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Solde"/></f:facet>
                                <h:outputText  value="#{var.var_solde}" rendered="#{var.var_solde!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <br/>
                    <h:panelGrid id="pnlgrttotal" columns="4" cellspacing="1" styleClass="recherche"  width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrVteTotaux==0}">
                        <h:panelGrid id="pnlgrttotalTTC" columns="2" cellspacing="3"  cellpadding="3">
                            <h:outputText id="outpTTCL" value="Montant commission" />
                            <h:inputText id="intpTTCL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.montantCommission}" style="width:100%;text-align:right;" readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:panelGrid>
                        <h:panelGrid id="pnlgrttotalRGLMT" columns="2" cellspacing="3"  cellpadding="3">
                            <h:outputText id="outpRGLMTL" value="Total Réglements" />
                            <h:inputText id="intpRGLMTL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.montantReglement}" style="width:100%;text-align:right;" readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:panelGrid>
                        <h:panelGrid id="pnlgrttotalSOLD" columns="2" cellspacing="3"  cellpadding="3">
                            <h:outputText id="outpSOLDL" value="Solde" />
                            <h:inputText id="intpSOLDL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.montantSolde}" style="width:100%;text-align:right;" readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:panelGrid>
                        <h:panelGrid id="pnlgrttotalLE" columns="1" cellspacing="3"  cellpadding="3">
                            <h:outputText id="outpLIST" value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.var_nb_ligne})" />
                        </h:panelGrid>
                    </h:panelGrid>
                </center>
            </rich:tab>

        </rich:tabPanel>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelAjoutCalcul" width="400" height="350" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.showModalPanelAjoutCalcul}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.showModalPanelAjoutCalcul}" var="ajt">
            <f:facet name="header"><h:outputText value="Ajouter un nouveau calcul"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.fermerCalcul}" image="/images/close.gif" styleClass="hidelink" reRender="panelAjoutCalcul"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;" id="panDest">
                        <h:column><h:outputText value="Date calcul:"/></h:column>
                        <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpDate}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Période du:"/></h:column>
                        <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Au:"/></h:column>
                        <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.optionsVentes.modeCommission!='3'}"><h:outputText value="Nb jour:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.optionsVentes.modeCommission!='3'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpNb}" size="5"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.optionsVentes.responsable!='1'}"><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.optionsVentes.responsable!='1'}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpResponsable}" style="width:100%;">
                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les responsables" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.rechercheResponsable}" reRender="idSubView,panDest,panelListeResponsable,formModalListeResponsable" />
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.optionsVentes.responsable=='1'}"><h:outputText value="Commercial:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.optionsVentes.responsable=='1'}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.inpCommercial}" style="width:100%;">
                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les commerciaux" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.rechercheCommercial}" reRender="idSubView,panDest,panelListeCommercial,formModalListeCommercial"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.valideCalcul}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelPaye" width="800" height="300" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.showModalPanelPaye}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.showModalPanelPaye}" var="pay">
            <f:facet name="header">
                <h:outputText value="Bon d'encaissement du document"></h:outputText>
            </f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.annulePaye}" image="/images/close.gif" styleClass="hidelink" reRender="panelPaye"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid id="firstgridd"  width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="Date:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.bonEncaissementVente.bonDate}" readonly="true"/></h:column>
                    <h:column><h:outputText value="N°:"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.commissionEnteteVentes.comNum}" readonly="true"/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value="Commercial:" style="text-decoration:underline;width:100%"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.commissionEnteteVentes.comNomCommercial}" readonly="true"/></h:column>
                    <h:column> <h:outputText value="Mode de règlement:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.commissionEnteteVentes.comTypeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.var_verouxModReg}">
                            <f:selectItem itemLabel="Paiement comptant" itemValue="0"/>
                            <f:selectItem itemLabel="Paiement bon encaissement" itemValue="4"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.chargerModReg}" reRender="firstgridd,colMontInput"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Caisse:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="bnqajt" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.var_inputCaisse}">
                            <f:selectItem  itemValue="0" itemLabel="Sélectionnez une caisse"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesCaissesItems}" />
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.choixCaisse}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:outputText value="Montant du bon:"/>
                    <h:column id="colMontInput">
                        <h:inputText style="width:100%;text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.montantElmTotBonEnc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.var_affichMontant}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelPaye" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.verifBonEncaissement}"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Net à payer:"/></h:column>
                    <h:column>
                        <h:inputText style="width:100%;text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.var_netAPayer}" disabled="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
                <h:panelGroup id="ppgrp">
                    <center>
                        <br><br>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.miseajourPaye}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.var_affiche_valide}" reRender="panelPaye,panelBouton"/>
                        <br>
                        <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.var_affiche_valide}" style="margin-left:50px;">
                            <h:graphicImage url="../images/Warning.png"  style="width:25px;height;"/>
                            <h:outputText value="Le montant du bon est supérieur au solde du document" style="color:red;" />
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelPayeMultiple" width="1100" height="450" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.showModalPanelPayeMultiple}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.showModalPanelPayeMultiple}" var="pay">
            <f:facet name="header">
                <h:outputText value="Bon d'encaissement des documents sélectionnés"></h:outputText>
            </f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.annulePayeMultiple}" image="/images/close.gif" styleClass="hidelink" reRender="panelPayeMultiple"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid id="firstgriddd"  width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="Date:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.bonEncaissementVente.bonDate}" readonly="true"/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column> <h:outputText value="Mode de règlement:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.commissionEnteteVentes.comTypeReg}">
                            <f:selectItem itemLabel="Paiement bon encaissement" itemValue="4"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Caisse:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="bnqajt" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.var_inputCaisse}">
                            <f:selectItem  itemValue="0" itemLabel="Sélectionnez une caisse"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesCaissesItems}" />
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.choixCaisse}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:outputText value="Montant du bon:"/>
                    <h:column id="colMontInput">
                        <h:inputText style="width:100%;text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.montantElmTotBonEnc}" disabled="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Net à payer:"/></h:column>
                    <h:column>
                        <h:inputText style="width:100%;text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.var_netAPayer}" disabled="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.datamodelPaiement}" var="var">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.calulNetPayer}" reRender="idNetPayer,panelGalobal"/>
                        <rich:column label="N° facture" sortable="true" sortBy="#{var.comNum}">
                            <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                            <h:outputText value="#{var.comNum}"/>
                        </rich:column>
                        <rich:column label="Date facture" sortable="true" sortBy="#{var.comDate} #{var.comNum}" width="70px">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.comDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Responsable ou commercial" sortable="true" sortBy="#{var.nomConcerne}" width="200px">
                            <f:facet name="header"><h:outputText  value="Nom Concerné" /></f:facet>
                            <h:outputText value="#{var.nomConcerne}"/>
                        </rich:column>
                        <rich:column label="Montant Commissions" sortable="true" sortBy="#{var.comTotCommission}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Commission"/></f:facet>
                            <h:outputText  value="#{var.comTotCommission}" rendered="#{var.comTotCommission!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Règlements" sortable="true" sortBy="#{var.comTotReglement}" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="Régl."  /></f:facet>
                            <h:outputText  value="#{var.comTotReglement}" rendered="#{var.comTotReglement!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Solde" sortable="true" sortBy="#{var.var_solde}" style="text-align:right;color:red">
                            <f:facet name="header"> <h:outputText value="Solde"  /></f:facet>
                            <h:outputText  value="#{var.var_solde}" rendered="#{var.var_solde!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                    <h:panelGroup id="ppgrp">
                        <center>
                            <br><br>
                            <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.miseajourPaye}" reRender="panelPayeMultiple,panelBouton"/>
                        </center>
                    </h:panelGroup>
                </a4j:region>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelAnnuler" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.showModalPanelAnnuler}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.showModalPanelAnnuler}" var="ser">
            <f:facet name="header"><h:outputText value="Annulation Commission"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.annuleAnnulation}" image="/images/close.gif" styleClass="hidelink" reRender="panelAnnuler"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Date annulation:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.commissionEnteteVentes.comDateAnnule}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Motif annulation:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.commissionEnteteVentes.comMotifAnnule}" maxlength="50"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommissionsVentes.miseajourAnnuler}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
