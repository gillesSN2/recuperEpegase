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

        <center> <h2><h:outputText value="LISTE DES PLANS ANALYTIQUES" style="color:green;font-size:16px;"/></h2></center>

        <rich:tabPanel switchType="client" immediate="true"  style="border:0px;">

            <rich:tab label="Plans analytiques" id="idGlobal">
                <h:panelGrid  id="pnRec" width="100%">
                    <h:panelGrid id="png1" columns="2"  styleClass="recherche"  width="100%" >
                        <h:panelGroup>
                            <h:outputText value="Année:"/>&nbsp;
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.var_annee}" style="width:147px;" >
                                <f:selectItem itemLabel="Sélectionnez une année" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.mesAnneeItems}"/>
                                <a4j:support eventsQueue="maQueue"   event="onchange" reRender="btnAnal,pnRec,panellist,scrollTable"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.buttonPanel}"/>
                            </h:selectOneMenu>
                        </h:panelGroup>
                        <h:panelGroup>
                            <h:outputText value="Plans analytiques:"/>&nbsp;
                            <h:selectOneMenu id="idAxeAnal" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.var_nature}" style="width:147px;" >
                                <f:selectItem itemLabel="Sélectionnez une nature" itemValue="0"/>                            
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.mesAxesAnalytique}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.buttonPanel}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,png1,btnAnal,pnRec,panellist,scrollTable"/>
                            </h:selectOneMenu>
                        </h:panelGroup>
                    </h:panelGrid>
                    <h:panelGrid id="btnAnal" width="200px" columns="5" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.showButtonPanel}">
                        <a4j:commandButton image="/images/ajouter.png" title="Ajouter un nouveau plan" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.ajouterPoste}" reRender="panelPlanAnalytique,formModalPlan,panelPlanActivite,formModalActivite"></a4j:commandButton>
                        <a4j:commandButton image="/images/modifier.png" title="Modifier un plan" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.modifierPoste}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.showButtonModif}" reRender="panelPlanAnalytique,formModalPlan,panelPlanActivite,formModalActivite"/>
                        <a4j:commandButton image="/images/supprimer.png" title="Supprimer un plan"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.showButtonSupp}"reRender="panellist,scrollTable" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.supprimerPoste}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément ?')) return false"  />
                        <a4j:commandButton image="/images/print.png" title="Imprimer" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
                        <h:panelGrid  style="width:200px;" columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.var_nature=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.var_nature=='2'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.var_nature=='3'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.var_nature=='4'}">
                            <a4j:commandButton  value="Modifier libellé #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.var_libelle}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.calculeLibelle}" oncomplete="javascript:Richfaces.showModalPanel('panelLibelle');" reRender="panelLibelle,formModalLibelle"></a4j:commandButton>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20" align="left" for="panellist"/>
                    <rich:extendedDataTable rows="100" style="max-height:100%" styleClass="bg" id="panellist" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.dataModelLesPlansAnalytiques}" var="planAnal">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" oncomplete="changeColor(this)" reRender="btnAnal" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.selectionPlanAnalytique}"/>
                        <rich:column  sortable="false" width="20%" >
                            <f:facet name="header"><h:outputText  value="CODE" /></f:facet>
                            <h:outputText value="#{planAnal.anaCode}" id="cod"/>
                        </rich:column>
                        <rich:column  width="30%" sortable="false" >
                            <f:facet name="header"><h:outputText  value="LIBELLE" /></f:facet>
                            <h:outputText value="#{planAnal.anaNomFr}"/>
                        </rich:column>
                        <rich:column  width="10%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.var_nature=='100'}">
                            <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                            <h:outputText value="#{planAnal.anaNature}"/>
                        </rich:column>
                        <rich:column  width="30%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.var_nature=='9'}">
                            <f:facet name="header"><h:outputText  value="Utilisation" /></f:facet>
                            <h:outputText value="#{planAnal.lib_type}"/>
                        </rich:column>
                        <rich:column  width="5%" sortable="false">
                            <f:facet name="header"><h:outputText  value="STR." /></f:facet>
                            <h:selectBooleanCheckbox value="#{planAnal.anaStr}" readonly="true"/>
                        </rich:column>
                        <rich:column  width="5%" sortable="false" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="ETAT" /></f:facet>
                            <h:commandButton disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.inactifPlb}"  image="#{planAnal.etat}" id="etat" rendered="#{planAnal.afficheImag}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:tab>

            <rich:tab label="Axes analytiques">
                <h:panelGrid style="width:100%">
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" headerClass="headerTab" style="width:100%">
                        <f:facet name="header"><h:outputText value="Découpage des Activités"/></f:facet>
                        <h:column><h:outputText value="Code 1:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strCode1}" size='7' maxlength="20" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                        <h:column><h:outputText value="Libellé 1:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strLib1}" size="20" maxlength="100" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                        <h:column><h:outputText value="Code 2:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strCode2}" size='7' maxlength="20" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                        <h:column><h:outputText value="Libellé 2:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strLib2}" size="20" maxlength="100" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                        <h:column><h:outputText value="Code 3:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strCode3}" size='7' maxlength="20" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                        <h:column><h:outputText value="Libellé 3:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strLib3}" size="20" maxlength="100" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                        <h:column><h:outputText value="Chainage des listes:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strChainageAxes}" style="width:300px;" >
                                <f:selectItem itemLabel="Axes libres" itemValue="0"/>
                                <f:selectItem itemLabel="Axes chainées" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" headerClass="headerTab" style="width:100%" id="panAnal">
                        <f:facet name="header"><h:outputText value="Analytiques Complémentaires"/></f:facet>
                        <h:column><h:outputText value="Axe Structure:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strStructure}"/></h:column>
                        <h:column><h:outputText value="Axe Site/Département/Service:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strSite}"/></h:column>
                        <h:column><h:outputText value="Axe Région/Secteur/Pdv:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strRegion}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.moduleUsine}"><h:outputText value="Axe Site/Atelier/Ligne:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.moduleUsine}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strUsine}"/></h:column>
                        <h:column><h:outputText value="Axe Activité:"/></h:column>
                        <h:column>
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strActivite}">
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="panAnal"/>
                            </h:selectBooleanCheckbox>&nbsp;&nbsp;&nbsp;&nbsp;
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strActiviteModeSasie}" style="width:250px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strActivite}">
                                <f:selectItem itemLabel="Sélection sur liste" itemValue="0"/>
                                <f:selectItem itemLabel="Sélection sur saisie" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.modulePaye}"><h:outputText value="Axe Agent:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.modulePaye}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strAgent}"/></h:column>
                        <h:column><h:outputText value="Axe Chantier:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strChantier}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.moduleParc}"><h:outputText value="Axe Parc:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.moduleParc}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strParc}"/></h:column>
                        <h:column><h:outputText value="Axe Mission/Frais:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strMission}"/></h:column>
                        <h:column><h:outputText value="Axe Clés répartition:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strCles}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.moduleProjet}"><h:outputText value="Axe Projet:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.moduleProjet}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strProjet}"/></h:column>
                        <h:column><h:outputText value="Axe Dossier/Affaire:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strDossier}" style="width:300px;" >
                                <f:selectItem itemLabel="Sans Dossier, Sans Affaire" itemValue="0"/>
                                <f:selectItem itemLabel="Dossier" itemValue="1"/>
                                <f:selectItem itemLabel="Porte feuille d`affaire" itemValue="2"/>
                                <f:selectItem itemLabel="Transitaire" itemValue="3"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="panAnal,idTransit1,idTransit2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column id="idTransit1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strDossier==3}"><h:outputText value="Longueur dossier transit:"/></h:column>
                        <h:column id="idTransit2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strDossier==3}">
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureLog.strNbCarDossier}" style="width:300px;" >
                                <f:selectItem itemLabel="Libre" itemValue="0" />
                                <f:selectItem itemLabel="1" itemValue="1" />
                                <f:selectItem itemLabel="2" itemValue="2" />
                                <f:selectItem itemLabel="3" itemValue="3"/>
                                <f:selectItem itemLabel="4" itemValue="4"/>
                                <f:selectItem itemLabel="5" itemValue="5"/>
                                <f:selectItem itemLabel="6" itemValue="6"/>
                                <f:selectItem itemLabel="7" itemValue="7"/>
                                <f:selectItem itemLabel="8" itemValue="8"/>
                                <f:selectItem itemLabel="9" itemValue="9"/>
                                <f:selectItem itemLabel="10" itemValue="10"/>
                                <f:selectItem itemLabel="11" itemValue="11"/>
                                <f:selectItem itemLabel="12" itemValue="12"/>
                                <f:selectItem itemLabel="13" itemValue="13"/>
                                <f:selectItem itemLabel="14" itemValue="14"/>
                                <f:selectItem itemLabel="15" itemValue="15"/>
                                <f:selectItem itemLabel="16" itemValue="16"/>
                                <f:selectItem itemLabel="17" itemValue="17"/>
                                <f:selectItem itemLabel="18" itemValue="18"/>
                                <f:selectItem itemLabel="19" itemValue="19"/>
                                <f:selectItem itemLabel="20" itemValue="20"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <h:panelGroup>
                    <br>
                    <center>
                        <a4j:commandButton id="idValDecoupage" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.validerDecoupage}" reRender="idGlobal,pnRec,idAxeAnal"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValDecoupage')}.click()" />
                    </center>
                </h:panelGroup>
            </rich:tab>

        </rich:tabPanel>      

        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelPlanAnalytique" width="900" height="420" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.showModalPanelPlan}">
        <f:facet name="header"><h:outputText value="GESTION DES SECTIONS ANALYTIQUES"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.annulerSaisie}" image="/images/close.gif" styleClass="hidelink" />
            </a4j:form>
        </f:facet>
        <a4j:form >
            <rich:tabPanel switchType="client" immediate="true" style="width:100%;border:0px;" id="formModalPlan">

                <rich:tab label="Général">
                    <h:panelGrid width="100%" id="panGlobal">
                        <h:panelGrid columns="2" id="mod" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Code:"/></h:column>
                            <h:column>
                                <h:inputText id="idCodeDos" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaCode}" maxlength="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.lgDossier}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase" size="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.showOngletCompte}">
                                    <a4j:support eventsQueue="maQueue"  event="onblur" reRender="mod,panyas,buttGrp,idCodeDos" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.verifCode}"/>
                                </h:inputText>
                                <h:panelGroup id="panyas">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.existCod}">
                                        <h:graphicImage url="/images/Warning.png"  style="width:25px;height;"/>
                                        <h:outputText value="Ce code est vide ou existe déja" style="color:red;" />
                                    </h:panelGroup>
                                </h:panelGroup>
                            </h:column>
                            <h:column><h:outputText value="Libellé:"/></h:column>
                            <h:column><h:inputText style="width:100%;" onkeypress="return scanToucheLettre(event)" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaNomFr}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaInactif<=1}"><h:outputText value="Inactif:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaInactif<=1}"><h:selectBooleanCheckbox  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.inactifPlb}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" headerClass="headerTab" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.var_nature!=9}">
                            <f:facet name="header"><h:outputText value="Accessibles dans :"/></f:facet>
                            <h:column><h:outputText value="Année:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.var_annee_selectionnee}" style="width:147px;" disabled="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaInactif==0)==false}">
                                    <f:selectItem itemLabel="Toutes les années" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.mesAnneeSelectionneeItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" headerClass="headerTab" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.var_nature==6}">
                            <f:facet name="header"><h:outputText value="Définition du dossier"/></f:facet>
                            <h:column><h:outputText value="Type:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaTypeDossier}" style="width:200px;" disabled="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaInactif==0)==false}">
                                    <f:selectItem itemLabel="Dossier simple" itemValue="99"/>
                                    <f:selectItem itemLabel="Importation Maritime" itemValue="0"/>
                                    <f:selectItem itemLabel="Importation Aérienne" itemValue="1"/>
                                    <f:selectItem itemLabel="Importation Express" itemValue="2"/>
                                    <f:selectItem itemLabel="Importation Routière" itemValue="3"/>
                                    <f:selectItem itemLabel="Exportation Maritime" itemValue="10"/>
                                    <f:selectItem itemLabel="Exportation Aérienne" itemValue="11"/>
                                    <f:selectItem itemLabel="Exportation Express" itemValue="12"/>
                                    <f:selectItem itemLabel="Exportation Routière" itemValue="13"/>
                                    <f:selectItem itemLabel="Assistance" itemValue="14"/>
                                    <f:selectItem itemLabel="Chantier" itemValue="7"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="btnAnal,pnRec,idConfigChantier,panGlobal,idConfigSimple,idConfigImport" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid id="idConfigImport" width="100%" columns="2" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaTypeDossier=='0'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaTypeDossier=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaTypeDossier=='2'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaTypeDossier=='3'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaTypeDossier=='10'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaTypeDossier=='11'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaTypeDossier=='12'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaTypeDossier=='13'}">
                            <h:column><h:outputText value="Devise:"/></h:column>
                            <h:column id="idDeviseGlobale">
                                <h:selectOneMenu style="width:30%" id="idDevise" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaTypeDevise}" disabled="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaInactif==0)==false}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.mesdevisesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.calculDevise}" reRender="idConfigImport,idDeviseGlobale,idCoefDev" />
                                </h:selectOneMenu>&nbsp;&nbsp;
                                <h:outputText value="Coef."/>&nbsp;
                                <h:inputText id="idCoefDev" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaTypeTauxDevise}" style="text-align:right;width:30%" disabled="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaInactif==0)==false}"/>
                            </h:column>
                            <h:column><h:outputText value="Exonération TVA:"/></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaTypeExoTva}" disabled="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaInactif==0)==false}"/></h:column>
                            <h:column><h:outputText value="Exonération DOUANE:"/></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaTypeExoDouane}" disabled="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaInactif==0)==false}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid id="idConfigChantier" width="100%" columns="2" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaTypeDossier=='7'}">
                            <h:column><h:outputText value="Propriétaire:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaMissionProprietaire}" style="width:100%"/></h:column>
                            <h:column><h:outputText value="Lettre de commande:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaMissionLettreCmd}" style="width:100%"/></h:column>
                            <h:column><h:outputText value="Chef de chantier:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaMissionChef}" style="width:100%"/></h:column>
                            <h:column><h:outputText value="Cout théorique:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaMissionCoutTheorique}" size="5" style="text-align:right;"/></h:column>
                            <h:column><h:outputText value="Date début:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaMissionDebut}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="Date fin:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaMissionFin}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="Etat:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaMissionEtat}" style="width:147px;" >
                                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Fermé" itemValue="1"/>
                                    <f:selectItem itemLabel="En attente" itemValue="2"/>
                                    <f:selectItem itemLabel="Abondonné" itemValue="3"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <center>
                        <h:panelGroup id="buttGrp">
                            <h:commandButton image="/images/valider_big.png" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.existCod&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaInactif==0)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.savePlanAnalytique}" style="margin-top:5px;" />
                        </h:panelGroup>
                    </center>
                </rich:tab>

                <rich:tab  label="Répartitions"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.var_nature=='9'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.showOngletCompte}" reRender="tableCompte,tableCompteGrp">
                    <h:panelGrid  id="btnCompte" columns="3" width="200px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaNatureRepartition!=200}">
                        <a4j:commandButton image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.ajouterRepartition}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.testplbCptesup}" oncomplete="javascript:Richfaces.showModalPanel('panelRepartition');" reRender="panelRepartition,modAttente" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        <a4j:commandButton image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.modifierRepartition}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.testplbCptesup}" oncomplete="javascript:Richfaces.showModalPanel('panelRepartition');" reRender="panelRepartition,modAttente" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        <a4j:commandButton image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.supprimerRepartition}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.testplbCptesup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette répartition ?')) return false" reRender="tableCompte,btnCompte"/>
                    </h:panelGrid>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaNatureRepartition==200}" var="ana1">
                            <rich:extendedDataTable enableContextMenu="true" id="tableCompteGrp" border="0" headerClass="headerTab" noDataLabel=" " activeClass="active-row" rowClasses="rows1,rows2,rowsd" width="100%" height="250px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.dataModelRepartition}" var="repAna" >
                                <rich:column label="Structure" width="10%" sortable="true" sortBy="#{repAna.cleIdStr}">
                                    <f:facet name="header"><h:outputText  value="ID STR" /></f:facet>
                                    <h:outputText value="#{repAna.cleIdStr}"/>
                                </rich:column>
                                <rich:column label="Structure" width="20%" sortable="true" sortBy="#{repAna.cleSigleStr}">
                                    <f:facet name="header"><h:outputText  value="Sigle" /></f:facet>
                                    <h:outputText value="#{repAna.cleSigleStr}"/>
                                </rich:column>
                                <rich:column label="Structure" width="50%" sortable="true" sortBy="#{repAna.cleNomStr}">
                                    <f:facet name="header"><h:outputText  value="Sigle" /></f:facet>
                                    <h:outputText value="#{repAna.cleNomStr}"/>
                                </rich:column>
                                <rich:column  width="20%" sortable="false" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                    <h:outputText value="#{repAna.cleRepStr}" style="width:100%;text-align:right;"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaNatureRepartition!=200}" var="ana1">
                            <rich:extendedDataTable enableContextMenu="true" groupingColumn="idAct" id="tableCompte" border="0" headerClass="headerTab" noDataLabel=" " activeClass="active-row" rowClasses="rows1,rows2,rowsd" width="100%" height="250px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.dataModelRepartition}" var="repAna" >
                                <rich:column id="idAct" label="Activité" width="150" sortable="true" sortBy="#{repAna.cleCodeActivite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_activite}">
                                    <f:facet name="header"><h:outputText  value="Activité" /></f:facet>
                                    <h:outputText value="#{repAna.cleCodeActivite} #{repAna.cleLibelleActivite}" rendered="#{repAna.affiche_activite}"/>
                                </rich:column>
                                <rich:column  width="60" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_activite}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                    <h:outputText value="#{repAna.cleRepActivite}" rendered="#{repAna.affiche_activite}" style="width:100%;text-align:right;"/>
                                </rich:column>
                                <rich:column  width="150" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_site}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Site" /></f:facet>
                                    <h:outputText value="#{repAna.cleCodeSite} #{repAna.cleLibelleSite}" rendered="#{repAna.affiche_site}"/>
                                </rich:column>
                                <rich:column  width="60" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_site}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                    <h:outputText value="#{repAna.cleRepSite}" rendered="#{repAna.affiche_site}" style="width:100%;text-align:right;"/>
                                </rich:column>
                                <rich:column  width="150" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_departement}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Département" /></f:facet>
                                    <h:outputText value="#{repAna.cleCodeDepartement} #{repAna.cleLibelleDepartement}" rendered="#{repAna.affiche_departement}"/>
                                </rich:column>
                                <rich:column  width="60" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_departement}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                    <h:outputText value="#{repAna.cleRepDepartement}" rendered="#{repAna.affiche_departement}" style="width:100%;text-align:right;"/>
                                </rich:column>
                                <rich:column  width="150" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_service}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                                    <h:outputText value="#{repAna.cleCodeService} #{repAna.cleLibelleService}" rendered="#{repAna.affiche_service}"/>
                                </rich:column>
                                <rich:column  width="60" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_service}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                    <h:outputText value="#{repAna.cleRepService}" rendered="#{repAna.affiche_service}" style="width:100%;text-align:right;"/>
                                </rich:column>
                                <rich:column  width="150" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_region}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Région" /></f:facet>
                                    <h:outputText value="#{repAna.cleCodeRegion} #{repAna.cleLibelleRegion}" rendered="#{repAna.affiche_region}"/>
                                </rich:column>
                                <rich:column  width="60" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_region}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                    <h:outputText value="#{repAna.cleRepRegion}" rendered="#{repAna.affiche_region}" style="width:100%;text-align:right;"/>
                                </rich:column>
                                <rich:column  width="150" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_secteur}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Secteur" /></f:facet>
                                    <h:outputText value="#{repAna.cleCodeSecteur} #{repAna.cleLibelleSecteur}" rendered="#{repAna.affiche_secteur}"/>
                                </rich:column>
                                <rich:column  width="60" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_secteur}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                    <h:outputText value="#{repAna.cleRepSecteur}" rendered="#{repAna.affiche_secteur}" style="width:100%;text-align:right;"/>
                                </rich:column>
                                <rich:column  width="150" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_pdv}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="P.D.V." /></f:facet>
                                    <h:outputText value="#{repAna.cleCodePdv} #{repAna.cleLibellePdv}" rendered="#{repAna.affiche_pdv}"/>
                                </rich:column>
                                <rich:column  width="60" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_pdv}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                    <h:outputText value="#{repAna.cleRepPdv}" rendered="#{repAna.affiche_pdv}" style="width:100%;text-align:right;"/>
                                </rich:column>
                                <rich:column  width="150" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_sitePrdv}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Site" /></f:facet>
                                    <h:outputText value="#{repAna.cleCodeSite} #{repAna.cleLibelleSite}" rendered="#{repAna.affiche_site}"/>
                                </rich:column>
                                <rich:column  width="60" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_sitePrdv}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                    <h:outputText value="#{repAna.cleRepSite}" rendered="#{repAna.affiche_site}" style="width:100%;text-align:right;"/>
                                </rich:column>
                                <rich:column  width="150" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_ligne}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Ligne" /></f:facet>
                                    <h:outputText value="#{repAna.cleCodeLigne} #{repAna.cleLibelleLigne}" rendered="#{repAna.affiche_ligne}"/>
                                </rich:column>
                                <rich:column  width="60" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_ligne}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                    <h:outputText value="#{repAna.cleRepLigne}" rendered="#{repAna.affiche_ligne}" style="width:100%;text-align:right;"/>
                                </rich:column>
                                <rich:column  width="150" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_atelier}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Atelier" /></f:facet>
                                    <h:outputText value="#{repAna.cleCodeAtelier} #{repAna.cleLibelleAtelier}" rendered="#{repAna.affiche_atelier}"/>
                                </rich:column>
                                <rich:column  width="60" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_atelier}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                    <h:outputText value="#{repAna.cleRepAtelier}" rendered="#{repAna.affiche_atelier}" style="width:100%;text-align:right;"/>
                                </rich:column>
                                <rich:column  width="150" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_parc}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Parc" /></f:facet>
                                    <h:outputText value="#{repAna.cleCodeParc} #{repAna.cleLibelleParc}" rendered="#{plbCpte.affiche_parc}"/>
                                </rich:column>
                                <rich:column  width="60" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_parc}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                    <h:outputText value="#{repAna.cleRepParc}" rendered="#{repAna.affiche_parc}" style="width:100%;text-align:right;"/>
                                </rich:column>
                                <rich:column  width="150" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_dossier!=0}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Dossier" /></f:facet>
                                    <h:outputText value="#{repAna.cleCodeDossier} #{repAna.cleLibelleDossier}" rendered="#{repAna.affiche_dossier}"/>
                                </rich:column>
                                <rich:column  width="60" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_dossier!=0}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                    <h:outputText value="#{repAna.cleRepDossier}" rendered="#{repAna.affiche_dossier}" style="width:100%;text-align:right;"/>
                                </rich:column>
                                <rich:column  width="150" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_agent}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Agent" /></f:facet>
                                    <h:outputText value="#{repAna.cleCodeAgent} #{repAna.cleLibelleAgent}" rendered="#{repAna.affiche_agent}"/>
                                </rich:column>
                                <rich:column  width="60" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_agent}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                    <h:outputText value="#{repAna.cleRepAgent}" rendered="#{repAna.affiche_agent}" style="width:100%;text-align:right;"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </c:if>
                    </a4j:region>
                </rich:tab>

            </rich:tabPanel>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelRepartition"  width="900" height="450" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.showModalPanelRepartition}">
        <f:facet name="header">
            <h:panelGroup><h:outputText value="AJOUT REPARTITION"></h:outputText></h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.annulerRepartition}" image="/images/close.gif" styleClass="hidelink"/>
            </a4j:form>
        </f:facet>
        <a4j:form id="idFormDet">
            <h:panelGrid width="100%" id="repartition" >
                <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.mode_calcul}">
                    <h:column><h:outputText value="Nature Analytique:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.natureRepartition}" style="width:300px;" >
                            <f:selectItem itemLabel="Sélection nature" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.mesAxesAnalytique}"/>
                            <a4j:support eventsQueue="maQueue"  event="onchange" reRender="idFormDet,detailRep,calculRep,calRep,valRep,repartition" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.structureNature}"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>

                <h:panelGrid width="100%" id="detailRep" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.mode_calcul}">
                    <h:panelGrid columns="4" width="100%">
                        <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.natureRepartition=='110'}">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  enableContextMenu="false" id="tableActivite" border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="150px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.lesActivites}"  var="act" > />
                                    <rich:column  width="10%" sortable="false" >
                                        <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                        <h:selectBooleanCheckbox value="#{act.select_activite}"/>
                                    </rich:column>
                                    <rich:column  width="20%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                        <h:outputText value="#{act.actCode}"/>
                                    </rich:column>
                                    <rich:column  width="70%" sortable="false" >
                                        <f:facet name="header"><h:outputText  value="Libellé Activité" /></f:facet>
                                        <h:outputText value="#{act.actNomFr}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                        <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.natureRepartition=='120'}">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  enableContextMenu="false" id="tableParc"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="150px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.lesParcs}"  var="prc" >
                                    <rich:column  width="10%" sortable="false" >
                                        <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                        <h:selectBooleanCheckbox value="#{prc.select_parc}"/>
                                    </rich:column>
                                    <rich:column  width="20%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                        <h:outputText value="#{prc.prcImmatriculation}"/>
                                    </rich:column>
                                    <rich:column  width="70%" sortable="false" >
                                        <f:facet name="header"><h:outputText  value="Libellé Parc" /></f:facet>
                                        <h:outputText value="#{prc.prcLibFamille} #{prc.prcMarque}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                        <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.natureRepartition=='6'}">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  enableContextMenu="false" id="tableDossier"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="150px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.lesDossiers}"  var="dos">
                                    <rich:column  width="10%" sortable="false" >
                                        <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                        <h:selectBooleanCheckbox value="#{dos.select_analytique}"/>
                                    </rich:column>
                                    <rich:column  width="20%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                        <h:outputText value="#{dos.anaCode}"/>
                                    </rich:column>
                                    <rich:column  width="70%" sortable="false" >
                                        <f:facet name="header"><h:outputText  value="Libellé Dossier" /></f:facet>
                                        <h:outputText value="#{dos.anaNomFr}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                        <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.natureRepartition=='7'}">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  enableContextMenu="false" id="tableChantier"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="150px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.lesChantiers}"  var="dos">
                                    <rich:column  width="10%" sortable="false" >
                                        <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                        <h:selectBooleanCheckbox value="#{dos.select_analytique}"/>
                                    </rich:column>
                                    <rich:column  width="20%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                        <h:outputText value="#{dos.anaCode}"/>
                                    </rich:column>
                                    <rich:column  width="70%" sortable="false" >
                                        <f:facet name="header"><h:outputText  value="Libellé Chantier" /></f:facet>
                                        <h:outputText value="#{dos.anaNomFr}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                        <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.natureRepartition=='8'}">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  enableContextMenu="false" id="tableMission"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="150px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.lesMissions}"  var="dos">
                                    <rich:column  width="10%" sortable="false" >
                                        <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                        <h:selectBooleanCheckbox value="#{dos.select_analytique}"/>
                                    </rich:column>
                                    <rich:column  width="20%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                        <h:outputText value="#{dos.anaCode}"/>
                                    </rich:column>
                                    <rich:column  width="70%" sortable="false" >
                                        <f:facet name="header"><h:outputText  value="Libellé Mission" /></f:facet>
                                        <h:outputText value="#{dos.anaNomFr}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                        <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.natureRepartition=='122'}">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  enableContextMenu="false" id="tableAgent"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="150px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.lesAgents}"  var="agt" > />
                                    <rich:column  width="10%" sortable="false" >
                                        <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                                        <h:selectBooleanCheckbox value="#{agt.lib_nature}"/>
                                    </rich:column>
                                    <rich:column  width="20%" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                                        <h:outputText value="#{agt.salMatricule}"/>
                                    </rich:column>
                                    <rich:column  width="70%" sortable="false" >
                                        <f:facet name="header"><h:outputText  value="Nom et Prénom" /></f:facet>
                                        <h:outputText value="#{agt.salNom} #{agt.salPrenom}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.natureRepartition=='100'}">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable  enableContextMenu="false" id="tableSitDepSer"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="200px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.lesSitDepSer}" var="sds" >
                                <rich:column  width="10%" sortable="false" >
                                    <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                    <h:selectBooleanCheckbox value="#{sds.select_site}" rendered="#{sds.affiche_site}"/>
                                </rich:column>
                                <rich:column  width="20%" sortable="false" >
                                    <f:facet name="header"><h:outputText  value="Site" /></f:facet>
                                    <h:outputText value="#{sds.cleCodeSite} #{sds.cleLibelleSite}" rendered="#{sds.affiche_site}"/>
                                </rich:column>
                                <rich:column  width="10%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_departement}">
                                    <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                    <h:selectBooleanCheckbox value="#{sds.select_departement}" rendered="#{sds.affiche_departement}"/>
                                </rich:column>
                                <rich:column  width="20%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_departement}">
                                    <f:facet name="header"><h:outputText  value="Département" /></f:facet>
                                    <h:outputText value="#{sds.cleCodeDepartement} #{sds.cleLibelleDepartement}" rendered="#{sds.affiche_departement}"/>
                                </rich:column>
                                <rich:column  width="10%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_service}">
                                    <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                    <h:selectBooleanCheckbox value="#{sds.select_service}" rendered="#{sds.affiche_service}"/>
                                </rich:column>
                                <rich:column  width="20%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_service}">
                                    <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                                    <h:outputText value="#{sds.cleCodeService} #{sds.cleLibelleService}" rendered="#{sds.affiche_service}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                    <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.natureRepartition=='101'}">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable  enableContextMenu="false" id="tableRegSecPdv"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="200px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.lesRegSecPdv}" var="rsp" >
                                <rich:column  width="10%" sortable="false" >
                                    <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                    <h:selectBooleanCheckbox value="#{rsp.select_region}" rendered="#{rsp.affiche_region}"/>
                                </rich:column>
                                <rich:column  width="20%" sortable="false" >
                                    <f:facet name="header"><h:outputText  value="Région" /></f:facet>
                                    <h:outputText value="#{rsp.cleCodeRegion} #{rsp.cleLibelleRegion}" rendered="#{rsp.affiche_region}"/>
                                </rich:column>
                                <rich:column  width="10%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_secteur}">
                                    <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                    <h:selectBooleanCheckbox value="#{rsp.select_secteur}" rendered="#{rsp.affiche_secteur}"/>
                                </rich:column>
                                <rich:column  width="20%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_secteur}">
                                    <f:facet name="header"><h:outputText  value="Secteur" /></f:facet>
                                    <h:outputText value="#{rsp.cleCodeSecteur} #{rsp.cleLibelleSecteur}" rendered="#{rsp.affiche_secteur}"/>
                                </rich:column>
                                <rich:column  width="10%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_pdv}">
                                    <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                    <h:selectBooleanCheckbox value="#{rsp.select_pdv}" rendered="#{rsp.affiche_pdv}"/>
                                </rich:column>
                                <rich:column  width="20%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_pdv}">
                                    <f:facet name="header"><h:outputText  value="P.D.V." /></f:facet>
                                    <h:outputText value="#{rsp.cleCodePdv} #{rsp.cleLibellePdv}" rendered="#{rsp.affiche_pdv}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                    <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.natureRepartition=='102'}">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable  enableContextMenu="false" id="tableSitLigAte"  border="0" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="200px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.lesSitLigAte}" var="sla" >
                                <rich:column  width="10%" sortable="false" >
                                    <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                    <h:selectBooleanCheckbox value="#{sla.select_site}" rendered="#{sla.affiche_sitePrdv}"/>
                                </rich:column>
                                <rich:column  width="20%" sortable="false" >
                                    <f:facet name="header"><h:outputText  value="Site" /></f:facet>
                                    <h:outputText value="#{sla.cleCodeSite} #{sla.cleLibelleSite}" rendered="#{sla.affiche_sitePrdv}"/>
                                </rich:column>
                                <rich:column  width="10%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_ligne}">
                                    <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                    <h:selectBooleanCheckbox value="#{sla.select_ligne}" rendered="#{sla.affiche_ligne}"/>
                                </rich:column>
                                <rich:column  width="20%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_ligne}">
                                    <f:facet name="header"><h:outputText  value="Ligne" /></f:facet>
                                    <h:outputText value="#{sla.cleCodeLigne} #{sla.cleLibelleLigne}" rendered="#{sla.affiche_ligne}"/>
                                </rich:column>
                                <rich:column  width="10%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_atelier}">
                                    <f:facet name="header"><h:outputText  value="Sélect." /></f:facet>
                                    <h:selectBooleanCheckbox value="#{sla.select_atelier}" rendered="#{sla.affiche_atelier}"/>
                                </rich:column>
                                <rich:column  width="20%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_atelier}">
                                    <f:facet name="header"><h:outputText  value="Atelier" /></f:facet>
                                    <h:outputText value="#{sla.cleCodeAtelier} #{sla.cleLibelleAtelier}" rendered="#{sla.affiche_atelier}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </h:panelGrid>

                <h:panelGrid width="100%" id="calculRep" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.mode_calcul}">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable  enableContextMenu="false" id="tableRep" border="0" headerClass="headerTab" noDataLabel=" " activeClass="active-row" rowClasses="rows1,rows2,rowsd" width="100%" height="300px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.lesPlanAnalytiqueRepartitions}" var="rep" >
                            <rich:column  width="200" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_activite}">
                                <f:facet name="header"><h:outputText  value="Activité" /></f:facet>
                                <h:outputText value="#{rep.cleCodeActivite} #{rep.cleLibelleActivite}" rendered="#{rep.affiche_activite}"/>
                            </rich:column>
                            <rich:column  width="90" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_activite}">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{rep.cleRepActivite}" rendered="#{rep.affiche_activite}" style="width:90%;text-align:right;"/>
                            </rich:column>
                            <rich:column  width="200" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_site}">
                                <f:facet name="header"><h:outputText  value="Site" /></f:facet>
                                <h:outputText value="#{rep.cleCodeSite} #{rep.cleLibelleSite}" rendered="#{rep.affiche_site}"/>
                            </rich:column>
                            <rich:column  width="90" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_site}">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{rep.cleRepSite}" rendered="#{rep.affiche_site}" style="width:90%;text-align:right;"/>
                            </rich:column>
                            <rich:column  width="200" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_departement}">
                                <f:facet name="header"><h:outputText  value="Département" /></f:facet>
                                <h:outputText value="#{rep.cleCodeDepartement} #{rep.cleLibelleDepartement}" rendered="#{rep.affiche_departement}"/>
                            </rich:column>
                            <rich:column  width="90" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_departement}">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{rep.cleRepDepartement}" rendered="#{rep.affiche_departement}" style="width:90%;text-align:right;"/>
                            </rich:column>
                            <rich:column  width="200" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_service}">
                                <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                                <h:outputText value="#{rep.cleCodeService} #{rep.cleLibelleService}" rendered="#{rep.affiche_service}"/>
                            </rich:column>
                            <rich:column  width="90" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_service}">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{rep.cleRepService}" rendered="#{rep.affiche_service}" style="width:90%;text-align:right;"/>
                            </rich:column>
                            <rich:column  width="200" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_region}">
                                <f:facet name="header"><h:outputText  value="Région" /></f:facet>
                                <h:outputText value="#{rep.cleCodeRegion} #{rep.cleLibelleRegion}" rendered="#{rep.affiche_region}"/>
                            </rich:column>
                            <rich:column  width="90" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_region}">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{rep.cleRepRegion}" rendered="#{rep.affiche_region}" style="width:90%;text-align:right;"/>
                            </rich:column>
                            <rich:column  width="200" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_secteur}">
                                <f:facet name="header"><h:outputText  value="Secteur" /></f:facet>
                                <h:outputText value="#{rep.cleCodeSecteur} #{rep.cleLibelleSecteur}" rendered="#{rep.affiche_secteur}"/>
                            </rich:column>
                            <rich:column  width="90" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_secteur}">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{rep.cleRepSecteur}" rendered="#{rep.affiche_secteur}" style="width:90%;text-align:right;"/>
                            </rich:column>
                            <rich:column  width="200" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_pdv}">
                                <f:facet name="header"><h:outputText  value="P.D.V." /></f:facet>
                                <h:outputText value="#{rep.cleCodePdv} #{rep.cleLibellePdv}" rendered="#{rep.affiche_pdv}"/>
                            </rich:column>
                            <rich:column  width="90" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_pdv}">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{rep.cleRepPdv}" rendered="#{rep.affiche_pdv}" style="width:90%;text-align:right;"/>
                            </rich:column>
                            <rich:column  width="200" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_sitePrdv}">
                                <f:facet name="header"><h:outputText  value="Site" /></f:facet>
                                <h:outputText value="#{rep.cleCodeSite} #{rep.cleLibelleSite}" rendered="#{rep.affiche_site}"/>
                            </rich:column>
                            <rich:column  width="90" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_sitePrdv}">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{rep.cleRepSite}" rendered="#{rep.affiche_site}" style="width:90%;text-align:right;"/>
                            </rich:column>
                            <rich:column  width="200" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_ligne}">
                                <f:facet name="header"><h:outputText  value="Ligne" /></f:facet>
                                <h:outputText value="#{rep.cleCodeLigne} #{rep.cleLibelleLigne}" rendered="#{rep.affiche_ligne}"/>
                            </rich:column>
                            <rich:column  width="90" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_ligne}">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{rep.cleRepLigne}" rendered="#{rep.affiche_ligne}" style="width:90%;text-align:right;"/>
                            </rich:column>
                            <rich:column  width="200" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_atelier}">
                                <f:facet name="header"><h:outputText  value="Atelier" /></f:facet>
                                <h:outputText value="#{rep.cleCodeAtelier} #{rep.cleLibelleAtelier}" rendered="#{rep.affiche_atelier}"/>
                            </rich:column>
                            <rich:column  width="90" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_atelier}">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{rep.cleRepAtelier}" rendered="#{rep.affiche_atelier}" style="width:90%;text-align:right;"/>
                            </rich:column>
                            <rich:column  width="200" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_parc}">
                                <f:facet name="header"><h:outputText  value="Parc" /></f:facet>
                                <h:outputText value="#{rep.cleCodeParc} #{rep.cleLibelleParc}" rendered="#{rep.affiche_parc}"/>
                            </rich:column>
                            <rich:column  width="90" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_parc}">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{rep.cleRepParc}" rendered="#{rep.affiche_parc}" style="width:90%;text-align:right;"/>
                            </rich:column>
                            <rich:column  width="200" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_dossier==1}">
                                <f:facet name="header"><h:outputText  value="Dossier" /></f:facet>
                                <h:outputText value="#{rep.cleCodeDossier} #{rep.cleLibelleDossier}"/>
                            </rich:column>
                            <rich:column  width="90" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_dossier==1}">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{rep.cleRepDossier}" style="width:90%;text-align:right;"/>
                            </rich:column>
                            <rich:column  width="200" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_agent}">
                                <f:facet name="header"><h:outputText  value="Agent" /></f:facet>
                                <h:outputText value="#{rep.cleCodeAgent} #{rep.cleLibelleAgent}" rendered="#{rep.affiche_agent}"/>
                            </rich:column>
                            <rich:column  width="90" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.affiche_agent}">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{rep.cleRepAgent}" rendered="#{rep.affiche_agent}" style="width:90%;text-align:right;"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>

            </h:panelGrid>

            <br><br>
            <center>
                <h:panelGrid>
                    <h:commandButton value="Calcule répartition..." action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.calculeRepartition}" style="text-decoration:none;" id="calRep" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.natureRepartition!=0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.mode_calcul}"/>
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.validerRepartition}" reRender="tableCompte,btnCompte,panelRepartition" style="text-decoration:none;" id="valRep" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.mode_calcul}">
                        <rich:componentControl for="panelRepartition" attachTo="valRep" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </h:panelGrid>
            </center>

        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelPlanActivite" width="900" height="420" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.showModalPanelActivite}">
        <f:facet name="header"><h:outputText value="GESTION DES SECTIONS ACTIVITES"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.annulerActivite}" image="/images/close.gif" styleClass="hidelink" />
            </a4j:form>
        </f:facet>
        <a4j:form >
            <rich:tabPanel switchType="client" immediate="true"   style="width:100%;border:0px;" id="formModalActivite">

                <rich:tab label="Général">
                    <h:panelGrid columns="2" id="mod" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Code:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaCode}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.showOngletCompte}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaId!=0}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                                <a4j:support eventsQueue="maQueue"  event="onblur" reRender="panyas,buttGrp" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.verifCodeActivite}"/>
                            </h:inputText>
                            <h:panelGroup id="panyas">
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.existCod}">
                                    <h:graphicImage url="/images/Warning.png"  style="width:25px;height;"/>
                                    <h:outputText value="Ce code est vide ou existe déja" style="color:red;" />
                                </h:panelGroup>
                            </h:panelGroup>
                        </h:column>
                        <h:column><h:outputText value="Libellé:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaNomFr}" onkeypress="return scanToucheLettre(event)" style="width:340px;text-transform:uppercase"/></h:column>
                        <h:column><h:outputText value="Inactif:"/></h:column>
                        <h:column><h:selectBooleanCheckbox  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.inactifPlb}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" headerClass="headerTab" width="100%">
                        <f:facet name="header"><h:outputText value="Accessibles dans :"/></f:facet>
                        <h:column><h:outputText value="Ventes:"/></h:column>
                        <h:column><h:selectBooleanCheckbox  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaVte}"/></h:column>
                        <h:column><h:outputText value="Achats:"/></h:column>
                        <h:column><h:selectBooleanCheckbox  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaAch}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strtypeentreprise=='2'}"><h:outputText value="Production:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strtypeentreprise=='2'}"><h:selectBooleanCheckbox  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaPrd}"/></h:column>
                        <h:column><h:outputText value="Frais généraux:"/></h:column>
                        <h:column><h:selectBooleanCheckbox  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaFrg}"/></h:column>
                        <h:column><h:outputText value="Investissements:"/></h:column>
                        <h:column><h:selectBooleanCheckbox  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaInv}"/></h:column>
                        <h:column><h:outputText value="Impôts et taxes:"/></h:column>
                        <h:column><h:selectBooleanCheckbox  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaTax}"/></h:column>
                        <h:column><h:outputText value="Salariés:"/></h:column>
                        <h:column><h:selectBooleanCheckbox  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.plansAnalytiques.anaSal}"/></h:column>
                    </h:panelGrid>                              
                    <center>
                        <h:panelGroup id="buttGrp">
                            <h:commandButton image="/images/valider_big.png" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.existCod}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansAnalytiques.savePlanActivite}" style="margin-top:5px;" />
                        </h:panelGroup>
                    </center>
                </rich:tab>

            </rich:tabPanel>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
