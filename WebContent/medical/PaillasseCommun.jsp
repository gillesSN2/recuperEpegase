<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<h:panelGrid styleClass="fichefournisseur" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
    <h:column><h:outputText value="Date:"/></h:column>
    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labDate}" readonly="true"/></h:column>
    <h:column><h:outputText value="N°:"/></h:column>
    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labNum}" readonly="true"/></h:column>
    <h:column><h:outputText value="Série:" /></h:column>
    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labSerie}" readonly="true"/></h:column>
    <h:column><h:outputText value="Nom Patient:" /></h:column>
    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.nom_anonyme}" readonly="true" style="width:100%"/></h:column>
    <h:column><h:outputText value="Né(e) le:" /></h:column>
    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patients.patDateNaissance}" readonly="true"/></h:column>
    <h:column><h:outputText value="Genre:" /></h:column>
    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patients.patSexe}" disabled="true">
        <f:selectItem itemLabel="Femme" itemValue="0"/>
        <f:selectItem itemLabel="Homme" itemValue="1"/>
    </h:selectOneRadio>
    <h:column><h:outputText value="Code:" /></h:column>
    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligProduit}" readonly="true" style="width:100%"/></h:column>
    <h:column><h:outputText value="Examen:" /></h:column>
    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligLibelle}" readonly="true" style="width:100%"/></h:column>
    <h:column><h:outputText value="Famille:" /></h:column>
    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligFamille}" readonly="true"/></h:column>
    <h:column><h:outputText value="Technique utilisée"/></h:column>
    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresTechnique}" readonly="true" style="width:100%"/></h:column>
    <h:column><h:outputText value="Norme"/></h:column>
    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresNorme}" readonly="true" style="width:100%"/></h:column>
    <h:column><h:outputText value="Appareil d'analyse"/></h:column>
    <h:column>
        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligAppareil}" style="width:100%;">
            <f:selectItem itemLabel="Appareil non spécifié" itemValue=""/>
            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.lesAppareilsItems}"/>
        </h:selectOneMenu>
    </h:column>
</h:panelGrid>
<br>