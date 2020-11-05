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

        <center> <h2><h:outputText value="METIERS DES PERSONNES / ACTIVITES DES SOCIETES" style="color:green;"/></h2></center>
        <center>
            <h:commandButton id="idAddDefault" value="Ajout par Défaut" onclick="if (!confirm('Voulez-vous charger les métiers et les activités par défaut?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesSocietes.defaultAdd}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesSocietes.afficheAjDefaut}" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:180px;cursor:pointer;"/>
            <br>
            <h:panelGrid  id="panelmaniact" width="200px" columns="4">
                <h:commandButton title="Ajouter une activité" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesSocietes.ajouterActivites}"/>
                <h:commandButton title="Modifier l'activité" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesSocietes.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesSocietes.modifierActivites}"  />
                <h:commandButton title="Supprimer l'activité" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesSocietes.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesSocietes.supprimerActivites}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" />
                <a4j:commandButton title="Imprimer les activités" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
        </center>
        <br>
        <center>
            <rich:tabPanel switchType="client" immediate="true" id="tabProduit"  style="border:0px;">

                <rich:tab label="Métiers">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesSocietes.chargerMetiers}" reRender="panMetier"/>
                    <h:panelGrid id="panMetier" width="100%">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable  activeClass="active-row" noDataLabel=" " headerClass="headerTab"  width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesSocietes.datamodelActivites}" var="act">
                                <a4j:support eventsQueue="maQueue"  event="onRowClick"  reRender="panelmaniact" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesSocietes.selectionActivite}"/>
                                <rich:column sortable="true" sortBy="#{act.metNomFr}" width="95%">
                                    <f:facet name="header"><h:outputText value="Mériers"/></f:facet>
                                    <h:outputText  value="#{act.metNomFr}"/>
                                </rich:column >
                                <rich:column  width="5%" sortable="true" sortBy="#{act.metInactif}" style="text-align:center">
                                    <f:facet name="header"><h:outputText value="Etat" /></f:facet>
                                    <a4j:commandButton id="idimage" image="#{act.etat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesSocietes.reactiverActivites}" rendered="#{act.afficheImag}" style="text-align:center" reRender="idimage"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Activités société">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesSocietes.chargerActivites}" reRender="panActivite"/>
                    <h:panelGrid id="panActivite" width="100%">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable  activeClass="active-row" noDataLabel=" " headerClass="headerTab"  width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesSocietes.datamodelActivites}" var="act">
                                <a4j:support eventsQueue="maQueue"  event="onRowClick" reRender="panelmaniact" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesSocietes.selectionActivite}"/>
                                <rich:column sortable="true" sortBy="#{act.metNomFr}" width="95%">
                                    <f:facet name="header"><h:outputText value="Activités"/></f:facet>
                                    <h:outputText  value="#{act.metNomFr}"/>
                                </rich:column >
                                <rich:column  width="5%" sortable="true" sortBy="#{act.metInactif}">
                                    <f:facet name="header"><h:outputText value="Etat" /></f:facet>
                                    <h:commandButton image="#{act.etat}"  rendered="#{act.afficheImag}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>
        </center>
        <center>
            <br>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelActivites" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesSocietes.showmodelPanel}" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="450" height="200">
        <center>
            <f:facet name="header"><h:outputText value="GESTION DES METIERS ET DES ACTIVITES DES SOCIETES"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:commandButton id="idCancel" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesSocietes.annulerActivites}" styleClass="hidelink" />
                    <rich:hotKey key="esc" handler="#{rich:element('idCancel')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid columns="2" id="pgrdAjtAct" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesSocietes.metiers.metNomFr}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                    <h:column><h:outputText value="Inactif:" /></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesSocietes.var_inactif}"/></h:column>
                </h:panelGrid>
                <h:panelGroup id="prgoutpAjtAct">
                    <br>
                    <center>
                        <h:commandButton id="idValide" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesSocietes.saveActivites}"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValide')}.click()" />
                    </center>
                    <br>
                    <center>
                        <h:outputText  id="outpAjtCodLibAct" style="color:red;" value="La saisie du libellé sont obligatoires!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formActivitesSocietes.codelibVide==false}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>

</f:subview>