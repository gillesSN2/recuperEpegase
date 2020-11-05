<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="jc">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES PLANS BUDGETAIRES" style="color:green;font-size:16px;"/></h2></center>

        <h:panelGrid  id="pnRec" width="100%">
            <h:panelGrid id="png1" columns="4"  styleClass="recherche"  width="100%" >
                <h:panelGroup>
                    <h:outputText value="Année:"/>&nbsp;
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.var_annee}" style="width:147px;" >
                        <f:selectItem itemLabel="Sélectionnez une année" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.mesAnneeItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.buttonPanel}" reRender="png1,btnBudget,pnRec,grpTable"/>
                    </h:selectOneMenu>
                </h:panelGroup>
                <h:panelGroup>
                    <h:outputText value="Nature du budget:"/>&nbsp;
                    <h:selectOneMenu id="idListeNature" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.var_nature}" style="width:147px;" >
                        <f:selectItem itemLabel="Sélectionnez une nature" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.mesTypesItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.buttonPanel}" reRender="btnBudget,pnRec,grpTable"/>
                    </h:selectOneMenu>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.var_annee!='0'}">
                    <a4j:commandButton  value="Liste des budgets" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.listeBudget}" reRender="panelListeBudget,modAttente" onclick="javascript:Richfaces.showModalPanel('modAttente');" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.moduleProjet}"/>
                </h:panelGroup>
                <a4j:commandButton  value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.recherche}" reRender="panellist,modAttente" onclick="javascript:Richfaces.showModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.showButtonPanel}"/>
            </h:panelGrid>

            <h:panelGrid id="btnBudget" width="250px" columns="5" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.showButtonPanel}">
                <a4j:commandButton image="/images/ajouter.png" title="Ajouter un nouveau plan" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.ajouterPoste}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPlanBudget,formModalPlan,panellist"/>
                <a4j:commandButton image="/images/duplicate.png" title="Duppliquer un plan" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.duppliquerPlanBud}" onclick="if (!confirm('Etes vous sur de vouloir duppliquer tout les plans budgétaires ?')) return false;" oncomplete="javascript:Richfaces.showModalPanel('panelDuppliquer');" reRender="panelDuppliquer"/>
                <a4j:commandButton image="/images/modifier.png" title="Modifier un plan" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.modifierPoste}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.showButtonModif}" oncomplete="javascript:Richfaces.showModalPanel('panelPlanBudget');" reRender="panelPlanBudget,formModalPlan"/>
                <a4j:commandButton image="/images/supprimer.png" title="Supprimer un plan" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.showButtonSupp}" reRender="grpTable" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.supprimerPoste}" onclick="if (!confirm('Etes vous sur de vouloir supprimer ce poste budgétaire ?')) return false"/>
                <a4j:commandButton image="/images/print.png" title="Imprimer" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGroup id="grpTable">
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable  enableContextMenu="false" id="panellist" border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.dataModelLesPlansBudgetaires}"  var="planBudget" >
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.selectionPlanBudget}" reRender="btnBudget"/>
                    <rich:column  sortable="false" width="20%" sortOrder="ASCENDING">
                        <f:facet name="header"><h:outputText  value="CODE" /></f:facet>
                        <h:outputText value="#{planBudget.plbCode}" id="cod"  style="#{planBudget.espaceFamille}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <h:outputText value="#{planBudget.plbEntite}"/>
                    </rich:column>
                    <rich:column  width="50%" sortable="false" >
                        <f:facet name="header"><h:outputText  value="LIBELLE" /></f:facet>
                        <h:outputText value="#{planBudget.plbLibelleFr}"  style="#{planBudget.espaceFamille}"/>
                    </rich:column>
                    <rich:column  width="20%" sortable="false" >
                        <f:facet name="header"><h:outputText  value="Bloquant" /></f:facet>
                        <h:outputText value="#{planBudget.var_lib_bloque}"  style="#{planBudget.espaceFamille}" rendered="#{planBudget.plbType<=1}"/>
                    </rich:column>
                    <rich:column  width="10%" sortable="false">
                        <f:facet name="header"><h:outputText  value="ETAT" /></f:facet>
                        <h:commandButton disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.disable}"  image="#{planBudget.etat}" id="etat" rendered="#{planBudget.afficheImag}"  onclick="if (!confirm('Voulez-vous réactiver ce poste budgetaire ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.reactiverPlanBud}">
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


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelPlanBudget" width="700" height="400" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.showModalPanelPlan}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.showModalPanelPlan}" var="pla">
            <f:facet name="header"><h:outputText value="GESTION DES POSTES BUDGETAIRES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <h:graphicImage value="/images/close.gif"  id="hidelink9" style="cursor:pointer;margin-left:350px"/>
                    <rich:componentControl for="panelPlanBudget" attachTo="hidelink9" operation="hide" event="onclick">
                        <a4j:support eventsQueue="maQueue" event="onclick"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.annulerSaisie}"  />
                    </rich:componentControl>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:tabPanel switchType="client" style="width:100%;border:0px;" id="formModalPlan">

                    <rich:tab label="Général">
                        <h:panelGrid width="100%" columns="2" id="mod" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Type:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.plansBudgetaires.plbType}">
                                    <f:selectItem itemLabel="ENTITE" itemValue="15"/>
                                    <f:selectItem itemLabel="TITRE" itemValue="20"/>
                                    <f:selectItem itemLabel="SOUS TITRE" itemValue="21"/>
                                    <f:selectItem itemLabel="SOUS SOUS TITRE" itemValue="22"/>
                                    <f:selectItem itemLabel="Opération" itemValue="1"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="mod,idCpt1,idCpt2,idCpt3,idCpt4"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="ENTITE:" style="color:red"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.plansBudgetaires.plbType==15}"><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.plansBudgetaires.plbEntite}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase;color:red" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.showOngletCompte}" maxlength="20"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.plansBudgetaires.plbType!=15}">
                                <h:selectOneMenu  style="width:300px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.plansBudgetaires.plbEntite}">
                                    <f:selectItem itemLabel="Sans Entité" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.mesEntitestems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Code:"/></h:column>
                            <h:column>
                                <h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.plansBudgetaires.plbCode}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.showOngletCompte}" maxlength="20">
                                    <a4j:support eventsQueue="maQueue" event="onblur" reRender="panyas,buttGrp" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.verifCode}"/>
                                </h:inputText>
                                <h:panelGroup id="panyas">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.existCod}">
                                        <h:graphicImage url="/images/Warning.png"  style="width:25px;height;"/>
                                        <h:outputText value="Ce code est vide ou existe déja" style="color:red;" />
                                    </h:panelGroup>
                                </h:panelGroup>
                            </h:column>
                            <h:column><h:outputText value="Libellé:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.plansBudgetaires.plbLibelleFr}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                            <h:column><h:outputText value="Mode:"/></h:column>
                            <h:column>
                                <h:selectOneMenu  style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.plansBudgetaires.plbBloque}">
                                    <f:selectItem itemLabel="Non bloquant" itemValue="0"/>
                                    <f:selectItem itemLabel="Bloquant sur budget insuffisant" itemValue="1"/>
                                    <f:selectItem itemLabel="Bloquant sur trésorerie insuffisante" itemValue="2"/>
                                    <f:selectItem itemLabel="Bloquant sur tous les critères" itemValue="3"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Inactif:"/></h:column>
                            <h:column><h:selectBooleanCheckbox  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.inactifPlb}"/></h:column>
                        </h:panelGrid>
                        <center>
                            <h:panelGroup id="buttGrp">
                                <h:commandButton image="/images/valider_big.png" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.existCod}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.savePlanBudgetaire}" style="margin-top:5px;" />
                            </h:panelGroup>
                        </center>
                    </rich:tab>

                    <rich:tab  label="Produits (Vente)" id="panelTabProdVte" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.var_aff_nature==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.showOngletCompte}">
                        <h:panelGrid  id="btnProdVte" columns="2" width="100px">
                            <a4j:commandButton image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.ajouterProdVte}" oncomplete="javascript:Richfaces.showModalPanel('panelProd');" reRender="panelProd,modAttente" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            <a4j:commandButton image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.supprimerPlanBudgetProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.testplbProdesup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="tableProdVte,btnProdVte"/>
                        </h:panelGrid>
                        <br>
                        <rich:extendedDataTable headerClass="headerTab" id="tableProdVte"  var="plbProdvte"  height="200px" width="100%" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd"  style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.dataModelPlbPlansProduits}"  >
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.recupererPlanBudgetProduit}" reRender="btnProdVte" />
                            <rich:column  width="25%" >
                                <f:facet name="header"><h:outputText  value="CODE" /></f:facet>
                                <h:outputText value="#{plbProdvte.plbcptCompte}"/>
                            </rich:column>
                            <rich:column  width="75%"  >
                                <f:facet name="header"><h:outputText  value="DESIGNATION" /></f:facet>
                                <h:outputText value="#{plbProdvte.plbcptLibelleFr}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </rich:tab>

                    <rich:tab  label="Produits (Achats)" id="panelTabProdAch"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.var_aff_nature==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.showOngletCompte}">
                        <h:panelGrid  id="btnProdAch" columns="2" width="100px">
                            <a4j:commandButton image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.ajouterProdAch}" oncomplete="javascript:Richfaces.showModalPanel('panelProd');" reRender="panelProd,modAttente" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            <a4j:commandButton image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.supprimerPlanBudgetProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.testplbProdesup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="tableProdAch,btnProdAch"/>
                        </h:panelGrid>
                        <br>
                        <rich:extendedDataTable headerClass="headerTab" id="tableProdAch"  var="plbProdach"  height="200px" width="100%" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd"  style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.dataModelPlbPlansProduits}"  >
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.recupererPlanBudgetProduit}" reRender="btnProdAch" />
                            <rich:column  width="25%" >
                                <f:facet name="header"><h:outputText  value="CODE" /></f:facet>
                                <h:outputText value="#{plbProdach.plbcptCompte}"/>
                            </rich:column>
                            <rich:column  width="75%"  >
                                <f:facet name="header"><h:outputText  value="DESIGNATION" /></f:facet>
                                <h:outputText value="#{plbProdach.plbcptLibelleFr}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </rich:tab>

                    <rich:tab  label="Produits (Production)" id="panelTabProdPrd" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.var_aff_nature==3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.showOngletCompte}">
                        <h:panelGrid  id="btnProdPrd" columns="2" width="100px">
                            <a4j:commandButton image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.ajouterProdPrd}" oncomplete="javascript:Richfaces.showModalPanel('panelProd');" reRender="panelProd,modAttente" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            <a4j:commandButton image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.supprimerPlanBudgetProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.testplbProdesup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="tableProdPrd,btnProdPrd"/>
                        </h:panelGrid>
                        <br>
                        <rich:extendedDataTable headerClass="headerTab" id="tableProdPrd"  var="plbProdprd"  height="200px" width="100%" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd"  style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.dataModelPlbPlansProduits}"  >
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.recupererPlanBudgetProduit}" reRender="btnProdPrd" />
                            <rich:column  width="25%" >
                                <f:facet name="header"><h:outputText  value="CODE" /></f:facet>
                                <h:outputText value="#{plbProdprd.plbcptCompte}"/>
                            </rich:column>
                            <rich:column  width="75%"  >
                                <f:facet name="header"><h:outputText  value="DESIGNATION" /></f:facet>
                                <h:outputText value="#{plbProdprd.plbcptLibelleFr}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </rich:tab>

                    <rich:tab  label="Comptes" id="panelTabCompte" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.showOngletCompte}">
                        <h:panelGrid  id="btnCompte" columns="2" width="100px">
                            <a4j:commandButton image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.ajouterCompte}" oncomplete="javascript:Richfaces.showModalPanel('panelCompte');" reRender="panelCompte,modAttente" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            <a4j:commandButton image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.supprimerPlanBudgetCompte}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.testplbCptesup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="tableCompte,btnCompte"/>
                        </h:panelGrid>
                        <br>
                        <rich:extendedDataTable headerClass="headerTab" id="tableCompte"  var="plbCpte"  height="200px" width="100%" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd"  style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.dataModelPlbPlansComptables}"  >
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.recupererPlanBudgetCompte}" reRender="btnCompte" />
                            <rich:column  width="25%" >
                                <f:facet name="header"><h:outputText  value="COMPTE" /></f:facet>
                                <h:outputText value="#{plbCpte.plbcptCompte}"/>
                            </rich:column>
                            <rich:column  width="75%"  >
                                <f:facet name="header"><h:outputText  value="LIBELLE" /></f:facet>
                                <h:outputText  value="#{plbCpte.plbcptLibelleFr}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </rich:tab>

                </rich:tabPanel>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelCompte" width="900" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" >
        <f:facet name="header"><h:outputText value="AJOUT DE COMPTE COMPTABLE"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidlinkAjPlbCpte" style="margin-left:350px"/>
                <rich:componentControl for="panelCompte" attachTo="hidlinkAjPlbCpte" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>
        <a4j:form>
            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableCompteListe"/>
            <rich:extendedDataTable rows="100" id="tableCompteListe" height="400px" width="100%" headerClass="headerTab" selectedClass="active-row" var="cpte" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.dataModelPlbCompte}">
                <a4j:support eventsQueue="maQueue" event="onRowClick" reRender="btnCompte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.selectionCompte}"/>
                <rich:column  width="5%" sortable="true" sortBy="#{cpte.var_select}" >
                    <f:facet name="header"><h:outputText  value="SEL." /></f:facet>
                    <h:selectBooleanCheckbox value="#{cpte.var_select}"/>
                </rich:column>
                <rich:column  width="20%" sortable="true" sortBy="#{cpte.plcCompte}" filterBy="#{cpte.plcCompte}">
                    <f:facet name="header"><h:outputText  value="COMPTE" /></f:facet>
                    <h:outputText value="#{cpte.plcCompte}"/>
                </rich:column>
                <rich:column  width="75%" sortable="true" sortBy="#{cpte.plcLibelleCpteFR}" filterBy="#{cpte.plcLibelleCpteFR}">
                    <f:facet name="header"><h:outputText  value="LIBELLE" /></f:facet>
                    <h:outputText value="#{cpte.plcLibelleCpteFR}" />
                </rich:column>
            </rich:extendedDataTable>
            <br><br>
            <center>
                <h:panelGroup >
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.validerCompte}" reRender="panelCompte,tableCompte" style="text-decoration:none;" id="idVal">
                        <rich:componentControl for="panelCompte" attachTo="idVal" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelProd" width="900" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" >
        <f:facet name="header"><h:outputText value="AJOUT DE PRODUITS"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidlinkAjPlbPrdvte" style="margin-left:350px"/>
                <rich:componentControl for="panelProd" attachTo="hidlinkAjPlbPrdvte" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>
        <a4j:form>
            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableProd"/>
            <rich:extendedDataTable rows="100" id="tableProd" height="400px" width="100%" headerClass="headerTab" selectedClass="active-row" var="prdvte" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.dataModelProduits}">
                <a4j:support eventsQueue="maQueue" event="onRowClick" reRender="btnProdVte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.selectionProduit}"/>
                <rich:column  width="5%" sortable="true" sortBy="#{prdvte.var_select}">
                    <f:facet name="header"><h:outputText  value="SEL." /></f:facet>
                    <h:selectBooleanCheckbox value="#{prdvte.var_select}"/>
                </rich:column>
                <rich:column  width="20%"  sortable="true" sortBy="#{prdvte.proCode}" filterBy="#{prdvte.proCode}">
                    <f:facet name="header"><h:outputText  value="CODE" /></f:facet>
                    <h:outputText value="#{prdvte.proCode}"/>
                </rich:column>
                <rich:column  width="75%" sortable="true" sortBy="#{prdvte.proLibClient}" filterBy="#{prdvte.proLibClient}" >
                    <f:facet name="header"><h:outputText  value="DESIGNATION" /></f:facet>
                    <h:outputText value="#{prdvte.proLibClient}" />
                </rich:column>
            </rich:extendedDataTable>
            <br><br>
            <center>
                <h:panelGroup >
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.validerProduit}" reRender="tableProdVte,tableProdPrd,tableProdAch" style="text-decoration:none;" id="idValProdVte">
                        <rich:componentControl for="panelProd" attachTo="idValProdVte" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelDuppliquer" width="500" height="200" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);">
        <f:facet name="header"><h:outputText value="DUPPLIQUER PLANS BUDGETAIRES"></h:outputText></f:facet>
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
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.var_annee}" style="width:147px;" readonly="true"/>
                    <h:outputText value=""/>
                    <h:outputText value=""/>
                    <h:outputText value="Copie vers...:"/>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.var_anneeDestination}" style="width:147px;">
                        <f:selectItem itemLabel="Sélectionnez une année" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.mesAnneeItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.verifDuppliquer}" reRender="pngGlobal,idValDup"/>
                    </h:selectOneMenu>
                </h:panelGrid>
                <br><br>
                <center>
                    <h:panelGroup>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.validerDuppliquer}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.valideDupplication}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,grpTable,btnBudget" style="text-decoration:none;" id="idValDup">
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


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelListeBudget" width="700" height="600" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.showModalPanelBudget}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.showModalPanelBudget}" var="lbl">
            <f:facet name="header"><h:outputText value="GESTION DES BUDGETS LIBRES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <h:graphicImage value="/images/close.gif"  id="hidelinkBud" style="cursor:pointer;margin-left:350px"/>
                    <rich:componentControl for="panelListeBudget" attachTo="hidelinkBud" operation="hide" event="onclick">
                        <a4j:support eventsQueue="maQueue" event="onclick"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.fermerBudget}"/>
                    </rich:componentControl>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid id="btnBudgetLibre" width="250px" columns="5" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                    <a4j:commandButton image="/images/ajouter.png" title="Ajouter un nouveau budget" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.ajouterBuget}" reRender="panelFicheBudget"/>
                    <a4j:commandButton image="/images/modifier.png" title="Modifier un budget" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.modifierBudget}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.afficheBudget}" reRender="panelFicheBudget"/>
                    <a4j:commandButton image="/images/supprimer.png" title="Supprimer un budget" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.afficheBudget}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.supprimerBudget}" onclick="if (!confirm('Etes vous sur de vouloir supprimer ce poste budgétaire ?')) return false" reRender="listBudget,btnBudgetLibre;idListeNature" />
                </h:panelGrid>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable  enableContextMenu="false" id="listBudget" border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="500px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.dataModelListeBudget}"  var="budget" >
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.selectionBudget}" reRender="btnBudgetLibre"/>
                        <rich:column  sortable="false" width="20%" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="CODE" /></f:facet>
                            <h:outputText value="#{budget.proCode}"/>
                        </rich:column>
                        <rich:column  width="50%" sortable="false" >
                            <f:facet name="header"><h:outputText  value="LIBELLE" /></f:facet>
                            <h:outputText value="#{budget.proNomFR}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

                
    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelFicheBudget" width="500" height="200" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.showModalPanelBudgetFiche}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.showModalPanelBudgetFiche}" var="fic">
            <f:facet name="header"><h:outputText value="DESCRIPTION D'UN BUDGET"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <h:graphicImage value="/images/close.gif"  id="hidelinkFic" style="cursor:pointer;margin-left:350px"/>
                    <rich:componentControl for="panelFicheBudget" attachTo="hidelinkFic" operation="hide" event="onclick">
                        <a4j:support eventsQueue="maQueue" event="onclick"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.annulerBudget}"  />
                    </rich:componentControl>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid columns="2" id="mod" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Code:"/></h:column>
                    <h:column>
                        <h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.projets.proCode}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="panyas,buttGrp" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.verifCodeBudget}"/>
                        </h:inputText>
                        <h:panelGroup id="panyas">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.existBudget}">
                                <h:graphicImage url="/images/Warning.png"  style="width:25px;height;"/>
                                <h:outputText value="Ce code est vide ou existe déja" style="color:red;" />
                            </h:panelGroup>
                        </h:panelGroup>
                    </h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.projets.proNomFR}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                </h:panelGrid>
                <center>
                    <h:panelGroup id="buttGrp">
                        <a4j:commandButton image="/images/valider_big.png" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.existBudget}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansBudgetaires.saveBudget}" style="margin-top:5px;" reRender="panelFicheBudget,listBudget,idListeNature"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
