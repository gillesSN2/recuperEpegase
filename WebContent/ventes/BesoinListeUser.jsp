<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="besoinliste">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center> <h2><h:outputText value="GESTION DES BESOINS" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
                <h:panelGrid columns="11" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_more_search}"/>
                    <h:column><h:outputText value="N°"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.inpNum}" size="7"/></h:column>
                    <h:column><h:outputText value="Client"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.inpClient}" size="10"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.inpSerie}" style="width:100px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.mesSerieUserItem}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.inpCat}" style="width:150px;">
                            <f:selectItem itemLabel="Toutes Catégories" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFamilleClientsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesEtatsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_more_search}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesPeriodesItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.inpActivite}" style="width:150px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_anal_activite}">
                            <f:selectItem itemLabel="Toutes Activités" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesActivitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,table,scrollTable,pnlgrttotal"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="9" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_more_search}">&nbsp;&nbsp;
                    <h:column>
                        <h:outputText value="Responsable:" style="text-decoration:underline;"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.inpResponsable}" size="10">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les responsables" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.rechercheResponsable}" reRender="idSubView,panCtrl,panDest,panelListeResponsable,formModalListeResponsable"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.optionsVentes.responsable=='1'}">
                        <h:outputText value="Commercial:" style="text-decoration:underline;"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.inpCommercial}" size="10">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les responsables" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.rechercheCommercial}" reRender="idSubView,panCtrl,panDest,panelListeCommercial,formModalListeCommercial"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_anal_parc}">
                        <h:outputText value="Parc:"/>&nbsp;&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.inpParc}" style="width:150px;"/>
                    </h:column>                 
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_anal_dossier}">
                        <h:outputText value="Dossier:"/>&nbsp;&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.inpDossier}" style="width:150px;"/>
                    </h:column>
                    <h:column><h:outputText value="Du"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="10" width="450px" style="height:34px">
            <a4j:commandButton title="Ajouter nouveau document" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.ajoutDocument}"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier le document sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.besoinEnteteVentes.besEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.modifDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter le document sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.consultDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer le document sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.besoinEnteteVentes.besEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.supprimerDocument}" reRender="modAttente,table,panelBouton,intpTTCL,intpRGLMTL,intpSOLDL"/>
            <a4j:commandButton title="Annuler le document sélectionné" image="/images/annuler_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.besoinEnteteVentes.besEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.sup}" onclick="if (!confirm('Etes-vous sur de vouloir annuler ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.annulerDocument}" reRender="panelAnnuler"/>
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
            <a4j:commandButton title="Changer N°/série" image="/images/imputer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifSerieVte==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.besoinEnteteVentes.besEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.accesImputSerie}" reRender="panelimpSerie" />
            <a4j:commandButton title="Dupliquer le document sélectionné" image="/images/duplicate.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.dup}" onclick="if (!confirm('Etes-vous sur de vouloir dupliquer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"   action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.duppliquerDocument}" reRender="modAttente,table,panelBouton,intpTTCL,intpRGLMTL,intpSOLDL" />
            <a4j:commandButton title="Transformer le(s) document(s) sélectionné(s)" image="/images/transferer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.visibiliteBton&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.besoinEnteteVentes.besEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.besoinEnteteVentes.besEtat==4)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.trf}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.transformerDocument}" reRender="panelTrf,formTrf,idSerieTrf"/>
            <a4j:commandButton title="Valider le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.besoinEnteteVentes.besEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document ?')) return false" reRender="panelBouton,idEtat,idTrf"/>
            <a4j:commandButton title="Dé-Valider le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.besoinEnteteVentes.besEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document ?')) return false" reRender="panelBouton,idEtat,idTrf"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.datamodelEntete}" var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.visualisationLigne}" reRender="idSubView,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                        <rich:column label="N° besoin" sortable="true" sortBy="#{var.besNum}">
                            <f:facet name="header"><h:outputText  value="N°"/></f:facet>
                            <h:outputText value="#{var.besNum}"/>
                        </rich:column>
                        <rich:column label="Date besoin" sortable="true" sortBy="#{var.besDate} #{var.besNum}" width="70px">
                            <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                            <h:outputText value="#{var.besDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Série" sortable="true" sortBy="#{var.besSerie}" style="text-align:center;" width="40px">
                            <f:facet name="header"><h:outputText  value="S."/></f:facet>
                            <h:outputText value="#{var.besSerie}"/>
                        </rich:column>
                        <rich:column label="Catégorie besoin" sortable="true" sortBy="#{var.besCat}" width="70px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Cat."/></f:facet>
                            <h:outputText value="#{var.besCat}"/>
                        </rich:column>
                        <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{var.besEtat}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                            <h:outputText value="#{var.libelleEta}"/>
                        </rich:column>
                        <rich:column id="idTrf" label="Transfert" sortable="true" sortBy="#{var.var_select_ligne}" width="50px" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.trf}">
                            <f:facet name="header"><h:outputText  value="Trf."/></f:facet>
                            <h:selectBooleanCheckbox value="#{var.var_select_ligne}" rendered="#{(var.besEtat==1||var.besEtat==4)&&var.besSerie!='X'}"/>
                        </rich:column>
                        <rich:column label="Commercial" sortable="true" sortBy="#{var.besNomCommercial}" width="200px">
                            <f:facet name="header"><h:outputText  value="Commercial"/></f:facet>
                            <h:outputText  value="#{var.besNomCommercial}"/>
                        </rich:column>
                        <rich:column label="Montant H.T." sortable="true" sortBy="#{var.besTotHt}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="H.T."/></f:facet>
                            <h:outputText  value="#{var.besTotHt}" rendered="#{var.besTotHt!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant des taxes" sortable="true" sortBy="#{var.besTotTva}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Taxes"/></f:facet>
                            <h:outputText  value="#{var.besTotTva}" rendered="#{var.besTotTva!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant T.T.C." sortable="true" sortBy="#{var.besTotTtc}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                            <h:outputText  value="#{var.besTotTtc}" rendered="#{var.besTotTtc!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Campagne" sortable="true" sortBy="#{var.besNumCampagne}" >
                            <f:facet name="header"><h:outputText value="Campagne"/></f:facet>
                            <h:outputText  value="#{var.besNumCampagne}"/>
                        </rich:column>
                        <rich:column label="Activité commerciale" sortable="true" sortBy="#{var.besActivite}" >
                            <f:facet name="header"><h:outputText value="Activité"/></f:facet>
                            <h:outputText  value="#{var.besActivite}"/>
                        </rich:column>
                        <rich:column label="Parc" sortable="true" sortBy="#{var.besAnal2}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_anal_parc}">
                            <f:facet name="header"><h:outputText value="Parc"/></f:facet>
                            <h:outputText  value="#{var.besAnal2}"/>
                        </rich:column>
                        <rich:column label="Objet du besoin" sortable="true" sortBy="#{var.besObject}" width="200px">
                            <f:facet name="header"><h:outputText value="Objet"/></f:facet>
                            <h:outputText  value="#{var.besObject}"/>
                        </rich:column>
                        <rich:column label="Echéance" sortable="true" sortBy="#{var.besDateEcheReg}" width="70px" >
                            <f:facet name="header"><h:outputText value="Eché."/></f:facet>
                            <h:outputText  value="#{var.besDateEcheReg}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Responsable" sortable="true" sortBy="#{var.besNomResponsable}" width="200px">
                            <f:facet name="header"><h:outputText  value="Respponsable"  /></f:facet>
                            <h:outputText  value="#{var.besNomResponsable}"/>
                        </rich:column>
                        <rich:column label="Commercial" sortable="true" sortBy="#{var.besNomCommercial}" width="200px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.optionsVentes.responsable=='1'}">
                            <f:facet name="header"><h:outputText  value="Commercial"  /></f:facet>
                            <h:outputText  value="#{var.besNomCommercial}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
            <br/>
            <h:panelGrid id="pnlgrttotal" columns="4" cellspacing="1" styleClass="recherche"  width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrVteTotaux==0}">
                <h:panelGrid id="pnlgrttotalTTC" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpTTCL" value="Total TTC" />
                    <h:inputText id="intpTTCL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.montantTtc}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpTTCE" value="Total TTC" />
                    <h:inputText id="intpTTCE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.montantTtcElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalRGLMT" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpRGLMTL" value="Total Réglements" />
                    <h:inputText id="intpRGLMTL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.montantReglement}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpRGLMTE" value="Total Réglements" />
                    <h:inputText id="intpRGLMTE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.montantReglementElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalSOLD" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpSOLDL" value="Solde" />
                    <h:inputText id="intpSOLDL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.montantSolde}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpSOLDE" value="Solde" />
                    <h:inputText id="intpSOLDE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.montantSoldeElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalLE" columns="1" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpLIST" value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_nb_ligne})" />
                    <h:outputText id="outpELMT" value="(Eléments sélectionnés)" />
                </h:panelGrid>
            </h:panelGrid>
        </center>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelimpSerie" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.showModalPanelImput}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.showModalPanelImput}" var="ser">
            <f:facet name="header"><h:outputText value="Imputation N°/Série"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.annuleImputSerie}" image="/images/close.gif" styleClass="hidelink" reRender="panelimpSerie"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Série imputée:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="serieimput"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_imput_serie}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.mesSerieUserItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="catimput" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_imput_cat}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFamilleClientsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.miseajourImput}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelTrf" width="1150" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.showModalPanelTrf}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.showModalPanelTrf}" var="trf">
            <f:facet name="header"><h:outputText value="Transformation besoin en ..."></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.annuleTrf}" image="/images/close.gif" styleClass="hidelink" reRender="panelTrf"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formTrf">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;" id="panGlobal">
                    <h:column>
                        <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_type_trf}" id="idSerieTrf">
                            <f:selectItem itemLabel="*** Sélectionnez type"  itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.documentTrfItems}" />
                            <a4j:support eventsQueue="maQueue" reRender="panGlobal,panelTrf,serieSel,modeleSel,valtrf,trf2,trf3,trf4,trf5,trf6" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.serieSelectTrf}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:panelGrid  columns="7" style="width:100%;background-color:#DAEECB;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_aff_trf}">
                        <h:column><h:outputText id="trf2" value="Date:" /></h:column>
                        <h:column>
                            <rich:calendar id="trf3" inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_date_trf}"  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;">
                            </rich:calendar>&nbsp;&nbsp;
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_heure}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                            </h:selectOneMenu>
                            <h:column><h:outputText value=":"/></h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_minute}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="trf4" style="width:230px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_mode_trf}">
                                <f:selectItem itemLabel="1 document => 1 document"  itemValue="0"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="serieSel" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_serie_trf}" style="width:80px;">
                                <f:selectItem itemLabel="Série Défaut" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.mesSeriesTrfItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="modeleSel" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_modele_trf}" style="width:120px;">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.modeleTrfItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><a4j:commandButton id="trf5" value="Reste=Reliquat" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.qteTrfQteOrg}" reRender="tabletrf,modAttente" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"/></h:column>
                        <h:column><a4j:commandButton id="trf6" value="Raz Qte Reste" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.razQteTrf}" reRender="tabletrf"/></h:column>
                    </h:panelGrid>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_aff_trf}"><h:outputText value="(Si la date est vide, alors le document généré prendra la date du document d'origine, si non, le document généré prendra la date spécifiée.)" style="color:red"/></h:column>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tabletrf" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.datamodelTransfert}" var="trf">
                            <rich:column label="N° besoin" sortable="false" sortBy="#{trf.besoinEnteteVentes.besNum}" sortOrder="ASCENDING" width="10%">
                                <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                <h:outputText value="#{trf.besoinEnteteVentes.besNum}"/>
                            </rich:column>
                            <rich:column label="Date" sortable="false" width="5%">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{trf.besoinEnteteVentes.besDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Série" sortable="false" style="text-align:center;" width="5%">
                                <f:facet name="header"><h:outputText  value="S." /></f:facet>
                                <h:outputText value="#{trf.besoinEnteteVentes.besSerie}"/>
                            </rich:column>
                            <rich:column label="Client" sortable="false" width="14%">
                                <f:facet name="header"><h:outputText  value="Client"  /></f:facet>
                                <h:outputText  value="#{trf.besoinEnteteVentes.besNomTiers}"/>
                            </rich:column>
                            <rich:column label="Produit" sortable="false" width="26%">
                                <f:facet name="header"><h:outputText  value="Produit"  /></f:facet>
                                <h:outputText  value="#{trf.besligCode}"/>
                                <h:outputText  value=" - "/>
                                <h:outputText  value="#{trf.besligLibelle}"/>
                            </rich:column>
                            <rich:column label="Dépôt" sortable="false" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_type_trf==22||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_type_trf==23}">
                                <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                <h:selectOneMenu id="iddepoligne" value="#{trf.var_depotLigne}" style="width:120px;">
                                    <f:selectItems value="#{trf.var_listDepotItem}" />
                                </h:selectOneMenu>
                            </rich:column>
                            <rich:column label="Quantité origine" sortable="false" style="text-align:right" width="10%">
                                <f:facet name="header"><h:outputText  value="Qte.Origine" /></f:facet>
                                <h:outputText  value="#{trf.besligQte}"/>
                            </rich:column>
                            <rich:column label="Quantité déjà transférée" sortable="false" style="text-align:right" width="10%">
                                <f:facet name="header"><h:outputText  value="Qte.trf." /></f:facet>
                                <h:outputText  value="#{trf.var_qteDejaTrf}"/>
                            </rich:column>
                            <rich:column label="Quantité restante" sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Qte.Reste" /></f:facet>
                                <h:inputText  value="#{trf.var_qteReliquat}" style="text-align:right;width:90%"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:panel>
                <h:panelGroup>
                    <br>
                    <center>
                        <h:commandButton id="valtrf" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.transformerMaj}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.var_aff_trf}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelAnnuler" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.showModalPanelAnnuler}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.showModalPanelAnnuler}" var="ser">
            <f:facet name="header"><h:outputText value="Annulation Besoin"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.annuleAnnulation}" image="/images/close.gif" styleClass="hidelink" reRender="panelAnnuler"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Date annulation:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.besoinEnteteVentes.besDateAnnule}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Motif annulation:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.besoinEnteteVentes.besMotifAnnule}" maxlength="50"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBesoinVentes.miseajourAnnuler}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
