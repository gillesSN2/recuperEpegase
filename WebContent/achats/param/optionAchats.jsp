<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="configAchats">

    <a4j:form id="form1" >

        <center><h2><h:outputText value="OPTIONS DES ACHATS" style="color:green;"/></h2></center>

        <rich:panel id="rich2" style="border:0px solid green;width:100%;">
            <h:panelGrid  columns="1" id="pan1" style="border:0px solid green;width:100%;">

                <rich:tabPanel switchType="client" immediate="true"  style="border:0px;">

                    <rich:tab label="Analytiques" >
                        <h:panelGrid id="idAnal" columns="2" columnClasses="clos20,clos80" headerClass="headerTab" style="width:100%">
                            <f:facet name="header"><h:outputText value="Axes Analytiques"/></f:facet>
                            <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.moduleStructure}"><h:outputText value="Axe Structure:"/></h:column>
                            <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.moduleStructure}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.axeStructure}"/></h:column>
                            <h:column><h:outputText value="Axe Site/Département/Service:"/></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.axeSite}"/></h:column>
                            <h:column><h:outputText value="Axe Région/Secteur/Pdv:"/></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.axeRegion}"/></h:column>
                            <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.moduleUsine}"><h:outputText value="Axe Site/Atelier/Ligne:"/></h:column>
                            <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.moduleUsine}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.axeUsine}"/></h:column>
                            <h:column><h:outputText value="Axe Activité:"/></h:column>
                            <h:column>
                                <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.axeActivite}">
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="idAnal"/>
                                </h:selectBooleanCheckbox>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.axeActivite}"><h:outputText value="Gestion des activités:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.axeActivite}">
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.activiteEnteteLigne}">
                                    <f:selectItem itemLabel="Dans l'entête" itemValue="0"/>
                                    <f:selectItem itemLabel="Dans les produits" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.modulePaye}"><h:outputText value="Axe Agent:"/></h:column>
                            <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.modulePaye}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.axeAgent}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.structureLog.strChantier}"><h:outputText value="Axe Chantier:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.structureLog.strChantier}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.axeChantier}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.moduleParc}"><h:outputText value="Axe Parc:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.moduleParc}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.axeParc}"/></h:column>
                            <h:column rendered="false"><h:outputText value="Axe Mission:"/></h:column>
                            <h:column rendered="false"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.axeMission}"/></h:column>
                            <h:column rendered="false"><h:outputText value="Axe Clés répartition:"/></h:column>
                            <h:column rendered="false"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.axeCles}"/></h:column>
                            <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.moduleProjet}"><h:outputText value="Axe Projet:"/></h:column>
                            <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.moduleProjet}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.axeProjet}"/></h:column>
                            <h:column><h:outputText value="Axe Dossier/Affaire:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.axeDossier}" style="width:300px;">
                                    <f:selectItem itemLabel="Sans Dossier importation, Sans Affaire" itemValue="0"/>
                                    <f:selectItem itemLabel="Dossier importation" itemValue="1"/>
                                    <f:selectItem itemLabel="Porte feuille d`affaire" itemValue="2"/>
                                    <f:selectItem itemLabel="Dossier Transit" itemValue="3"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Portefeuille" id="idPortefeuille" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.axeDossier=='2'}">
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value ="Affichage dans la fiche tiers:" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.affichInTierAffaire}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.affichInGlobViewAffaire}" style="width:200px;" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Demandes Achats" >
                        <h:panelGrid  columns="4" columnClasses="clos25,clos25g,clos25,clos25g" width="100%">
                            <h:column><h:outputText value="Nombre jours de relance:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.nbrJrRelanceDA}" style="width:50px;"/></h:column>
                            <h:column><h:outputText value="Nombre jour de validité:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.nbrJrValidDA}" style="width:50px;"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value ="Affichage dans la fiche tiers:" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.affichInTierFilDA}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.affichInGlobViewDA}" style="width:200px;" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>                       
                    </rich:tab>

                    <rich:tab label="Cotations">
                        <h:panelGrid  columns="4" columnClasses="clos25,clos25g,clos25,clos25g" width="100%">
                            <h:column><h:outputText value="Nombre jours de relance:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.nbrJrRelanceCOT}" style="width:50px;"/></h:column>
                            <h:column><h:outputText value="Nombre jour de validité:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.nbrJrValidCOT}" style="width:50px;"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value ="Affichage dans la fiche tiers:" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.affichInTierFilCOT}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.affichInGlobViewCOT}" style="width:200px;" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Affichage Qte/poids:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.affichQtePoidsCOT}" style="width:200px;" >
                                    <f:selectItem itemLabel="Rien afficher" itemValue="0"/>
                                    <f:selectItem itemLabel="Affichage Qte" itemValue="1"/>
                                    <f:selectItem itemLabel="Affichage Poids" itemValue="2"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Libellé Frais 1 (PRP):"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.fraisPrp1}" style="width:100%;"/></h:column>
                            <h:column><h:outputText value="Libellé Frais 2 (PRP):"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.fraisPrp2}" style="width:100%;"/></h:column>
                            <h:column><h:outputText value="Libellé Frais 3 (PRP):"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.fraisPrp3}" style="width:100%;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:outputText value="Taux RUSID (%):"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.tauxRusid}" style="width:50px;"/></h:column>
                            <h:column><h:outputText value="Taux réduit (douane) (%):"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.tauxReduit}" style="width:50px;"/></h:column>
                        </h:panelGrid>                          
                    </rich:tab>

                    <rich:tab label="Commandes">
                        <h:panelGrid  columns="4" columnClasses="clos25,clos25g,clos25,clos25g" width="100%">
                            <h:column><h:outputText value="Nombre jours de relance:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.nbrJrRelanceCOM}" style="width:50px;"/></h:column>
                            <h:column><h:outputText value="Nombre jour de validité:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.nbrJrValidCOM}" style="width:50px;"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value ="Affichage dans la fiche tiers:" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.affichInTierFilCOM}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.affichInGlobViewCOM}" style="width:200px;" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Affichage Qte/poids:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.affichQtePoidsCOM}" style="width:200px;" >
                                    <f:selectItem itemLabel="Rien afficher" itemValue="0"/>
                                    <f:selectItem itemLabel="Affichage Qte" itemValue="1"/>
                                    <f:selectItem itemLabel="Affichage Poids" itemValue="2"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Gestion des budgets:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.budgetCOM}" style="width:200px;" >
                                    <f:selectItem itemLabel="Dans onglet imputation" itemValue="0"/>
                                    <f:selectItem itemLabel="Dans entete commande" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Quantité déjà commandée:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.qteDejaCOM}" style="width:200px;" >
                                    <f:selectItem itemLabel="Sans calcul" itemValue="0"/>
                                    <f:selectItem itemLabel="Avec les mvts de l`exercice en cours (cmd validées)" itemValue="1"/>
                                    <f:selectItem itemLabel="Avec tous les mvts (cmd validées)" itemValue="2"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Réceptions">
                        <h:panelGrid  columns="4" columnClasses="clos25,clos25g,clos25,clos25g" width="100%">
                            <h:column><h:outputText value="Nombre jours de relance:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.nbrJrRelanceREC}" style="width:50px;"/></h:column>
                            <h:column><h:outputText value="Nombre jour de validité:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.nbrJrValidREC}" style="width:50px;"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value ="Affichage dans la fiche tiers:" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.affichInTierFilREC}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.affichInGlobViewREC}" style="width:200px;" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Affichage Qte/poids:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.affichQtePoidsREC}" style="width:200px;" >
                                    <f:selectItem itemLabel="Rien afficher" itemValue="0"/>
                                    <f:selectItem itemLabel="Affichage Qte" itemValue="1"/>
                                    <f:selectItem itemLabel="Affichage Poids" itemValue="2"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Gestion du réacheminement:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.reacheminementREC}" style="width:200px;" >
                                    <f:selectItem itemLabel="Désactivée" itemValue="0"/>
                                    <f:selectItem itemLabel="Activée" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value ="Mode Fret/Assurance (CIF, CFR ou CPT):" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.modeCifCfrREC}" style="width:200px;">
                                    <f:selectItem itemLabel="Le Fret/Assurance est en sus sur la facture" itemValue="0"/>
                                    <f:selectItem itemLabel="Le Fret/Assurance est inclus dans le total de la facture" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value ="Numéro de réception:" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.numeroReception}" style="width:200px;">
                                    <f:selectItem itemLabel="A son propre chrono autonome" itemValue="0"/>
                                    <f:selectItem itemLabel="A le même numéro que la commande" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>                        
                    </rich:tab>

                    <rich:tab label="Factures">
                        <h:panelGrid  columns="4" columnClasses="clos25,clos25g,clos25,clos25g" width="100%">
                            <h:column><h:outputText value="Nombre jours de relance:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.nbrJrRelanceFAC}" style="width:50px;"/></h:column>
                            <h:column><h:outputText value="Nombre jour de validité:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.nbrJrValidFAC}" style="width:50px;"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value ="Affichage dans la fiche tiers:" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.affichInTierFilFAC}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.affichInGlobViewFAC}" style="width:200px;" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid id="idFret" columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value ="Montant Fret/Assurance (CIF, CFR ou CPT):" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.modeCifCfrFAC}" style="width:200px;">
                                    <f:selectItem itemLabel="Ventilé sur les produits" itemValue="0"/>
                                    <f:selectItem itemLabel="Transféré dans comptes spécifiques" itemValue="1"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="idFret"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.modeCifCfrFAC=='1'}"><h:outputText value="Compte Fret:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.modeCifCfrFAC=='1'}">
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.compteFretFAC}" style="width:150px;" maxlength="20"/></h:column>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.modeCifCfrFAC=='1'}"><h:outputText value="Compte Assurance:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.modeCifCfrFAC=='1'}">
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.compteAssuranceFAC}" style="width:150px;" maxlength="20"/></h:column>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Notes.débit">
                        <h:panelGrid  columns="4" columnClasses="clos25,clos25g,clos25,clos25g" width="100%">
                            <h:column><h:outputText value="Nombre jours de relance:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.nbrJrRelanceNOTDEB}" style="width:50px;"/></h:column>
                            <h:column><h:outputText value="Nombre jour de validité:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.nbrJrValidNOTDEB}" style="width:50px;"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value ="Affichage dans la fiche tiers:" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.affichInTierFilNOTDEB}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.affichInGlobViewNOTDEB}" style="width:200px;" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>                         
                    </rich:tab>

                    <rich:tab label="Retours">
                        <h:panelGrid  columns="4" columnClasses="clos25,clos25g,clos25,clos25g" width="100%">
                            <h:column><h:outputText value="Nombre jours de relance:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.nbrJrRelanceRETOUR}" style="width:50px;"/></h:column>
                            <h:column><h:outputText value="Nombre jour de validité:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.nbrJrValidRETOUR}" style="width:50px;"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value ="Affichage dans la fiche tiers:" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.affichInTierFilRETOUR}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.affichInGlobViewRETOUR}" style="width:200px;" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>                        
                    </rich:tab>

                    <rich:tab label="Avoirs">
                        <h:panelGrid  columns="4" columnClasses="clos25,clos25g,clos25,clos25g" width="100%">
                            <h:column><h:outputText value="Nombre jours de relance:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.nbrJrRelanceAVOIR}" style="width:50px;"/></h:column>
                            <h:column><h:outputText value="Nombre jour de validité:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.nbrJrValidAVOIR}" style="width:50px;"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value ="Affichage dans la fiche tiers:" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.affichInTierFilAVOIR}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.affichInGlobViewAVOIR}" style="width:200px;" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>                        
                    </rich:tab>

                    <rich:tab label="Frais">
                        <h:panelGrid  columns="4" columnClasses="clos25,clos25g,clos25,clos25g" width="100%">
                            <h:column><h:outputText value="Nombre jours de relance:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.nbrJrRelanceFRA}" style="width:50px;"/></h:column>
                            <h:column><h:outputText value="Nombre jour de validité:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.nbrJrValidFRA}" style="width:50px;"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value ="Affichage dans la fiche tiers:" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.affichInTierFilFRA}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.affichInGlobViewFRA}" style="width:200px;" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                             <h:column><h:outputText value="Chargement de tous les frais:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.chargerFRA}" style="width:200px;" >
                                    <f:selectItem itemLabel="Gestion des factures de frais" itemValue="0"/>
                                    <f:selectItem itemLabel="Gestion des frais dans réception" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Valorisation" >
                        <h:panelGrid columns="2"  columnClasses="clos20,clos60g" width="100%" style="background-color:#DAEECB;">
                            <h:outputText value = "Mode de calcul coefficient PR:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.modCoefPr}" style="width:300px;">
                                <f:selectItem itemLabel="total des frais / prix de revient" itemValue="0"/>
                                <f:selectItem itemLabel="prix de revient / facture achat" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Mode de calcul PR:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.modCalcPr}" style="width:300px;">
                                <f:selectItem itemLabel="Calculé sur le H.T." itemValue="0"/>
                                <f:selectItem itemLabel="Calculé sur le T.T.C." itemValue="1"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Mode de calcul du PUMP1:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.modCalcPump}" style="width:300px;">
                                <f:selectItem itemLabel="((ancien PR * qte stock avant réception) + (nouveau PR * qte reçue)) / qte totale" itemValue="0"/>
                                <f:selectItem itemLabel="((ancien PR * ancienne qte reçue) + (nouveau PR * qte reçue)) / qte totale" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Mode de calcul du PUMP2:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.modDepPump}" style="width:300px;">
                                <f:selectItem itemLabel="Prendre en compte le dépôt en cours" itemValue="0"/>
                                <f:selectItem itemLabel="Prendre en compte tous les dépôts" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Mode de calcul du Prix de vente:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.modValoPvProd}" style="width:300px;">
                                <f:selectItem itemLabel="Le prix de vente ne change pas sur valorisation" itemValue="0"/>
                                <f:selectItem itemLabel="Le prix de vente est recalcué sur le PUMP à chaque valorisation" itemValue="1"/>
                                <f:selectItem itemLabel="Le prix de vente est recalcué sur le PR à chaque valorisation" itemValue="2"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Fret sur Aérien ou express:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.modValoFret}" style="width:300px;">
                                <f:selectItem itemLabel="50% du fret" itemValue="0"/>
                                <f:selectItem itemLabel="100% du fret" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Divers" >
                        <h:panelGrid columns="2"  columnClasses="clos20,clos60g" width="100%" style="background-color:#DAEECB;">
                            <h:outputText value="Nombre caractères des familles:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.nbrCtrsFamProd}" style="width:300px;">
                                <f:selectItem itemLabel="2c" itemValue="2"/>
                                <f:selectItem itemLabel="3c" itemValue="3"/>
                                <f:selectItem itemLabel="4c" itemValue="4"/>
                                <f:selectItem itemLabel="5c" itemValue="5"/>
                                <f:selectItem itemLabel="6c" itemValue="6"/>
                                <f:selectItem itemLabel="7c" itemValue="7"/>
                                <f:selectItem itemLabel="8c" itemValue="8"/>
                                <f:selectItem itemLabel="9c" itemValue="9"/>
                                <f:selectItem itemLabel="10c" itemValue="10"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Mode de calcul produits:" />
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.modCalcProd}" style="width:300px;">
                                <f:selectItem itemLabel="Code libre " itemValue="0"/>
                                <f:selectItem itemLabel="Libre avec nb caractères fixe " itemValue="1"/>
                                <f:selectItem itemLabel="Chrono simple sur ID + 1" itemValue="2"/>
                                <f:selectItem itemLabel="Chrono simple sur nombre produit + 1" itemValue="3"/>
                                <f:selectItem itemLabel="Chrono simple sur dernier code + 1" itemValue="4"/>
                                <f:selectItem itemLabel="Chrono sur famille sur ID produit + 1" itemValue="5"/>
                                <f:selectItem itemLabel="Chrono sur famille sur nombre produit + 1" itemValue="6"/>
                                <f:selectItem itemLabel="Chrono sur famille sur dernier produit + 1" itemValue="7"/>
                            </h:selectOneMenu>
                            <h:outputText value="Nombre caractère produits:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.nbrCtrsProProd}" style="width:300px;">
                                <f:selectItem itemLabel="2 c" itemValue="2"/>
                                <f:selectItem itemLabel="3 c" itemValue="3"/>
                                <f:selectItem itemLabel="4 c" itemValue="4"/>
                                <f:selectItem itemLabel="5 c" itemValue="5"/>
                                <f:selectItem itemLabel="6 c" itemValue="6"/>
                                <f:selectItem itemLabel="7 c" itemValue="7"/>
                                <f:selectItem itemLabel="8 c" itemValue="8"/>
                                <f:selectItem itemLabel="9 c" itemValue="9"/>
                                <f:selectItem itemLabel="10 c" itemValue="10"/>
                                <f:selectItem itemLabel="11 c" itemValue="11"/>
                                <f:selectItem itemLabel="12 c" itemValue="12"/>
                                <f:selectItem itemLabel="13 c" itemValue="13"/>
                                <f:selectItem itemLabel="14 c" itemValue="14"/>
                                <f:selectItem itemLabel="15 c" itemValue="15"/>
                                <f:selectItem itemLabel="16 c" itemValue="16"/>
                                <f:selectItem itemLabel="17 c" itemValue="17"/>
                                <f:selectItem itemLabel="18 c" itemValue="18"/>
                                <f:selectItem itemLabel="19 c" itemValue="19"/>
                                <f:selectItem itemLabel="20 c" itemValue="20"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Photos Produits:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.photosProduit}" style="width:300px;">
                                <f:selectItem itemLabel="Sans photos dans les listes" itemValue="0" />
                                <f:selectItem itemLabel="Avec photos dans les listes" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Affichage stock:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.choixStock}" style="width:300px;">
                                <f:selectItem itemLabel="Stock réel" itemValue="0" />
                                <f:selectItem itemLabel="Stock estimé" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                        <br>
                        <h:panelGrid  width="100%" style="background-color:white;" columns="2"  columnClasses="clos20,clos60g">
                            <h:outputText value = "Affectation des dépôts sur:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.depotStock}" style="width:300px;">
                                <f:selectItem itemLabel="les services" itemValue="0"/>
                                <f:selectItem itemLabel="les départements" itemValue="1"/>
                                <f:selectItem itemLabel="les sites" itemValue="2"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Libellé produit:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.modLibelleProd}" style="width:300px;">
                                <f:selectItem itemLabel="Utiliser libelle commercial" itemValue="0"/>
                                <f:selectItem itemLabel="Utiliser libellé technique" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Rabais:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.decrmtRabais}" style="width:300px;">
                                <f:selectItem itemLabel="Gestion des rabais en global" itemValue="1" />
                                <f:selectItem itemLabel="Gestion des rabais par quantité" itemValue="2"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Nb Décimales Quantités:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.nbDecQte}" style="width:300px;">
                                <f:selectItem itemLabel="0" itemValue="0" />
                                <f:selectItem itemLabel="1" itemValue="1"/>
                                <f:selectItem itemLabel="2" itemValue="2"/>
                                <f:selectItem itemLabel="3" itemValue="3"/>
                                <f:selectItem itemLabel="4" itemValue="4"/>
                                <f:selectItem itemLabel="5" itemValue="5"/>
                                <f:selectItem itemLabel="6" itemValue="6"/>
                                <f:selectItem itemLabel="7" itemValue="7"/>
                                <f:selectItem itemLabel="8" itemValue="8"/>
                                <f:selectItem itemLabel="9" itemValue="9"/>
                                <f:selectItem itemLabel="10" itemValue="10"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Nb Décimales P.U.:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.nbDecPu}" style="width:300px;">
                                <f:selectItem itemLabel="0" itemValue="0" />
                                <f:selectItem itemLabel="1" itemValue="1"/>
                                <f:selectItem itemLabel="2" itemValue="2"/>
                                <f:selectItem itemLabel="3" itemValue="3"/>
                                <f:selectItem itemLabel="4" itemValue="4"/>
                                <f:selectItem itemLabel="5" itemValue="5"/>
                                <f:selectItem itemLabel="6" itemValue="6"/>
                                <f:selectItem itemLabel="7" itemValue="7"/>
                                <f:selectItem itemLabel="8" itemValue="8"/>
                                <f:selectItem itemLabel="9" itemValue="9"/>
                                <f:selectItem itemLabel="10" itemValue="10"/>
                            </h:selectOneMenu>
                            <h:outputText rendered="false" value = "Saisie zones Analytiques:"/>
                            <h:selectOneMenu rendered="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.analAuto}" style="width:300px;">
                                <f:selectItem itemLabel="Saisie sur liste (chargement automatique)" itemValue="0" />
                                <f:selectItem itemLabel="Saisie sur zone de saisie" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:outputText value="Descriptif complémentaire:" />
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.descriptifComplementaire}" style="width:300px;" >
                                <f:selectItem itemLabel="Sans" itemValue="0"/>
                                <f:selectItem itemLabel="Avec" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Nombre ligne maximum des documents:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.nbLigneMax}" style="width:300px;">
                                <jsp:include flush="true" page="/commun/decoupageNbLigne.jsp"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Chargement des listes:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.chargementListe}" style="width:300px;">
                                <f:selectItem itemLabel="Manuel" itemValue="0" />
                                <f:selectItem itemLabel="Automatique" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Date sur transformation:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.dateTransformation}" style="width:300px;">
                                <f:selectItem itemLabel="Date d'origine" itemValue="0" />
                                <f:selectItem itemLabel="Date du jour" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Code TVA sur produits libres:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.tvaDefaut}" style="width:300px;">
                                <f:selectItem itemLabel="Sans code" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.mesTvaItem}"/>
                            </h:selectOneMenu>
                            <h:column><h:outputText value="Gestion des réglements:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.paiementAVOIR}" style="width:300px;" >
                                    <f:selectItem itemLabel="Factures" itemValue="0"/>
                                    <f:selectItem itemLabel="Bons de commande" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Gestion de la transformation:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.transformation}" style="width:300px;" >
                                    <f:selectItem itemLabel="Sans information sur l'origine" itemValue="0"/>
                                    <f:selectItem itemLabel="Avec l'information sur l'origine (---> Suivant...)" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:outputText value = "Afficher longueur:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.modeCalculDevis}" style="width:300px;">
                                <f:selectItem itemLabel="NON" itemValue="0" />
                                <f:selectItem itemLabel="OUI" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Entete">
                        <center>
                            <h:panelGrid columns="2">
                                <h:outputText value="Libellé 1:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib1}"/>
                                <h:outputText value="Libellé 2:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib2}"/>
                                <h:outputText value="Libellé 3:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib3}"/>
                                <h:outputText value="Libellé 4:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib4}"/>
                                <h:outputText value="Libellé 5:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib5}"/>
                                <h:outputText value="Libellé 6:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib6}"/>
                                <h:outputText value="Libellé 7:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib7}"/>
                                <h:outputText value="Libellé 8:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib8}"/>
                                <h:outputText value="Libellé 9:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib9}"/>
                                <h:outputText value="Libellé 10:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib10}"/>
                            </h:panelGrid>
                        </center>
                    </rich:tab>

                    <rich:tab label="N° Série">
                        <center>
                            <h:panelGrid columns="2">
                                <h:outputText value="Champ 1:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.serie1}"/>
                                <h:outputText value="Champ 2:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.serie2}"/>
                                <h:outputText value="Champ 3:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.serie3}"/>
                                <h:outputText value="Champ 4:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.serie4}"/>
                                <h:outputText value="Champ 5:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.serie5}"/>
                                <h:outputText value="Champ 6:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.serie6}"/>
                                <h:outputText value="Champ 7:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.serie7}"/>
                                <h:outputText value="Champ 8:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.serie8}"/>
                                <h:outputText value="Champ 9:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.serie9}"/>
                                <h:outputText value="Champ 10:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.serie10}"/>
                                <h:outputText value="Champ 11:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.serie11}"/>
                                <h:outputText value="Champ 12:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.serie12}"/>
                                <h:outputText value="Champ 13:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.serie13}"/>
                                <h:outputText value="Champ 14:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.serie14}"/>
                                <h:outputText value="Champ 15:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.serie15}"/>
                                <h:outputText value="Champ 16:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.serie16}"/>
                                <h:outputText value="Champ 17:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.serie17}"/>
                                <h:outputText value="Champ 18:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.serie18}"/>
                                <h:outputText value="Champ 19:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.serie19}"/>
                                <h:outputText value="Champ 20:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.serie20}"/>
                            </h:panelGrid>
                        </center>
                    </rich:tab>

                    <rich:tab label="Compta.">
                        <center>
                            <h:panelGrid columns="2">
                                <h:outputText value = "Transfert documents:"/>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.transfertDocument}" style="width:300px;">
                                    <f:selectItem itemLabel="Uniquement les documents validés" itemValue="0" />
                                    <f:selectItem itemLabel="Les documents en Cours et les validés" itemValue="1"/>
                                </h:selectOneMenu>
                                <h:outputText value = "Méthode de transfert en compta:"/>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.trfCompta}" style="width:300px;">
                                    <f:selectItem itemLabel="Méthode standard" itemValue="0" />
                                    <f:selectItem itemLabel="Méthode de gestion des comptes 38" itemValue="1"/>
                                </h:selectOneMenu>
                                <h:outputText value="Zone Référence 1:"/>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.zoneRef1}" style="width:300px;">
                                    <f:selectItem itemLabel="N° document en cours" itemValue="0" />
                                    <f:selectItem itemLabel="N° document d'origine" itemValue="1"/>
                                    <f:selectItem itemLabel="N° ref. fournisseur" itemValue="2"/>
                                    <f:selectItem itemLabel="N° dossier" itemValue="3"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib1}" itemValue="11" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib1}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib2}" itemValue="12" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib2}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib3}" itemValue="13" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib3}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib4}" itemValue="14" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib4}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib5}" itemValue="15" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib5}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib6}" itemValue="16" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib6}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib7}" itemValue="17" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib7}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib8}" itemValue="18" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib8}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib9}" itemValue="19" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib9}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib10}" itemValue="20" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib10}"/>
                                </h:selectOneMenu>
                                <h:outputText value="Serie Référence 1:"/>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.zoneRef1Serie}" style="width:300px;">
                                    <f:selectItem itemLabel="Avec Série" itemValue="0" />
                                    <f:selectItem itemLabel="Sans Série" itemValue="1"/>
                                </h:selectOneMenu>
                                <h:outputText value="Zone Référence 2:"/>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.zoneRef2}" style="width:300px;">
                                    <f:selectItem itemLabel="N° document en cours" itemValue="0" />
                                    <f:selectItem itemLabel="N° document d'origine" itemValue="1"/>
                                    <f:selectItem itemLabel="N° ref. fournisseur" itemValue="2"/>
                                    <f:selectItem itemLabel="N° dossier" itemValue="3"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib1}" itemValue="11" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib1}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib2}" itemValue="12" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib2}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib3}" itemValue="13" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib3}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib4}" itemValue="14" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib4}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib5}" itemValue="15" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib5}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib6}" itemValue="16" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib6}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib7}" itemValue="17" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib7}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib8}" itemValue="18" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib8}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib9}" itemValue="19" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib9}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib10}" itemValue="20" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib10}"/>
                                </h:selectOneMenu>
                                <h:outputText value="Serie Référence 2:"/>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.zoneRef2Serie}" style="width:300px;">
                                    <f:selectItem itemLabel="Avec Série" itemValue="0" />
                                    <f:selectItem itemLabel="Sans Série" itemValue="1"/>
                                </h:selectOneMenu>
                                <h:outputText value="Zone Libellé:"/>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.zoneLibelle}" style="width:300px;">
                                    <f:selectItem itemLabel="Nom tiers" itemValue="0" />
                                    <f:selectItem itemLabel="Objet" itemValue="1"/>
                                    <f:selectItem itemLabel="Objet + date document en cours" itemValue="2"/>
                                    <f:selectItem itemLabel="Nom tiers + N° Dossier" itemValue="3" />
                                </h:selectOneMenu>
                                <h:outputText value="Zone Libellé suite:"/>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.zoneLibelleSuite}" style="width:300px;">
                                    <f:selectItem itemLabel="" itemValue="0" />
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib1}" itemValue="11" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib1}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib2}" itemValue="12" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib2}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib3}" itemValue="13" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib3}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib4}" itemValue="14" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib4}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib5}" itemValue="15" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib5}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib6}" itemValue="16" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib6}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib7}" itemValue="17" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib7}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib8}" itemValue="18" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib8}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib9}" itemValue="19" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib9}"/>
                                    <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.optionAchats.lib10}" itemValue="20" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.lib10}"/>
                                </h:selectOneMenu>
                            </h:panelGrid>
                        </center>
                    </rich:tab>

                </rich:tabPanel>

            </h:panelGrid>
            <br>
            <center>
                <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />&nbsp;&nbsp;&nbsp;&nbsp;
                <h:commandButton styleClass="exp_lienmenu"  value="VALIDER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsAchats.creerOptionAchats}" onclick="if (!confirm('Voulez-vous enregistrer les modifications ?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
                <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
            </center>
        </rich:panel>

    </a4j:form>

</f:subview>