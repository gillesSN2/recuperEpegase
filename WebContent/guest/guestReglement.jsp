<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="guestreglement">

    <center><h2><h:outputText value="Mes règlements : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.tiers.tieraisonsocialenom}" style="color:green;"/></h2></center>

    <a4j:form id="reglements" >

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
                <h:panelGrid columns="5" width="100%">
                    <h:column><h:outputText value="Période Du"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.rechercheReglement}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,tableFrn,tableClt,scrollTable1,scrollTable2,pnlgrttotal"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.pageIndex}" reRender="tableFrn" id="scrollTable1" maxPages="20"align="left" for="tableFrn"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableFrn" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.datamodelReglements}" var="var">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.selectionReglement}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE,pnlgrttotal"/>
                        <rich:column label="Nature" sortable="true" sortBy="#{var.var_lib_nat}" width="130px">
                            <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                            <h:outputText value="#{var.var_lib_nat}"/>
                        </rich:column>
                        <rich:column label="Opération" sortable="true" sortBy="#{var.libelleOperation}" width="130px">
                            <f:facet name="header"><h:outputText  value="Opération" /></f:facet>
                            <h:outputText value="#{var.libelleOperation}"/>
                        </rich:column>
                        <rich:column label="Etat" sortable="true" sortBy="#{var.var_etat}" width="50px">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{var.var_etat}"/>
                        </rich:column>
                        <rich:column label="N°" sortable="true" sortBy="#{var.rglNum}" width="120px" sortOrder="DESCENDING">
                            <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                            <h:outputText value="#{var.rglNum}"/>
                        </rich:column>
                        <rich:column label="N° Origine" sortable="true" sortBy="#{var.rglDocument}" width="80px" >
                            <f:facet name="header"><h:outputText  value="N° Origine" /></f:facet>
                            <h:outputText value="#{var.rglDocument}"/>
                        </rich:column>
                        <rich:column label="Date" sortable="true" sortBy="#{var.rglDateReg}" width="70px" >
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.rglDateReg}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Série" sortable="true" sortBy="#{var.rglSerie}" style="text-align:center;" width="40px">
                            <f:facet name="header"><h:outputText  value="S." /></f:facet>
                            <h:outputText value="#{var.rglSerie}"/>
                        </rich:column>
                         <rich:column label="Recette" sortable="true" sortBy="#{var.val_recette}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Recette"/></f:facet>
                            <h:outputText  value="#{var.val_recette}" rendered="#{var.val_recette!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Dépense" sortable="true" sortBy="#{var.val_depense}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Dépense"/></f:facet>
                            <h:outputText  value="#{var.val_depense}" rendered="#{var.val_depense!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Timbre" sortable="true" sortBy="#{var.rglTimbre}" style="text-align:right;" width="80px">
                            <f:facet name="header"><h:outputText  value="Timbre"/></f:facet>
                            <h:outputText  value="#{var.rglTimbre}" rendered="#{var.rglTimbre!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Type règlement" sortable="true" sortBy="#{var.rglLibTypReg}" width="100px">
                            <f:facet name="header"><h:outputText  value="Type règlement"  /></f:facet>
                            <h:outputText  value="#{var.rglLibTypReg}"/>
                        </rich:column>
                        <rich:column label="Libellé" sortable="true" sortBy="#{var.rglLibelle}" width="200px">
                            <f:facet name="header"><h:outputText value="Libellé"  /></f:facet>
                            <h:outputText  value="#{var.rglLibelle}"/>
                        </rich:column>
                        <rich:column label="Caisse exécutrice" sortable="true" sortBy="#{var.rglLibCaiss}" width="100px" >
                            <f:facet name="header"><h:outputText  value="Exécutrice"  /></f:facet>
                            <h:outputText  value="#{var.rglLibCaiss}"/>
                        </rich:column>
                        <rich:column label="Banque Emettrice" sortable="true" sortBy="#{var.rglLibEmetrice}" width="100px" >
                            <f:facet name="header"><h:outputText  value="Emettrice"  /></f:facet>
                            <h:outputText  value="#{var.rglLibEmetrice}"/>
                        </rich:column>
                        <rich:column label="Banque Réceptrice" sortable="true" sortBy="#{var.rglLibReceptrice}" width="100px" >
                            <f:facet name="header"><h:outputText  value="Réceptrice"  /></f:facet>
                            <h:outputText  value="#{var.rglLibReceptrice}"/>
                        </rich:column>
                        <rich:column label="Activité(s) commerciale(s)" sortable="true" sortBy="#{var.rglActivite}" >
                            <f:facet name="header"><h:outputText value="Activité(s)"  /></f:facet>
                            <h:outputText  value="#{var.rglActivite}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>

            <br/>
            <h:panelGrid id="pnlgrttotal" columns="4" cellspacing="1" styleClass="recherche"  width="100%">
                <h:panelGrid id="pnlgrttotalTTC" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpTTCL" value="Total Dépense" />
                    <h:inputText id="intpTTCL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.montantTtc}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpTTCE" value="Dépense" />
                    <h:inputText id="intpTTCE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.montantTtcElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalRGLMT" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpRGLMTL" value="Total Recette" />
                    <h:inputText id="intpRGLMTL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.montantReglement}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpRGLMTE" value="Recette" />
                    <h:inputText id="intpRGLMTE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.montantReglementElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalSOLD" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpSOLDL" value="Total Timbre" />
                    <h:inputText id="intpSOLDL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formGuest.montantSolde}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpSOLDE" value="Timbre" />
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