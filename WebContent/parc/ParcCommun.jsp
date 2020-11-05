<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<h:panelGrid style="background-color:#DAEECB;" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
    <h:column><h:outputText style="text-decoration:underline;" value="Nature:"/></h:column>
    <h:column>
        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_nature}" disabled="true">
            <f:selectItem itemLabel="Sélectionnez une nature" itemValue="100"/>
            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.mesNatureItems}" />
        </h:selectOneMenu>
    </h:column>
    <h:column><h:outputText value="N° immat./ID:"/></h:column>
    <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcImmatriculation}" disabled="true"/></h:column>
    <h:column><h:outputText style="text-decoration:underline;" value="Famille:"/></h:column>
    <h:column>
        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_famille}" disabled="true">
            <f:selectItem itemLabel="Sélectionnez une famille" itemValue="100"/>
            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.mesFamilleItems}" />
        </h:selectOneMenu>
    </h:column>
    <h:column><h:outputText style="text-decoration:underline;" value="Sous famille:"/></h:column>
    <h:column>
        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_sousFamille}" disabled="true">
            <f:selectItem itemLabel="Sélectionnez une sous famille" itemValue="100"/>
            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.mesSousFamilleItems}" />
        </h:selectOneMenu>
    </h:column>
    <h:column><h:outputText value="Marque:"/></h:column>
    <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcMarque}" disabled="true"/></h:column>
    <h:column><h:outputText value="Origine:"/></h:column>
    <h:column>
        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcOrigine}" disabled="true">
            <f:selectItem itemLabel="Interne" itemValue="0"/>
            <f:selectItem itemLabel="Externe" itemValue="1"/>
            <f:selectItem itemLabel="Fabriqué" itemValue="2"/>
        </h:selectOneMenu>
    </h:column>
</h:panelGrid>

<br>
