<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="affaires">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center><h2><h:outputText styleClass="titre" value="GESTION DU PORTEFEUILLE D'AFFAIRES (SPANCO)" /></h2></center>

        <h:panelGrid id="panCtrl" columns="1" width="100%" styleClass="recherche">
            <h:panelGrid  columns="11"  width="100%" id="recherche" >
                <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_more_search}"/>
                <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_more_search}"/>
                <h:column><h:outputText value="Client:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.tiersRec}" size="10"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_more_search}">
                        <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesPeriodesItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.etatRec}" style="width:100px;">
                        <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                        <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesEtatsItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.modeRec}" style="width:130px;">
                        <f:selectItem itemLabel="Tous modes" itemValue="99"/>
                        <f:selectItem itemLabel="Normal" itemValue="0"/>
                        <f:selectItem itemLabel="Urgent" itemValue="1"/>
                        <f:selectItem itemLabel="Tres urgent" itemValue="2"/>
                        <f:selectItem itemLabel="Appel offre" itemValue="3"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dossierRec}" style="width:130px;">
                        <f:selectItem itemLabel="Tous types" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.mesNaturesAffaires}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.chargerLesAffaires}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="scrollTable,tableAffaires"/>
                    <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                </h:column>
            </h:panelGrid>
            <h:panelGrid id="panDest" columns="8" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_more_search}">
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.userRec}" style="width:200px;">
                        <f:selectItem itemLabel="Tous responsables" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.mesUsersItem}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.comRec}" style="width:200px;">
                        <f:selectItem itemLabel="Tous commerciaux" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.mesCommercialItem}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Affaire:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.affaireRec}" size="10"/></h:column>
                <h:column><h:outputText value="Du:"/></h:column>
                <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                <h:column><h:outputText value="Au:"/></h:column>
                <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid columns="12" width="400" id="btnAffaires" style="height:34">
            <a4j:commandButton title="Ajouter une nouvelle affaire" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.ajouterAffaires}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier l'affaire sélectionnée" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.modifierAffaires}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.afficheButtOption&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireEtat==0}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter l'affaire sélectionnée" image="/images/detail.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.consulterAffaires}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.afficheButtOption}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Calculer l'affaire sélectionnée" image="/images/actualiser.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.calculerAffaires}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.afficheButtOption}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente"/>
            <a4j:commandButton title="Supprimer le document sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.afficheButtOption&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.supprimerDocument}" reRender="modAttente,tableAffaires,btnAffaires"/>
            <a4j:commandButton title="Annuler le document sélectionné" image="/images/annuler_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.afficheButtOption&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireEtat==4)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.sup}" onclick="if (!confirm('Etes-vous sur de vouloir annuler ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.annulerDocument}" reRender="panelAnnuler"/>
            <a4j:commandButton title="Geler le document sélectionné" image="/images/geler.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.afficheButtOption&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireEtat==4)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.sup}" onclick="if (!confirm('Etes-vous sur de vouloir geler ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.gelerDocument}" reRender="panelGeler,formGeler"/>
            <a4j:commandButton title="Dégeler le document sélectionné" image="/images/degeler.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.afficheButtOption&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireEtat==3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.sup}" onclick="if (!confirm('Etes-vous sur de vouloir dégeler ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.miseajourDeGeler}" reRender="modAttente,tableAffaires,btnAffaires"/>
            <a4j:commandButton title="Impression" image="/images/print.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.afficheButtOption}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
            <a4j:commandButton title="Grapher" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.afficheButtOption&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}" reRender="panelGraph,formModalGraph,container" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.initGrapheur}"/>
            <a4j:commandButton title="Valider le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.afficheButtOption&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document ?')) return false" reRender="btnAffaires,idEtat"/>
            <a4j:commandButton title="Dé-Valider le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.afficheButtOption&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document ?')) return false" reRender="btnAffaires,idEtat"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.pageIndex}" reRender="tableAffaires" id="scrollTable" maxPages="20" align="left" for="tableAffaires"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableAffaires" border="0" width="270%" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelAffaires}" var="affaires" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.selectionAffaires}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,btnAffaires"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.visualisationLigne}" reRender="idSubView,btnAffaires"/>
                        <rich:column label="Année"  width="50px" sortBy="#{affaires.anaAnnee}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Année"/></f:facet>
                            <h:outputText value="#{affaires.anaAnnee}"/>
                        </rich:column>
                        <rich:column label="Code affaire" sortBy="#{affaires.anaCodeComplet}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Code"/></f:facet>
                            <h:outputText value="#{affaires.anaCodeComplet}"/>
                        </rich:column>
                        <rich:column label="Analytique" sortBy="#{affaires.anaAnalytique}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Anal."/></f:facet>
                            <h:outputText value="#{affaires.anaAnalytique} (#{affaires.anaIndice})"/>
                        </rich:column>
                        <rich:column id="idEtat" label="Etat affaire" width="80px" sortBy="#{affaires.libelle_etat}" sortable="true"  style="text-align:center">
                            <f:facet name="header"> <h:outputText value="Etat"/></f:facet>
                            <h:outputText value="#{affaires.libelle_etat}"/>
                        </rich:column>
                        <rich:column label="Client" width="150px" sortBy="#{affaires.anaAffaireNomClient}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Client"/></f:facet>
                            <h:outputText value="#{affaires.anaAffaireNomClient}"/>
                        </rich:column>
                        <rich:column label="Contact" width="150px" sortBy="#{affaires.anaAffaireNomContact}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Contact"/></f:facet>
                            <h:outputText value="#{affaires.anaAffaireNomContact}"/>
                        </rich:column>
                        <rich:column label="Objet" width="200px" sortBy="#{affaires.anaNomFr}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Objet"/></f:facet>
                            <h:outputText value="#{affaires.anaNomFr}" rendered="#{affaires.anaAffaireEtat!=2&&affaires.anaAffaireEtat!=3}" style="color:black"/>
                            <h:outputText value="#{affaires.anaTiersAdresse}" rendered="#{affaires.anaAffaireEtat==2||affaires.anaAffaireEtat==3}" style="color:red"/>
                        </rich:column>
                        <rich:column label="Source" sortBy="#{affaires.anaTierssource}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Source"/></f:facet>
                            <h:outputText value="#{affaires.anaTierssource}"/>
                        </rich:column>
                        <rich:column label="Nb jours de retard" width="50px" sortBy="#{affaires.nbJourRetard}" sortable="true" style="text-align:center">
                            <f:facet name="header"> <h:outputText value="Retard"/></f:facet>
                            <h:outputText value="#{affaires.nbJourRetard}" rendered="#{affaires.nbJourRetard>=0}" style="color:red"/>
                            <h:outputText value="#{affaires.nbJourRetard}" rendered="#{affaires.nbJourRetard<0}" style="color:black"/>
                        </rich:column>
                        <rich:column label="Date demande" sortBy="#{affaires.anaAffaireDateDemande}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Date dem."/></f:facet>
                            <h:outputText value="#{affaires.anaAffaireDateDemande}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date limite de réponse" sortBy="#{affaires.anaAffaireDatelimite}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Date lim."/></f:facet>
                            <h:outputText value="#{affaires.anaAffaireDatelimite}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date remise devis" sortBy="#{affaires.anaAffaireDateDevis}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Date DVS."/></f:facet>
                            <h:outputText value="#{affaires.anaAffaireDateDevis}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Mode affaire" width="80px" sortBy="#{affaires.libelle_mode}" sortable="true" style="text-align:center">
                            <f:facet name="header"> <h:outputText value="Mode"/></f:facet>
                            <h:outputText value="#{affaires.libelle_mode}" rendered="#{affaires.anaAffaireMode==0}"/>
                            <h:outputText value="#{affaires.libelle_mode}" rendered="#{affaires.anaAffaireMode==1}" style="color:purple"/>
                            <h:outputText value="#{affaires.libelle_mode}" rendered="#{affaires.anaAffaireMode==2}" style="color:red"/>
                            <h:outputText value="#{affaires.libelle_mode}" rendered="#{affaires.anaAffaireMode==3}" style="color:blue"/>
                        </rich:column>
                        <rich:column label="Mode affaire" width="50px" sortBy="#{affaires.libelle_tva}" sortable="true" style="text-align:center">
                            <f:facet name="header"> <h:outputText value="TVA"/></f:facet>
                            <h:outputText value="#{affaires.libelle_tva}"/>
                        </rich:column>
                        <rich:column label="Mode affaire" width="50px" sortBy="#{affaires.libelle_douane}" sortable="true" style="text-align:center">
                            <f:facet name="header"> <h:outputText value="Douane"/></f:facet>
                            <h:outputText value="#{affaires.libelle_douane}"/>
                        </rich:column>
                        <rich:column label="Avion" width="50px" sortBy="#{affaires.anaAffaireAvion}" sortable="true" style="text-align:center">
                            <f:facet name="header"> <h:outputText value="AV"/></f:facet>
                            <h:outputText value="*" rendered="#{affaires.anaAffaireAvion==1}"/>
                        </rich:column>
                        <rich:column label="Bateau" width="50px" sortBy="#{affaires.anaAffaireBateau}" sortable="true" style="text-align:center">
                            <f:facet name="header"> <h:outputText value="BA"/></f:facet>
                            <h:outputText value="*" rendered="#{affaires.anaAffaireBateau==1}"/>
                        </rich:column>
                        <rich:column label="Express" width="50px" sortBy="#{affaires.anaAffaireExpress}" sortable="true" style="text-align:center">
                            <f:facet name="header"> <h:outputText value="EX"/></f:facet>
                            <h:outputText value="*" rendered="#{affaires.anaAffaireExpress==1}"/>
                        </rich:column>
                        <rich:column label="Route" width="50px" sortBy="#{affaires.anaAffaireRoute}" sortable="true" style="text-align:center">
                            <f:facet name="header"> <h:outputText value="RT"/></f:facet>
                            <h:outputText value="*" rendered="#{affaires.anaAffaireRoute==1}"/>
                        </rich:column>
                        <rich:column label="Réacheminement 1" width="50px" sortBy="#{affaires.anaAffaireReachem1}" sortable="true" style="text-align:center">
                            <f:facet name="header"> <h:outputText value="R1"/></f:facet>
                            <h:outputText value="*" rendered="#{affaires.anaAffaireReachem1==1}"/>
                        </rich:column>
                        <rich:column label="Réacheminement 2" width="50px" sortBy="#{affaires.anaAffaireReachem2}" sortable="true" style="text-align:center">
                            <f:facet name="header"> <h:outputText value="R2"/></f:facet>
                            <h:outputText value="*" rendered="#{affaires.anaAffaireReachem2==1}"/>
                        </rich:column>
                        <rich:column label="Réacheminement 3" width="50px" sortBy="#{affaires.anaAffaireReachem3}" sortable="true" style="text-align:center">
                            <f:facet name="header"> <h:outputText value="R3"/></f:facet>
                            <h:outputText value="*" rendered="#{affaires.anaAffaireReachem3==1}"/>
                        </rich:column>
                        <rich:column label="Responsable" width="150px" sortBy="#{affaires.anaAffaireNomResponsable}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Responsable"/></f:facet>
                            <h:outputText value="#{affaires.anaAffaireNomResponsable}"/>
                        </rich:column>
                        <rich:column label="Date commande" sortBy="#{affaires.anaAffaireDateCommande}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Date CMD"/></f:facet>
                            <h:outputText value="#{affaires.anaAffaireDateCommande}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date réception" sortBy="#{affaires.anaAffaireDateReception}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Date REC."/></f:facet>
                            <h:outputText value="#{affaires.anaAffaireDateReception}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date livraison" sortBy="#{affaires.anaAffaireDateLivree}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Date LIV."/></f:facet>
                            <h:outputText value="#{affaires.anaAffaireDateLivree}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date facture" sortBy="#{affaires.anaAffaireDateFacture}" sortable="true">
                            <f:facet name="header"> <h:outputText value="Date FAC."/></f:facet>
                            <h:outputText value="#{affaires.anaAffaireDateFacture}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Commercial"  width="150px" sortable="true" sortBy="#{affaires.anaAffaireNomCommercial}">
                            <f:facet name="header"><h:outputText  value="Commercial" /></f:facet>
                            <h:outputText value="#{affaires.anaAffaireNomCommercial}"/>
                        </rich:column>
                        <rich:column label="Cout théorique" sortable="true" sortBy="#{affaires.anaAffaireTheo}" style="text-align:right">
                            <f:facet name="header"><h:outputText  value="Val. Théo" /></f:facet>
                            <h:outputText value="#{affaires.anaAffaireTheo}" rendered="#{affaires.anaAffaireTheo!=0}" style="text-align:right">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="PR Reel" sortable="true" sortBy="#{affaires.anaAffaireMargeReel}" style="text-align:right">
                            <f:facet name="header"><h:outputText  value="PR. Réel." /></f:facet>
                            <h:outputText value="#{affaires.anaAffaireMargeReel}" rendered="#{affaires.anaAffaireMargeReel!=0}" style="text-align:right">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Cout réelle" sortable="true" sortBy="#{affaires.anaAffaireReel}" style="text-align:right">
                            <f:facet name="header"><h:outputText  value="Val. Réel." /></f:facet>
                            <h:outputText value="#{affaires.anaAffaireReel}" rendered="#{affaires.anaAffaireReel!=0}" style="text-align:right">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
        </center>

        <br>
        <h:panelGroup>
            <center>
                <h:outputText value="LEGENDE DU SPANCO:"/><br>
                <h:outputText value="S: Suspect : Définition de la cible"/><br>
                <h:outputText value="P: Prospect : Identification du lead"/><br>
                <h:outputText value="A: Analyse ou Approche : Évaluation de la qualification du besoin et identification de la solution"/><br>
                <h:outputText value="N: Négociation : Processus de négociation"/><br>
                <h:outputText value="C: Conclusion : Finalisation de la commande"/><br>
                <h:outputText value="O: Order : Suivi du dossier, gestion de la commande et suivi de la vente"/><br><br>
                <h:column>
                    Cliquez  <A target="_blank" HREF="http://www.gexos.fr/gexos/spanco.html" TITLE="description" style="color:blue;"> ici </A>  pour des explications sur le SPANCO.
                </h:column>
            </center>
        </h:panelGroup>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="480" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <rich:hotKey key="return" handler="return false;"/>
            <a4j:form id="formModalGraph">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.valQteGraph}" >
                                <f:selectItem itemLabel="En nombre de document" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <f:selectItem itemLabel="par responsable" itemValue="1"/>
                                <f:selectItem itemLabel="par commercial" itemValue="2"/>
                                <f:selectItem itemLabel="par société" itemValue="4"/>
                                <f:selectItem itemLabel="par source" itemValue="7"/>
                                <f:selectItem itemLabel="par type" itemValue="8"/>
                                <f:selectItem itemLabel="par mode" itemValue="9"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <f:selectItem itemLabel="tranche horaire" itemValue="5"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelAnnuler" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.showModalPanelAnnuler}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.showModalPanelAnnuler}" var="ser">
            <f:facet name="header"><h:outputText value="Annulation Affaire"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.annuleAnnulation}" image="/images/close.gif" styleClass="hidelink" reRender="panelAnnuler"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Date annulation:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireDateAnnule}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Motif annulation:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaTiersAdresse}" maxlength="100"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.miseajourAnnuler}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelGeler" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.showModalPanelGele}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.showModalPanelGele}" var="gel">
            <f:facet name="header"><h:outputText value="Gèle l'affaire"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.annuleGeler}" image="/images/close.gif" styleClass="hidelink" reRender="panelGeler"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formGeler">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Date du gel:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireDateAnnule}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Motif du gel:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaTiersAdresse}" maxlength="100"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.miseajourGeler}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>