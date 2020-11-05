<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="produitscaract">

    <jsp:include flush="true" page="/achats/ProduitsCommun.jsp" />
    <h:panelGrid width="100%" id="prodcarteristique">

        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proAchNat=='0104'}" >
            <h:outputText value="Type:"/>
            <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.modeProduit1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                <f:selectItem itemLabel="N.R." itemValue="0"/>
                <f:selectItem itemLabel="ESSENCE" itemValue="1"/>
                <f:selectItem itemLabel="GAZOIL" itemValue="2"/>
                <f:selectItem itemLabel="GPL" itemValue="3"/>
                <f:selectItem itemLabel="KEROSENE" itemValue="4"/>
                <f:selectItem itemLabel="FUEL" itemValue="5"/>
                <f:selectItem itemLabel="JETA1" itemValue="6"/>
                <f:selectItem itemLabel="ELECTRIQUE" itemValue="7"/>
                <f:selectItem itemLabel="HYBRIDE" itemValue="8"/>
                <f:selectItem itemLabel="SOLAIRE" itemValue="9"/>
                <f:selectItem itemLabel="CHARBON" itemValue="10"/>
                <f:selectItem itemLabel="NUCLEAIRE" itemValue="11"/>
                <f:selectItem itemLabel="AUTRE" itemValue="12"/>
            </h:selectOneRadio>
        </c:if>

        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proAchNat=='0105'}" >
            <h:outputText value="Type:"/>
            <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.modeProduit2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                <f:selectItem itemLabel="N.R." itemValue="0"/>
                <f:selectItem itemLabel="MOTEUR" itemValue="1"/>
                <f:selectItem itemLabel="BOITE" itemValue="2"/>
                <f:selectItem itemLabel="PONT" itemValue="3"/>
                <f:selectItem itemLabel="SUSPENSION" itemValue="4"/>
                <f:selectItem itemLabel="AUTRE" itemValue="5"/>
            </h:selectOneRadio>
        </c:if>

        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proAchNat=='0108'}" >
            <h:outputText value="Type:"/>
            <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.modeProduit5}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                <f:selectItem itemLabel="DIVERS" itemValue="0"/>
                <f:selectItem itemLabel="ACTION" itemValue="1"/>
                <f:selectItem itemLabel="TRAITEMENT" itemValue="2"/>
                <f:selectItem itemLabel="VACCIN" itemValue="3"/>
            </h:selectOneRadio>
        </c:if>

        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proAchNat=='0112'}" >
            <h:outputText value="Nature du frais:"/>
            <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.modeProduit3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                <f:selectItem itemLabel="DIVERS" itemValue="0"/>
                <f:selectItem itemLabel="FRET" itemValue="1"/>
                <f:selectItem itemLabel="ASSURANCE" itemValue="2"/>
                <f:selectItem itemLabel="DOUANE" itemValue="3"/>
                <f:selectItem itemLabel="TVA/DOUANE" itemValue="4"/>
                <f:selectItem itemLabel="TRANSIT" itemValue="5"/>
                <f:selectItem itemLabel="DEBOURS" itemValue="6"/>
                <f:selectItem itemLabel="CAUTION" itemValue="7"/>
                <f:selectItem itemLabel="FRAIS FINANCIERS" itemValue="8"/>
                <f:selectItem itemLabel="FACTURE ACHAT (FOB)" itemValue="9"/>
            </h:selectOneRadio>
        </c:if>

        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proAchNat=='0114'}" >
            <h:panelGrid id="caract" columns="2" columnClasses="clos50d,clos50g">
                <h:column><h:outputText value="Energie:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proEnergie}" maxlength="10" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                <h:column><h:outputText value="Nb portes:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proNbPorte}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                <h:column><h:outputText value="Nb places:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proNbPlace}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                <h:column><h:outputText value="Boite vitesse:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proBoiteVitesse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                <h:column><h:outputText value="Puissance:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proPuissance}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                <h:column><h:outputText value="Puissance DIN:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proPuissanceDin}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                <h:column><h:outputText value="Cylindrée:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proCylindree}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                <h:column><h:outputText value="Genre:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proGenre}" maxlength="10" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                <h:column><h:outputText value="Carrosserie:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proCarrosserie}" maxlength="10" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                <h:column><h:outputText value="Couleur:"/></h:column>
                <h:column>
                    <h:selectOneMenu id="idCouleur1" style="width:800px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proCouleur}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                        <f:selectItem itemLabel="Sans couleur" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesCouleursItems}"/>
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>
            <h:panelGrid id="commission" columns="2" columnClasses="clos50d,clos50g" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.optionsVentes.modeCommission=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.optionsVentes.modeCommission=='2'}">
                <h:column><h:outputText value="Commission / Unité:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proComUnite}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="% commission / CA:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proComPourcentage}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
            </h:panelGrid>
        </c:if>

        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proAchNat!='0104'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proAchNat!='0105'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proAchNat!='0108'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proAchNat!='0112'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proAchNat!='0114'}" >
            <h:panelGrid columns="2" width="100%" styleClass="fichefournisseur">
                <h:outputText value="Options du produit:"/>
                <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.modeProduit4}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                    <f:selectItem itemLabel="Simple" itemValue="0"/>
                    <f:selectItem itemLabel="Groupe visible" itemValue="1"/>
                    <f:selectItem itemLabel="Groupe invisible" itemValue="2"/>
                    <f:selectItem itemLabel="Forfait" itemValue="3"/>
                    <f:selectItem itemLabel="Calcul automatique" itemValue="4"/>
                    <f:selectItem itemLabel="Générique" itemValue="5"/>
                    <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.recupererCalc}" reRender="idDefinitionCarac,prodcarteristique,caracteristique,grpButt,tabProduit" />
                </h:selectOneRadio>
            </h:panelGrid>
            <h:panelGrid columns="2" columnClasses="cols20,clos80" width="100%" style="background-color:#DAEECB;" id="grpButt" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.afficheFormule}">
                <h:outputText value="Formule:"/>
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proFormule}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}" style="width:100%"/>
            </h:panelGrid>
            <br>
            <h:panelGrid columnClasses="clos40,clos60g" id="caracteristique" columns="2" width="100%">
                <h:column>
                    <h:panelGrid id="caract" columns="2" columnClasses="clos30,clos70">
                        <h:column><h:outputText value="Conditionnement1:"/></h:column>
                        <h:column >
                            <h:selectOneMenu id="cdt11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proCondition1}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesConditionnementsItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.verifConditionnement1}" reRender="cdt11,idGrdVente3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Conditionnement2:"/></h:column>
                        <h:column >
                            <h:selectOneMenu id="cdt12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proCondition2}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesConditionnementsItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.verifConditionnement2}" reRender="cdt12,idGrdVente3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Conditionnement3:"/></h:column>
                        <h:column >
                            <h:selectOneMenu id="cdt13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proCondition3}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesConditionnementsItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.verifConditionnement3}" reRender="cdt13,idGrdVente3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Conditionnement4:"/></h:column>
                        <h:column >
                            <h:selectOneMenu id="cdt14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proCondition4}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesConditionnementsItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.verifConditionnement4}" reRender="cdt14,idGrdVente3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Conditionnement5 (sur stock):"/></h:column>
                        <h:column >
                            <h:selectOneMenu id="cdt15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proCondition5}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesConditionnementsItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.verifConditionnement5}" reRender="caract,cdt15,idGrdVente3,cdt151,cdt152"/>
                            </h:selectOneMenu>&nbsp;&nbsp;
                            <h:outputText id="cdt151" value="Nb unité:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.afficheQteNbUnite}"/>&nbsp;
                            <h:inputText id="cdt152" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proNbUnite}" size="4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.afficheQteNbUnite}"/>
                        </h:column>
                        <rich:spacer height="10px"/><rich:spacer height="10px"/>
                        <h:column><h:outputText value="Couleur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idCouleur2" style="width:230px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proCouleur}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                <f:selectItem itemLabel="Sans couleur" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesCouleursItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <rich:spacer height="10px"/><rich:spacer height="10px"/>
                        <h:column><h:outputText value="Etat (Liquide ...):"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proEtat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Longueur (CM):"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proLongueur}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Largeur (CM):"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proLargeur}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Epaisseur (CM):"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proEpaisseur}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Volume (CM3):"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proVolume}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Poids brut:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proPoidsBrut}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Tare:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proPoidsTare}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.calculPoidsNet}" reRender="idPoidsNet" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Poids net:"/></h:column>
                        <h:column><h:inputText id="idPoidsNet" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proPoidsNet}" style="text-align:right;" readonly="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Diamètre interne:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proDiamInt}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Diamètre externe:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proDiamExt}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Densité (Ex : Kg/L):"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proDensite}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Pression (Ex: B):"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proPression}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Usage:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proUsage}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Manchon:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proManchon}" maxlength="10" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid id="commission" columns="2" columnClasses="clos50d,clos50g" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.optionsVentes.modeCommission=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.optionsVentes.modeCommission=='2'}">
                        <h:column><h:outputText value="Commission / Unité:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proComUnite}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="% commission / CA:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proComPourcentage}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                    </h:panelGrid>
                </h:column>
                <h:column>
                    <h:panelGrid id="pantableauGrp" width="100%"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.existGrp}">
                        <h:panelGroup id="boutonGrp" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                            <a4j:commandButton title="Ajouter groupe" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.ajouterProduitGroupe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_ajt}" reRender="panelGrp" />&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton title="Modifier groupe" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.modifierProduitGroupe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.afficheButtProduitGroupe&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_mod}" reRender="panelGrp"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton title="Supprimer groupe" image="/images/supprimer.png"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.afficheButtProduitGroupe&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.supprimerProduitGroupe}" reRender="boutonGrp,tableauGrp"/>
                        </h:panelGroup>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable enableContextMenu="false" id="tableauGrp" styleClass="bg" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="border:solid 0px green;" border="0" height="350px" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.datamodelGrp}" var="depotgrp">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.selectProduitGroupe}" reRender="boutonGrp" />
                                <rich:column sortable="false" width="15%">
                                    <f:facet name="header" ><h:outputText value="Code"/></f:facet>
                                    <h:outputText value="#{depotgrp.progrpCode}"/>
                                </rich:column>
                                <rich:column sortable="false" width="25%">
                                    <f:facet name="header" ><h:outputText value="Libellé"/></f:facet>
                                    <h:outputText value="#{depotgrp.progrpLibelle}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%" style="text-align:right;">
                                    <f:facet name="header" ><h:outputText value="Quantité"  /></f:facet>
                                    <h:outputText value="#{depotgrp.progrpQte}" style="text-align:right;"/>
                                </rich:column>
                                <rich:column sortable="false" width="15%">
                                    <f:facet name="header" ><h:outputText value="Unité"/></f:facet>
                                    <h:outputText value="#{depotgrp.progrpUnite}" />
                                </rich:column>
                                <rich:column sortable="false" width="15%">
                                    <f:facet name="header" ><h:outputText value="Dépot"/></f:facet>
                                    <h:outputText value="#{depotgrp.progrpDepot}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%" style="text-align:right">
                                    <f:facet name="header" ><h:outputText value="Pump"/></f:facet>
                                    <h:outputText value="#{depotgrp.progrpPump}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" width="10%" style="text-align:right">
                                    <f:facet name="header" ><h:outputText value="P.V."/></f:facet>
                                    <h:outputText value="#{depotgrp.progrpPv}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                            <h:panelGrid id="idTotGrp" columns="5" columnClasses="clos15,clos35,clos15,clos35" width="80%">
                                <h:column><h:outputText value="Total Pump:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_grp_pump}" style="text-align:right;" disabled="true" readonly="true">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Total Pv:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_grp_pv}" style="text-align:right;" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;&nbsp;
                                    <a4j:commandButton title="Recharger les totaux" image="/images/actualiser.png" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.rechargeTotalGrp}" onclick="if (!confirm('Etes-vous sur de vouloir recalculer les totaux du groupe?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,pantableauGrp,idTotGrp,tableauTarifSt"/>
                                </h:column>
                            </h:panelGrid>
                        </a4j:region>
                    </h:panelGrid>
                    <h:panelGrid id="pantableauGrpbis"  width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.existGrpCode}">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable enableContextMenu="false" id="tableauGrpbis" styleClass="bg" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="border:solid 0px green;" border="0" height="350px" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.datamodelCode}" var="depotgrp">
                                <rich:column sortable="false" width="30%">
                                    <f:facet name="header" ><h:outputText value="Code"/></f:facet>
                                    <h:outputText value="#{depotgrp.proCode}"/>
                                </rich:column>
                                <rich:column sortable="false" width="70%">
                                    <f:facet name="header" ><h:outputText value="Libellé"/></f:facet>
                                    <h:outputText value="#{depotgrp.proLibClient}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </h:column>
            </h:panelGrid>
        </c:if>
    </h:panelGrid>


</f:subview>
