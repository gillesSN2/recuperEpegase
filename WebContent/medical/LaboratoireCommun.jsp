<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<h:panelGrid styleClass="fichefournisseur" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
    <h:column><h:outputText value="Date:"/></h:column>
    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labDate}" readonly="true"/></h:column>
    <h:column><h:outputText value="N° Labo.:"/></h:column>
    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labNum}" readonly="true"/></h:column>
    <h:column><h:outputText value="Dossier:" /></h:column>
    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patients.patDossier}" readonly="true"/></h:column>
    <h:column><h:outputText value="Nom Patient:" /></h:column>
    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labNomPatient}" readonly="true"/></h:column>
    <h:column><h:outputText value="Né(e) le:" /></h:column>
    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patients.patDateNaissance}" readonly="true"/></h:column>
    <h:column><h:outputText value="Genre:" /></h:column>
    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patients.patSexe}"  disabled="true">
        <f:selectItem itemLabel="Femme" itemValue="0"/>
        <f:selectItem itemLabel="Homme" itemValue="1"/>
    </h:selectOneRadio>
</h:panelGrid>
<br>