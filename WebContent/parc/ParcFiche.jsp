<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="ficheparc">

    <a4j:form enctype="multipart/form-data">

        <center> <h2><h:outputText value="DESCRIPTION DU PARC" style="color:green;"/></h2></center>

        <rich:tabPanel switchType="client" immediate="true"  id="tabPanelparc" style="border:0px;">

            <rich:tab label="Identification" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_acc_descriptif}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.autorisationDescription}">
                <h:panelGrid  width="100%" style="max-height:100%;">
                    <h:panelGrid style="background-color:#DAEECB;" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur">
                        <h:column><h:outputText style="text-decoration:underline;" value="Nature:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_nature}">
                                <f:selectItem itemLabel="Sélectionnez une nature" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.mesNatureItems}" />
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.calculeNature}" reRender="infoNature,valParc,famille"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="N° immat./ID:"/></h:column>
                        <h:column>
                            <h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcImmatriculation}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcId!=0}"/>&nbsp;&nbsp;&nbsp;
                            <h:outputText value="N° balise:"/>&nbsp;&nbsp;
                            <h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcBalise}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcId!=0}"/>
                        </h:column>
                        <h:column><h:outputText style="text-decoration:underline;" value="Famille:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="famille" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_famille}">
                                <f:selectItem itemLabel="Sélectionnez une famille" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.mesFamilleItems}" />
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.calculeSousFamille}" reRender="sousFamille"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText style="text-decoration:underline;" value="Sous famille:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="sousFamille" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_sousFamille}">
                                <f:selectItem itemLabel="Sélectionnez une sous famille" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.mesSousFamilleItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Marque:"/></h:column>
                        <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcMarque}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                        <h:column><h:outputText value="Origine:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcOrigine}">
                                <f:selectItem itemLabel="Interne" itemValue="0"/>
                                <f:selectItem itemLabel="Externe" itemValue="1"/>
                                <f:selectItem itemLabel="Fabriqué" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>

                    <h:panelGrid id="infoNature" width="100%">
                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_infoNature==1}">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_moteur==1}"><h:outputText value="N° moteur:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_moteur==1}"><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcMoteur}"/></h:column>
                            <h:column><h:outputText value="N° chassis:"/></h:column>
                            <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcChassis}"/></h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Alimentation:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_moteur==1}">
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcAlimentation}">
                                    <f:selectItem itemLabel="Sans" itemValue="0"/>
                                    <f:selectItem itemLabel="Essence" itemValue="1"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.calculeEssence}" reRender="infoNature,moto1,moto2"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column id="moto1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_moteur==1}"><h:outputText style="text-decoration:underline;" value="Essence:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_essence==1}"/></h:column>
                            <h:column id="moto2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_moteur==1}">
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcEssence}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_essence==1}">
                                    <f:selectItem itemLabel="Ordinaire" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Compteur:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcCompteur}">
                                    <f:selectItem itemLabel="Distance" itemValue="0"/>
                                    <f:selectItem itemLabel="Kilométrique" itemValue="1"/>
                                    <f:selectItem itemLabel="Horaire" itemValue="2"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_moteur==1}"><h:outputText value="Volt:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_moteur==1}"><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcVolt}"/>&nbsp;&nbsp;&nbsp;<h:outputText value="Amprère:"/>&nbsp<h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcAmpere}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_moteur==1}"><h:outputText value="Nb chevaux:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_moteur==1}"><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcPuisChev}"/>&nbsp;&nbsp;&nbsp;<h:outputText value="Puis. fiscale:"/>&nbsp<h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcPuisFiscale}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_moteur==1}"><h:outputText value="Conso. moy.:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_moteur==1}"><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcConsommation}"/>&nbsp;&nbsp;&nbsp;<h:outputText value="Cote. moy.:"/>&nbsp<h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcCote}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_infoNature==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_infoNature==3}">
                            <h:column><h:outputText value="N° moteur:"/></h:column>
                            <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcMoteur}"/></h:column>
                            <h:column><h:outputText value="N° chassis:"/></h:column>
                            <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcChassis}"/></h:column>
                            <h:column><h:outputText value="N° arrangement:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_infoNature==3}"/></h:column>
                            <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcArrangement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_infoNature==3}"/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Alimentation:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcAlimentation}">
                                    <f:selectItem itemLabel="Sans" itemValue="0"/>
                                    <f:selectItem itemLabel="Essence" itemValue="1"/>
                                    <f:selectItem itemLabel="Gazoil" itemValue="2"/>
                                    <f:selectItem itemLabel="GPL" itemValue="3"/>
                                    <f:selectItem itemLabel="Kérosène" itemValue="4"/>
                                    <f:selectItem itemLabel="Fuel" itemValue="5"/>
                                    <f:selectItem itemLabel="Jet A1" itemValue="6"/>
                                    <f:selectItem itemLabel="Electrique" itemValue="7"/>
                                    <f:selectItem itemLabel="Hybride" itemValue="8"/>
                                    <f:selectItem itemLabel="Solaire" itemValue="9"/>
                                    <f:selectItem itemLabel="Charbon" itemValue="10"/>
                                    <f:selectItem itemLabel="Nucléaire" itemValue="11"/>
                                    <f:selectItem itemLabel="Autre" itemValue="12"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.calculeEssence}" reRender="infoNature,essence1,essence2"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column id="essence1"><h:outputText style="text-decoration:underline;" value="Essence:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_essence==1}"/></h:column>
                            <h:column id="essence2">
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcEssence}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_essence==1}">
                                    <f:selectItem itemLabel="Ordinaire" itemValue="1"/>
                                    <f:selectItem itemLabel="Super 98" itemValue="2"/>
                                    <f:selectItem itemLabel="Super 99" itemValue="3"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Compteur:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcCompteur}">
                                    <f:selectItem itemLabel="Distance" itemValue="0"/>
                                    <f:selectItem itemLabel="Kilométrique" itemValue="1"/>
                                    <f:selectItem itemLabel="Horaire" itemValue="2"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Volt:"/></h:column>
                            <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcVolt}"/>&nbsp;&nbsp;&nbsp;<h:outputText value="Amprère:"/>&nbsp<h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcAmpere}"/></h:column>
                            <h:column><h:outputText value="Nb chevaux:"/></h:column>
                            <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcPuisChev}"/>&nbsp;&nbsp;&nbsp;<h:outputText value="Puis. fiscale:"/>&nbsp<h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcPuisFiscale}"/></h:column>
                            <h:column><h:outputText value="Conso. moy.:"/></h:column>
                            <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcConsommation}"/>&nbsp;&nbsp;&nbsp;<h:outputText value="Cote. moy.:"/>&nbsp<h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcCote}"/></h:column>
                        </h:panelGrid>

                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_infoNature==4}">
                        </h:panelGrid>

                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_infoNature==5}">
                        </h:panelGrid>

                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_infoNature==6}">
                        </h:panelGrid>

                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_infoNature==7}">
                            <h:column><h:outputText value="N° moteur:"/></h:column>
                            <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcMoteur}"/></h:column>
                            <h:column><h:outputText value="N° chassis:"/></h:column>
                            <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcChassis}"/></h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Alimentation:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcAlimentation}">
                                    <f:selectItem itemLabel="Sans" itemValue="0"/>
                                    <f:selectItem itemLabel="Essence" itemValue="1"/>
                                    <f:selectItem itemLabel="Gazoil" itemValue="2"/>
                                    <f:selectItem itemLabel="GPL" itemValue="3"/>
                                    <f:selectItem itemLabel="Kérosène" itemValue="4"/>
                                    <f:selectItem itemLabel="Fuel" itemValue="5"/>
                                    <f:selectItem itemLabel="Jet A1" itemValue="6"/>
                                    <f:selectItem itemLabel="Electrique" itemValue="7"/>
                                    <f:selectItem itemLabel="Hybride" itemValue="8"/>
                                    <f:selectItem itemLabel="Solaire" itemValue="9"/>
                                    <f:selectItem itemLabel="Charbon" itemValue="10"/>
                                    <f:selectItem itemLabel="Nucléaire" itemValue="11"/>
                                    <f:selectItem itemLabel="Autre" itemValue="12"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.calculeEssence}" reRender="infoNature,machine1,machine2"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column id="machine1"><h:outputText style="text-decoration:underline;" value="Essence:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_essence==1}"/></h:column>
                            <h:column id="machine2">
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcEssence}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_essence==1}">
                                    <f:selectItem itemLabel="Ordinaire" itemValue="1"/>
                                    <f:selectItem itemLabel="Super 98" itemValue="2"/>
                                    <f:selectItem itemLabel="Super 99" itemValue="3"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Compteur:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcCompteur}">
                                    <f:selectItem itemLabel="Horaire" itemValue="2"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Volt:"/></h:column>
                            <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcVolt}"/>&nbsp;&nbsp;&nbsp;<h:outputText value="Amprère:"/>&nbsp<h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcAmpere}"/></h:column>
                            <h:column><h:outputText value="Nb chevaux:"/></h:column>
                            <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcPuisChev}"/>&nbsp;&nbsp;&nbsp;<h:outputText value="Puis. fiscale:"/>&nbsp<h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcPuisFiscale}"/></h:column>
                            <h:column><h:outputText value="Conso. moy.:"/></h:column>
                            <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcConsommation}"/>&nbsp;&nbsp;&nbsp;<h:outputText value="Cote. moy.:"/>&nbsp<h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcCote}"/></h:column>
                        </h:panelGrid>

                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_infoNature==8}">
                            <h:column><h:outputText value="Marque:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcMarque}" style="width:100%" maxlength="50"/></h:column>
                            <h:column><h:outputText value="Modèle:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcModele}" style="width:100%" maxlength="50"/></h:column>
                            <h:column><h:outputText value="N° série:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcNumSerie}" style="width:100%" maxlength="50"/></h:column>
                            <h:column><h:outputText value="Processeur:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1771'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1772'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1773'}"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcProcesseur}" style="width:100%" maxlength="50" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1771'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1772'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1773'}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1771'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1772'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1773'}"><h:outputText value="OS:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1771'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1772'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1773'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcOs}" style="width:100%" maxlength="50"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1771'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1772'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1773'}"><h:outputText value=""/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1771'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1772'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1773'}"><h:outputText value=""/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1771'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1772'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1773'}"><h:outputText value="Mémoire:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1771'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1772'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1773'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcMemoire}" style="width:100%" maxlength="50"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1771'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1772'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1773'}"><h:outputText value="Disque dur:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1771'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1772'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1773'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcDd}" style="width:100%" maxlength="50"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1774'}"><h:outputText value="Type imprimante:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1774'}">
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcTypeImprimante}">
                                    <f:selectItem itemLabel="Matricielle" itemValue="Matricielle"/>
                                    <f:selectItem itemLabel="Jet d`encre" itemValue="Jet d`encre"/>
                                    <f:selectItem itemLabel="Laser" itemValue="Laser"/>
                                    <f:selectItem itemLabel="Thermique" itemValue="Thermique"/>
                                    <f:selectItem itemLabel="Autre" itemValue="Autre"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1774'}"><h:outputText value="Modèle cartouche"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.type_nature=='1774'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcCartouche}" style="width:100%" maxlength="50"/></h:column>
                            <h:column><h:outputText value="Volt:"/></h:column>
                            <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcVolt}"/></h:column>
                            <h:column><h:outputText value="Amprère:"/></h:column>
                            <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcAmpere}"/></h:column>
                        </h:panelGrid>

                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_infoNature==9}">
                            <h:column><h:outputText value="Volt:"/></h:column>
                            <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcVolt}"/>&nbsp;&nbsp;&nbsp;<h:outputText value="Amprère:"/>&nbsp<h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcAmpere}"/></h:column>                   
                        </h:panelGrid>

                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_infoNature==10}">
                            <h:column><h:outputText value="Volt:"/></h:column>
                            <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcVolt}"/>&nbsp;&nbsp;&nbsp;<h:outputText value="Amprère:"/>&nbsp<h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcAmpere}"/></h:column>                           
                        </h:panelGrid>

                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_infoNature==11}">
                        </h:panelGrid>

                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_infoNature==12}">
                        </h:panelGrid>

                    </h:panelGrid>

                    <h:panelGrid style="background-color:#DAEECB;" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Libellé:"/></h:column>
                        <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcNomFr}"/></h:column>
                        <h:column><h:outputText style="text-decoration:underline;" value="Mode:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcFonction}">
                                <f:selectItem itemLabel="En Fonction" itemValue="0"/>
                                <f:selectItem itemLabel="En Arrêt" itemValue="1"/>
                                <f:selectItem itemLabel="En Panne" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>

                </h:panelGrid>
                <center>
                    <br>
                    <h:panelGroup id="valParc">
                        <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.annulerParc}" image="/images/annuler_big.png" style="width:30px;height:30px"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.saveParc}" image="/images/valider_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_valide_parc&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_action!=3}"/>
                    </h:panelGroup>
                </center>
            </rich:tab>

            <rich:tab label="Photos" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_acc_photo}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.autorisationPhoto}">
                <jsp:include flush="true" page="/parc/ParcCommun.jsp" />
                <h:panelGrid id="panPhoto" columns="2" style="height:150px" width="100%" styleClass="top" headerClass="headerTab">
                    <f:facet name="header"><h:outputText value="Photo"/></f:facet>
                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcPhoto==null}">
                        <t:inputFileUpload id="file" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.uploadedFile}"/>
                        <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.ajoutPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_action==3}">
                            <a4j:support eventsQueue="maQueue"  immediate="true" reRender="grp3"/>
                        </h:commandButton>
                        <h:message for="file" infoStyle="color: green;" errorStyle="color: red;" />
                    </h:panelGroup>
                    <br/>
                    <h:panelGroup  id="grp3">
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcPhoto!=null}">
                            <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.urlphotoProd}" width="150px" height="150px"/>&nbsp;
                            <h:panelGrid columns="2" width="150px">
                                <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcPhotoTaille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_action==3}">
                                    <f:selectItem itemLabel="Petit format" itemValue="0"/>
                                    <f:selectItem itemLabel="Grand format" itemValue="1"/>
                                </h:selectOneRadio>
                                <h:commandButton image="/images/supprimer.png" title="supprimer photo" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette photo ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.reInitPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_action==3}"/>
                            </h:panelGrid>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcPhoto==null}">
                            <img alt="" src="images/no_image.jpeg" width="150px" height="150px" />
                        </c:if>
                    </h:panelGroup>
                </h:panelGrid>
            </rich:tab>

            <rich:tab label="Affectations/Imputations" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_acc_affectation}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.autorisationAffectation}">
                <jsp:include flush="true" page="/parc/ParcCommun.jsp" />
                <h:panelGrid  width="100%" columns="2">
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcOrigine==0}">
                        <h:panelGrid  id="boutonAffectation" columns="3" width="200px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_action!=3}">
                            <a4j:commandButton title="Ajouter une nouvelle affectation" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.ajouterAffectation}" reRender="panelAffectation,formAff"/>
                            <a4j:commandButton title="Modifier l'affectation sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_affiche_affectation&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.modifierAffectation}" reRender="panelAffectation,formAff"/>
                            <a4j:commandButton title="Supprimer l'affectation sélectionnée" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_affiche_affectation&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.supprimerAffectation}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="boutonAffectation,tableAffectation"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable width="100%" headerClass="headerTab" id="tableAffectation" enableContextMenu="false" selectedClass="active-row" var="affec" style="max-height:100%;border:solid 0px green;cursor:pointer;" styleClass="bg" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.datamodelAffectation}">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.selectionAffectation}" reRender="boutonAffectation"/>
                                <rich:column  width="60%">
                                    <f:facet name="header"><h:outputText  value="Agent" /></f:facet>
                                    <h:outputText value="#{affec.prcaffMatSalarie} #{affec.prcaffNomSalarie}  #{affec.prcaffPrenomSalarie}"/>
                                </rich:column>
                                <rich:column  width="20%" sortOrder="#{affec.prcaffDateDebut}">
                                    <f:facet name="header"><h:outputText  value="Du" /></f:facet>
                                    <h:outputText value="#{affec.prcaffDateDebut}"/>
                                </rich:column>
                                <rich:column  width="20%" >
                                    <f:facet name="header"><h:outputText  value="Au" /></f:facet>
                                    <h:outputText value="#{affec.prcaffDateFin}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcOrigine==0}">
                        <h:panelGrid  id="boutonImputation" columns="3" width="200px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_action!=3}">
                            <a4j:commandButton title="Ajouter une nouvelle imputation" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.ajouterImputation}" reRender="panelImputation,formImp"/>
                            <a4j:commandButton title="Modifier l'imputation sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_affiche_imputation&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.modifierImputation}" reRender="panelImputation,formImp"/>
                            <a4j:commandButton title="Supprimer l'imputation sélectionnée" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_affiche_imputation&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.supprimerImputation}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="boutonImputation,tableImputation"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable width="100%" headerClass="headerTab" id="tableImputation" enableContextMenu="false" selectedClass="active-row" var="imput" style="max-height:100%;border:solid 0px green;cursor:pointer;" styleClass="bg" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.datamodelImputation}">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.selectionImputation}" reRender="boutonImputation"/>
                                <rich:column  width="60%" >
                                    <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                                    <h:outputText value="#{imput.prcaffService} #{imput.prcaffLibService}"/>
                                </rich:column>
                                <rich:column  width="20%" sortOrder="#{imput.prcaffDateDebut}">
                                    <f:facet name="header"><h:outputText  value="Du" /></f:facet>
                                    <h:outputText value="#{imput.prcaffDateDebut}"/>
                                </rich:column>
                                <rich:column  width="20%" >
                                    <f:facet name="header"><h:outputText  value="Au" /></f:facet>
                                    <h:outputText value="#{imput.prcaffDateFin}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcOrigine==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcOrigine==2}">
                        <h:panelGrid  id="boutonProprietaire" columns="3" width="200px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_action!=3}">
                            <a4j:commandButton title="Ajouter un nouveau propriétaire" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.ajouterProprietaire}" reRender="panelProprietaire,formPro"/>
                            <a4j:commandButton title="Modifier le propriétaire sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_affiche_proprietaire&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.modifierProprietaire}" reRender="panelProprietaire,formPro"/>
                            <a4j:commandButton title="Supprimer le propriétaire sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_affiche_proprietaire&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.supprimerProprietaire}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="boutonProprietaire,tableProprietaire"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable width="100%" headerClass="headerTab" id="tableProprietaire" enableContextMenu="false" selectedClass="active-row" var="proprio" style="max-height:100%;border:solid 0px green;cursor:pointer;" styleClass="bg" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.datamodelProprietaire}">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.selectionProprietaire}" reRender="boutonProprietaire"/>
                                <rich:column  width="50%" >
                                    <f:facet name="header"><h:outputText  value="Nom propriétaire" /></f:facet>
                                    <h:outputText value="#{proprio.prcaffNomTiers}"/>
                                </rich:column>
                                <rich:column  width="20%" sortOrder="#{imput.prcaffContactTiers}">
                                    <f:facet name="header"><h:outputText  value="Contact" /></f:facet>
                                    <h:outputText value="#{proprio.prcaffContactTiers}"/>
                                </rich:column>
                                <rich:column  width="10%" sortOrder="#{imput.prcaffTelTiers}">
                                    <f:facet name="header"><h:outputText  value="Téléphone" /></f:facet>
                                    <h:outputText value="#{proprio.prcaffTelTiers}"/>
                                </rich:column>
                                <rich:column  width="10%" sortOrder="#{imput.prcaffDateDebut}">
                                    <f:facet name="header"><h:outputText  value="Du" /></f:facet>
                                    <h:outputText value="#{proprio.prcaffDateDebut}"/>
                                </rich:column>
                                <rich:column  width="10%" >
                                    <f:facet name="header"><h:outputText  value="Au" /></f:facet>
                                    <h:outputText value="#{proprio.prcaffDateFin}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcOrigine==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcOrigine==2}">
                    </h:column>
                </h:panelGrid>
            </rich:tab>           

            <rich:tab label="Comptabilité" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_acc_comptabilite}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.autorisationComptabilite}">
                <jsp:include flush="true" page="/parc/ParcCommun.jsp" />
                <h:panelGrid  width="100%" style="max-height:100%;" columns="4" columnClasses="clos15,clos35,clos15,clos35" id="idCompta">
                    <h:column><h:outputText value="N° immobilisation:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_presence_compta}"/></h:column>
                    <h:column>
                        <h:inputText id="idImmo" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcImmobilisation}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_presence_compta}">
                            <rich:toolTip id="tooladd1" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un numéro de compte ou d'un libellé de compte" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.rechercheImmobilisation}" reRender="panelImmobilisation"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value="Date achat:"/></h:column>
                    <h:column><h:inputText id="idDteAch" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcDateAchat}"/></h:column>
                    <h:column><h:outputText value="Prix achat:"/></h:column>
                    <h:column>
                        <h:inputText id="idValAch" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcPrixAchat}" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Prix cession:"/></h:column>
                    <h:column>
                        <h:inputText id="idValCes" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcPrixCession}" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value="Valeur argus:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcPrixArgus}" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Prix revient:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcPrixRevient}" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>                   
                    <h:column><h:outputText value="Prix location:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcPrixVente}" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                </h:panelGrid>
                <center>
                    <br>
                    <h:panelGroup>
                        <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.annulerParc}" image="/images/annuler_big.png" style="width:30px;height:30px"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.saveParc}" image="/images/valider_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_valide_parc&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_action!=3}"/>
                    </h:panelGroup>
                </center>
            </rich:tab>

            <rich:tab label="Etat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_acc_etat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.autorisationEtat}">
                <jsp:include flush="true" page="/parc/ParcCommun.jsp" />
                <h:panelGrid  width="100%" style="max-height:100%;">
                </h:panelGrid>
            </rich:tab>

            <rich:tab label="Caractéristiques" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_acc_caracteristique&&false}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.autorisationCaracteristique}">
                <jsp:include flush="true" page="/parc/ParcCommun.jsp" />
                <h:panelGrid  width="100%" style="max-height:100%;">
                </h:panelGrid>
            </rich:tab>

            <rich:tab label="Inventaires" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parc.prcId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_acc_inventaire&&false}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.autorisationInventaire}">
                <jsp:include flush="true" page="/parc/ParcCommun.jsp" />
                <h:panelGrid  width="100%" style="max-height:100%;" columns="2" columnClasses="clos35,clos65g">
                    <h:panelGrid  width="100%" style="max-height:100%;">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable width="100%" headerClass="headerTab" id="tableInventaire" enableContextMenu="false" selectedClass="active-row" var="inv" style="max-height:100%;border:solid 0px green;cursor:pointer;" styleClass="bg" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.dataModelInventaires}">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.selectionInventaire}" reRender="boutonInventaire,tableParcInventaire"/>
                                <rich:column  width="60%">
                                    <f:facet name="header"><h:outputText  value="NATURE" /></f:facet>
                                    <h:outputText value="#{inv.libInventaire}"/>
                                </rich:column>
                                <rich:column  width="20%">
                                    <f:facet name="header"><h:outputText  value="LIBELLE" /></f:facet>
                                    <h:outputText value="#{inv.carLibelle}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                    <h:panelGrid  width="100%" style="max-height:100%;">
                        <h:panelGrid  id="boutonInventaire" columns="3" width="200px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_action!=3}">
                            <a4j:commandButton title="Ajouter un nouvel inventaire" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.ajouterInventaire}" reRender="panelInventaire"/>
                            <a4j:commandButton title="Modifier l'inventaire sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_affiche_imputation&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.modifierInventaire}" reRender="panelInventaire"/>
                            <a4j:commandButton title="Supprimer l'inventaire sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_affiche_imputation&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.supprimerInventaire}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="boutonImputation,tableImputation"/>
                        </h:panelGrid>
                        <rich:extendedDataTable width="100%" headerClass="headerTab" id="tableParcInventaire" enableContextMenu="false" selectedClass="active-row" var="invPrc" style="max-height:100%;border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.dataModelParcInventaires}">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.selectionParcInventaire}" reRender="boutonInventaire"/>
                            <rich:column  width="60%" >
                                <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                                <h:outputText value="#{invPrc.prccarLibelle}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

        </rich:tabPanel>

    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel"id="panelImmobilisation"  width="900" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.showModalPanelImmobilisation}">
        <f:facet name="header">
            <h:panelGroup>
                <center> <h:outputText value="LISTE DES IMMOBILISATIONS"></h:outputText></center>
            </h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <a4j:form>
                <a4j:commandButton image="/images/close.gif" styleClass="hidelink" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.annuleImmobilisation}" reRender="idImmo,idCompta" style="text-decoration:none;" id="idCancel">
                    <rich:componentControl for="panelImmobilisation" attachTo="idCancel" operation="hide" event="onclick"/>
                </a4j:commandButton>
            </a4j:form>
        </f:facet>
        <a4j:form>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable height="400px" width="100%" headerClass="headerTab" selectedClass="active-row" var="immo" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.datamodelImmobilisation}">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.selectionImmobilisation}"/>
                    <rich:column  width="20%" >
                        <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                        <h:outputText value="#{immo.amoNum}"/>
                    </rich:column>
                    <rich:column  width="20%"  >
                        <f:facet name="header"><h:outputText  value="ACHAT" /></f:facet>
                        <h:outputText value="#{immo.amoDateAchat}" />
                    </rich:column>
                    <rich:column  width="20%"  >
                        <f:facet name="header"><h:outputText  value="VALEUR" /></f:facet>
                        <h:outputText value="#{immo.amoValeurAchat}" />
                    </rich:column>
                    <rich:column  width="40%"  >
                        <f:facet name="header"><h:outputText  value="LIBELLE" /></f:facet>
                        <h:outputText value="#{immo.amoLibelle}" />
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br><br>
            <center>
                <h:panelGroup >
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.valideImmobilisation}" reRender="idImmo,idCompta,idDteAch,idValAch,idValCes" style="text-decoration:none;" id="idVal">
                        <rich:componentControl for="panelImmobilisation" attachTo="idVal" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelAffectation"  width="500" height="400" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.showModalPanelAffectation}">
        <f:facet name="header">
            <h:panelGroup>
                <center> <h:outputText value="GESTION DES AFFECTATIONS (SALARIES)"></h:outputText></center>
            </h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <a4j:form>
                <a4j:commandButton image="/images/close.gif" styleClass="hidelink" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.annuleAffectation}" style="text-decoration:none;" id="idCancelAff" reRender="panelAffectation"/>
            </a4j:form>
        </f:facet>
        <a4j:form id="formAff">
            <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80">
                <h:column><h:outputText value="Matricule:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:inputText id="idMat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parcAffectation.prcaffMatSalarie}" size="10" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parcAffectation.prcaffId!=0}">
                        <rich:toolTip id="tooladd2" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début du matricule ou du nom ou du prénom du salarié" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.rechercheSalarie}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelSalaries"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Nom:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parcAffectation.prcaffNomSalarie}" readonly="true" style="width:100%"/></h:column>
                <h:column><h:outputText value="Prénom:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parcAffectation.prcaffPrenomSalarie}" readonly="true" style="width:100%"/></h:column>
                <h:column><h:outputText value="Date début:"/></h:column>
                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parcAffectation.prcaffDateDebut}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8" /></h:column>
                <h:column><h:outputText value="Date fin:"/></h:column>
                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parcAffectation.prcaffDateFin}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8" /></h:column>
            </h:panelGrid>
            <br><br>
            <center>
                <h:panelGroup id="idValAff">
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.saveAffectation}" reRender="tableAffectation,boutonAffectation,panelAffectation" style="text-decoration:none;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_affiche_valide_affectation}"/>
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelSalaries"  width="900" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.showModalPanelSalaries}">
        <f:facet name="header">
            <h:panelGroup>
                <center> <h:outputText value="LISTE DES SALARIES"></h:outputText></center>
            </h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <a4j:form>
                <a4j:commandButton image="/images/close.gif" styleClass="hidelink" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.annuleSalarie}" reRender="idMat,idNom,idPrenom,idValAff,panelSalaries" style="text-decoration:none;" id="idCancelSal"/>
            </a4j:form>
        </f:facet>
        <a4j:form>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable height="400px" width="100%" headerClass="headerTab" selectedClass="active-row" var="sal" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.datamodelSalaries}">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.selectionSalarie}"/>
                    <rich:column  width="10%" >
                        <f:facet name="header"><h:outputText  value="MATRICULE" /></f:facet>
                        <h:outputText value="#{sal.salMatricule}"/>
                    </rich:column>
                    <rich:column  width="40%"  >
                        <f:facet name="header"><h:outputText  value="NOM" /></f:facet>
                        <h:outputText value="#{sal.salNom}" />
                    </rich:column>
                    <rich:column  width="30%"  >
                        <f:facet name="header"><h:outputText  value="PRENOM" /></f:facet>
                        <h:outputText value="#{sal.salPrenom}" />
                    </rich:column>
                    <rich:column  width="20%"  >
                        <f:facet name="header"><h:outputText  value="SERVICE" /></f:facet>
                        <h:outputText value="#{sal.salService}" />
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br><br>
            <center>
                <h:panelGroup >
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.valideSalarie}" reRender="idMat,idNom,idPrenom,idValAff,panelSalaries" style="text-decoration:none;" id="idValSal"/>
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelImputation"  width="500" height="400" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.showModalPanelImputation}">
        <f:facet name="header">
            <h:panelGroup>
                <center> <h:outputText value="GESTION DES IMPUTATIONS (SERVICES)"></h:outputText></center>
            </h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <a4j:form>
                <a4j:commandButton image="/images/close.gif" styleClass="hidelink" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.annuleImputation}" style="text-decoration:none;" id="idCancelImp" reRender="panelImputation"/>
            </a4j:form>
        </f:facet>
        <a4j:form id="formImp">
            <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80">
                <h:column><h:outputText value="Service:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:inputText id="idCode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parcImputation.prcaffService}" size="10" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parcImputation.prcaffId!=0}">
                        <rich:toolTip id="tooladd3" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début du code ou du libellé du service" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.rechercheService}" reRender="panelServices"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Libellé:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parcImputation.prcaffLibService}" readonly="true" style="width:100%"/></h:column>
                <h:column><h:outputText value="Date début:"/></h:column>
                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parcImputation.prcaffDateDebut}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8" /></h:column>
                <h:column><h:outputText value="Date fin:"/></h:column>
                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parcImputation.prcaffDateFin}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8" /></h:column>
            </h:panelGrid>
            <br><br>
            <center>
                <h:panelGroup >
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.saveImputation}" reRender="tableImputation,boutonImputation,panelImputation" style="text-decoration:none;" id="idValImp" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_affiche_valide_imputation}"/>
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel"id="panelServices"  width="900" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.showModalPanelServices}">
        <f:facet name="header">
            <h:panelGroup>
                <center> <h:outputText value="LISTE DES SERVICES"></h:outputText></center>
            </h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <a4j:form>
                <a4j:commandButton image="/images/close.gif" styleClass="hidelink" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.annuleSalarie}" reRender="idCode,idLibelle,idValImp" style="text-decoration:none;" id="idCancelSer">
                    <rich:componentControl for="panelServices" attachTo="idCancelSer" operation="hide" event="onclick"/>
                </a4j:commandButton>
            </a4j:form>
        </f:facet>
        <a4j:form>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable height="400px" width="100%" headerClass="headerTab" selectedClass="active-row" var="ser" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.datamodelServices}">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.selectionService}"/>
                    <rich:column  width="30%" >
                        <f:facet name="header"><h:outputText  value="CODE" /></f:facet>
                        <h:outputText value="#{ser.serCode}"/>
                    </rich:column>
                    <rich:column  width="70%"  >
                        <f:facet name="header"><h:outputText  value="LIBELLE" /></f:facet>
                        <h:outputText value="#{ser.serNomFr}" />
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br><br>
            <center>
                <h:panelGroup >
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.valideService}" reRender="formImp,idCode,idLibelle,idValImp" style="text-decoration:none;" id="idValSer">
                        <rich:componentControl for="panelServices" attachTo="idValSer" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel"id="panelProprietaire"  width="600" height="400" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.showModalPanelProprietaire}">
        <f:facet name="header">
            <h:panelGroup>
                <center> <h:outputText value="GESTION DES PROPRIETAIRES (CLIENTS)"></h:outputText></center>
            </h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <a4j:form>
                <a4j:commandButton image="/images/close.gif" styleClass="hidelink" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.annuleProprietaire}" style="text-decoration:none;" id="idCancelPro">
                    <rich:componentControl for="panelProprietaire" attachTo="idCancelPro" operation="hide" event="onclick"/>
                </a4j:commandButton>
            </a4j:form>
        </f:facet>
        <a4j:form id="formPro">
            <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80">
                <h:column><h:outputText value="Nom du propriétaire:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:inputText id="idPro" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parcProprietaire.prcaffNomTiers}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parcProprietaire.prcaffId!=0}" maxlength="100">
                        <rich:toolTip id="tooladd4" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients (puis tabuler)" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.rechercheTiers}" reRender="panelTiers"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Adresse:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parcProprietaire.prcaffAdresseTiers}" style="width:100%" maxlength="100"/></h:column>
                <h:column><h:outputText value="Ville:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parcProprietaire.prcaffVilleTiers}" style="width:100%" maxlength="50"/></h:column>
                <h:column><h:outputText value="Contact:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parcProprietaire.prcaffContactTiers}" style="width:100%" maxlength="100"/></h:column>
                <h:column><h:outputText value="Téléphone:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parcProprietaire.prcaffTelTiers}" size="10" maxlength="20"/></h:column>
                <h:column><h:outputText value="Date début:"/></h:column>
                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parcProprietaire.prcaffDateDebut}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8" /></h:column>
                <h:column><h:outputText value="Date fin:"/></h:column>
                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.parcProprietaire.prcaffDateFin}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8" /></h:column>
            </h:panelGrid>
            <br><br>
            <center>
                <h:panelGroup >
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.saveProprietaire}" reRender="tableProprietaire,boutonProprietaire" style="text-decoration:none;" id="idValPro" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_affiche_valide_proprietaire}">
                        <rich:componentControl for="panelProprietaire" attachTo="idValPro" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel"id="panelTiers"  width="900" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.showModalPanelTiers}">
        <f:facet name="header">
            <h:panelGroup>
                <center> <h:outputText value="LISTE DES TIERS"></h:outputText></center>
            </h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <a4j:form>
                <a4j:commandButton image="/images/close.gif" styleClass="hidelink" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.annuleTiers}" reRender="idPro,idValPro" style="text-decoration:none;" id="idCancelTiers">
                    <rich:componentControl for="panelTiers" attachTo="idCancelTiers" operation="hide" event="onclick"/>
                </a4j:commandButton>
            </a4j:form>
        </f:facet>
        <a4j:form>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable height="400px" width="100%" headerClass="headerTab" selectedClass="active-row" var="tie" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.datamodelTiers}">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.selectionTiers}"/>
                    <rich:column  width="50%" >
                        <f:facet name="header"><h:outputText  value="NOM" /></f:facet>
                        <h:outputText value="#{tie.tieraisonsocialenom}"/>
                    </rich:column>
                    <rich:column  width="20%" >
                        <f:facet name="header"><h:outputText  value="TELEPHONE" /></f:facet>
                        <h:outputText value="#{tie.tieburtel1}"/>
                    </rich:column>
                    <rich:column  width="30%"  >
                        <f:facet name="header"><h:outputText  value="ADRESSE" /></f:facet>
                        <h:outputText value="#{tie.tieadresse}" />
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br><br>
            <center>
                <h:panelGroup >
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.valideTiers}" reRender="formPro,idPro,idValPro" style="text-decoration:none;" id="idValTiers">
                        <rich:componentControl for="panelTiers" attachTo="idValTiers" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>

</f:subview>
