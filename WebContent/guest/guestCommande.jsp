<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="guestcommande">

    <center><h2><h:outputText value="Mes commandes : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.tiers.tieraisonsocialenom}" style="color:green;"/></h2></center>

    <a4j:form id="commandes" >

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
                <h:panelGrid columns="11" width="100%">
                    <h:column><h:outputText value="N°"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.inpNum}" size="5"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.mesEtatsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Du"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.inpService}" style="width:150px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.mesServicesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.rechercheCommande}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,tableFrn,tableClt,scrollTable1,scrollTable2,pnlgrttotal"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <center>
            <h:panelGroup>
                <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.visibiliteBton}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
            </h:panelGroup>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.typeTiers==0}" var="frn">
                <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.pageIndex}" reRender="tableFrn" id="scrollTable1" maxPages="20"align="left" for="tableFrn"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableFrn" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.datamodelCommandesAchats}" var="var">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.selectionCommandeAchats}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                            <rich:column label="N° commande" sortable="true" sortBy="#{var.cmdNum}">
                                <f:facet name="header"><h:outputText  value="N° COMMANDE" /></f:facet>
                                <h:outputText value="#{var.cmdNum}"/>
                            </rich:column>
                            <rich:column label="Date facture" sortable="true" sortBy="#{var.cmdDate} #{var.cmdNum}" width="70px">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{var.cmdDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Catégorie fournisseur" sortable="true" sortBy="#{var.cmdCat}" width="70px">
                                <f:facet name="header"><h:outputText  value="Cat." /></f:facet>
                                <h:outputText value="#{var.cmdCat}"/>
                            </rich:column>
                            <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{var.cmdEtat}" width="50px" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                <h:outputText value="#{var.libelleEta}"/>
                            </rich:column>
                            <rich:column label="Contact" sortable="true" sortBy="#{var.var_nomContact}" width="200px">
                                <f:facet name="header"><h:outputText value="Contact"/></f:facet>
                                <h:outputText  value="#{var.var_nomContact}"/>
                            </rich:column>
                            <rich:column label="Montant H.T." sortable="true" sortBy="#{var.cmdTotHt}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="H.T."  /></f:facet>
                                <h:outputText  value="#{var.cmdTotHt}" rendered="#{var.cmdTotHt!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant des taxes" sortable="true" sortBy="#{var.cmdTotTva}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Taxes"/></f:facet>
                                <h:outputText  value="#{var.cmdTotTva}" rendered="#{var.cmdTotTva!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant T.T.C." sortable="true" sortBy="#{var.varTotTtcGlob}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                <h:outputText  value="#{var.varTotTtcGlob}" rendered="#{var.varTotTtcGlob!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Règlements" sortable="true" sortBy="#{var.cmdTotReglement}" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Régl."  /></f:facet>
                                <h:outputText  value="#{var.cmdTotReglement}" rendered="#{var.cmdTotReglement!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Solde" sortable="true" sortBy="#{var.var_reliquat}" style="text-align:right;color:red">
                                <f:facet name="header"> <h:outputText value="Solde"  /></f:facet>
                                <h:outputText  value="#{var.var_reliquat}" rendered="#{var.var_reliquat!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Activité commerciale" sortable="true" sortBy="#{var.cmdActivite}" >
                                <f:facet name="header"><h:outputText value="Act."  /></f:facet>
                                <h:outputText  value="#{var.cmdActivite}"/>
                            </rich:column>
                            <rich:column label="Objet de la commande" sortable="true" sortBy="#{var.cmdObject}" width="200px">
                                <f:facet name="header"><h:outputText value="Objet"  /></f:facet>
                                <h:outputText  value="#{var.cmdObject}"/>
                            </rich:column>
                            <rich:column label="Echéance" sortable="true" sortBy="#{var.cmdDateEcheReg}" width="70px" >
                                <f:facet name="header"><h:outputText value="Eché."  /></f:facet>
                                <h:outputText  value="#{var.cmdDateEcheReg}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Responsable" sortable="true" sortBy="#{var.cmdNomResponsable}" width="200px">
                                <f:facet name="header"><h:outputText  value="Respponsable"  /></f:facet>
                                <h:outputText  value="#{var.cmdNomResponsable}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </div>
            </c:if>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.typeTiers==3}" var="clt">
                <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable2" maxPages="20"align="left" for="tableClt"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableClt" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.datamodelCommandesVentes}" var="var">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.selectionCommandeVentes}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                            <rich:column label="N° commande" sortable="true" sortBy="#{var.bcmNum}">
                                <f:facet name="header"><h:outputText  value="N° COMMANDE" /></f:facet>
                                <h:outputText value="#{var.bcmNum}"/>
                            </rich:column>
                            <rich:column label="Date commande" sortable="true" sortBy="#{var.bcmDate} #{var.bcmNum}" width="70px">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{var.bcmDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Catégorie client" sortable="true" sortBy="#{var.bcmCat}" width="70px">
                                <f:facet name="header"><h:outputText  value="Cat." /></f:facet>
                                <h:outputText value="#{var.bcmCat}"/>
                            </rich:column>
                            <rich:column id="idEtat" title="Etat" sortable="true" sortBy="#{var.bcmEtat}" width="50px" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                <h:outputText value="#{var.libelleEta}"/>
                            </rich:column>
                            <rich:column label="Contact ou Destinataire" sortable="true" sortBy="#{var.var_nomContact}" width="200px">
                                <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.var_libcondest}"/></f:facet>
                                <h:outputText  value="#{var.var_nomContact}"/>
                            </rich:column>
                            <rich:column label="Montant H.T." sortable="true" sortBy="#{var.bcmTotHt}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="H.T."  /></f:facet>
                                <h:outputText  value="#{var.bcmTotHt}" rendered="#{var.bcmTotHt!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant des taxes" sortable="true" sortBy="#{var.bcmTotTva}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Taxes"/></f:facet>
                                <h:outputText  value="#{var.bcmTotTva}" rendered="#{var.bcmTotTva!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant T.T.C." sortable="true" sortBy="#{var.varTotTtcGlob}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                <h:outputText  value="#{var.varTotTtcGlob}" rendered="#{var.varTotTtcGlob!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Règlements" sortable="true" sortBy="#{var.bcmTotReglement}" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Régl."  /></f:facet>
                                <h:outputText  value="#{var.bcmTotReglement}" rendered="#{var.bcmTotReglement!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Solde" sortable="true" sortBy="#{var.var_reliquat}" style="text-align:right;color:red">
                                <f:facet name="header"> <h:outputText value="Solde"  /></f:facet>
                                <h:outputText  value="#{var.var_reliquat}" rendered="#{var.var_reliquat!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Activité commerciale" sortable="true" sortBy="#{var.bcmActivite}" >
                                <f:facet name="header"><h:outputText value="Act."  /></f:facet>
                                <h:outputText  value="#{var.bcmActivite}"/>
                            </rich:column>
                            <rich:column label="Source" sortable="true" sortBy="#{var.bcmSource}" >
                                <f:facet name="header"><h:outputText value="Source"  /></f:facet>
                                <h:outputText  value="#{var.bcmSource}"/>
                            </rich:column>
                            <rich:column label="Origine facture" sortable="true" sortBy="#{var.bcmContrat}">
                                <f:facet name="header"><h:outputText value="Origine" /></f:facet>
                                <h:outputText  value="#{var.bcmContrat}"/>
                            </rich:column>
                            <rich:column label="Objet de la commande" sortable="true" sortBy="#{var.bcmObject}" width="200px">
                                <f:facet name="header"><h:outputText value="Objet"  /></f:facet>
                                <h:outputText  value="#{var.bcmObject}"/>
                            </rich:column>
                            <rich:column label="Echéance" sortable="true" sortBy="#{var.bcmDateEcheReg}" width="70px" >
                                <f:facet name="header"><h:outputText value="Eché."  /></f:facet>
                                <h:outputText  value="#{var.bcmDateEcheReg}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Responsable" sortable="true" sortBy="#{var.bcmNomResponsable}" width="200px">
                                <f:facet name="header"><h:outputText  value="Respponsable"  /></f:facet>
                                <h:outputText  value="#{var.bcmNomResponsable}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </div>
            </c:if>

            <br/>
            <h:panelGrid id="pnlgrttotal" columns="4" cellspacing="1" styleClass="recherche"  width="100%">
                <h:panelGrid id="pnlgrttotalTTC" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpTTCL" value="Total TTC" />
                    <h:inputText id="intpTTCL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.montantTtc}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpTTCE" value="Total TTC" />
                    <h:inputText id="intpTTCE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.montantTtcElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalRGLMT" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpRGLMTL" value="Total Réglements" />
                    <h:inputText id="intpRGLMTL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.montantReglement}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpRGLMTE" value="Total Réglements" />
                    <h:inputText id="intpRGLMTE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.montantReglementElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalSOLD" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpSOLDL" value="Solde" />
                    <h:inputText id="intpSOLDL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.montantSolde}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpSOLDE" value="Solde" />
                    <h:inputText id="intpSOLDE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.montantSoldeElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalLE" columns="1" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpLIST" value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.var_nb_ligne})" />
                    <h:outputText id="outpELMT" value="(Eléments sélectionnés)" />
                </h:panelGrid>
            </h:panelGrid>
        </center>



    </a4j:form>


</f:subview>