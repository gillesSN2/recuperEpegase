<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<h:panelGrid columns="4" width="100%" styleClass="fichefournisseur" headerClass="headerTab">
    <f:facet name="header"><h:outputText value="ASSURE PRINCIPAL"/></f:facet>
    <h:column><h:outputText value="Dossier:"/></h:column>
    <h:column><h:inputText  readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAssure.patDossier}" style="width:200px;"/></h:column>
    <h:column><h:outputText value="Né(e) le:"/></h:column>
    <h:column><h:inputText  readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAssure.patDateNaissance}" style="width:200px;"/></h:column>
    <h:column><h:outputText value="Civilité:"/></h:column>
    <h:column><h:inputText  readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAssure.patCivilite}" style="width:200px;"/></h:column>
    <h:column><h:outputText value="Nom et Prénom:"/></h:column>
    <h:column><h:inputText style="width:100%" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAssure.patNom} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAssure.patPrenom}" /></h:column>
</h:panelGrid>

<h:panelGrid columns="4"  width="100%" styleClass="fichefournisseur" headerClass="headerTab">
    <f:facet name="header"><h:outputText value="PRISE EN CHARGE"/></f:facet>
    <h:panelGrid  columns="1" style="width:100%;" id="idPanelGlobal">
        <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35"width="100%" styleClass="fichefournisseur" id="idPanelPec">
            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays!='0077'}"><h:outputText value="N° de sécurité:"/></h:column>
            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:outputText value="N° CNSS:"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecNumCnss}" style="width:100%;" readonly="true" disabled="true"/></h:column>
            <h:column><h:outputText value="N° CNAMGS:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecNumCnamgs}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}" style="width:95%;" readonly="true" disabled="true"/></h:column>
            <h:column><h:outputText value="Utilisateur Payeur:"/></h:column>
            <h:column>
                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAssure.patIdUserPaiement}" readonly="true" disabled="true">
                    <f:selectItem itemLabel="Sans User payeur" itemValue="0"/>
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesUserItems}" />
                </h:selectOneMenu>
            </h:column>
            <h:column><h:outputText value="Salarié Payeur:"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientsAssure.patSalariePaiement}" style="width:95%;" maxlength="20" readonly="true" disabled="true"/></h:column>
            <h:column><h:outputText value="Choix Tiers"/></h:column>
            <h:column>
                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecType}" readonly="true" disabled="true">
                    <f:selectItem itemLabel="Assurance" itemValue="Assurance"/>
                    <f:selectItem itemLabel="IPM" itemValue="IPM"/>
                    <f:selectItem itemLabel="Mutuelle" itemValue="Mutuelle"/>
                    <f:selectItem itemLabel="Complémentaire" itemValue="Complémentaire"/>
                    <f:selectItem itemLabel="Programme Médical" itemValue="Programme Médical"/>
                    <f:selectItem itemLabel="Client Société" itemValue="Client Société"/>
                </h:selectOneMenu>
            </h:column>
            <h:column><h:outputText value="Tiers payeur:"/></h:column>
            <h:column><h:inputText style="width:95%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_tiers}" readonly="true" disabled="true"/></h:column>
            <h:column><h:outputText value=""/></h:column>
            <h:column><h:outputText value=""/></h:column>
            <h:column><h:outputText value="Employeur:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecType=='Assurance'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecType=='IPM'}"/></h:column>
            <h:column><h:inputText style="width:95%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecNomEmployeur}" readonly="true" disabled="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecType=='Assurance'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecType=='IPM'}"/></h:column>
            <h:column><h:outputText value="N° contrat:"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecNumContrat}" readonly="true" disabled="true"/></h:column>
            <h:column><h:outputText value="N° Immat. Assuré"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecMatriculeCouvert}" disabled="true"/></h:column>
            <h:column><h:outputText value="Date début"/></h:column>
            <h:column><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecDateDebut}" readonly="true" disabled="true"/></h:column>
            <h:column><h:outputText value="Date fin"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecDateFin}" readonly="true" disabled="true"/></h:column>
        </h:panelGrid>
        <h:panelGrid width="100%" styleClass="fichefournisseur1" columns="3" columnClasses="clos40c,clos30,clos30" border="0">
            <h:column><h:outputText value="L I B E L L E " style="text-align:center"/></h:column>
            <h:column><h:outputText value="E X T E R N E " style="text-align:center"/></h:column>
            <h:column><h:outputText value="H O S P I T A L I S A T I O N " style="text-align:center"/></h:column>
            <h:column><h:outputText value="1 - Frais d'hospitalisation hébergement:"/></h:column>
            <h:column><h:outputText value=""/></h:column>
            <h:column>
                <h:inputText size="8" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecHebergementPlaf}"  readonly="true" disabled="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>&nbsp;&nbsp;
                <h:outputText value="(plafond #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.structureLog.strdevise})"/>
                <br>
                <h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecHebergementRep}"  readonly="true" disabled="true"/>%
            </h:column>
            <h:column><h:outputText value="2- Actes et examens (%):"/></h:column>
            <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecSoins}"  readonly="true" disabled="true"/>%</h:column>
            <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecSoinsHospit}" readonly="true" disabled="true"/>%</h:column>
            <h:column><h:outputText value="3 - Fourniture pharmacie (%):"/></h:column>
            <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecMedicament}" readonly="true" disabled="true"/>%</h:column>
            <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecMedicamentHospit}" readonly="true" disabled="true"/>%</h:column>
            <h:column><h:outputText value="4 - Laboratoire et examens complémentaires (%):"/></h:column>
            <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecExamenss}" readonly="true" disabled="true"/>%</h:column>
            <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecExamenssHospit}" readonly="true" disabled="true"/>%</h:column>
            <h:column><h:outputText value="5 - Autres préstations de soins fournies (%):"/></h:column>
            <h:column><h:outputText value=""/></h:column>
            <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecPrestations}" readonly="true" disabled="true"/>%</h:column>
            <h:column><h:outputText value="6 - Autres préstations d'hotelière fournies (%):"/></h:column>
            <h:column><h:outputText value=""/></h:column>
            <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpacHotelerie}" readonly="true" disabled="true"/>%</h:column>
            <h:column><h:outputText value="Forfait global:"/></h:column>
            <h:column><h:outputText value=""/></h:column>
            <h:column>
                <h:inputText size="8" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientPec.patpecForfait}" readonly="true" disabled="true">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>&nbsp;&nbsp;
                <h:outputText value="(#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.structureLog.strdevise})"/>
            </h:column>
        </h:panelGrid>
    </h:panelGrid>
</h:panelGrid>