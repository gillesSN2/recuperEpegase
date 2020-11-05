<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="medicNettoyage">

    <center> <h2><h:outputText value="NETTOYAGE QUOTIDIEN" style="color:green;"/></h2></center>

    <a4j:form id="test">
        <rich:hotKey key="return" handler="return true;"/>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid  columns="6" styleClass="recherche" width="100%" id="boutons">
                <h:column><h:outputText value="Du:"/></h:column>
                <h:column><rich:calendar inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.dateDebut}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                <h:column><h:outputText value="Au:"/></h:column>
                <h:column><rich:calendar inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.dateFin}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                <h:column>
                    <h:selectOneMenu id="idEtat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.inpEtat}" style="width:200px;">
                        <f:selectItem itemLabel="Tous Etats hors Annulé" itemValue="100"/>
                        <f:selectItem itemLabel="En cours" itemValue="0"/>
                        <f:selectItem itemLabel="Validé" itemValue="1"/>
                        <f:selectItem itemLabel="Gelé" itemValue="2"/>
                        <f:selectItem itemLabel="Annulé" itemValue="3"/>
                        <f:selectItem itemLabel="Controle facture/paiement" itemValue="10"/>
                        <f:selectItem itemLabel="Controle reçu/facture" itemValue="11"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="test,documentGlobal,panelBoutonTrf,table,scrollTable,pnlgrttotal"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.chargerNettoyage}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttentetest,documentGlobal,panelBoutonTrf,table,scrollTable,pnlgrttotal"/>
                    <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                </h:column>
            </h:panelGrid>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="200" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0"  width="150%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.dataModelDocument}"  var="var">
                        <rich:column label="Sélection" sortable="true" sortBy="#{var.docSelect}" width="50px">
                            <f:facet name="header"><h:outputText  value="Sel." /></f:facet>
                            <h:selectBooleanCheckbox value="#{var.docSelect}" rendered="#{var.docTotReglement==0}"/>
                        </rich:column>
                        <rich:column label="Nature" sortable="true" sortBy="#{var.var_lib_nat}" sortOrder="DESCENDING" width="150px">
                            <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                            <h:outputText value="#{var.var_lib_nat}"/>
                        </rich:column>
                        <rich:column label="Etat document" sortable="true" sortBy="#{var.docLibelleEtat}" width="50px">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{var.docLibelleEtat}"/>
                        </rich:column>
                        <rich:column label="Numéro document" sortable="true" sortBy="#{var.docNum}" width="110px">
                            <f:facet name="header"><h:outputText  value="Num." /></f:facet>
                            <h:outputText value="#{var.docNum}"/>
                        </rich:column>
                        <rich:column label="Date" sortable="true" sortBy="#{var.docDate}" width="70px" >
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.docDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Série" sortable="true" sortBy="#{var.docSerie}" style="text-align:center;" width="40px">
                            <f:facet name="header"><h:outputText  value="S." /></f:facet>
                            <h:outputText value="#{var.docSerie}"/>
                        </rich:column>
                        <rich:column label="Dossier" sortable="true" sortBy="#{var.docBudget}" width="100px">
                            <f:facet name="header"><h:outputText  value="Dossier"  /></f:facet>
                            <h:outputText  value="#{var.docBudget}"/>
                        </rich:column>
                        <rich:column label="Tiers" sortable="true" sortBy="#{var.docNomTiers}" width="300px">
                            <f:facet name="header"><h:outputText  value="Client"  /></f:facet>
                            <h:outputText  value="#{var.docNomTiers}"/>
                        </rich:column>
                        <rich:column label="Part Patient" sortable="true" sortBy="#{var.docTotTtc}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.inpEtat!=10&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.inpEtat!=11}">
                            <f:facet name="header"><h:outputText value="Patient"  /></f:facet>
                            <h:outputText  value="#{var.docTotTtc}" rendered="#{var.docTotTtc!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Règlements" sortable="true" sortBy="#{var.docTotReglement}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.inpEtat!=10&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.inpEtat!=11}">
                            <f:facet name="header"><h:outputText value="Régl."  /></f:facet>
                            <h:outputText  value="#{var.docTotReglement}" rendered="#{var.docTotReglement!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Part Patient entete" sortable="true" sortBy="#{var.docTotTtc}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.inpEtat==10||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.inpEtat==11}">
                            <f:facet name="header"><h:outputText value="Pat.Ent"  /></f:facet>
                            <h:outputText  value="#{var.docTotTtc}" rendered="#{var.docTotTtc!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Part Patient ligne" sortable="true" sortBy="#{var.docTotTc}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.inpEtat==10||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.inpEtat==11}">
                            <f:facet name="header"><h:outputText value="Pat.Lig"  /></f:facet>
                            <h:outputText  value="#{var.docTotTc}" rendered="#{var.docTotTc!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Règlements Actes" sortable="true" sortBy="#{var.docTotTva}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.inpEtat==10||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.inpEtat==11}">
                            <f:facet name="header"><h:outputText value="Régl.Act"  /></f:facet>
                            <h:outputText  value="#{var.docTotTva}" rendered="#{var.docTotTva!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Règlements Caisse" sortable="true" sortBy="#{var.docTotReglement}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.inpEtat==10||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.inpEtat==11}">
                            <f:facet name="header"><h:outputText value="Régl.Cais."  /></f:facet>
                            <h:outputText  value="#{var.docTotReglement}" rendered="#{var.docTotReglement!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Service" sortable="true" sortBy="#{var.docService}" width="200px">
                            <f:facet name="header"><h:outputText value="Service"  /></f:facet>
                            <h:outputText  value="#{var.docService}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
            <br>
            <h:panelGroup id="panelBoutonTrf" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.inpEtat!='10'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.inpEtat!=11}">
                <center>
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.selectionAll}" value="Tout sélectionner" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.deSelectionAll}" value="Tout dé-sélectionner" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <h:commandButton onclick="if (!confirm('Etes-vous sur de vouloir nettoyer les éléments sélectionnés ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.applicationNettoyage}" value="Nettoyage" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:200px;"/>
                </center>
            </h:panelGroup>
            <h:panelGrid id="pnlgrttotal" columns="4" cellspacing="1" styleClass="recherche"  width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.inpEtat=='10'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.inpEtat==11}">
                <h:panelGrid columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText value="Total Patient entete" />
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.totalEntete}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText value="Total Patient ligne" />
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.totalLigne}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText value="Total Regl. acte" />
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.reglActe}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText value="Total Regl. Caisse" />
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.reglCaisse}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
            </h:panelGrid>
            <br>
            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.inpEtat!='10'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.inpEtat!=11}">
                <center>
                    <h:outputText value="DETAIL DES OPERATIONS:" style="color:red"/>&nbsp;&nbsp;&nbsp;
                    <h:outputText value="Les factures non payées: elles sont ANNULEES" style="color:red"/>&nbsp;&nbsp;&nbsp;
                    <h:outputText value="Les factures payées partiellement: la partie non payée est mise à 0" style="color:red"/>&nbsp;&nbsp;&nbsp;
                    <h:outputText value="Les bons d`encaissement non exécutés: ils sont détruits" style="color:red"/>&nbsp;&nbsp;&nbsp;
                    <h:outputText value="Les devis: ils sont détruits" style="color:red"/>&nbsp;&nbsp;&nbsp;
                </center>
            </h:panelGroup>
        </center>

    </a4j:form>

</f:subview>
