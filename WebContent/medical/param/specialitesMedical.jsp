<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="jc">

    <a4j:form>

        <center><h2><h:outputText value="LISTE DES SPECIALITES PAR SERVICES" style="color:green;"/></h2></center>

        <h:panelGroup id="panGroupspmed">
            <h:commandButton id="btpanelAjtmed" title="Ajouter" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.chargerPanAdd}">
            </h:commandButton> &nbsp; &nbsp;&nbsp;
            <h:commandButton  id="btpanelModmed" title="Modifier" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.chargerPanAModif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.afficheButtModif}">
            </h:commandButton> &nbsp; &nbsp;&nbsp;
            <h:commandButton id="btpanelSupmed" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.afficheButtSupp}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.deleteSpecialitesMedical}">
            </h:commandButton>&nbsp;&nbsp;&nbsp;
            <a4j:commandButton image="/images/print.png" id="imprimer" oncomplete="javascript:Richfaces.showModalPanel('panelImp');" reRender="panelImp">
            </a4j:commandButton>
        </h:panelGroup>

            <a4j:region renderRegionOnly="false">
        <rich:extendedDataTable border="0" id="mytableauspeMed" footerClass="bard"headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" style="max-height:100%;border:solid 0px green;margin-top:10px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.datamodel}"  var="specialiteMedical">
            <a4j:support eventsQueue="maQueue" event="onRowClick"oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.confirmer}" reRender="panGroupspmed"/>
            <rich:column sortable="true"  width="10%" sortBy="#{specialiteMedical.spemedCode}">
                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                <h:outputText value="#{specialiteMedical.spemedCode}"/>
            </rich:column>
            <rich:column  width="30%" sortable="true" sortBy="#{specialiteMedical.spemedNom}">
                <f:facet name="header"><h:outputText  value="Spécialité"/></f:facet>
                <h:outputText  value="#{specialiteMedical.spemedNom}" />
            </rich:column>
            <rich:column  width="30%" sortable="true" sortBy="#{specialiteMedical.type}">
                <f:facet name="header"><h:outputText  value="type"/></f:facet>
                <h:outputText  value="#{specialiteMedical.type}" />
            </rich:column>
            <rich:column  width="25%" sortable="true" sortBy="#{specialiteMedical.spemedNomResponsable}">
                <f:facet name="header"><h:outputText  value="Chef de service"/></f:facet>
                <h:outputText  value="#{specialiteMedical.spemedNomResponsable}" />
            </rich:column>
            <rich:column  width="5%" sortable="true" sortBy="#{specialiteMedical.spemedInactif}">
                <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                <h:graphicImage value="/images/desactiver.png" rendered="#{specialiteMedical.spemedInactif==1}" title="Service inactif"/>
            </rich:column>
        </rich:extendedDataTable>
        </a4j:region>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelAddspmed" headerClass="headerPanel" style="border:solid 0px black;background-color:white"  width="750" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.showPanAddSpec}">
        <f:facet name="header">
            <center><h:outputText value="AJOUT DE SPECIALITE MEDICALE"/></center>
        </f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:commandButton image="/images/close.gif"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.dechargerPanAdd}"/>
            </a4j:form>
        </f:facet>
        <a4j:form>
            <rich:tabPanel switchType="client" immediate="true"  style="border:0px;">
                <rich:tab label="Général">
                    <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:outputText value="Service:"/>
                        <h:selectOneMenu style="width:250px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.serviceSelected}" >
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.myListSelectItem}"/>
                        </h:selectOneMenu>
                        <h:outputText value="Type:"/>
                        <h:selectOneMenu style="width:250px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedType}" >
                            <f:selectItem itemLabel="Aide aux diagnostics: laboratoire" itemValue="0"/>
                            <f:selectItem itemLabel="Aide aux diagnostics: radiologie" itemValue="1"/>
                            <f:selectItem itemLabel="Service médicaux" itemValue="10"/>
                            <f:selectItem itemLabel="Service chirurgicaux" itemValue="11"/>
                            <f:selectItem itemLabel="Service pharmacie" itemValue="12"/>
                            <f:selectItem itemLabel="Service administratif" itemValue="20"/>
                            <f:selectItem itemLabel="Service technique" itemValue="21"/>
                        </h:selectOneMenu>
                        <h:outputText value="Etat du Service:" style="color:red"/>
                        <h:selectOneMenu style="width:250px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedInactif}" >
                            <f:selectItem itemLabel="Service actif" itemValue="0"/>
                            <f:selectItem itemLabel="Service inactif" itemValue="1"/>
                        </h:selectOneMenu>
                        <h:outputText value=""/>
                        <h:outputText value=""/>
                        <h:outputText value="Pavillion:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedPavillion}" />
                        <h:outputText value="Adresse:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedAdresse}"/>
                        <h:outputText value="Boite postale:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedBP}" />
                        <h:outputText value="Teléphone 1:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedTel1}" />
                        <h:outputText value="Teléphone 2:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedTel2}" />
                        <h:outputText value="Fax:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedFax}" />
                        <h:outputText value="Mail:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedMail}" />
                        <h:outputText value=""/>
                        <h:outputText value=""/>
                        <h:outputText value="Chef de service:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedNomResponsable}" />
                        <h:outputText value="Assistant principal:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedNomAssistant}" />
                        <h:outputText value="Docteur 1:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedDocteur1}" />
                        <h:outputText value="Docteur 2:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedDocteur2}" />
                        <h:outputText value="Docteur 3:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedDocteur3}" />
                        <h:outputText value="Docteur 4:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedDocteur4}" />
                        <h:outputText value="Docteur 5:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedDocteur5}" />
                        <h:outputText value="Docteur 6:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedDocteur6}" />
                        <h:outputText value="Docteur 7:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedDocteur7}" />
                        <h:outputText value="Docteur 8:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedDocteur8}" />
                        <h:outputText value="Docteur 9:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedDocteur9}" />
                        <h:outputText value="Docteur 10:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedDocteur10}" />
                    </h:panelGrid>
                </rich:tab>
            </rich:tabPanel>
            <center>
                <h:panelGroup>
                    <h:commandButton image="/images/valider_big.png" id="btvaldAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.saveSpecialitesMedical}"/>
                </h:panelGroup>
            </center>
        </a4j:form>        
    </rich:modalPanel>


    <!--**********************   Modal panel pour la modification **************************/-->
    <rich:modalPanel domElementAttachment="parent"  id="panelModifspmed" headerClass="headerPanel"  width="750" height="450" style="border:solid 0px black;overflow:auto;background-color:white;" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.showPanModifSpec}" >
        <f:facet name="header">
            <center><h:outputText value="MODIFICATION DE SPECIALITE MEDICALE"/></center>
        </f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:commandButton image="/images/close.gif"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.dechargerPanAModif}"/>
            </a4j:form>
        </f:facet>
        <a4j:form>
            <rich:tabPanel switchType="client" immediate="true"   style="border:0px;">
                <rich:tab label="Spécialité">
                    <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:outputText value="Service:"/>
                        <h:selectOneMenu  readonly="true"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.service.serId}" >
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.myListSelectItem}"/>
                        </h:selectOneMenu>
                        <h:outputText value="Type:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedType}" >
                            <f:selectItem itemLabel="Aide aux diagnostics: laboratoire" itemValue="0"/>
                            <f:selectItem itemLabel="Aide aux diagnostics: radiologie" itemValue="1"/>
                            <f:selectItem itemLabel="Service médicaux" itemValue="10"/>
                            <f:selectItem itemLabel="Service chirurgicaux" itemValue="11"/>
                            <f:selectItem itemLabel="Service pharmacie" itemValue="12"/>
                            <f:selectItem itemLabel="Service administratif" itemValue="20"/>
                            <f:selectItem itemLabel="Service technique" itemValue="21"/>
                        </h:selectOneMenu>
                        <h:outputText value="Etat du Service:" style="color:red"/>
                        <h:selectOneMenu style="width:250px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedInactif}" >
                            <f:selectItem itemLabel="Service actif" itemValue="0"/>
                            <f:selectItem itemLabel="Service inactif" itemValue="1"/>
                        </h:selectOneMenu>
                        <h:outputText value=""/>
                        <h:outputText value=""/>
                        <h:outputText value="Pavillion:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedPavillion}" />
                        <h:outputText value="Adresse:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedAdresse}"/>
                        <h:outputText value="Boite postale:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedBP}" />
                        <h:outputText value="Teléphone 1:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedTel1}" />
                        <h:outputText value="Teléphone 2:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedTel2}" />
                        <h:outputText value="Fax:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedFax}" />
                        <h:outputText value="Mail:"/>                       
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedMail}" />
                        <h:outputText value=""/>
                        <h:outputText value=""/>
                        <h:outputText value="Chef de service:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedNomResponsable}" />
                        <h:outputText value="Assistant principal:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedNomAssistant}" />
                        <h:outputText value="Docteur 1:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedDocteur1}" />
                        <h:outputText value="Docteur 2:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedDocteur2}" />
                        <h:outputText value="Docteur 3:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedDocteur3}" />
                        <h:outputText value="Docteur 4:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedDocteur4}" />
                        <h:outputText value="Docteur 5:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedDocteur5}" />
                        <h:outputText value="Docteur 6:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedDocteur6}" />
                        <h:outputText value="Docteur 7:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedDocteur7}" />
                        <h:outputText value="Docteur 8:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedDocteur8}" />
                        <h:outputText value="Docteur 9:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedDocteur9}" />
                        <h:outputText value="Docteur 10:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.specialitesMedical.spemedDocteur10}" />
                    </h:panelGrid>
                </rich:tab>
            </rich:tabPanel>
            <center>
                <h:panelGroup>
                    <h:commandButton image="/images/valider_big.png" id="btvaldModif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSpecialitesMedical.modifierSpecialitesMedical}"/>
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white"  width="550" height="200">
         <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
