<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="reacheminementliste">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center> <h2><h:outputText value="GESTION DES REACHEMINEMENTS" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid id="panCtrl"  styleClass="recherche"  width="100%">
                <h:panelGrid columns="11" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_more_search}"/>
                    <h:column><h:outputText value="N°"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.inpNum}" size="5"/></h:column>
                    <h:column><h:outputText value="Transporteur"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.inpFournisseur}" size="10"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.inpSerie}" style="width:100px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSerieUserItem}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idFamille" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.inpCat}" style="width:150px;">
                            <f:selectItem itemLabel="Toutes Catégories" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesFamilleFournisseursItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesEtatsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idPeriode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_more_search}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesPeriodesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,table,scrollTable,pnlgrttotal"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="11" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_more_search}">
                    <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/><br>
                        <h:inputText id="idResponsableRec" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.inpResponsable}" size="10">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les responsables" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.rechercheResponsable}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panCtrl,panDest,panelListeResponsable,formModalListeResponsable" />
                        </h:inputText>
                    </h:column>
                    <h:column>
                        <h:outputText value="Annonce:"/><br>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.inpAnnonce}" style="width:150px;"/>
                    </h:column>
                    <h:column>
                        <h:outputText value="Dossier:"/><br>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.inpDossier}" style="width:150px;"/>
                    </h:column>
                    <h:column><h:outputText value="Du"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <a4j:commandButton title="Recherche sur transporteur sélectionné" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.inpNomTiersEnCours}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.executerRequeteTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,table,scrollTable,pnlgrttotal"/>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="11" width="400px" style="height:34px">
            <a4j:commandButton title="Ajouter nouveau document" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.ajoutDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier le document sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.modifDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter le document sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.consultDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer le document sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.supprimerDocument}" reRender="table,panelBouton,intpTTCL,intpRGLMTL,intpSOLDL"/>
            <a4j:commandButton title="Annuler le document sélectionné" image="/images/annuler_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.sup}" onclick="if (!confirm('Etes-vous sur de vouloir annuler ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.annulerDocument}" reRender="panelAnnuler"/>
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
            <a4j:commandButton title="Changer la série" image="/images/imputer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifSerieAch==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.accesImputSerie}" reRender="panelimpSerie" />
            <a4j:commandButton title="Transformer le(s) document(s) sélectionné(s)" image="/images/transferer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.visibiliteBton&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaEtat==4)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.trf}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.transformerDocument}" reRender="panelTrf,formTrf,idSerieTrf"/>
            <a4j:commandButton title="Valider le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panelBouton,idEtat,idTrf"/>
            <a4j:commandButton title="Dé-Valider le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panelBouton,idEtat,idTrf"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.datamodelEntete}" var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,panelBoutonSuivi,intpSOLDE,intpTTCE,intpRGLMTE"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.visualisationLigne}" reRender="idSubView,panelBouton,panCtrl,panelBoutonSuivi,intpSOLDE,intpTTCE,intpRGLMTE"/>
                        <rich:column label="N° réacheminement" sortable="true" sortBy="#{var.reaNum}">
                            <f:facet name="header"><h:outputText  value="N° REA." /></f:facet>
                            <h:outputText value="#{var.reaNum}"/>
                        </rich:column>
                        <rich:column label="Etat signature" sortable="true" sortBy="#{var.reaPosSignature}" width="70px" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.habilitation!=null}">
                            <f:facet name="header"><h:outputText  value="Sign." /></f:facet>
                            <h:outputText  value="#{var.reaPosSignature}/#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.habilitation.habNombre}" style="text-align:center;"/>
                        </rich:column>
                        <rich:column label="N° annonce" sortable="true" sortBy="#{var.reaNumAnnonce}">
                            <f:facet name="header"><h:outputText  value="N° ANN." /></f:facet>
                            <h:outputText value="#{var.reaNumAnnonce}"/>
                        </rich:column>
                        <rich:column label="N° dossier" sortable="true" sortBy="#{var.reaAnal4}">
                            <f:facet name="header"><h:outputText  value="N° DOS." /></f:facet>
                            <h:outputText value="#{var.reaAnal4}"/>
                        </rich:column>
                        <rich:column label="N° Facture" sortable="true" sortBy="#{var.recNumFature}">
                            <f:facet name="header"><h:outputText  value="N° Fac." /></f:facet>
                            <h:outputText value="#{var.reaNumFature}"/>
                        </rich:column>
                        <rich:column label="Date Annonce" sortable="true" sortBy="#{var.reaDate} #{var.reaNum}" width="70px">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.reaDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column id="idEtat"  label="Etat" sortable="true" sortBy="#{var.reaEtat}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{var.libelleEta}"/>
                        </rich:column>
                        <rich:column label="Fournisseur" sortable="true" sortBy="#{var.var_nom_tiers}" width="200px">
                            <f:facet name="header"><h:outputText  value="Transporteur"  /></f:facet>
                            <h:outputText  value="#{var.var_nom_tiers}"/>
                        </rich:column>
                        <rich:column label="Type marchandise" sortable="true" sortBy="#{var.libelleTypeMarchandise}" width="80px">
                            <f:facet name="header"><h:outputText  value="Type" /></f:facet>
                            <h:outputText value="#{var.libelleTypeMarchandise}"/>
                        </rich:column>
                        <rich:column label="Poids total brut" sortable="true" sortBy="#{var.reaTotPoidsBrut}" style="text-align:right;" width="80px">
                            <f:facet name="header"><h:outputText  value="Poids brut" /></f:facet>
                            <h:outputText value="#{var.reaTotPoidsBrut}" rendered="#{var.reaTotPoidsBrut!=0}"/>
                        </rich:column>
                        <rich:column label="Nb sac" sortable="true" sortBy="#{var.reaTotNbSac}" style="text-align:right;" width="80px">
                            <f:facet name="header"><h:outputText  value="Sac" /></f:facet>
                            <h:outputText value="#{var.reaTotNbSac}" rendered="#{var.reaTotNbSac!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Poids total net" sortable="true" sortBy="#{var.reaTotPoidsNet}" style="text-align:right;" width="80px">
                            <f:facet name="header"><h:outputText  value="Poids net" /></f:facet>
                            <h:outputText value="#{var.reaTotPoidsNet}" rendered="#{var.reaTotPoidsNet!=0}"/>
                        </rich:column>
                        <rich:column label="Navire" sortable="true" sortBy="#{var.reaNomBateau}" width="200px">
                            <f:facet name="header"><h:outputText value="Navire"/></f:facet>
                            <h:outputText  value="#{var.reaNomBateau}"/>
                        </rich:column>
                        <rich:column label="Responsable" sortable="true" sortBy="#{var.reaNomResponsable}" width="200px">
                            <f:facet name="header"><h:outputText  value="Respponsable"  /></f:facet>
                            <h:outputText  value="#{var.reaNomResponsable}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
            <br/>
            <h:panelGrid id="pnlgrttotal" columns="4" columnClasses="clos15,clos35,clos15,clos35" cellspacing="1" styleClass="recherche"  width="100%">
                <h:outputText id="outpTTCL" value="Total Brut" />
                <h:inputText id="intpTTCL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.totauxBrutGlobal}" style="text-align:right;" readonly="true">
                </h:inputText>
                <h:outputText id="outpTTCE" value="Total Net" />
                <h:inputText id="intpTTCE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.totauxNetGlobal}" style="text-align:right;" readonly="true">
                </h:inputText>
            </h:panelGrid>
        </center>

    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.valQteGraph}" >
                                <f:selectItem itemLabel="En valeur" itemValue="0"/>
                                <f:selectItem itemLabel="en quantité" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <f:selectItem itemLabel="par responsable" itemValue="1"/>
                                <f:selectItem itemLabel="par société" itemValue="4"/>
                                <f:selectItem itemLabel="par famille produit" itemValue="5"/>
                                <f:selectItem itemLabel="par produit" itemValue="6"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelimpSerie" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.showModalPanelImput}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.showModalPanelImput}" var="imp">
            <f:facet name="header"><h:outputText value="Imputation Série"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.annuleImputSerie}" image="/images/close.gif" styleClass="hidelink" reRender="panelimpSerie"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Série imputée:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="serieimput"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_imput_serie}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSerieUserItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="catimput" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.var_imput_cat}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesFamilleFournisseursItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.miseajourImput}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelAnnuler" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.showModalPanelAnnuler}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.showModalPanelAnnuler}" var="ser">
            <f:facet name="header"><h:outputText value="Annulation Réception"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.annuleAnnulation}" image="/images/close.gif" styleClass="hidelink" reRender="panelAnnuler"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Date annulation:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaDateAnnule}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Motif annulation:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.reacheminementEnteteAchats.reaMotifAnnule}" maxlength="50"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReacheminementAchats.miseajourAnnuler}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
