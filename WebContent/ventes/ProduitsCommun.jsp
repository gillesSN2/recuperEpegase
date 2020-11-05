<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<h:panelGrid columns="4" width="100%" styleClass="fichefournisseur">
    <h:column><h:outputText value="Code produit:"/></h:column>
    <h:column><h:inputText  readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proCode}" style="width:200px;"/></h:column>
    <h:column><h:outputText value="Libellé client:"/></h:column>
    <h:column><h:inputText size="60" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proLibClient}" /></h:column>
</h:panelGrid>
<br>
