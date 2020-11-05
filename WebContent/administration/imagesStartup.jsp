<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="sysImageStartup">

    <a4j:form id="formSysImage" enctype="multipart/form-data">

        <center> <h2><h:outputText value="IMAGES STARTUP" style="color:green;"/></h2></center>

        <h:panelGrid width="100%">

            <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabDefaut" label="Images par défaut">
                    <h:panelGrid id="panDefaut" width="100%">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable1" maxPages="20"align="left" for="tableDefaut"/>
                            <rich:extendedDataTable rows="100" style="max-height:100%" styleClass="bg" id="tableDefaut" enableContextMenu="false" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.dataModelImagesStartupDefaut}" var="image">
                                <rich:column label="Image" width="40%" sortable="true" style="text-align:center">
                                    <f:facet name="header" ><h:outputText value="Image"/></f:facet>
                                    <h:graphicImage value="/images/startup/#{image}" alt="pho" height="80px" width="80px" style="text-align:center"/>
                                </rich:column>
                                <rich:column sortable="false" width="40%" sortBy="#{image}">
                                    <f:facet name="header" ><h:outputText value="Nom image"/></f:facet>
                                    <h:outputText value="#{image}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>

                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabSpecifique" label="Images spécifiques">
                    <h:panelGrid id="panSpecifique" width="100%">
                        <h:panelGrid id="panelSpecifique" width="200px" columns="4">
                            <a4j:commandButton title="Ajouter une image" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.ajouterImage}" reRender="panalAjoutFile"/>
                            <a4j:commandButton title="Supprimer une image" image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.supprimerImage}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer l`image sélectionnée ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableSpecifique,scrollTable2,panelSpecifique" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.afficheBoutons}"/>
                            <a4j:commandButton title="Activer Images Spécifiques" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.activerImage}" onclick="if (!confirm('Etes-vous sur de vouloir activer les images spécifiques ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelSpecifique" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.specifique}"/>
                            <a4j:commandButton title="Désactiver Images Spécifiques" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.desactiverImage}" onclick="if (!confirm('Etes-vous sur de vouloir désactiver les images spécifiques ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelSpecifique" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.specifique}"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable2" maxPages="20"align="left" for="tableSpecifique"/>
                            <rich:extendedDataTable rows="100" style="max-height:100%" styleClass="bg" id="tableSpecifique" enableContextMenu="false" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.dataModelImagesStartupSpecif}" var="specif">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.selectionImage}" reRender="panelSpecifique"/>
                                <rich:column label="Image" width="40%" sortable="true" style="text-align:center">
                                    <f:facet name="header" ><h:outputText value="Image"/></f:facet>
                                    <h:graphicImage value="/images/startup#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid}/#{specif}" alt="spe" height="80px" width="80px" style="text-align:center"/>
                                </rich:column>
                                <rich:column sortable="false" width="40%" sortBy="#{specif}">
                                    <f:facet name="header" ><h:outputText value="Nom image"/></f:facet>
                                    <h:outputText value="#{specif}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                        <h:panelGrid>
                            <h:outputText value="LA GESTION DES IMAGES:"/>
                            <h:outputText value="Les images doivent être au format  png; avoir une taille : hauteur 330px et largeur 220px et leur nom doit commencer par 'epegase_'. Ce nom est imposé lors de l'enregistrement."/>
                            <h:outputText value="L'activation ou la désactivation des images spécifiques imposent le redémarrage du serveur d'application GLASSFISH."/>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

        </h:panelGrid>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutFile" width="500" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.showModalPanelAjoutFile}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.showModalPanelAjoutFile}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER DES IMAGES "></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.annulerDocument}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutFile"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil">
                    <h:panelGrid style="width:100%;">
                        <h:outputLabel for="idDoc" value="Ajoutez un document" />
                        <t:inputFileUpload id="idDoc" storage="file"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.uploadedFile}" accept=".png, .PNG"/>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.validerDocument}"/>
                            </center>
                        </h:panelGroup>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>