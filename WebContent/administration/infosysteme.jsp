<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="sysAdm">

    <a4j:form id="formSysAdm">

        <center>
            <h2>
                <h:outputText value="INFORMATIONS SYSTEMES" style="color:green;"/><br>
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.baseLog}" style="color:green;"/>
            </h2>
        </center>

        <h:panelGrid width="100%" border="0">
            <h:panelGrid id="p1" columnClasses="clos20,clos80" columns="2" width="100%" headerClass="headerTab">
                <f:facet name="header"><h:outputText value="Informations sur la société"/></f:facet>
                <h:column><h:outputText style="color:green;font-weight:bold;" value="ID:"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid}"/></h:column>
                <h:column><h:outputText style="color:green;font-weight:bold;" value="Structure:"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strraisonsociale}"/></h:column>
                <h:column><h:outputText style="color:green;font-weight:bold;" value="Langue:"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strlangue}"/></h:column>
                <h:column><h:outputText style="color:green;font-weight:bold;" value="Pays:"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strnompays}"/></h:column>
                <h:column><h:outputText style="color:green;font-weight:bold;" value="Code pays:"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays}"/></h:column>
                <h:column><h:outputText style="color:green;font-weight:bold;" value="Devise:"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}"/></h:column>
                <h:column><h:outputText style="color:green;font-weight:bold;" value="Format Devise:"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strformatdevise}"/></h:column>
                <h:column><h:outputText style="color:green;font-weight:bold;" value="Zone fiscale:"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonefiscale}"/></h:column>
                <h:column><h:outputText style="color:green;font-weight:bold;" value="Zone commerciale:"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonecommerciale}"/></h:column>
                <h:column><h:outputText style="color:green;font-weight:bold;" value="Mode fonctionnement:"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmode}" style="width:400px;" disabled="true">
                        <f:selectItem itemLabel="Full internet" itemValue="0"/>
                        <f:selectItem itemLabel="Full intranet" itemValue="1"/>
                        <f:selectItem itemLabel="Mixte" itemValue="2"/>
                        <f:selectItem itemLabel="Spécial" itemValue="3"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText style="color:green;font-weight:bold;" value="Url du navigateur:"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.urlDocument}"/></h:column>
            </h:panelGrid>
            <h:panelGrid id="p2" columnClasses="clos20,clos80" columns="2" width="100%" headerClass="headerTab" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmode!=0}">
                <f:facet name="header"><h:outputText value="Informations sur le serveur epegase"/></f:facet>
                <h:column><h:outputText style="color:green;font-weight:bold;" value="Adresse Serveur:"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.ipServeur}"/></h:column>
                <h:column><h:outputText style="color:green;font-weight:bold;" value="Version Serveur:"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.versionDistante}"/></h:column>
                <h:column><h:outputText style="color:green;font-weight:bold;" value="Date compilation Serveur:"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.dateVersionDistante}"/></h:column>
                <h:column><h:outputText style="color:green;font-weight:bold;" value="Plate-forme Serveur:"/></h:column>
                <h:column><h:outputText value="Linux"/></h:column>
            </h:panelGrid>
            <h:panelGrid id="p3" columnClasses="clos20,clos80" columns="2" width="100%" headerClass="headerTab">
                <f:facet name="header"><h:outputText value="Informations sur le serveur #{bakingbeanepegase.menuModuleHorizontalCtrl.choixServeur}"/></f:facet>
                <h:column><h:outputText style="color:green;font-weight:bold;" value="Adresse Serveur local:"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.urlIpProd}/"/></h:column>
                <h:column><h:outputText style="color:green;font-weight:bold;" value="Version locale installée:"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.versionLocale}"/></h:column>
                <h:column><h:outputText style="color:green;font-weight:bold;" value="Date compilation (locale):"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.dateVersionLocale}"/></h:column>
                <h:column><h:outputText style="color:green;font-weight:bold;" value="Plate-forme Local (JVM):"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.var_type_os_serveur_local}"/></h:column>
                <h:column><h:outputText style="color:green;font-weight:bold;" value="Connexion internet:"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif}" style="width:400px;" disabled="true">
                        <f:selectItem itemLabel="Sans détection internet" itemValue="0"/>
                        <f:selectItem itemLabel="Avec détection internet mais sans epegase.biz" itemValue="1"/>
                        <f:selectItem itemLabel="Avec détection internet et avec epegase.biz" itemValue="2"/>
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>
        </h:panelGrid>
        <br>
        <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

            <rich:tab id="listetable" label="Liste des tables">

                <a4j:commandButton value="Calcule nombre d'enregistrements de la base distante (Le temps de calcul peut etre long...)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formInfoSysteme.chargerListeTableDistant}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,table" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}"/>

                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable style="max-height:100%" styleClass="bg" id="table" enableContextMenu="false" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formInfoSysteme.datamodelTable}" var="table">
                        <rich:column sortable="false" width="20%" sortBy="#{table.module} #{table.nomTable}" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText value="Module"/></f:facet>
                            <h:outputText value="#{table.module}" style="#{table.styleCouleur}"/>
                        </rich:column>
                        <rich:column sortable="false" width="50%">
                            <f:facet name="header" ><h:outputText value="Nom table"/></f:facet>
                            <h:outputText value="#{table.nomTable}" style="#{table.styleCouleur}"/>
                        </rich:column>
                        <rich:column sortable="false" width="10%" style="text-align:right;">
                            <f:facet name="header" ><h:outputText value="Nb records"/></f:facet>
                            <h:outputText value="#{table.nbRecords}" style="#{table.styleCouleur}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column sortable="false" width="10%" style="text-align:right;">
                            <f:facet name="header" ><h:outputText value="Taille (Ko)"/></f:facet>
                            <h:outputText value="#{table.taille}" style="#{table.styleCouleur}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column sortable="false" width="10%" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}">
                            <f:facet name="header" ><h:outputText value="Base distante"/></f:facet>
                            <h:outputText value="#{table.nbRecordsDistant}" style="#{table.styleCouleur}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:tab>

            <rich:tab id="listedossier" label="Liste des dossiers">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable style="max-height:100%" styleClass="bg" id="tableDossier" enableContextMenu="false" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formInfoSysteme.datamodelDossier}" var="dos">
                        <rich:column sortable="false" width="20%" sortBy="#{dos.module} #{dos.nomTable}" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText value="Structure"/></f:facet>
                            <h:outputText value="#{dos.module}"/>
                        </rich:column>
                        <rich:column sortable="false" width="50%">
                            <f:facet name="header" ><h:outputText value="Nom dossier"/></f:facet>
                            <h:outputText value="#{dos.nomTable}"/>
                        </rich:column>
                        <rich:column sortable="false" width="10%" style="text-align:right;">
                            <f:facet name="header" ><h:outputText value="Nombre fichiers"/></f:facet>
                            <h:outputText value="#{dos.nbRecords}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column sortable="false" width="20%" style="text-align:right;">
                            <f:facet name="header" ><h:outputText value="Taille (Ko)"/></f:facet>
                            <h:outputText value="#{dos.taille}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:tab>

            <rich:tab id="synthese" label="Synthèse">
                <h:panelGrid width="400px" columns="2" columnClasses="clos50d,clos50d">
                    <h:outputText value="Total nombre fichiers:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formInfoSysteme.nombreFileTotal}"/>
                    <h:outputText value="Total occupation fichier (Ko):"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formInfoSysteme.tailleTotale}">
                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                    </h:outputText>
                    <h:outputText value="Total nombre tables:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formInfoSysteme.nombreTotalTable}"/>
                    <h:outputText value="Total nombre tables utilisées:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formInfoSysteme.nombreTable}"/>
                    <h:outputText value="Total occupation base (Ko):"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formInfoSysteme.tailleBase}">
                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                    </h:outputText>
                    <h:outputText value="Total général (Ko):"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formInfoSysteme.tailleGenerale}">
                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                    </h:outputText>
                </h:panelGrid>
            </rich:tab>

        </rich:tabPanel>
    </a4j:form>

</f:subview>