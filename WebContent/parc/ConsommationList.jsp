<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="listeconsommation">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES CONSOMMATIONS" style="color:green;"/></h2></center>

        <h:panelGrid styleClass="recherche" width="100%" id="panCtrl">
            <h:panelGrid columns="9" width="100%">
                <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_more_search}"/>
                <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_more_search}"/>
                <h:column><h:outputText value="Immat.:" /></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_immat_rec}" style="width:100px"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_type_rec}">
                        <f:selectItem itemLabel="Carburant" itemValue="0"/>
                        <f:selectItem itemLabel="Lubrifiant" itemValue="1"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_nature_rec}">
                        <f:selectItem itemLabel="Toutes natures" itemValue="100"/>
                        <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.mesNatureItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu  style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_famille_rec}">
                        <f:selectItem itemLabel="Toutes familles" itemValue="100"/>
                        <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.mesFamilleItems_rec}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_origine_rec}">
                        <f:selectItem itemLabel="Toutes origines" itemValue="100"/>
                        <f:selectItem itemLabel="Interne" itemValue="0"/>
                        <f:selectItem itemLabel="Externe" itemValue="1"/>
                        <f:selectItem itemLabel="Fabriqué" itemValue="2"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_more_search}">
                        <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.mesPeriodesItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.rechercherConsommation}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,scrollTable,boutonParc,tableParc"/>
                    <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                </h:column>
            </h:panelGrid>
            <h:panelGrid id="panDest" columns="5" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_more_search}">
                <h:column><h:outputText value="Du"/></h:column>
                <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                <h:column><h:outputText value="Au"/></h:column>
                <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                <h:column>
                    <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_service_rec}">
                        <f:selectItem itemLabel="Tous Services" itemValue="100"/>
                        <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.mesServiceItems}"/>
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid  id="boutonParc" columns="9" width="350px" style="height:34px">
            <a4j:commandButton title="Ajouter un nouvelle consommation" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.ajouterConsommation}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier la consommation sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.modifierConsommation}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter la consommation sélectionnée" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.consulterConsommation}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer la consommation sélectionnée" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.supprimerConsommation}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" />
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.initImpression}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
            <a4j:commandButton title="Grapher" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.initGrapheur}" reRender="panelGraph,formModalGraph,container"/>
            <a4j:commandButton title="Valider le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.parcConsommation.prcconEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document ?')) return false" reRender="panelBouton,idEtat"/>
            <a4j:commandButton title="Dé-Valider le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.parcConsommation.prcconEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document ?')) return false" reRender="panelBouton,idEtat"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.pageIndex}" reRender="tableParc" id="scrollTable" maxPages="20"align="left" for="tableParc"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_nb_max}" border="0" enableContextMenu="true" id="tableParc" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="110%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.dataModelConsommations}" var="parc" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.selectionConsommation}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonParc"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.visualisationLigne}" reRender="idSubView,boutonParc"/>
                        <rich:column label="Immatriculation ou identification" sortable="true" width="100px" sortOrder="#{parc.parc.prcImmatriculation}">
                            <f:facet name="header"><h:outputText  value="Immat." /></f:facet>
                            <h:outputText value="#{parc.parc.prcImmatriculation}"/>
                        </rich:column>
                        <rich:column label="Date" sortable="true" sortBy="#{parc.prcconDate}" width="70px">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{parc.prcconDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="N° du bon de sortie" sortable="true" sortOrder="#{parc.prcconNum}" width="80px">
                            <f:facet name="header"><h:outputText  value="N° bon" /></f:facet>
                            <h:outputText value="#{parc.prcconNum}"/>
                        </rich:column>
                        <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{parc.prcconEtat}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{parc.libelleEta}"/>
                        </rich:column>
                        <rich:column label="Pompiste" sortable="true" sortOrder="#{parc.prcconNomPompiste}" width="200px">
                            <f:facet name="header"><h:outputText  value="Pompiste" /></f:facet>
                            <h:outputText value="#{parc.prcconNomPompiste}"/>
                        </rich:column>
                        <rich:column label="Dépôt" sortable="true" sortOrder="#{parc.prcconDepot}" width="80px">
                            <f:facet name="header"><h:outputText  value="Dépôt" /></f:facet>
                            <h:outputText value="#{parc.prcconDepot}"/>
                        </rich:column>
                        <rich:column label="Produit" sortable="true" sortOrder="#{parc.prcconCode}" width="150px">
                            <f:facet name="header"><h:outputText  value="Produit" /></f:facet>
                            <h:outputText value="#{parc.prcconCode}"/>
                        </rich:column>
                        <rich:column label="Quantité" sortable="true"  sortOrder="#{parc.prcconQte}" width="80px" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Qte" /></f:facet>
                            <h:outputText value="#{parc.prcconQte}"/>
                        </rich:column>
                        <rich:column label="Prix unitaire" sortable="true" sortOrder="#{parc.prcconPu}" width="80px" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="P.U." /></f:facet>
                            <h:outputText value="#{parc.prcconPu}"/>
                        </rich:column>
                        <rich:column label="Prix Total" sortable="true" sortOrder="#{parc.prcconTotal}" width="80px" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Total" /></f:facet>
                            <h:outputText value="#{parc.prcconTotal}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Service" sortable="true" sortOrder="#{parc.prcconService}" width="150px">
                            <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                            <h:outputText value="#{parc.prcconService}"/>
                        </rich:column>
                        <rich:column label="Demandeur" sortable="true" sortOrder="#{parc.prcconNomDemandeur}" width="150px">
                            <f:facet name="header"><h:outputText  value="Demandeur" /></f:facet>
                            <h:outputText value="#{parc.prcconNomDemandeur}"/>
                        </rich:column>
                        <rich:column label="Activité" sortable="true" sortOrder="#{parc.prcconActivite}" width="150px">
                            <f:facet name="header"><h:outputText  value="Activité" /></f:facet>
                            <h:outputText value="#{parc.prcconActivite}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
        </center>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.showModalPanelPrint}">
        <center>
            <f:facet name="header"><h:outputText value="Impression"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
                        <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImp" target="_blank">
                <center>
                    <h:outputText value="Choisissez un modèle et un format d'Impression"  style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid  width="100%">
                    <h:panelGrid  id="panchoixdoc" width="100%" style="border:solid 1px green;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneRadio id="choixDoc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_choix_modele}" >
                            <f:selectItem itemLabel="Document séléctionné" itemValue="0"/>
                            <f:selectItem itemLabel="Liste de documents" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" reRender="panchoixdoc,docSelect,listeSelect" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.listeDocImp}" />
                        </h:selectOneRadio>
                        <br>
                        <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.nomModeleDocument}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.documentImpressionItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu id="listeSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.nomModeleListe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.listeImpressionItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}"/>
                            <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="formModalImp,modAttente,panelMail"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column><h:inputText style="width:100%"  /></h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.valQteGraph}" >
                                <f:selectItem itemLabel="En valeur" itemValue="0"/>
                                <f:selectItem itemLabel="en quantité" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <f:selectItem itemLabel="par responsable" itemValue="1"/>
                                <f:selectItem itemLabel="par parc" itemValue="2"/>
                                <f:selectItem itemLabel="par famille de produit" itemValue="3"/>
                                <f:selectItem itemLabel="par produit" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
