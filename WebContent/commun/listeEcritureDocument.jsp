<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>

<rich:column sortable="false" width="10%">
    <f:facet name="header"><h:outputText  value="Date"/></f:facet>
    <h:outputText value="#{ecr.ecrDateSaisie}">
        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
    </h:outputText>
</rich:column>
<rich:column sortable="false" width="5%">
    <f:facet name="header"><h:outputText  value="Journal"/></f:facet>
    <h:outputText value="#{ecr.ecrCode}"/>
</rich:column>
<rich:column sortable="false" width="10%">
    <f:facet name="header"><h:outputText  value="N° Pièce"/></f:facet>
    <h:outputText  value="#{ecr.ecrPiece}"/>
</rich:column>
<rich:column sortable="false" width="10%">
    <f:facet name="header"><h:outputText  value="Réf1"/></f:facet>
    <h:outputText  value="#{ecr.ecrReference1}"/>
</rich:column>
<rich:column sortable="false" width="10%">
    <f:facet name="header"><h:outputText  value="Ref2"/></f:facet>
    <h:outputText value="#{ecr.ecrReference2}"/>
</rich:column>
<rich:column sortable="false" width="10%">
    <f:facet name="header"><h:outputText  value="Compte"/></f:facet>
    <h:outputText  value="#{ecr.ecrCompte}"/>
</rich:column>
<rich:column sortable="false" width="10%" style="text-align:right">
    <f:facet name="header"><h:outputText  value="Débit"/></f:facet>
    <h:outputText value="#{ecr.ecrDebitPays}" rendered="#{ecr.ecrDebitPays!=0}">
        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
    </h:outputText>
</rich:column>
<rich:column sortable="false" width="10%" style="text-align:right">
    <f:facet name="header"><h:outputText  value="Crédit"/></f:facet>
    <h:outputText value="#{ecr.ecrCreditPays}" rendered="#{ecr.ecrCreditPays!=0}">
        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
    </h:outputText>
</rich:column>
<rich:column sortable="false" width="25%">
    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
    <h:outputText value="#{ecr.ecrLibelle}"/>
</rich:column>