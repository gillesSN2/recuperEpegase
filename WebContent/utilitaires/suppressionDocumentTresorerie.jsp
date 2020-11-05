<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="selectperiode">

    <a4j:form>

        <center> <h2><h:outputText value="SUPPRESSION DOCUMENTS TRESORERIES" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%">
            <h:panelGrid id="panCtrl"  styleClass="recherche" width="100%">
                <h:panelGrid columns="6" width="100%">
                    <h:column><h:outputText value="Du:"/></h:column>
                    <h:column>
                        <rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr"  style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.var_date_deb}" popup="true"/>
                    </h:column>
                    <h:column><h:outputText value="Au:"/></h:column>
                    <h:column>
                        <rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr"  style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.var_date_fin}" popup="true"/>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid width="100%">
                    <h:panelGrid columns="2" width="40%" style="margin-left:400px">
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_devis}"/></h:column>
                        <h:column><h:outputText value="Bons de décaissement"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_bc}"/></h:column>
                        <h:column><h:outputText value="Bons d`encaissement"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_bl}"/></h:column>
                        <h:column><h:outputText value="Tous Reçus"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_noteDebit}"/></h:column>
                        <h:column><h:outputText value="Tous Déposits"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_cession}"/></h:column>
                        <h:column><h:outputText value="Reçus Ristournes"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_retour}"/></h:column>
                        <h:column><h:outputText value="Bons entrées"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_facture}"/></h:column>
                        <h:column><h:outputText value="Bons sorties"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_factureInterne}"/></h:column>
                        <h:column><h:outputText value="Virement"/></h:column>
                        <h:column rendered="false"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_noteDebit}"/></h:column>
                        <h:column rendered="false"><h:outputText value="Traites domiciliées"/></h:column>
                        <h:column rendered="false"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_avoir}"/></h:column>
                        <h:column rendered="false"><h:outputText value="Traites simplifiées"/></h:column>
                        <h:column rendered="false"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_chargement}"/></h:column>
                        <h:column rendered="false"><h:outputText value="Traites entreprises"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>
        <br>
        <h:panelGroup id="panelBoutonTrf">
            <center>
                <h:commandButton id="idAnnule" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.annulePlansAnalytiques}" value="RETOUR" styleClass="exp_lienmenu"/>&nbsp;&nbsp;&nbsp;
                <h:commandButton id="idValide" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.suppressionDocumentTresorerie}" value="Suppression doc. Trésorerie" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:250px;" onclick="if (!confirm('Etes-vous sur de vouloir exécuter cette opération ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');"/>
            </center>
        </h:panelGroup>

    </a4j:form>

</f:subview>

