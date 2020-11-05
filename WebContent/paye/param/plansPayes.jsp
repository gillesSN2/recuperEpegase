<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="planPaye">

    <a4j:form id="planpaye">
        <center>
            <h:panelGroup id="butt">

                <center> <h2><h:outputText value="LISTE DU PLAN DE PAYE" style="color:green;font-size:16px;"/></h2></center>

                <a4j:commandButton value="Ajout par Défaut" onclick="if (!confirm('Voulez-vous charger le plan de paye par défaut?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.defaultAdd}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.afficheAjDefaut}" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:180px;cursor:pointer;" reRender="butt,idRecherche,table,modAttente"/>
                <br>
                <a4j:commandButton image="/images/ajouter.png" title="Ajouter une rubrique" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.ajouterRubrique}" reRender="panelRubrique,panelGestionRubrique"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a4j:commandButton image="/images/modifier.png" title="Modifier la rubrique sélectionnée" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.afficheRubrique&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.afficheRubrique)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.modifierRubrique}" reRender="panelRubrique,panelGestionRubrique"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a4j:commandButton image="/images/supprimer.png" title="Supprimer la rubrique sélectionnée" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.afficheRubrique&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.afficheRubrique)==true}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.supprimerRubrique}" reRender="butt,table"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a4j:commandButton image="/images/print.png" title="Imprimer la liste des rubriques" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"></a4j:commandButton>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a4j:commandButton image="/images/actualiser.png" title="Fusionne avec le plan de paye par défaut" onclick="if (!confirm('Voulez-vous fusionner avec le plan de paye par défaut?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.fusionPlp}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.afficheAjDefaut}" reRender="butt,idRecherche,table,modAttente"/>
            </h:panelGroup>

            <h:panelGrid id="idRecherche" style="max-height:100%;border:1px;" columns="2">
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.nature}">
                    <f:selectItem itemLabel="Sélectionnez la nature" itemValue="9999"/>
                    <f:selectItem itemLabel="Plan complet" itemValue="0"/>
                    <f:selectItem itemLabel="10:Eléments de base" itemValue="10"/>
                    <f:selectItem itemLabel="11:Heures supplémentaires" itemValue="11"/>
                    <f:selectItem itemLabel="20:Primes imposables" itemValue="20"/>
                    <f:selectItem itemLabel="21:Indemnités imposables" itemValue="21"/>
                    <f:selectItem itemLabel="25:Indemnités compensatrices" itemValue="25"/>
                    <f:selectItem itemLabel="30:Retenues imposables" itemValue="30"/>
                    <f:selectItem itemLabel="40:Congés" itemValue="40"/>
                    <f:selectItem itemLabel="41:Licenciement" itemValue="41"/>
                    <f:selectItem itemLabel="42:Primes fin d`année" itemValue="42"/>
                    <f:selectItem itemLabel="50:Avantages en nature" itemValue="50"/>
                    <f:selectItem itemLabel="59:Total brut" itemValue="59"/>
                    <f:selectItem itemLabel="60:Impôts : charge fiscale" itemValue="60"/>
                    <f:selectItem itemLabel="61:Impôts : charge sociale" itemValue="61"/>
                    <f:selectItem itemLabel="62:Impôts : autre charge" itemValue="62"/>
                    <f:selectItem itemLabel="69:Total brut apès impôt" itemValue="69"/>
                    <f:selectItem itemLabel="70:Indemnités non imposables" itemValue="70"/>
                    <f:selectItem itemLabel="80:Retenues non imposables" itemValue="80"/>
                    <f:selectItem itemLabel="88:Appoints mensuels" itemValue="88"/>
                    <f:selectItem itemLabel="89:Total net" itemValue="89"/>
                    <f:selectItem itemLabel="90:Charges patronales" itemValue="90"/>
                    <f:selectItem itemLabel="99:Salaire net à atteindre" itemValue="99"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.chargerPlanPaye}"  onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,table,idUtilisation,modAttente,scrollTable" />
                </h:selectOneMenu>
                <h:panelGroup id="idUtilisation">
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.utilisation}" id="mouvment" >
                        <f:selectItem itemLabel="Toutes les rubriques" itemValue="0"/>
                        <f:selectItem itemLabel="Rubriques utilisées" itemValue="1"/>
                        <f:selectItem itemLabel="Rubriques non utilisées" itemValue="2"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.chargerPlanPaye}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,table,scrollTable" />
                    </h:selectOneMenu>
                </h:panelGroup>
            </h:panelGrid>
            <br>

            <h:panelGrid id="pgrd2" style="width:100%;max-height:100%;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="200" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.dataModelPlanPaye}" var="plan" id="table" border="0" styleClass="bg" style="max-height:100%;border:solid 0px green" width="100%" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.selectionLigne}" reRender="butt"/>
                        <rich:column label="Nature" width="10%" sortable="true" sortBy="#{plan.libelleNature}">
                            <f:facet name="header"><h:outputText value="Nature" /></f:facet>
                            <h:outputText value= "#{plan.plpNature} : #{plan.libelleNature}" style="#{plan.couleurImpot}" title="#{plan.plpNature} : #{plan.libelleNature}"/>
                        </rich:column>
                        <rich:column label="Code rubrique" width="7%" sortable="true" sortBy="#{plan.plpCode}" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText value="Code" /></f:facet>
                            <h:outputText value="#{plan.plpCode}" style="#{plan.couleurImpot}"/>
                        </rich:column>
                        <rich:column label="Libellé rubrique" width="26%" sortable="true" sortBy="#{plan.plpLibelleFR}">
                            <f:facet name="header"><h:outputText value="Intitulé Rubrique"/></f:facet>
                            <h:outputText value="#{plan.plpLibelleFR}" style="#{plan.couleurImpot}" title="#{plan.plpLibelleFR}"/>
                            <h:outputText value=" => (#{plan.plpCodeLie})" style="#{plan.couleurImpot}" rendered="#{plan.plpCodeLie!=null&&plan.plpCodeLie!=''}" title="#{plan.plpCodeLie}"/>
                        </rich:column>
                        <rich:column label="Sens" width="7%" sortable="true" sortBy="#{plan.libelleSens}" style="text-align:center;">
                            <f:facet name="header"><h:outputText value="Type"/></f:facet>
                            <h:outputText value="#{plan.libelleSens}" style="#{plan.couleurImpot}"/>
                        </rich:column>
                        <rich:column label="Prorata temporis" width="5%" sortable="true" sortBy="#{plan.plpProrataTemporis}" style="text-align:center;">
                            <f:facet name="header"><h:outputText value="Temp."/></f:facet>
                            <h:selectBooleanCheckbox value="#{true}" disabled="true" rendered="#{plan.plpProrataTemporis==1}" style="#{plan.couleurImpot}"/>
                        </rich:column>
                        <rich:column label="Rubrique facturée" width="5%" sortable="true" sortBy="#{plan.plpFacture}" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.interim}">
                            <f:facet name="header"><h:outputText value="Fac."/></f:facet>
                            <h:selectBooleanCheckbox value="#{true}" disabled="true" rendered="#{plan.plpFacture==true}" style="#{plan.couleurImpot}"/>
                        </rich:column>
                        <rich:column label="Base fiscale" width="5%" sortable="true" sortBy="#{plan.plpBaseFiscale}"  style="text-align:center;">
                            <f:facet name="header"><h:outputText value="B.fis."/></f:facet>
                            <h:selectBooleanCheckbox value="#{true}" disabled="true" rendered="#{plan.plpBaseFiscale==true}" style="#{plan.couleurImpot}"/>
                        </rich:column>
                        <rich:column label="Base sociale" width="5%" sortable="true" sortBy="#{plan.plpBaseSociale}"  style="text-align:center;">
                            <f:facet name="header"><h:outputText value="B.soc."/></f:facet>
                            <h:selectBooleanCheckbox value="#{true}" disabled="true" rendered="#{plan.plpBaseSociale==true}" style="#{plan.couleurImpot}"/>
                        </rich:column>
                        <rich:column label="Base congés" width="5%" sortable="true" sortBy="#{plan.plpBaseConges}"  style="text-align:center;">
                            <f:facet name="header"><h:outputText value="B.cp."/></f:facet>
                            <h:selectBooleanCheckbox value="#{true}" disabled="true" rendered="#{plan.plpBaseConges==true}" style="#{plan.couleurImpot}"/>
                        </rich:column>
                        <rich:column label="Base patronale" width="5%" sortable="true" sortBy="#{plan.plpBasePatronale}"  style="text-align:center;">
                            <f:facet name="header"><h:outputText value="B.pat."/></f:facet>
                            <h:selectBooleanCheckbox value="#{true}" disabled="true" rendered="#{plan.plpBasePatronale==true}" style="#{plan.couleurImpot}"/>
                        </rich:column>
                        <rich:column label="Groupage des comptes pour le transfert en compta" width="7%" sortable="true" sortBy="#{plan.libelleGroupe}">
                            <f:facet name="header"><h:outputText value="Groupe"/></f:facet>
                            <h:outputText value="#{plan.libelleGroupe}" style="#{plan.couleurImpot}"/>
                        </rich:column>
                        <rich:column label="Compte normal" width="7%" sortable="true" sortBy="#{plan.plpCompteNormal}">
                            <f:facet name="header"><h:outputText value="Cpte Std."/></f:facet>
                            <h:outputText value="#{plan.plpCompteNormal} #{plan.plpActivite}" style="#{plan.couleurImpot}"/>
                        </rich:column>
                        <rich:column label="Compte de contre partie" width="7%" sortable="true" sortBy="#{plan.plpCpNormal}">
                            <f:facet name="header"><h:outputText value="Cpte Cp."/></f:facet>
                            <h:outputText value="#{plan.plpCpNormal}" style="#{plan.couleurImpot}"/>
                        </rich:column>
                         <rich:column label="Code Sage" width="7%" sortable="true" sortBy="#{plan.plpCodeSage}">
                            <f:facet name="header"><h:outputText value="Code Sage"/></f:facet>
                            <h:outputText value="#{plan.plpCodeSage}" style="#{plan.couleurImpot}"/>
                        </rich:column>
                        <rich:column label="Désativer la rubrique" id="inact" width="5%" sortable="true" sortBy="#{plan.plpInactif}" style="text-align:center;">
                            <f:facet name="header"><h:outputText value="Etat"/></f:facet>
                            <h:commandButton image="#{plan.etat}" id="inactif" rendered="#{plan.afficheImag}" onclick="if (!confirm('Voulez-vous réactiver cette rubrique ?')) return false;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.reactiveRubrique}">
                                <a4j:support eventsQueue="maQueue" reRender="idRecherche" event="onclick"/>
                            </h:commandButton>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}">
                    <center>
                        <h:outputText value="LEGENDE DES COULEURS:"/>&nbsp;&nbsp;&nbsp;
                        <h:outputText value="Exonérée de CNAMGS, TCS et d'IRPP à hauteur de 4.000 000 Fcfa" style="color:magenta;"/>&nbsp;&nbsp;&nbsp;
                        <h:outputText value="Totalement exonérée de CNAMGS, TCS et d'IRPP" style="color:blue;"/>&nbsp;&nbsp;&nbsp;
                        <h:outputText value="Totalement exonérée de TCS et d'IRPP" style="color:brown;"/>&nbsp;&nbsp;&nbsp;
                        <h:outputText value="Rubrique normale" style="color:black;"/>
                    </center>
                </h:panelGroup>
            </h:panelGrid>
            <br>
            <h:commandButton id="idCancel" styleClass="exp_lienmenu" value="RETOUR" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}"/>
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent" headerClass="headerPanel" id="panelRubrique"style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="800" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.showModalPanelRubrique}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.showModalPanelRubrique}" var="rub">
            <f:facet name="header"><h:outputText value="Gestion des rubriques"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.annulerRubrique}" image="/images/close.gif" styleClass="hidelink" reRender="panelRubrique"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid id="panelGestionRubrique" style="width:100%;">
                    <rich:tabPanel switchType="client" immediate="true" style="border:0px">

                        <rich:tab label="Génèral">
                            <a4j:support eventsQueue="maQueue" event="onlabelclick" reRender="panDescription"/>
                            <h:panelGrid id="panDescription" columns="2" columnClasses="clos20,clos80" style="width:100%;">
                                <h:column><h:outputText value="Intitulé Nature:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature}" style="width:100%;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpId!=0}">
                                        <f:selectItem itemLabel="Sélectionnez la nature" itemValue="9999"/>
                                        <f:selectItem itemLabel="10:Eléments de base" itemValue="10"/>
                                        <f:selectItem itemLabel="11:Heures supplémentaires" itemValue="11"/>
                                        <f:selectItem itemLabel="20:Primes imposables" itemValue="20"/>
                                        <f:selectItem itemLabel="21:Indemnités imposables" itemValue="21"/>
                                        <f:selectItem itemLabel="25:Indemnités compensatrices" itemValue="25"/>
                                        <f:selectItem itemLabel="30:Retenues imposables" itemValue="30"/>
                                        <f:selectItem itemLabel="40:Congés" itemValue="40"/>
                                        <f:selectItem itemLabel="41:Licenciement" itemValue="41"/>
                                        <f:selectItem itemLabel="42:Primes fin d`année" itemValue="42"/>
                                        <f:selectItem itemLabel="50:Avantages en nature" itemValue="50"/>
                                        <f:selectItem itemLabel="59:Total brut" itemValue="59"/>
                                        <f:selectItem itemLabel="60:Impôts : charge fiscale" itemValue="60"/>
                                        <f:selectItem itemLabel="61:Impôts : charge sociale" itemValue="61"/>
                                        <f:selectItem itemLabel="62:Impôts : autre charge" itemValue="62"/>
                                        <f:selectItem itemLabel="69:Total brut apès impôt" itemValue="69"/>
                                        <f:selectItem itemLabel="70:Indemnités non imposables" itemValue="70"/>
                                        <f:selectItem itemLabel="80:Retenues non imposables" itemValue="80"/>
                                        <f:selectItem itemLabel="88:Appoints mensuels" itemValue="88"/>
                                        <f:selectItem itemLabel="89:Total net" itemValue="89"/>
                                        <f:selectItem itemLabel="90:Charges patronales" itemValue="90"/>
                                        <f:selectItem itemLabel="99:Salaire net à atteindre" itemValue="99"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.calculImpositionDefaut}" reRender="panCalcul1,panCalcul2,buttonValid,panCompta"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" columnClasses="clos20,clos80" style="width:100%;">
                                <h:column><h:outputText value="Code rubrique:"/></h:column>
                                <h:column>
                                    <h:inputText style="width:100px;" maxlength="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpCode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpId!=0}">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.testeUniciteRubrique}" reRender="buttonValid"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Intitulé Rubrique:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpLibelleFR}"/></h:column>
                                <h:column><h:outputText value="Inactif:"/></h:column>
                                <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.inactif}"/></h:column>
                                <h:column><h:outputText value="Code Sage:"/></h:column>
                                <h:column><h:inputText style="width:100px;" maxlength="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpCodeSage}"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" id="panelWarn">
                                <h:graphicImage  url="/images/Warning.png" style="width:20px;heigh:20px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.existeCopteDeja}"/>
                                <h:outputText value="Cette rubrique est invalide ou existe déja" style="color:red;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.existeCopteDeja}"/>
                            </h:panelGrid>
                            <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}">
                                <h:outputText value="Les rubriques de 109500 à 109559 sont exonérées de CNAMGS, TCS et d'IRPP à hauteur de 4.000.000 Fcfa" style="color:magenta;"/>
                                <h:outputText value="Les rubriques de 109560 à 109599 sont totalement exonérées de CNAMGS, TCS et d'IRPP" style="color:blue;"/>
                                <h:outputText value="Les rubriques de 109600 à 109659 sont totalement exonérées de TCS et d'IRPP" style="color:brown;"/>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab label="Calcul(1)">
                            <a4j:support eventsQueue="maQueue" event="onlabelclick"/>
                            <jsp:include flush="true" page="plansPayeCommun.jsp"/>
                            <h:panelGrid id="panCalcul1" headerClass="headerTab" columns="2" columnClasses="clos30,clos70" style="width:100%;">
                                <h:column><h:outputText value="Mode:"/></h:column>
                                <h:column>
                                    <h:selectOneRadio dir="LTR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpSens}" style="width:100%;">
                                        <f:selectItem itemLabel="+" itemValue="0"/>
                                        <f:selectItem itemLabel="-" itemValue="1"/>
                                        <f:selectItem itemLabel="Calcul" itemValue="2"/>
                                        <f:selectItem itemLabel="Résultat intermédaire" itemValue="3"/>
                                        <f:selectItem itemLabel="Non cumulée" itemValue="4"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Prorata temporis:"/></h:column>
                                <h:column>
                                    <h:selectOneRadio dir="LTR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpProrataTemporis}" style="width:130px;">
                                        <f:selectItem itemLabel="Non" itemValue="0"/>
                                        <f:selectItem itemLabel="Oui" itemValue="1"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Rubrique non imprimable:"/></h:column>
                                <h:column>
                                    <h:selectOneRadio dir="LTR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpProtege}" style="width:130px;">
                                        <f:selectItem itemLabel="Non" itemValue="0"/>
                                        <f:selectItem itemLabel="Oui" itemValue="1"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==25&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}">
                                    <h:outputText value="Rubrique avantages en nature liée"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==25&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}">
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpCodeLie}" style="width:100%;">
                                        <f:selectItem itemLabel="Sélectionnez la rubrique" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.lesRubAvantagesNature}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==50&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}">
                                    <h:outputText value="Rubrique compensatrice liée"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==50&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}">
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpCodeLie}" style="width:100%;">
                                        <f:selectItem itemLabel="Sélectionnez la rubrique" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.lesRubCompensatrices}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==60||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==61||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==62||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==90}"><h:outputText value="Mode régularisation:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==60||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==61||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==62||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==90}">
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpOption}" style="width:100%;">
                                        <f:selectItem itemLabel="Sans régule Mensuelle et avec régule annuelle" itemValue="0" />
                                        <f:selectItem itemLabel="Avec régule Mensuelle et annuelle" itemValue="1"/>
                                        <f:selectItem itemLabel="Sans régule Mensuelle et annuelle" itemValue="2"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.interim}"><h:outputText value="Rubrique facturée dans intérim:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.interim}">
                                    <h:selectOneRadio dir="LTR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.rubFac}" style="width:130px;">
                                        <f:selectItem itemLabel="Non" itemValue="0"/>
                                        <f:selectItem itemLabel="Oui" itemValue="1"/>
                                    </h:selectOneRadio>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab label="Calcul(2)" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==40||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==60||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==61||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==62||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==90}">
                            <a4j:support eventsQueue="maQueue" event="onlabelclick"/>
                            <jsp:include flush="true" page="plansPayeCommun.jsp"/>
                            <h:panelGrid id="panCalcul2" columns="2" headerClass="headerTab" columnClasses="clos30,clos70" style="width:100%;">
                                <f:facet name="header"><h:outputText value="La base (colonne B) est constituée par:"/></f:facet>
                                <a4j:region renderRegionOnly="true">
                                    <rich:extendedDataTable id="tableRub" border="0" styleClass="bg" style="border:solid 1px green" width="100%" height="250px" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.dataModelRubriques}" var="rub">
                                        <rich:column label="Nature" width="10%" sortable="true" sortBy="#{rub.select}" style="text-align:center;">
                                            <f:facet name="header"><h:outputText value="Nature" /></f:facet>
                                            <h:selectBooleanCheckbox value= "#{rub.select}">
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.changeLigneRub}" reRender="idSaisie1,idSaisie2"/>
                                            </h:selectBooleanCheckbox>
                                        </rich:column>
                                        <rich:column label="Code rubrique" width="10%" sortable="true" sortBy="#{rub.code}">
                                            <f:facet name="header"><h:outputText value="Code" /></f:facet>
                                            <h:outputText value="#{rub.code}"/>
                                        </rich:column>
                                        <rich:column label="Libellé rubrique" width="40%" sortable="true" sortBy="#{rub.libelle}" style="text-align:left;">
                                            <f:facet name="header"><h:outputText value="Intitulé Rubrique"/></f:facet>
                                            <h:outputText value="#{rub.libelle}"/>
                                        </rich:column>
                                        <rich:column id="idSaisie1" label="Pourcentage" width="10%" sortable="true" sortBy="#{rub.pourcentage}" style="text-align:center;">
                                            <f:facet name="header"><h:outputText value="%"/></f:facet>
                                            <h:inputText value="#{rub.pourcentage}" rendered="#{rub.select}" style="width:90%"/>
                                        </rich:column>
                                        <rich:column id="idSaisie2" label="Options" width="30%" sortable="true" sortBy="#{rub.formule}">
                                            <f:facet name="header"><h:outputText value="Formule"/></f:facet>
                                            <h:inputText value="#{rub.formule}" rendered="#{(rub.nature==60||rub.nature==61||rub.nature==62||rub.nature==90)&&rub.select}"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab label="Calcul(3)">
                            <a4j:support eventsQueue="maQueue" event="onlabelclick"/>
                            <jsp:include flush="true" page="plansPayeCommun.jsp"/>
                            <h:panelGrid id="panCalcul3" columns="2" headerClass="headerTab" columnClasses="clos30,clos70" style="width:100%;">
                                <f:facet name="header"><h:outputText value="Est utilisé dans le calcul de:"/></f:facet>
                                <a4j:region renderRegionOnly="true">
                                    <rich:extendedDataTable id="tableRubUtil" border="0" styleClass="bg" style="border:solid 1px green" width="100%" height="250px" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.dataModelRubriquesUtil}" var="rubUtl">
                                        <rich:column label="Code rubrique" width="20%" sortable="true" sortBy="#{rubUtl.code}">
                                            <f:facet name="header"><h:outputText value="Code" /></f:facet>
                                            <h:outputText value="#{rubUtl.code}"/>
                                        </rich:column>
                                        <rich:column label="Libellé rubrique" width="80%" sortable="true" sortBy="#{rubUtl.libelle}" style="text-align:left;">
                                            <f:facet name="header"><h:outputText value="Intitulé Rubrique"/></f:facet>
                                            <h:outputText value="#{rubUtl.libelle}"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab label="Calcul(4)">
                            <a4j:support eventsQueue="maQueue" event="onlabelclick"/>
                            <jsp:include flush="true" page="plansPayeCommun.jsp"/>
                            <h:panelGrid id="panCalcul4" columns="2" headerClass="headerTab" columnClasses="clos30,clos70" style="width:100%;">
                                <f:facet name="header"><h:outputText value="Est utilisé dans les feuilles suivantes:"/></f:facet>
                                <a4j:region renderRegionOnly="true">
                                    <rich:extendedDataTable id="tableRubFeuille" border="0" styleClass="bg" style="border:solid 1px green" width="100%" height="250px" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.dataModelFeuillesUtil}" var="feuUtl">
                                        <rich:column label="Code feuille" width="20%" sortable="true" sortBy="#{feuUtl.code}">
                                            <f:facet name="header"><h:outputText value="Code" /></f:facet>
                                            <h:outputText value="#{feuUtl.code}"/>
                                        </rich:column>
                                        <rich:column label="Libellé feuille" width="80%" sortable="true" sortBy="#{feuUtl.libelle}" style="text-align:left;">
                                            <f:facet name="header"><h:outputText value="Nom feuille"/></f:facet>
                                            <h:outputText value="#{feuUtl.libelle}"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab label="Interface comptable">
                            <a4j:support eventsQueue="maQueue" event="onlabelclick" reRender="panCompta"/>
                            <jsp:include flush="true" page="plansPayeCommun.jsp"/>
                            <h:panelGrid id="panCompta" columns="2" columnClasses="clos20,clos80" style="width:100%;">
                                <h:column><h:outputText value="Libellé forcé:"/></h:column>
                                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpCommentaire}"/></h:column>
                                <h:column><h:outputText value="Compte standard:"/></h:column>
                                <h:column><h:inputText style="width:200px;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpCompteNormal}"/></h:column>
                                <h:column><h:outputText value="Compte prestataire:"/></h:column>
                                <h:column><h:inputText style="width:200px;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpComptePrestataire}"/></h:column>
                                <h:column><h:outputText value="Regroupement Compte:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpGroupe}" style="width:100%;">
                                        <f:selectItem itemLabel="Compte groupé" itemValue="0"/>
                                        <f:selectItem itemLabel="Compte + Classement" itemValue="1"/>
                                        <f:selectItem itemLabel="Compte + Matricule" itemValue="2"/>
                                        <f:selectItem itemLabel="Compte + National/Non National" itemValue="3"/>
                                        <f:selectItem itemLabel="Compte + National/Non National + Classement" itemValue="4"/>
                                        <!--f:selectItem itemLabel="Compte + Temporaire" itemValue="5"/-->
                                        <!--f:selectItem itemLabel="Compte sur fiche" itemValue="6"/-->
                                        <f:selectItem itemLabel="Compte + Feuille de calcul" itemValue="7"/>
                                        <f:selectItem itemLabel="Compte + Code centre impôt" itemValue="8"/>
                                        <f:selectItem itemLabel="Compte + Code service" itemValue="9"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==50||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==60||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==61||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==62||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==90}"><h:outputText value="Contre partie standard:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==50||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==60||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==61||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==62||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==90}"><h:inputText style="width:200px;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpCpNormal}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==60||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==61||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==62||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==90}"><h:outputText value="Contre partie prestataire:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==60||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==61||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==62||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==90}"><h:inputText style="width:200px;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpCpPrestataire}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==50||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==60||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==61||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==62||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==90}"><h:outputText value="Regroupement Contre partie:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==50||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==60||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==61||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==62||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature==90}">
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpGroupeCp}" style="width:100%;">
                                        <f:selectItem itemLabel="Compte groupé" itemValue="0"/>
                                        <f:selectItem itemLabel="Compte + Classement" itemValue="1"/>
                                        <f:selectItem itemLabel="Compte + Matricule" itemValue="2"/>
                                        <f:selectItem itemLabel="Compte + National/Non National" itemValue="3"/>
                                        <f:selectItem itemLabel="Compte + National/Non National + Classement" itemValue="4"/>
                                        <!--f:selectItem itemLabel="Compte + Temporaire" itemValue="5"/-->
                                        <!--f:selectItem itemLabel="Compte sur fiche" itemValue="6"/-->
                                        <f:selectItem itemLabel="Compte + Feuille de calcul" itemValue="7"/>
                                        <f:selectItem itemLabel="Compte + Code centre impôt" itemValue="8"/>
                                        <f:selectItem itemLabel="Compte + Code service" itemValue="9"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Imputation analytique:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpAnalytique}" style="width:100%;">
                                        <f:selectItem itemLabel="Sans" itemValue="0"/>
                                        <f:selectItem itemLabel="Avec" itemValue="1"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panCompta,idAct1,idAct2"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column id="idAct1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpAnalytique==1}"><h:outputText value="Activité forcée:"/></h:column>
                                <h:column id="idAct2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpAnalytique==1}">
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpActivite}" style="width:100%;">
                                        <f:selectItem itemLabel="Sans Activité forcée" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.mesActivitesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="false"><h:outputText value="R.A.N.:"/></h:column>
                                <h:column rendered="false">
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpRan}" style="width:100%;">
                                        <f:selectItem itemLabel="Sans" itemValue="0"/>
                                        <f:selectItem itemLabel="Avec" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                    </rich:tabPanel>
                </h:panelGrid>
                <center>
                    <h:panelGroup id="buttonValid">
                        <a4j:commandButton title="Valider"style="margin-top:10px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpNature!=9999&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.existeCopteDeja}" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.validerRubrique}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelRubrique,table,scrollTable"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>



    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>