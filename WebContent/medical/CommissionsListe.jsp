<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="commissionmedicaleliste">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center> 
            <h2>
                <h:outputText value="ACTIVITES MEDICALES" style="color:green;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.infirmerie}"/>
                <h:outputText value="ACTIVITES MEDICALES (documents Contrôlés ou Refacturés) et CALCUL DES COMMISSIONS" style="color:green;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.infirmerie}"/>
            </h2>
        </center>

        <rich:tabPanel switchType="client" immediate="true" style="border:0px;background-color:white;" selectedTab="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.labelOnglet}">

            <rich:tab id="tabAnalyse" label="Analyse activité">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.documentAnalyse}" reRender="documentAnalyse"/>
                <h:panelGrid  columns="1" width="100%" id="documentAnalyse" >
                    <h:panelGrid id="panCtrlAnalyse" styleClass="recherche" width="100%">
                        <h:panelGrid columns="13" width="100%">
                            <h:column><h:outputText value="Du"/></h:column>
                            <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                            <h:column><h:outputText value="Au"/></h:column>
                            <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                            <h:column>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.infirmerie}" var="inf1">
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpType}" style="width:200px;">
                                        <f:selectItem itemLabel="Consultation" itemValue="71"/>
                                        <f:selectItem itemLabel="Pharmacie" itemValue="711"/>
                                        <f:selectItem itemLabel="Prescription odonnance" itemValue="712"/>
                                        <f:selectItem itemLabel="Prescription laobratoire" itemValue="713"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.effaceliste}" reRender="panCtrlAnalyse,tableAnalyse"/>
                                    </h:selectOneMenu>
                                </c:if>
                                <c:if test="${!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.infirmerie}" var="inf2">
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpType}" style="width:200px;">
                                        <f:selectItem itemLabel="Consultation" itemValue="71"/>
                                        <f:selectItem itemLabel="Pharmacie" itemValue="73"/>
                                        <f:selectItem itemLabel="Laboratoire" itemValue="74"/>
                                        <f:selectItem itemLabel="Hospitalisations" itemValue="76"/>
                                        <f:selectItem itemLabel="Tous les documents médicaux PRIVES" itemValue="990"/>
                                        <f:selectItem itemLabel="Tous les documents médicaux PRIS EN CHARGE" itemValue="991"/>
                                        <f:selectItem itemLabel="Tous les documents médicaux" itemValue="999"/>
                                        <f:selectItem itemLabel="Refacturation aux tiers" itemValue="78"/>
                                        <f:selectItem itemLabel="Facturation externe" itemValue="181"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.effaceliste}" reRender="panCtrlAnalyse,tableAnalyse"/>
                                    </h:selectOneMenu>
                                </c:if>
                            </h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpMode}" style="width:200px;">
                                    <f:selectItem itemLabel="par agent" itemValue="0"/>
                                    <f:selectItem itemLabel="par mèdecin" itemValue="1"/>
                                    <f:selectItem itemLabel="par service" itemValue="2"/>
                                    <f:selectItem itemLabel="par actes/produits" itemValue="3"/>
                                    <f:selectItem itemLabel="par motifs d`entrée" itemValue="4"/>
                                    <f:selectItem itemLabel="par motifs de sortie" itemValue="5"/>
                                    <f:selectItem itemLabel="par patient" itemValue="6"/>
                                    <f:selectItem itemLabel="par tiers payeurs" itemValue="7"/>
                                    <f:selectItem itemLabel="par pathologie" itemValue="8"/>
                                    <a4j:support eventsQueue="Maqueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.effaceliste}" reRender="tableAnalyse"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="false">
                                <h:selectOneMenu id="idResponsable" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpIdResponsable}" style="width:200px;">
                                    <f:selectItem itemLabel="Tous les Agents (facturation, Caissiers)" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.mesResponsablesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="false">
                                <h:selectOneMenu id="idCommercial" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpIdMedecin}" style="width:200px;">
                                    <f:selectItem itemLabel="Tous les mèdecins" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.mesMedecinItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.infirmerie}"><h:outputText value="Site:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.infirmerie}">
                                <h:selectOneMenu style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpSite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSite==null||bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSite==''}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesSitesItems}" />
                                </h:selectOneMenu>
                                <h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSite!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSite!=''}" readonly="true" disabled="true"/>
                            </h:column>
                            <h:column>
                                <a4j:commandButton value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.executerRequeteAnalyse}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panCtrl,tableAnalyse,scrollTableAnalyse,pnlgrttotalAnalyse"/>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <center>
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.pageIndex}" reRender="tableAnalyse" id="scrollTableAnalyse" maxPages="20"align="left" for="tableAnalyse"/>
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableAnalyse" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.dataModelAnalyse}" var="var">
                                <rich:column label="Tiers" sortable="true" sortBy="#{var.docNomTiers}" width="40%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpType==77}">
                                    <f:facet name="header"><h:outputText  value="Nom du Client"/></f:facet>
                                    <h:outputText  value="#{var.docNomTiers}"/>
                                </rich:column>
                                <rich:column label="Agents" sortable="true" sortBy="#{var.docNomResponsable}" width="40%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpMode==0}">
                                    <f:facet name="header"><h:outputText  value="Agent"/></f:facet>
                                    <h:outputText  value="#{var.docNomResponsable}"/>
                                </rich:column>
                                <rich:column label="Mèdecin" sortable="true" sortBy="#{var.docNomCommercial}" width="40%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpMode==1}">
                                    <f:facet name="header"><h:outputText  value="Mèdecin"/></f:facet>
                                    <h:outputText  value="#{var.docNomCommercial}"/>
                                </rich:column>
                                <rich:column label="Services" sortable="true" sortBy="#{var.docService}" width="40%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpMode==2}">
                                    <f:facet name="header"><h:outputText  value="Services"/></f:facet>
                                    <h:outputText  value="#{var.docService}"/>
                                </rich:column>
                                <rich:column label="Actes/Produits" sortable="true" sortBy="#{var.docLibelle}" width="40%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpMode==3}">
                                    <f:facet name="header"><h:outputText  value="Actes/Produits"/></f:facet>
                                    <h:outputText  value="#{var.docLibelle}"/>
                                </rich:column>
                                <rich:column label="Motif entrée" sortable="true" sortBy="#{var.docSource}" width="40%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpMode==4}">
                                    <f:facet name="header"><h:outputText  value="Motif Entrée"/></f:facet>
                                    <h:outputText  value="#{var.docSource}"/>
                                </rich:column>
                                <rich:column label="Motif sortie" sortable="true" sortBy="#{var.docSite}" width="40%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpMode==5}">
                                    <f:facet name="header"><h:outputText  value="Motif sortie"/></f:facet>
                                    <h:outputText  value="#{var.docSite}"/>
                                </rich:column>
                                <rich:column label="Patient" sortable="true" sortBy="#{var.docNomEquipe}" width="40%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpMode==6}">
                                    <f:facet name="header"><h:outputText  value="Patient"/></f:facet>
                                    <h:outputText  value="#{var.docNomEquipe}"/>
                                </rich:column>
                                <rich:column label="Tiers" sortable="true" sortBy="#{var.docNomPayeur}" width="40%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpMode==7}">
                                    <f:facet name="header"><h:outputText  value="Tiers"/></f:facet>
                                    <h:outputText  value="#{var.docNomPayeur}"/>
                                </rich:column>
                                <rich:column label="Pathologie" sortable="true" sortBy="#{var.docBudget}" width="40%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpMode==8}">
                                    <f:facet name="header"><h:outputText  value="Pathologie"/></f:facet>
                                    <h:outputText  value="#{var.docBudget}"/>
                                </rich:column>
                                <rich:column label="Nombre" sortable="true" sortBy="#{var.docQte}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.infirmerie}">
                                    <f:facet name="header"><h:outputText  value="Nombre"/></f:facet>
                                    <h:outputText  value="#{var.docQte}" rendered="#{var.docQte!=0}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Total T.T.C." sortable="true" sortBy="#{var.docTotTtc}" width="12%" style="text-align:right" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.infirmerie}">
                                    <f:facet name="header"><h:outputText  value="Total Document"/></f:facet>
                                    <h:outputText  value="#{var.docTotTtc}" rendered="#{var.docTotTtc!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Total Tiers" sortable="true" sortBy="#{var.docTotHt}" width="12%" style="text-align:right" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.infirmerie}">
                                    <f:facet name="header"><h:outputText  value="Part Tiers"/></f:facet>
                                    <h:outputText  value="#{var.docTotHt}" rendered="#{var.docTotHt!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Total Patient" sortable="true" sortBy="#{var.docTotTva}" width="12%" style="text-align:right" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.infirmerie}">
                                    <f:facet name="header"><h:outputText  value="Part Patient"/></f:facet>
                                    <h:outputText  value="#{var.docTotTva}" rendered="#{var.docTotTva!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Total règlement" sortable="true" sortBy="#{var.docTotReglement}" width="12%" style="text-align:right" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.infirmerie}">
                                    <f:facet name="header"><h:outputText  value="Règlement"/></f:facet>
                                    <h:outputText  value="#{var.docTotReglement}" rendered="#{var.docTotReglement!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Solde" sortable="true" sortBy="#{var.reliquat}" width="12%" style="text-align:right" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.infirmerie}">
                                    <f:facet name="header"><h:outputText  value="Solde"/></f:facet>
                                    <h:outputText  value="#{var.reliquat}" rendered="#{var.reliquat!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                        <br/>
                        <h:panelGrid id="pnlgrttotalAnalyse" columns="3" columnClasses="clos30,clos30,clos30" cellspacing="1" styleClass="recherche"  width="100%">
                            <h:panelGrid  columns="2" cellspacing="3"  cellpadding="3" width="100%">
                                <h:outputText value="Montant total Tiers" />
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.montantTiers}" style="width:100%;text-align:right;" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:panelGrid>
                            <h:panelGrid  columns="2" cellspacing="3"  cellpadding="3" width="100%">
                                <h:outputText value="Montant total Patient" />
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.montantPatient}" style="width:100%;text-align:right;" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:panelGrid>
                            <h:panelGrid  columns="2" cellspacing="3"  cellpadding="3" width="100%">
                                <h:outputText value="Montant total facturation" />
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.montantTotal}" style="width:100%;text-align:right;" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:panelGrid>
                            <h:panelGrid columns="2" cellspacing="3"  cellpadding="3" width="100%">
                                <h:outputText value="Total Réglements" />
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.montantReglement}" style="width:100%;text-align:right;" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:panelGrid>
                            <h:panelGrid columns="2" cellspacing="3"  cellpadding="3" width="100%">
                                <h:outputText value="Solde (patients + tiers)" />
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.montantSolde}" style="width:100%;text-align:right;" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:panelGrid>
                            <h:panelGrid columns="1" cellspacing="3"  cellpadding="3" width="100%">
                                <h:outputText value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.var_nb_ligne})" />
                            </h:panelGrid>
                        </h:panelGrid>
                    </center>
                </h:panelGrid>
            </rich:tab>

            <rich:tab id="tabRapport" label="Rapports Mensuels" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.var_acces_rapport}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.rapport}" reRender="rapport"/>
                <h:panelGrid  columns="1" width="100%" id="rapport" >
                    <h:panelGrid id="panCtrlRapport" styleClass="recherche" width="100%">
                        <h:panelGrid columns="11" width="100%">
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.periode}" style="width:150px;">
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesPeriodesItems}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpEtat}" style="width:100px;">
                                    <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                                    <f:selectItem itemLabel="En Cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Validé" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column>
                                <h:outputText value="Mèdecin:" style="text-decoration:underline;"/>&nbsp;
                                <h:selectOneMenu style="width:100px;" id="idMedecin1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpIdMedecin}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.mesMedecinItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.infirmerie}"><h:outputText value="Site:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.infirmerie}">
                                <h:selectOneMenu style="width:100px;" id="idSite" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpSite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSite==null||bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSite==''}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesSitesItems}" />
                                </h:selectOneMenu>
                                <h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSite!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSite!=''}" readonly="true" disabled="true"/>
                            </h:column>
                            <h:column>
                                <a4j:commandButton id="idValRechercheRapport" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.rechercherRapport}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panCtrlRapport,tableRapport,scrollTableRapport"/>
                                <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>

                <h:panelGrid id="panelBoutonRapport" columns="6" width="300px" style="height:34px">
                    <a4j:commandButton title="Ajouter nouveau rapport" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.ajouterRapport}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelRapport"/>
                    <a4j:commandButton title="Modifier le rapport sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.visibiliteBtonRapport&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.rapportMedical.rapmedEtat==0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.modifierRapport}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelRapport"/>
                    <a4j:commandButton title="Consulter le rapport sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.visibiliteBtonRapport}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.consulterRapport}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelRapport"/>
                    <a4j:commandButton title="Supprimer le rapport sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.visibiliteBtonRapport&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.rapportMedical.rapmedEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer le(s) document(s) ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.supprimerRapport}" reRender="tableRapport,panelBoutonRapport"/>
                    <a4j:commandButton title="Valider le rapport sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.visibiliteBtonRapport&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.rapportMedical.rapmedEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.validerRapport}" onclick="if (!confirm('Etes-vous sur de vouloir valider le(s) document(s) ?')) return false" reRender="panelBoutonRapport,idEtatRapport"/>
                    <a4j:commandButton title="Dé-Valider le rapport sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.commissionEnteteVentes.comDateTransfert==null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.visibiliteBtonRapport&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.rapportMedical.rapmedEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.deValiderRapport}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider le(s) document(s) ?')) return false" reRender="panelBoutonRapport,idEtatRapport"/>
                </h:panelGrid>

                <center>
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.pageIndex}" reRender="tableRapport" id="scrollTableRapport" maxPages="20"align="left" for="tableRapport"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableRapport" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.dataModelRapport}" var="rap">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.selectionRapport}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBoutonRapport"/>
                            <rich:column label="N° Rapport" sortable="true" sortBy="#{rap.rapmedNum}" width="10%">
                                <f:facet name="header"><h:outputText  value="N°"/></f:facet>
                                <h:outputText value="#{rap.rapmedNum}" title="#{rap.rapmedNum}"/>
                            </rich:column>
                            <rich:column label="Date Rapport" sortable="true" sortBy="#{rap.rapmedDate} #{rap.rapmedNum}" width="10%">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{rap.rapmedDate}" title="#{rap.rapmedDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column id="idEtatRapport" label="Etat" sortable="true" sortBy="#{rap.etat}" width="8%">
                                <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                <h:outputText value="#{rap.etat}"/>
                            </rich:column>
                            <rich:column label="Période" sortable="true" sortBy="#{rap.rapmedPeriode}" width="8%">
                                <f:facet name="header"><h:outputText  value="Période"/></f:facet>
                                <h:outputText value="#{rap.rapmedPeriode}" title="#{rap.rapmedPeriode}"/>
                            </rich:column>
                            <rich:column label="Responsable" sortable="true" sortBy="#{rap.rapmedNomCreateur}" width="15%">
                                <f:facet name="header"><h:outputText  value="Respponsable"/></f:facet>
                                <h:outputText value="#{rap.rapmedNomCreateur}" title="#{rap.rapmedNomCreateur}"/>
                            </rich:column>
                            <rich:column label="Service" sortable="true" sortBy="#{rap.rapmedService}" width="15%">
                                <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                                <h:outputText value="#{rap.rapmedService}" title="#{rap.rapmedService}"/>
                            </rich:column>
                            <rich:column label="Mèdecin" sortable="true" sortBy="#{rap.rapmedNomMedecin}" width="15%">
                                <f:facet name="header"><h:outputText  value="Mèdecin"/></f:facet>
                                <h:outputText value="#{rap.rapmedNomMedecin}" title="#{rap.rapmedNomMedecin}"/>
                            </rich:column>
                            <rich:column label="Rapport" sortable="true" sortBy="#{rap.rapmedRapport}" width="20%">
                                <f:facet name="header"><h:outputText  value="Rapport"/></f:facet>
                                <h:outputText value="#{rap.rapmedRapport}" title="#{rap.rapmedRapport}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </center>
            </rich:tab>

            <rich:tab id="tabCom" label="Calcul Commission" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.infirmerie}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.document}" reRender="document"/>
                <h:panelGrid  columns="1" width="100%" id="document" >
                    <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
                        <h:panelGrid columns="9" width="100%">
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.periode}" style="width:150px;">
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesPeriodesItems}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpEtat}" style="width:100px;">
                                    <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                                    <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesEtatsItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column>
                                <h:outputText value="Mèdecin:" style="text-decoration:underline;"/>&nbsp;
                                <h:selectOneMenu style="width:100px;" id="idMedecin2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpIdMedecin}">
                                    <f:selectItem itemLabel="Tous les médecins" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.mesMedecinItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column>
                                <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panCtrl,table,scrollTable,pnlgrttotal,panelBouton"/>
                                <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>

                <h:panelGrid id="panelBouton" columns="8" width="400px" style="height:34px">
                    <a4j:commandButton title="Ajouter nouveau calcul" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.ajoutCalcul}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelAjoutCalcul"/>
                    <a4j:commandButton title="Consulter le document sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.consultDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                    <a4j:commandButton title="Supprimer le document sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.commissionEnteteVentes.comEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer le(s) document(s) ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.supprimerCommission}" reRender="table,panelBouton,intpTTCL,intpRGLMTL,intpSOLDL"/>
                    <a4j:commandButton title="Annuler le document sélectionné" image="/images/annuler_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.commissionEnteteVentes.comEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.sup}" onclick="if (!confirm('Etes-vous sur de vouloir annuler ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.annulerDocument}" reRender="panelAnnuler"/>
                    <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
                    <a4j:commandButton title="Paiement (direct) du document sélectionné" image="/images/dollar.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.commissionEnteteVentes.comEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.var_affiche_dollar}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.payeDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPaye,panelPayeMultiple,panelBouton" />
                    <a4j:commandButton title="Historique des règlements du document sélectionné" image="/images/histoPaiement.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.commissionEnteteVentes.comEtat>=1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.histoReglement}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelHistoReglement" />
                    <a4j:commandButton title="Valider le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.commissionEnteteVentes.comEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider le(s) document(s) ?')) return false" reRender="panelBouton,idEtat,table"/>
                    <a4j:commandButton title="Dé-Valider le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.commissionEnteteVentes.comDateTransfert==null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.commissionEnteteVentes.comEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider le(s) document(s) ?')) return false" reRender="panelBouton,idEtat,table"/>
                </h:panelGrid>

                <center>
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.var_nb_max}" style="max-height:100%;" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.datamodelCommission}" var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.simpleSelectionEntete}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.extDTable}">
                            <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.visualisationLigne}" reRender="idSubView,modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                            <rich:column label="N° Commission" sortable="true" sortBy="#{var.comNum}" width="70px">
                                <f:facet name="header"><h:outputText  value="N°"/></f:facet>
                                <h:outputText value="#{var.comNum}"/>
                            </rich:column>
                            <rich:column label="Date Commission" sortable="true" sortBy="#{var.comDate} #{var.comNum}" width="70px">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{var.comDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Date Début" sortable="true" sortBy="#{var.comDateDebut} #{var.comNum}" width="70px">
                                <f:facet name="header"><h:outputText  value="Du" /></f:facet>
                                <h:outputText value="#{var.comDateDebut}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Date Fin" sortable="true" sortBy="#{var.comDateFin}" width="70px">
                                <f:facet name="header"><h:outputText  value="Au" /></f:facet>
                                <h:outputText value="#{var.comDateFin}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{var.comEtat}" width="50px" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                <h:outputText value="#{var.libelleEta}"/>
                            </rich:column>
                            <rich:column label="Mèdecin" sortable="true" sortBy="#{var.comNomCommercial}" width="150px">
                                <f:facet name="header"><h:outputText  value="Mèdecin"/></f:facet>
                                <h:outputText  value="#{var.comNomCommercial}"/>
                            </rich:column>
                            <rich:column label="Total commission" sortable="true" sortBy="#{var.comTotCommission}" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Commission"/></f:facet>
                                <h:outputText  value="#{var.comTotCommission}" rendered="#{var.comTotCommission!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Total taxe" sortable="true" sortBy="#{var.comTotTaxe}" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Prélév."/></f:facet>
                                <h:outputText  value="#{var.comTotTaxe}" rendered="#{var.comTotTaxe!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Total net à Payer" sortable="true" sortBy="#{var.comNetPayer}" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Net à Payer"/></f:facet>
                                <h:outputText  value="#{var.comNetPayer}" rendered="#{var.comNetPayer!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Total règlement" sortable="true" sortBy="#{var.comTotReglement}" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Règlement"/></f:facet>
                                <h:outputText  value="#{var.comTotReglement}" rendered="#{var.comTotReglement!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Solde" sortable="true" sortBy="#{var.reliquat}" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Reste Du"/></f:facet>
                                <h:outputText  value="#{var.reliquat}" rendered="#{var.reliquat!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <br/>
                    <h:panelGrid id="pnlgrttotal" columns="4" cellspacing="1" styleClass="recherche"  width="100%">
                        <h:panelGrid id="pnlgrttotalTTC" columns="2" cellspacing="3"  cellpadding="3">
                            <h:outputText id="outpTTCL" value="Montant commission" />
                            <h:inputText id="intpTTCL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.montantCommission}" style="width:100%;text-align:right;" readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:panelGrid>
                        <h:panelGrid id="pnlgrttotalRGLMT" columns="2" cellspacing="3"  cellpadding="3">
                            <h:outputText id="outpRGLMTL" value="Total Réglements" />
                            <h:inputText id="intpRGLMTL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.montantReglement}" style="width:100%;text-align:right;" readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:panelGrid>
                        <h:panelGrid id="pnlgrttotalSOLD" columns="2" cellspacing="3"  cellpadding="3">
                            <h:outputText id="outpSOLDL" value="Solde" />
                            <h:inputText id="intpSOLDL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.montantSolde}" style="width:100%;text-align:right;" readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:panelGrid>
                        <h:panelGrid id="pnlgrttotalLE" columns="1" cellspacing="3"  cellpadding="3">
                            <h:outputText id="outpLIST" value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.var_nb_ligne})" />
                        </h:panelGrid>
                    </h:panelGrid>
                </center>
            </rich:tab>

        </rich:tabPanel>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitationMedical.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelAjoutCalcul" width="400" height="350" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.showModalPanelAjoutCalcul}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.showModalPanelAjoutCalcul}" var="ajt">
            <f:facet name="header"><h:outputText value="Ajouter un nouveau calcul"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.fermerCalcul}" image="/images/close.gif" styleClass="hidelink" reRender="panelAjoutCalcul"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;" id="panDest">
                        <h:column><h:outputText value="Date calcul:"/></h:column>
                        <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpDate}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Période du:"/></h:column>
                        <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Au:"/></h:column>
                        <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Médecin:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" id="idMedecin3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpIdMedecin}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.mesMedecinBaremeItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.valideCalcul}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelPaye" width="1100" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.showModalPanelPaye}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.showModalPanelPaye}" var="pay">
            <f:facet name="header">
                <h:outputText value="Réglement de la commission"></h:outputText>
            </f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.annulePaye}" image="/images/close.gif" styleClass="hidelink" reRender="panelPaye"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid id="firstgriddd"  width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="Date:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.reglements.rglDateReg}" readonly="true"/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value="Caisse Exécutrice:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="bnqajt" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.var_inputCaisse}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.mesCaissesSeriesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Type règlement:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.varTypeReg}" style="width:100%;">
                            <f:selectItem itemLabel="Espèces" itemValue="0"/>
                            <f:selectItem itemLabel="Chèques" itemValue="1"/>
                            <f:selectItem itemLabel="Virement" itemValue="2"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable styleClass="bg" id="tableSelect" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.datamodelPaiement}" var="var">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.calulNetPayer}" reRender="idTotal"/>
                        <rich:column label="N° facture" sortable="true" sortBy="#{var.comligNum}">
                            <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                            <h:outputText value="#{var.comligNum}"/>
                        </rich:column>
                        <rich:column label="Date facture" sortable="true" sortBy="#{var.comDate} #{var.comligDate}" width="70px">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.comligDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Nom du patient" sortable="true" sortBy="#{var.comligNomTiers}" width="200px">
                            <f:facet name="header"><h:outputText  value="Nom Patient" /></f:facet>
                            <h:outputText value="#{var.comligNomTiers}"/>
                        </rich:column>
                        <rich:column label="Total ligne" sortable="true" sortBy="#{var.comligTotHt}" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="Total"  /></f:facet>
                            <h:outputText  value="#{var.comligTotHt}" rendered="#{var.comligTotHt!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Payé par le patient" sortable="true" sortBy="#{var.payePatient}" style="text-align:right;color:red">
                            <f:facet name="header"> <h:outputText value="P.Patient"  /></f:facet>
                            <h:outputText  value="#{var.payePatient}" rendered="#{var.payePatient!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Payé par le tier" sortable="true" sortBy="#{var.payeTiers}" style="text-align:right;color:red">
                            <f:facet name="header"> <h:outputText value="P.Tier"  /></f:facet>
                            <h:outputText  value="#{var.payeTiers}" rendered="#{var.payeTiers!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="% commission" sortable="true" sortBy="#{var.comligComPourcentage}" style="text-align:right;">
                            <f:facet name="header"> <h:outputText value="%"  /></f:facet>
                            <h:outputText  value="#{var.comligComPourcentage}" rendered="#{var.comligComPourcentage!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant Commissions" sortable="true" sortBy="#{var.comligTotCommissionReel}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Commissions"/></f:facet>
                            <h:outputText  value="#{var.comligTotCommissionReel}" rendered="#{var.comligTotCommissionReel!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Selection" sortable="true" sortBy="#{var.select}" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Sel."/></f:facet>
                            <h:selectBooleanCheckbox  value="#{var.select}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                    <br>
                    <h:panelGrid id="idTotal" columns="6" width="100%">
                        <a4j:commandButton value="Sélec. Patient" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.selPartPatient}" reRender="idTotal,tableSelect"/>
                        <a4j:commandButton value="Sélec. Tiers" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.selPartTiers}" reRender="idTotal,tableSelect"/>
                        <a4j:commandButton value="Tout sélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.toutSel}" reRender="idTotal,tableSelect"/>
                        <a4j:commandButton value="Tout désélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.toutDesel}" reRender="idTotal,tableSelect"/>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Total Sélectionné:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.var_netAPayer}" style="text-align:right">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Total Précompte:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.var_tot_precompte}" style="text-align:right">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Total Versé:" style="font-weight:bold;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.var_verse}" size="6" style="text-align:center;font-weight:bold;font-size:50px">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Total Commission:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.var_dejaPaye}" style="text-align:right">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Reste Du:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.var_solde}" style="text-align:right">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGroup id="ppgrp">
                        <center>
                            <br><br>
                            <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.miseajourPaye}" reRender="panelPaye,panelBouton,table"/>
                        </center>
                    </h:panelGroup>
                </a4j:region>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelAnnuler" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.showModalPanelAnnuler}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.showModalPanelAnnuler}" var="ser">
            <f:facet name="header"><h:outputText value="Annulation Commission"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.annuleAnnulation}" image="/images/close.gif" styleClass="hidelink" reRender="panelAnnuler"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Date annulation:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.commissionEnteteVentes.comDateAnnule}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Motif annulation:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.commissionEnteteVentes.comMotifAnnule}" maxlength="50"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.miseajourAnnuler}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelRapport" width="900" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.showModalPanelRapport}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.showModalPanelRapport}" var="rap">
            <f:facet name="header"><h:outputText value="Ajouter un nouveau rapport"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.fermerRapport}" image="/images/close.gif" styleClass="hidelink" reRender="panelRapport"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;" id="panDest">
                        <h:column><h:outputText value="Date rapport:"/></h:column>
                        <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.rapportMedical.rapmedDate}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.infirmerie}"><h:outputText value="Service:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.infirmerie}">
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.inpIdMedecin}" style="width:200px;">
                                <f:selectItem itemLabel="Sélectionnez le service" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesServices2Items}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.infirmerie}"><h:outputText value="Site concerné:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.infirmerie}">
                            <h:inputText style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.rapportMedical.rapmedService}" readonly="true" disabled="true"/>
                        </h:column>
                        <h:column><h:outputText value="Médecin:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.rapportMedical.rapmedIdMedecin}" style="width:200px;">
                                <f:selectItem itemLabel="Sélectionnez le médecin" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.mesMedecinItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Rapport:"/></h:column>
                        <h:column>
                            <h:inputTextarea rows="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.rapportMedical.rapmedRapport}" style="width:100%;"/>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.saveRapport}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelHistoReglement" width="1000" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.showModalPanelHistoReglement}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.showModalPanelHistoReglement}" var="his">
            <f:facet name="header"><h:outputText value="Historique des règlements"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.fermerHistoReglement}" image="/images/close.gif" styleClass="hidelink" reRender="panelHistoReglement"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  style="width:100%;">
                    <h:panelGrid styleClass="fichefournisseur" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                        <h:column><h:outputText value="Date:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.commissionEnteteVentes.comDate}" style="width:100%" readonly="true"/></h:column>
                        <h:column><h:outputText value="N°:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.commissionEnteteVentes.comNum}" style="width:100%" readonly="true"/></h:column>
                        <h:column><h:outputText value="Nom Médecin:" /></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.commissionEnteteVentes.comNomCommercial}" style="width:100%" readonly="true"/></h:column>
                        <h:column><h:outputText value="Total Net à payer:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.commissionEnteteVentes.comNetPayer}" style="text-align:right;width:100%"  readonly="true" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Total Déjà payé:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.commissionEnteteVentes.comTotReglement}" style="text-align:right;width:100%" readonly="true" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Total Reste du:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.commissionEnteteVentes.reliquat}" style="text-align:right;width:95%"  readonly="true" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable height="350px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formCommissionsMedicales.datamodelRecu}"  var="recu"  sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeReglementDocument.jsp"/>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
