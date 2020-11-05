<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<h:panelGrid columns="6" styleClass="fichefournisseur" width="100%">
    <h:column><h:outputText value="Mat.:"/></h:column>
    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salMatricule}" disabled="true"/></h:column>
    <h:column><h:outputText value="Nom:"/></h:column>
    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salNom}" disabled="true"/></h:column>
    <h:column><h:outputText value="Prénom:"/></h:column>
    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.salaries.salPrenom}" disabled="true"/></h:column>
</h:panelGrid>
<br>