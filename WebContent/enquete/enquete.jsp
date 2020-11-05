<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:view>
    <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <meta http-equiv="X-UA-Compatible" content="IE=edge" />
            <link rel="icon" type="image/png" href="../favicon.ico" />
            <link href="../css/designvert.css" title="Alternatif 1" type="text/css" rel="stylesheet"/>
            <title>Enquête de satisfaction e-Pégase</title>
            <script type="text/javascript" language=javascript>
                function myUrl(){
                    var urlDoc = document.location.href;
                    var doc = urlDoc.split("epegase");
                    var valUrl = doc[0];
                    document.getElementById("idenquete:idValUrl").value = valUrl;
                }
            </script>

        </head>

        <body onload="myUrl()">
            <a4j:form id="idenquete">
                <h:inputHidden id="idValUrl" value="#{enquete.urlClient}" immediate="true"/>

                <center>
                    <h:panelGrid width="60%">

                        <h:panelGroup>
                            <center>
                                <h:graphicImage url="/images/header.jpg" height="200px" width="100%"/><br>
                                <h:graphicImage url="/images/avis.jpg" height="100px" width="400px"/><br>
                                <h:column><h:outputText value="(Cette enquête est anomyme. Elle a été conçue pour améliorer epegase)"/></h:column>
                            </center>
                        </h:panelGroup>

                        <h:panelGrid style="font-size:10px;font-family:sans-serif;width:100%;border:1px solid green;">

                            <h:panelGrid width="100%" style="border:1px solid green" columns="2" columnClasses="clos20,clos80" headerClass="headerTab">
                                <f:facet name="header"><h:outputText value="Comportement global epegase"/></f:facet>
                                <h:column><h:outputText value="Fonctionnalités" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq00Fonctionnel}" >
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Simple" itemValue="1"/>
                                        <f:selectItem itemLabel="Complexe" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Convivialité" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq00Convivialite}" >
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Bien pensé" itemValue="1"/>
                                        <f:selectItem itemLabel="Mal pensé" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Ergonomie" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq00Ergonomie}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Joli" itemValue="1"/>
                                        <f:selectItem itemLabel="Pas joli" itemValue="2"/>
                                        <f:selectItem itemLabel="Agréable" itemValue="3"/>
                                        <f:selectItem itemLabel="Pas agréable" itemValue="4"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Assistance" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq00Assistance}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Bonne réactivité" itemValue="1"/>
                                        <f:selectItem itemLabel="Réactivité Moyenne" itemValue="2"/>
                                        <f:selectItem itemLabel="Mauvaise Réactivité" itemValue="3"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Observations" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq00Observation}" maxlength="100" style="width:100%"/></h:column>
                                <h:column><h:outputText value="Suggestion" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq00Suggestion}" maxlength="100" style="width:100%"/></h:column>
                            </h:panelGrid>

                            <h:panelGrid width="100%" style="border:1px solid green" columns="2" columnClasses="clos20,clos80" headerClass="headerTab">
                                <f:facet name="header"><h:outputText value="Accès epegase"/></f:facet>
                                <h:column><h:outputText value="Fonctionnalités" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq01Fonctionnel}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Simple" itemValue="1"/>
                                        <f:selectItem itemLabel="Complexe" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Convivialité" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq01Convivialite}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Bien pensé" itemValue="1"/>
                                        <f:selectItem itemLabel="Mal pensé" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Ergonomie" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq01Ergonomie}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Joli" itemValue="1"/>
                                        <f:selectItem itemLabel="Pas joli" itemValue="2"/>
                                        <f:selectItem itemLabel="Agréable" itemValue="3"/>
                                        <f:selectItem itemLabel="Pas agréable" itemValue="4"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Observations" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq01Observation}" maxlength="100" style="width:100%"/></h:column>
                                <h:column><h:outputText value="Suggestion" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq01Suggestion}" maxlength="100" style="width:100%"/></h:column>
                            </h:panelGrid>

                            <h:panelGrid width="100%" style="border:1px solid green" columns="2" columnClasses="clos20,clos80" headerClass="headerTab">
                                <f:facet name="header"><h:outputText value="Ecran d'accueil"/></f:facet>
                                <h:column><h:outputText value="Fonctionnalités" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq02Fonctionnel}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Simple" itemValue="1"/>
                                        <f:selectItem itemLabel="Complexe" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Convivialité" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq02Convivialite}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Bien pensé" itemValue="1"/>
                                        <f:selectItem itemLabel="Mal pensé" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Ergonomie" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq02Ergonomie}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Joli" itemValue="1"/>
                                        <f:selectItem itemLabel="Pas joli" itemValue="2"/>
                                        <f:selectItem itemLabel="Agréable" itemValue="3"/>
                                        <f:selectItem itemLabel="Pas agréable" itemValue="4"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Observations" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq02Observation}" maxlength="100" style="width:100%"/></h:column>
                                <h:column><h:outputText value="Suggestion" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq02Suggestion}" maxlength="100" style="width:100%"/></h:column>
                            </h:panelGrid>
                            <br>
                            <h:panelGrid width="100%" style="border:1px solid green" columns="2" columnClasses="clos20,clos80" headerClass="headerTab">
                                <f:facet name="header"><h:outputText value="Module Tiers"/></f:facet>
                                <h:column><h:outputText value="Fonctionnalités" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq03Fonctionnel}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Simple" itemValue="1"/>
                                        <f:selectItem itemLabel="Complexe" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Convivialité" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq03Convivialite}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Bien pensé" itemValue="1"/>
                                        <f:selectItem itemLabel="Mal pensé" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Ergonomie" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq03Ergonomie}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Joli" itemValue="1"/>
                                        <f:selectItem itemLabel="Pas joli" itemValue="2"/>
                                        <f:selectItem itemLabel="Agréable" itemValue="3"/>
                                        <f:selectItem itemLabel="Pas agréable" itemValue="4"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Observations" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq03Observation}" maxlength="100" style="width:100%"/></h:column>
                                <h:column><h:outputText value="Suggestion" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq03Suggestion}" maxlength="100" style="width:100%"/></h:column>
                            </h:panelGrid>
                            <br>
                            <h:panelGrid width="100%" style="border:1px solid green" columns="2" columnClasses="clos20,clos80" headerClass="headerTab">
                                <f:facet name="header"><h:outputText value="Module Office"/></f:facet>
                                <h:column><h:outputText value="Fonctionnalités" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq04Fonctionnel}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Simple" itemValue="1"/>
                                        <f:selectItem itemLabel="Complexe" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Convivialité" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq04Convivialite}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Bien pensé" itemValue="1"/>
                                        <f:selectItem itemLabel="Mal pensé" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Ergonomie" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq04Ergonomie}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Joli" itemValue="1"/>
                                        <f:selectItem itemLabel="Pas joli" itemValue="2"/>
                                        <f:selectItem itemLabel="Agréable" itemValue="3"/>
                                        <f:selectItem itemLabel="Pas agréable" itemValue="4"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Observations" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq04Observation}" maxlength="100" style="width:100%"/></h:column>
                                <h:column><h:outputText value="Suggestion" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq04Suggestion}" maxlength="100" style="width:100%"/></h:column>
                            </h:panelGrid>
                            <br>
                            <h:panelGrid width="100%" style="border:1px solid green" columns="2" columnClasses="clos20,clos80" headerClass="headerTab">
                                <f:facet name="header"><h:outputText value="Module Comptabilité (Comptabilité, Etats financiers, Immobilisations, rapprochements bancaires)"/></f:facet>
                                <h:column><h:outputText value="Fonctionnalités" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq05Fonctionnel}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Simple" itemValue="1"/>
                                        <f:selectItem itemLabel="Complexe" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Convivialité" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq05Convivialite}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Bien pensé" itemValue="1"/>
                                        <f:selectItem itemLabel="Mal pensé" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Ergonomie" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq05Ergonomie}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Joli" itemValue="1"/>
                                        <f:selectItem itemLabel="Pas joli" itemValue="2"/>
                                        <f:selectItem itemLabel="Agréable" itemValue="3"/>
                                        <f:selectItem itemLabel="Pas agréable" itemValue="4"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Observations" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq05Observation}" maxlength="100" style="width:100%"/></h:column>
                                <h:column><h:outputText value="Suggestion" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq05Suggestion}" maxlength="100" style="width:100%"/></h:column>
                            </h:panelGrid>
                            <br>
                            <h:panelGrid width="100%" style="border:1px solid green" columns="2" columnClasses="clos20,clos80" headerClass="headerTab">
                                <f:facet name="header"><h:outputText value="Module Achats (Importations, valorisation)"/></f:facet>
                                <h:column><h:outputText value="Fonctionnalités" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq06Fonctionnel}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Simple" itemValue="1"/>
                                        <f:selectItem itemLabel="Complexe" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Convivialité" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq06Convivialite}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Bien pensé" itemValue="1"/>
                                        <f:selectItem itemLabel="Mal pensé" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Ergonomie" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq06Ergonomie}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Joli" itemValue="1"/>
                                        <f:selectItem itemLabel="Pas joli" itemValue="2"/>
                                        <f:selectItem itemLabel="Agréable" itemValue="3"/>
                                        <f:selectItem itemLabel="Pas agréable" itemValue="4"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Observations" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq06Observation}" maxlength="100" style="width:100%"/></h:column>
                                <h:column><h:outputText value="Suggestion" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq06Suggestion}" maxlength="100" style="width:100%"/></h:column>
                            </h:panelGrid>
                            <br>
                            <h:panelGrid width="100%" style="border:1px solid green" columns="2" columnClasses="clos20,clos80" headerClass="headerTab">
                                <f:facet name="header"><h:outputText value="Module Stock"/></f:facet>
                                <h:column><h:outputText value="Fonctionnalités" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq07Fonctionnel}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Simple" itemValue="1"/>
                                        <f:selectItem itemLabel="Complexe" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Convivialité" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq07Convivialite}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Bien pensé" itemValue="1"/>
                                        <f:selectItem itemLabel="Mal pensé" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Ergonomie" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq07Ergonomie}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Joli" itemValue="1"/>
                                        <f:selectItem itemLabel="Pas joli" itemValue="2"/>
                                        <f:selectItem itemLabel="Agréable" itemValue="3"/>
                                        <f:selectItem itemLabel="Pas agréable" itemValue="4"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Observations" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq07Observation}" maxlength="100" style="width:100%"/></h:column>
                                <h:column><h:outputText value="Suggestion" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq07Suggestion}" maxlength="100" style="width:100%"/></h:column>
                            </h:panelGrid>
                            <br>
                            <h:panelGrid width="100%" style="border:1px solid green" columns="2" columnClasses="clos20,clos80" headerClass="headerTab">
                                <f:facet name="header"><h:outputText value="Module Ventes (CRM, gestion des campagnes, SPANCO)"/></f:facet>
                                <h:column><h:outputText value="Fonctionnalités" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq08Fonctionnel}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Simple" itemValue="1"/>
                                        <f:selectItem itemLabel="Complexe" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Convivialité" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq08Convivialite}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Bien pensé" itemValue="1"/>
                                        <f:selectItem itemLabel="Mal pensé" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Ergonomie" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq08Ergonomie}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Joli" itemValue="1"/>
                                        <f:selectItem itemLabel="Pas joli" itemValue="2"/>
                                        <f:selectItem itemLabel="Agréable" itemValue="3"/>
                                        <f:selectItem itemLabel="Pas agréable" itemValue="4"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Observations" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq08Observation}" maxlength="100" style="width:100%"/></h:column>
                                <h:column><h:outputText value="Suggestion" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq08Suggestion}" maxlength="100" style="width:100%"/></h:column>
                            </h:panelGrid>
                            <br>
                            <h:panelGrid width="100%" style="border:1px solid green" columns="2" columnClasses="clos20,clos80" headerClass="headerTab">
                                <f:facet name="header"><h:outputText value="Module Paye (salaires, ressources humaines)"/></f:facet>
                                <h:column><h:outputText value="Fonctionnalités" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq09Fonctionnel}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Simple" itemValue="1"/>
                                        <f:selectItem itemLabel="Complexe" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Convivialité" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq09Convivialite}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Bien pensé" itemValue="1"/>
                                        <f:selectItem itemLabel="Mal pensé" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Ergonomie" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq09Ergonomie}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Joli" itemValue="1"/>
                                        <f:selectItem itemLabel="Pas joli" itemValue="2"/>
                                        <f:selectItem itemLabel="Agréable" itemValue="3"/>
                                        <f:selectItem itemLabel="Pas agréable" itemValue="4"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Observations" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq09Observation}" maxlength="100" style="width:100%"/></h:column>
                                <h:column><h:outputText value="Suggestion" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq09Suggestion}" maxlength="100" style="width:100%"/></h:column>
                            </h:panelGrid>
                            <br>
                            <h:panelGrid width="100%" style="border:1px solid green" columns="2" columnClasses="clos20,clos80" headerClass="headerTab">
                                <f:facet name="header"><h:outputText value="Module Parc"/></f:facet>
                                <h:column><h:outputText value="Fonctionnalités" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq10Fonctionnel}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Simple" itemValue="1"/>
                                        <f:selectItem itemLabel="Complexe" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Convivialité" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq10Convivialite}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Bien pensé" itemValue="1"/>
                                        <f:selectItem itemLabel="Mal pensé" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Ergonomie" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq10Ergonomie}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Joli" itemValue="1"/>
                                        <f:selectItem itemLabel="Pas joli" itemValue="2"/>
                                        <f:selectItem itemLabel="Agréable" itemValue="3"/>
                                        <f:selectItem itemLabel="Pas agréable" itemValue="4"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Observations" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq10Observation}" maxlength="100" style="width:100%"/></h:column>
                                <h:column><h:outputText value="Suggestion" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq10Suggestion}" maxlength="100" style="width:100%"/></h:column>
                            </h:panelGrid>
                            <br>
                            <h:panelGrid width="100%" style="border:1px solid green" columns="2" columnClasses="clos20,clos80" headerClass="headerTab">
                                <f:facet name="header"><h:outputText value="Module Médical"/></f:facet>
                                <h:column><h:outputText value="Fonctionnalités" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq11Fonctionnel}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Simple" itemValue="1"/>
                                        <f:selectItem itemLabel="Complexe" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Convivialité" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq11Convivialite}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Bien pensé" itemValue="1"/>
                                        <f:selectItem itemLabel="Mal pensé" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Ergonomie" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq11Ergonomie}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Joli" itemValue="1"/>
                                        <f:selectItem itemLabel="Pas joli" itemValue="2"/>
                                        <f:selectItem itemLabel="Agréable" itemValue="3"/>
                                        <f:selectItem itemLabel="Pas agréable" itemValue="4"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Observations" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq11Observation}" maxlength="100" style="width:100%"/></h:column>
                                <h:column><h:outputText value="Suggestion" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq11Suggestion}" maxlength="100" style="width:100%"/></h:column>
                            </h:panelGrid>
                            <br>
                            <h:panelGrid width="100%" style="border:1px solid green" columns="2" columnClasses="clos20,clos80" headerClass="headerTab">
                                <f:facet name="header"><h:outputText value="Module Trésorerie"/></f:facet>
                                <h:column><h:outputText value="Fonctionnalités" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq12Fonctionnel}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Simple" itemValue="1"/>
                                        <f:selectItem itemLabel="Complexe" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Convivialité" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq12Convivialite}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Bien pensé" itemValue="1"/>
                                        <f:selectItem itemLabel="Mal pensé" itemValue="2"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Ergonomie" style="font-weight:bold;"/></h:column>
                                <h:column>
                                    <h:selectOneRadio value="#{enquete.pegEnquete.pegenq12Ergonomie}">
                                        <f:selectItem itemLabel="Sans avis" itemValue="0"/>
                                        <f:selectItem itemLabel="Joli" itemValue="1"/>
                                        <f:selectItem itemLabel="Pas joli" itemValue="2"/>
                                        <f:selectItem itemLabel="Agréable" itemValue="3"/>
                                        <f:selectItem itemLabel="Pas agréable" itemValue="4"/>
                                        <f:selectItem itemLabel="A améliorer" itemValue="9"/>
                                    </h:selectOneRadio>
                                </h:column>
                                <h:column><h:outputText value="Observations" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq12Observation}" maxlength="100" style="width:100%"/></h:column>
                                <h:column><h:outputText value="Suggestion" style="font-weight:bold;"/></h:column>
                                <h:column><h:inputText value="#{enquete.pegEnquete.pegenq12Suggestion}" maxlength="100" style="width:100%"/></h:column>
                            </h:panelGrid>
                            <br>
                            <h:panelGroup>
                                <center>
                                    <h:commandButton image="/images/annuler_big.png" action="#{enquete.annulerEnquete}"/>&nbsp;&nbsp;&nbsp;
                                    <h:commandButton image="/images/valider_big.png" action="#{enquete.creationEnquete}" onclick="javascript:Richfaces.showModalPanel('modAttenteEpegase');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=2}"/>
                                </center>
                            </h:panelGroup>

                        </h:panelGrid>

                    </h:panelGrid>
                </center>
            </a4j:form>
        </body>
    </html>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="modAttenteEpegase" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="350" height="80" resizeable="false">
        <f:facet name="header"><h:outputText value="Traitement en cours, veuillez patienter..."/></f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel><h:graphicImage value="/images/ajax-loader(3).gif"/></a4j:outputPanel>
                <br>
            </a4j:form>
        </center>
    </rich:modalPanel>

</f:view>