<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="commandeliste">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center> <h2><h:outputText value="GESTION DES COMMANDES D'ACHAT" style="color:green;" /></h2></center>

        <h:panelGrid  columns="1" width="60%" id="document" >
            <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
                <h:panelGrid columns="11" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_more_search}"/>
                    <h:column><h:outputText value="N°"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.inpNum}" size="5"/></h:column>
                    <h:column><h:outputText value="Fournisseur"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.inpFournisseur}" size="10"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="serie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.inpSerie}" style="width:100px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSerieUserItem}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.inpCat}" style="width:150px;">
                            <f:selectItem itemLabel="Toutes Catégories" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesFamilleFournisseursItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesEtatsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_more_search}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesPeriodesItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.inpActivite}" style="width:150px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_anal_activite}">
                            <f:selectItem itemLabel="Toutes Activités" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesActivitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.inpService}" style="width:150px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesServicesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,table,scrollTable,tableSuivi,scrollTableSuivi,tableAction,scrollTableAction,pnlgrttotal"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="8" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_more_search}">
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.inpBudget}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Budgets" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesBudgetsItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:outputText value="Responsable:" style="text-decoration:underline;"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.inpResponsable}" size="10">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les responsables" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.rechercheResponsable}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panCtrl,panDest,panelListeResponsable,formModalListeResponsable"/>
                        </h:inputText>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="parc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.inpParc}" style="width:100px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_anal_parc}">
                            <f:selectItem itemLabel="Tous Parcs" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesParcsItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.axeDossier=='2'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_anal_dossier}">
                        <h:outputText value="Dossier:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.axeDossier=='1'}"/>
                        <h:outputText value="Affaire:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.axeDossier=='2'}"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.inpDossier}"  size="7"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.axeDossier=='2'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_anal_activite}">
                        <h:outputText value="Analytique:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.inpAnal}"  size="7"/>
                    </h:column>
                    <h:column>
                        <h:outputText value="Du"/>
                        <rich:calendar  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.inpDu}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" />
                    </h:column>
                    <h:column>
                        <h:outputText value="Au:"/>
                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.inpAu}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" />
                    </h:column>
                    <a4j:commandButton title="Recherche sur fournisseur sélectionné" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.inpNomTiersEnCours}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.executerRequeteTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,table,scrollTable,pnlgrttotal"/>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <center>

            <rich:tabPanel switchType="client" immediate="true"  id="panelGlobalCommande" style="border:0px;background-color:transparent;" width="100%">

                <rich:tab id="tabCmd" label="Liste Commandes">
                    <h:panelGrid id="panelBouton" columns="18" width="550px" style="height:34px">
                        <a4j:commandButton title="Ajouter nouveau document" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.ajoutDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                        <a4j:commandButton title="Modifier le document sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.modifDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                        <a4j:commandButton title="Consulter le document sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.consultDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                        <a4j:commandButton title="Supprimer le document sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.supprimerDocument}" reRender="table,panelBouton,intpTTCL,intpRGLMTL,intpSOLDL"/>
                        <a4j:commandButton title="Annuler le document sélectionné" image="/images/annuler_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.sup}" onclick="if (!confirm('Etes-vous sur de vouloir annuler ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.annulerDocument}" reRender="panelAnnuler"/>
                        <a4j:commandButton title="Geler le document sélectionné" image="/images/geler.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBton&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat==3||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat==4)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.sup}" onclick="if (!confirm('Etes-vous sur de vouloir geler ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.gelerDocument}" reRender="panelGele,formGele"/>
                        <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
                        <a4j:commandButton title="Grapher" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}" reRender="panelGraph,formModalGraph,container" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.initGrapheur}"/>
                        <a4j:commandButton title="Changer N°/série" image="/images/imputer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifSerieAch==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.accesImputSerie}" reRender="panelimpSerie" />
                        <a4j:commandButton title="Dupliquer le document sélectionné" image="/images/duplicate.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.dup}" onclick="if (!confirm('Etes-vous sur de vouloir dupliquer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.duppliquerDocument}" reRender="modAttente,table,panelBouton,intpTTCL,intpRGLMTL,intpSOLDL" />
                        <a4j:commandButton title="Transformer le(s) document(s) sélectionné(s)" image="/images/transferer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBton&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat==4)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.trf}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.transformerDocument}" reRender="panelTrf,formTrf,idSerieTrf"/>
                        <h:commandButton title="Calculer reliquat" image="/images/reliquat.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculReliquat}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        <a4j:commandButton title="Bon de décaissement du/des document(s) sélectionné(s)" image="/images/bonCaisse.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.reglementAutorise&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat==4||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat==5)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_affiche_be}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.payeDocumentBonEncaissement}" reRender="panelPaye,panelBouton" />
                        <a4j:commandButton title="Règlement direct du/des document(s) sélectionné(s)" image="/images/dollar.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.reglementAutorise&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat==4||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat==5)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_affiche_dollar}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.payeXDocumentRecu}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPayeXDoc,panelBouton" />
                        <a4j:commandButton title="Historique des règlements du document sélectionné" image="/images/histoPaiement.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat>=1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.histoReglement}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelHistoReglement" />
                        <a4j:commandButton title="Valider le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document ?')) return false" reRender="panelBouton,idEtat,idTrf"/>
                        <a4j:commandButton title="Dé-Valider le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document ?')) return false" reRender="panelBouton,idEtat,idTrf"/>
                        <a4j:commandButton title="Simulation calcul du Prix de Revient" image="/images/pr.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.initChargerSimulation}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_simluationPr&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBton}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                        <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
                    </h:panelGrid>
                    <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="200%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.datamodelEntete}" var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.extDTable}">
                                <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,panelBoutonSuivi,intpSOLDE,intpTTCE,intpRGLMTE"/>
                                <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visualisationLigne}" reRender="idSubView,panelBouton,panCtrl,panelBoutonSuivi,intpSOLDE,intpTTCE,intpRGLMTE"/>
                                <rich:column label="N° commande" sortable="true" sortBy="#{var.cmdNum}">
                                    <f:facet name="header"><h:outputText  value="N° CMD." /></f:facet>
                                    <h:outputText value="#{var.cmdNum}"/>
                                </rich:column>
                                <rich:column label="Etat signature" sortable="true" sortBy="#{var.cmdPosSignature}" width="70px" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.habilitation!=null}">
                                    <f:facet name="header"><h:outputText  value="Sign." /></f:facet>
                                    <h:outputText  value="#{var.cmdPosSignature}/#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.habilitation.habNombre}" style="text-align:center;"/>
                                </rich:column>
                                <rich:column label="N° dossier/affaire" sortable="true" sortBy="#{var.cmdAnal4}">
                                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.libelleDossier}" /></f:facet>
                                    <h:outputText value="#{var.cmdAffaire}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.axeDossier=='2'}"/>
                                    <h:outputText value="#{var.cmdAnal4}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.axeDossier!='2'}"/>
                                </rich:column>
                                <rich:column label="N° analytique" sortable="true" sortBy="#{var.cmdAnal4}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.axeDossier=='2'}">
                                    <f:facet name="header"><h:outputText  value="N°ANAL." /></f:facet>
                                    <h:outputText value="#{var.cmdAnal4}"/>
                                </rich:column>
                                <rich:column label="Date commande" sortable="true" sortBy="#{var.cmdDate} #{var.cmdNum}" width="70px">
                                    <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                    <h:outputText value="#{var.cmdDate}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Série" sortable="true" sortBy="#{var.cmdSerie}" style="text-align:center;" width="40px">
                                    <f:facet name="header"><h:outputText  value="S." /></f:facet>
                                    <h:outputText value="#{var.cmdSerie}"/>
                                </rich:column>
                                <rich:column label="Phase de construction" sortable="true" sortBy="#{var.cmdPhase}" width="80px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.moduleImmobilier}">
                                    <f:facet name="header"><h:outputText  value="Phase" /></f:facet>
                                    <h:outputText value="#{var.libellePhase}"/>
                                </rich:column>
                                <rich:column label="Catégorie fournisseur" sortable="true" sortBy="#{var.cmdCat}" width="70px" style="text-align:center;">
                                    <f:facet name="header"><h:outputText  value="Cat." /></f:facet>
                                    <h:outputText value="#{var.cmdCat}"/>
                                </rich:column>
                                <rich:column id="idEtat"  label="Etat" sortable="true" sortBy="#{var.cmdEtat}" width="50px" style="text-align:center;">
                                    <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                    <h:outputText value="#{var.libelleEta}"/>
                                </rich:column>
                                <rich:column id="idTrf"  label="Transfert" sortable="true" sortBy="#{var.var_select_ligne}" width="50px" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.trf}">
                                    <f:facet name="header"><h:outputText  value="Trf." /></f:facet>
                                    <h:selectBooleanCheckbox value="#{var.var_select_ligne}" rendered="#{(var.cmdEtat==1||var.cmdEtat==4)&&var.cmdSerie!='X'}"/>
                                </rich:column>
                                <rich:column label="Fournisseur" sortable="true" sortBy="#{var.var_nom_tiers}" width="200px">
                                    <f:facet name="header"><h:outputText  value="Fournisseur"  /></f:facet>
                                    <h:outputText  value="#{var.var_nom_tiers}"/>
                                </rich:column>
                                <rich:column label="Contact" sortable="true" sortBy="#{var.var_nomContact}" width="200px">
                                    <f:facet name="header"><h:outputText value="Contact"/></f:facet>
                                    <h:outputText  value="#{var.var_nomContact}"/>
                                </rich:column>
                                <rich:column label="Devise" sortable="true" sortBy="#{var.cmdDevise}" width="50px">
                                    <f:facet name="header"><h:outputText value="Dev."/></f:facet>
                                    <h:outputText  value="#{var.cmdDevise}"/>
                                </rich:column>
                                <rich:column label="Montant H.T." sortable="true" sortBy="#{var.cmdTotHt}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="H.T."  /></f:facet>
                                    <h:outputText  value="#{var.cmdTotHt}" rendered="#{var.cmdTotHt!=0&&var.var_format_devise==0}">
                                        <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText  value="#{var.cmdTotHt}" rendered="#{var.cmdTotHt!=0&&var.var_format_devise==1}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText  value="#{var.cmdTotHt}" rendered="#{var.cmdTotHt!=0&&var.var_format_devise==2}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Montant des taxes" sortable="true" sortBy="#{var.cmdTotTva}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Taxes"/></f:facet>
                                    <h:outputText  value="#{var.cmdTotTva}" rendered="#{var.cmdTotTva!=0&&var.var_format_devise==0}">
                                        <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText  value="#{var.cmdTotTva}" rendered="#{var.cmdTotTva!=0&&var.var_format_devise==1}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText  value="#{var.cmdTotTva}" rendered="#{var.cmdTotTva!=0&&var.var_format_devise==2}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Montant T.T.C." sortable="true" sortBy="#{var.cmdTotTtc}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                    <h:outputText  value="#{var.cmdTotTtc}" rendered="#{var.cmdTotTtc!=0&&var.var_format_devise==0}">
                                        <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText  value="#{var.cmdTotTtc}" rendered="#{var.cmdTotTtc!=0&&var.var_format_devise==1}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText  value="#{var.cmdTotTtc}" rendered="#{var.cmdTotTtc!=0&&var.var_format_devise==2}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Règlements" sortable="true" sortBy="#{var.cmdTotReglement}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.reglementAutorise}">
                                    <f:facet name="header"><h:outputText value="Régl."  /></f:facet>
                                    <h:outputText  value="#{var.cmdTotReglement}" rendered="#{var.cmdTotReglement!=0&&var.var_format_devise==0}">
                                        <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText  value="#{var.cmdTotReglement}" rendered="#{var.cmdTotReglement!=0&&var.var_format_devise==1}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText  value="#{var.cmdTotReglement}" rendered="#{var.cmdTotReglement!=0&&var.var_format_devise==2}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Solde" sortable="true" sortBy="#{var.var_reliquat}" style="text-align:right;color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.reglementAutorise}">
                                    <f:facet name="header"> <h:outputText value="Solde"  /></f:facet>
                                    <h:outputText  value="#{var.var_reliquat}" rendered="#{var.var_reliquat!=0&&var.var_format_devise==0}">
                                        <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText  value="#{var.var_reliquat}" rendered="#{var.var_reliquat!=0&&var.var_format_devise==1}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText  value="#{var.var_reliquat}" rendered="#{var.var_reliquat!=0&&var.var_format_devise==2}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Montant T.T.C. local" sortable="true" sortBy="#{var.cmdTotTtcLocal}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="T.T.C Local"/></f:facet>
                                    <h:outputText  value="#{var.cmdTotTtcLocal}" rendered="#{var.cmdTotTtcLocal!=0}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Activité commerciale" sortable="true" sortBy="#{var.cmdActivite}" >
                                    <f:facet name="header"><h:outputText value="Act."  /></f:facet>
                                    <h:outputText  value="#{var.cmdActivite}"/>
                                </rich:column>
                                <rich:column label="Parc" sortable="true" sortBy="#{var.cmdAnal2}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_anal_parc}">
                                    <f:facet name="header"><h:outputText value="Parc"  /></f:facet>
                                    <h:outputText  value="#{var.cmdAnal2}"/>
                                </rich:column>
                                <rich:column label="Budget" sortable="true" sortBy="#{var.cmdBudgetPoste}" >
                                    <f:facet name="header"><h:outputText value="Budget"  /></f:facet>
                                    <h:outputText  value="#{var.cmdBudgetPoste}"/>
                                </rich:column>
                                <rich:column label="Quantité totale" sortable="true" sortBy="#{var.cmdTotQte}" style="text-align:right;" width="80px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.affichageQtePoids==1}">
                                    <f:facet name="header"><h:outputText  value="Qte" /></f:facet>
                                    <h:outputText value="#{var.cmdTotQte}" rendered="#{var.cmdTotQte!=0}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Poids total" sortable="true" sortBy="#{var.cmdTotPoidsBrut}" style="text-align:right;" width="80px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.affichageQtePoids==2}">
                                    <f:facet name="header"><h:outputText  value="Poids" /></f:facet>
                                    <h:outputText value="#{var.cmdTotPoidsBrut}" rendered="#{var.cmdTotPoidsBrut!=0}"/>
                                </rich:column>
                                <rich:column label="Objet de la commande" sortable="true" sortBy="#{var.cmdObject}" width="200px">
                                    <f:facet name="header"><h:outputText value="Objet"  /></f:facet>
                                    <h:outputText  value="#{var.cmdObject}"/>
                                </rich:column>
                                <rich:column label="Echéance" sortable="true" sortBy="#{var.cmdDateEcheReg}" width="70px" >
                                    <f:facet name="header"><h:outputText value="Eché."  /></f:facet>
                                    <h:outputText  value="#{var.cmdDateEcheReg}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Responsable" sortable="true" sortBy="#{var.cmdNomResponsable}" width="200px">
                                    <f:facet name="header"><h:outputText  value="Respponsable"  /></f:facet>
                                    <h:outputText  value="#{var.cmdNomResponsable}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </div>
                </rich:tab>

                <rich:tab id="tabSuivi" label="Suivi Commandes">
                    <h:panelGrid id="panelBoutonSuivi" columns="5" style="height:34px">
                        <a4j:commandButton title="Modifier le suivi sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBtonSuivi&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.modifDocumentSuivi}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelSuiviCmd"/>
                        <a4j:commandButton title="Consulter le siuvi sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBtonSuivi}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.consultDocumentSuivi}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelSuiviCmd"/>
                        <a4j:commandButton title="Détail préparation" value="Détail préparation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBtonSuivi}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.affichePreparation}" reRender="tableSuivi"/>
                        <a4j:commandButton title="Détail paiement" value="Détail paiement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBtonSuivi}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.affichePaiement}" reRender="tableSuivi"/>
                        <a4j:commandButton title="Détail suivi" value="Détail suivi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBtonSuivi}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.afficheSuivi}" reRender="tableSuivi"/>
                    </h:panelGrid>
                    <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableSuivi" maxPages="20"align="left" for="tableSuivi"/>
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_nb_max}" style="max-height:100%" styleClass="bg" id="tableSuivi" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="150%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.datamodelEnteteSuivi}" var="var">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.selectionLigneSuivi}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panelBoutonSuivi"/>
                                <rich:column label="N° commande" sortable="true" sortBy="#{var.cmdNum}">
                                    <f:facet name="header"><h:outputText  value="N° CMD." /></f:facet>
                                    <h:outputText value="#{var.cmdNum}"/>
                                </rich:column>
                                <rich:column label="N° dossier" sortable="true" sortBy="#{var.cmdAnal4}" width="80px">
                                    <f:facet name="header"><h:outputText  value="N° DOS." /></f:facet>
                                    <h:outputText value="#{var.cmdAnal4}"/>
                                </rich:column>
                                <rich:column label="Date commande" sortable="true" sortBy="#{var.cmdDate} #{var.cmdNum}" width="70px">
                                    <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                    <h:outputText value="#{var.cmdDate}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Fournisseur" sortable="true" sortBy="#{var.var_nom_tiers}" width="200px">
                                    <f:facet name="header"><h:outputText  value="Fournisseur"  /></f:facet>
                                    <h:outputText  value="#{var.var_nom_tiers}"/>
                                </rich:column>
                                <rich:column label="Objet de la commande" sortable="true" sortBy="#{var.cmdObject}" width="200px">
                                    <f:facet name="header"><h:outputText value="Objet"  /></f:facet>
                                    <h:outputText  value="#{var.cmdObject}"/>
                                </rich:column>
                                <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.affichageDetail==0}" var="v2">
                                    <rich:column label="Mode importation" sortable="true" sortBy="#{var.libelleMode}" width="80px">
                                        <f:facet name="header"><h:outputText value="Mode"  /></f:facet>
                                        <h:outputText  value="#{var.libelleMode}"/>
                                    </rich:column>
                                    <rich:column label="Incoterm" sortable="true" sortBy="#{var.cmdIncoterm}" width="50px">
                                        <f:facet name="header"><h:outputText value="Inco."/></f:facet>
                                        <h:outputText  value="#{var.cmdIncoterm}"/>
                                    </rich:column>
                                    <rich:column label="Type contener" sortable="true" sortBy="#{var.cmdTypeContener}" width="50px">
                                        <f:facet name="header"><h:outputText value="Contener."/></f:facet>
                                        <h:outputText  value="#{var.cmdTypeContener}"/>
                                    </rich:column>
                                    <rich:column label="Nb contener" sortable="true" sortBy="#{var.cmdNbContener}" width="50px">
                                        <f:facet name="header"><h:outputText value="Nb"/></f:facet>
                                        <h:outputText  value="#{var.cmdNbContener}"/>
                                    </rich:column>
                                    <rich:column label="Date demande FDI/DPI" sortable="true" sortBy="#{var.cmdDateFdi}" width="80px">
                                        <f:facet name="header"><h:outputText value="Fdi/Dpi"/></f:facet>
                                        <h:outputText value="#{var.cmdDateFdi}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Fdi/DPI" sortable="true" sortBy="#{var.cmdNomTiersFdi}" width="50px">
                                        <f:facet name="header"><h:outputText value="A qui"/></f:facet>
                                        <h:outputText  value="#{var.cmdNomTiersFdi}"/>
                                    </rich:column>
                                    <rich:column label="Date remise FDI/DPI" sortable="true" sortBy="#{var.cmdEnvoiFdi}" width="80px">
                                        <f:facet name="header"><h:outputText value="Remise"/></f:facet>
                                        <h:outputText value="#{var.cmdEnvoiFdi}" style="color:blue">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Date réception doc. originaux" sortable="true" sortBy="#{var.cmdDateDocOriginaux}" width="80px">
                                        <f:facet name="header"><h:outputText value="Doc. Ori."/></f:facet>
                                        <h:outputText value="#{var.cmdDateDocOriginaux}" style="color:blue">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Date demande assurance" sortable="true" sortBy="#{var.cmdDateAssurance}" width="80px">
                                        <f:facet name="header"><h:outputText value="Assurance"/></f:facet>
                                        <h:outputText value="#{var.cmdDateAssurance}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Date RFCV" sortable="true" sortBy="#{var.cmdDateRfcv}" width="80px">
                                        <f:facet name="header"><h:outputText value="RFCV"/></f:facet>
                                        <h:outputText value="#{var.cmdDateRfcv}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Date remise doc. transitaire" sortable="true" sortBy="#{var.cmdDateDocTransit}" width="80px">
                                        <f:facet name="header"><h:outputText value="Doc. remis."/></f:facet>
                                        <h:outputText value="#{var.cmdDateDocTransit}" style="color:blue">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                </c:if>
                                <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.affichageDetail==1}" var="v1">
                                    <rich:column label="Devise" sortable="true" sortBy="#{var.cmdNomContact}" width="50px">
                                        <f:facet name="header"><h:outputText value="Dev."/></f:facet>
                                        <h:outputText  value="#{var.cmdDevise}"/>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{var.cmdTotTtc}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{var.cmdTotTtc}" rendered="#{var.cmdTotTtc!=0&&var.var_format_devise==0}">
                                            <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                        <h:outputText  value="#{var.cmdTotTtc}" rendered="#{var.cmdTotTtc!=0&&var.var_format_devise==1}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                        <h:outputText  value="#{var.cmdTotTtc}" rendered="#{var.cmdTotTtc!=0&&var.var_format_devise==2}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Quantité totale" sortable="true" sortBy="#{var.cmdTotQte}" style="text-align:right;" width="80px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.affichageQtePoids==1}">
                                        <f:facet name="header"><h:outputText  value="Qte" /></f:facet>
                                        <h:outputText value="#{var.cmdTotQte}" rendered="#{var.cmdTotQte!=0}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Poids total" sortable="true" sortBy="#{var.cmdTotPoidsBrut}" style="text-align:right;" width="80px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.affichageQtePoids==2}">
                                        <f:facet name="header"><h:outputText  value="Poids" /></f:facet>
                                        <h:outputText value="#{var.cmdTotPoidsBrut}" rendered="#{var.cmdTotPoidsBrut!=0}"/>
                                    </rich:column>
                                    <rich:column label="Date paiement" sortable="true" sortBy="#{var.cmdDatePaiement}" width="80px" >
                                        <f:facet name="header"><h:outputText value="Paiement"  /></f:facet>
                                        <h:outputText  value="#{var.cmdDatePaiement}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Moyen paiement" sortable="true" sortBy="#{var.cmdMoyenPaiement}" width="80px">
                                        <f:facet name="header"><h:outputText value="Moyen"/></f:facet>
                                        <h:outputText  value="#{var.cmdMoyenPaiement}"/>
                                    </rich:column>
                                    <rich:column label="Observations paiement" sortable="true" sortBy="#{var.cmdObsPaiement}" width="100px">
                                        <f:facet name="header"><h:outputText value="Obs."/></f:facet>
                                        <h:outputText  value="#{var.cmdObsPaiement}"/>
                                    </rich:column>
                                    <rich:column label="Tracking (N° bateau, n° Vol, N° DHL...)" sortable="true" sortBy="#{var.cmdTracking}" width="100px" >
                                        <f:facet name="header"><h:outputText value="Tracking"/></f:facet>
                                        <h:outputText  value="#{var.cmdTracking}"/>
                                    </rich:column>
                                </c:if>
                                <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.affichageDetail==2}" var="v3">
                                    <rich:column label="Date livraison Théorique" sortable="true" sortBy="#{var.cmdDateLivraison}" width="80px" >
                                        <f:facet name="header"><h:outputText value="Livr. R."/></f:facet>
                                        <h:outputText  value="#{var.cmdDateLivraison}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Date Départ Usine" sortable="true" sortBy="#{var.cmdDateDepartUsine}" width="80px">
                                        <f:facet name="header"><h:outputText value="Usine"/></f:facet>
                                        <h:outputText value="#{var.cmdDateDepartUsine}" style="color:blue">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Lieu Livraison" sortable="true" sortBy="#{var.cmdLieuLivraison}" width="100px">
                                        <f:facet name="header"><h:outputText value="Lieu"/></f:facet>
                                        <h:outputText  value="#{var.cmdLieuLivraison}"/>
                                    </rich:column>
                                    <rich:column label="Date Livraison Transitaire" sortable="true" sortBy="#{var.cmdDateArriveeTransit}" width="80px">
                                        <f:facet name="header"><h:outputText value="Transitaire"/></f:facet>
                                        <h:outputText  value="#{var.cmdDateArriveeTransit}" style="color:blue">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Date Embarquement Théorique" sortable="true" sortBy="#{var.cmdDateEmbarquementTheo}" width="80px" >
                                        <f:facet name="header"><h:outputText value="Embarq.T."/></f:facet>
                                        <h:outputText  value="#{var.cmdDateEmbarquementTheo}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Date Embarquement Réel" sortable="true" sortBy="#{var.cmdDateEmbarquementTheo}" width="80px" >
                                        <f:facet name="header"><h:outputText value="Embarq.R."/></f:facet>
                                        <h:outputText  value="#{var.cmdDateEmbarquementReel}" style="color:blue">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Date Arrivée Port Théo" sortable="true" sortBy="#{var.cmdDateArriveePortTheo}" width="80px" >
                                        <f:facet name="header"><h:outputText value="Arriv. T."/></f:facet>
                                        <h:outputText  value="#{var.cmdDateArriveePortTheo}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Date Arrivée Port Réel" sortable="true" sortBy="#{var.cmdDateArriveePortTheo}" width="80px" >
                                        <f:facet name="header"><h:outputText value="Arriv. R."/></f:facet>
                                        <h:outputText  value="#{var.cmdDateArriveePortReel}" style="color:blue">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Date livraison Réelle" sortable="true" sortBy="#{var.cmdDateLivraison}" width="80px" >
                                        <f:facet name="header"><h:outputText value="Livr. R."/></f:facet>
                                        <h:outputText  value="#{var.cmdDateLivreDepot}" style="color:blue">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Date maj stock" sortable="true" sortBy="#{var.cmdDateStock}" width="80px" >
                                        <f:facet name="header"><h:outputText value="Stock"/></f:facet>
                                        <h:outputText  value="#{var.cmdDateStock}" style="color:blue">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Date recup. caution" sortable="true" sortBy="#{var.cmdDateDocCaution}" width="80px" >
                                        <f:facet name="header"><h:outputText value="Caution"/></f:facet>
                                        <h:outputText  value="#{var.cmdDateDocCaution}" style="color:blue">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                        </h:outputText>
                                    </rich:column>
                                </c:if>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </div>
                </rich:tab>

                <rich:tab id="tabAction" label="Action à faire">
                    <h:panelGrid id="panelBoutonAction" columns="2" width="150px" style="height:34px">
                        <a4j:commandButton title="Modifier le suivi sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBtonSuivi&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.modifDocumentAction}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelAction"/>
                        <a4j:commandButton title="Consulter le siuvi sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBtonSuivi}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.consultDocumentAction}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelAction"/>
                    </h:panelGrid>
                    <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableAction" maxPages="20"align="left" for="tableAction"/>
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_nb_max}" style="max-height:100%" styleClass="bg" id="tableAction" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="140%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.datamodelEnteteSuivi}" var="var">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.selectionLigneAction}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panelBoutonSuivi,panelBoutonAction"/>
                                <rich:column label="N° commande" sortable="true" sortBy="#{var.cmdNum}">
                                    <f:facet name="header"><h:outputText  value="N° CMD." /></f:facet>
                                    <h:outputText value="#{var.cmdNum}"/>
                                </rich:column>
                                <rich:column label="N° dossier" sortable="true" sortBy="#{var.cmdAnal4}" width="80px">
                                    <f:facet name="header"><h:outputText  value="N° DOS." /></f:facet>
                                    <h:outputText value="#{var.cmdAnal4}"/>
                                </rich:column>
                                <rich:column label="Date commande" sortable="true" sortBy="#{var.cmdDate} #{var.cmdNum}" width="70px">
                                    <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                    <h:outputText value="#{var.cmdDate}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Fournisseur" sortable="true" sortBy="#{var.var_nom_tiers}" width="200px">
                                    <f:facet name="header"><h:outputText  value="Fournisseur"  /></f:facet>
                                    <h:outputText  value="#{var.var_nom_tiers}"/>
                                </rich:column>
                                <rich:column label="Objet de la commande" sortable="true" sortBy="#{var.cmdObject}" width="200px">
                                    <f:facet name="header"><h:outputText value="Objet"  /></f:facet>
                                    <h:outputText  value="#{var.cmdObject}"/>
                                </rich:column>
                                <rich:column label="Prochaine action à faire" sortable="true" sortBy="#{var.cmdProchaineAction}" width="600px">
                                    <f:facet name="header"><h:outputText value="Prochaine action à faire"  /></f:facet>
                                    <h:outputText  value="#{var.cmdProchaineAction}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </div>
                </rich:tab>

            </rich:tabPanel>

        </center>
        <br/>
        <h:panelGrid id="pnlgrttotal" columns="4" cellspacing="1" styleClass="recherche"  width="60%">
            <h:panelGrid id="pnlgrttotalTTC" columns="2" cellspacing="3"  cellpadding="3">
                <h:outputText id="outpTTCL" value="Total TTC" />
                <h:inputText id="intpTTCL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.montantTtc}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
                <h:outputText id="outpTTCE" value="Total TTC" />
                <h:inputText id="intpTTCE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.montantTtcElmt}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
            </h:panelGrid>
            <h:panelGrid id="pnlgrttotalRGLMT" columns="2" cellspacing="3"  cellpadding="3"   rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.reglementAutorise}">
                <h:outputText id="outpRGLMTL" value="Total Réglements" />
                <h:inputText id="intpRGLMTL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.montantReglement}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
                <h:outputText id="outpRGLMTE" value="Total Réglements" />
                <h:inputText id="intpRGLMTE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.montantReglementElmt}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
            </h:panelGrid>
            <h:panelGrid id="pnlgrttotalSOLD" columns="2" cellspacing="3"  cellpadding="3"   rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.reglementAutorise}">
                <h:outputText id="outpSOLDL" value="Solde" />
                <h:inputText id="intpSOLDL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.montantSolde}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
                <h:outputText id="outpSOLDE" value="Solde" />
                <h:inputText id="intpSOLDE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.montantSoldeElmt}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
            </h:panelGrid>
            <h:panelGrid id="pnlgrttotalLE" columns="1" cellspacing="3"  cellpadding="3">
                <h:outputText id="outpLIST" value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_nb_ligne})" />
                <h:outputText id="outpELMT" value="(Eléments sélectionnés)" />
            </h:panelGrid>
        </h:panelGrid>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.valQteGraph}" >
                                <f:selectItem itemLabel="En valeur" itemValue="0"/>
                                <f:selectItem itemLabel="en quantité" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <f:selectItem itemLabel="par responsable" itemValue="1"/>
                                <f:selectItem itemLabel="par société" itemValue="4"/>
                                <f:selectItem itemLabel="par famille produit" itemValue="5"/>
                                <f:selectItem itemLabel="par produit" itemValue="6"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <f:selectItem itemLabel="tranche horaire" itemValue="5"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelimpSerie" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelImput}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelImput}" var="imp">
            <f:facet name="header"><h:outputText value="Imputation N°/Série"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.annuleImputSerie}" image="/images/close.gif" styleClass="hidelink" reRender="panelimpSerie"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;" id="idChangement">
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_imput_choix}" >
                            <f:selectItem itemLabel="Changement Numéro" itemValue="0"/>
                            <f:selectItem itemLabel="Changement Série" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idChangement"/>
                        </h:selectOneMenu>
                    </h:column>
                    <br><br><br>
                    <h:panelGrid  columns="2" style="width:100%;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_imput_choix==0}">
                        <h:column><h:outputText value="Ancien Numéro:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdNum}" disabled="true" readonly="true"/></h:column>
                        <h:column><h:outputText value="Nouveau Numéro:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_imput_num}">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.controleNumero}" reRender="idChangement"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid  columns="2" style="width:100%;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_imput_choix==1}">
                        <h:column><h:outputText value="Série imputée:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="serieimput"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_imput_serie}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSerieUserItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Impacter la série des produits:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.impacteProduit}"/></h:column>
                        <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="catimput" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_imput_cat}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesFamilleFournisseursItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <br>
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.miseajourImput}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelTrf" width="1150" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelTrf}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelTrf}" var="trf">
            <f:facet name="header"><h:outputText value="Transformation commande en ..."></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.annuleTrf}" image="/images/close.gif" styleClass="hidelink" reRender="panelTrf"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formTrf">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;" id="panGlobal">
                    <h:column>
                        <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_type_trf}" id="idSerieTrf">
                            <f:selectItem itemLabel="*** Sélectionnez type"  itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.documentTrfItems}" />
                            <a4j:support eventsQueue="maQueue" reRender="panGlobal,panelTrf,serieSel,modeleSel,valtrf,trf2,trf3,trf4,trf5,trf6" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.serieSelectTrf}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:panelGrid  columns="8" style="width:100%;background-color:#DAEECB;">
                        <h:column><h:outputText id="trf2" value="Date:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_trf}"/></h:column>
                        <h:column>
                            <rich:calendar id="trf3" inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_date_trf}"   enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_trf}">
                            </rich:calendar>&nbsp;&nbsp;
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_heure}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_trf}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                            </h:selectOneMenu>
                            <h:column><h:outputText value=":" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_trf}"/></h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_minute}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_trf}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="trf4" style="width:230px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_mode_trf}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_trf}">
                                <f:selectItem itemLabel="1 document => 1 document"  itemValue="0"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="serieSel" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_serie_trf}" style="width:80px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_trf}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.mesSeriesTrfItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu style="width:30%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_coef_pr}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_trf}">
                                <f:selectItem itemValue="0" itemLabel="PR sur Coef."/>
                                <f:selectItem itemValue="1" itemLabel="PR sur Frais"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="modeleSel" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_modele_trf}" style="width:120px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_trf}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.modeleTrfItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><a4j:commandButton id="trf5" value="Reste=Reliquat" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.qteTrfQteOrg}" reRender="tabletrf,modAttente" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_trf}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/></h:column>
                        <h:column><a4j:commandButton id="trf6" value="Raz Qte Reste" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.razQteTrf}" reRender="tabletrf" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_trf}"/></h:column>
                    </h:panelGrid>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_trf}"><h:outputText value="(Si la date est vide, alors le document généré prendra la date du document d'origine, si non, le document généré prendra la date spécifiée.)" style="color:red"/></h:column>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tabletrf" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.datamodelTransfert}" var="trf">
                            <rich:column label="N° commande" sortable="false" sortBy="#{trf.commandeEnteteAchats.cmdNum}" sortOrder="ASCENDING" width="10%">
                                <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                <h:outputText value="#{trf.commandeEnteteAchats.cmdNum}"/>
                            </rich:column>
                            <rich:column label="Date" sortable="false" width="5%">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{trf.commandeEnteteAchats.cmdDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Série" sortable="false" style="text-align:center;" width="5%">
                                <f:facet name="header"><h:outputText  value="S." /></f:facet>
                                <h:outputText value="#{trf.commandeEnteteAchats.cmdSerie}"/>
                            </rich:column>
                            <rich:column label="Fournisseur" sortable="false" width="14%">
                                <f:facet name="header"><h:outputText  value="Fournisseur"  /></f:facet>
                                <h:outputText  value="#{trf.commandeEnteteAchats.cmdNomTiers}"/>
                            </rich:column>
                            <rich:column label="Produit" sortable="false" width="26%">
                                <f:facet name="header"><h:outputText  value="Produit"  /></f:facet>
                                <h:outputText  value="#{trf.codeProduit}"/>
                                <h:outputText  value=" - "/>
                                <h:outputText  value="#{trf.libelleProsduit}"/>
                            </rich:column>
                            <rich:column label="Dépôt" sortable="false" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_type_trf==13}">
                                <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                <h:selectOneMenu id="iddepoligne" value="#{trf.var_depotLigne}" style="width:120px;">
                                    <f:selectItems value="#{trf.var_listDepotItem}" />
                                </h:selectOneMenu>
                            </rich:column>
                            <rich:column label="Quantité origine" sortable="false" style="text-align:right" width="10%">
                                <f:facet name="header"><h:outputText  value="Qte.Origine" /></f:facet>
                                <h:outputText  value="#{trf.cmdligQte}"/>
                            </rich:column>
                            <rich:column label="Quantité déjà transférée" sortable="false" style="text-align:right" width="10%">
                                <f:facet name="header"><h:outputText  value="Qte.trf." /></f:facet>
                                <h:outputText  value="#{trf.var_qteDejaTrf}"/>
                            </rich:column>
                            <rich:column label="Quantité reçue" sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Qte.Reçue" /></f:facet>
                                <h:inputText  value="#{trf.var_qteReliquat}" style="text-align:right;width:90%"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:panel>
                <h:panelGroup>
                    <br>
                    <center>
                        <h:commandButton id="valtrf" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.transformerMaj}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_trf}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelReliquat" width="1150" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelReliquat}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelReliquat}" var="rel">
            <f:facet name="header"><h:outputText value="Gestion des reliquats"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.fermerReliquat}" image="/images/close.gif" styleClass="hidelink" reRender="panelReliquat"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formReliquat">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;" id="panGlobal">
                    <jsp:include flush="true" page="/achats/CommandeCommun.jsp"/>
                    <h:panelGroup>
                        <center>
                            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}" reRender="printReliquat,formModalImp" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.initImpressionReliquat}"/>
                        </center>
                    </h:panelGroup>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableReliquat" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.dataModelReliquat}" var="trf">
                            <rich:column id="idProduit" title="Produit" sortable="false" width="40%">
                                <f:facet name="header"><h:outputText  value="Produit"/></f:facet>
                                <h:outputText  value="#{trf.cmdligCode}" style="#{trf.familleStyle}"/>
                                <h:outputText  value=" - "/>
                                <h:outputText  value="#{trf.cmdligLibelle}" style="#{trf.familleStyle}"/>
                            </rich:column>
                            <rich:column label="Dépôt" sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                <h:outputText  value="#{trf.cmdligDepot}" style="#{trf.familleStyle}"/>
                            </rich:column>
                            <rich:column label="Date" sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                <h:outputText  value="#{trf.cmdligDescription}" style="#{trf.familleStyle}"/>
                            </rich:column>
                            <rich:column label="Quantité commandée" sortable="false" style="text-align:right" width="10%">
                                <f:facet name="header"><h:outputText  value="Qte.Commandée" /></f:facet>
                                <h:outputText  value="#{trf.cmdligQteUtil}" rendered="#{trf.cmdligQteUtil!=0}" style="#{trf.familleStyle}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecQte}"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Quantité déjà reçue" sortable="false" style="text-align:right" width="10%">
                                <f:facet name="header"><h:outputText  value="Qte.reçue" /></f:facet>
                                <h:outputText  value="#{trf.cmdligQteLivree}" rendered="#{trf.cmdligQteLivree!=0}" style="#{trf.familleStyle}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecQte}"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Quantité restante" sortable="false" style="text-align:right" width="10%">
                                <f:facet name="header"><h:outputText  value="Qte.Restante" /></f:facet>
                                <h:outputText  value="#{trf.var_qteRestante}" rendered="#{trf.var_qteRestante!=0}" style="#{trf.familleStyle}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.optionAchats.nbDecQte}"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:panel>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="printReliquat" width="650" height="350" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelPrintReliquat}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelPrintReliquat}" var="prl">
            <f:facet name="header"><h:outputText value="Impression des reliquats"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.fermerPrintReliquat}" image="/images/close.gif" styleClass="hidelink" reRender="printReliquat"/>
                </a4j:form>
            </f:facet>
            <a4j:form target="_blank">
                <rich:hotKey key="return" handler="return false;"/>
                <center>
                    <h:outputText value="Choisissez un modèle et un format d'Impression"  style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid  width="100%">
                    <h:panelGrid id="panchoixdoc" width="100%" style="border:solid 0px green;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.nomModeleDocument}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.lesDocumentsReliquatItem}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 0px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes du serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                                    <h:selectOneMenu id="impSelect1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelPaye" width="800" height="350" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelPaye}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelPaye}" var="pay">
            <f:facet name="header"><h:outputText value="Bon d'encaissement du document"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.annulePaye}" image="/images/close.gif" styleClass="hidelink" reRender="panelPaye"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid id="firstgridd"  width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Date:"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_date_trf}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateVte==0}"/></h:column>
                    <h:column><h:outputText value="N°:"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdNum}" readonly="true"/></h:column>
                    <h:column><h:outputText value="Série:"/></h:column>
                    <h:column>
                        <h:panelGroup>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdSerie}" size="2" readonly="true"/>
                            <h:outputText value="Devise:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDevise}" size="3" readonly="true"/>
                        </h:panelGroup>
                    </h:column>
                    <h:column><h:outputText value="Client:"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdNomTiers}" readonly="true"/></h:column>
                    <h:column><h:outputText value="Responsable:"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdNomResponsable}" readonly="true"/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column> <h:outputText value="Mode de règlement:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTypeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_verouxModReg}">
                            <f:selectItem itemLabel="Paiement total" itemValue="0"/>
                            <f:selectItem itemLabel="Paiement partiel" itemValue="4"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.chargerModReg}" reRender="firstgridd,colMontInput"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Caisse:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="bnqajt" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_inputCaisse}">
                            <f:selectItem  itemValue="0" itemLabel="Sélectionnez une caisse"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.mesCaissesSeriesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.choixCaisseXReglementBencaissement}" reRender="firstgridd,idBnq1,idBnq2,idChq1,idChq2,idChq3,idChq4"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:outputText value="Montant du bon:"/>
                    <h:column id="colMontInput">
                        <h:inputText style="width:100%;text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.montantElmTotBonEnc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_affichMontant}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelPaye" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.verifBonEncaissement}"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Net à payer:"/></h:column>
                    <h:column>
                        <h:inputText style="width:100%;text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_netAPayer}" disabled="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Type règlement:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idTypeRegBe" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_type_reg}" style="width:100%;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.mesTypeReglementsCaisse}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.choixTypeReglementBencaissement}" reRender="firstgridd,idBnq1,idBnq2,idChq1,idChq2,idChq3,idChq4"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText id="idBnq1" value="Banque destination:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_affiche_banque&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_affiche_banque_destination}"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idBnq2" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_banque_destination}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_affiche_banque&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_affiche_banque_destination}">
                            <f:selectItem itemLabel="Inconnue" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.mesBanquesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column id="idChq1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_affiche_banque}"><h:outputText value="Banque du tireur:"/></h:column>
                    <h:column id="idChq2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_affiche_banque}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_banque_tireur}" maxlength="50" style="text-transform:uppercase"/></h:column>
                    <h:column id="idChq3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_affiche_banque}"><h:outputText value="N° chèque ou bordereau:"/></h:column>
                    <h:column id="idChq4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_affiche_banque}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_num_cheque}" maxlength="50"/></h:column>
                </h:panelGrid>
                <h:panelGroup id="ppgrp">
                    <center>
                        <br><br>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.miseajourPaye}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_affiche_valide}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPaye,panelBouton,modMessageCommun"/>
                        <br>
                        <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_affiche_valide}" style="margin-left:50px;">
                            <h:graphicImage url="../images/Warning.png"  style="width:25px;height;"/>
                            <h:outputText value="Le montant du bon est supérieur au solde du document" style="color:red;" />
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelPayeXDoc" width="1100" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelReglement}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelReglement}" var="pay">
            <f:facet name="header"><h:outputText value="Règlement direct de plusieurs documents"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.fermerXReglement}" image="/images/close.gif" styleClass="hidelink" reRender="panelPayeXDoc"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formPayeXDoc">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid id="panelGlobal" width="100%">
                    <h:panelGrid id="firstgridd"  width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Date:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_date_trf}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateVte==0}"/></h:column>
                        <h:column><h:outputText value="Caisse exécutrice:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="bnqajt" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_inputCaisse}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.mesCaissesSeriesItems}" />
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.choixCaisseXReglement}" reRender="panelGlobal"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Type règlement:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_type_reg}" style="width:100%;">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.mesTypeReglementsCaisse}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.choixTypeReglement}" reRender="firstgridd,panelGlobal,bnqajt,idEncais2,idImp1,idImp2,table,idBnq1,idBnq2,idEcart3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText id="idImp1" value="Impression: (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.nomRepMod})" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idImp2" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_modele_trf}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.mesModesleRecus}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText id="idBnq1" value="Banque destination:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_affiche_banque&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_affiche_banque_destination}"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idBnq2" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_banque_destination}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_affiche_banque&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_affiche_banque_destination}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.mesBanquesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:outputText value=""/>
                        <h:outputText value=""/>
                        <h:column> <h:outputText value="Mode de règlement:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTypeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_verouxModReg}">
                                <f:selectItem itemLabel="Paiement total" itemValue="0"/>
                                <f:selectItem itemLabel="Paiement partiel" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.chargerModReg}" reRender="firstgridd"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:outputText value=""/>
                        <h:outputText value=""/>
                        <h:outputText value="Montant règlement:"/>
                        <h:column>
                            <h:inputText style="width:100%;text-align:center;font-weight:bold;font-size:50px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.montantElmTotBonEnc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_affichMontant}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.verifValide}" reRender="panelGlobal,ppgrp,idEcart0,idEcart1,idEcart2,idEcart3"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Net à payer:"/></h:column>
                        <h:column>
                            <h:inputText id="idNetPayer" style="width:100%;text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_netAPayer}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Observations:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_objet}" maxlength="50" style="width:50%;"/>&nbsp;&nbsp;
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.repartitionManuelle}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.datamodelTransfert.rowCount>=2}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.controleEcartRepartitionManuelle}" reRender="ppgrp,table,firstgridd,idEcart1,idEcart2"/>
                            </h:selectBooleanCheckbox>&nbsp;
                            <h:outputText value="Répartition manuelle"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.datamodelTransfert.rowCount>=2}"/>
                        </h:column>
                        <h:column><h:outputText value="Ecart:"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.repartitionManuelle}">
                            <h:inputText id="idEcart0" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_ecart_reglement}" readonly="true" style="width:100%;text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.repartitionManuelle}">
                            <h:inputText id="idEcart1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_ecart_reglement}" readonly="true" style="width:45%;text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;&nbsp;
                            <h:inputText id="idEcart2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.ecartManuel}" readonly="true" style="width:45%;text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid id="idEncais2" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_affiche_banque}">
                        <h:column><h:outputText value="Banque du tireur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_banque_tireur}" maxlength="50" style="text-transform:uppercase"/></h:column>
                        <h:column><h:outputText value="N° chèque ou bordereau:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_num_cheque}" maxlength="50"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid id="idEcart3" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.varTypeReg==0}">
                        <h:column><h:outputText value="Montant timbre:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.val_timbre}" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Total dû (réglement + timbre)"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.totalPayerTimbre}" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" enableContextMenu="false" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.datamodelTransfert}" var="var">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calulNetPayer}" reRender="idNetPayer,panelGalobal"/>
                            <rich:column label="N° facture" sortable="false">
                                <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                <h:outputText value="#{var.cmdNum}"/>
                            </rich:column>
                            <rich:column label="Date facture" sortable="false" width="70px">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{var.cmdDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Série" sortable="false" style="text-align:center;" width="40px">
                                <f:facet name="header"><h:outputText  value="S." /></f:facet>
                                <h:outputText value="#{var.cmdSerie}"/>
                            </rich:column>
                            <rich:column label="Catégorie client" sortable="false" width="70px">
                                <f:facet name="header"><h:outputText  value="Cat." /></f:facet>
                                <h:outputText value="#{var.cmdCat}"/>
                            </rich:column>
                            <rich:column label="Montant T.T.C." sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                <h:outputText  value="#{var.varTotTtcGlob}" rendered="#{var.varTotTtcGlob!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant Timbre" sortable="false" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.varTypeReg==0}">
                                <f:facet name="header"><h:outputText  value="Timbre"/></f:facet>
                                <h:outputText  value="#{var.var_fac_timbre}" rendered="#{var.var_fac_timbre!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Règlements" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Régl."  /></f:facet>
                                <h:outputText  value="#{var.cmdTotReglement}" rendered="#{var.cmdTotReglement!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Solde" sortable="false" style="text-align:right;color:red">
                                <f:facet name="header"> <h:outputText value="Solde"  /></f:facet>
                                <h:outputText  value="#{var.var_reliquat}" rendered="#{var.var_reliquat!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Répartition manuelle" sortable="false" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.repartitionManuelle}">
                                <f:facet name="header"> <h:outputText value="Règlement"/></f:facet>
                                <h:inputText  value="#{var.montantReglementManuel}" style="text-align:right;width:90%;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.controleEcartRepartitionManuelle}" reRender="ppgrp,idEcart1,idEcart2"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Tiers" sortable="false" width="200px">
                                <f:facet name="header"><h:outputText value="Tiers"  /></f:facet>
                                <h:outputText  value="#{var.var_nom_tiers}"/>
                            </rich:column>
                            <rich:column label="Objet de la facture" sortable="false" width="200px">
                                <f:facet name="header"><h:outputText value="Objet"  /></f:facet>
                                <h:outputText  value="#{var.cmdObject}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                        <h:panelGroup id="ppgrp">
                            <center>
                                <br><br>
                                <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.validerXreglement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_affiche_valide}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                                <br>
                                <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_affiche_valide}" style="margin-left:50px;">
                                    <h:graphicImage url="/images/Warning.png"  style="width:25px;height;"/>
                                    <h:outputText value="Le montant du bon est supérieur au solde du document" style="color:red;" />
                                </h:panelGroup>
                            </center>
                        </h:panelGroup>
                    </a4j:region>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelImpRecu" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="200" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelPrintRecu}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelPrintRecu}" var="prtrec">
            <f:facet name="header"><h:outputText value="Impression du reçu d'encaissement"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.fermerImpressionRecu}" image="/images/close.gif" styleClass="hidelink" reRender="panelImpRecu"/>
                </a4j:form>
            </f:facet>
            <a4j:form target="_blank">
                <rich:hotKey key="return" handler="return false;"/>
                <center>
                    <h:outputText value="Choisissez un format d'Impression" style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid  width="100%">
                    <h:panelGrid  width="100%" style="border:solid 0px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes du serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                                    <h:selectOneMenu id="impSelect1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.imprimerRecuJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.imprimerRecuPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.imprimerRecuODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.imprimerRecuXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.imprimerRecuDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.imprimerRecuHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.imprimerRecuXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelHistoReglement" width="1000" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelHistoReglement}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelHistoReglement}" var="his">
            <f:facet name="header"><h:outputText value="Historique des règlements"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.fermerHistoReglement}" image="/images/close.gif" styleClass="hidelink" reRender="panelHistoReglement"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  style="width:100%;">
                    <jsp:include flush="true" page="/achats/CommandeCommun.jsp"/>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable height="350px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.datamodelRecu}"  var="recu"  sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeReglementDocument.jsp"/>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelSuiviCmd" width="1000" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelSuiviCmd}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelSuiviCmd}" var="svc">
            <f:facet name="header"><h:outputText value="Suivi commande"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.fermerSuivi}" image="/images/close.gif" styleClass="hidelink" reRender="panelSuiviCmd"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel style="width:100%;">
                    <jsp:include flush="true" page="CommandeCommun.jsp"/>

                    <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                        <rich:tab id="tabPrepa" label="Préparation">
                            <h:panelGrid columns="4" columnClasses="clos20,clos30g,clos20,clos30g" width="100%" styleClass="fichefournisseur">
                                <h:column><h:outputText value="Méthode importation:"/></h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdMode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                    <f:selectItem itemLabel="Sans" itemValue="100"/>
                                    <f:selectItem itemLabel="Maritime" itemValue="0"/>
                                    <f:selectItem itemLabel="Aérien" itemValue="1"/>
                                    <f:selectItem itemLabel="Express" itemValue="2"/>
                                    <f:selectItem itemLabel="Route" itemValue="3"/>
                                </h:selectOneMenu>
                                <h:column><h:outputText value="Incoterm:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdIncoterm}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                        <f:selectItem  itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesIncotermesItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Type contener:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTypeContener}" style="width:95%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="100"/></h:column>
                                <h:column><h:outputText value="Nb contener:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdNbContener}" style="width:95%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="100"/></h:column>
                                <h:column><h:outputText value="Date demande FDI/DPI:"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateFdi}"  inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"></rich:calendar></h:column>
                                <h:column><h:outputText value="FDI demandé à:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdNomTiersFdi}" style="width:95%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="100"/></h:column>
                                <h:column><h:outputText value="Date remise FDI/DPI:"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdEnvoiFdi}"  inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"></rich:calendar></h:column>
                                <h:column><h:outputText value="Date réception doc. ori:"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateDocOriginaux}"  inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"></rich:calendar></h:column>
                                <h:column><h:outputText value="Date demande assurance:"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateAssurance}"  inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"></rich:calendar></h:column>
                                <h:column><h:outputText value="Date FRCV:"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateRfcv}"  inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"></rich:calendar></h:column>
                                <h:column><h:outputText value="Date doc. transitaire:"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateDocTransit}"  inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"></rich:calendar></h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabPaiement" label="Paiement">
                            <h:panelGrid  columns="4" columnClasses="clos20,clos30g,clos20,clos30g" width="100%" styleClass="fichefournisseur">
                                <h:column><h:outputText value="Total commande:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotTtc}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.var_format_devise==0}" disabled="true" readonly="true">
                                        <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotTtc}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.var_format_devise==1}" disabled="true" readonly="true">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTotTtc}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.var_format_devise==2}" disabled="true" readonly="true">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Devise:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDevise}" disabled="true" readonly="true"/></h:column>
                                <h:column><h:outputText value="Date Paiement:"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDatePaiement}"  inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                                <h:column><h:outputText value="Moyen Paiement:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdMoyenPaiement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                                        <f:selectItem itemLabel="Sélectionnez moyen de paiement" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.lesMoyensPaiements}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Observation Paiement:"/></h:column>
                                <h:column><h:inputText maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdObsPaiement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                                <h:column><h:outputText value="Référence commande:"/></h:column>
                                <h:column><h:inputText maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdReferencefournisseur}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                                <h:column><h:outputText value="Référence facture:"/></h:column>
                                <h:column><h:inputText maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdNumFacture}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                                <h:column><h:outputText value="Tracking commande:"/></h:column>
                                <h:column><h:inputText maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdTracking}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabSuivi" label="Suivi livraison">
                            <h:panelGrid columns="4" columnClasses="clos20,clos30g,clos20,clos30g" width="100%" styleClass="fichefournisseur">
                                <h:column><h:outputText value="Date Livraison Théorique:"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateLivraison}"  inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"></rich:calendar></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="Lieu livraison:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdLieuLivraison}" style="width:95%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="100"/></h:column>
                                <h:column><h:outputText value="Info livraison:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdInfoLivraison}" style="width:95%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}" maxlength="100"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid  columns="4" columnClasses="clos20,clos30g,clos20,clos30g" width="100%" styleClass="fichefournisseur">
                                <h:column><h:outputText value="Date Départ Usine:" style="color:blue"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateDepartUsine}"  inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                                <h:column><h:outputText value="Date Arrivée Transitaire:"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateArriveeTransit}"  inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                                <h:column><h:outputText value="Date Embarquement Théorique:"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateEmbarquementTheo}"  inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                                <h:column><h:outputText value="Date Embarquement Réel:" style="color:blue"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateEmbarquementReel}"  inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                                <h:column><h:outputText value="Date Arrivée Port Théorique:"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateArriveePortTheo}"  inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                                <h:column><h:outputText value="Date Arrivée Port Réel:" style="color:blue"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateArriveePortReel}"  inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid  columns="4" columnClasses="clos20,clos30g,clos20,clos30g" width="100%" styleClass="fichefournisseur">
                                <h:column><h:outputText value="Date Livraison Réelle:" style="color:blue"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateLivreDepot}"  inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                                <h:column><h:outputText value="Date mise à jour stock:" style="color:blue"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateStock}"  inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                                <h:column><h:outputText value="Date retour caution:" style="color:blue"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateDocCaution}"  inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/></h:column>
                            </h:panelGrid>
                        </rich:tab>

                    </rich:tabPanel>

                </rich:panel>
                <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                    <center>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.valideSuivi}" reRender="panelSuiviCmd,tableSuivi"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelAction" width="800" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelAction}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelAction}" var="act">
            <f:facet name="header"><h:outputText value="Suivi commande"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.fermerAction}" image="/images/close.gif" styleClass="hidelink" reRender="panelAction"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <jsp:include flush="true" page="CommandeCommun.jsp"/>
                    <h:panelGrid columns="2" columnClasses="clos50d,clos50g" width="100%" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Prochaine action:"/></h:column>
                        <h:column>
                            <h:inputTextarea rows="10" id="idTexte" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdProchaineAction}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}"/>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.var_aff_action}">
                    <center>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.valideAction}" reRender="panelAction,tableAction"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelAnnuler" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelAnnuler}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelAnnuler}" var="ser">
            <f:facet name="header"><h:outputText value="Annulation Commande"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.annuleAnnulation}" image="/images/close.gif" styleClass="hidelink" reRender="panelAnnuler"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Date annulation:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateAnnule}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Motif annulation:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdMotifAnnule}" maxlength="50"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.miseajourAnnuler}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelGele" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelGele}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.showModalPanelGele}" var="gel">
            <f:facet name="header"><h:outputText value="Gèle une Commande"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.annulerGeler}" image="/images/close.gif" styleClass="hidelink" reRender="panelGele"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Date du gel:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdDateAnnule}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Motif du gel:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdMotifAnnule}" maxlength="50"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.miseajourGeler}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
