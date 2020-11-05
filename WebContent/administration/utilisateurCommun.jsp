<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<h:panelGrid columns="4" width="100%" styleClass="fichefournisseur">
    <h:column><h:outputText value="Groupe:"/></h:column>
    <h:column><h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.groupe.grpCode}" style="width:200px;"/></h:column>
    <h:column><h:outputText value="Nom et Prénom(s):"/></h:column>
    <h:column><h:inputText style="width:100%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrNom} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.newUser.usrPrenom}"/></h:column>
</h:panelGrid>
<br>