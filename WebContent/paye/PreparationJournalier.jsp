<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="journalierpreparation">

    <a4j:form>

        <center> <h2>
                <h:outputText id="idTitre" value="PREPARATION DES JOURNALIERS DU : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenJour} DE LA FEUILLE N° #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.feuilleCalcul.feuCode}" style="color:green;"/>&nbsp;&nbsp;
                <h:selectOneMenu style="width:150px;color:green;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_service_rec}">
                    <f:selectItem itemLabel="Tous les Services" itemValue=""/>
                    <f:selectItem itemLabel="-------------------------------------------------" itemValue="-----" itemDisabled="true"/>
                    <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesServiceItems}"/>
                    <f:selectItem itemLabel="-------------------------------------------------" itemValue="-----" itemDisabled="true"/>
                    <f:selectItem itemLabel="Sans Service" itemValue="*****"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.chagerSalarieServicePreparatoire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries,scrollTable,tableSalaries,boutonRubriques,scrollTable2,tableRubriques,boutonHistorique,scrollTable3,tableHistorique,boutonCompteVrt,scrollTable4,tableCompteVrt,boutonImmatriculation,scrollTable5,tableImmatriculation"/>
                </h:selectOneMenu>
            </h2></center>

        <h:panelGrid width="100%">

            <h:panelGroup>
                <center>
                    <h:commandButton value="FERMER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.fermerPeriode}" styleClass="fermer" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </center>
            </h:panelGroup>

            <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabSalarie" label="Sur Journalier" >
                    <h:panelGrid  id="boutonSalaries" columns="7" width="400px" style="height:34px">
                        <a4j:commandButton title="Recherche des journaliers" image="/images/jumelle.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.rechercheJournaliers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelListeSalaries"/>
                        <a4j:commandButton title="Ajouter un nouveau journalier" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.ajouterJournaliers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelJournalier"/>
                        <a4j:commandButton title="Saisie des variables" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.saisieVariablesJournaliers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelVariable"/>
                        <a4j:commandButton title="Geler le salarié sélectionné" image="/images/geler.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salEtat<=1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.gelerImputationJournalier}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableSalaries,boutonSalaries"/>
                        <a4j:commandButton title="Réactiver le salarié sélectionné" image="/images/degeler.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salEtat==9}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.degelerImputationJournalier}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableSalaries,boutonSalaries"/>
                        <a4j:commandButton title="Imprimer contrat journalier" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.initImpressionPrepJournalier}" reRender="panelImpPrepa,formModalImpPrepa,panelMailPrepa"/>
                        <a4j:commandButton title="Historique des bulletins du salarié sélectionné" image="/images/extrait.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.historiqueBulletin}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelListeBulletin"/>
                    </h:panelGrid>
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.pageIndex}" reRender="tableSalaries" id="scrollTable" maxPages="20"align="left" for="tableSalaries"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_nb_max}" border="0" enableContextMenu="true" id="tableSalaries" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.dataModelLesElements}" var="salfic" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.selectionJournalier}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.visualisationJournalier}" reRender="idSubView,boutonSalaries"/>
                        <rich:column id="idSaisie" label="Saisie" sortable="true" width="5%" sortBy="#{salfic.effectue}">
                            <f:facet name="header"><h:outputText  value="Saisie"/></f:facet>
                            <h:selectBooleanCheckbox id="idEffectue" value="#{salfic.effectue}" disabled="true"/>
                        </rich:column>
                        <rich:column label="Matricule agent" sortable="true" width="10%" sortBy="#{salfic.salaries.salMatricule}">
                            <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                            <h:outputText value="#{salfic.salaries.salMatricule}"/>
                        </rich:column>
                        <rich:column label="Feuille de calcul" sortable="true" width="5%" sortBy="#{salfic.salaries.salFeuille}">
                            <f:facet name="header"><h:outputText  value="Feuille" /></f:facet>
                            <h:outputText value="#{salfic.salaries.salFeuille}"/>
                        </rich:column>
                        <rich:column label="Etat" sortable="true" width="5%" sortBy="#{salfic.salaries.lib_etat}">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{salfic.salaries.lib_etat}"/>
                        </rich:column>
                        <rich:column label="Nom et prénom" sortable="true" width="20%" sortBy="#{salfic.salaries.salNom}  #{salfic.salaries.salPrenom}">
                            <f:facet name="header"><h:outputText  value="Nom et prénom" /></f:facet>
                            <h:outputText value="#{salfic.salaries.salNom}  #{salfic.salaries.salPrenom}"/>
                        </rich:column>
                        <rich:column label="Genre : Homme ou femme" sortable="true" width="5%" sortBy="#{salfic.salaries.lib_genre}">
                            <f:facet name="header"><h:outputText  value="Genre" /></f:facet>
                            <h:outputText value="#{salfic.salaries.lib_genre}"/>
                        </rich:column>
                        <rich:column label="Situation de famille" sortable="true" width="5%" sortBy="#{salfic.salaries.lib_sitfamille}">
                            <f:facet name="header"><h:outputText  value="Sit." /></f:facet>
                            <h:outputText value="#{salfic.salaries.lib_sitfamille}"/>
                        </rich:column>
                        <rich:column label="Fonction actuelle" sortable="true" width="10%" sortBy="#{salfic.salaries.salFonction}">
                            <f:facet name="header"><h:outputText  value="Fonction" /></f:facet>
                            <h:outputText value="#{salfic.salaries.salFonction}"/>
                        </rich:column>
                        <rich:column label="Convention" sortable="true" width="10%" sortBy="#{salfic.salaries.salConvention}">
                            <f:facet name="header"><h:outputText  value="Convention" /></f:facet>
                            <h:outputText value="#{salfic.salaries.salConvention}"/>
                        </rich:column>
                        <rich:column label="Grille" sortable="true" width="10%" sortBy="#{salfic.salaries.salGrille}">
                            <f:facet name="header"><h:outputText  value="Grille" /></f:facet>
                            <h:outputText value="#{salfic.salaries.salGrille}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </rich:tab>

                <rich:tab id="tabRubrique" label="Sur Rubrique" >
                    <h:panelGrid  id="boutonRubriques" columns="5" width="400px" style="height:34px">
                        <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.variableSaisie}">
                            <f:selectItem itemLabel="Sélectionnez Variable" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.lesVariablesItems}"/>
                            <a4j:support eventsQueue="maQeueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.rechercheVariables}" reRender="tableRubriques,scrollTable2" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"/>
                        </h:selectOneMenu>
                        <a4j:commandButton title="Recharger les variables de la liste" image="/images/actualiser.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.rechercheVariables}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRubriques"/>
                        <a4j:commandButton title="Effacer les variables de la liste" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.razRubriques}" onclick="if (!confirm('Etes-vous sur de vouloir effacer les valeurs de la liste?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRubriques"/>
                        <a4j:commandButton title="Enregistrer les variables de la liste" image="/images/valider_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.saveRubriques}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente"/>
                        <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenEtat<=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.initImpressionRub}" reRender="panelImpRub,formModalImpRub,panelMailRub"/>
                    </h:panelGrid>
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable2" maxPages="20"align="left" for="tableRubriques"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_nb_max}" border="0" enableContextMenu="true" id="tableRubriques" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.datamodelRubriques}" var="rub">
                        <rich:column label="Feuille de calcul" sortable="true" width="5%" sortBy="#{rub.salaries.salFeuille}">
                            <f:facet name="header"><h:outputText  value="Feuille" /></f:facet>
                            <h:outputText value="#{rub.salaries.salFeuille}"/>
                        </rich:column>
                        <rich:column label="Etat" sortable="true" width="5%" sortBy="#{rub.salaries.lib_etat}">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{rub.salaries.lib_etat}"/>
                        </rich:column>
                        <rich:column label="Matricule agent" sortable="true" width="10%" sortBy="#{rub.salaries.salMatricule}">
                            <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                            <h:outputText value="#{rub.salaries.salMatricule}"/>
                        </rich:column>
                        <rich:column label="Nom et prénom" sortable="true" width="15%" sortBy="#{rub.salaries.salNom}  #{rub.salaries.salPrenom}">
                            <f:facet name="header"><h:outputText  value="Nom et prénom" /></f:facet>
                            <h:outputText value="#{rub.salaries.salNom}  #{rub.salaries.salPrenom}"/>
                        </rich:column>
                        <rich:column label="Genre : Homme ou femme" sortable="true" width="5%" sortBy="#{rub.salaries.lib_genre}">
                            <f:facet name="header"><h:outputText  value="Genre" /></f:facet>
                            <h:outputText value="#{rub.salaries.lib_genre}"/>
                        </rich:column>
                        <rich:column label="Situation de famille" sortable="true" width="5%" sortBy="#{rub.salaries.lib_sitfamille}">
                            <f:facet name="header"><h:outputText  value="Sit." /></f:facet>
                            <h:outputText value="#{rub.salaries.lib_sitfamille}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="A-Calcul"/></f:facet>
                            <h:inputText value="#{rub.salvarValeurColA}" rendered="#{rub.salvarVariableA}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="B-Base"/></f:facet>
                            <h:inputText value="#{rub.salvarValeurColB}" rendered="#{rub.salvarVariableB}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </rich:column>
                        <rich:column width="10%" sortable="false" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="C-Taux"/></f:facet>
                            <h:inputText value="#{rub.salvarValeurColC}" rendered="#{rub.salvarVariableC}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="D-Nb"/></f:facet>
                            <h:inputText value="#{rub.salvarValeurColD}" rendered="#{rub.salvarVariableD}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="E-Résultat"/></f:facet>
                            <h:inputText value="#{rub.salvarValeurColE}" rendered="#{rub.salvarVariableE}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </rich:column>
                    </rich:extendedDataTable>
                </rich:tab>

            </rich:tabPanel>

        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelVariable" width="900" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelVariable}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelVariable}" var="varb">
            <f:facet name="header"><h:outputText value="GESTION DES VARIABLES POUR LE JOUR DU : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinMois.bulmenJour}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanVariable" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.fermerVariables}" styleClass="hidelink" reRender="panelVariable"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanVariable')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid style="width:100%;" id="panVariable">

                    <rich:tabPanel switchType="client" immediate="true"  id="tabPanelsalaries" style="border:0px;">

                        <rich:tab name="variable" label="Variables journalières">
                            <jsp:include flush="true" page="/paye/PreparationCommunJournalier.jsp" />
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable rows="200" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.dataModelVariables}" enableContextMenu="false" var="plan" id="table" border="0" styleClass="bg" style="border:solid 0px green" width="100%" height="350px" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.selectionVariable}" reRender="butt"/>
                                    <rich:column  width="12%" sortable="false">
                                        <f:facet name="header"><h:outputText value="Nature" /></f:facet>
                                        <h:outputText value= "#{plan.planPaye.libelleNature}"/>
                                    </rich:column>
                                    <rich:column width="8%" sortable="false" sortBy="#{plan.salvarCode}" sortOrder="ASCENDING">
                                        <f:facet name="header"><h:outputText value="Code" /></f:facet>
                                        <h:outputText value="#{plan.salvarCode}"/>
                                    </rich:column>
                                    <rich:column width="30%" sortable="false" >
                                        <f:facet name="header"><h:outputText value="Libellé rubrique"/></f:facet>
                                        <h:outputText value="#{plan.planPaye.plpLibelleFR}"/>
                                    </rich:column>
                                    <rich:column width="10%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"><h:outputText value="A-Calcul"/></f:facet>
                                        <h:inputText value="#{plan.salvarValeurColA}" rendered="#{plan.salvarVariableA}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;"/>
                                    </rich:column>
                                    <rich:column width="10%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"><h:outputText value="B-Base"/></f:facet>
                                        <h:inputText value="#{plan.salvarValeurColB}" rendered="#{plan.salvarVariableB}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column width="10%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"><h:outputText value="C-Taux"/></f:facet>
                                        <h:inputText value="#{plan.salvarValeurColC}" rendered="#{plan.salvarVariableC}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;"/>
                                    </rich:column>
                                    <rich:column width="10%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"><h:outputText value="D-Nb"/></f:facet>
                                        <h:inputText value="#{plan.salvarValeurColD}" rendered="#{plan.salvarVariableD}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;"/>
                                    </rich:column>
                                    <rich:column width="10%" sortable="false" style="text-align:right;">
                                        <f:facet name="header"><h:outputText value="E-Résultat"/></f:facet>
                                        <h:inputText value="#{plan.salvarValeurColE}" rendered="#{plan.salvarVariableE}" style="width:90%;text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </rich:tab>

                        <rich:tab name="elements" label="Elements salariés">
                            <a4j:support eventsQueue="maQueue" event="onlabelclick" reRender="idSitFam,idAnalytique,idPaiement,idEtat"/>
                            <jsp:include flush="true" page="/paye/PreparationCommunJournalier.jsp" />
                            <h:panelGrid columns="4" id="idSitFam" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                                <h:column><h:outputText value="Genre:"/></h:column>
                                <h:column>
                                    <h:selectOneRadio id="idGenre" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleGenre}" disabled="true" style="width:200px">
                                        <f:selectItem itemLabel="Femme" itemValue="0"/>
                                        <f:selectItem itemLabel="Homme" itemValue="1"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="Situation matrimoniale:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleSitFamille}">
                                        <f:selectItem itemLabel="Célibataire" itemValue="0" />
                                        <f:selectItem itemLabel="Marié(e)" itemValue="1" />
                                        <f:selectItem itemLabel="Concubin(e)" itemValue="2" />
                                        <f:selectItem itemLabel="Pacsé(e)" itemValue="3" />
                                        <f:selectItem itemLabel="Divorcé(e)" itemValue="4" />
                                        <f:selectItem itemLabel="Veuf(ve)" itemValue="5" />
                                        <a4j:support eventsQueue="maQeueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.calculNbParts}" reRender="idSitFam,idNbEnfant,idNbFemme,nbPartFiscal,idNbpartTrimf,idD1,idD2,idD3,idD4,idD5,idD6"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText id="idD1" value="Date (JJ/MM/AAAA)" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleSitFamille>=1}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleSitFamille==0}"></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleSitFamille==1}"><rich:calendar id="idD2"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleDateMarie}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleSitFamille==2}"><rich:calendar id="idD3"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleDateConcubinage}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleSitFamille==3}"><rich:calendar id="idD4"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleDatePacs}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleSitFamille==4}"><rich:calendar id="idD5"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleDateDivorce}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleSitFamille==5}"><rich:calendar id="idD6"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleDateVeuf}"/></h:column>
                                <h:column><h:outputText value="Nb Enfants:"/></h:column>
                                <h:column><h:inputText id="idNbEnfant" style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleNbEnfant}"/></h:column>
                                <h:column><h:outputText value="Nb Parts:"/></h:column>
                                <h:column><h:inputText id="nbPartFiscal" style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleNbPartFiscal}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}"/></h:column>
                                <h:column><h:outputText value="Nb Parts TRIMF:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0202'}"/></h:column>
                                <h:column><h:inputText id="idNbpartTrimf" style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleNbPartTrimf}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0202'}"/></h:column>
                                <h:column><h:outputText value="Nb Femmes:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleGenre==1}"/></h:column>
                                <h:column><h:inputText id="idNbFemme" style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleNbFemme}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleGenre==1}"/></h:column>
                                <h:column><h:outputText value="Régime congés:"/></h:column>
                                <h:column><h:inputText style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleNbJourCp}"/>&nbsp;&nbsp;<h:outputText value="(Nb jours congés par mois)"/></h:column>
                                <h:column><h:outputText value="Nb jours travail:"/></h:column>
                                <h:column><h:inputText style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleNbJourTr}"/>&nbsp;&nbsp;<h:outputText value="(Nb jour de travail par mois)"/></h:column>
                            </h:panelGrid>
                            <br>
                            <h:panelGrid width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur">
                                <h:column><h:outputText value="Catégorie salariale:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idgrille" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_grille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                        <f:selectItem itemLabel="Sélectionnez Grille" itemValue="0" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesGrillesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="Clé 1 répartition:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_cle1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                        <f:selectItem itemLabel="" itemValue="" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesClesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Clé 2 répartition:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_cle2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                        <f:selectItem itemLabel="" itemValue="" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesClesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.optionPaye.modeTravail!='1'}"><h:outputText value="Activité:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.optionPaye.modeTravail!='1'}">
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_activite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                        <f:selectItem itemLabel="" itemValue="" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesActivitesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.optionPaye.modeTravail!='2'}"><h:outputText value="Service:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.optionPaye.modeTravail!='2'}">
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_service}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                        <f:selectItem itemLabel="" itemValue="" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesServiceItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Localisation:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleLocalisation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeContrat==0}">
                                        <f:selectItem itemLabel="" itemValue="" />
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesLocalisationItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <br>
                            <h:panelGrid width="100%" id="idPaiement" styleClass="fichefournisseur">
                                <h:panelGrid columns="4"  columnClasses="clos15,clos35,clos15,clos35" width="100%">
                                    <h:column><h:outputText value="Mode de paiement:"/></h:column>
                                    <h:column>
                                        <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleModeReglement}">
                                            <f:selectItem itemLabel="Espèce" itemValue="0"/>
                                            <f:selectItem itemLabel="Carte pré-payée" itemValue="3"/>
                                            <f:selectItem itemLabel="Mobile" itemValue="5" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.accesOrange}"/>
                                            <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.modeCalculPaiement}" reRender="panPaiement,idPaiement"/>
                                        </h:selectOneRadio>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid columns="2" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleModeReglement==3}">
                                    <h:column><h:outputText value="Code banque:"/></h:column>
                                    <h:column><h:inputText size="4" maxlength="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleNumBanque}"/></h:column>
                                    <h:column><h:outputText value="N° carte:"/></h:column>
                                    <h:column><h:inputText size="15" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleCompteBanque}"/></h:column>
                                </h:panelGrid>
                                <h:panelGrid columns="2" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleModeReglement==5}">
                                    <h:column><h:outputText value="N° téléphone mobile:"/></h:column>
                                    <h:column><h:inputText size="15" maxlength="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salariesElements.saleleCompteBanque}"/></h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                        </rich:tab>

                    </rich:tabPanel>

                    <h:panelGroup>
                        <br>
                        <center>
                            <a4j:commandButton id="idValVariable" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.saveVariablesJournaliers}" reRender="panelVariable,idEffectue"/>
                            <rich:hotKey key="return"  handler="#{rich:element('idValVariable')}.click()" />
                        </center>
                    </h:panelGroup>

                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelImpPrepa" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="800" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelPrintPrep}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelPrintPrep}" var="prtprp">
            <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.closeImpressionPrep}" image="/images/close.gif" styleClass="hidelink" reRender="panelImpPrepa"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImpPrepa" target="_blank">
                <br>
                <h:panelGrid width="100%">
                    <h:panelGrid  width="100%" style="border:solid 1px black;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.nomModeleListe}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.listeImpressionItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px black;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                                    <h:selectOneMenu id="impSelectPrepa" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="formModalImp,modAttente,panelMail"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMailPrepa" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px black;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column><h:inputText style="width:100%"  /></h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.affMail}" id="printPrepa" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelImpRub" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="800" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelPrintRub}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelPrintRub}" var="prtrub">
            <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.closeImpressionRub}" image="/images/close.gif" styleClass="hidelink" reRender="panelImpRub"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImpRub" target="_blank">
                <br>
                <h:panelGrid width="100%">
                    <h:panelGrid  width="100%" style="border:solid 1px black;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.nomModeleListe}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.listeImpressionItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px black;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                                    <h:selectOneMenu id="impSelectPrepa" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="formModalImp,modAttente,panelMail"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMailPrepa" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px black;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column><h:inputText style="width:100%"  /></h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.affMail}" id="printPrepa" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelListeBulletin" width="800" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelListeBulletin}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelListeBulletin}" var="lst">
            <f:facet name="header"><h:outputText value="LISTE DES BULLETINS POUR #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.bulletinSalaire.salaries.salNom}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanListeBulletin" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.fermerListeBulletin}" styleClass="hidelink" reRender="panelListeBulletin"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanListeBulletin')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGroup>
                    <center>
                        <a4j:commandButton title="Consulter le bulletin généré" image="/images/detail.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.consulterBulletin}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelBulletin"/>
                    </center>
                </h:panelGroup>
                <h:panelGrid style="width:100%;" id="panListeBulletin">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable rows="200" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.dataModelListeBulletins}" enableContextMenu="false" var="liste" id="listeBulletin" border="0" styleClass="bg" style="border:solid 1px green" width="100%" height="400px" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.selectionBulletin}"/>
                            <rich:column width="10%" sortable="false">
                                <f:facet name="header"><h:outputText value="Période"/></f:facet>
                                <h:outputText value="#{liste.bulsalPeriode}"/>
                            </rich:column>
                            <rich:column width="12%" sortable="false" >
                                <f:facet name="header"><h:outputText value="Date début"/></f:facet>
                                <h:outputText value="#{liste.bulsalDateDebut}"/>
                            </rich:column>
                            <rich:column width="12%" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Date début"/></f:facet>
                                <h:outputText value="#{liste.bulsalDateFin}"/>
                            </rich:column>
                            <rich:column width="12%" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Activité"/></f:facet>
                                <h:outputText value="#{liste.bulsalActivite}"/>
                            </rich:column>
                            <rich:column width="12%" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Av. Nat."/></f:facet>
                                <h:outputText value="#{liste.bulsalAvNat}" rendered="#{liste.bulsalAvNat!=0}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="12%" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="C.P."/></f:facet>
                                <h:outputText value="#{liste.bulsalCP}" rendered="#{liste.bulsalCP!=0}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="12%" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Net"/></f:facet>
                                <h:outputText value="#{liste.bulsalNetPayer}" rendered="#{liste.bulsalNetPayer!=0}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelListeRubrique" width="1350" height="520" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.showModalPanelListeRubrique}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.showModalPanelListeRubrique}" var="rub">
            <f:facet name="header"><h:outputText value="LISTE DES RUBRIQUES POUR #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.salaries.salMatricule} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.salaries.salNom}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanListeRubrique" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.fermerlisteRubrique}" styleClass="hidelink" reRender="panelListeRubrique"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanListeRubrique')}.click()" />
                </a4j:form>
            </f:facet>
            <jsp:include flush="true" page="/paye/FicheSalarieRubriques.jsp" />
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelBulletin" width="900" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.showModalPanelBulletin}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.showModalPanelBulletin}" var="bul">
            <f:facet name="header"><h:outputText value="BULLETIN DU : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.bulsalPeriode} POUR #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.salaries.salMatricule} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.salaries.salNom}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanBulletin" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.fermerConsulterBulletin}" styleClass="hidelink" reRender="panelBulletin,panelImpBulletin"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanBulletin')}.click()" />
                </a4j:form>
            </f:facet>
            <jsp:include flush="true" page="/paye/FicheSalarieBulletins.jsp" />
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelListeSalaries" width="1000" height="520" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelSalaries}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelSalaries}" var="sal">
            <f:facet name="header"><h:outputText value="Recherche des journaliers"></h:outputText></f:facet>
            <a4j:form>
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableSalaries"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_nb_max}" border="0" enableContextMenu="true" id="tableSalaries" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" height="400px" styleClass="bg" style="border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.datamodelSalaries}" var="salSel">
                        <rich:column label="Sélection agent" sortable="true" width="5%" sortBy="#{salSel.select_agent}">
                            <f:facet name="header"><h:outputText  value="Sel."/></f:facet>
                            <h:selectBooleanCheckbox value="#{salSel.select_agent}"/>
                        </rich:column>
                        <rich:column label="Matricule agent" sortable="true" width="10%" sortBy="#{salSel.salMatricule}">
                            <f:facet name="header"><h:outputText  value="Matricule"/></f:facet>
                            <h:outputText value="#{salSel.salMatricule}"/>
                        </rich:column>
                        <rich:column label="Civilité" sortable="true" width="10%" sortBy="#{salSel.salCivilite}">
                            <f:facet name="header"><h:outputText  value="Civilité"/></f:facet>
                            <h:outputText value="#{salSel.salCivilite}"/>
                        </rich:column>
                        <rich:column label="Nom et prénom" sortable="true" width="30%" sortBy="#{salSel.salNom}  #{salSel.salPrenom}">
                            <f:facet name="header"><h:outputText  value="Nom et prénom"/></f:facet>
                            <h:outputText value="#{salSel.salNom}  #{salSel.salPrenom}"/>
                        </rich:column>
                        <rich:column label="Etat" sortable="true" width="10%" sortBy="#{salSel.lib_etat}">
                            <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                            <h:outputText value="#{salSel.lib_etat}"/>
                        </rich:column>
                        <rich:column label="Service" sortable="true" width="10%" sortBy="#{salSel.salService}">
                            <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                            <h:outputText value="#{salSel.salService}"/>
                        </rich:column>
                        <rich:column label="Activite" sortable="true" width="10%" sortBy="#{salSel.salActivite}">
                            <f:facet name="header"><h:outputText  value="Activite"/></f:facet>
                            <h:outputText value="#{salSel.salActivite}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br>
                <h:panelGroup id="panelValide">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.fermerRechercheJournalier}" reRender="panelListeSalaries"/>&nbsp;&nbsp;
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.validerRechercheJournalier}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelBarProg" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="700" height="80" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_showBarProg}">
        <f:facet name="header"><h:outputText value="Traitement en cours..."/></f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel id="progressPanel">
                    <rich:progressBar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_currentValue}" style="width:90%" interval="300" enabled="true" minValue="-1" maxValue="100" id="barprg">
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_info} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_currentValue} %)"/>
                    </rich:progressBar>
                </a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelJournalier" width="900" height="450" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelJournalier}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelJournalier}" var="saljr">
            <f:facet name="header"><h:outputText value="FICHE D'UN JOURNALIER"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.fermerJournaliers}" styleClass="hidelink" reRender="panelJournalier"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid style="width:100%;" id="panJournaliers">

                    <h:panelGrid width="100%">
                        <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" id="panelId1">
                            <h:column><h:outputText style="border:0px;color:red;text-decoration:underline;" value="Nature:"/></h:column>
                            <h:column><h:inputText style="border:0px;color:red;width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_nature_agent}" disabled="true"/></h:column>
                            <h:column><h:outputText style="border:0px;color:red" value="Matricule:"/></h:column>
                            <h:column>
                                <h:inputText style="border:0px;color:red;width:40%;text-align:center" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salMatricule}" readonly="true"/>&nbsp;&nbsp;
                                <h:graphicImage  value="/images/cadenas_op.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salProtege==0}"/>
                                <h:graphicImage  value="/images/cadenas_cl.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salProtege==1}"/>&nbsp;
                                <a4j:commandButton style="border:0px;color:red;width:40%;text-align:center" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.lib_etat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.visuEtat}" reRender="panelVisuEtat"/>
                            </h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Civilité:"/></h:column>
                            <h:column>
                                <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salCivilite}">
                                    <f:selectItem itemLabel="Madame" itemValue="Madame"/>
                                    <f:selectItem itemLabel="Mademoiselle" itemValue="Mademoiselle"/>
                                    <f:selectItem itemLabel="Monsieur" itemValue="Monsieur"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.calculeGenreCivil}" reRender="panelId1,idGenre,idLjf,idSjf"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Genre:"/></h:column>
                            <h:column>
                                <h:selectOneRadio id="idGenre" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salGenre}" disabled="true" style="width:200px">
                                    <f:selectItem itemLabel="Femme" itemValue="0"/>
                                    <f:selectItem itemLabel="Homme" itemValue="1"/>
                                </h:selectOneRadio>
                            </h:column>
                            <h:column><h:outputText value="Nom:"/></h:column>
                            <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salNom}" maxlength="100"/></h:column>
                            <h:column><h:outputText value="Prénom:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salPrenom}" maxlength="50" onkeypress="return scanToucheLettre(event)" style="width:95%;text-transform:capitalize"/></h:column>
                            <h:column><h:outputText id="idLjf" value="Nom Jeune fille:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_affiche_nomJf}"/></h:column>
                            <h:column><h:inputText id="idSjf" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salNomJf}" maxlength="100" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_affiche_nomJf}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                            <h:column><h:outputText value="Téléphone dom.:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salTelDom}" maxlength="50"/></h:column>
                            <h:column><h:outputText value="Mobile 1:"/></h:column>
                            <h:column>
                                <h:inputText style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salCel1}" maxlength="50"/>&nbsp;&nbsp;
                                <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.envoiSmsZ1}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                            </h:column>
                            <h:column><h:outputText value="Mobile 2:"/></h:column>
                            <h:column>
                                <h:inputText style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salCel2}" maxlength="50"/>&nbsp;&nbsp;
                                <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.envoiSmsZ2}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                            </h:column>
                            <h:column><h:outputText value="Mobile 3:"/></h:column>
                            <h:column>
                                <h:inputText style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salCel3}" maxlength="50"/>&nbsp;&nbsp;
                                <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.envoiSmsZ3}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                            </h:column>
                            <h:column><h:outputText value="Mail:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salMail1}" maxlength="100"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="4" width="100%" styleClass="fichefournisseur"  columnClasses="clos15,clos35,clos15,clos35">
                            <h:column><h:outputText value="N° carte identité:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salNumCi}" maxlength="20"/></h:column>
                            <h:column><h:outputText value="Délivrée à:"/></h:column>
                            <h:column><h:inputText style="width:95%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salLieuCi}" maxlength="50"/></h:column>
                            <h:column><h:outputText value="Par:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salDelivreCi}" maxlength="50"/></h:column>
                            <h:column><h:outputText value="Date délivrance:"/></h:column>
                            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salDateCi}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="4" width="100%" styleClass="fichefournisseur"  columnClasses="clos15,clos35,clos15,clos35">
                            <h:column><h:outputText value="Fonction:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salFonction}" maxlength="50"/></h:column>
                            <h:column><h:outputText value="Durée:"/></h:column>
                            <h:column>
                                <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salDureeJour}" >
                                    <f:selectItem itemLabel="Journée" itemValue="0"/>
                                    <f:selectItem itemLabel="1/2 journée" itemValue="1"/>
                                    <f:selectItem itemLabel="Autre" itemValue="2"/>
                                </h:selectOneRadio>
                            </h:column>
                            <h:column><h:outputText value="Classement:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_classement}" disabled="true"/></h:column>
                            <h:column><h:outputText value="Centre Impôt:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idcentre" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_centre}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action_contrat==3}">
                                    <f:selectItem itemLabel="Sélectionnez Centre impôt" itemValue="0" />
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesCentresImpotsItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Convention:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idconvention" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_convention}">
                                    <f:selectItem itemLabel="Sélectionnez Convention" itemValue="0" />
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesConventionsItems}" />
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.chargerGrille}" reRender="idConfig2,idgrille"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Catégorie Salariale:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idgrille" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_grille}">
                                    <f:selectItem itemLabel="Sélectionnez Grille" itemValue="0" />
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.mesGrillesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGroup>
                        <br>
                        <center>
                            <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.validerJournaliers}" reRender="panelJournalier,tableSalaries,scrollTable"/>
                        </center>
                    </h:panelGroup>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   id="modalSms" headerClass="headerPanel" width="500" height="200" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelSms}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.showModalPanelSms}" var="sms">
            <f:facet name="header"><h:outputText value="ENVOI SMS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.fermerSms}" image="/images/close.gif" styleClass="hidelink" reRender="modalSms"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid  columns="2" width="100%" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Numéro mobile:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.numeroMobile}" readonly="true"/></h:column>
                    <h:column><h:outputText value="Texte message:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.messageSms}" maxlength="160" style="width:95%"/></h:column>
                </h:panelGrid>
                <br/> <br/>
                <center>
                    <h:panelGroup id="valSms">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.valideEnvoiSms}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,modalSms"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
