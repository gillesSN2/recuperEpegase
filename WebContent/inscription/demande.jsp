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
            <title>Mon compte</title>
        </head>

        <body>
            <a4j:form id="demande">
                <center><h:graphicImage url="../../images/header.jpg" style="border:2px solid green;width:50%; margin-top:30px;"/>
                    <rich:panel style="width:50%;border:1px solid green;border-top:0px;">
                        <h:graphicImage url="../../images/compteinfo.gif" style="margin-bottom:25px;margin-top:10px;" />
                        <h:panelGrid style="text-align:justify;font-size:12px;font-family:sans-serif;"> Remplissez le formulaire suivant. Nous vous enverrons les codes d'accés de la plate forme de démonstration le plus rapidement possible.
                        </h:panelGrid>

                        <h:panelGrid columns="1" width="70%" style="tex-align:center;">
                            <h:column>
                                <center>
                                    <rich:messages layout="table" style="color:red;" tooltip="true" showDetail="false" showSummary="true">
                                        <f:facet name="errorMarker">
                                            <h:graphicImage url="../../images/error.gif" style="margin-right:10px;"/>
                                        </f:facet>
                                    </rich:messages>
                                </center>
                            </h:column>
                        </h:panelGrid>

                        <h:panelGrid columns="2" cellspacing="3" width="100%" columnClasses="clos20,clos80" id="fp">
                            <h:column><h:outputText style="margin-left:10px" value=""/> </h:column>
                            <h:column><h:outputText style="font-size:11px;color:red;" value="Tous les Champs sont obligatoires" binding="#{createAppli.alerteMessage}"/></h:column>
                            <h:column><h:outputText value="Société:"/></h:column>
                            <h:column><h:inputText value="#{createAppli.newUsers.usrprenom}" maxlength="50" size="50" /></h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Pays:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idPays" style="border:1px solid green;" binding="#{createAppli.selectOneMenu}" value="#{createAppli.newStructure.strnompays}">
                                    <a4j:support eventsQueue="maQueue" reRender="idDevise" event="onchange" action="#{createAppli.selectionElement}"/>
                                    <f:selectItems  value="#{createAppli.lespays.mesPaysItems}" />
                                </h:selectOneMenu>
                                <h:outputText style="font-size:11px;color:red;text-decoration:blink;" value="(Le pays conditionne les normes fiscales et sociales)"/>
                            </h:column>
                            <h:column><h:outputText value="Prénom:"/></h:column>
                            <h:column><h:inputText value="#{createAppli.newUsers.usrprenom}" maxlength="50" size="50" /></h:column>
                            <h:column><h:outputText value="Nom:"/> </h:column>
                            <h:column><h:inputText onchange="javascript:this.value=this.value.toUpperCase();" id="Adresse" value="#{createAppli.newUsers.usrnom}" size="50"  maxlength="50"/></h:column>
                            <h:column><h:outputText value="E-mail:"/></h:column>
                            <h:column>
                                <h:inputText required="true" style="border:1px solid green;"id="cptMail" size="50"  value="#{createAppli.newUsers.usrmail}" maxlength="100">
                                    <f:validator validatorId = "validemail"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText  value="Fonction:"/></h:column>
                            <h:column><h:inputText id="cptFonction" size="50"  value="#{createAppli.newUsers.usrfonction}" maxlength="50" styleClass="inputText"/></h:column>
                        </h:panelGrid>

                        <br/>
                        <center>
                            <h:panelGrid columns="3" id="f2">
                                <a4j:commandButton image="../../images/precedent.gif" onclick="javascript:history.back()"/>
                                <h:commandButton  image="../../images/suivant.gif" action="#{createAppli.CreerDemande}" value="Valider"/>
                            </h:panelGrid>
                        </center>

                    </rich:panel >

                </center>
            </a4j:form>
        </body>
    </html>
</f:view>