<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="facturelissage">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center> <h2><h:outputText value="BAGUETTE MAGIQUE" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
                <h:panelGrid columns="9" width="100%">
                    <h:column><h:outputText value="Du"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Sélection Série"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.inpSerie}" style="width:100px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.mesSerieUserItem}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.executerRequeteLissage}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,table,scrollTable,pnlgrttotal"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="4" width="250px" style="height:34px">
            <a4j:commandButton title="Consulter le document sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.visualisationLigneLissage}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
            <a4j:commandButton title="Changer la série des documents sélectionnés" image="/images/imputer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.visibiliteBton&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facEtat==4)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.trf}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.transformerDocumentLissage}" reRender="panelLissage,formLissage"/>
            <a4j:commandButton title="Renumérotation de(s) document(s) sélectionné(s)" image="/images/transferer.png" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.visibiliteBton&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facEtat==4)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.trf}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.transformerReNumeroLissage}" reRender="table"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_nb_max}" style="max-height:100%;" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.datamodelEntete}" var="var"  activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.selectionLigneLissage}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.visualisationLigneLissage}" reRender="idSubView,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                        <rich:column label="N° facture" sortable="true" sortBy="#{var.facNum}">
                            <f:facet name="header"><h:outputText  value="N° FACTURE" /></f:facet>
                            <h:outputText value="#{var.facNum}"/>
                        </rich:column>
                        <rich:column label="Date facture" sortable="true" sortBy="#{var.facDate&&var.facNum}" width="70px">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.facDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Série" sortable="true" sortBy="#{var.facSerie}" style="text-align:center;" width="40px">
                            <f:facet name="header"><h:outputText  value="S." /></f:facet>
                            <h:outputText value="#{var.facSerie}"/>
                        </rich:column>
                        <rich:column label="Catégorie client" sortable="true" sortBy="#{var.facCat}" width="70px">
                            <f:facet name="header"><h:outputText  value="Cat." /></f:facet>
                            <h:outputText value="#{var.facCat}"/>
                        </rich:column>
                        <rich:column label="N° bon de livraison" sortable="true" sortBy="#{var.facNumBl}">
                            <f:facet name="header"><h:outputText  value="N° BL" /></f:facet>
                            <h:outputText value="#{var.facNumBl}"/>
                        </rich:column>
                        <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{var.facEtat}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{var.libelleEta}"/>
                        </rich:column>
                        <rich:column id="idTrf" label="Transfert" sortable="true" sortBy="#{var.var_select_ligne}" width="50px" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.trf}">
                            <f:facet name="header"><h:outputText  value="Trf." /></f:facet>
                            <h:selectBooleanCheckbox value="#{var.var_select_ligne}" rendered="#{(var.facEtat==1||var.facEtat==4)&&var.facSerie!='X'}"/>
                        </rich:column>
                        <rich:column label="Client" sortable="true" sortBy="#{var.var_nom_tiers}" width="200px">
                            <f:facet name="header"><h:outputText  value="Client"  /></f:facet>
                            <h:outputText  value="#{var.var_nom_tiers}"/>
                        </rich:column>
                        <rich:column label="Contact ou Destinataire" sortable="true" sortBy="#{var.var_nomContact}" width="200px">
                            <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_libcondest}"/></f:facet>
                            <h:outputText  value="#{var.var_nomContact}"/>
                        </rich:column>
                        <rich:column label="Montant H.T." sortable="true" sortBy="#{var.facTotHt}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="H.T."  /></f:facet>
                            <h:outputText  value="#{var.facTotHt}" rendered="#{var.facTotHt!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant de la TVA" sortable="true" sortBy="#{var.facTotTva}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="TVA"/></f:facet>
                            <h:outputText  value="#{var.facTotTva}" rendered="#{var.facTotTva!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant des taxes complémentaires" sortable="true" sortBy="#{var.facTotTc}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_tc_type!=0}">
                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_tc_libelle}"/></f:facet>
                            <h:outputText  value="#{var.facTotTc}" rendered="#{var.facTotTc!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant T.T.C." sortable="true" sortBy="#{var.varTotTtcGlob}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                            <h:outputText  value="#{var.varTotTtcGlob}" rendered="#{var.varTotTtcGlob!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Règlements" sortable="true" sortBy="#{var.facTotReglement}" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="Régl."  /></f:facet>
                            <h:outputText  value="#{var.facTotReglement}" rendered="#{var.facTotReglement!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Solde" sortable="true" sortBy="#{var.var_reliquat}" style="text-align:right;color:red">
                            <f:facet name="header"> <h:outputText value="Solde"  /></f:facet>
                            <h:outputText  value="#{var.var_reliquat}" rendered="#{var.var_reliquat!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date dernier règlement" sortable="true" sortBy="#{var.facDateLastReg}" width="70px">
                            <f:facet name="header"><h:outputText value="Last.Reg." /></f:facet>
                            <h:outputText value="#{var.facDateLastReg}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Activité commerciale" sortable="true" sortBy="#{var.facActivite}" >
                            <f:facet name="header"><h:outputText value="Act."  /></f:facet>
                            <h:outputText  value="#{var.facActivite}"/>
                        </rich:column>
                        <rich:column label="Parc" sortable="true" sortBy="#{var.facAnal2}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_anal_parc}">
                            <f:facet name="header"><h:outputText value="Prc."  /></f:facet>
                            <h:outputText  value="#{var.facAnal2}"/>
                        </rich:column>
                        <rich:column label="Origine facture" sortable="true" sortBy="#{var.facContrat}">
                            <f:facet name="header"><h:outputText value="Origine" /></f:facet>
                            <h:outputText  value="#{var.facContrat}"/>
                        </rich:column>
                        <rich:column label="Objet de la facture" sortable="true" sortBy="#{var.facObject}" width="200px">
                            <f:facet name="header"><h:outputText value="Objet"  /></f:facet>
                            <h:outputText  value="#{var.facObject}"/>
                        </rich:column>
                        <rich:column label="Echéance" sortable="true" sortBy="#{var.facDateEcheReg}" width="70px" >
                            <f:facet name="header"><h:outputText value="Eché."  /></f:facet>
                            <h:outputText  value="#{var.facDateEcheReg}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Responsable" sortable="true" sortBy="#{var.facNomResponsable}" width="200px">
                            <f:facet name="header"><h:outputText  value="Respponsable"  /></f:facet>
                            <h:outputText  value="#{var.facNomResponsable}"/>
                        </rich:column>
                        <rich:column label="Commercial" sortable="true" sortBy="#{var.facNomCommercial}" width="200px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.optionsVentes.responsable=='1'}">
                            <f:facet name="header"><h:outputText  value="Commercial"  /></f:facet>
                            <h:outputText  value="#{var.facNomCommercial}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
            <br/>
            <h:panelGrid id="pnlgrttotal" columns="4" cellspacing="1" styleClass="recherche"  width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrVteTotaux==0}">
                <h:panelGrid id="pnlgrttotalTTC" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpTTCL" value="Total TTC" />
                    <h:inputText id="intpTTCL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.montantTtc}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpTTCE" value="Total TTC" />
                    <h:inputText id="intpTTCE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.montantTtcElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalRGLMT" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpRGLMTL" value="Total Réglements" />
                    <h:inputText id="intpRGLMTL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.montantReglement}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpRGLMTE" value="Total Réglements" />
                    <h:inputText id="intpRGLMTE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.montantReglementElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalSOLD" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpSOLDL" value="Solde" />
                    <h:inputText id="intpSOLDL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.montantSolde}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpSOLDE" value="Solde" />
                    <h:inputText id="intpSOLDE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.montantSoldeElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalLE" columns="1" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpLIST" value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_nb_ligne})" />
                    <h:outputText id="outpELMT" value="(Eléments sélectionnés)" />
                </h:panelGrid>
            </h:panelGrid>
        </center>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelLissage" width="400" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.showModalPanelTrf}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.showModalPanelTrf}" var="ser">
            <f:facet name="header"><h:outputText value="Change Série"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.annuleLissage}" image="/images/close.gif" styleClass="hidelink" reRender="panelLissage"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formLissage">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;" id="idChangement">
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_imput_choix}" >
                            <f:selectItem itemLabel="Changement Numéro" itemValue="0"/>
                            <f:selectItem itemLabel="Changement Série" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idChangement"/>
                        </h:selectOneMenu>
                    </h:column>
                    <br><br><br>
                    <h:panelGrid  columns="2" style="width:100%;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_imput_choix==0}">
                        <h:column><h:outputText value="Ancien Numéro:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.factureEnteteVentes.facNum}" disabled="true" readonly="true"/></h:column>
                        <h:column><h:outputText value="Nouveau Numéro:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_imput_num}">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.controleNumero}" reRender="idChangement"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid  columns="2" style="width:100%;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_imput_choix==1}">
                        <h:column><h:outputText value="Sélection la Série:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="serieimput"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_serie_trf}" >
                                <f:selectItem itemLabel="Sélectionnez la série" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.mesSerieUserItem}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.verifLissage}" reRender="ppgrp,idCaisse" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Sélection la Caisse" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idCaisse" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.inpCaisse}" style="width:180px;">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.mesCaissesSeriesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <br>
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.miseajourLissage}" onclick="javascript:Richfaces.showModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.valideLissage}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
