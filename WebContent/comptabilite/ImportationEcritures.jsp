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

        <center><h2><h:outputText value="IMPORTATION ECRITURES COMPTABLES" styleClass="titre"/></h2></center>

        <br>
        <br>
        <br>
        <h:panelGroup id="grid">
            <center>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.var_choix_importation}">
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

                <rich:fileUpload id="upload1" acceptedTypes="csv,CSV" ajaxSingle="false" progressLabel="true" addControlLabel="Ajouter fichier" uploadControlLabel="Importer" autoclear="true" noDuplicate="true" immediateUpload="false" maxFilesQuantity="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.uploadsAvailable}" listHeight="80px" fileUploadListener="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.listener}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.var_choix_importation==1}" >
                    <a4j:support event="onuploadcomplete" reRender="grid,idTransfert"/>
                </rich:fileUpload>
                <rich:fileUpload id="upload2" acceptedTypes="xls,XLS" ajaxSingle="false" progressLabel="true" addControlLabel="Ajouter fichier" uploadControlLabel="Importer" autoclear="true" noDuplicate="true" immediateUpload="false" maxFilesQuantity="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.uploadsAvailable}" listHeight="80px" fileUploadListener="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.listener}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.var_choix_importation==2}" >
                    <a4j:support event="onuploadcomplete" reRender="grid,idTransfert"/>
                </rich:fileUpload>
                <h:commandButton id="idTransfert" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:300px;" value="Visualisation transfert" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.var_choix_importation==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.var_choix_importation==2}"/>

                <h:commandButton style="color:white;background-color:green;margin:3px 3px 3px 3px;width:300px;" value="Importation à  partir d'un site ftp" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.importFtp}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.var_choix_importation==3}"/>

            </center>
        </h:panelGroup>
        <br>
        <br>
        <br>

    </h:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelInfo" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="1100" height="600">
        <center>
            <f:facet name="header"><h:outputText value="Information sur l'importation" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelinkInfo"/>
                    <rich:componentControl for="panelInfo" attachTo="hidelinkInfo" operation="hide" event="onclick"/>
                </h:panelGroup>
            </f:facet>
            <a4j:form id="formModalInfo" >

                <div style="text-align:center;text-decoration:underline;">Le format CSV (comma-separated-values) ?
                </div>
                <br>
                <div style="text-align:justify;">Le format CSV (comma-separated-values) est un format de communication qui respecte la norme CSV décrite sous la référence <A target="_blank" HREF="http://tools.ietf.org/html/rfc4180" TITLE="description" style="color:blue;"> RFC 4180 </A>.
                    Le format de communication est donc le CSV et voici le détail de la structure du fichier. Chaque champ est séparé par une virgule et chaque enregistrement est terminé par un point-virgule puis par un retour chariot (car13).<br><br>
                </div>

                <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabEcr" label="Importation écritures (avec Anal.)" >
                        <h:panelGrid width="100%">
                            <div style="text-align:justify;">
                                Il est constitué de 22 colonnes au format CSV :<br>
                                <b></b> <br>
                                - colonne 01 : code journal (6 caractères maximum) <br>
                                - colonne 02 : date de l'écriture (AAAA-MM-JJ) <br>
                                - colonne 03 : numéro du compte (20 caractères maximun) <br>
                                - colonne 04 : numéro de la pièce (20 caractères maximun) <br>
                                - colonne 05 : référence 1 (30 caractères maximun) <br>
                                - colonne 06 : référence 2 (30 caractères maximun) <br>
                                - colonne 07 : montant débit (le séparateur de décimal est le .) <br>
                                - colonne 08 : montant crédit (le séparateur de décimal est le .) <br>
                                - colonne 09 : code du lettrage (4 caractères maximum) <br>
                                - colonne 10 : libellé de l'écriture (100 caractères maximum) <br>
                                - colonne 11 : date d'échéance (AAAA-MM-JJ) <br>
                                - colonne 12 : code activité (20 caractères maximum) <br>
                                - colonne 13 : code dossier (20 caractères maximum) <br>
                                - colonne 14 : code parc (20 caractères maximum) <br>
                                - colonne 15 : code site (20 caractères maximum) <br>
                                - colonne 16 : code département (20 caractères maximum) <br>
                                - colonne 17 : code service (20 caractères maximum) <br>
                                - colonne 18 : code région (20 caractères maximum) <br>
                                - colonne 19 : code secteur (20 caractères maximum) <br>
                                - colonne 20 : code point de vente (20 caractères maximum) <br>
                                - colonne 21 : code budget (20 caractères maximum) <br>
                                - colonne 22 : identification client (20 caractères maximum, pour des traitements spécifiques) <br><br>
                                Ce format est valable pour toutes les importations soit pas fichier direct soit par serveur FTP.<br>
                            </div>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabEcrLight1" label="Importation écritures (light1)">
                        <h:panelGrid width="100%">
                            <div style="text-align:justify;">
                                Il est constitué de 12 colonnes au format CSV:<br>
                                <b></b> <br>
                                - colonne 01 : code journal (6 caractères maximum) <br>
                                - colonne 02 : date de l'écriture (AAAA-MM-JJ) <br>
                                - colonne 03 : numéro du compte (20 caractères maximun) <br>
                                - colonne 04 : numéro du compte du tiers de SAGE (20 caractères maximun) <br>
                                - colonne 05 : numéro de la pièce (20 caractères maximun) <br>
                                - colonne 06 : référence 1 (30 caractères maximun) <br>
                                - colonne 07 : référence 2 (30 caractères maximun) <br>
                                - colonne 08 : montant débit (le séparateur de décimal est le .) <br>
                                - colonne 09 : montant crédit (le séparateur de décimal est le .) <br>
                                - colonne 10 : code du lettrage (4 caractères maximum) <br>
                                - colonne 11 : date d'échéance (AAAA-MM-JJ) <br>
                                - colonne 12 : libellé de l'écriture (100 caractères maximum) <br><br>
                                Ce format est valable pour toutes les importations soit pas fichier direct soit par serveur FTP.<br>
                            </div>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabEcrLight2" label="Importation écritures (light2)">
                        <h:panelGrid width="100%">
                            <div style="text-align:justify;">
                                Il est constitué de 10 colonnes au format CSV:<br>
                                <b></b> <br>
                                - colonne 01 : numéro du compte (20 caractères maximun) <br>
                                - colonne 02 : date de l'écriture (JJ/MM/AAAA) <br>
                                - colonne 03 : code journal (6 caractères maximum) <br>
                                - colonne 04 : montant débit (le séparateur de décimal est le .) <br>
                                - colonne 05 : montant crédit (le séparateur de décimal est le .) <br>
                                - colonne 06 : libellé de l'écriture (100 caractères maximum) <br>
                                - colonne 07 : numéro de la pièce (20 caractères maximun) <br>
                                - colonne 08 : date et heure création (JJ/MM/AAAA HH:MM) <br>
                                - colonne 09 : référence 1 (30 caractères maximun) <br>
                                - colonne 10 : 1 si débit 0 si crédit<br><br>
                                Ce format est valable pour toutes les importations soit pas fichier direct soit par serveur FTP.<br>
                            </div>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabEcrLight3" label="Importation écritures (light3)">
                        <h:panelGrid width="100%">
                            <div style="text-align:justify;">
                                Il est constitué de 9 colonnes au format XLS:<br>
                                <b></b> <br>
                                - colonne 01 : date de l'écriture (JJ/MM/AAAA) <br>
                                - colonne 02 : code journal (6 caractères maximum) <br>
                                - colonne 03 : numéro du compte (20 caractères maximun) <br>
                                - colonne 04 : numéro de la pièce (20 caractères maximun) <br>
                                - colonne 05 : libellé de l'écriture (100 caractères maximum) <br>
                                - colonne 06 : montant débit (le séparateur de décimal est le .) <br>
                                - colonne 07 : montant crédit (le séparateur de décimal est le .) <br>
                                - colonne 08 : analytique (activite1:montant1,activite2:montant2,...) <br>
                                - colonne 09 : lettrage (4 caractères maximun) <br><br>
                                Ce format est valable pour toutes les importations soit pas fichier direct soit par serveur FTP.<br>
                            </div>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabEcrSageExpert" label="Importation écritures SAGE EXPERT">
                        <h:panelGrid width="100%">
                            <div style="text-align:justify;">
                                Il est constitué de 18 colonnes au format CSV, issu de l'extraction FEC provenant de Sage Expert:<br>
                                <b></b> <br>
                                - colonne 01 : code journal (20 caractères maximun) <br>
                                - colonne 02 : libellé journal (100 caractères maximum) <br>
                                - colonne 03 : numéro écriture (20 caractères maximun)<br>
                                - colonne 04 : date de l'écriture (AAAAMMJJ) <br>
                                - colonne 05 : numéro de compte général (20 caractères maximun)<br>
                                - colonne 06 : libellé du compte général (100 caractères maximum) <br>
                                - colonne 07 : numéro compte de tiers (20 caractères maximun) <br>
                                - colonne 08 : libellé compte de tiers (100 caractères maximum) <br>
                                - colonne 09 : numéro de pièce (20 caractères maximun) <br>
                                - colonne 10 : Date de la pièce (AAAAMMJJ)<br>
                                - colonne 11 : libellé écriture (100 caractères)<br>
                                - colonne 12 : débit<br>
                                - colonne 13 : crédit<br>
                                - colonne 14 : Lettrage écriture<br>
                                - colonne 15 : Date du lettrage (AAAAMMJJ)<br>
                                - colonne 16 : date validation (AAAAMMJJ)<br>
                                - colonne 17 : montant en devise<br>
                                - colonne 18 : devise<br>
                                Ce format est valable pour toutes les importations soit pas fichier direct soit par serveur FTP.<br>
                            </div>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabEcrSage" label="Importation écritures SAGE (#MECG)">
                        <h:panelGrid width="100%">
                            <div style="text-align:justify;">
                                Il est constitué de 37 colonnes encapsulées dans un drapeau #MECG:<br>
                                <b></b> <br>
                                - colonne 01 : code journal (6 caractères maximum) <br>
                                - colonne 02 : date de l'écriture (JJMMAA) <br>
                                - colonne 03 : date de sasie (JJMMAA ou blanc) <br>
                                - colonne 04 : numéro de la pièce (20 caractères maximun) <br>
                                - colonne 05 : numéro de facture ou référence 1 (30 caractères maximun) <br>
                                - colonne 06 : numéro de la pièce de trésorerie (30 caractères maximun) <br>
                                - colonne 07 : numéro du compte général (20 caractères maximun) <br>
                                - colonne 08 : numéro du compte général contre partie (20 caractères maximun) <br>
                                - colonne 09 : numéro du compte du tiers (20 caractères maximun) <br>
                                - colonne 10 : numéro du compte du tiers de contre partie (20 caractères maximun) <br>
                                - colonne 11 : libellé de l'écriture (100 caractères maximum) <br>
                                - colonne 12 : numéro réglement (30 caractères maximun) <br>
                                - colonne 13 : date d'échéance (JJMMAA) <br>
                                - colonne 14 : parité (14 caractères) <br>
                                - colonne 15 : quantité (14 caractères) <br>
                                - colonne 16 : numéro de devise (2 caractères) <br>
                                - colonne 17 : sens (1 caractère) <br>
                                - colonne 18 : montant (le séparateur de décimal est le .) <br>
                                - colonne 19 : code du lettrage (3 caractères maximum) <br>
                                - colonne 20 : numéro lettre devise (3 caractères maximum) <br>
                                - colonne 21 : numéro pointage (3 caractères maximum) <br>
                                - colonne 22 : nombre de rappels (2 caractères maximum) <br>
                                - colonne 23 : type à nouveau (1 caractère1 maximum) <br>
                                - colonne 24 : type de revision (1 caractère maximum) <br>
                                - colonne 25 : montant devise (numerques) <br>
                                - colonne 26 : code taxe (5 caractères maximum) <br>
                                - colonne 27 : norme (1 caractère maximum) <br>
                                - colonne 28 : provenance (1 caractère maximum) <br>
                                - colonne 29 : type pénalités (1 caractère maximum) <br>
                                - colonne 30 : date pénalité (JJMMAA) <br>
                                - colonne 31 : date relance (JJMMAA) <br>
                                - colonne 32 : date rapprochment (JJMMAA) <br>
                                - colonne 33 : référence 2 (17 caractères) <br>
                                - colonne 34 : statut règlement (1 caractère) <br>
                                - colonne 35 : montant réglé (numérique) <br>
                                - colonne 36 : dernier règlement (JJMMAA ou blanc) <br>
                                - colonne 37 : date opération (JJMMAAou blanc) <br><br>
                                Ce format est valable pour toutes les importations soit pas fichier direct soit par serveur FTP.<br><br>
                                ==> métodologie pour importer les écritures SAGE à partir du fichier SAGE<br>
                                * renomer le fichier .TXT en .CSV<br>
                                * remplacer , par .<br>
                                * remplacer ø par .<br>
                                * remplacer ' par `<br>
                                * rempalcer les caractères accentués par les caractères non accentués<br>
                            </div>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabPlanComptableSage" label="Importation Plan comptable SAGE">
                        <h:panelGrid width="100%">
                            <div style="text-align:justify;">
                                Il est constitué de 21 colonnes encapsulées dans un drapeau #MPLG: <br>
                                <b></b> <br>
                                - colonne 01 : numéro de compte ou compte général (20 caractères maximum) <br>
                                - colonne 02 : numéro de commpte de tiers SAGE (20 caractères maximun) <br>
                                - colonne 03 : libellé du compte (100 caractères maximun) <br><br>
                                Ce format est valable pour toutes les importations soit pas fichier direct soit par serveur FTP.<br><br>
                                ==> métodologie pour importer le plan comptable SAGE à partir du fichier SAGE<br>
                                * renomer le fichier .TXT en .CSV<br>
                                * remplacer , par .<br>
                                * remplacer ø par .<br>
                                * remplacer ' par `<br>
                                * rempalcer les caractères accentués par les caractères non accentués<br>
                            </div>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabJournauxComptablesSage" label="Importation Journaux comptables SAGE">
                        <h:panelGrid width="100%">
                            <div style="text-align:justify;">
                                Il est constitué de 13 colonnes encapsulées dans un drapeau #MCJR: <br>
                                <b></b> <br>
                                - colonne 01 : code du journal (20 caractères maximum) <br>
                                - colonne 02 : libellé du journal (100 caractères maximun) <br>
                                - colonne 03 : compte de trésorerie (20 caractères maximun) <br><br>
                                Ce format est valable pour toutes les importations soit pas fichier direct soit par serveur FTP.<br><br>
                                ==> métodologie pour importer les journaux comptables SAGE à partir du fichier SAGE<br>
                                * renomer le fichier .TXT en .CSV<br>
                                * remplacer , par .<br>
                                * remplacer ø par .<br>
                                * remplacer ' par `<br>
                                * rempalcer les caractères accentués par les caractères non accentués<br>
                            </div>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabImmSage" label="Importation immobilisations SAGE (#IIMO)">
                        <h:panelGrid width="100%">
                            <div style="text-align:justify;">
                                Il est constitué de 117 colonnes encapsulées dans un drapeau #IIMO (mais 15 colonnes sont utiles):<br>
                                <b></b> <br>
                                - colonne 02 : code immobilisation <br>
                                - colonne 04 : intitulé <br>
                                - colonne 07 : lieu <br>
                                - colonne 09 : fournisseur <br>
                                - colonne 11 : numérode pièce <br>
                                - colonne 12 : valeur acquisition <br>
                                - colonne 13 : valeur résiduelle <br>
                                - colonne 14 : date acquisition <br>
                                - colonne 15 : date de mise en service <br>
                                - colonne 34 : compte immobilisation <br>
                                - colonne 35 : compte amortissement économique <br>
                                - colonne 36 : compte dotation économique <br>
                                - colonne 50 : mode amortissement économique <br>
                                - colonne 51 : nombre années économiques <br>
                                - colonne 104 : numéro immatriculation <br>
                                Ce format est valable pour toutes les importations soit pas fichier direct soit par serveur FTP.<br><br>
                                ==> métodologie pour importer les immobilisations SAGE à partir du fichier SAGE<br>
                                * renomer le fichier .TXT en .CSV<br>
                                * remplacer , par .<br>
                                * remplacer ø par .<br>
                                * remplacer ' par `<br>
                                * rempalcer les caractères accentués par les caractères non accentués<br>
                            </div>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabBal" label="Importation balances">
                        <h:panelGrid width="100%">
                            <div style="text-align:justify;">
                                Ce fichier peut être soit en CSV soit au format XLS<br>
                                Il est constitué de 08 colonnes :<br>
                                <b></b> <br>
                                - colonne 01 : numéro de compte (20 caractères maximum) <br>
                                - colonne 02 : libellé écriture (100 caractères maximun) <br>
                                - colonne 03 : montant débit AN (le séparateur de décimal est le .) <br>
                                - colonne 04 : montant crédit AN (le séparateur de décimal est le .) <br>
                                - colonne 05 : montant débit MVTS (le séparateur de décimal est le .) <br>
                                - colonne 06 : montant crédit MVTS (le séparateur de décimal est le .) <br>
                                - colonne 07 : montant débit SOLDE (le séparateur de décimal est le .) <br>
                                - colonne 08 : montant crédit SOLDE (le séparateur de décimal est le .) <br><br>
                                Ce format est valable pour toutes les importations soit pas fichier direct soit par serveur FTP.<br>
                            </div>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabPlanComptable" label="Importation Plan comptable">
                        <h:panelGrid width="100%">
                            <div style="text-align:justify;">
                                Il est constitué de 03 colonnes au format CSV :<br>
                                <b></b> <br>
                                - colonne 01 : numéro de compte ou compte général (20 caractères maximum) <br>
                                - colonne 02 : numéro de commpte de tiers SAGE (20 caractères maximun) <br>
                                - colonne 03 : libellé du compte (100 caractères maximun) <br><br>
                                Ce format est valable pour toutes les importations soit pas fichier direct soit par serveur FTP.<br>
                            </div>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabEcr5" label="Champs table Amortissement" >
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableDictionnaireAmortissement" style="border:solid 0px green;cursor:pointer;" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " selectionMode="single" border="0" width="100%" height="350px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.dataModelChampAmortissement}" var="dic1">
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

                </rich:tabPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>


</f:subview>
