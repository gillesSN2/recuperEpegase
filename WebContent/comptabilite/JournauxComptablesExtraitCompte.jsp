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

    <center> <h2><h:outputText id="pgextrait" value="EXTRAIT DE COMPTE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.planComptable.plcCompte} - #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.planComptable.plcLibelleCpteFR}" styleClass="titre"/></h2></center>

    <a4j:form id="formPrinc">

        <h:panelGrid style="border:1px solid black;background-color:#FFFFFF;height:130px;" id="firstPanel" width="100%" columns="2" columnClasses="clos20,clos80">

            <h:panelGrid width="100%" cellpadding="0" cellspacing="0">
                <h:panelGrid id="panelgrp" width="100%" columns="3" style="text-align:center;">
                    <a4j:commandButton title="Imprime extrait" image="/images/print.png" style="width:20px;height:19px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.initImpression}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                    <a4j:commandButton title="Graphe extrait" image="/images/grapheur.png" style="width:20px;height:19px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.initGrapheur}" reRender="panelGraph,formModalGraph,container"/>
                    <h:commandButton value="RETOUR JOURNAL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.fermerJournauxExtrait}" styleClass="fermer" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </h:panelGrid>
                <h:panelGrid id="filtrePage" width="100%">
                    <h:selectOneMenu  id="filtrecb" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.filtrage}" title="Filtre écritures" style="width:100%">
                        <f:selectItem itemLabel="Toutes les écritures" itemValue="0"/>
                        <f:selectItem itemLabel="Ecritures non lettrées" itemValue="1"/>
                        <f:selectItem itemLabel="Ecritures lettrées" itemValue="2"/>
                        <f:selectItem itemLabel="Ecritures non pointées" itemValue="3"/>
                        <f:selectItem itemLabel="Ecritures pointées" itemValue="4"/>
                        <f:selectItem itemLabel="Ecritures non lettrées et non pointées" itemValue="5"/>
                        <f:selectItem itemLabel="Ecritures lettrées et pointées" itemValue="6"/>
                        <a4j:support eventsQueue="maQueue"  event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.chargerEcritures}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" reRender="tableExtrait,mvts,selection,pgextrait,select,lettre,panelgrp,fermer,modAttente,scrollTable"/>
                    </h:selectOneMenu>
                </h:panelGrid>
                <h:panelGrid id="select" columns="3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                    <a4j:commandButton value="Point." style="width:95px" title="Pointage des écritures sélectionnées" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.selectionPointage}" oncomplete="javascript:Richfaces.showModalPanel('panelPointage');" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.testdeliste}"/>
                    <h:commandButton value="Tout sélec." style="width:95px" title="Sélectionne toutes les écritures de la liste" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.toutSelectionner}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.testdeliste}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    <h:commandButton value="Rien sélec." style="width:95px" title="Dé-sélectionne toutes les écritures de la liste" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.toutDeSelectionner}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.testdeliste}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </h:panelGrid>
                <h:panelGrid id="lettre" columns="3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                    <h:commandButton value="Lettrage" style="width:95px" title="Lettrage des écritures sélectionnées" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.exoselectionne.execptEtatAnterieur==0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.exoselectionne.execptEtatAnterieur==2)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.verifierSelection}" onclick="javascript:Richfaces.showModalPanel('modAttente');" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.testdeliste}"/>
                    <h:commandButton value="Filtre" style="width:95px" title="Filtre" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.testdeliste}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.ouvrirFiltre}"/>
                    <a4j:commandButton value="Délettrage" style="width:95px" title="Dé-lettrage des écritures sélectionnées" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.exoselectionne.execptEtatAnterieur==0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.exoselectionne.execptEtatAnterieur==2)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.testdeliste}" oncomplete="javascript:Richfaces.showModalPanel('panelDelettrage');" reRender="panelDelettrage"/>
                    <h:outputText value="La cloture antérieure est provisoire!" style="color:red;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.exoselectionne.execptEtatAnterieur==1}"/>
                </h:panelGrid>
            </h:panelGrid>

            <h:panelGrid width="100%" id="filtre">
                <h:panelGrid width="100%" id="periode">
                    <h:panelGrid width="100%" style="border:1px solid black;height:20px;text-align:center;font-weight:bold">
                        <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.periode}" /></h:column>
                    </h:panelGrid>
                </h:panelGrid>

                <h:panelGrid width="100%" columns="2" columnClasses="clos50d,clos50d">

                    <h:panelGrid width="100%" columns="3" style="border:1px solid black;height:145px;" id="selection" columnClasses="clos30,clos35,clos35">
                        <h:panelGrid  headerClass="headerTab" style="margin-top:-2px;" width="100%">
                            <f:facet name="header"><h:outputText  value="SELECTION"/></f:facet>
                            <h:column><h:inputText value="Lettrées: " readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.lettreCumul}" style="color:green" id="l" /></h:column>
                            <h:column><h:inputText value="Non lettrées:" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                            <h:column><h:inputText value="Sélectionnées:" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                            <h:column><h:inputText value="Solde:" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" style="margin-top:-2px" width="100%">
                            <f:facet name="header"><h:outputText  value="DEBIT"/></f:facet>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.ecrDebitL}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.ecrDebitNL}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.ecrDebitS}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.soldeDebitS}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" style="margin-top:-2px" width="100%">
                            <f:facet name="header"><h:outputText  value="CREDIT"/></f:facet>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.ecrCreditL}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.ecrCreditNL}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.ecrCreditS}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.soldeCreditS}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
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
                            <h:column><a4j:commandButton value="Lettre dispo. :" title="Sélectionne lettre en cours" style="height:50px;width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.testdeliste}" oncomplete="javascript:Richfaces.showModalPanel('panelLettrage');"  reRender="panelLettrage"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" style="margin-top:-2px" width="100%">
                            <f:facet name="header"><h:outputText  value="DEBIT"/></f:facet>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.tmouvDeb}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.solDebit}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.lettrModal}" readonly="true" style="height:42px;width:100%;text-align:center;"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" style="margin-top:-2px" width="100%">
                            <f:facet name="header"><h:outputText  value="CREDIT"/></f:facet>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.tmouvCred}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.solCredit}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.var_erreur_lettrage}" readonly="true" style="height:42px;width:100%;text-align:center;color:red"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>

                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>
        <br>
        <a4j:region renderRegionOnly="false">
            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.pageIndex}" reRender="tableExtrait" id="scrollTable" maxPages="20" align="left" for="tableExtrait"/>
            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.var_nb_max}" border="0" width="100%" styleClass="bg" noDataLabel=" " headerClass="headerTab" style="max-height:100%;border:solid 0px green;" id="tableExtrait" selectedClass="active-row" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.dataModelEcritures}"  var="table" rowClasses="rows1,rows2,rowsd" selectionMode="single">
                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelgrp,selection,lettre,fermer,mvts"/>
                <rich:column id="c1" width="5%" sortable="true" sortBy="#{table.ecrCode}" label="Journal">
                    <f:facet name="header"><h:outputText  value="Jr." /></f:facet>
                    <h:outputText value="#{table.ecrCode}" style="#{table.gras}"/>
                </rich:column>
                <rich:column id="c2" width="7%" sortable="true" sortBy="#{table.ecrDateSaisie}" label="Date de saisie" sortOrder="DESCENDING">
                    <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                    <h:outputText value="#{table.ecrDateSaisie}" style="#{table.gras}">
                        <f:convertDateTime pattern="dd/MM/yy"/>
                    </h:outputText>
                </rich:column>
                <rich:column id="c3" width="9%" sortable="true" sortBy="#{table.ecrCompte}" label="N° compte">
                    <f:facet name="header"><h:outputText  value="Compte"/></f:facet>
                    <h:outputText value="#{table.ecrCompte}" style="#{table.gras}"/>
                </rich:column>
                <rich:column id="c4" width="9%" sortable="true" sortBy="#{table.ecrPiece}" label="N° Pièce">
                    <f:facet name="header"><h:outputText value="Pièce" /></f:facet>
                    <h:outputText value="#{table.ecrPiece}" style="#{table.gras}"/>
                </rich:column>
                <rich:column id="c5" width="9%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.optionComptabilite.testRef1Piece}" sortable="true" sortBy="#{table.ecrReference1}" label="Référence 1">
                    <f:facet name="header"><h:outputText  value="Réf.1"/></f:facet>
                    <h:outputText value="#{table.ecrReference1}" style="#{table.gras}"/>
                </rich:column>
                <rich:column id="c6" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.optionComptabilite.testRef2Piece}" sortable="true" sortBy="#{table.ecrReference2}" label="Référence 2">
                    <f:facet name="header"><h:outputText  value="Réf.2"/></f:facet>
                    <h:outputText value="#{table.ecrReference2}" style="#{table.gras}"/>
                </rich:column>
                <rich:column id="c7" width="4%"  sortable="true" sortBy="#{table.sel_ecriture}" label="Sélection des écritures (lettrage ou impression)">
                    <f:facet name="header"><h:outputText  value="Sel."/></f:facet>
                    <h:selectBooleanCheckbox value="#{table.sel_ecriture}" style="#{table.gras}" rendered="#{table.ecrCode!='XX'}">
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.calculeSelectionLight}" reRender="selection"/>
                    </h:selectBooleanCheckbox>
                </rich:column>
                <rich:column id="c8" width="5%" sortable="true" sortBy="#{table.ecrLettrage}" label="Lettrage">
                    <f:facet name="header"><h:outputText  value="L."/></f:facet>
                    <h:outputText value="#{table.ecrLettrage}" style="#{table.gras}"/>
                </rich:column>
                <rich:column id="c9" width="4%" sortable="true" sortBy="#{table.ecrPointage}" label="Pointage">
                    <f:facet name="header"><h:outputText  value="P."/></f:facet>
                    <h:outputText value="#{table.erreurLettrage}" style="#{table.gras};color:red;"/>
                    <h:outputText value="#{table.ecrPointage}" style="#{table.gras}"/>
                </rich:column>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.planComptable.plcNature==6||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.planComptable.plcNature==7}">
                    <rich:column id="c10" width="7%" sortable="true" sortBy="#{table.ecrDateEcheance}" label="Date d'échéance">
                        <f:facet name="header"><h:outputText  value="Eché." /></f:facet>
                        <h:outputText value="#{table.ecrDateEcheance}" style="#{table.gras}">
                            <f:convertDateTime pattern="dd/MM/yy"/>
                        </h:outputText>
                    </rich:column>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.planComptable.plcNature==10||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.planComptable.plcNature==11}">
                    <rich:column id="c11" width="7%" sortable="true" sortBy="#{table.ecrDateValeurTheo}"label="Date de valeur">
                        <f:facet name="header"><h:outputText value="Valeur" /> </f:facet>
                        <h:outputText value="#{table.ecrDateValeurTheo}" style="#{table.gras}">
                            <f:convertDateTime pattern="dd/MM/yy"/>
                        </h:outputText>
                    </rich:column>
                </c:if>
                <rich:column id="c12" width="10%" style="text-align:right;" sortable="true" sortBy="#{table.ecrDebitPays}" label="Débit">
                    <f:facet name="header"><h:outputText  value="Débit" /></f:facet>
                    <h:outputText value="#{table.ecrDebitPays}" rendered="#{table.ecrDebitPays!=0}" style="#{table.gras}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column id="c13" width="10%"  style="text-align:right;" sortable="true" sortBy="#{table.ecrCreditPays}"label="Crédit">
                    <f:facet name="header"><h:outputText  value="Crédit" /></f:facet>
                    <h:outputText value="#{table.ecrCreditPays}" rendered="#{table.ecrCreditPays!=0}" style="#{table.gras}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column id="c14" width="20%" sortable="true" sortBy="#{table.ecrLibelle}" label="Libellé">
                    <f:facet name="header"><h:outputText value="Libellé" /></f:facet>
                    <h:outputText value="#{table.ecrLibelle}" style="#{table.gras}"/>
                </rich:column>
                <rich:column width="9%" style="text-align:center;" rendered="#{table.ecrAnaActif==1}">
                    <a4j:commandButton image="/images/detail.png" style="width:14px;height:14px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.ouvrirDetailsAnalytique}" reRender="idSubView,modalpanelAnalytique,formAnal,modalpanelAnalRecup,formAnalRecup" rendered="#{table.ecrAnaActif==1}" ></a4j:commandButton>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelExtrait" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="800" height="410"  showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.showModalFind}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.showModalFind}" var="ext">
            <f:facet name="header"><h:outputText value="Recherche N° Compte"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.annuleRecherche}" image="/images/close.gif" styleClass="hidelink" reRender="panelExtrait,filtre,tableExtrait,scrollTable"/>
                </a4j:form >
            </f:facet>
            <a4j:form id="Form" >
                <rich:panel id="richpsupp"  style="width:100%;border:0px;">
                    <h:panelGrid border="0" columns="4" id="pgrd1"  width="100%" columnClasses="clos25,clos25g,clos25,clos25g">
                        <h:column><h:outputText  style="text-decoration:underline;" value="Numéro de Compte:"/></h:column>
                        <h:column>
                            <h:inputText id="compteId" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.inputnum}">
                                <rich:toolTip id="toolcpt" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un numéro de compte ou d'un libellé de compte" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.recherchePlanComptable}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="idSubView,panCtrl,pgrd1,panelListePlanComptable,formModalListePlanComptable,compteId"/>
                            </h:inputText>
                        </h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column><h:outputText value="Période du:" /></h:column>
                        <h:column><rich:calendar style=" background-color:white;" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.dateDebut}"  enableManualInput="true" datePattern="dd/MM/yyyy"  inputSize="17" /></h:column>
                        <h:column><h:outputText value="Au:"/></h:column>
                        <h:column><rich:calendar style=" background-color:white;" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.dateFin}"  enableManualInput="true" datePattern="dd/MM/yyyy"  inputSize="17" /></h:column>
                        <h:column><h:outputText value="Numéro de pièce:" /></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.piece}" /></h:column>
                        <h:column><h:outputText value="Lettrage:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.lettrage}"/></h:column>
                        <h:column><h:outputText value="Journal (jr1:jr2:jrxx):"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.journal}"/></h:column>
                        <h:column><h:outputText value="Libellé:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.libEC}"/></h:column>
                        <h:column><h:outputText value="Référence 1:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.ref1}"/></h:column>
                        <h:column><h:outputText value="Référence 2:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.ref2}"/></h:column>
                        <h:column><h:outputText value="Pointage:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.pointage}"/></h:column>
                        <h:column><h:outputText value="Montant:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.montant}" style="text-align:right" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Analytique:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.analytique}"/></h:column>
                        <h:column><h:outputText value="Dossier:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.dossier}"/></h:column>
                    </h:panelGrid>
                    <br><br>
                    <h:panelGrid columns="2" id="pgrd2" width="100%" columnClasses="clos25,clos75" style="border:solid 1px green">
                        <h:column>
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.var_solde_ante}"/>
                        </h:column>
                        <h:column><h:outputText value="Affiche solde antérieur cumulé"/></h:column>
                        <h:column>
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.situationRech}"/>
                        </h:column>
                        <h:column><h:outputText value="Inclure journaux de situation"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}">
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.reserveRech}" />
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:outputText value="Inclure journaux privés"/></h:column>
                        <h:column><h:outputText value=" Filtre des écritures:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.filtrage}" >
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
                            <h:commandButton  image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.chargerEcritures}" id="idValRec" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </center>
                    </h:panelGroup>
                </rich:panel>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelPointage" width="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);">
        <f:facet name="header"><h:outputText value="Pointage"></h:outputText></f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="cancelP"/>
                <rich:componentControl for="panelPointage" attachTo="cancelP" operation="hide" event="onclick"/>
            </h:panelGroup>
        </f:facet>
        <rich:panel id="richPointage" style="border:0px solid green;width:80%;height:80%;">
            <a4j:form  id="FormPoint">
                <h:panelGrid border="0" columns="2" width="100%" style="text-align:left;">
                    <h:outputText value="Pointage:"/>
                    <h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.pointModal}" maxlength="10"/>
                </h:panelGrid>
                <br>
                <center>
                    <h:panelGroup>
                        <a4j:commandButton image="/images/valider_big.png" id="validP">
                            <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.pointerSelection}" reRender="tableExtrait,panelPointage,scrollTable"/>
                        </a4j:commandButton>
                        <rich:componentControl for="panelPointage" attachTo="validP" operation="hide" event="onclick"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
            <br/>
        </rich:panel>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelLettrage" width="400" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);">
        <f:facet name="header"><h:outputText value="Lettrage"/></f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="cancelL"/>
                <rich:componentControl for="panelLettrage" attachTo="cancelL" operation="hide" event="onclick"/>
            </h:panelGroup>
        </f:facet>
        <a4j:form  id="FormLettr">
            <h:panelGrid border="0" columns="2" width="100%" style="text-align:left;">
                <h:outputText value="Lettrage"/>
                <h:inputText id="idLettreSel" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.lettrModal}" maxlength="4">
                </h:inputText>
            </h:panelGrid>
            <br>
            <center>
                <a4j:commandButton value="Calcule prochaine lettre" title="Calcule prochaine lettre" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.calculerProchaineLettre}" reRender="idLettreSel"/>
            </center>
            <br/> <br/> <br/>
            <center>
                <h:panelGroup id="pan">
                    <h:commandButton image="/images/valider_big.png" id="validL">
                        <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.valideLettre}"/>
                    </h:commandButton>
                    <rich:componentControl for="panelLettrage" attachTo="validL" operation="hide" event="onclick"/>
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelFiltre" width="400" height="300" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.showModalpanelFiltre}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.showModalpanelFiltre}" var="extfil">
            <f:facet name="header"><h:outputText value="Filtrage des écritures"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.fermerFiltre}" image="/images/close.gif" styleClass="hidelink"/>
                </a4j:form>
            </f:facet>
            <a4j:form  id="FormFiltre">
                <h:panelGrid border="0" columns="2" width="100%" style="text-align:left;">
                    <h:outputText value="Du:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.dateDu}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/>
                    <h:outputText value="Au:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.dateAu}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/>
                </h:panelGrid>
                <br/> <br/> <br/>
                <center>
                    <h:panelGroup>
                        <center>
                            <h:commandButton  image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.valideFiltre}" id="idValFiltre" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </center>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelCompense" width="400" height="300" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.showModalPanelCompense}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.showModalPanelCompense}" var="extcom">
            <f:facet name="header"><h:outputText value="Compensation automatique"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.fermerSelection}" image="/images/close.gif" styleClass="hidelink"/>
                </a4j:form >
            </f:facet>
            <a4j:form  id="FormComp">
                <h:panelGrid border="0" columns="2" columnClasses="clos20,clos80" width="100%" style="text-align:left;">
                    <h:outputText value="Montant:"/>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.var_compense}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText value="Date:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.var_date_compense}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.var_aff_action}"/>
                    <h:outputText value="Compte:"/>
                    <h:inputText id="idCompteCompens" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.var_compte_compense}">
                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un numéro de compte ou d'un libellé de compte" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.rechercheCompteCompense}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panCtrl,pgrd1,panelListePlanComptable,formModalListePlanComptable,idCompteCompens"/>
                    </h:inputText>
                    <h:outputText value="Libellé:"/>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.var_libelle_compense}"/>
                </h:panelGrid>
                <br/> <br/> <br/>
                <center>
                    <h:panelGroup>
                        <center>
                            <h:commandButton  image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.lettrerSelection}" id="idValComp" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </center>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelDelettrage" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="300" height="220">
        <f:facet name="header"><h:outputText value="Dé-lettrage" style="color:green;"/></f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelink1Impim"/>
                <rich:componentControl for="panelDelettrage" attachTo="hidelink1Impim" operation="hide" event="onclick"/>
            </h:panelGroup>
        </f:facet>
        <a4j:form id="formModalDelet">
            <h:panelGrid  width="100%">
                <h:selectOneRadio  id="format" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.delettre}" layout="pageDirection">
                    <f:selectItem itemLabel="La ligne en cours" itemValue="0" />
                    <f:selectItem itemLabel="Toutes lignes de la lettre sélectionnée" itemValue="1"/>
                    <f:selectItem itemLabel="Tout le compte avec toutes ses lettres" itemValue="2"/>
                </h:selectOneRadio>
            </h:panelGrid>
            <br><br>
            <center>
                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.deLettrerSelection}" image="/images/valider_big.png" id="ipPrim" onclick="javascript:Richfaces.showModalPanel('modAttente');">
                    <rich:componentControl for="panelDelettrage" attachTo="ipPrim" operation="hide" event="onclick"/>
                </h:commandButton>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="600" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.showModalPanelPrint}" var="extimp">
            <center>
                <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
                <f:facet name="controls">
                    <a4j:form >
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
                            <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                        </a4j:commandButton>
                    </a4j:form>
                </f:facet>
                <a4j:form id="formModalImp" target="_blank">
                    <center>
                        <h:outputText value="Choisissez un modèle et un format d'Impression"  style="color:green;"/>
                    </center>
                    <br><br>
                    <h:panelGrid width="100%">
                        <h:panelGrid  width="100%" style="border:solid 1px green;">
                            <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                            <br>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.nomRapport}">
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.lesModelsimpression}"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                        <br>
                        <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                            <f:facet name="header"><h:outputText value="Format"/></f:facet>
                            <br>
                            <h:panelGrid  width="100%" columns="9" style="height:80px">
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                    <center>
                                        <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                                        <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                        </h:selectOneMenu>
                                    </center>
                                </h:panelGroup>
                                <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                                <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                                <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                                <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                                <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                                <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                                <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                                <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="formModalImp,modAttente,panelMail"/>
                            </h:panelGrid>
                        </h:panelGrid>
                        <br>
                        <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.affMail}">
                            <h:panelGrid  width="100%"  style="border:solid 1px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.impEmetteur}" >
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.utilPrint.lesbalEmetteursItems}"/>
                                    </h:selectOneMenu >
                                </h:column>
                                <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.impDestinataire}" >
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.utilPrint.lesbalDestinatairesItems}"/>
                                        <f:selectItem itemLabel="" itemValue=""/>
                                    </h:selectOneMenu >
                                </h:column>
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column><h:outputText value="Copie à (CC):"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.impDestinataireCC}"/></h:column>
                                <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.impDestinataireCCI}"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid  width="100%" style="text-align:center;">
                                <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>


   <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.valQteGraph}" >
                                <f:selectItem itemLabel="En valeur" itemValue="0"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.formExtraitCompte.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
