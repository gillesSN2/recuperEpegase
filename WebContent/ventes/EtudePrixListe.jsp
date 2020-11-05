<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="vteproduitsprix">

    <a4j:form id="produitprixformvte" enctype="multipart/form-data">
        <rich:hotKey key="return" handler="return true;"/>

        <center><h2><h:outputText value="ETUDE DES PRIX DES PRODUITS (VENTE)" style="color:green;"/></h2></center>

        <h:panelGrid id="panCtrl" columns="1" styleClass="recherche" width="100%">
            <h:panelGrid columns="10"  width="100%">
                <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_more_search}"/>
                <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_more_search}"/>
                <h:column><h:outputText value="Code:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_CodFind}" style="width:60px;"/></h:column>
                <h:column><h:outputText  value="Libellé:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_LibFind}" style="width:100px;"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.var_marque_util}">
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_MarqueFind}"  style="width:130px;">
                        <f:selectItem itemLabel="Toutes Marques" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesMarquesItems}" />
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.chargeFamilleMarque}" reRender="idFamille"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu id="idPromo" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_PromoFind}"  style="width:130px;">
                        <f:selectItem itemLabel="Tous Produits" itemValue="0"/>
                        <f:selectItem itemLabel="Produits en promotion" itemValue="1"/>
                        <f:selectItem itemLabel="Produits avec tarif spécial client" itemValue="2"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu id="idFamille" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_FamilleFind}"  style="width:130px;">
                        <f:selectItem itemLabel="Toutes Familles" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.mesFamillesItems}" />
                        <a4j:support eventsQueue="maQeue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.calculeSousFamille}" reRender="panCtrl,idSousFamille"/>
                    </h:selectOneMenu>&nbsp;&nbsp;
                    <h:selectOneMenu id="idSousFamille" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_SousFamilleFind}"  style="width:130px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.afficheSousFamille}">
                        <f:selectItem itemLabel="Toutes Sous Familles" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.mesSousFamillesItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu id="itemNature" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_NatureFind}"  style="width:130px;">
                        <f:selectItem itemLabel="Toutes Natures" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesNaturesItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu id="itemService" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_ServiceFind}" style="width:130px;">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesServicesItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.rechercherProduit}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,btnProd,scrollTable,listeProd"/>
                    <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                </h:column>
            </h:panelGrid>
            <h:panelGrid columns="2" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_more_search}">
                <h:column>
                    <h:selectOneMenu id="itemActivite" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_ActiviteFind}" style="width:130px;">
                        <f:selectItem itemLabel="Toutes Activités" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesActivitesItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:column><h:outputText  value="Produits actifs et inactifs:"/></h:column>
                    <h:selectBooleanCheckbox id="itemEtat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_inactif}" style="width:80px;"/>
                </h:column>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid  width="100%">

            <h:panelGroup id="grpProd">
                <h:panelGrid columns="3" width="200px" id="btnProd" style="height:34px">
                    <a4j:commandButton image="/images/modifier.png" title="Modifier le tarif concurentiel" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.tarifProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.afficheButtOption&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                    <a4j:commandButton image="/images/print.png" title="Imprimer produit" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.initPrint}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.afficheButtOption&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}" />
                    <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
                </h:panelGrid>

                <center>
                    <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.pageIndex}" reRender="listeProd" id="scrollTable" maxPages="20"align="left" for="listeProd"/>
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_nb_max}" style="max-height:100%;" border="0" styleClass="bg" id="listeProd" width="130%" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.datamodelProduit}" var="leproduit" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.extDTable}">
                                <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.selectionProduitTarif}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,grpProd,btnProd"/>
                                <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.visualisationLigneTarif}" reRender="idSubView,grpProd,btnProd"/>
                                <rich:column label="Code" width="100px" sortable="true" sortBy="#{leproduit.proCode}" sortOrder="ASCENDING">
                                    <f:facet name="header" ><h:outputText value="Code" /></f:facet>
                                    <h:outputText value="#{leproduit.proCode}" />
                                </rich:column>
                                <rich:column label="Libellé Commercial" width="300px" sortable="true" sortBy="#{leproduit.proLibClient}" >
                                    <f:facet name="header" ><h:outputText value="Libellé Commercial"  /></f:facet>
                                    <h:outputText value="#{leproduit.proLibClient}"/>
                                </rich:column>
                                <rich:column label="PV 1" width="100px" sortable="true" sortBy="#{leproduit.pv1}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif1}">
                                    <f:facet name="header" ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif1}"/></f:facet>
                                    <h:outputText value="#{leproduit.pv1}" rendered="#{leproduit.pv1!=0}">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="PV 2" width="100px" sortable="true" sortBy="#{leproduit.pv2}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif2}">
                                    <f:facet name="header" ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif2}"/></f:facet>
                                    <h:outputText value="#{leproduit.pv2}" rendered="#{leproduit.pv2!=0}">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="PV 3" width="100px" sortable="true" sortBy="#{leproduit.pv3}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif3}">
                                    <f:facet name="header" ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif3}"/></f:facet>
                                    <h:outputText value="#{leproduit.pv3}" rendered="#{leproduit.pv3!=0}">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="PV 4" width="100px" sortable="true" sortBy="#{leproduit.pv4}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif4}">
                                    <f:facet name="header" ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif4}"/></f:facet>
                                    <h:outputText value="#{leproduit.pv4}" rendered="#{leproduit.pv4!=0}">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="PV 5" width="100px" sortable="true" sortBy="#{leproduit.pv5}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif5}">
                                    <f:facet name="header" ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif5}"/></f:facet>
                                    <h:outputText value="#{leproduit.pv5}" rendered="#{leproduit.pv5!=0}">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="PV 6" width="100px" sortable="true" sortBy="#{leproduit.pv6}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif6}">
                                    <f:facet name="header" ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif6}"/></f:facet>
                                    <h:outputText value="#{leproduit.pv6}" rendered="#{leproduit.pv6!=0}">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="PV 7" width="100px" sortable="true" sortBy="#{leproduit.pv7}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif7}">
                                    <f:facet name="header" ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif7}"/></f:facet>
                                    <h:outputText value="#{leproduit.pv7}" rendered="#{leproduit.pv7!=0}">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="PV 8" width="100px" sortable="true" sortBy="#{leproduit.pv8}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif8}">
                                    <f:facet name="header" ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif8}"/></f:facet>
                                    <h:outputText value="#{leproduit.pv8}" rendered="#{leproduit.pv8!=0}">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="PV 9" width="100px" sortable="true" sortBy="#{leproduit.pv9}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif9}">
                                    <f:facet name="header" ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif9}"/></f:facet>
                                    <h:outputText value="#{leproduit.pv9}" rendered="#{leproduit.pv9!=0}">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="PV 10" width="100px" sortable="true" sortBy="#{leproduit.pv10}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif10}">
                                    <f:facet name="header" ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif10}"/></f:facet>
                                    <h:outputText value="#{leproduit.pv10}" rendered="#{leproduit.pv10!=0}">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Prix du marché" width="100px" sortable="true" sortBy="#{leproduit.pv1Marche}" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText value="Marché"/></f:facet>
                                    <h:outputText value="#{leproduit.pv1Marche}" rendered="#{leproduit.pv1Marche!=0}">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </div>
                </center>
            </h:panelGroup>

        </h:panelGrid>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="600" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.showModalPanelPrint}" var="prt">
            <f:facet name="header"><h:outputText value="Impression"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
                        <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImp" target="_blank">
                <rich:hotKey key="return" handler="return false;"/>
                <center>
                    <h:outputText value="Choisissez un modèle et un format d'Impression"  style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid  width="100%">
                    <h:panelGrid  id="panchoixdoc" width="100%" style="border:solid 1px green;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneRadio id="choixDoc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_choix_modele}" >
                            <f:selectItem itemLabel="Produit séléctionné" itemValue="0"/>
                            <f:selectItem itemLabel="Liste de produits" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" reRender="panchoixdoc,docSelect,listeSelect" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.listeDocImp}" />
                        </h:selectOneRadio>
                        <br>
                        <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.nomModeleDocument}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.documentImpressionItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu id="listeSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.nomModeleListe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.listeImpressionItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="formModalImp,modAttente,panelMail"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.utilPrint.lesbalDestinatairesItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.imprimer}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
