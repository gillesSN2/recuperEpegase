<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<jsp:include flush="true" page="/tiers/tiersCommun.jsp" />
<h:panelGrid id="preg" width="100%"  headerClass="headerTab" >
    <f:facet name="header"><h:outputText value="Mode de règlement"/></f:facet>
    <h:panelGrid  width="100%" columns="2" id="prest145" columnClasses="clos20,clos80">
        <h:column><h:outputText id="prest146" value="Type Règlement :"/> </h:column>
        <h:column>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietype==0}" >
                <h:selectOneMenu style="width:200px;" id="regFouItem" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiemodereg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                    <f:selectItem itemValue="100" itemLabel="Sélectionez un mode"/>
                    <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesReglementFournisseurItems}" />
                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="preg" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.calculReglementTiers}" />
                </h:selectOneMenu>
            </c:if>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietype!=0}" >
                <h:selectOneMenu style="width:200px;" id="regCliItem" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiemodereg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                    <f:selectItem itemValue="100" itemLabel="Sélectionez un mode"/>
                    <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesReglementClientItems}" />
                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="preg" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.calculReglementTiers}" />
                </h:selectOneMenu>
            </c:if>
        </h:column>
        <h:column><h:outputText id="prest149" value="Mode calcul:"/></h:column>
        <h:column>
            <h:selectOneRadio id="prest150" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietypereg}" layout="pageDirection" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                <f:selectItem itemLabel="Paiement comptant" itemValue="0"/>
                <f:selectItem itemLabel="Paiement terme sur date de facture" itemValue="1"/>
                <f:selectItem itemLabel="Paiement terme sur fin de mois" itemValue="2"/>
                <a4j:support eventsQueue="maQueue" event="onchange" reRender="preg"/>
            </h:selectOneRadio>
        </h:column>
        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietypereg>=1}"><h:outputText id="prest154"value="Nombre de jour:" /></h:column>
        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietypereg>=1}"><h:inputText id="prest155"size="5"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienbecheance}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietypereg>=1}"><h:outputText id="prest156"value="Arrondi:" /></h:column>
        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietypereg>=1}"><h:inputText id="prest157"size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienbarrondi}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
        <h:column rendered="false"><h:outputText id="prest169"value="Journal de règlement:"/></h:column>
        <h:column rendered="false"><h:inputText id="prest170" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiejournalreg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
        <h:column><h:outputText id="prest159"value="Condition règlement:"/></h:column>
        <h:column><h:inputTextarea   cols="70" id="prest160" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieconditionreg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
        <h:column><h:outputText value="Solde déposit/ristourne:"/></h:column>
        <h:column>
            <h:inputText size="10" style="text-align:right" id="idSoldeDepot" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiedepotavance}" readonly="true">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
            </h:inputText>&nbsp;&nbsp;&nbsp;&nbsp;
            <a4j:commandButton value="Affiche Détail" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.detailDepotAvance}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelDepot,histo,idSoldeDepot"/>
        </h:column>
    </h:panelGrid>

    <h:panelGrid id="infbnq" width="100%" headerClass="headerTab">
        <f:facet name="header"><h:outputText value="Informations bancaires"/></f:facet>
        <h:column>
            <h:panelGrid  width="100%" columns="1" >
                <h:column>
                    <h:panelGrid  id="prest113" columns="2" columnClasses="clos20,clos80" width="100%" >
                        <h:column><h:outputText value="Nom banque:"/></h:column>
                        <h:column><h:inputText  maxlength="100" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienombanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Adresse banque:"/></h:column>
                        <h:column><h:inputText  maxlength="100" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieadressebanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Code Banque:"/></h:column>
                        <h:column><h:inputText  maxlength="5" size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienumbanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Code Guichet:"/></h:column>
                        <h:column><h:inputText  maxlength="5" size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieguichetbanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Numéro Compte:"/></h:column>
                        <h:column><h:inputText  maxlength="20" size="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecomptebanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Clé RIB:"/></h:column>
                        <h:column><h:inputText  maxlength="2" size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieclebanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                        <h:column><h:outputText value="IBAN:"/></h:column>
                        <h:column><h:inputText  maxlength="34" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieiban}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                        <h:column><h:outputText value="SWIFT:"/></h:column>
                        <h:column><h:inputText  maxlength="20" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieswift}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                    </h:panelGrid>
                </h:column>
            </h:panelGrid>
        </h:column>
    </h:panelGrid>

</h:panelGrid>



