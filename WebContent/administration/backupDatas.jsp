<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="sysBackup">

    <h:form id="formSysBackup" enctype="multipart/form-data">

        <center><h2><h:outputText value="SAUVEGARDE DES DATAS" style="color:green;"/></h2></center>

        <h:panelGrid width="100%">

            <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;" selectedTab="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.ongletActif}">

                <rich:tab id="tabBackup" label="Backup">
                    <h:panelGrid id="panelBouton" width="350px" columns="7">
                        <a4j:commandButton title="Exécuter une sauvegarde" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.backupDB}"  onclick="if (!confirm('Etes-vous sur de vouloir exécuter la sauvegarde ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableSauvegarde,scrollTable,panelBouton"/>
                        <a4j:commandButton title="Compresser la sauvegarde" image="/images/zipper.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.zipperFichier}"  onclick="if (!confirm('Etes-vous sur de vouloir zipper le fichier sélectionné ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableSauvegarde,scrollTable,panelBouton" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.selectFile}" />
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.selectFile}">
                            <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.fichierUrl}" download="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.nomFichier}" title="Télécharger le fichier sélectionné"><img src="images/download.png" alt="télécharger"></a>
                            </h:column>
                            <a4j:commandButton title="Restaurer la sauvegarde" image="/images/upload.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.restoreDB}"  onclick="if (!confirm('Etes-vous sur de vouloir exécuter la restauration de la base de données sélectionnée?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableSauvegarde,scrollTable,panelBouton" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.selectFile}"/>
                            <a4j:commandButton title="Supprimer la sauvegarde" image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.supprimerFichier}"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer le fichier sélectionné ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableSauvegarde,scrollTable,panelBouton" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.selectFile}" />
                            <a4j:commandButton title="Ajouter sauvegarde externe" image="/images/jumelle.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.ajouterExterne}" reRender="panalAjoutBackup"/>
                            <a4j:commandButton title="Recharger la liste" image="/images/actualiser.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.chargerListeSauvegarde}" reRender="scrollTable,tableSauvegarde"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableSauvegarde"/>
                            <rich:extendedDataTable rows="100" style="max-height:100%" styleClass="bg" id="tableSauvegarde" enableContextMenu="false" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.datamodelBackup}" var="save">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.selectionFichier}" reRender="panelBouton"/>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header" ><h:outputText value="Sauvegarde N°"/></f:facet>
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.datamodelBackup.rowIndex+1}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" width="80%" sortBy="#{save.module}" sortOrder="DESCENDING">
                                    <f:facet name="header" ><h:outputText value="Nom sauvegarde (fichier DUMP SQL)"/></f:facet>
                                    <h:outputText value="#{save.module}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText value="Taille (ko)"/></f:facet>
                                    <h:outputText value="#{save.taille}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                <rich:tab id="tabSousDossier" label="Sous dossiers">
                    <h:panelGrid id="panelBoutonSd" width="300px" columns="2">
                        <a4j:commandButton title="Créer sous dossier" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.creerSousDossier}"  onclick="if (!confirm('Etes-vous sur de vouloir créer un sous dossier ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableSd,scrollTableSd,panelBoutonSd"/>
                        <a4j:commandButton title="Supprimer le sous dossier" image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.supprimerSousDossier}"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer le sous dossier sélectionné ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableSd,scrollTableSd,panelBoutonSd" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.selectSousDossier}" />
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableSd" maxPages="20"align="left" for="tableSd"/>
                        <rich:extendedDataTable rows="100" style="max-height:100%" styleClass="bg" id="tableSd" enableContextMenu="false" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.datamodelSousDossier}" var="sd">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.selectionSousDossier}" reRender="panelBoutonSd"/>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header" ><h:outputText value="Sous dossier N°"/></f:facet>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.datamodelSousDossier.rowIndex+1}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="80%" sortBy="#{sd}" sortOrder="DESCENDING">
                                <f:facet name="header" ><h:outputText value="Nom sous dossier (base de données SQL)"/></f:facet>
                                <h:outputText value="#{sd}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab id="tabRestauration" label="Restauration Dump Sql vers BD" immediate="true">
                    <h:panelGroup id="grid">
                        <center>
                            <rich:fileUpload id="upload" acceptedTypes="SQL,sql,bz2,BZ2" ajaxSingle="false" progressLabel="true" addControlLabel="Ajouter DUMP SQL" uploadControlLabel="Importer" autoclear="true" noDuplicate="true" immediateUpload="false" maxFilesQuantity="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.uploadsAvailable}" listHeight="500px" listWidth="600px" allowFlash="false" fileUploadListener="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.listener}" uploadData="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.uploadData}">
                                <a4j:support event="onuploadcomplete" reRender="grid"/>
                            </rich:fileUpload>
                        </center>
                    </h:panelGroup>
                </rich:tab>

                <rich:tab id="tabRepertoire" label="Répertoires">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.chargerListeRepertoires}" reRender="panRepertoires"/>
                    <h:panelGrid width="100%" columns="2" columnClasses="clos40,clos60g" id="panRepertoires">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable2" maxPages="20" align="left" for="tableRepertoire"/>
                            <rich:extendedDataTable rows="100" style="max-height:100%" styleClass="bg" id="tableRepertoire" enableContextMenu="false" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" rowKeyVar="rkv" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.datamodelRepertoire}" var="rep">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.selectionRepertoire}" reRender="panelBouton2,tableFichier,scrollTable3,tableRepertoire,panelBouton3"/>
                                <rich:column id="idColDossier" sortable="false" width="20%" style="text-align:center">
                                    <f:facet name="header"><h:outputText value=""/></f:facet>
                                    <h:graphicImage value="#{rep.type}"/>
                                </rich:column>
                                <rich:column id="idColTexte" sortable="false" width="80%">
                                    <f:facet name="header" ><h:outputText value="Nom répertoire"/></f:facet>
                                    <h:outputText value="#{rep.espace} #{rep.texte}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                        <a4j:region renderRegionOnly="false">
                            <h:panelGrid id="panelBouton3" width="200px" columns="4" style="height:40px">
                                <a4j:commandButton title="Ajouter un fichier" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.ajouterFichierDossier}" reRender="panalAjoutFile" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.selectRepertoire}"/>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.selectFile}">
                                    <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.fichierUrl}" download="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.nomFichier}" title="Télécharger document"><img src="images/download.png" alt="télécharger"></a>
                                    </h:column>
                                    <a4j:commandButton title="Supprimer le(s) fichier(s)" image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.suppressionFichierDossier}"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer le fichier sélectionné ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableFichier,scrollTable3,panelBouton3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.selectFile}" />
                                </h:panelGrid>
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable3" maxPages="20"align="left" for="tableFichier"/>
                                <rich:extendedDataTable rows="100" style="max-height:100%" styleClass="bg" id="tableFichier" enableContextMenu="false" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.datamodelFichier}" var="fic">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.selectionFichierDossier}" reRender="panelBouton3"/>
                                    <rich:column sortable="false" width="10%" style="text-align:center">
                                        <f:facet name="header"><h:outputText  value=""/></f:facet>
                                        <h:graphicImage value="#{fic.type}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="5%" style="text-align:center">
                                        <f:facet name="header"><h:outputText  value=""/></f:facet>
                                        <h:selectBooleanCheckbox value="#{fic.selection}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="75%">
                                        <f:facet name="header" ><h:outputText value="Nom fichier (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.memoRepertoire})"/></f:facet>
                                        <h:outputText value="#{fic.texte}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%" style="text-align:right;">
                                        <f:facet name="header" ><h:outputText value="Taille (ko)"/></f:facet>
                                        <h:outputText value="#{fic.taille}" rendered="#{fic.type!='../images/dossier.png'}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>

                </rich:tab>

                <rich:tab id="tabServices" label="Services">
                    <h:panelGroup>
                        <center>
                            <br><br><br>
                            <h:commandButton value="Rebooter le serveur" style="width:90%;text-align:center;font-weight:bold;font-size:50px;color:red;"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.rebootServeur}" onclick="if (!confirm('Etes-vous sur de vouloir rebooter le serveur ?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
                            <br><br><br>
                            <h:commandButton value="Eteindre le serveur" style="width:90%;text-align:center;font-weight:bold;font-size:50px;color:red;"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.eteindreServeur}" onclick="if (!confirm('Etes-vous sur de vouloir éteindre le serveur ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.urlHost!='www.e-pegase.biz'}"/>
                            <br><br><br>
                        </center>
                    </h:panelGroup>
                </rich:tab>

                <rich:tab id="tabGlassfish" label="Glassfish">
                    <iframe width="100%" height="600px" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.urlProtocole}://${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.urlHost}:4848/" frameborder="0"></iframe>
                </rich:tab>

                <rich:tab id="tabWebmin" label="Webmin">
                    <iframe width="100%" height="600px" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.urlProtocole}://${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.urlHost}:10000/" frameborder="0"></iframe>
                </rich:tab>

                <rich:tab id="tabSql" label="mySql">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.chargerListeTablesSql}" reRender="panMysql"/>
                    <h:panelGrid width="100%" columns="2" columnClasses="clos30,clos70" id="panMysql">
                        <h:panelGrid width="100%">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable style="max-height:100%" styleClass="bg" id="tableTable" enableContextMenu="false" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" rowKeyVar="rkv" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.datamodelTable}" var="table">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.selectionTable}" reRender="panelBouton2,tableFichier,scrollTable3,tableRepertoire,panelBouton3,tableColonne"/>
                                    <rich:column sortable="false" width="20%" sortBy="#{table.module} #{table.nomTable}" sortOrder="ASCENDING" style="text-align:left;">
                                        <f:facet name="header" ><h:outputText value="Module"/></f:facet>
                                        <h:outputText value="#{table.module}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="65%" style="text-align:left;">
                                        <f:facet name="header" ><h:outputText value="Nom table"/></f:facet>
                                        <h:outputText value="#{table.nomTable}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="15%" style="text-align:right;">
                                        <f:facet name="header" ><h:outputText value="Nombre enregistrements"/></f:facet>
                                        <h:outputText value="#{table.nbRecords}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                        <h:panelGrid width="100%">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable style="max-height:100%" styleClass="bg" id="tableColonne" enableContextMenu="false" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" rowKeyVar="rkv" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.datamodelColonnes}" var="col">
                                    <rich:column sortable="false" width="20%" sortBy="##{col.column_name}" sortOrder="ASCENDING">
                                        <f:facet name="header" ><h:outputText value="Colonne"/></f:facet>
                                        <h:outputText value="#{col.column_name}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="60%">
                                        <f:facet name="header" ><h:outputText value="Descriptif"/></f:facet>
                                        <h:outputText value="#{col.column_comment}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%">
                                        <f:facet name="header" ><h:outputText value="Type"/></f:facet>
                                        <h:outputText value="#{col.column_type}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="5%" style="text-align:right;">
                                        <f:facet name="header" ><h:outputText value="NbCar."/></f:facet>
                                        <h:outputText value="#{col.column_nbCar}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="5%" style="text-align:right;">
                                        <f:facet name="header" ><h:outputText value="NbPrec."/></f:facet>
                                        <h:outputText value="#{col.column_numeric}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

        </h:panelGrid>

    </h:form>


    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutFile" width="500" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.showModalPanelAjoutFile}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.showModalPanelAjoutFile}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER DES DOCUMENTS VERS : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.memoRepertoire}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.annulerFichierDossier}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutFile"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil">
                    <h:panelGrid style="width:100%;">
                        <h:outputLabel for="idDoc" value="Ajoutez un document"/>
                        <t:inputFileUpload id="idDoc" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.uploadedFile}"/>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.validerFichierDossier}"/>
                            </center>
                        </h:panelGroup>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutBackup" width="500" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.showModalPanelAjoutFile}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.showModalPanelAjoutFile}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER UNE SAUVEGARDE EXTERNE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.annulerExterne}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutBackup"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil">
                    <h:panelGrid style="width:100%;">
                        <h:outputLabel for="idDoc" value="Ajoutez un document" />
                        <t:inputFileUpload id="idDoc" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.uploadedFile}" accept=".sql,.SQL"/>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.validerExeterne}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            </center>
                        </h:panelGroup>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>