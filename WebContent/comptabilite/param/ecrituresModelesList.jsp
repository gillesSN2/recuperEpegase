<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="lisModEcr">

    <a4j:form>

        <center> <h2><h:outputText value="MODELES D`ECRITURES" style="color:green;"/></h2></center>
        <center>
            <h:panelGrid  id="panelmaniact" width="250px" columns="4">
                <a4j:commandButton title="Ajouter un modèle" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.ajouterModele}" reRender="panelModele"/>
                <a4j:commandButton title="Modifier le modèle" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.modifierModele}" reRender="panelModele"/>
                <a4j:commandButton title="Supprimer le modèle" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.supprimerModele}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="tableModele,panelmaniact"/>
                <a4j:commandButton title="Imprimer les modèles" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
        </center>
        <br>
        <center>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="tableModele" activeClass="active-row" noDataLabel=" " headerClass="headerTab"  width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.datamodelEcrituresModeles}" var="mode">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick"  reRender="panelmaniact" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.selectionModele}"/>
                    <rich:column sortable="true" sortBy="#{mode.type}" width="30%">
                        <f:facet name="header"><h:outputText value="Type"/></f:facet>
                        <h:outputText  value="#{mode.type}"/>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{mode.modCode}" width="20%">
                        <f:facet name="header"><h:outputText value="Code"/></f:facet>
                        <h:outputText  value="#{mode.modCode}"/>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{mode.modLibelle}" width="40%">
                        <f:facet name="header"><h:outputText value="Libellé"/></f:facet>
                        <h:outputText  value="#{mode.modLibelle}"/>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{mode.modJournal}" width="10%">
                        <f:facet name="header"><h:outputText value="Journal"/></f:facet>
                        <h:outputText  value="#{mode.modJournal}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </center>

        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>

    </a4j:form>


    <rich:modalPanel headerClass="headerPanel" id="panelModele" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.showmodelPanel}"style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="900" height="550">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.showmodelPanel}" var="act">
            <f:facet name="header"><h:outputText value="DESCRIPTION DU MODELE"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCancel" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.annulerModele}" styleClass="hidelink" reRender="panelModele,panelmaniact"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCancel')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid width="100%" id="pgrdAjtAct">
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Type:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.ecrituresModeles.modType}" style="width:100%" >
                                <f:selectItem itemLabel="Modèle: Ecritures" itemValue="0"/>
                                <f:selectItem itemLabel="Modèle: Amortissements" itemValue="1"/>
                                <f:selectItem itemLabel="Modèle: Notes Externes" itemValue="2"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="pgrdAjtAct"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Code modèle:" /></h:column>
                        <h:column id="clnAjtAct">
                            <h:inputText id="AdActCode"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.ecrituresModeles.modCode}" size="10" maxlength="20" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.ecrituresModeles.modId!=0}">
                                <a4j:support eventsQueue="maQueue" event="onchange"  reRender="pgrdAjtAct,prgoutpAjtAct" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.verifielesSaisieCode}"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText  id="outexistCodeAct" style="color:red;" value="Le code est vide ou existe déjà!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.existeCode}"/>
                        </h:column>
                        <h:column><h:outputText value="Libellé:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.ecrituresModeles.modLibelle}" maxlength="100" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                        <h:column><h:outputText value="Inactif:" /></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.ecrituresModeles.modInactif}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid id="idAmort" columns="2" columnClasses="clos20,clos80" width="100%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.existeCode&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.ecrituresModeles.modType=='1'}">
                        <h:column><h:outputText value="Compte Immobilisation:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.compteImmobilisation}" maxlength="100" style="width:100%">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.rechcherCompteImmo}"  onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPlCompte"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Compte Amortissement:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.compteAmortissement}" maxlength="100" style="width:100%">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.rechcherCompteAmo}"  onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPlCompte"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Compte Dotation:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.compteDotation}" maxlength="100" style="width:100%">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.rechcherCompteDot}"  onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPlCompte"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Compte Cession:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.compteCession}" maxlength="100" style="width:100%">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.rechcherCompteCes}"  onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPlCompte"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.existeCode&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.ecrituresModeles.modType!='1'}">
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Journal comptable:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.ecrituresModeles.modJournal}" style="width:100%;" >
                                    <f:selectItem itemLabel="Sélectionnez un journal" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.mesJournaux}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.ecrituresModeles.modType=='2'}" var="nex">
                            <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="Nature:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.ecrituresModeles.modNature}" style="width:100%;" >
                                        <f:selectItem itemLabel="Carburant" itemValue="0"/>
                                        <f:selectItem itemLabel="Amende" itemValue="1"/>
                                        <f:selectItem itemLabel="Péage" itemValue="2"/>
                                        <f:selectItem itemLabel="Taxi" itemValue="3"/>
                                        <f:selectItem itemLabel="Transport Urbain" itemValue="4"/>
                                        <f:selectItem itemLabel="Restaurant Seul" itemValue="5"/>
                                        <f:selectItem itemLabel="Restaurant avec client" itemValue="6"/>
                                        <f:selectItem itemLabel="Hébergement" itemValue="7"/>
                                        <f:selectItem itemLabel="Entretien véhicule" itemValue="8"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </c:if>
                        <h:panelGrid  id="panelcompte" width="200px" columns="3">
                            <a4j:commandButton title="Ajouter un compte" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.ajouterCompte}" reRender="panelCompte"/>
                            <a4j:commandButton title="Modifier le compte" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.ecrituresModelesLignes.modligId!=0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.modifierCompte}" reRender="panelCompte"/>
                            <a4j:commandButton title="Supprimer le compte" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.ecrituresModelesLignes.modligId!=0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.supprimerCompte}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="tableLigne,panelCompte"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableLigne" activeClass="active-row" noDataLabel=" " headerClass="headerTab"  width="100%" height="300px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.datamodelEcrituresModelesLignes}" var="lig">
                                <a4j:support eventsQueue="maQueue"  event="onRowClick"  reRender="panelcompte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.selectionCompte}"/>
                                <rich:column sortable="true" sortBy="#{lig.modligCompte}" width="20%">
                                    <f:facet name="header"><h:outputText value="Compte"/></f:facet>
                                    <h:outputText value="#{lig.modligCompte}"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{lig.modligLibelle}" width="30%">
                                    <f:facet name="header"><h:outputText value="Intitulé"/></f:facet>
                                    <h:outputText value="#{lig.modligLibelle}"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{lig.libelleSens}" width="10%">
                                    <f:facet name="header"><h:outputText value="Sens"/></f:facet>
                                    <h:outputText value="#{lig.libelleSens}" style="text-align:center"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{lig.modligTaux}" width="10%">
                                    <f:facet name="header"><h:outputText value="Taux"/></f:facet>
                                    <h:outputText value="#{lig.modligTaux}" rendered="#{lig.modligTaux!=0}" style="text-align:right"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{lig.modligTc}" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}">
                                    <f:facet name="header"><h:outputText value="Taux"/></f:facet>
                                    <h:outputText value="#{lig.modligTc}" rendered="#{lig.modligTc!=0}" style="text-align:right"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{lig.libelleCalcul}" width="20%">
                                    <f:facet name="header"><h:outputText value="Calcul"/></f:facet>
                                    <h:outputText value="#{lig.libelleCalcul}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </h:panelGrid>
                <h:panelGroup id="prgoutpAjtAct">
                    <br>
                    <center>
                        <a4j:commandButton id="idValide" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.saveModele}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.existeCode}" reRender="panelModele,tableModele,panelmaniact"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValide')}.click()" />
                    </center>
                    <br>
                    <center>
                        <h:outputText  id="outpAjtCodLibAct" style="color:red;" value="La saisie du code et du libellé sont obligatoires!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.codelibVide==false}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel headerClass="headerPanel" id="panelCompte" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.showmodelPanelCompte}" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="200">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.showmodelPanelCompte}" var="cpt">
            <f:facet name="header"><h:outputText value="SELECTION COMPTE"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCancelCpte" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.annulerCompte}" styleClass="hidelink" reRender="panelCompte,panelCompte"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCancelCpte')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                    <h:column><h:outputText value="Compte:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.compte}" maxlength="100" style="width:100%">
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.rechcherCompteGene}"  onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPlCompte"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                    <h:column><h:outputText value="Sens:"/></h:column>
                    <h:column>
                        <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.ecrituresModelesLignes.modligSens}" style="width:100%" >
                            <f:selectItem itemLabel="Débit" itemValue="0"/>
                            <f:selectItem itemLabel="Crédit" itemValue="1"/>
                        </h:selectOneRadio>
                    </h:column>
                    <h:column><h:outputText value="Taux TVA:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.ecrituresModelesLignes.modligTaux}" size="5">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:outputText value="Taux CSS:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}">
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.ecrituresModelesLignes.modligTc}" size="5">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Calcul:"/></h:column>
                    <h:column>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}" var="gab">
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.ecrituresModelesLignes.modligCalcul}" style="width:100%;" >
                                <f:selectItem itemLabel="= Montant saisie" itemValue="0"/>
                                <f:selectItem itemLabel="= Calcule TVA" itemValue="1"/>
                                <f:selectItem itemLabel="= Extraction TVA" itemValue="2"/>
                                <f:selectItem itemLabel="= Calcule TPS" itemValue="3"/>
                                <f:selectItem itemLabel="= Extraction TPS" itemValue="4"/>
                                <f:selectItem itemLabel="= Calcule CSS" itemValue="5"/>
                                <f:selectItem itemLabel="= Extraction CSS" itemValue="6"/>
                                <f:selectItem itemLabel="= Calcule H.T." itemValue="7"/>
                                <f:selectItem itemLabel="= Calcule T.T.C.." itemValue="8"/>
                            </h:selectOneMenu>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays!='0077'}" var="aut">
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.ecrituresModelesLignes.modligCalcul}" style="width:100%;" >
                                <f:selectItem itemLabel="= Montant saisie" itemValue="0"/>
                                <f:selectItem itemLabel="= Calule TVA" itemValue="1"/>
                                <f:selectItem itemLabel="= Extraction TVA" itemValue="2"/>
                                <f:selectItem itemLabel="= Calcule TPS" itemValue="3"/>
                                <f:selectItem itemLabel="= Extraction TPS" itemValue="4"/>
                                <f:selectItem itemLabel="= Calcule H.T." itemValue="7"/>
                                <f:selectItem itemLabel="= Calcule T.T.C." itemValue="8"/>
                            </h:selectOneMenu>
                        </c:if>
                    </h:column>
                </h:panelGrid>
                <h:panelGroup id="prgoutpAjtCpte">
                    <br>
                    <center>
                        <a4j:commandButton id="idValideCpte" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.saveCompte}" reRender="panelCompte,tableLigne,panelcompte"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValideCpte')}.click()" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel headerClass="headerPanel" id="panelPlCompte" width="900" height="550" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.showmodelPanelPlCompte}" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" >
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.showmodelPanelPlCompte}" var="plc">
            <f:facet name="header"><h:outputText value="AJOUT DE COMPTE COMPTABLE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton id="idCancelPlCpte" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.fermerCompte}" styleClass="hidelink" reRender="panelPlCompte"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCancelPlCpte')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableCompteListe"/>
                <rich:extendedDataTable rows="100" id="tableCompteListe" height="400px" width="100%" headerClass="headerTab" selectedClass="active-row" var="cpte" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.dataModelPlbCompte}">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" reRender="idPlCpte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.selectionPlCompte}"/>
                    <rich:column  width="20%" sortable="true" sortBy="#{cpte.plcCompte}" filterBy="#{cpte.plcCompte}">
                        <f:facet name="header"><h:outputText  value="COMPTE" /></f:facet>
                        <h:outputText value="#{cpte.plcCompte}"/>
                    </rich:column>
                    <rich:column  width="75%" sortable="true" sortBy="#{cpte.plcLibelleCpteFR}" filterBy="#{cpte.plcLibelleCpteFR}">
                        <f:facet name="header"><h:outputText  value="LIBELLE" /></f:facet>
                        <h:outputText value="#{cpte.plcLibelleCpteFR}" />
                    </rich:column>
                </rich:extendedDataTable>
                <br><br>
                <center>
                    <h:panelGroup id="idPlCpte">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.validerCompte}" reRender="panelPlCompte,panelCompte,idAmort" style="text-decoration:none;" id="idVal" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formModelesEcritures.planComptable.plcId!=0}">
                            <rich:componentControl for="panelPlCompte" attachTo="idVal" operation="hide" event="onclick"/>
                        </a4j:commandButton>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>