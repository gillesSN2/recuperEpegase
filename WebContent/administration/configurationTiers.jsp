<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="configurationTiers">

    <a4j:form id="formconfigurationTiers" enctype="multipart/form-data">

        <center> <h2><h:outputText value="CONFIGURATION DES TIERS" style="color:green;"/></h2></center>

        <h:panelGrid width="100%">

            <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabConfiguration" label="Configuration">
                    <h:panelGrid id="panelConfiguration" width="100%">
                        <h:panelGrid id="panelBouton" width="400px" columns="4">
                            <a4j:commandButton title="Ajouter une configuration" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.ajouterConfiguration}" reRender="panalConfiguration"/>
                            <a4j:commandButton title="Modifier une configuration" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.modifierConfiguration}" reRender="panalConfiguration" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.tiersTechnique.tietecId!=0}"/>
                            <a4j:commandButton title="Supprimer une configuration" image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.supprimerConfiguration}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer la configuration sélectionnée ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableConfiguration,scrollTable,panelBouton" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.tiersTechnique.tietecId!=0}"/>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.idTiers}" style="width:100%">
                                    <f:selectItem itemLabel="Sélection tiers" itemValue=""/>
                                    <f:selectItem itemLabel="Tous les tiers" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.mesTiersItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.chargerTiers}" reRender="panelConfiguration,tableConfiguration,scrollTable,panelBouton"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableConfiguration"/>
                            <rich:extendedDataTable rows="100" style="max-height:100%" styleClass="bg" id="tableConfiguration" enableContextMenu="false" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.dataModelTiersTechnique}" var="config">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.selectionConfiguration}" reRender="panelBouton"/>
                                <rich:column sortable="false" width="25%" sortBy="#{config.tiers.tieraisonsocialenom}" sortOrder="DESCENDING">
                                    <f:facet name="header" ><h:outputText value="Tiers"/></f:facet>
                                    <h:outputText value="#{config.tiers.tieraisonsocialenom}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%" sortBy="#{config.libelle}" >
                                    <f:facet name="header" ><h:outputText value="Type"/></f:facet>
                                    <h:outputText value="#{config.libelle}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%" sortBy="#{config.tietecService}" >
                                    <f:facet name="header" ><h:outputText value="Service"/></f:facet>
                                    <h:outputText value="#{config.tietecService}"/>
                                </rich:column>
                                <rich:column sortable="false" width="25%" sortBy="#{config.tietecAdresse}" >
                                    <f:facet name="header" ><h:outputText value="Adresse"/></f:facet>
                                    <h:outputText value="#{config.tietecAdresse}"/>
                                </rich:column>
                                <rich:column sortable="false" width="15%" sortBy="#{config.tietecLogin}">
                                    <f:facet name="header" ><h:outputText value="Login"/></f:facet>
                                    <h:outputText value="#{config.tietecLogin}"/>
                                </rich:column>
                                <rich:column sortable="false" width="15%" sortBy="#{config.tietecPw}">
                                    <f:facet name="header" ><h:outputText value="Password"/></f:facet>
                                    <h:outputText value="#{config.tietecPw}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

        </h:panelGrid>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panalConfiguration" width="600" height="350" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.showModalPanelConfiguration}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.showModalPanelConfiguration}" var="scr" >
            <f:facet name="header"><h:outputText value="GESTION DES CONFIGURATIONS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.fermerConfiguration}" image="/images/close.gif" styleClass="hidelink" reRender="panalConfiguration"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid width="100%">

                    <h:panelGrid width="100%" columns="2">
                        <h:column><h:outputText value="Nom du tiers" style="text-decoration:underline;" /></h:column>
                        <h:column>
                            <h:inputText id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.nomTiers}" style="width:100%">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idTiers,panelListeTiers,idValide"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Type"/></h:column>
                        <h:column>
                            <h:selectOneListbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.tiersTechnique.tietecType}" style="width:100%">
                                <f:selectItem itemLabel="Gestion des mots de passe" itemValue="0"/>
                            </h:selectOneListbox>
                        </h:column>
                        <h:column><h:outputText value="Service"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.tiersTechnique.tietecService}" style="width:100%"/></h:column>
                        <h:column><h:outputText value="Adresse"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.tiersTechnique.tietecAdresse}" style="width:100%"/></h:column>
                        <h:column><h:outputText value="Login"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.tiersTechnique.tietecLogin}" style="width:100%"/></h:column>
                        <h:column><h:outputText value="PassWord"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.tiersTechnique.tietecPw}" style="width:100%"/></h:column>
                    </h:panelGrid>

                    <br>
                    <h:panelGroup>
                        <center>
                            <h:commandButton id="idValide" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.saveConfiguration}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.tiers.tieid!=0}"/>
                        </center>
                    </h:panelGroup>
                    <br>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!-- modalPanel de selection des tiers -->
    <rich:modalPanel domElementAttachment="parent"  id="panelListeTiers" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.showModalPanelTiers}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.showModalPanelTiers}" var="tie">
            <f:facet name="header"><h:outputText value="Sélection du tiers"/></f:facet>
            <a4j:form id="formModalListeTiers">
                <rich:extendedDataTable id="tableTiers" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.dataModelTiers}" var="tiers">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.selectionligneTiers}"/>
                    <f:facet name="header"></f:facet>
                    <rich:column label="Catégorie" sortable="true" sortBy="#{tiers.tiecategorie}" width="15%">
                        <f:facet name="header"><h:outputText  value="Catégorie" /></f:facet>
                        <h:outputText value="#{tiers.tiecategorie}"/>
                    </rich:column>
                    <rich:column label="Raison sociale ou Nom" sortable="true" sortBy="#{tiers.tieraisonsocialenom}" width="55%">
                        <f:facet name="header"><h:outputText  value="Raison sociale" /></f:facet>
                        <h:outputText value="#{tiers.tieraisonsocialenom}"/>
                    </rich:column>
                    <rich:column label="Prénom" sortable="true" sortBy="#{tiers.tieprenom}" width="20%">
                        <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                        <h:outputText value="#{tiers.tieprenom}"/>
                    </rich:column>
                    <rich:column label="Civilité" sortable="true" sortBy="#{tiers.tiecivilite}" width="10%">
                        <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                        <h:outputText value="#{tiers.tiecivilite}"/>
                    </rich:column>
                </rich:extendedDataTable>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanTiers" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.annuleTiers}" reRender="idTiers,panelListeTiers,idValide"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.calculeTiers}" reRender="idTiers,panelListeTiers,idValide"/>
                        <rich:hotKey key="esc"  handler="#{rich:element('idCanTiers')}.click()" />
                        <rich:hotKey key="return"  handler="#{rich:element('idValTiers')}.click()" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>