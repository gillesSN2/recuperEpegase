<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="produitsoptions">
    <h:panelGrid columns="2" id="idGrdVente" width="100%" columnClasses="clos15,clos35">
        <h:column><h:outputText value="Nature vente:" style="text-decoration:underline;" /></h:column>
        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.inpNatureVnt}" style="width:100%" readonly="true"/></h:column>
        <h:column></h:column>
        <h:column></h:column>
        <h:column><h:outputText value="Code TVA:" style="text-decoration:underline;"/></h:column>
        <h:column>
            <h:selectOneMenu id="idTva" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proVteTva}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                <f:selectItem itemLabel="" itemValue=""/>
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesTaxesItems}"/>
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText value="Code Douane:"/></h:column>
        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proVteDouane}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/></h:column>
    </h:panelGrid>

    <h:panelGrid columns="2" id="idGrdVente2" width="100%" columnClasses="clos15,clos35"  style="background-color:#DAEECB;">
        <h:column><h:outputText value="Compte vente local:" style="text-decoration:underline;" /></h:column>
        <h:column>
            <h:selectOneMenu id="idCptVteLoc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proVteCpteLoc}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                <f:selectItem itemLabel="" itemValue=""/>
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesCompteProduitsItems}"/>
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText value="Compte vente zone:" style="text-decoration:underline;"/></h:column>
        <h:column>
            <h:selectOneMenu id="idCpteVteZ" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proVteCpteZ}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                <f:selectItem itemLabel="" itemValue=""/>
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesCompteProduitsItems}"/>
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText value="Compte vente hors zone:" style="text-decoration:underline;"/></h:column>
        <h:column>
            <h:selectOneMenu id="idCptVteHZ" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proVteCpteHz}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                <f:selectItem itemLabel="" itemValue=""/>
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesCompteProduitsItems}"/>
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText value="Compte de produit:" style="text-decoration:underline;"/></h:column>
        <h:column>
            <h:selectOneMenu id="idCpteVtePrd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proVteCptePr}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                <f:selectItem itemLabel="" itemValue=""/>
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesCompteStocksItems}"/>
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText value="Compte de stock:" style="text-decoration:underline;"/></h:column>
        <h:column>
            <h:selectOneMenu id="idCpteVteStk" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proVteCpteSt}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                <f:selectItem itemLabel="" itemValue=""/>
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesCompteStocksItems}"/>
            </h:selectOneMenu>
        </h:column>
    </h:panelGrid>

    <h:panelGrid columns="2"  id="idGrdVente3" width="100%" columnClasses="clos15,clos35">
        <h:column><h:outputText value="Dépot vente:" style="text-decoration:underline;"/></h:column>
        <h:column>
            <h:selectOneMenu id="idDepot" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proDepotVte}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                <f:selectItem itemLabel="" itemValue=""/>
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesDepotItems}"/>
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
        <h:column>
            <h:selectOneMenu id="idActivite" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proActivite}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                <f:selectItem itemLabel="" itemValue=""/>
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesActivitesItems}"/>
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText value="Code promotion:" /></h:column>
        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proPromo}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/></h:column>
    </h:panelGrid>

    <h:panelGrid columns="2"  id="idGrdVente4" width="100%" columnClasses="clos15,clos35"  style="background-color:#DAEECB;">
        <h:column><h:outputText value="Conditionnement1:"/></h:column>
        <h:column id="cdt11">
            <h:selectOneMenu id="idCond1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proCondition1}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesConditionnementsItems}"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.verifConditionnement1}" reRender="cdt11,idGrdVente3"/>
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText value="Conditionnement2:"/></h:column>
        <h:column id="cdt12">
            <h:selectOneMenu id="idCond2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proCondition2}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesConditionnementsItems}"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.verifConditionnement2}" reRender="cdt12,idGrdVente3"/>
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText value="Conditionnement3:"/></h:column>
        <h:column id="cdt13">
            <h:selectOneMenu id="idCond3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proCondition3}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesConditionnementsItems}"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.verifConditionnement3}" reRender="cdt13,idGrdVente3"/>
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText value="Conditionnement4:"/></h:column>
        <h:column id="cdt14">
            <h:selectOneMenu id="idCond4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proCondition4}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesConditionnementsItems}"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.verifConditionnement4}" reRender="cdt14,idGrdVente3"/>
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText value="Conditionnement5:"/></h:column>
        <h:column id="cdt15">
            <h:selectOneMenu id="idCond5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proCondition5}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesConditionnementsItems}"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.verifConditionnement5}" reRender="cdt15,idGrdVente3"/>
            </h:selectOneMenu>
        </h:column>
    </h:panelGrid>

    <h:panelGroup>
        <center>
            <h:commandButton value="Valeur par défaut" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.valeurDefautFamille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/>
        </center>
    </h:panelGroup>

</f:subview>