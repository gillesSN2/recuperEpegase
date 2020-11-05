<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelDetailPiece">

    <center>
        <h2>
            <h:outputText value="EXTRAIT DE COMPTE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.planComptable.plcCompte} - #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.planComptable.plcLibelleCpteFR}" styleClass="titre"/>
            <h:outputText value="Modification/Visualisation de la pièce N° #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecrituresDetail.ecrPiece}"/>
        </h2>
    </center>
    <a4j:form  id="FormPiece">
        <h:panelGrid width="100%" style="text-align:left;">
            <h:panelGrid id="panTotalExtrait" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g" styleClass="fichefournisseur1">
                <h:column><h:outputText value="Total débit:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.var_tot_debit}" style="text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Total crédit:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.var_tot_credit}" style="text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Solde:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.var_solde}" style="text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
            </h:panelGrid>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="pclisteId"  height="350px" width="100%" headerClass="headerTab" selectedClass="active-row" var="detEcr" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.dataModelDetailPiece}" >
                    <a4j:support eventsQueue="maQueue" event="onRowclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.selectionPiece}"/>
                    <rich:column width="5%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAccesCorrection==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.testAffOutilsCorr}">
                        <a4j:commandButton title="Modification écriture" image="/images/modifier.png" style="width:20px;height:20px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.modifierEcriture}" reRender="panelModifEcriture"/>
                    </rich:column>
                    <rich:column width="5%" sortable="true" sortBy="#{detEcr.ecrCode}" label="Journal">
                        <f:facet name="header"><h:outputText  value="Jr." /></f:facet>
                        <h:outputText value="#{detEcr.ecrCode}" title="#{detEcr.ecrCode}">
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
                        <h:outputText value="#{detEcr.ecrCompte}" title="#{detEcr.ecrCompte}">
                        </h:outputText>
                    </rich:column>
                    <rich:column width="9%" sortable="true" sortBy="#{detEcr.ecrPiece}" label="N° Pièce">
                        <f:facet name="header"><h:outputText value="Pièce" /></f:facet>
                        <h:outputText value="#{detEcr.ecrPiece}" title="#{detEcr.ecrPiece}">
                        </h:outputText>
                    </rich:column>
                    <rich:column  width="9%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.optionComptabilite.testRef1Piece}" sortable="true" sortBy="#{detEcr.ecrReference1}" label="Référence 1">
                        <f:facet name="header"><h:outputText  value="Réf.1"/></f:facet>
                        <h:outputText value="#{detEcr.ecrReference1}" title="#{detEcr.ecrReference1}">
                        </h:outputText>
                    </rich:column>
                    <rich:column width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.optionComptabilite.testRef2Piece}" sortable="true" sortBy="#{detEcr.ecrReference2}" label="Référence 2">
                        <f:facet name="header"><h:outputText  value="Réf.2"/></f:facet>
                        <h:outputText value="#{detEcr.ecrReference2}" title="#{detEcr.ecrReference2}">
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
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.planComptable.plcNature==6||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.planComptable.plcNature==7}">
                        <rich:column width="6%" sortable="true" sortBy="#{detEcr.ecrDateEcheance}" label="Date d'échéance">
                            <f:facet name="header"><h:outputText  value="Eché." /></f:facet>
                            <h:outputText value="#{detEcr.ecrDateEcheance}">
                                <f:convertDateTime pattern="dd/MM/yy"/>
                            </h:outputText>
                        </rich:column>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.planComptable.plcNature==10||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.planComptable.plcNature==11}">
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
                        <h:outputText value="#{detEcr.ecrLibelle}" title="#{detEcr.ecrLibelle}">
                        </h:outputText>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </h:panelGrid>

        <h:panelGroup>
            <center>
                <a4j:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.fermerDetailPiece}" reRender="idSubView"/>
            </center>
        </h:panelGroup>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelModifEcriture" headerClass="headerPanel" styleClass="bg"style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="800" height="300"  showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelModifPiece}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.showModalPanelModifPiece}" var="mdp">
            <f:facet name="header"><h:outputText value="Modification de la ligne"/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton image="/images/close.gif" styleClass="hidelink" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.fermerModifierPiece}" id="idCancelModif" reRender="panelModifEcriture" style="text-decoration:none;"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCancelModif')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form  id="Form" >
                <rich:panel style="width:100%;border:0px;">
                    <h:panelGrid border="0" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Date:" /></h:column>
                        <h:column><rich:calendar style=" background-color:white;" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecrituresDetail.ecrDateSaisie}"  enableManualInput="true" datePattern="dd/MM/yyyy"  inputSize="17" disabled="true" readonly="true"/></h:column>
                        <h:column><h:outputText value="Journal:" /></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecrituresDetail.ecrCode}" disabled="true" readonly="true"/></h:column>
                        <h:column><h:outputText value="Compte:" /></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecrituresDetail.ecrCompte}" disabled="true" readonly="true"/></h:column>
                        <h:column><h:outputText value="Pièce:" /></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecrituresDetail.ecrPiece}" disabled="true" readonly="true"/></h:column>
                        <h:column><h:outputText value="Débit:" /></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecrituresDetail.ecrDebitSaisie}" style="text-align:right;" disabled="true" readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Crédit:" /></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecrituresDetail.ecrCreditSaisie}" style="text-align:right;" disabled="true" readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <br/>
                    <h:panelGrid border="0" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Libellé:" /></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecrituresDetail.ecrLibelle}" maxlength="100" style="width:100%"/></h:column>
                        <h:column><h:outputText value="Référence 1:" /></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecrituresDetail.ecrReference1}" maxlength="30" style="width:100%"/></h:column>
                        <h:column><h:outputText value="Référence 2:" /></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecrituresDetail.ecrReference2}" maxlength="30" style="width:100%"/></h:column>
                    </h:panelGrid>
                    <br/>
                    <h:panelGrid id="idBudgetTresoProjet" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.optionComptabilite.tresorerie=='true'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.afficheBudgetTresoProjet}" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur">
                        <h:outputText value="Poste:" styleClass="textAligneOutTable"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecrituresDetail.ecrPosteTreso}" size="7" onkeypress="return scanToucheLettre(event)">
                            <rich:toolTip id="tooladdBudgetProjet" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez un poste de budget de trésorerie ou * puis tabulez" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.rechercheBudgetTresorerie}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeBudgetTresorerie,formModalListeBudgetTresorerie,idBudgetTresoProjet"/>
                        </h:inputText>
                        <h:outputText value="Budget:" styleClass="textAligneOutTable"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecrituresDetail.ecrBudgetTreso}" size="7" readonly="true" disabled="true"/>
                    </h:panelGrid>
                    <h:panelGrid id="idBudgetTresoStandard" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.optionComptabilite.tresorerie=='true'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.afficheBudgetTresoStandard}" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur">
                        <h:outputText value="Tréso.:" styleClass="textAligneOutTable"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.ecrituresDetail.ecrTreso}" size="10" onkeypress="return scanToucheLettre(event)">
                            <rich:toolTip id="tooladdBudgetStandard" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez un poste de budget de trésorerie ou * puis tabulez" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.rechercheBudgetTresorerie}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeBudgetTresorerie,formModalListeBudgetTresorerie,idBudgetTresoStandard"/>
                        </h:inputText>
                    </h:panelGrid>
                    <br/>
                    <h:panelGroup>
                        <center>
                            <h:commandButton  image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.vaiderModifierEcriture}" id="idValModif" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            <rich:hotKey key="return" handler="#{rich:element('idValModif')}.click()" />
                        </center>
                    </h:panelGroup>
                </rich:panel>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>