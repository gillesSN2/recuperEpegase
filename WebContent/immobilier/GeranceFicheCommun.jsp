<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<h:panelGrid styleClass="fichefournisseur" width="100%">
    <h:panelGrid  width="100%" columns="2" columnClasses="clos15,clos85">
        <h:column><h:outputText value="Nom Propiétaire"/></h:column>
        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formGeranceImmobilier.bienGeranceEntete.biegerentNomTiers}" disabled="true" readonly="true"></h:inputText></h:column>
    </h:panelGrid>
</h:panelGrid>

<br>
