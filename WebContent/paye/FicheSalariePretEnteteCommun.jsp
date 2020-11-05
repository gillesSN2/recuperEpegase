<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>


<rich:column label="Nature du prêt" sortable="false" width="150px">
    <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
    <h:outputText value="#{prInt.lib_nature}" style="#{prInt.color}"/>
</rich:column>
<rich:column label="Etat du prêt" sortable="false" width="60px">
    <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
    <h:outputText value="#{prInt.libelleEtat}" id="idEtatPretInterne" style="#{prInt.color}"/>
</rich:column>
<rich:column label="N° du prêt" sortable="false" width="60px" style="text-align:right;">
    <f:facet name="header"><h:outputText  value="N°" /></f:facet>
    <h:outputText value="#{prInt.salpreNum}" style="#{prInt.color}"/>
</rich:column>
<rich:column label="Montant" sortable="false" width="100px" style="text-align:right;">
    <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
    <h:outputText value="#{prInt.salpreMontant}" rendered="#{prInt.salpreMontant!=0}" style="#{prInt.color}">
        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
    </h:outputText>
</rich:column>
<rich:column label="Date début remboursement" sortable="false" width="80px" style="text-align:right;">
    <f:facet name="header"><h:outputText  value="Début" /></f:facet>
    <h:outputText value="#{prInt.salpreDateDebut}" style="#{prInt.color}">
        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
    </h:outputText>
</rich:column>
<rich:column label="Nombre d'échéances" sortable="false" width="60px" style="text-align:right;">
    <f:facet name="header"><h:outputText  value="Echéance" /></f:facet>
    <h:outputText value="#{prInt.salpreEcheance}" style="#{prInt.color}"/>
</rich:column>
<rich:column label="Déjà remboursé" sortable="false" width="100px" style="text-align:right;">
    <f:facet name="header"><h:outputText  value="Remboursement" /></f:facet>
    <h:outputText value="#{prInt.salpreRmb}" rendered="#{prInt.salpreRmb!=0}" style="#{prInt.color}">
        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
    </h:outputText>
</rich:column>
<rich:column label="Solde" sortable="false" width="100px" style="text-align:right;">
    <f:facet name="header"><h:outputText  value="Solde" /></f:facet>
    <h:outputText value="#{prInt.solde}" rendered="#{prInt.solde!=0}" style="#{prInt.color}">
        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
    </h:outputText>
</rich:column>
<rich:column label="Description" sortable="false" width="300px">
    <f:facet name="header"><h:outputText  value="Description" /></f:facet>
    <h:outputText value="#{prInt.salpreObjet}" style="#{prInt.color}"/>
</rich:column>

