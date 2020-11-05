<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<h:panelGrid styleClass="fichefournisseur" width="100%">
    <h:panelGrid  width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
        <h:column><h:outputText value="Numéro Bail"/></h:column>
        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiNum}" disabled="true" readonly="true"></h:inputText></h:column>
        <h:column><h:outputText value="Etabli le"/></h:column>
        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiDate}" disabled="true" readonly="true"></h:inputText></h:column>
        <h:column><h:outputText value="Nom Locataire"/></h:column>
        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiNomTiers}" disabled="true" readonly="true"></h:inputText></h:column>
        <h:column><h:outputText value="Désignation Local"/></h:column>
        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bien.bieNom}" disabled="true" readonly="true"></h:inputText></h:column>
    </h:panelGrid>
</h:panelGrid>

<br>
