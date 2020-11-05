<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="panelDetailBiens">

    <a4j:form id="formModalDetailBiens">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid  width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="Détail du Biens"/></f:facet>
            <h:panelGrid width="100%" styleClass="fichefournisseur" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                <h:column><h:outputText value="Gestion:"/></h:column>
                <h:column>
                    <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.bien.bieGestion}" disabled="true">
                        <f:selectItem itemLabel="Géré par l'agence" itemValue="0"/>
                        <f:selectItem itemLabel="Plus géré par l'agence" itemValue="1"/>
                    </h:selectOneRadio>
                </h:column>
                <h:column><h:outputText value=""/></h:column>
                <h:column><h:outputText value=""/></h:column>
                <h:column><h:outputText value="Code bien:"/></h:column>
                <h:column><h:inputText maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.bien.bieNum}" disabled="true"/></h:column>
                <h:column><h:outputText value="Libellé bien:"/></h:column>
                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.bien.bieNom}" disabled="true"/></h:column>
                <h:column><h:outputText value="Adresse:"/></h:column>
                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.bien.bieAdresse}" disabled="true"/></h:column>
                <h:column><h:outputText value="Rue N°:"/></h:column>
                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.bien.bieRue}" disabled="true"/></h:column>
                <h:column><h:outputText value="Quartier:"/></h:column>
                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.bien.bieQuartier}" disabled="true"/></h:column>
                <h:column><h:outputText value="Commune:"/></h:column>
                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.bien.bieCommune}" disabled="true"/></h:column>
                <h:column><h:outputText value="Zone:"/></h:column>
                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.bien.bieZone}" disabled="true"/></h:column>
                <h:column><h:outputText value="Département:"/></h:column>
                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.bien.bieDepart}" disabled="true"/></h:column>
                <h:column><h:outputText value="Ville:"/></h:column>
                <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.bien.bieVille}"/></h:column>
                <h:column><h:outputText value="Pays:"/></h:column>
                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.bien.bieNomPays}" disabled="true"/></h:column>
            </h:panelGrid>
        </h:panelGrid>
        <br>
        <h:panelGroup id="idVal">
            <center>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==162}">
                    <a4j:commandButton id="idCanTiers162" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.annuleDetailBiens}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==163}">
                    <a4j:commandButton id="idCanTiers163" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.annuleDetailBiens}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==164}">
                    <a4j:commandButton id="idCanTiers164" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.annuleDetailBiens}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==171}">
                    <a4j:commandButton id="idCanTiers171" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.annuleDetailBiens}" reRender="idSubView"/>
                </h:column>
            </center>
        </h:panelGroup>
    </a4j:form>

</f:subview>