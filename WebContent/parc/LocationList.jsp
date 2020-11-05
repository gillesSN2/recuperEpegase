<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="listeloc">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES LOCATIONS" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
                <h:panelGrid columns="10" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.var_more_search}"/>
                    <h:column><h:outputText value="N° LOCATION"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.inpNum}" size="7"/></h:column>
                    <h:outputText value="Parc:"/>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.inpParc}" size="7"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.inpSerie}" style="width:100px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.mesSerieUserItem}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.mesEtatsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.var_more_search}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.mesPeriodesItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.inpActivite}" style="width:150px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.decoupageActivite=='false'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.var_anal_activite}">
                            <f:selectItem itemLabel="Toutes Activités" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.mesActivitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.rechercherLocation}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonParc,panCtrl,tableParc,scrollTable"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="16" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.var_more_search}">
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.var_anal_activite}">
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.var_colonne1}" >
                            <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.laColonne1Items}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.var_anal_activite}">
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.var_colonne2}" >
                            <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.laColonne2Items}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.var_anal_activite}">
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.var_colonne3}" >
                            <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.laColonne3Items}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:outputText value="Commercial:" style="text-decoration:underline;"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.inpReceptionnaire}" size="10">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les commerciaux" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.rechercheResponsable}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panCtrl,panDest,panelListeResponsable,formModalListeResponsable" />
                        </h:inputText>
                    </h:column>
                    <h:column>
                        <h:outputText value="Chauffeur:" style="text-decoration:underline;"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.inpChauffeur}" size="10">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les chauffeurs" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.rechercheCommercial}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panCtrl,panDest,panelListeCommercial,formModalListeCommercial"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Du"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrProdService==0}">
                        <h:selectOneMenu id="idServiceRec" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.inpService}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Services" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.mesServicesItems}"/>
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
            <a4j:commandButton title="Ajouter une nouvelle location" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.ajouterLocation}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier la location sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.parcLocationEntete.prclocEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.modifierLocation}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter la location sélectionnée" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.consulterLocation}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer la location sélectionnée" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.parcLocationEntete.prclocEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.supprimerLocation}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" />
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.initImpression}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
            <a4j:commandButton title="Grapher" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.initGrapheur}" reRender="panelGraph,formModalGraph,container"/>
            <a4j:commandButton title="Valider le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.parcLocationEntete.prclocEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document ?')) return false" reRender="boutonParc,idEtat"/>
            <a4j:commandButton title="Dé-Valider le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.parcLocationEntete.prclocEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document ?')) return false" reRender="boutonParc,idEtat"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.pageIndex}" reRender="tableParc" id="scrollTable" maxPages="20"align="left" for="tableParc"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.var_nb_max}" border="0" enableContextMenu="true" id="tableParc" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="110%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.dataModelOrEntete}" var="parc" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.selectionLocation}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonParc"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.visualisationLigne}" reRender="idSubView,boutonParc"/>
                        <rich:column label="Immatriculation ou identification" sortable="true" width="150px" sortOrder="#{parc.parc.prcImmatriculation}">
                            <f:facet name="header"><h:outputText  value="Immat." /></f:facet>
                            <h:outputText value="#{parc.parc.prcImmatriculation}"/>
                        </rich:column>
                        <rich:column label="Date" sortable="true" sortBy="#{parc.prclocDate}" width="70px">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{parc.prclocDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="N° du bon de sortie" sortable="true" sortOrder="#{parc.prclocNum}" width="80px">
                            <f:facet name="header"><h:outputText  value="N° bon" /></f:facet>
                            <h:outputText value="#{parc.prclocNum}"/>
                        </rich:column>
                        <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{parc.prclocEtat}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{parc.libelleEta}"/>
                        </rich:column>
                        <rich:column label="Commercial" sortable="true" sortOrder="#{parc.prclocNomCommercial}" width="200px">
                            <f:facet name="header"><h:outputText  value="Receptionnaire" /></f:facet>
                            <h:outputText value="#{parc.prclocNomCommercial}"/>
                        </rich:column>
                        <rich:column label="Service" sortable="true" sortOrder="#{parc.prclocService}" width="150px">
                            <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                            <h:outputText value="#{parc.prclocService}"/>
                        </rich:column>
                        <rich:column label="Chauffeur" sortable="true" sortOrder="#{parc.prclocNomChauffeur}" width="150px">
                            <f:facet name="header"><h:outputText  value="Chauffeur" /></f:facet>
                            <h:outputText value="#{parc.prclocNomChauffeur}"/>
                        </rich:column>
                        <rich:column label="Activité" sortable="true" sortOrder="#{parc.prclocActivite}" width="150px">
                            <f:facet name="header"><h:outputText  value="Activité" /></f:facet>
                            <h:outputText value="#{parc.prclocActivite}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
        </center>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="600" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.showModalPanelPrint}">
        
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.valQteGraph}" >
                                <f:selectItem itemLabel="En valeur" itemValue="0"/>
                                <f:selectItem itemLabel="en quantité" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <f:selectItem itemLabel="par responsable" itemValue="1"/>
                                <f:selectItem itemLabel="par parc" itemValue="2"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
