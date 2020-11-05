<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="cadeauxFiche">

    <a4j:form id="formCadeauxFiche">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText  styleClass="titre" value="FICHE DES CADEAUX" /></h2></center>

        <h:panelGrid  width="100%" styleClass="fichefournisseur" id="idPanGlobal">
            <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%">
                <h:column><h:outputText value="Date:"/></h:column>
                <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.var_date}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.var_aff_action}"/></h:column>
                <h:column><h:outputText value=""/></h:column>
                <h:column><h:outputText value=""/></h:column>
                <h:column><h:outputText value="Nom du tiers:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:inputText style="width:100%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.cadeaux.cadNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.var_aff_action}" maxlength="100">
                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les tiers (puis tabuler)" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,idPanGlobal,panelListeTiers,formModalListeTiers,panelButton"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Nom du contact:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.var_nom_contat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.var_aff_action}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.mesContactsItem}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Nom du commercial:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.var_nom_commercial}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.var_aff_action}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.mesCommercialItem}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value=""/></h:column>
                <h:column><h:outputText value=""/></h:column>
                <h:column><h:outputText value="Code:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.cadeaux.cadCode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.var_aff_action}" maxlength="100">
                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.rechercheProduits}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelButton,idPanGlobal,listeProd,formModalListeProduitVente"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Libellé:"/></h:column>
                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.cadeaux.cadLibelle}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.var_aff_action}"/></h:column>
                <h:column><h:outputText value="Dépôt:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.var_depot}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.var_aff_action}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.mesProduitsDepotsItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Pump:"/></h:column>
                <h:column>
                    <h:inputText style="width:100%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.cadeaux.cadPump}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.var_aff_action}">
                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Quantité:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.cadeaux.cadQte}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.var_aff_action}">
                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.controleValidation}" reRender="panelButton"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value=""/></h:column>
                <h:column><h:outputText value=""/></h:column>
            </h:panelGrid>

            <h:panelGroup id="panelButton">
                <center>
                    <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.annuleDocument}" reRender="idSubView"/>&nbsp;&nbsp;
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.save}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.valide_doc&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.var_action!=3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelBouton,tableCadeaux"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

</f:subview>