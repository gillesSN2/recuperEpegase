<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<f:view>
    <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <link rel="stylesheet" type="text/css" href="../../css/epegase.css"/>
            <title>Choix des modules</title>
        </head>

        <body>
            <a4j:form>
                <center>
                    <h:panelGrid  columnClasses="col,col">
                        <h:graphicImage url="../../images/header.jpg" style="border:2px solid green;width:100%; margin-top:5px;"/>
                    </h:panelGrid>
                    <h:panelGrid columns="2"  width="150" style="border-bottom:1px solid green;margin-left:25px;"columnClasses="col,col">
                        <h:column><h:graphicImage url="../../images/ligne.gif" /></h:column>
                        <h:column>
                            <h:outputText value="Administration" title="Administration du portail de gestion e-Pégase"/>
                        </h:column>
                        <h:column><h:graphicImage url="../../images/ligne.gif" /></h:column>
                        <h:column>
                            <h:outputText value="Mon Compte" title="Gestion de compte dans la portail e-Pégase"/>
                        </h:column>
                        <h:column><h:graphicImage url="../../images/ligne.gif" /></h:column>
                        <h:column>
                            <h:outputText value="Accueil" title="Météo, Dernières news, Flux RSS, Histoire de Pégase, Norme QC 100"/>
                        </h:column>
                        <h:column><h:graphicImage url="../../images/ligne.gif" /></h:column>
                        <h:column>
                            <h:outputText value="Office" title="Mes documents, Ma Messagerie, Mon Planning, Mon Parapheur, Annuaire"/>
                        </h:column>
                        <h:column><h:graphicImage url="../../images/ligne.gif" /></h:column>
                        <h:column>
                            <h:outputText value="Gestion des Tiers" title="Immatriculation, Modes de règlement, Eléments de facturation, Contacts, Photos, Planning, Rendez-vous"/>
                        </h:column>
                        <h:column><h:graphicImage url="../../images/ligne.gif" /></h:column>
                        <h:column>
                            <h:outputText  value="Comptabilité" title="Module de comptabilité"/>
                            <h:panelGrid border="0" columnClasses="col" id="cpt1"  style="margin-left:20px;width:500px;">
                                <h:column>
                                    <h:selectOneRadio value="#{createAppli.choixCompta}" layout="pageDirection" id="taillecp">
                                        <f:selectItem itemLabel="Pas de Comptabilité" itemValue="0"/>
                                        <f:selectItem itemLabel="Comptabilité Libérale" itemValue="1" itemDisabled="true"/>
                                        <f:selectItem itemLabel="Comptabilité Société" itemValue="2"/>
                                        <f:selectItem itemLabel="Comptabilité Projet" itemValue="3" itemDisabled="true"/>
                                    </h:selectOneRadio>
                                </h:column>
                            </h:panelGrid>
                        </h:column>
                        <h:column><h:selectBooleanCheckbox value="#{createAppli.checkboxPaye}" /></h:column>
                        <h:column >
                            <h:outputText  value="Paye" title="Module Paye, RH et Pointage horaire" style="text-decoration:none;color:#000000;"/>
                        </h:column>
                        <h:column><h:selectBooleanCheckbox value="#{createAppli.checkboxAchats}" /></h:column>
                        <h:column >
                            <h:outputText  value="Achats"  title="Module des achats" style="text-decoration:none;color:#000000;"/>
                        </h:column>
                        <h:column><h:selectBooleanCheckbox value="#{createAppli.checkboxParc}" /></h:column>
                        <h:column >
                            <h:outputText value="Parc" title="Module GMAO" style="text-decoration:none;color:#000000;"/>
                        </h:column>
                        <h:column><h:selectBooleanCheckbox value="#{createAppli.checkboxCaisse}" /></h:column>
                        <h:column >
                            <h:outputText  value="Caisse décentralisée" title="Module de la caisse commerciale décentralisée" style="text-decoration:none;color:#000000;"/>
                        </h:column>
                        <h:column><h:graphicImage url="../../images/ligne.gif" /></h:column>
                        <h:column >
                            <h:outputText  value="Suivi Commercial" title="Module CRM (standard ou lié à un métier"  style="text-decoration:none;color:#000000;"/>
                            <h:panelGrid border="0"  columnClasses="col"  style="margin-left:20px;width:500px;">
                                <h:column>
                                    <h:selectOneRadio value="#{createAppli.choixCommercial}" layout="pageDirection" id="taille">
                                        <f:selectItem itemLabel="Pas de Suivi Commercial" itemValue="0"/>
                                        <f:selectItem itemLabel="Suivi Commercial Standard" itemValue="1"/>
                                        <f:selectItem itemLabel="Suivi Commercial Standard + Comptoir" itemValue="2" itemDisabled="true"/>
                                        <f:selectItem itemLabel="Gestion Fondation" itemValue="3"/>
                                        <f:selectItem itemLabel="Gestion Intérim" itemValue="4"/>
                                        <f:selectItem itemLabel="Gestion Dockers" itemValue="5" itemDisabled="true"/>
                                        <f:selectItem itemLabel="Gestion Transit" itemValue="6" itemDisabled="true"/>
                                        <f:selectItem itemLabel="Gestion Micro finance" itemValue="7"/>
                                        <f:selectItem itemLabel="Gestion du Change Monétaire" itemValue="8" itemDisabled="true"/>
                                        <f:selectItem itemLabel="Gestion Education" itemValue="9"/>
                                        <f:selectItem itemLabel="Gestion des Pêcheries" itemValue="11" itemDisabled="true"/>
                                        <f:selectItem itemLabel="Gestion des Temples" itemValue="12" itemDisabled="true"/>
                                        <f:selectItem itemLabel="Gestion des PABX" itemValue="13" itemDisabled="true"/>
                                        <f:selectItem itemLabel="Gestion Forestière" itemValue="14" itemDisabled="true"/>
                                        <f:selectItem itemLabel="Gestion Médicale" itemValue="15"/>
                                        <f:selectItem itemLabel="Gestion Immobilière" itemValue="16"/>
                                        <f:selectItem itemLabel="Gestion Hotellerie" itemValue="17" itemDisabled="true"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column>
                                </h:column>
                            </h:panelGrid>
                        </h:column>
                    </h:panelGrid>

                    <br/>
                    <center>
                        <h:panelGrid columns="3" id="f2">
                            <a4j:commandButton image="../../images/precedent.gif" onclick="javascript:history.back()"/>
                            <h:commandButton  image="../../images/suivant.gif" action="#{createAppli.suivantModules}" />
                        </h:panelGrid>
                    </center>

                </center>
            </a4j:form>
        </body>
    </html>
</f:view>