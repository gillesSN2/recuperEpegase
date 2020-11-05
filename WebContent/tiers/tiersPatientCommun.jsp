<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<h:panelGrid columns="4"  width="100%" styleClass="fichefournisseur">
    <h:column><h:outputText value="Dossier:"/></h:column>
    <h:column><h:inputText  readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patDossier}" style="width:200px;"/></h:column>
    <h:column><h:outputText value="Né(e) le:"/></h:column>
    <h:column><h:inputText  readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patDateNaissance}" style="width:200px;"/></h:column>
    <h:column><h:outputText value="Civilité:"/></h:column>
    <h:column><h:inputText  readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patCivilite}" style="width:200px;"/></h:column>
    <h:column><h:outputText value="Nom et Prénom:"/></h:column>
    <h:column><h:inputText style="width:100%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patNom} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patPrenom}" /></h:column>
</h:panelGrid>
<br>