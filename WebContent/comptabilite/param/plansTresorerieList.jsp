<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="pt">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DU PLAN DE TRESORERIE" style="color:green;font-size:16px;"/></h2></center>

        <h:panelGrid  id="pnRec" width="100%">
            <h:panelGrid id="png1" columns="3" styleClass="recherche"  width="100%" >
                <h:panelGroup>
                    <h:outputText value="Année:"/>&nbsp;
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.var_annee}" style="width:147px;" >
                        <f:selectItem itemLabel="Sélectionnez une année" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.mesAnneeItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.selectionAnnee}" reRender="btnTresorerie,pnRec,grpTable"/>
                    </h:selectOneMenu>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.projetPresent}">
                    <h:outputText value="Projets:"/>&nbsp;
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.var_projet}" style="width:147px;" >
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.mesProjetsItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.selectionAnnee}" reRender="btnTresorerie,pnRec,grpTable"/>
                    </h:selectOneMenu>
                </h:panelGroup>
                <a4j:commandButton  value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.recherche}" reRender="panellist,modAttente" onclick="javascript:Richfaces.showModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.showButtonPanel}"/>
            </h:panelGrid>

            <h:panelGrid id="btnTresorerie" width="250px" columns="5" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.showButtonPanel}">
                <a4j:commandButton image="/images/ajouter.png" title="Ajouter un nouveau poste" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.ajouterPoste}" oncomplete="javascript:Richfaces.showModalPanel('panelPlanTresorerie');" reRender="panelPlanTresorerie,formModalPlan"></a4j:commandButton>
                <a4j:commandButton image="/images/duplicate.png" title="Dupliquer le plan" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.duppliquerPlanBud}" onclick="if (!confirm('Etes vous sur de vouloir duppliquer tout le plan de trésorerie ?')) return false;" oncomplete="javascript:Richfaces.showModalPanel('panelDuppliquer');" reRender="panelDuppliquer"/>
                <a4j:commandButton image="/images/modifier.png" title="Modifier un poste" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.modifierPoste}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.showButtonModif}" oncomplete="javascript:Richfaces.showModalPanel('panelPlanTresorerie');" reRender="panelPlanTresorerie,formModalPlan"/>
                <a4j:commandButton image="/images/supprimer.png" title="Supprimer un poste"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.showButtonSupp}"reRender="panellist,grpTable" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.supprimerPoste}" onclick="if (!confirm('Etes vous sur de vouloir supprimer ce ce poste tresorerieaire ?')) return false"/>
                <a4j:commandButton image="/images/print.png" title="Imprimer" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGroup id="grpTable">
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable  enableContextMenu="false" id="panellist" border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.dataModelLesPlansTresorerie}" var="plan">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" oncomplete="changeColor(this)" reRender="btnTresorerie" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.selectionPlanTresorerie}"/>
                    <rich:column  sortable="false" width="15%" sortOrder="ASCENDING">
                        <f:facet name="header"><h:outputText  value="CODE"/></f:facet>
                        <h:outputText value="#{plan.treCode}" style="#{plan.espaceFamille}"/>
                    </rich:column>
                    <rich:column  width="33%" sortable="false" >
                        <f:facet name="header"><h:outputText  value="LIBELLE"/></f:facet>
                        <h:outputText value="#{plan.treLibelleFr}" style="#{plan.espaceFamille}"/>
                    </rich:column>
                    <rich:column  sortable="false" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.projetPresent}">
                        <f:facet name="header"><h:outputText  value="COMPTE"/></f:facet>
                        <h:outputText value="#{plan.treCompte}" style="#{plan.espaceFamille}"/>
                    </rich:column>
                    <rich:column  width="38%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.projetPresent}">
                        <f:facet name="header"><h:outputText  value="LIBELLE COMPTE"/></f:facet>
                        <h:outputText value="#{plan.treLibelleCompte}" style="#{plan.espaceFamille}"/>
                    </rich:column>
                    <rich:column  width="4%" sortable="false">
                        <f:facet name="header"><h:outputText  value="ETAT" /></f:facet>
                        <h:commandButton disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.disable}"  image="#{planTresorerie.etat}" id="etat" rendered="#{planTresorerie.afficheImag}"  onclick="if (!confirm('Voulez-vous réactiver ce poste tresorerieaire ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.reactiverPlanBud}">
                            <a4j:support eventsQueue="maQueue" reRender="grpTable" event="onclick"/>
                        </h:commandButton>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </h:panelGroup>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelPlanTresorerie" width="700" height="400" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.showModalPanelPlan}">
        <f:facet name="header"><h:outputText value="GESTION DES POSTES DE TRESORERIE"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:graphicImage value="/images/close.gif"  id="hidelink9" style="cursor:pointer;margin-left:350px"/>
                <rich:componentControl for="panelPlanTresorerie" attachTo="hidelink9" operation="hide" event="onclick">
                    <a4j:support eventsQueue="maQueue" event="onclick"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.annulerSaisie}"  />
                </rich:componentControl>
            </a4j:form>
        </f:facet>
        <a4j:form >
            <h:panelGrid columns="2" id="mod" columnClasses="clos20,clos80" width="100%">
                <h:column><h:outputText value="Code:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.plansTresorerie.treCode}">
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.verifCode}" reRender="panyas,buttGrp"/>
                    </h:inputText>
                    <h:panelGroup id="panyas">
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.existCod}">
                            <h:graphicImage url="/images/Warning.png"  style="width:25px;height;"/>
                            <h:outputText value="Ce code est vide ou existe déja" style="color:red;" />
                        </h:panelGroup>
                    </h:panelGroup>
                </h:column>
                <h:column><h:outputText value="Libellé:"/></h:column>
                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.plansTresorerie.treLibelleFr}"/></h:column>
                <h:column><h:outputText value="Type:"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.plansTresorerie.treType}">
                        <f:selectItem itemLabel="Encaissement" itemValue="0"/>
                        <f:selectItem itemLabel="Décaissement" itemValue="1"/>
                        <f:selectItem itemLabel="Transfert" itemValue="3"/>
                        <f:selectItem itemLabel="Virement interne" itemValue="4"/>
                        <f:selectItem itemLabel="TITRE" itemValue="20"/>
                        <f:selectItem itemLabel="SOUS TITRE" itemValue="21"/>
                        <f:selectItem itemLabel="SOUS SOUS TITRE" itemValue="22"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="mod,idCpt1,idCpt2,idCpt3,idCpt4"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.plansTresorerie.treType!=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.plansTresorerie.treType<=9&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.projetPresent}" id="idCpt1"><h:outputText value="Compte affecté:" style="text-decoration:underline;"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.plansTresorerie.treType!=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.plansTresorerie.treType<=9&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.projetPresent}" id="idCpt2">
                    <h:inputText id="compteId" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.plansTresorerie.treCompte}">
                        <rich:toolTip id="toolcpt" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un numéro de compte ou d'un libellé de compte" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.recherchePlanComptable}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,mod,panCtrl,panelListePlanComptable,formModalListePlanComptable,listeCompte,compteId,nomcompteId"/>
                    </h:inputText>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.plansTresorerie.treType!=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.plansTresorerie.treType<=9&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.projetPresent}" id="idCpt3"><h:outputText value="Libellé compte:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.plansTresorerie.treType!=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.plansTresorerie.treType<=9&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.projetPresent}" id="idCpt4"><h:outputText id="nomcompteId" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.plansTresorerie.treLibelleCompte}"/></h:column>
                <h:column><h:outputText value="Inactif:"/></h:column>
                <h:column><h:selectBooleanCheckbox  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.inactifPlb}"/></h:column>
            </h:panelGrid>
            <center>
                <h:panelGroup id="buttGrp">
                    <h:commandButton image="/images/valider_big.png" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.existCod}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.savePlanTresorerie}" style="margin-top:5px;" />
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelDuppliquer" width="500" height="200" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);">
        <f:facet name="header"><h:outputText value="DUPPLIQUER PLAN TRESORERIE"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidlinkDup" style="margin-left:350px"/>
                <rich:componentControl for="panelDuppliquer" attachTo="hidlinkDup" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>
        <a4j:form>
            <h:panelGrid id="pngGlobal" width="100%" style="text-align:center">
                <h:panelGrid id="png1" columns="2" styleClass="recherche" width="100%" >
                    <h:outputText value=""/>
                    <h:outputText value=""/>
                    <h:outputText value="Année d'origine:"/>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.var_annee}" style="width:147px;" readonly="true"/>
                    <h:outputText value=""/>
                    <h:outputText value=""/>
                    <h:outputText value="Copie vers...:"/>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.var_anneeDestination}" style="width:147px;">
                        <f:selectItem itemLabel="Sélectionnez une année" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.mesAnneeItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.verifDuppliquer}" reRender="pngGlobal,idValDup"/>
                    </h:selectOneMenu>
                </h:panelGrid>
                <br><br>
                <center>
                    <h:panelGroup>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.validerDuppliquer}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.valideDupplication}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,grpTable,btnBudget" style="text-decoration:none;" id="idValDup">
                            <rich:componentControl for="panelDuppliquer" attachTo="idValDup" operation="hide" event="onclick"/>
                        </a4j:commandButton>
                    </h:panelGroup>
                </center>
            </h:panelGrid>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
