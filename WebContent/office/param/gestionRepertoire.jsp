<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="gestionRepertoire">
    <a4j:form>

        <center> <h2><h:outputText value="GESTION DES REPERTOIRES" style="color:green;"/></h2></center>

        <center>
            <h:panelGrid id="pangrpVisbt" columns="4" width="200px">
                <a4j:commandButton title="Ajouter un nouveau répertoire" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGestionRepertoire.ajouterRepertoire}" reRender="panelRepertoire"/>
                <a4j:commandButton title="Modifier le répertoire sélectionné" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGestionRepertoire.modifierRepertoire}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGestionRepertoire.visibiliteBton}" reRender="panelRepertoire"/>
                <a4j:commandButton title="Supprimer le répertoire sélectionné" image="/images/supprimer.png" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGestionRepertoire.supprimerRepertoire}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGestionRepertoire.visibiliteBton}" reRender="pangrpVisbt,table"/>
                <a4j:commandButton title="Imprimer les répertoires" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');" rendered="false"/>
            </h:panelGrid>
        </center>

        <br>

        <center>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="table" headerClass="headerTab" enableContextMenu="false" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" border="0" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGestionRepertoire.dataModelRepertoiresCommun}" var="repCmm">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGestionRepertoire.selectionRepertoire}" reRender="pangrpVisbt,table"/>
                    <rich:column label="Type" sortable="false" width="10%" style="text-align:center;">
                        <f:facet name="header"><h:outputText  value="Type"/></f:facet>
                        <h:graphicImage value="#{repCmm.type}"/>
                    </rich:column>
                    <rich:column label="Nom du répertoire" sortable="false" width="90%">
                        <f:facet name="header"><h:outputText  value="Nom répertoire commun : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGestionRepertoire.nomRepertoire}"/></f:facet>
                        <h:outputText value="#{repCmm.texte}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </center>

        <br>

        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelRepertoire" width="500" height="500" headerClass="headerPanel"style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGestionRepertoire.showModalPanelRepertoire}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGestionRepertoire.showModalPanelRepertoire}" var="rep">
            <f:facet name="header"><h:outputText value="GESTION D'UN REPERTOIRE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGestionRepertoire.annulerRepertoire}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelRepertoire"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid  style="width:100%;" id="pngGlob">
                    <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                        <h:column><h:outputText value="Nom du répertoire:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGestionRepertoire.gestionRepertoire}"/></h:column>
                    </h:panelGrid>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableGroupe" headerClass="headerTab" enableContextMenu="false" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" border="0" styleClass="bg" style="border:solid 0px green;text-align:left;" width="100%" height="250px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGestionRepertoire.dataModelGroupesFavoris}" var="grp">
                            <rich:column label="Groupe" sortable="false" width="200px">
                                <f:facet name="header"><h:outputText  value="Autorisation Groupe"/></f:facet>
                                <h:outputText value="#{grp.groupe.grpCode} #{grp.groupe.grpLibelle}"/>
                            </rich:column>
                            <rich:column label="Accès" sortable="false" width="60px" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Accès"/></f:facet>
                                <h:selectBooleanCheckbox value="#{grp.grpfavAcces}"/>
                            </rich:column>
                            <rich:column label="Ajouter" sortable="false" width="60px" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Upload"/></f:facet>
                                <h:selectBooleanCheckbox value="#{grp.grpfavAjout}"/>
                            </rich:column>
                            <rich:column label="Modifier" sortable="false" width="60px" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Download"/></f:facet>
                                <h:selectBooleanCheckbox value="#{grp.grpfavModif}"/>
                            </rich:column>
                            <rich:column label="Supprimer" sortable="false" width="60px" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Supprimer"/></f:facet>
                                <h:selectBooleanCheckbox value="#{grp.grpfavSupp}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <br>
                    <h:panelGrid id="idpanSel" columns="2" style="width:100%;" columnClasses="clos50,clo50">
                        <a4j:commandButton value="Tout sélectionné" style="width:95%" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGestionRepertoire.toutSelectionner}" reRender="tableGroupe"/>
                        <a4j:commandButton value="Rien sélectionné" style="width:95%" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGestionRepertoire.rienSelectionner}" reRender="tableGroupe"/>
                        <a4j:commandButton value="Héritage dossier parent" style="width:95%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGestionRepertoire.niveau>=2}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGestionRepertoire.heritageDroitParent}" reRender="tableGroupe"/>
                        <h:column>
                            <a4j:commandButton value="Héritage autre dossier" style="width:95%" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGestionRepertoire.heritageDroitRepertoire}" reRender="idSelDossier,idpanSel"/><br>
                            <h:selectOneMenu id="idSelDossier" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGestionRepertoire.var_dossier}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGestionRepertoire.afficheDossierSelection}" style="width:95%">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGestionRepertoire.lesAutresDossiersItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGestionRepertoire.recupHeritageDroitRepertoire}" reRender="tableGroupe,idSelDossier,idpanSel" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>

                <h:panelGroup id="pngValide">
                    <center>
                        <br>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGestionRepertoire.validerAjoutRepertoire}" reRender="panelRepertoire,table,pangrpVisbt"/>
                    </center>
                </h:panelGroup>

            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>

</f:subview>
