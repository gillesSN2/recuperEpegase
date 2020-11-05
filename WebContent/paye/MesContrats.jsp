<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<h:panelGrid style="width:100%;" id="panMesContrats">

    <a4j:form>

         <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.groupe.grpModulePay==2}">
            <center><h2><h:outputText value="MES CONTRATS (#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPatronyme})" style="color:green;" /></h2></center>
        </h:column>

        <h:panelGrid id="panContrat" width="100%">
            <jsp:include flush="true" page="/paye/FicheSalarieCommun.jsp" />
            <h:panelGrid width="250px" id="panelBoutonContrat" columns="5" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.groupe.grpModulePay!=2&&bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                <a4j:commandButton title="Ajouter un nouveau contrat" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_ajt}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.ajouterContrat}" reRender="panelContrat"/>
                <a4j:commandButton title="Modifier le contrat sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_contrat&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_mod&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconEtatH==0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.modifierContrat}" reRender="panelContrat"/>
                <a4j:commandButton title="Consulter le contrat sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_contrat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.consulterContrat}" reRender="panelContrat"/>
                <a4j:commandButton title="Supprimer le contrat sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_contrat&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconEtatH==0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.supprimerContrat}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelBoutonContrat,tableContrat"/>
                <a4j:commandButton title="Valider le contrat sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.usersChronoContrat.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.usersChronoContrat.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_contrat&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconEtatH==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_mod}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.valideContrat}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce contrat ?')) return false" reRender="panelBoutonContrat,idEtatContrat"/>
                <a4j:commandButton title="Dé-Valider le contrat sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.usersChronoContrat.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.usersChronoContrat.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_contrat&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconEtatH==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_mod}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.deValideContrat}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce contrat ?')) return false" reRender="panelBoutonContrat,idEtatContrat"/>
            </h:panelGrid>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable border="0" enableContextMenu="false" id="tableContrat" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.dataModelContrat}" var="contrat" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.simpleSelectionEnteteCrt}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.extDTableCrt}">
                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.selectionContrat}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBoutonContrat"/>
                    <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.visualisationFicheContrat}" reRender="idSubView,panelBoutonContrat"/>
                    <rich:column label="Nature du contrat" sortable="true" width="10%" sortOrder="#{contrat.lib_nature}">
                        <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                        <h:outputText value="#{contrat.lib_nature}"/>
                    </rich:column>
                    <rich:column id="idEtatContrat" label="Etat du contrat" sortable="true" width="5%" sortOrder="#{contrat.salconEtatH}">
                        <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                        <h:outputText value="#{contrat.libelleEtat}"/>
                    </rich:column>
                    <rich:column label="Feuille" sortable="true" width="5%" sortOrder="#{contrat.salconFeuille}">
                        <f:facet name="header"><h:outputText  value="Feuille" /></f:facet>
                        <h:outputText value="#{contrat.salconFeuille}"/>
                    </rich:column>
                    <rich:column label="Statut du contrat" sortable="true" width="8%" sortOrder="#{contrat.lib_etat}">
                        <f:facet name="header"><h:outputText  value="Statut" /></f:facet>
                        <h:outputText value="#{contrat.lib_etat}"/>
                    </rich:column>
                    <rich:column label="Date début du contrat" sortable="true" width="9%" sortOrder="#{contrat.salconDateDebut}">
                        <f:facet name="header"><h:outputText  value="Début" /></f:facet>
                        <h:outputText value="#{contrat.salconDateDebut}">
                            <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Date fin du contrat" sortable="true" width="9%" sortOrder="#{contrat.salconDateFin}">
                        <f:facet name="header"><h:outputText  value="Fin" /></f:facet>
                        <h:outputText value="#{contrat.salconDateFin}">
                            <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Fonction" sortable="true" width="8%" sortOrder="#{contrat.salconFonction}">
                        <f:facet name="header"><h:outputText  value="Fonction" /></f:facet>
                        <h:outputText value="#{contrat.salconFonction}"/>
                    </rich:column>
                    <rich:column label="Service" sortable="true" width="8%" sortOrder="#{contrat.salconService}">
                        <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                        <h:outputText value="#{contrat.salconService} #{contrat.salconLibService}"/>
                    </rich:column>
                    <rich:column label="Projet" sortable="true" width="8%" sortOrder="#{contrat.salconProjet}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.accesProjet}">
                        <f:facet name="header"><h:outputText  value="Projet" /></f:facet>
                        <h:outputText value="#{contrat.salconProjet} #{contrat.salconLibProjet}"/>
                    </rich:column>
                    <rich:column label="Activite" sortable="true" width="8%" sortOrder="#{contrat.salconActivite}">
                        <f:facet name="header"><h:outputText  value="Activite" /></f:facet>
                        <h:outputText value="#{contrat.salconActivite}"/>
                    </rich:column>
                    <rich:column label="Localisation" sortable="true" width="8%" sortOrder="#{contrat.salconLocalisation}">
                        <f:facet name="header"><h:outputText  value="Localisation" /></f:facet>
                        <h:outputText value="#{contrat.salconLocalisation}"/>
                    </rich:column>
                    <rich:column label="Parc" sortable="true" width="8%" sortOrder="#{contrat.salconParc}">
                        <f:facet name="header"><h:outputText  value="Parc" /></f:facet>
                        <h:outputText value="#{contrat.salconParc}"/>
                    </rich:column>
                    <rich:column label="Date remise du contrat" sortable="true" width="8%" sortOrder="#{contrat.salconDateRemise}">
                        <f:facet name="header"><h:outputText  value="Remise" /></f:facet>
                        <h:outputText value="#{contrat.salconDateRemise}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Date retour du contrat" sortable="true" width="8%" sortOrder="#{contrat.salconDateRetour}">
                        <f:facet name="header"><h:outputText  value="Retour" /></f:facet>
                        <h:outputText value="#{contrat.salconDateRetour}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </h:panelGrid>
    </a4j:form>

</h:panelGrid>

