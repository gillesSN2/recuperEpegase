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

        <center><h2><h:outputText value="LIAISON AVEC LA PAYE" styleClass="titre"/></h2></center>

        <br>
        <br>
        <br>
        <h:panelGroup id="grid">
            <center>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.var_choix_importation}">
                        <f:selectItem itemLabel="Choissisez le mode d'importation..." itemValue="0"/>
                        <f:selectItem itemLabel="Importation par fichier texte (CSV)" itemValue="1"/>
                        <f:selectItem itemLabel="Importation via serveur FTP" itemValue="2" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif==0}"/>
                        <f:selectItem itemLabel="Importation Salariés epegase" itemValue="3"/>
                        <f:selectItem itemLabel="Importation Elèves epegase" itemValue="4"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="grid"/>
                    </h:selectOneMenu>
                </h:column>
                <br>
                <br>
                <a4j:commandButton value="Information sur l'importation" title="Information" oncomplete="javascript:Richfaces.showModalPanel('panelInfo');" reRender="panelInfo" />
                <br>
                <br>
                <br>

                <rich:fileUpload id="upload" acceptedTypes="csv,CSV" ajaxSingle="false" progressLabel="true" addControlLabel="Ajouter fichier" uploadControlLabel="Importer" autoclear="true" noDuplicate="true" immediateUpload="false" maxFilesQuantity="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.uploadsAvailable}" listHeight="80px" fileUploadListener="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.listener}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.var_choix_importation==1}" >
                    <a4j:support event="onuploadcomplete" reRender="grid,idTransfert"/>
                </rich:fileUpload>
                <h:commandButton id="idTransfert" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:300px;" value="Visualisation transfert" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.var_choix_importation==1}"/>

                <h:commandButton style="color:white;background-color:green;margin:3px 3px 3px 3px;width:300px;" value="Importation à partir d'un site ftp" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.importFtp}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.var_choix_importation==2}"/>

                <h:commandButton style="color:white;background-color:green;margin:3px 3px 3px 3px;width:300px;" value="Importation à des salariés  d`epegase" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.importPayeePegase}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.var_choix_importation==3}"/>

                <h:commandButton style="color:white;background-color:green;margin:3px 3px 3px 3px;width:300px;" value="Importation à des élèves d`epegase" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.importEducationPegase}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.var_choix_importation==4}"/>

            </center>
        </h:panelGroup>
        <br>
        <br>
        <br>

    </h:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelInfo" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="700" height="600">
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

                    <rich:tab id="tabEmb" label="Importation Salariés Embauchés" >
                        <h:panelGrid width="100%">
                            <div style="text-align:justify;">
                                Il est constitué de 17 colonnes :<br>
                                <b></b> <br>
                                - colonne 01 : Matricule (20 caractères maximum) <br>
                                - colonne 02 : Nom (100 caractères maximun)<br>
                                - colonne 03 : Prénom (100 caractères maximun) <br>
                                - colonne 04 : Date de naissance (AAAA-MM-JJ) <br>
                                - colonne 05 : Genre (0=femme 1=homme) <br>
                                - colonne 06 : Etat (0=actif 1=inactif) <br>
                                - colonne 07 : Fonction (50 caractères maximun)<br>
                                - colonne 08 : Adresse (50 caractères maximun)<br>
                                - colonne 09 : Téléphone fixe (20 caractères maximum) <br>
                                - colonne 10 : Téléphone mobile (20 caractères maximum)<br>
                                - colonne 11 : Mail (50 caractères maximum)<br>
                                - colonne 12 : Site (20 caractères maximum)<br>
                                - colonne 13 : Département (20 caractères maximum)<br>
                                - colonne 14 : Service (20 caractères maximum)<br>
                                - colonne 15 : Equipe (20 caractères maximum)<br>
                                - colonne 16 : Date départ en congés (AAAA-MM-JJ)<br>
                                - colonne 17 : Date retour congés (AAAA-MM-JJ)<br><br>
                                Ce format est valable pour toutes les importations soit pas fichier direct soit par serveur FTP.<br>
                            </div>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabTmp" label="Importation Salariés Temporaires" >
                        <h:panelGrid width="100%">
                            <div style="text-align:justify;">
                                Il est constitué de 11 colonnes :<br>
                                <b></b> <br>
                                - colonne 01 : Matricule (20 caractères maximum) <br>
                                - colonne 02 : Nom (100 caractères maximun)<br>
                                - colonne 03 : Prénom (100 caractères maximun) <br>
                                - colonne 04 : Date de naissance (AAAA-MM-JJ) <br>
                                - colonne 05 : Genre (0=femme 1=homme) <br>
                                - colonne 06 : Etat (0=actif 1=inactif) <br>
                                - colonne 07 : Fonction (50 caractères maximun)<br>
                                - colonne 08 : Adresse (50 caractères maximun)<br>
                                - colonne 09 : Téléphone fixe (20 caractères maximum) <br>
                                - colonne 10 : Téléphone mobile (20 caractères maximum)<br>
                                - colonne 11 : Mail (50 caractères maximum)<br>
                                - colonne 12 : Site (20 caractères maximum)<br>
                                - colonne 13 : Département (20 caractères maximum)<br>
                                - colonne 14 : Service (20 caractères maximum)<br>
                                - colonne 15 : Equipe (20 caractères maximum)<br><br>
                                Ce format est valable pour toutes les importations soit pas fichier direct soit par serveur FTP.<br>
                            </div>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>


</f:subview>
