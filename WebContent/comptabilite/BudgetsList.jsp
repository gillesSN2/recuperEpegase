<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="Sb">

    <a4j:form>

        <center> <h2><h:outputText value="SAISIE DU BUDGET" styleClass="titre"/></h2></center>

        <h:panelGrid id="pnRec" width="100%">

            <h:panelGrid id="png1" columns="6" styleClass="recherche" width="100%" >
                <h:panelGroup>
                    <h:outputText value="Année:" />&nbsp;
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.var_annee}" style="width:147px;">
                        <f:selectItem itemLabel="Sélectionnez une année" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.mesAnneeItems}"/>
                        <a4j:support eventsQueue="maQueue"  event="onchange" reRender="pnRec,png1,rec,table,btnBudgetEntite,idBouton" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.buttonPanel}"/>
                    </h:selectOneMenu>
                </h:panelGroup>
                <h:panelGroup>
                    <h:outputText value="Nature du budget:" />&nbsp;
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.var_nature}"  style="width:147px;"  >
                        <f:selectItem itemLabel="Sélectionnez une nature" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.mesTypesItems}"/>
                        <a4j:support eventsQueue="maQueue"  event="onchange" reRender="pnRec,png1,rec,table,btnBudgetEntite,idBouton" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.buttonPanel}"/>
                    </h:selectOneMenu>
                </h:panelGroup>
                <h:panelGroup>
                    <h:outputText value="Réaménagement:" />&nbsp;
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.var_choix_reamenagement}">
                        <f:selectItem itemLabel="Budget Initial" itemValue="0"/>
                        <f:selectItem itemLabel="Réaménagement N° 1" itemValue="1"/>
                        <f:selectItem itemLabel="Réaménagement N° 2" itemValue="2"/>
                        <f:selectItem itemLabel="Réaménagement N° 3" itemValue="3"/>
                        <a4j:support eventsQueue="maQueue"  event="onchange" reRender="pnRec,png1,rec,table,btnBudgetEntite,idBouton" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.buttonPanel}"/>
                    </h:selectOneMenu>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.afficheEntite}">
                    <h:outputText value="Entités:" />&nbsp;
                    <h:selectOneMenu id="idListeEntites" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.var_choix_entite}">
                        <f:selectItem itemLabel="Toutes entités" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.mesEntitesItems}"/>
                    </h:selectOneMenu>
                </h:panelGroup>
                <h:panelGroup>
                    <a4j:commandButton id="rec" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.recherche}" onclick="javascript:Richfaces.showModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.showButtonRec}" reRender="pnRec,btnBudget,scrollTable,table,idBouton,modAttente"/>
                </h:panelGroup>
            </h:panelGrid>

            <h:panelGrid columns="2" id="idBouton">
                <h:panelGrid id="btnBudget" style="width:250px" columns="5" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.showButtonPanel}">
                    <a4j:commandButton image="/images/modifier.png" title="Modifier un réaménagement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.modifierBudget}" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.testaffSupp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.budget.budType<=4)==true}" reRender="panelSaisieLigne,formAnal"/>
                    <a4j:commandButton image="/images/supprimer.png" title="Supprimer un réaménagement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.supprimerBudget}" reRender="table" onclick="if (!confirm('Etes vous sur de vouloir supprimer toutes les lignes de ce budget?')) return false" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.testaffSupp)==true}"/>
                    <a4j:commandButton image="/images/duplicate.png" title="Duppliquer un budget vers l'année suivante" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.duppliquerBudget}" reRender="table" onclick="if (!confirm('Etes vous sur de vouloir duppliquer vers l`exercice suivant?')) return false" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.dup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.budtestDupliquer)==true}"/>
                    <a4j:commandButton image="/images/print.png" title="Imprimer les budgets" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                </h:panelGrid>
                <h:panelGrid  id="btnBudgetEntite" style="width:200px;border:1px solid green;" columns="4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.showButtonPanel&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.budget.budType==15}">
                    <h:outputText value="ENTITE:" style="color:red;font-weight:bold"/>
                    <a4j:commandButton image="/images/modifier.png" title="Modifier libellé de l'entité du budget" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.modifierEntiteBudget}" reRender="panelEntite" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.dup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.budtestDupliquer)==true}"/>
                    <a4j:commandButton image="/images/duplicate.png" title="Duppliquer l'entité du budget" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.duppliquerEntiteBudget}" onclick="if (!confirm('Etes vous sur de vouloir duppliquer l`identité sélectionnée?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,table,btnBudgetEntite,idBouton,png1,idListeEntites,pnRec" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.dup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.budtestDupliquer)==true}"/>
                    <a4j:commandButton image="/images/supprimer.png" title="Supprimer un réaménagement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.supprimerEntiteBudget}" onclick="if (!confirm('Etes vous sur de vouloir supprimer tous les postes de l`identite sélectionnée?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,table,btnBudgetEntite,idBouton,png1,idListeEntites,pnRec" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.testaffSupp)==true}"  />
                </h:panelGrid>
            </h:panelGrid>

            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.var_nb_max}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.dataModelLesBudgets}" headerClass="headerTab" styleClass="bg" enableContextMenu="false" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" id="table" width="100%"  style="max-height:100%;border:solid 0px black;cursor:pointer;"  var="saisieBudget">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.selectionBudget}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idBouton,btnBudget,btnBudgetEntite"/>
                    <rich:column sortable="false" width="10%">
                        <f:facet name="header"><h:outputText  value="Année" /></f:facet>
                        <h:outputText value="#{saisieBudget.budAnnee}" style="#{saisieBudget.espaceFamille}"/>
                    </rich:column>
                    <rich:column sortable="false" width="20%">
                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                        <h:outputText value="#{saisieBudget.budCode}" style="#{saisieBudget.espaceFamille}"/>
                    </rich:column>
                    <rich:column width="40%">
                        <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                        <h:outputText value="#{saisieBudget.budLibelleFr}" style="#{saisieBudget.espaceFamille}"/>
                    </rich:column >
                    <rich:column style="text-align:right;" width="20%" >
                        <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                        <h:outputText value="#{saisieBudget.montant}" rendered="#{saisieBudget.montant!=0}" style="#{saisieBudget.espaceFamilleLight}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column style="text-align:right;" width="10%">
                        <f:facet name="header"><h:outputText  value="Qte" /></f:facet>
                        <h:outputText value="#{saisieBudget.qte}" rendered="#{saisieBudget.qte!=0}" style="#{saisieBudget.espaceFamilleLight}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>

        </h:panelGrid>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent" headerClass="headerPanel" id="panelSaisieLigne"  width="1200" height="300" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.showModalPanelDetail}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.showModalPanelDetail}" var="det">
            <f:facet name="header"><h:outputText value="DETAIL DU POSTE BUDGETAIRE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.annulerBudget}" image="/images/close.gif" styleClass="hidelink" reRender="panelSaisieLigne"/>
                </a4j:form>
            </f:facet>
            <jsp:include flush="true" page="../commun/analytiqueBudget.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelRecherche" width="900" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.showModalPanelRecherche}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.showModalPanelRecherche}" var="rec">
            <f:facet name="header"><h:outputText value="LISTE DES #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.libelleRecherche}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.annulerRecherche}" image="/images/close.gif" styleClass="hidelink" reRender="panelRecherche,idDossier1,idDossier2,idMission1,idMission2,idChantier1,idChantier2,idParc1,idParc2,idAgent1,idAgent2,idProjet1,idProjet2"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableRecherche"  height="400px" width="100%" headerClass="headerTab" selectedClass="active-row" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.dataModelRecherche}" var="rec">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.selectionRecherche}" reRender="idValSelectObjet"/>
                        <rich:column  width="20%" >
                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                            <h:outputText value="#{rec.code}"/>
                        </rich:column>
                        <rich:column  width="80%"  >
                            <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                            <h:outputText value="#{rec.nom_FR}" />
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br><br>
                <center>
                    <h:panelGroup id="idValSelectObjet">
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.valideRecherche}" image="/images/valider_big.png" styleClass="hidelink" reRender="panelRecherche,idDossier1,idDossier2,idMission1,idMission2,idChantier1,idChantier2,idParc1,idParc2,idAgent1,idAgent2,idProjet1,idProjet2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.selectObjet}"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" headerClass="headerPanel" id="panelEntite"  width="700" height="200" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.showModalPanelEntite}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.showModalPanelEntite}" var="det">
            <f:facet name="header"><h:outputText value="MODIFICATION D'UNE ENTITE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.annulerEntite}" image="/images/close.gif" styleClass="hidelink" reRender="panelEntite"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" headerClass="headerTab">
                    <h:column><h:outputText value="Libellé entité:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.budget.budLibelleFr}" style="100%" maxlength="100"/></h:column>
                </h:panelGrid>
                <br><br>
                <center>
                    <h:panelGroup id="idValEntite">
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.validerEntite}" image="/images/valider_big.png" styleClass="hidelink" reRender="panelEntite,table"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="350" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitationComptabilite.jsp"/>
        </c:if>
    </rich:modalPanel>

</f:subview>
