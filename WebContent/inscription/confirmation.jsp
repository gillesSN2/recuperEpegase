<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:view>
    <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <link rel="stylesheet" type="text/css" href="../../css/epegase.css"/>
            <title>Confirmation de l'inscrition</title>
        </head>

        <body>
            <a4j:form >
                <center><br/>

                    <h:panelGrid columnClasses="col,col" style="width:708px;">
                        <h:graphicImage url="../../images/header.jpg" style="border:2px solid green;width:100%; margin-top:5px;"/>
                    </h:panelGrid>

                    <rich:panel  headerClass="headerTab"style="width:702px;border:solid 0px green; margin-top:0px;font-family:sans-serif;">

                        <f:facet name="header">
                            <h:outputText value="CONFIRMATION DU COMPTE" />
                        </f:facet>

                        <h:panelGrid columns="2" cellspacing="3">

                            <h:panelGroup>
                                <h1>
                                    <h:outputText style="color:red;" value="Votre inscription a été prise en compte !"/><br><br>
                                    <h:outputText value="Un Mail vous a été envoyé qui contient vos identifiants. "/><br><br>
                                    <h:outputText value="Si vous ne le recevez pas, vérifiez dans votre boite SPAM ou refaite l'inscription"/>
                                </h1>
                            </h:panelGroup>

                        </h:panelGrid>

                    </rich:panel>

                    <a href="../../index.faces" style="text-decoration:none;font-family:sans-serif;color:green;font-weight:bold;">e-Pégase</a>

                </center>
            </a4j:form>
        </body>
    </html>
</f:view>