<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="eleveSituation">

    <a4j:form id="formEleveSituation" enctype="multipart/form-data">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText  styleClass="titre" value="SITUATION ELEVE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.eleDossier}: #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.eleves.patronyme}" /></h2></center>

        <h:panelGrid width="100%">
            <jsp:include flush="true" page="/tiers/tiersEleveCommun.jsp" />
            <h:panelGrid id="idSit" width="100%" styleClass="fichefournisseur1">
                <h:panelGrid  id="btnFacture" columns="5" width="200px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action!=3}">
                    <a4j:commandButton image="/images/detail.png" title="Consulter facture/règlement"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.consulterFacture}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.afficheButtFacture}" reRender="panelFacture,btnFacture"/>
                    <a4j:commandButton image="/images/print.png" title="Imprimer facture/Reçu"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.initImprimerFacture}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.afficheButtFacture}" reRender="panelImpressionSituation"/>
                    <a4j:commandButton title="Bon d'encaissement du/des document(s) sélectionné(s)" image="/images/bonCaisse.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.reglementAutorise&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.afficheButtFacture&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_affiche_be}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.payeDocumentBonEncaissement}" reRender="panelPaye,panelBouton" />
                    <a4j:commandButton title="Règlement direct du/des document(s) sélectionné(s)" image="/images/dollar.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.reglementAutorise&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.afficheButtFacture&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_affiche_dollar}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.payeXDocumentRecu}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPayeXDoc,panelBouton" />
                    <a4j:commandButton title="Historique des règlements du document sélectionné" image="/images/histoPaiement.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.reglementAutorise&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.afficheButtFacture&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacEtat==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.histoReglement}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelHistoReglement" />
                </h:panelGrid>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable style="border:solid 0px green;" border="0" id="tableFacture" width="100%" height="300px" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.datamodelFacturation}" var="facture" >
                        <a4j:support eventsQueue="maQueue" event="onRowClick"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.selectionFacture}" reRender="btnFacture"/>
                        <rich:column sortable="true" sortBy="#{facture.elefacAnnee}" width="10%">
                            <f:facet name="header" ><h:outputText  value="Année"/></f:facet>
                            <h:outputText  value="#{facture.elefacAnnee}"/>
                        </rich:column>
                        <rich:column id="idEtat" sortable="true" sortBy="#{facture.libelleEtat}" width="10%">
                            <f:facet name="header" ><h:outputText  value="Etat"/></f:facet>
                            <h:outputText  value="#{facture.libelleEtat}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{facture.elefacNum}" width="10%">
                            <f:facet name="header" ><h:outputText  value="N° Facture"/></f:facet>
                            <h:outputText  value="#{facture.elefacNum}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{facture.elefacDate}" width="10%">
                            <f:facet name="header" ><h:outputText  value="Date"/></f:facet>
                            <h:outputText  value="#{facture.elefacDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{facture.libelleMode}" width="10%">
                            <f:facet name="header" ><h:outputText  value="Mode"/></f:facet>
                            <h:outputText  value="#{facture.libelleMode}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{facture.libelleType}" width="10%">
                            <f:facet name="header" ><h:outputText  value="Type"/></f:facet>
                            <h:outputText  value="#{facture.libelleType}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{facture.total}" width="10%" style="text-align:right;">
                            <f:facet name="header" ><h:outputText  value="Total"/></f:facet>
                            <h:outputText  value="#{facture.total}" rendered="#{facture.total!=0}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{facture.elefacReglement}" width="10%" style="text-align:right;">
                            <f:facet name="header" ><h:outputText  value="Réglements"/></f:facet>
                            <h:outputText  value="#{facture.elefacReglement}" rendered="#{facture.elefacReglement!=0}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{facture.solde}" width="10%" style="text-align:right;">
                            <f:facet name="header" ><h:outputText  value="Solde"/></f:facet>
                            <h:outputText  value="#{facture.solde}" rendered="#{facture.solde!=0}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <h:panelGrid id="idSitTot" width="90%" styleClass="fichefournisseur1" columns="6">
                    <h:column><h:outputText value="Total factures:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.totalFacture}" disabled="true" readonly="true" style="text-align:right">
                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Total règlements:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.totalReglement}" disabled="true" readonly="true" style="text-align:right">
                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Solde:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.sode}" disabled="true" readonly="true" style="text-align:right">
                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGroup>
            <center>
                <a4j:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.retourDocuments}" reRender="modAttente,idSubView"/>
            </center>
        </h:panelGroup>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelFacture" headerClass="headerPanel" width="800" height="350" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelFacture}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelFacture}" var="fac">
            <f:facet name="header"><h:outputText value="GESTION FACTURE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton image="/images/close.gif" id="hidelinkPec" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.fermerFacture}" reRender="panelFacture"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>

                <h:panelGrid width="100%">
                    <rich:tabPanel switchType="client" immediate="true"  id="tabPanelFactureEleve" style="border:0px;">

                        <rich:tab label="Facture">
                            <h:panelGrid id="idMontant" width="100%">
                                <h:panelGrid styleClass="fichefournisseur" id="idMontant1" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                    <h:column><h:outputText style="text-decoration:underline;" value="Classe ou filière:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu id="idClasseItem" style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_filiere}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <f:selectItem itemLabel="Sélection classe ou filière" itemValue="0"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesFiliairesItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.calculeFiliereFacture}" reRender="idMontant,idMontantEcheance"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Année scolaire"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacAnnee}" style="width:85%;color:red;text-align:center"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}"/></h:column>
                                    <rich:spacer></rich:spacer>
                                    <rich:spacer></rich:spacer>
                                    <rich:spacer></rich:spacer>
                                    <rich:spacer></rich:spacer>
                                    <h:column><h:outputText value="Date facturation:"/></h:column>
                                    <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDate}" popup="true"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}"/></h:column>
                                    <h:column><h:outputText value=""/></h:column>
                                    <h:column><h:outputText value=""/></h:column>
                                    <h:column><h:outputText value="Frais inscription:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTarifInscription}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Frais ré-inscription:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTarifReinscription}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Frais dossier:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTarifDossier}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Frais assurance:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTarifDossier}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid styleClass="fichefournisseur" id="idMontant2" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                    <h:column><h:outputText value="Frais scolarité:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTarifScolarite}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Périodicité:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu id="civiliteItem" style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacModeScolarite}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <f:selectItem itemLabel="Mensuel" itemValue="0"/>
                                            <f:selectItem itemLabel="Trimestriel" itemValue="1"/>
                                            <f:selectItem itemLabel="Semestriel" itemValue="2"/>
                                            <f:selectItem itemLabel="Annuel" itemValue="3"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.calculDecoupageFacture}" reRender="idMontantEcheance"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Frais transport:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTarifTransport}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Frais restauration/cantine:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTarifCantine}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid styleClass="fichefournisseur" id="idMontant3" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                    <h:column><h:outputText value="Frais tenue:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTarifTenue}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Frais examens:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTarifExamens}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Frais association étudiante:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTarifAssociation}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Frais divers:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTarifDivers}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab label="Imputations">
                            <h:panelGrid styleClass="fichefournisseur" width="100%" columns="2" columnClasses="clos30,clos70" id="panFiltre">
                                <h:column><h:outputText value="Sélection site:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idSite" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.site}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                        <f:selectItem itemLabel="Tous sites" itemValue="100"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesSitesItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.chargerDepartement}" reRender="panFiltre,idDepartement,idService" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Sélection département:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idDepartement" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.departement}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                        <f:selectItem itemLabel="Tous départements" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesDepartementsItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.chargerService}" reRender="panFiltre,idService" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Sélection service:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idService" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.service}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                        <f:selectItem itemLabel="Tous services" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesServicesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Sélection région:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idRegion" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.region}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                        <f:selectItem itemLabel="Toutes régions" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesRegionsItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.chargerSecteur}" reRender="panFiltre,idSecteur,idPdv" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Sélection secteurs:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idSecteur" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.secteur}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                        <f:selectItem itemLabel="Tous secteurs" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesSecteursItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.chargerPdv}" reRender="panFiltre,idPdv" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Sélection points de vente:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idPdv" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.pdv}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                        <f:selectItem itemLabel="Tous points de vente" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesPdvItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid styleClass="fichefournisseur" width="100%" columns="2" columnClasses="clos30,clos70" id="panFiltre3">
                                <h:column><h:outputText value="Sélection Responsable:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idResponsable" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.responsable}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesUserItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Sélection Commercial:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idCommercial" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.commercial}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesUserItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab label="Echéances" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacType==2}">
                            <h:panelGrid styleClass="fichefournisseur" id="idMontantEcheance" width="100%" columns="1">
                                <h:panelGrid id="idTitre" columns="4" width="100%" style="text-align:center;font-weight:bold;" border="0">
                                    <h:column><h:outputText value="Date"/></h:column>
                                    <h:column><h:outputText value="Scolarité"/></h:column>
                                    <h:column><h:outputText value="Transport"/></h:column>
                                    <h:column><h:outputText value="Cantine"/></h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance01" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche01!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche01}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite01}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport01}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine01}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance02" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche02!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche02}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite02}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport02}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine02}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance03" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche03!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche03}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite03}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport03}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine03}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance04" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche04!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche04}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite04}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport04}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine04}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance05" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche05!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche05}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite05}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport05}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine05}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance06" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche06!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche06}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite06}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport06}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine06}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance07" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche07!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche07}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite07}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport07}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine07}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance08" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche08!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche08}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite08}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport08}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine08}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance09" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche09!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesInscription.eleinsDateEche09}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite09}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport09}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine09}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance10" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche10!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche10}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite10}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport10}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine10}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance11" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche11!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche11}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite11}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport11}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine11}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="idEcheance12" columns="4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche12!=null}">
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacDateEche12}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacScolarite12}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTransport12}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacCantine12}" style="text-align:right;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture=='3'}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="idMontant"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                        </rich:tab>

                    </rich:tabPanel>
                </h:panelGrid>
                <br/>
                <center>
                    <h:panelGroup id="valFacture">
                        <a4j:commandButton title="Recalcul des échéances" image="/images/actualiser.png" style="height:20px;width;20px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.calculDecoupageFacture}" reRender="idMontant,idMontantEcheance" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture!='3'}"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" id="idpanCont" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.saveInscription}" reRender="panelInscription,tableInscription,btnInscription" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_actionFacture!='3'}"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelImpressionSituation" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelPrintSituation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelPrintSituation}" var="prt">
            <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.closeImpressionSituation}" image="/images/close.gif" styleClass="hidelink" reRender="panelImpressionSituation">
                        <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImpSituation" target="_blank">
                <rich:hotKey key="return" handler="return false;"/>
                <center>
                    <h:outputText value="Choisissez un modèle et un format d'Impression"  style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid width="100%">
                    <h:panelGrid id="panelchoixDoc" width="100%" style="border:solid 1px black;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneRadio id="choixDoc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_choix_modele}" >
                            <f:selectItem itemLabel="Facture séléctionnée" itemValue="0"/>
                            <f:selectItem itemLabel="Situation de l`élève" itemValue="1"/>
                            <f:selectItem itemLabel="Reçu facture" itemValue="2"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelchoixDoc,choixDoc,docSelect,listeSelect"/>
                        </h:selectOneRadio>
                        <br>
                        <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.nomModeleDocument}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_choix_modele==0}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.documentImpressionItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu id="listeSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.nomModeleListe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_choix_modele==1}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.listeImpressionItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu id="recuSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.nomModeleRecu}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_choix_modele==2}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.listeRecuItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerJRVSituation}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerPDFSituation}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerODTSituation}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerXLSSituation}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerDOCSituation}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerHTMLSituation}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerXMLSituation}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.envoieMAILSituation}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px black;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue="" />
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelPaye" width="800" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelPaye}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelPaye}" var="pay">
            <f:facet name="header"><h:outputText value="Bon d'encaissement du document"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.annulePaye}" image="/images/close.gif" styleClass="hidelink" reRender="panelPaye"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid id="firstgridd"  width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Date:"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_date_trf}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateVte==0}"/></h:column>
                    <h:column><h:outputText value="N°:"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacNum}" readonly="true"/></h:column>
                    <h:column><h:outputText value="Série:"/></h:column>
                    <h:column>
                        <h:panelGroup>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacSerie}" size="2" readonly="true"/>
                            <h:outputText value="Devise:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}" size="3" readonly="true"/>
                        </h:panelGroup>
                    </h:column>
                    <h:column><h:outputText value="Client:"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.eleves.patronyme}" readonly="true"/></h:column>
                    <h:column><h:outputText value="Responsable:"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacNomResponsable}" readonly="true"/></h:column>
                    <h:column><h:outputText value="Commercial:"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacNomCommercial}" readonly="true"/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column> <h:outputText value="Mode de règlement:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTypeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_verouxModReg}">
                            <f:selectItem itemLabel="Paiement total" itemValue="0"/>
                            <f:selectItem itemLabel="Paiement partiel" itemValue="4"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.chargerModReg}" reRender="firstgridd,colMontInput"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Caisse:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="bnqajt" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_inputCaisse}">
                            <f:selectItem  itemValue="0" itemLabel="Sélectionnez une caisse"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesCaissesSeriesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.choixCaisseXReglementBencaissement}" reRender="firstgridd,idBnq1,idBnq2,idChq1,idChq2,idChq3,idChq4"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Type règlement:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idTypeRegBe" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_type_reg}" style="width:100%;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesTypeReglementsCaisse}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.choixTypeReglementBencaissement}" reRender="firstgridd,idBnq1,idBnq2,idChq1,idChq2,idChq3,idChq4"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Net à payer:"/></h:column>
                    <h:column>
                        <h:inputText style="width:100%;text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_netAPayer}" disabled="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:outputText value="Montant du bon:"/>
                    <h:column id="colMontInput">
                        <h:inputText style="width:100%;text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.montantElmTotBonEnc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_affichMontant}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelPaye" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.verifBonEncaissement}"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText id="idBnq1" value="Banque destination:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_affiche_banque&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_affiche_banque_destination}"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idBnq2" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_banque_destination}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_affiche_banque&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_affiche_banque_destination}">
                            <f:selectItem itemLabel="Inconnue" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesBanquesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column id="idChq1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_affiche_banque}"><h:outputText value="Banque du tireur:"/></h:column>
                    <h:column id="idChq2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_affiche_banque}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_banque_tireur}" maxlength="50" style="text-transform:uppercase"/></h:column>
                    <h:column id="idChq3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_affiche_banque}"><h:outputText value="N° chèque ou bordereau:"/></h:column>
                    <h:column id="idChq4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_affiche_banque}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_num_cheque}" maxlength="50"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTypeReg==4||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTypeReg==5}"><h:outputText value=""/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTypeReg==4||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTypeReg==5}"><h:outputText value=""/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTypeReg==5}"><h:outputText value="Observation parapheur:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTypeReg==5}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacMotifRejetCredit}" readonly="true"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTypeReg==5}"><h:outputText value=""/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTypeReg==5}"><h:outputText value=""/></h:column>
                </h:panelGrid>
                <h:panelGroup id="ppgrp">
                    <center>
                        <br><br>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.miseajourPaye}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_affiche_valide}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPaye,panelBouton,modMessageCommun"/>
                        <br>
                        <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_affiche_valide}" style="margin-left:50px;">
                            <h:graphicImage url="../images/Warning.png"  style="width:25px;height;"/>
                            <h:outputText value="Le montant du bon est supérieur au solde du document" style="color:red;" />
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelPayeXDoc" width="1100" height="550" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelReglement}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelReglement}" var="pay">
            <f:facet name="header"><h:outputText value="Règlement direct de plusieurs documents"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.fermerXReglement}" image="/images/close.gif" styleClass="hidelink" reRender="panelPayeXDoc"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formPayeXDoc">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid id="panelGlobal" width="100%">
                    <h:panelGrid id="firstgridd"  width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Date:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_date_trf}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateVte==0}"/></h:column>
                        <h:column><h:outputText value="Caisse exécutrice:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="bnqajt" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_inputCaisse}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesCaissesSeriesItems}" />
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.choixCaisseXReglement}" reRender="panelGlobal"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Type règlement:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_type_reg}" style="width:100%;">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesTypeReglementsCaisse}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.choixTypeReglement}" reRender="firstgridd,panelGlobal,bnqajt,idEncais2,idImp1,idImp2,table,idBnq1,idBnq2,idEcart3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText id="idImp1" value="Impression: (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.nomRepMod})" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idImp2" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_modele_trf}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesModesleRecus}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText id="idBnq1" value="Banque destination:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_affiche_banque&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_affiche_banque_destination}"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idBnq2" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_banque_destination}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_affiche_banque&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_affiche_banque_destination}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.mesBanquesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:outputText value=""/>
                        <h:outputText value=""/>
                        <h:column> <h:outputText value="Mode de règlement:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.elevesFacture.elefacTypeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_verouxModReg}">
                                <f:selectItem itemLabel="Paiement total" itemValue="0"/>
                                <f:selectItem itemLabel="Paiement partiel" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.chargerModReg}" reRender="firstgridd"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:outputText value=""/>
                        <h:outputText value=""/>
                        <h:outputText value="Montant règlement:"/>
                        <h:column>
                            <h:inputText style="width:100%;text-align:center;font-weight:bold;font-size:50px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.montantElmTotBonEnc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_affichMontant}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.verifValide}" reRender="panelGlobal,ppgrp,idEcart0,idEcart1,idEcart2,idEcart3"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Net à payer:"/></h:column>
                        <h:column>
                            <h:inputText id="idNetPayer" style="width:100%;text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_netAPayer}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Observations:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_objet}" maxlength="50" style="width:50%;"/>&nbsp;&nbsp;
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.repartitionManuelle}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.datamodelTransfert.rowCount>=2}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.controleEcartRepartitionManuelle}" reRender="ppgrp,table,firstgridd,idEcart1,idEcart2"/>
                            </h:selectBooleanCheckbox>&nbsp;
                            <h:outputText value="Répartition manuelle" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.datamodelTransfert.rowCount>=2}"/>
                        </h:column>
                        <h:column><h:outputText value="Ecart:"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.repartitionManuelle}">
                            <h:inputText id="idEcart0" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_ecart_reglement}" readonly="true" style="width:100%;text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.repartitionManuelle}">
                            <h:inputText id="idEcart1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_ecart_reglement}" readonly="true" style="width:45%;text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;&nbsp;
                            <h:inputText id="idEcart2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.ecartManuel}" readonly="true" style="width:45%;text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid id="idEncais2" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_affiche_banque}">
                        <h:column><h:outputText value="Banque du tireur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_banque_tireur}" maxlength="50" style="text-transform:uppercase"/></h:column>
                        <h:column><h:outputText value="N° chèque ou bordereau:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_num_cheque}" maxlength="50"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid id="idEcart3" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.varTypeReg==0}">
                        <h:column><h:outputText value="Montant timbre:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.val_timbre}" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Total dû (réglement + timbre)"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.totalPayerTimbre}" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" enableContextMenu="false" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.datamodelTransfert}" var="var">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.calulNetPayer}" reRender="idNetPayer,panelGalobal"/>
                            <rich:column label="N° facture" sortable="false">
                                <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                <h:outputText value="#{var.elefacNum}"/>
                            </rich:column>
                            <rich:column label="Date facture" sortable="false" width="70px">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{var.elefacDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Série" sortable="false" style="text-align:center;" width="40px">
                                <f:facet name="header"><h:outputText  value="S." /></f:facet>
                                <h:outputText value="#{var.elefacSerie}"/>
                            </rich:column>
                            <rich:column label="Montant T.T.C." sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                <h:outputText  value="#{var.totalTtc}" rendered="#{var.totalTtc!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant Timbre" sortable="false" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.varTypeReg==0}">
                                <f:facet name="header"><h:outputText  value="Timbre"/></f:facet>
                                <h:outputText  value="#{var.var_fac_timbre}" rendered="#{var.var_fac_timbre!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Règlements" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Régl."  /></f:facet>
                                <h:outputText  value="#{var.elefacReglement}" rendered="#{var.elefacReglement!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Solde" sortable="false" style="text-align:right;color:red">
                                <f:facet name="header"> <h:outputText value="Solde"  /></f:facet>
                                <h:outputText  value="#{var.var_reliquat}" rendered="#{var.var_reliquat!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Répartition manuelle" sortable="false" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.repartitionManuelle}">
                                <f:facet name="header"> <h:outputText value="Règlement"/></f:facet>
                                <h:inputText  value="#{var.montantReglementManuel}" style="text-align:right;width:90%;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.controleEcartRepartitionManuelle}" reRender="ppgrp,idEcart1,idEcart2"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Tiers" sortable="false" width="200px">
                                <f:facet name="header"><h:outputText value="Tiers"  /></f:facet>
                                <h:outputText  value="#{var.eleves.patronyme}"/>
                            </rich:column>
                            <rich:column label="Objet de la facture" sortable="false" width="200px">
                                <f:facet name="header"><h:outputText value="Objet"  /></f:facet>
                                <h:outputText  value="#{var.libelleType}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                        <h:panelGroup id="ppgrp">
                            <center>
                                <br><br>
                                <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.validerXreglement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_affiche_valide}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                                <br>
                                <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_affiche_valide}" style="margin-left:50px;">
                                    <h:graphicImage url="/images/Warning.png"  style="width:25px;height;"/>
                                    <h:outputText value="Le montant du bon est supérieur au solde du document" style="color:red;" />
                                </h:panelGroup>
                            </center>
                        </h:panelGroup>
                    </a4j:region>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelImpRecu" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="200" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelPrintRecu}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelPrintRecu}" var="prtrec">
            <f:facet name="header"><h:outputText value="Impression du reçu d'encaissement"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.fermerImpressionRecu}" image="/images/close.gif" styleClass="hidelink" reRender="panelImpRecu"/>
                </a4j:form>
            </f:facet>
            <a4j:form target="_blank">
                <rich:hotKey key="return" handler="return false;"/>
                <center>
                    <h:outputText value="Choisissez un format d'Impression" style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid  width="100%">
                    <h:panelGrid  width="100%" style="border:solid 0px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes du serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerRecuPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                                    <h:selectOneMenu id="impSelect1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerRecuJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerRecuPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerRecuODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerRecuXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerRecuDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerRecuHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.imprimerRecuXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelHistoReglement" width="1000" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelHistoReglement}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.showModalPanelHistoReglement}" var="his">
            <f:facet name="header"><h:outputText value="Historique des règlements"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.fermerHistoReglement}" image="/images/close.gif" styleClass="hidelink" reRender="panelHistoReglement"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  style="width:100%;">
                    <jsp:include flush="true" page="/tiers/EleveFactureCommun.jsp"/>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable height="350px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.datamodelReglement}"  var="recu"  sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeReglementDocument.jsp"/>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>