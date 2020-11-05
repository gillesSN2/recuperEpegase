<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="fmrextraitClas">

    <center> <h2><h:outputText id="pgextrait" value="EXTRAIT DE CLASSE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.inputnum}" styleClass="titre"/></h2></center>

    <a4j:form id="formPrinc" >

        <h:panelGrid style="border:1px solid black;background-color:#FFFFFF;height:130px;" id="firstPanel" width="100%" columns="2" columnClasses="clos20,clos80">

            <h:panelGrid width="100%" cellpadding="1" cellspacing="0">
                <h:panelGrid id="panelgrp" width="100%" columns="4" style="text-align:center;">
                    <a4j:commandButton title="Recherche classe"image="/images/rechercher.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.trouverCompte}" reRender="panelExtrait"/>
                    <a4j:commandButton title="Imprime extrait" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                    <a4j:commandButton title="Graphe extrait" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.initGrapheur}" reRender="panelGraph,formModalGraph,container"/>
                    <a4j:commandButton title="Modification/Visualisation pièce" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.visualisationPiece}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="idSubView,modAttente"/>
                    <a4j:commandButton title="Accès au journal" image="/images/brouillard.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.accesJournauxExtraitClasse}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="idSubView,modAttente"/>
                    <h:commandButton title="Interchange écriture" image="/images/parametre.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.testAffOutilsCorr}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.interchangeEcritures}" styleClass="BoutonLnk" onclick="if (!confirm('Etes-vous sur de vouloir effectuer un inter-change des écritures?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
                    <a4j:commandButton title="Informations sur l'écriture" image="/images/info.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.informationPiece}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.var_affiche_bouton}" reRender="panelInformation"/>
                    <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png"  style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
                </h:panelGrid>
                <h:panelGrid id="filtrePage" width="100%">
                    <h:selectOneMenu  id="filtrecb" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.filtrage}" title="Filtre écritures" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.testdeliste}">
                        <f:selectItem itemLabel="Toutes les écritures" itemValue="0"/>
                        <f:selectItem itemLabel="Ecritures non lettrées" itemValue="1"/>
                        <f:selectItem itemLabel="Ecritures lettrées" itemValue="2"/>
                        <f:selectItem itemLabel="Ecritures non pointées" itemValue="3"/>
                        <f:selectItem itemLabel="Ecritures pointées" itemValue="4"/>
                        <f:selectItem itemLabel="Ecritures non lettrées et non pointées" itemValue="5"/>
                        <f:selectItem itemLabel="Ecritures lettrées et pointées" itemValue="6"/>
                        <a4j:support eventsQueue="maQueue"  event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.chargerEcritures}" reRender="tableExtrait,mvts,selection,pgextrait,select,panelgrp,fermer,scrollTable" />
                    </h:selectOneMenu>
                </h:panelGrid>
                <h:panelGrid id="select" columns="2" width="100%" columnClasses="clos50,g,clos50g">
                    <a4j:commandButton value="Tout sélec." title="Sélectionne toutes les écritures de la liste" reRender="tableExtrait,selection,scrollTable" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.toutSelectionner}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.testdeliste}" style="width:100%"/>
                    <a4j:commandButton value="Rien sélec." title="Dé-sélectionne toutes les écritures de la liste" reRender="tableExtrait,selection,scrollTable" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.toutDeSelectionner}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.testdeliste}" style="width:100%"/>
                </h:panelGrid>              
            </h:panelGrid>

            <h:panelGrid width="100%" id="filtre">
                <h:panelGrid width="100%" id="periode">
                    <h:panelGrid width="100%" style="border:1px solid black;height:20px;text-align:center;font-weight:bold">
                        <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.periode}" /></h:column>
                    </h:panelGrid>
                </h:panelGrid>

                <h:panelGrid width="100%" columns="2" columnClasses="clos50d,clos50d">

                    <h:panelGrid width="100%" columns="3" style="border:1px solid black;height:130px;" id="selection" columnClasses="clos30,clos35,clos35">
                        <h:panelGrid  headerClass="headerTab" style="margin-top:-2px;" width="100%">
                            <f:facet name="header"><h:outputText  value="SELECTION"/></f:facet>
                            <h:column><h:inputText value="Lettrées: (" readonly="true" style="width:70%;text-align:right;background:transparent;border:0px;"/><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.lettreCumul}" style="color:green" id="l" /><h:outputText value=")" /></h:column>
                            <h:column><h:inputText value="Non lettrées:" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                            <h:column><h:inputText value="Sélectionnées:" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                            <h:column><h:inputText value="Solde:" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" style="margin-top:-2px" width="100%">
                            <f:facet name="header"><h:outputText  value="DEBIT"/></f:facet>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.ecrDebitL}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.ecrDebitNL}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.ecrDebitS}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.soldeDebitS}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" style="margin-top:-2px" width="100%">
                            <f:facet name="header"><h:outputText  value="CREDIT"/></f:facet>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.ecrCreditL}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.ecrCreditNL}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.ecrCreditS}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.soldeCreditS}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>

                    <h:panelGrid width="100%" columns="3" style="border:1px solid black;height:130px;" id="mvts" columnClasses="clos30,clos35,clos35">
                        <h:panelGrid  headerClass="headerTab" style="margin-top:-2px;" width="100%">
                            <f:facet name="header"><h:outputText  value="MVTS"/></f:facet>
                            <h:column><h:inputText value="Total:" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                            <h:column><h:inputText value="Solde:" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                            <h:column><h:inputText value="" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                            <h:column><h:inputText value="" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" style="margin-top:-2px" width="100%">
                            <f:facet name="header"><h:outputText  value="DEBIT"/></f:facet>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.tmouvDeb}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.solDebit}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:inputText value="" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                            <h:column><h:inputText value="" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" style="margin-top:-2px" width="100%">
                            <f:facet name="header"><h:outputText  value="CREDIT"/></f:facet>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.tmouvCred}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.solCredit}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:inputText value="" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                            <h:column><h:inputText value="" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>

                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>
        <br>
        <a4j:region renderRegionOnly="false">
            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.pageIndex}" reRender="tableExtrait" id="scrollTable" maxPages="20"align="left" for="tableExtrait"/>
            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.var_nb_max}" border="0" width="100%" noDataLabel=" " styleClass="bg" headerClass="headerTab" style="max-height:100%;border:solid 0px green;" id="tableExtrait" selectedClass="active-row" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.dataModelEcritures}" var="table" rowClasses="rows1,rows2,rowsd"sortMode="single" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.configListeEntete}">
                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.selectionEcriture}" reRender="modAttente,panelgrp"/>
                <rich:column width="4%"  sortable="true" sortBy="#{table.sel_ecriture}" label="Sélection pour impression">
                    <f:facet name="header"><h:outputText  value="Sel."/></f:facet>
                    <h:selectBooleanCheckbox value="#{table.sel_ecriture}">
                        <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.calculTotalSelectionCochee}" reRender="selection,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12"/>
                    </h:selectBooleanCheckbox>
                </rich:column>
                <rich:column id="c1" width="5%" sortable="true" sortBy="#{table.ecrCode}" label="Journal">
                    <f:facet name="header"><h:outputText  value="Jr." /></f:facet>
                    <h:outputText value="#{table.ecrCode}" title="#{table.ecrCode}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c2" width="7%" sortable="true" sortBy="#{table.ecrDateSaisie}" label="Date de saisie">
                    <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                    <h:outputText value="#{table.ecrDateSaisie}">
                        <f:convertDateTime pattern="dd/MM/yy"/>
                    </h:outputText>
                </rich:column>
                <rich:column id="c3" width="9%" sortable="true" sortBy="#{table.ecrCompte}" label="N° compte" >
                    <f:facet name="header"><h:outputText  value="Compte"  /></f:facet>
                    <h:outputText value="#{table.ecrCompte}" title="#{table.ecrCompte}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c4" width="9%" sortable="true" sortBy="#{table.ecrPiece}" label="N° Pièce">
                    <f:facet name="header"><h:outputText value="Pièce" /></f:facet>
                    <h:outputText value="#{table.ecrPiece}" title="#{table.ecrPiece}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c5" width="9%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.optionComptabilite.testRef1Piece}" sortable="true" sortBy="#{table.ecrReference1}" label="Référence 1">
                    <f:facet name="header"><h:outputText  value="Réf.1"/></f:facet>
                    <h:outputText value="#{table.ecrReference1}" title="#{table.ecrReference1}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c6" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.optionComptabilite.testRef2Piece}" sortable="true" sortBy="#{table.ecrReference2}" label="Référence 2">
                    <f:facet name="header"><h:outputText  value="Réf.2"/></f:facet>
                    <h:outputText value="#{table.ecrReference2}" title="#{table.ecrReference2}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c7" width="5%"  sortable="true" sortBy="#{table.ecrLettrage}" label="Lettrage">
                    <f:facet name="header"><h:outputText  value="L."/></f:facet>
                    <h:outputText value="#{table.ecrLettrage}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c8" width="4%" sortable="true" sortBy="#{table.ecrPointage}" label="Pointage">
                    <f:facet name="header"><h:outputText  value="P."/></f:facet>
                    <h:outputText value="#{table.ecrPointage}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c15" width="5%" sortable="true" sortBy="#{table.ecrPj}" label="PJ"  style="text-align:center">
                    <f:facet name="header"><h:outputText  value="Pj"/></f:facet>
                    <a4j:commandButton eventsQueue="maQueue" immediate="true" title="Visualisation pièce scannée" image="/images/mail_pj.png" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.ouvrirPjConsultation}" reRender="panelPJ,formPJ" rendered="#{table.ecrPj}"/>
                </rich:column>
                <rich:column id="c9" width="7%" sortable="true" sortBy="#{table.ecrDateEcheance}" label="Date d'échéance">
                    <f:facet name="header"><h:outputText  value="Eché." /></f:facet>
                    <h:outputText value="#{table.ecrDateEcheance}">
                        <f:convertDateTime pattern="dd/MM/yy"/>
                    </h:outputText>
                </rich:column>
                <rich:column id="c10" width="10%" style="text-align:right;" sortable="true" sortBy="#{table.ecrDebitPays}" label="Débit">
                    <f:facet name="header"><h:outputText  value="Débit" /></f:facet>
                    <h:outputText   value="#{table.ecrDebitPays}" rendered="#{table.ecrDebitPays!=0}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column id="c11" width="10%"  style="text-align:right;" sortable="true" sortBy="#{table.ecrCreditPays}"label="Crédit">
                    <f:facet name="header"><h:outputText  value="Crédit" /></f:facet>
                    <h:outputText value="#{table.ecrCreditPays}" rendered="#{table.ecrCreditPays!=0}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column width="4%" style="text-align:center;" label="Analytique">
                    <a4j:commandButton eventsQueue="maQueue" image="/images/detail.png" style="width:14px;height:14px;" immediate="true" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.gestionAnalytique}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView" rendered="#{table.ecrAnaActif==1&&table.erreurAnalytique==false}" ></a4j:commandButton>
                    <a4j:commandButton eventsQueue="maQueue" image="/images/detail_alerte.png" style="width:14px;height:14px;" immediate="true" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.gestionAnalytique}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView" rendered="#{table.ecrAnaActif==1&&table.erreurAnalytique==true}" ></a4j:commandButton>
                </rich:column>
                <rich:column id="c12" width="20%" sortable="true" sortBy="#{table.ecrLibelle}" label="Libellé">
                    <f:facet name="header"><h:outputText value="Libellé" /></f:facet>
                    <h:outputText value="#{table.ecrLibelle}" title="#{table.ecrLibelle}">
                    </h:outputText>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelExtrait" headerClass="headerPanel" styleClass="bg" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="800" height="400"  showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.showModalFind}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.showModalFind}" var="mdp">
            <f:facet name="header"><h:outputText value="Recherche N° Classe"/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton image="/images/close.gif" styleClass="hidelink" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.annuleRecherche}" id="idCancelRec" reRender="panelExtrait,filtre,tableExtrait,scrollTable" style="text-decoration:none;"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCancelRec')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form  id="Form" >
                <rich:panel id="richpsupp"  style="width:100%;border:0px;">
                    <h:panelGrid border="0" columns="4" id="pgrd1"  width="100%" columnClasses="clos25,clos25g,clos25,clos25g">
                        <h:column><h:outputText value="Classe:"/></h:column>
                        <h:column><h:inputText id="cpte" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.inputnum}"/></h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column><h:outputText value="Période du:" /></h:column>
                        <h:column><rich:calendar style=" background-color:white;" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.dateDebut}"  enableManualInput="true" datePattern="dd/MM/yyyy"  inputSize="17" /></h:column>
                        <h:column><h:outputText value="Au:"/></h:column>
                        <h:column><rich:calendar style=" background-color:white;" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.dateFin}"  enableManualInput="true" datePattern="dd/MM/yyyy"  inputSize="17" /></h:column>
                        <h:column><h:outputText value="Numéro de pièce:" /></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.piece}" /></h:column>
                        <h:column><h:outputText value="Lettrage:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.lettrage}"/></h:column>
                        <h:column><h:outputText value="Journal (jr1:jr2:jrxx):"/></h:column>
                        <h:column><h:inputText id="idJournaux" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.journal}" readonly="true" disabled="true"/></h:column>
                        <h:column><h:outputText value="Liste journaux:"/></h:column>
                        <a4j:commandButton  value="Liste des journaux" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.listeJournaux}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelJournaux" style="width:90%"/>
                        <h:column><h:outputText value="Nature Journal (nat1:nat2:natxx):"/></h:column>
                        <h:column><h:inputText id="idNature" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.natureJournal}" readonly="true" disabled="true"/></h:column>
                        <h:column><h:outputText value="Liste natures:"/></h:column>
                        <a4j:commandButton  value="Liste des natures" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.listeNature}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelNature"  style="width:90%"/>
                        <h:column><h:outputText value="Libellé:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.libEC}"/></h:column>
                        <h:column><h:outputText value="Référence 1:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.ref1}"/></h:column>
                        <h:column><h:outputText value="Référence 2:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.ref2}"/></h:column>
                        <h:column><h:outputText value="Pointage:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.pointage}"/></h:column>
                        <h:column><h:outputText value="Montant:" /></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.montant}" style="text-align:right" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Analytique:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.analytique}"/></h:column>
                        <h:column><h:outputText value="Dossier:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.dossier}"/></h:column>
                    </h:panelGrid>
                    <br><br>
                    <h:panelGrid columns="2" id="pgrd2" width="100%" columnClasses="clos25,clos75" style="border:solid 0px black">
                        <h:column>
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.situationRech}"/>
                        </h:column>
                        <h:column><h:outputText value="Inclure journaux de situation"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}">
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.reserveRech}" />
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:outputText value="Inclure journaux privés"/></h:column>
                        <h:column><h:outputText value=" Filtre des écritures:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.filtrage}" >
                                <f:selectItem itemLabel="Toutes les écritures" itemValue="0"/>
                                <f:selectItem itemLabel="Ecritures non lettrées" itemValue="1"/>
                                <f:selectItem itemLabel="Ecritures lettrées" itemValue="2"/>
                                <f:selectItem itemLabel="Ecritures non pointées" itemValue="3"/>
                                <f:selectItem itemLabel="Ecritures pointées" itemValue="4"/>
                                <f:selectItem itemLabel="Ecritures non lettrées et non pointées" itemValue="5"/>
                                <f:selectItem itemLabel="Ecritures lettrées et pointées" itemValue="6"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <br/>
                    <h:panelGroup id="buttFind">
                        <center>
                            <h:commandButton  image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.chargerEcritures}" id="idValRec" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            <rich:hotKey key="return" handler="#{rich:element('idValRec')}.click()" />
                        </center>
                    </h:panelGroup>
                </rich:panel>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="350" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitationComptabilite.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.fermerGrapheur}" id="idCancelGraph" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCancelGraph')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.valQteGraph}" >
                                <f:selectItem itemLabel="En valeur" itemValue="0"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <f:selectItem itemLabel="par compte" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelPJ" width="900" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.showModalPanelPJ}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.showModalPanelPJ}" var="pie">
            <f:facet name="header"><h:outputText value="Pièce jointe"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.fermerPj}" image="/images/close.gif" styleClass="hidelink" reRender="panelPJ"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formPJ">
                <h:panelGrid width="100%">
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.typeFichier==0}" var="sc1">
                        <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.urlphotoProd}" width="100%" height="800px"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.typeFichier==1}" var="sc2">
                        <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.fichierMine}" width="100%" height="550">
                            <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.fichierUrl}"></a>
                        </object>
                    </c:if>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelInformation" width="600" height="160" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.showModalPanelInformation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.showModalPanelInformation}" var="inf">
            <f:facet name="header"><h:outputText value="INFORMATION SUR L'ECRITURE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.fermerInformationPiece}" image="/images/close.gif" styleClass="hidelink" reRender="panelInformation"/>
                </a4j:form >
            </f:facet>
            <a4j:form id="formLpr">
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos30,clos70">
                    <h:outputText value="ID écriture:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.ecritures.ecr_id}"/>
                    <h:outputText value="Date de création:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.ecritures.ecrDateCreat}" datePattern="dd/MM/yyyy hh:mm:ss"  locale="fr" style=" background-color:white;" inputSize="20" readonly="true" disabled="true"/>
                    <h:outputText value="Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.nomCreation} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.ecritures.ecrUserCreat})"/>
                    <h:outputText value="Modifié le:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.ecritures.ecrDateModif}" datePattern="dd/MM/yyyy hh:mm:ss"  locale="fr" style=" background-color:white;" inputSize="20"  readonly="true" disabled="true"/>
                    <h:outputText value="Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.nomModification} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.ecritures.ecrUserModif})"/>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelJournaux" width="800" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.showModalPanelJournaux}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.showModalPanelJournaux}" var="jrx">
            <f:facet name="header"><h:outputText value="Liste des journaux"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.fermerListeJournaux}" image="/images/close.gif" styleClass="hidelink" reRender="panelJournaux"/>
                </a4j:form >
            </f:facet>
            <h:panelGrid style="width:100%">
                <a4j:form>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableJrx" border="0" headerClass="headerTab" footerClass="bard" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.dataModelJournaux}" var="jrx">
                             <rich:column  width="10%" sortable="true" sortBy="#{jrx.select}">
                                <f:facet name="header"><h:outputText  value="Sel."/></f:facet>
                                <h:selectBooleanCheckbox value="#{jrx.select}"/>
                            </rich:column>
                            <rich:column  width="20%" sortable="true" sortBy="#{jrx.pljCode}">
                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                <h:outputText value="#{jrx.pljCode}"/>
                            </rich:column>
                            <rich:column  width="40%" sortable="true" sortBy="#{jrx.pljLibelleFr}">
                                <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                <h:outputText  value="#{jrx.pljLibelleFr}"/>
                            </rich:column>
                            <rich:column  width="30%" sortable="true" sortBy="#{jrx.libNature}" >
                                <f:facet name="header"><h:outputText value="Nature"/></f:facet>
                                <h:outputText value="#{jrx.libNature}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <center>
                        <h:panelGroup>
                            <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.validerListeJournaux}" reRender="panelJournaux,idJournaux"/>
                        </h:panelGroup>
                    </center>
                </a4j:form>
                <br/>
            </h:panelGrid>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelNature" width="800" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.showModalPanelNature}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.showModalPanelNature}" var="nat">
            <f:facet name="header"><h:outputText value="Liste des natures de journaux"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.fermerListeNature}" image="/images/close.gif" styleClass="hidelink" reRender="panelNature"/>
                </a4j:form >
            </f:facet>
            <h:panelGrid style="width:100%">
                <a4j:form>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableNat" border="0" headerClass="headerTab" footerClass="bard" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.dataModelNature}" var="nat">
                             <rich:column  width="10%" sortable="true" sortBy="#{nat.valide}">
                                <f:facet name="header"><h:outputText  value="Sel."/></f:facet>
                                <h:selectBooleanCheckbox value="#{nat.valide}"/>
                            </rich:column>
                            <rich:column  width="20%" sortable="true" sortBy="#{nat.code}">
                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                <h:outputText value="#{nat.code}"/>
                            </rich:column>
                            <rich:column  width="40%" sortable="true" sortBy="#{nat.nom_FR}">
                                <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                <h:outputText  value="#{nat.nom_FR}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <center>
                        <h:panelGroup>
                            <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.validerListeNature}" reRender="panelNature,idNature"/>
                        </h:panelGroup>
                    </center>
                </a4j:form>
                <br/>
            </h:panelGrid>
        </c:if>
    </rich:modalPanel>


</f:subview>
