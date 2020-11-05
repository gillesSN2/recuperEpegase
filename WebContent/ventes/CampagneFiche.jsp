<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="campagnefiche">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="GESTION DES CAMPAGNES" style="color:green;"/></h2></center>

        <h:panelGroup id="panelPage" >

            <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabDoc" label="Campagne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_acc_document}">
                    <h:panelGrid width="100%" columns="6" id="panelDate">
                        <h:column><h:outputText value="Date:"/></h:column>
                        <h:panelGrid width="100%" columns="4">
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_date}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateVte==0}">
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelValide,outptpanelTiers,link8Ajt,idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.controleSaisie}"/>
                            </rich:calendar>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_heure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}"  style="width:45px">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                            </h:selectOneMenu>
                            <h:column><h:outputText value=":"/></h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_minute}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}"  style="width:45px">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                        <h:column><h:outputText value="N°:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneEnteteVentes.camNum}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Type:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:30%" id="idType" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneEnteteVentes.camType}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}">
                                <f:selectItem itemLabel="Sur site" itemValue="0"/>
                                <f:selectItem itemLabel="Par Mail" itemValue="1"/>
                                <f:selectItem itemLabel="Par SMS" itemValue="2"/>
                                <f:selectItem itemLabel="Mail+SMS" itemValue="3"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelGlobal,tabMail,tabSms"/>
                            </h:selectOneMenu>&nbsp;&nbsp;
                            <h:outputText value="Série:" style="text-decoration:underline;"/>&nbsp;
                            <h:selectOneMenu style="width:30%" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneEnteteVentes.camSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneEnteteVentes.camId!=0}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.mesSerieUserItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid id="panelContact" width="100%" columns="4" >
                        <h:column><h:outputText value="Objet Campagne:"/></h:column>
                        <h:column>
                            <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneEnteteVentes.camObjet}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}" maxlength="50">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.verifValide}" reRender="panelValide"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Responsable Campagne:" style="text-decoration:underline;"/></h:column>
                        <h:column id="idResponsable">
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_nom_responsable}" disabled="#{(!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_verrou_comm||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action)==true}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.mesUsersItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid id="panelPeriode" width="100%" columns="6" >
                        <h:column><h:outputText value="Campagne Du:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneEnteteVentes.camDateDebut}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Au:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneEnteteVentes.camDateFin}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Budget Théorique:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneEnteteVentes.camTotBudget}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}" style="text-align:right">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}"/></h:column>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid id="panelDescriptif" width="100%" headerClass="headerTab">
                        <f:facet name="header"><h:outputText value="Description de la campagne"/></f:facet>
                        <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneEnteteVentes.camDescriptif}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}">
                            <jsp:include flush="true" page="../css/tdt.jsp"/>
                        </rich:editor>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabAction" label="Actions" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.visibleOnglet}">
                    <jsp:include flush="true" page="CampagneCommun.jsp"/>
                    <h:panelGrid id="panelBoutonAction" columns="4" width="300px" style="height:34px">
                        <a4j:commandButton title="Ajouter nouvelle action" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.ajouterAction}"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelAction"/>
                        <a4j:commandButton title="Modifier l'action sélectionnéé" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.visibiliteBtonActions&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.modifierAction}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelAction"/>
                        <a4j:commandButton title="Consulter l'action sélectionnée" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.visibiliteBtonActions}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.consulterAction}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelAction"/>
                        <a4j:commandButton title="Supprimer l'action sélectionnée" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.visibiliteBtonActions&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette action ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.supprimerAction}" reRender="modAttente,panelBoutonAction,tableAction,idResume"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableAction" maxPages="20" align="left" for="tableAction"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableAction" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.datamodelActions}" var="act">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.selectionAction}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBoutonAction"/>
                            <rich:column label="Date action" sortable="true" sortBy="#{act.camactDate}" width="10%">
                                <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                <h:outputText value="#{act.camactDate}">
                                    <f:convertDateTime pattern="dd/MM/yyyy" locale="fr"/>
                                </h:outputText>
                            </rich:column>   
                            <rich:column label="Définition action" sortable="true" sortBy="#{act.camactAction}" width="30%">
                                <f:facet name="header"><h:outputText  value="Définition Action "/></f:facet>
                                <h:outputText value="#{act.camactAction}"/>
                            </rich:column>
                            <rich:column label="Personne concernée action" sortable="true" sortBy="#{act.camactNomCommercial}" width="30%">
                                <f:facet name="header"><h:outputText  value="Action faite par"/></f:facet>
                                <h:outputText value="#{act.camactNomCommercial}"/>
                            </rich:column>
                            <rich:column label="Deadline action" sortable="true" sortBy="#{act.camactDateFin}" width="10%">
                                <f:facet name="header"><h:outputText  value="Deadline"/></f:facet>
                                <h:outputText value="#{act.camactDateFin}">
                                    <f:convertDateTime pattern="dd/MM/yyyy" locale="fr"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Résultat action" sortable="true" sortBy="#{act.libelleResultat}" width="10%">
                                <f:facet name="header"><h:outputText  value="Résultat"/></f:facet>
                                <h:outputText value="#{act.libelleResultat}"/>
                            </rich:column>
                            <rich:column label="Suite action" sortable="true" sortBy="#{act.camactSuite}" width="10%">
                                <f:facet name="header"><h:outputText  value="Suite"/></f:facet>
                                <h:outputText value="#{act.camactSuite}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab id="tabDepenses" label="Dépenses" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.visibleOnglet}">
                    <jsp:include flush="true" page="CampagneCommun.jsp"/>
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableDepense" maxPages="20"align="left" for="tableDepense"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableDepense" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.dataModelDepenses}" var="dep">
                            <rich:column label="Nature" sortable="true" sortBy="#{dep.var_lib_nat}" width="100px">
                                <f:facet name="header"><h:outputText  value="Nature"/></f:facet>
                                <h:outputText value="#{dep.var_lib_nat}"/>
                            </rich:column>
                            <rich:column label="N° document" sortable="true" sortBy="#{dep.docNum}" width="100px">
                                <f:facet name="header"><h:outputText  value="N°"/></f:facet>
                                <h:outputText value="#{dep.docNum}"/>
                            </rich:column>
                            <rich:column label="Date Document" sortable="true" sortBy="#{dep.docDate} #{dep.docNum}" width="100px">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{dep.docDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{dep.docEtat}" width="50px" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                <h:outputText value="#{dep.libelleEta}"/>
                            </rich:column>
                            <rich:column label="Tiers" sortable="true" sortBy="#{dep.docNomTiers}" width="200px">
                                <f:facet name="header"><h:outputText  value="Tiers"/></f:facet>
                                <h:outputText  value="#{dep.docNomTiers}"/>
                            </rich:column>
                            <rich:column label="Objet" sortable="true" sortBy="#{dep.docObject}" width="200px">
                                <f:facet name="header"><h:outputText  value="Objet"/></f:facet>
                                <h:outputText  value="#{dep.docObject}"/>
                            </rich:column>
                            <rich:column label="Total HT" sortable="true" sortBy="#{dep.docTotHt}" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="H.T."/></f:facet>
                                <h:outputText  value="#{dep.docTotHt}" rendered="#{dep.docTotHt!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Total TVA" sortable="true" sortBy="#{dep.docTotTva}" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="T.V.A."/></f:facet>
                                <h:outputText  value="#{dep.docTotTva}" rendered="#{dep.docTotTva!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Total TTC" sortable="true" sortBy="#{dep.docTotTtc}" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="T.T.C."/></f:facet>
                                <h:outputText  value="#{dep.docTotTtc}" rendered="#{dep.docTotTtc!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Réglement" sortable="true" sortBy="#{dep.docTotReglement}" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Réglement"/></f:facet>
                                <h:outputText  value="#{dep.docTotReglement}" rendered="#{dep.docTotReglement!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <h:panelGrid width="" columns="2">
                        <h:column><h:outputText value="Total dépense:"/></h:column>
                        <h:column>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.totalDepenses}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>&nbsp;&nbsp;&nbsp;&nbsp;
                            <h:outputText value="(Dépenses = Factures + Notes débit - Avoirs)"/>
                        </h:column>
                        <h:column><h:outputText value="Documents analysés:"/></h:column>
                        <h:column><h:outputText value="Cotations, Commandes, Réceptions, Factures, Notes débit, Avoirs"/></h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabRecettes" label="Recettes" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.visibleOnglet}">
                    <jsp:include flush="true" page="CampagneCommun.jsp"/>
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableRecette" maxPages="20"align="left" for="tableRecette"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableRecette" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.dataModelRecettes}" var="rec">
                            <rich:column label="Nature" sortable="true" sortBy="#{rec.var_lib_nat}" width="100px">
                                <f:facet name="header"><h:outputText  value="Nature"/></f:facet>
                                <h:outputText value="#{rec.var_lib_nat}"/>
                            </rich:column>
                            <rich:column label="N° document" sortable="true" sortBy="#{rec.docNum}" width="100px">
                                <f:facet name="header"><h:outputText  value="N°"/></f:facet>
                                <h:outputText value="#{rec.docNum}"/>
                            </rich:column>
                            <rich:column label="Date Document" sortable="true" sortBy="#{rec.docDate} #{rec.docNum}" width="100px">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{rec.docDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{rec.docEtat}" width="50px" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                <h:outputText value="#{rec.libelleEta}"/>
                            </rich:column>
                            <rich:column label="Tiers" sortable="true" sortBy="#{rec.docNomTiers}" width="200px">
                                <f:facet name="header"><h:outputText  value="Tiers"/></f:facet>
                                <h:outputText  value="#{rec.docNomTiers}"/>
                            </rich:column>
                            <rich:column label="Contact" sortable="true" sortBy="#{rec.docNomContact}" width="200px">
                                <f:facet name="header"><h:outputText  value="Contact"/></f:facet>
                                <h:outputText  value="#{rec.docNomContact}"/>
                            </rich:column>
                            <rich:column label="Total HT" sortable="true" sortBy="#{rec.docTotHt}" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="H.T."/></f:facet>
                                <h:outputText  value="#{rec.docTotHt}" rendered="#{rec.docTotHt!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Total TVA" sortable="true" sortBy="#{rec.docTotTva}" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="T.V.A."/></f:facet>
                                <h:outputText  value="#{rec.docTotTva}" rendered="#{rec.docTotTva!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Total TTC" sortable="true" sortBy="#{rec.docTotTtc}" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="T.T.C."/></f:facet>
                                <h:outputText  value="#{rec.docTotTtc}" rendered="#{rec.docTotTtc!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Réglement" sortable="true" sortBy="#{dep.docTotReglement}" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Réglement"/></f:facet>
                                <h:outputText  value="#{dep.docTotReglement}" rendered="#{dep.docTotReglement!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <h:panelGrid width="" columns="2">
                        <h:column><h:outputText value="Total recette:"/></h:column>
                        <h:column>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.totalRecettes}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>&nbsp;&nbsp;&nbsp;&nbsp;
                            <h:outputText value="(Recettes = Factures + Notes débit - Avoirs)"/>
                        </h:column>
                        <h:column><h:outputText value="Documents analysés:"/></h:column>
                        <h:column><h:outputText value="Devis, Commandes, Livraisons, Factures, Notes débit, Avoirs"/></h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabParticipants" label="Participants" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.visibleOnglet}">
                    <jsp:include flush="true" page="CampagneCommun.jsp"/>
                    <h:panelGrid id="panelBoutonParticipant" columns="6" width="300px" style="height:34px">
                        <a4j:commandButton title="Ajouter nouveau participant individuel" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.ajouterParticipant}"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelParticipant"/>
                        <a4j:commandButton title="Ajouter groupe de participants" image="/images/groupes.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.ajouterGroupe}"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGroupe"/>
                        <a4j:commandButton title="Modifier le participant sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.visibiliteBtonParticipant&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.modifierParticipant}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelParticipant"/>
                        <a4j:commandButton title="Consulter le participant sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.visibiliteBtonParticipant}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.consulterParticipant}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelParticipant"/>
                        <a4j:commandButton title="Supprimer le participant sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.visibiliteBtonParticipant&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce participant ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.supprimerParticipant}" reRender="modAttente,panelBoutonParticipant,tableParticipant,idResume"/>
                        <a4j:commandButton title="Effacer la liste des participants" image="/images/annuler_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.visibiliteBtonParticipant&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer la liste des participants ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.supprimerGroupeParticipant}" reRender="modAttente,panelBoutonParticipant,tableParticipant,idResume"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableParticipant" maxPages="20" align="left" for="tableParticipant"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableParticipant" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.dataModelParticipants}" var="par">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.selectionParticipant}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBoutonParticipant"/>
                            <rich:column label="Date visite" sortable="true" sortBy="#{par.camparDate}" width="10%">
                                <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                <h:outputText value="#{par.camparDate}">
                                    <f:convertDateTime pattern="dd/MM/yy HH:mm" locale="fr"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Structure" sortable="true" sortBy="#{par.camparNomTiers}" width="20%">
                                <f:facet name="header"><h:outputText  value="Structure"/></f:facet>
                                <h:outputText value="#{par.camparNomTiers}"/>
                            </rich:column>
                            <rich:column label="Nom prénom du participant" sortable="true" sortBy="#{par.contacts.conpatronyme}" width="20%">
                                <f:facet name="header"><h:outputText  value="Nom et prénom"/></f:facet>
                                <h:outputText value="#{par.contacts.conpatronyme}"/>
                            </rich:column>
                            <rich:column label="Fonction" sortable="true" sortBy="#{par.contacts.confonction}" width="10%">
                                <f:facet name="header"><h:outputText  value="Fonction"/></f:facet>
                                <h:outputText  value="#{par.contacts.confonction}"/>
                            </rich:column>
                            <rich:column label="Téléphone" sortable="true" sortBy="#{par.contacts.concel1}" width="10%">
                                <f:facet name="header"><h:outputText  value="Téléphne"/></f:facet>
                                <h:outputText  value="#{par.contacts.concel1}"/>
                            </rich:column>
                            <rich:column label="eMail" sortable="true" sortBy="#{par.contacts.mailCumul}" width="15%">
                                <f:facet name="header"><h:outputText  value="eMail"/></f:facet>
                                <h:outputText  value="#{par.contacts.mailCumul}"/>
                            </rich:column>
                            <rich:column label="Commercial à origine de l'invitation" sortable="true" sortBy="#{par.camparNomCommercial}" width="15%">
                                <f:facet name="header"><h:outputText  value="Commercial"/></f:facet>
                                <h:outputText  value="#{par.camparNomCommercial}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab id="tabMail" label="Mails" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.visibleOnglet&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneEnteteVentes.camType==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneEnteteVentes.camType==3)}">
                    <jsp:include flush="true" page="CampagneCommun.jsp"/>
                    <h:panelGrid id="panelBoutonMail" columns="5" width="250px" style="height:34px">
                        <a4j:commandButton title="Ajouter nouveau mail" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.ajouterMail}"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelMail"/>
                        <a4j:commandButton title="Modifier le mail sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.visibiliteBtonMail&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneMessageVentesMail.cammesEtat==0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.modifierMail}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelMail"/>
                        <a4j:commandButton title="Consulter le mail sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.visibiliteBtonMail}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.consulterMail}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelMail"/>
                        <a4j:commandButton title="Supprimer le mail sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.visibiliteBtonMail&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneMessageVentesMail.cammesEtat==0}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce mail ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.supprimerMail}" reRender="modAttente,panelBoutonMail,tableMail,tableRepartition"/>
                        <a4j:commandButton title="Envoyer le mail sélectionné" image="/images/mail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.visibiliteBtonMail&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneMessageVentesMail.cammesEtat==0}" onclick="if (!confirm('Etes-vous sur de vouloir envoyer ce mail à tous les participants?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.envoyerMail}" reRender="modAttente,panelBoutonMail,tableMail"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" id="scrollTableMail" maxPages="20" align="left" for="tableMail"/>
                        <rich:extendedDataTable rows="100" style="max-height:100%;" styleClass="bg" id="tableMail" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.dataModelMail}" var="mai">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.selectionMail}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBoutonMail"/>
                            <rich:column label="Etat" sortable="true" sortBy="#{mai.libelleEtat}" width="8%">
                                <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                <h:outputText value="#{mai.libelleEtat}"/>
                            </rich:column>
                            <rich:column label="Date" sortable="true" sortBy="#{mai.cammesDate}" width="15%">
                                <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                <h:outputText value="#{mai.cammesDate}">
                                    <f:convertDateTime pattern="dd/MM/yy HH:mm" locale="fr"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Descriptif" sortable="true" sortBy="#{mai.cammesDescriptif}" width="20%">
                                <f:facet name="header"><h:outputText  value="Descriptif"/></f:facet>
                                <h:outputText value="#{mai.cammesDescriptif}"/>
                            </rich:column>
                            <rich:column label="Objet" sortable="true" sortBy="#{mai.cammesObjet}" width="20%">
                                <f:facet name="header"><h:outputText  value="Objet"/></f:facet>
                                <h:outputText value="#{mai.cammesObjet}"/>
                            </rich:column>
                            <rich:column label="Contemnu du mail" sortable="true" sortBy="#{mai.cammesMessage}" width="37%">
                                <f:facet name="header"><h:outputText  value="Mail"/></f:facet>
                                <h:outputText value="#{mai.cammesMessage}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab id="tabSms" label="Sms" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.visibleOnglet&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneEnteteVentes.camType==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneEnteteVentes.camType==3)}">
                    <jsp:include flush="true" page="CampagneCommun.jsp"/>
                    <h:panelGrid id="panelBoutonSms" columns="5" width="250px" style="height:34px">
                        <a4j:commandButton title="Ajouter nouvel sms" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.ajouterSms}"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelSms"/>
                        <a4j:commandButton title="Modifier le sms sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.visibiliteBtonSms&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneMessageVentesSms.cammesEtat==0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.modifierSms}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelSms"/>
                        <a4j:commandButton title="Consulter le sms sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.visibiliteBtonSms}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.consulterSms}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelSms"/>
                        <a4j:commandButton title="Supprimer le sms sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.visibiliteBtonMail&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneMessageVentesSms.cammesEtat==0}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce sms ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.supprimerSms}" reRender="modAttente,panelBoutonSms,tableSms"/>
                        <a4j:commandButton title="Envoyer le sms sélectionné" image="/images/sms.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.visibiliteBtonSms&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneMessageVentesSms.cammesEtat==0}" onclick="if (!confirm('Etes-vous sur de vouloir envoyer cet sms à tous les participants?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.envoyerSms}" reRender="modAttente,panelBoutonSms,tableSms"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" id="scrollTableSms" maxPages="20" align="left" for="tableSms"/>
                        <rich:extendedDataTable rows="100" style="max-height:100%;" styleClass="bg" id="tableSms" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.dataModelSms}" var="sms">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.selectionSms}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBoutonSms"/>
                            <rich:column label="Etat" sortable="true" sortBy="#{sms.libelleEtat}" width="8%">
                                <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                <h:outputText value="#{sms.libelleEtat}"/>
                            </rich:column>
                            <rich:column label="Date" sortable="true" sortBy="#{sms.cammesDate}" width="15%">
                                <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                <h:outputText value="#{sms.cammesDate}">
                                    <f:convertDateTime pattern="dd/MM/yy HH:mm" locale="fr"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Descriptif" sortable="true" sortBy="#{sms.cammesDescriptif}" width="20%">
                                <f:facet name="header"><h:outputText  value="Descriptif"/></f:facet>
                                <h:outputText value="#{sms.cammesDescriptif}"/>
                            </rich:column>
                            <rich:column label="Texte du sms" sortable="true" sortBy="#{sms.cammesMessage}" width="57%">
                                <f:facet name="header"><h:outputText  value="Message"/></f:facet>
                                <h:outputText value="#{sms.cammesMessage}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab id="tabResume" label="Résumé" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.visibleOnglet}">
                    <jsp:include flush="true" page="CampagneCommun.jsp"/>
                    <h:panelGrid width="50%" columns="2" style="text-align:right;" id="idResume">
                        <h:column><h:outputText value="Nombre participants:"/></h:column>
                        <h:column>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.nbParticipants}" style="text-align:right;">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </h:column>
                        <h:column><h:outputText value="Budget théorique:"/></h:column>
                        <h:column>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneEnteteVentes.camTotBudget}" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </h:column>
                        <h:column><h:outputText value="Dépenses réelles:"/></h:column>
                        <h:column>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.totalDepenses}" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </h:column>
                        <h:column><h:outputText value="Ecarts sur Dépenses:"/></h:column>
                        <h:column>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.totalEcartBudget}" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </h:column>
                        <h:column><h:outputText value="Total recettes:"/></h:column>
                        <h:column>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.totalRecettes}" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </h:column>
                        <h:column><h:outputText value="Marge campagne:"/></h:column>
                        <h:column>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.totalMarge}" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </h:column>
                        <h:column><h:outputText value="% par commercial:"/></h:column>
                        <h:column>
                            <rich:extendedDataTable rows="100" styleClass="bg" id="tableRepartition" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.resumeCommercial}" var="res">
                                <rich:column label="Commercial" sortable="true" sortBy="#{res.nomSerie}" width="60%" style="text-align:left">
                                    <f:facet name="header"><h:outputText  value="Commercial"/></f:facet>
                                    <h:outputText value="#{res.nomSerie}" style="text-align:left"/>
                                </rich:column>
                                <rich:column label="Nombre de participants" sortable="true" sortBy="#{res.v02}" width="20%">
                                    <f:facet name="header"><h:outputText  value="Nb Part."/></f:facet>
                                    <h:outputText value="#{res.v02}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Pourcentage" sortable="true" sortBy="#{res.vpourcent}" width="20%" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="%"/></f:facet>
                                    <h:outputText value="#{res.vpourcent}"  style="text-align:right">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </h:column>
                        <h:column><h:outputText value="Etat campagne:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneEnteteVentes.camEtat}" style="width:200px">
                                <f:selectItem itemLabel="En cours" itemValue="0"/>
                                <f:selectItem itemLabel="Validé" itemValue="1"/>
                                <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                <f:selectItem itemLabel="Terminé" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.clotureCampagne}" reRender="idSubView,idEtat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelValide">
                <center>
                    <br><br>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.annuleDocument}"  />&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.save}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </center>
            </h:panelGroup>

        </h:panelGroup>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelParticipant" width="900" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.showModalPanelParticipant}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.showModalPanelParticipant}" var="ser">
            <f:facet name="header"><h:outputText value="Participant"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.fermerParticipant}" image="/images/close.gif" styleClass="hidelink" reRender="panelParticipant"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:tabPanel switchType="client" immediate="true" id="panelGlobalVisite" style="border:0px;background-color:white;">

                    <rich:tab id="tabDoc" label="Visite">
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70" styleClass="fichefournisseur">
                            <h:column><h:outputText value="Nom contact:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:inputText style="width:90%" id="idContact" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_participant}" maxlength="100">
                                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients (puis tabuler)" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.rechercheContacts}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeContacts,formModalListeContacts"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Société:"/></h:column>
                            <h:column><h:inputText style="width:90%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneParticipantVentes.camparNomTiers}" readonly="true"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70" styleClass="fichefournisseur">
                            <h:column><h:outputText value="Commercial (qui a invité):"/></h:column>
                            <h:selectOneMenu style="width:90%" id="idComInvite" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneParticipantVentes.camparIdCommercial}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.mesPersonnelsItem}"/>
                            </h:selectOneMenu>
                            <h:column><h:outputText value="Date visite:"/></h:column>
                            <h:panelGrid width="50%" columns="5">
                                <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_date}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}">
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelValide,outptpanelTiers,link8Ajt,idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.controleSaisie}"/>
                                </rich:calendar>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_heure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}" style="width:50px">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                </h:selectOneMenu>
                                <h:column><h:outputText value=":"/></h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_minute}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}" style="width:50px">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                                </h:selectOneMenu>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabLivre" label="Livre d'or">
                        <h:panelGrid id="panelLivre" width="100%" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Livre d'or"/></f:facet>
                            <h:column><h:inputTextarea rows="20" cols="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneParticipantVentes.camparCommentaire}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabAction" label="Actions à faire">
                        <h:panelGrid id="panelAction" width="100%" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Action à faire"/></f:facet>
                            <h:column><h:inputTextarea rows="20" cols="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneParticipantVentes.camparAction}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabCadeaux" label="Cadeaux">
                        <h:panelGrid id="panelCadeaux" width="100%" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Cadeaux effectués"/></f:facet>
                            <h:column><h:inputTextarea rows="20" cols="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneParticipantVentes.camparCadeau}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>
                <h:panelGroup id="idValide">
                    <center>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.validerParticipant}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panelParticipant,scrollTableParticipant,tableParticipant,panelBoutonParticipant,idResume,tableRepartition"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelGroupe" width="1200" height="520" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.showModalPanelGroupe}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.showModalPanelGroupe}" var="grp">
            <f:facet name="header"><h:outputText value="Recherche groupes de participants"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.fermerParticipant}" image="/images/close.gif" styleClass="hidelink" reRender="panelGroupe"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" id="idPanlGlob">
                    <h:panelGrid  columns="7" width="100%" styleClass="recherche" id="idButton">
                        <h:column><h:outputText value="Société:"/></h:column>
                        <h:column><h:inputText style="width:150px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.nomRec}" /></h:column>
                        <h:column><h:outputText value="Ville:"/></h:column>
                        <h:column><h:inputText style="width:150px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.villeRec}"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="paysItem" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.paysRec}" style="width:130px;">
                                <f:selectItem  itemLabel="Tous pays" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.mesPaysItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="aciviteItem" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.activitesRec}"  style="width:130px;">
                                <f:selectItem  itemLabel="Toutes activités" itemValue="100"/>
                                <f:selectItem  itemLabel="Sans activité" itemValue="****"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.mesActivitesSocietesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="obsItem" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.observationsRec}"  style="width:130px;">
                                <f:selectItem  itemLabel="Toutes observations" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.mesObservationsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="appreciationItem" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.appreciationRec}" style="width:130px;">
                                <f:selectItem itemLabel="Toutes appréciations" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.mesAppreciationsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="categorieItem" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.categorieRec}" style="width:130px;">
                                <f:selectItem itemLabel="Toutes catégories" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.mesCategoriesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="familleItem2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.familleRec}" style="width:130px;">
                                <f:selectItem itemLabel="Toutes familles" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFamilleClientsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="pdvItem" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.pdvRec}"  style="width:130px;">
                                <f:selectItem  itemLabel="Tous PDV" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesPdvItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="eMail:"/></h:column>
                        <h:column><h:inputText style="width:150px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.mailRec}"/></h:column>
                        <h:column>
                            <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.chargerLesTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idPanlGlob,idButton,scrollTableRec,tableTiersRec"/>
                            <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()"/>
                        </h:column>
                    </h:panelGrid>

                    <h:panelGrid style="border:solid 0px black;"  width="100%">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" reRender="tableTiersRec" id="scrollTableRec" maxPages="20" align="left" for="tableTiersRec"/>
                            <rich:extendedDataTable rows="200" styleClass="bg" id="tableTiersRec" border="0" width="100%" height="350px" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.dataModelGroupe}" var="societe" >
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.selectionGroupe}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,btnTiers"/>
                                <rich:column label="Sélection du tiers" sortable="true" sortBy="#{societe.select}" width="5%">
                                    <f:facet name="header" ><h:outputText value="Sel."/></f:facet>
                                    <h:selectBooleanCheckbox value="#{societe.select}"/>
                                </rich:column>
                                <rich:column label="Société" sortable="true" sortBy="#{societe.tiers.tieraisonsocialenom}" width="18%">
                                    <f:facet name="header" ><h:outputText value="Société"/></f:facet>
                                    <h:outputText value="#{societe.tiers.tieraisonsocialenom}"/>
                                </rich:column>
                                <rich:column label="Catégorie des tiers" sortable="true" sortBy="#{societe.tiers.tiecategorie}" width="7%">
                                    <f:facet name="header" ><h:outputText value="Catégorie"/></f:facet>
                                    <h:outputText value="#{societe.tiers.tiecategorie}"/>
                                </rich:column>
                                <rich:column label="Civilité" sortable="true" sortBy="#{societe.concivilite}" width="5%">
                                    <f:facet name="header" ><h:outputText value="Civilité"/></f:facet>
                                    <h:outputText value="#{societe.concivilite}"/>
                                </rich:column>
                                <rich:column label="Nom" sortable="true" sortBy="#{societe.connom}" width="15%" sortOrder="ASCENDING">
                                    <f:facet name="header" ><h:outputText value="Nom"/></f:facet>
                                    <h:outputText value="#{societe.connom}"/>
                                </rich:column>
                                <rich:column label="Prénom" sortable="true" sortBy="#{societe.conprenom}" width="10%">
                                    <f:facet name="header" ><h:outputText value="Prénom"/></f:facet>
                                    <h:outputText value="#{societe.conprenom}"/>
                                </rich:column>
                                <rich:column label="N° téléphone" sortable="true" sortBy="#{societe.concel1}" width="10%">
                                    <f:facet name="header" ><h:outputText value="Mobile"/></f:facet>
                                    <h:outputText value="#{societe.concel1}"/>
                                </rich:column>
                                <rich:column label="Email" sortable="true" sortBy="#{societe.conmail1}" width="10%">
                                    <f:facet name="header" ><h:outputText value="Mail"/></f:facet>
                                    <h:outputText value="#{societe.conmail1}"/>
                                </rich:column>
                                <rich:column label="Fonction" sortable="true" sortBy="#{societe.confonction}" width="10%">
                                    <f:facet name="header" ><h:outputText value="Fonction"/></f:facet>
                                    <h:outputText value="#{societe.confonction}"/>
                                </rich:column>
                                <rich:column label="Service" sortable="true" sortBy="#{societe.conservice}" width="10%">
                                    <f:facet name="header" ><h:outputText value="Service"/></f:facet>
                                    <h:outputText value="#{societe.conservice}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>

                </h:panelGrid>

                <h:panelGroup id="idValide">
                    <center>
                        <a4j:commandButton value="Tout sélectionnez" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.toutSelectionner}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="tableTiersRec"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton value="Sélectionnez tous les mails" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.toutSelectionnerMail}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="tableTiersRec" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneEnteteVentes.camType==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneEnteteVentes.camType==3}"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton value="Sélectionnez tous les mobiles" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.toutSelectionnerMobile}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="tableTiersRec" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneEnteteVentes.camType==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneEnteteVentes.camType==3}"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton value="Rien sélectionnez" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.rienSelectionner}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="tableTiersRec"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.validerGroupe}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panelGroupe,scrollTableParticipant,tableParticipant,panelBoutonParticipant,idResume"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent" id="panelMail" width="950" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.showModalPanelMessageMail}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.showModalPanelMessageMail}" var="mail">
            <f:facet name="header"><h:outputText value="Modèle du mail"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.fermerMail}" image="/images/close.gif" styleClass="hidelink" reRender="panelMail"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  columns="2" style="width:100%;" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Date:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneMessageVentesMail.cammesDate}" readonly="true" disabled="true"/></h:column>
                    <h:column><h:outputText value="Descriptif:"/></h:column>
                    <h:column><h:inputText style="width:90%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneMessageVentesMail.cammesDescriptif}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}"/></h:column>
                    <h:column><h:outputText value="Objet:"/></h:column>
                    <h:column><h:inputText style="width:90%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneMessageVentesMail.cammesObjet}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}"/></h:column>
                </h:panelGrid>
                <h:panelGrid width="100%" headerClass="headerTab" >
                    <rich:editor id="idCorps"  theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneMessageVentesMail.cammesMessage}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}">
                        <jsp:include flush="true" page="../css/tdt.jsp"/>
                    </rich:editor>
                </h:panelGrid>

                <h:panelGroup id="idValideMail">
                    <br>
                    <center>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.validerMail}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panelMail,scrollTableMail,tableMail,panelBoutonMail"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelSms" width="825" height="300" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.showModalPanelMessageSMS}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.showModalPanelMessageSMS}" var="sms">
            <f:facet name="header"><h:outputText value="Modèle du sms"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.fermerSms}" image="/images/close.gif" styleClass="hidelink" reRender="panelSms"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  columns="2" style="width:100%;" styleClass="fichefournisseur">
                    <h:panelGrid width="100%" headerClass="headerTab">
                        <h:column><h:outputText value="Date:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneMessageVentesSms.cammesDate}" readonly="true" disabled="true"/></h:column>
                        <h:column><h:outputText value="Descriptif:"/></h:column>
                        <h:column><h:inputText style="width:90%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneMessageVentesSms.cammesDescriptif}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}"/></h:column>
                        <f:facet name="header"><h:outputText value="Texte du Sms"/></f:facet>
                        <h:column><h:inputTextarea rows="5" cols="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneMessageVentesSms.cammesMessage}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>

                <h:panelGroup id="idValideSms">
                    <br>
                    <center>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.validerSms}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panelSms,scrollTableSms,tableSms,panelBoutonSms"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelAction" width="900" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.showModalPanelActions}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.showModalPanelActions}" var="act">
            <f:facet name="header"><h:outputText value="Actions"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.fermerAction}" image="/images/close.gif" styleClass="hidelink" reRender="panelAction"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid id="panelGlobal" columns="2" style="width:100%;" columnClasses="clos30,clos70" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Date action:"/></h:column>
                    <h:column>
                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneActionVentes.camactDate}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}"/>
                    </h:column>
                    <h:column><h:outputText value="Définition action:"/></h:column>
                    <h:column><h:inputText style="width:90%" maxlength="200" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneActionVentes.camactAction}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}"/></h:column>
                    <h:column><h:outputText value="Action suivi par:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:90%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneActionVentes.camactIdCommercial}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}">
                            <f:selectItem itemLabel="Sélectionnez commercial" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.mesPersonnelsItem}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Deadline:"/></h:column>
                    <h:column>
                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneActionVentes.camactDateFin}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}"/>
                    </h:column>
                    <h:column><h:outputText value="Observations:"/></h:column>
                    <h:column><h:inputText style="width:90%" maxlength="200" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneActionVentes.camactCommentaire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}"/></h:column>
                    <h:column><h:outputText value="Résultat action:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:30%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneActionVentes.camactResultat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}">
                            <f:selectItem itemLabel="En cours" itemValue="0"/>
                            <f:selectItem itemLabel="Traités" itemValue="1"/>
                            <f:selectItem itemLabel="Non traitée" itemValue="2"/>
                            <f:selectItem itemLabel="Reporté" itemValue="3"/>
                            <f:selectItem itemLabel="Annulée" itemValue="4"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelGlobal"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneActionVentes.camactResultat==3}"><h:outputText value="Date de report:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneActionVentes.camactResultat==3}">
                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneActionVentes.camactDateReport}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}"/>
                    </h:column>
                    <h:column><h:outputText value="Définition action:"/></h:column>
                    <h:column><h:inputText style="width:90%" maxlength="200" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.campagneActionVentes.camactSuite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_aff_action}"/></h:column>
                </h:panelGrid>

                <h:panelGroup id="idValideAction">
                    <center>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.validerAction}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panelAction,scrollTableAction,tableAction,panelBoutonAction"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
