
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="feuilleCalcul">

    <a4j:form id="feuillecalcul">

        <center> <h2><h:outputText value="LISTE DES FEUILLES DE CALCUL" style="color:green;font-size:16px;"/></h2></center>

        <center>
            <h:panelGroup id="butt">
                <a4j:commandButton value="Ajout par Défaut" onclick="if (!confirm('Voulez-vous charger les feuilles de calcul par défaut?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.defaultAdd}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.afficheAjDefaut}" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:180px;cursor:pointer;" reRender="butt,idRecherche,table,modAttente"/>
                <br>
                <a4j:commandButton image="/images/ajouter.png" title="Ajouter une feuille de calcul" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.ajouterFeuille}" reRender="panelFeuille,panelGestionFeuille"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a4j:commandButton image="/images/duplicate.png" title="Duppliquer la feuille sélectionnée" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.afficheFeuille}" onclick="if (!confirm('Etes vous sur de vouloir dupliquer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.duppliquerFeuille}" reRender="modAttente,butt,table"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a4j:commandButton image="/images/modifier.png" title="Modifier la feuille sélectionnée" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.afficheFeuille}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.modifierFeuille}" reRender="panelFeuille,panelGestionFeuille"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a4j:commandButton image="/images/supprimer.png" title="Supprimer la feuille sélectionnée" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.afficheFeuille}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.supprimerFeuille}" reRender="butt,table"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a4j:commandButton image="/images/print.png" title="Imprimer la liste des feuilles" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"></a4j:commandButton>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a4j:commandButton image="/images/print.png" title="Imprimer la structure de la feuille" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.afficheFeuille}" oncomplete="javascript:Richfaces.showModalPanel('panelImpStructure');"></a4j:commandButton>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a4j:commandButton image="/images/actualiser.png" title="Vérification des feuilles et des formules" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.afficheFeuille}" onclick="if (!confirm('Etes vous sur de vouloir vérifier les feuilles et les formules?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.verifierFeuille}" reRender="butt,modAttente"></a4j:commandButton>
            </h:panelGroup>

            <h:panelGrid id="idRecherche" style="max-height:100%;border:1px;" columns="2">
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.nature}">
                    <f:selectItem itemLabel="Sélectionnez la nature" itemValue="9999"/>
                    <f:selectItem itemLabel="Toutes les natures" itemValue="100"/>
                    <f:selectItems id="idNatSal" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.mesNaturesItems}"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="idRecherche,table,idUtilisation,modAttente,scrollTable" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.chargerFeuilleCalcul}"/>
                </h:selectOneMenu>
                <h:panelGroup id="idUtilisation">
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.utilisation}" id="mouvment" >
                        <f:selectItem itemLabel="Toutes les feuilles" itemValue="0"/>
                        <f:selectItem itemLabel="Feuilles utilisées" itemValue="1"/>
                        <f:selectItem itemLabel="Feuilles non utilisées" itemValue="2"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="idRecherche,table,scrollTable"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.chargerFeuilleCalcul}" >
                        </a4j:support>
                    </h:selectOneMenu>
                </h:panelGroup>
            </h:panelGrid>
            <br>

            <h:panelGrid id="pgrd2" style="width:100%;max-height:100%;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="200" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.dataModelFeuillesCalcul}" var="plan" id="table" border="0" styleClass="bg" style="max-height:100%;border:solid 0px green" width="100%" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.selectionFeuille}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,butt"/>
                        <rich:column  width="12%" sortable="true" sortBy="#{plan.libelleNature}">
                            <f:facet name="header"><h:outputText value="Nature" /></f:facet>
                            <h:outputText value= "#{plan.libelleNature}" title="#{plan.libelleNature}"/>
                        </rich:column>
                        <rich:column width="8%" sortable="true" sortBy="#{plan.feuCode}" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText value="Code" /></f:facet>
                            <h:outputText value="#{plan.feuCode}" title="#{plan.feuCode}"/>
                        </rich:column>
                        <rich:column width="30%" sortable="true" sortBy="#{plan.feuLibelleFr}">
                            <f:facet name="header"><h:outputText value="Intitulé Feuille"/></f:facet>
                            <h:outputText value="#{plan.feuLibelleFr}" title="#{plan.feuLibelleFr}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="true" sortBy="#{plan.feuModele}">
                            <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                            <h:outputText value="#{plan.feuModele}" title="#{plan.feuModele}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="true" sortBy="#{plan.feuModeleMat}">
                            <f:facet name="header"><h:outputText value="Modèle Mat."/></f:facet>
                            <h:outputText value="#{plan.feuModeleMat}" title="#{plan.feuModeleMat}"/>
                        </rich:column>
                        <rich:column width="12%" sortable="true" sortBy="#{plan.feuJournal}">
                            <f:facet name="header"><h:outputText value="Journal"/></f:facet>
                            <h:outputText value="#{plan.feuJournal}" title="#{plan.feuJournal}"/>
                        </rich:column>
                        <rich:column width="8%" sortable="true" sortBy="#{plan.feuDecale}">
                            <f:facet name="header"><h:outputText value="Décalage"/></f:facet>
                            <h:outputText value="#{plan.feuDecale}" rendered="#{plan.feuDecale!=0}"/>
                        </rich:column>
                        <rich:column id="inact" width="10%" sortable="true" sortBy="#{plan.feuInactif}" style="text-align:center;">
                            <f:facet name="header"><h:outputText value="Etat"/></f:facet>
                            <h:commandButton image="#{plan.etat}" id="inactif" rendered="#{plan.afficheImag}" onclick="if (!confirm('Voulez-vous réactiver cette feuille ?')) return false;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.reactiveFeuille}">
                                <a4j:support eventsQueue="maQueue" reRender="idRecherche" event="onclick"/>
                            </h:commandButton>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>
            <br>
            <h:commandButton id="idCancel" styleClass="exp_lienmenu" value="RETOUR" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}"/>
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelFeuille" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1000" height="650" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.showModalPanelFeuille}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.showModalPanelFeuille}" var="feu">
            <f:facet name="header"><h:outputText value="Gestion de la feuille de calcul N° #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalcul.feuCode}  #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalcul.feuLibelleFr}"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.annulerFeuille}" image="/images/close.gif" styleClass="hidelink" reRender="panelFeuille"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid id="panelGestionFeuille" style="width:100%;">
                    <rich:tabPanel switchType="client" immediate="true" style="border:0px">

                        <rich:tab label="Description Feuille">
                            <a4j:support eventsQueue="maQueue" event="onlabelclick" reRender="panDescription"/>
                            <h:panelGrid id="panDescription" columns="2" columnClasses="clos20,clos80" style="width:100%;">
                                <h:column><h:outputText value="Intitulé Nature:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalcul.feuNature}" style="width:100%;" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.saisieCode}">
                                        <f:selectItem itemLabel="Sélectionnez la nature" itemValue="9999"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.mesNaturesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" columnClasses="clos20,clos80" style="width:100%;">
                                <h:column><h:outputText value="Code feuille:"/></h:column>
                                <h:column>
                                    <h:inputText style="width:100px;" maxlength="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalcul.feuCode}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.saisieCode}">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.testeUniciteFeuille}" reRender="buttonValid"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Intitulé Feuille:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalcul.feuLibelleFr}"/></h:column>
                                <h:column><h:outputText value="Modèle Standard:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalcul.feuModele}" style="width:100%;">
                                        <f:selectItems id="idModele" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.mesModelesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Modèle Matricielle:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalcul.feuModeleMat}" style="width:100%;">
                                        <f:selectItem itemLabel="Sans modéle" itemValue=""/>
                                        <f:selectItems id="idModeleMat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.mesModelesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Journal:"/></h:column>
                                <h:column>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.exerciceCompta}" var="s1">
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalcul.feuJournal}" style="width:100%;">
                                            <f:selectItem itemLabel="Sans journal" itemValue=""/>
                                            <f:selectItems id="idJournal" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.mesJournauxItems}"/>
                                        </h:selectOneMenu>
                                    </c:if>
                                    <c:if test="${!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.exerciceCompta}" var="s2">
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalcul.feuJournal}" style="width:100%;"/>
                                    </c:if>
                                </h:column>
                                <h:column><h:outputText value="Nb jours décallage:"/></h:column>
                                <h:column>
                                    <h:inputText size="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalcul.feuDecale}"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="(Si 0 alors génération calendaire)"/>
                                </h:column>
                                <h:column><h:outputText value="Inactif:"/></h:column>
                                <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.inactif}"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" id="panelWarn">
                                <h:graphicImage  url="/images/Warning.png" style="width:20px;heigh:20px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.existeCopteDeja}"/>
                                <h:outputText value="Cette rubrique est invalide ou existe déja" style="color:red;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.existeCopteDeja}"/>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab label="Structure Feuille" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalcul.feu_id!=0}">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable rows="200" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.dataModelRubrique}" var="rubC" id="tableRubiqueConstruction" border="0" styleClass="bg" style="border:solid 0px green" width="100%" height="500px" footerClass="bard" headerClass="headerTab" enableContextMenu="false" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.simpleSelectionEntete}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.extDTable}">
                                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.selectionRubrique}" reRender="idColCompte,idCmd"/>
                                    <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.detailRubrique}" reRender="idColCompte,idCmd"/>
                                    <rich:column id="idSel" width="7%" sortable="true" style="text-align:center;" sortBy="#{rubC.feurubActif} #{rubC.planPaye.plpCode}">
                                        <f:facet name="header"><h:outputText value="Sél."/></f:facet>
                                        <h:selectBooleanCheckbox value="#{rubC.feurubActif}" disabled="true"  style="#{rubC.couleurImpot}"/>
                                    </rich:column>
                                    <rich:column  width="9%" sortable="true" sortBy="#{rubC.planPaye.libelleNature} #{rubC.planPaye.plpCode}">
                                        <f:facet name="header"><h:outputText value="Nature" /></f:facet>
                                        <h:outputText value= "#{rubC.planPaye.libelleNature}"  style="#{rubC.couleurImpot}"/>
                                    </rich:column>
                                    <rich:column width="8%" sortable="true" sortBy="#{rubC.planPaye.plpCode}">
                                        <f:facet name="header"><h:outputText value="Code" /></f:facet>
                                        <h:outputText value="#{rubC.planPaye.plpCode}"  style="#{rubC.couleurImpot}"/>
                                    </rich:column>
                                    <rich:column width="23%" sortable="true" sortBy="#{rubC.planPaye.plpLibelleFR}">
                                        <f:facet name="header"><h:outputText value="Intitulé Rubrique"/></f:facet>
                                        <h:outputText value="#{rubC.planPaye.plpLibelleFR}"  style="#{rubC.couleurImpot}"/>
                                    </rich:column>
                                    <rich:column width="5%" sortable="true" style="text-align:center;" sortBy="#{rubC.planPaye.libelleSens}">
                                        <f:facet name="header"><h:outputText value="Type"/></f:facet>
                                        <h:outputText value="#{rubC.planPaye.libelleSens}"  style="#{rubC.couleurImpot}"/>
                                    </rich:column>
                                    <rich:column id="idColA" width="7%" sortable="true" style="text-align:center;" sortBy="#{rubC.feurubColA}">
                                        <f:facet name="header"><h:outputText value="A-Calcul"/></f:facet>
                                        <h:selectBooleanCheckbox value="#{rubC.feurubColA}" rendered="#{rubC.feurubActif}" disabled="true"  style="#{rubC.couleurImpot}"/>
                                    </rich:column>
                                    <rich:column id="idColB"  width="7%" sortable="true" style="text-align:center;" sortBy="#{rubC.feurubColB}">
                                        <f:facet name="header"><h:outputText value="B-Base"/></f:facet>
                                        <h:selectBooleanCheckbox value="#{rubC.feurubColB}" rendered="#{rubC.feurubActif}" disabled="true"  style="#{rubC.couleurImpot}"/>
                                    </rich:column>
                                    <rich:column id="idColC"  width="7%" sortable="true" style="text-align:center;" sortBy="#{rubC.feurubColC}">
                                        <f:facet name="header"><h:outputText value="C-Taux"/></f:facet>
                                        <h:selectBooleanCheckbox value="#{rubC.feurubColC}" rendered="#{rubC.feurubActif}" disabled="true"  style="#{rubC.couleurImpot}"/>
                                    </rich:column>
                                    <rich:column id="idColD"  width="7%" sortable="true" style="text-align:center;" sortBy="#{rubC.feurubColD}">
                                        <f:facet name="header"><h:outputText value="D-Nb"/></f:facet>
                                        <h:selectBooleanCheckbox value="#{rubC.feurubColD}" rendered="#{rubC.feurubActif}" disabled="true"  style="#{rubC.couleurImpot}"/>
                                    </rich:column>
                                    <rich:column id="idColE"  width="7%" sortable="true" style="text-align:center;" sortBy="#{rubC.feurubColE}">
                                        <f:facet name="header"><h:outputText value="E-Résultat"/></f:facet>
                                        <h:selectBooleanCheckbox value="#{rubC.feurubColE}" rendered="#{rubC.feurubActif}" disabled="true"  style="#{plan.couleurImpot}"/>
                                    </rich:column>
                                    <rich:column id="idColCompte" width="13%" sortable="true" sortBy="#{rubC.feurubCompte}">
                                        <f:facet name="header"><h:outputText value="Compte"/></f:facet>
                                        <a4j:commandButton immediate="true" id="idCmd" image="/images/detail.png" style="width:15px;height:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.detailRubrique}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panelRubrique" rendered="#{rubC.select}"/>&nbsp;
                                        <h:inputText value="#{rubC.feurubCompte}" rendered="#{rubC.feurubActif}" style="width:70%;#{rubC.couleurImpot}" disabled="true"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </rich:tab>

                    </rich:tabPanel>
                </h:panelGrid>
                <center>
                    <h:panelGroup id="buttonValid">
                        <a4j:commandButton title="Valider"style="margin-top:10px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalcul.feuNature!=9999&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.existeCopteDeja}" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.validerFeuille}" reRender="panelFeuille,table"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelRubrique" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1200" height="550" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.showModalPanelRubrique}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.showModalPanelRubrique}" var="rub">
            <f:facet name="header"><h:outputText value="Détail de la rubrique : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.planPaye.plpCode}  #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.planPaye.plpLibelleFR}"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.fermerDetailRubrique}" image="/images/close.gif" styleClass="hidelink" reRender="panelRubrique"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid id="panelChoixColonne" width="100%" columns="7" styleClass="recherche">
                    <h:column>
                        <h:outputText value="Rubrique Active:"/>&nbsp;
                        <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubActif}">
                            <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.calculeNbColonnes}" reRender="panelChoixColonne,panelGestionRubrique"/>
                        </h:selectBooleanCheckbox>
                    </h:column>
                    <h:column>
                        <h:outputText value="Colonne A (Calcul):"/>&nbsp;
                        <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubColA}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubActif}">
                            <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.calculeNbColonnes}" reRender="panelChoixColonne,panelGestionRubrique"/>
                        </h:selectBooleanCheckbox>
                    </h:column>
                    <h:column>
                        <h:outputText value="Colonne B (Base):"/>&nbsp;
                        <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubColB}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubActif}">
                            <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.calculeNbColonnes}" reRender="panelChoixColonne,panelGestionRubrique"/>
                        </h:selectBooleanCheckbox>
                    </h:column>
                    <h:column>
                        <h:outputText value="Colonne C (Taux):"/>&nbsp;
                        <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubColC}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubActif}">
                            <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.calculeNbColonnes}" reRender="panelChoixColonne,panelGestionRubrique"/>
                        </h:selectBooleanCheckbox>
                    </h:column>
                    <h:column>
                        <h:outputText value="Colonne D (Nombre):"/>&nbsp;
                        <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubColD}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubActif}">
                            <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.calculeNbColonnes}" reRender="panelChoixColonne,panelGestionRubrique"/>
                        </h:selectBooleanCheckbox>
                    </h:column>
                    <h:column>
                        <h:outputText value="Colonne E (Résultat):"/>&nbsp;
                        <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubColE}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubActif}">
                            <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.calculeNbColonnes}" reRender="panelChoixColonne,panelGestionRubrique"/>
                        </h:selectBooleanCheckbox>
                    </h:column>
                    <h:column>
                        <h:outputText value="Compte rubrique (prioritaire):"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubCompte}" size="6" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubActif}"/>
                    </h:column>
                </h:panelGrid>

                <br>  

                <h:panelGrid id="panelGestionRubrique" width="100%" columns="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.nbColonne}" columnClasses="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.styleColonne}">

                    <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubActif&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubColA}">
                        <h:panelGrid width="200px" id="idBoutonA" columns="4">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter une formule" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.ajouterFormuleA}" reRender="panelFormule,panelGestionFormule"/>
                            <a4j:commandButton image="/images/modifier.png" title="Modifier la formule sélectionnée" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.afficheFormuleA}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.modifierFormuleA}" reRender="panelFormule,panelGestionFormule"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer la formule sélectionnée" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.afficheFormuleA}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.supprimerFormuleA}" reRender="idBoutonA,colonneA"/>
                            <h:selectBooleanCheckbox title="RAZ après cloture" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubColARaz}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubVariableA}">
                                <h:outputText value="RAZ"/>
                            </h:selectBooleanCheckbox>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.dataModelColA}" var="colA" id="colonneA" border="0" styleClass="bg" enableContextMenu="false" style="border:solid 1px green" width="100%" height="300px" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.selectionColonneA}" reRender="idBoutonA"/>
                                <rich:column  width="100%" sortable="false" style="text-align:left;">
                                    <f:facet name="header"><h:outputText value="Interne Col(A)"/></f:facet>
                                    <h:outputText value= "#{colA.feurubforFormule}" title="#{colA.feurubforFormule}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>

                    <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubActif&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubColB}">
                        <h:panelGrid width="200px" id="idBoutonB" columns="4">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter une formule" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.ajouterFormuleB}" reRender="panelFormule,panelGestionFormule"/>
                            <a4j:commandButton image="/images/modifier.png" title="Modifier la formule sélectionnée" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.afficheFormuleB}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.modifierFormuleB}" reRender="panelFormule,panelGestionFormule"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer la formule sélectionnée" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.afficheFormuleB}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.supprimerFormuleB}" reRender="idBoutonB,colonneB"/>
                            <h:selectBooleanCheckbox title="RAZ après cloture" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubColBRaz}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubVariableB}">
                                <h:outputText value="RAZ"/>
                            </h:selectBooleanCheckbox>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.dataModelColB}" var="colB" id="colonneB" border="0" styleClass="bg" enableContextMenu="false" style="border:solid 1px green" width="100%" height="300px" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.selectionColonneB}" reRender="idBoutonB"/>
                                <rich:column width="100%" sortable="false" style="text-align:left;">
                                    <f:facet name="header"><h:outputText value="Base Col(B)"/></f:facet>
                                    <h:outputText value= "#{colB.feurubforFormule}" title="#{colB.feurubforFormule}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>

                    <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubActif&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubColC}">
                        <h:panelGrid width="200px" id="idBoutonC" columns="4">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter une formule" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.ajouterFormuleC}" reRender="panelFormule,panelGestionFormule"/>
                            <a4j:commandButton image="/images/modifier.png" title="Modifier la formule sélectionnée" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.afficheFormuleC}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.modifierFormuleC}" reRender="panelFormule,panelGestionFormule"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer la formule sélectionnée" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.afficheFormuleC}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.supprimerFormuleC}" reRender="idBoutonC,colonneC"/>
                            <h:selectBooleanCheckbox title="RAZ après cloture" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubColCRaz}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubVariableC}">
                                <h:outputText value="RAZ"/>
                            </h:selectBooleanCheckbox>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.dataModelColC}" var="colC" id="colonneC" border="0" styleClass="bg" enableContextMenu="false" style="border:solid 1px green" width="100%" height="300px" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.selectionColonneC}" reRender="idBoutonC"/>
                                <rich:column  width="100%" sortable="false" style="text-align:left;">
                                    <f:facet name="header"><h:outputText value="Taux Col(C)"/></f:facet>
                                    <h:outputText value= "#{colC.feurubforFormule}" title="#{colC.feurubforFormule}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>

                    <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubActif&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubColD}">
                        <h:panelGrid width="200px" id="idBoutonD" columns="4" style="text-align:top">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter une formule" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.ajouterFormuleD}" reRender="panelFormule,panelGestionFormule"/>
                            <a4j:commandButton image="/images/modifier.png" title="Modifier la formule sélectionnée" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.afficheFormuleD}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.modifierFormuleD}" reRender="panelFormule,panelGestionFormule"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer la formule sélectionnée" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.afficheFormuleD}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.supprimerFormuleD}" reRender="idBoutonD,colonneD"/>
                            <h:selectBooleanCheckbox title="RAZ après cloture" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubColDRaz}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubVariableD}">
                                <h:outputText value="RAZ"/>
                            </h:selectBooleanCheckbox>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.dataModelColD}" var="colD" id="colonneD" border="0" styleClass="bg" enableContextMenu="false" style="border:solid 1px green" width="100%" height="300px" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.selectionColonneD}" reRender="idBoutonD"/>
                                <rich:column  width="100%" sortable="false" style="text-align:left;">
                                    <f:facet name="header"><h:outputText value="Nombre Col(D)"/></f:facet>
                                    <h:outputText value= "#{colD.feurubforFormule}" title="#{colD.feurubforFormule}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>

                    <h:panelGrid width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubActif&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubColE}">
                        <h:panelGrid width="200px" id="idBoutonE" columns="4">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter une formule" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.ajouterFormuleE}" reRender="panelFormule,panelGestionFormule"/>
                            <a4j:commandButton image="/images/modifier.png" title="Modifier la formule sélectionnée" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.afficheFormuleE}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.modifierFormuleE}" reRender="panelFormule,panelGestionFormule"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer la formule sélectionnée" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.afficheFormuleE}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.supprimerFormuleE}" reRender="idBoutonE,colonneE"/>
                            <h:selectBooleanCheckbox title="RAZ après cloture" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubColERaz}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.feurubVariableE}">
                                <h:outputText value="RAZ"/>
                            </h:selectBooleanCheckbox>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.dataModelColE}" var="colE" id="colonneE" border="0" styleClass="bg" enableContextMenu="false" style="border:solid 1px green" width="100%" height="300px" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.selectionColonneE}" reRender="idBoutonE"/>
                                <rich:column  width="100%" sortable="false" style="text-align:left;">
                                    <f:facet name="header"><h:outputText value="Résultat Col(E)"/></f:facet>
                                    <h:outputText value= "#{colE.feurubforFormule}" title="#{colE.feurubforFormule}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>

                </h:panelGrid>
                <center>
                    <h:panelGroup>
                        <a4j:commandButton title="Valider"style="margin-top:10px;" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.valideRubrique}" reRender="panelRubrique,tableRubiqueConstruction"/>
                    </h:panelGroup>
                </center>

                <h:panelGroup>
                    <center>
                        <h:outputText value="Eléments qui peuvent être intégrés dans le contrat:"/><br>
                        <h:outputText value="Prime: rendement, responsabilité, exceptionnelle, sujetion, fonction, outillage, astreinte, transport, logement"/><br>
                        <h:outputText value="Indemnité: caisse, transport, logement, déplacement, kilométrique, salissure, réprésentation, diverse, responsabilité, nourriture"/><br>
                        <h:outputText value="Avantage en nature: logement, domesticité, téléphone, eau, électricité, nourriture, véhicule"/><br>
                    </center>
                </h:panelGroup>

            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelFormule" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="900" height="320" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.showModalPanelFormule}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.showModalPanelFormule}" var="sheet">
            <f:facet name="header"><h:outputText value="Détail de la formule : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.planPaye.plpCode}  #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculRubrique.planPaye.plpLibelleFR}"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.fermerFormule}" image="/images/close.gif" styleClass="hidelink" reRender="panelFormule"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid id="panelGestionFormule" width="100%" columns="2" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Formule:"/></h:column>
                    <h:column><h:inputText id="pngpFormule" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.feuilleCalculFormule.feurubforFormule}" style="width:100%"/></h:column>
                </h:panelGrid>
                <h:panelGrid width="100%" columns="2" columnClasses="clos50,clos50g" id="idPanelFormule">
                    <h:panelGrid id="panelFonction" width="100%">
                        <h:column><h:outputText value="Opérateurs Arithmétiques:"/></h:column>
                        <h:column>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterEq}" reRender="pngpFormule,listeFonction,idPanelFormule" value="=" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterPlus}" reRender="pngpFormule,listeFonction,idPanelFormule" value="+" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterMoins}" reRender="pngpFormule,listeFonction,idPanelFormule" value="-" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterMulti}" reRender="pngpFormule,listeFonction,idPanelFormule" value="*" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterDiv}" reRender="pngpFormule,listeFonction,idPanelFormule" value="/" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterAbs}" reRender="pngpFormule,listeFonction,idPanelFormule" value="ABS()" size="3" title="Valeur absolue"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterArr}" reRender="pngpFormule,listeFonction,idPanelFormule" value="ARR()" size="3" title="Arrondi à x décimales"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterInv}" reRender="pngpFormule,listeFonction,idPanelFormule" value="INV()" size="3" title="multiplie le résultat par -1"/>
                        </h:column>
                        <h:column><h:outputText value="Opérateurs Logiques:"/></h:column>
                        <h:column>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterSupp}" reRender="pngpFormule,listeFonction,idPanelFormule" value=">" size="3" />
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterInf}" reRender="pngpFormule,listeFonction,idPanelFormule" value="<" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterSuppOrEq}" reRender="pngpFormule,listeFonction,idPanelFormule" value=">=" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterInfOrEq}" reRender="pngpFormule,listeFonction,idPanelFormule" value="<=" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterDiff}" reRender="pngpFormule,listeFonction,idPanelFormule" value="<>" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterEgal}" reRender="pngpFormule,listeFonction,idPanelFormule" value="==" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterSi}" reRender="pngpFormule,listeFonction,idPanelFormule" value="SI()" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterSinon}" reRender="pngpFormule,listeFonction,idPanelFormule" value="SINON" size="3"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterFinSi}" reRender="pngpFormule,listeFonction,idPanelFormule" value="FINSI" size="3"/>
                        </h:column>
                        <h:column><h:outputText value="Opérateurs Rubriques:"/></h:column>
                        <h:column>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterTot}" reRender="pngpFormule,listeFonction,idPanelFormule" value="TOT()" size="3" title="Totalise une section"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterSom}" reRender="pngpFormule,listeFonction,idPanelFormule" value="SOM()" size="3" title="Totalise d'une rubrique d'origine à une rubrique de destination SOM(XXXXXX:YYYYYY)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterCol}" reRender="pngpFormule,listeFonction,idPanelFormule" value="COL()" size="3" title="Prend la valeur de la colonne COL(X)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterVal}" reRender="pngpFormule,listeFonctione,idPanelFormule" value="VAL()" size="3" title="Affecte une valeur VAL(0)"/><br>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterRub}" reRender="pngpFormule,listeFonction,idPanelFormule" value="RUB()" size="3" title="Accès aux rubriques du plan de paye RUB(XXXXXX:A)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterMac}" reRender="pngpFormule,listeFonction,idPanelFormule" value="MAC()" size="3" title="Accès aux macros intégrées MAC(Calcul congés)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterSal}" reRender="pngpFormule,listeFonction,idPanelFormule" value="SAL()" size="3" title="Accès aux variables du salarié SAL(Nb enfants)"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterVar}" reRender="pngpFormule,listeFonction,idPanelFormule" value="VAR()" size="3" title="Accès aux variables mensuelles en saisie"/>
                            <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.AffecterTst}" reRender="pngpFormule,listeFonction,idPanelFormule" value="TST()" size="3" title="Si la colonne spécifié = 0 alors le résulta = 0"/>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid id="panelListe" width="100%">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.dataModelFonction}" var="fonction" id="listeFonction" border="0" styleClass="bg" enableContextMenu="false" style="border:solid 1px green" width="100%" height="200px" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                                <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.selectionFonction}" reRender="pngpFormule"/>
                                <rich:column  width="100%" sortable="true" style="text-align:left;" sortBy="#{fonction}" sortOrder="ASCENDING">
                                    <f:facet name="header"><h:outputText value="Liste fonctions"/></f:facet>
                                    <h:outputText value= "#{fonction}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </h:panelGrid>
                <center>
                    <h:panelGroup>
                        <a4j:commandButton title="Valider" style="margin-top:10px;" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.validerFormule}" reRender="panelFormule,colonneA,colonneB,colonneC,colonneD,colonneE,idBoutonA,idBoutonB,idBoutonC,idBoutonD,idBoutonE"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImpStructure" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <center>
            <f:facet name="header"><h:outputText value="Impression de la structure de la feuille"/></f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/images/close.gif" id="hideImpStructure"/>
                    <rich:componentControl for="panelImpStructure" attachTo="hideImpStructure" operation="hide" event="onclick"/>
                </h:panelGroup>
            </f:facet>
            <a4j:form id="formModalImpStructure" target="_blank">
                <h:panelGrid width="100%" >
                    <h:panelGrid width="100%" style="border:solid 0px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="8" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.imprimerJRV}" onclick="javascript:Richfaces.hideModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFeuilleCalcul.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                        </h:panelGrid>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>


</f:subview>