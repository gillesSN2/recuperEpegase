<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="medichospit">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center> <h2><h:outputText value="HOSPITALISATIONS" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid  id="panCtrl"  styleClass="recherche"  width="100%">
                <h:panelGrid columns="9" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_more_search}"/>
                    <h:column><h:outputText value="N° hospit."/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.inpNum}" size="5"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idFamille" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.inpFam}" style="width:150px;">
                            <f:selectItem itemLabel="Toutes Catégories" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesCategoriesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idEtat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesEtatsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idPeriode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_more_search}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesPeriodesItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu id="idActivite" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.inpActivite}" style="width:150px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.tActivite}">
                            <f:selectItem itemLabel="Toutes Activités" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesActivitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idService" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.inpService}" style="width:150px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesServicesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelBouton,table,scrollTable,pnlgrttotal"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="8" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_more_search}">
                    <h:column><h:outputText value="Nom:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.inpNomPatient}" /></h:column>
                    <h:column><h:outputText value="Prénom:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.inpPrenomPatient}"/></h:column>
                    <h:column><h:outputText value="Dossier entrée:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.inpDossier}"/></h:column>
                    <h:column><h:outputText value="Téléphone:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.inpTel}"/></h:column>
                    <h:column><h:outputText value="C.I./Sécu.:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.inpCi}"/></h:column>
                    <h:column><h:outputText value="Société:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.inpSociete}"/></h:column>
                    <h:column><h:outputText value="Assurance/IPM:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.inpAssurance}"/></h:column>
                    <h:column><h:outputText value="Mutuelle/Complémentaire:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.inpComplementaire}"/></h:column>
                    <h:column><h:outputText value="N° Contrat/Mat.:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.inpContrat}"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_affiche_protocole}"><h:outputText value="Protocole"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_affiche_protocole}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.inpProtocole}" size="10"/></h:column>
                    <h:column><h:outputText value="Du:"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au:"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="15" width="500px" style="height:34px">
            <a4j:commandButton title="Ajouter nouvelle hospitalisation" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.ajoutDocument}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.add}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier hospitalisation sélectionnée" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.modifDocument}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hospitalisationEntete.hosEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter" image="/images/detail.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.consultDocument}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.visibiliteBton}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer l'hospitalisation sélectionnée uniquement si en cours" image="/images/supprimer.png"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.supprimerDocument}" reRender="table,pangrpVisbt,intpTTCL,intpRGLMTL,intpSOLDL" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hospitalisationEntete.hosEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.sup}"/>
            <a4j:commandButton title="Annuler l'hospitalisation sélectionnée (Avoir) uniquement si validée" image="/images/annuler_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hospitalisationEntete.hosEtat==1&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hospitalisationEntete.hosRegPatient==0||bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrMedicalAvoir==1)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.sup}" onclick="if (!confirm('Etes-vous sur de vouloir annuler ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.annulerDocument}" reRender="panelAnnuler"/>
            <a4j:commandButton title="imprimer" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');" reRender="panelImp,formModalImp,panchoixdoc,optionMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
            <a4j:commandButton title="Grapher" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}" reRender="panelGraph,formModalGraph,container"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.initGrapheur}"/>
            <a4j:commandButton title="Imputer la série" image="/images/boussole.png" oncomplete="javascript:Richfaces.showModalPanel('panelimpSerie');" reRender="panelimpSerie" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.accesImputSerie}" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hospitalisationEntete.hosSerie=='X'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.clo}"/>
            <a4j:commandButton title="Dupliquer le document sélectionné" image="/images/duplicate.png"  onclick="if (!confirm('Etes-vous sur de vouloir dupliquer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.duppliquerDocument}" reRender="modAttente,table,pangrpVisbt,intpTTCL,intpRGLMTL,intpSOLDL" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.dup}"/>
            <a4j:commandButton title="Paiement (Bon d'encaissement) du document sélectionné" image="/images/bonCaisse.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hospitalisationEntete.hosEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_affiche_be}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.payeDocument}" reRender="panelBonEncaissement,panelBouton" />
            <a4j:commandButton title="Paiement (direct) du document sélectionné" image="/images/dollar.png" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hospitalisationEntete.hosEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_affiche_dollar}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.payeDirect}" reRender="panelPaye,panelBouton" />
            <a4j:commandButton title="Historique des règlements du document sélectionné" image="/images/histoPaiement.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hospitalisationEntete.hosEtat>=1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.histoReglement}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelHistoReglement" />
            <a4j:commandButton title="Valider le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hospitalisationEntete.hosEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document ?')) return false" reRender="panelBouton,table"/>
            <a4j:commandButton title="Dé-Valider le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hospitalisationEntete.hosDateTransfert==null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hospitalisationEntete.hosEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hospitalisationEntete.hosRegPatient==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document ?')) return false" reRender="panelBouton,table"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.datamodelHospitalisation}"  var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.selectionHospitalisation}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,pnlgrttotal"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.visualisationLigne}" reRender="idSubView,panelBouton,pnlgrttotal"/>
                        <rich:column label="N° Dossier patient" sortable="true" sortBy="#{var.patients.patDossier}" >
                            <f:facet name="header"><h:outputText  value="N° Dossier" /></f:facet>
                            <h:outputText value="#{var.patients.patDossier}" title="#{var.patients.patDossier}"/>
                        </rich:column>
                        <rich:column label="N° Hospitalisation" sortable="true" sortBy="#{var.hosNum}" >
                            <f:facet name="header"><h:outputText  value="N° Hospit." /></f:facet>
                            <h:outputText value="#{var.hosNum}" title="#{var.hosNum}"/>
                        </rich:column>
                        <rich:column label="Date" sortable="true" sortBy="#{var.hosDateEntree}" width="70px" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="Entrée" /></f:facet>
                            <h:outputText value="#{var.hosDateEntree}" title="#{var.hosDateEntree}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Motif entrée" sortable="true" sortBy="#{var.libelleCategorie}" width="100px">
                            <f:facet name="header"><h:outputText  value="M.Entrée" /></f:facet>
                            <h:outputText value="#{var.libelleCategorie}" title="#{var.libelleCategorie}"/>
                        </rich:column>
                        <rich:column label="Provenance" sortable="true" sortBy="#{var.libelleMotifEntree}" width="100px">
                            <f:facet name="header"><h:outputText  value="Provenance" /></f:facet>
                            <h:outputText value="#{var.libelleMotifEntree}" title="#{var.libelleMotifEntree}"/>
                        </rich:column>
                        <rich:column label="Date de sortie" sortable="true" sortBy="#{var.hosDateSortie}" width="70px">
                            <f:facet name="header"><h:outputText  value="Sortie" /></f:facet>
                            <h:outputText value="#{var.hosDateSortie}" title="#{var.hosDateSortie}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Motif destination" sortable="true" sortBy="#{var.libelleMotifSortie}" width="100px">
                            <f:facet name="header"><h:outputText  value="Destination" /></f:facet>
                            <h:outputText value="#{var.libelleMotifSortie}" rendered="#{var.hosDateSortie!=null}" title="#{var.libelleMotifSortie}"/>
                        </rich:column>
                        <rich:column label="Prise en charge" sortable="true" sortBy="#{var.hosPecCnamgs}" width="50px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.optionMedical.cnamgs=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}">
                            <f:facet name="header"><h:outputText  value="Pec" /></f:facet>
                            <h:outputText value="#{var.hosPecCnamgs}" style="text-align:right;" rendered="#{var.hosPecCnamgs!=0}" title="#{var.hosPecCnamgs}"/>
                        </rich:column>
                        <rich:column label="Famille tarification" sortable="true" sortBy="#{var.libelleFamille}" width="90px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Tar." /></f:facet>
                            <h:outputText value="#{var.libelleFamille}" title="#{var.libelleFamille}"/>
                        </rich:column>
                        <rich:column label="Etat" sortable="true" sortBy="#{var.hosEtat}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{var.libelleEta}"  title="#{var.libelleEta}   #{var.hosMotifAnnule}"/>
                        </rich:column>
                        <rich:column label="Patient" sortable="true" sortBy="#{var.hosNomPatient}" width="200px">
                            <f:facet name="header"><h:outputText  value="Patient"  /></f:facet>
                            <h:outputText  value="#{var.hosNomPatient} (#{var.hosCivilite})" title="#{var.hosNomPatient}"/>
                        </rich:column>
                        <rich:column label="Service" sortable="true" sortBy="#{var.hosService}" width="200px">
                            <f:facet name="header"><h:outputText  value="Service(s)"/></f:facet>
                            <h:outputText  value="#{var.hosService}" title="#{var.hosService}"/>
                        </rich:column>
                        <rich:column label="Part Patient" sortable="true" sortBy="#{var.totalPatient}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="P.Patient"  /></f:facet>
                            <h:outputText  value="#{var.totalPatient}" rendered="#{var.totalPatient!=0}" title="#{var.totalPatient}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Reg. Patient" sortable="true" sortBy="#{var.hosRegPatient}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="R.Patient"/></f:facet>
                            <h:outputText  value="#{var.hosRegPatient}" rendered="#{var.hosRegPatient!=0}" title="#{var.hosRegPatient}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Solde Patient" sortable="true" sortBy="#{var.hosRegTiers}" style="text-align:right;color:red">
                            <f:facet name="header"><h:outputText value="S.Patient"/></f:facet>
                            <h:outputText  value="#{var.var_reliquat}" rendered="#{var.var_reliquat!=0}" title="#{var.var_reliquat}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Part Tiers" sortable="true" sortBy="#{var.totalTiers}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="P.Tiers"/></f:facet>
                            <h:outputText  value="#{var.totalTiers}" rendered="#{var.totalTiers!=0}" title="#{var.totalTiers}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Reg. Tiers" sortable="true" sortBy="#{var.hosRegTiers}" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="R.Tiers"/></f:facet>
                            <h:outputText  value="#{var.hosRegTiers}" rendered="#{var.hosRegTiers!=0}" title="#{var.hosRegTiers}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Activité" sortable="true" sortBy="#{var.hosActivite}" width="200px">
                            <f:facet name="header"><h:outputText value="Activité"/></f:facet>
                            <h:outputText  value="#{var.hosActivite}" title="#{var.hosActivite}"/>
                        </rich:column>
                        <rich:column label="Protocle" sortable="true" sortBy="#{var.hosProtocole}" width="200px">
                            <f:facet name="header"><h:outputText value="Protocole"/></f:facet>
                            <h:outputText  value="#{var.hosProtocole}" title="#{var.hosProtocole}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
        </center>
        <br/>
        <h:panelGrid id="pnlgrttotal" columns="4" styleClass="recherche" width="100%">
            <h:panelGrid columns="2" >
                <h:outputText value="Total Patient" />
                <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.totalPatient}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
                <h:outputText value="Total Tiers" />
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.totalTiers}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
            </h:panelGrid>
            <h:panelGrid columns="2" >
                <h:outputText value="Réglements Patients " />
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.regPatient}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
                <h:outputText  value="Réglements Tiers" />
                <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.regTiers}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
            </h:panelGrid>
            <h:panelGrid columns="2" >
                <h:outputText  value="Solde Patient" />
                <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.soldePatient}" style="width:100%;text-align:right;color:red" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
                <h:outputText value="Solde Tiers" />
                <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.soldeTiers}" style="width:100%;text-align:right;color:red" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
            </h:panelGrid>
            <h:panelGrid columns="1">
                <h:outputText value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_nb_ligne})" />
            </h:panelGrid>
        </h:panelGrid>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.valQteGraph}" >
                                <f:selectItem itemLabel="En valeur" itemValue="0"/>
                                <f:selectItem itemLabel="en quantité" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <f:selectItem itemLabel="par catégorie d'entrée" itemValue="1"/>
                                <f:selectItem itemLabel="par prescripteur" itemValue="2"/>
                                <f:selectItem itemLabel="par patient" itemValue="3"/>
                                <f:selectItem itemLabel="par assurance" itemValue="4"/>
                                <f:selectItem itemLabel="par complémentaire" itemValue="5"/>
                                <f:selectItem itemLabel="par société" itemValue="6"/>
                                <f:selectItem itemLabel="par protocole" itemValue="7"/>
                                <f:selectItem itemLabel="par pathologie" itemValue="8"/>
                                <f:selectItem itemLabel="par service (séjour)" itemValue="21"/>
                                <f:selectItem itemLabel="par lit (séjour)" itemValue="22"/>
                                <f:selectItem itemLabel="par actes" itemValue="20"/>
                                <f:selectItem itemLabel="par produits phamacies" itemValue="23"/>
                                <f:selectItem itemLabel="par examens laboratoires" itemValue="24"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <f:selectItem itemLabel="tranche horaire" itemValue="5"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelimpSerie" width="900" height="350" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.showModalPanelImput}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.showModalPanelImput}" var="imp">
            <f:facet name="header"><h:outputText value="Imputation série"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.annuleImputSerie}" image="/images/close.gif" styleClass="hidelink" id="hidelinkImput" reRender="panelimpSerie"/>
                    <rich:componentControl for="panelAjt" attachTo="hidelinkImput" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <jsp:include flush="true" page="/medical/HospitalisationCommun.jsp"/>
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Série imputée:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="serieimput"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_imput_serie}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.mesSeriesUsersItem}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="serieimput"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="catimput" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_imput_cat}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.mesPecItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.miseajourImput}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelBonEncaissement" width="1000" height="560" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.showModalPanelBonEncaissement}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.showModalPanelBonEncaissement}" var="pay">
            <f:facet name="header">
                <h:outputText value="Bon d'encaissement du document"></h:outputText>
            </f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.annulePaye}" image="/images/close.gif" styleClass="hidelink" reRender="panelBonEncaissement"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid id="idPanelGlobal"  width="100%">
                    <h:panelGrid id="firstgridd"  width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Date encaissement:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_date}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateMed==0}"/></h:column>
                        <h:column><h:outputText value="N°:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hospitalisationEntete.hosNum}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Série:"/></h:column>
                        <h:column>
                            <h:panelGroup>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hospitalisationEntete.hosSerie}" size="2" readonly="true"/>
                            </h:panelGroup>
                        </h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Patient:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hospitalisationEntete.hosNomPatient}" readonly="true"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column> <h:outputText value="Mode de règlement:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hospitalisationEntete.hosTypeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_verouxModReg}">
                                <f:selectItem itemLabel="Paiement comptant" itemValue="0"/>
                                <f:selectItem itemLabel="Paiement Lettre de garantie" itemValue="12"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.chargerModReg}" reRender="firstgridd,colMontInput,idTotal"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Caisse:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idCaisse" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_inputCaisse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.mesCaissesSeriesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable height="200px" id="idListeRegService" width="100%" border="0" enableContextMenu="false" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.dataModelRegService}" var="reg" sortMode="multi">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.selectionPaye}"/>
                            <rich:column sortable="false" width="30%">
                                <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                                <h:outputText value="#{reg.nomService}"/>
                            </rich:column>
                            <rich:column sortable="false" width="30%">
                                <f:facet name="header"><h:outputText  value="Laboratoire/Produit"/></f:facet>
                                <h:outputText value="#{reg.nomLaboratoire}"/>
                                <h:outputText value="#{reg.nomLibelle}" rendered="#{reg.nomService=='41:PHARMACIE CENTRALE'}"/>
                            </rich:column>
                            <rich:column sortable="false" width="10%" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Total"/></f:facet>
                                <h:outputText value="#{reg.totalService}" rendered="#{reg.totalService!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="10%" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Déjà Payé"/></f:facet>
                                <h:inputText value="#{reg.dejaPaye}" style="text-align:right;width:90%" readonly="true" disabled="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column sortable="false" width="10%" style="text-align:right">
                                <f:facet name="header"><h:outputText value="A Payer"/></f:facet>
                                <h:inputText value="#{reg.prix}" style="text-align:right;width:80%" onkeypress="return scanToucheChiffre(event)" disabled="#{reg.saisieInterdit}">
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.calculSodeLigne}" reRender="idSolde,idPanelGlobal,idTotal,idTotalReglement,idTotalSolde,ppgrp"/>
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column id="idSolde" sortable="false" width="10%" style="text-align:right">
                                <f:facet name="header"><h:outputText value="Solde"/></f:facet>
                                <h:outputText value="#{reg.solde}" rendered="#{reg.solde!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <br>
                    <h:panelGrid id="idTotal"  width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Total hospitalisation:"/></h:column>
                        <h:column>
                            <h:inputText style="width:100%;text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_netAPayer}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Total règlements:"/></h:column>
                        <h:column>
                            <h:inputText style="width:100%;text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.totalReglement}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:outputText value="Montant encaissé:" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.balanceFinale}"/>
                            <h:outputText value="Balance finale séjour:" style="color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.balanceFinale}"/>
                        </h:column>
                        <h:column id="idTotalReglement">
                            <h:inputText style="width:100%;text-align:center;font-weight:bold;font-size:50px"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.totalPaye}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.paiementPartiel}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idTotal,idTotalReglement,ppgrp,idListeRegService" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.calculeSoldeFinal}"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.balanceFinale&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.totalPaye>0}">
                            <h:outputText value="Paiement partiel:" style="color:red"/>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.balanceFinale&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.totalPaye>0}">
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.paiementPartiel}" style="color:red">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.calculSoldeTotal}" reRender="idTotal,idTotalReglement,ppgrp,idListeRegService"/>
                            </h:selectBooleanCheckbox>
                        </h:column>
                        <h:column><h:outputText value="Solde patient:"/></h:column>
                        <h:column id="idTotalSolde">
                            <h:inputText style="width:100%;text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.totalSolde}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <h:panelGroup id="ppgrp">
                    <center>
                        <br><br>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.miseajourPaye}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_inputCaisse!='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_affiche_valide}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBonEncaissement,panelBouton,table,scrollTable,modMessageCommun"/>
                        <br>
                        <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_affiche_valide}" style="margin-left:50px;">
                            <h:graphicImage url="/images/Warning.png"  style="width:25px;height;"/>
                            <h:outputText value="Le montant du bon est supérieur au solde du document" style="color:red;" />
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelHistoReglement" width="1000" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.showModalPanelHistoReglement}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.showModalPanelHistoReglement}" var="his">
            <f:facet name="header"><h:outputText value="Historique des règlements"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.fermerHistoReglement}" image="/images/close.gif" styleClass="hidelink" reRender="panelHistoReglement"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  style="width:100%;">
                    <jsp:include flush="true" page="/medical/HospitalisationCommun.jsp"/>
                    <h:panelGrid styleClass="fichefournisseur" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                        <h:column><h:outputText value="Total Patient:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hospitalisationEntete.hosTotPatient}" style="text-align:right;width:100%"  readonly="true" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Total Tiers:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_tot_tiers}" style="text-align:right;width:100%" readonly="true" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Total Général:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hospitalisationEntete.hosTotGeneral}" style="text-align:right;width:95%"  readonly="true" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Règlement Patient:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hospitalisationEntete.hosRegPatient}" style="text-align:right;width:100%"  readonly="true" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Règlement Tiers:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hospitalisationEntete.hosRegTiers}" style="text-align:right;width:100%" readonly="true" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Solde Général:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_solde}" style="text-align:right;width:95%"  readonly="true" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable height="350px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.datamodelRecu}"  var="recu"  sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeReglementDocument.jsp"/>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelAnnuler" width="900" height="350" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.showModalPanelAnnuler}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.showModalPanelAnnuler}" var="ser">
            <f:facet name="header"><h:outputText value="Annulation Consultation"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.annuleAnnulation}" image="/images/close.gif" styleClass="hidelink" reRender="panelAnnuler"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <jsp:include flush="true" page="/medical/HospitalisationCommun.jsp"/>
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Date annulation:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hospitalisationEntete.hosDateAnnule}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateCai==0}"/></h:column>
                        <h:column><h:outputText value="Caisse exécutrice:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.var_inputCaisse}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.mesCaissesSeriesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Motif annulation:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.hospitalisationEntete.hosMotifAnnule}" maxlength="50"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.miseajourAnnuler}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
