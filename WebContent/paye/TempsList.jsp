<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="Listetemps1">

    <a4j:form >

        <center> <h2><h:outputText value="GESTION DES TEMPS" styleClass="titre"/></h2></center>

        <h:panelGrid id="panelGlobal" width="100%" >
            <h:panelGrid id="panelRecherche" columns="5"  styleClass="recherche" width="100%" >
                <h:selectOneMenu id="idPeriode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.periode}" style="width:150px;" >
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.lesPeriodes}"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelGlobal,panelRecherche,panelBouton,tableEcriture,panelSolde,scrollTable" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.razTemps}"/>
                </h:selectOneMenu>
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_nom_agent}" style="width:247px;" >
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.mesAgentsItems}"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelGlobal,panelRecherche,panelBouton,tableEcriture,panelSolde,scrollTable" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.razTemps}"/>
                </h:selectOneMenu>
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.etat}" style="width:100px;" >
                    <f:selectItem itemLabel="Tous les états" itemValue="100"/>
                    <f:selectItem itemLabel="En Cours" itemValue="0"/>
                    <f:selectItem itemLabel="Validés" itemValue="1"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelGlobal,panelRecherche,panelBouton,tableEcriture,panelSolde,scrollTable" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.razTemps}"/>
                </h:selectOneMenu>
                <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.chargerLesTemps}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelGlobal,panelBouton,scrollTable,tableEcriture"/>
                <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
            </h:panelGrid>

            <h:panelGrid id="panelBouton" columns="9" width="350px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.testsaisiePointage}">
                <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouveau temps" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.ajouterPointage}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/modifier.png" title="Modifier le temps sélectionné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.modifierPointage}" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.salariesPointage.salpoiEtat==0)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/detail.png" title="Consulter le temps sélectionné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.consulterPointage}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_affiche_bouton}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton image="/images/supprimer.png" title="Supprimer le temps sélectionné" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.salariesPointage.salpoiEtat==0)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.supprimerPointage}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette pièce?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="tableEcriture,panelSolde,panelBouton,modAttente,scrollTable"/>
                <a4j:commandButton image="/images/print.png"title="Imprimer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                <a4j:commandButton title="Grapher" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" reRender="panelGraph,formModalGraph,container" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.initGrapheur}"/>
                <a4j:commandButton image="/images/valDoc.png" title="Valider dans les journaux" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.validationLignes}" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.trf}" reRender="panelValidation"/>
                <a4j:commandButton title="Informations sur le pointage" image="/images/info.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.informationPiece}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_affiche_bouton}" reRender="panelInformation"/>
                <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
            </h:panelGrid>
        </h:panelGrid>

        <a4j:region renderRegionOnly="false">
            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.pageIndex}" reRender="tableEcriture" id="scrollTable" maxPages="20"align="left" for="tableEcriture"/>
            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_nb_max}" id="tableEcriture" width="100%" styleClass="bg" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="max-height:100%;border:solid 0px green;cursor:pointer;" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.datamodelSalariesPointage}" var="point" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.extDTable}">
                <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.selectionPointage}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton"/>
                <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.visualisationPointage}" reRender="idSubView,panelBouton"/>
                <rich:column style="text-align:center;" width="5%" sortable="false" sortBy="#{point.salpoiEtat}">
                    <f:facet name="header"><h:outputText  value="Clot" /></f:facet>
                    <h:graphicImage rendered="#{point.salpoiEtat!=0}"  value="/images/cadenas_cl.png" id="imcadenas"/>
                </rich:column>
                <rich:column width="8%"  sortable="false" sortBy="#{point.salpoiDate}">
                    <f:facet name="header"><h:outputText value="Date "/></f:facet>
                    <h:outputText value="#{point.salpoiDate}"  >
                        <f:convertDateTime pattern="dd/MM/yyyy"/>
                    </h:outputText>
                </rich:column>
                <rich:column  width="5%" sortable="false" sortBy="#{point.salpoiDuree}" style="text-align:right">
                    <f:facet name="header"><h:outputText value="Durée"/></f:facet>
                    <h:outputText value="#{point.salpoiDuree}" style="text-align:right">
                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                    </h:outputText>
                </rich:column >
                <rich:column  width="5%" sortable="false" sortBy="#{point.salpoiContrat}" rendered="false">
                    <f:facet name="header"><h:outputText value="Contrat" /></f:facet>
                    <h:outputText value="#{point.salpoiContrat}"/>
                </rich:column >
                <rich:column  width="20%" sortable="false" sortBy="#{point.salpoiNomTiers}" >
                    <f:facet name="header"><h:outputText value="Tiers"/></f:facet>
                    <h:outputText value="#{point.salpoiNomTiers}"/>
                </rich:column >
                <rich:column  width="8%" sortable="false" sortBy="#{point.salpoiMission}" >
                    <f:facet name="header"><h:outputText value="Mission"/></f:facet>
                    <h:outputText value="#{point.salpoiMission}"/>
                </rich:column>
                <rich:column  width="20%" sortable="false" sortBy="#{point.salpoiTache}" >
                    <f:facet name="header"><h:outputText value="Tache"/></f:facet>
                    <h:outputText value="#{point.salpoiTache}"/>
                </rich:column>
                <rich:column  width="10%" sortable="false" sortBy="#{point.salpoiService}" >
                    <f:facet name="header"><h:outputText value="Service"/></f:facet>
                    <h:outputText value="#{point.salpoiService}"/>
                </rich:column>
                <rich:column  width="10%" sortable="false" sortBy="#{point.salpoiActivite}" >
                    <f:facet name="header"><h:outputText value="Activité"/></f:facet>
                    <h:outputText value="#{point.salpoiActivite}"/>
                </rich:column>
                <rich:column  width="10%" sortable="false" sortBy="#{point.salpoiObjet}">
                    <f:facet name="header"><h:outputText value="Observation"/></f:facet>
                    <h:outputText value="#{point.salpoiObjet}"/>
                </rich:column >
            </rich:extendedDataTable>
        </a4j:region>
        <br><br>
        <h:panelGrid id="panelSolde" columns="6"  styleClass="recherche"  width="100%" >

        </h:panelGrid>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitationTemps.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.valQteGraph}" >
                                <f:selectItem itemLabel="En Durée" itemValue="0"/>
                                <f:selectItem itemLabel="en P.V." itemValue="1"/>
                                <f:selectItem itemLabel="en P.R." itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <f:selectItem itemLabel="par client" itemValue="1"/>
                                <f:selectItem itemLabel="par mission" itemValue="2"/>
                                <f:selectItem itemLabel="par tache" itemValue="3"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.timeDecoupage}">
                                <f:selectItem itemLabel="mois" itemValue="0"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelInformation" width="600" height="160" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.showModalPanelInformation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.showModalPanelInformation}" var="inf">
            <f:facet name="header"><h:outputText value="INFORMATION SUR LE POINTAGE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.fermerInformationPiece}" image="/images/close.gif" styleClass="hidelink" reRender="panelInformation"/>
                </a4j:form >
            </f:facet>
            <a4j:form id="formLpr">
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos30,clos70">
                    <h:outputText value="ID pointage:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.salariesPointage.salpoiId}"/>
                    <h:outputText value="Date de création:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.salariesPointage.salpoiDateCreat}" datePattern="dd/MM/yyyy hh:mm:ss"  locale="fr" style=" background-color:white;" inputSize="20" readonly="true" disabled="true"/>
                    <h:outputText value="Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.nomCreation} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.salariesPointage.salpoiUserCreat})"/>
                    <h:outputText value="Modifié le:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.salariesPointage.salpoiDateModif}" datePattern="dd/MM/yyyy hh:mm:ss"  locale="fr" style=" background-color:white;" inputSize="20"  readonly="true" disabled="true"/>
                    <h:outputText value="Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.nomModification} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.salariesPointage.salpoiUserModif})"/>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
