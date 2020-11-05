<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>

<a4j:region renderRegionOnly="false">
    <rich:extendedDataTable styleClass="bg" id="tableGerance" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="400px" footerClass="bard" headerClass="headerTab" enableContextMenu="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.dataModelGerance}" var="ger">
        <rich:column label="Etat du contrat" sortable="true" width="100px" sortBy="#{ger.BienGeranceEntete.libelleEtat}">
            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
            <h:outputText value="#{ger.BienGeranceEntete.libelleEtat}"/>
        </rich:column>
        <rich:column label="Numéro du contrat" sortable="true" width="70px" sortBy="#{ger.BienGeranceEntete.biegerentNum}">
            <f:facet name="header"><h:outputText  value="N°" /></f:facet>
            <h:outputText value="#{ger.BienGeranceEntete.biegerentNum}"/>
        </rich:column>
        <rich:column label="Nom du propriétaire" sortable="true" width="200px" sortBy="#{ger.BienGeranceEntete.biegerentNomTiers}">
            <f:facet name="header"><h:outputText  value="Propriétaire" /></f:facet>
            <h:outputText value="#{ger.BienGeranceEntete.biegerentNomTiers}"/>
        </rich:column>
        <rich:column label="Date établissement" sortable="true" width="100px" sortBy="#{ger.BienGeranceEntete.biegerentDateSignature}">
            <f:facet name="header"><h:outputText  value="Etabli" /></f:facet>
            <h:outputText value="#{ger.BienGeranceEntete.biegerentDateSignature}">
                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
            </h:outputText>
        </rich:column>
        <rich:column label="Date début contrat" sortable="true" width="100px" sortBy="#{ger.BienGeranceEntete.biegerentDateDebut}">
            <f:facet name="header"><h:outputText  value="Début" /></f:facet>
            <h:outputText value="#{ger.BienGeranceEntete.biegerentDateDebut}">
                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
            </h:outputText>
        </rich:column>
        <rich:column label="Date fin du contrat" sortable="true" width="100px" sortBy="#{ger.BienGeranceEntete.biegerentDateFin}">
            <f:facet name="header"><h:outputText  value="Fin" /></f:facet>
            <h:outputText value="#{ger.BienGeranceEntete.biegerentDateFin}">
                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
            </h:outputText>
        </rich:column>
        <rich:column label="Base Loyer" sortable="true" width="100px" sortBy="#{ger.biegerligLoyerBrut}" style="text-align:right">
            <f:facet name="header"><h:outputText  value="Base Loyer" /></f:facet>
            <h:outputText value="#{ger.biegerligLoyerBrut}" rendered="#{ger.biegerligLoyerBrut!=0}" >
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
            </h:outputText>
        </rich:column>
        <rich:column label="Loyer net" sortable="true" width="100px" sortBy="#{ger.biegerligLoyerNet}" style="text-align:right">
            <f:facet name="header"><h:outputText  value="Loyer Net" /></f:facet>
            <h:outputText value="#{ger.biegerligLoyerNet}" rendered="#{ger.biegerligLoyerNet!=0}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
            </h:outputText>
        </rich:column>
    </rich:extendedDataTable>
</a4j:region>

