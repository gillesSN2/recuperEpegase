<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="importGestCom">

    <h:form enctype="multipart/form-data">

        <center><h2><h:outputText value="IMPORTATION GESTION COMMERCIALE" styleClass="titre"/></h2></center>

        <br>
        <br>
        <br>
        <h:panelGroup id="grid">
            <center>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.var_choix_importation}">
                        <f:selectItem itemLabel="Choissisez le mode d'importation..." itemValue="0"/>
                        <f:selectItem itemLabel="Importation par fichier texte (CSV)" itemValue="1"/>
                        <f:selectItem itemLabel="Importation par fichier Excel" itemValue="2"/>
                        <f:selectItem itemLabel="Importation via serveur FTP" itemValue="3" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif==0}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="grid"/>
                    </h:selectOneMenu>
                </h:column>
                <br>
                <br>
                <a4j:commandButton value="Information sur l'importation" title="Information" oncomplete="javascript:Richfaces.showModalPanel('panelInfo');" reRender="panelInfo" />
                <br>
                <br>
                <br>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.var_choix_importation==1}" var="csv">
                    <rich:fileUpload id="upload1" acceptedTypes="csv,CSV" ajaxSingle="false" progressLabel="true" addControlLabel="Ajouter fichier" uploadControlLabel="Importer" autoclear="true" noDuplicate="true" immediateUpload="false" maxFilesQuantity="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.uploadsAvailable}" listHeight="80px" fileUploadListener="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.listener}">
                        <a4j:support event="onuploadcomplete" reRender="grid,idTransfert"/>
                    </rich:fileUpload>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.var_choix_importation==2}" var="xls">
                    <rich:fileUpload id="upload2" acceptedTypes="xls,XLS" ajaxSingle="false" progressLabel="true" addControlLabel="Ajouter fichier" uploadControlLabel="Importer" autoclear="true" noDuplicate="true" immediateUpload="false" maxFilesQuantity="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.uploadsAvailable}" listHeight="80px" fileUploadListener="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.listener}">
                        <a4j:support event="onuploadcomplete" reRender="grid,idTransfert"/>
                    </rich:fileUpload>
                </c:if>
                <h:commandButton id="idTransfert" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:300px;" value="Visualisation transfert" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.var_choix_importation==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.var_choix_importation==2}"/>

                <h:commandButton style="color:white;background-color:green;margin:3px 3px 3px 3px;width:300px;" value="Importation à  partir d'un site ftp" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.importFtp}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.var_choix_importation==3}"/>

            </center>
        </h:panelGroup>
        <br>
        <br>
        <br>

    </h:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelInfo" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1200" height="600">
        <center>
            <f:facet name="header"><h:outputText value="Information sur l'importation" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelinkInfo"/>
                    <rich:componentControl for="panelInfo" attachTo="hidelinkInfo" operation="hide" event="onclick"/>
                </h:panelGroup>
            </f:facet>
            <a4j:form id="formModalInfo" >

                <div style="text-align:center;text-decoration:underline;">Le format CSV (comma-separated-values) ou Excel (xls, xlsx) ?
                </div>
                <br>
                <div style="text-align:justify;">Le format CSV (comma-separated-values) est un format de communication qui respecte la norme CSV décrite sous la référence <A target="_blank" HREF="http://tools.ietf.org/html/rfc4180" TITLE="description" style="color:blue;"> RFC 4180 </A>.
                    Le format de communication est donc le CSV et voici le détail de la structure du fichier. Chaque champ est séparé par une virgule et chaque enregistrement est terminé par un point-virgule puis par un retour chariot (car13).<br><br>
                </div>
                <div style="text-align:justify;">Le format Excel (xls uniquement) est un format propriétair développé par Microsoft dans sa gamme Office.
                    ePegase est capable de lire directement les fihiers excel.<br><br>
                </div>

                <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabEcr1" label="Importation PRODUITS" >
                        <h:panelGrid width="100%">
                            <div style="text-align:justify;">
                                Cette procédure permet d'importer et de mettre à jour la base de données de la table des produits.
                                La structure du fchier est trés simple. La première colonne est obligatoire.<br>
                                Voici la structure du tableau (Format XLS):<br>
                                <b></b> <br>
                                - colonne 01 : code produit<br>
                                - les autres colonnes provienent de la table PRODUIT.
                                Chaque colonne doit porter le nom de la rubrique concernée (sur la ligne 1 d'excel).
                                Les rubriques ne doient appartenir qu'à une seule table en même temps.
                                Les dates doivent être au format AAAA-MM-JJ.
                                Les boolean doient être égale à 1 pour VRAI et 0 pour FAUX.
                            </div>
                            <h:graphicImage value="/images/screenshot/importExcelProduit.jpg"/><br><br>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabEcr2" label="Importation PRODUITS/DEPOTS" >
                        <h:panelGrid width="100%">
                            <div style="text-align:justify;">
                                Cette procédure permet d'importer et de mettre à jour la base de données de la table de liaison des produits avec les dépôts.
                                La structure du fchier est trés simple. Les 2 premières colonnes sont obligatoires. Le code produit et le code dépôt doivent exister<br>
                                Voici la structure du tableau (Format XLS):<br>
                                <b></b> <br>
                                - colonne 01 : code produit<br>
                                - colonne 02 : code dépôt<br>
                                - les autres colonnes provienent de la table PRODUIT/DEPOT.
                                Chaque colonne doit porter le nom de la rubrique concernée (sur la ligne 1 d'excel).
                                Les rubriques ne doient appartenir qu'à une seule table en même temps.
                                Les dates doivent être au format AAAA-MM-JJ.
                                Les boolean doient être égale à 1 pour VRAI et 0 pour FAUX.
                            </div>
                            <h:graphicImage value="/images/screenshot/importExcelProduitDepot.jpg"/><br><br>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabEcr3" label="Importation PRODUITS/TARIFS" >
                        <h:panelGrid width="100%">
                            <div style="text-align:justify;">
                                Cette procédure permet d'importer et de mettre à jour la base de données de la table de liaison des produits avec les tarifs. Les catégories des tarifs sont directement liés au découage des clients en famille de clients
                                La structure du fchier est trés simple. Les 2 premières colonnes sont obligatoires. Le code produit et l'ordre tarif doivent exister<br>
                                Voici la structure du tableau (Format XLS):<br>
                                <b></b> <br>
                                - colonne 01 : code produit<br>
                                - colonne 02 : ordre tarif<br>
                                - les autres colonnes provienent de la table PRODUIT/TARIF.
                                Chaque colonne doit porter le nom de la rubrique concernée (sur la ligne 1 d'excel).
                                Les rubriques ne doient appartenir qu'à une seule table en même temps.
                                Les dates doivent être au format AAAA-MM-JJ.
                                Les boolean doient être égale à 1 pour VRAI et 0 pour FAUX.
                            </div>
                            <h:graphicImage value="/images/screenshot/importExcelProduitTarif.jpg"/><br><br>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabEcr4" label="Importation BAREMES" >
                        <h:panelGrid width="100%">
                            <div style="text-align:justify;">
                                Cette procédure permet d'importer et de mettre à jour la base de données de la table des barémes.
                                La structure du fchier est trés simple. Les 2 premières colonnes sont obligatoires. Les barèmes sont des tarifs qui viennent se substituer aux tarifs standards. Ils peuvents être liés soit à un tiers, soit à une famille de tiers, soit à une famille de produit soit à un produit. La présente importation permet ne permet que d'importer des barèmes liés à une famille de tiers. C'est la rion pour laquelle les 2ere colonnes obligatoires sont le code produit et l`ordre de tarif.<br>
                                Voici la structure du tableau (Format XLS):<br>
                                <b></b> <br>
                                - colonne 01 : code produit<br>
                                - colonne 02 : ordre tarif<br>
                                - les autres colonnes provienent de la table BAREMES.
                                Chaque colonne doit porter le nom de la rubrique concernée (sur la ligne 1 d'excel).
                                Les rubriques ne doient appartenir qu'à une seule table en même temps.
                                Les dates doivent être au format AAAA-MM-JJ.
                                Les boolean doient être égale à 1 pour VRAI et 0 pour FAUX.
                            </div>
                            <h:graphicImage value="/images/screenshot/importExcelBaremes.jpg"/><br><br>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabEcr5" label="Champs table Produit" >
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableDictionnaireProduits" style="border:solid 0px green;cursor:pointer;" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " selectionMode="single" border="0" width="100%" height="350px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.dataModelChampProduit}" var="dic1">
                                <rich:column label="Nom" sortable="true" sortBy="#{dic1.column_name}" width="30%">
                                    <f:facet name="header"><h:outputText  value="Nom champ" /></f:facet>
                                    <h:outputText value="#{dic1.column_name}"/>
                                </rich:column>
                                <rich:column label="Nom" sortable="true" sortBy="#{dic1.column_comment}" width="70%">
                                    <f:facet name="header"><h:outputText  value="Explication champ" /></f:facet>
                                    <h:outputText value="#{dic1.column_comment}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                    <rich:tab id="tabEcr6" label="Champs table Produit/Dépôt" >
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableDictionnaireProduitsDepot" style="border:solid 0px green;cursor:pointer;" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " selectionMode="single" border="0" width="100%" height="350px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.dataModelChampProduitDepot}" var="dic2">
                                <rich:column label="Nom" sortable="true" sortBy="#{dic1.column_name}" width="30%">
                                    <f:facet name="header"><h:outputText  value="Nom champ" /></f:facet>
                                    <h:outputText value="#{dic2.column_name}"/>
                                </rich:column>
                                <rich:column label="Nom" sortable="true" sortBy="#{dic1.column_comment}" width="70%">
                                    <f:facet name="header"><h:outputText  value="Explication champ" /></f:facet>
                                    <h:outputText value="#{dic2.column_comment}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                    <rich:tab id="tabEcr7" label="Champs table Produit/Tarif" >
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableDictionnaireProduitsTarif" style="border:solid 0px green;cursor:pointer;" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " selectionMode="single" border="0" width="100%" height="350px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.dataModelChampProduitTarif}" var="dic3">
                                <rich:column label="Nom" sortable="true" sortBy="#{dic1.column_name}" width="30%">
                                    <f:facet name="header"><h:outputText  value="Nom champ" /></f:facet>
                                    <h:outputText value="#{dic3.column_name}"/>
                                </rich:column>
                                <rich:column label="Nom" sortable="true" sortBy="#{dic1.column_comment}" width="70%">
                                    <f:facet name="header"><h:outputText  value="Explication champ" /></f:facet>
                                    <h:outputText value="#{dic3.column_comment}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                   <rich:tab id="tabEcr8" label="Champs table Barèmes" >
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableDictionnaireBareme" style="border:solid 0px green;cursor:pointer;" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " selectionMode="single" border="0" width="100%" height="350px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTransfertVentes.dataModelChampBareme}" var="dic4">
                                <rich:column label="Nom" sortable="true" sortBy="#{dic1.column_name}" width="30%">
                                    <f:facet name="header"><h:outputText  value="Nom champ" /></f:facet>
                                    <h:outputText value="#{dic4.column_name}"/>
                                </rich:column>
                                <rich:column label="Nom" sortable="true" sortBy="#{dic1.column_comment}" width="70%">
                                    <f:facet name="header"><h:outputText  value="Explication champ" /></f:facet>
                                    <h:outputText value="#{dic4.column_comment}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                </rich:tabPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>

</f:subview>
