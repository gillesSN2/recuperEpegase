<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="sm" >

    <center> <h2><h:outputText value="SAISIE MENSUELLE DES OPERATIONS COMPTABLES" styleClass="titre"/></h2></center>

    <a4j:form id="formsm">
        <h:panelGrid  width="100%" id="pngGlobal">
            <h:panelGrid  columns="2"  width="100%" id="pngGlob" columnClasses="clos50d;clos50g">
                <h:panelGrid  style="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_hauteur}" width="100%" styleClass="fichefournisseur1" >
                    <b><h:outputText value="Journal : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljCode} : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljLibelleFr}  (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.devise}) #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.cpTreso}" styleClass="titre" /></b>
                    <b><h:outputText value="Période : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxMois.joumenPeriode}" styleClass="titre"/></b>
                    <h:panelGrid id="fermer" columns="3">
                        <h:commandButton value="FERMER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.fermerLeJournalImputation}" styleClass="fermer" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        <a4j:commandButton title="Uniquement Analytique en ERREUR" image="/images/detail_alerte.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.chargerAnalytiqueErreur}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,solde,pnSaisie,richpanlisteECR,scrollTable,tableEcritures"/>
                        <a4j:commandButton title="Imprimer" image="/images/print.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail,solde"/>
                    </h:panelGrid>
                </h:panelGrid>

                <h:panelGrid id="solde" styleClass="fichefournisseur1" columns="3" width="100%" style="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_hauteur}" columnClasses="cols,cols,cols" >
                    <h:panelGrid width="100%" style="text-align:right;font-weight:bold;margin-top:25px;" cellpadding="2px" >
                        <f:facet name="header"><h:outputText value=""/></f:facet>
                        <h:column><h:outputText value= "Mouvements:" /></h:column>
                        <h:column><h:outputText value= "Solde:" /></h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" style="border:1px solid black;" headerClass="headerTab">
                        <f:facet name="header"><h:outputText  value="DEBIT"/></f:facet>
                        <h:column >
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.totalMvtsdebit}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"   id="totalMvtDebID" >
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.soldeDeb}" id="soldedebId" readonly="true"  style="color:red;width:90%;text-align:right;background:transparent;border:0px;"  >
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" style="border:1px solid black;" headerClass="headerTab">
                        <f:facet name="header"><h:outputText  value="CREDIT"/></f:facet>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.totalMvtscredit}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;" id="totalMvtCredID" >
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.soldeCred}" readonly="true" style="color:red;width:90%;text-align:right;background:transparent;border:0px;" id="soldecredID">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </h:panelGrid>

            <h:panelGrid columns="13" id="pnSaisie" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_action!=3)==true}" styleClass="refbarre"  width="100%" >
                <h:panelGroup id="jour">
                    <h:outputText value="Jour:" styleClass="textAligneOutTable"/><br>
                    <h:selectOneMenu  tabindex="1" id="jourId" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrJour}"  style="width:50px;" disabled="true">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.lesjoursItems}"  />
                    </h:selectOneMenu>
                </h:panelGroup>
                <h:panelGroup id="compte">
                    <h:outputText value="N° de compte:" styleClass="textAligneOutTable"/><br>
                    <h:inputText tabindex="2" id="compteId" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrCompte}" onfocus="compteId.focus()" onkeypress="return scanToucheLettre(event)" size="6" readonly="true" disabled="true" maxlength="20">
                        <rich:toolTip id="tooladd" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un numéro de compte ou d'un libellé de compte" style="background-color:#FFF8D4;"/>
                    </h:inputText>
                </h:panelGroup>
                <h:panelGroup id="comtePartie" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testContrePartie}">
                    <h:outputText  value="Contrepartie:" styleClass="textAligneOutTable" /><br>
                    <h:inputText tabindex="3" id="cpId" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrContrePartie}" onkeypress="return scanToucheLettre(event)" size="6" readonly="true" disabled="true" maxlength="20">
                        <rich:toolTip id="tooladdCP" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un numéro de compte ou d'un libellé de compte" style="background-color:#FFF8D4;"/>
                    </h:inputText>
                </h:panelGroup>
                <h:panelGroup id="piece">
                    <h:outputText value="N° de pièce:" style="font-weight:bold"/><br>
                    <h:inputText tabindex="4" id="pieceId" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrPiece}" size="9" maxlength="20" readonly="true" disabled="true"/>
                </h:panelGroup>
                <h:panelGroup id="ref1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testRef1Piece}">
                    <h:outputText value="Référence1:" style="font-weight:bold"/><br>
                    <h:inputText tabindex="5" id="ref1Id" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrReference1}" size="9" maxlength="30" onkeypress="return scanToucheLettre(event)" readonly="true" disabled="true"/>
                </h:panelGroup>
                <h:panelGroup id="ref2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testRef2Piece}">
                    <h:outputText value="Référence2:" style="font-weight:bold"/><br>
                    <h:inputText tabindex="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrReference2}" size="9" maxlength="30" onkeypress="return scanToucheLettre(event)" readonly="true" disabled="true"/>
                </h:panelGroup>
                <h:panelGroup id="idBudgetTresoProjet" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.tresorerie=='true'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.afficheBudgetTresoProjet}">
                    <h:outputText value="Poste/Budget:" styleClass="textAligneOutTable"/><br>
                    <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrPosteTreso}" size="7" readonly="true" disabled="true" onkeypress="return scanToucheLettre(event)">
                        <rich:toolTip id="tooladdBudgetProjet" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez un poste de budget de trésorerie ou * puis tabulez" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.rechercheBudgetTresorerie}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeBudgetTresorerie,formModalListeBudgetTresorerie,idBudgetTresoProjet"/>
                    </h:inputText>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrBudgetTreso}" size="7" readonly="true" disabled="true"/>
                </h:panelGroup>
                <h:panelGroup id="idBudgetTresoStandard" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.tresorerie=='true'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.afficheBudgetTresoStandard}">
                    <h:outputText value="Tréso.:" styleClass="textAligneOutTable"/><br>
                    <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrTreso}" size="10" readonly="true" disabled="true" onkeypress="return scanToucheLettre(event)">
                        <rich:toolTip id="tooladdBudgetStandard" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez un poste de budget de trésorerie ou * puis tabulez" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.rechercheBudgetTresorerie}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeBudgetTresorerie,formModalListeBudgetTresorerie,idBudgetTresoStandard"/>
                    </h:inputText>
                </h:panelGroup>
                <h:panelGroup id="idDossier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_affiche_dossier}">
                    <h:outputText value="Dossier:" styleClass="textAligneOutTable"/><br>
                    <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrDossier}" size="10" readonly="true" disabled="true" onkeypress="return scanToucheLettre(event)">
                        <rich:toolTip id="tooladdDossier" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez un dossier ou * puis tabulez" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.rechercheDossier}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelDossier,idDossier"/>
                    </h:inputText>
                </h:panelGroup>
                <h:panelGroup id="dateEcheance" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrNature==6||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrNature==7}">
                    <h:outputText id="idEcheance" value="Echéance:" style="font-weight:bold"/><br>
                    <rich:calendar tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrDateEcheance}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" inputSize="8" readonly="true" disabled="true"/>
                </h:panelGroup>
                <h:panelGroup id="origine" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==8||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==10)&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrNature==10||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrNature==11)}">
                    <h:outputText value="Origine:" styleClass="textAligneOutTable"/><br>
                    <h:column>
                        <h:selectOneMenu tabindex="9" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrOrigineBanque}" readonly="true" disabled="true">
                            <f:selectItem itemLabel="Même bnq sur place" itemValue="0"/>
                            <f:selectItem itemLabel="Même bnq hors place" itemValue="1"/>
                            <f:selectItem itemLabel="Autre bnq sur place" itemValue="2"/>
                            <f:selectItem itemLabel="Autre bnq hors place" itemValue="2"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGroup>
                <h:panelGroup id="dateValeur" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==8||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==10)&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrNature==10||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrNature==11)}">
                    <h:outputText value="Date val.:" style="font-weight:bold"/><br>
                    <rich:calendar tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrDateValeurTheo}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" inputSize="8" readonly="true" disabled="true"/>
                </h:panelGroup>
                <h:panelGroup id="debit">
                    <h:outputText value="Débit:" style="font-weight:bold"/><br>
                    <h:inputText id="idDebit" tabindex="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.valindexD}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrDebitSaisie}" style="text-align:right" size="10" readonly="true" disabled="true" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGroup>
                <h:panelGroup id="credit">
                    <h:outputText value="Crédit:" style="font-weight:bold"/><br>
                    <h:inputText tabindex="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.valindexC}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrCreditSaisie}"  style="text-align:right" size="10" readonly="true" disabled="true" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGroup>
                <h:panelGroup id="libelle">
                    <h:outputText value="Libellé:" style="font-weight:bold"/><br>
                    <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrLibelle}" size="30" id="ecrLibelleid" onkeypress="return scanToucheLettre(event)" readonly="true" disabled="true"/>
                </h:panelGroup>
                <h:panelGroup id="pngMaj" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.planComptable.plcId!=0}">
                    <a4j:commandButton tabindex="14" id="idValLigne" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.saveEcritureImputation}" focus="sm:formsm:compteId" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="pngGlobal,alerteM,pngGlob,solde,pnSaisie,richpanlisteECR,tableEcritures,idAnal,modalpanelAnalytique,modAttente"/>
                    <rich:hotKey key="return" handler="#{rich:element('idValLigne')}.click()" />
                </h:panelGroup>
            </h:panelGrid>

            <h:outputText id="libNumcpte"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrLibCompte}"/>
        </h:panelGrid>

        <h:panelGrid width="100%" id="richpanlisteECR" styleClass="fichefournisseur1">
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.pageIndex}" reRender="tableEcritures" id="scrollTable" maxPages="20"align="left" for="tableEcritures"/>
                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_nb_max}" border="0" activeClass="active-row" noDataLabel=" "  footerClass="bard" headerClass="headerTab" sortMode="multi" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.datamodelEcritures}" var="table" id="tableEcritures"  width="100%"  style="max-height:100%;border: solid 1px">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.selectionEcriture}" reRender="pnSaisie,libNumcpte,alerteM,fermer"/>
                    <rich:column label="Etat" width="3%" sortable="true" sortBy="#{table.ecrEtat}"  >
                        <f:facet name="header"><h:outputText  value="E."/></f:facet>
                        <h:outputText value="#{table.lib_etat}" style="width:10px;color:#{table.couleur};"/>
                    </rich:column>
                    <rich:column label="Jour" width="3%" sortable="true" sortBy="#{table.ecrJour}"  >
                        <f:facet name="header"><h:outputText  value="J."/></f:facet>
                        <h:outputText value="#{table.ecrJour}" style="width:10px;color:#{table.couleur};"/>
                    </rich:column>
                    <rich:column label="Compte" width="8%" sortable="true" sortBy="#{table.ecrCompte}" >
                        <f:facet name="header"><h:outputText  value="N° compte" /></f:facet>
                        <h:outputText value="#{table.ecrCompte}" style="color:#{table.couleur}" title="#{table.ecrCompte}"/>
                    </rich:column>
                    <rich:column label="Ititulé du Compte" width="8%" sortable="true" sortBy="#{table.ecrLibCompte}" >
                        <f:facet name="header"><h:outputText  value="Intitulé" /></f:facet>
                        <h:outputText value="#{table.ecrLibCompte}" style="color:#{table.couleur}" title="#{table.ecrLibCompte}"/>
                    </rich:column>
                    <rich:column label="Contrepartie"  width="8%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testContrePartie}" sortable="true" sortBy="#{table.ecrContrePartie}" >
                        <f:facet name="header"><h:outputText value="Contrepartie"/></f:facet>
                        <h:outputText value="#{table.ecrContrePartie}" style="color:#{table.couleur}" title="#{table.ecrContrePartie}"/>
                    </rich:column>
                    <rich:column label="N° de pièce"  width="10%"  sortable="true" sortBy="#{table.ecrPiece}" sortOrder="DESCENDING" >
                        <f:facet name="header"><h:outputText value="N° pièce" /></f:facet>
                        <h:outputText value="#{table.ecrPiece}" style="color:#{table.couleur}" title="#{table.ecrPiece}"/>
                    </rich:column>
                    <rich:column label="Référence N°1"  width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testRef1Piece}" sortable="true" sortBy="#{table.ecrReference1}" >
                        <f:facet name="header"><h:outputText  value="Référence1" /></f:facet>
                        <h:outputText value="#{table.ecrReference1}" style="color:#{table.couleur}" title="#{table.ecrReference1}"/>
                    </rich:column>
                    <rich:column label="Référence n°2" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.testRef2Piece}" sortable="true" sortBy="#{table.ecrReference2}">
                        <f:facet name="header"><h:outputText  value="Référence2"/></f:facet>
                        <h:outputText value="#{table.ecrReference2}" style="color:#{table.couleur}" title="#{table.ecrReference2}"/>
                    </rich:column>
                    <rich:column label="Date échéance"  width="10%" sortable="true" sortBy="#{table.ecrDateEcheance}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==2}">
                        <f:facet name="header"><h:outputText  value="Echéance" /></f:facet>
                        <h:outputText value="#{table.ecrDateEcheance}" style="width:10px;color:#{table.couleur};">
                            <f:convertDateTime pattern="dd/MM/yyyy"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Lettrage/Pointage/Rapproc."  width="3%" style="text-align:center;">
                        <f:facet name="header"><h:outputText  value="LPR." /></f:facet>
                        <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/cadenas_cl.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ouvrirLpr}" reRender="modalpanelLPR,formLpr" rendered="#{table.nbrEcrLettrage}"/>
                    </rich:column>
                    <rich:column label="Dossier"  width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_affiche_dossier}" sortable="true" sortBy="#{table.ecrDossier}" >
                        <f:facet name="header"><h:outputText  value="Dossier" /></f:facet>
                        <h:outputText value="#{table.ecrDossier}" style="color:#{table.couleur}" title="#{table.ecrDossier}"/>
                    </rich:column>
                    <rich:column id="idAnal" width="3%" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_affiche_analytique}">
                        <f:facet name="header"><h:outputText  value="A."/></f:facet>
                        <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/detail.png" style="width:14px;height:14px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ouvrirDetailsAnalytique}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,modalpanelAnalytique,formAnal,modalpanelAnalRecup,formAnalRecup" rendered="#{table.ecrAnaActif==1&&table.erreurAnalytique==false}" ></a4j:commandButton>
                         <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/detail_alerte.png" style="width:14px;height:14px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ouvrirDetailsAnalytique}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,modalpanelAnalytique,formAnal,modalpanelAnalRecup,formAnalRecup" rendered="#{table.ecrAnaActif==1&&table.erreurAnalytique==true}" ></a4j:commandButton>
                    </rich:column>
                    <rich:column label="Montant débit"  width="10%" style="text-align:right;" sortable="true" sortBy="#{table.ecrDebitSaisie}" >
                        <f:facet name="header"><h:outputText  value="Débit"/></f:facet>
                        <h:outputText value="#{table.ecrDebitSaisie}" rendered="#{table.ecrDebitSaisie!=0}" style="color:#{table.couleur}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Montant crédit"  width="10%" style="text-align:right;" sortable="true" sortBy="#{table.ecrCreditSaisie}" >
                        <f:facet name="header"><h:outputText value="Crédit" /></f:facet>
                        <h:outputText value="#{table.ecrCreditSaisie}" rendered="#{table.ecrCreditSaisie!=0}" style="color:#{table.couleur}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Libellé écriture"  width="20%"sortable="true" sortBy="#{table.ecrLibelle}"  >
                        <f:facet name="header"><h:outputText value="Libellé" /></f:facet>
                        <h:outputText value="#{table.ecrLibelle}" style="width:100px;color:#{table.couleur};" title="#{table.ecrLibelle}"/>
                    </rich:column>
                    <rich:column label="Budget Trésorerie ou imputation de trésoreie" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.optionComptabilite.tresorerie=='true'&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature>=7&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature<=11)}" sortable="true" sortBy="#{table.ecrTreso} #{table.ecrPosteTreso} #{table.ecrBudgetTreso}">
                        <f:facet name="header"><h:outputText  value="Poste/Budget"/></f:facet>
                        <h:outputText value="#{table.ecrPosteTreso} #{table.ecrBudgetTreso}" style="color:#{table.couleur}" rendered="#{table.ecrPosteTreso!=null}"/>
                        <h:outputText value="#{table.ecrTreso}" style="color:#{table.couleur}" rendered="#{table.ecrTreso!=null}"/>
                    </rich:column>
                    <rich:column label="Date valeur" width="10%" sortable="true" sortBy="#{table.ecrDateValeurTheo}" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==8||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.journauxActif.pljNature==10)}">
                        <f:facet name="header"><h:outputText  value="Date val."/></f:facet>
                        <h:outputText value="#{table.ecrDateValeurTheo}" style="width:10px;color:#{table.couleur};">
                            <f:convertDateTime pattern="dd/MM/yyyy"/>
                        </h:outputText>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br>
        </h:panelGrid>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="modalpanelLPR" width="250" height="160" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelLpr}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelLpr}" var="lpr">
            <f:facet name="header"><h:outputText value="INFORMATION SUR LE L.P.R."></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.fermerLpr}" image="/images/close.gif" styleClass="hidelink" reRender="modalpanelLPR"/>
                </a4j:form >
            </f:facet>
            <a4j:form id="formLpr">
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos50,clos50" style="text-align:center;">
                    <h:outputText value="Lettrage :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrLettrage}" id="outLPRlett"/>

                    <h:outputText value="Pointage :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrPointage}" id="outLPRpoint"/>

                    <h:outputText value="Rapprochement :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.ecrRapprochement}" id="outLPRrapp"/>

                    <h:outputText value="Statut :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.ecritures.lib_etat}"/>

                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="480" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitationComptabilite.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="modalpanelAnalytique" width="1100" height="530" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelAnalytique}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelAnalytique}" var="anal1">
            <f:facet name="header"><h:outputText value="IMPUTATION ANALYTIQUE"/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.fermerAnalytique}" image="/images/close.gif" styleClass="hidelink" reRender="modalpanelAnalytique" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.modeConsultation}"/>
                </a4j:form>
            </f:facet>
            <jsp:include flush="true" page="../commun/analytiqueJournaux.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelRecherche" width="900" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.showModalPanelRecherche}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.showModalPanelRecherche}" var="rec">
            <f:facet name="header"><h:outputText value="LISTE DES #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.libelleRecherche}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.annulerRecherche}" image="/images/close.gif" styleClass="hidelink" reRender="panelRecherche,idDossier1,idDossier2,idMission1,idMission2,idChantier1,idChantier2,idParc1,idParc2,idAgent1,idAgent2,idProjet1,idProjet2"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableRecherche"  height="400px" width="100%" headerClass="headerTab" selectedClass="active-row" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.dataModelRecherche}" var="rec">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.selectionRecherche}" reRender="idValSelectObjet"/>
                        <rich:column  width="20%" >
                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                            <h:outputText value="#{rec.code}"/>
                        </rich:column>
                        <rich:column  width="80%"  >
                            <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                            <h:outputText value="#{rec.nom_FR}" />
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br><br>
                <center>
                    <h:panelGroup id="idValSelectObjet">
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.valideRecherche}" image="/images/valider_big.png" styleClass="hidelink" reRender="panelRecherche,idDossier1,idDossier2,idMission1,idMission2,idChantier1,idChantier2,idParc1,idParc2,idAgent1,idAgent2,idProjet1,idProjet2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formAnalytique.selectObjet}"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelDossier" width="900" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelDossier}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.showModalPanelDossier}" var="dos">
            <f:facet name="header"><h:outputText value="LISTE DES DOSSIERS TRANSITS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.annuleDossier}" image="/images/close.gif" styleClass="hidelink" reRender="panelDossier,idDossier"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableDossier" height="400px" width="100%" headerClass="headerTab" selectedClass="active-row" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.datamodelDossier}" var="dos">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.selectionRecherche}" reRender="idValSelectDossier"/>
                        <rich:column label="Code" sortable="true" sortBy="#{dos.anaCode}" width="15%">
                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                            <h:outputText value="#{dos.anaCode}"/>
                        </rich:column>
                        <rich:column label="Libellé du dossier" sortable="true" sortBy="#{dos.anaNomFr}" width="55%">
                            <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                            <h:outputText value="#{dos.anaNomFr}"/>
                        </rich:column>
                        <rich:column label="Type" sortable="true" sortBy="#{dos.lib_dossier}" width="10%">
                            <f:facet name="header"><h:outputText  value="Type" /></f:facet>
                            <h:outputText value="#{dos.lib_dossier}"/>
                        </rich:column>
                        <rich:column label="Devise" sortable="true" sortBy="#{dos.anaTypeDevise}" width="10%">
                            <f:facet name="header"><h:outputText  value="Devise" /></f:facet>
                            <h:outputText value="#{dos.anaTypeDevise}"/>
                        </rich:column>
                        <rich:column label="Année" sortable="true" sortBy="#{dos.anaAnnee}" width="10%">
                            <f:facet name="header"><h:outputText  value="Année" /></f:facet>
                            <h:outputText value="#{dos.anaAnnee}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br><br>
                <center>
                    <h:panelGroup id="idValSelectDossier">
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.valideDossier}" image="/images/valider_big.png" styleClass="hidelink" reRender="panelDossier,idDossier"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>

