<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="budgetliste">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES BUDGETS" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
                <h:panelGrid columns="5" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_more_search}"/>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_more_search}">
                            <f:selectItem itemLabel="Toutes Années" itemValue="0"/>
                            <f:selectItems id="idAnnee" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.lesPeriodes}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.inpMode}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Modes" itemValue="100"/>
                            <f:selectItem itemLabel="Normal" itemValue="0"/>
                            <f:selectItem itemLabel="Exceptionnel" itemValue="1"/>
                            <f:selectItem itemLabel="Fonds de roulement" itemValue="2"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItems id="idEtats" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.mesEtatsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,tableBudget,scrollTableBudget"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="10" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_more_search}">
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="10" width="400px" style="height:34px">
            <a4j:commandButton title="Ajouter nouveau budget" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.ajouterBudget}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier le budget sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetEntete.biebudentEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.modifierBudget}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter le budget sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.consulterBudget}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer le budget sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetEntete.biebudentEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer le bail sélectionné ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.supprimerBudget}" reRender="tableBudget,scrollTableBudget,panelBouton"/>
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
            <a4j:commandButton title="Valider le budget sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetEntete.biebudentEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce budget ?')) return false" reRender="panelBouton,idEtat"/>
            <a4j:commandButton title="Dé-Valider le budget sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetEntete.biebudentEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce budget ?')) return false" reRender="panelBouton,idEtat"/>
            <a4j:commandButton title="Clôturer le budget sélectionné" image="/images/lock.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetEntete.biebudentEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.cloturerDocument}" onclick="if (!confirm('Etes-vous sur de vouloir cloturer ce budget ?')) return false" reRender="panelBouton,idEtat"/>
            <a4j:commandButton title="Recalcul de tous les budgets" image="/images/actualiser.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.reclculerBudgets}" onclick="if (!confirm('Etes-vous sur de vouloir recalculer les budgets de cette liste ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,tableBudget,scrollTableBudget"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>

            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.pageIndex}" reRender="tableBudget" id="scrollTableBudget" maxPages="20" align="left" for="tableBudget" />
                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableBudget" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.datamodelBudget}" var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.extDTable}">
                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton"/>
                    <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.visualisationLigne}" reRender="idSubView,panelBouton"/>
                    <rich:column label="Numéro du budget" sortable="true" width="70px" sortBy="#{var.biebudentNum}">
                        <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                        <h:outputText value="#{var.biebudentNum}"/>
                    </rich:column>
                    <rich:column id="idEtat" label="Etat du budget" sortable="true" width="70px" sortBy="#{var.libelleEtat}">
                        <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                        <h:outputText value="#{var.libelleEtat}"/>
                    </rich:column>
                    <rich:column label="Mode du budget" sortable="true" width="70px" sortBy="#{var.libelleMode}">
                        <f:facet name="header"><h:outputText  value="Mode" /></f:facet>
                        <h:outputText value="#{var.libelleMode}"/>
                    </rich:column>
                    <rich:column label="Numéro du bien" sortable="true" width="70px" sortBy="#{var.bien.bieNum}">
                        <f:facet name="header"><h:outputText  value="N° Bien" /></f:facet>
                        <h:outputText value="#{var.bien.bieNum}"/>
                    </rich:column>
                    <rich:column label="Nom du bien" sortable="true" width="150px" sortBy="#{var.bien.bieNom}">
                        <f:facet name="header"><h:outputText  value="Nom Bien" /></f:facet>
                        <h:outputText value="#{var.bien.bieNom}"/>
                    </rich:column>
                    <rich:column label="Année" sortable="true" width="80px" sortBy="#{var.biebudentAnnee}">
                        <f:facet name="header"><h:outputText  value="Année" /></f:facet>
                        <h:outputText value="#{var.biebudentAnnee}"/>
                    </rich:column>
                    <rich:column label="Date début" sortable="true" width="100px" sortBy="#{var.biebudentDateDebut}">
                        <f:facet name="header"><h:outputText  value="Début" /></f:facet>
                        <h:outputText value="#{var.biebudentDateDebut}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Date fin" sortable="true" width="100px" sortBy="#{var.biebudentDateFin}">
                        <f:facet name="header"><h:outputText  value="Fin" /></f:facet>
                        <h:outputText value="#{var.biebudentDateFin}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Relquat N-1" sortable="true" width="100px" sortBy="#{var.biebudentResteAnterieur}" style="text-align:right">
                        <f:facet name="header"><h:outputText  value="Reliquat" /></f:facet>
                        <h:outputText value="#{var.biebudentResteAnterieur}" rendered="#{var.biebudentResteAnterieur!=0}" >
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Montant budget" sortable="true" width="100px" sortBy="#{var.biebudentTotal}" style="text-align:right">
                        <f:facet name="header"><h:outputText  value="Total" /></f:facet>
                        <h:outputText value="#{var.biebudentTotal}" rendered="#{var.biebudentTotal!=0}" >
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Montant Charges" sortable="true" width="100px" sortBy="#{var.biebudentDepenses}" style="text-align:right">
                        <f:facet name="header"><h:outputText  value="Réalisés" /></f:facet>
                        <h:outputText value="#{var.biebudentDepenses}" rendered="#{var.biebudentDepenses!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Montant Charges non imputées" sortable="true" width="100px" sortBy="#{var.biebudentDepensesNonImpute}" style="text-align:right">
                        <f:facet name="header"><h:outputText  value="Non Imputées" /></f:facet>
                        <h:outputText value="#{var.biebudentDepensesNonImpute}" rendered="#{var.biebudentDepensesNonImpute!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="% d'exécution" sortable="true" width="100px" sortBy="#{var.biebudentRealisation}" style="text-align:right">
                        <f:facet name="header"><h:outputText  value="%" /></f:facet>
                        <h:outputText value="#{var.biebudentRealisation}" rendered="#{var.biebudentRealisation!=0}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                        </h:outputText>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>

        </center>

    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.showModalPanelPrint}" var="prt">
            <center>
                <f:facet name="header"><h:outputText value="Impression : Choisissez un modèle et un format d'Impression"/></f:facet>
                <f:facet name="controls">
                    <a4j:form >
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
                            <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                        </a4j:commandButton>
                    </a4j:form>
                </f:facet>
                <a4j:form id="formModalImp" target="_blank">
                    <h:panelGrid  width="100%" id="idSelectionImpression">
                        <h:panelGrid id="panchoixdoc" width="100%" style="border:solid 0px green;">
                            <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                            <br>
                            <h:panelGrid columns="2" width="100%">
                                <h:selectOneRadio id="choixDoc1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.var_choix_modele}">
                                    <f:selectItem itemLabel="Document séléctionné" itemValue="0"/>
                                    <f:selectItem itemLabel="Liste de documents" itemValue="1"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.listeDocImp}" reRender="idSelectionImpression,panchoixdoc,docSelect,listeSelect,panCertification"/>
                                </h:selectOneRadio>
                                <h:selectOneMenu id="docPeriode" style="width:250px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.periode}">
                                    <f:selectItem itemLabel="Année Complète" itemValue="0"/>
                                    <f:selectItem itemLabel="1er Trimestre" itemValue="1"/>
                                    <f:selectItem itemLabel="2eme Trimestre" itemValue="2"/>
                                    <f:selectItem itemLabel="3eme Trimestre" itemValue="3"/>
                                    <f:selectItem itemLabel="4eme Trimestre" itemValue="4"/>
                                </h:selectOneMenu>
                            </h:panelGrid>
                            <br>
                            <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.nomModeleDocument}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.affListeDoc}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.documentImpressionItems}"/>
                            </h:selectOneMenu>
                            <h:selectOneMenu id="listeSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.nomModeleListe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.affListeDoc}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.listeImpressionItems}"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                        <h:panelGrid id="panCertification" width="100%" columns="2" style="border:solid 0px green;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.var_choix_modele==0}">
                            <f:facet name="header"><h:outputText value="Certification document"/></f:facet>
                            <h:outputText value="La certification des doucments permet de générer un cachet électronique, certifié par l'Agence UniverSign. Ce cachet életronique est reconnu par tous les tribunaux."/>
                            <h:graphicImage value="/images/logo_universign.png"title="UniverSign"/>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.afficheUniverSign}">
                                <h:outputText value="Voulez-vous activer la certification pour le document en cours?"/>&nbsp;&nbsp;&nbsp;&nbsp;
                                <h:selectBooleanCheckbox title="Activer la certification" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.certification}"/>
                            </h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.afficheUniverSign}">
                                <h:outputText value="Votre certification n'est pas active. Pour l'activer, veuillez vous rapprocher des équipes d'HORUS SOLUTIONS ou de SENTRUST."/>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="border:solid 0px green;background-color:white;">
                            <f:facet name="header"><h:outputText value="Format"/></f:facet>
                            <br>
                            <!--immobilier-->
                            <h:column>
                                <h:panelGrid  width="100%" columns="9" style="height:80px">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                        <center>
                                            <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe  (Imprimantes du serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.imp}"/>
                                            <h:selectOneMenu id="impSelect6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                            </h:selectOneMenu>
                                        </center>
                                    </h:panelGroup>
                                    <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                                    <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.imp}"/>
                                    <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.imp}"/>
                                    <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.imp}"/>
                                    <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.imp}"/>
                                    <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.imp}"/>
                                    <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.imp}"/>
                                    <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="formModalImp,modAttente,panelMail"/>
                                </h:panelGrid>
                            </h:column>
                        </h:panelGrid>
                        <!--mails-->
                        <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.affMail}">
                            <h:panelGrid  width="100%"  style="border:solid 0px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.impEmetteur}" >
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.lesbalEmetteursItems}"/>
                                    </h:selectOneMenu >
                                </h:column>
                                <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.impDestinataire}" >
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.lesbalDestinatairesItems}"/>
                                        <f:selectItem itemLabel="" itemValue="" />
                                    </h:selectOneMenu >
                                </h:column>
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column><h:outputText value="Copie à (CC):"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.impDestinataireCC}"/></h:column>
                                <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.impDestinataireCCI}"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid  width="100%" style="text-align:center;">
                                <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>


</f:subview>
