<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<h:panelGrid columns="4" width="100%" styleClass="fichefournisseur">
    <h:column><h:outputText value="Code groupe:"/></h:column>
    <h:column><h:inputText  readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpCode}" style="width:200px;"/></h:column>
    <h:column><h:outputText value="Libellé groupe:"/></h:column>
    <h:column><h:inputText style="width:100%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpLibelle}"/></h:column>
</h:panelGrid>
<br>