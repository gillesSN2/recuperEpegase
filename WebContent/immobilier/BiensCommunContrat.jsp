<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>

<a4j:region renderRegionOnly="false">
    <rich:extendedDataTable styleClass="bg" id="tableContrat" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="400px" footerClass="bard" headerClass="headerTab" enableContextMenu="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.dataModelBaux}" var="var">
        <rich:column label="Etat du bail" sortable="true" width="100px" sortBy="#{var.libelleEtat}">
            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
            <h:outputText value="#{var.libelleEtat}"/>
        </rich:column>
        <rich:column label="Numéro du bail" sortable="true" width="70px" sortBy="#{var.biebaiNum}">
            <f:facet name="header"><h:outputText  value="N°" /></f:facet>
            <h:outputText value="#{var.biebaiNum}"/>
        </rich:column>
        <rich:column label="Nom du locataire" sortable="true" width="200px" sortBy="#{var.biebaiNomTiers}">
            <f:facet name="header"><h:outputText  value="Locataire" /></f:facet>
            <h:outputText value="#{var.biebaiNomTiers}"/>
        </rich:column>
        <rich:column label="Date début établissement" sortable="true" width="100px" sortBy="#{var.biebaiDate}">
            <f:facet name="header"><h:outputText  value="Etabli" /></f:facet>
            <h:outputText value="#{var.biebaiDate}">
                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
            </h:outputText>
        </rich:column>
        <rich:column label="Date début bail" sortable="true" width="100px" sortBy="#{var.biebaiDateDebut}">
            <f:facet name="header"><h:outputText  value="Début" /></f:facet>
            <h:outputText value="#{var.biebaiDateDebut}">
                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
            </h:outputText>
        </rich:column>
        <rich:column label="Date fin du bail" sortable="true" width="100px" sortBy="#{var.biebaiDateFin}">
            <f:facet name="header"><h:outputText  value="Fin" /></f:facet>
            <h:outputText value="#{var.biebaiDateFin}">
                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
            </h:outputText>
        </rich:column>
        <rich:column label="Mode de facturation" sortable="true" width="100px" sortBy="#{var.libelleMode}">
            <f:facet name="header"><h:outputText  value="Mode" /></f:facet>
            <h:outputText value="#{var.libelleMode}"/>
        </rich:column>
        <rich:column label="Usage" sortable="true" width="100px" sortBy="#{var.libelleUsage}">
            <f:facet name="header"><h:outputText  value="Usage" /></f:facet>
            <h:outputText value="#{var.libelleUsage}"/>
        </rich:column>
        <rich:column label="Montant Loyer" sortable="true" width="100px" sortBy="#{var.biebaiLoyerNet}" style="text-align:right">
            <f:facet name="header"><h:outputText  value="Loyer" /></f:facet>
            <h:outputText value="#{var.biebaiLoyerNet}" rendered="#{var.biebaiLoyerNet!=0}" >
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
            </h:outputText>
        </rich:column>
        <rich:column label="Montant Charges" sortable="true" width="100px" sortBy="#{var.biebaiCharges}" style="text-align:right">
            <f:facet name="header"><h:outputText  value="Charges" /></f:facet>
            <h:outputText value="#{var.biebaiCharges}" rendered="#{var.biebaiCharges!=0}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
            </h:outputText>
        </rich:column>
    </rich:extendedDataTable>
</a4j:region>

