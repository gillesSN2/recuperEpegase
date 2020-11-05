<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<h:panelGrid style="width:100%;" id="panContratJRX">

    <h:panelGrid id="idConfig0" width="100%" >
        <h:panelGrid id="idConfig1" columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
            <h:column><h:outputText value="Nature contrat:"/></h:column>
            <h:column>
                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNature}" disabled="true" readonly="true">
                    <f:selectItem itemLabel="Sélectionnez type contrat" itemValue="100" />
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesNatureAgentItems}"/>
                </h:selectOneMenu>
            </h:column>
            <h:column><h:outputText value="Feuille calcul:"/></h:column>
            <h:column>
                <h:selectOneMenu id="idfeuille" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salFeuille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                    <f:selectItem itemLabel="Sélectionnez Feuille" itemValue="0" />
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesFeuillesContratItems}"/>
                </h:selectOneMenu>
            </h:column>
            <h:column><h:outputText value="Date début (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"  inputSize="8" locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDateEntree}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/></h:column>
            <h:column><h:outputText value="Date fin  (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   inputSize="8" locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDateSortie}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/></h:column>
        </h:panelGrid>
        <h:panelGrid id="idConfig2" columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%">
            <h:column><h:outputText value="Fonction:"/></h:column>
            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salFonction}" maxlength="50"/></h:column>
            <h:column><h:outputText value="Durée:"/></h:column>
            <h:column>
                <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salDureeJour}" >
                    <f:selectItem itemLabel="Journée" itemValue="0"/>
                    <f:selectItem itemLabel="1/2 journée" itemValue="1"/>
                    <f:selectItem itemLabel="Autre" itemValue="2"/>
                </h:selectOneRadio>
            </h:column>
            <h:column><h:outputText value="Classement:"/></h:column>
            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_classement}" disabled="true"/></h:column>
            <h:column><h:outputText value="Centre Impôt:"/></h:column>
            <h:column>
                <h:selectOneMenu id="idcentre" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_centre}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                    <f:selectItem itemLabel="Sélectionnez Centre impôt" itemValue="0" />
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesCentresImpotsItems}" />
                </h:selectOneMenu>
            </h:column>
            <h:column><h:outputText value="Convention:"/></h:column>
            <h:column>
                <h:selectOneMenu id="idconvention" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_convention}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                    <f:selectItem itemLabel="Sélectionnez Convention" itemValue="0" />
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesConventionsItems}" />
                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.chargerGrille}" reRender="idConfig2,idgrille"/>
                </h:selectOneMenu>
            </h:column>
            <h:column><h:outputText value="Catégorie salariale:"/></h:column>
            <h:column>
                <h:selectOneMenu id="idgrille" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_grille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                    <f:selectItem itemLabel="Sélectionnez Grille" itemValue="0" />
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesGrillesItems}"/>
                </h:selectOneMenu>
            </h:column>
        </h:panelGrid>
        <h:panelGrid id="idConfig3" columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesInterim}">
            <h:column><h:outputText value="Société:" style="text-decoration:underline;"/></h:column>
            <h:column>
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_tiers}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                    <f:selectItem itemLabel="Sans Société" itemValue="0"/>
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesTiersItems}" />
                </h:selectOneMenu>
            </h:column>
        </h:panelGrid>
    </h:panelGrid>

</h:panelGrid>
