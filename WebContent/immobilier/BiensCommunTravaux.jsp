<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>

<a4j:region renderRegionOnly="false">
    <rich:extendedDataTable styleClass="bg" id="tableTravaux" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="400px" footerClass="bard" headerClass="headerTab" enableContextMenu="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.dataModelTravaux}" var="trv">
        <rich:column label="Numéro de l'OT" sortable="true" width="100px" sortBy="#{trv.bietraentNum}">
            <f:facet name="header"><h:outputText  value="N° OT" /></f:facet>
            <h:outputText value="#{trv.bietraentNum}"/>
        </rich:column>
        <rich:column label="Date début de l'OT" sortable="true" width="100px" sortBy="#{trv.bietraentDateDebut}">
            <f:facet name="header"><h:outputText  value="Début" /></f:facet>
            <h:outputText value="#{trv.bietraentDateDebut}">
                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
            </h:outputText>
        </rich:column>
        <rich:column label="Objet des travaux" sortable="true" width="300px" sortBy="#{trv.bietraentObjet}">
            <f:facet name="header"><h:outputText  value="Objet" /></f:facet>
            <h:outputText value="#{trv.bietraentObjet}"/>
        </rich:column>
        <rich:column label="Date fin de l'OT" sortable="true" width="100px" sortBy="#{trv.bietraentDateFin}">
            <f:facet name="header"><h:outputText  value="Fin" /></f:facet>
            <h:outputText value="#{trv.bietraentDateFin}">
                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
            </h:outputText>
        </rich:column>
        <rich:column label="Date controle" sortable="true" width="100px" sortBy="#{trv.bietraentDateCtrl}">
            <f:facet name="header"><h:outputText  value="Date Ctrl" /></f:facet>
            <h:outputText value="#{trv.bietraentDateCtrl}">
                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
            </h:outputText>
        </rich:column>
        <rich:column label="Rapport controle" sortable="true" width="150px" sortBy="#{trv.bietraentRapportCtrl}">
            <f:facet name="header"><h:outputText  value="Controle" /></f:facet>
            <h:outputText value="#{trv.bietraentRapportCtrl}"/>
        </rich:column>
        <rich:column label="Nom du controleur" sortable="true" width="200px" sortBy="#{trv.bietraentNomCtrl}">
            <f:facet name="header"><h:outputText  value="Controleur" /></f:facet>
            <h:outputText value="#{trv.bietraentNomCtrl}"/>
        </rich:column>
    </rich:extendedDataTable>
</a4j:region>
