<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="decoupageGeograpique">

    <a4j:form id="orgcomm">

        <center> <h2><h:outputText value="ORGANISATION DU POLIT BUREAU" style="color:green;"/></h2></center>

        <h:panelGrid width="100%" columnClasses="clos30g,clos30g,clos30g" columns="3">

            <h:panelGrid id="idPanRegion" width="100%">
                <h:panelGrid id="boutonRegion" width="200px" columnClasses="top" columns="4" style="height:34px">
                    <a4j:commandButton image="/images/ajouter.png" title="Ajout Pays" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.ajouterRegion}" reRender="modalPanelRegion"/>
                    <a4j:commandButton image="/images/modifier.png" title="Modification Pays" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.modifierRegion}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.region.regId!=0}" reRender="modalPanelRegion"/>
                    <a4j:commandButton image="/images/supprimer.png" title="Modification Pays" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.supprimerRegion}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.region.regId!=0 && bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.dataModelSecteur.rowCount==0}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="boutonRegion,tableRegion"/>
                    <a4j:commandButton image="/images/print.png" title="Imprimer le découpage géographique" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
                </h:panelGrid>
                <h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable  id="tableRegion" enableContextMenu="false" activeClass="active-row" noDataLabel=" " headerClass="headerTab" height="200px" width="400px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.dataModelRegion}" var="reg">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonRegion,idPanSecteur,idPanPdv,idPanVille,idPanQuartier,idPanCellule" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.selectionRegion}"/>
                            <rich:column sortable="true" sortBy="#{reg.regCode}" width="20%" sortOrder="ASCENDING">
                                <f:facet name="header"><h:outputText value="Code"/></f:facet>
                                <h:outputText value="#{reg.regCode}"/>
                            </rich:column >
                            <rich:column sortable="true" sortBy="#{reg.regNomFr}" width="40%">
                                <f:facet name="header"><h:outputText value="Nom Pays"/></f:facet>
                                <h:outputText value="#{reg.regNomFr}"/>
                            </rich:column >
                            <rich:column sortable="true" sortBy="#{reg.regNomResponsable}" width="40%">
                                <f:facet name="header"><h:outputText value="Responsable"/></f:facet>
                                <h:outputText value="#{reg.regNomResponsable}"/>
                            </rich:column >
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </h:panelGrid>

            <h:panelGrid id="idPanSecteur" width="100%">
                <h:panelGrid  id="boutonSecteur" width="150px" columnClasses="top" columns="3" style="height:34px">
                    <a4j:commandButton image="/images/ajouter.png" title="Ajout Région" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.ajouterSecteur}" reRender="modalPanelSecteur"/>
                    <a4j:commandButton image="/images/modifier.png" title="Modification Région" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.modifierSecteur}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.secteur.secId!=0}" reRender="modalPanelSecteur"/>
                    <a4j:commandButton image="/images/supprimer.png" title="Suppression Région" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.supprimerSecteur}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.secteur.secId!=0&& bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.dataModelPdv.rowCount==0}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="boutonRegion,boutonSecteur,tableSecteur"/>
                </h:panelGrid>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableSecteur" enableContextMenu="false" activeClass="active-row" noDataLabel=" " headerClass="headerTab" height="200px" width="400px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.dataModelSecteur}" var="sec"  >
                        <a4j:support eventsQueue="maQueue"  event="onRowClick"  immediate="true"  onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSecteur,idPanPdv,idPanVille,idPanQuartier,idPanCellule" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.selectionSecteur}"/>
                        <rich:column sortable="true" sortBy="#{sec.secCode}" width="20%" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText value="Code"/></f:facet>
                            <h:outputText  value="#{sec.secCode}"/>
                        </rich:column >
                        <rich:column sortable="true" sortBy="#{sec.secNomFr}" width="40%">
                            <f:facet name="header"><h:outputText value="Nom Région"/></f:facet>
                            <h:outputText  value="#{sec.secNomFr}"/>
                        </rich:column >
                        <rich:column sortable="true" sortBy="#{sec.secNomResponsable}" width="40%">
                            <f:facet name="header"><h:outputText value="Responsable"/></f:facet>
                            <h:outputText value="#{sec.secNomResponsable}"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>

            <h:panelGrid id="idPanPdv" width="100%">
                <h:panelGrid id="boutonPdv" width="150px" columnClasses="top" columns="3" style="height:34px">
                    <a4j:commandButton image="/images/ajouter.png" title="Ajout Département"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.ajouterPdv}" reRender="modalPanelPdv"/>
                    <a4j:commandButton image="/images/modifier.png" title="Modification Département" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.modifierPdv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.pdv.pdvId!=0}" reRender="modalPanelPdv"/>
                    <a4j:commandButton image="/images/supprimer.png" title="Suppression Département" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.supprimerPdv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.pdv.pdvId!=0  && bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.dataModelVille.rowCount==0}"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="boutonSecteur,boutonPdv,tablePdv"/>
                </h:panelGrid>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tablePdv" enableContextMenu="false" activeClass="active-row" noDataLabel=" " headerClass="headerTab" height="200px" width="400px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.dataModelPdv}" var="pdv"   >
                        <a4j:support eventsQueue="maQueue"  event="onRowClick"  onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonPdv,idPanVille,idPanQuartier,idPanCellule" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.selectionPdv}"/>
                        <rich:column sortable="true" sortBy="#{pdv.pdvCode}" width="20%" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText value="Code"/></f:facet>
                            <h:outputText value="#{pdv.pdvCode}"/>
                        </rich:column >
                        <rich:column sortable="true" sortBy="#{pdv.pdvNomFr}" width="40%">
                            <f:facet name="header"><h:outputText value="Nom Département"/></f:facet>
                            <h:outputText value="#{pdv.pdvNomFr}"/>
                        </rich:column >
                        <rich:column sortable="true" sortBy="#{pdv.pdvNomResponsable}" width="40%">
                            <f:facet name="header"><h:outputText value="Responsable"/></f:facet>
                            <h:outputText value="#{pdv.pdvNomResponsable}"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>

            <h:panelGrid id="idPanVille" width="100%">
                <h:panelGrid id="boutonVille" width="150px" columnClasses="top" columns="3" style="height:34px">
                    <a4j:commandButton image="/images/ajouter.png" title="Ajout Ville" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.ajouterVille}" reRender="modalPanelVille"/>
                    <a4j:commandButton image="/images/modifier.png" title="Modification Ville" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.modifierVille}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.pdv.pdvId!=0}" reRender="modalPanelVille"/>
                    <a4j:commandButton image="/images/supprimer.png" title="Modification Ville" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.supprimerVille}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.pdv.pdvId!=0 && bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.dataModelQuartier.rowCount==0}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="boutonVille,tableVille"/>
                </h:panelGrid>
                <h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable  id="tableVille" enableContextMenu="false" activeClass="active-row" noDataLabel=" " headerClass="headerTab" height="200px" width="400px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.dataModelVille}" var="vil">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonVille,idPanQuartier,idPanCellule" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.selectionVille}"/>
                            <rich:column sortable="true" sortBy="#{vil.vilCode}" width="20%" sortOrder="ASCENDING">
                                <f:facet name="header"><h:outputText value="Code"/></f:facet>
                                <h:outputText value="#{vil.vilCode}"/>
                            </rich:column >
                            <rich:column sortable="true" sortBy="#{vil.vilNomFr}" width="40%">
                                <f:facet name="header"><h:outputText value="Nom Ville"/></f:facet>
                                <h:outputText value="#{vil.vilNomFr}"/>
                            </rich:column >
                            <rich:column sortable="true" sortBy="#{vil.vilNomResponsable}" width="40%">
                                <f:facet name="header"><h:outputText value="Responsable"/></f:facet>
                                <h:outputText value="#{vil.vilNomResponsable}"/>
                            </rich:column >
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </h:panelGrid>

            <h:panelGrid id="idPanQuartier" width="100%">
                <h:panelGrid  id="boutonQuartier" width="150px" columnClasses="top" columns="3" style="height:34px">
                    <a4j:commandButton image="/images/ajouter.png" title="Ajout Quartier" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.ajouterQuartier}" reRender="modalPanelQuartier"/>
                    <a4j:commandButton image="/images/modifier.png" title="Modification Quartier" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.modifierQuartier}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.ville.vilId!=0}" reRender="modalPanelQuatier"/>
                    <a4j:commandButton image="/images/supprimer.png" title="Suppression Quartier" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.supprimerQuartier}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.ville.vilId!=0&& bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.dataModelCellule.rowCount==0}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="boutonVille,boutonQuartier,tableQuartier"/>
                </h:panelGrid>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableQuartier" enableContextMenu="false" activeClass="active-row" noDataLabel=" " headerClass="headerTab" height="200px" width="400px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.dataModelQuartier}" var="qua"  >
                        <a4j:support eventsQueue="maQueue"  event="onRowClick"  immediate="true"  onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonQuartier,idPanCellule" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.selectionQuartier}"/>
                        <rich:column sortable="true" sortBy="#{qua.quaCode}" width="20%" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText value="Code"/></f:facet>
                            <h:outputText  value="#{qua.quaCode}"/>
                        </rich:column >
                        <rich:column sortable="true" sortBy="#{qua.quaNomFr}" width="40%">
                            <f:facet name="header"><h:outputText value="Nom Quartier"/></f:facet>
                            <h:outputText  value="#{qua.quaNomFr}"/>
                        </rich:column >
                        <rich:column sortable="true" sortBy="#{qua.quaNomResponsable}" width="40%">
                            <f:facet name="header"><h:outputText value="Responsable"/></f:facet>
                            <h:outputText value="#{qua.quaNomResponsable}"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>

            <h:panelGrid id="idPanCellule" width="100%">
                <h:panelGrid id="boutonCellule" width="150px" columnClasses="top" columns="3" style="height:34px">
                    <a4j:commandButton image="/images/ajouter.png" title="Ajout Cellule"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.ajouterCellule}" reRender="modalPanelCellule"/>
                    <a4j:commandButton image="/images/modifier.png" title="Modification Cellule" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.modifierCellule}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.cellule.celId!=0}" reRender="modalPanelCellule"/>
                    <a4j:commandButton image="/images/supprimer.png" title="Suppression Cellule" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.supprimerCellule}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.cellule.celId!=0}"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="boutonQuartier,boutonCellule,tableCellule"/>
                </h:panelGrid>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableCellule" enableContextMenu="false" activeClass="active-row" noDataLabel=" " headerClass="headerTab" height="200px" width="400px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.dataModelCellule}" var="cel"   >
                        <a4j:support eventsQueue="maQueue"  event="onRowClick"  onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonCellule" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.selectionPdv}"/>
                        <rich:column sortable="true" sortBy="#{cel.celCode}" width="20%" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText value="Code"/></f:facet>
                            <h:outputText value="#{cel.celCode}"/>
                        </rich:column >
                        <rich:column sortable="true" sortBy="#{cel.celNomFr}" width="40%">
                            <f:facet name="header"><h:outputText value="Nom Cellule"/></f:facet>
                            <h:outputText value="#{cel.celNomFr}"/>
                        </rich:column >
                        <rich:column sortable="true" sortBy="#{cel.celNomResponsable}" width="40%">
                            <f:facet name="header"><h:outputText value="Responsable"/></f:facet>
                            <h:outputText value="#{cel.celNomResponsable}"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>

        </h:panelGrid>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="modalPanelRegion" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.showmodelPanelRegion}" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="400" height="200">
        <center>
            <f:facet name="header"><h:outputText value="Gestion des Pays"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.annulerRegion}" image="/images/close.gif" styleClass="hidelink" reRender="modalPanelRegion"/>
                </a4j:form >
            </f:facet>
            <a4j:form>
                <h:panelGrid columns="2" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Code:" /></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.region.regCode}" size="7"  maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.region.regId!=0}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="modalPanelRegion,idRegionExiste,valideRegion" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.verifierCodeRegion}"/>
                        </h:inputText>
                        <h:outputText id="idRegionExiste" style="color:red;" value="Le code est vide ou existe déjà!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.existeCode}"/>
                    </h:column>
                    <h:column><h:outputText value="Nom:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.region.regNomFr}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                    <h:column><h:outputText value="Responsable:" /></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.region.regIdResponsable}" style="width:100%;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.mesResponsable}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Inactif:" /></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.var_region_inactif}" /></h:column>
                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <h:commandButton id="valideRegion" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.validerRegion}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.existeCode}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </center>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="modalPanelSecteur" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.showmodelPanelSecteur}" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="400" height="200">
        <center>
            <f:facet name="header"><h:outputText value="Gestion des Régions"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.annulerSecteur}" image="/images/close.gif" styleClass="hidelink" reRender="modalPanelSecteur"/>
                </a4j:form >
            </f:facet>
            <a4j:form>
                <h:panelGrid columns="2" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Code:" /></h:column>
                    <h:column >
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.secteur.secCode}" size="7"  maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.secteur.secId!=0}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="modalPanelSecteur,idSecteurExiste,valideSecteur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.verifierCodeSecteur}"/>
                        </h:inputText>
                        <h:outputText id="idSecteurExiste" style="color:red;" value="Le code est vide ou existe déjà!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.existeCode}"/>
                    </h:column>
                    <h:column><h:outputText value="Nom:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.secteur.secNomFr}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                    <h:column><h:outputText value="Responsable:" /></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.secteur.secIdResponsable}" style="width:100%;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.mesResponsable}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Inactif:" /></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.var_secteur_inactif}" /></h:column>
                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <h:commandButton id="valideSecteur" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.validerSecteur}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.existeCode}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </center>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="modalPanelPdv" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.showmodelPanelPdv}" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="400" height="200">
        <center>
            <f:facet name="header"><h:outputText value="Gestion des Départements"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.annulerPdv}" image="/images/close.gif" styleClass="hidelink" reRender="modalPanelPdv"/>
                </a4j:form >
            </f:facet>
            <a4j:form>
                <h:panelGrid columns="2" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Code:" /></h:column>
                    <h:column >
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.pdv.pdvCode}" size="7"  maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.pdv.pdvId!=0}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="modalPanelPdv,idPdvExiste,validePdv" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.verifierCodePdv}"/>
                        </h:inputText>
                        <h:outputText id="idPdvExiste" style="color:red;" value="Le code est vide ou existe déjà!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.existeCode}"/>
                    </h:column>
                    <h:column><h:outputText value="Nom:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.pdv.pdvNomFr}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                    <h:column><h:outputText value="Responsable:" /></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.pdv.pdvIdResponsable}" style="width:100%;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.mesResponsable}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Inactif:" /></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.var_pdv_inactif}" /></h:column>
                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <h:commandButton id="validePdv" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.validerPdv}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.existeCode}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </center>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="modalPanelVille" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.showmodelPanelVille}" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="400" height="200">
        <center>
            <f:facet name="header"><h:outputText value="Gestion des Villes"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.annulerVille}" image="/images/close.gif" styleClass="hidelink" reRender="modalPanelVille"/>
                </a4j:form >
            </f:facet>
            <a4j:form>
                <h:panelGrid columns="2" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Code:" /></h:column>
                    <h:column >
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.ville.vilCode}" size="7"  maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.ville.vilId!=0}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="modalPanelVille,idVilleExiste,valideVille" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.verifierCodeVille}"/>
                        </h:inputText>
                        <h:outputText id="idVilleExiste" style="color:red;" value="Le code est vide ou existe déjà!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.existeCode}"/>
                    </h:column>
                    <h:column><h:outputText value="Nom:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.ville.vilNomFr}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                    <h:column><h:outputText value="Responsable:" /></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.ville.vilIdResponsable}" style="width:100%;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.mesResponsable}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Inactif:" /></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.var_ville_inactif}" /></h:column>
                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <h:commandButton id="valideVille" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.validerVille}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.existeCode}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </center>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="modalPanelQuartier" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.showmodelPanelQuartier}" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="400" height="200">
        <center>
            <f:facet name="header"><h:outputText value="Gestion des Quartiers"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.annulerQuartier}" image="/images/close.gif" styleClass="hidelink" reRender="modalPanelQuartier"/>
                </a4j:form >
            </f:facet>
            <a4j:form>
                <h:panelGrid columns="2" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Code:" /></h:column>
                    <h:column >
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.quartier.quaCode}" size="7"  maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.quartier.quaId!=0}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="modalPanelQuartier,idQuartierExiste,quartierVille" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.verifierCodeQuartier}"/>
                        </h:inputText>
                        <h:outputText id="idQuartierExiste" style="color:red;" value="Le code est vide ou existe déjà!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.existeCode}"/>
                    </h:column>
                    <h:column><h:outputText value="Nom:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.quartier.quaNomFr}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                    <h:column><h:outputText value="Responsable:" /></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.quartier.quaIdResponsable}" style="width:100%;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.mesResponsable}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Inactif:" /></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.var_quartier_inactif}" /></h:column>
                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <h:commandButton id="valideVille" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.validerQuartier}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.existeCode}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </center>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="modalPanelCellule" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.showmodelPanelCellule}" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="400" height="200">
        <center>
            <f:facet name="header"><h:outputText value="Gestion des Cellules"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.annulerCellule}" image="/images/close.gif" styleClass="hidelink" reRender="modalPanelCellule"/>
                </a4j:form >
            </f:facet>
            <a4j:form>
                <h:panelGrid columns="2" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Code:" /></h:column>
                    <h:column >
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.cellule.celCode}" size="7"  maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.cellule.celId!=0}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="modalPanelCellule,idCelluleExiste,valideCellule" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.verifierCodeCellule}"/>
                        </h:inputText>
                        <h:outputText id="idCelluleExiste" style="color:red;" value="Le code est vide ou existe déjà!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.existeCode}"/>
                    </h:column>
                    <h:column><h:outputText value="Nom:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.cellule.celNomFr}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                    <h:column><h:outputText value="Responsable:" /></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.cellule.celIdResponsable}" style="width:100%;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.mesResponsable}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Inactif:" /></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.var_cellule_inactif}" /></h:column>
                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <h:commandButton id="valideCellule" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.validerCellule}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOrganisationCommerciale.existeCode}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </center>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>

</f:subview>
