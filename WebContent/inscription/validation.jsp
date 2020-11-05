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
            <title>Validation de l'inscrition</title>
        </head>

        <body >
            <a4j:form >
                <center>

                    <h:panelGrid columnClasses="col,col" style="width:708px;">
                        <h:graphicImage url="../../images/header.jpg" style="border:2px solid green;width:100%; margin-top:5px;"/>
                    </h:panelGrid>

                    <h:panelGrid style="width:708px;border:solid 0px green;" >
                        <center>
                            <rich:panel  headerClass="headerTab" style="width:708px; margin-top:5px;border:0px;">
                                <f:facet name="header">
                                    <h:outputText value="INFORMATIONS SUR LA SOCIETE" />
                                </f:facet>
                                <h:panelGrid columns="2" cellspacing="3" width="100%" columnClasses="clos20,clos80">
                                    <h:column><h:outputText value="Raison sociale:"/></h:column>
                                    <h:column><h:inputText value="#{createAppli.newStructure.strraisonsociale}" readonly="true" size="50"/></h:column>
                                    <h:column><h:outputText value="Adresse:"/></h:column>
                                    <h:column><h:inputText value="#{createAppli.newStructure.stradresse}" readonly="true" size="50"/></h:column>
                                    <h:column><h:outputText value="Boite Postale:"/></h:column>
                                    <h:column><h:inputText value="#{createAppli.newStructure.strbp}" readonly="true" size="50"/></h:column>
                                    <h:column><h:outputText value="Ville:"/></h:column>
                                    <h:column><h:inputText value="#{createAppli.newStructure.strville}" readonly="true" size="50"/></h:column>
                                    <h:column><h:outputText value="Téléphone:"/></h:column>
                                    <h:column><h:inputText value="#{createAppli.newStructure.strtel1}" readonly="true" size="50"/></h:column>
                                    <h:column><h:outputText value="Fax:"/></h:column>
                                    <h:column><h:inputText value="#{createAppli.newStructure.strfax}"  readonly="true" size="50"/></h:column>
                                    <h:column><h:outputText value="Pays:"/></h:column>
                                    <h:column><h:inputText value="#{createAppli.newStructure.strnompays}"  readonly="true" size="50"/></h:column>
                                    <h:column><h:outputText value="Devise:"/></h:column>
                                    <h:column><h:inputText value="#{createAppli.newStructure.strdevise}" readonly="true" size="50"/></h:column>
                                    <h:column><h:outputText value="Langue:"/></h:column>
                                    <h:column><h:inputText value="#{createAppli.newStructure.strlangue}" readonly="true" size="50"/></h:column>
                                </h:panelGrid>
                            </rich:panel >

                            <rich:panel headerClass="headerTab" style="width:100%;border:0px;">
                                <f:facet name="header">
                                    <h:outputText value="INFORMATIONS SUR L'INDIVIDUS" />
                                </f:facet>
                                <h:panelGrid columns="2" cellspacing="3" width="100%" columnClasses="clos20,clos80">
                                    <h:column><h:outputText value="Prénom:"/></h:column>
                                    <h:column><h:inputText value="#{createAppli.newUsers.usrprenom}" size="50" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Nom:"/></h:column>
                                    <h:column><h:inputText value="#{createAppli.newUsers.usrnom}" size="50" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Email:"/></h:column>
                                    <h:column><h:inputText value="#{createAppli.newUsers.usrmail}" size="50" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Login:"/></h:column>
                                    <h:column><h:inputText value="#{createAppli.newUsers.usrlogin}" size="50" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Fonction:"/></h:column>
                                    <h:column><h:inputText value="#{createAppli.newUsers.usrfonction}" size="50" readonly="true"/></h:column>
                                </h:panelGrid>
                            </rich:panel>

                            <rich:panel headerClass="headerTab" style="width:100%;border:0px;" >
                                <f:facet name="header">
                                    <h:outputText value="MODULES CHOISIS " />
                                </f:facet>
                                <h:panelGrid columns="2" cellspacing="3" columnClasses="clos20,clos80">
                                    <h:dataTable value="#{createAppli.modulesSelect}" var="mdl">
                                        <h:column><h:selectBooleanCheckbox disabled="true"/></h:column>
                                        <h:column><h:outputText value="#{mdl.libelle1FR}"/></h:column>
                                    </h:dataTable>
                                </h:panelGrid>
                            </rich:panel >

                        </center>
                    </h:panelGrid>

                    <br/>
                    <center>
                        <h:panelGrid columns="3" id="f2">
                            <a4j:commandButton image="../../images/precedent.gif" onclick="javascript:history.back()"/>
                            <h:commandButton  image="../../images/suivant.gif" action="#{createAppli.CreerInscription}" value="Valider"/>
                        </h:panelGrid>
                    </center>

                </center>
            </a4j:form>
        </body>
    </html>
</f:view>