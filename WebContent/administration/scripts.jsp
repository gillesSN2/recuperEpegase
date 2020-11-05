<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="sysScripts">

    <a4j:form id="formSysScripts" enctype="multipart/form-data">

        <center> <h2><h:outputText value="SCRIPTS AUTOMATIQUES" style="color:green;"/></h2></center>

        <h:panelGrid width="100%">

            <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabScripts" label="Scripts">
                    <h:panelGrid id="panelScripts" width="100%">
                        <h:panelGrid id="panelBouton" width="250px" columns="5">
                            <a4j:commandButton title="Ajouter un script" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.ajouterScripts}" reRender="panalScript"/>
                            <a4j:commandButton title="Dupliquer le script sélectionné" image="/images/duplicate.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.duppliquerScripts}" reRender="panalScript" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.afficheBoutons}"/>
                            <a4j:commandButton title="Modifier un script" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.modifierScripts}" reRender="panalScript" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.afficheBoutons}"/>
                            <a4j:commandButton title="Supprimer un script" image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.supprimerScripts}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer le script sélectionné ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableScripts,scrollTable,panelBouton" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.afficheBoutons}"/>
                            <h:commandButton title="Exécuter un script" image="/images/executer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.executerScriptsDirect}" onclick="if (!confirm('Etes-vous sur de vouloir exécuter le script sélectionné ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.afficheBoutons}"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableScripts"/>
                            <rich:extendedDataTable rows="100" style="max-height:100%" styleClass="bg" id="tableScripts" enableContextMenu="false" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.dataModelScripts}" var="script">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.selectionScript}" reRender="panelBouton"/>
                                <rich:column sortable="false" width="10%" sortBy="#{script.scrIdStructure}">
                                    <f:facet name="header" ><h:outputText value="Id Str"/></f:facet>
                                    <h:outputText value="#{script.scrIdStructure}"/>
                                </rich:column>
                                <rich:column sortable="false" width="30%" sortBy="#{script.scrNomStructure}">
                                    <f:facet name="header" ><h:outputText value="Nom Str"/></f:facet>
                                    <h:outputText value="#{script.scrNomStructure}"/>
                                </rich:column>
                                <rich:column sortable="false" width="30%" sortBy="#{script.libelleType}">
                                    <f:facet name="header" ><h:outputText value="Type"/></f:facet>
                                    <h:outputText value="#{script.libelleType}"/>
                                </rich:column>
                                <rich:column sortable="false" width="20%" sortBy="#{script.scrLibelle}" sortOrder="DESCENDING">
                                    <f:facet name="header" ><h:outputText value="Nom du script"/></f:facet>
                                    <h:outputText value="#{script.scrLibelle}"/>
                                </rich:column>
                                <rich:column sortable="false" width="20%" sortBy="#{script.scrMail}">
                                    <f:facet name="header" ><h:outputText value="Mail rapport"/></f:facet>
                                    <h:outputText value="#{script.scrMail}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

        </h:panelGrid>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panalScript" width="800" height="450" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.showModalPanelScripts}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.showModalPanelScripts}" var="scr" >
            <f:facet name="header"><h:outputText value="CONFIGURATION DES SCRIPTS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.fermerScripts}" image="/images/close.gif" styleClass="hidelink" reRender="panalScript,panelBouton"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid width="100%">
                    <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                        <rich:tab id="tabIdentification" label="Identification">
                            <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Nom structure"/></h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrIdStructure}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.mesStructuresItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Nom du script"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrLibelle}" style="width:100%"/></h:column>
                                <h:column><h:outputText value="Mail de rapport"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrMail}" style="width:100%"/></h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabPeriode" label="Période">
                            <h:panelGrid width="100%" columns="4" id="idTranche">
                                <h:column><h:outputText value="Valable du "/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrDateDebut}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="Au"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrDateFin}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="Lundi"/></h:column>
                                <h:column>
                                    <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrLundi}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="idTranche"/>
                                    </h:selectBooleanCheckbox>
                                </h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrHeureLundi}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrLundi}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.lesHeuresItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrMinuteLundi}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrLundi}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.lesMinutesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Mardi"/></h:column>
                                <h:column>
                                    <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrMardi}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="idTranche"/>
                                    </h:selectBooleanCheckbox>
                                </h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrHeureMardi}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrMardi}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.lesHeuresItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrMinuteMardi}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrMardi}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.lesMinutesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Mercredi"/></h:column>
                                <h:column>
                                    <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrMercredi}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="idTranche"/>
                                    </h:selectBooleanCheckbox>
                                </h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrHeureMercredi}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrMercredi}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.lesHeuresItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrMinuteMercredi}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrMercredi}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.lesMinutesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Jeudi"/></h:column>
                                <h:column>
                                    <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrJeudi}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="idTranche"/>
                                    </h:selectBooleanCheckbox>
                                </h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrHeureJeudi}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrJeudi}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.lesHeuresItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrMinuteJeudi}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrJeudi}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.lesMinutesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Vendredi"/></h:column>
                                <h:column>
                                    <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrVendredi}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="idTranche"/>
                                    </h:selectBooleanCheckbox>
                                </h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrHeureVendredi}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrVendredi}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.lesHeuresItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrMinuteVendredi}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrVendredi}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.lesMinutesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Samedi"/></h:column>
                                <h:column>
                                    <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrSamedi}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="idTranche"/>
                                    </h:selectBooleanCheckbox>
                                </h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrHeureSamedi}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrSamedi}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.lesHeuresItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrMinuteSamedi}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrSamedi}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.lesMinutesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Dimanche"/></h:column>
                                <h:column>
                                    <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrDimanche}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="idTranche"/>
                                    </h:selectBooleanCheckbox>
                                </h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrHeureDimanche}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrDimanche}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.lesHeuresItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrMinuteDimanche}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrDimanche}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.lesMinutesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabMethode" label="Méthode">
                            <h:panelGrid width="100%" columns="2" id="idType">
                                <h:column><h:outputText value="Type de script"/></h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType}" style="width:100%">
                                        <f:selectItem itemLabel="Sélectionnez type de script" itemValue="0"/>
                                        <f:selectItem itemLabel="Update BD vers serveur epegase (cloud)" itemValue="1"/>
                                        <f:selectItem itemLabel="Backup BD vers backup serveur epegase (Netissime cloud)" itemValue="2"/>
                                        <f:selectItem itemLabel="Backup BD vers backup serveur epegase (Kheweul cloud)" itemValue="21"/>
                                        <f:selectItem itemLabel="Update BD vers serveur personnel" itemValue="3" itemDisabled="true"/>
                                        <f:selectItem itemLabel="Backup BD vers disque local" itemValue="4"/>
                                        <f:selectItem itemLabel="Backup BD vers serveur FTP" itemValue="5"/>
                                        <f:selectItem itemLabel="Backup dossier Structure vers epegase (Netissime cloud)" itemValue="6"/>
                                        <f:selectItem itemLabel="Backup dossier Structure vers epegase (Kheweul cloud)" itemValue="22"/>
                                        <f:selectItem itemLabel="Backup dossier Structure vers disque local" itemValue="7"/>
                                        <f:selectItem itemLabel="Backup dossier Structure vers serveur FTP" itemValue="8"/>
                                        <f:selectItem itemLabel="Backup dossier GED vers epegase (Netissime cloud)" itemValue="9"/>
                                        <f:selectItem itemLabel="Backup dossier GED vers epegase (Kheweul cloud)" itemValue="23"/>
                                        <f:selectItem itemLabel="Backup dossier GED vers disque local" itemValue="10"/>
                                        <f:selectItem itemLabel="Backup dossier GED vers serveur FTP" itemValue="11"/>
                                        <f:selectItem itemLabel="Exécution méthode" itemValue="99" itemDisabled="true"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="idType"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==8||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==11}"><h:outputText value="Adresse URL (host) du backup"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==8||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==11}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrUrl}" style="width:100%"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==8||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==11}"><h:outputText value="Login"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==11}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrLogin}" style="width:100%"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==8||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==11}"><h:outputText value="Mot de passe"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==8||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==11}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrPw}" style="width:100%"/></h:column>
                                <h:column rendered="false"><h:outputText value="Dossier à sauvegarder"/></h:column>
                                <h:column rendered="false"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrDescription}" style="width:100%"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==4||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==7||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==8||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==10||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==11}"><h:outputText value="Chemin de sauvegarde"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==4||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==7||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==8||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==10||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==11}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrParametreChemin}" style="width:100%"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==99}"><h:outputText value="Méthode à exécuter"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrType==99}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrMethode}" style="width:100%"/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrId==0}"><h:outputText value="Créer le même script poir toutes les bases"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.scripts.scrId==0}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.allBases}"/></h:column>
                            </h:panelGrid>
                        </rich:tab>

                    </rich:tabPanel>
                    <br>
                    <h:panelGroup>
                        <center>
                            <h:commandButton id="idValide" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formBackupDatas.validerScripts}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </center>
                    </h:panelGroup>
                    <br>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>