<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<h:panelGrid styleClass="fichefournisseur" width="100%">
    <h:panelGrid  width="100%" columns="2" columnClasses="clos60g,clos40">
        <h:panelGrid  width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
            <h:column><h:outputText value="Date:"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvDate}" readonly="true"/></h:column>
            <h:column><h:outputText value="N°:"/></h:column>
            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvNum}" readonly="true"/></h:column>
            <h:column><h:outputText value="Chantier:"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvChantier}" readonly="true"/></h:column>
        </h:panelGrid>

    </h:panelGrid>
</h:panelGrid>

<br>
