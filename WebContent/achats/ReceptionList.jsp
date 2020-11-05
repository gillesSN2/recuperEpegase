
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="receptionliste">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center> <h2><h:outputText value="GESTION DES RECEPTIONS D'ACHAT #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.libelleModeReception}" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid id="panCtrl"  styleClass="recherche"  width="100%">
                <h:panelGrid columns="11" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_more_search}"/>
                    <h:column><h:outputText value="N°"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.inpNum}" size="5"/></h:column>
                    <h:column><h:outputText value="Fournisseur"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.inpFournisseur}" size="10"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.inpSerie}" style="width:100px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSerieUserItem}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idFamille" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.inpCat}" style="width:150px;">
                            <f:selectItem itemLabel="Toutes Catégories" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesFamilleFournisseursItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesEtatsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idPeriode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_more_search}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesPeriodesItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu  id="idActivite" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.inpActivite}" style="width:150px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_anal_activite}">
                            <f:selectItem itemLabel="Toutes Activités" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesActivitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idService" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.inpService}" style="width:150px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesServicesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,table,scrollTable,pnlgrttotal"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="8" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_more_search}">
                    <h:column>
                        <h:selectOneMenu id="idBudget" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.inpBudget}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Budgets" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesBudgetsItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:outputText value="Responsable:" style="text-decoration:underline;"/>
                        <h:inputText id="idResponsableRec" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.inpResponsable}" size="10">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les responsables" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.rechercheResponsable}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panCtrl,panDest,panelListeResponsable,formModalListeResponsable" />
                        </h:inputText>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="parc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.inpParc}" style="width:150px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_anal_parc}">
                            <f:selectItem itemLabel="Tous Parcs" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesParcsItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.axeDossier=='2'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_anal_dossier}">
                        <h:column><h:outputText value="Dossier:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.axeDossier=='1'}"/></h:column>
                        <h:column><h:outputText value="Affaire:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.axeDossier=='2'}"/></h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.inpDossier}" size="7"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.axeDossier=='2'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_anal_activite}">
                        <h:column><h:outputText value="Analytique:"/></h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.inpAnal}" size="7"/>
                    </h:column>
                    <h:column>
                        <h:outputText value="Du:"/>
                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.inpDu}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" />
                    </h:column>
                    <h:column>
                        <h:outputText value="Au:"/>
                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.inpAu}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" />
                    </h:column>
                    <a4j:commandButton title="Recherche sur fournisseur sélectionné" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.inpNomTiersEnCours}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.executerRequeteTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,table,scrollTable,pnlgrttotal"/>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="13" width="500px" style="height:34px">
            <a4j:commandButton title="Ajouter nouveau document" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.numeroReception=='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.ajoutDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier le document sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.modifDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter le document sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.consultDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer le document sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.supprimerDocument}" reRender="table,panelBouton,intpTTCL,intpRGLMTL,intpSOLDL"/>
            <a4j:commandButton title="Annuler le document sélectionné" image="/images/annuler_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.sup}" onclick="if (!confirm('Etes-vous sur de vouloir annuler ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.annulerDocument}" reRender="panelAnnuler"/>
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
            <a4j:commandButton title="Grapher" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}" reRender="panelGraph,formModalGraph,container" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.initGrapheur}"/>
            <a4j:commandButton title="Changer N°/série" image="/images/imputer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifSerieAch==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.accesImputSerie}" reRender="panelimpSerie" />
            <a4j:commandButton title="Dupliquer le document sélectionné" image="/images/duplicate.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.dup}" onclick="if (!confirm('Etes-vous sur de vouloir dupliquer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.duppliquerDocument}" reRender="modAttente,table,panelBouton,intpTTCL,intpRGLMTL,intpSOLDL" />
            <a4j:commandButton title="Duppliquer en négatif le document sélectionné" image="/images/duplicate.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.dup}" onclick="if (!confirm('Etes-vous sur de vouloir duppliquer en négatif ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.duppliquerNegatifDocument}" reRender="modAttente,table,panelBouton,intpTTCL,intpRGLMTL,intpSOLDL" />
            <a4j:commandButton title="Transformer le(s) document(s) sélectionné(s)" image="/images/transferer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visibiliteBton&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recEtat==4)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.trf}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.transformerDocument}" reRender="panelTrf,formTrf,idSerieTrf"/>
            <a4j:commandButton title="Valider le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panelBouton,idEtat,idTrf"/>
            <a4j:commandButton title="Dé-Valider le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panelBouton,idEtat,idTrf"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.datamodelEntete}" var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,panelBoutonSuivi,intpSOLDE,intpTTCE,intpRGLMTE"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.visualisationLigne}" reRender="idSubView,panelBouton,panCtrl,panelBoutonSuivi,intpSOLDE,intpTTCE,intpRGLMTE"/>
                        <rich:column label="N° réception" sortable="true" sortBy="#{var.recNum}">
                            <f:facet name="header"><h:outputText  value="N° REC" /></f:facet>
                            <h:outputText value="#{var.recNum}"/>
                        </rich:column>
                        <rich:column label="Etat signature" sortable="true" sortBy="#{var.recPosSignature}" width="70px" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.habilitation!=null}">
                            <f:facet name="header"><h:outputText  value="Sign." /></f:facet>
                            <h:outputText  value="#{var.recPosSignature}/#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.habilitation.habNombre}" style="text-align:center;"/>
                        </rich:column>
                        <rich:column label="N° dossier/affaire" sortable="true" sortBy="#{var.recAnal4}">
                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.libelleDossier}"/></f:facet>
                            <h:outputText value="#{var.recAffaire}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.axeDossier=='2'}"/>
                            <h:outputText value="#{var.recAnal4}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.axeDossier!='2'}"/>
                        </rich:column>
                        <rich:column label="N° analytque" sortable="true" sortBy="#{var.recAnal4}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.axeDossier=='2'}">
                            <f:facet name="header"><h:outputText  value="N° ANAL."/></f:facet>
                            <h:outputText value="#{var.recAnal4}"/>
                        </rich:column>
                        <rich:column label="N° Facture" sortable="true" sortBy="#{var.recNumFature}">
                            <f:facet name="header"><h:outputText  value="N° Fac." /></f:facet>
                            <h:outputText value="#{var.recNumFature}"/>
                        </rich:column>
                        <rich:column label="Date réception" sortable="true" sortBy="#{var.recDate} #{var.recNum}" width="70px">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.recDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Phase de construction" sortable="true" sortBy="#{var.recPhase}" width="80px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.moduleImmobilier}">
                            <f:facet name="header"><h:outputText  value="Phase" /></f:facet>
                            <h:outputText value="#{var.libellePhase}"/>
                        </rich:column>
                         <rich:column id="idEtat"  label="Etat" sortable="true" sortBy="#{var.recEtat}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{var.libelleEta}"/>
                        </rich:column>
                        <rich:column id="idTrf"  label="Transfert" sortable="true" sortBy="#{var.var_select_ligne}" width="50px" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.trf}">
                            <f:facet name="header"><h:outputText  value="Trf." /></f:facet>
                            <h:selectBooleanCheckbox value="#{var.var_select_ligne}" rendered="#{(var.recEtat==1||var.recEtat==4)&&var.recSerie!='X'}"/>
                        </rich:column>
                        <rich:column label="Pièces jointes" sortable="true" sortBy="#{var.pj}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText value="PJ"/></f:facet>
                            <h:graphicImage value="#{var.pj}" height="20px" width="20px" rendered="#{var.pj!=null}"/>
                        </rich:column>
                        <rich:column label="Mode valorisation" sortable="true" sortBy="#{var.mode_valorisation}" width="80px">
                            <f:facet name="header"><h:outputText  value="Mode" /></f:facet>
                            <h:outputText value="#{var.mode_valorisation}"/>
                        </rich:column>
                        <rich:column label="Incoterm" sortable="true" sortBy="#{var.recIncoterm}" width="50px">
                            <f:facet name="header"><h:outputText  value="Inc." /></f:facet>
                            <h:outputText value="#{var.recIncoterm}"/>
                        </rich:column>
                        <rich:column label="Fournisseur" sortable="true" sortBy="#{var.var_nom_tiers}" width="200px">
                            <f:facet name="header"><h:outputText  value="Fournisseur"  /></f:facet>
                            <h:outputText  value="#{var.var_nom_tiers}"/>
                        </rich:column>
                         <rich:column label="Quantité totale" sortable="true" sortBy="#{var.recTotQte}" style="text-align:right;" width="80px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.affichageQtePoids==1}">
                            <f:facet name="header"><h:outputText  value="Qte" /></f:facet>
                            <h:outputText value="#{var.recTotQte}" rendered="#{var.recTotQte!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Poids total" sortable="true" sortBy="#{var.recTotPoidsBrut}" style="text-align:right;" width="80px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.affichageQtePoids==2}">
                            <f:facet name="header"><h:outputText  value="Poids" /></f:facet>
                            <h:outputText value="#{var.recTotPoidsBrut}" rendered="#{var.recTotPoidsBrut!=0}"/>
                        </rich:column>
                        <rich:column label="Objet" sortable="true" sortBy="#{var.recObject}" width="200px">
                            <f:facet name="header"><h:outputText value="Objet"/></f:facet>
                            <h:outputText  value="#{var.recObject}"/>
                        </rich:column>
                        <rich:column label="Devise" sortable="true" sortBy="#{var.recDevise}" width="50px">
                            <f:facet name="header"><h:outputText value="Dev."/></f:facet>
                            <h:outputText  value="#{var.recDevise}"/>
                        </rich:column>
                        <rich:column label="Devise" sortable="true" sortBy="#{var.recCoefDevise}" width="80px" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="Coef.Dev."/></f:facet>
                            <h:outputText  value="#{var.recCoefDevise}" rendered="#{var.recCoefDevise!=0}"/>
                        </rich:column>
                        <rich:column label="Montant H.T." sortable="true" sortBy="#{var.recTotHt}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="H.T."  /></f:facet>
                            <h:outputText  value="#{var.recTotHt}" rendered="#{var.recTotHt!=0&&var.var_format_devise==0}">
                                <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                            <h:outputText  value="#{var.recTotHt}" rendered="#{var.recTotHt!=0&&var.var_format_devise==1}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                            <h:outputText  value="#{var.recTotHt}" rendered="#{var.recTotHt!=0&&var.var_format_devise==2}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant des taxes" sortable="true" sortBy="#{var.recTotTva}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Taxes"/></f:facet>
                            <h:outputText  value="#{var.recTotTva}" rendered="#{var.recTotTva!=0&&var.var_format_devise==0}">
                                <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                            <h:outputText  value="#{var.recTotTva}" rendered="#{var.recTotTva!=0&&var.var_format_devise==1}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                            <h:outputText  value="#{var.recTotTva}" rendered="#{var.recTotTva!=0&&var.var_format_devise==2}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant T.T.C." sortable="true" sortBy="#{var.recTotTtc}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="T.T.C."/></f:facet>
                            <h:outputText  value="#{var.recTotTtc}" rendered="#{var.recTotTtc!=0&&var.var_format_devise==0}">
                                <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                            <h:outputText  value="#{var.recTotTtc}" rendered="#{var.recTotTtc!=0&&var.var_format_devise==1}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                            <h:outputText  value="#{var.recTotTtc}" rendered="#{var.recTotTtc!=0&&var.var_format_devise==2}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant H.T. Local" sortable="true" sortBy="#{var.recTotTtcLocal}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="HT(#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise})"/></f:facet>
                            <h:outputText  value="#{var.recTotTtcLocal}" rendered="#{var.recTotTtcLocal!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strformatdevise==0}">
                                <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                            <h:outputText  value="#{var.recTotTtcLocal}" rendered="#{var.recTotTtcLocal!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strformatdevise==1}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                            <h:outputText  value="#{var.recTotTtcLocal}" rendered="#{var.recTotTtcLocal!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strformatdevise==2}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Série" sortable="true" sortBy="#{var.recSerie}" style="text-align:center;" width="40px">
                            <f:facet name="header"><h:outputText  value="S." /></f:facet>
                            <h:outputText value="#{var.recSerie}"/>
                        </rich:column>
                        <rich:column label="Catégorie fournisseur" sortable="true" sortBy="#{var.recCat}" width="70px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Cat." /></f:facet>
                            <h:outputText value="#{var.recCat}"/>
                        </rich:column>
                        <rich:column label="Coefficient de revient" sortable="true" sortBy="#{var.recEtat}" width="80px" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Coef.Pr" /></f:facet>
                            <h:outputText value="#{var.recCoefValo}" rendered="#{var.recCoefValo!=0}"/>
                        </rich:column>
                        <rich:column label="Activité commerciale" sortable="true" sortBy="#{var.recActivite}" >
                            <f:facet name="header"><h:outputText value="Act."  /></f:facet>
                            <h:outputText  value="#{var.recActivite}"/>
                        </rich:column>
                        <rich:column label="Parc" sortable="true" sortBy="#{var.recAnal2}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_anal_parc}">
                            <f:facet name="header"><h:outputText value="Parc"  /></f:facet>
                            <h:outputText  value="#{var.recAnal2}"/>
                        </rich:column>
                        <rich:column label="Budget" sortable="true" sortBy="#{var.recBudget}" >
                            <f:facet name="header"><h:outputText value="Budget"  /></f:facet>
                            <h:outputText  value="#{var.recBudget}"/>
                        </rich:column>
                        <rich:column label="Objet de la réception" sortable="true" sortBy="#{var.recObject}" width="200px">
                            <f:facet name="header"><h:outputText value="Objet"  /></f:facet>
                            <h:outputText  value="#{var.recObject}"/>
                        </rich:column>
                        <rich:column label="Echéance" sortable="true" sortBy="#{var.recDateEcheReg}" width="70px" >
                            <f:facet name="header"><h:outputText value="Eché."  /></f:facet>
                            <h:outputText  value="#{var.recDateEcheReg}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Responsable" sortable="true" sortBy="#{var.recNomResponsable}" width="200px">
                            <f:facet name="header"><h:outputText  value="Respponsable"  /></f:facet>
                            <h:outputText  value="#{var.recNomResponsable}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
            <br/>
            <h:panelGrid id="pnlgrttotal" columns="4" cellspacing="1" styleClass="recherche"  width="100%">
                <h:panelGrid id="pnlgrttotalTTC" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpTTCL" value="Total TTC" />
                    <h:inputText id="intpTTCL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.montantTtc}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpTTCE" value="Total TTC" />
                    <h:inputText id="intpTTCE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.montantTtcElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalRGLMT" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpRGLMTL" value="Total Réglements" />
                    <h:inputText id="intpRGLMTL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.montantReglement}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpRGLMTE" value="Total Réglements" />
                    <h:inputText id="intpRGLMTE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.montantReglementElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalSOLD" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpSOLDL" value="Solde" />
                    <h:inputText id="intpSOLDL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.montantSolde}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpSOLDE" value="Solde" />
                    <h:inputText id="intpSOLDE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.montantSoldeElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalLE" columns="1" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpLIST" value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_nb_ligne})" />
                    <h:outputText id="outpELMT" value="(Eléments sélectionnés)" />
                </h:panelGrid>
            </h:panelGrid>
        </center>

    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.valQteGraph}" >
                                <f:selectItem itemLabel="En valeur" itemValue="0"/>
                                <f:selectItem itemLabel="en quantité" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <f:selectItem itemLabel="par responsable" itemValue="1"/>
                                <f:selectItem itemLabel="par société" itemValue="4"/>
                                <f:selectItem itemLabel="par famille produit" itemValue="5"/>
                                <f:selectItem itemLabel="par produit" itemValue="6"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <f:selectItem itemLabel="tranche horaire" itemValue="5"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelimpSerie" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelImput}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelImput}" var="imp">
            <f:facet name="header"><h:outputText value="Imputation N°/Série"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.annuleImputSerie}" image="/images/close.gif" styleClass="hidelink" reRender="panelimpSerie"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;" id="idChangement">
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_imput_choix}" >
                            <f:selectItem itemLabel="Changement Numéro" itemValue="0"/>
                            <f:selectItem itemLabel="Changement Série" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idChangement"/>
                        </h:selectOneMenu>
                    </h:column>
                    <br><br><br>
                    <h:panelGrid  columns="2" style="width:100%;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_imput_choix==0}">
                        <h:column><h:outputText value="Ancien Numéro:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recNum}" disabled="true" readonly="true"/></h:column>
                        <h:column><h:outputText value="Nouveau Numéro:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_imput_num}">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.controleNumero}" reRender="idChangement"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid  columns="2" style="width:100%;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_imput_choix==1}">
                        <h:column><h:outputText value="Série imputée:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="serieimput"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_imput_serie}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSerieUserItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="catimput" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_imput_cat}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesFamilleFournisseursItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <br>
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.miseajourImput}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelTrf" width="1150" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelTrf}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelTrf}" var="trf">
            <f:facet name="header"><h:outputText value="Transformation réception en ..."></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.annuleTrf}" image="/images/close.gif" styleClass="hidelink" reRender="panelTrf"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formTrf">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;" id="panGlobal">
                    <h:column>
                        <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_type_trf}" id="idSerieTrf">
                            <f:selectItem itemLabel="*** Sélectionnez type"  itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.documentTrfItems}" />
                            <a4j:support eventsQueue="maQueue" reRender="panGlobal,panelTrf,serieSel,modeleSel,valtrf,trf2,trf3,trf4,trf5,trf6" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.serieSelectTrf}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:panelGrid  columns="7" style="width:100%;background-color:#DAEECB;">
                        <h:column><h:outputText id="trf2" value="Date:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_trf}"/></h:column>
                        <h:column>
                            <rich:calendar id="trf3" inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_date_trf}"   enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_trf}">
                            </rich:calendar>&nbsp;&nbsp;
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_heure}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_trf}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                            </h:selectOneMenu>
                            <h:column><h:outputText value=":" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_trf}"/></h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_minute}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_trf}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="trf4" style="width:230px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_mode_trf}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_trf}">
                                <f:selectItem itemLabel="1 document => 1 document"  itemValue="0"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="serieSel" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_serie_trf}" style="width:80px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_trf}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.mesSeriesTrfItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="modeleSel" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_modele_trf}" style="width:120px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_trf}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.modeleTrfItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><a4j:commandButton id="trf5" value="Reste=Reliquat" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.qteTrfQteOrg}" reRender="tabletrf,modAttente" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_trf}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/></h:column>
                        <h:column><a4j:commandButton id="trf6" value="Raz Qte Reste" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.razQteTrf}" reRender="tabletrf" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_trf}"/></h:column>
                    </h:panelGrid>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_trf}"><h:outputText value="(Si la date est vide, alors le document généré prendra la date du document d'origine, si non, le document généré prendra la date spécifiée.)" style="color:red"/></h:column>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tabletrf" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.datamodelTransfert}" var="trf">
                            <rich:column label="N° réception" sortable="false" sortBy="#{trf.receptionEnteteAchats.recNum}" sortOrder="ASCENDING" width="10%">
                                <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                <h:outputText value="#{trf.receptionEnteteAchats.recNum}"/>
                            </rich:column>
                            <rich:column label="Date" sortable="false" width="5%">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{trf.receptionEnteteAchats.recDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Série" sortable="false" style="text-align:center;" width="5%">
                                <f:facet name="header"><h:outputText  value="S." /></f:facet>
                                <h:outputText value="#{trf.receptionEnteteAchats.recSerie}"/>
                            </rich:column>
                            <rich:column label="Fournisseur" sortable="false" width="14%">
                                <f:facet name="header"><h:outputText  value="Fournisseur"  /></f:facet>
                                <h:outputText  value="#{trf.receptionEnteteAchats.recNomTiers}"/>
                            </rich:column>
                            <rich:column label="Produit" sortable="false" width="26%">
                                <f:facet name="header"><h:outputText  value="Produit"  /></f:facet>
                                <h:outputText  value="#{trf.recligCode}"/>
                                <h:outputText  value=" - "/>
                                <h:outputText  value="#{trf.recligLibelle}"/>
                            </rich:column>
                            <rich:column label="Dépôt" sortable="false" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_type_trf==14}">
                                <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                <h:selectOneMenu id="iddepoligne" value="#{trf.var_depotLigne}" style="width:120px;">
                                    <f:selectItems value="#{trf.var_listDepotItem}" />
                                </h:selectOneMenu>
                            </rich:column>
                            <rich:column label="Quantité origine" sortable="false" style="text-align:right" width="10%">
                                <f:facet name="header"><h:outputText  value="Qte.Origine" /></f:facet>
                                <h:outputText  value="#{trf.recligQte}"/>
                            </rich:column>
                            <rich:column label="Quantité déjà transférée" sortable="false" style="text-align:right" width="10%">
                                <f:facet name="header"><h:outputText  value="Qte.trf." /></f:facet>
                                <h:outputText  value="#{trf.var_qteDejaTrf}"/>
                            </rich:column>
                            <rich:column label="Quantité restante" sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Qte.Reste" /></f:facet>
                                <h:inputText  value="#{trf.var_qteReliquat}" style="text-align:right;width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_type_trf==15}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:panel>
                <h:panelGroup>
                    <br>
                    <center>
                        <h:commandButton id="valtrf" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.transformerMaj}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.var_aff_trf}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelAnnuler" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelAnnuler}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.showModalPanelAnnuler}" var="ser">
            <f:facet name="header"><h:outputText value="Annulation Réception"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.annuleAnnulation}" image="/images/close.gif" styleClass="hidelink" reRender="panelAnnuler"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Date annulation:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recDateAnnule}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Motif annulation:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.receptionEnteteAchats.recMotifAnnule}" maxlength="50"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.miseajourAnnuler}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
