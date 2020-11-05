<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<h:panelGrid styleClass="fichefournisseur" width="100%" id="idVente">
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBtonAppart}" var="happ">
        <h:panelGrid  width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
            <h:column><h:outputText value="Code bien:"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bienAppartement.bieNum}" readonly="true"/></h:column>
            <h:column><h:outputText value="Libellé bien:"/></h:column>
            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bienAppartement.bieNom}" readonly="true"/></h:column>
            <h:column><h:outputText value="Propriétaire actuel:"/></h:column>
            <h:column><h:inputText style="width:95%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bienAppartement.bieNomTiers}" readonly="true"/></h:column>
        </h:panelGrid>
    </c:if>
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBtonBureau}" var="hbur">
        <h:panelGrid  width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
            <h:column><h:outputText value="Code bien:"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bienBureau.bieNum}" readonly="true"/></h:column>
            <h:column><h:outputText value="Libellé bien:"/></h:column>
            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bienBureau.bieNom}" readonly="true"/></h:column>
            <h:column><h:outputText value="Propriétaire actuel:"/></h:column>
            <h:column><h:inputText style="width:95%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bienBureau.bieNomTiers}" readonly="true"/></h:column>
        </h:panelGrid>
    </c:if>
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBtonPrking}" var="hpak">
        <h:panelGrid  width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
            <h:column><h:outputText value="Code bien:"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bienParking.bieNum}" readonly="true"/></h:column>
            <h:column><h:outputText value="Libellé bien:"/></h:column>
            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bienParking.bieNom}" readonly="true"/></h:column>
            <h:column><h:outputText value="Propriétaire actuel:"/></h:column>
            <h:column><h:inputText style="width:95%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bienParking.bieNomTiers}" readonly="true"/></h:column>
        </h:panelGrid>
    </c:if>
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBtonAppart==false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBtonBureau==false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBtonPrking==false}" var="hbien">
        <h:panelGrid  width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
            <h:column><h:outputText value="Code bien:"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieNum}" readonly="true"/></h:column>
            <h:column><h:outputText value="Libellé bien:"/></h:column>
            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieNom}" readonly="true"/></h:column>
            <h:column><h:outputText value="Propriétaire actuel:"/></h:column>
            <h:column><h:inputText style="width:95%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieNomTiers}" readonly="true"/></h:column>
        </h:panelGrid>
    </c:if>
</h:panelGrid>
<br>
