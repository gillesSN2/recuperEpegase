<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelExtClasse">

    <center>
        <h2>
            <h:outputText value="EXTRAIT ANALYTIQUE DU COMPTE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.ecrituresAnalytiqueMemo.ecranaCompte}" styleClass="titre"/>
            <h:outputText value="Pièce N° #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.ecrituresAnalytiqueMemo.ecranaPiece}"/>
        </h2>
    </center>
    <a4j:form id="formAnal">
        <h:panelGrid id="idPanAnal" width="100%" >
            <h:panelGrid width="100%" columns="2" columnClasses="clos50d,clos50d" rendered="true">
                <h:panelGrid style="height:100px;" styleClass="fichefournisseur1" width="100%">
                    <h:panelGrid columns="2" columnClasses="clos30,clos70d" width="100%">
                        <h:outputText value="Axe analytique:" />
                        <h:selectOneMenu id="idonglet" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_axe}" style="width:200px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.mesOngletsAnalytiqueItems}"/>
                            <a4j:support eventsQueue="maQueue"  event="onchange" reRender="idPanAnal" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.chargerAxe}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                </h:panelGrid>
                <h:panelGrid style="height:100px;" styleClass="fichefournisseur1" width="100%">
                    <h:panelGrid id="idPanTotalAnal" columns="2" columnClasses="clos20,clos80" width="100%">
                        <h:outputText value="Total:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_montant_ligne}" readonly="true" style="text-align:right">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                        <h:outputText value="Imputation:" />
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_montant_impute}" readonly="true" style="text-align:right">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                        <h:outputText value="Ecart:" />
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_ecart}" readonly="true" style="text-align:right">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:panelGrid>
                </h:panelGrid>
            </h:panelGrid>
            <br>
            <h:panelGrid id="idPanRepartition" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_affiche_saisie_anal}">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.dataModelDetAnalytique}" var="saisieAnal" width="100%" height="300px" style="border: solid 1px" >
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.selectionAnalytique}"/>
                        <rich:column id="gprActivite" label="Activité" width="15%" sortable="true" sortBy="#{saisieAnal.ecranaActivite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_activite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique<=90}">
                            <f:facet name="header"><h:outputText  value="Activité" /></f:facet>
                            <h:outputText value="#{saisieAnal.ecranaActivite} #{saisieAnal.ecranaActiviteLib}" title="#{table.ecranaActivite} #{saisieAnal.ecranaActiviteLib}"/>
                        </rich:column>
                        <rich:column label="Site" width="15%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_site&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique<=90}">
                            <f:facet name="header"><h:outputText  value="Site"/></f:facet>
                            <h:outputText value="#{saisieAnal.ecranaSite} #{saisieAnal.ecranaSiteLib}" title="#{table.ecranaSite} #{saisieAnal.ecranaSiteLib}"/>
                        </rich:column>
                        <rich:column label="Département" width="15%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_departement&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique<=90}">
                            <f:facet name="header"><h:outputText  value="Département" /></f:facet>
                            <h:outputText value="#{saisieAnal.ecranaDepartement} #{saisieAnal.ecranaDepartementLib}" title="#{table.ecranaDepartement} #{saisieAnal.ecranaDepartementLib}"/>
                        </rich:column>
                        <rich:column label="Service"  width="15%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_service&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique<=90}">
                            <f:facet name="header"><h:outputText value="Service"/></f:facet>
                            <h:outputText value="#{saisieAnal.ecranaService} #{saisieAnal.ecranaServiceLib}" title="#{table.ecranaService} #{saisieAnal.ecranaServiceLib}"/>
                        </rich:column>
                        <rich:column label="Région" width="15%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_region&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique<=90}">
                            <f:facet name="header"><h:outputText  value="Région"/></f:facet>
                            <h:outputText value="#{saisieAnal.ecranaRegion} #{saisieAnal.ecranaRegionLib}" title="#{table.ecranaRegion} #{saisieAnal.ecranaRegionLib}"/>
                        </rich:column>
                        <rich:column label="Secteur" width="15%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_secteur&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique<=90}">
                            <f:facet name="header"><h:outputText  value="Secteur" /></f:facet>
                            <h:outputText value="#{saisieAnal.ecranaSecteur} #{saisieAnal.ecranaSecteurLib}" title="#{table.ecranaSecteur} #{saisieAnal.ecranaSecteurLib}"/>
                        </rich:column>
                        <rich:column label="Pdv"  width="15%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_pdv&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique<=90}">
                            <f:facet name="header"><h:outputText value="Pdv"/></f:facet>
                            <h:outputText value="#{saisieAnal.ecranaPdv} #{saisieAnal.ecranaPdvLib}" title="#{table.ecranaPdv} #{saisieAnal.ecranaPdvLib}"/>
                        </rich:column>
                        <rich:column label="Site Production" width="15%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_sitePrdv&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique<=90}">
                            <f:facet name="header"><h:outputText  value="Site"/></f:facet>
                            <h:outputText value="#{saisieAnal.ecranaSite} #{saisieAnal.ecranaSiteLib}" title="#{table.ecranaSite} #{saisieAnal.ecranaSiteLib}"/>
                        </rich:column>
                        <rich:column label="Ligne" width="15%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_ligne&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique<=90}">
                            <f:facet name="header"><h:outputText  value="Ligne" /></f:facet>
                            <h:outputText value="#{saisieAnal.ecranaLigne} #{saisieAnal.ecranaLigneLib}" title="#{table.ecranaLigne} #{saisieAnal.ecranaLigneLib}"/>
                        </rich:column>
                        <rich:column label="Atelier"  width="15%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.affiche_atelier&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique<=90}">
                            <f:facet name="header"><h:outputText value="Atelier"/></f:facet>
                            <h:outputText value="#{saisieAnal.ecranaAtelier} #{saisieAnal.ecranaAtelierLib}" title="#{table.ecranaAtelier} #{saisieAnal.ecranaAtelierLib}"/>
                        </rich:column>
                        <rich:column id="idCodeActivite" label="Activité" width="25%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique==110}">
                            <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                            <h:inputText value="#{saisieAnal.ecranaActivite}" style="width:90%;height:19px" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_consult_analytique}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_consult_analytique}">
                                <rich:toolTip id="toolActivite" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un code activité ou d'un libellé d'activité" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.rechercherActivite}" reRender="panelActivite"/>
                            </h:inputText>
                        </rich:column>
                        <rich:column id="idLibActivite" label="Activite" width="40%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique==110}">
                            <f:facet name="header"><h:outputText  value="Libellé Activité"/></f:facet>
                            <h:outputText value="#{saisieAnal.ecranaActiviteLib}" title="#{table.ecranaActiviteLib}" />
                        </rich:column>
                        <rich:column label="Activité" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique==110}">
                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                            <h:outputText id="idAct1" style="width:90%" value="#{saisieAnal.zoneActivite}"/>
                        </rich:column>
                        <rich:column label="Analytique1" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique==110}">
                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                            <h:outputText id="idAct2" style="width:90%" value="#{saisieAnal.zoneAnal1}"/>
                        </rich:column>
                        <rich:column label="Analytique3" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique==110}">
                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                            <h:outputText id="idAct3" style="width:90%" value="#{saisieAnal.zoneAnal3}"/>
                        </rich:column>
                        <rich:column id="idCodeParc" label="Parc" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique==120}">
                            <f:facet name="header"><h:outputText  value="Immatriculation"/></f:facet>
                            <h:inputText value="#{saisieAnal.ecranaAnal2}" style="width:90%;height:19px" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_consult_analytique}">
                                <rich:toolTip id="toolParc" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'une immatriculation de véhicule ou d'un libellé de parc" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.rechercherParc}" reRender="panelParc"/>
                            </h:inputText>
                        </rich:column>
                        <rich:column id="idLibParc" label="Parc" width="40%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique==120}">
                            <f:facet name="header"><h:outputText  value="Libellé Parc"/></f:facet>
                            <h:outputText value="#{saisieAnal.ecranaAnal2Lib}" title="#{table.ecranaAnal2Lib}"/>
                        </rich:column>
                        <rich:column id="idCodeDossier" label="Dossier" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique==121}">
                            <f:facet name="header"><h:outputText  value="N° Dossier"/></f:facet>
                            <h:inputText value="#{saisieAnal.ecranaAnal4}" title="#{table.ecranaAnal4}" style="width:90%;height:19px" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_consult_analytique}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_consult_analytique}">
                                <rich:toolTip id="toolDossier" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un numéro de dossier ou d'un libellé d'un dossier" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.rechercherDossier}" reRender="panelDossier"/>
                            </h:inputText>
                        </rich:column>
                        <rich:column id="idLibDossier" label="Dossier" width="40%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique==121}">
                            <f:facet name="header"><h:outputText  value="Libellé Dossier"/></f:facet>
                            <h:outputText value="#{saisieAnal.ecranaAnal4Lib}" title="#{table.ecranaAnal4Lib}"/>
                        </rich:column>
                        <rich:column label="Agent" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique==122}">
                            <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                            <h:inputText value="#{saisieAnal.ecranaAnal3}" title="#{table.ecranaAnal3}" style="width:90%;height:19px" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_consult_analytique}"/>
                        </rich:column>
                        <rich:column label="Agent" width="40%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique==122}">
                            <f:facet name="header"><h:outputText  value="Nom et Prénom Agent"/></f:facet>
                            <h:outputText value="#{saisieAnal.ecranaAnal3Lib}" title="#{table.ecranaAnal3Lib}"/>
                        </rich:column>
                        <rich:column label="Structure" width="40%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_nature_analytique==200}">
                            <f:facet name="header"><h:outputText  value="Nom structure"/></f:facet>
                            <h:outputText value="#{saisieAnal.ecranaStrLib}" title="#{table.ecranaStrLib}"/>
                        </rich:column>
                        <rich:column label="pourcentage"  width="8%" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="%" /></f:facet>
                            <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_consult_analytique}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_consult_analytique}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.calculPourcentage}" reRender="idRepartitionAnal" focus="idRepartitionAnal"/>
                            </h:inputText>
                        </rich:column>
                        <rich:column label="Montant"  width="15%" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                            <h:inputText id="idRepartitionAnal" value="#{saisieAnal.ecranaMontantSaisie}" style="text-align:right;width:90%;height:20px" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_consult_analytique}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_consult_analytique}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.controleEcartAnalytique}" reRender="idPanAnal,idPanValAnal,idPanRepartition" />
                            </h:inputText>
                        </rich:column>
                        <rich:column label="Supprimer répartition"  width="5%" style="text-align:center;">
                            <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/supprimer.png" style="width:17px;height:17px;text-align:center;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.supprimerAnalytique}" reRender="idTableAnal,idPanValAnal,idPanTotalAnal" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_consult_analytique}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGroup>
            <center>
                <a4j:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.fermerDetailsAnalytique}" reRender="idSubView"/>
            </center>
        </h:panelGroup>

    </a4j:form>

</f:subview>