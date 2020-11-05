<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="bnq">

    <center>
        <a4j:form>

            <center> <h2><h:outputText value="LISTE DES BANQUES" style="color:green;"/></h2></center>

            <h:panelGrid id="panelBanque" width="250px" columns="4">
                <a4j:commandButton title="Ajout banque" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBanques.lanceAjouter}" reRender="panelAddBanque"/>
                <a4j:commandButton title="Modification banque" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBanques.btnModBanque}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBanques.lanceModif}" reRender="panelUpdateBanque"/>
                <a4j:commandButton title="Suppression banque" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBanques.btnModBanque}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBanques.supprimer}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableBanque,panelBanque"/>
                <a4j:commandButton title="Imprimer les banques" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
            <br>
            <h:panelGroup>
                <center>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableBanque" activeClass="active-row" noDataLabel=" " style="max-height:100%;border:solid 0px green;cursor:pointer;" styleClass="bg" border="0" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBanques.dataModelBanques}" var="bnq">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" reRender="panelBanque" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBanques.selectionLigne}" />
                            <rich:column width="10%" sortable="false">
                                <f:facet name="header"><h:outputText value="Code"/> </f:facet>
                                <h:outputText value="#{bnq.code}"></h:outputText>
                            </rich:column>
                            <rich:column width="30%" sortable="false">
                                <f:facet name="header"><h:outputText value="Nom de la banque"/> </f:facet>
                                <h:outputText value="#{bnq.libelle}"></h:outputText>
                            </rich:column>
                            <rich:column width="30%" sortable="false">
                                <f:facet name="header"><h:outputText value="SWIFT"/> </f:facet>
                                <h:outputText value="#{bnq.swift}"></h:outputText>
                            </rich:column>
                            <rich:column width="30%" sortable="false">
                                <f:facet name="header"><h:outputText value="IBAN"/> </f:facet>
                                <h:outputText value="#{bnq.iban}"></h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGroup>
            </center>
            <br>
            <center>
                <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
                <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
            </center>
        </a4j:form>
    </center>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" id="panelAddBanque" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBanques.afficheModePanelAjt}" width="500" height="300">
        <f:facet name="header"><h:outputText style="font-weight:bold;font-size:12px;"value="AJOUT DE BANQUE"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBanques.closeModif}"  image="/images/close.gif" styleClass="hidelink" id="bpanelRegclients"/>
                <rich:componentControl for="panelAddBanque" attachTo="panelAddBanque" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>
        <center>
            <a4j:form id="formfmBnq" style="width:100%;">
                <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                    <h:column><h:outputText value="Code:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBanques.code}" maxlength="5" onkeypress="return scanToucheLettre(event)" style="width:50%;text-transform:uppercase" /></h:column>
                    <h:column><h:outputText value="Libelle banque:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBanques.libelle}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" /></h:column>
                    <h:column><h:outputText value="Code SWIFT:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBanques.swift}" maxlength="11" onkeypress="return scanToucheLettre(event)" style="width:60%;text-transform:uppercase" /></h:column>
                    <h:column><h:outputText value="Code IBAN:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBanques.iban}" maxlength="34" onkeypress="return scanToucheLettre(event)" style="width:60%;text-transform:uppercase" /></h:column>
                </h:panelGrid>
                <h:panelGrid>
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBanques.majAjout}"/>
                    </center>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" id="panelUpdateBanque" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBanques.afficheModePanel}" width="500" height="300">
        <f:facet name="header">
            <h:panelGroup>
                <h:outputText style="font-weight:bold;font-size:12px;"value="MODIFICATION BANQUE"></h:outputText>
            </h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBanques.closeModif}"  image="/images/close.gif" styleClass="hidelink" id="bpanelRegclientsModif"/>
                <rich:componentControl for="panelUpdateBanque" attachTo="panelUpdateBanque" operation="hide" event="onclick"/>
            </a4j:form>            
        </f:facet>
        <center>
            <a4j:form id="formRegClientsModif"style="width:100%;">
                 <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                    <h:column><h:outputText value="Code:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBanques.code}" maxlength="5" onkeypress="return scanToucheLettre(event)" style="width:50%;text-transform:uppercase" /></h:column>
                    <h:column><h:outputText value="Libelle banque:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBanques.libelle}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" /></h:column>
                    <h:column><h:outputText value="Code SWIFT:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBanques.swift}" maxlength="11" onkeypress="return scanToucheLettre(event)" style="width:60%;text-transform:uppercase" /></h:column>
                    <h:column><h:outputText value="Code IBAN:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBanques.iban}" maxlength="34" onkeypress="return scanToucheLettre(event)" style="width:60%;text-transform:uppercase" /></h:column>
                 </h:panelGrid>
                <h:panelGrid>
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBanques.majModif}"/>
                    </center>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>

</f:subview>