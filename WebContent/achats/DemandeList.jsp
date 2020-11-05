<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="daliste">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center> <h2><h:outputText value="GESTION DES DEMANDES D'ACHAT" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
                <h:panelGrid columns="11" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_more_search}"/>
                    <h:column><h:outputText value="N°"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.inpNum}" size="5"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="serie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.inpSerie}" style="width:100px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSerieUserItem}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesEtatsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_more_search}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesPeriodesItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.inpActivite}" style="width:150px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_anal_activite}">
                            <f:selectItem itemLabel="Toutes Activités" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesActivitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.inpService}" style="width:150px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesServicesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,table,scrollTable,pnlgrttotal"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="9" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_more_search}">
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.inpBudget}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Budgets" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesBudgetsItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="parc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.inpParc}" style="width:150px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_anal_parc}">
                            <f:selectItem itemLabel="Tous Parcs" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesParcsItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:outputText value="Dossier:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_anal_dossier}"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.inpDossier}" style="width:150px;"/>
                    </h:column>
                    <h:column><h:outputText value="Du"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="11" width="400px" style="height:34px">
            <a4j:commandButton title="Ajouter nouveau document" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.ajoutDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier le document sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.demandeEnteteAchats.demEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.modifDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter le document sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.consultDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer le document sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.demandeEnteteAchats.demEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.supprimerDocument}" reRender="table,panelBouton,intpTTCL,intpRGLMTL,intpSOLDL"/>
            <a4j:commandButton title="Annuler le document sélectionné" image="/images/annuler_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formAvoirAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.demandeEnteteAchats.demEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.sup}" onclick="if (!confirm('Etes-vous sur de vouloir annuler ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.annulerDocument}" reRender="panelAnnuler"/>
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
            <a4j:commandButton title="Changer N°/série" image="/images/imputer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifSerieAch==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.demandeEnteteAchats.demEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.accesImputSerie}" reRender="panelimpSerie" />
            <a4j:commandButton title="Dupliquer le document sélectionné" image="/images/duplicate.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.dup}" onclick="if (!confirm('Etes-vous sur de vouloir dupliquer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.duppliquerDocument}" reRender="modAttente,table,panelBouton,intpTTCL,intpRGLMTL,intpSOLDL" />
            <a4j:commandButton title="Transformer le(s) document(s) sélectionné(s)" image="/images/transferer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.visibiliteBton&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.demandeEnteteAchats.demEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.demandeEnteteAchats.demEtat==4)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.trf}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.transformerDocument}" reRender="panelTrf,formTrf,idSerieTrf"/>
            <a4j:commandButton title="Valider le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.demandeEnteteAchats.demEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panelBouton,idEtat,idTrf"/>
            <a4j:commandButton title="Dé-Valider le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.demandeEnteteAchats.demEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panelBouton,idEtat,idTrf"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.datamodelEntete}" var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,panelBoutonSuivi,intpSOLDE,intpTTCE,intpRGLMTE"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.visualisationLigne}" reRender="idSubView,panelBouton,panCtrl,panelBoutonSuivi,intpSOLDE,intpTTCE,intpRGLMTE"/>
                        <rich:column label="N° demande" sortable="true" sortBy="#{var.demNum}">
                            <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                            <h:outputText value="#{var.demNum}"/>
                        </rich:column>
                        <rich:column label="Etat signature" sortable="true" sortBy="#{var.demPosSignature}" width="70px" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.habilitation!=null}">
                            <f:facet name="header"><h:outputText  value="Sign." /></f:facet>
                            <h:outputText  value="#{var.demPosSignature}/#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.habilitation.habNombre}" style="text-align:center;"/>
                        </rich:column>
                        <rich:column label="Date demande" sortable="true" sortBy="#{var.demDate} #{var.demNum}" width="70px">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.demDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date de validation" sortable="true" sortBy="#{var.demDateValide}" width="70px">
                            <f:facet name="header"><h:outputText  value="Valide" /></f:facet>
                            <h:outputText value="#{var.demDateValide}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Série" sortable="true" sortBy="#{var.demSerie}" style="text-align:center;" width="40px">
                            <f:facet name="header"><h:outputText  value="S." /></f:facet>
                            <h:outputText value="#{var.demSerie}"/>
                        </rich:column>
                        <rich:column label="Phase de construction" sortable="true" sortBy="#{var.demPhase}" width="80px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.moduleImmobilier}">
                            <f:facet name="header"><h:outputText  value="Phase" /></f:facet>
                            <h:outputText value="#{var.libellePhase}"/>
                        </rich:column>
                        <rich:column id="idEtat"  label="Etat" sortable="true" sortBy="#{var.demEtat}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{var.libelleEta}"/>
                        </rich:column>
                        <rich:column label="N° CMD" sortable="true" sortBy="#{var.numCmd}" rendered="false">
                            <f:facet name="header"><h:outputText  value="CMD" /></f:facet>
                            <h:outputText value="#{var.numCmd}"/>
                        </rich:column>
                        <rich:column label="N° RECEPTION" sortable="true" sortBy="#{var.numRec}" rendered="false">
                            <f:facet name="header"><h:outputText  value="REC." /></f:facet>
                            <h:outputText value="#{var.numRec}"/>
                        </rich:column>
                        <rich:column label="N° FACTURE" sortable="true" sortBy="#{var.numFac}" rendered="false">
                            <f:facet name="header"><h:outputText  value="FAC" /></f:facet>
                            <h:outputText value="#{var.numFac}"/>
                        </rich:column>
                        <rich:column id="idTrf"  label="Transfert" sortable="true" sortBy="#{var.var_select_ligne}" width="50px" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.trf}">
                            <f:facet name="header"><h:outputText  value="Trf." /></f:facet>
                            <h:selectBooleanCheckbox value="#{var.var_select_ligne}" rendered="#{(var.demEtat==1||var.demEtat==4)&&var.demSerie!='X'}"/>
                        </rich:column>
                        <rich:column label="Site" sortable="true" sortBy="#{var.demSite}" width="200px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.choixSitDepSer==1}">
                            <f:facet name="header"><h:outputText value="Site"/></f:facet>
                            <h:outputText  value="#{var.demSite}"/>
                        </rich:column>
                        <rich:column label="Département" sortable="true" sortBy="#{var.demDepartement}" width="200px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.choixSitDepSer==2}">
                            <f:facet name="header"><h:outputText value="Département"/></f:facet>
                            <h:outputText  value="#{var.demDepartement}"/>
                        </rich:column>
                        <rich:column label="Service" sortable="true" sortBy="#{var.demService}" width="200px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.choixSitDepSer==3}">
                            <f:facet name="header"><h:outputText value="Service"/></f:facet>
                            <h:outputText  value="#{var.demService}"/>
                        </rich:column>
                        <rich:column label="Observatons" sortable="true" sortBy="#{var.demObservation}" width="200px">
                            <f:facet name="header"><h:outputText value="Observation"/></f:facet>
                            <h:outputText  value="#{var.demObservation}"/>
                        </rich:column>
                        <rich:column label="Responsable" sortable="true" sortBy="#{var.demNomResponsable}" width="200px">
                            <f:facet name="header"><h:outputText  value="Respponsable"/></f:facet>
                            <h:outputText  value="#{var.demNomResponsable}"/>
                        </rich:column>
                        <rich:column label="Montant H.T." sortable="true" sortBy="#{var.demTotHt}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="H.T."  /></f:facet>
                            <h:outputText  value="#{var.demTotHt}" rendered="#{var.demTotHt!=0&&var.var_format_devise==0}">
                                <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                            <h:outputText  value="#{var.demTotHt}" rendered="#{var.demTotHt!=0&&var.var_format_devise==1}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                            <h:outputText  value="#{var.demTotHt}" rendered="#{var.demTotHt!=0&&var.var_format_devise==2}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant des taxes" sortable="true" sortBy="#{var.demTotTva}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Taxes"/></f:facet>
                            <h:outputText  value="#{var.demTotTva}" rendered="#{var.demTotTva!=0&&var.var_format_devise==0}">
                                <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                            <h:outputText  value="#{var.demTotTva}" rendered="#{var.demTotTva!=0&&var.var_format_devise==1}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                            <h:outputText  value="#{var.demTotTva}" rendered="#{var.demTotTva!=0&&var.var_format_devise==2}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant T.T.C." sortable="true" sortBy="#{var.demTotTtc}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                            <h:outputText  value="#{var.demTotTtc}" rendered="#{var.demTotTtc!=0&&var.var_format_devise==0}">
                                <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                            <h:outputText  value="#{var.demTotTtc}" rendered="#{var.demTotTtc!=0&&var.var_format_devise==1}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                            <h:outputText  value="#{var.demTotTtc}" rendered="#{var.demTotTtc!=0&&var.var_format_devise==2}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Activité commerciale" sortable="true" sortBy="#{var.demActivite}" >
                            <f:facet name="header"><h:outputText value="Act."  /></f:facet>
                            <h:outputText  value="#{var.demActivite}"/>
                        </rich:column>
                        <rich:column label="Parc" sortable="true" sortBy="#{var.demAnal2}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_anal_parc}">
                            <f:facet name="header"><h:outputText value="Parc"  /></f:facet>
                            <h:outputText  value="#{var.demAnal2}"/>
                        </rich:column>
                        <rich:column label="Budget" sortable="true" sortBy="#{var.demBudget}" >
                            <f:facet name="header"><h:outputText value="Budget"  /></f:facet>
                            <h:outputText  value="#{var.demBudget}"/>
                        </rich:column>
                        <rich:column label="Objet de la demande" sortable="true" sortBy="#{var.demObject}" width="200px">
                            <f:facet name="header"><h:outputText value="Objet"  /></f:facet>
                            <h:outputText  value="#{var.demObject}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
            <br/>
            <h:panelGrid id="pnlgrttotal" columns="4" cellspacing="1" styleClass="recherche"  width="100%">
                <h:panelGrid id="pnlgrttotalTTC" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpTTCL" value="Total TTC" />
                    <h:inputText id="intpTTCL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.montantTtc}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpTTCE" value="Total TTC" />
                    <h:inputText id="intpTTCE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.montantTtcElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalLE" columns="1" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpLIST" value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_nb_ligne})" />
                    <h:outputText id="outpELMT" value="(Eléments sélectionnés)" />
                </h:panelGrid>
            </h:panelGrid>
        </center>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelimpSerie" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.showModalPanelImput}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.showModalPanelImput}" var="imp">
            <f:facet name="header"><h:outputText value="Imputation N°/Série"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.annuleImputSerie}" image="/images/close.gif" styleClass="hidelink" reRender="panelimpSerie"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;" id="idChangement">
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_imput_choix}" >
                            <f:selectItem itemLabel="Changement Numéro" itemValue="0"/>
                            <f:selectItem itemLabel="Changement Série" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idChangement"/>
                        </h:selectOneMenu>
                    </h:column>
                    <br><br><br>
                    <h:panelGrid  columns="2" style="width:100%;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_imput_choix==0}">
                        <h:column><h:outputText value="Ancien Numéro:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.cotationEnteteAchats.cotNum}" disabled="true" readonly="true"/></h:column>
                        <h:column><h:outputText value="Nouveau Numéro:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_imput_num}">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.controleNumero}" reRender="idChangement"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid  columns="2" style="width:100%;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_imput_choix==1}">
                        <h:column><h:outputText value="Série imputée:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="serieimput"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_imput_serie}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSerieUserItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="catimput" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_imput_cat}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesFamilleFournisseursItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <br>
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.miseajourImput}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelTrf"  width="1150" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.showModalPanelTrf}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.showModalPanelTrf}" var="trf">
            <f:facet name="header"><h:outputText value="Transformation demande d'achat en ..."></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.annuleTrf}" image="/images/close.gif" styleClass="hidelink" reRender="panelTrf"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formTrf">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;" id="panGlobal">
                    <h:column>
                        <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_type_trf}" id="idSerieTrf">
                            <f:selectItem itemLabel="*** Sélectionnez type"  itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.documentTrfItems}" />
                            <a4j:support eventsQueue="maQueue" reRender="panGlobal,panelTrf,serieSel,modeleSel,valtrf,trf2,trf3,trf4,trf5,trf6" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.serieSelectTrf}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:panelGrid  columns="7" style="width:100%;background-color:#DAEECB;">
                        <h:column><h:outputText id="trf2" value="Date:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_aff_trf}"/></h:column>
                        <h:column>
                            <rich:calendar id="trf3" inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_date_trf}"   enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_aff_trf}">
                            </rich:calendar>&nbsp;&nbsp;
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_heure}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_aff_trf}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                            </h:selectOneMenu>
                            <h:column><h:outputText value=":" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_aff_trf}"/></h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_minute}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_aff_trf}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="serieSel" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_serie_trf}" style="width:80px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_aff_trf}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.mesSeriesTrfItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="modeleSel" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_modele_trf}" style="width:120px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_aff_trf}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.modeleTrfItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><a4j:commandButton id="trf5" value="Reste=Reliquat" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.qteTrfQteOrg}" reRender="tabletrf,modAttente" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_aff_trf}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/></h:column>
                        <h:column><a4j:commandButton id="trf6" value="Raz Qte Reste" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.razQteTrf}" reRender="tabletrf" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_aff_trf}"/></h:column>
                    </h:panelGrid>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_aff_trf}"><h:outputText value="(Si la date est vide, alors le document généré prendra la date du document d'origine, si non, le document généré prendra la date spécifiée.)" style="color:red"/></h:column>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tabletrf" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.datamodelTransfert}" var="trf">
                            <rich:column label="N° cotation" sortable="false" sortBy="#{trf.demandeEnteteAchats.demNum}" sortOrder="ASCENDING" width="5%">
                                <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                <h:outputText value="#{trf.demandeEnteteAchats.demNum}"/>
                            </rich:column>
                            <rich:column label="Date" sortable="false" width="5%">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{trf.demandeEnteteAchats.demDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Série" sortable="false" style="text-align:center;" width="5%">
                                <f:facet name="header"><h:outputText  value="S." /></f:facet>
                                <h:outputText value="#{trf.demandeEnteteAchats.demSerie}"/>
                            </rich:column>
                            <rich:column label="Département" sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Département"/></f:facet>
                                <h:outputText  value="#{trf.demandeEnteteAchats.demDepartement}"/>
                            </rich:column>
                            <rich:column label="Service" sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                                <h:outputText  value="#{trf.demandeEnteteAchats.demService}"/>
                            </rich:column>
                            <rich:column label="Produit" sortable="false" width="15%">
                                <f:facet name="header"><h:outputText  value="Produit"/></f:facet>
                                <h:outputText  value="#{trf.demligCode}"/>
                                <h:outputText  value=" - "/>
                                <h:outputText  value="#{trf.demligLibelle}"/>
                            </rich:column>
                            <rich:column label="Quantité origine" sortable="false" style="text-align:right" width="10%">
                                <f:facet name="header"><h:outputText  value="Qte.Origine" /></f:facet>
                                <h:outputText  value="#{trf.demligQte}"/>
                            </rich:column>
                            <rich:column label="Quantité déjà transférée" sortable="false" style="text-align:right" width="10%">
                                <f:facet name="header"><h:outputText  value="Qte.trf." /></f:facet>
                                <h:outputText  value="#{trf.var_qteDejaTrf}"/>
                            </rich:column>
                            <rich:column label="Quantité restante" sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Qte.Reste" /></f:facet>
                                <h:inputText  value="#{trf.var_qteReliquat}" style="text-align:right;width:90%"/>
                            </rich:column>
                            <rich:column label="Recherche Fournisseurs" sortable="false" width="5%">
                                <f:facet name="header"><h:outputText  value="" /></f:facet>
                                <a4j:commandButton value="Sél." action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.selectionFournisseur}" style="text-align:right;width:90%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_aff_trf}" reRender="formTiers,panelTiers"/>
                            </rich:column>
                            <rich:column label="Sélection ligne pour affectation fournisseurs identiques" sortable="false" style="text-align:right" width="5%">
                                <f:facet name="header"><h:outputText  value="" /></f:facet>
                                <h:selectBooleanCheckbox  value="#{trf.selectionLigne}"/>
                            </rich:column>
                            <rich:column id="idListFournisseur" title="Fournisseurs concernés" sortable="false" width="15%">
                                <f:facet name="header"><h:outputText  value="Fournisseur"/></f:facet>
                                <h:outputText  value="#{trf.listFournisseur}" title="#{trf.listFournisseur}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:panel>
                <h:panelGroup>
                    <br>
                    <center>
                        <h:commandButton id="valtrf" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.transformerMaj}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.var_aff_trf}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelTiers" width="1150" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.showModalPanelTiers}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.showModalPanelTiers}" var="tie">
            <f:facet name="header"><h:outputText value="Sélection des fournisseurs concernés"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.annuleTiers}" image="/images/close.gif" styleClass="hidelink"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formTiers">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;" id="panGlobalTiers">
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableTiers" footerClass="bard" headerClass="headerTab" styleClass="bg" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.dataModelTiers}" var="tiers">
                            <rich:column label="Sélection du tiers" sortable="true" sortBy="#{tiers.selectionTiers}" width="5%">
                                <f:facet name="header"><h:outputText  value="Sel." /></f:facet>
                                <h:selectBooleanCheckbox value="#{tiers.selectionTiers}"/>
                            </rich:column>
                            <rich:column label="Catégorie" sortable="true" sortBy="#{tiers.tiecategorie}" width="15%">
                                <f:facet name="header"><h:outputText  value="Catégorie" /></f:facet>
                                <h:outputText value="#{tiers.tiecategorie}"/>
                            </rich:column>
                            <rich:column label="N° Compte" sortable="true" sortBy="#{tiers.tiecompte0}" width="10%">
                                <f:facet name="header"><h:outputText  value="N° compte" /></f:facet>
                                <h:outputText value="#{tiers.tiecompte0}"/>
                            </rich:column>
                            <rich:column label="Raison sociale ou Nom" sortable="true" sortBy="#{tiers.tieraisonsocialenom}" filterBy="#{tiers.tieraisonsocialenom}" width="40%">
                                <f:facet name="header"><h:outputText  value="Raison sociale" /></f:facet>
                                <h:outputText value="#{tiers.tieraisonsocialenom}"/>
                            </rich:column>
                            <rich:column label="Prénom" sortable="true" sortBy="#{tiers.tieprenom}" width="20%">
                                <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                                <h:outputText value="#{tiers.tieprenom}"/>
                            </rich:column>
                            <rich:column label="Civilité" sortable="true" sortBy="#{tiers.tiecivilite}" width="10%">
                                <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                                <h:outputText value="#{tiers.tiecivilite}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <br>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.recopieTiers}" style="color:red">
                        <f:selectItem itemLabel="Impute le fournisseur sur la ligne en cours" itemValue="0"/>
                        <f:selectItem itemLabel="Recopie fournisseur uniquement sur lignes cochées" itemValue="1"/>
                        <f:selectItem itemLabel="Recopie fournisseur sur toutes les lignes" itemValue="2"/>
                    </h:selectOneMenu>
                </rich:panel>
                <h:panelGroup>
                    <br>
                    <center>
                        <a4j:commandButton id="valtiers" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.valideTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelTiers,idListFournisseur,tabletrf"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelAnnuler" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.showModalPanelAnnuler}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.showModalPanelAnnuler}" var="ser">
            <f:facet name="header"><h:outputText value="Annulation Demande"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.annuleAnnulation}" image="/images/close.gif" styleClass="hidelink" reRender="panelAnnuler"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Date annulation:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.demandeEnteteAchats.demDateAnnule}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Motif annulation:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.demandeEnteteAchats.demMotifAnnule}" maxlength="50"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formDemandeAchats.miseajourAnnuler}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
