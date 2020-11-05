<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="guestextrait">

    <center><h2><h:outputText value="Mon extrait de compte : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.compte} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.tiers.tieraisonsocialenom}" style="color:green;"/></h2></center>

    <a4j:form id="extraits" >

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
                <h:panelGrid columns="5" width="100%">
                    <h:column><h:outputText value="Période Du"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.rechercheExtrait}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,tableFrn,tableClt,scrollTable1,scrollTable2,pnlgrttotal"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <center>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.pageIndex}" reRender="tableFrn" id="scrollTable1" maxPages="20"align="left" for="tableFrn"/>
                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableFrn" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.datamodelExtraits}" var="table">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.selectionExtrait}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE,pnlgrttotal"/>
                    <rich:column id="c1" width="5%" sortable="true" sortBy="#{table.ecrCode}" label="Journal">
                        <f:facet name="header"><h:outputText  value="Jr." /></f:facet>
                        <h:outputText value="#{table.ecrCode}" style="#{table.gras}"/>
                    </rich:column>
                    <rich:column id="c2" width="7%" sortable="true" sortBy="#{table.ecrDateSaisie}" label="Date de saisie" sortOrder="DESCENDING">
                        <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                        <h:outputText value="#{table.ecrDateSaisie}" style="#{table.gras}">
                            <f:convertDateTime pattern="dd/MM/yy"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column id="c4" width="9%" sortable="true" sortBy="#{table.ecrPiece}" label="N° Pièce">
                        <f:facet name="header"><h:outputText value="Pièce" /></f:facet>
                        <h:outputText value="#{table.ecrPiece}" style="#{table.gras}"/>
                    </rich:column>
                    <rich:column id="c5" width="9%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.optionComptabilite.testRef1Piece}" sortable="true" sortBy="#{table.ecrReference1}" label="Référence 1">
                        <f:facet name="header"><h:outputText  value="Réf.1"/></f:facet>
                        <h:outputText value="#{table.ecrReference1}" style="#{table.gras}"/>
                    </rich:column>
                    <rich:column id="c6" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.optionComptabilite.testRef2Piece}" sortable="true" sortBy="#{table.ecrReference2}" label="Référence 2">
                        <f:facet name="header"><h:outputText  value="Réf.2"/></f:facet>
                        <h:outputText value="#{table.ecrReference2}" style="#{table.gras}"/>
                    </rich:column>
                    <rich:column id="c8" width="5%" sortable="true" sortBy="#{table.ecrLettrage}" label="Lettrage">
                        <f:facet name="header"><h:outputText  value="L."/></f:facet>
                        <h:outputText value="#{table.ecrLettrage}" style="#{table.gras}"/>
                    </rich:column>
                    <rich:column id="c9" width="4%" sortable="true" sortBy="#{table.ecrPointage}" label="Pointage">
                        <f:facet name="header"><h:outputText  value="P."/></f:facet>
                        <h:outputText value="#{table.erreurLettrage}" style="#{table.gras};color:red;"/>
                        <h:outputText value="#{table.ecrPointage}" style="#{table.gras}"/>
                    </rich:column>
                    <rich:column id="c10" width="7%" sortable="true" sortBy="#{table.ecrDateEcheance}" label="Date d'échéance">
                        <f:facet name="header"><h:outputText  value="Eché." /></f:facet>
                        <h:outputText value="#{table.ecrDateEcheance}" style="#{table.gras}">
                            <f:convertDateTime pattern="dd/MM/yy"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column id="c12" width="10%" style="text-align:right;" sortable="true" sortBy="#{table.ecrDebitPays}" label="Débit">
                        <f:facet name="header"><h:outputText  value="Débit" /></f:facet>
                        <h:outputText value="#{table.ecrDebitPays}" rendered="#{table.ecrDebitPays!=0}" style="#{table.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column id="c13" width="10%"  style="text-align:right;" sortable="true" sortBy="#{table.ecrCreditPays}"label="Crédit">
                        <f:facet name="header"><h:outputText  value="Crédit" /></f:facet>
                        <h:outputText value="#{table.ecrCreditPays}" rendered="#{table.ecrCreditPays!=0}" style="#{table.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column id="c14" width="20%" sortable="true" sortBy="#{table.ecrLibelle}" label="Libellé">
                        <f:facet name="header"><h:outputText value="Libellé" /></f:facet>
                        <h:outputText value="#{table.ecrLibelle}" style="#{table.gras}"/>
                    </rich:column>
                    <rich:column width="9%" style="text-align:center;" rendered="#{table.ecrAnaActif==1}">
                        <a4j:commandButton image="/images/detail.png" style="width:14px;height:14px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.ouvrirDetailsAnalytique}" reRender="idSubView,modalpanelAnalytique,formAnal,modalpanelAnalRecup,formAnalRecup" rendered="#{table.ecrAnaActif==1}" ></a4j:commandButton>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>

            <br/>
            <h:panelGrid id="pnlgrttotal" columns="3" cellspacing="1" styleClass="recherche"  width="100%">
                <h:panelGrid id="pnlgrttotalTTC" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpTTCL" value="Total Débit" />
                    <h:inputText id="intpTTCL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.montantTtc}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpTTCE" value="Débit" />
                    <h:inputText id="intpTTCE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.montantTtcElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalRGLMT" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpRGLMTL" value="Total Crédit" />
                    <h:inputText id="intpRGLMTL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.montantReglement}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpRGLMTE" value="Crédit" />
                    <h:inputText id="intpRGLMTE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.montantReglementElmt}" style="width:100%;text-align:right;" readonly="true">
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