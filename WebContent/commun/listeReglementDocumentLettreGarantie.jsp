<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>

<rich:column sortable="false" width="10%" sortOrder="DESCENDING" sortBy="#{recu.rglDateReg}">
    <f:facet name="header"><h:outputText  value="Date reçu."/></f:facet>
    <h:outputText value="#{recu.rglDateReg}">
        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
    </h:outputText>
</rich:column>
<rich:column sortable="false" width="10%">
    <f:facet name="header"><h:outputText  value="N° reçu"/></f:facet>
    <h:outputText value="#{recu.rglNum}"/>
</rich:column>
<rich:column sortable="false" width="10%">
    <f:facet name="header"><h:outputText  value="Type document"/></f:facet>
    <h:outputText value="#{recu.var_lib_nat}"/>
</rich:column>
<rich:column sortable="false" width="10%">
    <f:facet name="header"><h:outputText  value="N° document"/></f:facet>
    <h:outputText value="#{recu.rglDocument}"/>
</rich:column>
<rich:column sortable="false" width="10%" style="text-align:right">
    <f:facet name="header"><h:outputText  value="Montant"/></f:facet>
    <h:outputText value="#{recu.montantReglement}" rendered="#{recu.montantReglement!=0}">
        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
    </h:outputText>
</rich:column>
<rich:column sortable="false" width="10%">
    <f:facet name="header"><h:outputText  value="N° Lettre"/></f:facet>
    <h:outputText  value="#{recu.rglNumChqBdx}"/>
</rich:column>
<rich:column sortable="false" width="18%">
    <f:facet name="header"><h:outputText  value="Caisse"/></f:facet>
    <h:outputText  value="#{recu.rglCodeCaiss}:#{recu.rglLibCaiss} #{recu.rglLibelle}"/>
</rich:column>
<rich:column sortable="false" width="15%">
    <f:facet name="header"><h:outputText  value="Responsable"/></f:facet>
    <h:outputText value="#{recu.rglNomResponsable}" title="#{recu.rglNomResponsable}"/>
</rich:column>
<rich:column sortable="false" width="7%">
    <f:facet name="header"><h:outputText  value="Position"/></f:facet>
    <h:outputText value="#{recu.rglLibEmetrice}" title="#{recu.rglLibEmetrice}" rendered="#{recu.rglLibEmetrice!=null}"/>
    <h:outputText value="#{recu.rglLibReceptrice}" title="#{recu.rglLibReceptrice}" rendered="#{recu.rglLibReceptrice!=null}"/>
</rich:column>