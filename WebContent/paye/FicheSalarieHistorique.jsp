<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>



<h:panelGrid style="width:100%;">
    <h:panelGrid columns="2" styleClass="fichefournisseur" columnClasses="clos30,clos70" width="100%" >
        <h:column><h:outputText value="Rubrique:"/></h:column>
        <h:column>
            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesHistorique.salhisCode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_historique==3}">
                <f:selectItem itemLabel="Sélectionnez une rubrique" itemValue=""/>
                <f:selectItem itemLabel="Salaire Brut" itemValue="BRUT"/>
                <f:selectItem itemLabel="Congés Payés" itemValue="CP"/>
                <f:selectItem itemLabel="Nombre de jours de congés acquis" itemValue="NBJS"/>
                <f:selectItem itemLabel="Appoint dernier mois" itemValue="ADM"/>
                <f:selectItem itemLabel="Primes imposables à déduire des CP" itemValue="PRDCP"/>
                <f:selectItem itemLabel="Base CP si rubiques choisies" itemValue="BASECP"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.verifUniciteRubrique}" reRender="panHisto,idValHistorique"/>
            </h:selectOneMenu>
        </h:column>
    </h:panelGrid>
    <h:panelGrid columns="2" id="idHistorique" styleClass="fichefournisseur1" columnClasses="clos30,clos70" width="100%" >
        <h:column><h:outputText value="Date historique (JJ/MM/AAAA):"/></h:column>
        <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesHistorique.salhisDate}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_historique==3}"/></h:column>
        <h:column><h:outputText value="Contrat:"/></h:column>
        <h:column>
            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesHistorique.salhisContrat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_historique==3}">
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.lesContratsActifsItems}"/>
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText value="Valeur:"/></h:column>
        <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesHistorique.salhisValeurColE}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_historique==3}" style="text-align:right;"/></h:column>
    </h:panelGrid>
</h:panelGrid>