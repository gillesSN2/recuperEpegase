<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="tiersPatientGrS">

    <jsp:include flush="true" page="/tiers/tiersPatientCommun.jsp" />
    <h:panelGrid  columns="2" width="100%" style="border:1px solid black" columnClasses="clos50g,clos50g">

        <h:panelGrid width="100%" headerClass="headerTab" columnClasses="cols,cols" style="background-color:#EDFEDE;vertical-align:top;" columns="2">
          <f:facet name="header"><h:outputText  value="1er prélèvement" /></f:facet>
            <h:column>
                <h:panelGrid columns="1" width="100%">
                    <h:column rendered="false">
                        <a4j:commandButton  title="Imprimer" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImpLettremed');"/>
                    </h:column>
                </h:panelGrid>
                <br>
                <h:panelGrid columns="2" width="100%" columnClasses="clos50d,clos50g">
                    <h:column><h:outputText value="Date 1er prélèvement:"/></h:column>
                    <a4j:outputPanel layout="block">
                        <rich:calendar style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patDatePrelev1}" popup="true"  inputSize="8" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/>
                    </a4j:outputPanel>
                </h:panelGrid>
                <h:panelGrid columns="2" width="100%" columnClasses="clos50d,clos50g">
                    <h:column><h:outputText value="GROUPE:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patGroupe1}" size="5" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                </h:panelGrid>
                <h:panelGrid columns="2" width="100%" columnClasses="clos50d,clos50g">
                    <h:column><h:outputText  value="RHESUS:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patRhesus1}" size="5" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                </h:panelGrid>
            </h:column>
            <h:column>
                <h:panelGrid columns="1">
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_D1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/>D</h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_C1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/>C</h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_Cc1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/>c</h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_E1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/>E</h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_Ee1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/>e</h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_Cde1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/>CDE</h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_K1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/>K</h:column>
                </h:panelGrid>
            </h:column>
        </h:panelGrid>

        <h:panelGrid width="100%" headerClass="headerTab" columnClasses="cols,cols" style="background-color:##FFF8D4;vertical-align:top;" columns="2">
            <f:facet name="header"><h:outputText  value="2eme prélèvement" /></f:facet>
            <h:column>
                <h:panelGrid  columns="1" width="100%">
                    <h:column rendered="false">
                        <a4j:commandButton title="Imprimer" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImpLettremed');"/>
                    </h:column>
                </h:panelGrid>
                <br>
                <h:panelGrid columns="2" width="100%" columnClasses="clos50d,clos50g">
                    <h:column><h:outputText value="Date 2eme prélèvement:"/></h:column>
                    <a4j:outputPanel layout="block">
                        <rich:calendar style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patDatePrelev2}" popup="true"  inputSize="8" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/>
                    </a4j:outputPanel>
                </h:panelGrid>
                <h:panelGrid columns="2" width="100%" columnClasses="clos50d,clos50g">
                    <h:column><h:outputText value="GROUPE:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patGroupe2}" size="5" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                </h:panelGrid>
                <h:panelGrid columns="2" width="100%" columnClasses="clos50d,clos50g">
                    <h:column><h:outputText value="RHESUS:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patRhesus2}" size="5" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                </h:panelGrid>
            </h:column>
            <h:column>
                <h:panelGrid columns="1">
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_D2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/>D</h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_C2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/>C</h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_Cc2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/>c</h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_E2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/>E</h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_Ee2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/>e</h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_Cde2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/>CDE</h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_K2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/>K</h:column>
                </h:panelGrid>
            </h:column>
        </h:panelGrid>

    </h:panelGrid>

</f:subview>