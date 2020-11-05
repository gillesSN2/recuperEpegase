<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="panelDetailTiers">

    <a4j:form id="formModalDetailTiers">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid  width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="Détail du Tiers"/></f:facet>
            <br>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.var_typeTiers==false}">
                <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%">
                    <h:column><h:outputText style="text-decoration:underline;" value="Civilité:"/></h:column>
                    <h:column><h:inputText readonly="true" style="width:210;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiecivilite}"/></h:column>
                    <h:column><h:outputText value="Genre:"/></h:column>
                    <h:column>
                        <h:selectOneRadio readonly="true" style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiesexe}" >
                            <f:selectItem itemLabel="Femme" itemValue="0"/>
                            <f:selectItem itemLabel="Homme" itemValue="1"/>
                        </h:selectOneRadio>
                    </h:column>
                    <h:column><h:outputText value="Nom:"/></h:column>
                    <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieraisonsocialenom}"/></h:column>
                    <h:column><h:outputText value="Prénom:"/></h:column>
                    <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieprenom}"/></h:column>
                    <h:column><h:outputText style="text-decoration:underline;" value="Catégorie:"/></h:column>
                    <h:column><h:inputText readonly="true" style="width:210;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiecategorie}"/></h:column>
                    <h:column><h:outputText style="text-decoration:underline;" value="Langue:"/></h:column>
                    <h:column><h:inputText readonly="true" style="width:210;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tielangue}"/></h:column>
                    <h:column><h:outputText value="Né(e) le:"/></h:column>
                    <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiedatenaissance}"/></h:column>
                    <h:column><h:outputText value="Lieu naissance:"/></h:column>
                    <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tielieunaissance}"/></h:column>
                </h:panelGrid>
            </c:if>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.var_typeTiers==true}">
                <h:panelGrid  columns="2" width="100%" columnClasses="clos15,clos85">
                    <h:column><h:outputText value="Raison sociale:"/></h:column>
                    <h:column><h:inputText readonly="true" size="91" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieraisonsocialenom}"/></h:column>
                </h:panelGrid>
                <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText style="text-decoration:underline;" value="Catégorie:"/></h:column>
                    <h:column><h:inputText readonly="true" style="width:210;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiecategorie}"/></h:column>
                    <h:column><h:outputText style="text-decoration:underline;" value="Langue:"/></h:column>
                    <h:column><h:inputText readonly="true" style="width:210;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tielangue}"/></h:column>
                </h:panelGrid>
            </c:if>
            <h:panelGrid width="100%" columns="2" columnClasses="clos15,clos85">
                <h:column><h:outputText value="Adresse:"/></h:column>
                <h:column><h:inputText readonly="true" size="91" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieadresse}"/></h:column>
            </h:panelGrid>
            <h:panelGrid  columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                <h:column><h:outputText value="Rue N°:"/></h:column>
                <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tierue}"/></h:column>
                <h:column><h:outputText value="Lot N°:"/></h:column>
                <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tielot}"/></h:column>
                <h:column><h:outputText value="Ilot N°:"/></h:column>
                <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieilot}"/></h:column>
                <h:column><h:outputText value="Porte N°:"/></h:column>
                <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieporte}"/></h:column>
                <h:column><h:outputText value="Quartier:"/></h:column>
                <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiequartier}"/></h:column>
                <h:column><h:outputText value="Commune:"/></h:column>
                <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiecommune}"/></h:column>
                <h:column><h:outputText value="Zone:"/></h:column>
                <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiezone}"/></h:column>
                <h:column><h:outputText value="Département:"/></h:column>
                <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiedepart}"/></h:column>
                <h:column><h:outputText value="Bâtiment:"/></h:column>
                <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiebatiment}"/></h:column>
                <h:column><h:outputText value="Escalier:"/></h:column>
                <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieetage}"/></h:column>
                <h:column><h:outputText value="Boite Postale:"/></h:column>
                <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiebp}"/></h:column>
                <h:column><h:outputText value="Cédex:"/></h:column>
                <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiecedex}"/></h:column>
                <h:column><h:outputText value="Ville:"/></h:column>
                <h:column><h:inputText readonly="true" size="25" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieville}"/></h:column>
                <h:column><h:outputText style="text-decoration:underline;" value="Pays:"/></h:column>
                <h:column ><h:inputText readonly="true" style="width:210;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tienompays}"/></h:column>
            </h:panelGrid>
            <h:panelGrid width="100%">
                <h:panelGrid style="background-color:#DAEECB;" width="100%">
                    <h:panelGrid  columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Téléphone 1:"/></h:column>
                        <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieteldom}"/></h:column>
                        <h:column><h:outputText value="Téléphone 2:"/></h:column>
                        <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieburtel2}"/></h:column>
                        <h:column><h:outputText value="Cellulaire:"/></h:column>
                        <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieburtel3}"/></h:column>
                        <h:column><h:outputText value="Fax:"/></h:column>
                        <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieburfax}"/></h:column>
                        <h:column><h:outputText value="Aol:"/></h:column>
                        <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieaol}"/></h:column>
                        <h:column><h:outputText value="Skype:"/></h:column>
                        <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieskype}"/></h:column>
                        <h:column><h:outputText value="Yahoo:"/></h:column>
                        <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieyahoo}"/></h:column>
                        <h:column><h:outputText value="Msn:"/></h:column>
                        <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiemsn}"/></h:column>
                        <h:column><h:outputText value="Mail 1:"/></h:column>
                        <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiemail1}"/></h:column>
                        <h:column><h:outputText value="Mail 2:"/></h:column>
                        <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiemail2}"/></h:column>
                        <h:column><h:outputText value="Mail 3:"/></h:column>
                        <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiemail3}"/></h:column>
                        <h:column><h:outputText value="Site Web:"/></h:column>
                        <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieweb}"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </h:panelGrid>
            <h:panelGrid width="100%">
                <h:panelGrid   columns="4"  width="100%" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="Observation:"/></h:column>
                    <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieobservations}"/></h:column>
                    <h:column> <h:outputText style="text-decoration:underline;" value="Source:"/></h:column>
                    <h:column><h:inputText readonly="true" style="width:211;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tiesource}"/></h:column>
                    <h:column><h:outputText value="1ère activité:"/></h:column>
                    <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieactivite1}"/></h:column>
                    <h:column><h:outputText value="2ème activité:"/></h:column>
                    <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tieactivite2}"/></h:column>
                    <h:column><h:outputText style="text-decoration:underline;" value="Appréciation:"/></h:column>
                    <h:column>
                        <h:selectOneMenu readonly="true" style="width:210;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tienoteman}">
                            <f:selectItem itemLabel="Plomb" itemValue="1"/>
                            <f:selectItem itemLabel="Zinc" itemValue="2"/>
                            <f:selectItem itemLabel="Cuivre" itemValue="3"/>
                            <f:selectItem itemLabel="Fer" itemValue="4"/>
                            <f:selectItem itemLabel="Alunimium" itemValue="5"/>
                            <f:selectItem itemLabel="Argent" itemValue="6"/>
                            <f:selectItem itemLabel="Or" itemValue="7"/>
                            <f:selectItem itemLabel="Platine" itemValue="8"/>
                            <f:selectItem itemLabel="Diamant" itemValue="9"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Note automatique:"/></h:column>
                    <h:column><h:inputText readonly="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.tiers.tienoteauto}/20"/></h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>
        <br>
        <h:panelGroup id="idVal">
            <center>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==0}">
                    <a4j:commandButton id="idCanTiers0" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==11}">
                    <a4j:commandButton id="idCanTiers11" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==12}">
                    <a4j:commandButton id="idCanTiers12" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==13}">
                    <a4j:commandButton id="idCanTiers13" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==14}">
                    <a4j:commandButton id="idCanTiers14" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formRetourAchats.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==15}">
                    <a4j:commandButton id="idCanTiers15" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==16}">
                    <a4j:commandButton id="idCanTiers16" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formAvoirAchats.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==17}">
                    <a4j:commandButton id="idCanTiers17" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==18}">
                    <a4j:commandButton id="idCanTiers18" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFraisAchats.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==35}">
                    <a4j:commandButton id="idCanTiers35" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==8}">
                    <a4j:commandButton id="idCanTiers8" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formSimulContratVentes.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==21}">
                    <a4j:commandButton id="idCanTiers21" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formDevisVentes.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==22}">
                    <a4j:commandButton id="idCanTiers22" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==23}">
                    <a4j:commandButton id="idCanTiers23" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==24}">
                    <a4j:commandButton id="idCanTiers24" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==25}">
                    <a4j:commandButton id="idCanTiers25" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==6}">
                    <a4j:commandButton id="idCanTiers6" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==26}">
                    <a4j:commandButton id="idCanTiers26" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==27}">
                    <a4j:commandButton id="idCanTiers27" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formNoteDebitVentes.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==28}">
                    <a4j:commandButton id="idCanTiers28" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formChargementVentes.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==43}">
                    <a4j:commandButton id="idCanTiers43" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcLocation.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==127&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes!=null}">
                    <a4j:commandButton id="idCanTiers127v" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==127&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats!=null}">
                    <a4j:commandButton id="idCanTiers127a" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formAffaires.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==534}">
                    <a4j:commandButton id="idCanTiers534" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==162}">
                    <a4j:commandButton id="idCanTiers162" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==163}">
                    <a4j:commandButton id="idCanTiers163" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==164}">
                    <a4j:commandButton id="idCanTiers164" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==171}">
                    <a4j:commandButton id="idCanTiers171" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formSyndicImmobilier.annuleDetailTiers}" reRender="idSubView"/>
                </h:column>
            </center>
        </h:panelGroup>
    </a4j:form>

</f:subview>