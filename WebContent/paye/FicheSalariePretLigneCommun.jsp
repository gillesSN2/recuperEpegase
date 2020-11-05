<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>


<rich:column label="Date théorique" sortable="false" width="80px" style="text-align:right;">
    <f:facet name="header"><h:outputText  value="Date Théo." /></f:facet>
    <h:outputText value="#{prLig1.salpreligDateTheo}">
        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
    </h:outputText>
</rich:column>
<rich:column label="Montant théorique" sortable="false" width="100px" style="text-align:right;">
    <f:facet name="header"><h:outputText  value="Montant Théo." /></f:facet>
    <h:outputText value="#{prLig1.salpreligMontantTheo}" rendered="#{prLig1.salpreligMontantTheo!=0}">
        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
    </h:outputText>
</rich:column>
<rich:column label="Date Réelle" sortable="false" width="80px" style="text-align:right;">
    <f:facet name="header"><h:outputText  value="Date Réel." /></f:facet>
    <h:outputText value="#{prLig1.salpreligDateReel}">
        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
    </h:outputText>
</rich:column>
<rich:column label="Montant réel" sortable="false" width="100px" style="text-align:right;">
    <f:facet name="header"><h:outputText  value="Montant Réel." /></f:facet>
    <h:outputText value="#{prLig1.salpreligMontantReel}" rendered="#{prLig1.salpreligMontantReel!=0}">
        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
    </h:outputText>
</rich:column>
<rich:column label="Référence" sortable="false" width="200px">
    <f:facet name="header"><h:outputText  value="Référence" /></f:facet>
    <h:outputText value="#{prLig1.salpreligReference}"/>
</rich:column>
