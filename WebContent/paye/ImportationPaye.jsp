<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="import">

    <h:form enctype="multipart/form-data">

        <center><h2><h:outputText value="IMPORTATION PAYE" styleClass="titre"/></h2></center>

        <br>
        <br>
        <br>
        <h:panelGroup id="grid">
            <center>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_choix_importation}">
                        <f:selectItem itemLabel="Choissisez le mode d'importation..." itemValue="0"/>
                        <f:selectItem itemLabel="Importation par fichier texte (CSV)" itemValue="1"/>
                        <f:selectItem itemLabel="Importation par fichier Excel" itemValue="2"/>
                        <f:selectItem itemLabel="Importation via serveur FTP" itemValue="3" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif==0}"/>
                        <f:selectItem itemLabel="Importation avec BD Sage" itemValue="4"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.calculBase}" reRender="grid,idBases"/>
                    </h:selectOneMenu>
                </h:column>
                <br>
                <br>
                <a4j:commandButton value="Information sur l'importation" title="Information" oncomplete="javascript:Richfaces.showModalPanel('panelInfo');" reRender="panelInfo" />
                <br>
                <br>
                <br>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_choix_importation==1}" var="csv">
                    <rich:fileUpload id="upload1" acceptedTypes="csv,CSV" ajaxSingle="false" progressLabel="true" addControlLabel="Ajouter fichier" uploadControlLabel="Importer" autoclear="true" noDuplicate="true" immediateUpload="false" maxFilesQuantity="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.uploadsAvailable}" listHeight="80px" fileUploadListener="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.listener}">
                        <a4j:support event="onuploadcomplete" reRender="grid,idTransfert"/>
                    </rich:fileUpload>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_choix_importation==2}" var="xls">
                    <rich:fileUpload id="upload2" acceptedTypes="xls,XLS" ajaxSingle="false" progressLabel="true" addControlLabel="Ajouter fichier" uploadControlLabel="Importer" autoclear="true" noDuplicate="true" immediateUpload="false" maxFilesQuantity="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.uploadsAvailable}" listHeight="80px" fileUploadListener="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.listener}">
                        <a4j:support event="onuploadcomplete" reRender="grid,idTransfert"/>
                    </rich:fileUpload>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_choix_importation==4}" var="bds">
                    <h:selectOneMenu style="width:300px" id="idBases" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_choix_base}">
                        <f:selectItem itemLabel="Séléction Base" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.lesBasesSage}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.selectionBase}" reRender="grid,idImportSalarie,idImportBulletin,idTransfert"/>
                    </h:selectOneMenu>
                    <h:commandButton id="idImportSalarie" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:200px;" value="Import Salariés" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.importationSalarie}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.baseSelect}" onclick="if (!confirm('Etes-vous sur de vouloir importer les Salariés Sage ?')) return false;javascript:Richfaces.showModalPanel('panelImport');" />
                    <h:commandButton id="idImportBulletin" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:200px;" value="Import Bulletins" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.importationBulletin}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.baseSelect}" onclick="if (!confirm('Etes-vous sur de vouloir importer les bulletins de salaire de Sage ?')) return false;javascript:Richfaces.showModalPanel('panelImport');" />
                </c:if>
                <h:commandButton id="idTransfert" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:300px;" value="Visualisation transfert" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_choix_importation==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_choix_importation==2}"/>

                <h:commandButton style="color:white;background-color:green;margin:3px 3px 3px 3px;width:300px;" value="Importation à  partir d'un site ftp" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.importFtp}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_choix_importation==3}"/>

            </center>
        </h:panelGroup>
        <br>
        <br>
        <br>

    </h:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelInfo" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="1200" height="600">
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

                    <rich:tab id="tabEcr1" label="Importation variables des salariés" >
                        <h:panelGrid width="100%">
                            <div style="text-align:justify;">
                                Le fichier décrit les différentes zones concernées. Les 4 premières colonnes sont imposées et fixes mais les autres sont libres.
                                Il peut y avoir plusieurs feuilles dans la classeur excel. Chaque feuille peut avoir des rubriques diffrentes
                                Chaque feuille doit impérativement avoir une ligne qui décrit les colonnes.
                                Voici la structure du tableau (Format XLS):<br>
                                <b></b> <br>
                                - colonne 01 : activité analytique (20 caractères maximum)<br>
                                - colonne 02 : service (20 caractères maximum)<br>
                                - colonne 03 : localisation (20 caractères maximum)<br>
                                - colonne 04 : matricule<br>
                                - colonne 05 : nom et prénom (100 caractères maximun) <br>
                                - colonne 06 : état du salarié (0=bulletin généré 1=bulletin non généré)<br>
                                - colonne 07 à 40: colonnes qui correspondent aux rubriques de la paye<br><br>
                            </div>
                            <h:graphicImage value="/images/screenshot/exempleImportVariablesExcel.jpg"/><br><br>
                            <div style="text-align:justify;">
                                Dans cet exemple, la ligne rouge permet à ePégase d'identifier chaque rubrique. Une colonne qui ne doit pas être traitée doit avoir X à la place du code rubrique.<br>
                                La ligne dit commencer par le mot clé : RUBRIQUE<br>
                                La période doit être positionner dans la colonne C.<br>
                                Seules les rubriques variables et non contactuelles sont prises en compte.<br>
                            </div>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabEcr2" label="Importation libre" >
                        <h:panelGrid width="100%">
                            <div style="text-align:justify;">
                                Cette procédure permet d'importer et de mettre à jour la base de données des tables Salariés et Contrats.
                                La structure du fchier est trés simple.
                                Voici la structure du tableau  (Format XLS):<br>
                                <b></b> <br>
                                - colonne 01 : matricule (20 caractères maximum) Cette colonne est obligatoire et doit correspondre au matricule du salarié<br>
                                - les autres colonnes peuvent provenir des tables SALARIES ou CONTRATS.
                                Chaque colonne doit porter le nom de la rubrique concernée (sur la ligne 1 d'excel).
                                Les rubriques ne doient appartenir qu'à une seule table en même temps.
                                Les dates doivent être au format AAAA-MM-JJ.
                                Les boolean doient être égale à 1 pour VRAI et 0 pour FAUX.
                            </div>
                            <h:graphicImage value="/images/screenshot/exempleImportLibreExcel.jpg"/><br><br>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabEcr3" label="Importation champs individuels" >
                        <h:panelGrid width="100%">
                            <div style="text-align:justify;">
                                Cette procédure permet d'importer et de mettre à jour la base de données avec des variables précises.
                                La structure du fchier est trés simple.
                                Voici la structure du tableau  (Format XLS):<br>
                                <b></b> <br>
                                - colonne 01 : matricule (20 caractères maximum)<br>
                                - colonne 02 : variable (numérique)<br><br>
                            </div>
                            <h:panelGrid columns="2">
                                <h:graphicImage value="/images/screenshot/exempleImportRubriqueExcel2.jpg"/>
                                <h:graphicImage value="/images/screenshot/exempleImportRubriqueExcel3.jpg"/>
                            </h:panelGrid>
                            <br><br>
                            <div style="text-align:justify;">
                                La colonne 02 doit porter le nom de la rubrique à mettre à jour.<br>
                                Elle peut provenir des tables suivantes : VARIABLES ou HISTORIQUES. Pour les historiques, il faut préciser un mot clé complémentaire séparé par :. BRUT pour le brut, NBJS pour le nombre de jours de congés restants, CP pour le montant des congs payés, ADM pour l'appoint du dernier mois <br>
                                La rubrique à mettre à jour est exclusivement numérique.<br>
                            </div>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabEcr4" label="Champs table Salarié" >
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableDictionnaireSalarie" style="border:solid 0px green;cursor:pointer;" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " selectionMode="single" border="0" width="100%" height="350px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.dataModelChampSalarie}" var="dic1">
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

                    <rich:tab id="tabEcr5" label="Champs table Contrat" >
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableDictionnaireContrat" style="border:solid 0px green;cursor:pointer;" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " selectionMode="single" border="0" width="100%" height="350px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.dataModelChampContrat}" var="dic2">
                                <rich:column label="Nom" sortable="true" sortBy="#{dic2.column_name}" width="30%">
                                    <f:facet name="header"><h:outputText  value="Nom champ" /></f:facet>
                                    <h:outputText value="#{dic2.column_name}"/>
                                </rich:column>
                                <rich:column label="Nom" sortable="true" sortBy="#{dic2.column_comment}" width="70%">
                                    <f:facet name="header"><h:outputText  value="Explication champ" /></f:facet>
                                    <h:outputText value="#{dic2.column_comment}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                </rich:tabPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelSage" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="1200" height="600" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.showModalPanelSage }">
        <f:facet name="header"><h:outputText value="" style="color:white;"/></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.fermerSage}" image="/images/close.gif" styleClass="hidelink" reRender="panelSage"/>
            </a4j:form >
        </f:facet>
        <a4j:form id="formModalSage" >

            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.balance==1}" var="salSage">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="280%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.datamodelDocument}" var="doc">
                        <rich:column label="Matricule" sortable="true" sortBy="#{doc.trfColT00}" width="100px">
                            <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                            <h:outputText value="#{doc.trfColT00}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column label="Nom et Prénom" sortable="true" sortBy="#{doc.trfColT01}" width="300px" style="text-align:right">
                            <f:facet name="header"><h:outputText  value="Nomet prénom" /></f:facet>
                            <h:outputText value="#{doc.trfColT01}" style="#{doc.stylePolice};text-align:right"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </c:if>

            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.balance==2}" var="bulSage">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="280%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.datamodelDocument}" var="doc">
                        <rich:column label="Matricule" sortable="true" sortBy="#{doc.trfColT00}" width="100px">
                            <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                            <h:outputText value="#{doc.trfColT00}" style="#{doc.stylePolice}"/>
                        </rich:column>
                        <rich:column label="Nom et Prénom" sortable="true" sortBy="#{doc.trfColT01}" width="300px" style="text-align:right">
                            <f:facet name="header"><h:outputText  value="Nomet prénom" /></f:facet>
                            <h:outputText value="#{doc.trfColT01}" style="#{doc.stylePolice};text-align:right"/>
                        </rich:column>
                        <rich:column label="Période" sortable="true" sortBy="#{doc.trfColT02}" width="100px" style="text-align:right">
                            <f:facet name="header"><h:outputText  value="Période" /></f:facet>
                            <h:outputText value="#{doc.trfColT02}" style="#{doc.stylePolice};text-align:right"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </c:if>

        </a4j:form>

    </rich:modalPanel>

    <rich:modalPanel headerClass="headerPanel" id="panelImport" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="700" height="80" >
            <f:facet name="header"><h:outputText value="Traitement en cours (Importation Sage)..."/></f:facet>
            <center>
                <a4j:form>
                    <br>
                    <a4j:outputPanel id="progressPanelSage">
                        <rich:progressBar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_currentValue}" style="width:90%" interval="300" enabled="true" minValue="-1" maxValue="100" id="barprgSage" mode="ajax" ajaxSingle="true" eventsQueue="maQueueProgress" limitToList="true" progressVar="progress" reRenderAfterComplete="panelImport,progressPanelSage">
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_info}" id="text"/>
                        </rich:progressBar>
                    </a4j:outputPanel>
                </a4j:form>
            </center>
    </rich:modalPanel>

</f:subview>
