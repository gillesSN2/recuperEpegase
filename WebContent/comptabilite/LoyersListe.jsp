<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="saisieloyerListe">

    <center> <h2><h:outputText value="LISTE DES LOYERS" styleClass="titre"/></h2></center>

    <a4j:form id="loyer">

        <h:panelGrid id="panelBtn" columns="7" width="400px">
            <a4j:commandButton image="/images/ajouter.png" title="Ajouter" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.ajoutLoyer}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.testAffAjout)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton image="/images/modifier.png"  title="Modifier" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.modifLoyer}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.testAffModif&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.loyer.loyId!=0)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton image="/images/detail.png"  title="Consulter" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.consultLoyer}" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.testAffModif&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.loyer.loyId!=0)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton image="/images/supprimer.png" title="Supprimer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.removeSelectedLoyer}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.testAffSupp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.loyer.loyId!=0)==true}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelBtn,scrollTable,tableLoyer"/>
            <a4j:commandButton image="/images/print.png" title="Imprimer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail,panCertification"/>
            <a4j:commandButton image="/images/transferer.png" title="Transférer" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.trf&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.testAffAjout)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.openModalPanel}" oncomplete="javascript:Richfaces.showModalPanel('panelTransfert');" reRender="panelTransfert" />
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>
        <br>
        <h:panelGroup  id="table">
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.pageIndex}" reRender="tableLoyer" id="scrollTable" maxPages="20"align="left" for="tableLoyer"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.var_nb_max}" border="0" id="tableLoyer" activeClass="active-row" noDataLabel=" " styleClass="bg" footerClass="bard" sortMode="multi" headerClass="headerTab" var="loyer" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.dataModelLesloyers}"  width="250%" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.configListeEntete}">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.selectionLoyer}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBtn"/>
                        <rich:column label="N° du bail" sortable="true" sortOrder="ASCENDING" sortBy="#{loyer.loyNumBail}">
                            <f:facet name="header"><h:outputText value="N° Bail" /></f:facet>
                            <h:outputText  value="#{loyer.loyNumBail}" />
                        </rich:column>
                        <rich:column label="N° compte du tiers" sortable="true" sortBy="#{loyer.loyCompteTiers}">
                            <f:facet name="header"><h:outputText  value="Cpt. Tiers" /></f:facet>
                            <h:outputText value="#{loyer.loyCompteTiers}"  />
                        </rich:column>
                        <rich:column label="Type de bail" sortable="true" sortBy="#{loyer.type}">
                            <f:facet name="header"><h:outputText  value="Type" /></f:facet>
                            <h:outputText value="#{loyer.type}"  />
                        </rich:column>
                        <rich:column label="N° compte du loyerl" sortable="true" sortBy="#{loyer.loyCompteLoyer}">
                            <f:facet name="header"><h:outputText  value="Cpt. Loyer" /></f:facet>
                            <h:outputText value="#{loyer.loyCompteLoyer}"  />
                        </rich:column>
                        <rich:column label="N° compte de la taxe" sortable="true" sortBy="#{loyer.loyCompteTaxe}">
                            <f:facet name="header"><h:outputText  value="Cpt. Taxe" /></f:facet>
                            <h:outputText  value="#{loyer.loyCompteTaxe}" />
                        </rich:column>
                        <rich:column label="N° compte de l'impôt" sortable="true" sortBy="#{loyer.loyCompteImpot}">
                            <f:facet name="header"><h:outputText  value="Cpt. Impôt" /></f:facet>
                            <h:outputText value="#{loyer.loyCompteImpot}" />
                        </rich:column>
                        <rich:column label="Date début du bail" style="text-align:right" sortable="true" sortBy="#{loyer.loyDateDebut}">
                            <f:facet name="header"><h:outputText value="Début" /></f:facet>
                            <h:outputText value="#{loyer.loyDateDebut}" >
                                <f:convertDateTime locale="fr" pattern="dd/MM/yyyy"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date fin du bail" style="text-align:right" sortable="true" sortBy="#{loyer.loyDateFin}">
                            <f:facet name="header"><h:outputText  value="Fin" /></f:facet>
                            <h:outputText  value="#{loyer.loyDateFin}">
                                <f:convertDateTime locale="fr" pattern="dd/MM/yyyy"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Mode du bail" sortable="true" sortBy="#{loyer.mode}">
                            <f:facet name="header"><h:outputText value="Mode" /></f:facet>
                            <h:outputText  value="#{loyer.mode}"/>
                        </rich:column>
                        <rich:column label="Montant net" style="text-align:right" sortable="true" sortBy="#{loyer.loyMontantNet}">
                            <f:facet name="header"><h:outputText  value="Total net" /></f:facet>
                            <h:outputText value="#{loyer.loyMontantNet}" rendered="#{loyer.loyMontantNet!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant brut" style="text-align:right" sortable="true" sortBy="#{loyer.loyMontantBrut}">
                            <f:facet name="header"><h:outputText value="Total brut" /></f:facet>
                            <h:outputText value="#{loyer.loyMontantBrut}" rendered="#{loyer.loyMontantBrut!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant taxe" style="text-align:right" sortable="true" sortBy="#{loyer.loyMontantTaxe}">
                            <f:facet name="header"><h:outputText value="Total taxe" /></f:facet>
                            <h:outputText value="#{loyer.loyMontantTaxe}" rendered="#{loyer.loyMontantTaxe!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant impôt" style="text-align:right" sortable="true" sortBy="#{loyer.loyMontantImpot}">
                            <f:facet name="header"><h:outputText value="Total impôt" /></f:facet>
                            <h:outputText value="#{loyer.loyMontantImpot}" rendered="#{loyer.loyMontantImpot!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Etat du bail" style="text-align:center" sortable="false">
                            <f:facet name="header"><h:outputText value="Inactif" /></f:facet>
                            <h:commandButton disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.disable}"  image="#{loyer.etat}" rendered="#{loyer.inactif}"  onclick="if (!confirm('Voulez-vous réactiver cet élément ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.reactiverLoyer}" title="Supprimer" style="text-align:right;">
                                <a4j:support eventsQueue="maQueue" reRender="table" event="onclick"/>
                            </h:commandButton>
                        </rich:column>
                        <rich:column label="Activité" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testactivite}" sortable="true" sortBy="#{loyer.loyActiviteCode}">
                            <f:facet name="header"><h:outputText  value="Activité" /></f:facet>
                            <h:outputText value="#{loyer.loyActiviteCode}" />
                        </rich:column>
                        <rich:column label="Site" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testsite}" sortable="true" sortBy="#{loyer.loySiteCode}">
                            <f:facet name="header"><h:outputText value="Site" /></f:facet>
                            <h:outputText value="#{loyer.loySiteCode}"/>
                        </rich:column>
                        <rich:column label="Département" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testdept}"  sortable="true" sortBy="#{loyer.loyDepartementCode}">
                            <f:facet name="header"><h:outputText value="Dépt." /></f:facet>
                            <h:outputText value="#{loyer.loyDepartementCode}"/>
                        </rich:column>
                        <rich:column label="Service" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testservice}" sortable="true" sortBy="#{loyer.loyServiceCode}">
                            <f:facet name="header"><h:outputText value="Serv." /></f:facet>
                            <h:outputText value="#{loyer.loyServiceCode}" />
                        </rich:column>
                        <rich:column label="Région" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testreg}" sortable="true" sortBy="#{loyer.loyRegionCode}">
                            <f:facet name="header"><h:outputText value="Région" /></f:facet>
                            <h:outputText value="#{loyer.loyRegionCode}" />
                        </rich:column>
                        <rich:column label="Secteur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testsecteur}" sortable="true" sortBy="#{loyer.loySecteurCode}">
                            <f:facet name="header"><h:outputText  value="Secteur" /></f:facet>
                            <h:outputText value="#{loyer.loySecteurCode}" />
                        </rich:column>
                        <rich:column label="Point de vente" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testPVD}" sortable="true" sortBy="#{loyer.loyPdvCode}">
                            <f:facet name="header"><h:outputText  value="PDV" /></f:facet>
                            <h:outputText value="#{loyer.loyPdvCode}" />
                        </rich:column>
                        <rich:column label="Dossier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testDossier!=0}" sortable="true" sortBy="#{loyer.loyDossierCode}">
                            <f:facet name="header"><h:outputText value="Dossier" /></f:facet>
                            <h:outputText value="#{loyer.loyDossierCode}" />
                        </rich:column>
                        <rich:column label="Mission" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testMission}" sortable="true" sortBy="#{loyer.loyMissionCode}">
                            <f:facet name="header"><h:outputText  value="Mission" /></f:facet>
                            <h:outputText value="#{loyer.loyMissionCode}" />
                        </rich:column>
                        <rich:column label="Parc" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testParc}" sortable="true" sortBy="#{loyer.loyParcCode}">
                            <f:facet name="header"><h:outputText value="Parc" /></f:facet>
                            <h:outputText value="#{loyer.loyParcCode}"/>
                        </rich:column>
                        <rich:column label="Agent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.testAgent}" sortable="true" sortBy="#{loyer.loyAgentCode}">
                            <f:facet name="header"><h:outputText value="Agent" /></f:facet>
                            <h:outputText value="#{loyer.loyAgentCode}"/>
                        </rich:column>
                        <rich:column label="Clé" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.optionComptabilite.analytique}" sortable="true" sortBy="#{loyer.loyCle1Code}">
                            <f:facet name="header"><h:outputText value="Clé" /></f:facet>
                            <h:outputText value="#{loyer.loyCle1Code}"/>
                        </rich:column>
                        <rich:column label="Budget" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.optionComptabilite.budget}" sortable="true" sortBy="#{loyer.loyBudget}">
                            <f:facet name="header"><h:outputText  value="Budget" /></f:facet>
                            <h:outputText value="#{loyer.loyBudgetCode}" />
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
        </h:panelGroup>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="480" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitationComptabilite.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelTransfert" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="400" height="300" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.showModalPanelTransfert}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.showModalPanelTransfert}" var="trf">
            <f:facet name="header"><h:outputText value="TRANSFERT LOYER"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton reRender="panelTransfert" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.closeModalPanel}"  image="/images/close.gif" styleClass="hidelink" id="hidelinkperd"/>
                </a4j:form>
            </f:facet>
            <center>
                <a4j:form>
                    <h:panelGrid columns="2">
                        <h:outputText value="Date de Debut"/>
                        <rich:calendar id="datedeb" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.dateDebut}"  locale="fr"   enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white"/>
                        <h:outputText value="Date de Fin"/>
                        <rich:calendar id="datefin" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formLoyers.dateFin}"  locale="fr"   enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white"/>
                    </h:panelGrid>
                    <center>
                        <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.preparationTransfertLoyer}" style="margin-top:15px;" image="/images/valider_big.png" title="Valider"  />
                    </center>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>


</f:subview>
