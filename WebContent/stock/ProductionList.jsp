<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="productionliste">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center> <h2><h:outputText value="GESTION DES PRODUCTIONS" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid id="panCtrl"  styleClass="recherche"  width="100%">
                <h:panelGrid columns="11" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_more_search}"/>
                    <h:column><h:outputText value="N°"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.inpNum}" size="5"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchats == '0'}">
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.inpService}" style="width:150px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesServicesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idProcessList" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.inpProcess}" style="width:150px;">
                            <f:selectItem itemLabel="Tous process" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.mesProcessItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchats == '0'}">
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.inpDepot}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Dépôts productions" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesDepotAchItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesEtatsItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_more_search}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesPeriodesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchats == '0'}">
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.inpActivite}" style="width:150px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_anal_activite}">
                            <f:selectItem itemLabel="Toutes Activités" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesActivitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchats == '0'}">
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.inpAtelier}" style="width:150px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesAteliersItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,table,scrollTable,pnlgrttotalLE"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="8" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_more_search}">
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchats == '0'}">
                        <h:selectOneMenu id="serie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.inpSerie}" style="width:100px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSerieUserItem}" />
                            <a4j:support eventsQueue="maQueue" reRender="test,btImputSerie,panelBouton" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibleImputSerie}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchats == '0'}">
                        <h:selectOneMenu id="parc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.inpParc}" style="width:150px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_anal_parc}">
                            <f:selectItem itemLabel="Tous Parcs" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesParcsItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_anal_dossier>=0&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchats == '0'}">
                        <h:outputText value="Dossier:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.inpDossier}" style="width:150px;"/>
                    </h:column>
                    <h:column><h:outputText value="Du"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="10" width="400px" style="height:34px">
            <a4j:commandButton title="Ajouter nouveau document" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menustock.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.ajoutDocument}"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier le document sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menustock.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.modifDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter le document sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.consultDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer le document sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menustock.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.supprimerDocument}" reRender="modAttente,table,panelBouton,intpTTCL"/>
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menustock.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
            <a4j:commandButton title="Grapher" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menustock.imp}" reRender="panelGraph,formModalGraph,container" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.initGrapheur}"/>
            <a4j:commandButton title="Changer la série" image="/images/imputer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifSerieAch==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menustock.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.accesImputSerie}" reRender="panelimpSerie" />
            <h:commandButton title="Valider le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menustock.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
            <h:commandButton title="Dé-Valider le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menustock.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <h:panelGrid columns="2" columnClasses="clos50g2,clos50g2" width="100%">
            <h:column>
                <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.pageIndex}" reRender="table" id="scrollTable" maxPages="20" align="left" for="table"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" enableContextMenu="true" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.datamodelEntete}" var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.extDTable}">
                            <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,tableLigneIntrant"/>
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visualisationLigne}" reRender="panelVisualisation,panelBouton"/>
                            <rich:column label="N° production" sortable="true" sortBy="#{var.fabNum}" sortOrder="DESCENDING">
                                <f:facet name="header"><h:outputText  value="N° PROD." /></f:facet>
                                <h:outputText value="#{var.fabNum}"/>
                            </rich:column>
                            <rich:column label="N° lot" sortable="true" sortBy="#{var.fabNumLot}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.modeReception==0}">
                                <f:facet name="header"><h:outputText  value="N° LOT" /></f:facet>
                                <h:outputText value="#{var.fabNumLot}"/>
                            </rich:column>
                            <rich:column label="Etat signature" sortable="true" sortBy="#{var.fabPosSignature}" width="70px" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.habilitation!=null}">
                                <f:facet name="header"><h:outputText  value="Sign." /></f:facet>
                                <h:outputText  value="#{var.fabPosSignature}/#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.habilitation.habNombre}" style="text-align:center;"/>
                            </rich:column>
                            <rich:column label="Numero de quart" sortable="true" sortBy="#{var.fabQuart}" style="text-align:right;"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.modeReception==0}">
                                <f:facet name="header"><h:outputText  value="Quart"  /></f:facet>
                                <h:outputText  value="#{var.fabQuart}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Date production" sortable="true" sortBy="#{var.fabDate} #{var.fabNum}" width="70px">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{var.fabDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Série" sortable="true" sortBy="#{var.fabSerie}" style="text-align:center;" width="40px">
                                <f:facet name="header"><h:outputText  value="S." /></f:facet>
                                <h:outputText value="#{var.fabSerie}"/>
                            </rich:column>
                            <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{var.libelleEta}" width="50px" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                <h:outputText value="#{var.libelleEta}"/>
                            </rich:column>
                            <rich:column label="Process" sortable="true" sortBy="#{var.fabProcess}" width="250px">
                                <f:facet name="header"><h:outputText  value="Process" /></f:facet>
                                <h:outputText value="#{var.fabProcess} #{var.fabLibClient} "/>
                            </rich:column>
                            <rich:column label="Dépôt de production" sortable="true" sortBy="#{var.fabDepot}" width="100px">
                                <f:facet name="header"><h:outputText  value="Dépôt prod." /></f:facet>
                                <h:outputText value="#{var.fabDepot}"/>
                            </rich:column>
                            <rich:column label="Quantité produite" sortable="true" sortBy="#{var.fabQte}" width="100px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Qte. prod." /></f:facet>
                                <h:outputText value="#{var.fabQte}"/>
                            </rich:column>
                            <rich:column label="Service" sortable="true" sortBy="#{var.fabService}" width="100px">
                                <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                                <h:outputText value="#{var.fabService}"/>
                            </rich:column>
                            <rich:column label="Bon de commande" sortable="true" sortBy="#{var.fabCommande}" width="100px">
                                <f:facet name="header"><h:outputText  value="B.C." /></f:facet>
                                <h:outputText value="#{var.fabCommande}"/>
                            </rich:column>
                            <rich:column label="Montant Valorisation" sortable="true" sortBy="#{var.fabTotPump}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.affichagePump}">
                                <f:facet name="header"><h:outputText  value="Valo."  /></f:facet>
                                <h:outputText  value="#{var.fabTotPump}" rendered="#{var.fabTotPump!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Activité commerciale" sortable="true" sortBy="#{var.fabActivite}">
                                <f:facet name="header"><h:outputText value="Activité"  /></f:facet>
                                <h:outputText  value="#{var.fabActivite}"/>
                            </rich:column>
                            <rich:column label="Responsable" sortable="true" sortBy="#{var.fabNomResponsable}" width="200px">
                                <f:facet name="header"><h:outputText  value="Respponsable"/></f:facet>
                                <h:outputText  value="#{var.fabNomResponsable}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </div>
            </h:column>
            <h:column>
                <rich:dataTable id="tableLigneIntrant" width="100%" border="0" headerClass="headerTab" style="border:solid 0px green;cursor:pointer;max-height:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.datamodelIntrants}" var="intrant">
                    <rich:column sortable="false" width="20%">
                        <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                        <h:outputText  value="#{intrant.fabligCode}"/>
                    </rich:column>
                    <rich:column sortable="false" width="30%">
                        <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                        <h:outputText value="#{intrant.fabligLibelle}"/>
                    </rich:column>
                    <rich:column sortable="false" width="20%">
                        <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                        <h:outputText value="#{intrant.fabligDepot}"/>
                    </rich:column>
                    <rich:column sortable="false" style="text-align:right" width="20%">
                        <f:facet name="header"><h:outputText  value="Qte. Conso."/></f:facet>
                        <h:outputText value="#{intrant.fabligQte}" rendered="#{intrant.fabligQte!=0}">
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="false" width="10%">
                        <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                        <h:outputText value="#{intrant.fabligUnite}"/>
                    </rich:column>
                </rich:dataTable>
            </h:column>
        </h:panelGrid>
        <br/>
        <h:panelGrid id="pnlgrttotal" columns="2" cellspacing="1" styleClass="recherche"  width="100%">
            <h:panelGrid id="pnlgrttotalTTC" columns="2" cellspacing="3"  cellpadding="3">
                <h:outputText id="outpTTCL" value="Total Valorisation" />
                <h:inputText id="intpTTCL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.montantPump}" style="width:100%;text-align:right;" readonly="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
            </h:panelGrid>
            <h:panelGrid id="pnlgrttotalLE" columns="1" cellspacing="3"  cellpadding="3">
                <h:outputText id="outpLIST" value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_nb_ligne})" />
                <h:outputText id="outpELMT" value="(Eléments sélectionnés)" />
            </h:panelGrid>
        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.valQteGraph}" >
                                <f:selectItem itemLabel="En valeur" itemValue="0"/>
                                <f:selectItem itemLabel="en quantité" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <f:selectItem itemLabel="par responsable" itemValue="1"/>
                                <f:selectItem itemLabel="par équipe" itemValue="3"/>
                                <f:selectItem itemLabel="par famille produit" itemValue="5"/>
                                <f:selectItem itemLabel="par produit" itemValue="6"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelimpSerie" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.showModalPanelImput}">
        <f:facet name="header"><h:outputText value="Imputation Série"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.annuleImputSerie}" image="/images/close.gif" styleClass="hidelink" reRender="panelimpSerie"/>
            </a4j:form>
        </f:facet>
        <a4j:form >
            <rich:hotKey key="return" handler="return false;"/>
            <rich:panel  style="width:100%;">
                <h:panelGrid  columns="2" style="width:100%;">
                    <h:column><h:outputText value="Série imputée:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:180px" id="serieimput"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_imput_serie}" >
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSerieUserItem}"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
            </rich:panel>
            <h:panelGroup id="ppgrp">
                <center>
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.miseajourImput}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </center>
            </h:panelGroup>
        </a4j:form>
    </rich:modalPanel>

</f:subview>
