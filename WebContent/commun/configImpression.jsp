<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="impressionconfig">

    <a4j:form id="impression" enctype="multipart/form-data">

        <center> <h2><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.var_nom_ecran}" style="color:green;"/></h2></center>

        <h:panelGrid id="idPanGlobal" width="100%"  border="0" columns="4">

            <rich:extendedDataTable id="tableRepertoire" headerClass="headerTab" activeClass="active-row"  width="300px" height="515px" border="0" noDataLabel=" " rowClasses="rows1,rows2,rowsd" styleClass="bg" style="border:solid 1px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.dataModelRepertoire}" var="repert">
                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.selectionRepertoire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idPanRapport,idPanAction,idPanRapportHORUS,tableRapportHORUS,tableSousRapportHORUS,"/>
                <rich:column width="100%">
                    <f:facet name="header" ><h:outputText value="SELECTION ETAT"/></f:facet>
                    <h:outputText  value="#{repert}" style="width:100%" />
                </rich:column>
            </rich:extendedDataTable>

            <h:panelGrid id="idPanModele">
                <h:panelGrid style="border:0px" id="idPanRapport">
                    <rich:extendedDataTable id="tableRapport" headerClass="headerTab" activeClass="active-row"  height="250px" width="300px" border="0" noDataLabel=" " rowClasses="rows1,rows2,rowsd" styleClass="bg" style="border:solid 1px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.dataModelRapport}"  var="rapport">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.selectionRapport}" reRender="idPanAction"/>
                        <rich:column width="100%" >
                            <f:facet name="header" ><h:outputText value="SELECTION RAPPORT"/></f:facet>
                            <h:outputText value="#{rapport}" />
                        </rich:column >
                    </rich:extendedDataTable>
                </h:panelGrid>

                <h:panelGrid style="border:0px">
                    <rich:extendedDataTable id="tableSousRapport" height="200px" headerClass="headerTab" activeClass="active-row" width="300px" border="0" noDataLabel=" " rowClasses="rows1,rows2,rowsd" styleClass="bg" style="border:solid 1px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.dataModelSousRapport}" var="sousRapport">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.selectionSousRapport}" reRender="idPanAction"/>
                        <rich:column width="100%" >
                            <f:facet name="header" ><h:outputText value="SEELCTION SOUS RAPPORT"/></f:facet>
                            <h:outputText  value="#{sousRapport}" style="width:100%" />
                        </rich:column >
                    </rich:extendedDataTable>
                    <h:panelGrid  id="idMessage" style="border:1px solid green;width:100%;height:50px">
                        <h:messages  infoStyle="color: red;" errorStyle="color: red;"  />
                    </h:panelGrid>
                </h:panelGrid>
            </h:panelGrid>

            <h:panelGrid id="idPanAction">

                <rich:panel headerClass="headerTab" id="idAction1" style="border:1px solid green;width:100%;height:250px"  >
                    <f:facet name="header" ><h:outputText value="ACTION SUR LES RAPPORTS"/></f:facet>
                    <h:panelGrid columns="2" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.var_repertoire_selectionne&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.var_rapportModele_visible}">
                        <h:outputLabel for="file" value="Importer votre rapport:"/>
                        <t:inputFileUpload id="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.uploadedFileRapport}"/>
                    </h:panelGrid>
                    <center>
                        <br>
                        <h:commandButton value="Envoyer le rapport vers le serveur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.envoyerRapport}" style="color:green;font-family:Arial;width:300px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.var_repertoire_selectionne&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.var_rapportModele_visible}"/>
                        <br>
                        <h:commandButton value="Copier le rapport du serveur vers le local" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.copierRapport}" style="color:green;font-family:Arial;width:300px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.var_rapport_visible}"/>
                        <br><br>
                        <h:commandButton value="Renommer le rapport du serveur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.renommerRapport}" style="color:green;font-family:Arial;width:300px;" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.var_rapport_visible}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"/>
                        <br>
                        <h:commandButton value="Supprimer le rapport du serveur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.supprimerRapport}" style="color:green;font-family:Arial;width:300px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.var_rapport_visible}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"/>
                        <br><br>
                        <h:commandButton value="Envoyer le modèle vers HORUS =>" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.envoyerRapportversHorus}" style="color:red;font-family:Arial;width:300px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.var_rapport_visible}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        <br>
                        <h:commandButton value="<= Copier le modéle HORUS dans serveur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.copierRapportdepuisHorus}" style="color:red;font-family:Arial;width:300px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.var_rapportModele_visible}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        <br><br>
                        <a4j:commandButton value="Visualiser le modéle HORUS" style="color:red;font-family:Arial;width:300px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.var_rapportModele_visible}" onclick="javascript:Richfaces.showModalPanel('panelImp');"/>
                    </center>
                </rich:panel>

                <rich:panel  headerClass="headerTab"  id="idAction2" style="border:1px solid green;width:100%;height:250px"  >
                    <f:facet name="header" ><h:outputText value="ACTION SUR LES SOUS RAPPORTS"/></f:facet>
                    <h:panelGrid columns="2" border="0"  id="pgrdSousrapp" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.var_sousRapport_visible}">
                        <h:outputLabel for="file2" value="Importer sous rapport:" />
                        <t:inputFileUpload id="file2"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.uploadedFileSousRapport}"/>
                        <h:panelGroup />
                    </h:panelGrid>
                    <center>
                        <br>
                        <h:commandButton value="Envoyer le sous rapport vers le serveur"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.envoyerSousRapport}" style="color:green;font-family:Arial;width:300px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.var_sousRapport_visible}"/>
                        <br>
                        <h:commandButton value="Copier le sous rapport du serveur vers le local" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.copierSousRapport}" style="color:green;font-family:Arial;width:300px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.var_sousRapport_visible}"/>
                        <br><br>
                        <h:commandButton value="Renommer le sous rapport du serveur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.renommerSousRapport}" style="color:green;font-family:Arial;width:300px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.var_sousRapport_visible}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"/>
                        <br>
                        <h:commandButton value="Supprimer le sous rapport du serveur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.supprimerSousRapport}" style="color:green;font-family:Arial;width:300px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.var_sousRapport_visible}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"/>
                        <br><br>
                        <h:commandButton value="Envoyer le sous rapport vers HORUS =>"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.envoyerSousRapport}" style="color:red;font-family:Arial;width:300px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.var_sousRapport_visible}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        <br>
                        <h:commandButton value="<= Copier le sous rapport HORUS dans serveur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.copierSousRapport}" style="color:red;font-family:Arial;width:300px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.var_sousRapportModele_visible}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </rich:panel>

            </h:panelGrid>

            <h:panelGrid id="idPanModeleHORUS" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}">
                <h:panelGrid style="border:0px" id="idPanRapportHORUS">
                    <rich:extendedDataTable id="tableRapportHORUS" headerClass="headerTab" activeClass="active-row"  height="250px" width="300px" border="0" noDataLabel=" " rowClasses="rows1,rows2,rowsd" styleClass="bg" style="border:solid 1px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.dataModelModeleRapport}"  var="rapportHORUS">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.selectionRapportModele}" reRender="idPanAction"/>
                        <rich:column width="100%" >
                            <f:facet name="header" ><h:outputText value="SELECTION MODELE RAPPORT HORUS" style="color:red"/></f:facet>
                            <h:outputText value="#{rapportHORUS}" />
                        </rich:column >
                    </rich:extendedDataTable>
                </h:panelGrid>

                <h:panelGrid style="border:0px">
                    <rich:extendedDataTable id="tableSousRapportHORUS" height="250px" headerClass="headerTab" activeClass="active-row" width="300px" border="0" noDataLabel=" " rowClasses="rows1,rows2,rowsd" styleClass="bg" style="border:solid 1px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.dataModelModeleSousRapport}" var="sousRapportHORUS">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.selectionSousRapportModele}" reRender="idPanAction"/>
                        <rich:column width="100%" >
                            <f:facet name="header" ><h:outputText value="SELECTION MODELE SOUS RAPPORT HORUS" style="color:red"/></f:facet>
                            <h:outputText value="#{sousRapportHORUS}" style="width:100%" />
                        </rich:column >
                    </rich:extendedDataTable>
                </h:panelGrid>
            </h:panelGrid>

        </h:panelGrid>

        <br>
        Cliquez  <A target="_blank" HREF="http://jasperforge.org/projects/ireport" TITLE="description" style="color:blue;"> ici </A>  pour télécharger iReport (version 3.7.1).
        <br><br>
        <center>
            <h:commandButton id="idCancel" styleClass="exp_lienmenu" value="R E T O U R" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelRenameRapport" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="300" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.showModalPanelRenameRapport}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.showModalPanelRenameRapport}" var="rer">
            <f:facet name="header"><h:outputText value="RENOMMER RAPPORT"/></f:facet>
            <a4j:form id="formModalRenamer">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%" columns="2" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Ancien nom:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.ancienNom}" disabled="true" readonly="true" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                    <h:column><h:outputText value="Nouveau nom:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.nouveauNom}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                </h:panelGrid>
                <br>
                <h:panelGroup id="idpanvalr">
                    <center>
                        <a4j:commandButton id="idCanDupr" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.fermerRenommerRapport}" reRender="panelRenameRapport"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDupr" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.validerRenommerRapport}" reRender="panelRenameRapport,tableRapport" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelRenameSousRapport" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="300" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.showModalPanelRenameSousRapport}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.showModalPanelRenameSousRapport}" var="rsr">
            <f:facet name="header"><h:outputText value="RENOMMER SOUS RAPPORT"/></f:facet>
            <a4j:form id="formModalRenamsre">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%" columns="2" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Ancien nom:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.ancienNom}" disabled="true" readonly="true" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                    <h:column><h:outputText value="Nouveau nom:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.nouveauNom}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                </h:panelGrid>
                <br>
                <h:panelGroup id="idpanvalsr">
                    <center>
                        <a4j:commandButton id="idCanDupsr" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.fermerRenommeSousrRapport}" reRender="panelRenameSousRapport"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDupsr" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.validerRenommerSousRapport}" reRender="panelRenameSousRapport,tableSousRapport" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <center>
            <f:facet name="header"><h:outputText value="Impression"/></f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/images/close.gif" id="hideImp"/>
                    <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                </h:panelGroup>
            </f:facet>
            <a4j:form id="formModalImp" target="_blank">
                <h:panelGrid width="100%" >
                    <h:panelGrid width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <center>
                            <h:panelGrid  width="100%" style="height:80px">
                                <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConfigImprDocument.visualiserRapportdepuisHorus}" onclick="javascript:Richfaces.hideModalPanel('modAttenteImp');"/>
                            </h:panelGrid>
                        </center>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>


</f:subview>