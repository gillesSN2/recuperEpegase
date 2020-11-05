<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="fmrextraitCpte">

    <center> <h2><h:outputText id="pgextrait" value="EXTRAIT DE COMPTE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.planComptable.plcCompte} - #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.planComptable.plcLibelleCpteFR}" styleClass="titre"/></h2></center>

    <a4j:form id="formPrinc">
        <rich:hotKey key="return" handler="return true;"/>

        <h:panelGrid style="border:1px solid black;background-color:#FFFFFF;height:130px;" id="firstPanel" width="100%" columns="2" columnClasses="clos20,clos80">

            <h:panelGrid width="100%" cellpadding="0" cellspacing="0">
                <h:panelGrid id="panelgrp" width="100%" columns="6" style="text-align:center;">
                    <a4j:commandButton title="Premier compte" image="/images/premier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.chargerFirst}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="tableExtrait,mvts,selection,pgextrait,select,lettre,panelgrp,fermer,modAttente,scrollTable" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.testequilibre}"/>
                    <a4j:commandButton title="Compte précédent" image="/images/precedent.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.chargerPrevious}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="tableExtrait,mvts,selection,pgextrait,select,lettre,panelgrp,fermer,modAttente,scrollTable" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.testequilibre}"/>
                    <a4j:commandButton title="Recherche compte"image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.trouverCompte}" reRender="panelExtrait"/>
                    <a4j:commandButton title="Compte suivant"  image="/images/suivant.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.chargerNext}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="tableExtrait,mvts,selection,pgextrait,select,lettre,panelgrp,fermer,modAttente,scrollTable" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.testequilibre}"/>
                    <a4j:commandButton title="Dernier compte" image="/images/dernier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.chargerLast}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="tableExtrait,mvts,selection,pgextrait,select,lettre,panelgrp,fermer,modAttente,scrollTable" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.testequilibre}"/>
                    <a4j:commandButton title="Imprime extrait" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                    <a4j:commandButton title="Graphe extrait" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.initGrapheur}" reRender="panelGraph,formModalGraph,container"/>
                    <a4j:commandButton title="Modification/Visualisation pièce" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.visualisationPiece}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="idSubView,modAttente"/>
                    <a4j:commandButton title="Accès au journal" image="/images/brouillard.png"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.affichageAccesJr&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.accesJournauxExtraitCompte}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="idSubView,modAttente"/>
                    <h:commandButton title="Interchange écriture" image="/images/parametre.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.testAffOutilsCorr}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.interchangeEcritures}" style="text-decoration:none;" styleClass="BoutonLnk" onclick="if (!confirm('Etes-vous sur de vouloir effectuer un inter-change des écritures?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
                    <a4j:commandButton title="Informations sur l'écriture" image="/images/info.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.informationPiece}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.var_affiche_bouton}" reRender="panelInformation"/>
                    <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png"  style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
                </h:panelGrid>
                <h:panelGrid id="filtrePage" width="100%">
                    <h:selectOneMenu  id="filtrecb" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.filtrage}" title="Filtre écritures" style="width:100%">
                        <f:selectItem itemLabel="Toutes les écritures" itemValue="0"/>
                        <f:selectItem itemLabel="Ecritures non lettrées" itemValue="1"/>
                        <f:selectItem itemLabel="Ecritures lettrées" itemValue="2"/>
                        <f:selectItem itemLabel="Ecritures non pointées" itemValue="3"/>
                        <f:selectItem itemLabel="Ecritures pointées" itemValue="4"/>
                        <f:selectItem itemLabel="Ecritures non lettrées et non pointées" itemValue="5"/>
                        <f:selectItem itemLabel="Ecritures lettrées et pointées" itemValue="6"/>
                        <a4j:support eventsQueue="maQueue"  event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.chargerEcritures}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" reRender="tableExtrait,mvts,selection,pgextrait,select,lettre,panelgrp,fermer,modAttente,scrollTable"/>
                    </h:selectOneMenu>
                </h:panelGrid>
                <h:panelGrid id="select" columns="3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                    <a4j:commandButton value="Point." style="width:95px" title="Pointage des écritures sélectionnées" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.selectionPointage}" reRender="panelPointage" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.testdeliste}"/>
                    <h:commandButton value="Tout sélec." style="width:95px" title="Sélectionne toutes les écritures de la liste" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.toutSelectionner}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.testdeliste}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    <h:commandButton value="Rien sélec." style="width:95px" title="Dé-sélectionne toutes les écritures de la liste" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.toutDeSelectionner}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.testdeliste}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </h:panelGrid>
                <h:panelGrid id="lettre" columns="3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                    <h:commandButton value="Lettrage" style="width:95px" title="Lettrage des écritures sélectionnées" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.exoselectionne.execptEtatAnterieur==0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.exoselectionne.execptEtatAnterieur==2)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.verifierSelection}" onclick="javascript:Richfaces.showModalPanel('modAttente');" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.testdeliste}"/>
                    <a4j:commandButton value="Filtre" style="width:95px" title="Filtre" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.testdeliste}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ouvrirFiltre}" reRender="panelFiltre"/>
                    <a4j:commandButton value="Délettrage" style="width:95px" title="Dé-lettrage des écritures sélectionnées" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.exoselectionne.execptEtatAnterieur==0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.exoselectionne.execptEtatAnterieur==2)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.testdeliste}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ouvrirDelettrage}" reRender="panelDelettrage"/>
                    <h:outputText value="La cloture antérieure est provisoire!" style="color:red;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.exoselectionne.execptEtatAnterieur==1}"/>
                </h:panelGrid>
            </h:panelGrid>

            <h:panelGrid width="100%" id="filtre">
                <h:panelGrid width="100%" id="periode">
                    <h:panelGrid width="100%" style="border:1px solid black;height:20px;text-align:center;font-weight:bold">
                        <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.periode}" /></h:column>
                    </h:panelGrid>
                </h:panelGrid>

                <h:panelGrid width="100%" columns="2" columnClasses="clos50d,clos50d">

                    <h:panelGrid width="100%" columns="3" style="border:1px solid black;height:145px;" id="selection" columnClasses="clos30,clos35,clos35">
                        <h:panelGrid  headerClass="headerTab" style="margin-top:-2px;" width="100%">
                            <f:facet name="header"><h:outputText  value="SELECTION"/></f:facet>
                            <h:column><h:inputText value="Lettrées: " readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.lettreCumul}" style="color:green" id="l" /></h:column>
                            <h:column><h:inputText value="Non lettrées:" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                            <h:column><h:inputText value="Sélectionnées:" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                            <h:column><h:inputText value="Solde:" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" style="margin-top:-2px" width="100%">
                            <f:facet name="header"><h:outputText  value="DEBIT"/></f:facet>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecrDebitL}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecrDebitNL}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecrDebitS}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.soldeDebitS}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" style="margin-top:-2px" width="100%">
                            <f:facet name="header"><h:outputText  value="CREDIT"/></f:facet>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecrCreditL}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecrCreditNL}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecrCreditS}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.soldeCreditS}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>

                    <h:panelGrid width="100%" columns="3" style="border:1px solid black;height:145px;" id="mvts" columnClasses="clos30,clos35,clos35">
                        <h:panelGrid  headerClass="headerTab" style="margin-top:-2px;" width="100%">
                            <f:facet name="header"><h:outputText  value="MVTS"/></f:facet>
                            <h:column><h:inputText value="Total:" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                            <h:column><h:inputText value="Solde:" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                            <h:column><a4j:commandButton value="Lettre dispo. :" id="idLettredispo" title="Sélectionne lettre en cours" style="height:50px;width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.testdeliste}"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ouvrirLettre}" reRender="panelLettrage"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" style="margin-top:-2px" width="100%">
                            <f:facet name="header"><h:outputText  value="DEBIT"/></f:facet>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.tmouvDeb}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.solDebit}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.lettrModal}" readonly="true" style="height:42px;width:100%;text-align:center;"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" style="margin-top:-2px" width="100%">
                            <f:facet name="header"><h:outputText  value="CREDIT"/></f:facet>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.tmouvCred}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.solCredit}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.var_erreur_lettrage}" readonly="true" style="height:42px;width:100%;text-align:center;color:red"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>

                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>
        <br>
        <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.pageIndex}" reRender="tableExtrait" id="scrollTable" maxPages="20" align="left" for="tableExtrait"/>
                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.var_nb_max}" border="0" width="140%" styleClass="bg" noDataLabel=" " headerClass="headerTab" style="max-height:100%;border:solid 0px green;" id="tableExtrait" selectedClass="active-row" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.dataModelEcritures}"  var="table" rowClasses="rows1,rows2,rowsd" sortMode="single" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.configListeEntete}">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.selectionLigne}" reRender="panelgrp,selection,lettre,fermer,mvts"/>
                    <rich:column id="c1" width="80px" sortable="true" sortBy="#{table.ecrCode}" label="Journal">
                        <f:facet name="header"><h:outputText  value="Jr." /></f:facet>
                        <h:outputText value="#{table.ecrCode}" style="#{table.gras}" title="#{table.ecrCode}"/>
                    </rich:column>
                    <rich:column id="c2" width="80px" sortable="true" sortBy="#{table.ecrDateSaisie}" label="Date de saisie">
                        <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                        <h:outputText value="#{table.ecrDateSaisie}" style="#{table.gras}">
                            <f:convertDateTime pattern="dd/MM/yy"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column id="c3" width="110px" sortable="true" sortBy="#{table.ecrCompte}" label="N° compte">
                        <f:facet name="header"><h:outputText  value="Compte"/></f:facet>
                        <h:outputText value="#{table.ecrCompte}" style="#{table.gras}" title="#{table.ecrCompte}"/>
                    </rich:column>
                    <rich:column id="c4" width="100px" sortable="true" sortBy="#{table.ecrPiece}" label="N° Pièce">
                        <f:facet name="header"><h:outputText value="Pièce" /></f:facet>
                        <h:outputText value="#{table.ecrPiece}" style="#{table.gras}" title="#{table.ecrPiece}"/>
                    </rich:column>
                    <rich:column id="c5" width="100px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.optionComptabilite.testRef1Piece}" sortable="true" sortBy="#{table.ecrReference1}" label="Référence 1">
                        <f:facet name="header"><h:outputText  value="Réf.1"/></f:facet>
                        <h:outputText value="#{table.ecrReference1}" style="#{table.gras}" title="#{table.ecrReference1}"/>
                    </rich:column>
                    <rich:column id="c6" width="80px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.optionComptabilite.testRef2Piece}" sortable="true" sortBy="#{table.ecrReference2}" label="Référence 2">
                        <f:facet name="header"><h:outputText  value="Réf.2"/></f:facet>
                        <h:outputText value="#{table.ecrReference2}" style="#{table.gras}" title="#{table.ecrReference2}"/>
                    </rich:column>
                    <rich:column id="c16" width="80px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strDossier==3}" sortable="true" sortBy="#{table.ecrDossier}" label="Dossier Transit">
                        <f:facet name="header"><h:outputText  value="Transit"/></f:facet>
                        <h:outputText value="#{table.ecrDossier}" style="#{table.gras}" title="#{table.ecrDossier}"/>
                    </rich:column>
                    <rich:column id="c7" width="50px"  sortable="true" sortBy="#{table.sel_ecriture}" label="Sélection des écritures (lettrage ou impression)">
                        <f:facet name="header"><h:outputText  value="Sel."/></f:facet>
                        <h:selectBooleanCheckbox value="#{table.sel_ecriture}" style="#{table.gras}" rendered="#{table.ecrCode!='XX'}">
                            <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.calculeSelectionLight}" reRender="selection"/>
                        </h:selectBooleanCheckbox>
                    </rich:column>
                    <rich:column id="c8" width="50px" sortable="true" sortBy="#{table.ecrLettrage}" label="Lettrage">
                        <f:facet name="header"><h:outputText  value="L."/></f:facet>
                        <h:outputText value="#{table.ecrLettrage}" style="#{table.gras}"/>
                    </rich:column>
                    <rich:column id="c9" width="50px" sortable="true" sortBy="#{table.ecrPointage}" label="Pointage">
                        <f:facet name="header"><h:outputText  value="P."/></f:facet>
                        <h:outputText value="#{table.erreurLettrage}" style="#{table.gras};color:red;"/>
                        <h:outputText value="#{table.ecrPointage}" style="#{table.gras}"/>
                    </rich:column>
                    <rich:column id="c15" width="50px" sortable="true" sortBy="#{table.ecrPj}" label="PJ" style="text-align:center">
                        <f:facet name="header"><h:outputText  value="Pj"/></f:facet>
                        <a4j:commandButton eventsQueue="maQueue" immediate="true" title="Visualisation pièce scannée" image="/images/mail_pj.png" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ouvrirPjConsultation}" reRender="panelPJ,formPJ" rendered="#{table.ecrPj}"/>
                    </rich:column>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.planComptable.plcNature==6||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.planComptable.plcNature==7}">
                        <rich:column id="c10" width="80px" sortable="true" sortBy="#{table.ecrDateEcheance}" label="Date d'échéance">
                            <f:facet name="header"><h:outputText  value="Eché." /></f:facet>
                            <h:outputText value="#{table.ecrDateEcheance}" style="#{table.gras}">
                                <f:convertDateTime pattern="dd/MM/yy"/>
                            </h:outputText>
                        </rich:column>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.planComptable.plcNature==10||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.planComptable.plcNature==11}">
                        <rich:column id="c11" width="80px" sortable="true" sortBy="#{table.ecrDateValeurTheo}"label="Date de valeur">
                            <f:facet name="header"><h:outputText value="Valeur" /> </f:facet>
                            <h:outputText value="#{table.ecrDateValeurTheo}" style="#{table.gras}">
                                <f:convertDateTime pattern="dd/MM/yy"/>
                            </h:outputText>
                        </rich:column>
                    </c:if>
                    <rich:column id="c12" width="100px" style="text-align:right;" sortable="true" sortBy="#{table.ecrDebitPays}" label="Débit">
                        <f:facet name="header"><h:outputText  value="Débit" /></f:facet>
                        <h:outputText value="#{table.ecrDebitPays}" rendered="#{table.ecrDebitPays!=0}" style="#{table.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column id="c13" width="100px"  style="text-align:right;" sortable="true" sortBy="#{table.ecrCreditPays}"label="Crédit">
                        <f:facet name="header"><h:outputText  value="Crédit" /></f:facet>
                        <h:outputText value="#{table.ecrCreditPays}" rendered="#{table.ecrCreditPays!=0}" style="#{table.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column width="50px" style="text-align:center;">
                        <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/detail.png" style="width:14px;height:14px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ouvrirDetailsAnalytique}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,modalpanelAnalytique,formAnal,modalpanelAnalRecup,formAnalRecup" rendered="#{table.ecrAnaActif==1&&table.erreurAnalytique==false}" ></a4j:commandButton>
                        <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/detail_alerte.png" style="width:14px;height:14px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.modifierDetailsAnalytique}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,modalpanelAnalytique,formAnal,modalpanelAnalRecup,formAnalRecup" rendered="#{table.ecrAnaActif==1&&table.erreurAnalytique==true}" ></a4j:commandButton>
                    </rich:column>
                    <rich:column id="c14" width="200px" sortable="true" sortBy="#{table.ecrLibelle}" label="Libellé">
                        <f:facet name="header"><h:outputText value="Libellé" /></f:facet>
                        <h:outputText value="#{table.ecrLibelle}" style="#{table.gras}" title="#{table.ecrLibelle}"/>
                    </rich:column>
                    <rich:column label="Budget Trésorerie ou imputation de trésoreie" width="80px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.optionComptabilite.tresorerie=='true'}" sortable="true" sortBy="#{table.ecrTreso} #{table.ecrPosteTreso} #{table.ecrBudgetTreso}">
                        <f:facet name="header"><h:outputText  value="Poste/Budget"/></f:facet>
                        <h:outputText value="#{table.ecrPosteTreso} #{table.ecrBudgetTreso}" style="color:#{table.couleur}" rendered="#{table.ecrPosteTreso!=null}"/>
                        <h:outputText value="#{table.ecrTreso}" style="color:#{table.couleur}" rendered="#{table.ecrTreso!=null}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </div>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelExtrait" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="800" height="430" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalFind}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalFind}" var="ext">
            <f:facet name="header"><h:outputText value="Recherche N° Compte"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.annuleRecherche}" id="idCancelRec" image="/images/close.gif" styleClass="hidelink" reRender="panelExtrait,filtre,tableExtrait,scrollTable"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCancelRec')}.click()" />
                </a4j:form >
            </f:facet>
            <a4j:form id="formextrait">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel id="richpsupp"  style="width:100%;border:0px;">
                    <h:panelGrid border="0" columns="4" id="pgrd1"  width="100%" columnClasses="clos25,clos25g,clos25,clos25g">
                        <h:column><h:outputText  style="text-decoration:underline;" value="Numéro de Compte:"/></h:column>
                        <h:column>
                            <h:inputText id="compteId" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.inputnum}" onkeypress="return scanToucheLettre(event)">
                                <rich:toolTip id="toolcpt" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un numéro de compte ou d'un libellé de compte" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.recherchePlanComptable}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="idSubView,panCtrl,pgrd1,panelListePlanComptable,formModalListePlanComptable,compteId"/>
                            </h:inputText>
                        </h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column><h:outputText value="Période du:" /></h:column>
                        <h:column><rich:calendar style=" background-color:white;" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.dateDebut}"  enableManualInput="true" datePattern="dd/MM/yyyy"  inputSize="17" /></h:column>
                        <h:column><h:outputText value="Au:"/></h:column>
                        <h:column><rich:calendar style=" background-color:white;" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.dateFin}"  enableManualInput="true" datePattern="dd/MM/yyyy"  inputSize="17" /></h:column>
                        <h:column><h:outputText value="Numéro de pièce:" /></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.piece}" /></h:column>
                        <h:column><h:outputText value="Lettrage:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.lettrage}"/></h:column>
                        <h:column><h:outputText value="Journal (jr1:jr2:jrxx):"/></h:column>
                        <h:column><h:inputText id="idJournaux" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.journal}" readonly="true" disabled="true"/></h:column>
                        <h:column><h:outputText value="Liste journaux:"/></h:column>
                        <a4j:commandButton  value="Liste des journaux" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.listeJournaux}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelJournaux" style="width:90%"/>
                        <h:column><h:outputText value="Nature Journal (nat1:nat2:natxx):"/></h:column>
                        <h:column><h:inputText id="idNature" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.natureJournal}" readonly="true" disabled="true"/></h:column>
                        <h:column><h:outputText value="Liste natures:"/></h:column>
                        <a4j:commandButton  value="Liste des natures" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.listeNature}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelNature"  style="width:90%"/>
                        <h:column><h:outputText value="Libellé:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.libEC}"/></h:column>
                        <h:column><h:outputText value="Référence 1:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ref1}"/></h:column>
                        <h:column><h:outputText value="Référence 2:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ref2}"/></h:column>
                        <h:column><h:outputText value="Pointage:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.pointage}"/></h:column>
                        <h:column><h:outputText value="Montant:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.montant}" style="text-align:right" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Analytique:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.analytique}"/></h:column>
                        <h:column><h:outputText value="Dossier:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.dossier}"/></h:column>
                    </h:panelGrid>
                    <br><br>
                    <h:panelGrid columns="2" id="pgrd2" width="100%" columnClasses="clos25,clos75" style="border:solid 1px green">
                        <h:column>
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.var_solde_ante}"/>
                        </h:column>
                        <h:column><h:outputText value="Affiche solde antérieur cumulé"/></h:column>
                        <h:column>
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.situationRech}"/>
                        </h:column>
                        <h:column><h:outputText value="Inclure journaux de situation"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}">
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.reserveRech}" />
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:outputText value="Inclure journaux privés"/></h:column>
                        <h:column><h:outputText value=" Filtre des écritures:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.filtrage}" >
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
                            <h:commandButton  image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.chargerEcritures}" id="idValRec" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            <rich:hotKey key="return" handler="#{rich:element('idValRec')}.click()" />
                        </center>
                    </h:panelGroup>
                </rich:panel>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelPointage" width="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelPointage}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelPointage}" var="poin">
            <f:facet name="header"><h:outputText value="Pointage"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.fermerPointage}" id="idCancelPointage" image="/images/close.gif" styleClass="hidelink" reRender="panelPointage"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCancelPointage')}.click()" />
                </a4j:form >
            </f:facet>
            <rich:panel id="richPointage" style="border:0px solid green;width:80%;height:80%;">
                <a4j:form  id="FormPoint">
                    <h:panelGrid border="0" columns="2" width="100%" style="text-align:left;">
                        <h:outputText value="Pointage:"/>
                        <h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.pointModal}" maxlength="10"/>
                    </h:panelGrid>
                    <br>
                    <center>
                        <h:panelGroup>
                            <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.pointerSelection}" id="idValPointage" reRender="tableExtrait,panelPointage,scrollTable"/>
                            <rich:hotKey key="return" handler="#{rich:element('idValPointage')}.click()" />
                        </h:panelGroup>
                    </center>
                </a4j:form>
                <br/>
            </rich:panel>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelLettrage" width="400" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelLettrage}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelLettrage}" var="lettr">
            <f:facet name="header"><h:outputText value="Lettrage"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.fermerLettrage}" id="idCancelLettrage" image="/images/close.gif" styleClass="hidelink" reRender="panelLettrage"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCancelLettrage')}.click()" />
                </a4j:form >
            </f:facet>
            <a4j:form  id="FormLettr">
                <h:panelGrid border="0" columns="2" width="100%" style="text-align:left;">
                    <h:outputText value="Lettrage"/>
                    <h:inputText id="idLettreSel" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.lettrModal}" maxlength="4">
                    </h:inputText>
                </h:panelGrid>
                <br>
                <center>
                    <a4j:commandButton value="Calcule prochaine lettre" title="Calcule prochaine lettre" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.calculerProchaineLettre}" reRender="idLettreSel"/>
                </center>
                <br/> <br/> <br/>
                <center>
                    <h:panelGroup id="pan">
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.valideLettre}" id="idValLettrage"/>
                        <rich:hotKey key="return" handler="#{rich:element('idValLettrage')}.click()" />
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelDelettrage" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="300" height="220" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelDelettrage}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelDelettrage}" var="poin">
            <f:facet name="header"><h:outputText value="Dé-lettrage" style="color:green;"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.fermerDelettrage}" id="idCancelDelettrage" image="/images/close.gif" styleClass="hidelink" reRender="panelDelettrage"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCancelDelettrage')}.click()" />
                </a4j:form >
            </f:facet>
            <a4j:form id="formModalDelet">
                <h:panelGrid  width="100%">
                    <h:selectOneRadio  id="format" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.delettre}" layout="pageDirection">
                        <f:selectItem itemLabel="La ligne en cours" itemValue="0" />
                        <f:selectItem itemLabel="Toutes lignes de la lettre sélectionnée" itemValue="1"/>
                        <f:selectItem itemLabel="Tout le compte avec toutes ses lettres" itemValue="2"/>
                    </h:selectOneRadio>
                </h:panelGrid>
                <br><br>
                <center>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.deLettrerSelection}" image="/images/valider_big.png" id="idValDelettrage" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelDelettrage,filtre,tableExtrait"/>
                    <rich:hotKey key="return" handler="#{rich:element('idValDelettrage')}.click()" />
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelFiltre" width="400" height="300" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalpanelFiltre}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalpanelFiltre}" var="extfil">
            <f:facet name="header"><h:outputText value="Filtrage des écritures"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.fermerFiltre}" id="idCancelFiltre" image="/images/close.gif" styleClass="hidelink"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCancelFiltre')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form  id="FormFiltre">
                <h:panelGrid border="0" columns="2" width="100%" style="text-align:left;">
                    <h:outputText value="Du:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.dateDu}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/>
                    <h:outputText value="Au:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.dateAu}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/>
                </h:panelGrid>
                <br/> <br/> <br/>
                <center>
                    <h:panelGroup>
                        <center>
                            <h:commandButton  image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.valideFiltre}" id="idValFiltre" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            <rich:hotKey key="return" handler="#{rich:element('idValFiltre')}.click()" />
                        </center>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelCompense" width="400" height="300" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelCompense}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelCompense}" var="extcom">
            <f:facet name="header"><h:outputText value="Compensation automatique"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.fermerSelection}" id="idCancelCompense" image="/images/close.gif" styleClass="hidelink"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCancelCompense')}.click()" />
                </a4j:form >
            </f:facet>
            <a4j:form  id="FormComp">
                <h:panelGrid border="0" columns="2" columnClasses="clos20,clos80" width="100%" style="text-align:left;">
                    <h:outputText value="Montant:"/>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.var_compense}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText value="Date:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.var_date_compense}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.var_aff_action}"/>
                    <h:outputText value="Compte:" style="text-decoration:underline;"/>
                    <h:inputText id="idCompteCompens" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.var_compte_compense}">
                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un numéro de compte ou d'un libellé de compte" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.rechercheCompteCompense}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panCtrl,pgrd1,panelListePlanComptable,formModalListePlanComptable,idCompteCompens"/>
                    </h:inputText>
                    <h:outputText value="Libellé:"/>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.var_libelle_compense}"/>
                </h:panelGrid>
                <br/> <br/> <br/>
                <center>
                    <h:panelGroup>
                        <center>
                            <h:commandButton  image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.lettrerSelection}" id="idValComp" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            <rich:hotKey key="return" handler="#{rich:element('idValComp')}.click()" />
                        </center>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="modalpanelAnalytique" width="1100" height="530" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelAnalytique}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelAnalytique}" var="anal1">
            <f:facet name="header"><h:outputText value="IMPUTATION ANALYTIQUE"/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.fermerAnalytique}" image="/images/close.gif" styleClass="hidelink" reRender="modalpanelAnalytique" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.formAnalytique.modeConsultation}"/>
                </a4j:form>
            </f:facet>
            <jsp:include flush="true" page="../commun/analytiqueExtraitCompte.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="350" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitationComptabilite.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.fermerGrapheur}" id="idCancelGraph" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCancelGraph')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.valQteGraph}" >
                                <f:selectItem itemLabel="En valeur" itemValue="0"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelPJ" width="900" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelPJ}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelPJ}" var="pie">
            <f:facet name="header"><h:outputText value="Pièce jointe"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.fermerPj}" image="/images/close.gif" styleClass="hidelink" reRender="panelPJ"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formPJ">
                <h:panelGrid width="100%">
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.typeFichier==0}" var="sc1">
                        <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.urlphotoProd}" width="100%" height="800px"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.typeFichier==1}" var="sc2">
                        <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.fichierMine}" width="100%" height="550">
                            <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.fichierUrl}"></a>
                        </object>
                    </c:if>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelInformation" width="600" height="160" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelInformation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelInformation}" var="inf">
            <f:facet name="header"><h:outputText value="INFORMATION SUR L'ECRITURE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.fermerInformationPiece}" image="/images/close.gif" styleClass="hidelink" reRender="panelInformation"/>
                </a4j:form >
            </f:facet>
            <a4j:form id="formLpr">
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos30,clos70">
                    <h:outputText value="ID écriture:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecritures.ecr_id}"/>
                    <h:outputText value="Date de création:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecritures.ecrDateCreat}" datePattern="dd/MM/yyyy hh:mm:ss"  locale="fr" style=" background-color:white;" inputSize="20" readonly="true" disabled="true"/>
                    <h:outputText value="Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.nomCreation} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecritures.ecrUserCreat})"/>
                    <h:outputText value="Modifié le:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecritures.ecrDateModif}" datePattern="dd/MM/yyyy hh:mm:ss"  locale="fr" style=" background-color:white;" inputSize="20"  readonly="true" disabled="true"/>
                    <h:outputText value="Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.nomModification} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecritures.ecrUserModif})"/>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelJournaux" width="800" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelJournaux}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelJournaux}" var="jrx">
            <f:facet name="header"><h:outputText value="Liste des journaux"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.fermerListeJournaux}" image="/images/close.gif" styleClass="hidelink" reRender="panelJournaux"/>
                </a4j:form >
            </f:facet>
            <h:panelGrid style="width:100%">
                <a4j:form>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableJrx" border="0" headerClass="headerTab" footerClass="bard" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.dataModelJournaux}" var="jrx">
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
                            <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.validerListeJournaux}" reRender="panelJournaux,idJournaux"/>
                        </h:panelGroup>
                    </center>
                </a4j:form>
                <br/>
            </h:panelGrid>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelNature" width="800" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelNature}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelNature}" var="nat">
            <f:facet name="header"><h:outputText value="Liste des natures de journaux"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.fermerListeNature}" image="/images/close.gif" styleClass="hidelink" reRender="panelNature"/>
                </a4j:form >
            </f:facet>
            <h:panelGrid style="width:100%">
                <a4j:form>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableNat" border="0" headerClass="headerTab" footerClass="bard" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.dataModelNature}" var="nat">
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
                            <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.validerListeNature}" reRender="panelNature,idNature"/>
                        </h:panelGroup>
                    </center>
                </a4j:form>
                <br/>
            </h:panelGrid>
        </c:if>
    </rich:modalPanel>

</f:subview>
