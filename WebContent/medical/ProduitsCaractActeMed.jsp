<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<h:panelGrid columns="2" columnClasses="clos15,clos85" width="100%">
    <h:outputText value="Sélection mode:" style="color:red"/>
    <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proMode}" style="color:red" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
        <f:selectItem itemLabel="Acte standard" itemValue="0"/>
        <f:selectItem itemLabel="Acte Dentaire" itemValue="1"/>
    </h:selectOneRadio>
    <h:outputText value="Sélection Délais de grâce:" style="color:red"/>
    <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proGrace}" style="color:red" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
        <f:selectItem itemLabel="Sans délais de grâce" itemValue="0"/>
        <f:selectItem itemLabel="Avec délais de grâce" itemValue="1"/>
    </h:selectOneRadio>
    <h:outputText value="Hiérarchie:"/>
    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsActe.proactHierarchie}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/>
    <h:outputText value="Rang:"/>
    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsActe.proactRang}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/>
    <h:outputText value="Position:"/>
    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsActe.proactPosition}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/>
    <h:outputText value="Y:"/>
    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsActe.proactY}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/>
    <h:outputText value="ICR:"/>
    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsActe.proactIcr}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/>
    <h:outputText value="PARA:"/>
    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsActe.proactPara}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/>
    <h:outputText value="A:"/>
    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsActe.proactA}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/>
    <h:outputText value="B:"/>
    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsActe.proactB}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/>
    <h:outputText value="CC:"/>
    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsActe.proactCc}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/>
    <h:outputText value="SCORE:"/>
    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsActe.proactScore}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/>
    <h:outputText value="Observations:"/>
    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsActe.proactObservations}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/>
</h:panelGrid>

