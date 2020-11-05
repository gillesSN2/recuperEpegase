<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="listeor">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES OR (Ordres de réparation)" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
                <h:panelGrid columns="10" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_more_search}"/>
                    <h:column><h:outputText value="N° OR"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.inpNum}" size="7"/></h:column>
                    <h:outputText value="Parc:"/>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.inpParc}" size="7"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.inpSerie}" style="width:100px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.mesSerieUserItem}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.mesEtatsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_more_search}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.mesPeriodesItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.inpActivite}" style="width:150px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.decoupageActivite=='false'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_anal_activite}">
                            <f:selectItem itemLabel="Toutes Activités" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.mesActivitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.rechercherOr}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonParc,panCtrl,tableParc,scrollTable"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="16" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_more_search}">
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_anal_activite}">
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_colonne1}" >
                            <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.laColonne1Items}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_anal_activite}">
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_colonne2}" >
                            <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.laColonne2Items}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_anal_activite}">
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_colonne3}" >
                            <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.laColonne3Items}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:outputText value="Réceptionnaire:" style="text-decoration:underline;"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.inpReceptionnaire}" size="10">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les responsables" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.rechercheResponsable}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panCtrl,panDest,panelListeResponsable,formModalListeResponsable" />
                        </h:inputText>
                    </h:column>
                    <h:column>
                        <h:outputText value="Chauffeur:" style="text-decoration:underline;"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.inpChauffeur}" size="10">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les responsables" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.rechercheCommercial}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panCtrl,panDest,panelListeCommercial,formModalListeCommercial"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Du"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrProdService==0}">
                        <h:selectOneMenu id="idServiceRec" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.inpService}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Services" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.mesServicesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrProdService==1}">
                        <h:outputText value="Service:"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrService}" style="width:300px;" readonly="true" disabled="true"/>
                    </h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid  id="boutonParc" columns="9" width="350px" style="height:34px">
            <a4j:commandButton title="Ajouter un nouvel OR" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.ajouterOr}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier l'OR sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.modifierOr}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter l'OR sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.consulterOr}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer l'OR sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.supprimerOr}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" />
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
            <a4j:commandButton title="Grapher" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.initGrapheur}" reRender="panelGraph,formModalGraph,container"/>
            <a4j:commandButton title="Valider le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document ?')) return false" reRender="boutonParc,idEtat"/>
            <a4j:commandButton title="Dé-Valider le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document ?')) return false" reRender="boutonParc,idEtat"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.pageIndex}" reRender="tableParc" id="scrollTable" maxPages="20"align="left" for="tableParc"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_nb_max}" border="0" enableContextMenu="true" id="tableParc" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="110%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.dataModelOrEntete}" var="parc" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.selectionOr}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonParc"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.visualisationLigne}" reRender="idSubView,boutonParc"/>
                        <rich:column label="Immatriculation ou identification" sortable="true" width="100px" sortOrder="#{parc.parc.prcImmatriculation}">
                            <f:facet name="header"><h:outputText  value="Immat." /></f:facet>
                            <h:outputText value="#{parc.parc.prcImmatriculation}"/>
                        </rich:column>
                        <rich:column label="Date" sortable="true" sortBy="#{parc.prcoreDate}" width="70px">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{parc.prcoreDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="N° du bon de sortie" sortable="true" sortOrder="#{parc.prcoreNum}" width="80px">
                            <f:facet name="header"><h:outputText  value="N° bon" /></f:facet>
                            <h:outputText value="#{parc.prcoreNum}"/>
                        </rich:column>
                        <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{parc.prcoreEtat}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{parc.libelleEta}"/>
                        </rich:column>
                        <rich:column label="Réceptionnaire" sortable="true" sortOrder="#{parc.prcoreNomReceptionnaire}" width="200px">
                            <f:facet name="header"><h:outputText  value="Receptionnaire" /></f:facet>
                            <h:outputText value="#{parc.prcoreNomReceptionnaire}"/>
                        </rich:column>
                        <rich:column label="Service" sortable="true" sortOrder="#{parc.prcoreService}" width="150px">
                            <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                            <h:outputText value="#{parc.prcoreService}"/>
                        </rich:column>
                        <rich:column label="Chauffeur" sortable="true" sortOrder="#{parc.prcoreNomChauffeur}" width="150px">
                            <f:facet name="header"><h:outputText  value="Chauffeur" /></f:facet>
                            <h:outputText value="#{parc.prcoreNomChauffeur}"/>
                        </rich:column>
                        <rich:column label="Activité" sortable="true" sortOrder="#{parc.prcoreActivite}" width="150px">
                            <f:facet name="header"><h:outputText  value="Activité" /></f:facet>
                            <h:outputText value="#{parc.prcoreActivite}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
        </center>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="600" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.showModalPanelPrint}">
        <
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.valQteGraph}" >
                                <f:selectItem itemLabel="En valeur" itemValue="0"/>
                                <f:selectItem itemLabel="en quantité" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <f:selectItem itemLabel="par responsable" itemValue="1"/>
                                <f:selectItem itemLabel="par parc" itemValue="2"/>
                                <f:selectItem itemLabel="par famille de produit" itemValue="3"/>
                                <f:selectItem itemLabel="par produit" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
