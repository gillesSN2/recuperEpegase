<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="listegroupes">

    <a4j:form id="impgen">

        <center> <h2><h:outputText value="LISTE DES CABINETS/GROUPES/FRANCHISES/FORMATION/DISTRIBUTEURS (SYSTEME)" style="color:green;font-size:16px;"/></h2></center>

        <h:panelGrid id="impgenPG" border="0" width="100%" style="border:0px solid green;"  columns="2">

            <rich:column id="cab" width="50%" style="border:1px solid green;">

                <h:panelGrid id="pancab" columns="6" width="100%">
                    <h:commandButton image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.ajouterCabinet}"/>
                    <h:commandButton image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.modifierCabinet}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.cabinetPeg.cabId!=0}"/>
                    <h:commandButton image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.cabinetPeg.cabId!=0}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.supprimerCabinet}"/>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.etat}" style="width:130px;" >
                        <f:selectItem itemLabel="Tous Etats" itemValue="9"/>
                        <f:selectItem itemLabel="En cours" itemValue="0"/>
                        <f:selectItem itemLabel="Terminé" itemValue="1" />
                        <f:selectItem itemLabel="Litige" itemValue="2" />
                        <f:selectItem itemLabel="Abandonné" itemValue="3" />
                    </h:selectOneMenu>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.mode}" style="width:130px;" >
                        <f:selectItem itemLabel="Tous Modes" itemValue="9"/>
                        <f:selectItem itemLabel="Cabinets" itemValue="1"/>
                        <f:selectItem itemLabel="Groupes" itemValue="2"/>
                        <f:selectItem itemLabel="Franchises" itemValue="3"/>
                        <f:selectItem itemLabel="Centre de formation" itemValue="4"/>
                        <f:selectItem itemLabel="Distributeurs" itemValue="5"/>
                    </h:selectOneMenu>
                    <a4j:commandButton value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.chargerLesCabinets}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tablesoc"/>
                </h:panelGrid>

                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tablesoc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.dataModelLesCabinetsPeg}" headerClass="headerTab" activeClass="active-row" noDataLabel=" " width="100%" styleClass="bg" style="max-height:100%" border="0" rowClasses="rows1,rows2,rowsd" var="cab">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.selectionCabinet}" reRender="pancab,societe,tablesociete,pansoc"/>
                        <rich:column width="10%" sortable="true" sortBy="#{cab.cabId}">
                            <f:facet name="header" ><h:outputText value="ID"/></f:facet>
                            <h:outputText value="#{cab.cabId}"  />
                        </rich:column >
                        <rich:column width="10%" sortable="true" sortBy="#{cab.cabDteCreat}">
                            <f:facet name="header" ><h:outputText value="Création"/></f:facet>
                            <h:outputText value="#{cab.cabDteCreat}" >
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column width="10%" sortable="true" sortBy="#{cab.libetat}">
                            <f:facet name="header" ><h:outputText value="Etat"/></f:facet>
                            <h:outputText value="#{cab.libetat}" />
                        </rich:column>
                        <rich:column width="20%" sortable="true" sortBy="#{cab.libmode}">
                            <f:facet name="header" ><h:outputText value="Mode"/></f:facet>
                            <h:outputText value="#{cab.libmode}"  />
                        </rich:column>
                        <rich:column width="50%" sortable="true" sortBy="#{cab.cabEntite}">
                            <f:facet name="header" ><h:outputText value="Nom Entité"/></f:facet>
                            <h:outputText value="#{cab.cabEntite}" />
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:column>

            <rich:column id="societe" width="50%" style="border:1px solid green;">
                <h:panelGrid id="pansoc" columns="3" width="150px" style="height:34px">
                    <h:commandButton image="/images/ajouter.png" title="Ajouter" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.cabinetPeg.cabId!=0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.chargerSociete}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    <h:commandButton image="/images/modifier.png" title="Modifier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.structurePeg.strmaitrecabinet==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.structurePeg.strId!=0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.modifierMandat}"/>
                    <a4j:commandButton image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.structurePeg.strId!=0}" reRender="pansoc,tablesociete" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.supprimerAffectation}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"/>
                </h:panelGrid>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable enableContextMenu="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.dataModelLesSocites}"  id="tablesociete" headerClass="headerTab" activeClass="active-row" noDataLabel=" " width="100%" border="0" styleClass="bg" style="max-height:100%" rowClasses="rows1,rows2,rowsd" var="soc">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.selectionSociete}" reRender="pansoc" />
                        <rich:column width="10%" sortable="true" sortBy="#{soc.strmaitrecabinet} #{soc.strraisonsociale}">
                            <f:facet name="header" ><h:outputText value="Maître"/></f:facet>
                            <h:outputText  value="#{soc.libmaitre}"/>
                        </rich:column>
                        <rich:column width="70%" >
                            <f:facet name="header" ><h:outputText value="Structure de l'entité"/></f:facet>
                            <h:outputText  value="#{soc.strraisonsociale}"/>
                        </rich:column>
                        <rich:column width="10%" >
                            <f:facet name="header" ><h:outputText value="Début"/></f:facet>
                            <h:outputText value="#{soc.strdtedebmandat}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column width="10%" >
                            <f:facet name="header" ><h:outputText value="Fin"/></f:facet>
                            <h:outputText value="#{soc.strdtefinmandat}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:column>

        </h:panelGrid>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelCabinet" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="600" height="200" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.showModalPanelCabinet}">
        <center>
            <f:facet name="header"><h:outputText value="GESTION DES ENTITES" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.fermerCabinet}" image="/images/close.gif" styleClass="hidelink"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalCabinet" >
                <h:panelGrid  width="100%">
                    <h:panelGrid  columns="2" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText style="text-decoration:underline;color:red;" value="Type entité:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:210px;color:red;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.cabinetPeg.cabNature}">
                                <f:selectItem itemLabel="Cabinet" itemValue="1"/>
                                <f:selectItem itemLabel="Groupe" itemValue="2" />
                                <f:selectItem itemLabel="Franchise" itemValue="3" />
                                <f:selectItem itemLabel="Formation" itemValue="4" />
                                <f:selectItem itemLabel="Distributeur" itemValue="5" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Entité:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.cabinetPeg.cabEntite}"/></h:column>
                        <h:column><h:outputText style="text-decoration:underline;color:red;" value="Etat entité:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:210px;color:red;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.cabinetPeg.cabEtat}">
                                <f:selectItem itemLabel="En cours" itemValue="0"/>
                                <f:selectItem itemLabel="Terminé" itemValue="1"/>
                                <f:selectItem itemLabel="Litige" itemValue="2"/>
                                <f:selectItem itemLabel="Abandonné" itemValue="3"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGrid  width="100%" style="text-align:center;">
                    <h:commandButton image="/images/valider_big.png" title="Valider" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.saveCabinet}" id="val"/>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelSociete" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="800" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.showModalPanelSociete}">
        <center>
            <f:facet name="header"><h:outputText value="SELECTION SOCIETES" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.fermerSociete}" image="/images/close.gif" styleClass="hidelink"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalSociete" >
                <h:panelGrid  width="100%">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tablesocRec" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.dataModelLesRecherches}" headerClass="headerTab" activeClass="active-row" noDataLabel=" " width="100%" styleClass="bg" height="400px" border="0" rowClasses="rows1,rows2,rowsd" var="societe">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.selectionRecherche}"/>
                            <rich:column width="10%" sortable="true" sortBy="#{societe.strId}">
                                <f:facet name="header" ><h:outputText value="ID"/></f:facet>
                                <h:outputText  value="#{societe.strId}"  />
                            </rich:column >
                            <rich:column width="5%" sortable="true" sortBy="#{societe.libetat}">
                                <f:facet name="header" ><h:outputText value="Etat"/></f:facet>
                                <h:outputText  value="#{societe.libetat}" />
                            </rich:column >
                            <rich:column width="10%" sortable="true" sortBy="#{societe.libmode}">
                                <f:facet name="header" ><h:outputText value="Mode"/></f:facet>
                                <h:outputText  value="#{societe.libmode}"  />
                            </rich:column >
                            <rich:column width="40%" sortable="true" sortBy="#{societe.strraisonsociale}">
                                <f:facet name="header" ><h:outputText value="Raison sociale"/></f:facet>
                                <h:outputText  value="#{societe.strraisonsociale}" />
                            </rich:column >
                            <rich:column width="15%" sortable="true" sortBy="#{societe.strtel1}" >
                                <f:facet name="header" ><h:outputText value="Téléphone"/></f:facet>
                                <h:outputText  value="#{societe.strtel1}"  />
                            </rich:column >
                            <rich:column width="10%" sortable="true" sortBy="#{societe.strnompays}" >
                                <f:facet name="header" ><h:outputText value="Pays"/></f:facet>
                                <h:outputText  value="#{societe.strnompays}"  />
                            </rich:column >
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
                <br>
                <h:panelGrid  width="100%" style="text-align:center;">
                    <h:commandButton image="/images/valider_big.png" title="Valider" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.valideSociete}" id="valsoc"/>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelMandat" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="400" height="300" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.showModalPanelMandat}">
        <center>
            <f:facet name="header"><h:outputText value="GESTION DES MANDATS" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.fermerMandat}" image="/images/close.gif" styleClass="hidelink"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalMandat" >
                <h:panelGrid  width="100%">
                    <h:panelGrid  columns="2" columnClasses="clos30,clos70d" width="100%">
                        <h:column><h:outputText value="Date début mandat:"/></h:column>
                        <h:column>
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.structurePeg.strdtedebmandat}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/>
                        </h:column>
                        <h:column><h:outputText value="Date fin mandat:"/></h:column>
                        <h:column>
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.structurePeg.strdtefinmandat}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/>
                        </h:column>
                        <h:column><h:outputText value="Etat mandat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:210px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.structurePeg.stretatmandat}">
                                <f:selectItem itemLabel="En cours" itemValue="0"/>
                                <f:selectItem itemLabel="Terminé" itemValue="1" />
                                <f:selectItem itemLabel="Litige" itemValue="2" />
                                <f:selectItem itemLabel="Abandonné" itemValue="3" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGrid  width="100%" style="text-align:center;">
                    <h:commandButton image="/images/valider_big.png" title="Valider" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemCabinet.validerMandat}" id="valman"/>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>

</f:subview>
