<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h:panelGrid styleClass="fichefournisseur" width="100%">
    <h:panelGrid  width="100%" columns="2" columnClasses="clos60g,clos40">
        <h:column>
            <h:panelGrid  width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                <h:column><h:outputText value="Date:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotDate}" readonly="true"/></h:column>
                <h:column><h:outputText value="N°:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.ecrnotNum}" readonly="true"/></h:column>
                <h:column><h:outputText value="Catégorie:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.ecrituresNotes.libelleCategorie}" readonly="true"/></h:column>
            </h:panelGrid>
        </h:column>
    </h:panelGrid>
</h:panelGrid>

<br>
