<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="impressionpaye">

    <a4j:form target="_blank" >

        <center><h2><h:outputText value="IMPRESSIONS DE LA PAYE" styleClass="titre"/></h2></center>

        <center><a4j:commandButton value="Bordereaux de versement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.openBordereau}" reRender="panelBordereaux"/></center>

        <h:panelGroup id="panGlobal">

            <h:panelGrid width="100%" columns="3"  id="panGlob">

                <rich:column width="300px" style="max-height:100%" >
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableRepertoire" enableContextMenu="false" footerClass="bard" headerClass="headerTab" activeClass="active-row" border="1" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;border-radius:10px" noDataLabel=" " width="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.dataModelImpgen}" var="repert">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.recupererNomrep}" reRender="panGlobal,tableNomEtat,richPFiltre,panPrint,panLigne,panDocument,panExport"/>
                            <rich:column width="100%" sortBy="#{repert}" sortable="true"  sortOrder="ASCENDING">
                                <f:facet name="header" > <h:outputText value="Sélection état"/></f:facet>
                                <h:outputText value="#{repert}"/>
                            </rich:column >
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:column>
                <rich:column width="300px" style="max-height:100%;">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableNomEtat" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="1" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;border-radius:10px" activeClass="active-row" noDataLabel=" " width="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.dataModelImpgenFichier}" var="rapport">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.recupererNomfich}" reRender="richPFiltre,panPrint,panLigne,panDocument,panExport,panColonne"/>
                            <rich:column  width="100%" sortBy="#{rapport}" sortable="true" sortOrder="ASCENDING">
                                <f:facet name="header" ><h:outputText value="Sélection modéle" /></f:facet>
                                <h:outputText  value="#{rapport}"/>
                            </rich:column >
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:column >
                <rich:column id="richPFiltre"  width="100%" >
                    <h:panelGrid headerClass="headerTab" width="100%" styleClass="fichefournisseur1" style="height:505px;display:block;overflow-y:scroll;width:400px;border-radius:10px">
                        <f:facet name="header" ><h:outputText value="Filtres"/></f:facet>
                        <h:panelGrid width="100%" columns="2" columnClasses="clos50d,clos50g" id="panFiltre">
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.testafficheDocument||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.nomRepertoire=='05-contrat'}"><h:outputText value="Période:" /></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.testafficheDocument||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.nomRepertoire=='05-contrat'}">
                                <h:selectOneMenu id="idPeriode" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.periode}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesPeriodesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.calculeDates}" reRender="idD1,idD2"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.testafficheDocument}"><h:outputText value="Du:" /></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.testafficheDocument}"><rich:calendar id="idD1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.filtreDateDebut}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.testafficheDocument}"><h:outputText value="Au:" /></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.testafficheDocument}"><rich:calendar id="idD2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.filtreDateFin}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;" /></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.interim}"><h:outputText value="Sélection tiers" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.interim}">
                                <div style="max-height:100px;width:100%;overflow:scroll;border:solid 1px black;">
                                    <h:selectManyListbox id="idClient" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.listeClients}" >
                                        <f:selectItem itemLabel="Tous clients" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.mesTiersItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.chargerServiceClient}" reRender="idService"/>
                                    </h:selectManyListbox>
                                </div>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.testafficheExport}"><h:outputText value="Mode exportation:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.testafficheExport}">
                                <h:selectOneMenu id="idMode" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.modeExportation}" >
                                    <f:selectItem itemLabel="Net à Payer" itemValue="0"/>
                                    <f:selectItem itemLabel="Acompte de quinzaine" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Etat Salarié:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idEtat" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.etatSalarie}" >
                                    <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                                    <f:selectItem itemLabel="Actif" itemValue="0"/>
                                    <f:selectItem itemLabel="En congés" itemValue="1"/>
                                    <f:selectItem itemLabel="Licencié" itemValue="2"/>
                                    <f:selectItem itemLabel="Démissioné" itemValue="3"/>
                                    <f:selectItem itemLabel="Décédé" itemValue="4"/>
                                    <f:selectItem itemLabel="Retraité" itemValue="5"/>
                                    <f:selectItem itemLabel="Fin de contrat" itemValue="6"/>
                                    <f:selectItem itemLabel="Arret/Suspendu" itemValue="7"/>
                                    <f:selectItem itemLabel="Mutation" itemValue="8"/>
                                    <f:selectItem itemLabel="Gelé/Bloqué" itemValue="9"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Matricule Salarié:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:inputText id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.nomSalarie}">
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.rechercheSalarie}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeTiers" />
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.testafficheDocument}"><h:outputText value="Sélection nature rubrique" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.testafficheDocument}">
                                <h:selectOneMenu id="idNatureRubrique" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.natureRubrique}" >
                                    <f:selectItem itemLabel="Toutes natures rubriques" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesNatureRubriqueItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.testafficheDocument}"><h:outputText value="Sélection rubrique" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.testafficheDocument}">
                                <h:selectOneMenu id="idRubrique" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.rubrique}" >
                                    <f:selectItem itemLabel="Toutes rubriques" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesRubriquesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Sélection nature salarié" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idNature" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.natureSalarie}" >
                                    <f:selectItem itemLabel="Toutes natures" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesNatureAgentItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Sélection feuille" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idFeuille" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.feuille}" >
                                    <f:selectItem itemLabel="Toutes feuilles" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesFeuillesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Sélection convention" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idConvention" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.convention}" >
                                    <f:selectItem itemLabel="Toutes conventions" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesConventionsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.chargerGrille}" reRender="idGrille"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Sélection grille" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idGrille" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.grille}" >
                                    <f:selectItem itemLabel="Toutes grilles" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesGrillesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Sélection centre d'impôt" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idCentre" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.centre}" >
                                    <f:selectItem itemLabel="Tous centres" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesCentresImpotsItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strNumSecuMultiple==1}"><h:outputText value="Sélection centre de sécurité sociale" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strNumSecuMultiple==1}">
                                <h:selectOneMenu id="idSecurite" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.securite}" >
                                    <f:selectItem itemLabel="Tous les centres de sécurités sociales" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesCentresSecuritesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Sélection classement" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idClassement" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.classement}" >
                                    <f:selectItem itemLabel="Tous classements" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesClassementsItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Sélection niveau emploi" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idNiveau" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.niveauEmploi}" >
                                    <f:selectItem itemLabel="Tous niveaux" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesNiveauxEmploisItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.testafficheDocument}"><h:outputText value="Sélection pays de naissance" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.testafficheDocument}">
                                <h:selectOneMenu id="idPays" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.pays}" >
                                    <f:selectItem itemLabel="Tous pays" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesPaysItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.testafficheDocument}"><h:outputText value="Sélection nationalité" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.testafficheDocument}">
                                <h:selectOneMenu id="idNtionalite" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.nationnalite}" >
                                    <f:selectItem itemLabel="Toutes nationalités" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesNationnalitesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.testafficheDocument}"><h:outputText value="Sélection localisations" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.testafficheDocument}">
                                <h:selectOneMenu id="idLocalisation" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.localisation}" >
                                    <f:selectItem itemLabel="Toutes localisations" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesLocalisationItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.var_anal_activite}"><h:outputText value="Activités:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.var_anal_activite}">
                                <div style="max-height:100px;width:100%;overflow:scroll;border:solid 1px black;">
                                    <h:selectManyListbox id="idActviteAgent" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.listeActivite}" >
                                        <f:selectItem itemLabel="Toutes les activités" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesActiviteItems}"/>
                                    </h:selectManyListbox>
                                </div>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.var_anal_activite}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.var_anal_activite}">
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.var_colonne1}" >
                                    <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.laColonne1Items}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.var_anal_activite}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.var_anal_activite}">
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.var_colonne2}" >
                                    <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.laColonne2Items}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.var_anal_activite}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.var_anal_activite}">
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.var_colonne3}" >
                                    <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.laColonne3Items}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.selectionMode==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.var_anal_site}"><h:outputText value="Sélection site:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.selectionMode==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.var_anal_site}">
                                <h:selectOneMenu id="idSite" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.site}" >
                                    <f:selectItem itemLabel="Tous sites" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesSitesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.chargerDepartement}" reRender="panFiltre,idDepartement,idService" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.selectionMode==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.var_anal_departement}"><h:outputText value="Sélection département:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.selectionMode==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.var_anal_departement}">
                                <h:selectOneMenu id="idDepartement" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.departement}" >
                                    <f:selectItem itemLabel="Tous départements" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesDepartementsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.chargerService}" reRender="panFiltre,idService" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.selectionMode==1}"><h:outputText value="Sélection service:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.selectionMode==1}">
                                <div style="max-height:100px;width:100%;overflow:scroll;border:solid 1px black;">
                                    <h:selectManyListbox id="idService" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.listeService}" >
                                        <f:selectItem itemLabel="Tous les services" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesServicesItems}"/>
                                    </h:selectManyListbox>
                                </div>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.selectionMode==2}"><h:outputText value="Sélection projet:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.selectionMode==2}">
                                <h:selectOneMenu id="idProjet" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.projet}" >
                                    <f:selectItem itemLabel="Tous projets" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesProjetItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Sélection budget:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idBudget" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.budget}" >
                                    <f:selectItem itemLabel="Tous budgets" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesBudgetItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.nomRepertoire!='04-ressources_humaines'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.nomRepertoire!='05-contrat'}"><h:outputText value="Sélection lot"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.nomRepertoire!='04-ressources_humaines'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.nomRepertoire!='05-contrat'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.lot}"/></h:column>
                            <h:column><h:outputText value="Sélection banque Entreprise:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idBanqueSociete" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.banqueSociete}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesBanqueItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Sélection banque agent:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <div style="max-height:100px;width:100%;overflow:scroll;border:solid 1px black;">
                                    <h:selectManyListbox id="idBanqueAgent" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.listeBanque}" >
                                        <f:selectItem itemLabel="Toutes les banques" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.mesBanqueAgentsItems}"/>
                                    </h:selectManyListbox>
                                </div>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%" id="panColonne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.testafficheDocumentUser}">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="tableColonne" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="1" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="border:1px solid black;cursor:pointer;" activeClass="active-row" noDataLabel=" " width="400px" height="200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.datamodelColonnes}" var="col">
                                    <rich:column  width="10%" sortBy="#{col.column_comment}" sortable="true">
                                        <f:facet name="header" ><h:outputText value="Sel." /></f:facet>
                                        <h:selectBooleanCheckbox  value="#{col.column_select}"/>
                                    </rich:column>
                                    <rich:column  width="60%" sortBy="#{col.column_comment}" sortable="true" sortOrder="ASCENDING">
                                        <f:facet name="header" ><h:outputText value="Colonne" /></f:facet>
                                        <h:outputText  value="#{col.column_comment}"/>
                                    </rich:column>
                                    <rich:column  width="30%" sortBy="#{col.column_name}" sortable="true">
                                        <f:facet name="header" ><h:outputText value="Code" /></f:facet>
                                        <h:outputText  value="#{col.column_name}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:column >

            </h:panelGrid>

            <center>
                <br>
                <h:panelGroup id="panPrint" style="height:80px" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.testafficheExport}">
                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="AperÃ§u avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/imp_csv.png" onmouseover="this.src='images/imp_csv_big.png'" onmouseout="this.src='images/imp_csv.png'" value="CSV" title="Export CSV" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.imprimerCSV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>&nbsp;&nbsp;
                    <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panMail"/>
                    <h:panelGrid id="panMail" width="100%">
                        <h:panelGrid  width="100%" columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.affMail}">
                            <h:panelGrid  width="100%"  style="border:solid 1px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idEmetteur" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.impEmetteur}" >
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.utilPrint.lesbalEmetteursItems}"/>
                                    </h:selectOneMenu >
                                </h:column>
                                <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idDestinataire" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.impDestinataire}" >
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.utilPrint.lesbalDestinatairesItems}"/>
                                        <f:selectItem itemLabel="" itemValue=""/>
                                    </h:selectOneMenu >
                                </h:column>
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column><h:outputText value="Copie Ã  (CC):"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.impDestinataireCC}"/></h:column>
                                <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.impDestinataireCCI}"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid  width="100%" style="text-align:center;">
                                <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGroup>
                <h:panelGroup id="panExport" style="height:80px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.testafficheExport}">
                    <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="AperÃ§u avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.imprimerEXP}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                    <h:column id="idFichier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.afficheFichierExport}">
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.fichierUrl}" download="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.nomFichier}" title="Télécharger document"><img src="images/download.png" height="50px" width="50px" alt="télécharger"></a>
                        </h:column>
                    </h:panelGroup>
            </center>

        </h:panelGroup>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelListeTiers" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.showModalPanelSalaries}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.showModalPanelSalaries}" var="tie">
            <f:facet name="header"><h:outputText value="Sélection du tiers"/></f:facet>
            <a4j:form id="formModalListeTiers">
                <rich:extendedDataTable id="tableTiers" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="1" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.datamodelSalaries}" var="sal">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.selectionSalarie}"/>
                    <rich:column label="Matricule" sortable="true" sortBy="#{sal.salMatricule}" width="15%">
                        <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                        <h:outputText value="#{sal.salMatricule}"/>
                    </rich:column>
                    <rich:column label="Raison sociale ou Nom" sortable="true" sortBy="#{sal.salNom}" width="55%">
                        <f:facet name="header"><h:outputText  value="Raison sociale" /></f:facet>
                        <h:outputText value="#{sal.salNom}"/>
                    </rich:column>
                    <rich:column label="Prénom" sortable="true" sortBy="#{sal.salPrenom}" width="20%">
                        <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                        <h:outputText value="#{sal.salPrenom}"/>
                    </rich:column>
                    <rich:column label="Civilité" sortable="true" sortBy="#{sal.salCivilite}" width="10%">
                        <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                        <h:outputText value="#{sal.salCivilite}"/>
                    </rich:column>
                </rich:extendedDataTable>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanTiers" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.annuleSalarie}" reRender="idTiers,panelListeTiers"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.calculeSalarie}" reRender="idTiers,panelListeTiers"/>
                        <rich:hotKey key="esc" handler="#{rich:element('idCanTiers')}.click()" />
                        <rich:hotKey key="return" handler="#{rich:element('idValTiers')}.click()" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="modAttenteImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="350" height="80" resizeable="false">
        <f:facet name="header"><h:outputText value="Calcul de l'état en cours, veuillez patienter..."/></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <h:commandButton image="/images/close.gif" styleClass="hidelink" id="closeImp">
                    <rich:componentControl attachTo="closeImp" for="modAttenteImp" event="onclick" operation="hide" />
                </h:commandButton>
            </a4j:form>
        </f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel><h:graphicImage style="width:20px;height:20px;" value="/images/attente.gif"/></a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelBordereaux" width="700" height="550"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.showModalPanelBordereau}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.showModalPanelBordereau}" var="brd">
            <f:facet name="header"><h:outputText value="BORDEREAUX DE VERSEMENTS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.closeBordereaux}" image="/images/close.gif" styleClass="hidelink" reRender="panelBordereaux"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid width="100%" style="text-align:left;">
                    <h:panelGrid width="100%" columns="5" border="1">
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="NÂ° Bordereaux"/></h:column>
                        <h:column><h:outputText value="Date Versement (JJ/MM/AAAA)"/></h:column>
                        <h:column><h:outputText value="Montant"/></h:column>
                        <h:column><h:outputText value="Allocations fam."/></h:column>
                        <h:column><h:outputText value="Janvier"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd01}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd01}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd01}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll01}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Février"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd02}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd02}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd02}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll02}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Mars"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd03}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd03}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd03}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll03}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Avril"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd04}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd04}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd04}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll04}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Mai"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd05}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd05}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd05}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll05}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Juin"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd06}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd06}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd06}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll06}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Juillet"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd07}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd07}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd07}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll07}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Aout"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd08}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd08}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd08}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll08}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Septembre"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd09}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd09}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd09}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll09}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Octobre"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd10}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd10}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd10}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll10}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Novembre"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd11}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd11}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd11}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll11}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Décembre"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayNumBrd12}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayDteBrd12}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotBrd12}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayTotAll12}" style="text-align:right;" size="8">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid width="100%" columns="2">
                        <h:column><h:outputText value="Commissions honoraires Redevances versées"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.exoSelectionne.exepayRedevance}" size="7" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <br/>
                    <h:panelGroup>
                        <center>
                            <a4j:commandButton image="/images/valider_big.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formImpressionPaye.majBordereau}" reRender="panelBordereaux"/>
                        </center>
                    </h:panelGroup>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>