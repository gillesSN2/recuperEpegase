<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="mesDocs">

    <center> <h2><h:outputText value="MES DOCUMENTS" style="color:green;"/></h2></center>

    <a4j:form id="documents" >
        <h:panelGrid id="pn2" width="100%">
            <a4j:region renderRegionOnly="false">
                <h:panelGrid id="btnRep" columns="4" width="20%" style="height:34px;width:200px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                    <a4j:commandButton title="Ajouter document" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.niveau!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.objetMessageSysteme.ajout}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.ajouterDocument}" reRender="panalAjoutFile"/>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.objetMessageSysteme.modif&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.fichier}">
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.fichierUrl}" download="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.nomFichier}" title="Télécharger document"><img src="images/download.png" alt="télécharger"></a>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.objetMessageSysteme.modif&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.fichier&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.viewerPdf}">
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                        </h:column>
                        <a4j:commandButton title="Supprimer document" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.objetMessageSysteme.supp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.fichier}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;" reRender="tableRep" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.supprimerDocument}"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableRep" enableContextMenu="false" style="max-height:100%" width="100%" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " styleClass="bordure" headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.dataModelRepertoire}" var="repertoire" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.selectionRepertoire}" reRender="btnRep,tableRep,pn2"/>
                            <rich:column width="35px" sortable="false" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value=""/></f:facet>
                                <h:graphicImage value="#{repertoire.type}"/>
                            </rich:column>
                            <rich:column width="90%" sortable="false">
                                <f:facet name="header" ><h:outputText value="Documents #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.nomRepertoire} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.nomFichier}"/></f:facet>
                                <h:outputText value="#{repertoire.texte}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </a4j:region>
            </h:panelGrid>
        </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutFile" width="500" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.showModalPanelAjoutFile}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.showModalPanelAjoutFile}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER DES DOCUMENTS VERS : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.nomRepertoire}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.annulerDocument}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutFile"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil">
                    <h:panelGrid style="width:100%;">
                        <h:outputLabel for="idDoc" value="Ajoutez un document" />
                        <t:inputFileUpload id="idDoc" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.uploadedFile}"/>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formBrowser.validerDocument}"/>
                            </center>
                        </h:panelGroup>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>