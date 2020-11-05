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

        <center> <h2><h:outputText value="SUPPRESSION DOCUMENTS ACHATS ET STOCKS" style="color:green;"/></h2></center>

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
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_da}"/></h:column>
                        <h:column><h:outputText value="DA"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_cotation}"/></h:column>
                        <h:column><h:outputText value="Cotation"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_cmd}"/></h:column>
                        <h:column><h:outputText value="Commande"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_reception}"/></h:column>
                        <h:column><h:outputText value="Réception"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_retour}"/></h:column>
                        <h:column><h:outputText value="Retour"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_facture}"/></h:column>
                        <h:column><h:outputText value="Facture Achat"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_factureFrais}"/></h:column>
                        <h:column><h:outputText value="Facture Frais"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_noteDebit}"/></h:column>
                        <h:column><h:outputText value="Note de débit"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_avoir}"/></h:column>
                        <h:column><h:outputText value="Avoir"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" width="40%" style="margin-left:400px">
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_inventaire}"/></h:column>
                        <h:column><h:outputText value="Inventaire"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_bin}"/></h:column>
                        <h:column><h:outputText value="Bon entrée"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_bout}"/></h:column>
                        <h:column><h:outputText value="Bon sortie"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_cession}"/></h:column>
                        <h:column><h:outputText value="Cession"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.sup_production}"/></h:column>
                        <h:column><h:outputText value="Production"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>
        <br>
        <h:panelGroup id="panelBoutonTrf">
            <center>
                <h:commandButton id="idAnnule" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.annulePlansAnalytiques}" value="RETOUR" styleClass="exp_lienmenu"/>&nbsp;&nbsp;&nbsp;
                <h:commandButton id="idValide" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUtilitaires.suppressionDocumentAchat}" value="Suppression doc. Achats" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:250px;" onclick="if (!confirm('Etes-vous sur de vouloir exécuter cette opération ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');"/>
            </center>
        </h:panelGroup>

    </a4j:form>

</f:subview>

