<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="mvtsproduits">

    <a4j:form id="produitformvte" enctype="multipart/form-data">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText value="MOUVEMENTS DES PRODUITS (VENTE)" style="color:green;"/></h2></center>

        <h:panelGrid  id="idlienMvt" width="100%">
            <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proCode} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proLibClient}"></h:outputText></f:facet>
            <h:panelGrid columns="4" id="recMvt" styleClass="recherche" width="100%">
                <h:panelGroup>
                    <h:panelGrid columns="1" style="width:150px;height:150px;border:1px solid green;" title="Période">
                        <h:outputText value="Date début:"/><rich:calendar inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_date_debut}"   enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"/>
                        <h:outputText value="Date de fin:"/><rich:calendar inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_date_fin}"   enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"/>
                    </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup>
                    <h:panelGrid columns="1" style="width:150px;height:150px;border:1px solid green;" title="Filtre">
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_depot}"  style="width:140px;">
                            <f:selectItem itemLabel="Tous Dépôts" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesDepotItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_activites}"  style="width:140px;">
                            <f:selectItem itemLabel="Toutes Actvités" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesActivitesItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_services}"  style="width:140px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesServicesItems}"/>
                        </h:selectOneMenu>
                        <h:column>
                            <a4j:commandButton image="/images/rechercher.png" title="Rechercher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.chargerMouvements}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,resultatMvt,idTotal"/>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton image="/images/print.png" title="Imprimer produit" reRender="panelImp,formModalImp,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.initPrintMvts}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.afficheButtSup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}" />&nbsp;&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton image="/images/grapheur.png" title="Grapher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.initGrapheur}" reRender="panelGraph,formModalGraph,container"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.afficheButtSup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}" />
                        </h:column>
                    </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup>
                    <h:panelGrid style="width:150px;height:150px;border:1px solid green;" title="Ventes" id="selVte">
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_mvt_ss_cdevis}"/><h:outputText value="Devis"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_mvt_ss_ccmd}"/><h:outputText value="Commandes"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_mvt_as_cbl}" style="color:red"/><h:outputText value="Livraisons" style="color:red"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_mvt_as_cchg}" style="color:red"/><h:outputText value="Chargements" style="color:red"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_mvt_as_cretour}" style="color:red"/><h:outputText value="Retours" style="color:red"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_mvt_as_ticket}" style="color:red"/><h:outputText value="Tickets" style="color:red"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_mvt_ss_cfacture}"/><h:outputText value="Factures"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_mvt_ss_cavoir}"/><h:outputText value="Avoirs"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_mvt_ss_cnoteDebit}"/><h:outputText value="Notes Débit"/></h:column>
                    </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup>
                    <h:panelGrid columns="1" style="width:150px;height:150px;border:1px solid green;" title="Sélection">
                        <a4j:commandButton style="width:140px" value="Sél. Stock" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.selStock}" reRender="selVte"/>
                        <a4j:commandButton style="width:140px" value="Sél. Tout" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.selTout}" reRender="selVte"/>
                        <a4j:commandButton style="width:140px" value="Sél. Rien" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.selRien}" reRender="selVte"/>
                        <a4j:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.annuleSaisie}" reRender="idSubView"/>
                    </h:panelGrid>
                </h:panelGroup>
            </h:panelGrid>
            <Br>
            <h:panelGrid  width="100%" id="resultatMvt">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" reRender="mvts" id="scrollTable" maxPages="20"align="left" for="mvts"/>
                    <rich:extendedDataTable styleClass="bg" style="max-height:100%,border:solid 0px green;" height="500px" width="100%" border="0" footerClass="bard" activeClass="active-row" noDataLabel=" " id="mvts" headerClass="headerTab" sortMode="multi" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.datamodelMvt}" var="mvt">
                        <rich:column  width="5%" sortable="true" sortBy="#{mvt.stk_type}" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText value="Type"/></f:facet>
                            <h:outputText value="#{mvt.stk_lib_type}" />
                        </rich:column>
                        <rich:column  width="5%" sortable="true" sortBy="#{mvt.stk_etat}">
                            <f:facet name="header">
                                <h:outputText value="Etat"/>
                            </f:facet>
                            <h:outputText value="#{mvt.stk_etat}" />
                        </rich:column>
                        <rich:column  width="10%" sortable="true" sortBy="#{mvt.stk_code_depot}" >
                            <f:facet name="header" ><h:outputText value="Dépôt" /></f:facet>
                            <h:outputText value="#{mvt.stk_code_depot}" />
                        </rich:column>
                        <rich:column  width="10%" sortable="true" sortBy="#{mvt.stk_activite}" >
                            <f:facet name="header" ><h:outputText value="Activité" /></f:facet>
                            <h:outputText value="#{mvt.stk_activite}" />
                        </rich:column>
                        <rich:column  width="12%" sortable="true" sortBy="#{mvt.stk_date_mvt}" >
                            <f:facet name="header" ><h:outputText value="Date" /></f:facet>
                            <h:outputText value="#{mvt.stk_date_mvt}">
                                <f:convertDateTime pattern="dd/MM/yy  HH:MM" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column  width="10%" sortable="true" sortBy="#{mvt.stk_numero}" >
                            <f:facet name="header" ><h:outputText value="Numéro" /></f:facet>
                            <h:outputText value="#{mvt.stk_numero}" />
                        </rich:column>
                        <rich:column  width="10%" sortable="true" sortBy="#{mvt.stk_qte_in}" style="text-align:right;">
                            <f:facet name="header" ><h:outputText value="Qte In" /></f:facet>
                            <h:outputText value="#{mvt.stk_qte_in}" rendered="#{mvt.stk_qte_in!=0}"/>
                        </rich:column>
                        <rich:column  width="10%" sortable="true" sortBy="#{mvt.stk_qte_out}" style="text-align:right;">
                            <f:facet name="header" ><h:outputText value="Qte out" /></f:facet>
                            <h:outputText value="#{mvt.stk_qte_out}" rendered="#{mvt.stk_qte_out!=0}"/>
                        </rich:column>
                        <rich:column  width="10%" sortable="true" sortBy="#{mvt.stk_pv}" style="text-align:right;">
                            <f:facet name="header" ><h:outputText value="P.V." /></f:facet>
                            <h:outputText value="#{mvt.stk_pv}" rendered="#{mvt.stk_pv!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column  width="18%" sortable="true" sortBy="#{mvt.stk_tiers}" >
                            <f:facet name="header" ><h:outputText value="Tiers" /></f:facet>
                            <h:outputText value="#{mvt.stk_tiers}" />
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <h:panelGrid width="100%" columns="2" id="idTotal">
                    <h:column><h:outputText value="Total Qte entrée:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.tot_qte_in}" readonly="true" style="text-align:right;"/></h:column>
                    <h:column><h:outputText value="Total Qte sortie:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.tot_qte_out}" readonly="true" style="text-align:right;"/></h:column>
                    <h:column><h:outputText value="Total Valeur:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.tot_montant}" readonly="true" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelImpMvts" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="450" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.showModalPanelPrint}">
        <center>
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
                        <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.nomModeleMvts}" >
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.listeImpressionMvtsItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onselect" reRender="docSelect"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
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
        </center>
    </rich:modalPanel>

   <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.valQteGraph}" >
                                <f:selectItem itemLabel="En valeur PV" itemValue="0"/>
                                <f:selectItem itemLabel="En valeur PUMP" itemValue="1"/>
                                <f:selectItem itemLabel="en quantité" itemValue="2"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <f:selectItem itemLabel="par société" itemValue="4"/>
                                <f:selectItem itemLabel="par dossier" itemValue="7"/>
                                <f:selectItem itemLabel="par dépot" itemValue="8"/>
                                <f:selectItem itemLabel="par type de mouvement" itemValue="9"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
