<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="fmrUtilitaireMaintenance" >
    <center>
        <h2>
            <h:outputText value="UTILITAIRES ET MAINTENANCES" style="color:green;"/><br>
            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.baseLog}" style="color:green;"/>
        </h2>
    </center>

    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.choixModule=='moduleUtilitaires'}" var="lien" scope="session">
        <rich:tabPanel switchType="client" immediate="true"  style="height:400px;margin-top:0px;border:0;" width="100%">

            <rich:tab name="maj" label="Mise à jour">
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
                    <h:panelGrid columnClasses="clos20,clos80" columns="2" width="100%" headerClass="headerTab" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmode!=0}">
                        <f:facet name="header"><h:outputText value="Procédures de mise à jour"/></f:facet>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.var_aff_maj}"><h:outputText style="color:green;font-weight:bold;" value="Pas de mise à jour..."/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.var_aff_maj}"><h:outputText style="color:green;font-weight:bold;" value="Procédure de mise à jour:"/></h:column>
                        <h:commandButton value="Mise à jour" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:200px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.var_aff_maj}" onclick="if (!confirm('Voulez-vous installer la mise à jour ?')) return false;javascript:Richfaces.showModalPanel('panelBarMaj');"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.installationMiseAJour}"/>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.var_aff_maj}"><h:outputText value=""/></h:column>
                        <rich:spacer height="20px"/>
                        <rich:spacer height="20px"/>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

            <rich:tab name="toolsTiers" label="Utilitaires Tiers/Office">
                <a4j:form>
                    <center>
                        <rich:dataTable style="background:transparent;border:0px;" headerClass="headConfig" cellpadding="0" cellspacing="0" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.dataModelUtilTiers}" var="utilTiers" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <rich:column style="border:0px;">
                                <h:graphicImage url="/images/configuration.png" style="margin-right:20px;margin-left:15px;"/>
                                <h:commandButton value="#{utilTiers.libelle}" style="font-weight:bold;background-color:transparent;border:0px;cursor:pointer;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.aiguillageUtilitairesTiers}" onclick="if (!confirm('Etes-vous sur de vouloir exécuter cette opération ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');"/>
                            </rich:column>
                        </rich:dataTable>
                    </center>
                </a4j:form>
            </rich:tab>

            <rich:tab name="toolsCompta" label="Utilitaires Comptabilité" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.accesCompta}">
                <a4j:form>
                    <center>
                        <rich:dataTable style="background:transparent;border:0px;" headerClass="headConfig" cellpadding="0" cellspacing="0" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.dataModelUtilCompta}" var="utilCompta" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <rich:column style="border:0px;">
                                <h:graphicImage url="/images/configuration.png" style="margin-right:20px;margin-left:15px;"/>
                                <h:commandButton value="#{utilCompta.libelle}" style="font-weight:bold;background-color:transparent;border:0px;cursor:pointer;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.aiguillageUtilitairesCompta}" onclick="if (!confirm('Etes-vous sur de vouloir exécuter cette procédure ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');"/>
                            </rich:column>
                        </rich:dataTable>
                    </center>
                </a4j:form>
            </rich:tab>

            <rich:tab name="toolsAchats" label="Utilitaires Achats" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.accesAchats}">
                <a4j:form>
                    <center>
                        <rich:dataTable style="background:transparent;border:0px;" headerClass="headConfig" cellpadding="0" cellspacing="0" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.dataModelUtilAchats}" var="utilAchats" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <rich:column style="border:0px;">
                                <h:graphicImage url="/images/configuration.png" style="margin-right:20px;margin-left:15px;"/>
                                <h:commandButton value="#{utilAchats.libelle}" style="font-weight:bold;background-color:transparent;border:0px;cursor:pointer;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.aiguillageUtilitairesAchats}" onclick="if (!confirm('Etes-vous sur de vouloir exécuter cette procédure ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');"/>
                            </rich:column>
                        </rich:dataTable>
                    </center>
                </a4j:form>
            </rich:tab>

            <rich:tab name="toolsVentes" label="Utilitaires Ventes" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.accesVentes}">
                <a4j:form>
                    <center>
                        <rich:dataTable style="background:transparent;border:0px;" headerClass="headConfig" cellpadding="0" cellspacing="0" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.dataModelUtilVentes}" var="utilVentes" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <rich:column style="border:0px;">
                                <h:graphicImage url="/images/configuration.png" style="margin-right:20px;margin-left:15px;"/>
                                <h:commandButton value="#{utilVentes.libelle}"  style="font-weight:bold;background-color:transparent;border:0px;cursor:pointer;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.aiguillageUtilitairesVentes}" onclick="if (!confirm('Etes-vous sur de vouloir exécuter cette procédure ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');"/>
                            </rich:column>
                        </rich:dataTable>
                    </center>
                </a4j:form>
            </rich:tab>

            <rich:tab name="toolsMedical" label="Utilitaires Médical" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.accesMedical}">
                <a4j:form>
                    <center>
                        <rich:dataTable style="background:transparent;border:0px;" headerClass="headConfig" cellpadding="0" cellspacing="0" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.dataModelUtilMedical}" var="utilMedical" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <rich:column style="border:0px;">
                                <h:graphicImage url="/images/configuration.png" style="margin-right:20px;margin-left:15px;"/>
                                <h:commandButton value="#{utilMedical.libelle}" style="font-weight:bold;background-color:transparent;border:0px;cursor:pointer;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.aiguillageUtilitairesMedical}" onclick="if (!confirm('Etes-vous sur de vouloir exécuter cette procédure ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');"/>
                            </rich:column>
                        </rich:dataTable>
                    </center>
                </a4j:form>
            </rich:tab>

            <rich:tab name="toolsParc" label="Utilitaires Parc" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.accesParc}">
                <a4j:form>
                    <center>
                        <rich:dataTable style="background:transparent;border:0px;" headerClass="headConfig" cellpadding="0" cellspacing="0" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.dataModelUtilParc}" var="utilParc" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <rich:column style="border:0px;">
                                <h:graphicImage url="/images/configuration.png" style="margin-right:20px;margin-left:15px;"/>
                                <h:commandButton value="#{utilParc.libelle}" style="font-weight:bold;background-color:transparent;border:0px;cursor:pointer;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.aiguillageUtilitairesParc}" onclick="if (!confirm('Etes-vous sur de vouloir exécuter cette procédure ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');"/>
                            </rich:column>
                        </rich:dataTable>
                    </center>
                </a4j:form>
            </rich:tab>

            <rich:tab name="toolsPaye" label="Utilitaires Paye" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.accesPaye}">
                <a4j:form>
                    <center>
                        <rich:dataTable style="background:transparent;border:0px;" headerClass="headConfig" cellpadding="0" cellspacing="0" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.dataModelUtilPaye}" var="utilPaye" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <rich:column style="border:0px;">
                                <h:graphicImage url="/images/configuration.png" style="margin-right:20px;margin-left:15px;"/>
                                <h:commandButton value="#{utilPaye.libelle}" style="font-weight:bold;background-color:transparent;border:0px;cursor:pointer;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.aiguillageUtilitairesPaye}" onclick="if (!confirm('Etes-vous sur de vouloir exécuter cette procédure ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');"/>
                            </rich:column>
                        </rich:dataTable>
                    </center>
                </a4j:form>
            </rich:tab>

            <rich:tab name="toolsTreso" label="Utilitaires Trésorerie" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.accesTreso}">
                <a4j:form>
                    <center>
                        <rich:dataTable style="background:transparent;border:0px;" headerClass="headConfig" cellpadding="0" cellspacing="0" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.dataModelUtilTreso}" var="utilTreso" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <rich:column style="border:0px;">
                                <h:graphicImage url="/images/configuration.png" style="margin-right:20px;margin-left:15px;"/>
                                <h:commandButton value="#{utilTreso.libelle}" style="font-weight:bold;background-color:transparent;border:0px;cursor:pointer;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.aiguillageUtilitairesTreso}" onclick="if (!confirm('Etes-vous sur de vouloir exécuter cette procédure ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');"/>
                            </rich:column>
                        </rich:dataTable>
                    </center>
                </a4j:form>
            </rich:tab>

            <rich:tab name="toolsImmobilier" label="Utilitaires Immobiliser" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.accesImmobilier}">
                <a4j:form>
                    <center>
                        <rich:dataTable style="background:transparent;border:0px;" headerClass="headConfig" cellpadding="0" cellspacing="0" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.dataModelUtilImmobilier}" var="utilImmobilier" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <rich:column style="border:0px;">
                                <h:graphicImage url="/images/configuration.png" style="margin-right:20px;margin-left:15px;"/>
                                <h:commandButton value="#{utilImmobilier.libelle}" style="font-weight:bold;background-color:transparent;border:0px;cursor:pointer;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.aiguillageUtilitairesImmobilier}" onclick="if (!confirm('Etes-vous sur de vouloir exécuter cette procédure ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');"/>
                            </rich:column>
                        </rich:dataTable>
                    </center>
                </a4j:form>
            </rich:tab>

            <rich:tab name="toolsEspion" label="Analyse Espion">
                <a4j:form>
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.intEspion}" reRender="panEspion,tableEspion,scrollTable"/>
                    <h:panelGrid width="100%" styleClass="recherche" id="panEspion">
                        <h:panelGrid width="100%" columns="9">
                            <h:column><h:outputText value="Type:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.var_plan_origine}" style="width:200px;">
                                    <f:selectItem itemLabel="Action" itemValue="0"/>
                                    <f:selectItem itemLabel="Log." itemValue="1"/>
                                    <f:selectItem itemLabel="Litige." itemValue="2"/>
                                    <f:selectItem itemLabel="Réimputation agent" itemValue="3"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date début:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.var_date_deb}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  /></h:column>
                            <h:column><h:outputText value="Date fin:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.var_date_fin}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  /></h:column>
                            <h:column><h:outputText value="Mot clé:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.var_info}"/></h:column>
                            <h:column>
                                <a4j:commandButton id="idValRechercheEspion" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.analyseActivite}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableEspion,scrollTableEspion"/>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller reRender="tableEspion" id="scrollTableEspion" maxPages="20"align="left" for="tableEspion"/>
                        <rich:extendedDataTable rows="100" style="max-height:100%" styleClass="bg" id="tableEspion" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.dataModelEcrituresDetruites}" var="var">
                            <rich:column label="N° id" sortable="true" sortBy="#{var.espid}" width="8%">
                                <f:facet name="header"><h:outputText  value="N° Id" /></f:facet>
                                <h:outputText value="#{var.espid}"/>
                            </rich:column>
                            <rich:column label="Date action" sortable="true" sortBy="#{var.espdtecreat}" width="12%">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{var.espdtecreat}">
                                    <f:convertDateTime pattern="dd/MM/yy hh:mm:ss" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Action" sortable="true" sortBy="#{var.espaction}" width="50%">
                                <f:facet name="header"><h:outputText  value="Action" /></f:facet>
                                <h:outputText value="#{var.espaction}" title="#{var.espaction}"/>
                            </rich:column>
                            <rich:column label="Catégorie client" sortable="true" sortBy="#{var.libelleType}" width="10%">
                                <f:facet name="header"><h:outputText  value="Cat." /></f:facet>
                                <h:outputText value="#{var.libelleType}"/>
                            </rich:column>
                            <rich:column label="User" sortable="true" sortBy="#{var.users.usrPatronyme}" width="20%">
                                <f:facet name="header"><h:outputText  value="User" /></f:facet>
                                <h:outputText value="#{var.users.usrPatronyme}" title="#{var.users.usrPatronyme}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </a4j:form>
            </rich:tab>

            <rich:tab label="Evolution/debugage">
                <a4j:form>
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.intEvolution}" reRender="panEvolution"/>
                    <h:panelGrid id="panEvolution" width="100%">
                        <h:panelGrid width="100%" columns="9">
                            <h:column><h:outputText value="Date début:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.var_date_deb}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  /></h:column>
                            <h:column><h:outputText value="Date fin:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.var_date_fin}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  /></h:column>
                            <h:column><h:outputText value="Module:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.module}" style="width:200px;">
                                    <f:selectItem itemLabel="Tous les modules" itemValue=""/>
                                    <f:selectItem itemLabel="Acceuil" itemValue="ACCEUIL"/>
                                <f:selectItem itemLabel="Achats" itemValue="ACHATS"/>
                                <f:selectItem itemLabel="Administration" itemValue="ADMINISTRATION"/>
                                <f:selectItem itemLabel="Androide" itemValue="ANDROIDE"/>
                                <f:selectItem itemLabel="Cabinet" itemValue="CABINET"/>
                                <f:selectItem itemLabel="Comptabilité" itemValue="COMPTA"/>
                                <f:selectItem itemLabel="Education" itemValue="EDUCATION"/>
                                <f:selectItem itemLabel="Exploitation" itemValue="EXPLOITATION"/>
                                <f:selectItem itemLabel="Fondation" itemValue="FONDATION"/>
                                <f:selectItem itemLabel="Forêt" itemValue="FORET"/>
                                <f:selectItem itemLabel="Guest" itemValue="GUEST"/>
                                <f:selectItem itemLabel="HelpDesk" itemValue="HELP-DESK"/>
                                <f:selectItem itemLabel="HighCharts" itemValue="HIGH-CHARTS"/>
                                <f:selectItem itemLabel="Immobilier" itemValue="IMMOBILIER"/>
                                <f:selectItem itemLabel="Interim" itemValue="INTERIM"/>
                                <f:selectItem itemLabel="Live-Chat" itemValue="LIVE-CHAT"/>
                                <f:selectItem itemLabel="Médical" itemValue="MEDICAL"/>
                                <f:selectItem itemLabel="Micro-finance" itemValue="MICRO-FINANCE"/>
                                <f:selectItem itemLabel="Office" itemValue="OFFICE"/>
                                <f:selectItem itemLabel="Parc" itemValue="PARC"/>
                                <f:selectItem itemLabel="Paye" itemValue="PAYE"/>
                                <f:selectItem itemLabel="Polit-bureau" itemValue="POLIT-BUREAU"/>
                                <f:selectItem itemLabel="Projets" itemValue="PROJETS"/>
                                <f:selectItem itemLabel="Production" itemValue="PRODUCTION"/>
                                <f:selectItem itemLabel="Reporting" itemValue="REPORTING"/>
                                <f:selectItem itemLabel="Responsive-Voice" itemValue="RESPONSIVE-VOICE"/>
                                <f:selectItem itemLabel="Script" itemValue="SCRIPT"/>
                                <f:selectItem itemLabel="Stock" itemValue="STOCK"/>
                                <f:selectItem itemLabel="Système" itemValue="SYSTEME"/>
                                <f:selectItem itemLabel="Temples" itemValue="TEMPLE"/>
                                <f:selectItem itemLabel="Temps" itemValue="TEMPS"/>
                                <f:selectItem itemLabel="Transit/Transport" itemValue="TRANSIT/TRANSPORT"/>
                                <f:selectItem itemLabel="Trésorerie" itemValue="TRESORERIE"/>
                                <f:selectItem itemLabel="Tiers" itemValue="TIERS"/>
                                <f:selectItem itemLabel="Update" itemValue="UPDATE"/>
                                <f:selectItem itemLabel="Utilitaires" itemValue="UTILITAIRES"/>
                                <f:selectItem itemLabel="Ventes" itemValue="VENTES"/>
                                <f:selectItem itemLabel="WebTwain" itemValue="WEBTWAIN"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Mot clé:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.var_info}"/></h:column>
                            <h:column>
                                <a4j:commandButton id="idValRechercheEvolution" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.chargementEvolution}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,listeEvolution,scrollTableEvolution"/>
                            </h:column>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller reRender="listeEvolution" id="scrollTableEvolution" maxPages="20"align="left" for="listeEvolution"/>
                            <rich:extendedDataTable rows="200" style="max-height:100%;" border="0" styleClass="bg" id="listeEvolution" width="100%" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.dataModelEvolution}" var="evo">
                                <rich:column label="Version" width="8%" sortable="true" sortBy="#{evo.version}">
                                    <f:facet name="header" ><h:outputText value="Version" /></f:facet>
                                    <h:outputText value="#{evo.version}" title="#{evo.version}"/>
                                </rich:column>
                                <rich:column label="Date" sortable="true" sortBy="#{evo.date}" width="8%" sortOrder="DESCENDING">
                                    <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                    <h:outputText value="#{evo.date}">
                                        <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Type" width="10%" sortable="true" sortBy="#{evo.type}">
                                    <f:facet name="header" ><h:outputText value="Type" /></f:facet>
                                    <h:outputText value="#{evo.type}" title="#{evo.type}"/>
                                </rich:column>
                                <rich:column label="Module" width="10%" sortable="true" sortBy="#{evo.module}">
                                    <f:facet name="header" ><h:outputText value="Module" /></f:facet>
                                    <h:outputText value="#{evo.module}" title="#{evo.module}"/>
                                </rich:column>
                                <rich:column label="Ecran ou état" width="10%" sortable="true" sortBy="#{evo.ecran}">
                                    <f:facet name="header" ><h:outputText value="Ecran/Etat" /></f:facet>
                                    <h:outputText value="#{evo.ecran}" title="#{evo.ecran}" rendered="#{evo.ecran!=null}"/>
                                </rich:column>
                                <rich:column label="Objet" width="34%" sortable="true" sortBy="#{evo.objet}">
                                    <f:facet name="header" ><h:outputText value="Objet" /></f:facet>
                                    <h:inputTextarea rows="3" value="#{evo.objet}" title="#{evo.objet}" readonly="true" style="width:100%"/>
                                </rich:column>
                                <rich:column label="Détail ou Statut" width="20%" sortable="true" sortBy="#{evo.detail}">
                                    <f:facet name="header" ><h:outputText value="Détail/Statut" /></f:facet>
                                    <h:inputTextarea rows="3" value="#{evo.detail}" title="#{evo.detail}" readonly="true" style="width:100%"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </a4j:form>
            </rich:tab>

        </rich:tabPanel>
    </c:if>

    <c:choose>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.choixModule=='executionUtilitaires'}">
            <jsp:include flush="true" page="/utilitaires/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.choixLigne}.jsp"/>
        </c:when>
    </c:choose>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelBarProg" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="700" height="80" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.var_showBarProg}">
        <f:facet name="header"><h:outputText value="Traitement des utilitaires en cours..."/></f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel id="progressPanel">
                    <rich:progressBar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.var_currentValue}" style="width:90%" interval="300" enabled="true" minValue="-1" maxValue="100" id="barprg" mode="ajax" ajaxSingle="true" eventsQueue="maQueueProgress" limitToList="true" reRenderAfterComplete="panelBarProg,progressPanel">
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.var_info} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.var_currentValue} %)"/>
                    </rich:progressBar>
                </a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelBarMaj" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="700" height="80" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.var_showBarProgMaj}">
        <f:facet name="header"><h:outputText value="Mise à jour en cours..."/></f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel id="progressPanelMaj">
                    <rich:progressBar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.var_currentValue}" style="width:90%" interval="300" enabled="true" minValue="-1" maxValue="100" id="barprg">
                        <h:outputText value="Telechargement en cours... (#{bakingbeanepegase.menuModuleHorizontalCtrl.var_currentValue} %)"/>
                    </rich:progressBar>
                </a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>


</f:subview>