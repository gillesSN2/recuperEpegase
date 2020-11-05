<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="orgcomact">

    <a4j:form id="orgact">

        <center> <h2><h:outputText value="ACTIVITES COMMERCIALES" style="color:green;"/></h2></center>
        <center>
            <h:panelGrid  id="panelmaniact" width="500px" columns="6">
                <a4j:commandButton title="Ajouter une activité" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.ajouterActivites}" reRender="panelActivites"/>
                <a4j:commandButton title="Modifier l'activité" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.modifierActivites}" reRender="panelActivites"/>
                <a4j:commandButton title="Supprimer l'activité" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.supprimerActivites}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="tableActivite,panelmaniact"/>
                <a4j:commandButton title="Imprimer les activités" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
                <a4j:commandButton title="Configurer les découpages de l'activité" image="/images/configuration.png" style="width:20px;height:20px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.configurerDecoupage}"  reRender="panelDecoupage"/>
                <h:selectOneMenu style="width:150px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.codeDecoupage}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.decoupageVisible}">
                    <f:selectItem itemLabel="Sans découpage" itemValue=""/>
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.lesDecoupagesItems}"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.chargeActivite}" reRender="tableActivite"/>
                </h:selectOneMenu>
            </h:panelGrid>
        </center>
        <br>
        <center>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.pageIndex}" reRender="tableActivite" id="scrollTable" maxPages="20"align="left" for="tableActivite"/>
                <rich:extendedDataTable rows="200" id="tableActivite" activeClass="active-row" noDataLabel=" " headerClass="headerTab"  width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.datamodelActivites}" var="act"  >
                    <a4j:support eventsQueue="maQueue"  event="onRowClick"  reRender="panelmaniact" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.selectionActivite}"/>
                    <rich:column sortable="true" sortBy="#{act.actCode}" width="15%" sortOrder="ASCENDING">
                        <f:facet name="header"><h:outputText value="Code"/></f:facet>
                        <h:outputText  value="#{act.actCode}"/>
                    </rich:column >
                    <rich:column sortable="true" sortBy="#{act.actNomFr}" width="30%">
                        <f:facet name="header"><h:outputText value="Activités"/></f:facet>
                        <h:outputText  value="#{act.actNomFr}"/>
                    </rich:column >
                    <rich:column sortable="true" sortBy="#{act.libOptions}" width="10%">
                        <f:facet name="header"><h:outputText value="Options"/></f:facet>
                        <h:outputText  value="#{act.libOptions}"/>
                    </rich:column >
                    <rich:column sortable="true" sortBy="#{act.actRegroupement}" width="15%">
                        <f:facet name="header"><h:outputText value="Regroupement"/></f:facet>
                        <h:outputText value="#{act.actRegroupement}"/>
                    </rich:column >
                    <rich:column sortable="true" sortBy="#{act.actNomResponsable}" width="25%">
                        <f:facet name="header"><h:outputText value="Responsable"/></f:facet>
                        <h:outputText value="#{act.actNomResponsable}"/>
                    </rich:column >
                    <rich:column  width="5%" sortable="true" sortBy="#{act.actInactif}">
                        <f:facet name="header"><h:outputText value="Etat" /></f:facet>
                        <h:commandButton image="#{act.etat}"  rendered="#{act.afficheImag}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </center>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.retourAdminstrationGenerale}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelActivites" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.showmodelPanel}" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="600" height="350">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.showmodelPanel}" var="act">
            <f:facet name="header"><h:outputText value="GESTION DES ACTIVITES"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCancel" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.annulerActivites}" styleClass="hidelink" reRender="panelActivites,tableActivite,panelmaniact"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCancel')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid  id="pgrdAjtAct" width="100%">
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Code:" /></h:column>
                        <h:column id="clnAjtAct">
                            <h:inputText id="AdActCode"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.activites.actCode}" size="7" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.activites.actId!=0}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.verifielesSaisieCodeAct}" reRender="pgrdAjtAct,prgoutpAjtAct"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText  id="outexistCodeAct" style="color:red;" value="Le code est vide ou existe déjà!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.existeCode}"/>
                        </h:column>
                        <h:column><h:outputText value="Libellé:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.activites.actNomFr}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100">
                                <a4j:support eventsQueue="maQueue" event="onchange"  reRender="pgrdAjtAct,prgoutpAjtAct" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.verifielesSaisieLibelleAct}"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Options:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;color:red;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.activites.actOptions}">
                                <f:selectItem itemLabel="Sans option" itemValue="0"/>
                                <f:selectItem itemLabel="N° Contrat" itemValue="1"/>
                                <f:selectItem itemLabel="N° Dossier" itemValue="2"/>
                                <f:selectItem itemLabel="N° Parc" itemValue="3"/>
                                <f:selectItem itemLabel="N° O.R." itemValue="4"/>
                                <f:selectItem itemLabel="N° CMD" itemValue="5"/>
                                <f:selectItem itemLabel="N° Compte Taxe" itemValue="6"/>
                                <f:selectItem itemLabel="N° Tableau" itemValue="7"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.chargeCompteTaxes}" reRender="pgrdAjtAct,idTaxe1,idTaxe2,idTaxe3,idTaxe4"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column id="idTaxe1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.activites.actOptions==6}"><h:outputText value="Compte taxe:"/></h:column>
                        <h:column id="idTaxe2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.activites.actOptions==6}">
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.activites.actCompteTaxe}">
                                <f:selectItem itemLabel="Sélection un compte" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.mesCompteTaxeItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column id="idTaxe3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.activites.actOptions==6}"><h:outputText value="Taux taxe:"/></h:column>
                        <h:column id="idTaxe4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.activites.actOptions==6}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.activites.actTauxTaxe}" style="text-align:right" size="4">
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Regroupement:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.activites.actRegroupement}" size="7" maxlength="20" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Responsable:" /></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.activites.actIdResponsable}" style="width:100%;">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.mesResponsable}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Inactif:" /></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.var_inactif}"/></h:column>
                    </h:panelGrid>

                    <h:panelGroup id="prgoutpAjtAct">
                        <br>
                        <center>
                            <a4j:commandButton id="idValide" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.saveActivites}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.existeCode}" reRender="panelActivites,tableActivite,panelmaniact"/>
                            <rich:hotKey key="return"  handler="#{rich:element('idValide')}.click()" />
                        </center>
                        <br>
                        <center>
                            <h:outputText  id="outpAjtCodLibAct" style="color:red;" value="La saisie du code et du libellé sont obligatoires!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.codelibVide==false}"/>
                        </center>
                    </h:panelGroup>
                </h:panelGrid>

            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelDecoupage" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.showModalPanelDecoupage}" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="450" height="250">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.showModalPanelDecoupage}" var="dec">
            <f:facet name="header"><h:outputText value="CONFIGURATION DES ACTIVITES"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCancelDecoupage" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.fermerDecoupage}" styleClass="hidelink" reRender="panelDecoupage,tableActivite,panelmaniact"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCancelDecoupage')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid columns="2" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Code 1:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strCode1}" size='7' maxlength="20" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Libellé 1:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" size="20" maxlength="100" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Code 2:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strCode2}" size='7' maxlength="20" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Libellé 2:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" size="20" maxlength="100" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Code 3:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strCode3}" size='7' maxlength="20" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Libellé 3:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" size="20" maxlength="100" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Chainage des listes:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strChainageAxes}" style="width:300px;" >
                            <f:selectItem itemLabel="Axes libres" itemValue="0"/>
                            <f:selectItem itemLabel="Axes chainées" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGroup>
                    <br>
                    <center>
                        <a4j:commandButton id="idValDecoupage" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesCommerciales.validerDecoupage}" reRender="panelDecoupage,tableActivite,panelmaniact"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValDecoupage')}.click()" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>