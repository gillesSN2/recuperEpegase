<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="devisentete">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center> <h2><h:outputText value="GESTION DES DEVIS" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid  id="panCtrl"  styleClass="recherche"  width="100%">
                <h:panelGrid columns="9" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_more_search}"/>
                    <h:column><h:outputText value="N°"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.inpNum}" size="5"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.inpSerie}" style="width:100px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesSerieUserItem}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idFamille" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.inpFam}" style="width:150px;">
                            <f:selectItem itemLabel="Toutes Catégories" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesCategoriesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idEtat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesEtatsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idPeriode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_more_search}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesPeriodesItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu id="idActivite" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.inpActivite}" style="width:150px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.tActivite}">
                            <f:selectItem itemLabel="Toutes Activités" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesActivitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelBouton,table,scrollTable,pnlgrttotal"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="8" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_more_search}">
                    <h:column><h:outputText value="Nom:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.inpNomPatient}" /></h:column>
                    <h:column><h:outputText value="Prénom:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.inpPrenomPatient}"/></h:column>
                    <h:column><h:outputText value="Dossier entrée:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.inpDossier}"/></h:column>
                    <h:column><h:outputText value="Téléphone:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.inpTel}"/></h:column>
                    <h:column><h:outputText value="C.I./Sécu.:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.inpCi}"/></h:column>
                    <h:column><h:outputText value="Société:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.inpSociete}"/></h:column>
                    <h:column><h:outputText value="Assurance/IPM:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.inpAssurance}"/></h:column>
                    <h:column><h:outputText value="Mutuelle/Complémentaire:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.inpComplementaire}"/></h:column>
                    <h:column><h:outputText value="N° Contrat/Mat.:"/></h:column>
                    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.inpContrat}"/></h:column>
                    <h:column><h:outputText value="Mèdecin:"/></h:column>
                    <h:column>
                        <h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.inpMedecin}">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les responsables" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.rechercheMedecin}" reRender="panCtrl,panDest,panelListeResponsable,formModalListeResponsable" oncomplete="javascript:Richfaces.showModalPanel('panelListeResponsable');"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_affiche_protocole}"><h:outputText value="Protocole"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_affiche_protocole}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.inpProtocole}" size="10"/></h:column>
                    <h:column><h:outputText value="Du:"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au:"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="12" width="400px" style="height:34px">
            <a4j:commandButton title="Ajouter nouveau devis" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.ajoutDocument}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.add}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier le devis sélectionné" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.modifDocument}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter" image="/images/detail.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.consultDocument}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.visibiliteBton}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer devis sélectionné uniquement si en cours" image="/images/supprimer.png"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.supprimerDocument}" reRender="table,pangrpVisbt,intpTTCL,intpRGLMTL,intpSOLDL" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.sup}"/>
            <a4j:commandButton title="imprimer" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');" reRender="panelImp,formModalImp,panchoixdoc,optionMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
            <a4j:commandButton title="Grapher" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}" reRender="panelGraph,formModalGraph,container"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.initGrapheur}"/>
            <a4j:commandButton title="Imputer la série" image="/images/boussole.png" oncomplete="javascript:Richfaces.showModalPanel('panelimpSerie');" reRender="panelimpSerie" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.accesImputSerie}" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsSerie=='X'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.clo}"/>
            <a4j:commandButton title="Changer le service ou le médecin du document sélectionné" style="height:22px;width:22px" image="/images/permutter.jpeg" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsEtat==1&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsRegPatient==0||bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrMedicalAvoir==1)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="if (!confirm('Etes-vous sur de vouloir changer le service ou le médecin ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.changerService}" reRender="panelChangerService"/>
            <a4j:commandButton title="Dupliquer le document sélectionné" image="/images/duplicate.png"  onclick="if (!confirm('Etes-vous sur de vouloir dupliquer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.duppliquerDocument}" reRender="modAttente,table,pangrpVisbt,intpTTCL,intpRGLMTL,intpSOLDL" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.dup}"/>
            <a4j:commandButton title="Valider le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document ?')) return false" reRender="panelBouton,table"/>
            <a4j:commandButton title="Dé-Valider le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsDateTransfert==null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document ?')) return false" reRender="panelBouton,table"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.datamodelDocument}" var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.selectionConsultation}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,pnlgrttotal"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.visualisationLigne}" reRender="idSubView,panelBouton,pnlgrttotal"/>
                        <rich:column label="N° Dossier patient" sortable="true" sortBy="#{var.patients.patDossier}" >
                            <f:facet name="header"><h:outputText  value="N° Dossier" /></f:facet>
                            <h:outputText value="#{var.patients.patDossier}" title="#{var.patients.patDossier}"/>
                        </rich:column>
                        <rich:column label="N° Devis" sortable="true" sortBy="#{var.dvsNum}" >
                            <f:facet name="header"><h:outputText  value="N° Devis" /></f:facet>
                            <h:outputText value="#{var.dvsNum}" title="#{var.dvsNum}"/>
                        </rich:column>
                        <rich:column label="Date" sortable="true" sortBy="#{var.dvsDate}" width="70px" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.dvsDate}" title="#{var.dvsDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Série" sortable="true" sortBy="#{var.dvsSerie}" style="text-align:center;" width="40px">
                            <f:facet name="header"><h:outputText  value="S." /></f:facet>
                            <h:outputText value="#{var.dvsSerie}" title="#{var.dvsSerie}"/>
                        </rich:column>
                        <rich:column label="Prise en charge" sortable="true" sortBy="#{var.dvsPecCnamgs}" width="50px" style="text-align:right;"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.optionMedical.cnamgs=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}">
                            <f:facet name="header"><h:outputText  value="Pec" /></f:facet>
                            <h:outputText value="#{var.dvsPecCnamgs}" style="text-align:right;" rendered="#{var.dvsPecCnamgs!=0}" title="#{var.dvsPecCnamgs}"/>
                        </rich:column>
                        <rich:column label="Famille tarification" sortable="true" sortBy="#{var.libelleFamille}" width="90px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Tar." /></f:facet>
                            <h:outputText value="#{var.libelleFamille}" title="#{var.libelleFamille}"/>
                        </rich:column>
                        <rich:column label="Etat" sortable="true" sortBy="#{var.dvsEtat}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{var.libelleEta}"  title="#{var.libelleEta}   #{var.dvsMotifAnnule}"/>
                        </rich:column>
                        <rich:column label="Motif entrée" sortable="true" sortBy="#{var.entree}" width="50px">
                            <f:facet name="header"><h:outputText  value="Ent." /></f:facet>
                            <h:outputText value="#{var.entree}" title="#{var.entree}"/>
                        </rich:column>
                        <rich:column label="Patient" sortable="true" sortBy="#{var.dvsNomPatient}" width="200px">
                            <f:facet name="header"><h:outputText  value="Patient"  /></f:facet>
                            <h:outputText  value="#{var.dvsNomPatient} (#{var.dvsCivilite})" title="#{var.dvsNomPatient}"/>
                        </rich:column>
                        <rich:column label="Part Patient" sortable="true" sortBy="#{var.totalPatient}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="P.Patient"  /></f:facet>
                            <h:outputText  value="#{var.totalPatient}" rendered="#{var.totalPatient!=0}" title="#{var.totalPatient}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Part Tiers" sortable="true" sortBy="#{var.totalTiers}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="P.Tiers"/></f:facet>
                            <h:outputText  value="#{var.totalTiers}" rendered="#{var.totalTiers!=0}" title="#{var.totalTiers}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Activité" sortable="true" sortBy="#{var.dvsActivite}" width="200px">
                            <f:facet name="header"><h:outputText value="Activité"/></f:facet>
                            <h:outputText  value="#{var.dvsActivite}" title="#{var.dvsActivite}"/>
                        </rich:column>
                        <rich:column label="Protocle" sortable="true" sortBy="#{var.dvsProtocole}" width="200px">
                            <f:facet name="header"><h:outputText value="Protocole"/></f:facet>
                            <h:outputText  value="#{var.dvsProtocole}" title="#{var.dvsProtocole}"/>
                        </rich:column>
                        <rich:column label="Mèdecin" sortable="true" sortBy="#{var.dvsMedecin}" width="200px">
                            <f:facet name="header"><h:outputText  value="Mèdecin"/></f:facet>
                            <h:outputText  value="#{var.dvsMedecin}" title="#{var.dvsMedecin}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
        </center>
        <br/>
        <h:panelGrid id="pnlgrttotal" columns="4" styleClass="recherche" width="100%">
            <h:panelGrid columns="2" >
                <h:outputText value="Total Patient" />
                <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.totalPatient}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
                <h:outputText value="Total Tiers" />
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.totalTiers}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
            </h:panelGrid>
            <h:panelGrid columns="2" >
                <h:outputText value="Réglements Patients " />
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.regPatient}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
                <h:outputText  value="Réglements Tiers" />
                <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.regTiers}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
            </h:panelGrid>
            <h:panelGrid columns="2" >
                <h:outputText  value="Solde Patient" />
                <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.soldePatient}" style="width:100%;text-align:right;color:red" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
                <h:outputText value="Solde Tiers" />
                <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.soldeTiers}" style="width:100%;text-align:right;color:red" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
            </h:panelGrid>
            <h:panelGrid columns="1">
                <h:outputText value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_nb_ligne})" />
            </h:panelGrid>
        </h:panelGrid>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.valQteGraph}" >
                                <f:selectItem itemLabel="En valeur" itemValue="0"/>
                                <f:selectItem itemLabel="en quantité" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <f:selectItem itemLabel="par mèdecin" itemValue="1"/>
                                <f:selectItem itemLabel="par prescripteur" itemValue="2"/>
                                <f:selectItem itemLabel="par patient" itemValue="3"/>
                                <f:selectItem itemLabel="par assurance" itemValue="4"/>
                                <f:selectItem itemLabel="par complémentaire" itemValue="5"/>
                                <f:selectItem itemLabel="par société" itemValue="6"/>
                                <f:selectItem itemLabel="par protocole" itemValue="8"/>
                                <f:selectItem itemLabel="par pathologie" itemValue="9"/>
                                <f:selectItem itemLabel="par service" itemValue="10"/>
                                <f:selectItem itemLabel="par examen" itemValue="20"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <f:selectItem itemLabel="tranche horaire" itemValue="5"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelimpSerie" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.showModalPanelImput}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.showModalPanelImput}" var="imp">
            <f:facet name="header"><h:outputText value="Imputation N°/Série"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.annuleImputSerie}" image="/images/close.gif" styleClass="hidelink" id="hidelinkImput" reRender="panelimpSerie"/>
                    <rich:componentControl for="panelAjt" attachTo="hidelinkImput" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Série imputée:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="serieimput"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_imput_serie}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.mesSeriesUsersItem}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="serieimput"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="catimput" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_imput_cat}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.mesPecItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.miseajourImput}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelChangerService" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.showModalPanelChangerService}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.showModalPanelChangerService}" var="chs">
            <f:facet name="header"><h:outputText value="Change Service, Médecin"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.annulerChangerService}" image="/images/close.gif" styleClass="hidelink" id="hidelinkChg" reRender="panelChangerService"/>
                    <rich:componentControl for="panelChg" attachTo="hidelinkChg" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  style="width:100%;">
                    <h:panelGrid  columns="2" columnClasses="clos30,clos70" style="width:100%;" styleClass="recherche">
                        <h:column><h:outputText value="Ancien service:"/></h:column>
                        <h:column><h:inputText style="width:100%" readonly="true" disabled="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsService}"/></h:column>
                        <h:column><h:outputText value="Nouveau service:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.nouveauService}" >
                                <f:selectItem itemLabel="Sélectionner un service" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesServicesItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.chargerMedecinService}" reRender="idNewMedecin"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid  columns="2" columnClasses="clos30,clos70" style="width:100%;" styleClass="recherche">
                        <h:column><h:outputText value="Ancien médecin:"/></h:column>
                        <h:column><h:inputText style="width:100%" readonly="true" disabled="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.ancienMedecin}"/></h:column>
                        <h:column><h:outputText value="Nouveau médecin:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idNewMedecin" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.nouveauMedecin}" >
                                <f:selectItem itemLabel="Sélectionner un médecin" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.mesMedecinsItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.validerChangerService}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
