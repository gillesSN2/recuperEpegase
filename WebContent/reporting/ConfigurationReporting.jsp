<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="tableauDeBordConfigClient">

    <a4j:form id="impgen">

        <center> <h2><h:outputText value=" TABLEAUX DE BORD et REPORTING" style="color:green;font-size:16px;"/></h2></center>

        <h:panelGrid id="impgenPG" border="0" width="100%" style="border:0px solid green;"  columns="2">

            <rich:column id="rchpbListTab" width="25%" style="border:1px solid green;">

                <h:panelGrid id="rcolbListTab" columns="4" width="200px" style="height:35px">
                    <a4j:commandButton title="Ajouter un tableau" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.ajouterTableau}" oncomplete="javascript:Richfaces.showModalPanel('panelTableau');" reRender="panelTableau"/>
                    <a4j:commandButton title="Modifier le tableau en cours" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.testAffTabNomSuppModif}" oncomplete="javascript:Richfaces.showModalPanel('panelTableau');" reRender="panelTableau"/>
                    <a4j:commandButton title="Supprimer le tableau en cours" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.testAffTabNomSuppModif}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.deleteTableau}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false"  reRender="pngdElement,tableColonne,rcolbListTab,rchpbListElement"/>
                    <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.testAffTabNomSuppModif}" oncomplete="javascript:Richfaces.showModalPanel('panelImp');" reRender="panelImp"/>
                    <a4j:commandButton title="Importer un tableau des états financiers" image="/images/modifier.png" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.importerTableauEtatFinancier}" oncomplete="javascript:Richfaces.showModalPanel('panelTableauEtatFinancier');" reRender="panelTableauEtatFinancier"/>
                </h:panelGrid>

                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tabletabnom" height="350px" activeClass="active-row" noDataLabel=" " enableContextMenu="false" footerClass="bard" headerClass="headerTab" width="100%" border="0" styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.datamodeltabNom}" var="tableau">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.selectionTableau}" reRender="pngdElement,tableColonne,rcolbListTab,rchpbListElement"/>
                        <rich:column width="20%" sortable="false" >
                            <f:facet name="header" ><h:outputText value="Code"/></f:facet>
                            <h:outputText  value="#{tableau.tablisCode}" style="width:100%" />
                        </rich:column >
                        <rich:column width="80%" sortable="false" >
                            <f:facet name="header" ><h:outputText value="Nom des tableaux"/></f:facet>
                            <h:outputText  value="#{tableau.tablisLibFR}" style="width:100%" />
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>

                <h:panelGrid columns="3" width="200px" style="height:35px" id="copierColler">
                    <a4j:commandButton title="Copier la formule de la colonne sélectionnée" image="/images/copier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.testAffTabFormuleSave}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.copierFormule}"/>
                    <a4j:commandButton title="Coller la formule dans la colonne sélectionnée" image="/images/coller.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.testAffTabFormuleSave}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.collerFormule}" reRender="tabletabformule"/>
                    <a4j:commandButton title="Duplique la formule de la colonne sélectionnée jusqu'à la fin du tableau" image="/images/duplicate.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.testAffTabFormuleSave}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.duppliqueFormule}" onclick="if (!confirm('Etes-vous sur de vouloir dupliquer cette formule aux colonnes suivantes ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tabletabformule"/>
                </h:panelGrid>

                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableColonne" height="215px" activeClass="active-row" noDataLabel=" " enableContextMenu="false" footerClass="bard" headerClass="headerTab" width="100%" border="0" styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.dataModelLesNomsCol}" var="Nomcol">
                        <a4j:support eventsQueue="maQueue" event="onRowClick"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.selectionColonne}" reRender="tabletabformule,rchpbFormule,copierColler"/>
                        <rich:column width="20%"sortable="false" >
                            <f:facet name="header" ><h:outputText value="N°"/></f:facet>
                            <h:outputText value="#{Nomcol.numCol}"  style="width:100%" />
                        </rich:column >
                        <rich:column width="30%" sortable="false">
                            <f:facet name="header" ><h:outputText value="Période" style="color:red"/></f:facet>
                            <h:outputText value="#{Nomcol.libPeriodeCol}"  style="width:100%;color:red;"/>
                        </rich:column >
                        <rich:column width="30%" sortable="false">
                            <f:facet name="header" ><h:outputText value="Nom"/></f:facet>
                            <h:outputText value="#{Nomcol.nomCol}"  style="width:100%" />
                        </rich:column >
                        <rich:column width="20%" style="text-align:center;" sortable="false">
                            <a4j:commandButton title="Modifier la colonne sélectionnée" image="/images/modifier.png" oncomplete="javascript:Richfaces.showModalPanel('panelColonne');" reRender="panelColonne"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>

            </rich:column>

            <rich:column width="75%" id="pngdElement" style="border:1px solid green;width:100%">

                <h:panelGrid columns="3" width="200px" id="rchpbListElement" style="height:35px">
                    <a4j:commandButton title="Ajouter un élément du tableau sélectionné" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.testAffTabElementSave}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.ajouterElement}" oncomplete="javascript:Richfaces.showModalPanel('panelElement');" reRender="panelElement"/>
                    <a4j:commandButton title="Modifier l'élément en cours" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.testAffTabElementuppModif}" oncomplete="javascript:Richfaces.showModalPanel('panelElement');" reRender="panelElement"/>
                    <a4j:commandButton title="Supprimer l'élément en cours" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.testAffTabElementuppModif}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.deleteElemnent}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" reRender="tabelement,rchpbFormule"/>
                </h:panelGrid>

                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tabelement" height="350px" activeClass="active-row" noDataLabel=" " enableContextMenu="false" footerClass="bard" headerClass="headerTab" width="100%" border="0" styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.datamodeltabElement}" var="element">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.selectionElement}" reRender="tabletabformule,rchpbListElement,rchpbFormule"/>
                        <rich:column width="6%" >
                            <f:facet name="header" ><h:outputText value="Ord. "/></f:facet>
                            <h:outputText  value="#{element.tabeleNum}" />
                        </rich:column >
                        <rich:column style="height:20px;" width="7%" sortable="false">
                            <f:facet name="header"><h:outputText  value="T.C." /></f:facet>
                            <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.ordonnnerDescendant}" image="/images/downarrow.png" id="decroissant" rendered="#{((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.datamodeltabElement.rowIndex+1)<bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.datamodeltabElement.rowCount)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </rich:column>
                        <rich:column style="height:20px;" width="7%" sortable="false" >
                            <f:facet name="header"><h:outputText  value="T.D." /></f:facet>
                            <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.ordonnnerAscendant}"  image="/images/uparrow.png"  id="croissant" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.datamodeltabElement.rowIndex>=1)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </rich:column>
                        <rich:column width="10%" >
                            <f:facet name="header" ><h:outputText value="Réf."/></f:facet>
                            <h:outputText  value="#{element.tabeleReference}" />
                        </rich:column >
                        <rich:column width="10%" >
                            <f:facet name="header" ><h:outputText value="Type"/></f:facet>
                            <h:outputText  value="#{element.var_type}" />
                        </rich:column>
                        <rich:column width="10%" >
                            <f:facet name="header" ><h:outputText value="Rés."/></f:facet>
                            <h:outputText  value="#{element.var_resultat}" />
                        </rich:column>
                        <rich:column width="50%" >
                            <f:facet name="header" ><h:outputText value="Liste des éléments"/></f:facet>
                            <h:outputText  value="#{element.tabeleLibFR}"  />
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>

                <h:panelGrid columns="4" width="400px" id="rchpbFormule" style="height:35px" >
                    <a4j:commandButton title="Ajouter une formule de l'élément sélectionné" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabNom.tablis_id!=0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.ajouterFormule}" oncomplete="javascript:Richfaces.showModalPanel('panelFormule');" reRender="panelFormule"/>
                    <a4j:commandButton title="Modifier la formule en cours" image="/images/modifier.png"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.testAffTabFormuleSuppModif}"oncomplete="javascript:Richfaces.showModalPanel('panelFormule');"  reRender="panelFormule"/>
                    <a4j:commandButton title="Supprimer la formule en cours" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.testAffTabFormuleSuppModif}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.deleteFormule}" reRender="tabletabformule,rchpbFormule" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" />
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.afficheCellule}">
                        <h:outputText value="Cellule :  #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.nomCellule}"/>&nbsp;&nbsp;
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.natureCellule}" id="idNatCel">
                            <f:selectItem itemLabel="Affichage Monnaie" itemValue="0"/>
                            <f:selectItem itemLabel="Affichage Pourcentage" itemValue="1"/>
                            <f:selectItem itemLabel="Affichage Quantité" itemValue="2"/>
                            <f:selectItem itemLabel="Saisie Monnaie" itemValue="10"/>
                            <f:selectItem itemLabel="Saisie Pourcentage" itemValue="11"/>
                            <f:selectItem itemLabel="Saisie Quantité" itemValue="12"/>
                            <f:selectItem itemLabel="Saisie Texte 1 ligne" itemValue="13"/>
                            <f:selectItem itemLabel="Saisie Texte x lignes" itemValue="14"/>
                            <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.majElement}" reRender="tabletabformule"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>

                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tabletabformule"height="215px"  activeClass="active-row" noDataLabel=" " enableContextMenu="false" footerClass="bard"headerClass="headerTab"   width="100%" border="0" styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.datamodeltabFormule}" var="formule">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.selectionFormule}" reRender="rchpbFormule,copierColler"/>
                        <rich:column width="10%" sortable="false" sortBy="#{formule.tabfor_id}" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText value="Type"/></f:facet>
                            <h:outputText value="#{formule.var_sens}" />
                        </rich:column >
                        <rich:column width="10%" >
                            <f:facet name="header" ><h:outputText value="Période" style="color:red"/></f:facet>
                            <h:outputText  value="#{formule.lib_periode}" style="color:red"/>
                        </rich:column>
                        <rich:column width="40%" sortable="false" >
                            <f:facet name="header" ><h:outputText value="Formule"/></f:facet>
                            <h:outputText  value="#{formule.tabforFormule}"/>
                        </rich:column >
                        <rich:column width="20%" sortable="false" >
                            <f:facet name="header" ><h:outputText value="Budget"/></f:facet>
                            <h:outputText value="#{formule.tabforBudget}" />
                        </rich:column >
                        <rich:column width="20%" sortable="false" >
                            <f:facet name="header" ><h:outputText value="Analytique"/></f:facet>
                            <h:outputText  value="#{formule.tabforAnalytique}"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>

            </rich:column>

        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelTableau" width="540" height="450" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" >
        <f:facet name="header">
            <h:panelGroup>
                <h:outputText value="DESCRIPTION D'UN TABLEAU"></h:outputText>
            </h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidepanelTableau"/>
                <rich:componentControl for="panelTableau" attachTo="hidepanelTableau" operation="hide" event="onclick"/>
            </h:panelGroup>
        </f:facet>
        <a4j:form  >
            <h:panelGrid columns="2" columnClasses="clos30,clos70" width="100%">
                <h:column><h:outputText value="Code:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabNom.tablisCode}" maxlength="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabNom.tablis_id!=0}"/></h:column>
                <h:column><h:outputText value="Libelle:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabNom.tablisLibFR}" maxlength="200" style="width:100%;"/></h:column>
                <h:column><h:outputText value="Nb colonnes:"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabNom.tablisNbCol}" style="width:100%;">
                        <f:selectItem itemLabel="1 colonne" itemValue="1"/>
                        <f:selectItem itemLabel="2 colonnes" itemValue="2"/>
                        <f:selectItem itemLabel="3 colonnes" itemValue="3"/>
                        <f:selectItem itemLabel="4 colonnes" itemValue="4"/>
                        <f:selectItem itemLabel="5 colonnes" itemValue="5"/>
                        <f:selectItem itemLabel="6 colonnes" itemValue="6"/>
                        <f:selectItem itemLabel="7 colonnes" itemValue="7"/>
                        <f:selectItem itemLabel="8 colonnes" itemValue="8"/>
                        <f:selectItem itemLabel="9 colonnes" itemValue="9"/>
                        <f:selectItem itemLabel="10 colonnes" itemValue="10"/>
                        <f:selectItem itemLabel="11 colonnes" itemValue="11"/>
                        <f:selectItem itemLabel="12 colonnes" itemValue="12"/>
                        <f:selectItem itemLabel="13 colonnes" itemValue="13"/>
                        <f:selectItem itemLabel="14 colonnes" itemValue="14"/>
                        <f:selectItem itemLabel="15 colonnes" itemValue="15"/>
                        <f:selectItem itemLabel="16 colonnes" itemValue="16"/>
                        <f:selectItem itemLabel="17 colonnes" itemValue="17"/>
                        <f:selectItem itemLabel="18 colonnes" itemValue="18"/>
                        <f:selectItem itemLabel="19 colonnes" itemValue="19"/>
                        <f:selectItem itemLabel="20 colonnes" itemValue="20"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column rendered="false"><h:outputText value="Modèle impression:"/></h:column>
                <h:column rendered="false"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabNom.tablisModele}" maxlength="100" style="width:100%;"/></h:column>
                <h:outputText value="Type:"/>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabNom.tablisType}" style="width:100%;"  >
                        <f:selectItem itemLabel="Rapport de Synthèse" itemValue="1"/>
                    </h:selectOneMenu>
                </h:column>
                <h:outputText value="Catégorie:"/>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabNom.tablisCategorie}" style="width:100%;">
                        <f:selectItem itemLabel="Comptabilité" itemValue="4"/>
                        <f:selectItem itemLabel="Paye" itemValue="5"/>
                        <f:selectItem itemLabel="Achats" itemValue="6"/>
                        <f:selectItem itemLabel="Ventes" itemValue="8"/>
                        <f:selectItem itemLabel="Trésorerie" itemValue="90"/>

                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Filtre analytique:" /></h:column>
                <h:column><h:inputText id="valAnalytique" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabNom.tablisAnalytique}" maxlength="1000" style="width:100%;"/></h:column>
                <h:column rendered="false"><h:outputText value="Sauf analytique:" /></h:column>
                <h:column rendered="false"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabNom.tablisSauf}" maxlength="1000" style="width:100%;"/></h:column>
                <h:column><h:outputText value="Opérateurs Analytiques:"/></h:column>
                <h:column>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.ImputSit}" reRender="valAnalytique" value="SIT" size="3"/>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.ImputDep}" reRender="valAnalytique" value="DEP" size="3"/>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.ImputServ}" reRender="valAnalytique" value="SER" size="3"/><br>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.ImputReg}" reRender="valAnalytique" value="REG" size="3"/>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.ImputSec}" reRender="valAnalytique" value="SEC" size="3"/>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.ImputPdv}" reRender="valAnalytique" value="PDV" size="3"/><br>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.ImputPrc}" reRender="valAnalytique" value="PRC" size="3"/>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.ImputDos}" reRender="valAnalytique" value="DOS" size="3"/>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.ImputAgt}" reRender="valAnalytique" value="AGT" size="3"/><br>
                    <a4j:commandButton rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.decoupageanalytique}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.ImputAct}" reRender="valAnalytique" value="ACT" size="3" title="Activité"/>
                    <a4j:commandButton rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.decoupageanalytique}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.ImputAc1}" reRender="valAnalytique" value="AC1" size="3" title="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}"/>
                    <a4j:commandButton rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.decoupageanalytique}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.ImputAc2}" reRender="valAnalytique" value="AC2" size="3" title="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}"/>
                    <a4j:commandButton rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.decoupageanalytique}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.ImputAc3}" reRender="valAnalytique" value="AC3" size="3" title="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}"/>
                    <a4j:commandButton rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.decoupageanalytique}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.ImputAcx}" reRender="valAnalytique" value="ACX" size="3" title="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}"/>
                </h:column>
                <h:column><h:outputText value="Tableau inactif:"/></h:column>
                <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabNom.var_tab_inactif}"  /></h:column>
            </h:panelGrid>
            <br><br><br>
            <center>
                <h:panelGroup>
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.saveTableau}" image="/images/valider_big.png" style="text-decoration:none;"/>
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   id="panelColonne" width="540" headerClass="headerPanel" height="250" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);">
        <f:facet name="header">
            <h:panelGroup>
                <h:outputText value="DESCRIPTION DES NOMBRES DE COLONNES"></h:outputText>
            </h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidepanelFinancierNbrCol"/>
                <rich:componentControl for="panelColonne" attachTo="hidepanelFinancierNbrCol" operation="hide" event="onclick"/>
            </h:panelGroup>
        </f:facet>
        <a4j:form  >
            <h:panelGrid columns="2" columnClasses="clos30,clos70" id="panCol">
                <h:column><h:outputText value="Libelle:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.etatFinancier.nomCol}" maxlength="30" style="width:100%;"/></h:column>
                <h:column><h:outputText value="Période:" style="color:red"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.etatFinancier.periodeCol}" style="width:100%;color:red">
                        <f:selectItem itemLabel="N" itemValue="0"/>
                        <f:selectItem itemLabel="N Janvier" itemValue="1"/>
                        <f:selectItem itemLabel="N Février" itemValue="2"/>
                        <f:selectItem itemLabel="N Mars" itemValue="3"/>
                        <f:selectItem itemLabel="N Avril" itemValue="4"/>
                        <f:selectItem itemLabel="N Mai" itemValue="5"/>
                        <f:selectItem itemLabel="N Juin" itemValue="6"/>
                        <f:selectItem itemLabel="N Juillet" itemValue="7"/>
                        <f:selectItem itemLabel="N Aout" itemValue="8"/>
                        <f:selectItem itemLabel="N Septembre" itemValue="9"/>
                        <f:selectItem itemLabel="N Octobre" itemValue="10"/>
                        <f:selectItem itemLabel="N Novembre" itemValue="11"/>
                        <f:selectItem itemLabel="N Décembre" itemValue="12"/>
                        <f:selectItem itemLabel="N 1er trimestre" itemValue="13"/>
                        <f:selectItem itemLabel="N 2eme trimestre" itemValue="14"/>
                        <f:selectItem itemLabel="N 3eme trimestre" itemValue="15"/>
                        <f:selectItem itemLabel="N 4eme trimestre" itemValue="16"/>
                        <f:selectItem itemLabel="N 1er semestre" itemValue="17"/>
                        <f:selectItem itemLabel="N 2eme semestre" itemValue="18"/>
                        <f:selectItem itemLabel="N (Période complète)" itemValue="19"/>
                        <f:selectItem itemLabel="N-1" itemValue="20"/>
                        <f:selectItem itemLabel="N-1 Janvier" itemValue="21"/>
                        <f:selectItem itemLabel="N-1 Février" itemValue="22"/>
                        <f:selectItem itemLabel="N-1 Mars" itemValue="23"/>
                        <f:selectItem itemLabel="N-1 Avril" itemValue="24"/>
                        <f:selectItem itemLabel="N-1 Mai" itemValue="25"/>
                        <f:selectItem itemLabel="N-1 Juin" itemValue="26"/>
                        <f:selectItem itemLabel="N-1 Juillet" itemValue="27"/>
                        <f:selectItem itemLabel="N-1 Aout" itemValue="28"/>
                        <f:selectItem itemLabel="N-1 Septembre" itemValue="29"/>
                        <f:selectItem itemLabel="N-1 Octobre" itemValue="30"/>
                        <f:selectItem itemLabel="N-1 Novembre" itemValue="31"/>
                        <f:selectItem itemLabel="N-1 Décembre" itemValue="32"/>
                        <f:selectItem itemLabel="N-1 1er trimestre" itemValue="33"/>
                        <f:selectItem itemLabel="N-1 2eme trimestre" itemValue="34"/>
                        <f:selectItem itemLabel="N-1 3eme trimestre" itemValue="35"/>
                        <f:selectItem itemLabel="N-1 4eme trimestre" itemValue="36"/>
                        <f:selectItem itemLabel="N-1 1er semestre" itemValue="38"/>
                        <f:selectItem itemLabel="N-1 2eme semestre" itemValue="38"/>
                        <f:selectItem itemLabel="N-1 (Période complète)" itemValue="39"/>
                        <f:selectItem itemLabel="N-2" itemValue="40"/>
                        <f:selectItem itemLabel="N-2 Janvier" itemValue="41"/>
                        <f:selectItem itemLabel="N-2 Février" itemValue="42"/>
                        <f:selectItem itemLabel="N-2 Mars" itemValue="43"/>
                        <f:selectItem itemLabel="N-2 Avril" itemValue="44"/>
                        <f:selectItem itemLabel="N-2 Mai" itemValue="45"/>
                        <f:selectItem itemLabel="N-2 Juin" itemValue="46"/>
                        <f:selectItem itemLabel="N-2 Juillet" itemValue="47"/>
                        <f:selectItem itemLabel="N-2 Aout" itemValue="48"/>
                        <f:selectItem itemLabel="N-2 Septembre" itemValue="49"/>
                        <f:selectItem itemLabel="N-2 Octobre" itemValue="50"/>
                        <f:selectItem itemLabel="N-2 Novembre" itemValue="51"/>
                        <f:selectItem itemLabel="N-2 Décembre" itemValue="52"/>
                        <f:selectItem itemLabel="N-2 1er trimestre" itemValue="53"/>
                        <f:selectItem itemLabel="N-2 2eme trimestre" itemValue="54"/>
                        <f:selectItem itemLabel="N-2 3eme trimestre" itemValue="55"/>
                        <f:selectItem itemLabel="N-2 4eme trimestre" itemValue="56"/>
                        <f:selectItem itemLabel="N-2 1er semestre" itemValue="57"/>
                        <f:selectItem itemLabel="N-2 2eme semestre" itemValue="58"/>
                        <f:selectItem itemLabel="N-2 (Période complète)" itemValue="59"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Largeur:"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.etatFinancier.typeCol}" style="width:100%">
                        <f:selectItem itemLabel="Petite largeur" itemValue="0"/>
                        <f:selectItem itemLabel="Largeur moyenne" itemValue="7"/>
                        <f:selectItem itemLabel="Grande largeur" itemValue="8"/>
                    </h:selectOneMenu>
                </h:column>            
            </h:panelGrid>
            <br><br><br>
            <center>
                <h:panelGroup>
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.saveColonne}" image="/images/valider_big.png" style="text-decoration:none;"/>
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelElement" headerClass="headerPanel" width="540" height="300" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);">
        <f:facet name="header">
            <h:panelGroup>
                <center> <h:outputText value="DESCRIPTION D'UN ELEMENT"></h:outputText></center>
            </h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidepanelFElmtSave"/>
                <rich:componentControl for="panelElement" attachTo="hidepanelFElmtSave" operation="hide" event="onclick"/>
            </h:panelGroup>
        </f:facet>
        <a4j:form  >
            <h:panelGrid columns="2" columnClasses="clos30,clos70">
                <h:column><h:outputText value="Référence:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabElement.tabeleReference}" maxlength="20" style="width:200px;"/></h:column>
                <h:column><h:outputText value="Libellé:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabElement.tabeleLibFR}" maxlength="200" style="width:100%;"/></h:column>
                <h:column><h:outputText value="Type:"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabElement.tabeleType}" style="width:100%;">
                        <f:selectItem itemLabel="Titre principal" itemValue="0"/>
                        <f:selectItem itemLabel="Titre secondaire " itemValue="1"/>
                        <f:selectItem itemLabel="Sous Titre" itemValue="2"/>
                        <f:selectItem itemLabel="Calcul Automatique ou Saisie" itemValue="3"/>
                        <!--f:selectItem itemLabel="Saisie" itemValue="4"/-->
                        <f:selectItem itemLabel="Total Sous Titre " itemValue="5"/>
                        <f:selectItem itemLabel="Total Titre secondaire " itemValue="6"/>
                        <f:selectItem itemLabel="Total Titre principal " itemValue="7"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Résultat intermédiaire:"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabElement.tabeleMode}" style="width:100%;">
                        <f:selectItem itemLabel="Non" itemValue="0"/>
                        <f:selectItem itemLabel="Oui" itemValue="1"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Non imprimable:"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabElement.tabelePrint}" style="width:340px;">
                        <f:selectItem itemLabel="Non" itemValue="0"/>
                        <f:selectItem itemLabel="Oui" itemValue="1"/>
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>
            <br><br><br>
            <center>
                <h:panelGroup>
                    <a4j:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.saveElemnent}"  image="/images/valider_big.png" style="text-decoration:none;" reRender="panelElement,tabelement"/>
                </h:panelGroup>
            </center>
        </a4j:form>

    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelFormule" headerClass="headerPanel" width="1000" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);">
        <f:facet name="header">
            <h:panelGroup>
                <h:outputText value="DETAILS DE LA FORMULE (LIGNE/COLONNE)"></h:outputText>
            </h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidepanelFormulesave"/>
                <rich:componentControl for="panelFormule" attachTo="hidepanelFormulesave" operation="hide" event="onclick"/>
            </h:panelGroup>
        </f:facet>
        <a4j:form>
            <h:panelGrid columns="2" columnClasses="clos30,clos70" width="100%">
                <h:column><h:outputText value="Formules:" /></h:column>
                <h:column><h:inputText style="width:100%;" id="pngpFormule" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabFormule.tabforFormule}" maxlength="1000"/></h:column>
                <h:column><h:outputText value="Période:"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabFormule.tabforPeriode}" style="width:100%">
                        <f:selectItem itemLabel="N" itemValue="0"/>
                        <f:selectItem itemLabel="N Janvier" itemValue="1"/>
                        <f:selectItem itemLabel="N Février" itemValue="2"/>
                        <f:selectItem itemLabel="N Mars" itemValue="3"/>
                        <f:selectItem itemLabel="N Avril" itemValue="4"/>
                        <f:selectItem itemLabel="N Mai" itemValue="5"/>
                        <f:selectItem itemLabel="N Juin" itemValue="6"/>
                        <f:selectItem itemLabel="N Juillet" itemValue="7"/>
                        <f:selectItem itemLabel="N Aout" itemValue="8"/>
                        <f:selectItem itemLabel="N Septembre" itemValue="9"/>
                        <f:selectItem itemLabel="N Octobre" itemValue="10"/>
                        <f:selectItem itemLabel="N Novembre" itemValue="11"/>
                        <f:selectItem itemLabel="N Décembre" itemValue="12"/>
                        <f:selectItem itemLabel="N 1er trimestre" itemValue="13"/>
                        <f:selectItem itemLabel="N 2eme trimestre" itemValue="14"/>
                        <f:selectItem itemLabel="N 3eme trimestre" itemValue="15"/>
                        <f:selectItem itemLabel="N 4eme trimestre" itemValue="16"/>
                        <f:selectItem itemLabel="N 1er semestre" itemValue="17"/>
                        <f:selectItem itemLabel="N 2eme semestre" itemValue="18"/>
                        <f:selectItem itemLabel="N (Période complète)" itemValue="19"/>
                        <f:selectItem itemLabel="N-1" itemValue="20"/>
                        <f:selectItem itemLabel="N-1 Janvier" itemValue="21"/>
                        <f:selectItem itemLabel="N-1 Février" itemValue="22"/>
                        <f:selectItem itemLabel="N-1 Mars" itemValue="23"/>
                        <f:selectItem itemLabel="N-1 Avril" itemValue="24"/>
                        <f:selectItem itemLabel="N-1 Mai" itemValue="25"/>
                        <f:selectItem itemLabel="N-1 Juin" itemValue="26"/>
                        <f:selectItem itemLabel="N-1 Juillet" itemValue="27"/>
                        <f:selectItem itemLabel="N-1 Aout" itemValue="28"/>
                        <f:selectItem itemLabel="N-1 Septembre" itemValue="29"/>
                        <f:selectItem itemLabel="N-1 Octobre" itemValue="30"/>
                        <f:selectItem itemLabel="N-1 Novembre" itemValue="31"/>
                        <f:selectItem itemLabel="N-1 Décembre" itemValue="32"/>
                        <f:selectItem itemLabel="N-1 1er trimestre" itemValue="33"/>
                        <f:selectItem itemLabel="N-1 2eme trimestre" itemValue="34"/>
                        <f:selectItem itemLabel="N-1 3eme trimestre" itemValue="35"/>
                        <f:selectItem itemLabel="N-1 4eme trimestre" itemValue="36"/>
                        <f:selectItem itemLabel="N-1 1er semestre" itemValue="38"/>
                        <f:selectItem itemLabel="N-1 2eme semestre" itemValue="38"/>
                        <f:selectItem itemLabel="N-1 (Période complète)" itemValue="39"/>
                        <f:selectItem itemLabel="N-2" itemValue="40"/>
                        <f:selectItem itemLabel="N-2 Janvier" itemValue="41"/>
                        <f:selectItem itemLabel="N-2 Février" itemValue="42"/>
                        <f:selectItem itemLabel="N-2 Mars" itemValue="43"/>
                        <f:selectItem itemLabel="N-2 Avril" itemValue="44"/>
                        <f:selectItem itemLabel="N-2 Mai" itemValue="45"/>
                        <f:selectItem itemLabel="N-2 Juin" itemValue="46"/>
                        <f:selectItem itemLabel="N-2 Juillet" itemValue="47"/>
                        <f:selectItem itemLabel="N-2 Aout" itemValue="48"/>
                        <f:selectItem itemLabel="N-2 Septembre" itemValue="49"/>
                        <f:selectItem itemLabel="N-2 Octobre" itemValue="50"/>
                        <f:selectItem itemLabel="N-2 Novembre" itemValue="51"/>
                        <f:selectItem itemLabel="N-2 Décembre" itemValue="52"/>
                        <f:selectItem itemLabel="N-2 1er trimestre" itemValue="53"/>
                        <f:selectItem itemLabel="N-2 2eme trimestre" itemValue="54"/>
                        <f:selectItem itemLabel="N-2 3eme trimestre" itemValue="55"/>
                        <f:selectItem itemLabel="N-2 4eme trimestre" itemValue="56"/>
                        <f:selectItem itemLabel="N-2 1er semestre" itemValue="57"/>
                        <f:selectItem itemLabel="N-2 2eme semestre" itemValue="58"/>
                        <f:selectItem itemLabel="N-2 (Période complète)" itemValue="59"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Formule inactive:"/></h:column>
                <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabFormule.var_for_inactif}" /></h:column>
            </h:panelGrid>

            <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabOperateur" label="Opérateurs">
                    <h:panelGrid  width="100%" columns ="2" headerClass="headerTab" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Opérateurs Arithmétiques:"/></h:column>
                        <h:column>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterEq}" reRender="pngpFormule" value="=" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterPlus}" reRender="pngpFormule" value="+" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterMoins}" reRender="pngpFormule" value="-" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterMulti}" reRender="pngpFormule" value="*" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterDiv}" reRender="pngpFormule"  value="/" size="3"/>
                        </h:column>
                        <h:column><h:outputText value="Opérateurs Tableaux:"/></h:column>
                        <h:column>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterVal}" reRender="pngpFormule"  value="VAL" title="VAL(100)" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterCel}" reRender="pngpFormule" value="CEL" size="3" title="CEL(TAB=REF:COL) ou CEL(REF:COL) ou CEL(REF:*) ou CEL(TAB=REF:*)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterSomv}" reRender="pngpFormule" value="SOMV" size="3" title="SOMV(Référence départ:Référence fin)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterSomh}" reRender="pngpFormule" value="SOMH" size="3" title="SOMH(Colonne départ:Colonne fin)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterDifh}" reRender="pngpFormule" value="DIFH" size="3" title="DIFH(Colonne départ:Colonne fin)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterVal}" reRender="pngpFormule" value="VAL" size="3" title="VAL(valeur numérique)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterColP}" reRender="pngpFormule" value="COL>0" size="3" title="Garde la valeur si > 0"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterColN}" reRender="pngpFormule" value="COL<0" size="3" title="Garde la valeur asolue si < 0"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterSTOT}" reRender="pngpFormule" value="STOT" size="3" title="Calcule le sous total STOT(Numero ligne, Numéro colonne)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterTTAB}" reRender="pngpFormule" value="TTAB" size="3" title="Calcule total colonne TTaB(Numero colonne)"/>
                        </h:column>
                        <h:column><h:outputText value="Opérateurs Logiques:"/></h:column>
                        <h:column>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterSupp}" reRender="pngpFormule" value=">" size="3" />
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterInf}" reRender="pngpFormule" value="<" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterSuppOrEq}" reRender="pngpFormule" value=">=" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterInfOrEq}" reRender="pngpFormule" value="<=" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterDiff}" reRender="pngpFormule" value="<>" size="3"/>
                        </h:column>
                        <h:column><h:outputText value="Opérateurs Conditionnels:"/></h:column>
                        <h:column>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterSi}" reRender="pngpFormule" value="SI" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterNon}" reRender="pngpFormule" value="NON" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterFin}" reRender="pngpFormule" value="FIN" size="3"/>
                        </h:column>
                        <h:column><h:outputText value="Opérateurs Divers:"/></h:column>
                        <h:column>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterAr}" reRender="pngpFormule"  value="ARR" size="3" title="ARR() ou ARR(1) ou ARR(2)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterAb}" reRender="pngpFormule" value="ABS" size="3" title="Valeur absolue ABS()"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterInv}" reRender="pngpFormule" value="INV" size="3" title="Inverse le signe INV()"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterEcom}" reRender="pngpFormule" value="&" size="3" title="opérateur ET"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterBo}" reRender="pngpFormule" value="|" size="3" title="Opérateur OU"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterEcom}" reRender="pngpFormule" value="INT" size="3" title="Partie entière INT()"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterMod}" reRender="pngpFormule" value="MOD" size="3" title="Reste de la division MOD()"/>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabAnalytique" label="Analytique">
                    <h:panelGrid  width="100%" columns ="2" headerClass="headerTab" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Filtre Budget:"/></h:column>
                        <h:column><h:inputText style="width:100%;" id="pngpBudget" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabFormule.tabforBudget}" maxlength="1000"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.masqueAnalytique}"><h:outputText value="Filtre analytique:"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.masqueAnalytique}">
                            <h:inputText style="width:100%;" id="pngpAnalytique" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabFormule.tabforAnalytique}" maxlength="10000">
                                <rich:toolTip for="pngpAnalytique" followMouse="true" direction="top-right" showDelay="1000" value="Les axes sont séparés par : et les postes par ; Exemple : DEP(01;02;03):ACT(A1;A2) " style="background-color:#FFF8D4;"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Opérateurs budgétaires et Analytiques:"/></h:column>
                        <h:column>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterBud}" reRender="pngpBudget" value="BUDGET" size="3" title="BUDGET(Compte) ou BUDGET(Compte 1;Compte 2;CompteX)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterSit}" reRender="pngpAnalytique" value="SIT" size="3" title="Site" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.masqueAnalytique}"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterDep}" reRender="pngpAnalytique" value="DEP" size="3" title="Département" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.masqueAnalytique}"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterServ}" reRender="pngpAnalytique" value="SER" size="3" title="Service" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.masqueAnalytique}"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterReg}" reRender="pngpAnalytique" value="REG" size="3" title="Région" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.masqueAnalytique}"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterSec}" reRender="pngpAnalytique" value="SEC" size="3" title="Secteur" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.masqueAnalytique}"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterPdv}" reRender="pngpAnalytique" value="PDV" size="3" title="Point de vente" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.masqueAnalytique}"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterPrc}" reRender="pngpAnalytique" value="PRC" size="3" title="Parc" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.masqueAnalytique}"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterDos}" reRender="pngpAnalytique" value="DOS" size="3" title="Dossier" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.masqueAnalytique}"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterAgt}" reRender="pngpAnalytique" value="AGT" size="3" title="Agent" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.masqueAnalytique}"/>
                            <a4j:commandButton rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.decoupageanalytique&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.masqueAnalytique}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterAct}" reRender="pngpAnalytique" value="ACT" size="3" title="Activité"/>
                            <a4j:commandButton rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.decoupageanalytique&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.masqueAnalytique}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterAc1}" reRender="pngpAnalytique" value="AC1" size="3" title="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}"/>
                            <a4j:commandButton rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.decoupageanalytique&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.masqueAnalytique}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterAc2}" reRender="pngpAnalytique" value="AC2" size="3" title="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}"/>
                            <a4j:commandButton rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.decoupageanalytique&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.masqueAnalytique}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterAc3}" reRender="pngpAnalytique" value="AC3" size="3" title="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}"/>
                            <a4j:commandButton rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.decoupageanalytique&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.masqueAnalytique}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterAcx}" reRender="pngpAnalytique" value="ACX" size="3" title="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterTie}" reRender="pngpAnalytique" value="TIE" size="3" title="Compte du Tiers"/>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabComptabilite" label="Comptabilité">
                    <h:panelGrid  width="100%" columns ="2" headerClass="headerTab" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Type:" /></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabFormule.tabforSolde}" style="width:100%">
                                <f:selectItem itemLabel="Compte Débiteur (Tout Solde)" itemValue="0"/>
                                <f:selectItem itemLabel="Compte Créditeur (Tout Solde)" itemValue="1"/>
                                <f:selectItem itemLabel="Solde Débiteur" itemValue="2"/>
                                <f:selectItem itemLabel="Solde Créditeur" itemValue="3"/>
                                <f:selectItem itemLabel="Mouvements Débiteurs" itemValue="4"/>
                                <f:selectItem itemLabel="Mouvements Créditeurs" itemValue="5"/>
                                <f:selectItem itemLabel="Tout Solde AN (Comptes Débiteurs)" itemValue="10"/>
                                <f:selectItem itemLabel="Tout Solde AN (Comptes Crédteurs)" itemValue="11"/>
                                <f:selectItem itemLabel="Solde Débiteur AN" itemValue="12"/>
                                <f:selectItem itemLabel="Solde Créditeur AN" itemValue="13"/>
                                <f:selectItem itemLabel="Mouvements Débiteurs AN" itemValue="14"/>
                                <f:selectItem itemLabel="Mouvements Créditeurs AN" itemValue="15"/>
                                <f:selectItem itemLabel="Mouvements Débiteur sauf AN & V.P/P" itemValue="16"/>
                                <f:selectItem itemLabel="Mouvements Créditeurs sauf AN & V.P/P" itemValue="17"/>
                                <f:selectItem itemLabel="Mouvements Débiteur sauf V.P/P" itemValue="18"/>
                                <f:selectItem itemLabel="Mouvements Créditeurs sauf V.P/P" itemValue="19"/>
                                <f:selectItem itemLabel="Mouvements Débiteur V.P/P" itemValue="20"/>
                                <f:selectItem itemLabel="Mouvements Créditeurs V.P/P" itemValue="21"/>
                                <f:selectItem itemLabel="Tout Solde uniquement V.P/P" itemValue="22"/>
                                <f:selectItem itemLabel="Recettes" itemValue="30"/>
                                <f:selectItem itemLabel="Dépenses" itemValue="31"/>
                                <f:selectItem itemLabel="Solde (Recettes - Dépenses)" itemValue="32"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Opérateurs Comptes:"/></h:column>
                        <h:column>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterCpt}" reRender="pngpFormule" value="COMPTE" size="3" title="COMPTE(Compte 1;Compte 2;CompteX)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterAmach}" reRender="pngpFormule" value="AMACH" size="3" title="Valeur achat AMACH(Compte 1;Compte 2;Compte X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterAmdot}" reRender="pngpFormule" value="AMDOT" size="3" title="Valeur dotation AMDOT(Compte 1;Compte 2;Compte X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterAmant}" reRender="pngpFormule" value="AMANT" size="3" title="Valeur antérieur AMANT(Compte 1;Compte 2;Compte X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterAmres}" reRender="pngpFormule" value="AMRES" size="3" title="Valeur résiduelle AMRES(Compte 1;Compte 2;Compte X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterAmces}" reRender="pngpFormule" value="AMCES" size="3" title="Valeur cession AMCES(Compte 1;Compte 2;Compte X)"/>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabPaye" label="Paye">
                    <h:panelGrid  width="100%" columns ="2" headerClass="headerTab" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Rubrique Paye:"/></h:column>
                        <h:column><a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterRub}" reRender="pngpFormule" value="RUBRIQUE" size="3" title="RUBRIQUE(Rubrique 1:colonne;Rubrique 2:colonne;RubriqueX:colonne)"/></h:column>
                        <h:column><h:outputText value="Nature Rubrique:"/></h:column>
                        <h:column><a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterRubNat}" reRender="pngpFormule" value="NAT_RUBRIQUE" size="3" title="NAT_RUBRIQUE(Nature 1:colonne;Nature 2:colonne;NatureX:colonne)"/></h:column>
                        <h:column><h:outputText value="Feuilles Salarié:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabFormule.tabforFeuilleSalarie}" style="width:100%;">
                                <f:selectItem itemLabel="Toutes feuilles" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.lesFeuillesSalaries}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Etat Salarié:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabFormule.tabforEtatSalarie}" style="width:100%;">
                                <f:selectItem itemLabel="Tous états" itemValue="99"/>
                                <f:selectItem itemLabel="Actif" itemValue="0"/>
                                <f:selectItem itemLabel="Licencié" itemValue="2"/>
                                <f:selectItem itemLabel="Démissioné" itemValue="3"/>
                                <f:selectItem itemLabel="Décédé" itemValue="4"/>
                                <f:selectItem itemLabel="Retraité" itemValue="5"/>
                                <f:selectItem itemLabel="Fin de contrat" itemValue="6"/>
                                <f:selectItem itemLabel="Arret/Suspendu" itemValue="7"/>
                                <f:selectItem itemLabel="Mutation" itemValue="8"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Type Salarié:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabFormule.tabforTypeSalarie}" style="width:100%;">
                                <f:selectItem itemLabel="Salariés non refacturés" itemValue="0"/>
                                <f:selectItem itemLabel="Salariés refacturés" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Classement Salarié:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="classement" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabFormule.tabforClassementSalarie}" style="width:100%;">
                                <f:selectItem itemLabel="Tous Classements" itemValue=""/>
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.mesClassementsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Nature Salarié:"/></h:column>
                        <h:column>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="tabletabNatureSalarie" height="200px"  activeClass="active-row" noDataLabel=" " enableContextMenu="false" footerClass="bard"headerClass="headerTab"   width="100%" border="0" styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.lesNaturesSalaries}" var="natsal">
                                    <rich:column width="10%" sortable="false">
                                        <f:facet name="header" ><h:outputText value="Sel."/></f:facet>
                                        <h:selectBooleanCheckbox value="#{natsal.valide}" />
                                    </rich:column >
                                    <rich:column width="10%" >
                                        <f:facet name="header" ><h:outputText value="Code"/></f:facet>
                                        <h:outputText  value="#{natsal.code}"/>
                                    </rich:column>
                                    <rich:column width="80%" sortable="false" >
                                        <f:facet name="header" ><h:outputText value="Nature salarié"/></f:facet>
                                        <h:outputText  value="#{natsal.nom_FR}"/>
                                    </rich:column >
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabTreso" label="Trésorerie">
                    <h:panelGrid  width="100%" columns ="2" headerClass="headerTab" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Opérateurs Trésorerie:"/></h:column>
                        <h:column>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterExec}" reRender="pngpFormule" value="EXEC" size="3" title="EXEC(Code caisse1 ou banque1;Code caisse2 ou banque2;Code caisseX ou banqueX) ou EXCE(*) = tous les organes"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterOrig}" reRender="pngpFormule" value="ORIG" size="3" title="ORIG(Code caisse1 ou banque1;Code caisse2 ou banque2;Code caisseX ou banqueX) ou ORIG(*) = tous les organes"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterDest}" reRender="pngpFormule" value="DEST" size="3" title="DEST(Code caisse1 ou banque1;Code caisse2 ou banque2;Code caisseX ou banqueX) ou DEST(*) = tous les organes"/>
                        </h:column>
                        <h:column><h:outputText value="Mode de paiement:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabFormule.tabforTypeReglement}" style="width:100%">
                                <f:selectItem itemLabel="Tous modes paiement" itemValue="99"/>
                                <f:selectItem itemLabel="Especes" itemValue="0"/>
                                <f:selectItem itemLabel="Chéque" itemValue="1"/>
                                <f:selectItem itemLabel="Virement" itemValue="2"/>
                                <f:selectItem itemLabel="Traite" itemValue="3"/>
                                <f:selectItem itemLabel="CB" itemValue="4"/>
                                <f:selectItem itemLabel="Transfert" itemValue="5"/>
                                <f:selectItem itemLabel="ePaiement" itemValue="6"/>
                                <f:selectItem itemLabel="Crédoc" itemValue="7"/>
                                <f:selectItem itemLabel="Factor" itemValue="8"/>
                                <f:selectItem itemLabel="Compense" itemValue="9"/>
                                <f:selectItem itemLabel="Terme" itemValue="10"/>
                                <f:selectItem itemLabel="Lettre garantie" itemValue="12"/>
                                <f:selectItem itemLabel="Prélévement" itemValue="13"/>
                                <f:selectItem itemLabel="Bitcoin" itemValue="14"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Sens opéraiton:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabFormule.tabforSens}" style="width:100%">
                                <f:selectItem itemLabel="Tous sens" itemValue="99"/>
                                <f:selectItem itemLabel="Dépense" itemValue="0"/>
                                <f:selectItem itemLabel="Recette" itemValue="1"/>
                                <f:selectItem itemLabel="Recette - Dépense" itemValue="2"/>
                                <f:selectItem itemLabel="Dépense - Recette" itemValue="3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Nature opération:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabFormule.tabforNature}" style="width:100%">
                                <f:selectItem itemLabel="Toutes natures" itemValue="99"/>
                                <f:selectItem itemLabel="Non renseigné" itemValue="0"/>
                                <f:selectItem itemLabel="Facture achats" itemValue="15"/>
                                <f:selectItem itemLabel="Note de débit achats" itemValue="17"/>
                                <f:selectItem itemLabel="Facture de frais" itemValue="18"/>
                                <f:selectItem itemLabel="BC ventes" itemValue="22"/>
                                <f:selectItem itemLabel="BL ventes" itemValue="23"/>
                                <f:selectItem itemLabel="Factures ventes" itemValue="25"/>
                                <f:selectItem itemLabel="Note de débit ventes" itemValue="27"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Catégorie opération:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabFormule.tabforCategorie}" style="width:100%">
                                <f:selectItem itemLabel="Toutes catégories" itemValue="99"/>
                                <f:selectItem itemLabel="Fournisseurs" itemValue="0"/>
                                <f:selectItem itemLabel="Clients" itemValue="20"/>
                                <f:selectItem itemLabel="Patients" itemValue="30"/>
                                <f:selectItem itemLabel="Eleves" itemValue="40"/>
                                <f:selectItem itemLabel="Bons de sortie" itemValue="62"/>
                                <f:selectItem itemLabel="Bons d'entrée" itemValue="63"/>
                                <f:selectItem itemLabel="Virements" itemValue="64"/>
                                <f:selectItem itemLabel="Salariés" itemValue="80"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Racine compte destinataire:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.cptTabFormule.tabforCpteDest}" maxlength="20" style="width:200px;"/></h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabGestcomm" label="Suivi commercial">
                    <h:panelGrid  width="100%" columns ="2" headerClass="headerTab" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="C.A. Produits:"/></h:column>
                        <h:column>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterCaBlv}" reRender="pngpFormule" value="CABLV" size="3" title="C.A. Bon de livraison CABLV(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterCaBrt}" reRender="pngpFormule" value="CABRT" size="3" title="C.A. Bon de retour CABRT(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterCaBst}" reRender="pngpFormule" value="CABST" size="3" title="C.A. Bon de sortie CABST(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterCaBen}" reRender="pngpFormule" value="CABEN" size="3" title="C.A. Bon d'entrée CABEN(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterCaFac}" reRender="pngpFormule" value="CAFAC" size="3" title="C.A. Facturation CAFAC(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterCaNdb}" reRender="pngpFormule" value="CANDB" size="3" title="C.A. Note de débit CANDN(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterCaAvr}" reRender="pngpFormule" value="CAAVR" size="3" title="C.A. Avoir CAAVR(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterCaAch}" reRender="pngpFormule" value="CAACH" size="3" title="C.A. facture d'achat CABRT(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterCaPrd}" reRender="pngpFormule" value="CAPRD" size="3" title="Cout de production CAPRD(Code produit1;Code produit 2;Code produit X)"/>
                        </h:column>
                        <h:column><h:outputText value="Valoume Produits:"/></h:column>
                        <h:column>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterVlBlv}" reRender="pngpFormule" value="VLBLV" size="3" title="Volume Bon de livraison VLBLV(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterVlBrt}" reRender="pngpFormule" value="VLBRT" size="3" title="Volume Bon de retour VLBRT(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterVlBst}" reRender="pngpFormule" value="VLBST" size="3" title="Volume Bon de sortie VLBST(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterVlBen}" reRender="pngpFormule" value="VLBEN" size="3" title="Volume Bon d'entrée VLBEN(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterVlFac}" reRender="pngpFormule" value="VLFAC" size="3" title="Volume Facturé VLFAC(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterVlNdb}" reRender="pngpFormule" value="VLNDN" size="3" title="Volume Note de débit VLNDB(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterVlAvr}" reRender="pngpFormule" value="VLAVR" size="3" title="Volume Avoir VLAVR(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterVlAch}" reRender="pngpFormule" value="VLACH" size="3" title="Volume Acheté VLACH(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterVlPrd}" reRender="pngpFormule" value="VLPRD" size="3" title="Volume Produit VLPRD(Code produit1;Code produit 2;Code produit X)"/>
                        </h:column>
                        <h:column><h:outputText value="Quantité Produits:"/></h:column>
                        <h:column>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterQtBlv}" reRender="pngpFormule" value="QTBLV" size="3" title="Quantité Bon de livraison QTBLV(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterQtBrt}" reRender="pngpFormule" value="QTBRT" size="3" title="Quantité Bon de retour QTBRT(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterQtBst}" reRender="pngpFormule" value="QTBST" size="3" title="Quantité Bon de sortie QTBST(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterQtBen}" reRender="pngpFormule" value="QTBEN" size="3" title="Quantité Bon d'entrée QTBST(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterQtFac}" reRender="pngpFormule" value="QTFAC" size="3" title="Quantité Facturé QTFAC(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterQtNdb}" reRender="pngpFormule" value="QTNDB" size="3" title="Quantité Note de débit QTNDB(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterQtAvr}" reRender="pngpFormule" value="QTAVR" size="3" title="Quantité Avoir QTAVR(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterQtAch}" reRender="pngpFormule" value="QTACH" size="3" title="Quantité Acheté QTACH(Code produit1;Code produit 2;Code produit X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.AffecterQtPrd}" reRender="pngpFormule" value="QTPRD" size="3" title="Quantité Produit QTPRD(Code produit1;Code produit 2;Code produit X)"/>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <br><br><br>
            <center>
                <h:panelGroup>
                    <a4j:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierConfigClient.saveFormule}"  image="/images/valider_big.png" style="text-decoration:none;" reRender="panelFormule,tabletabformule"/>
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>

</f:subview>
