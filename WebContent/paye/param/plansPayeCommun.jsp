<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<h:panelGrid columns="6" style="width:100%;" styleClass="fichefournisseur">
    <h:column><h:outputText value="Code rubrique:"/></h:column>
    <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpCode}" disabled="true"/></h:column>
    <h:column><h:outputText value="Intitulé Rubrique:"/></h:column>
    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanPaye.planPaye.plpLibelleFR}"disabled="true"/></h:column>
</h:panelGrid>
<br>