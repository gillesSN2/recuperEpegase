<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="panelDetailProd">

    <a4j:form id="formModalDetailProd">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="Détail du Produit"/></f:facet>
            <br>
            <h:panelGrid columns="3" columnClasses="clos15,clos25g,clos60g" width="100%" style="background-color:#DAEECB;">
                <h:column><h:outputText value="Famille vente:"/></h:column>
                <h:column><h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produits.proVteCode}" style="width:200px;"/></h:column>
                <h:column><h:inputText readonly="true" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produits.proVteLib}"/></h:column>
                <h:column><h:outputText value="Code produit:"/></h:column>
                <h:column><h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produits.proCode}"  style="width:200px;"/></h:column>
                <h:column><h:outputText value=""/></h:column>
            </h:panelGrid>
            <h:panelGrid columns="2"columnClasses="clos15,clos85" width="100%">
                <h:column><h:outputText value="Libellé client:"/></h:column>
                <h:column><h:inputText readonly="true" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produits.proLibClient}"/></h:column>
                <h:column><h:outputText value="Libellé technique:"/></h:column>
                <h:column><h:inputText readonly="true"style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produits.proLibTech}"/></h:column>
                <h:column><h:outputText value="Descriptif:"/></h:column>
                <h:column>
                    <h:panelGrid id="corps" width="100%" style="height:300;border:0px solid green">
                        <h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produits.proDescrip}" style="width:100%" readonly="true"/>
                    </h:panelGrid>
                </h:column>
                <h:column><h:outputText value="Marque:"/></h:column>
                <h:column><h:inputText readonly="true" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produits.proMarque}"/></h:column>
                <h:column><h:outputText value="Constructeur:"/></h:column>
                <h:column><h:inputText readonly="true" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produits.proConstructeur}"/></h:column>
            </h:panelGrid>
            <h:panelGrid columns="4" columnClasses="clos15,clos35,clos25,clos25g" width="100%" style="background-color:#DAEECB;">
                <h:column><h:outputText value="Produit lié:" /></h:column>
                <h:column><h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produits.proCodeLie}" /></h:column>
                <h:column><h:outputText value="Quantité liée:"/></h:column>
                <h:column><h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produits.proQteLie}" style="text-align:right;"/></h:column>
            </h:panelGrid>
            <h:panelGrid  width="100%" style="text-align:center;">
                <center>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produits.proPhoto!=null}">
                        <img alt="Visuel produit" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.urlphotoProd}" width="100px" height="100px"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produits.proPhoto==null}">
                        <img alt="Visuel non disponible" src="images/no_image.jpeg" width="100px" height="100px" />
                    </c:if>
                </center>
            </h:panelGrid>
            <h:panelGrid columns="2" columnClasses="clos15,clos85" width="100%" >
                <h:outputText value="Option du produit:"/>
                <h:selectOneRadio layout="lineDirection" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produits.proMode}">
                    <f:selectItem itemLabel="Simple" itemValue="0"/>
                    <f:selectItem itemLabel="Groupe visible" itemValue="1"/>
                    <f:selectItem itemLabel="Groupe invisible" itemValue="2"/>
                    <f:selectItem itemLabel="Forfait" itemValue="3"/>
                    <f:selectItem itemLabel="Calcul automatique" itemValue="4"/>
                </h:selectOneRadio>
                <h:column><h:outputText value="Poids brut (Kg):"/></h:column>
                <h:column><h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produits.proPoidsBrut}" style="text-align:right;"/></h:column>
                <h:column><h:outputText value="Poids net (Kg):"/></h:column>
                <h:column><h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produits.proPoidsNet}" style="text-align:right;"/></h:column>
                <rich:spacer height="10px"/><rich:spacer height="10px"/>
                <h:column><h:outputText value="Diamètre interne (MM):"/></h:column>
                <h:column><h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produits.proDiamInt}" style="text-align:right;"/></h:column>
                <h:column><h:outputText value="Diamètre externe (MM):"/></h:column>
                <h:column><h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produits.proDiamExt}" style="text-align:right;"/></h:column>
                <rich:spacer height="10px"/><rich:spacer height="10px"/>
                <h:column><h:outputText value="Densité (Kg/L):"/></h:column>
                <h:column><h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produits.proDensite}" style="text-align:right;"/></h:column>
                <h:column><h:outputText value="Pression (B):"/></h:column>
                <h:column><h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produits.proPression}" style="text-align:right;"/></h:column>
                <h:column><h:outputText value="Etat  (Liquide ...):"/></h:column>
                <h:column><h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.produits.proEtat}"/></h:column>
            </h:panelGrid>
        </h:panelGrid>
        <br>
        <h:panelGroup id="idVal">
            <center>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==11}">
                    <a4j:commandButton id="idCanTiers11" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.annuleDetailProduit}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==12}">
                    <a4j:commandButton id="idCanTiers12" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.annuleDetailProduit}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==13}">
                    <a4j:commandButton id="idCanTiers13" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.annuleDetailProduit}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==14}">
                    <a4j:commandButton id="idCanTiers14" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formRetourAchats.annuleDetailProduit}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==15}">
                    <a4j:commandButton id="idCanTiers15" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.annuleDetailProduit}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==16}">
                    <a4j:commandButton id="idCanTiers16" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formAvoirAchats.annuleDetailProduit}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==17}">
                    <a4j:commandButton id="idCanTiers17" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.annuleDetailProduit}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==18}">
                    <a4j:commandButton id="idCanTiers18" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFraisAchats.annuleDetailProduit}" reRender="idSubView"/>
                </h:column>
                 <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==30}">
                    <a4j:commandButton id="idCanTiers30" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.annuleDetailProduit}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==31}">
                    <a4j:commandButton id="idCanTiers31" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formBonEntree.annuleDetailProduit}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==32}">
                    <a4j:commandButton id="idCanTiers32" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formBonSortie.annuleDetailProduit}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==33}">
                    <a4j:commandButton id="idCanTiers33" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCession.annuleDetailProduit}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==34}">
                    <a4j:commandButton id="idCanTiers34" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.annuleDetailProduit}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==35}">
                    <a4j:commandButton id="idCanTiers35" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.annuleDetailProduit}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==8}">
                    <a4j:commandButton id="idCanTiers8" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.annuleDetailProduit}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==21}">
                    <a4j:commandButton id="idCanTiers21" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formDevisVentes.annuleDetailProduit}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==22}">
                    <a4j:commandButton id="idCanTiers22" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.annuleDetailProduit}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==23}">
                    <a4j:commandButton id="idCanTiers23" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.annuleDetailProduit}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==24}">
                    <a4j:commandButton id="idCanTiers24" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.annuleDetailProduit}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==25}">
                    <a4j:commandButton id="idCanTiers25" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.annuleDetailProduit}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==26}">
                    <a4j:commandButton id="idCanTiers26" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.annuleDetailProduit}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==27}">
                    <a4j:commandButton id="idCanTiers27" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formNoteDebitVentes.annuleDetailProduit}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==28}">
                    <a4j:commandButton id="idCanTiers28" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.annuleDetailProduit}" reRender="idSubView"/>
                </h:column>
            </center>
        </h:panelGroup>
    </a4j:form>

</f:subview>