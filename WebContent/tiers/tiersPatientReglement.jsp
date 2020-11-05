<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="tiersReglement">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>
        <jsp:include flush="true" page="/tiers/tiersPatientCommun.jsp" />
        <h:panelGrid id="preg" width="100%"  headerClass="headerTab" >
            <f:facet name="header"><h:outputText value="Mode de règlement"/></f:facet>
            <h:panelGrid  width="100%" columns="2" id="prest145" columnClasses="clos20,clos80">
                <h:column><h:outputText id="prest146" value="Type Règlement :"/> </h:column>
                <h:column>
                    <h:selectOneMenu style="width:200;" id="regCliItem" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patModereg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                        <f:selectItem itemValue="100" itemLabel="Sélectionez un mode"/>
                        <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.mesReglementClientItems}" />
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="preg" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.calculReglementTiers}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText id="prest149" value="Mode calcul:"/></h:column>
                <h:column>
                    <h:selectOneRadio id="prest150" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patTypereg}" layout="pageDirection" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                        <f:selectItem itemLabel="Paiement comptant" itemValue="0"/>
                        <f:selectItem itemLabel="Paiement terme sur date de facture" itemValue="1"/>
                        <f:selectItem itemLabel="Paiement terme sur fin de mois" itemValue="2"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="preg" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.griserModeCalcul}"  />
                    </h:selectOneRadio>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.testModeCalcul}"><h:outputText id="prest154"value="Nombre de jour:" /></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.testModeCalcul}"><h:inputText id="prest155"size="5"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patNbecheance}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.testModeCalcul}"><h:outputText id="prest156"value="Arrondi:" /></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.testModeCalcul}"><h:inputText id="prest157"size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patNbarrondi}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                <h:column><h:outputText id="prest159"value="Condition règlement:"/></h:column>
                <h:column><h:inputTextarea   cols="70" id="prest160" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patConditionreg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
            </h:panelGrid>

            <h:panelGrid id="infbnq" width="100%" headerClass="headerTab">
                <f:facet name="header"><h:outputText value="Informations bancaires"/></f:facet>
                <h:column>
                    <h:panelGrid  width="100%" columns="1" >
                        <h:column>
                            <h:panelGrid  id="prest113" columns="2" columnClasses="clos20,clos80" width="100%" >
                                <h:column><h:outputText value="Nom banque:"/></h:column>
                                <h:column><h:inputText maxlength="100" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patNomBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Adresse banque:"/></h:column>
                                <h:column><h:inputText maxlength="100" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patAdresseBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Code Banque:"/></h:column>
                                <h:column><h:inputText maxlength="5" size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patNumBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Code Guichet:"/></h:column>
                                <h:column><h:inputText maxlength="5" size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patGuichetBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Numéro Compte:"/></h:column>
                                <h:column><h:inputText maxlength="20" size="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patCompteBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Clé RIB:"/></h:column>
                                <h:column><h:inputText maxlength="2" size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patCleBanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="IBAN:"/></h:column>
                                <h:column><h:inputText maxlength="34" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patIban}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                                <h:column><h:outputText value="SWIFT:"/></h:column>
                                <h:column><h:inputText maxlength="20" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patSwift}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
                            </h:panelGrid>
                        </h:column>
                    </h:panelGrid>
                </h:column>
            </h:panelGrid>

        </h:panelGrid>
    </a4j:form>

</f:subview>