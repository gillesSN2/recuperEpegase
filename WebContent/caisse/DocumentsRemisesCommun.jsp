<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<rich:column label="Etat" width="3%" sortable="true" sortBy="#{table.sel_ecriture}"  >
    <f:facet name="header"><h:outputText  value="Sel."/></f:facet>
    <h:selectBooleanCheckbox value="#{table.sel_ecriture}" style="width:10px;color:#{table.couleur};"/>
</rich:column>
<rich:column label="Etat" width="3%" sortable="true" sortBy="#{table.var_etat}"  >
    <f:facet name="header"><h:outputText  value="E."/></f:facet>
    <h:outputText value="#{table.var_etat}" style="width:10px;color:#{table.couleur};"/>
</rich:column>
<rich:column label="Caisse exécutrice" width="5%" sortable="true" sortBy="#{table.rglCodeCaiss}"  >
    <f:facet name="header"><h:outputText  value="Caisse."/></f:facet>
    <h:outputText value="#{table.rglCodeCaiss}" style="width:10px;color:#{table.couleur};"/>
</rich:column>
<rich:column label="Jour" width="8%" sortable="true" sortBy="#{table.rglDateReg}"  >
    <f:facet name="header"><h:outputText  value="Date"/></f:facet>
    <h:outputText value="#{table.rglDateReg}" style="width:10px;color:#{table.couleur};">
        <f:convertDateTime pattern="dd/MM/yyyy"/>
    </h:outputText>
</rich:column>
<rich:column label="N° de pièce"  width="10%"  sortable="true" sortBy="#{table.rglNum}" sortOrder="DESCENDING" >
    <f:facet name="header"><h:outputText value="N° pièce" /></f:facet>
    <h:outputText value="#{table.rglNum}" style="color:#{table.couleur}"/>
</rich:column>
<rich:column label="Référence N°1"  width="8%" sortable="true" sortBy="#{table.rglBon}" >
    <f:facet name="header"><h:outputText  value="Référence1" /></f:facet>
    <h:outputText value="#{table.rglBon}" style="color:#{table.couleur}" rendered="#{table.rglBon!='NULL'}"/>
</rich:column>
<rich:column label="Date échéance"  width="8%" sortable="true" sortBy="#{table.rglDateValeur}">
    <f:facet name="header"><h:outputText  value="Echéance" /></f:facet>
    <h:outputText value="#{table.rglDateValeur}" style="width:10px;color:#{table.couleur};">
        <f:convertDateTime pattern="dd/MM/yyyy"/>
    </h:outputText>
</rich:column>
<rich:column label="Montant recette"  width="8%" style="text-align:right;" sortable="true" sortBy="#{table.rglRecette}" >
    <f:facet name="header"><h:outputText value="Recette" /></f:facet>
    <h:outputText value="#{table.rglRecette}" rendered="#{table.rglRecette!=0}" style="color:#{table.couleur}">
        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
    </h:outputText>
</rich:column>
<rich:column label="Tiers concerné" width="17%" sortable="true" sortBy="#{table.rglNomTiers}" >
    <f:facet name="header"><h:outputText  value="Tiers" /></f:facet>
    <h:outputText value="#{table.rglNomTiers}" style="color:#{table.couleur}"/>
</rich:column>
<rich:column label="Mode paiement"  width="8%"sortable="true" sortBy="#{table.rglLibTypReg}"  >
    <f:facet name="header"><h:outputText value="Mode" /></f:facet>
    <h:outputText value="#{table.rglLibTypReg}" style="width:100px;color:#{table.couleur};" rendered="#{table.rglLibCaiss!='NULL'}"/>
</rich:column>
<rich:column label="Banque tireur"  width="10%"sortable="true" sortBy="#{table.rglBanqueTireur}" >
    <f:facet name="header"><h:outputText value="Tireur" /></f:facet>
    <h:outputText value="#{table.rglBanqueTireur}" style="width:100px;color:#{table.couleur};" rendered="#{table.rglBanqueTireur!='NULL'}"/>
</rich:column>
<rich:column label="Numéro de chèque"  width="10%"sortable="true" sortBy="#{table.rglNumChqBdx}" >
    <f:facet name="header"><h:outputText value="N° Chq" /></f:facet>
    <h:outputText value="#{table.rglNumChqBdx}" style="width:100px;color:#{table.couleur};" rendered="#{table.rglNumChqBdx!='NULL'}"/>
</rich:column>
