<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="listeabs">

    <a4j:form>

        <center> <h2><h:outputText value="ABSENCES OU RETARDS" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="panelRecherche" >
            <h:panelGrid id="panCtrl"  styleClass="recherche"  width="100%">
                <h:panelGrid columns="9" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_more_search}"/>
                    <h:column>
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_nat_rec}">
                            <f:selectItem itemLabel="Toutes natures" itemValue="100"/>
                            <f:selectItem itemLabel="Demande d'absence" itemValue="10"/>
                            <f:selectItem itemLabel="Absence payée" itemValue="11"/>
                            <f:selectItem itemLabel="Absence non payée" itemValue="12"/>
                            <f:selectItem itemLabel="Absence payée à déduire sur congés" itemValue="13"/>
                            <f:selectItem itemLabel="Absence payée pour repos médical" itemValue="16"/>
                            <f:selectItem itemLabel="Absence payée pour visite médicale" itemValue="17"/>
                            <f:selectItem itemLabel="Retard non payé" itemValue="14"/>
                            <f:selectItem itemLabel="Retard payé" itemValue="15"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.calculeConges}" reRender="panCtrl,tableSalaries,scrollTable,boutonSalaries"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_valide_rec}">
                            <f:selectItem itemLabel="Tout Etat" itemValue="100"/>
                            <f:selectItem itemLabel="En cours" itemValue="0"/>
                            <f:selectItem itemLabel="Validé" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_etat_rec}">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItem itemLabel="Actif" itemValue="0"/>
                            <f:selectItem itemLabel="En congès" itemValue="1"/>
                            <f:selectItem itemLabel="Licencié" itemValue="2"/>
                            <f:selectItem itemLabel="Démissioné" itemValue="3"/>
                            <f:selectItem itemLabel="Licencié" itemValue="4"/>
                            <f:selectItem itemLabel="Retraité" itemValue="5"/>
                            <f:selectItem itemLabel="Fin de contrat" itemValue="6"/>
                            <f:selectItem itemLabel="Arret/Suspendu" itemValue="7"/>
                            <f:selectItem itemLabel="Mutation" itemValue="8"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_nature_rec}">
                            <f:selectItem itemLabel="Toutes Natures agents" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.mesNatureAgentItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_feuille_rec}">
                            <f:selectItem itemLabel="Toutes Feuilles" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.mesFeuillesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_service_rec}">
                            <f:selectItem itemLabel="Tous Services" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.mesServiceItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_activite_rec}">
                            <f:selectItem itemLabel="Toutes Activités" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.mesActiviteItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.rechercherSalarieAbs}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,boutonSalaries,scrollTable1,tableSalaries1,scrollTable2,tableSalaries2"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panSuite" columns="12" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_more_search}">
                    <h:column><h:outputText value="Du"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column>
                        <h:selectOneMenu id="sit" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_site_rec}">
                            <f:selectItem itemLabel="Tous Sites" itemValue="100"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="dep" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_departement_rec}">
                            <f:selectItem itemLabel="Tous Départements" itemValue="100"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="niveau" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_niveau_rec}">
                            <f:selectItem itemLabel="Tous Niveaux" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.mesNiveauxEmploisItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="classement" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_classement_rec}">
                            <f:selectItem itemLabel="Tous Classements" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.mesClassementsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="centre" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_centre_rec}">
                            <f:selectItem itemLabel="Tous Centres" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.mesCentresImpotsItems}"/>
                        </h:selectOneMenu>
                    </h:column>                  
                    <h:column></h:column>
                    <h:column></h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid  id="boutonSalaries" columns="10" width="400px" style="height:34px">
            <a4j:commandButton title="Ajouter une nouvelle absence" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.ajoutCp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.ajouterAbsences}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier l'absence sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_affiche_absences&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.modifierAbsences}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter l'absence sélectionnée" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_affiche_absences}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.consulterAbsences}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer l'absence sélectionnée" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_affiche_absences&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.supprimerAbsences}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente')" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_affiche_absences&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
            <a4j:commandButton title="Valider l'absence sélectionnée" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.usersChronoAbsence.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.usersChronoAbsence.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_affiche_absences&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.valideAbsences}" onclick="if (!confirm('Etes-vous sur de vouloir valider cette absence ?')) return false" reRender="boutonSalaries,idEtatCp1,idEtatCp2"/>
            <a4j:commandButton title="Dé-Valider l'absence sélectionnée" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.usersChronoAbsence.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.usersChronoAbsence.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_affiche_absences&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.deValideAbsences}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider cette absence ?')) return false" reRender="boutonSalaries,idEtatCp1,idEtatCp2"/>
            <a4j:commandButton title="Consulter le bulletin généré" image="/images/bulletin.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_affiche_absences}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.consulterBulletinAbsences}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelBulletin"/>
            <a4j:commandButton title="Informations sur l'absence" image="/images/info.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.informationPieceABS}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_affiche_absences}" reRender="panelInformation"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.optionPaye.triAgents=='0'}" var="sal1">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.pageIndex}" reRender="tableSalaries1" id="scrollTable1" maxPages="20"align="left" for="tableSalaries1"/>
                    <rich:extendedDataTable groupingColumn="idMat" rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_nb_max}" border="0" enableContextMenu="true" id="tableSalaries1" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="130%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.dataModelAbsences}" var="cps" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.simpleSelectionEnteteAb}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.extDTableAb}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.selectionAbsences}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.visualisationAbsences}" reRender="idSubView,boutonSalaries"/>
                        <rich:column id="idMat"label="Matricule agent" sortable="true" width="70px" sortBy="#{cps.salaries.salMatricule}" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                            <h:outputText value="#{cps.salaries.salMatricule}" style="#{cps.protege}"/>
                        </rich:column>
                        <rich:column label="Nature agent" sortable="true" width="100px" sortBy="#{cps.salaries.lib_nature}">
                            <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                            <h:outputText value="#{cps.salaries.lib_nature}" style="#{cps.protege}"/>
                        </rich:column>
                        <rich:column id="idEtatCp1" label="Etat" sortable="true" width="70px" sortBy="#{cps.libelleEtat}">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{cps.libelleEtat}" style="#{cps.protege}"/>
                        </rich:column>
                        <rich:column label="Nom et prénom" sortable="true" width="200px" sortBy="#{cps.salaries.patronyme}">
                            <f:facet name="header"><h:outputText  value="Nom et prénom" /></f:facet>
                            <h:outputText value="#{cps.salaries.patronyme}" style="#{cps.protege}"/>
                        </rich:column>
                        <rich:column label="N° Contrat" sortable="true" width="80px" sortBy="#{cps.salcngContrat}">
                            <f:facet name="header"><h:outputText  value="Contrat" /></f:facet>
                            <h:outputText value="#{cps.salcngContrat}" style="#{cps.protege}"/>
                        </rich:column>
                        <rich:column label="Nature" sortable="true" width="200px" sortBy="#{cps.lib_nature}">
                            <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                            <h:outputText value="#{cps.lib_nature}" style="#{cps.protege}"/>
                        </rich:column>
                        <rich:column label="Date début" sortable="true" width="70px" sortBy="#{cps.salcngDateDebut}">
                            <f:facet name="header"><h:outputText  value="Début" /></f:facet>
                            <h:outputText value="#{cps.salcngDateDebut}" style="#{cps.protege}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date fin" sortable="true" width="70px" sortBy="#{cps.salcngDateFin}">
                            <f:facet name="header"><h:outputText  value="Fin" /></f:facet>
                            <h:outputText value="#{cps.salcngDateFin}" style="#{cps.protege}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Nombre jours" sortable="true" width="60px" sortBy="#{cps.salcngDuree}" style="text-align:right">
                            <f:facet name="header"><h:outputText  value="Nb J." /></f:facet>
                            <h:outputText value="#{cps.salcngDuree}"  style="#{cps.protege};text-align:right" rendered="#{cps.salcngDuree!=0}"/>
                        </rich:column>
                        <rich:column label="Nombre heures" sortable="true" width="60px" sortBy="#{cps.salcngNbHeure}" style="text-align:right">
                            <f:facet name="header"><h:outputText  value="Nb H." /></f:facet>
                            <h:outputText value="#{cps.salcngNbHeure}"  style="#{cps.protege};text-align:right" rendered="#{cps.salcngNbHeure!=0}"/>
                        </rich:column>
                        <rich:column label="Objet" sortable="true" width="500px" sortBy="#{cps.salcngObjet}">
                            <f:facet name="header"><h:outputText  value="Objet" /></f:facet>
                            <h:outputText value="#{cps.salcngObjet}" style="#{cps.protege}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </c:if>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.optionPaye.triAgents=='1'}" var="sal2">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.pageIndex}" reRender="tableSalaries2" id="scrollTable2" maxPages="20"align="left" for="tableSalaries2"/>
                    <rich:extendedDataTable groupingColumn="idSal" rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_nb_max}" border="0" enableContextMenu="true" id="tableSalaries2" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="130%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.dataModelAbsences}" var="cps" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.simpleSelectionEnteteAb}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.extDTableAb}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.selectionAbsences}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.visualisationAbsences}" reRender="idSubView,boutonSalaries"/>
                        <rich:column label="Matricule agent" sortable="true" width="70px" sortBy="#{cps.salaries.salMatricule}">
                            <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                            <h:outputText value="#{cps.salaries.salMatricule}" style="#{cps.protege}"/>
                        </rich:column>
                        <rich:column label="Nature agent" sortable="true" width="100px" sortBy="#{cps.salaries.lib_nature}">
                            <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                            <h:outputText value="#{cps.salaries.lib_nature}" style="#{cps.protege}"/>
                        </rich:column>
                        <rich:column id="idEtatCp2" label="Etat" sortable="true" width="70px" sortBy="#{cps.libelleEtat}">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{cps.libelleEtat}" style="#{cps.protege}"/>
                        </rich:column>
                        <rich:column id="idSal" label="Nom et prénom" sortable="true" width="200px" sortBy="#{cps.salaries.patronyme}" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="Nom et prénom" /></f:facet>
                            <h:outputText value="#{cps.salaries.patronyme}" style="#{cps.protege}"/>
                        </rich:column>
                        <rich:column label="N° Contrat" sortable="true" width="80px" sortBy="#{cps.salcngContrat}">
                            <f:facet name="header"><h:outputText  value="Contrat" /></f:facet>
                            <h:outputText value="#{cps.salcngContrat}" style="#{cps.protege}"/>
                        </rich:column>
                        <rich:column label="Nature" sortable="true" width="200px" sortBy="#{cps.lib_nature}">
                            <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                            <h:outputText value="#{cps.lib_nature}" style="#{cps.protege}"/>
                        </rich:column>
                        <rich:column label="Date début" sortable="true" width="70px" sortBy="#{cps.salcngDateDebut}">
                            <f:facet name="header"><h:outputText  value="Début" /></f:facet>
                            <h:outputText value="#{cps.salcngDateDebut}" style="#{cps.protege}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date fin" sortable="true" width="70px" sortBy="#{cps.salcngDateFin}">
                            <f:facet name="header"><h:outputText  value="Fin" /></f:facet>
                            <h:outputText value="#{cps.salcngDateFin}" style="#{cps.protege}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Nombre jours" sortable="true" width="60px" sortBy="#{cps.salcngDuree}" style="text-align:right">
                            <f:facet name="header"><h:outputText  value="Nb J." /></f:facet>
                            <h:outputText value="#{cps.salcngDuree}"  style="#{cps.protege};text-align:right" rendered="#{cps.salcngDuree!=0}"/>
                        </rich:column>
                        <rich:column label="Nombre heures" sortable="true" width="60px" sortBy="#{cps.salcngNbHeure}" style="text-align:right">
                            <f:facet name="header"><h:outputText  value="Nb H." /></f:facet>
                            <h:outputText value="#{cps.salcngNbHeure}"  style="#{cps.protege};text-align:right" rendered="#{cps.salcngNbHeure!=0}"/>
                        </rich:column>
                        <rich:column label="Objet" sortable="true" width="500px" sortBy="#{cps.salcngObjet}">
                            <f:facet name="header"><h:outputText  value="Objet" /></f:facet>
                            <h:outputText value="#{cps.salcngObjet}" style="#{cps.protege}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </c:if>
        </div>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="480" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitationPaye.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelBulletin" width="900" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.showModalPanelBulletin}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.showModalPanelBulletin}" var="bul">
            <f:facet name="header"><h:outputText value="BULLETIN DU : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.bulsalPeriode} POUR #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.salaries.salMatricule} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.salaries.salNom}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanBulletin" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.fermerConsulterBulletin}" styleClass="hidelink" reRender="panelBulletin"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanBulletin')}.click()" />
                </a4j:form>
            </f:facet>
            <jsp:include flush="true" page="/paye/FicheSalarieBulletins.jsp" />
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelInformation" width="600" height="160" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.showModalPanelInformation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.showModalPanelInformation}" var="inf">
            <f:facet name="header"><h:outputText value="INFORMATION SUR L`ABSENCE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.fermerInformationPiece}" image="/images/close.gif" styleClass="hidelink" reRender="panelInformation"/>
                </a4j:form >
            </f:facet>
            <a4j:form id="formLpr">
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos30,clos70">
                    <h:outputText value="ID congés:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngId}"/>
                    <h:outputText value="Date de création:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngDateCreat}" datePattern="dd/MM/yyyy hh:mm:ss"  locale="fr" style=" background-color:white;" inputSize="20" readonly="true" disabled="true"/>
                    <h:outputText value="Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.nomCreation} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngUserCreat})"/>
                    <h:outputText value="Modifié le:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngDateModif}" datePattern="dd/MM/yyyy hh:mm:ss"  locale="fr" style=" background-color:white;" inputSize="20"  readonly="true" disabled="true"/>
                    <h:outputText value="Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.nomModification} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngUserModif})"/>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
