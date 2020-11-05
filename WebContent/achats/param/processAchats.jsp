<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="lp">

    <a4j:form id="form">

        <center><h2><h:outputText value="LISTE DES PROCESS" style="color:green;"/></h2></center>

        <h:panelGrid id="panelBouton" columns="6" width="350px">
            <a4j:commandButton title="Ajouter un nouveau process" image="/images/ajouter.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.ajouterProcess}" reRender="panelProcess"/>
            <a4j:commandButton title="Modfier le process sélectionné" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.modifierProcess}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.var_affiche_bouton}" reRender="panelProcess"/>
            <a4j:commandButton title="Supprimer le process sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.var_affiche_bouton}"  onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.supprimerProcess}" reRender="modAttente,panelBouton,tableProcess"/>
            <a4j:commandButton title="Imprimer la liste des process" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"></a4j:commandButton>
            <a4j:commandButton title="Imprimer le détail du process sélectionné" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.var_affiche_bouton}" oncomplete="javascript:Richfaces.showModalPanel('panelImpStructure');"></a4j:commandButton>
            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.filtreService}">
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.mesServicesRecItems}"/>
                <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelBouton,tableProcess"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.selectionService}"/>
            </h:selectOneMenu>
        </h:panelGrid>
        <br>
        <h:panelGrid id="tableau" border="0" width="100%" style="text-align:center;">

            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="tableProcess" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" "  rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.datamodelProcessEntete}" var="process">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.selectionProcess}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton"/>
                    <rich:column style="text-align:left;" width="10%">
                        <f:facet name="header"><h:outputText  value="Code produit"/></f:facet>
                        <h:outputText  value="#{process.procesCode}"/>
                    </rich:column>
                    <rich:column style="text-align:left;" width="30%">
                        <f:facet name="header"><h:outputText  value="Libellé produit"/></f:facet>
                        <h:outputText  value="#{process.procesLibClient}"/>
                    </rich:column>
                    <rich:column style="text-align:left;" width="15%">
                        <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                        <h:outputText  value="#{process.procesService}" rendered="#{process.procesOption2=='0'}"/>
                    </rich:column>
                    <rich:column style="text-align:left;" width="15%">
                        <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                        <h:outputText  value="#{process.procesDepot}" rendered="#{process.procesOption2=='0'}"/>
                    </rich:column>
                    <rich:column style="text-align:left;" width="10%">
                        <f:facet name="header"><h:outputText  value="Stock"/></f:facet>
                        <h:outputText  value="#{process.modeStock}" rendered="#{process.procesOption2=='0'}"/>
                    </rich:column>
                    <rich:column style="text-align:left;" width="10%">
                        <f:facet name="header"><h:outputText  value="Création lot"/></f:facet>
                        <h:outputText  value="#{process.libelleCreationLot}" rendered="#{process.procesOption2=='0'}"/>
                    </rich:column>
                    <rich:column style="text-align:left;" width="10%">
                        <f:facet name="header"><h:outputText  value="Conditionnement"/></f:facet>
                        <h:outputText  value="#{process.procesCondition}" rendered="#{process.procesOption2=='0'}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </h:panelGrid>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelProcess" width="1100" height="630" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.showModalPanelProcess}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.showModalPanelProcess}" var="det">
            <f:facet name="header"><h:outputText value="DETAIL D'UN PROCESS"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.annulerProcess}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelProcess,panelBouton"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid width="100%" id="idPanalGlobal">
                    <h:panelGrid columns="4" width="100%" id="idProcessProduit" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Mode process:" style="color:red"/></h:column>
                        <h:column>
                            <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesId!=0}">
                                <f:selectItem itemLabel="Lié à un produit" itemValue="0"/>
                                <f:selectItem itemLabel="Libre" itemValue="1"/>
                                <a4j:support event="onchange" eventsQueue="maQueue" reRender="idProcessProduit,idDetail"/>
                            </h:selectOneRadio>
                        </h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='0'}"><h:outputText value="Code produit:" style="text-decoration:underline"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='0'}">
                            <h:inputText id="inpCodDet" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesCode}">
                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.rechercheProduitsFabrique}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeProduits,idPanalGlobal,idProcessProduit,idDetail"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='1'}"><h:outputText value="Code produit:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='1'}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesCode}"/>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='0'}"><h:outputText value="Libellé produit:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='0'}"><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesLibClient}" readonly="true"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='1'}"><h:outputText value="Libellé process:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='1'}"><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesLibClient}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='0'}"><h:outputText value="Dépôt:" style="text-decoration:underline"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='0'}">
                            <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesDepot}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.mesProduitsDepotsItems}"/>
                            </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                            <h:outputText value="Service:" style="text-decoration:underline"/>&nbsp;
                            <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesService}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.mesServicesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='1'}"><h:outputText value="Service:" style="text-decoration:underline"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='1'}">
                            <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesService}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.mesServicesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='0'}"><h:outputText value="Libellé technique:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='0'}"><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesLibTech}" readonly="true"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='0'}"><h:outputText value="Unité:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='0'}">
                            <h:inputText style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesUnite}"/>&nbsp;&nbsp;&nbsp;
                            <h:outputText value="Mode stock:" style="text-decoration:underline"/>&nbsp;
                            <h:selectOneMenu style="width:130px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesStock}" disabled="true">
                                <f:selectItem itemLabel="Sans stock" itemValue="0"/>
                                <f:selectItem itemLabel="Stock simple" itemValue="1"/>
                                <f:selectItem itemLabel="LIFO (lot)" itemValue="2"/>
                                <f:selectItem itemLabel="FIFO (lot)" itemValue="3"/>
                                <f:selectItem itemLabel="Péremption (lot)" itemValue="4"/>
                                <f:selectItem itemLabel="Sérialisé" itemValue="5"/>
                                <f:selectItem itemLabel="Consigne" itemValue="6" itemDisabled="true"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idProcessProduit,idModeLot1,idModeLot2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="false"><h:outputText value="Coefficient:"/></h:column>
                        <h:column rendered="false"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesCoef}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='0'}"><h:outputText value="Conditionnement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.var_aff_condit}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='0'}">
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesCondition}" style="width:100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.var_aff_condit}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.mesConditionnementsProduits}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid==110||bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid==113)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.afficheSuffixe&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='0'}"><h:outputText value="Suffixe:"/></h:column>
                        <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid==110||bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid==113)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.afficheSuffixe&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='0'}">
                            <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesSuffixe}">
                                <f:selectItem itemLabel="Sélectionnez Suffixe" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.mesSuffixeProductionItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Option 1:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption1}">
                                <f:selectItem itemLabel="Saisie des quantités consommées" itemValue="0"/>
                                <f:selectItem itemLabel="Saisie des quantités restantes" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Process Inactif:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.inactif}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='0'}"><h:outputText value="Création lot:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='0'}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.creationLot}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" id="idDetail" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.produitsFabrique.proId!='0')||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='1'}">
                        <rich:tabPanel switchType="client" immediate="true" id="tabPanel" style="border:0px;">

                            <rich:tab label="Produits générés" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesOption2=='1'}">
                                <h:panelGrid width="100%" id="idGlobalGenere">
                                    <h:panelGrid width="150px" columns="2" id="idPanelGenere">
                                        <a4j:commandButton title="Ajouter un nouveau produit" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.ajouterGeneres}" reRender="idSaisieGenere,idPanelGenere"/>
                                        <a4j:commandButton title="Supprimer le produit sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processIntrantAchats.procesligId!='0'}"  onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.supprimerGeneres}" reRender="idGlobalGenere,idSaisieGenere,tableGenere"/>
                                    </h:panelGrid>
                                    <h:panelGrid width="100%" id="idSaisieGenere" columns="11" style="border:1px solid green;background-color:#FFF8D4;">
                                        <h:column><h:outputText value="Code produit:" style="text-decoration:underline"/></h:column>
                                        <h:column>
                                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processGenereAchats.procesligCode}">
                                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.rechercheProduitsGenere}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeProduits,idSaisieGenere"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column><h:outputText value="Libellé produit:"/></h:column>
                                        <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processGenereAchats.procesligLibClient}" readonly="true"/></h:column>
                                        <h:column><h:outputText value="Dépôt:" style="text-decoration:underline"/></h:column>
                                        <h:column>
                                            <h:selectOneMenu style="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processGenereAchats.procesligDepot}">
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.mesProduitsDepotsGenereItems}"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column><h:outputText value="Unité:"/></h:column>
                                        <h:column><h:inputText size="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processGenereAchats.procesligUnite}"/></h:column>
                                        <h:column>
                                            <a4j:commandButton image="/images/valider_big.png" id="idValLigne0" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.saveGeneres}" reRender="tableGenere,idSaisieGenere,idPanelGenere,idGlobalGenere"/>
                                            <rich:hotKey key="return"  handler="#{rich:element('idValLigne0')}.click()" />
                                        </h:column>
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable id="tableGenere" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="250px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.datamodelProcessGenere}" var="gn">
                                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.selectionGeneres}" reRender="idPanelGenere,idSaisieGenere"/>
                                            <rich:column style="text-align:left;" width="20%">
                                                <f:facet name="header"><h:outputText  value="Code produit"/></f:facet>
                                                <h:outputText  value="#{gn.procesligCode}"/>
                                            </rich:column>
                                            <rich:column style="text-align:left;" width="40%">
                                                <f:facet name="header"><h:outputText  value="Libellé produit"/></f:facet>
                                                <h:outputText  value="#{gn.procesligLibClient}"/>
                                            </rich:column>
                                            <rich:column style="text-align:left;" width="20%">
                                                <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                                <h:outputText  value="#{gn.procesligDepot}"/>
                                            </rich:column>
                                            <rich:column style="text-align:left;" width="20%">
                                                <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                                <h:outputText  value="#{gn.procesligUnite}"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:panelGrid>
                            </rich:tab>

                            <rich:tab label="Intrants utilisés">
                                <h:panelGrid width="100%" id="idGlobalIntrant">
                                    <h:panelGrid width="150px" columns="4" id="idPanelIntrant">
                                        <a4j:commandButton title="Ajouter un nouveau produit simple" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.ajouterIntrants}" reRender="idSaisieIntrant,idPanelIntrant"/>
                                        <a4j:commandButton title="Ajouter un produit interchangeable" image="/images/imputer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.ajouterProduitInterchangeable}" reRender="panelProduitInterchangeable"/>
                                        <a4j:commandButton title="Modifier le produit interchangeable" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.modifierProduitInterchangeable}" reRender="panelProduitInterchangeable" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processIntrantAchats.procesligId!='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processIntrantAchats.procesligInterChange==true}" />
                                        <a4j:commandButton title="Supprimer le produit sélectionné (simple ou interchangeable)" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processIntrantAchats.procesligId!='0'}"  onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.supprimerIntrants}" reRender="idGlobalIntrant,idSaisieIntrant,tableIntrant"/>
                                    </h:panelGrid>
                                    <h:panelGrid width="100%" id="idSaisieIntrant" columns="11" style="border:1px solid green;background-color:#FFF8D4;">
                                        <h:column><h:outputText value="Code produit:" style="text-decoration:underline"/></h:column>
                                        <h:column>
                                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processIntrantAchats.procesligCode}">
                                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.rechercheProduitsUtilise}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeProduits,idSaisieIntrant"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column><h:outputText value="Libellé produit:"/></h:column>
                                        <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processIntrantAchats.procesligLibClient}" readonly="true"/></h:column>
                                        <h:column><h:outputText value="Dépôt:" style="text-decoration:underline"/></h:column>
                                        <h:column>
                                            <h:selectOneMenu style="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processIntrantAchats.procesligDepot}">
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.mesProduitsDepotsIntrantsItems}"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column><h:outputText value="Unité:"/></h:column>
                                        <h:column><h:inputText size="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processIntrantAchats.procesligUnite}"/></h:column>
                                        <h:column><h:outputText value="Qte:"/></h:column>
                                        <h:column>
                                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processIntrantAchats.procesligQte}" style="text-align:right;">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.optionStocks.nbDecQteProd}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.optionStocks.nbDecQteProd}"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column>
                                            <a4j:commandButton image="/images/valider_big.png" id="idValLigne1" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.saveIntrants}" reRender="tableIntrant,idSaisieIntrant,idPanelIntrant,idGlobalIntrant"/>
                                            <rich:hotKey key="return"  handler="#{rich:element('idValLigne1')}.click()" />
                                        </h:column>
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable id="tableIntrant" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="250px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.datamodelProcessIntrant}" var="in">
                                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.selectionIntrants}" reRender="idPanelIntrant,idSaisieIntrant"/>
                                            <rich:column style="text-align:left;" width="10%">
                                                <f:facet name="header"><h:outputText  value="Code produit"/></f:facet>
                                                <h:outputText  value="#{in.procesligCode}"/>
                                            </rich:column>
                                            <rich:column style="text-align:left;" width="40%">
                                                <f:facet name="header"><h:outputText  value="Libellé produit"/></f:facet>
                                                <h:outputText  value="#{in.procesligLibClient}"/>
                                            </rich:column>
                                            <rich:column style="text-align:center;" width="10%">
                                                <f:facet name="header"><h:outputText  value="Interchange"/></f:facet>
                                                <h:selectBooleanCheckbox  value="#{in.procesligInterChange}" readonly="true" disabled="true"/>
                                            </rich:column>
                                            <rich:column style="text-align:left;" width="10%">
                                                <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                                <h:outputText  value="#{in.procesligDepot}" rendered="#{in.procesligInterChange==false}"/>
                                            </rich:column>
                                            <rich:column style="text-align:left;" width="10%">
                                                <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                                <h:outputText  value="#{in.procesligUnite}"/>
                                            </rich:column>
                                            <rich:column style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText  value="Qte R."/></f:facet>
                                                <h:outputText  value="#{in.procesligQte}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.optionStocks.nbDecQteProd}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.optionStocks.nbDecQteProd}"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column style="text-align:right;" width="10%"  rendered="false">
                                                <f:facet name="header"><h:outputText  value="Qte --"/></f:facet>
                                                <h:outputText  value="#{in.procesligQteSur}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.optionStocks.nbDecQteProd}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.optionStocks.nbDecQteProd}"/>
                                                </h:outputText>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:panelGrid>
                            </rich:tab>

                            <rich:tab label="Sous produits générés">
                                <h:panelGrid width="100%" id="idGlobalSousProduit">
                                    <h:panelGrid width="150px" columns="2" id="idPanelSousProduit">
                                        <a4j:commandButton title="Ajouter un nouveau sous produit" image="/images/ajouter.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.ajouterSousProduits}" reRender="idSaisieSousProduit,idPanelSousProduit"/>
                                        <a4j:commandButton title="Supprimer le sous produit sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processSousProduitAchats.procesligId!='0'}"  onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.supprimerSousProduits}" reRender="idSaisieSousProduit,tableSousProduit"/>
                                    </h:panelGrid>
                                    <h:panelGrid width="100%" id="idSaisieSousProduit" columns="11" style="border:1px solid green;background-color:#FFF8D4;">
                                        <h:column><h:outputText value="Code produit:" style="text-decoration:underline"/></h:column>
                                        <h:column>
                                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processSousProduitAchats.procesligCode}">
                                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.rechercheSousProduits}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeProduits,idSaisieSousProduit"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column><h:outputText value="Libellé produit:"/></h:column>
                                        <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processSousProduitAchats.procesligLibClient}" readonly="true"/></h:column>
                                        <h:column><h:outputText value="Dépôt:" style="text-decoration:underline"/></h:column>
                                        <h:column>
                                            <h:selectOneMenu style="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processSousProduitAchats.procesligDepot}">
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.mesProduitsDepotsSousProduitItems}"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column><h:outputText value="Unité:"/></h:column>
                                        <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processSousProduitAchats.procesligUnite}" readonly="true"/></h:column>
                                        <h:column><h:outputText value="Qte:"/></h:column>
                                        <h:column>
                                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processSousProduitAchats.procesligQte}" style="text-align:right;">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.optionStocks.nbDecQteProd}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.optionStocks.nbDecQteProd}"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column>
                                            <a4j:commandButton  image="/images/valider_big.png" id="idValLigne2" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.saveSousProduits}" reRender="tableSousProduit,idSaisieSousProduit,idPanelSousProduit,idGlobalSousProduit"/>
                                            <rich:hotKey key="return"  handler="#{rich:element('idValLigne2')}.click()" />
                                        </h:column>
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable id="tableSousProduit" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="250px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.datamodelProcessSousProduit}" var="sp">
                                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.selectionSousProduits}" reRender="idPanelSousProduit,idSaisieSousProduit"/>
                                            <rich:column style="text-align:left;" width="10%">
                                                <f:facet name="header"><h:outputText  value="Code produit"/></f:facet>
                                                <h:outputText  value="#{sp.procesligCode}"/>
                                            </rich:column>
                                            <rich:column style="text-align:left;" width="60%">
                                                <f:facet name="header"><h:outputText  value="Libellé produit"/></f:facet>
                                                <h:outputText  value="#{sp.procesligLibClient}"/>
                                            </rich:column>
                                            <rich:column style="text-align:left;" width="10%">
                                                <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                                <h:outputText  value="#{sp.procesligDepot}"/>
                                            </rich:column>
                                            <rich:column style="text-align:left;" width="10%">
                                                <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                                <h:outputText  value="#{sp.procesligUnite}"/>
                                            </rich:column>
                                            <rich:column style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText  value="Qte"/></f:facet>
                                                <h:outputText  value="#{sp.procesligQte}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.optionStocks.nbDecQteProd}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.optionStocks.nbDecQteProd}"/>
                                                </h:outputText>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:panelGrid>
                            </rich:tab>

                            <rich:tab label="Déchets générés">
                                <h:panelGrid width="100%" id="idGlobalDechet">
                                    <h:panelGrid width="150px" columns="2" id="idPanelDechet">
                                        <a4j:commandButton title="Ajouter un nouveau déchet" image="/images/ajouter.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.ajouterDechets}" reRender="idSaisieDechet,idPanelDechet"/>
                                        <a4j:commandButton title="Supprimer le déchet sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processDechetAchats.procesligId!='0'}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.supprimerDechets}" reRender="idSaisieDechet,tableDechet"/>
                                    </h:panelGrid>
                                    <h:panelGrid width="100%" id="idSaisieDechet" columns="11" style="border:1px solid green;background-color:#FFF8D4;">
                                        <h:column><h:outputText value="Code produit:" style="text-decoration:underline"/></h:column>
                                        <h:column>
                                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processDechetAchats.procesligCode}">
                                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.rechercheDechets}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeProduits,idSaisieDechet"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column><h:outputText value="Libellé produit:"/></h:column>
                                        <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processDechetAchats.procesligLibClient}" readonly="true"/></h:column>
                                        <h:column><h:outputText value="Dépôt:" style="text-decoration:underline"/></h:column>
                                        <h:column>
                                            <h:selectOneMenu style="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processDechetAchats.procesligDepot}">
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.mesProduitsDepotsDechetItems}"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column><h:outputText value="Unité:"/></h:column>
                                        <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processDechetAchats.procesligUnite}" readonly="true"/></h:column>
                                        <h:column><h:outputText value="Qte:"/></h:column>
                                        <h:column>
                                            <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processDechetAchats.procesligQte}" style="text-align:right;">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.optionStocks.nbDecQteProd}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.optionStocks.nbDecQteProd}"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column>
                                            <a4j:commandButton  image="/images/valider_big.png" id="idValLigne3" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.saveDechets}" reRender="tableDechet,idSaisieDechet,idPanelDechet,idGlobalDechet"/>
                                            <rich:hotKey key="return"  handler="#{rich:element('idValLigne3')}.click()" />
                                        </h:column>
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable id="tableDechet" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" "  rowClasses="rows1,rows2,rowsd" width="100%" height="250px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.datamodelProcessDechet}" var="dc">
                                            <a4j:support eventsQueue="maQueue" event="onRowClick"oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.selectionDechets}" reRender="idPanelDechet,idSaisieDechet"/>
                                            <rich:column style="text-align:left;" width="10%">
                                                <f:facet name="header"><h:outputText  value="Code produit"/></f:facet>
                                                <h:outputText  value="#{dc.procesligCode}"/>
                                            </rich:column>
                                            <rich:column style="text-align:left;" width="60%">
                                                <f:facet name="header"><h:outputText  value="Libellé produit"/></f:facet>
                                                <h:outputText  value="#{dc.procesligLibClient}"/>
                                            </rich:column>
                                            <rich:column style="text-align:left;" width="10%">
                                                <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                                <h:outputText  value="#{dc.procesligDepot}"/>
                                            </rich:column>
                                            <rich:column style="text-align:left;" width="10%">
                                                <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                                <h:outputText  value="#{dc.procesligUnite}"/>
                                            </rich:column>
                                            <rich:column style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText  value="Qte"/></f:facet>
                                                <h:outputText  value="#{dc.procesligQte}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.optionStocks.nbDecQteProd}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.optionStocks.nbDecQteProd}"/>
                                                </h:outputText>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:panelGrid>
                            </rich:tab>

                            <rich:tab label="Tâches à effectuer">
                                <h:panelGrid width="100%" id="idGlobalTache">
                                    <h:panelGrid width="200px" columns="3" id="idPanelTache">
                                        <a4j:commandButton title="Ajouter une nouvelle tache" image="/images/ajouter.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.ajouterTaches}" reRender="panelGestionTache,idPanelTache"/>
                                        <a4j:commandButton title="Modfier la tache sélectionnée" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.modifierTaches}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processTacheAchats.procesligId!='0'}" reRender="panelGestionTache,formModalGestionTache,idPanelTache,valgestion"/>
                                        <a4j:commandButton title="Supprimer la tache sélectionnée" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processTacheAchats.procesligId!='0'}"  onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.supprimerTaches}" reRender="idPanelTache,tableTache"/>
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable id="tableTache" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" "  rowClasses="rows1,rows2,rowsd" width="100%" height="250px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.datamodelProcessTache}" var="ta">
                                            <a4j:support eventsQueue="maQueue" event="onRowClick"oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.selectionTaches}" reRender="idPanelTache,idSaisieTache"/>
                                            <rich:column style="text-align:left;" width="10%">
                                                <f:facet name="header"><h:outputText  value="Code tache"/></f:facet>
                                                <h:outputText  value="#{ta.procesligCode}"/>
                                            </rich:column>
                                            <rich:column style="text-align:left;" width="40%">
                                                <f:facet name="header"><h:outputText  value="Libellé tache"/></f:facet>
                                                <h:outputText  value="#{ta.procesligLibClient}"/>
                                            </rich:column>
                                            <rich:column style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText  value="P.R. HT"/></f:facet>
                                                <h:outputText  value="#{ta.procesligPrht}" rendered="#{ta.procesligPrht!='0'}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText  value="P.V. HT"/></f:facet>
                                                <h:outputText  value="#{ta.procesligPvht}" rendered="#{ta.procesligPvht!='0'}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column style="text-align:right;" width="5%">
                                                <f:facet name="header"><h:outputText  value="JJ"/></f:facet>
                                                <h:outputText  value="#{ta.procesligJj}" rendered="#{ta.procesligJj!='0'}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column style="text-align:right;" width="5%">
                                                <f:facet name="header"><h:outputText  value="HH"/></f:facet>
                                                <h:outputText  value="#{ta.procesligHh}" rendered="#{ta.procesligHh!='0'}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column style="text-align:right;" width="5%">
                                                <f:facet name="header"><h:outputText  value="MM"/></f:facet>
                                                <h:outputText  value="#{ta.procesligMm}" rendered="#{ta.procesligMm!='0'}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column style="text-align:right;" width="5%">
                                                <f:facet name="header"><h:outputText  value="SS"/></f:facet>
                                                <h:outputText  value="#{ta.procesligSs}" rendered="#{ta.procesligSs!='0'}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                                </h:outputText>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:panelGrid>
                            </rich:tab>

                            <rich:tab label="Imputations">
                                <h:panelGrid columns="2" width="100%" id="idImputations" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                                    <h:column><h:outputText value="Site:" style="text-decoration:underline"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:300px;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesSite}">
                                            <f:selectItem itemLabel="Sélectionnez Site" itemValue=""/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.mesSitesItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.chargerLigne}" reRender="idLigne,idAtelier"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Ligne:" style="text-decoration:underline"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu id ="idLigne" style="width:300px;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesLigne}">
                                            <f:selectItem itemLabel="Sélectionnez Ligne" itemValue=""/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.mesLignesItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.chargerAtelier}" reRender="idAtelier"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Atelier:" style="text-decoration:underline"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu id="idAtelier" style="width:300px;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesAtelier}">
                                            <f:selectItem itemLabel="Sélectionnez Atelier" itemValue=""/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.mesAteliersItems}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid columns="2" width="100%" id="idActivites" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                                    <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                                    <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.decoupageActivite}">
                                        <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesActivite}" style="width:230px">
                                            <f:selectItem itemLabel="" itemValue=""/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.mesActivitesItems}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.decoupageActivite}">
                                        <a4j:region renderRegionOnly="false">
                                            <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="200px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.dataModelDecoupageActivtes}" var="saisieAnal">
                                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.selectionAnalytique}"/>
                                                <rich:column label="Activité" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.decoupageActivite}">
                                                    <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                                    <h:selectOneMenu value="#{saisieAnal.zoneActivite}">
                                                        <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.laColonne1Items}"/>
                                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.valideColonne1}" />
                                                    </h:selectOneMenu>
                                                </rich:column>
                                                <rich:column label="Analytique1" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.decoupageActivite}">
                                                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                                    <h:selectOneMenu value="#{saisieAnal.zoneAnal1}">
                                                        <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.laColonne2Items}"/>
                                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.valideColonne2}" />
                                                    </h:selectOneMenu>
                                                </rich:column>
                                                <rich:column label="Analytique3" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.decoupageActivite}">
                                                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                                    <h:selectOneMenu value="#{saisieAnal.zoneAnal3}">
                                                        <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.laColonne3Items}"/>
                                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.valideColonne3}" />
                                                    </h:selectOneMenu>
                                                </rich:column>
                                                <rich:column label="%"  width="15%" style="text-align:right;">
                                                    <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                                    <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px">
                                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.controleEcartAnalytique}" reRender="idTableAnal" />
                                                    </h:inputText>
                                                </rich:column>
                                                <rich:column label="Supprimer répartition"  width="5%" style="text-align:center;">
                                                    <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/supprimer.png" style="width:17px;height:17px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.supprimerAnalytique}" reRender="idTableAnal"/>
                                                </rich:column>
                                            </rich:extendedDataTable>
                                        </a4j:region>
                                    </h:column>
                                </h:panelGrid>
                            </rich:tab>

                            <rich:tab label="Méthodes appliquées">
                                <h:panelGrid width="100%">
                                    <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesMethode}">
                                        <jsp:include flush="true" page="../../css/tdt.jsp"/>
                                    </rich:editor>
                                </h:panelGrid>
                            </rich:tab>

                            <rich:tab label="Pièges à éviter">
                                <h:panelGrid width="100%">
                                    <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processEnteteAchats.procesPiege}">
                                        <jsp:include flush="true" page="../../css/tdt.jsp"/>
                                    </rich:editor>
                                </h:panelGrid>
                            </rich:tab>

                            <rich:tab label="Utilisateurs habilités">
                                <h:panelGrid width="100%">
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable id="tableUserHabilites" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" "  rowClasses="rows1,rows2,rowsd" width="100%" height="250px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.dataModelUsersHabilites}" var="uh">
                                            <rich:column style="text-align:left;" width="10%">
                                                <f:facet name="header"><h:outputText  value="Sel."/></f:facet>
                                                <h:selectBooleanCheckbox  value="#{uh.selectUser}"/>
                                            </rich:column>
                                            <rich:column style="text-align:left;" width="10%">
                                                <f:facet name="header"><h:outputText  value="Civilité"/></f:facet>
                                                <h:outputText  value="#{uh.usrCivilite}"/>
                                            </rich:column>
                                            <rich:column style="text-align:left;" width="50%">
                                                <f:facet name="header"><h:outputText  value="Nom et prénom"/></f:facet>
                                                <h:outputText  value="#{uh.usrPatronyme}"/>
                                            </rich:column>
                                            <rich:column style="text-align:left;" width="20%">
                                                <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                                                <h:outputText  value="#{uh.usrService}"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:panelGrid>
                            </rich:tab>

                        </rich:tabPanel>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <center>
                    <h:panelGroup id="buttGrp">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.saveProcess}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableau,panelProcess"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!-- modalPanel de selection des produits -->
    <rich:modalPanel domElementAttachment="parent"  id="panelListeProduits" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="400" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.showModalPanelProduits}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.showModalPanelProduits}" var="prd">
            <f:facet name="header"><h:outputText value="Sélection du produit"/></f:facet>
            <a4j:form id="formModalListeProduits">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableProd" maxPages="20"align="left" for="tableProd"/>
                <rich:extendedDataTable rows="200" id="tableProd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.dataModelProduits}" var="prd">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.selectionProduits}" reRender="valprod"/>
                    <rich:column label="Sélection Produit" sortable="true" sortBy="#{prd.var_select}" width="5%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processIntrantAchats.procesligInterChange}">
                        <f:facet name="header"><h:outputText  value="Sel." /></f:facet>
                        <h:selectBooleanCheckbox value="#{prd.var_select}"/>
                    </rich:column>
                    <rich:column label="Code" sortable="true" sortBy="#{prd.proCode}" width="15%" filterBy="#{prd.proCode}">
                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                        <h:outputText value="#{prd.proCode}"/>
                    </rich:column>
                    <rich:column label="Libellé produit" sortable="true" sortBy="#{prd.proLibClient}" width="30%" filterBy="#{prd.proLibClient}">
                        <f:facet name="header"><h:outputText  value="Libellé produit" /></f:facet>
                        <h:outputText value="#{prd.proLibClient}"/>
                    </rich:column>
                    <rich:column label="Famille" sortable="true" sortBy="#{prd.proVteLib}" width="20%">
                        <f:facet name="header"><h:outputText  value="Fam. ACH" /></f:facet>
                        <h:outputText value="#{prd.proAchLib}"/>
                    </rich:column>
                    <rich:column label="Famille" sortable="true" sortBy="#{prd.proVteLib}" width="20%">
                        <f:facet name="header"><h:outputText  value="Fam. VTE" /></f:facet>
                        <h:outputText value="#{prd.proVteLib}"/>
                    </rich:column>
                </rich:extendedDataTable>
                <br>
                <h:panelGroup id="valprod">
                    <center>
                        <a4j:commandButton id="idCanProd" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.annuleProduits}" reRender="panelListeProduits,idProcessProduit,idDetail,idSaisieIntrant,idSaisieSousProduit,idSaisieDechet"/>&nbsp;&nbsp;&nbsp;
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.calculeProduits}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.produits.proId!='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processIntrantAchats.procesligInterChange==false}"/>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.calculeProduitsMultiple}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.produits.proId!='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processIntrantAchats.procesligInterChange==true}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!-- modalPanel de selection des taches -->
    <rich:modalPanel domElementAttachment="parent"  id="panelListeTache" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.showModalPanelTaches}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.showModalPanelTaches}" var="tch">
            <f:facet name="header"><h:outputText value="Sélection de la tache"/></f:facet>
            <a4j:form id="formModalListeTache">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableTache" maxPages="20"align="left" for="tableTache"/>
                <rich:extendedDataTable rows="200" id="tableTache" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.datamodelTaches}" var="tch">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.selectionTache}" reRender="valtache"/>
                    <rich:column label="Code" sortable="true" sortBy="#{tch.tacCode}" width="10%" filterBy="#{tch.tacCode}">
                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                        <h:outputText value="#{tch.tacCode}"/>
                    </rich:column>
                    <rich:column label="Libellé tache" sortable="true" sortBy="#{tch.tacNomFr}" width="50%" filterBy="#{tch.tacNomFr}">
                        <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                        <h:outputText value="#{tch.tacNomFr}"/>
                    </rich:column>
                    <rich:column label="Prix de revient" sortable="true" sortBy="#{tch.tacValPr}" width="10%">
                        <f:facet name="header"><h:outputText  value="P.R." /></f:facet>
                        <h:outputText value="#{tch.tacValPr}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Prix de vente" sortable="true" sortBy="#{tch.tacValPv}" width="10%">
                        <f:facet name="header"><h:outputText  value="P.V." /></f:facet>
                        <h:outputText value="#{tch.tacValPv}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column style="text-align:right;" width="5%">
                        <f:facet name="header"><h:outputText  value="JJ"/></f:facet>
                        <h:outputText  value="#{tch.tacValJj}" rendered="#{tch.tacValJj!='0'}" style="text-align:right;">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column style="text-align:right;" width="5%">
                        <f:facet name="header"><h:outputText  value="HH"/></f:facet>
                        <h:outputText  value="#{tch.tacValHh}" rendered="#{tch.tacValHh!='0'}" style="text-align:right;">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column style="text-align:right;" width="5%">
                        <f:facet name="header"><h:outputText  value="MM"/></f:facet>
                        <h:outputText  value="#{tch.tacValMm}" rendered="#{tch.tacValMm!='0'}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column style="text-align:right;" width="5%">
                        <f:facet name="header"><h:outputText  value="SS"/></f:facet>
                        <h:outputText  value="#{tch.tacValSs}" rendered="#{tch.tacValSs!='0'}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                        </h:outputText>
                    </rich:column>
                </rich:extendedDataTable>
                <br>
                <h:panelGroup id="valtache">
                    <center>
                        <a4j:commandButton id="idCanTache" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.annuleTache}" reRender="panelListeTache,panelGestionTache"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTache" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.calculeTache}" reRender="panelListeTache,panelGestionTache" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.taches.tacId!='0'}"/>
                    </center>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCanTache')}.click()" />
                    <rich:hotKey key="return"  handler="#{rich:element('idValTache')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!-- modalPanel de gestion des taches -->
    <rich:modalPanel domElementAttachment="parent"  id="panelGestionTache" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1000" height="550" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.showModalPanelGestionTaches}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.showModalPanelGestionTaches}" var="tch">
            <f:facet name="header"><h:outputText value="Gestion de la tache"/></f:facet>
            <a4j:form id="formModalGestionTache">
                <h:panelGrid width="100%" id="idSaisieTache" columns="4" columnClasses="clos15,clos35,clos15,clos35" headerClass="headerTab">
                    <f:facet name="header"><h:outputText value="Identification de la tache"/></f:facet>
                    <h:column><h:outputText value="Code tache:" style="text-decoration:underline"/></h:column>
                    <h:column>
                        <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processTacheAchats.procesligCode}">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche toutes les taches (puis tabuler)" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.rechercheTaches}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeTache,idSaisieTache"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Libellé tache:"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processTacheAchats.procesligLibClient}" readonly="true"/></h:column>
                    <h:column><h:outputText value="P.R. HT:"/></h:column>
                    <h:column>
                        <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processTacheAchats.procesligPrht}" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="P.V. HT:"/></h:column>
                    <h:column>
                        <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processTacheAchats.procesligPvht}" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid width="100%" id="idDureeTache" columns="8" headerClass="headerTab">
                    <f:facet name="header"><h:outputText value="Durée de la tache"/></f:facet>
                    <h:column><h:outputText value="Jour(s):"/></h:column>
                    <h:column>
                        <h:inputText size="1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processTacheAchats.procesligJj}" style="text-align:right;">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Heure(s):"/></h:column>
                    <h:column>
                        <h:inputText size="1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processTacheAchats.procesligHh}" style="text-align:right;">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Minute(s):"/></h:column>
                    <h:column>
                        <h:inputText size="1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processTacheAchats.procesligMm}" style="text-align:right;">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Seconde(s):"/></h:column>
                    <h:column>
                        <h:inputText size="1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processTacheAchats.procesligSs}" style="text-align:right;">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>

                <h:panelGrid width="100%" columns="2" columnClasses="clos50,clos50">
                    <h:panelGrid width="100%" id="idMetierTache" headerClass="headerTab">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableMetiers" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" "  rowClasses="rows1,rows2,rowsd" width="100%" height="300px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.datamodelService}" var="mt">
                                <a4j:support eventsQueue="maQueue" event="onRowClick"oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.selectionIntrants}" reRender="idPanelIntrant,idSaisieIntrant"/>
                                <rich:column style="text-align:left;" width="70%" sortable="false" sortBy="#{mt.column_name}" sortOrder="ASCENDING">
                                    <f:facet name="header"><h:outputText  value="Services concernés"/></f:facet>
                                    <h:outputText  value="#{mt.column_name}"/>
                                </rich:column>
                                <rich:column style="text-align:center;" width="10%" sortable="false">
                                    <f:facet name="header"><h:outputText  value="Qte"/></f:facet>
                                    <h:inputText  value="#{mt.column_qte}" style="text-align:center;width:70%">
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="idPr"/>
                                    </h:inputText>
                                </rich:column>
                                <rich:column id="idPr" style="text-align:right;" width="20%" sortable="false">
                                    <f:facet name="header"><h:outputText  value="P.R."/></f:facet>
                                    <h:inputText  value="#{mt.column_pr}" style="text-align:right;width:90%" rendered="#{mt.column_qte!='0'}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                        <h:column><h:outputText value="(Les services sont ceux liés aux agents)"/></h:column>
                    </h:panelGrid>

                    <h:panelGrid width="100%" id="idMaterielTache" headerClass="headerTab">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableParc" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" "  rowClasses="rows1,rows2,rowsd" width="100%" height="300px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.datamodelParc}" var="pc">
                                <a4j:support eventsQueue="maQueue" event="onRowClick"oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.selectionIntrants}" reRender="idPanelIntrant,idSaisieIntrant"/>
                                <rich:column style="text-align:center;" width="10%" sortable="false">
                                    <f:facet name="header"><h:outputText  value="Sel."/></f:facet>
                                    <h:selectBooleanCheckbox  value="#{pc.column_select}" style="text-align:center;"/>
                                </rich:column>
                                <rich:column style="text-align:left;" width="20%" sortable="false">
                                    <f:facet name="header"><h:outputText  value="Immat."/></f:facet>
                                    <h:outputText  value="#{pc.column_code}"/>
                                </rich:column>
                                <rich:column style="text-align:left;" width="50%" sortable="false" sortBy="#{pc.column_name}" sortOrder="ASCENDING">
                                    <f:facet name="header"><h:outputText  value="Matériel utilisé"/></f:facet>
                                    <h:outputText  value="#{pc.column_name}"/>
                                </rich:column>
                                <rich:column style="text-align:right;" width="20%" sortable="false">
                                    <f:facet name="header"><h:outputText  value="P.R."/></f:facet>
                                    <h:outputText  value="#{pc.column_pr}" style="text-align:right;width:90%">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                        <h:column><h:outputText value="(Le matériel est ceui défini dans le parc)"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>

                <br>
                <h:panelGroup id="valgestion">
                    <center>
                        <a4j:commandButton id="idCanGestionTache" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.fermerTaches}" reRender="panelGestionTache"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValGestionTache" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.saveTaches}" reRender="panelGestionTache,panelListeTache,idPanalGlobal,idProcessTache,tableTache" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.taches.tacId!='0'}"/>
                    </center>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCanGestionTache')}.click()" />
                    <rich:hotKey key="return"  handler="#{rich:element('idValGestionTache')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!-- modalPanel de gestion des produits multiples -->
    <rich:modalPanel domElementAttachment="parent"  id="panelProduitInterchangeable" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1000" height="550" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.showModalPanelProduitInterchangeable}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.showModalPanelProduitInterchangeable}" var="pit">
            <f:facet name="header"><h:outputText value="Gestion des produits interchangeables"/></f:facet>
            <a4j:form id="formModalProduitInterchangeable">
                <h:panelGrid width="100%" id="idSaisieInterchangeble" columns="2" columnClasses="clos20,clos80" headerClass="headerTab">
                    <f:facet name="header"><h:outputText value="Caractérstiques du produit interchangeable"/></f:facet>
                    <h:column><h:outputText value="Libellé produit interchangeable:"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processIntrantAchats.procesligLibClient}"/></h:column>
                    <h:column><h:outputText value="Unité:"/></h:column>
                    <h:column><h:inputText size="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processIntrantAchats.procesligUnite}"/></h:column>
                    <h:column><h:outputText value="Qte:"/></h:column>
                    <h:column>
                        <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.processIntrantAchats.procesligQte}" style="text-align:right;">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.optionStocks.nbDecQteProd}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.optionStocks.nbDecQteProd}"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>

                <h:panelGrid width="100%" id="idDureeTache" headerClass="headerTab">
                    <f:facet name="header"><h:outputText value="Liste produits possibles"/></f:facet>
                    <h:panelGrid width="150px" columns="2" id="idPanelInterchangeable">
                        <a4j:commandButton title="Ajouter un nouveau produit" image="/images/ajouter.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.rechercheProduitsInterchangeable}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeProduits"/>
                        <a4j:commandButton title="Supprimer le produit sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.produits.proId!='0'}"  onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.supprimerProduitInterchangeable}" reRender="tableProdInterchangeable"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable rows="200" id="tableProdInterchangeable" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="250px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.datamodelProduitInterchangeable}" var="pint">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.selectionProduitsInterchangeable}" reRender="idPanelInterchangeable"/>
                            <rich:column label="Code" sortable="true" sortBy="#{pint.proCode}" width="15%">
                                <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                <h:outputText value="#{pint.proCode}"/>
                            </rich:column>
                            <rich:column label="Libellé produit" sortable="true" sortBy="#{pint.proLibClient}" width="35%">
                                <f:facet name="header"><h:outputText  value="Libellé produit" /></f:facet>
                                <h:outputText value="#{pint.proLibClient}"/>
                            </rich:column>
                            <rich:column label="Famille" sortable="true" sortBy="#{pint.proVteLib}" width="20%">
                                <f:facet name="header"><h:outputText  value="Fam. ACH" /></f:facet>
                                <h:outputText value="#{pint.proAchLib}"/>
                            </rich:column>
                            <rich:column label="Famille" sortable="true" sortBy="#{pint.proVteLib}" width="20%">
                                <f:facet name="header"><h:outputText  value="Fam. VTE" /></f:facet>
                                <h:outputText value="#{pint.proVteLib}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>

                <br>
                <h:panelGroup id="valinterchangeable">
                    <center>
                        <a4j:commandButton id="idCanProduitInterchangeable" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.fermerProduitInterchangeable}" reRender="panelProduitInterchangeable"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValProduitInterchangeable" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.validerProduitInterchangeable}" reRender="panelProduitInterchangeable,tableIntrant"/>
                    </center>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanProduitInterchangeable')}.click()" />
                    <rich:hotKey key="return" handler="#{rich:element('idValProduitInterchangeable')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


    <!-- debut Modal panel pour impression detail process-->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImpStructure" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <center>
            <f:facet name="header"><h:outputText value="Impression du détail du process"/></f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/images/close.gif" id="hideImpStructure"/>
                    <rich:componentControl for="panelImpStructure" attachTo="hideImpStructure" operation="hide" event="onclick"/>
                </h:panelGroup>
            </f:facet>
            <a4j:form id="formModalImpStructure" target="_blank">
                <h:panelGrid width="100%" >
                    <h:panelGrid width="100%" style="border:solid 0px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="8" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.imprimerJRV}" onclick="javascript:Richfaces.hideModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProcessAchats.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                        </h:panelGrid>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>


</f:subview>
