<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="etatFinancier">

    <a4j:form id="etatfi">

        <center> <h2><h:outputText value="ETATS FINANCIERS / BILANS SOCIAUX (SYSTEME)" style="color:green;font-size:16px;"/></h2></center>

        <h:panelGrid id="impgenPG" border="0" width="100%" style="border:0px solid green;"  columns="3">

            <rich:column  width="25%" style="border:1px solid green;">
                <rich:extendedDataTable id="tableZone"height="550px" styleClass="bg" headerClass="headerTab" activeClass="active-row" noDataLabel=" "  width="100%" border="0"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.datamodelMesZones}" var="zone">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.selectionZonefiscale}" reRender="panelTableaux,panelColonnes,panelElements,tableFormules,boutonFormules"/>
                    <rich:column width="100%">
                        <f:facet name="header" ><h:outputText value="Zone fiscale"/></f:facet>
                        <h:outputText value="#{zone.code}"/>
                    </rich:column >
                </rich:extendedDataTable>
            </rich:column>

            <rich:column id="panelTableaux" width="25%" style="border:1px solid green;">
                <h:panelGrid id="boutonTableaux" columns="5" width="200px" style="height:34px">
                    <a4j:commandButton image="/images/ajouter.png" title="Ajouter tableau"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.ajouterTableaux}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.zone!=null}" reRender="modalPanelTableau"/>
                    <a4j:commandButton image="/images/modifier.png" title="Modifier tableau"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablis_id!=0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.modifierTableaux}" reRender="modalPanelTableau"/>
                    <a4j:commandButton image="/images/supprimer.png"  title="Supprimer tableau" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablis_id!=0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.supprimerTableaux}" onclick="if (!confirm('Etes vous sur de vouloir supprimer le tableau #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisCode} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisLibFR} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisZone})?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableTableaux,boutonTableaux,tableColonne,panelElements,boutonElements,tableElements" />
                    <a4j:commandButton image="/images/print.png" title="Imprimer" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablis_id!=0}" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
                    <a4j:commandButton image="/images/duplicate.png" title="Duppliquer tableau"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.duppliquerTableaux}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablis_id!=0}" reRender="modalPanelDuppliquer"/>
                </h:panelGrid>

                <rich:extendedDataTable id="tableTableaux" enableContextMenu="false" height="290px"styleClass="bg"  headerClass="headerTab" activeClass="active-row" noDataLabel=" " width="100%" border="0" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.datamodeltabNom}" var="tableau">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.selectionTableaux}" reRender="panelColonnes,tableColonne,boutonTableaux,boutonElements,panelElements"/>
                    <rich:column width="20%" sortable="false" sortBy="#{tableau.tablisNum}">
                        <f:facet name="header" ><h:outputText value="Liste tableaux"/></f:facet>
                        <h:outputText  value="#{tableau.tablisNum}" />
                    </rich:column >
                    <rich:column width="80%" sortable="false" sortBy="#{tableau.tablisNum}" sortOrder="ASCENDING">
                        <f:facet name="header" ><h:outputText value="Liste tableaux"/></f:facet>
                        <h:outputText  value="#{tableau.tablisLibFR}" />
                    </rich:column >
                </rich:extendedDataTable>

                <h:panelGroup id="panelColonnes" >
                    <rich:extendedDataTable id="tableColonne" enableContextMenu="false" height="250px" styleClass="bg" headerClass="headerTab" activeClass="active-row" noDataLabel=" " value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.dataModelLesNomsCol}"   width="100%" border="0"   var="Nomcol">
                        <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.selectionColonne}" reRender="tableFormules,boutonFormules,boutonElements"/>
                        <rich:column width="20%" >
                            <f:facet name="header" ><h:outputText value="N°" /></f:facet>
                            <h:outputText value="#{Nomcol.numCol}"  />
                        </rich:column >
                        <rich:column width="30%" >
                            <f:facet name="header" ><h:outputText value="Période" /></f:facet>
                            <h:outputText value="#{Nomcol.libPeriodeCol}" />
                        </rich:column >
                        <rich:column width="30%" >
                            <f:facet name="header" ><h:outputText value="Libellé" /></f:facet>
                            <h:outputText value="(#{Nomcol.libTypeCol}) #{Nomcol.nomCol}"/>
                        </rich:column >
                        <rich:column width="20%" style="text-align:center;">
                            <a4j:commandButton immediate="true" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.modifierColonne}" value="M." reRender="modalPanelColonnes"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </h:panelGroup>
            </rich:column>

            <rich:column id="panelElements" width="50%" style="border:1px solid green;width:100%">
                <h:panelGrid id="boutonElements" columns="3" width="150px" style="height:34px">
                    <a4j:commandButton image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablis_id!=0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.ajouterElement}" reRender="modalPanelElements"/>
                    <a4j:commandButton image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabElement.tabele_id!=0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.modifierElement}" reRender="modalPanelElements"/>
                    <a4j:commandButton image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.datamodeltabFormule.rowCount==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabElement.tabele_id!=0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.supprimerElement}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" reRender="tableElements,boutonElements"/>
                </h:panelGrid>

                <rich:extendedDataTable id="tableElements" enableContextMenu="false" height="250px" styleClass="bg" headerClass="headerTab" activeClass="active-row" noDataLabel=" " width="100%" border="0"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.datamodeltabElement}" var="element">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.selectionElement}" reRender="boutonElements,boutonFormules,tableFormules,boutonFormules" />
                    <rich:column width="6%" >
                        <f:facet name="header" ><h:outputText value="Ord. "/></f:facet>
                        <h:outputText  value="#{element.tabeleNum}" />
                    </rich:column >
                    <rich:column style="height:20px;" width="7%" sortable="false">
                        <f:facet name="header"><h:outputText  value="T.C." /></f:facet>
                        <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.ordonnnerDescendant}" image="/images/downarrow.png" id="decroissant" rendered="#{((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.datamodeltabElement.rowIndex+1)<bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.datamodeltabElement.rowCount)==true}"/>
                    </rich:column>
                    <rich:column style="height:20px;" width="7%" sortable="false" >
                        <f:facet name="header"><h:outputText  value="T.D." /></f:facet>
                        <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.ordonnnerAscendant}"  image="/images/uparrow.png"  id="croissant" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.datamodeltabElement.rowIndex>=1)==true}"/>
                    </rich:column>
                    <rich:column width="10%" >
                        <f:facet name="header" ><h:outputText value="Réf."/></f:facet>
                        <h:outputText  value="#{element.tabeleReference}" />
                    </rich:column >
                    <rich:column width="20%" >
                        <f:facet name="header" ><h:outputText value="Type"/></f:facet>
                        <h:outputText  value="#{element.var_type}" />
                    </rich:column >
                    <rich:column width="10%" >
                        <f:facet name="header" ><h:outputText value="Rés."/></f:facet>
                        <h:outputText  value="#{element.var_resultat}" />
                    </rich:column >
                    <rich:column width="40%" >
                        <f:facet name="header" ><h:outputText value="Liste des éléments"/></f:facet>
                        <h:outputText  value="#{element.tabeleLibFR}"  />
                    </rich:column >
                </rich:extendedDataTable>

                <h:panelGrid id="boutonFormules" columns="3" width="150px" style="height:34px">
                    <a4j:commandButton image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabElement.tabele_id!=0}"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.ajouterFormule}" reRender="modalPanelFormules"/>
                    <a4j:commandButton image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabFormule.tabfor_id!=0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.modifierFormule}" reRender="modalPanelFormules" />
                    <a4j:commandButton image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabFormule.tabfor_id!=0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.supprimerFormule}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" reRender="tableFormules,boutonFormules" />
                </h:panelGrid>

                <rich:extendedDataTable id="tableFormules" enableContextMenu="false" height="250px" styleClass="bg" headerClass="headerTab"  activeClass="active-row" noDataLabel=" "    width="100%" border="0"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.datamodeltabFormule}" var="formule">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.selectionFormule}" reRender="boutonFormules"  />
                    <rich:column width="20%" >
                        <f:facet name="header" ><h:outputText value="Type" /></f:facet>
                        <h:outputText  value="#{formule.var_sens}"   />
                    </rich:column >
                    <rich:column width="10%" >
                        <f:facet name="header" ><h:outputText value="Période" /></f:facet>
                        <h:outputText value="#{formule.lib_periode}" />
                    </rich:column >
                    <rich:column width="70%" >
                        <f:facet name="header" ><h:outputText value="Formule" /></f:facet>
                        <h:outputText  value="#{formule.tabforFormule}" />
                    </rich:column >
                </rich:extendedDataTable>
            </rich:column>

        </h:panelGrid>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="modalPanelTableau" width="540" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.showmodalPanelTableaux}">
        <f:facet name="header"><h:outputText value="GESTION DES TABLEAUX"/></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.annulerTableaux}" image="/images/close.gif" styleClass="hidelink" reRender="modalPanelTableau"/>
            </a4j:form>
        </f:facet>
        <rich:panel style="border:0px solid green;width:100%;height:340px;">
            <a4j:form  >
                <h:panelGrid style="width:100%">
                    <h:panelGrid columns="2" columnClasses="clos25,clos75">
                        <h:outputText value="Code:"/><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisCode}"  />
                        <h:outputText value="Libelle FR:"/><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisLibFR}" style="width:340px;"   />
                        <h:outputText value="Libelle UK:"/><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisLibUK}"style="width:340px;"   />
                        <h:outputText value="Libelle SP:"/><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisLibSP}" style="width:340px;"   />
                        <h:outputText value="N° page:"/><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisNum}"/>
                        <h:outputText value="Nb colonnes:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisNbCol}"  >
                            <f:selectItem itemLabel="1 colonne" itemValue="1"/>
                            <f:selectItem itemLabel="2 colonnes" itemValue="2"/>
                            <f:selectItem itemLabel="3 colonnes" itemValue="3"/>
                            <f:selectItem itemLabel="4 colonnes" itemValue="4"/>
                            <f:selectItem itemLabel="5 colonnes" itemValue="5"/>
                            <f:selectItem itemLabel="6 colonnes" itemValue="6"/>
                            <f:selectItem itemLabel="7 colonnes" itemValue="7"/>
                            <f:selectItem itemLabel="8 colonnes" itemValue="8"/>
                            <f:selectItem itemLabel="9 colonnes" itemValue="9"/>
                            <f:selectItem itemLabel="10 colonne" itemValue="10"/>
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
                        <h:outputText value="Modèle impression:"/><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisModele}" style="width:340px;"/>
                        <h:outputText value="Type:"/>
                        <h:panelGroup>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisType}" style="width:300px;"  >
                                <f:selectItem itemLabel="Etat Financier" itemValue="0"/>
                                <f:selectItem itemLabel="Rapport de Synthèse" itemValue="1"/>
                                <f:selectItem itemLabel="Identification société" itemValue="2"/>
                                <f:selectItem itemLabel="Activités société" itemValue="3"/>
                                <f:selectItem itemLabel="Dirigeants, Actionnaires, Filiales" itemValue="4"/>
                                <f:selectItem itemLabel="Couvertures" itemValue="5"/>
                                <f:selectItem itemLabel="Recapitulatif des annexes" itemValue="6"/>
                                <f:selectItem itemLabel="Tableaux complémentaires" itemValue="7"/>
                                <f:selectItem itemLabel="Etats Annexes" itemValue="8"/>
                                <f:selectItem itemLabel="DSF" itemValue="9"/>
                                <f:selectItem itemLabel="--------------------------------" itemValue="99"/>
                                <f:selectItem itemLabel="Bilan social" itemValue="10"/>
                                <f:selectItem itemLabel="Couvertures" itemValue="15"/>
                            </h:selectOneMenu>
                        </h:panelGroup>
                        <h:outputText value="Mode:" />
                        <h:panelGroup>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisModif}" style="width:300px;" >
                                <f:selectItem itemLabel="Modifiable par le client" itemValue="0"/>
                                <f:selectItem itemLabel="Non Modifiable par le client" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:panelGroup>
                        <h:outputText value="Exercice N-1:" />
                        <h:panelGroup>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisAnneeAnte}" style="width:300px;" >
                                <f:selectItem itemLabel="Ne pas charger N-1" itemValue="0"/>
                                <f:selectItem itemLabel="Charger N-1" itemValue="1"/>
                                <f:selectItem itemLabel="Charger N-1 + N-2" itemValue="2"/>
                                <f:selectItem itemLabel="Charger N-1 + N-2 + N-3" itemValue="3"/>
                                <f:selectItem itemLabel="Charger N-1 + N-2 + N-3 + N-4" itemValue="4"/>
                            </h:selectOneMenu>
                        </h:panelGroup>
                        <h:outputText value="Inactif:"/>
                        <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisInactif}"  />
                    </h:panelGrid>
                </h:panelGrid>
                <br><br><br>
                <center>
                    <h:panelGroup>
                        <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.validerTableaux}"  image="/images/valider_big.png" style="text-decoration:none;"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </rich:panel>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="modalPanelDuppliquer" width="540" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.showmodalPanelDuppiquerTableaux}">
        <f:facet name="header"><h:outputText value="GESTION DUPPLICATION DES TABLEAUX"/></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.fermerDuppliquerTableaux}" image="/images/close.gif" styleClass="hidelink" reRender="modalPanelDuppliquer"/>
            </a4j:form>
        </f:facet>
        <rich:panel style="border:0px solid green;width:100%;height:340px;">
            <a4j:form  >
                <h:panelGrid style="width:100%">
                    <h:panelGrid columns="2" columnClasses="clos25,clos75">
                        <h:outputText value="Zone:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisZone}" style="width:300px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.mesSzonesItems}"/>
                        </h:selectOneMenu>
                        <h:outputText value="Code:"/><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisCode}"/>
                        <h:outputText value="Libelle FR:"/><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisLibFR}" style="width:340px;"/>
                        <h:outputText value="Libelle UK:"/><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisLibUK}" style="width:340px;" />
                        <h:outputText value="Libelle SP:"/><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisLibSP}" style="width:340px;"/>
                        <h:outputText value="N° page:"/><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisNum}"/>
                        <h:outputText value="Nb colonnes:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisNbCol}">
                            <f:selectItem itemLabel="1 colonne" itemValue="1"/>
                            <f:selectItem itemLabel="2 colonnes" itemValue="2"/>
                            <f:selectItem itemLabel="3 colonnes" itemValue="3"/>
                            <f:selectItem itemLabel="4 colonnes" itemValue="4"/>
                            <f:selectItem itemLabel="5 colonnes" itemValue="5"/>
                            <f:selectItem itemLabel="6 colonnes" itemValue="6"/>
                            <f:selectItem itemLabel="7 colonnes" itemValue="7"/>
                            <f:selectItem itemLabel="8 colonnes" itemValue="8"/>
                            <f:selectItem itemLabel="9 colonnes" itemValue="9"/>
                            <f:selectItem itemLabel="10 colonne" itemValue="10"/>
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
                        <h:outputText value="Modèle impression:"/><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisModele}" style="width:340px;"/>
                        <h:outputText value="Type:"/>
                        <h:panelGroup>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisType}" style="width:300px;"  >
                                <f:selectItem itemLabel="Etat Financier" itemValue="0"/>
                                <f:selectItem itemLabel="Rapport de Synthèse" itemValue="1"/>
                                <f:selectItem itemLabel="Identification société" itemValue="2"/>
                                <f:selectItem itemLabel="Activités société" itemValue="3"/>
                                <f:selectItem itemLabel="Dirigeants, Actionnaires, Filiales" itemValue="4"/>
                                <f:selectItem itemLabel="Couvertures" itemValue="5"/>
                                <f:selectItem itemLabel="Recapitulatif des annexes" itemValue="6"/>
                                <f:selectItem itemLabel="Tableaux complémentaires" itemValue="7"/>
                                <f:selectItem itemLabel="Etats Annexes" itemValue="8"/>
                                <f:selectItem itemLabel="DSF" itemValue="9"/>
                                <f:selectItem itemLabel="--------------------------------" itemValue="99"/>
                                <f:selectItem itemLabel="Bilan social" itemValue="10"/>
                                <f:selectItem itemLabel="Couvertures" itemValue="15"/>
                            </h:selectOneMenu>
                        </h:panelGroup>
                        <h:outputText value="Mode:" />
                        <h:panelGroup>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisModif}" style="width:300px;" >
                                <f:selectItem itemLabel="Modifiable par le client" itemValue="0"/>
                                <f:selectItem itemLabel="Non Modifiable par le client" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:panelGroup>
                         <h:outputText value="Exercice N-1:" />
                        <h:panelGroup>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisAnneeAnte}" style="width:300px;" >
                                <f:selectItem itemLabel="Ne pas charger N-1" itemValue="0"/>
                                <f:selectItem itemLabel="Charger N-1" itemValue="1"/>
                                <f:selectItem itemLabel="Charger N-1 + N-2" itemValue="2"/>
                                <f:selectItem itemLabel="Charger N-1 + N-2 + N-3" itemValue="3"/>
                                <f:selectItem itemLabel="Charger N-1 + N-2 + N-3 + N-4" itemValue="4"/>
                            </h:selectOneMenu>
                        </h:panelGroup>
                        <h:outputText value="Inactif:"/>
                        <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabNom.tablisInactif}"  />
                    </h:panelGrid>
                </h:panelGrid>
                <br><br><br>
                <center>
                    <h:panelGroup>
                        <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.validerDuppliquerTableaux}"  image="/images/valider_big.png" style="text-decoration:none;"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </rich:panel>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   id="modalPanelColonnes" width="540" headerClass="headerPanel" height="300" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.showmodalPanelColonne}">
        <f:facet name="header"><h:outputText value="MODIFICATION COLONNE N° "/><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.tabforcol}"/></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.annulerColonne}" image="/images/close.gif" styleClass="hidelink" reRender="modalPanelColonnes"/>
            </a4j:form>
        </f:facet>
        <rich:panel style="border:0px solid green;width:100%;height:230px;">
            <a4j:form >
                <h:panelGrid  style="width:100%" id="panelTabNbrCol">
                    <h:panelGrid columns="2" columnClasses="clos25,clos75">
                        <h:outputText value="N° col.:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.etatFinancier.numCol}"  style="width:340px;" readonly="true" />
                        <h:outputText value="Libellé:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.etatFinancier.nomCol}"  style="width:340px;" maxlength="30"/>
                        <h:outputText value="Période:"/>
                        <h:selectOneMenu id="annNomCol" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.etatFinancier.periodeCol}">
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
                            <f:selectItem itemLabel="N-3" itemValue="60"/>
                            <f:selectItem itemLabel="N-3 Janvier" itemValue="61"/>
                            <f:selectItem itemLabel="N-3 Février" itemValue="62"/>
                            <f:selectItem itemLabel="N-3 Mars" itemValue="63"/>
                            <f:selectItem itemLabel="N-3 Avril" itemValue="64"/>
                            <f:selectItem itemLabel="N-3 Mai" itemValue="65"/>
                            <f:selectItem itemLabel="N-3 Juin" itemValue="66"/>
                            <f:selectItem itemLabel="N-3 Juillet" itemValue="67"/>
                            <f:selectItem itemLabel="N-3 Aout" itemValue="68"/>
                            <f:selectItem itemLabel="N-3 Septembre" itemValue="69"/>
                            <f:selectItem itemLabel="N-3 Octobre" itemValue="70"/>
                            <f:selectItem itemLabel="N-3 Novembre" itemValue="71"/>
                            <f:selectItem itemLabel="N-3 Décembre" itemValue="72"/>
                            <f:selectItem itemLabel="N-3 1er trimestre" itemValue="73"/>
                            <f:selectItem itemLabel="N-3 2eme trimestre" itemValue="74"/>
                            <f:selectItem itemLabel="N-3 3eme trimestre" itemValue="75"/>
                            <f:selectItem itemLabel="N-3 4eme trimestre" itemValue="76"/>
                            <f:selectItem itemLabel="N-3 1er semestre" itemValue="77"/>
                            <f:selectItem itemLabel="N-3 2eme semestre" itemValue="78"/>
                            <f:selectItem itemLabel="N-4" itemValue="80"/>
                            <f:selectItem itemLabel="N-4 Janvier" itemValue="81"/>
                            <f:selectItem itemLabel="N-4 Février" itemValue="82"/>
                            <f:selectItem itemLabel="N-4 Mars" itemValue="83"/>
                            <f:selectItem itemLabel="N-4 Avril" itemValue="84"/>
                            <f:selectItem itemLabel="N-4 Mai" itemValue="85"/>
                            <f:selectItem itemLabel="N-4 Juin" itemValue="86"/>
                            <f:selectItem itemLabel="N-4 Juillet" itemValue="87"/>
                            <f:selectItem itemLabel="N-4 Aout" itemValue="88"/>
                            <f:selectItem itemLabel="N-4 Septembre" itemValue="89"/>
                            <f:selectItem itemLabel="N-4 Octobre" itemValue="90"/>
                            <f:selectItem itemLabel="N-4 Novembre" itemValue="91"/>
                            <f:selectItem itemLabel="N-4 Décembre" itemValue="92"/>
                            <f:selectItem itemLabel="N-4 1er trimestre" itemValue="93"/>
                            <f:selectItem itemLabel="N-4 2eme trimestre" itemValue="94"/>
                            <f:selectItem itemLabel="N-4 3eme trimestre" itemValue="95"/>
                            <f:selectItem itemLabel="N-4 4eme trimestre" itemValue="96"/>
                            <f:selectItem itemLabel="N-4 1er semestre" itemValue="97"/>
                            <f:selectItem itemLabel="N-4 2eme semestre" itemValue="98"/>
                        </h:selectOneMenu>
                        <h:outputText value="Largeur:"/>
                        <h:selectOneMenu id="TypeCol" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.etatFinancier.typeCol}">
                            <f:selectItem itemLabel="Petite largeur" itemValue="0"/>
                            <f:selectItem itemLabel="Largeur moyenne" itemValue="7"/>
                            <f:selectItem itemLabel="Grande largeur" itemValue="8"/>
                        </h:selectOneMenu>
                    </h:panelGrid>                
                </h:panelGrid>
                <br><br><br>
                <center>
                    <h:panelGroup>
                        <a4j:commandButton reRender="modalPanelColonnes,tableColonne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.validerColonne}" image="/images/valider_big.png"id="linkcom" style="text-decoration:none;"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </rich:panel>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="modalPanelElements" headerClass="headerPanel" width="650" height="400" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.showmodalPanelElement}">
        <f:facet name="header"><h:outputText value="GESTION DES ELEMENTS DU TABLEAU"/></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.annulerElement}" image="/images/close.gif" styleClass="hidelink" reRender="modalPanelElements"/>
            </a4j:form>
        </f:facet>
        <rich:panel style="border:0px solid green;width:100%;height:400px;">
            <a4j:form  >
                <h:panelGrid  style="width:100%">
                    <h:panelGrid columns="2" columnClasses="clos25,clos75">
                        <h:outputText value="Référence:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabElement.tabeleReference}" style="width:100px;"  maxlength="20"/>
                        <h:outputText value="Libelle FR:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabElement.tabeleLibFR}" style="width:340px;" maxlength="200"/>
                        <h:outputText value="Libelle UK:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabElement.tabeleLibUK}" style="width:340px;" maxlength="200"/>
                        <h:outputText value="Libelle SP:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabElement.tabeleLibSP}" style="width:340px;" maxlength="200"/>
                        <h:outputText value="Type:"/>
                        <h:panelGroup>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabElement.tabeleType}"  >
                                <f:selectItem itemLabel="Titre principal" itemValue="0"/>
                                <f:selectItem itemLabel="Titre secondaire" itemValue="1"/>
                                <f:selectItem itemLabel="Sous Titre" itemValue="2"/>
                                <f:selectItem itemLabel="Titre calculé" itemValue="7"/>
                                <f:selectItem itemLabel="Calcul/Saisie" itemValue="3"/>
                                <f:selectItem itemLabel="Total Sous Titre" itemValue="4"/>
                                <f:selectItem itemLabel="Total Titre secondaire" itemValue="5"/>
                                <f:selectItem itemLabel="Total Titre principal" itemValue="6"/>
                            </h:selectOneMenu>
                        </h:panelGroup>
                        <h:outputText value="Résultat intermédiaire:"/>
                        <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabElement.tabeleMode}">
                            <f:selectItem itemLabel="Non" itemValue="0"/>
                            <f:selectItem itemLabel="Oui" itemValue="1"/>
                        </h:selectOneRadio>
                    </h:panelGrid>
                </h:panelGrid>
                <br><br><br>
                <center>
                    <h:panelGroup>
                        <h:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.validerElement}"  image="/images/valider_big.png" id="linkElement" style="text-decoration:none;"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </rich:panel>

    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="modalPanelFormules" headerClass="headerPanel" width="800" height="475" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.showmodalPanelFormule}">
        <f:facet name="header"><h:outputText value="GESTION DES FORMULES (LIGNE/COLONNE)"/></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.annulerFormule}" image="/images/close.gif" styleClass="hidelink" reRender="modalPanelFormules"/>
            </a4j:form>
        </f:facet>
        <rich:panel style="border:0px solid green;width:100%;height:420px;">
            <a4j:form  >
                <h:panelGrid style="width:100%">
                    <h:panelGroup id="pngpFormule">
                        <h:outputText value="FORMULE " style="font-weight: bold;"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabFormule.tabforFormule}" style="width:600px;text-transform:uppercase"/>
                    </h:panelGroup>
                    <h:panelGrid columns="2"  width="100%" columnClasses="clos25,clos75">
                        <h:outputText value="Type:"/>
                        <h:panelGroup>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabFormule.tabforSolde}">
                                <f:selectItem itemLabel="Tout Solde (Débit-Crédit)" itemValue="0"/>
                                <f:selectItem itemLabel="Tout Solde (Crédit-Débit)" itemValue="1"/>
                                <f:selectItem itemLabel="Solde Débiteur" itemValue="2"/>
                                <f:selectItem itemLabel="Solde Créditeur" itemValue="3"/>
                                <f:selectItem itemLabel="Mouvements Débiteurs" itemValue="4"/>
                                <f:selectItem itemLabel="Mouvements Créditeurs" itemValue="5"/>
                                <f:selectItem itemLabel="Tout Solde AN (Débit-Crédit)" itemValue="10"/>
                                <f:selectItem itemLabel="Tout Solde AN (Crédit-Débit)" itemValue="11"/>
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
                                <f:selectItem itemLabel="Mouvements Débiteurs AB (balance)" itemValue="23"/>
                                <f:selectItem itemLabel="Mouvements Créditeurs AB (balance)" itemValue="24"/>
                                <f:selectItem itemLabel="Solde Débiteurs AB (balance)" itemValue="25"/>
                                <f:selectItem itemLabel="Solde Créditeurs AB (balance)" itemValue="26"/>
                                <f:selectItem itemLabel="Tout Solde AB (Débit-Crédit)" itemValue="27"/>
                                <f:selectItem itemLabel="Tout Solde AB (Crédit-Débit)" itemValue="28"/>
                                <f:selectItem itemLabel="Solde Débiteur sauf AN" itemValue="29"/>
                                <f:selectItem itemLabel="Solde Créditeur sauf AN" itemValue="30"/>
                                <f:selectItem itemLabel="Saisie numérique" itemValue="6"/>
                                <f:selectItem itemLabel="Saisie texte court" itemValue="7"/>
                                <f:selectItem itemLabel="Saisie texte long" itemValue="8"/>
                                <f:selectItem itemLabel="Saisie liste" itemValue="9" itemDisabled="true"/>
                            </h:selectOneMenu>
                        </h:panelGroup>
                        <h:outputText value="Période:"/>
                        <h:selectOneMenu id="forPerAdd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabFormule.tabforPeriode}">
                            <f:selectItem itemLabel="N" itemValue="0"/>                           
                            <f:selectItem itemLabel="N-1" itemValue="20"/>                          
                            <f:selectItem itemLabel="N-2" itemValue="40"/>
                            <f:selectItem itemLabel="N-3" itemValue="60"/>
                            <f:selectItem itemLabel="N-4" itemValue="80"/>
                        </h:selectOneMenu>
                        <h:outputText value="Formule Inactive:" />
                        <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.pegTabFormule.tabforInactif}" />
                        <h:outputText value="Opérateurs Arithmétiques:" />
                        <h:panelGroup>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterEq}" reRender="pngpFormule" value="=" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterPlus}" reRender="pngpFormule"  value="+" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterMoins}" reRender="pngpFormule"  value="-" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterMulti}" reRender="pngpFormule"  value="*" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterDiv}" reRender="pngpFormule"  value="/" size="3"/>
                        </h:panelGroup>
                        <h:outputText value="Opérateurs Tableaux:" />
                        <h:panelGroup>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterCel}" reRender="pngpFormule" value="CEL" size="3" title="CEL(TAB=REF:COL) ou CEL(REF:COL)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterSomv}" reRender="pngpFormule" value="SOMV" size="3" title="SOMV(Référence départ:Référence fin)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterSomh}" reRender="pngpFormule" value="SOMH" size="3" title="SOMH(Colonne départ:Colonne fin)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterDifh}" reRender="pngpFormule" value="DIFH" size="3" title="DIFH(Colonne départ:Colonne fin)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterVal}" reRender="pngpFormule" value="VAL" size="3" title="VAL(valeur numérique)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterColP}" reRender="pngpFormule" value="COL>0" size="3" title="Garde la valeur si > 0"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterColN}" reRender="pngpFormule" value="COL<0" size="3" title="Garde la valeur asolue si < 0"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterSTOT}" reRender="pngpFormule" value="S.TOT" size="3" title="Sous total"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterTTAB}" reRender="pngpFormule" value="T.TAB" size="3" title="Total du tableau"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterVAR}" reRender="pngpFormule" value="VAR" size="3" title="Variation COL 1 avec COL2 (VAR(1:2))"/>
                        </h:panelGroup>
                        <h:outputText value="Opérateurs Logiques:" />
                        <h:panelGroup>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterSupp}" reRender="pngpFormule" value=">" size="3" />
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterInf}" reRender="pngpFormule" value="<" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterSuppOrEq}" reRender="pngpFormule" value=">=" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterInfOrEq}" reRender="pngpFormule" value="<=" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterDiff}" reRender="pngpFormule" value="<>" size="3"/>
                        </h:panelGroup>                      
                        <h:outputText value="Opérateurs Conditionnels:" />
                        <h:panelGroup>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterSi}" reRender="pngpFormule"  value="SI" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterNon}" reRender="pngpFormule"  value="SINON" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterFin}" reRender="pngpFormule"  value="FIN" size="3"/>
                        </h:panelGroup>
                        <h:outputText value="Opérateurs Comptes:"/>
                        <h:panelGroup>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterCpt}" reRender="pngpFormule"  value="COMPTE" size="3" title="COMPTE(Compte 1;Compte 2;CompteX)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterAmach}" reRender="pngpFormule"  value="AMACH" size="3" title="Valeur achat"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterAmdot}" reRender="pngpFormule"  value="AMDOT" size="3" title="Valeur dotation"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterAmant}" reRender="pngpFormule"  value="AMANT" size="3" title="Valeur antérieur"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterAmres}" reRender="pngpFormule"  value="AMRES" size="3" title="Valeur résiduelle"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterAmces}" reRender="pngpFormule"  value="AMCES" size="3" title="Valeur cession"/>
                        </h:panelGroup>
                        <h:outputText value="Opérateurs Paye:"/>
                        <h:panelGroup>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterSalNb}" reRender="pngpFormule"  value="SAL_NBR" size="3" title="SAL_NBR(Nature;Sexe;Classement;Niveau)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterSalVl}" reRender="pngpFormule"  value="SAL_VAL" size="3" title="SAL_VAL(Nature;Sexe;Classement;Niveau)"/><br>
                            <h:outputText value="Nature: 0 = embauche, 1 = mot, 2 = extérieur OU le code nature du salarié"/><br>
                            <h:outputText value="Genre: 0 = femme, 1 = homme, 2 = tout"/><br>
                            <h:outputText value="Classement: 0 = nationnal, 1 = zone, 2 = hors zone OU code classement"/><br>
                            <h:outputText value="Niveau: 0 = cadre, 1 = technicien supérieur, 2 = technicien, 3 = main d'oeuvre"/><br>
                        </h:panelGroup>
                        <h:outputText value="Opérateurs Divers:" />
                        <h:panelGroup>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterAr}" reRender="pngpFormule"  value="ARR" size="3" title="ARR() ou ARR(1) ou ARR(2)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterAb}" reRender="pngpFormule" value="ABS" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterInv}" reRender="pngpFormule" value="INV" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterMod}" reRender="pngpFormule" value="MOD" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterInt}" reRender="pngpFormule" value="INT" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterEcom}" reRender="pngpFormule" value="&&" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.AffecterBo}" reRender="pngpFormule" value="||" size="3"/>
                        </h:panelGroup>
                    </h:panelGrid>
                </h:panelGrid>
                <br><br><br>
                <center>
                    <h:panelGroup>
                        <a4j:commandButton reRender="modalPanelFormules,tableFormules" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.validerFormule}"  image="/images/valider_big.png" id="linkElement" style="text-decoration:none;"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </rich:panel>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="300" height="200">
        <f:facet name="header"><h:outputText value="Impression"/></f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelink1ImpimEFs"/>
                <rich:componentControl for="panelImp" attachTo="hidelink1ImpimEFs" operation="hide" event="onclick"/>
            </h:panelGroup>
        </f:facet>
        <a4j:form id="formModalImprimEFS" target="_blank">
            <center>
                <h:outputText value="Choisissez un  format"/>
            </center>
            <h:panelGrid  >
                <h:selectOneListbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.formatImpression}" id="format">
                    <f:selectItem itemLabel="PDF" itemValue="PDF"/>
                </h:selectOneListbox>
            </h:panelGrid>
            <center>
                <h:commandButton image="/images/valider_big.png"title="Imprimer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formEtatFinancier.imprimer}" id="EFprints">
                    <rich:componentControl for="panelImprEFS" attachTo="EFprints" operation="hide" event="onclick"/>
                </h:commandButton>
            </center>
        </a4j:form>
    </rich:modalPanel>

</f:subview>
