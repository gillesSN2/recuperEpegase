<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="configVentes">
    <a4j:form id="form1" >

        <center> <h2><h:outputText value="OPTIONS DES CAISSES" style="color:green;"/></h2></center>

        <center>
            <rich:tabPanel switchType="client" immediate="true"  style="border:0px;" id="idPanelOption">

                <rich:tab label="Analytiques" >
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" headerClass="headerTab" style="width:100%">
                        <f:facet name="header"><h:outputText value="Axes Analytiques"/></f:facet>
                        <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.moduleStructure}"><h:outputText value="Axe Structure:"/></h:column>
                        <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.moduleStructure}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.axeStructure}"/></h:column>
                        <h:column><h:outputText value="Axe Site/Département/Service:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.axeSite}"/></h:column>
                        <h:column><h:outputText value="Axe Région/Secteur/Pdv:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.axeRegion}"/></h:column>
                        <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.moduleUsine}"><h:outputText value="Axe Site/Atelier/Ligne:"/></h:column>
                        <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.moduleUsine}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.axeUsine}"/></h:column>
                        <h:column><h:outputText value="Axe Activité:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.axeActivite}"/></h:column>
                        <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.modulePaye}"><h:outputText value="Axe Agent:"/></h:column>
                        <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.modulePaye}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.axeAgent}"/></h:column>
                        <h:column rendered="false"><h:outputText value="Axe Chantier:"/></h:column>
                        <h:column rendered="false"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.axeChantier}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.moduleParc}"><h:outputText value="Axe Parc:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.moduleParc}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.axeParc}"/></h:column>
                        <h:column rendered="false"><h:outputText value="Axe Mission:"/></h:column>
                        <h:column rendered="false"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.axeMission}"/></h:column>
                        <h:column><h:outputText value="Axe Clés répartition:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.axeCles}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.moduleProjet}"><h:outputText value="Axe Projet:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.moduleProjet}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.axeProjet}"/></h:column>
                        <h:column><h:outputText value="Axe Dossier:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.axeDossier}" style="width:300px;" >
                                <f:selectItem itemLabel="Sans Dossier, Sans Affaire" itemValue="0"/>
                                <f:selectItem itemLabel="Dossier" itemValue="1"/>
                                <f:selectItem itemLabel="Portefeuille affaires" itemValue="2"/>
                                <f:selectItem itemLabel="Dossier Transit" itemValue="3"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Caisses">
                    <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                        <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.affichInGlobViewCAISSE}" style="width:300px;" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Saisie Recette directe:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.saisieRecette}"/></h:column>
                        <h:column><h:outputText value="Saisie Dépense directe:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.saisieDepense}"/></h:column>
                        <h:column><h:outputText value="Saisie Transfert directe:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.saisieTransfert}"/></h:column>
                        <h:column rendered="false"><h:outputText value="Saisie Modification:"/></h:column>
                        <h:column rendered="false"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.saisieRegularisation}"/></h:column>
                        <h:column><h:outputText value="Annulation reçu:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.saisieAnnulation}"/></h:column>
                        <h:column><h:outputText value="Suppression reçu:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.saisieSuppression}"/></h:column>
                        <h:column><h:outputText value="Modèle cloture journalière:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.modeleClotJour}" style="width:300px;">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.mesModelesRapport}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Mails pour cloture journalière:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.mailClotJour}"/></h:column>
                        <h:column><h:outputText value="Modèle cloture mensuelle:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.modeleClotMois}" style="width:300px;">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.mesModelesRapport}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Mails pour cloture mensuelle:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.mailClotMois}"/></h:column>
                        <h:column><h:outputText value="Date des exécutions des opérations:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.execution}" style="width:300px;">
                                <f:selectItem itemLabel="Date du jour" itemValue="0"/>
                                <f:selectItem itemLabel="Date de la pièce d'origine" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:outputText value = "Date sur suppression ou annumation reçus"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.dateSuppression}" style="width:300px;">
                            <f:selectItem itemLabel="Date d'origine" itemValue="0" />
                            <f:selectItem itemLabel="Date du jour" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Reçus (Règlements)">
                    <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                        <h:column><h:outputText value="Affichage dans la vue globale:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.affichInGlobViewRECU}" style="width:300px;" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Mode des chronos:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.chronoReglement}" style="width:300px;">
                                <f:selectItem itemLabel="Chrono unique pour tous les modes de règlements" itemValue="0"/>
                                <f:selectItem itemLabel="Chrono unique par mode de règlement" itemValue="1"/>
                                <f:selectItem itemLabel="Chrono unique par série (caisse)" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Bons de sortie">
                    <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                        <h:column><h:outputText value="Affichage dans la vue globale: "   /></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.affichInGlobViewSorti}" style="width:300px;" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Bons d'entrée">
                    <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                        <h:column><h:outputText value="Affichage dans la vue globale: "   /></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.affichInGlobViewEntre}" style="width:300px;" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Virements internes">
                    <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                        <h:column><h:outputText value="Affichage dans la vue globale: "   /></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.affichInGlobViewVirment}" style="width:300px;" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Divers">
                    <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                        <h:outputText value = "Nombre ligne maximum des documents:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.nbLigneMax}" style="width:300px;">
                            <jsp:include flush="true" page="/commun/decoupageNbLigne.jsp"/>
                        </h:selectOneMenu>
                        <h:outputText value = "Nb chèques impayés avent blocage du compte:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.blocageCompte}" style="width:300px;">
                            <f:selectItem itemLabel="Jamais bloqué" itemValue="0"/>
                            <f:selectItem itemLabel="1 incident" itemValue="1"/>
                            <f:selectItem itemLabel="2 incidents" itemValue="2"/>
                            <f:selectItem itemLabel="3 incidents" itemValue="3"/>
                            <f:selectItem itemLabel="4 incidents" itemValue="4"/>
                            <f:selectItem itemLabel="5 incidents" itemValue="5"/>
                            <f:selectItem itemLabel="6 incidents" itemValue="6"/>
                            <f:selectItem itemLabel="7 incidents" itemValue="7"/>
                            <f:selectItem itemLabel="8 incidents" itemValue="8"/>
                            <f:selectItem itemLabel="9 incidents" itemValue="9"/>
                            <f:selectItem itemLabel="10 incidents" itemValue="10"/>
                        </h:selectOneMenu>
                        <h:column><h:outputText value="Accés aux journaux:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.accesJournaux}" style="width:300px;">
                                <f:selectItem itemLabel="Uniquement aux chronox/caisses autorisées (nature 60)" itemValue="0"/>
                                <f:selectItem itemLabel="Uniquement aux chronox/reçus autorisées (nature 61)" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Bons de déaissements:"   /></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.bonDecaissement}" style="width:300px;" >
                                <f:selectItem itemLabel="Garder le bon après exécution" itemValue="0"/>
                                <f:selectItem itemLabel="Supprimer le bon après exécution" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Bons d'encaissements:"   /></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.bonEncaissement}" style="width:300px;" >
                                <f:selectItem itemLabel="Garder le bon après exécution" itemValue="0"/>
                                <f:selectItem itemLabel="Supprimer le bon après exécution" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Billetage">
                    <h:panelGrid  width="100%" columns="2">
                        <h:panelGrid  width="100%" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Valeur des Billets (du plus gros au plus petit)"/></f:facet>
                            <h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.b1}"/>
                            <h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.b2}"/>
                            <h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.b3}"/>
                            <h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.b4}"/>
                            <h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.b5}"/>
                            <h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.b6}"/>
                            <h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.b7}"/>
                            <h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.b8}"/>
                            <h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.b9}"/>
                            <h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.b10}"/>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Valeur des Pièces (du la plus grosse à la plus petite)"/></f:facet>
                            <h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.p1}"/>
                            <h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.p2}"/>
                            <h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.p3}"/>
                            <h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.p4}"/>
                            <h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.p5}"/>
                            <h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.p6}"/>
                            <h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.p7}"/>
                            <h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.p8}"/>
                            <h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.p9}"/>
                            <h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.p10}"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Entete">
                    <center>
                        <h:panelGrid columns="2">
                            <h:outputText value="Libellé 1:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.lib1ENTETE}">
                                <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.calculeLibEntete}" reRender="idPanelOption"/>
                            </h:inputText>
                            <h:outputText value="Libellé 2:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.lib2ENTETE}">
                                <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.calculeLibEntete}" reRender="idPanelOption"/>
                            </h:inputText>
                            <h:outputText value="Libellé 3:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.lib3ENTETE}">
                                <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.calculeLibEntete}" reRender="idPanelOption"/>
                            </h:inputText>
                            <h:outputText value="Libellé 4:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.lib4ENTETE}">
                                <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.calculeLibEntete}" reRender="idPanelOption"/>
                            </h:inputText>
                            <h:outputText value="Libellé 5:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.lib5ENTETE}">
                                <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.calculeLibEntete}" reRender="idPanelOption"/>
                            </h:inputText>
                            <h:outputText value="Libellé 6:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.lib6ENTETE}">
                                <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.calculeLibEntete}" reRender="idPanelOption"/>
                            </h:inputText>
                            <h:outputText value="Libellé 7:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.lib7ENTETE}">
                                <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.calculeLibEntete}" reRender="idPanelOption"/>
                            </h:inputText>
                            <h:outputText value="Libellé 8:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.lib8ENTETE}">
                                <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.calculeLibEntete}" reRender="idPanelOption"/>
                            </h:inputText>
                            <h:outputText value="Libellé 9:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.lib9ENTETE}">
                                <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.calculeLibEntete}" reRender="idPanelOption"/>
                            </h:inputText>
                            <h:outputText value="Libellé 10:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.lib10ENTETE}">
                                <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.calculeLibEntete}" reRender="idPanelOption"/>
                            </h:inputText>
                        </h:panelGrid>
                    </center>
                </rich:tab>

                <rich:tab label="Compta.">
                    <center>
                        <h:panelGrid columns="2">
                            <h:outputText value="Zone Référence 1:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.zoneRef1}" style="width:300px;">
                                <f:selectItem itemLabel="N° document en cours" itemValue="0" />
                                <f:selectItem itemLabel="N° document d'origine" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:outputText value="Serie Référence 1:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.zoneRef1Serie}" style="width:300px;">
                                <f:selectItem itemLabel="Avec Série" itemValue="0" />
                                <f:selectItem itemLabel="Sans Série" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:outputText value="Zone Référence 2:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.zoneRef2}" style="width:300px;">
                                <f:selectItem itemLabel="N° document en cours" itemValue="0" />
                                <f:selectItem itemLabel="N° document d'origine direct" itemValue="1"/>
                                <f:selectItem itemLabel="N° document d'origine calculé" itemValue="2"/>
                            </h:selectOneMenu>
                            <h:outputText value="Serie Référence 2:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.zoneRef2Serie}" style="width:300px;">
                                <f:selectItem itemLabel="Avec Série" itemValue="0" />
                                <f:selectItem itemLabel="Sans Série" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:outputText value="Libellé:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.optionCaisses.zoneLibelle}" style="width:300px;">
                                <f:selectItem itemLabel="Objet + Libellé + nom Tiers" itemValue="0" />
                                <f:selectItem itemLabel="Objet + Libellé + N° chèque + nom Tiers" itemValue="4" />
                                <f:selectItem itemLabel="Réglement XXX + nom Tiers" itemValue="1"/>
                                <f:selectItem itemLabel="Nom Tiers" itemValue="2"/>
                                <f:selectItem itemLabel="Réglement XXX" itemValue="3"/>
                                <f:selectItem itemLabel="Libellé en fonction de l'origine" itemValue="5"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                    </center>
                </rich:tab>

            </rich:tabPanel>
        </center>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />&nbsp;&nbsp;&nbsp;&nbsp;
            <h:commandButton styleClass="exp_lienmenu" value="VALIDER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsCaisse.creerOptionsCaisses}" onclick="if (!confirm('Voulez-vous enregistrer les modifications ?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
        <center>
            <h:panelGroup id="prgoutpmessage">
                <h:messages infoStyle="color: red;" errorStyle="color: red;" />
            </h:panelGroup>
        </center>

    </a4j:form>

</f:subview>