<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelDetailPieceClasse">

    <center>
        <h2>
            <h:outputText value="EXTRAIT DE COMPTE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.planComptable.plcCompte} - #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.planComptable.plcLibelleCpteFR}" styleClass="titre"/>
            <h:outputText value="Modification/Visualisation de la pièce N° #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.ecritures.ecrPiece}"/>
        </h2>
    </center>
    <a4j:form  id="FormPiece">
        <h:panelGrid width="100%" style="text-align:left;">
            <h:panelGrid id="panTotalExtrait" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g" styleClass="fichefournisseur1">
                <h:column><h:outputText value="Total débit:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.var_tot_debit}" style="text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Total crédit:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.var_tot_credit}" style="text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Solde:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.var_solde}" style="text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
            </h:panelGrid>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="pclisteId"  height="350px" width="100%" headerClass="headerTab" selectedClass="active-row" var="detEcr" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.dataModelDetailPiece}" >
                    <a4j:support eventsQueue="maQueue" event="onRowclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.selectionPiece}"/>
                    <rich:column width="5%" sortable="false">
                        <h:commandButton rendered="#{detEcr.nbrEcrLettrage==false}" title="Modification écriture" image="/images/modifier.png" style="width:20px;height:20px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.modifierEcriture}"/>
                    </rich:column>
                    <rich:column width="5%" sortable="true" sortBy="#{detEcr.ecrCode}" label="Journal">
                        <f:facet name="header"><h:outputText  value="Jr." /></f:facet>
                        <h:outputText value="#{detEcr.ecrCode}">
                        </h:outputText>
                    </rich:column>
                    <rich:column width="6%" sortable="true" sortBy="#{detEcr.ecrDateSaisie}" label="Date de saisie">
                        <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                        <h:outputText value="#{detEcr.ecrDateSaisie}">
                            <f:convertDateTime pattern="dd/MM/yy"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column width="9%" sortable="true" sortBy="#{detEcr.ecrCompte}" label="N° compte">
                        <f:facet name="header"><h:outputText  value="Compte"  /></f:facet>
                        <h:outputText value="#{detEcr.ecrCompte}" >
                        </h:outputText>
                    </rich:column>
                    <rich:column width="9%" sortable="true" sortBy="#{detEcr.ecrPiece}" label="N° Pièce">
                        <f:facet name="header"><h:outputText value="Pièce" /></f:facet>
                        <h:outputText value="#{detEcr.ecrPiece}" >
                        </h:outputText>
                    </rich:column>
                    <rich:column  width="9%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.optionComptabilite.testRef1Piece}" sortable="true" sortBy="#{detEcr.ecrReference1}" label="Référence 1">
                        <f:facet name="header"><h:outputText  value="Réf.1"/></f:facet>
                        <h:outputText value="#{detEcr.ecrReference1}" >
                        </h:outputText>
                    </rich:column>
                    <rich:column width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.optionComptabilite.testRef2Piece}" sortable="true" sortBy="#{detEcr.ecrReference2}" label="Référence 2">
                        <f:facet name="header"><h:outputText  value="Réf.2"/></f:facet>
                        <h:outputText value="#{detEcr.ecrReference2}">
                        </h:outputText>
                    </rich:column>
                    <rich:column width="5%"  sortable="true" sortBy="#{detEcr.ecrLettrage}" label="Lettrage">
                        <f:facet name="header"><h:outputText  value="L."/></f:facet>
                        <h:outputText value="#{detEcr.ecrLettrage}" >
                        </h:outputText>
                    </rich:column>
                    <rich:column width="4%" sortable="true" sortBy="#{detEcr.ecrPointage}" label="Pointage">
                        <f:facet name="header"><h:outputText  value="P."/></f:facet>
                        <h:outputText value="#{detEcr.ecrPointage}" >
                        </h:outputText>
                    </rich:column>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.planComptable.plcNature==6||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.planComptable.plcNature==7}">
                        <rich:column width="6%" sortable="true" sortBy="#{detEcr.ecrDateEcheance}" label="Date d'échéance">
                            <f:facet name="header"><h:outputText  value="Eché." /></f:facet>
                            <h:outputText value="#{detEcr.ecrDateEcheance}">
                                <f:convertDateTime pattern="dd/MM/yy"/>
                            </h:outputText>
                        </rich:column>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.planComptable.plcNature==10||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.planComptable.plcNature==11}">
                        <rich:column width="6%" sortable="true" sortBy="#{detEcr.ecrDateValeurTheo}"label="Date de valeur">
                            <f:facet name="header"><h:outputText value="Valeur" /> </f:facet>
                            <h:outputText value="#{detEcr.ecrDateValeurTheo}"  >
                                <f:convertDateTime pattern="dd/MM/yy"/>
                            </h:outputText>
                        </rich:column>
                    </c:if>
                    <rich:column width="10%" style="text-align:right;" sortable="true" sortBy="#{detEcr.ecrDebitPays}" label="Débit">
                        <f:facet name="header"><h:outputText  value="Débit" /></f:facet>
                        <h:outputText   value="#{detEcr.ecrDebitPays}" rendered="#{detEcr.ecrDebitPays!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column width="10%"  style="text-align:right;" sortable="true" sortBy="#{detEcr.ecrCreditPays}"label="Crédit">
                        <f:facet name="header"><h:outputText  value="Crédit" /></f:facet>
                        <h:outputText value="#{detEcr.ecrCreditPays}" rendered="#{detEcr.ecrCreditPays!=0}" >
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column width="24%" sortable="true" sortBy="#{detEcr.ecrLibelle}" label="Libellé">
                        <f:facet name="header"><h:outputText value="Libellé" /></f:facet>
                        <h:outputText value="#{detEcr.ecrLibelle}" >
                        </h:outputText>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </h:panelGrid>

        <h:panelGroup>
            <center>
                <a4j:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.fermerDetailPiece}" reRender="idSubView"/>
            </center>
        </h:panelGroup>

    </a4j:form>

</f:subview>