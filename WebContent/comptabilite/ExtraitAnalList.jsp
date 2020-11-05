<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="fmrextraitAnal">

    <center> <h2><h:outputText id="pgextrait" value="EXTRAIT ANALYTIQUE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_filtre_analytique}" styleClass="titre"/></h2></center>

    <a4j:form id="formPrinc" >

        <h:panelGrid style="border:1px solid black;background-color:#FFFFFF;height:80px;" id="firstPanel" width="100%" columns="2" columnClasses="clos20,clos80">

            <h:panelGrid width="100%" cellpadding="1" cellspacing="0" id="idRecherche">
                <h:panelGrid id="panelgrp" width="100%" columns="5" style="text-align:center;">
                    <a4j:commandButton title="Recherche imputation"image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.trouverCompte}" reRender="panelExtrait,panelExtraitLight,scrollTable"/>
                    <a4j:commandButton title="Imprime extrait" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                    <a4j:commandButton title="Graphe extrait" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.initGrapheur}" reRender="panelGraph,formModalGraph,container"/>
                    <a4j:commandButton title="Informations sur l'écriture" image="/images/info.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.informationPiece}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_affiche_bouton}" reRender="panelInformation"/>
                    <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
                </h:panelGrid>
                <h:panelGrid id="filtrePage" width="100%" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affichageLettrage}">
                    <h:selectOneMenu  id="filtrecb" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.filtrage}" title="Filtre écritures" style="width:100%">
                        <f:selectItem itemLabel="Toutes les écritures" itemValue="0"/>
                        <f:selectItem itemLabel="Ecritures non lettrées" itemValue="1"/>
                        <f:selectItem itemLabel="Ecritures lettrées" itemValue="2"/>
                        <f:selectItem itemLabel="Ecritures non pointées" itemValue="3"/>
                        <f:selectItem itemLabel="Ecritures pointées" itemValue="4"/>
                        <f:selectItem itemLabel="Ecritures non lettrées et non pointées" itemValue="5"/>
                        <f:selectItem itemLabel="Ecritures lettrées et pointées" itemValue="6"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.chargerEcritures}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idRecherche,filtrePage,select,lettre,panelExtraitLight,scrollTable,tableExtrait,filtre,pgextrait"/>
                    </h:selectOneMenu>
                </h:panelGrid>
                <h:panelGrid id="select" columns="3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                    <a4j:commandButton value="Point." style="width:95px" title="Pointage des écritures sélectionnées" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affichageLettrage}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.selectionPointage}" reRender="panelPointage" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.testdeliste}"/>
                    <a4j:commandButton value="Tout sélec." title="Sélectionne toutes les écritures de la liste" reRender="tableExtrait,selection,scrollTable" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.toutSelectionner}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.testdeliste}"/>
                    <a4j:commandButton value="Rien sélec." title="Dé-sélectionne toutes les écritures de la liste" reRender="tableExtrait,selection,scrollTable" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.toutDeSelectionner}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.testdeliste}"/>
                </h:panelGrid>
                <h:panelGrid id="lettre" columns="3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affichageLettrage}">
                    <h:commandButton value="Lettrage" style="width:95px" title="Lettrage des écritures sélectionnées" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.exoselectionne.execptEtatAnterieur==0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.exoselectionne.execptEtatAnterieur==2)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.verifierSelection}" onclick="javascript:Richfaces.showModalPanel('modAttente');" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.testdeliste}"/>
                    <a4j:commandButton value="Filtre" style="width:95px" title="Filtre" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.testdeliste}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.ouvrirFiltre}" reRender="panelFiltre"/>
                    <a4j:commandButton value="Délettrage" style="width:95px" title="Dé-lettrage des écritures sélectionnées" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.exoselectionne.execptEtatAnterieur==0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.exoselectionne.execptEtatAnterieur==2)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.testdeliste}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.ouvrirDelettrage}" reRender="panelDelettrage"/>
                    <h:outputText value="La cloture antérieure est provisoire!" style="color:red;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.exoselectionne.execptEtatAnterieur==1}"/>
                </h:panelGrid>
            </h:panelGrid>

            <h:panelGrid width="100%" id="filtre">
                <h:panelGrid width="100%" id="periode">
                    <h:panelGrid width="100%" style="border:1px solid black;height:20px;text-align:center;font-weight:bold">
                        <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.periode}" /></h:column>
                    </h:panelGrid>
                </h:panelGrid>

                <h:panelGrid width="100%" columns="3" style="border:1px solid black;height:80px;" id="selection" columnClasses="clos30,clos35,clos35">
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affichageLettrage==false}" var="ecrCl">
                        <h:panelGrid  headerClass="headerTab" style="margin-top:-2px;" width="100%">
                            <f:facet name="header"><h:outputText  value="SELECTION"/></f:facet>
                            <h:column><h:inputText value="Total Mouvements:" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                            <h:column><h:inputText value="Solde extrait:" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                            <h:column><h:inputText value="Ecritures sélectionnées:" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" style="margin-top:-2px" width="100%">
                            <f:facet name="header"><h:outputText  value="DEBIT"/></f:facet>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_total_debit}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_solde_debit}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_total_select_debit}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" style="margin-top:-2px" width="100%">
                            <f:facet name="header"><h:outputText  value="CREDIT"/></f:facet>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_total_credit}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_solde_credit}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_total_select_credit}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affichageLettrage==true}" var="ecrCp">
                        <h:panelGrid  headerClass="headerTab" style="margin-top:-2px;" width="100%">
                            <f:facet name="header"><h:outputText  value="SELECTION"/></f:facet>
                            <h:column><h:inputText value="Lettrées: " readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lettreCumul}" style="color:green" id="l" /></h:column>
                            <h:column><h:inputText value="Non lettrées:" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                            <h:column><h:inputText value="Sélectionnées:" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                            <h:column><h:inputText value="Solde:" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" style="margin-top:-2px" width="100%">
                            <f:facet name="header"><h:outputText  value="DEBIT"/></f:facet>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.ecrDebitL}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.ecrDebitNL}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.ecrDebitS}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.soldeDebitS}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" style="margin-top:-2px" width="100%">
                            <f:facet name="header"><h:outputText  value="CREDIT"/></f:facet>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.ecrCreditL}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.ecrCreditNL}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.ecrCreditS}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.soldeCreditS}" readonly="true" style="width:90%;text-align:right;background:transparent;border:0px;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </c:if>
                </h:panelGrid>


            </h:panelGrid>
        </h:panelGrid>
        <br>
        <a4j:region renderRegionOnly="false">
            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableExtrait"/>
            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nb_max}" border="0"  width="100%" noDataLabel=" " groupingColumn="idCompte" styleClass="bg" headerClass="headerTab" style="max-height:100%;border:solid 0px green;" id="tableExtrait" selectedClass="active-row" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.dataModelEcrituresAnalytiques}" var="table" rowClasses="rows1,rows2,rowsd" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.configListeEntete}">
                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.selectionEcriture}" reRender="modAttente,panelgrp,filtre"/>
                <rich:column width="4%"  sortable="true" sortBy="#{table.sel_ecriture}" label="Sélection pour impression">
                    <f:facet name="header"><h:outputText  value="Sel."/></f:facet>
                    <h:selectBooleanCheckbox value="#{table.sel_ecriture}">
                        <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.calculTotalSelectionCochee}" reRender="selection,c1,c2,idCompte,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13"/>
                    </h:selectBooleanCheckbox>
                </rich:column>
                <rich:column id="c1" width="5%" sortable="true" sortBy="#{table.ecranaCode}" label="Journal">
                    <f:facet name="header"><h:outputText  value="Jr." /></f:facet>
                    <h:outputText value="#{table.ecranaCode}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c2" width="7%" sortable="true" sortBy="#{table.ecranaDateSaisie}" label="Date de saisie">
                    <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                    <h:outputText value="#{table.ecranaDateSaisie}">
                        <f:convertDateTime pattern="dd/MM/yy"/>
                    </h:outputText>
                </rich:column>
                <rich:column width="9%" sortable="true" id="idCompte" sortBy="#{table.ecranaCompte}" label="N° compte" >
                    <f:facet name="header"><h:outputText  value="Compte"  /></f:facet>
                    <h:outputText value="#{table.ecranaCompte}" >
                    </h:outputText>
                </rich:column>
                <rich:column id="c4" width="9%" sortable="true" sortBy="#{table.ecranaPiece}" label="N° Pièce">
                    <f:facet name="header"><h:outputText value="Pièce" /></f:facet>
                    <h:outputText value="#{table.ecranaPiece}" >
                    </h:outputText>
                </rich:column>
                <rich:column id="c5" width="9%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.optionComptabilite.testRef1Piece}" sortable="true" sortBy="#{table.ecranaReference1}" label="Référence 1">
                    <f:facet name="header"><h:outputText  value="Réf.1"/></f:facet>
                    <h:outputText value="#{table.ecranaReference1}" >
                    </h:outputText>
                </rich:column>
                <rich:column id="c6" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.optionComptabilite.testRef2Piece}" sortable="true" sortBy="#{table.ecranaReference2}" label="Référence 2">
                    <f:facet name="header"><h:outputText  value="Réf.2"/></f:facet>
                    <h:outputText value="#{table.ecranaReference2}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c81" width="50px" sortable="true" sortBy="#{table.lettrage}" label="Lettrage" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affichageLettrage}">
                    <f:facet name="header"><h:outputText  value="L."/></f:facet>
                    <h:outputText value="#{table.lettrage}"/>
                </rich:column>
                <rich:column id="c91" width="50px" sortable="true" sortBy="#{table.pointage}" label="Pointage" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affichageLettrage}">
                    <f:facet name="header"><h:outputText  value="P."/></f:facet>
                    <h:outputText value="#{table.erreurLettrage}" style="color:red;"/>
                    <h:outputText value="#{table.pointage}"/>
                </rich:column>
                <rich:column id="c7" width="6%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.liste_activite}" sortable="true" sortBy="#{table.ecranaActivite}" label="Activité">
                    <f:facet name="header"><h:outputText  value="Act."/></f:facet>
                    <h:outputText value="#{table.ecranaActivite}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c8" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.liste_anal1}" sortable="true" sortBy="#{table.ecranaActivite}" label="Colonne1">
                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strCode1}"/></f:facet>
                    <h:outputText value="#{table.ecranaActivite}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c9" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.liste_anal2}" sortable="true" sortBy="#{table.ecranaAnal1}" label="Colonne2">
                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strCode2}"/></f:facet>
                    <h:outputText value="#{table.ecranaAnal1}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c10" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.liste_anal3}" sortable="true" sortBy="#{table.ecranaAnal3}" label="Colonne3">
                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strCode3}"/></f:facet>
                    <h:outputText value="#{table.ecranaAnal3}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c100" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.liste_clesStr}" sortable="true" sortBy="#{table.ecranaStrCle}" label="Cles Structure">
                    <f:facet name="header"><h:outputText  value="Cles Structure"/></f:facet>
                    <h:outputText value="#{table.ecranaStrCle}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c113" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.liste_axesStr}" sortable="true" sortBy="#{table.ecranaStr}" label="Axes Structure">
                    <f:facet name="header"><h:outputText  value="Axes Structure"/></f:facet>
                    <h:outputText value="#{table.ecranaStr}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c101" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.liste_site}" sortable="true" sortBy="#{table.ecranaSite}" label="Site">
                    <f:facet name="header"><h:outputText  value="Site"/></f:facet>
                    <h:outputText value="#{table.ecranaSite}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c102" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.liste_departement}" sortable="true" sortBy="#{table.ecranaDepartement}" label="Département">
                    <f:facet name="header"><h:outputText  value="Département"/></f:facet>
                    <h:outputText value="#{table.ecranaDepartement}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c103" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.liste_service}" sortable="true" sortBy="#{table.ecranaService}" label="Service">
                    <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                    <h:outputText value="#{table.ecranaService}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c104" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.liste_region}" sortable="true" sortBy="#{table.ecranaRegion}" label="Région">
                    <f:facet name="header"><h:outputText  value="Région"/></f:facet>
                    <h:outputText value="#{table.ecranaRegion}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c105" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.liste_secteur}" sortable="true" sortBy="#{table.ecranaSecteur}" label="Secteur">
                    <f:facet name="header"><h:outputText  value="Secteur"/></f:facet>
                    <h:outputText value="#{table.ecranaSecteur}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c106" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.liste_pdv}" sortable="true" sortBy="#{table.ecranaPdv}" label="Pdv">
                    <f:facet name="header"><h:outputText  value="Pdv"/></f:facet>
                    <h:outputText value="#{table.ecranaPdv}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c107" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.liste_sitePrdv}" sortable="true" sortBy="#{table.ecranaSite}" label="Site">
                    <f:facet name="header"><h:outputText  value="Site"/></f:facet>
                    <h:outputText value="#{table.ecranaSite}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c108" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.liste_ligne}" sortable="true" sortBy="#{table.ecranaAtelier}" label="Atelier">
                    <f:facet name="header"><h:outputText  value="Département"/></f:facet>
                    <h:outputText value="#{table.ecranaLigne}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c109" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.liste_atelier}" sortable="true" sortBy="#{table.ecranaLigne}" label="Ligne">
                    <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                    <h:outputText value="#{table.ecranaAtelier}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c1111" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.liste_anal1}" sortable="true" sortBy="#{table.ecranaAnal1}" label="Chantier">
                    <f:facet name="header"><h:outputText  value="Chantier"/></f:facet>
                    <h:outputText value="#{table.ecranaAnal1}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c111" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.liste_parc}" sortable="true" sortBy="#{table.ecranaAnal2}" label="Parc">
                    <f:facet name="header"><h:outputText  value="Parc"/></f:facet>
                    <h:outputText value="#{table.ecranaAnal2}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c1113" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.liste_anal3}" sortable="true" sortBy="#{table.ecranaAnal3}" label="Frais">
                    <f:facet name="header"><h:outputText  value="Frais/Mission"/></f:facet>
                    <h:outputText value="#{table.ecranaAnal3}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c110" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.liste_dossier}" sortable="true" sortBy="#{table.ecranaAnal4}" label="Dossier">
                    <f:facet name="header"><h:outputText  value="Dossier"/></f:facet>
                    <h:outputText value="#{table.ecranaAnal4}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c112" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.liste_agent}" sortable="true" sortBy="#{table.ecranaAgent}" label="Agent">
                    <f:facet name="header"><h:outputText  value="Agent"/></f:facet>
                    <h:outputText value="#{table.ecranaAgent}">
                    </h:outputText>
                </rich:column>
                <rich:column id="c11" width="10%" style="text-align:right;" sortable="true" sortBy="#{table.valDebit}" label="Débit">
                    <f:facet name="header"><h:outputText  value="Débit" /></f:facet>
                    <h:outputText value="#{table.valDebit}" rendered="#{table.valDebit!=0}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column id="c12" width="10%" style="text-align:right;" sortable="true" sortBy="#{table.valCredit}" label="Crédit">
                    <f:facet name="header"><h:outputText  value="Crédit" /></f:facet>
                    <h:outputText value="#{table.valCredit}" rendered="#{table.valCredit!=0}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column width="4%" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strDossier!=3}">
                    <a4j:commandButton image="/images/detail.png" style="width:14px;height:14px;" immediate="true" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.gestionAnalytique}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,modalpanelAnalytique,formAnal,modalpanelAnalRecup,formAnalRecup" ></a4j:commandButton>
                </rich:column>
                <rich:column id="c13" width="22%" sortable="true" sortBy="#{table.ecranaLibelle}" label="Libellé">
                    <f:facet name="header"><h:outputText value="Libellé" /></f:facet>
                    <h:outputText value="#{table.ecranaLibelle}" >
                    </h:outputText>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelExtrait" headerClass="headerPanel" styleClass="bg" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" autosized="true" width="800" height="400"  showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.showModalFind}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.showModalFind}" var="ext">
            <f:facet name="header"><h:outputText value="Recherche Imputations Analyiques"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton image="/images/close.gif" styleClass="hidelink" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.annuleRecherche}" id="idCancelRecherche" reRender="panelExtrait,filtre,tableExtrait" style="text-decoration:none;"/>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCancelRecherche')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form  id="idFormAnal" >
                <rich:panel id="repartition"  style="width:100%;border:0px;" styleClass="fichefournisseur">
                    <h:panelGrid border="0" columns="4" id="pgrd1" width="100%" columnClasses="clos25,clos25g,clos25,clos25g">
                        <h:column><h:outputText value="Période du:" /></h:column>
                        <h:column><rich:calendar style=" background-color:white;" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.dateDebut}"  enableManualInput="true" datePattern="dd/MM/yyyy"   inputSize="8" /></h:column>
                        <h:column><h:outputText value="Au:"/></h:column>
                        <h:column><rich:calendar style=" background-color:white;" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.dateFin}"  enableManualInput="true" datePattern="dd/MM/yyyy"   inputSize="8" /></h:column>
                        <h:column><h:outputText value="Inclure journaux de situation:"/></h:column>
                        <h:column>
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.situationRech}"/>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:outputText value="Inclure journaux privés:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}">
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.reserveRech}" />
                        </h:column>
                        <h:column><h:outputText value="Compte n°:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.inpCompte}">
                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les comptes" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.recherchePlanComptable}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="idSubView,panCtrl,pgrd1,panelListePlanComptable,formModalListePlanComptable"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Classe n°:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.inpClasse}"/></h:column>
                    </h:panelGrid>
                    <br>

                    <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                        <rich:tab id="tabSelection" label="Sélection axe">
                            <h:panelGrid columns="4" width="100%" columnClasses="clos25,clos25,clos25,clos25">
                                <h:column><h:outputText value="Axe analytique:" /></h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique}" style="width:200px;">
                                        <f:selectItem itemLabel="Sélectionnez une nature" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.mesAxesAnalytique}"/>
                                        <a4j:support eventsQueue="maQueue"  event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.structureNature}" reRender="idFormAnal,repartition,detailRep,tableParc,idMemorise"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="" /></h:column>
                                <a4j:commandButton id="idMemorise" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique!=0}" value="Mémorise Axe" style="color:red" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.memoriseAxe}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"  reRender="modAttente,tableAxeCumul,idFormAnal,repartition,detailRep,tableParc,idMemorise"/>
                            </h:panelGrid>
                            <h:panelGrid width="100%" id="detailRep" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.mode_calcul}">
                                <h:panelGrid columns="4" width="100%">
                                    <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_activite&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strActiviteModeSasie==0}">
                                        <a4j:region renderRegionOnly="false">
                                            <rich:extendedDataTable  enableContextMenu="false" id="tableActivite" border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="150px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesActivites}"  var="act" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.decoupageActivite}">
                                                <rich:column  width="10%" sortable="false" >
                                                    <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                                    <h:selectBooleanCheckbox value="#{act.select_activite}"/>
                                                </rich:column>
                                                <rich:column  width="20%" sortable="false">
                                                    <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                                    <h:outputText value="#{act.actCode}"/>
                                                </rich:column>
                                                <rich:column  width="70%" sortable="false" >
                                                    <f:facet name="header"><h:outputText  value="Libellé Activité" /></f:facet>
                                                    <h:outputText value="#{act.actNomFr}"/>
                                                </rich:column>
                                            </rich:extendedDataTable>
                                            <rich:extendedDataTable  enableContextMenu="false" id="tableCol1" border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="100px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesColones1}"  var="co1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.decoupageActivite}">
                                                <rich:column  width="10%" sortable="false" >
                                                    <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                                    <h:selectBooleanCheckbox value="#{co1.select_activite}"/>
                                                </rich:column>
                                                <rich:column  width="20%" sortable="false">
                                                    <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                                    <h:outputText value="#{co1.actCode}"/>
                                                </rich:column>
                                                <rich:column  width="70%" sortable="false" >
                                                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                                    <h:outputText value="#{co1.actNomFr}"/>
                                                </rich:column>
                                            </rich:extendedDataTable>
                                            <rich:extendedDataTable  enableContextMenu="false" id="tableCol2" border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="100px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesColones2}"  var="co2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.decoupageActivite}">
                                                <rich:column  width="10%" sortable="false" >
                                                    <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                                    <h:selectBooleanCheckbox value="#{co2.select_activite}"/>
                                                </rich:column>
                                                <rich:column  width="20%" sortable="false">
                                                    <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                                    <h:outputText value="#{co2.actCode}"/>
                                                </rich:column>
                                                <rich:column  width="70%" sortable="false" >
                                                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                                    <h:outputText value="#{co2.actNomFr}"/>
                                                </rich:column>
                                            </rich:extendedDataTable>
                                            <rich:extendedDataTable  enableContextMenu="false" id="tableCol3" border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="100px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesColones3}"  var="co3" reRender="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.decoupageActivite}">
                                                <rich:column  width="10%" sortable="false" >
                                                    <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                                    <h:selectBooleanCheckbox value="#{co3.select_activite}"/>
                                                </rich:column>
                                                <rich:column  width="20%" sortable="false">
                                                    <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                                    <h:outputText value="#{co3.actCode}"/>
                                                </rich:column>
                                                <rich:column  width="70%" sortable="false" >
                                                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                                    <h:outputText value="#{co3.actNomFr}"/>
                                                </rich:column>
                                            </rich:extendedDataTable>
                                        </a4j:region>
                                    </h:panelGrid>
                                    <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_activite&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strActiviteModeSasie==1}"  columns="4" columnClasses="clos25,clos25,clos25,clos25">
                                        <h:column><h:outputText value="N° Activité:" style="text-decoration:underline;"/></h:column>
                                        <h:column>
                                            <h:inputText id="idActivite" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.rec_activite}">
                                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les dossiers" style="background-color:#FFF8D4;"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.rechercheActivite}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column><h:outputText value="" /></h:column>
                                        <h:column><h:outputText value="" /></h:column>
                                        <h:column><h:outputText value="" /></h:column>
                                        <h:column><h:outputText value="" /></h:column>
                                    </h:panelGrid>
                                    <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_parc}">
                                        <a4j:region renderRegionOnly="false">
                                            <rich:extendedDataTable  enableContextMenu="false" id="tableParc"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="150px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesParcs}"  var="prc" > />
                                                <rich:column  width="10%" sortable="false" >
                                                    <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                                    <h:selectBooleanCheckbox value="#{prc.select_parc}"/>
                                                </rich:column>
                                                <rich:column  width="20%" sortable="false">
                                                    <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                                    <h:outputText value="#{prc.prcImmatriculation}"/>
                                                </rich:column>
                                                <rich:column  width="70%" sortable="false" >
                                                    <f:facet name="header"><h:outputText  value="Libellé Parc" /></f:facet>
                                                    <h:outputText value="#{prc.prcLibFamille} #{prc.prcMarque}"/>
                                                </rich:column>
                                            </rich:extendedDataTable>
                                        </a4j:region>
                                    </h:panelGrid>
                                    <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_anal1}">
                                        <a4j:region renderRegionOnly="false">
                                            <rich:extendedDataTable  enableContextMenu="false" id="tableChantier"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="150px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesChantiers}"  var="cha" > />
                                                <rich:column  width="10%" sortable="false" >
                                                    <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                                    <h:selectBooleanCheckbox value="#{cha.select_analytique}"/>
                                                </rich:column>
                                                <rich:column  width="20%" sortable="false">
                                                    <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                                    <h:outputText value="#{cha.anaCode}"/>
                                                </rich:column>
                                                <rich:column  width="70%" sortable="false" >
                                                    <f:facet name="header"><h:outputText  value="Libellé Chantier" /></f:facet>
                                                    <h:outputText value="#{cha.anaNomFr}"/>
                                                </rich:column>
                                            </rich:extendedDataTable>
                                        </a4j:region>
                                    </h:panelGrid>
                                    <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_anal3}">
                                        <a4j:region renderRegionOnly="false">
                                            <rich:extendedDataTable  enableContextMenu="false" id="tableMission"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="150px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesMissions}"  var="mis" > />
                                                <rich:column  width="10%" sortable="false" >
                                                    <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                                    <h:selectBooleanCheckbox value="#{mis.select_analytique}"/>
                                                </rich:column>
                                                <rich:column  width="20%" sortable="false">
                                                    <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                                    <h:outputText value="#{mis.anaCode}"/>
                                                </rich:column>
                                                <rich:column  width="70%" sortable="false" >
                                                    <f:facet name="header"><h:outputText  value="Libellé Mission/Frais" /></f:facet>
                                                    <h:outputText value="#{mis.anaNomFr}"/>
                                                </rich:column>
                                            </rich:extendedDataTable>
                                        </a4j:region>
                                    </h:panelGrid>
                                    <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_dossier==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_dossier==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_dossier==3}" columns="4" columnClasses="clos25,clos25,clos25,clos25">
                                        <h:column><h:outputText value="N° Dossier:" style="text-decoration:underline;"/></h:column>
                                        <h:column>
                                            <h:inputText id="idDossier" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.rec_dossier}">
                                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les dossiers" style="background-color:#FFF8D4;"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.rechercheDossier}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column><h:outputText value="" /></h:column>
                                        <h:column><h:outputText value="" /></h:column>
                                        <h:column><h:outputText value="" /></h:column>
                                        <h:column><h:outputText value="" /></h:column>
                                    </h:panelGrid>
                                    <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_agent}">
                                        <a4j:region renderRegionOnly="false">
                                            <rich:extendedDataTable  enableContextMenu="false" id="tableAgent" border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="150px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesAgents}"  var="agt">
                                                <rich:column  width="10%" sortable="false">
                                                    <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                                                    <h:selectBooleanCheckbox value="#{agt.select_agent}"/>
                                                </rich:column>
                                                <rich:column  width="20%" sortable="false">
                                                    <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                                                    <h:outputText value="#{agt.salMatricule}"/>
                                                </rich:column>
                                                <rich:column  width="70%" sortable="false">
                                                    <f:facet name="header"><h:outputText  value="Nom et Prénom" /></f:facet>
                                                    <h:outputText value="#{agt.salNom} #{agt.salPrenom}"/>
                                                </rich:column>
                                            </rich:extendedDataTable>
                                        </a4j:region>
                                    </h:panelGrid>
                                    <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_clesStr}">
                                        <a4j:region renderRegionOnly="false">
                                            <rich:extendedDataTable  enableContextMenu="false" id="tableCleStructure"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="150px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesClesStructures}"  var="str" > />
                                                <rich:column  width="10%" sortable="false">
                                                    <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                                    <h:selectBooleanCheckbox value="#{str.select_analytique}"/>
                                                </rich:column>
                                                <rich:column  width="20%" sortable="false">
                                                    <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                                    <h:outputText value="#{str.anaCode}"/>
                                                </rich:column>
                                                <rich:column  width="70%" sortable="false" >
                                                    <f:facet name="header"><h:outputText  value="Libellé Cles Structure" /></f:facet>
                                                    <h:outputText value="#{str.anaNomFr}"/>
                                                </rich:column>
                                            </rich:extendedDataTable>
                                        </a4j:region>
                                    </h:panelGrid>
                                    <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_axesStr}">
                                        <a4j:region renderRegionOnly="false">
                                            <rich:extendedDataTable  enableContextMenu="false" id="tableAxeStructure"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="150px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesAxesStructures}"  var="str" > />
                                                <rich:column  width="10%" sortable="false">
                                                    <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                                    <h:selectBooleanCheckbox value="#{str.select_analytique}"/>
                                                </rich:column>
                                                <rich:column  width="20%" sortable="false">
                                                    <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                                    <h:outputText value="#{str.anaCode}"/>
                                                </rich:column>
                                                <rich:column  width="70%" sortable="false" >
                                                    <f:facet name="header"><h:outputText  value="Libellé Axes Structure" /></f:facet>
                                                    <h:outputText value="#{str.anaNomFr}"/>
                                                </rich:column>
                                            </rich:extendedDataTable>
                                        </a4j:region>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_site}">
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable  enableContextMenu="false" id="tableSitDepSer"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="200px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesSitDepSer}" var="sds" >
                                            <rich:column  width="10%" sortable="false">
                                                <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                                <h:selectBooleanCheckbox value="#{sds.select_site}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_site}"/>
                                            </rich:column>
                                            <rich:column  width="20%" sortable="false">
                                                <f:facet name="header"><h:outputText  value="Site" /></f:facet>
                                                <h:outputText value="#{sds.cleCodeSite} #{sds.cleLibelleSite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_site}"/>
                                            </rich:column>
                                            <rich:column  width="10%" sortable="false">
                                                <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                                <h:selectBooleanCheckbox value="#{sds.select_departement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_departement}"/>
                                            </rich:column>
                                            <rich:column  width="20%" sortable="false">
                                                <f:facet name="header"><h:outputText  value="Département" /></f:facet>
                                                <h:outputText value="#{sds.cleCodeDepartement} #{sds.cleLibelleDepartement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_departement}"/>
                                            </rich:column>
                                            <rich:column  width="10%" sortable="false">
                                                <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                                <h:selectBooleanCheckbox value="#{sds.select_service}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_service}"/>
                                            </rich:column>
                                            <rich:column  width="20%" sortable="false">
                                                <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                                                <h:outputText value="#{sds.cleCodeService} #{sds.cleLibelleService}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_service}"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:panelGrid>
                                <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_region}">
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable  enableContextMenu="false" id="tableRegSecPdv"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="200px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesRegSecPdv}" var="rsp" >
                                            <rich:column  width="10%" sortable="false">
                                                <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                                <h:selectBooleanCheckbox value="#{rsp.select_region}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_region}"/>
                                            </rich:column>
                                            <rich:column  width="20%" sortable="false">
                                                <f:facet name="header"><h:outputText  value="Région" /></f:facet>
                                                <h:outputText value="#{rsp.cleCodeRegion} #{rsp.cleLibelleRegion}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_region}"/>
                                            </rich:column>
                                            <rich:column  width="10%" sortable="false">
                                                <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                                <h:selectBooleanCheckbox value="#{rsp.select_secteur}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_secteur}"/>
                                            </rich:column>
                                            <rich:column  width="20%" sortable="false">
                                                <f:facet name="header"><h:outputText  value="Secteur" /></f:facet>
                                                <h:outputText value="#{rsp.cleCodeSecteur} #{rsp.cleLibelleSecteur}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_secteur}"/>
                                            </rich:column>
                                            <rich:column  width="10%" sortable="false">
                                                <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                                <h:selectBooleanCheckbox value="#{rsp.select_pdv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_pdv}"/>
                                            </rich:column>
                                            <rich:column  width="20%" sortable="false">
                                                <f:facet name="header"><h:outputText  value="P.D.V." /></f:facet>
                                                <h:outputText value="#{rsp.cleCodePdv} #{rsp.cleLibellePdv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_pdv}"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:panelGrid>
                                <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_sitePrdv}">
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable  enableContextMenu="false" id="tableSitLigAte"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="200px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesSitLigAte}" var="sla" >
                                            <rich:column  width="10%" sortable="false">
                                                <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                                <h:selectBooleanCheckbox value="#{sla.select_site}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_sitePrdv}"/>
                                            </rich:column>
                                            <rich:column  width="20%" sortable="false">
                                                <f:facet name="header"><h:outputText  value="Site" /></f:facet>
                                                <h:outputText value="#{sla.cleCodeSite} #{sla.cleLibelleSite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_sitePrdv}"/>
                                            </rich:column>
                                            <rich:column  width="10%" sortable="false">
                                                <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                                <h:selectBooleanCheckbox value="#{sla.select_ligne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_ligne}"/>
                                            </rich:column>
                                            <rich:column  width="20%" sortable="false">
                                                <f:facet name="header"><h:outputText  value="Ligne" /></f:facet>
                                                <h:outputText value="#{sla.cleCodeLigne} #{sla.cleLibelleLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_ligne}"/>
                                            </rich:column>
                                            <rich:column  width="10%" sortable="false">
                                                <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                                <h:selectBooleanCheckbox value="#{sla.select_atelier}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_atelier}"/>
                                            </rich:column>
                                            <rich:column  width="20%" sortable="false">
                                                <f:facet name="header"><h:outputText  value="Atelier" /></f:facet>
                                                <h:outputText value="#{sla.cleCodeAtelier} #{sla.cleLibelleAtelier}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_atelier}"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:panelGrid>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabRequete" label="Axes cumulés">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  enableContextMenu="false" id="tableAxeCumul"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="150px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.dataModelAxeCumul}"  var="axe" > />
                                    <rich:column  width="10%" sortable="false" >
                                        <f:facet name="header"><h:outputText  value="N°Axe" /></f:facet>
                                        <h:outputText value="#{axe.numAxe}"/>
                                    </rich:column>
                                    <rich:column  width="20%" sortable="false" >
                                        <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                                        <h:outputText value="#{axe.lot}"/>
                                    </rich:column>
                                    <rich:column  width="20%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                        <h:outputText value="#{axe.code}"/>
                                    </rich:column>
                                    <rich:column  width="50%" sortable="false" >
                                        <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                                        <h:outputText value="#{axe.nom_FR}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                            <br>
                            <h:panelGroup id="buttFind">
                                <center>
                                    <a4j:commandButton  image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.chargerEcritures}" id="idValRec" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idRecherche,filtrePage,select,lettre,panelExtrait,scrollTable,tableExtrait,filtre,pgextrait"/>
                                    <rich:hotKey key="return"  handler="#{rich:element('idValRec')}.click()" />
                                </center>
                            </h:panelGroup>
                        </rich:tab>

                    </rich:tabPanel>

                </rich:panel>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelExtraitLight" headerClass="headerPanel" styleClass="bg" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" autosized="true" width="800" height="400"  showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.showModalFindLight}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.showModalFindLight}" var="ext">
            <f:facet name="header"><h:outputText value="Recherche Imputations Analyiques (LIGHT)"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton image="/images/close.gif" styleClass="hidelink" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.annuleRecherche}" id="idCancelRechercheL" reRender="panelExtraitLight,filtre,tableExtrait" style="text-decoration:none;"/>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCancelRechercheL')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form  id="idFormAnal" >
                <rich:panel id="repartition"  style="width:100%;border:0px;" styleClass="fichefournisseur">
                    <h:panelGrid border="0" columns="4" id="pgrd1" width="100%" columnClasses="clos25,clos25g,clos25,clos25g">
                        <h:column><h:outputText value="Période du:" /></h:column>
                        <h:column><rich:calendar style=" background-color:white;" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.dateDebut}"  enableManualInput="true" datePattern="dd/MM/yyyy"   inputSize="8" /></h:column>
                        <h:column><h:outputText value="Au:"/></h:column>
                        <h:column><rich:calendar style=" background-color:white;" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.dateFin}"  enableManualInput="true" datePattern="dd/MM/yyyy"   inputSize="8" /></h:column>
                        <h:column><h:outputText value="Inclure journaux de situation:"/></h:column>
                        <h:column>
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.situationRech}"/>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:outputText value="Inclure journaux privés:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}">
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.reserveRech}" />
                        </h:column>
                        <h:column><h:outputText value="Compte n°:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.inpCompte}">
                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les comptes" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.recherchePlanComptable}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="idSubView,panCtrl,pgrd1,panelListePlanComptable,formModalListePlanComptable"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Classe n°:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.inpClasse}"/></h:column>
                    </h:panelGrid>
                    <br>

                    <h:panelGrid columns="4" width="100%" columnClasses="clos25,clos25,clos25,clos25">
                        <h:column><h:outputText value="Axe analytique:" /></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique}" style="width:200px;" disabled="true" readonly="true">
                                <f:selectItem itemLabel="Sélectionnez une nature" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.mesAxesAnalytique}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="(Pré-sélection lié à l'utilisateur)" /></h:column>
                        <h:column><h:outputText value="" /></h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" id="detailRep" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.mode_calcul}">
                        <h:panelGrid columns="4" width="100%">
                            <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_activite&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strActiviteModeSasie==0}">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable  enableContextMenu="false" id="tableActivite" border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="150px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesActivites}"  var="act" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.decoupageActivite}">
                                        <rich:column  width="10%" sortable="false" >
                                            <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                            <h:selectBooleanCheckbox value="#{act.select_activite}"/>
                                        </rich:column>
                                        <rich:column  width="20%" sortable="false">
                                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                            <h:outputText value="#{act.actCode}"/>
                                        </rich:column>
                                        <rich:column  width="70%" sortable="false" >
                                            <f:facet name="header"><h:outputText  value="Libellé Activité" /></f:facet>
                                            <h:outputText value="#{act.actNomFr}"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                    <rich:extendedDataTable  enableContextMenu="false" id="tableCol1" border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="100px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesColones1}"  var="co1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.decoupageActivite}">
                                        <rich:column  width="10%" sortable="false" >
                                            <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                            <h:selectBooleanCheckbox value="#{co1.select_activite}"/>
                                        </rich:column>
                                        <rich:column  width="20%" sortable="false">
                                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                            <h:outputText value="#{co1.actCode}"/>
                                        </rich:column>
                                        <rich:column  width="70%" sortable="false" >
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                            <h:outputText value="#{co1.actNomFr}"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                    <rich:extendedDataTable  enableContextMenu="false" id="tableCol2" border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="100px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesColones2}"  var="co2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.decoupageActivite}">
                                        <rich:column  width="10%" sortable="false" >
                                            <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                            <h:selectBooleanCheckbox value="#{co2.select_activite}"/>
                                        </rich:column>
                                        <rich:column  width="20%" sortable="false">
                                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                            <h:outputText value="#{co2.actCode}"/>
                                        </rich:column>
                                        <rich:column  width="70%" sortable="false" >
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                            <h:outputText value="#{co2.actNomFr}"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                    <rich:extendedDataTable  enableContextMenu="false" id="tableCol3" border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="100px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesColones3}"  var="co3" reRender="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.decoupageActivite}">
                                        <rich:column  width="10%" sortable="false" >
                                            <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                            <h:selectBooleanCheckbox value="#{co3.select_activite}"/>
                                        </rich:column>
                                        <rich:column  width="20%" sortable="false">
                                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                            <h:outputText value="#{co3.actCode}"/>
                                        </rich:column>
                                        <rich:column  width="70%" sortable="false" >
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                            <h:outputText value="#{co3.actNomFr}"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:panelGrid>
                            <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_activite&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strActiviteModeSasie==1}"  columns="4" columnClasses="clos25,clos25,clos25,clos25">
                                <h:column><h:outputText value="N° Activité:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:inputText id="idActivite" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.rec_activite}">
                                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les dossiers" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.rechercheActivite}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="" /></h:column>
                                <h:column><h:outputText value="" /></h:column>
                                <h:column><h:outputText value="" /></h:column>
                                <h:column><h:outputText value="" /></h:column>
                            </h:panelGrid>
                            <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_parc}">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable  enableContextMenu="false" id="tableParc"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="150px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesParcs}"  var="prc" > />
                                        <rich:column  width="10%" sortable="false" >
                                            <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                            <h:selectBooleanCheckbox value="#{prc.select_parc}"/>
                                        </rich:column>
                                        <rich:column  width="20%" sortable="false">
                                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                            <h:outputText value="#{prc.prcImmatriculation}"/>
                                        </rich:column>
                                        <rich:column  width="70%" sortable="false" >
                                            <f:facet name="header"><h:outputText  value="Libellé Parc" /></f:facet>
                                            <h:outputText value="#{prc.prcLibFamille} #{prc.prcMarque}"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:panelGrid>
                            <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_anal1}">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable  enableContextMenu="false" id="tableChantier"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="150px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesChantiers}"  var="cha" > />
                                        <rich:column  width="10%" sortable="false" >
                                            <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                            <h:selectBooleanCheckbox value="#{cha.select_analytique}"/>
                                        </rich:column>
                                        <rich:column  width="20%" sortable="false">
                                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                            <h:outputText value="#{cha.anaCode}"/>
                                        </rich:column>
                                        <rich:column  width="70%" sortable="false" >
                                            <f:facet name="header"><h:outputText  value="Libellé Chantier" /></f:facet>
                                            <h:outputText value="#{cha.anaNomFr}"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:panelGrid>
                            <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_anal3}">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable  enableContextMenu="false" id="tableMission"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="150px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesMissions}"  var="mis" > />
                                        <rich:column  width="10%" sortable="false" >
                                            <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                            <h:selectBooleanCheckbox value="#{mis.select_analytique}"/>
                                        </rich:column>
                                        <rich:column  width="20%" sortable="false">
                                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                            <h:outputText value="#{mis.anaCode}"/>
                                        </rich:column>
                                        <rich:column  width="70%" sortable="false" >
                                            <f:facet name="header"><h:outputText  value="Libellé Mission/Frais" /></f:facet>
                                            <h:outputText value="#{mis.anaNomFr}"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:panelGrid>
                            <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_dossier==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_dossier==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_dossier==3}" columns="4" columnClasses="clos25,clos25,clos25,clos25">
                                <h:column><h:outputText value="N° Dossier:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:inputText id="idDossier" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.rec_dossier}">
                                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les dossiers" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.rechercheDossier}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="" /></h:column>
                                <h:column><h:outputText value="" /></h:column>
                                <h:column><h:outputText value="" /></h:column>
                                <h:column><h:outputText value="" /></h:column>
                            </h:panelGrid>
                            <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_agent}">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable  enableContextMenu="false" id="tableAgent" border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="150px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesAgents}"  var="agt">
                                        <rich:column  width="10%" sortable="false">
                                            <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                                            <h:selectBooleanCheckbox value="#{agt.select_agent}"/>
                                        </rich:column>
                                        <rich:column  width="20%" sortable="false">
                                            <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                                            <h:outputText value="#{agt.salMatricule}"/>
                                        </rich:column>
                                        <rich:column  width="70%" sortable="false">
                                            <f:facet name="header"><h:outputText  value="Nom et Prénom" /></f:facet>
                                            <h:outputText value="#{agt.salNom} #{agt.salPrenom}"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:panelGrid>
                            <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_clesStr}">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable  enableContextMenu="false" id="tableCleStructure"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="150px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesClesStructures}"  var="str" > />
                                        <rich:column  width="10%" sortable="false">
                                            <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                            <h:selectBooleanCheckbox value="#{str.select_analytique}"/>
                                        </rich:column>
                                        <rich:column  width="20%" sortable="false">
                                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                            <h:outputText value="#{str.anaCode}"/>
                                        </rich:column>
                                        <rich:column  width="70%" sortable="false" >
                                            <f:facet name="header"><h:outputText  value="Libellé Cles Structure" /></f:facet>
                                            <h:outputText value="#{str.anaNomFr}"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:panelGrid>
                            <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_axesStr}">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable  enableContextMenu="false" id="tableAxeStructure"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="150px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesAxesStructures}"  var="str" > />
                                        <rich:column  width="10%" sortable="false">
                                            <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                            <h:selectBooleanCheckbox value="#{str.select_analytique}"/>
                                        </rich:column>
                                        <rich:column  width="20%" sortable="false">
                                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                            <h:outputText value="#{str.anaCode}"/>
                                        </rich:column>
                                        <rich:column  width="70%" sortable="false" >
                                            <f:facet name="header"><h:outputText  value="Libellé Axes Structure" /></f:facet>
                                            <h:outputText value="#{str.anaNomFr}"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_site}">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  enableContextMenu="false" id="tableSitDepSer"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="200px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesSitDepSer}" var="sds" >
                                    <rich:column  width="10%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                        <h:selectBooleanCheckbox value="#{sds.select_site}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_site}"/>
                                    </rich:column>
                                    <rich:column  width="20%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Site" /></f:facet>
                                        <h:outputText value="#{sds.cleCodeSite} #{sds.cleLibelleSite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_site}"/>
                                    </rich:column>
                                    <rich:column  width="10%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                        <h:selectBooleanCheckbox value="#{sds.select_departement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_departement}"/>
                                    </rich:column>
                                    <rich:column  width="20%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Département" /></f:facet>
                                        <h:outputText value="#{sds.cleCodeDepartement} #{sds.cleLibelleDepartement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_departement}"/>
                                    </rich:column>
                                    <rich:column  width="10%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                        <h:selectBooleanCheckbox value="#{sds.select_service}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_service}"/>
                                    </rich:column>
                                    <rich:column  width="20%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                                        <h:outputText value="#{sds.cleCodeService} #{sds.cleLibelleService}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_service}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                        <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_region}">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  enableContextMenu="false" id="tableRegSecPdv"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="200px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesRegSecPdv}" var="rsp" >
                                    <rich:column  width="10%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                        <h:selectBooleanCheckbox value="#{rsp.select_region}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_region}"/>
                                    </rich:column>
                                    <rich:column  width="20%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Région" /></f:facet>
                                        <h:outputText value="#{rsp.cleCodeRegion} #{rsp.cleLibelleRegion}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_region}"/>
                                    </rich:column>
                                    <rich:column  width="10%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                        <h:selectBooleanCheckbox value="#{rsp.select_secteur}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_secteur}"/>
                                    </rich:column>
                                    <rich:column  width="20%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Secteur" /></f:facet>
                                        <h:outputText value="#{rsp.cleCodeSecteur} #{rsp.cleLibelleSecteur}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_secteur}"/>
                                    </rich:column>
                                    <rich:column  width="10%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                        <h:selectBooleanCheckbox value="#{rsp.select_pdv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_pdv}"/>
                                    </rich:column>
                                    <rich:column  width="20%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="P.D.V." /></f:facet>
                                        <h:outputText value="#{rsp.cleCodePdv} #{rsp.cleLibellePdv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_pdv}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                        <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_sitePrdv}">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  enableContextMenu="false" id="tableSitLigAte"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="200px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lesSitLigAte}" var="sla" >
                                    <rich:column  width="10%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                        <h:selectBooleanCheckbox value="#{sla.select_site}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_sitePrdv}"/>
                                    </rich:column>
                                    <rich:column  width="20%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Site" /></f:facet>
                                        <h:outputText value="#{sla.cleCodeSite} #{sla.cleLibelleSite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_sitePrdv}"/>
                                    </rich:column>
                                    <rich:column  width="10%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                        <h:selectBooleanCheckbox value="#{sla.select_ligne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_ligne}"/>
                                    </rich:column>
                                    <rich:column  width="20%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Ligne" /></f:facet>
                                        <h:outputText value="#{sla.cleCodeLigne} #{sla.cleLibelleLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_ligne}"/>
                                    </rich:column>
                                    <rich:column  width="10%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                        <h:selectBooleanCheckbox value="#{sla.select_atelier}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_atelier}"/>
                                    </rich:column>
                                    <rich:column  width="20%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Atelier" /></f:facet>
                                        <h:outputText value="#{sla.cleCodeAtelier} #{sla.cleLibelleAtelier}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_atelier}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="buttFindL">
                    <center>
                        <br>
                        <a4j:commandButton  image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.chargerEcrituresLight}" id="idValRecL" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idRecherche,filtrePage,select,lettre,panelExtraitLight,scrollTable,tableExtrait,filtre,pgextrait"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecL')}.click()" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="350" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitationComptabilite.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.valQteGraph}" >
                                <f:selectItem itemLabel="En valeur" itemValue="0"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <f:selectItem itemLabel="par compte général" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelInformation" width="600" height="160" headerClass="headerPanel"style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.showModalPanelInformation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.showModalPanelInformation}" var="inf">
            <f:facet name="header"><h:outputText value="INFORMATION SUR L'ECRITURE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.fermerInformationPiece}" image="/images/close.gif" styleClass="hidelink" reRender="panelInformation"/>
                </a4j:form >
            </f:facet>
            <a4j:form id="formLpr">
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos30,clos70">
                    <h:outputText value="ID écriture:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.ecritures.ecr_id}"/>
                    <h:outputText value="Date de création:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.ecritures.ecrDateCreat}" datePattern="dd/MM/yyyy hh:mm:ss"  locale="fr" style=" background-color:white;" inputSize="20" readonly="true" disabled="true"/>
                    <h:outputText value="Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.nomCreation} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.ecritures.ecrUserCreat})"/>
                    <h:outputText value="Modifié le:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.ecritures.ecrDateModif}" datePattern="dd/MM/yyyy hh:mm:ss"  locale="fr" style=" background-color:white;" inputSize="20"  readonly="true" disabled="true"/>
                    <h:outputText value="Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.nomModification} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.ecritures.ecrUserModif})"/>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelPointage" width="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.showModalPanelPointage}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.showModalPanelPointage}" var="poin">
            <f:facet name="header"><h:outputText value="Pointage"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.fermerPointage}" id="idCancelPointage" image="/images/close.gif" styleClass="hidelink" reRender="panelPointage"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCancelPointage')}.click()" />
                </a4j:form >
            </f:facet>
            <rich:panel id="richPointage" style="border:0px solid green;width:80%;height:80%;">
                <a4j:form  id="FormPoint">
                    <h:panelGrid border="0" columns="2" width="100%" style="text-align:left;">
                        <h:outputText value="Pointage:"/>
                        <h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.pointModal}" maxlength="10"/>
                    </h:panelGrid>
                    <br>
                    <center>
                        <h:panelGroup>
                            <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.pointerSelection}" id="idValPointage" reRender="tableExtrait,panelPointage,scrollTable"/>
                            <rich:hotKey key="return" handler="#{rich:element('idValPointage')}.click()" />
                        </h:panelGroup>
                    </center>
                </a4j:form>
                <br/>
            </rich:panel>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelLettrage" width="400" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.showModalPanelLettrage}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.showModalPanelLettrage}" var="lettr">
            <f:facet name="header"><h:outputText value="Lettrage"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.fermerLettrage}" id="idCancelLettrage" image="/images/close.gif" styleClass="hidelink" reRender="panelLettrage"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCancelLettrage')}.click()" />
                </a4j:form >
            </f:facet>
            <a4j:form  id="FormLettr">
                <h:panelGrid border="0" columns="2" width="100%" style="text-align:left;">
                    <h:outputText value="Lettrage"/>
                    <h:inputText id="idLettreSel" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.lettrModal}" maxlength="4">
                    </h:inputText>
                </h:panelGrid>
                <br>
                <center>
                    <a4j:commandButton value="Calcule prochaine lettre" title="Calcule prochaine lettre" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.calculerProchaineLettre}" reRender="idLettreSel"/>
                </center>
                <br/> <br/> <br/>
                <center>
                    <h:panelGroup id="pan">
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.valideLettre}" id="idValLettrage"/>
                        <rich:hotKey key="return" handler="#{rich:element('idValLettrage')}.click()" />
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelDelettrage" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="300" height="220" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.showModalPanelDelettrage}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.showModalPanelDelettrage}" var="poin">
            <f:facet name="header"><h:outputText value="Dé-lettrage" style="color:green;"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.fermerDelettrage}" id="idCancelDelettrage" image="/images/close.gif" styleClass="hidelink" reRender="panelDelettrage"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCancelDelettrage')}.click()" />
                </a4j:form >
            </f:facet>
            <a4j:form id="formModalDelet">
                <h:panelGrid  width="100%">
                    <h:selectOneRadio  id="format" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.delettre}" layout="pageDirection">
                        <f:selectItem itemLabel="La ligne en cours" itemValue="0" />
                        <f:selectItem itemLabel="Toutes lignes de la lettre sélectionnée" itemValue="1"/>
                        <f:selectItem itemLabel="Tout le compte avec toutes ses lettres" itemValue="2"/>
                    </h:selectOneRadio>
                </h:panelGrid>
                <br><br>
                <center>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.deLettrerSelection}" image="/images/valider_big.png" id="idValDelettrage" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelDelettrage,filtre,tableExtrait"/>
                    <rich:hotKey key="return" handler="#{rich:element('idValDelettrage')}.click()" />
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
