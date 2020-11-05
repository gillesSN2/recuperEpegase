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

        <center><h2><h:outputText value="MOUVEMENTS DES PRODUITS (MEDICAL)" style="color:green;"/></h2></center>

        <h:panelGrid  id="idlienMvt" width="100%">
            <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proCode} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proLibClient}"></h:outputText></f:facet>
           
            <h:panelGrid columns="4" id="recMvt" styleClass="recherche" width="100%">
                <h:column>
                    <h:outputText value="Date  début:"/><rich:calendar inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_date_debut}"  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"/>
                    <br>
                    <h:outputText value="Date de  fin:"/><rich:calendar inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_date_fin}"  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"/>
                </h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_depot}"  style="width:130px;">
                        <f:selectItem itemLabel="Tous Dépôts" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.mesDepotItems}"/>
                    </h:selectOneMenu>
                    <br><br>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_activites}"  style="width:130px;">
                        <f:selectItem itemLabel="Toutes Activités" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesActivitesItems}"/>
                    </h:selectOneMenu>
                    <br><br>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_services}"  style="width:130px;">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesServicesItems}"/>
                    </h:selectOneMenu>
                </h:column>
                    <h:panelGrid width="100%" columns="3">
                    <h:panelGrid  style="width:150px;height:150px;border:1px solid green;" title="Achats" id="selAch">
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_mvt_ss_fcotation}"/><h:outputText value="Cotations"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_mvt_ss_fcommande}"/><h:outputText value="Commandes" /></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_mvt_as_freception}" style="color:red"/><h:outputText value="Réceptions" style="color:red"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_mvt_as_fsav}" style="color:red"/><h:outputText value="Retours" style="color:red"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_mvt_ss_ffacture}"/><h:outputText value="Factures"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_mvt_ss_favoir}"/><h:outputText value="Avoirs" /></h:column>
                    </h:panelGrid>
                    <h:panelGrid  style="width:150px;height:150px;border:1px solid green;" title="Stocks" id="selStk">
                        <h:column>
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_mvt_as_inventaire}" style="color:red">
                                <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.deSelPump}" reRender="tableResult,idlienMvt"/>
                            </h:selectBooleanCheckbox>
                            <h:outputText value="Inventaires" style="color:red"/></h:column>
                        <h:column>
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_mvt_as_bin}" style="color:red">
                                <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.deSelPump}" reRender="tableResult,idlienMvt"/>
                            </h:selectBooleanCheckbox>
                            <h:outputText value="Bons entrées" style="color:red"/></h:column>
                        <h:column>
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_mvt_as_bout}" style="color:red">
                                <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.deSelPump}" reRender="tableResult,idlienMvt"/>
                            </h:selectBooleanCheckbox>
                            <h:outputText value="Bons sorties" style="color:red"/></h:column>
                        <h:column>
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_mvt_as_cession}" style="color:red">
                                <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.deSelPump}" reRender="tableResult,idlienMvt"/>
                            </h:selectBooleanCheckbox>
                            <h:outputText value="Cessions" style="color:red"/></h:column>
                        <h:column>
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_mvt_as_production}" style="color:red">
                                <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.deSelPump}" reRender="tableResult,idlienMvt"/>
                            </h:selectBooleanCheckbox>
                            <h:outputText value="Productions" style="color:red"/></h:column>
                        <h:column>
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_mvt_ss_pump}" style="color:blue">
                                <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.selPump}" reRender="tableResult,idlienMvt"/>
                            </h:selectBooleanCheckbox>
                            <h:outputText value="Evolution PUMP" style="color:blue"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid style="width:130px;border:1px solid green;" title="Ventes" id="selVte">
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_mvt_ss_cdevis}"/><h:outputText value="Ordonnance"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_mvt_as_cbl}" style="color:red"/><h:outputText value="Pharmacie" style="color:red"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_mvt_as_ticket}" style="color:red"/><h:outputText value="Hospitalisation" style="color:red"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <h:column>
                    <a4j:commandButton style="width:120px" value="Sél. Stock" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.selStock}" reRender="selAch,selStk,selVte"/>
                    <br>
                    <a4j:commandButton style="width:120px" value="Sél. Tout" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.selTout}" reRender="selAch,selStk,selVte"/>
                    <br>
                    <a4j:commandButton style="width:120px" value="Sél. Rien" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.selRien}" reRender="selAch,selStk,selVte"/>
                    <br><br>
                    <a4j:commandButton style="width:120px" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.chargerMouvements}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,resultatMvt"/>
                    <br>
                    <h:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.annuleSaisie}" />
                </h:column>
            </h:panelGrid>
            <Br>
            <h:panelGrid  width="100%" id="resultatMvt">
                <rich:extendedDataTable style="border:solid 0px green;" height="500px" width="100%" border="0" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" sortMode="multi" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelMvt}" var="mvt">
                    <rich:column  width="10%" sortable="true" sortBy="#{mvt.stk_type}" sortOrder="ASCENDING">
                        <f:facet name="header" ><h:outputText value="Type"/></f:facet>
                        <h:outputText value="#{mvt.stk_lib_type}" />
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
                    <rich:column  width="8%" sortable="true" sortBy="#{mvt.stk_qte_in}" style="text-align:right;">
                        <f:facet name="header" ><h:outputText value="Qte In" /></f:facet>
                        <h:outputText value="#{mvt.stk_qte_in}" rendered="#{mvt.stk_qte_in!=0}"/>
                    </rich:column>
                    <rich:column  width="8%" sortable="true" sortBy="#{mvt.stk_qte_out}" style="text-align:right;">
                        <f:facet name="header" ><h:outputText value="Qte out" /></f:facet>
                        <h:outputText value="#{mvt.stk_qte_out}" rendered="#{mvt.stk_qte_out!=0}"/>
                    </rich:column>
                    <rich:column  width="10%" sortable="true" sortBy="#{mvt.stk_pv}" style="text-align:right;">
                        <f:facet name="header" ><h:outputText value="P.V." /></f:facet>
                        <h:outputText value="#{mvt.stk_pv}" rendered="#{mvt.stk_pv!=0}">
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.formatdevise==0}">
                                <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.formatdevise==1}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.formatdevise==2}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </c:if>
                        </h:outputText>
                    </rich:column>
                    <rich:column  width="10%" sortable="true" sortBy="#{mvt.stk_pump}" style="text-align:right;">
                        <f:facet name="header" ><h:outputText value="P.U.M.P." /></f:facet>
                        <h:outputText value="#{mvt.stk_pump}" rendered="#{mvt.stk_pump!=0}"/>
                    </rich:column>
                    <rich:column  width="18%" sortable="true" sortBy="#{mvt.stk_tiers}" >
                        <f:facet name="header" ><h:outputText value="Tiers" /></f:facet>
                        <h:outputText value="#{mvt.stk_tiers}" />
                    </rich:column>
                </rich:extendedDataTable>
            </h:panelGrid>
        </h:panelGrid>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="450" height="450">
        <center>
            <f:facet name="header"><h:outputText value="Impression"/></f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelink1Impim"/>
                    <rich:componentControl for="panelImp" attachTo="hidelink1Impim" operation="hide" event="onclick"/>
                </h:panelGroup>
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
                        <h:selectOneRadio id="choixDoc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_choix_modele}" >
                            <f:selectItem itemLabel="Produit séléctionné" itemValue="0"/>
                            <f:selectItem itemLabel="Liste de produits" itemValue="1"/>
                        </h:selectOneRadio>
                        <br>
                        <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.nomRapport}" >
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.listeImpressionItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onselect" reRender="docSelect"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="6">
                            <h:commandButton id="b1" image="/images/imp_reader.png" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.imprimerPDF}"/>
                            <h:commandButton id="b2" image="/images/imp_excel.png" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.imprimerXLS}"/>
                            <h:commandButton id="b3" image="/images/imp_word.png" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.imprimerDOC}"/>
                            <h:commandButton id="b4" image="/images/imp_html.png" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.imprimerHTML}"/>
                            <h:commandButton id="b5" image="/images/imp_xml.png" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.imprimerXML}"/>
                            <a4j:commandButton id="b6" reRender="formModalImp" image="/images/imp_mail.png" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.envoieMAIL}" />
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="optionMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column><h:inputText style="width:100%"  /></h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.imprimer}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.affMail}" id="print">
                                <rich:componentControl for="panelImp" attachTo="print" operation="hide" event="onclick"/>
                            </h:commandButton>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>


</f:subview>
