<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="fichesmission">

    <a4j:form>

        <center> <h2><h:outputText value="DETAIL DE LA MISSION" style="color:green;"/></h2></center>

        <h:panelGrid id="idPanGlobal" width="100%">

            <rich:tabPanel switchType="client" immediate="true"  id="tabPanelsalaries" style="border:0px;">

                <rich:tab name="mission" label="Mission" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_acc_identification}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.autorisationIdentification}" reRender="panDescription"/>
                    <h:panelGrid id="panDescription" width="100%">
                        <h:panelGrid width="100%">
                            <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" id="panelId1">
                                <h:column><h:outputText style="text-decoration:underline;" value="Mode:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misMode}">
                                        <f:selectItem itemLabel="Local" itemValue="0"/>
                                        <f:selectItem itemLabel="Etranger" itemValue="1"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.calculePays}" reRender="panelId1,idPays"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Nature:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misNature}">
                                        <f:selectItem itemLabel="Formations" itemValue="0"/>
                                        <f:selectItem itemLabel="Réunions" itemValue="1"/>
                                        <f:selectItem itemLabel="Séminaires" itemValue="2"/>
                                        <f:selectItem itemLabel="Terrains" itemValue="3"/>
                                        <f:selectItem itemLabel="Visites" itemValue="4"/>
                                        <f:selectItem itemLabel="Entretiens" itemValue="5"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="N° Mission:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misNum}" style="width:100%" disabled="true"/></h:column>
                                <h:column><h:outputText value="Etat:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misEtat}">
                                        <f:selectItem itemLabel="En cours" itemValue="0"/>
                                        <f:selectItem itemLabel="Approuvé" itemValue="1"/>
                                        <f:selectItem itemLabel="En exécution" itemValue="2"/>
                                        <f:selectItem itemLabel="Retour" itemValue="3"/>
                                        <f:selectItem itemLabel="Cloture" itemValue="4"/>
                                        <f:selectItem itemLabel="Annulé" itemValue="5"/>
                                        <f:selectItem itemLabel="Gelé" itemValue="6"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="tabPanelsalaries,idRetour,idFrais,retour,frais"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date Début (JJ/MM/AAAA):"/></h:column>
                                <h:column>
                                    <rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"    inputSize="8" locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misDateDebut}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_action==3}">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.calculeNbJoursTheo}" reRender="panelId1,idNbJours"/>
                                    </rich:calendar>
                                </h:column>
                                <h:column><h:outputText value="Date de fin (JJ/MM/AAAA):"/></h:column>
                                <h:column>
                                    <rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   inputSize="8"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misDateFin}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_action==3}">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.calculeNbJoursTheo}" reRender="panelId1,idNbJours"/>
                                    </rich:calendar>
                                </h:column>
                                <h:column><h:outputText value="Nb jour(s) théorique(s):"/></h:column>
                                <h:column>
                                    <h:inputText id="idNbJours" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misNbJourTheo}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_action==3}" readonly="true">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.calculeNbJoursTheo}" reRender="panelId1,idPerdiem"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Pays:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu  id="idPays" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misPays}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_action==3||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misMode==0}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.mesPaysItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Taux des Perdiems:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misPuPerdiem}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_action==3}">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.calculePerdiemTheo}" reRender="panelId1,idPerdiem"/>
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;<h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}"/>
                                    <br>
                                    (Cliquez  <A target="_blank" HREF="http://apps.who.int/bfi/tsy/PerDiem.aspx" TITLE="description" style="color:blue;"> ici </A>  pour la référence des Nations Unis).
                                </h:column>
                                <h:column><h:outputText value="Perdiem théorique:"/></h:column>
                                <h:column>
                                    <h:inputText id="idPerdiem" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misPerdiemTheo}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_action==3}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu  id="idActivite" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_action==3||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misMode==0}">
                                        <f:selectItem itemLabel="Sans Activité" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.mesActiviteItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Service:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu  id="idService" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misService}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_action==3||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misMode==0}">
                                        <f:selectItem itemLabel="Sans Service" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.mesServiceItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Budget:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu  id="idBuget" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misBudget}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_action==3||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misMode==0}">
                                        <f:selectItem itemLabel="Sans Budget" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.mesBudgetItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu  id="idResponsable" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_nom_responsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_action==3||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misMode==0}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.mesResponsablesItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" styleClass="fichefournisseur" columnClasses="clos15,clos85" width="100%" id="panelId2">
                                <h:column><h:outputText value="Objectif(s):"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misObjectif}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_action==3}"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid styleClass="fichefournisseur" headerClass="headerTab" width="100%" id="panelId3">
                                <f:facet name="header"><h:outputText value="Détail de la mission"/></f:facet>
                                <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misDetail}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_action==3}">
                                    <jsp:include flush="true" page="../css/tdt.jsp"/>
                                </rich:editor>
                            </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab name="ordremission" label="Ordre Mission" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_acc_complement}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.autorisationOrdreMission}" reRender="panOrdreMission"/>
                    <h:panelGrid id="panOrdreMission" width="100%">
                        <jsp:include flush="true" page="/paye/MissionsCommun.jsp"/>
                        <h:panelGrid width="100%">
                            <h:panelGrid styleClass="fichefournisseur" headerClass="headerTab" width="100%">
                                <f:facet name="header"><h:outputText value="Ordre de mission"/></f:facet>
                                <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misOrdreMission}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_action==3}">
                                    <jsp:include flush="true" page="../css/tdt.jsp"/>
                                </rich:editor>
                            </h:panelGrid>
                            <h:panelGrid styleClass="fichefournisseur" headerClass="headerTab" width="100%">
                                <f:facet name="header"><h:outputText value="Itinéraire"/></f:facet>
                                <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misItineraire}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_action==3}">
                                    <jsp:include flush="true" page="../css/tdt.jsp"/>
                                </rich:editor>
                            </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab name="agents" label="Agents" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_acc_complement}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.autorisationAgent}" reRender="panAgent"/>
                    <h:panelGrid id="panAgent" width="100%">
                        <jsp:include flush="true" page="/paye/MissionsCommun.jsp"/>
                        <h:panelGrid width="100%">
                            <h:panelGrid id="idBoutonAgent" width="200px" columns="3" style="height:34px">
                                <a4j:commandButton title="Ajouter un nouvel agent" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.ajouterSalaries}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelSalariesMissions"/>
                                <a4j:commandButton title="Modifier l'agent sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_affiche_agents&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.modifierSalaries}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelSalariesMissions"/>
                                <a4j:commandButton title="Supprimer l'agent sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_affiche_agents&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.supprimerSalaries}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente')" reRender="modAttente,tableSalariesMissions,idBoutonAgent"/>
                            </h:panelGrid>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable border="0" enableContextMenu="true" id="tableSalariesMissions" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.datamodelSalariesMissions}" var="sal">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.selectionAgent}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idBoutonAgent"/>
                                    <rich:column label="Matricule agent" sortable="true" width="90px" sortBy="#{sal.salaries.salMatricule}">
                                        <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                                        <h:outputText value="#{sal.salaries.salMatricule}"/>
                                    </rich:column>
                                    <rich:column label="Nom et prénom" sortable="true" width="300px" sortBy="#{sal.salaries.salNom}  #{sal.salaries.salPrenom}">
                                        <f:facet name="header"><h:outputText  value="Nom et prénom" /></f:facet>
                                        <h:outputText value="#{sal.salaries.salNom}  #{sal.salaries.salPrenom}"/>
                                    </rich:column>
                                    <rich:column label="Visa" sortable="true" width="90px" sortBy="#{sal.salmisVisa}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misMode==1}">
                                        <f:facet name="header"><h:outputText  value="Visa" /></f:facet>
                                        <h:outputText value="#{sal.salmisVisa}" style="text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Mode transport" sortable="true" width="100px" sortBy="#{sal.libTransport}">
                                        <f:facet name="header"><h:outputText  value="Mode" /></f:facet>
                                        <h:outputText value="#{sal.libTransport}"/>
                                    </rich:column>
                                    <rich:column label="Réservation hotel" sortable="true" width="70px" sortBy="#{sal.salmisResaHotel}">
                                        <f:facet name="header"><h:outputText  value="Résa." /></f:facet>
                                        <h:selectBooleanCheckbox value="#{sal.salmisResaHotel}"/>
                                    </rich:column>
                                    <rich:column label="Nom hotel" sortable="true" width="200px" sortBy="#{sal.salmisNomHotel}">
                                        <f:facet name="header"><h:outputText  value="Hotel" /></f:facet>
                                        <h:outputText value="#{sal.salmisNomHotel}"/>
                                    </rich:column>
                                    <rich:column label="Commentaires" sortable="true" width="200px" sortBy="#{sal.salmisObs}">
                                        <f:facet name="header"><h:outputText  value="Commentaire" /></f:facet>
                                        <h:outputText value="#{sal.salmisObs}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab name="retour" id="idRetour" label="Retour" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misEtat>=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_acc_familial}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.autorisationRetour}" reRender="panRetour"/>
                    <h:panelGrid id="panRetour" width="100%">
                        <jsp:include flush="true" page="/paye/MissionsCommun.jsp"/>
                        <h:panelGrid width="100%">
                            <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" id="panelId10">
                                <h:column><h:outputText value="Date Début réelle (JJ/MM/AAAA):"/></h:column>
                                <h:column>
                                    <rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   inputSize="8"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misDateDebutReel}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_action==3}">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.calculeNbJoursReel}" reRender="idNbJourReel,idPerdiemReel"/>
                                    </rich:calendar>
                                </h:column>
                                <h:column><h:outputText value="Date de fin réelle (JJ/MM/AAAA):"/></h:column>
                                <h:column>
                                    <rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"    inputSize="8" locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misDateFinReel}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_action==3}">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.calculeNbJoursReel}" reRender="idNbJourReel,idPerdiemReel"/>
                                    </rich:calendar>
                                </h:column>
                                <h:column><h:outputText value="Nb jour(s) réel(s):"/></h:column>
                                <h:column>
                                    <h:inputText id="idNbJourReel" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misNbJourReel}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_action==3}" readonly="true">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.calculeNbJoursReel}" reRender="idNbJourReel,idPerdiemReel"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Perdiem réel:"/></h:column>
                                <h:column>
                                    <h:inputText id="idPerdiemReel" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misPerdiemReel}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_action==3}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid styleClass="fichefournisseur" headerClass="headerTab" width="100%">
                                <f:facet name="header"><h:outputText value="Rapport de mission"/></f:facet>
                                <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misRapportMission}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_action==3}">
                                    <jsp:include flush="true" page="../css/tdt.jsp"/>
                                </rich:editor>
                            </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab name="frais" id="idFrais" label="Frais" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misEtat>=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_acc_familial}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.autorisationRetour}" reRender="panFrais"/>
                    <h:panelGrid id="panFrais" width="100%">
                        <jsp:include flush="true" page="/paye/MissionsCommun.jsp"/>
                        <h:panelGrid width="100%">
                            <h:panelGrid id="idBoutonFrais" width="200px" columns="3" style="height:34px">
                                <a4j:commandButton title="Ajouter un nouveau frais" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.ajouterFrais}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelSalariesFrais"/>
                                <a4j:commandButton title="Modifier le frais sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_affiche_frais&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.modifierFrais}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelSalariesFrais"/>
                                <a4j:commandButton title="Supprimer le frais sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_affiche_frais&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.supprimerFrais}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente')" reRender="modAttente,tableSalariesFrais,idBoutonFrais"/>
                            </h:panelGrid>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable groupingColumn="idSal" border="0" enableContextMenu="true" id="tableSalariesFrais" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.datamodelSalariesMissionsFrais}" var="fra">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.selectionFrais}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idBoutonFrais"/>
                                    <rich:column label="Matricule agent" sortable="true" width="90px" sortBy="#{fra.salaries.salMatricule}">
                                        <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                                        <h:outputText value="#{fra.salaries.salMatricule}"/>
                                    </rich:column>
                                    <rich:column id="idSal" label="Nom et prénom" sortable="true" width="300px" sortBy="#{fra.salaries.salNom}  #{fra.salaries.salPrenom}">
                                        <f:facet name="header"><h:outputText  value="Nom et prénom" /></f:facet>
                                        <h:outputText value="#{fra.salaries.salNom}  #{fra.salaries.salPrenom}"/>
                                    </rich:column>
                                    <rich:column label="Date du frais" sortable="true" width="90px" sortBy="#{fra.salmisfraDate}">
                                        <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                        <h:outputText value="#{fra.salmisfraDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Objet du frais" sortable="true" width="100px" sortBy="#{fra.salmisfraObjet}">
                                        <f:facet name="header"><h:outputText  value="Objet" /></f:facet>
                                        <h:outputText value="#{fra.salmisfraObjet}"/>
                                    </rich:column>
                                    <rich:column label="Type de frais" sortable="true" width="90px" sortBy="#{fra.lib_type}">
                                        <f:facet name="header"><h:outputText  value="Type" /></f:facet>
                                        <h:outputText value="#{fra.lib_type}"/>
                                    </rich:column>
                                    <rich:column label="Référence" sortable="true" width="200px" sortBy="#{fra.salmisfraReference}">
                                        <f:facet name="header"><h:outputText  value="Référence" /></f:facet>
                                        <h:outputText value="#{fra.salmisfraReference}"/>
                                    </rich:column>
                                    <rich:column label="Fournisseur" sortable="true" width="200px" sortBy="#{fra.salmisfraFournisseur}">
                                        <f:facet name="header"><h:outputText  value="Fournisseur" /></f:facet>
                                        <h:outputText value="#{fra.salmisfraFournisseur}"/>
                                    </rich:column>
                                    <rich:column label="Montant du frais" sortable="true" width="100px" sortBy="#{fra.salmisfraCout}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="Cout" /></f:facet>
                                        <h:outputText value="#{fra.salmisfraCout}" style="text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelValide">
                <center>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.annulerMissions}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.saveMissions}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_action!=3}"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelSalariesMissions" width="700" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.showModalPanelSalariesMissions}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.showModalPanelSalariesMissions}" var="smi">
            <f:facet name="header"><h:outputText value="GESTION DES AGENTS DE LA MISSION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanSalMis" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.fermerSalaries}" styleClass="hidelink" reRender="panelSalariesMissions"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanSalMis')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid style="width:100%;" id="panLigneGlob">
                    <h:panelGrid style="width:100%;" columns="2" columnClasses="clos30,clos70" styleClass="fichefournisseur">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salaries.salId==0}"><h:outputText value="Agent:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salaries.salId==0}">
                            <h:inputText id="idSalarie" style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.nomSalarie}">
                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les salariés (puis tabuler)" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.rechercheSalarie}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeAgents,formModalListeAgents,idSalarie,idValSalMis,panLigneGlob"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Nom Agent:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salaries.salNom}" readonly="true"/></h:column>
                    </h:panelGrid>

                    <rich:tabPanel switchType="client" immediate="true"  id="tabPanelsalaries" style="border:0px;">

                        <rich:tab name="depart" label="Départ" >
                            <h:panelGrid style="width:100%;" columns="2" columnClasses="clos30,clos70" styleClass="fichefournisseur" headerClass="headerTab">
                                <f:facet name="header"><h:outputText value="Elements de départ"/></f:facet>
                                <h:column><h:outputText value="Montant Perdiem Théo:"/></h:column>
                                <h:column>
                                    <h:inputText style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salariesMissions.salmisPerdiemTheo}" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misMode==1}"><h:outputText value="Montant Visa:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misMode==1}">
                                    <h:inputText style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salariesMissions.salmisVisa}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}"/>
                                </h:column>
                                <h:column><h:outputText value="Type Transport:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salariesMissions.salmisTypeTransport}">
                                        <f:selectItem itemLabel="Route" itemValue="0"/>
                                        <f:selectItem itemLabel="Train" itemValue="1"/>
                                        <f:selectItem itemLabel="Avion" itemValue="2"/>
                                        <f:selectItem itemLabel="Bateau" itemValue="3"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Réservation Hotel:"/></h:column>
                                <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salariesMissions.salmisResaHotel}"/></h:column>
                                <h:column><h:outputText value="Nom Hotel:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salariesMissions.salmisNomHotel}"/></h:column>
                                <h:column><h:outputText value="Mail Hotel:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salariesMissions.salmisMailHotel}"/></h:column>
                                <h:column><h:outputText value="Téléphone Hotel:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salariesMissions.salmisTelHotel}"/></h:column>
                                <h:column><h:outputText value="Chambre Hotel:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salariesMissions.salmisChambreHotel}"/></h:column>
                                <h:column><h:outputText value="Commentaires:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salariesMissions.salmisObs}"/></h:column>
                                <h:column><h:outputText value="Acompte versé:"/></h:column>
                                <h:column>
                                    <h:inputText style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salariesMissions.salmisAcompte}" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}"/>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab name="accompagnant" label="Accompagnant" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.missions.misMode==1}">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable border="0" enableContextMenu="true" id="tableSalariesFamille" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" height="300px" styleClass="bg" style="border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.dataModelAccompagnant}" var="fam">
                                    <rich:column label="Nature" sortable="true" width="25%" sortBy="#{fam.lib_nature}">
                                        <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                                        <h:outputText value="#{fam.lib_nature}"/>
                                    </rich:column>
                                    <rich:column label="Nom et prénom" sortable="true" width="50%" sortBy="#{fam.salgrhObjet}">
                                        <f:facet name="header"><h:outputText  value="Nom et prénom" /></f:facet>
                                        <h:outputText value="#{fam.salgrhObjet}"/>
                                    </rich:column>
                                    <rich:column label="Date naissance ou mariage" sortable="true" width="20%" sortBy="#{fam.salgrhDate}">
                                        <f:facet name="header"><h:outputText  value="Naissance/Mariage" /></f:facet>
                                        <h:outputText value="#{fam.salgrhDate}">
                                            <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Selection" sortable="true" width="5%" sortBy="#{fam.rhSelect}" style="text-align:center">
                                        <f:facet name="header"><h:outputText  value="Sel." /></f:facet>
                                        <h:selectBooleanCheckbox value="#{fam.rhSelect}" style="text-align:center"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </rich:tab>

                        <rich:tab name="retour" label="Retour" >
                            <h:panelGrid style="width:100%;" columns="2" columnClasses="clos30,clos70" styleClass="fichefournisseur" headerClass="headerTab">
                                <f:facet name="header"><h:outputText value="Elements de retour"/></f:facet>
                                <h:column><h:outputText value="Total Transport:"/></h:column>
                                <h:column>
                                    <h:inputText style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salariesMissions.salmisTitreTransport}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}"/>
                                </h:column>
                                <h:column><h:outputText value="Dépalcement domicile/(aéroport/port/gare):"/></h:column>
                                <h:column>
                                    <h:inputText style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salariesMissions.salmisDeplacement1}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}"/>
                                </h:column>
                                <h:column><h:outputText value="Dépalcement (aéroport/port/gare)/domicile:"/></h:column>
                                <h:column>
                                    <h:inputText style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salariesMissions.salmisDeplacement2}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}"/>
                                </h:column>
                                <h:column><h:outputText value="Total Hébergement:"/></h:column>
                                <h:column>
                                    <h:inputText style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salariesMissions.salmisHebergement}" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}"/>
                                </h:column>
                                <h:column><h:outputText value="Total Restauration:"/></h:column>
                                <h:column>
                                    <h:inputText style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salariesMissions.salmisRestauration}" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}"/>
                                </h:column>
                                <h:column><h:outputText value="Total Autres frais:"/></h:column>
                                <h:column>
                                    <h:inputText style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salariesMissions.salmisAutresFrais}" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}"/>
                                </h:column>
                                <h:column><h:outputText value="Total Perdiem Réel:"/></h:column>
                                <h:column>
                                    <h:inputText style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salariesMissions.salmisPerdiemReel}" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}"/>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                    </rich:tabPanel>
                    <h:panelGroup>
                        <br>
                        <center>
                            <a4j:commandButton id="idValSalMis" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.saveSalaries}" reRender="panelSalariesMissions,tableSalariesMissions,idBoutonAgent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salaries.salId!=0}"/>
                            <rich:hotKey key="return"  handler="#{rich:element('idValSalMis')}.click()" />
                        </center>
                    </h:panelGroup>

                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelSalariesFrais" width="700" height="350" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.showModalPanelSalariesMissionsFrais}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.showModalPanelSalariesMissionsFrais}" var="frs">
            <f:facet name="header"><h:outputText value="GESTION DES FRAIS DE LA MISSION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanSalFra" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.fermerFrais}" styleClass="hidelink" reRender="panelSalariesFrais"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanSalFra')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid style="width:100%;" id="panLigneGlob">
                    <h:panelGrid style="width:100%;" columns="2" columnClasses="clos30,clos70" styleClass="fichefournisseur" headerClass="headerTab">
                        <f:facet name="header"><h:outputText value="Elements de retour"/></f:facet>
                        <h:column><h:outputText value="Agent:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.nomSalarie}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.lesAgentsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Date du frais (JJ/MM/AAAA):"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salariesMissionsFrais.salmisfraDate}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Type de frais:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salariesMissionsFrais.salmisfraType}">
                                <f:selectItem itemLabel="Transport" itemValue="0"/>
                                <f:selectItem itemLabel="Hébergement" itemValue="1"/>
                                <f:selectItem itemLabel="Restauration" itemValue="2"/>
                                <f:selectItem itemLabel="Divers" itemValue="3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Objet:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salariesMissionsFrais.salmisfraObjet}"/></h:column>
                        <h:column><h:outputText value="Référence:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salariesMissionsFrais.salmisfraReference}"/></h:column>
                        <h:column><h:outputText value="Fournisseur:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salariesMissionsFrais.salmisfraFournisseur}"/></h:column>
                        <h:column><h:outputText value="Montant frais:"/></h:column>
                        <h:column>
                            <h:inputText style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.salariesMissionsFrais.salmisfraCout}" >
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}"/>
                        </h:column>
                    </h:panelGrid>

                    <h:panelGroup>
                        <br>
                        <center>
                            <a4j:commandButton id="idValSalFra" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.saveFrais}" reRender="panelSalariesFrais,tableSalariesFrais,idBoutonFrais"/>
                            <rich:hotKey key="return"  handler="#{rich:element('idValSalFra')}.click()" />
                        </center>
                    </h:panelGroup>

                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelListeAgents" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.showModalPanelAgents}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.showModalPanelAgents}" var="dst">
            <f:facet name="header"><h:outputText value="Sélection de l'agent"/></f:facet>
            <a4j:form id="formModalListeAgents">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableSalaries"/>
                    <rich:extendedDataTable rows="200" id="tableSalaries" footerClass="bard" headerClass="headerTab" styleClass="bg" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.dataModelLesSalaries}" var="sal">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.recuperationSalarie}" reRender="idVal"/>
                        <rich:column label="Service" sortable="true" sortBy="#{sal.salService}" width="15%">
                            <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                            <h:outputText value="#{sal.salService}"/>
                        </rich:column>
                        <rich:column label="Matricule" sortable="true" sortBy="#{sal.salMatricule}" width="10%">
                            <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                            <h:outputText value="#{sal.salMatricule}"/>
                        </rich:column>
                        <rich:column label="Raison sociale ou Nom" sortable="true" sortBy="#{sal.salNom}" width="45%">
                            <f:facet name="header"><h:outputText  value="Raison sociale" /></f:facet>
                            <h:outputText value="#{sal.salNom}"/>
                        </rich:column>
                        <rich:column label="Prénom" sortable="true" sortBy="#{sal.salPrenom}" width="20%">
                            <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                            <h:outputText value="#{sal.salPrenom}"/>
                        </rich:column>
                        <rich:column label="Civilité" sortable="true" sortBy="#{sal.salCivilite}" width="10%">
                            <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                            <h:outputText value="#{sal.salCivilite}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br>
                <h:panelGroup id="valagent">
                    <center>
                        <a4j:commandButton id="idCanAgent" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.annuleSalarie}" reRender="panelListeAgents,formModalListeAgents,idSalarie,idValSalMis"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValAgent" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.calculeSalarie}" reRender="panelListeAgents,formModalListeAgents,idSalarie,idValSalMis,panLigneGlob"/>
                    </center>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCanAgent')}.click()" />
                    <rich:hotKey key="return"  handler="#{rich:element('idValAgent')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
