<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="locimmobilisation">

    <a4j:form id="orgact">

        <center> <h2><h:outputText value="LOCALISATIONS IMMOBILISATION" style="color:green;"/></h2></center>
        <center>
            <h:panelGrid  id="panelmaniact" width="250px" columns="6">
                <a4j:commandButton title="Ajouter une localisation" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLocalisationImmobilisation.ajouterLocalisationImmobilisation}" reRender="panelLocalisations"/>
                <a4j:commandButton title="Modifier la localisation" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLocalisationImmobilisation.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLocalisationImmobilisation.modifierLocalisationImmobilisation}" reRender="panelLocalisations"/>
                <a4j:commandButton title="Supprimer la localisation" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLocalisationImmobilisation.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLocalisationImmobilisation.supprimerLocalisationImmobilisation}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="tableLocalisation,panelmaniact"/>
                <a4j:commandButton title="Imprimer les localisations" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
        </center>
        <br>
        <center>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="tableLocalisation" activeClass="active-row" noDataLabel=" " headerClass="headerTab"  width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLocalisationImmobilisation.datamodelLocalisationImmobilisation}" var="loc">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick"  reRender="panelmaniact" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLocalisationImmobilisation.selectionLocalisationImmobilisation}"/>
                    <rich:column sortable="true" sortBy="#{loc.locimmNomFr}" width="30%">
                        <f:facet name="header"><h:outputText value="Localisations"/></f:facet>
                        <h:outputText  value="#{loc.locimmNomFr}"/>
                    </rich:column >
                    <rich:column sortable="true" sortBy="#{loc.locimmLongitude}" width="10%">
                        <f:facet name="header"><h:outputText value="Longitude"/></f:facet>
                        <h:outputText  value="#{loc.locimmLongitude}" rendered="#{loc.locimmLongitude!=0}" style="text-align:right;"/>
                    </rich:column >
                    <rich:column sortable="true" sortBy="#{loc.locimmLatitude}" width="15%">
                        <f:facet name="header"><h:outputText value="Latitude"/></f:facet>
                        <h:outputText value="#{loc.locimmLatitude}" rendered="#{loc.locimmLatitude!=0}" style="text-align:right;"/>
                    </rich:column >
                    <rich:column  width="5%" sortable="true" sortBy="#{loc.locimmInactif}">
                        <f:facet name="header"><h:outputText value="Etat" /></f:facet>
                        <h:commandButton image="#{loc.etat}"  rendered="#{loc.afficheImag}"/>
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


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelLocalisations" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLocalisationImmobilisation.showmodelPanel}" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="450" height="250">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLocalisationImmobilisation.showmodelPanel}" var="act">
            <f:facet name="header"><h:outputText value="GESTION DES LOCALISATIONS"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCancel" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLocalisationImmobilisation.annulerLocalisationImmobilisation}" styleClass="hidelink" reRender="panelLocalisations,tableLocalisation,panelmaniact"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCancel')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid columns="2" id="pgrdAjtAct" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Localisation:" /></h:column>
                    <h:column id="clnAjtAct">
                        <h:inputText id="AdActCode"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLocalisationImmobilisation.localisationImmobilisation.locimmNomFr}" size="7" maxlength="20" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                            <a4j:support eventsQueue="maQueue" event="onchange"  reRender="pgrdAjtAct,prgoutpAjtAct" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLocalisationImmobilisation.verifielesSaisieCodeAct}"/>
                        </h:inputText>&nbsp;&nbsp;
                        <h:outputText  id="outexistCodeAct" style="color:red;" value="Le code est vide ou existe déjà!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLocalisationImmobilisation.existeCode}"/>
                    </h:column>
                    <h:column><h:outputText value="Longitude:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLocalisationImmobilisation.localisationImmobilisation.locimmLongitude}" size="7"/>
                    </h:column>
                    <h:column><h:outputText value="Latitude:" /></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLocalisationImmobilisation.localisationImmobilisation.locimmLatitude}" size="7"/>
                    </h:column>
                    <h:column><h:outputText value="Inactif:" /></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLocalisationImmobilisation.var_inactif}"/></h:column>
                </h:panelGrid>
                <h:panelGroup id="prgoutpAjtAct">
                    <br>
                    <center>
                        <a4j:commandButton id="idValide" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLocalisationImmobilisation.saveLocalisationImmobilisation}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLocalisationImmobilisation.existeCode}" reRender="panelLocalisations,tableLocalisation,panelmaniact"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValide')}.click()" />
                    </center>
                    <br>
                    <center>
                        <h:outputText  id="outpAjtCodLibAct" style="color:red;" value="La saisie du code et du libellé sont obligatoires!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLocalisationImmobilisation.codelibVide==false}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>