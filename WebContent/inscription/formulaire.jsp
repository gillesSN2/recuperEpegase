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
            <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
            <link rel="stylesheet" type="text/css"  href="../../css/epegase.css">
            <title>Formulaire d'inscription</title>
        </head>

        <body>
            <a4j:form id="structure">
                <center>
                    <h:graphicImage url="../../images/header.jpg" style="border:2px solid green;width:50%; margin-top:30px;"/>
                    <rich:panel style="width:50%;border:1px solid green;border-top:0px;">
                        <h:graphicImage url="../../images/societeinfo.gif" style="margin-top:10px;margin-bottom:25px;" />

                        <h:panelGrid style="text-align:justify;font-size:12px;font-family:sans-serif;">   Ces informations sont les plus importantes. Pour espérer utiliser l'application e-Pégase, veuillez inscrire des informations valides. Pour bénéficier pleinement de tous les services, vous devez remplir le formulaire suivant.
                            Dès la fin de votre inscription, vous recevrez un mail vous demandant de la confirmer.
                        </h:panelGrid>

                        <h:panelGrid columns="1" width="70%" style="tex-align:center;" id="ent">
                            <h:column>
                                <rich:messages layout="table" tooltip="true" showDetail="false" showSummary="true">
                                    <f:facet name="errorMarker">
                                        <h:graphicImage url="../../images/error.gif" style="margin-right:10px;"/>
                                    </f:facet>
                                </rich:messages>
                            </h:column>
                        </h:panelGrid>

                        <h:panelGrid columns="2" cellspacing="3" width="100%" columnClasses="clos20,clos80" id="fp" >
                            <h:column><h:outputText style="margin-left:10px" value=""/> </h:column>
                            <h:column><h:outputText style="font-size:11px;color:red;" value="Tous les Champs sont obligatoires" binding="#{createAppli.alerteMessage}"/></h:column>
                            <h:column><h:outputText value="Raison sociale:"/></h:column>
                            <h:column><h:inputText style="border:1px solid green;" onchange="javascript:this.value=this.value.toUpperCase();" id="Rsociale" value="#{createAppli.newStructure.strraisonsociale}" maxlength="30" size="50" /></h:column>
                            <h:column><h:outputText value="Adresse:"/></h:column>
                            <h:column><h:inputText style="border:1px solid green;" id="Adresse" value="#{createAppli.newStructure.stradresse}" size="50"  maxlength="30" /></h:column>
                            <h:column><h:outputText value="Boite Postale:"/></h:column>
                            <h:column><h:inputText style="border:1px solid green;" id="Bpostale" size="50"  value="#{createAppli.newStructure.strbp}" maxlength="30"/></h:column>
                            <h:column><h:outputText value="Ville:"/></h:column>
                            <h:column><h:inputText style="border:1px solid green;" onchange="javascript:this.value=this.value.toUpperCase();" id="Ville" size="50"  value="#{createAppli.newStructure.strville}" maxlength="30"/></h:column>
                            <h:column><h:outputText value="Téléphone:"/></h:column>
                            <h:column> <h:inputText style="border:1px solid green;" id="Telephone" size="50"  value="#{createAppli.newStructure.strtel1}" maxlength="30"/></h:column>
                            <h:column><h:outputText value="Fax:"/></h:column>
                            <h:column><h:inputText  style="border:1px solid green;"id="Fax" size="50"  value="#{createAppli.newStructure.strfax}" maxlength="30"/></h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Pays:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idPays" style="border:1px solid green;" binding="#{createAppli.selectOneMenu}" value="#{createAppli.newStructure.strnompays}">
                                    <a4j:support eventsQueue="maQueue" reRender="idDevise" event="onchange" action="#{createAppli.selectionElement}"/>
                                    <f:selectItems  value="#{createAppli.lespays.mesPaysItems}" />
                                </h:selectOneMenu>
                                <h:outputText style="font-size:11px;color:red;text-decoration:blink;" value="(Le pays conditionne les normes fiscales et sociales)"/>
                            </h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Devise:"/></h:column>
                            <h:column>
                                <h:selectOneMenu  id="idDevise" style="border:1px solid green;" value="#{createAppli.newStructure.strdevise}">
                                    <f:selectItems value="#{createAppli.lesdevises.mesDevisesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Langue:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idlangue" style="border:1px solid green;"value="#{createAppli.newStructure.strlangue}">
                                    <f:selectItems value="#{createAppli.lectureLangues.mesLanguesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>

                        <br/>
                        <center>
                            <h:panelGrid columns="3" id="f2" >
                                <h:commandButton image="../../images/precedent.gif" action="#{createAppli.precedent}" />
                                <h:commandButton image="../../images/suivant.gif" action="#{createAppli.suivStruct}" />
                            </h:panelGrid>
                        </center>
                        
                    </rich:panel >
                </center>
            </a4j:form>
        </body>
    </html>
</f:view>