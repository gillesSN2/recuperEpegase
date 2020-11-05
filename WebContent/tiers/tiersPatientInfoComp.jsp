<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="tiersPatientInC">

    <jsp:include flush="true" page="/tiers/tiersPatientCommun.jsp" />
    <h:panelGrid border="0" columns="2" columnClasses="rows1,rowsd" styleClass="fichefournisseur" headerClass="header" width="100%" >
        <h:panelGrid >
            <rich:column>
                <f:facet name="header">Situation de famille</f:facet>
                <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patSitFam}" layout="pageDirection" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                    <f:selectItem itemValue="0" itemLabel="Non signalé"/>
                    <f:selectItem itemValue="1" itemLabel="Célibataire"/>
                    <f:selectItem itemValue="2" itemLabel="Marié(e)"/>
                    <f:selectItem itemValue="3" itemLabel="Veuf(Ve)"/>
                    <f:selectItem itemValue="4" itemLabel="Divorcé(e)"/>
                    <f:selectItem itemValue="5" itemLabel="Concubin(e)"/>
                </h:selectOneRadio>
            </rich:column>
        </h:panelGrid>
        <h:panelGrid>
            <rich:column>
                <f:facet name="header">Habitat</f:facet>
                <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patHabitat}" layout="pageDirection" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                    <f:selectItem itemValue="0" itemLabel="Non signalé"/>
                    <f:selectItem itemValue="1" itemLabel="Nomade"/>
                    <f:selectItem itemValue="2" itemLabel="Rural"/>
                    <f:selectItem itemValue="3" itemLabel="Semi-rural"/>
                    <f:selectItem itemValue="4" itemLabel="Urbain"/>
                </h:selectOneRadio>
            </rich:column>
        </h:panelGrid>
    </h:panelGrid>

    <h:panelGrid columns="4" width="100%" styleClass="fichefournisseur1" columnClasses="clos15,clos35,clos15,clos35">
        <h:column><h:outputText value="Nationnalité:"/></h:column>
        <h:column>
            <h:selectOneMenu id="natioItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patPaysNaissance}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}">
                <f:selectItems id="paysItem" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesPaysItems}" />
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText value="Reigion"/></h:column>
        <h:column><h:inputText style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patReligion}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
        <h:column><h:outputText value="Secteur d'activité:"/></h:column>
        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patSecteurActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
        <h:column><h:outputText value="Profession:"/></h:column>
        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patProfession}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
        <h:column><h:outputText value="Poste de travail:"/></h:column>
        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patProfObs}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
        <h:column><h:outputText value="Date embauche (JJ/MM/AAAA)"/></h:column>
        <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patDateEmbauche}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
        <h:column><h:outputText value="Nb enfants:"/></h:column>
        <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patNbEnfant}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
        <h:column><h:outputText value=""/></h:column>
        <h:column><h:outputText value=""/></h:column>
        <h:column><h:outputText value="Nom de la mère:"/></h:column>
        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patNomMere}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
        <h:column><h:outputText value="Nom du père:"/></h:column>
        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patNomPere}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
        <h:column>
            <h:outputText value="Profession mère:" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.infirmerie}"/>
            <h:outputText value="Service:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.infirmerie}"/>
        </h:column>
        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patZone}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
        <h:column>
            <h:outputText value="Profession père:" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.infirmerie}"/>
            <h:outputText value="Affectation:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.infirmerie}"/>
        </h:column>
        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patLot}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.infirmerie}"><h:outputText value="Site:"/></h:column>
        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.infirmerie}"><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patCommune}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
        <h:column><h:outputText value="Département:"/></h:column>
        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patDepart}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
    </h:panelGrid>
    <h:panelGrid columns="2" width="100%" columnClasses="clos15,clos85" styleClass="fichefournisseur">
        <h:column><h:outputText value="Observations:"/></h:column>
        <h:column><h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patObservations}" rows="5" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
    </h:panelGrid>
    <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur1">
        <h:column><h:outputText value="Tél. bureau1:"/></h:column>
        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patBurTel1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
        <h:column><h:outputText value="Tél. bureau2:"/></h:column>
        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patBurTel2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
        <h:column><h:outputText value="Fax:"/></h:column>
        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patBurFax}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
        <h:column><h:outputText value="Tel.Voiture:"/></h:column>
        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patTelVoiture}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==3}"/></h:column>
    </h:panelGrid>

</f:subview>