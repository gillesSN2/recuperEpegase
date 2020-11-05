<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="ficheor">

    <a4j:form>

        <center> <h2><h:outputText value="DESCRIPTION FICHE OR" style="color:green;"/></h2></center>

        <rich:tabPanel switchType="client" immediate="true"  id="tabPanelparc" style="border:0px;" selectedTab="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_onglet}">

            <rich:tab id="identification" label="Identification" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_acc_descriptif}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.autorisationDescription}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.onglet01}"/>
                <h:panelGrid  width="100%" style="max-height:100%;">
                    <h:panelGrid style="background-color:#DAEECB;" id="idPanelIdentificiation" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Date:"/></h:column>
                        <h:panelGrid width="100%" columns="4">
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_date}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDatePrc==0}"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_heure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}" style="width:45px">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                            </h:selectOneMenu>
                            <h:column><h:outputText value=":"/></h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_minute}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}" style="width:45px">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                        <h:column><h:outputText value="N°:"/></h:column>
                        <h:column>
                            <h:inputText style="width:70%;text-align:center;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreNum}" readonly="true"/>&nbsp;&nbsp;
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreSerie}" style="width:80px;">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.mesSerieUserItem}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText style="text-decoration:underline;" value="Immatriculation:"/></h:column>
                        <h:column>
                            <h:inputText id="idParc" style="width:100%;text-align:center;font-weight:bold;font-size:50px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.immatriculation}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}">
                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les parcs (puis tabuler)" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.rechercheParc}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,formModalListeParc,tableParc,idParc"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Type:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreType}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}" style="width:100%;text-align:center;font-weight:bold;font-size:50px">
                                <f:selectItem itemLabel="Diagnostic" itemValue="0"/>
                                <f:selectItem itemLabel="Maintenance" itemValue="1"/>
                                <f:selectItem itemLabel="Réparation" itemValue="2"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.chargerMotifEntree}" reRender="idPanelIdentificiation,idMotifEntree1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="N° Chassis:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreNumChassis}" readonly="true" disabled="true"/></h:column>
                        <h:column><h:outputText value="N° Moteur:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreNumMoteur}" readonly="true" disabled="true"/></h:column>
                        <h:column><h:outputText value="N° Série:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreNumSrie}" readonly="true" disabled="true"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Motif d'entrée 1:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idMotifEntree1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreMotifEntree1}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}" style="width:100%">
                                <f:selectItem itemLabel="Sans motif" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.mesMotifsEntreeItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Motif d'entrée 2:"/></h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreMotifEntree2}" maxlength="120" style="width:100%"/>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

            <rich:tab id="description" label="Description des travaux" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_acc_descriptif}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.autorisationDescription}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.onglet02}"/>
                <h:panelGrid  width="100%" style="max-height:100%;">
                    <h:panelGrid style="background-color:#DAEECB;" id="idPanelTravaux" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Niveau de carburant:"/></h:column>
                        <h:column>
                            <a4j:outputPanel>
                                <h:graphicImage value="/images/niveauCarburant.jpg" height="80px" width="200px" style="border:2px solid black">
                                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreNiveauCarburant}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}" style="width:190px;margin-left:10px;">
                                        <f:selectItem itemLabel="Empty" itemValue="0"/>
                                        <f:selectItem itemLabel="1/4" itemValue="1"/>
                                        <f:selectItem itemLabel="1/2" itemValue="2"/>
                                        <f:selectItem itemLabel="1/3" itemValue="3"/>
                                        <f:selectItem itemLabel="Full" itemValue="4"/>
                                    </h:selectOneRadio>
                                </h:graphicImage>
                            </a4j:outputPanel>
                        </h:column>
                        <h:column><h:outputText value="Relevé compteur:"/></h:column>
                        <h:column>
                            <h:inputText style="width:100%;text-align:center;font-weight:bold;font-size:50px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreCompteur}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/>&nbsp;&nbsp;
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.typeCompteur}"/>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid style="height:500px;background-color:#DAEECB;background-image: url('images/voiture.png');background-repeat: no-repeat;background-position: top center" id="idPanelTravaux2" width="90%"  styleClass="fichefournisseur" >
                        <h:panelGrid width="100%" columns="5" columnClasses="clos12d,clos21g,clos20,clos21g,clos12d">
                            <h:column><h:outputText value="Face Avant Gauche:"/></h:column>
                            <h:column><h:inputTextarea rows="4" cols="100" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreAvantGauche}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:inputTextarea rows="4" cols="100" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreAvantDroit}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Face Avant Droite:"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%" columns="5" columnClasses="clos12d,clos21g,clos20,clos21g,clos12d">
                            <h:column><h:outputText value="Latéral Gauche:"/></h:column>
                            <h:column><h:inputTextarea rows="4" cols="100" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreLateralGauche}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:inputTextarea rows="4" cols="100" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreLateralDroit}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Latéral Droit:"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%" columns="5" columnClasses="clos12d,clos21g,clos20,clos21g,clos12d">
                            <h:column><h:outputText value="Face Arrière Gauche:"/></h:column>
                            <h:column><h:inputTextarea rows="4" cols="100" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreArriereGauche}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:inputTextarea rows="4" cols="100" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreArriereDroit}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Face Arrière Droite:"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

            <rich:tab id="inventaireIn" label="Inventaire Entrée" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_acc_descriptif}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.autorisationDescription}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.onglet03}"/>
                <h:panelGrid  width="100%" style="max-height:100%;">
                    <h:panelGrid style="background-color:#DAEECB;" width="100%" columns="2" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Roue de secours:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreRoueSecours}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Crick:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreCrick}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Boite à outils:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreBoiteOutils}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid style="background-color:#DAEECB;" width="100%" columns="2" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Extincteur:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreExtincteur}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Trousse de secours:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreTrousseSecours}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Gilet jaune:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreGilet}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Triangle:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreTriangle}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid style="background-color:#DAEECB;" width="100%" columns="2" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Carte grise:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcorePapier1}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Visite Technique:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcorePapier2}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Carte Extincteur:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcorePapier3}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Carte Rose:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcorePapier4}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Vignette:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcorePapier5}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Assurance:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcorePapier6}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

            <rich:tab id= "imputations" label="Affectations/Imputations" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_acc_affectation}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.autorisationAffectation}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.onglet04}"/>
                <h:panelGrid  width="100%" style="max-height:100%;">
                    <h:panelGrid style="background-color:#DAEECB;" width="100%" columns="2" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Service:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreService}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}" style="width:100%">
                                <f:selectItem itemLabel="Sans service" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.mesServicesItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculChauffeur}" reRender="idChauffeur"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Chauffeur:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idChauffeur" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreIdChauffeur}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}" style="width:100%">
                                <f:selectItem itemLabel="Sans chauffeur" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.mesDemandeursItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.decoupageActivite}">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}">
                                <f:selectItem itemLabel="Sans Activité" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.mesActivitesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.decoupageActivite}">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="200px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.dataModelDecoupageActivtes}" var="saisieAnal">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.selectionAnalytique}"/>
                                    <rich:column label="Activité" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.decoupageActivite}">
                                        <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                        <h:selectOneMenu value="#{saisieAnal.zoneActivite}">
                                            <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.laColonne1Items}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.valideColonne1}" />
                                        </h:selectOneMenu>
                                    </rich:column>
                                    <rich:column label="Analytique1" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.decoupageActivite}">
                                        <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                        <h:selectOneMenu value="#{saisieAnal.zoneAnal1}">
                                            <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.laColonne2Items}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.valideColonne2}" />
                                        </h:selectOneMenu>
                                    </rich:column>
                                    <rich:column label="Analytique3" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.decoupageActivite}">
                                        <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                        <h:selectOneMenu value="#{saisieAnal.zoneAnal3}">
                                            <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.laColonne3Items}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.valideColonne3}" />
                                        </h:selectOneMenu>
                                    </rich:column>
                                    <rich:column label="%"  width="15%" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                        <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.controleEcartAnalytique}" reRender="idTableAnal" />
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column label="Supprimer répartition"  width="5%" style="text-align:center;">
                                        <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/supprimer.png" style="width:17px;height:17px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.supprimerAnalytique}" reRender="idTableAnal"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

            <rich:tab id="pieces" label="Pièces à changer (théorique)" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_acc_descriptif}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.autorisationDescription}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.onglet05}"/>
                <h:panelGrid width="100%">
                    <h:panelGroup id="panelBoutonLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_valide_parc&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_action!=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreTransmisDevis==0}">
                        <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle ligne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.addLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.add}" reRender="panelLigne,panelBoutonLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/supprimer.png" title="Supprimer la ligne en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.supprimerLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelTotal,panelLigne,tableLigne,panelBoutonLigne"/>
                    </h:panelGroup>
                    <h:panelGrid width="100%" id="panelLigne" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_valide_parc&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_action!=3}">
                        <h:panelGrid  columns="5" width="100%" id="panelLigne1" columnClasses="clos15g,clos5c,clos10g,clos70d">
                            <h:column>
                                <h:outputText value="Code" style="text-decoration:underline;"/>
                                <h:inputText tabindex="1" id="inpCodDet" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpCode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.griserchamps}">
                                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.rechercheProduits}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeProduits,formModalListeProduits,idDepot,inpCodDet,panelLigne"/>
                                </h:inputText>
                            </h:column>
                            <h:column>
                                <a4j:commandButton tabindex="2" style="height:15px;width:15px" image="/images/detail.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.detailProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_detail_prod}" reRender="idSubView,formModalDetailProd,panelDetailProd"/>
                            </h:column>
                            <h:column>
                                <h:outputText value="Référence"/>
                                <h:inputText tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpReference}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.griserchamps}" />
                            </h:column>
                            <h:column>
                                <h:outputText value="Libellé"/>
                                <h:inputText tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpLibelle}" disabled="true" style="width:100%"/>
                            </h:column>
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.type!='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreExoTva==0}">
                                <h:outputText value="Taxe" />
                                <h:selectOneMenu tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpTaxe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.griserchamps}" style="width:70px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.mesTaxesVentesProduits}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelPt,modMessageCommun"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                        </h:panelGrid>
                        <h:panelGrid columns="9" width="100%" id="panelLigne2">
                            <h:column>
                                <h:outputText value="Casier"/>
                                <h:inputText tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpCasier}" style="width:100px" disabled="true" />
                            </h:column>
                            <h:column>
                                <h:outputText value="Qte dispo."/>
                                <h:inputText tabindex="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpQteStock}" disabled="true" style="color:red;text-align:right;width:100px">
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelLigne,panelPt,panelPu,panelLigne4,modMessageCommun"/>
                                </h:inputText>
                            </h:column>
                            <h:panelGroup id="panelUnite">
                                <h:outputText value="Unité"/>
                                <h:selectOneMenu tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpUnite}" disabled="true" style="width:80px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.mesUnitesProduits}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.extractCodeUnite}" reRender="panelUnite,panelLigne2"/>
                                </h:selectOneMenu>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite>=100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite<=199}">
                                    <br>
                                    <h:outputText value="(L."/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpLong}" style="width:90px;text-align:right;"/>
                                    <h:outputText value=")"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite<=299}">
                                    <br>
                                    <h:outputText value="(L."/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpLong}" style="width:70px;text-align:right;"/>
                                    <h:outputText value="l."/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpLarg}" style="width:70px;text-align:right;"/>
                                    <h:outputText value=")"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite<=399}">
                                    <br>
                                    <h:outputText value="(L."/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpLong}" style="width:60px;text-align:right;"/>
                                    <h:outputText value="l."/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpLarg}" style="width:60px;text-align:right;"/>
                                    <h:outputText value="H."/>
                                    <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpHaut}" style="width:60px;text-align:right;"/>
                                    <h:outputText value=")"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite<=499}">
                                    <br>
                                    <h:outputText value="(L."/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpLong}" style="width:70px;text-align:right;"/>
                                    <h:outputText value="D."/>
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpLarg}" style="width:70px;text-align:right;"/>
                                    <h:outputText value=")"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite>=800&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite<=849}">
                                    <br>
                                    <h:outputText value="(Nb"/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpNb}" style="width:90px;text-align:right;"/>
                                    <h:outputText value=")"/>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite>=850&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite<=899}">
                                    <br>
                                    <h:outputText value="(P."/>
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpNb}" style="width:90px;text-align:right;"/>
                                    <h:outputText value=")"/>
                                </h:panelGroup>
                            </h:panelGroup>
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_condit}">
                                <h:outputText value="Cdt."/>
                                <h:selectOneMenu tabindex="11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpCondition}" style="width:100px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.mesConditionnementsProduits}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelLigne2,panelPu,panelPt,modMessageCommun"/>
                                </h:selectOneMenu>
                            </h:panelGroup>
                            <h:panelGroup>
                                <h:outputText value="Qte"/>
                                <h:inputText tabindex="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpQte}" style="width:90px;text-align:right;">
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelLigne2,panelPu,panelPt,modMessageCommun"/>
                                </h:inputText>
                            </h:panelGroup>
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.affichagePump}">
                                <h:outputText value="PUMP"/>
                                <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpPump}" style="width:100px;text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.verrouPump}" >
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelPt,modMessageCommun" />
                                </h:inputText>
                            </h:panelGroup>
                            <h:panelGroup id="panelPump" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.affichagePump}">
                                <h:outputText value="Total PUMP"/>
                                <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpTotal}" disabled="true" style="width:100px;text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:panelGroup>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.type!='0'}" var="garage">
                                <h:panelGroup id="panelPlancher" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.affichagePlancher&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.prixPlancher!=0}">
                                    <h:outputText value="Plancher"/>
                                    <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.prixPlancher}" style="width:100px;text-align:right;" disabled="true" >
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelPu">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.decrmtPriVteStock=='1'}">
                                        <h:outputText value="P.U.HT"/>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpPu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.verrouPrvente}" style="width:100px;text-align:right;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.decrmtPriVteStock=='2'}">
                                        <h:outputText value="P.U.TTC"/>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpPuTtc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.verrouPrvente}" style="width:100px;text-align:right;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.verrouRemise}">
                                    <h:outputText value="Remise %"/>
                                    <h:inputText tabindex="15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpTauxRemise}" style="width:70px;text-align:right;">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.verrouRabais}">
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.libelleRabRis}"/>
                                    <h:inputText tabindex="16" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpRabais}" style="width:70px;text-align:right;">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelPt">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.decrmtPriVteStock=='1'}">
                                        <h:outputText value="P.T.HT"/>
                                        <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpPt}" disabled="true" style="width:100px;text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.decrmtPriVteStock=='2'}">
                                        <h:outputText value="P.T.TTC"/>
                                        <h:inputText tabindex="18" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpTtc}" disabled="true" style="width:100px;text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                </h:panelGroup>
                            </c:if>
                            <h:column>
                                <h:outputText value="Observation"/>
                                <h:inputText tabindex="15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpObs}" maxlength="50"/>
                            </h:column>
                            <h:panelGroup>
                                <a4j:commandButton  tabindex="16" image="/images/valider_big.png" id="idValLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.validerPiece}" reRender="panelPage,panelTotal,panelLigne,tableLigne,panelBoutonLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.validationLigne<=1}"/>
                                <rich:hotKey key="return" handler="#{rich:element('idValLigne')}.click()" />
                            </h:panelGroup>
                        </h:panelGrid>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20" align="left" for="tableLigne"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_nb_max}" id="tableLigne" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.dataModelOrPiece}" var="doclig">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.selectionnerPiece}" reRender="panelLigne,panelBoutonLigne"/>
                            <rich:column sortable="false" width="14%">
                                <f:facet name="header"><h:outputText value="Code"/></f:facet>
                                <h:outputText  value="#{doclig.prcorpCode}"/>
                            </rich:column>
                            <rich:column sortable="false" width="26%">
                                <f:facet name="header"><h:outputText value="Libellé"/></f:facet>
                                <h:outputText value="#{doclig.prcorpLibelle}"/>
                            </rich:column>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText value="Casier"/></f:facet>
                                <h:outputText value="#{doclig.prcorpCasier}"/>
                            </rich:column>
                            <rich:column sortable="false" style="text-align:right;" width="10%" >
                                <f:facet name="header"><h:outputText value="Qte Dispo"/></f:facet>
                                <h:outputText value="#{doclig.prcorpQteStock}" style="color:red">
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" style="text-align:right" width="10%" >
                                <f:facet name="header"><h:outputText value="Qte Sortie"/></f:facet>
                                <h:outputText value="#{doclig.prcorpQte}">
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="6%" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Lg"/></f:facet>
                                <h:outputText value="#{doclig.prcorpLong}" rendered="#{doclig.prcorpLong!=0}"/>
                            </rich:column>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header"><h:outputText value="Unité"/></f:facet>
                                <h:outputText value="#{doclig.var_lib_uni_condit}"/>
                                <a4j:commandButton immediate="true" value="Lot" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.ouvertureLot}" rendered="#{doclig.prcorpStock==2||doclig.prcorpStock==3||doclig.prcorpStock==4}" reRender="panelLot,formModalLot,panelDetailLot" style="width:100%"/>
                                <a4j:commandButton immediate="true" value="N° Séries" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.ouvertureSerie}" rendered="#{doclig.prcorpStock==5}" reRender="panelSerie,formModalSerie" style="width:100%"/>
                            </rich:column>
                            <rich:column sortable="false" style="text-align:right;" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.affichagePump}">
                                <f:facet name="header"><h:outputText value="PUMP Unit."  /></f:facet>
                                <h:outputText value="#{doclig.prcorpPump}" rendered="#{doclig.prcorpPump!=0}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" style="text-align:right;" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.affichagePump}">
                                <f:facet name="header"><h:outputText value="Total PUMP"  /></f:facet>
                                <h:outputText value="#{doclig.prcorpTotal}" rendered="#{doclig.prcorpTotal!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </rich:tab>

            <rich:tab id="mainpoeuvre" label="Main d'Oeuvre" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_acc_descriptif}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.autorisationDescription}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.onglet06}"/>
                <h:panelGrid width="100%">
                    <h:panelGrid width="100%">
                        <h:panelGroup id="panelBoutonMo" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_valide_parc&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_action!=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreTransmisDevis==0}">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle ligne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.addLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.add}" reRender="panelMo,panelBoutonMo"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer la ligne en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.supprimerLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelTotal,panelMo,tableMo,panelBoutonMo"/>
                        </h:panelGroup>
                        <h:panelGrid width="100%" id="panelMo" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_valide_parc&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_action!=3}">
                            <h:panelGrid  columns="11" width="100%" id="panelMo1">
                                <h:column>
                                    <h:outputText value="Code" style="text-decoration:underline;"/>
                                    <h:inputText tabindex="1" id="inpCodMo" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpCode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.griserchamps}">
                                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.rechercheProduits}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeProduits,formModalListeProduits,inpCodMo,panelMo"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <a4j:commandButton tabindex="2" style="height:15px;width:15px" image="/images/detail.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.detailProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_detail_prod}" reRender="idSubView,formModalDetailProd,panelDetailProd"/>
                                </h:column>
                                <h:column>
                                    <h:outputText value="Libellé"/>
                                    <h:inputText tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpLibelle}" disabled="true" style="width:100%"/>
                                </h:column>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.type!='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreExoTva==0}">
                                    <h:outputText value="Taxe" />
                                    <h:selectOneMenu tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpTaxe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.griserchamps}" style="width:70px;">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.mesTaxesVentesProduits}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelPt,modMessageCommun"/>
                                    </h:selectOneMenu>
                                </h:panelGroup>
                                <h:panelGroup>
                                    <h:outputText value="Qte"/>
                                    <h:inputText tabindex="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpQte}" style="width:90px;text-align:right;">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelLigne2,panelPu,panelPt,modMessageCommun"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelPuMo">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.decrmtPriVteStock=='1'}">
                                        <h:outputText value="P.U.HT"/>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpPu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.verrouPrvente}" style="width:100px;text-align:right;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.decrmtPriVteStock=='2'}">
                                        <h:outputText value="P.U.TTC"/>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpPuTtc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.verrouPrvente}" style="width:100px;text-align:right;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.nbDecPu}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.verrouRemise}">
                                    <h:outputText value="Remise %"/>
                                    <h:inputText tabindex="15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpTauxRemise}" style="width:70px;text-align:right;">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.verrouRabais}">
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.libelleRabRis}"/>
                                    <h:inputText tabindex="16" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpRabais}" style="width:70px;text-align:right;">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelPtMo">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.decrmtPriVteStock=='1'}">
                                        <h:outputText value="P.T.HT"/>
                                        <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpPt}" disabled="true" style="width:100px;text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.decrmtPriVteStock=='2'}">
                                        <h:outputText value="P.T.TTC"/>
                                        <h:inputText tabindex="18" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpTtc}" disabled="true" style="width:100px;text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                </h:panelGroup>
                                <h:column>
                                    <h:outputText value="Observation"/>
                                    <h:inputText tabindex="15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpObs}" maxlength="50"/>
                                </h:column>
                                <h:panelGroup>
                                    <a4j:commandButton  tabindex="16" image="/images/valider_big.png" id="idValMo" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.validerPiece}" reRender="panelPage,panelTotal,panelLigne,tableLigne,panelBoutonLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.validationLigne<=1}"/>
                                    <rich:hotKey key="return" handler="#{rich:element('idValMo')}.click()" />
                                </h:panelGroup>
                            </h:panelGrid>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableMo" maxPages="20" align="left" for="tableMo"/>
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_nb_max}" id="tableMo" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.dataModelOrMo}" var="doclig">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.selectionnerPiece}" reRender="panelMo,panelBoutonMo"/>
                                <rich:column sortable="false" width="14%">
                                    <f:facet name="header"><h:outputText value="Code"/></f:facet>
                                    <h:outputText  value="#{doclig.prcorpCode}"/>
                                </rich:column>
                                <rich:column sortable="false" width="26%">
                                    <f:facet name="header"><h:outputText value="Libellé"/></f:facet>
                                    <h:outputText value="#{doclig.prcorpLibelle}"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right" width="10%" >
                                    <f:facet name="header"><h:outputText value="Qte Sortie"/></f:facet>
                                    <h:outputText value="#{doclig.prcorpQte}">
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.affichagePump}">
                                    <f:facet name="header"><h:outputText value="Total PUMP"  /></f:facet>
                                    <h:outputText value="#{doclig.prcorpTotal}" rendered="#{doclig.prcorpTotal!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

            <rich:tab id="devis" label="Devis client" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_acc_descriptif}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.autorisationDescription}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.onglet06}"/>
                <h:panelGrid width="100%">
                    <h:column><h:outputText value="Devis transmis au client:"/></h:column>
                    <h:column>
                        <h:selectOneMenu tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreTransmisDevis}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.griserchamps}" style="width:100%">
                            <f:selectItem itemLabel="Non transmis" itemValue="0"/>
                            <f:selectItem itemLabel="Transmis par mail" itemValue="1"/>
                            <f:selectItem itemLabel="Transmis par courrier" itemValue="2"/>
                            <f:selectItem itemLabel="Transmis par mail et courrier" itemValue="3"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelBoutonLigne"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Réponse du client:"/></h:column>
                    <h:column>
                        <h:selectOneMenu tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreReponseClient}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.griserchamps}" style="width:100%">
                            <f:selectItem itemLabel="Attente réponse" itemValue="0"/>
                            <f:selectItem itemLabel="Refus client: trop cher" itemValue="1"/>
                            <f:selectItem itemLabel="Refus client: trop long " itemValue="2"/>
                            <f:selectItem itemLabel="Refus client: Mieux ailleurs " itemValue="2"/>
                            <f:selectItem itemLabel="Acceptation client" itemValue="10"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Observations client"/></h:column>
                    <h:column><h:inputTextarea rows="4" cols="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreObservationClient}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.griserchamps}" style="width:100%;"/></h:column>
                </h:panelGrid>
            </rich:tab>

            <rich:tab id="execution" label="Execution" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_acc_descriptif}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.autorisationDescription}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.onglet06}"/>
                <h:panelGrid width="100%">
                    <h:column><h:outputText value="Etat exécution:"/></h:column>
                    <h:column>
                        <h:selectOneMenu tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreExecution}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.griserchamps}" style="width:100%">
                            <f:selectItem itemLabel="Pas exécution" itemValue="0"/>
                            <f:selectItem itemLabel="Mise en attente pour manque de pièce" itemValue="1"/>
                            <f:selectItem itemLabel="Mise ne attente pour manque de main d'oeuvre" itemValue="2"/>
                            <f:selectItem itemLabel="Réparation en cours" itemValue="3"/>
                            <f:selectItem itemLabel="Réparation terminée" itemValue="4"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelBoutonLigne"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Observations chef atelier"/></h:column>
                    <h:column><h:inputTextarea rows="4" cols="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreObservationChef}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.griserchamps}" style="width:100%;"/></h:column>
                </h:panelGrid>
            </rich:tab>

            <rich:tab id="sortie" label="Pièces changées (Réel)" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_acc_descriptif}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.autorisationDescription}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.onglet07}"/>
                <h:panelGrid width="100%">
                    <h:panelGrid width="100%">
                        <h:panelGroup id="panelBoutonLigneReel" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_valide_parc&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_action!=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreTransmisDevis==10}">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle ligne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.addLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.add}" reRender="panelLigneReel,panelBoutonLigneReel"/>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer la ligne en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.supprimerLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelTotal,panelLigneReel,tableLigneReel,panelBoutonLigneReel"/>
                        </h:panelGroup>
                        <h:panelGrid width="100%" id="panelLigneReel" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_valide_parc&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_action!=3}">
                            <h:panelGrid  columns="5" width="100%" id="panelLigne1Reel" columnClasses="clos15g,clos5c,clos10g,clos70d">
                                <h:column>
                                    <h:outputText value="Code" style="text-decoration:underline;"/>
                                    <h:inputText tabindex="1" id="inpCodDetReel" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpCode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.griserchamps}">
                                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.rechercheProduits}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeProduits,formModalListeProduits,idDepot,inpCodDet,panelLigneReel"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <a4j:commandButton tabindex="2" style="height:15px;width:15px" image="/images/detail.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.detailProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_detail_prod}" reRender="idSubView,formModalDetailProd,panelDetailProd"/>
                                </h:column>
                                <h:column>
                                    <h:outputText value="Référence"/>
                                    <h:inputText tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpReference}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.griserchamps}" />
                                </h:column>
                                <h:column>
                                    <h:outputText value="Libellé"/>
                                    <h:inputText tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpLibelle}" disabled="true" style="width:100%"/>
                                </h:column>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.type!='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreExoTva==0}">
                                    <h:outputText value="Taxe" />
                                    <h:selectOneMenu tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpTaxe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.griserchamps}" style="width:70px;">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.mesTaxesVentesProduits}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelPt,modMessageCommun"/>
                                    </h:selectOneMenu>
                                </h:panelGroup>
                            </h:panelGrid>
                            <h:panelGrid columns="9" width="100%" id="panelLigne2Reel">
                                <h:column>
                                    <h:outputText value="Casier"/>
                                    <h:inputText tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpCasier}" style="width:100px" disabled="true" />
                                </h:column>
                                <h:column>
                                    <h:outputText value="Qte dispo."/>
                                    <h:inputText tabindex="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpQteStock}" disabled="true" style="color:red;text-align:right;width:100px">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelLigne,panelPt,panelPu,panelLigne4,modMessageCommun"/>
                                    </h:inputText>
                                </h:column>
                                <h:panelGroup id="panelUniteReel">
                                    <h:outputText value="Unité"/>
                                    <h:selectOneMenu tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpUnite}" disabled="true" style="width:80px;">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.mesUnitesProduits}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.extractCodeUnite}" reRender="panelUnite,panelLigne2"/>
                                    </h:selectOneMenu>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite>=100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite<=199}">
                                        <br>
                                        <h:outputText value="(L."/>
                                        <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpLong}" style="width:90px;text-align:right;"/>
                                        <h:outputText value=")"/>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite<=299}">
                                        <br>
                                        <h:outputText value="(L."/>
                                        <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpLong}" style="width:70px;text-align:right;"/>
                                        <h:outputText value="l."/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpLarg}" style="width:70px;text-align:right;"/>
                                        <h:outputText value=")"/>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite<=399}">
                                        <br>
                                        <h:outputText value="(L."/>
                                        <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpLong}" style="width:60px;text-align:right;"/>
                                        <h:outputText value="l."/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpLarg}" style="width:60px;text-align:right;"/>
                                        <h:outputText value="H."/>
                                        <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpHaut}" style="width:60px;text-align:right;"/>
                                        <h:outputText value=")"/>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite<=499}">
                                        <br>
                                        <h:outputText value="(L."/>
                                        <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpLong}" style="width:70px;text-align:right;"/>
                                        <h:outputText value="D."/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpLarg}" style="width:70px;text-align:right;"/>
                                        <h:outputText value=")"/>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite>=800&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite<=849}">
                                        <br>
                                        <h:outputText value="(Nb"/>
                                        <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpNb}" style="width:90px;text-align:right;"/>
                                        <h:outputText value=")"/>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite>=850&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_code_unite<=899}">
                                        <br>
                                        <h:outputText value="(P."/>
                                        <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpNb}" style="width:90px;text-align:right;"/>
                                        <h:outputText value=")"/>
                                    </h:panelGroup>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_condit}">
                                    <h:outputText value="Cdt."/>
                                    <h:selectOneMenu tabindex="11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpCondition}" style="width:100px;">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.mesConditionnementsProduits}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelLigne2,panelPu,panelPt,modMessageCommun"/>
                                    </h:selectOneMenu>
                                </h:panelGroup>
                                <h:panelGroup>
                                    <h:outputText value="Qte"/>
                                    <h:inputText tabindex="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpQte}" style="width:90px;text-align:right;">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelLigne2,panelPu,panelPt,modMessageCommun"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.affichagePump}">
                                    <h:outputText value="PUMP"/>
                                    <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpPump}" style="width:100px;text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.verrouPump}" >
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelPt,modMessageCommun" />
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="panelPumpReel" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.affichagePump}">
                                    <h:outputText value="Total PUMP"/>
                                    <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpTotal}" disabled="true" style="width:100px;text-align:right;">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.type!='0'}" var="garage">
                                    <h:panelGroup id="panelPlancherReel" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.affichagePlancher&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.prixPlancher!=0}">
                                        <h:outputText value="Plancher"/>
                                        <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.prixPlancher}" style="width:100px;text-align:right;" disabled="true" >
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup id="panelPuReel">
                                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.decrmtPriVteStock=='1'}">
                                            <h:outputText value="P.U.HT"/>
                                            <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpPu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.verrouPrvente}" style="width:100px;text-align:right;">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.nbDecPu}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                            </h:inputText>
                                        </h:panelGroup>
                                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.decrmtPriVteStock=='2'}">
                                            <h:outputText value="P.U.TTC"/>
                                            <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpPuTtc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.verrouPrvente}" style="width:100px;text-align:right;">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.nbDecPu}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                            </h:inputText>
                                        </h:panelGroup>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.verrouRemise}">
                                        <h:outputText value="Remise %"/>
                                        <h:inputText tabindex="15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpTauxRemise}" style="width:70px;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.verrouRabais}">
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.libelleRabRis}"/>
                                        <h:inputText tabindex="16" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpRabais}" style="width:70px;text-align:right;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.calculPrix}" reRender="panelPt,panelLigne2,idValLigne,modMessageCommun"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup id="panelPtReel">
                                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.decrmtPriVteStock=='1'}">
                                            <h:outputText value="P.T.HT"/>
                                            <h:inputText tabindex="17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpPt}" disabled="true" style="width:100px;text-align:right;">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:panelGroup>
                                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.optionParcs.decrmtPriVteStock=='2'}">
                                            <h:outputText value="P.T.TTC"/>
                                            <h:inputText tabindex="18" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpTtc}" disabled="true" style="width:100px;text-align:right;">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:panelGroup>
                                    </h:panelGroup>
                                </c:if>
                                <h:column>
                                    <h:outputText value="Observation"/>
                                    <h:inputText tabindex="15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrPiece.prcorpObs}" maxlength="50"/>
                                </h:column>
                                <h:panelGroup>
                                    <a4j:commandButton  tabindex="16" image="/images/valider_big.png" id="idValLigneReel" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.validerPieceReel}" reRender="panelPage,panelTotal,panelLigne,tableLigne,panelBoutonLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.validationLigne<=1}"/>
                                    <rich:hotKey key="return" handler="#{rich:element('idValLigneReel')}.click()" />
                                </h:panelGroup>
                            </h:panelGrid>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableReel" maxPages="20" align="left" for="tableLigneReel"/>
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_nb_max}" id="tableLigneReel" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.dataModelOrPieceReel}" var="doclig">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.selectionnerPieceReel}" reRender="panelLigneReel,panelBoutonLigneReel"/>
                                <rich:column sortable="false" width="14%">
                                    <f:facet name="header"><h:outputText value="Code"/></f:facet>
                                    <h:outputText  value="#{doclig.prcorpCode}"/>
                                </rich:column>
                                <rich:column sortable="false" width="26%">
                                    <f:facet name="header"><h:outputText value="Libellé"/></f:facet>
                                    <h:outputText value="#{doclig.prcorpLibelle}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText value="Casier"/></f:facet>
                                    <h:outputText value="#{doclig.prcorpCasier}"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="10%" >
                                    <f:facet name="header"><h:outputText value="Qte Dispo"/></f:facet>
                                    <h:outputText value="#{doclig.prcorpQteStock}" style="color:red">
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right" width="10%" >
                                    <f:facet name="header"><h:outputText value="Qte Sortie"/></f:facet>
                                    <h:outputText value="#{doclig.prcorpQte}">
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" width="6%" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Lg"/></f:facet>
                                    <h:outputText value="#{doclig.prcorpLong}" rendered="#{doclig.prcorpLong!=0}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText value="Unité"/></f:facet>
                                    <h:outputText value="#{doclig.var_lib_uni_condit}"/>
                                    <a4j:commandButton immediate="true" value="Lot" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.ouvertureLot}" rendered="#{doclig.prcorpStock==2||doclig.prcorpStock==3||doclig.prcorpStock==4}" reRender="panelLot,formModalLot,panelDetailLot" style="width:100%"/>
                                    <a4j:commandButton immediate="true" value="N° Séries" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.ouvertureSerie}" rendered="#{doclig.prcorpStock==5}" reRender="panelSerie,formModalSerie" style="width:100%"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.affichagePump}">
                                    <f:facet name="header"><h:outputText value="PUMP Unit."  /></f:facet>
                                    <h:outputText value="#{doclig.prcorpPump}" rendered="#{doclig.prcorpPump!=0}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.affichagePump}">
                                    <f:facet name="header"><h:outputText value="Total PUMP"  /></f:facet>
                                    <h:outputText value="#{doclig.prcorpTotal}" rendered="#{doclig.prcorpTotal!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

            <rich:tab id="inventaireOut" label="Inventaire Sortie" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_acc_descriptif}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.autorisationDescription}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.onglet08}"/>
                <h:panelGrid  width="100%" style="max-height:100%;">
                    <h:panelGrid style="background-color:#DAEECB;" width="100%" columns="2" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Roue de secours:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreRoueSecoursFin}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Crick:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreCrickFin}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Boite à outils:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreBoiteOutilsFin}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid style="background-color:#DAEECB;" width="100%" columns="2" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Extincteur:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreExtincteurFin}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Trousse de secours:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreTrousseSecoursFin}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Gilet jaune:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreGiletFin}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Triangle:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcoreTriangleFin}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid style="background-color:#DAEECB;" width="100%" columns="2" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Carte grise:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcorePapier1Fin}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Visite Technique:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcorePapier2Fin}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Carte Extincteur:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcorePapier3Fin}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Carte Rose:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcorePapier4Fin}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Vignette:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcorePapier5Fin}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Assurance:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.parcOrEntete.prcorePapier6Fin}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_aff_action}"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

        </rich:tabPanel>

        <center>
            <br>
            <h:panelGroup id="valParc">
                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.annulerOr}" image="/images/annuler_big.png" style="width:30px;height:30px"/>&nbsp;&nbsp;&nbsp;&nbsp;
                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.saveOr}" image="/images/valider_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_valide_parc&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcOr.var_action!=3}"/>
            </h:panelGroup>
        </center>

    </a4j:form>

</f:subview>
