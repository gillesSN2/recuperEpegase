<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="fichepointage1">

    <a4j:form >

        <center> <h2><h:outputText value="SAISIE POINTAGE (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.salaries.patronyme} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.periode})" styleClass="titre"/></h2></center>

        <h:panelGrid id="panelGlobal" width="100%" >

            <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" id="idPanelSaisie">
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.optionPaye.temps=='1'}"><h:outputText value="Contrat:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.optionPaye.temps=='1'}">
                    <h:selectOneMenu style="width:150px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.salariesPointage.salpoiContrat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_aff_action}">
                        <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.lesContratsActifsItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Jour:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.jour}" style="width:150px;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_aff_action}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.lesjoursItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Nb d'heures:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.salariesPointage.salpoiDuree}"  style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_aff_action}">
                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Description:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.salariesPointage.salpoiObjet}" style="width:100%;" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_aff_action}"/></h:column>
            </h:panelGrid>

            <h:panelGroup id="panelValide">
                <center>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.annulerPointage}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.savePointage}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action!=3}"/>
                </center>
            </h:panelGroup>
        </h:panelGrid>

    </a4j:form>

</f:subview>
