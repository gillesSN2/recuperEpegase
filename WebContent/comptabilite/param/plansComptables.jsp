<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<script type="text/JavaScript" language="JavaScript">

    function verifForm(Form)
    {
        if(document.getElementById("Form:pgNumCpt1").value == ""||document.getElementById("Form:ncompte").value == "")
            alert('Les zones numero de Compte et Intitulé Compte sont obligatoires \!\!');
        else
            Form.submit();
    }

</script>

<f:subview id="planCpte">

    <a4j:form id="plancompta">

        <center>
            <h2>
                <h:outputText value="PLAN COMPTABLE #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonefiscale}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.choixRacine==0}" style="color:green;font-size:16px;"/>
                <h:outputText value="PLAN COMPTABLE #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.selecFiscalite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.choixRacine!=0}" style="color:green;font-size:16px;"/>&nbsp;&nbsp;
                <h:commandButton title="Permutter la fiscalité du plan comptable" image="/images/permutter.jpeg" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.permutterMesracines}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.choixRacine!=0}" onclick="javascript:Richfaces.showModalPanel('modAttente');" />
            </h2>
        </center>

        <center>
            <h:panelGroup id="panGlobal">
                <h:panelGroup id="butt">
                    <a4j:commandButton value="Ajout par Défaut" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.defaultAdd}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.afficheAjDefaut}" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:180px;cursor:pointer;" onclick="if (!confirm('Voulez-vous charger le plan comptable par défaut?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,butt,panGlobal,pan11,table"/>
                    <br>
                    <a4j:commandButton  title="Ajouter un nouveau compte" image="/images/ajouter.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.ajoutCompte}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.afficheAjout}" oncomplete="javascript:Richfaces.showModalPanel('panelCompte');" reRender="panGlobal,panelCompte,panelGestionComptes"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton title="Modifier le compte sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.afficheButtMod}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.modifCompte}" oncomplete="javascript:Richfaces.showModalPanel('panelCompte');" reRender="panGlobal,panelCompte,panelGestionComptes"/>&nbsp;&nbsp;&nbsp;
                    <h:commandButton title="Désactiver le compte sélectionné" image="/images/supprimer.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.afficheAjout&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.afficheButtSup)==true}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.removeSelectedPlanComptable}"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton title="Imprimer le plan comptable sélectionné" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"></a4j:commandButton>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton title="Désactiver tous les comptes non mouvementés de la liste en cours" image="/images/geler.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.afficheAjout)==true}" onclick="if (!confirm('Etes vous sur de vouloir désactiver tous les comptes non mouvementés de la liste en cours cet element?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panGlobal,butt,pan11,table" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.removeNonMouvementePlanComptable}"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton title="Résactiver tous les comptes de la liste en cours" image="/images/degeler.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.afficheAjout)==true}" onclick="if (!confirm('Etes vous sur de vouloir réactiver tous les comptes de la liste en cours cet element?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panGlobal,butt,pan11,table" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.reactivePlanComptable}"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton image="/images/exporter.png" title="Exporter le plan comptable en XML" style="text-decoration:none;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.exportXML}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente" rendered="false"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton image="/images/duplicate.png" title="Copier ancien plan dans nouvean plan" style="text-decoration:none;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.fusionnerPlanComptable}" onclick="if (!confirm('Etes vous sur de vouloir effectuer cette opération?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panGlobal," rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.choixRacine==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.afficheAjout}"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton image="/images/parametre.png" title="Transformer l`exercice de l`ancien plan vers le nouveau plan (ATTENTION CETTE OPERATION EST IRREVERSIBLE!)" style="text-decoration:none;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.transformerPlanComptable}" onclick="if (!confirm('Etes vous sur de vouloir effectuer cette opération?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panGlobal," rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.choixRacine==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.afficheAjout}"/>
                </h:panelGroup>

                <h:panelGrid id="pan11" style="max-height:100%;border:1px;" columns="3">
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.natureFiscale}">
                        <f:selectItem itemLabel="Sélectionnez le plan" itemValue="9999"/>
                        <f:selectItem itemLabel="0:Plan Général" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.naturFiscalItem}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panGlobal,pan11,table,panmouv,modAttente,scrollTable,pgrd2"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.selectionChargement}"/>
                    </h:selectOneMenu>
                    <h:panelGroup id="panmouv">
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.mouvement}" id="mouvment" >
                            <f:selectItem itemLabel="Tous les comptes" itemValue="0"/>
                            <f:selectItem itemLabel="Comptes mouvementés" itemValue="1"/>
                            <f:selectItem itemLabel="Comptes non mouvementés" itemValue="2"/>
                            <f:selectItem itemLabel="Comptes avec imputation analytique" itemValue="3"/>
                            <f:selectItem itemLabel="Comptes avec Compte SAGE" itemValue="4"/>
                            <f:selectItem itemLabel="Comptes avec compte SYSCOHADA" itemValue="5"/>
                            <f:selectItem itemLabel="Comptes avec autre fiscalité" itemValue="6"/>
                            <f:selectItem itemLabel="Comptes non convertis" itemValue="7"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panGlobal,pan11,table,scrollTable,butt,pgrd2"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.selectionChargement}"/>
                        </h:selectOneMenu>
                    </h:panelGroup>
                    <h:panelGroup id="panexo">
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.annee}" id="annee" >
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.lesAnneesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panGlobal,pan11,table,scrollTable,butt,pgrd2"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.selectionChargement}"/>
                        </h:selectOneMenu>
                    </h:panelGroup>
                </h:panelGrid>
                <br>

                <h:panelGrid id="pgrd2" style="width:100%;max-height:100%;">
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="table"/>
                        <rich:extendedDataTable rows="200" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.madatamodel}" var="plan" id="table" border="0" styleClass="bg" style="max-height:100%;border:solid 0px green" width="100%" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,butt"/>
                            <rich:column width="15%" sortable="true" sortBy="#{plan.plcCompte}" sortOrder="ASCENDING">
                                <f:facet name="header"><h:outputText value="N° Compte" /></f:facet>
                                <h:outputText value="#{plan.plcCompte}"/>
                            </rich:column>
                            <rich:column  width="33%" sortable="true" sortBy="#{plan.plcLibelleCpteFR}">
                                <f:facet name="header"><h:outputText value="Intitulé Compte"  /></f:facet>
                                <h:outputText value="#{plan.plcLibelleCpteFR}"/>
                            </rich:column>
                            <rich:column  width="8%" sortable="true" sortBy="#{plan.plcCodeRacine}">
                                <f:facet name="header"><h:outputText value="Racine" /></f:facet>
                                <h:outputText value= "#{plan.plcCodeRacine}"/>
                            </rich:column>
                            <rich:column  width="10%" sortable="true" sortBy="#{plan.plcLibelleNatureFR}">
                                <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                                <h:outputText value="(#{plan.plcNature}) #{plan.plcLibelleNatureFR}"/>
                            </rich:column>
                            <rich:column width="10%" sortable="true" sortBy="#{plan.plcSage}">
                                <f:facet name="header"><h:outputText value="N° Sage" /></f:facet>
                                <h:outputText value="#{plan.plcSage}"/>
                            </rich:column>
                            <rich:column width="10%" sortable="true" sortBy="#{plan.plcCompteSyscohada}">
                                <f:facet name="header"><h:outputText value="Syscohada" /></f:facet>
                                <h:outputText value="#{plan.plcCompteSyscohada}"/>
                            </rich:column>
                            <rich:column width="10%" sortable="true" sortBy="#{plan.plcCompteAutre}">
                                <f:facet name="header"><h:outputText value="Autre Fis." /></f:facet>
                                <h:outputText value="#{plan.plcCompteAutre}"/>
                            </rich:column>
                            <rich:column  id="inact"  width="5%" sortable="true" sortBy="#{plan.plcInactif}">
                                <f:facet name="header"><h:outputText value="Etat" /></f:facet>
                                <h:commandButton  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.disable}" image="#{plan.etat}"  id="inactif"  rendered="#{plan.afficheImag}"  onclick="if (!confirm('Voulez-vous réactiver ce compte ?')) return false;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.reactiverCompte}">
                                    <a4j:support eventsQueue="maQueue" reRender="pan11" event="onclick"/>
                                </h:commandButton>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </h:panelGroup>
            <br>
            <h:commandButton id="idCancel" styleClass="exp_lienmenu" value="RETOUR" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}"/>
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelCompte" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="700" height="400" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.var_affPanelCompte}">
        <center>
            <f:facet name="header"><h:outputText value="Gestion des comptes"/></f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/images/close.gif" id="hidelink"/>
                    <rich:componentControl for="panelCompte" attachTo="hidelink" operation="hide" event="onclick"/>
                </h:panelGroup>
            </f:facet>
            <a4j:form>
                <h:panelGrid id="panelGestionComptes">
                    <rich:tabPanel switchType="client" immediate="true"  id="rtab" style="border:0px">

                        <rich:tab label="Génèral">
                            <h:panelGrid border="0" columns="1" style="text-align:left;" id="pgrd1">
                                <h:panelGroup>
                                    <h:outputText value="Intitulé Nature:"/>
                                    <h:selectOneMenu disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.oneMenuModif}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.intituleNat}" style="margin-left:40px;width:400px;">
                                        <f:selectItem itemLabel="Choisir une nature" itemValue="0"/>
                                        <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.naturFiscalItem}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="ir,other,buttonValid" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.recuperNatureFiscal}"/>
                                    </h:selectOneMenu>
                                </h:panelGroup>
                                <h:panelGroup id="ir">
                                    <h:outputText value="Intitulé Racine:"/>
                                    <h:selectOneMenu disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.oneMenuModif}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.intituleRac}" style="margin-left:35px;width:400px;">
                                        <f:selectItem itemLabel="Choisir une racine" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.racinesItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.recuperRacine}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,intRac,pgNumCpt,other,buttonValid,panelWarn"/>
                                    </h:selectOneMenu>
                                </h:panelGroup>
                            </h:panelGrid>
                            <h:panelGrid columns="2" id="other">
                                <h:outputText value="Racine/Compte:" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.oneMenuModif}"/>
                                <h:panelGroup id="intRac" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.oneMenuModif}">
                                    <h:outputText style="margin-left:25px;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.racines.racCode}" id="inpRacCpt"/>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.complNum}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.vhlibre}" id="ncompte" maxlength="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.nbcarmax}">
                                        <a4j:support eventsQueue="maQueue" event="onblur" reRender="GrpMunCpt,other,panelWarn,buttonValid" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.recupererNumero}"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:outputText value="Numero compte:"/>
                                <h:panelGroup id="GrpMunCpt">
                                    <h:inputText style="margin-left:25px;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.planComptable.plcCompte}" id="inpMunCpt" readonly="true"/>
                                </h:panelGroup>
                                <h:outputText value="Intitulé Compte:"/>
                                <h:panelGroup id="pgNumCpt">
                                    <h:inputText style="margin-left:25px;width:400px;" onkeypress="return scanToucheLettre(event)" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.planComptable.plcLibelleCpteFR}" id="pgNumCpt1" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.vhlibre}"/>
                                </h:panelGroup>
                                <h:outputText value="RAN Detaillé:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.affichRan}" />
                                <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.planComptable.plcRanDetaille}"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.vhcd}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.affichRan}"  style="margin-left:25px;">
                                </h:selectBooleanCheckbox>
                                <h:outputText  value="Taux Taxe:" id="taxe" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.affichTauxTaxe}"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.planComptable.plcTauxTaxe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.affichTauxTaxe}" id= "tauTax" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.vhtt}"  style="margin-left:25px;"/>
                                <h:outputText value="Inactif:"/>
                                <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.inactif}" style="margin-left:25px;"/>
                                <h:outputText value="Compte SAGE:"/>
                                <h:panelGroup><h:inputText style="margin-left:25px;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.planComptable.plcSage}" maxlength="20"/></h:panelGroup>
                                <h:outputText value="Compte SYSCOHADA:"/>
                                <h:panelGroup><h:inputText style="margin-left:25px;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.planComptable.plcCompteSyscohada}" maxlength="20"/></h:panelGroup>
                                <h:outputText value="Compte autre fiscalité:"/>
                                <h:panelGroup><h:inputText style="margin-left:25px;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.planComptable.plcCompteAutre}" maxlength="20"/></h:panelGroup>
                            </h:panelGrid>
                            <h:panelGrid columns="3" id="panelWarn">
                                <h:graphicImage  url="/images/Warning.png" style="width:20px;heigh:20px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.existeCopteDeja}"/>
                                <h:outputText value="Ce compte est invalide ou existe déja"  style="color:red;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.existeCopteDeja}"/>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab label="Analytique" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionComptabilite.analytique=='true'}">
                            <h:panelGrid columns="2" columnClasses="clos20,clos80">
                                <h:outputText value="Clé 1:"/>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.planComptable.plcAnalCle1}" style="margin-left:35px;width:400px;">
                                    <f:selectItem  itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.mesClesAnalytiques}"/>
                                </h:selectOneMenu>
                                <h:outputText value="Clé 2:"/>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.planComptable.plcAnalCle2}" style="margin-left:35px;width:400px;">
                                    <f:selectItem  itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.mesClesAnalytiques}"/>
                                </h:selectOneMenu>
                            </h:panelGrid>
                        </rich:tab>

                    </rich:tabPanel>
                </h:panelGrid>
                <center>
                    <h:panelGroup id="buttonValid">
                        <h:commandButton title="Valider"style="margin-top:10px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.existeCopteDeja}" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanComptable.valider}"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </center>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>