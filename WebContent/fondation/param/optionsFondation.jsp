<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="configFondation">

    <a4j:form id="form1" >

        <center> <h2><h:outputText value="OPTIONS DE LA FONDATION" style="color:green;"/></h2></center>

        <center>
            <rich:tabPanel switchType="client" immediate="true"  style="border:0px;" id="idPanelOption">

                <rich:tab label="Analytiques" >
                    <h:panelGrid id="idAnal" columns="2" columnClasses="clos20,clos80" headerClass="headerTab" style="width:100%">
                        <f:facet name="header"><h:outputText value="Axes Analytiques"/></f:facet>
                        <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.moduleStructure}"><h:outputText value="Axe Structure:"/></h:column>
                        <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.moduleStructure}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.axeStructure}"/></h:column>
                        <h:column><h:outputText value="Axe Site/Département/Service:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.axeSite}"/></h:column>
                        <h:column><h:outputText value="Axe Région/Secteur/Pdv:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.axeRegion}"/></h:column>
                        <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.moduleUsine}"><h:outputText value="Axe Site/Atelier/Ligne:"/></h:column>
                        <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.moduleUsine}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.axeUsine}"/></h:column>
                        <h:column><h:outputText value="Axe Activité:"/></h:column>
                        <h:column>
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.axeActivite}">
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idAnal"/>
                            </h:selectBooleanCheckbox>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.axeActivite}"><h:outputText value="Gestion des activités:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.axeActivite}">
                            <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.activiteEnteteLigne}">
                                <f:selectItem itemLabel="Dans l'entête" itemValue="0"/>
                                <f:selectItem itemLabel="Dans les produits" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.modulePaye}"><h:outputText value="Axe Agent:"/></h:column>
                        <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.modulePaye}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.axeAgent}"/></h:column>
                        <h:column rendered="false"><h:outputText value="Axe Chantier:"/></h:column>
                        <h:column rendered="fasle"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.axeChantier}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.moduleParc}"><h:outputText value="Axe Parc:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.moduleParc}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.axeParc}"/></h:column>
                        <h:column rendered="false"><h:outputText value="Axe Mission:"/></h:column>
                        <h:column rendered="false"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.axeMission}"/></h:column>
                        <h:column rendered="false"><h:outputText value="Axe Clés répartition:"/></h:column>
                        <h:column rendered="false"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.axeCles}"/></h:column>
                        <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.moduleProjet}"><h:outputText value="Axe Projet:"/></h:column>
                        <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.moduleProjet}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.axeProjet}"/></h:column>
                        <h:column><h:outputText value="Axe Dossier/Affaire:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.axeDossier}" style="width:300px;" >
                                <f:selectItem itemLabel="Sans Dossier, Sans Affaire" itemValue="0"/>
                                <f:selectItem itemLabel="Dossier" itemValue="1"/>
                                <f:selectItem itemLabel="Porte feuille d`affaire" itemValue="2"/>
                                <f:selectItem itemLabel="Dossier Transit" itemValue="3"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Demande">
                    <h:panelGrid  columns="4" columnClasses="clos25,clos25g,clos25,clos25g" width="100%">
                        <h:column><h:outputText value="Nombre jours de relance:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.nbrJrRelanceDEVIS}" style="width:50px;"/></h:column>
                        <h:column><h:outputText value="Nombre jour de validité:"/></h:column>
                        <h:column><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.nbrJrValidDEVIS}" style="width:50px;"/></h:column>
                    </h:panelGrid>                  
                    <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                        <h:column><h:outputText value ="Affichage dans la fiche tiers:" /></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.affichInTierFilDEVIS}" style="width:200px;">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.affichInGlobViewDEVIS}" style="width:200px;" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Divers">
                    <center><h4><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.obsProduit}" style="color:red;"/></h4></center>
                    <br>
                    <h:panelGrid  width="100%" style="background-color:white;" columns="2"  columnClasses="clos20,clos60g">
                        <h:outputText value = "Responsables/Commerciaux:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.responsable}" style="width:300px;">
                            <f:selectItem itemLabel="Uniquement les responsables" itemValue="0" />
                            <f:selectItem itemLabel="Responsables et Commerciaux libres" itemValue="2"/>
                            <f:selectItem itemLabel="Equipe (Responsable + Commercial)" itemValue="1"/>
                        </h:selectOneMenu>
                        <h:outputText value = "Nb Décimales P.U.:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.nbDecPu}" style="width:300px;">
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
                        <h:outputText value = "Prix de vente:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.decrmtPriVteStock}" style="width:300px;">
                            <f:selectItem itemLabel="Prix de vente en H.T." itemValue="1" />
                            <f:selectItem itemLabel="Prix de vente en T.T.C." itemValue="2"/>
                        </h:selectOneMenu>
                        <h:outputText rendered="false" value = "Saisie zones Analytiques:"/>
                        <h:selectOneMenu rendered="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.analAuto}" style="width:300px;">
                            <f:selectItem itemLabel="Saisie sur liste (chargement automatique)" itemValue="0" />
                            <f:selectItem itemLabel="Saisie sur zone de saisie" itemValue="1"/>
                        </h:selectOneMenu>
                        <h:outputText value = "Nombre ligne maximum des documents:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.nbLigneMax}" style="width:300px;">
                            <jsp:include flush="true" page="/commun/decoupageNbLigne.jsp"/>
                        </h:selectOneMenu>
                        <h:outputText value = "Chargement des listes:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.chargementListe}" style="width:300px;">
                            <f:selectItem itemLabel="Manuel" itemValue="0" />
                            <f:selectItem itemLabel="Automatique" itemValue="1"/>
                        </h:selectOneMenu>
                        <h:outputText value = "Date sur transformation:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.dateTransformation}" style="width:300px;">
                            <f:selectItem itemLabel="Date d'origine" itemValue="0" />
                            <f:selectItem itemLabel="Date du jour" itemValue="1"/>
                        </h:selectOneMenu>
                        <h:outputText value = "Libellé des produits sur documents:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.libelleProduit}" style="width:300px;">
                            <f:selectItem itemLabel="Majuscule" itemValue="0" />
                            <f:selectItem itemLabel="Capital" itemValue="1"/>
                            <f:selectItem itemLabel="Minuscule" itemValue="2"/>
                        </h:selectOneMenu>
                        <h:outputText value = "Code TVA sur produits libres:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.tvaDefaut}" style="width:300px;">
                            <f:selectItem itemLabel="Sans code" itemValue="" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.mesTvaItem}"/>
                        </h:selectOneMenu>
                        <h:column><h:outputText value="Gestion de la traçabilité:"   /></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.tracabilite}" style="width:300px;" >
                                <f:selectItem itemLabel="Historique complet" itemValue="0"/>
                                <f:selectItem itemLabel="Historique limité au document en cours" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Gestion de la transformation:"   /></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.transformation}" style="width:300px;" >
                                <f:selectItem itemLabel="Sans information sur l'origine" itemValue="0"/>
                                <f:selectItem itemLabel="Avec l'information sur l'origine (---> Suivant...)" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Entete">
                    <center>
                        <h:panelGrid columns="2">
                            <h:outputText value="Libellé 1:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib1ENTETE}">
                                <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.calculeLibEntete}" reRender="idPanelOption"/>
                            </h:inputText>
                            <h:outputText value="Libellé 2:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib2ENTETE}">
                                <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.calculeLibEntete}" reRender="idPanelOption"/>
                            </h:inputText>
                            <h:outputText value="Libellé 3:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib3ENTETE}">
                                <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.calculeLibEntete}" reRender="idPanelOption"/>
                            </h:inputText>
                            <h:outputText value="Libellé 4:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib4ENTETE}">
                                <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.calculeLibEntete}" reRender="idPanelOption"/>
                            </h:inputText>
                            <h:outputText value="Libellé 5:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib5ENTETE}">
                                <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.calculeLibEntete}" reRender="idPanelOption"/>
                            </h:inputText>
                            <h:outputText value="Libellé 6:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib6ENTETE}">
                                <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.calculeLibEntete}" reRender="idPanelOption"/>
                            </h:inputText>
                            <h:outputText value="Libellé 7:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib7ENTETE}">
                                <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.calculeLibEntete}" reRender="idPanelOption"/>
                            </h:inputText>
                            <h:outputText value="Libellé 8:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib8ENTETE}">
                                <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.calculeLibEntete}" reRender="idPanelOption"/>
                            </h:inputText>
                            <h:outputText value="Libellé 9:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib9ENTETE}">
                                <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.calculeLibEntete}" reRender="idPanelOption"/>
                            </h:inputText>
                            <h:outputText value="Libellé 10:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib10ENTETE}">
                                <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.calculeLibEntete}" reRender="idPanelOption"/>
                            </h:inputText>
                        </h:panelGrid>
                    </center>
                </rich:tab>

                <rich:tab label="Compta.">
                    <center>
                        <h:panelGrid columns="2">
                            <h:outputText value = "Transfert documents:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.transfertDocument}" style="width:300px;">
                                <f:selectItem itemLabel="Uniquement les documents validés" itemValue="0" />
                                <f:selectItem itemLabel="Les documents en Cours et les validés" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:outputText value="Zone Référence 1:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.zoneRef1}" style="width:300px;">
                                <f:selectItem itemLabel="N° document en cours" itemValue="0" />
                                <f:selectItem itemLabel="N° document origine" itemValue="1"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib1ENTETE}" itemValue="11" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib1}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib2ENTETE}" itemValue="12" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib2}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib3ENTETE}" itemValue="13" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib3}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib4ENTETE}" itemValue="14" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib4}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib5ENTETE}" itemValue="15" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib5}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib6ENTETE}" itemValue="16" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib6}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib7ENTETE}" itemValue="17" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib7}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib8ENTETE}" itemValue="18" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib8}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib9ENTETE}" itemValue="19" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib9}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib10ENTETE}" itemValue="20" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib10}"/>
                            </h:selectOneMenu>
                            <h:outputText value="Serie Référence 1:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.zoneRef1Serie}" style="width:300px;">
                                <f:selectItem itemLabel="Avec Série" itemValue="0" />
                                <f:selectItem itemLabel="Sans Série" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:outputText value="Zone Référence 2:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.zoneRef2}" style="width:300px;">
                                <f:selectItem itemLabel="N° document en cours" itemValue="0" />
                                <f:selectItem itemLabel="N° document origine" itemValue="1"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib1ENTETE}" itemValue="11" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib1}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib2ENTETE}" itemValue="12" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib2}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib3ENTETE}" itemValue="13" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib3}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib4ENTETE}" itemValue="14" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib4}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib5ENTETE}" itemValue="15" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib5}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib6ENTETE}" itemValue="16" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib6}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib7ENTETE}" itemValue="17" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib7}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib8ENTETE}" itemValue="18" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib8}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib9ENTETE}" itemValue="19" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib9}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib10ENTETE}" itemValue="20" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib10}"/>
                            </h:selectOneMenu>
                            <h:outputText value="Serie Référence 2:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.zoneRef2Serie}" style="width:300px;">
                                <f:selectItem itemLabel="Avec Série" itemValue="0" />
                                <f:selectItem itemLabel="Sans Série" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:outputText value="Zone Libellé:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.zoneLibelle}" style="width:300px;">
                                <f:selectItem itemLabel="Nom tiers" itemValue="0" />
                                <f:selectItem itemLabel="Objet" itemValue="1"/>
                                <f:selectItem itemLabel="Objet + date document en cours" itemValue="2"/>
                            </h:selectOneMenu>
                            <h:outputText value="Zone Libellé suite:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.zoneLibelleSuite}" style="width:300px;">
                                <f:selectItem itemLabel="" itemValue="0" />
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib1ENTETE}" itemValue="11" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib1}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib2ENTETE}" itemValue="12" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib2}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib3ENTETE}" itemValue="13" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib3}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib4ENTETE}" itemValue="14" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib4}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib5ENTETE}" itemValue="15" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib5}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib6ENTETE}" itemValue="16" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib6}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib7ENTETE}" itemValue="17" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib7}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib8ENTETE}" itemValue="18" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib8}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib9ENTETE}" itemValue="19" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib9}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib10ENTETE}" itemValue="20" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib10}"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                    </center>
                </rich:tab>

            </rich:tabPanel>
        </center>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />&nbsp;&nbsp;&nbsp;&nbsp;
            <h:commandButton styleClass="exp_lienmenu" value="VALIDER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.creerOptionsVentes}" onclick="if (!confirm('Voulez-vous enregistrer les modifications ?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>

    </a4j:form>

</f:subview>