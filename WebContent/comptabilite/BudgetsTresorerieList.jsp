<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="saisieBudgetTreso">

    <a4j:form>

        <center> <h2><h:outputText value="SAISIE DU BUDGET DE TRESORERIE" styleClass="titre"/></h2></center>

        <h:panelGrid id="pnRec" width="100%">

            <h:panelGrid id="png1" columns="5" styleClass="recherche" width="100%" >
                <h:panelGroup >
                    <h:outputText value="Année:" />&nbsp;
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.var_annee}" style="width:147px;">
                        <f:selectItem itemLabel="Sélectionnez une année" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.mesAnneeItems}"/>
                        <a4j:support eventsQueue="maQueue"  event="onchange" reRender="png1,rec,table" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.buttonPanel}"/>
                    </h:selectOneMenu>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.projetPresent}">
                    <h:outputText value="Projet du budget:" />&nbsp;
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.var_projet}"  style="width:147px;">
                        <f:selectItem itemLabel="Sélectionnez un projet" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.mesProjetsItems}"/>
                        <a4j:support eventsQueue="maQueue"  event="onchange" reRender="png1,rec,table" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.calculAnneeProjet}"/>
                    </h:selectOneMenu>
                </h:panelGroup>
                <h:panelGroup>
                    <h:outputText value="Réaménagement:" />&nbsp;
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.var_choix_reamenagement}">
                        <f:selectItem itemLabel="Budget Initial" itemValue="0"/>
                        <f:selectItem itemLabel="Réaménagement N° 1" itemValue="1"/>
                        <f:selectItem itemLabel="Réaménagement N° 2" itemValue="2"/>
                        <f:selectItem itemLabel="Réaménagement N° 3" itemValue="3"/>
                        <a4j:support eventsQueue="maQueue"  event="onchange" reRender="png1,rec,table" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.buttonPanel}"/>
                    </h:selectOneMenu>
                </h:panelGroup>
                <h:panelGroup>
                    <a4j:commandButton id="rec" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.recherche}" onclick="javascript:Richfaces.showModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.showButtonRec}" reRender="pnRec,btnBudget,scrollTable,table,modAttente"/>
                </h:panelGroup>
            </h:panelGrid>

            <h:panelGrid  id="btnBudget" style="width:200px" columns="4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.showButtonPanel}">
                <a4j:commandButton image="/images/modifier.png" title="Modifier un réaménagement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.modifierBudget}" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.testaffSupp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.budgetTresorerie.budSens<=4)==true}" reRender="panelSaisie"/>
                <a4j:commandButton image="/images/supprimer.png" title="Supprimer un réaménagement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.supprimerBudget}" reRender="table" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.testaffSupp)==true}"  />
                <a4j:commandButton image="/images/duplicate.png" title="Duppliquer un budget" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.duppliquerBudget}" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.dup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.budtestDupliquer)==true}" oncomplete="javascript:Richfaces.showModalPanel('modPanReamBudget');" />
                <a4j:commandButton image="/images/print.png" title="Imprimer les budgets" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
            </h:panelGrid >

            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.var_nb_max}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.dataModelLesBudgets}" headerClass="headerTab" styleClass="bg" enableContextMenu="false" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" id="table" width="100%"  style="max-height:100%;border:solid 0px black;cursor:pointer;"  var="saisieBudget">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.selectionBudget}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,btnBudget"/>
                    <rich:column sortable="false" width="10%" >
                        <f:facet name="header"><h:outputText  value="Année"/></f:facet>
                        <h:outputText value="#{saisieBudget.budAnnee}" style="#{saisieBudget.espaceFamille}"/>
                    </rich:column>
                    <rich:column sortable="false" width="20%" >
                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                        <h:outputText value="#{saisieBudget.budCode}" style="#{saisieBudget.espaceFamille}"/>
                    </rich:column>
                    <rich:column width="50%"  >
                        <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                        <h:outputText value="#{saisieBudget.budLibelleFr}" style="#{saisieBudget.espaceFamille}"/>
                    </rich:column >
                    <rich:column style="text-align:right;" width="10%" >
                        <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                        <h:outputText value="#{saisieBudget.montant}" rendered="#{saisieBudget.montant!=0}" style="#{saisieBudget.espaceFamilleLight}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>

        </h:panelGrid>
    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelSaisie"  width="1200" height="600" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.showModalPanelSaisie}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.showModalPanelSaisie}" var="bud">
            <f:facet name="header"><h:outputText value="SAISIE DU BUDGET DE TRESORERIE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.annulerBudget}" image="/images/close.gif" styleClass="hidelink" reRender="panelSaisie"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid id="calcul" width="100%">
                    <h:panelGrid columns="6" columnClasses="clos12d,clos12d,clos12d,clos12d,clos12d,clos40" width="100%" headerClass="headerTab">
                        <h:column><h:outputText value="Année:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.var_annee}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Réaménagement:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.budgetTresorerie.lib_reamenagement}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Libellé poste:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.budgetTresorerie.budCode} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.budgetTresorerie.budLibelleFr}" readonly="true" style="width:100%"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="3" id="boutonLigne" style="width:150px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.showButtonPanel}">
                        <a4j:commandButton image="/images/ajouter.png" title="Ajouter une analytique" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.ajouterLigne}" reRender="panelSaisieModif,idPanModif"/>
                        <a4j:commandButton image="/images/modifier.png" title="Modifier une analytique" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.modifierLigne}" reRender="panelSaisieModif,idPanModif"/>
                        <a4j:commandButton image="/images/supprimer.png" title="Supprimer tout le détail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.supprimerLigne}" reRender="panMontant,tableVal,idMontantGlobal,panQte,tableQte,idQteGlobal" onclick="if (!confirm('Etes vous sur de vouloir supprimer le détail du budget?')) return false"/>
                    </h:panelGrid>
                    <h:panelGrid columns="2" width="100%" columnClasses="clos50,clos50">
                        <rich:tabPanel switchType="client" immediate="true"  style="width:100%;border:0px;" id="panGlob">

                            <rich:tab label="Ventilation du montant">
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.selectionMontant}" reRender="panMontant"/>
                                <h:panelGrid id="panMontant" width="100%">
                                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" headerClass="headerTab">
                                        <h:column rendered="false"><h:outputText value="Montant global:"/></h:column>
                                        <h:column rendered="false">
                                            <h:inputText id="idMontantGlobal" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.montantTotal}" style="text-align:right;">
                                                <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.calculeRepartitionMontant}"  reRender="calcul,repartitionMontant" event="onblur"/>
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.dataModelLesBudgetsLigne}" headerClass="headerTab" styleClass="bg" enableContextMenu="false" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" id="tableVal" width="100%" height="300px" style="border:solid 0px black;cursor:pointer;"  var="ligne" >
                                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.selectionBudgetLigne}" />
                                            <rich:column style="text-align:right;" width="7%" >
                                                <f:facet name="header"><h:outputText  value="Total" /></f:facet>
                                                <h:outputText value="#{ligne.ligvalTotal}" rendered="#{ligne.ligvalTotal!=0}"  >
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column style="text-align:right;" width="7%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_janvier}">
                                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_janvier}" /></f:facet>
                                                <h:outputText value="#{ligne.ligval01}" rendered="#{ligne.ligval01!=0}"  >
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column style="text-align:right;" width="7%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_fevrier}">
                                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_fevrier}" /></f:facet>
                                                <h:outputText value="#{ligne.ligval02}" rendered="#{ligne.ligval02!=0}"  >
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column style="text-align:right;" width="7%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_mars}">
                                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_mars}" /></f:facet>
                                                <h:outputText value="#{ligne.ligval03}" rendered="#{ligne.ligval03!=0}"  >
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column style="text-align:right;" width="7%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_avril}">
                                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_avril}" /></f:facet>
                                                <h:outputText value="#{ligne.ligval04}" rendered="#{ligne.ligval04!=0}"  >
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column style="text-align:right;" width="7%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_mai}">
                                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_mai}" /></f:facet>
                                                <h:outputText value="#{ligne.ligval05}" rendered="#{ligne.ligval05!=0}"  >
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column style="text-align:right;" width="7%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_juin}">
                                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_juin}" /></f:facet>
                                                <h:outputText value="#{ligne.ligval06}" rendered="#{ligne.ligval06!=0}"  >
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column style="text-align:right;" width="7%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_juillet}">
                                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_juillet}" /></f:facet>
                                                <h:outputText value="#{ligne.ligval07}" rendered="#{ligne.ligval07!=0}"  >
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column style="text-align:right;" width="7%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_aout}">
                                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_aout}" /></f:facet>
                                                <h:outputText value="#{ligne.ligval08}" rendered="#{ligne.ligval08!=0}"  >
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column style="text-align:right;" width="7%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_septembre}">
                                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_septembre}" /></f:facet>
                                                <h:outputText value="#{ligne.ligval09}" rendered="#{ligne.ligval09!=0}"  >
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column style="text-align:right;" width="7%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_octobre}">
                                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_octobre}" /></f:facet>
                                                <h:outputText value="#{ligne.ligval10}" rendered="#{ligne.ligval10!=0}"  >
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column style="text-align:right;" width="7%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_novembre}">
                                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_novembre}" /></f:facet>
                                                <h:outputText value="#{ligne.ligval11}" rendered="#{ligne.ligval11!=0}"  >
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column style="text-align:right;" width="7%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_decembre}">
                                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_decembre}" /></f:facet>
                                                <h:outputText value="#{ligne.ligval12}" rendered="#{ligne.ligval12!=0}"  >
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:panelGrid>
                            </rich:tab>

                        </rich:tabPanel>
                    </h:panelGrid>
                </h:panelGrid>
                <br><br>
                <center>
                    <h:panelGroup >
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.validerBudget}" reRender="table,panelSaisie" style="text-decoration:none;" id="idVal"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelSaisieModif"  width="900" height="250" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.showModalPanelModif}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.showModalPanelModif}" var="modbud">
            <f:facet name="header">
                <h:panelGroup><h:outputText value="MODIFICATION DU BUDGET"></h:outputText></h:panelGroup>
            </f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.annulerModification}" image="/images/close.gif" styleClass="hidelink" reRender="panelSaisieModif"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="idPanModif">
                <h:panelGrid id="calcul" width="100%">
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" headerClass="headerTab" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.testactivite}">
                        <f:facet name="header"><h:outputText value="Définition du poste"/></f:facet>
                        <h:column><h:outputText value="Activité:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.budgetTresorerieLigne.budligActivite}">
                                <f:selectItem itemLabel="" itemValue=""/>
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.mesActivitesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" headerClass="headerTab">
                        <f:facet name="header"><h:outputText value="Définition du montant annuel"/></f:facet>
                        <h:column><h:outputText value="Montant"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.montantTotal}" style="text-align:right;">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.calculeRepartitionMontant}" reRender="calcul,repartitionMontant"/>
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" headerClass="headerTab" width="100%" id="repartitionMontant">
                        <f:facet name="header"><h:outputText value="Ventilation du montant"/></f:facet>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_janvier}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_janvier}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_janvier}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.val01}" size="10" style="text-align:right">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_fevrier}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_fevrier}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_fevrier}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.val02}" size="10" style="text-align:right">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_mars}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_mars}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_mars}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.val03}" size="10" style="text-align:right">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_avril}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_avril}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_avril}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.val04}" size="10" style="text-align:right">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_mai}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_mai}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_mai}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.val05}" size="10" style="text-align:right">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_juin}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_juin}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_juin}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.val06}" size="10" style="text-align:right">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_juillet}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_juillet}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_juillet}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.val07}" size="10" style="text-align:right">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_aout}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_aout}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_aout}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.val08}" size="10" style="text-align:right">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_septembre}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_septembre}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_septembre}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.val09}" size="10" style="text-align:right">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_octobre}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_octobre}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_octobre}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.val10}" size="10" style="text-align:right">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_novembre}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_novembre}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_novembre}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.val11}" size="10" style="text-align:right">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_decembre}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.lib_decembre}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.aff_decembre}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.val12}" size="10" style="text-align:right">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br><br>
                <center>
                    <h:panelGrid>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.valideModification}" style="text-decoration:none;" id="valModif" />
                    </h:panelGrid>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="350" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudgetTresorerie.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitationComptabilite.jsp"/>
        </c:if>
    </rich:modalPanel>

</f:subview>
