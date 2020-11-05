<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="tfm">

    <center>
        <a4j:form>

            <center> <h2><h:outputText value="MODES DE REGLEMENTS FOURNISSEURS" style="color:green;"/></h2></center>

            <h:panelGrid id="panelBtnCtiers" width="250px" columns="5">
                <a4j:commandButton title="Ajout règlement fournisseur" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.lanceAjouter}" reRender="panelRegFournisseurs"/>
                <a4j:commandButton title="Modification règlement" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.btnModreglement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.lanceModif}" reRender="panelRegFournisseursModif"/>
                <a4j:commandButton title="Définir par défaut" image="/images/co-chef.png" style="width:26px;height:26px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.btnModreglement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.calculeDefaut}" reRender="tableReglement"/>
                <a4j:commandButton title="Suppression règlement" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.btnModreglement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.majSup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableReglement"/>
                <a4j:commandButton title="Imprimer les modes de règlement des fournisseurs" id="btpanelImp" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
            <br>
            <h:panelGroup>
                <center>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableReglement" activeClass="active-row" noDataLabel=" " style="max-height:100%;border:solid 0px green;cursor:pointer;" styleClass="bg" border="0" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.dataModelReglementFournisseur}" var="Regtiersxml">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" reRender="panelBtnCtiers" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.selectionLigne}" />
                            <rich:column width="5%" sortable="false" style="text-align:center;">
                                <f:facet name="header"><h:outputText value="Défaut"/></f:facet>
                                <h:graphicImage value="/images/co-chef.png" rendered="#{Regtiersxml.aff_defaut}"/>
                            </rich:column>
                            <rich:column width="5%" sortable="false">
                                <f:facet name="header"><h:outputText value="N."/> </f:facet>
                                <h:outputText value="#{Regtiersxml.categories}"></h:outputText>
                            </rich:column>
                            <rich:column width="30%" sortable="false">
                                <f:facet name="header"><h:outputText value="Libellé"/> </f:facet>
                                <h:outputText value="#{Regtiersxml.libelles}"></h:outputText>
                            </rich:column>
                            <rich:column width="15%" sortable="false">
                                <f:facet name="header"><h:outputText value="Echéance"/> </f:facet>
                                <h:outputText value="#{Regtiersxml.libEcheances}"></h:outputText>
                            </rich:column>
                            <rich:column width="5%" sortable="false">
                                <f:facet name="header"><h:outputText value="Nb.J."/> </f:facet>
                                <h:outputText value="#{Regtiersxml.nbjours}"></h:outputText>
                            </rich:column>
                            <rich:column width="5%" sortable="false">
                                <f:facet name="header"><h:outputText value="Ard."/> </f:facet>
                                <h:outputText value="#{Regtiersxml.arrondis}"></h:outputText>
                            </rich:column>
                            <rich:column width="45%" sortable="false">
                                <f:facet name="header"><h:outputText value="Conditions"/> </f:facet>
                                <h:outputText value="#{Regtiersxml.conditions}"></h:outputText>
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

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" id="panelRegFournisseurs" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.afficheModePanelAjt}" width="800" height="300">
        <f:facet name="header">
            <h:panelGroup>
                <h:outputText style="font-weight:bold;font-size:12px;"value="AJOUT DE REGLEMENTS FOURNISSEURS"></h:outputText>
            </h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.closeModif}"  image="/images/close.gif" styleClass="hidelink" id="bpanelRegclients"/>
                <rich:componentControl for="panelRegFournisseurs" attachTo="bpanelRegclients" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>
        <center>
            <a4j:form id="formfmtAFournisseurs" style="width:100%;">
                <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                    <h:column>
                        <h:outputText value="Type:"/>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.code}"   >
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.lesTypeReglements}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Mode échéance:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.modeReg.echeances}" >
                            <f:selectItem itemValue="0"  itemLabel="Paiement comptant" />
                            <f:selectItem  itemValue="1" itemLabel="Paiement terme date de facture" />
                            <f:selectItem  itemValue="2" itemLabel="Paiement terme fin de mois" />
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.visibleNbJArr}" reRender="formfmtAFournisseurs"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column id="nbr" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.testNbrJourArr}">
                        <h:outputText value="Nombre de jour:"/>
                    </h:column>
                    <h:column id="nbrbis" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.testNbrJourArr}">
                        <h:inputText size="5" style="text-align:right;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.modeReg.nbjours}"/>
                    </h:column>
                    <h:column id="ar" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.testNbrJourArr}">
                        <h:outputText value="Arrondi le:"/>
                    </h:column>
                    <h:column id="arbis" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.testNbrJourArr}">
                        <h:inputText size="5" style="text-align:right;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.modeReg.arrondis}"/>
                    </h:column>
                    <h:column><h:outputText value="Condition de règlement:"/></h:column>
                    <h:column>
                        <h:inputTextarea cols="50" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.modeReg.conditions}"/>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid>
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.majAjout}"/>
                    </center>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" id="panelRegFournisseursModif" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.afficheModePanel}" width="800" height="300">
        <f:facet name="header">
            <h:panelGroup>
                <h:outputText style="font-weight:bold;font-size:12px;"value="AJOUT DE REGLEMENTS FOURNISSEURS"></h:outputText>
            </h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.closeModif}"  image="/images/close.gif" styleClass="hidelink" id="bpanelRegclientsModif"/>
                <rich:componentControl for="panelRegFournisseursModif" attachTo="bpanelRegclientsModif" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>
        <center>
            <a4j:form id="formRegFournisseursModif"style="width:100%;">
                <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                    <h:column>
                        <h:outputText value="Type:"/>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.code}"   >
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.lesTypeReglements}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Mode échéance:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.modeReg.echeances}" >
                            <f:selectItem itemValue="0"  itemLabel="Paiement comptant" />
                            <f:selectItem  itemValue="1" itemLabel="Paiement terme date de facture" />
                            <f:selectItem  itemValue="2" itemLabel="Paiement terme fin de mois" />
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.visibleNbJArr}" reRender="formRegFournisseursModif"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.testNbrJourArr}">
                        <h:outputText value="Nombre de jour:"/>
                    </h:column>
                    <h:column  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.testNbrJourArr}">
                        <h:inputText size="5" style="text-align:right;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.modeReg.nbjours}"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.testNbrJourArr}">
                        <h:outputText value="Arrondi le:"/>
                    </h:column>
                    <h:column  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.testNbrJourArr}">
                        <h:inputText size="5" style="text-align:right;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.modeReg.arrondis}"/>
                    </h:column>
                    <h:column><h:outputText value="Condition de règlement:"/></h:column>
                    <h:column>
                        <h:inputTextarea cols="50" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.modeReg.conditions}"/>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid>
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formReglementFournisseur.majModif}"/>
                    </center>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>

</f:subview>