<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="espaceClient">

    <a4j:form id="formEspaceClient">

        <center>
            <h2>
                <h:outputText value="ESPACE CLIENT (UTILISATEURS)" style="color:green;font-size:16px;"/>&nbsp;&nbsp;&nbsp;
            </h2>
        </center>

        <center>
            <h:panelGrid id="butt">
                <a4j:commandButton title="Payer les factures sélectionnées" image="/images/dollar.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.ajouterPaiement}" reRender="panelPaiement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.montantSoldeElmt!=0}"/>
            </h:panelGrid>
        </center>
        <br>
        <h:panelGrid id="pgrd2" style="width:100%;max-height:100%;">
            <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabFacture" label="Factures">
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableFacture" maxPages="20"align="left" for="tableFacture"/>
                        <rich:extendedDataTable rows="100" style="max-height:100%;" styleClass="bg" id="tableFacture" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.dataModelFacturesEntete}" var="fac">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.selectionLigneFacture}" reRender="panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                            <rich:column label="N° facture" sortable="true" sortBy="#{fac.facNum}">
                                <f:facet name="header"><h:outputText  value="N° FACTURE" /></f:facet>
                                <h:outputText value="#{fac.facNum}"/>
                            </rich:column>
                            <rich:column label="Date facture" sortable="true" sortBy="#{fac.facDate} #{fac.facNum}" width="70px">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{fac.facDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Série" sortable="true" sortBy="#{fac.facSerie}" style="text-align:center;" width="40px">
                                <f:facet name="header"><h:outputText  value="S." /></f:facet>
                                <h:outputText value="#{fac.facSerie}"/>
                            </rich:column>
                            <rich:column label="Catégorie client" sortable="true" sortBy="#{fac.facCat}" width="70px">
                                <f:facet name="header"><h:outputText  value="Cat." /></f:facet>
                                <h:outputText value="#{fac.facCat}"/>
                            </rich:column>
                            <rich:column label="N° bon de livraison" sortable="true" sortBy="#{fac.facNumBl}">
                                <f:facet name="header"><h:outputText  value="N° BL" /></f:facet>
                                <h:outputText value="#{fac.facNumBl}"/>
                            </rich:column>
                            <rich:column label="Etat" sortable="true" sortBy="#{fac.facEtat}" width="50px" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                <h:outputText value="#{fac.libelleEta}"/>
                            </rich:column>
                            <rich:column label="Paiement" sortable="true" sortBy="#{fac.var_select_ligne}" width="50px" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Pay." /></f:facet>
                                <h:selectBooleanCheckbox value="#{fac.var_select_ligne}" rendered="#{fac.var_reliquat!=0}">
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.calculTotal}" reRender="pnlgrttotal,butt" />
                                </h:selectBooleanCheckbox>
                            </rich:column>
                            <rich:column label="Montant H.T." sortable="true" sortBy="#{fac.facTotHt}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="H.T."  /></f:facet>
                                <h:outputText  value="#{fac.facTotHt}" rendered="#{fac.facTotHt!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant des taxes" sortable="true" sortBy="#{fac.facTotTva}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Taxes"/></f:facet>
                                <h:outputText  value="#{fac.facTotTva}" rendered="#{fac.facTotTva!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant T.T.C." sortable="true" sortBy="#{fac.varTotTtcGlob}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                <h:outputText  value="#{fac.varTotTtcGlob}" rendered="#{fac.varTotTtcGlob!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Règlements" sortable="true" sortBy="#{fac.facTotReglement}" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Régl."  /></f:facet>
                                <h:outputText  value="#{fac.facTotReglement}" rendered="#{fac.facTotReglement!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Solde" sortable="true" sortBy="#{fac.var_reliquat}" style="text-align:right;color:red">
                                <f:facet name="header"> <h:outputText value="Solde"  /></f:facet>
                                <h:outputText  value="#{fac.var_reliquat}" rendered="#{fac.var_reliquat!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Date dernier règlement" sortable="true" sortBy="#{fac.facDateLastReg}" width="70px">
                                <f:facet name="header"><h:outputText value="Last.Reg." /></f:facet>
                                <h:outputText value="#{fac.facDateLastReg}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab id="tabNoteDebit" label="Notes de Débit">
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableNoteDebit" maxPages="20"align="left" for="tableNoteDebit"/>
                        <rich:extendedDataTable rows="100" style="max-height:100%;" styleClass="bg" id="tableNoteDebit" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.dataModelNoteDebitEntete}" var="ndb">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.selectionLigneNoteDebit}" reRender="panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                            <rich:column label="N° Note de Debit" sortable="true" sortBy="#{ndb.ndbNum}">
                                <f:facet name="header"><h:outputText  value="N° N.DEBIT" /></f:facet>
                                <h:outputText value="#{ndb.ndbNum}"/>
                            </rich:column>
                            <rich:column label="Date note débit" sortable="true" sortBy="#{ndb.ndbDate} #{ndb.ndbNum}" width="70px">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{ndb.ndbDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Série" sortable="true" sortBy="#{ndb.ndbSerie}" style="text-align:center;" width="40px">
                                <f:facet name="header"><h:outputText  value="S." /></f:facet>
                                <h:outputText value="#{ndb.ndbSerie}"/>
                            </rich:column>
                            <rich:column label="Catégorie client" sortable="true" sortBy="#{ndb.ndbCat}" width="70px">
                                <f:facet name="header"><h:outputText  value="Cat." /></f:facet>
                                <h:outputText value="#{ndb.ndbCat}"/>
                            </rich:column>
                            <rich:column label="N° bon de livraison" sortable="true" sortBy="#{ndb.ndbNumBl}">
                                <f:facet name="header"><h:outputText  value="N° BL" /></f:facet>
                                <h:outputText value="#{ndb.ndbNumBl}"/>
                            </rich:column>
                            <rich:column label="Etat" sortable="true" sortBy="#{ndb.ndbEtat}" width="50px" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                <h:outputText value="#{ndb.libelleEta}"/>
                            </rich:column>
                            <rich:column label="Paiement" sortable="true" sortBy="#{ndb.var_select_ligne}" width="50px" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Pay." /></f:facet>
                                <h:selectBooleanCheckbox value="#{ndb.var_select_ligne}" rendered="#{ndb.var_reliquat!=0}">
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.calculTotal}" reRender="pnlgrttotal,butt" />
                                </h:selectBooleanCheckbox>
                            </rich:column>
                            <rich:column label="Montant H.T." sortable="true" sortBy="#{ndb.ndbTotHt}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="H.T."  /></f:facet>
                                <h:outputText  value="#{ndb.ndbTotHt}" rendered="#{ndb.ndbTotHt!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant des taxes" sortable="true" sortBy="#{ndb.ndbTotTva}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Taxes"/></f:facet>
                                <h:outputText  value="#{ndb.ndbTotTva}" rendered="#{ndb.ndbTotTva!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant T.T.C." sortable="true" sortBy="#{ndb.varTotTtcGlob}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                <h:outputText  value="#{ndb.varTotTtcGlob}" rendered="#{ndb.varTotTtcGlob!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Règlements" sortable="true" sortBy="#{ndb.facTotReglement}" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Régl."  /></f:facet>
                                <h:outputText  value="#{ndb.ndbTotReglement}" rendered="#{ndb.ndbTotReglement!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Solde" sortable="true" sortBy="#{ndb.var_reliquat}" style="text-align:right;color:red">
                                <f:facet name="header"> <h:outputText value="Solde"  /></f:facet>
                                <h:outputText  value="#{ndb.var_reliquat}" rendered="#{ndb.var_reliquat!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Date dernier règlement" sortable="true" sortBy="#{ndb.ndbDateLastReg}" width="70px">
                                <f:facet name="header"><h:outputText value="Last.Reg." /></f:facet>
                                <h:outputText value="#{ndb.ndbDateLastReg}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab id="tabAvoir" label="Avoirs">
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableAvoir" maxPages="20"align="left" for="tableAvoir"/>
                        <rich:extendedDataTable rows="100" style="max-height:100%;" styleClass="bg" id="tableAvoir" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.dataModelAvoirsEntete}" var="avr">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.selectionLigneAvoir}" reRender="panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                            <rich:column label="N° avoir" sortable="true" sortBy="#{avr.avrNum}">
                                <f:facet name="header"><h:outputText  value="N° AVOIR" /></f:facet>
                                <h:outputText value="#{avr.avrNum}"/>
                            </rich:column>
                            <rich:column label="Date facture" sortable="true" sortBy="#{avr.avrDate} #{avr.avrNum}" width="70px">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{avr.avrDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Série" sortable="true" sortBy="#{avr.avrSerie}" style="text-align:center;" width="40px">
                                <f:facet name="header"><h:outputText  value="S." /></f:facet>
                                <h:outputText value="#{avr.avrSerie}"/>
                            </rich:column>
                            <rich:column label="Catégorie client" sortable="true" sortBy="#{avr.avrCat}" width="70px">
                                <f:facet name="header"><h:outputText  value="Cat." /></f:facet>
                                <h:outputText value="#{avr.avrCat}"/>
                            </rich:column>
                            <rich:column label="N° facture" sortable="true" sortBy="#{avr.avrNumFac}">
                                <f:facet name="header"><h:outputText  value="N° facture" /></f:facet>
                                <h:outputText value="#{avr.avrNumFac}"/>
                            </rich:column>
                            <rich:column label="Etat" sortable="true" sortBy="#{avr.avrEtat}" width="50px" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                <h:outputText value="#{avr.libelleEta}"/>
                            </rich:column>
                            <rich:column label="Montant H.T." sortable="true" sortBy="#{avr.avrTotHt}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="H.T."  /></f:facet>
                                <h:outputText  value="#{avr.avrTotHt}" rendered="#{avr.avrTotHt!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant des taxes" sortable="true" sortBy="#{avr.avrTotTva}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Taxes"/></f:facet>
                                <h:outputText  value="#{avr.avrTotTva}" rendered="#{avr.avrTotTva!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant T.T.C." sortable="true" sortBy="#{avr.varTotTtcGlob}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                <h:outputText  value="#{avr.varTotTtcGlob}" rendered="#{avr.varTotTtcGlob!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Règlements" sortable="true" sortBy="#{avr.avrTotReglement}" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Régl."  /></f:facet>
                                <h:outputText  value="#{avr.avrTotReglement}" rendered="#{avr.avrTotReglement!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Solde" sortable="true" sortBy="#{avr.var_reliquat}" style="text-align:right;color:red">
                                <f:facet name="header"> <h:outputText value="Solde"  /></f:facet>
                                <h:outputText  value="#{avr.var_reliquat}" rendered="#{avr.var_reliquat!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Date dernier règlement" sortable="true" sortBy="#{avr.avrDateLastReg}" width="70px">
                                <f:facet name="header"><h:outputText value="Last.Reg." /></f:facet>
                                <h:outputText value="#{avr.avrDateLastReg}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab id="tabDevis" label="Devis">
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableDevis" maxPages="20"align="left" for="tableDevis"/>
                        <rich:extendedDataTable rows="100" style="max-height:100%;" styleClass="bg" id="tableDevis" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.dataModelDevisEntete}" var="dvs">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.selectionLigneDevis}" reRender="panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                            <rich:column label="N° devis" sortable="true" sortBy="#{dvs.dvsNum}">
                                <f:facet name="header"><h:outputText  value="N° DEVIS" /></f:facet>
                                <h:outputText value="#{dvs.dvsNum}"/>
                            </rich:column>
                            <rich:column label="Série" sortable="true" sortBy="#{dvs.dvsSerie}" style="text-align:center;" width="40px">
                                <f:facet name="header"><h:outputText  value="S." /></f:facet>
                                <h:outputText value="#{dvs.dvsSerie}"/>
                            </rich:column>
                            <rich:column label="Catégorie client" sortable="true" sortBy="#{dvs.dvsCat}" width="70px">
                                <f:facet name="header"><h:outputText  value="Cat." /></f:facet>
                                <h:outputText value="#{dvs.dvsCat}"/>
                            </rich:column>
                            <rich:column label="Etat" sortable="true" sortBy="#{dvs.dvsEtat}" width="50px" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                <h:outputText value="#{dvs.libelleEta}"/>
                            </rich:column>
                            <rich:column label="Montant H.T." sortable="true" sortBy="#{dvs.dvsTotHt}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="H.T."  /></f:facet>
                                <h:outputText  value="#{dvs.dvsTotHt}" rendered="#{dvs.dvsTotHt!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant des taxes" sortable="true" sortBy="#{dvs.dvsTotTva}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Taxes"/></f:facet>
                                <h:outputText  value="#{dvs.dvsTotTva}" rendered="#{dvs.dvsTotTva!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant T.T.C." sortable="true" sortBy="#{dvs.varTotTtcGlob}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                <h:outputText  value="#{dvs.varTotTtcGlob}" rendered="#{dvs.varTotTtcGlob!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="objet" sortable="true" sortBy="#{dvs.dvsObject}" width="400px">
                                <f:facet name="header"><h:outputText  value="Objet" /></f:facet>
                                <h:outputText value="#{dvs.dvsObject}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGrid id="pnlgrttotal" columns="4" cellspacing="1" styleClass="recherche"  width="100%">
                <h:panelGrid columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText value="Total TTC" />
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.montantTtc}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText value="Total TTC" />
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.montantTtcElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText value="Total Réglements" />
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.montantReglement}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText value="Total Réglements" />
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.montantReglementElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText value="Solde" />
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.montantSolde}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText value="Solde" />
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.montantSoldeElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid columns="1" cellspacing="3"  cellpadding="3">
                    <h:outputText value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.var_nb_ligne})" />
                    <h:outputText value="(Eléments sélectionnés)" />
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>
        <br>
        <center>
            <h:commandButton id="idCancel" styleClass="exp_lienmenu" value="RETOUR" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.retourAdmnistration}"/>
            <rich:hotKey key="esc" handler="#{rich:element('idCancel')}.click()" />
        </center>

    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelPaiement" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="600" height="400" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.showModalPanelPaiement}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.showModalPanelPaiement}" var="pay">
            <f:facet name="header"><h:outputText value="Gestion des paiements"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idFermePanelPaiement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.fermerPaiement}" image="/images/close.gif" styleClass="hidelink" reRender="panelPaiement"/>
                </a4j:form>
            </f:facet>
            <form id="formTpe" action="<%=request.getContextPath()%>/paiementCashBox" method="post">

                <h:panelGrid id="panelGestionPaiement" style="width:100%;">

                    <script type="text/javascript" language="Javascript">
                        function GetParams() {
                            var TpeArr = new Array();
                            TpeArr.push(parseInt(document.getElementById("Montant").value)); //Montant
                            TpeArr.push("epegase"); //CommercantID
                            TpeArr.push(document.getElementById("Nom").value); //ClientNom
                            TpeArr.push(document.getElementById("Email").value); //ClientEmail
                            TpeArr.push(document.getElementById("Tel").value); //ClientGSM
                            TpeArr.push("FR"); //Langue
                            TpeArr.push(document.getElementById("Ref").value); //Ref Commande
                            TpeArr.push(document.getElementById("Comm").value); //Commentaire
                            TpeArr.push("e-pegase.biz"); //Point de Vente
                            return TpeArr;
                        }
                        function DoTpe(param) {
                            document.getElementById("Tpe").style.visibility = 'visible';
                            document.getElementById("Tpe").innerHTML=param;
                        }
                        function CloseTpe() {
                            document.getElementById("Tpe").style.visibility = 'hidden';
                            document.getElementById("Tpe").innerHTML="";
                        }
                        function PayValid(pVal) {
                            CloseTpe();
                            document.getElementById("resultat").value = pVal;
                            document.forms["formTpe"].submit();
                        }
                    </script>

                    <table style="width: 550px; height: 200px;" border="0">
                        <tbody>
                            <tr>
                                <td>Nom:</td>
                                <td><input id="Nom" type="text" value="${bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.usersLog.usrPatronyme}" readonly="true"/></td>
                            </tr>
                            <tr>
                                <td>Email:</td>
                                <td><input id="Email" type="text" value="${bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.usersLog.usrMail}" readonly="true"/></td>
                            </tr>
                            <tr>
                                <td>Téléphone:</td>
                                <td><input id="Tel" type="text" value="${bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.usersLog.usrTelBureau}" readonly="true"/></td>
                            </tr>
                            <tr>
                                <td>Montant:</td>
                                <td><input id="Montant" type="text" value="${bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.totalPayer}" readonly="true"/></td>
                            </tr>
                            <tr>
                                <td>Référence facture:</td>
                                <td><input id="Ref" type="text" value="${bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.referenceFacture}" readonly="true"/></td>
                            </tr>
                            <tr>
                                <td>Commentaires:</td>
                                <td<input id="Comm" type="text" value="${bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.commentaire}"/></td>
                            </tr>
                        </tbody>
                    </table>

                    <br><br>

                    <center>
                        <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" id="TpeButton" width="417" height="109" codebase="http://fpdownload.macromedia.com/get/flashplayer/current/swflash.cab">
                            <param name="movie" value="/images/TpeButton.swf" />
                            <param name="wmode" value="transparent" />
                            <param name="quality" value="high" />
                            <param name="bgcolor" value="#869ca7" />
                            <param name="allowScriptAccess" value="always" />
                            <embed src="images/TpeButton.swf" quality="high" bgcolor="#869ca7"
                                   width="417" height="109" name="TpeButton" align="middle"
                                   play="true"
                                   loop="false"
                                   wmode="transparent"
                                   quality="high"
                                   allowScriptAccess="always"
                                   type="application/x-shockwave-flash"
                                   pluginspage="http://www.adobe.com/go/getflashplayer">
                            </embed>
                        </object>
                        <div id="Tpe" class="TpeStyle">
                        </div>
                        <input id="resultat" type="hidden" value="${bakingbeanepegase.menuModuleHorizontalCtrl.formEspaceClient.resultat}"/>
                    </center>

                </h:panelGrid>
            </form>
        </c:if>
    </rich:modalPanel>



</f:subview>
