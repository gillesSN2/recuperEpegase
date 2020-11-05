<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="configMedical">

    <a4j:form id="form1" >

        <center> <h2><h:outputText value="OPTIONS DU MEDICAL" style="color:green;"/></h2></center>

        <rich:panel id="rich2" style="border:0px solid green;width:100%;">
            <h:panelGrid  columns="1" id="pan1" style="border:0px solid green;width:100%;">

                <rich:tabPanel switchType="client" immediate="true"  style="border:0px;">

                    <rich:tab label="Consult.Général" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.infirmerie||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.cabinet||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.clinique||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.hopital}">
                        <h2>
                            <h:selectBooleanCheckbox rendered="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.gestConsultGenCC}" >
                                <f:selectItem itemLabel="Gestion des consultations générales" />
                            </h:selectBooleanCheckbox>&nbsp;&nbsp;
                            <h:outputText value = "Gestion des consultations générales"  styleClass = "panelOption" style = "width:100%;text-align:left"/>
                        </h2>
                        <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:column><h:outputText value = "Affichage dans la fiche tiers "/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.affichInTierViewCC}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:column><h:outputText value = "Affichage dans la vue globale "/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.affichInGlobViewCC}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:outputText value = "Renseignement Service:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.serviceCG}" style="width:200px;">
                                <f:selectItem itemLabel="Obligatoire" itemValue="0" />
                                <f:selectItem itemLabel="Optionnel" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:outputText value = "Renseignement Médecin:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.medecinCG}" style="width:200px;">
                                <f:selectItem itemLabel="Obligatoire" itemValue="0" />
                                <f:selectItem itemLabel="Optionnel" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:outputText value = "Délais de grâce (nb jours) si même médecin (actes sélectionnés):"/>
                            <h:column><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.nbrJrGraceCG}" style="width:50px;"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Consult.Sp" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.cabinet||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.clinique||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.hopital}">
                        <h2>
                            <h:selectBooleanCheckbox rendered="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.gestConsultGenCS}" >
                                <f:selectItem itemLabel="Gestion des consultations spécialisées" />
                            </h:selectBooleanCheckbox>&nbsp;&nbsp;
                            <h:outputText value = "Gestion des consultations spécialisées"  styleClass = "panelOption" style = "width:100%;text-align:left"/>
                        </h2>
                        <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:column><h:outputText value = "Affichage dans la fiche tiers "/></h:column>
                            <h:column><h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.affichInTierViewCS}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:column><h:outputText value = "Affichage dans la vue globale "/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.affichInGlobViewCS}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:outputText value = "Renseignement Service:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.serviceCS}" style="width:200px;">
                                <f:selectItem itemLabel="Obligatoire" itemValue="0" />
                                <f:selectItem itemLabel="Optionnel" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:outputText value = "Renseignement Médecin:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.medecinCS}" style="width:200px;">
                                <f:selectItem itemLabel="Obligatoire" itemValue="0" />
                                <f:selectItem itemLabel="Optionnel" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                         <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:outputText value = "Option Dentiste:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.dent}" style="width:200px;">
                                <f:selectItem itemLabel="Sans Dentiste" itemValue="0" />
                                <f:selectItem itemLabel="Avec Schéma dentaire FDI" itemValue="1"/>
                                <f:selectItem itemLabel="Avec Schéma dentaire Universelle (US)" itemValue="2"/>
                                <f:selectItem itemLabel="Avec Schéma dentaire Palmer" itemValue="3"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Pharmacie" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.pharmacie||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.hopital}">
                        <h2>
                            <h:selectBooleanCheckbox rendered="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.gestPharCP}" >
                                <f:selectItem itemLabel="Gestion de la pharmacie" />
                            </h:selectBooleanCheckbox>&nbsp;&nbsp;
                            <h:outputText value = "Gestion de la pharmacie"  styleClass = "panelOption" style = "width:100%;text-align:left"/>
                        </h2>
                        <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:column><h:outputText value = "Affichage dans la fiche tiers " /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.affichInTierViewCP}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:column><h:outputText value = "Affichage dans la vue globale "/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.affichInGlobViewCP}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:outputText value = "Renseignement Service:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.servicePH}" style="width:200px;">
                                <f:selectItem itemLabel="Obligatoire" itemValue="0" />
                                <f:selectItem itemLabel="Optionnel" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:outputText value = "Renseignement Médecin:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.medecinPH}" style="width:200px;">
                                <f:selectItem itemLabel="Obligatoire" itemValue="0" />
                                <f:selectItem itemLabel="Optionnel" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Laboratoire" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.laboratoire||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.clinique||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.hopital}">
                        <h2>
                            <h:selectBooleanCheckbox rendered="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.gestLaboratoireCL}" >
                                <f:selectItem itemLabel="Gestion des laboratoires" />
                            </h:selectBooleanCheckbox>&nbsp;&nbsp;
                            <h:outputText value = "Gestion des laboratoires"  styleClass = "panelOption" style = "width:100%;text-align:left"/>
                        </h2>
                        <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:column><h:outputText value = "Affichage dans la fiche tiers "/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.affichInTierViewCL}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:column><h:outputText value = "Affichage dans la vue globale "/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.affichInGlobViewCL}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:column><h:outputText value = "Affichage dans la paillasse "/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.affichInGlobViewPaillasse}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:outputText value = "Renseignement Service:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.serviceLB}" style="width:200px;">
                                <f:selectItem itemLabel="Obligatoire" itemValue="0" />
                                <f:selectItem itemLabel="Optionnel" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:outputText value = "Renseignement Médecin:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.medecinLB}" style="width:200px;">
                                <f:selectItem itemLabel="Obligatoire" itemValue="0" />
                                <f:selectItem itemLabel="Optionnel" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:outputText value = "Sélection laboratoire:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.choixLabo}" style="width:200px;">
                                <f:selectItem itemLabel="Entête" itemValue="0" />
                                <f:selectItem itemLabel="Ligne" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Hospitalisations" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.hopital}">
                        <h2>
                            <h:selectBooleanCheckbox rendered="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.gestHospitalisationCH}" >
                                <f:selectItem itemLabel="Gestion des hospitalisations" />
                            </h:selectBooleanCheckbox>&nbsp;&nbsp;
                            <h:outputText value = "Gestion des hospitalisations"  styleClass = "panelOption" style = "width:100%;text-align:left"/>
                        </h2>
                        <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:column><h:outputText value = "Affichage dans la fiche tiers "/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.affichInTierViewCH}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:column><h:outputText value = "Affichage dans la vue globale "/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.affichInGlobViewCH}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:outputText value = "Renseignement Médecin:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.medecinHP}" style="width:200px;">
                                <f:selectItem itemLabel="Obligatoire" itemValue="0" />
                                <f:selectItem itemLabel="Optionnel" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Devis" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.cabinet||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.clinique||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.hopital}">
                        <h:panelGrid  columns="4" columnClasses="clos25,clos25g,clos25,clos25g" width="100%">
                            <h:column><h:outputText value="Nombre jours de relance:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.nbrJrRelanceDEVIS}" style="width:50px;"/></h:column>
                            <h:column><h:outputText value="Nombre jour de validité:"/></h:column>
                            <h:column><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.nbrJrValidDEVIS}" style="width:50px;"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value ="Affichage dans la fiche tiers:" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.affichInTierFilDEVIS}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.affichInGlobViewDEVIS}" style="width:200px;" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Factures Tiers" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.pharmacie||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.laboratoire||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.cabinet||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.clinique||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.hopital}">
                        <h:panelGrid  columns="4" columnClasses="clos25,clos25g,clos25,clos25g" width="100%">
                            <h:column><h:outputText value="Nombre jours de relance:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.nbrJrRelanceFAC}" style="width:50px;"/></h:column>
                            <h:column><h:outputText value="Nombre jour de validité:"/></h:column>
                            <h:column><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.nbrJrValidFAC}" style="width:50px;"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value ="Affichage dans la fiche tiers:" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.affichInTierFilFAC}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.affichInGlobViewFAC}" style="width:200px;" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:outputText value = "Prix de vente:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.decrmtPriVteStock}" style="width:200px;">
                                <f:selectItem itemLabel="Prix de vente en H.T." itemValue="1" />
                                <f:selectItem itemLabel="Prix de vente en T.T.C." itemValue="2"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Mode refacturation:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.modeRefacturation}" style="width:200px;">
                                <f:selectItem itemLabel="Avec Détail des documents" itemValue="1" />
                                <f:selectItem itemLabel="Sans détail des documents" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Not.déb">
                        <h:panelGrid  columns="4" columnClasses="clos25,clos25g,clos25,clos25g" width="100%">
                            <h:column><h:outputText value="Nombre jours de relance:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.nbrJrRelanceNOTDEB}" style="width:50px;"/></h:column>
                            <h:column><h:outputText value="Nombre jour de validité:"/></h:column>
                            <h:column><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.nbrJrValidNOTDEB}" style="width:50px;"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value ="Affichage dans la fiche tiers:" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.affichInTierFilNOTDEB}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.affichInGlobViewNOTDEB}" style="width:200px;" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:outputText value = "Gestion du CTRL sur plafond:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.gestionPlafondNdb}" style="width:200px;">
                                <f:selectItem itemLabel="Non" itemValue="0" />
                                <f:selectItem itemLabel="Oui" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                    </rich:tab>


                    <rich:tab label="Avoirs" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.pharmacie||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.laboratoire||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.cabinet||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.clinique||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.hopital}">
                        <h:panelGrid  columns="4" columnClasses="clos25,clos25g,clos25,clos25g" width="100%">
                            <h:column><h:outputText value="Nombre jours de relance:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.nbrJrRelanceAVOIR}" style="width:50px;"/></h:column>
                            <h:column><h:outputText value="Nombre jour de validité:"/></h:column>
                            <h:column><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.nbrJrValidAVOIR}" style="width:50px;"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value ="Affichage dans la fiche tiers:" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.affichInTierFilAVOIR}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.affichInGlobViewAVOIR}" style="width:200px;" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Commissions">
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value="Affichage dans la vue globale:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.affichInGlobViewCOMMISSION}" style="width:200px;" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:outputText value = "Mode de calcul:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.modeCommission}"  style="width:200px;">
                                <f:selectItem itemLabel="Sans calcul des commissions" itemValue="0"/>
                                <f:selectItem itemLabel="Mode 1: sur le CA total par médecin" itemValue="1"/>
                                <f:selectItem itemLabel="Mode 2: sur le CA encaissé par médecin" itemValue="2"/>
                            </h:selectOneMenu>
                            <h:outputText value = "N° de compte:"/>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.compteDebit}" style="width:200px;"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Divers">
                        <center><h4><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.obsProduit}" style="color:red;"/></h4></center>
                        <br>
                        <h:panelGrid columns="2"  columnClasses="clos20,clos60g" width="100%" style="background-color:#DAEECB;">
                            <h:column><h:outputText value = "Utilisation des actes Personnels:"/></h:column>
                            <h:column><h:selectBooleanCheckbox  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.actePerso}"/></h:column>
                            <h:column><h:outputText value = "Utilisation des actes CCAM:"/></h:column>
                            <h:column><h:selectBooleanCheckbox  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.acteCcam}"/></h:column>
                            <h:column><h:outputText value = "Utilisation des actes NGAP:"/></h:column>
                            <h:column><h:selectBooleanCheckbox  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.acteNgap}"/></h:column>
                            <h:column><h:outputText value = "Nombre de caractéres des familles:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.nbrCtrsFamOP}"  style="width:300px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.griseProduit}">
                                    <f:selectItem itemLabel="2 c" itemValue="2"/>
                                    <f:selectItem itemLabel="3 c" itemValue="3"/>
                                    <f:selectItem itemLabel="4 c" itemValue="4"/>
                                    <f:selectItem itemLabel="5 c" itemValue="5"/>
                                    <f:selectItem itemLabel="6 c" itemValue="6"/>
                                    <f:selectItem itemLabel="7 c" itemValue="7"/>
                                    <f:selectItem itemLabel="8 c" itemValue="8"/>
                                    <f:selectItem itemLabel="9 c" itemValue="9"/>
                                    <f:selectItem itemLabel="10 c" itemValue="10"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value = "Mode de calcul de produits:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.modCalcOP}" style="width:300px;">
                                    <f:selectItem itemLabel="Code libre " itemValue="0"/>
                                    <f:selectItem itemLabel="Libre avec nb caractères fixe " itemValue="1"/>
                                    <f:selectItem itemLabel="Chrono simple sur ID + 1" itemValue="2"/>
                                    <f:selectItem itemLabel="Chrono simple sur nombre produit + 1" itemValue="3"/>
                                    <f:selectItem itemLabel="Chrono simple sur dernier code + 1" itemValue="4"/>
                                    <f:selectItem itemLabel="Chrono sur famille sur ID produit + 1" itemValue="5"/>
                                    <f:selectItem itemLabel="Chrono sur famille sur nombre produit + 1" itemValue="6"/>
                                    <f:selectItem itemLabel="Chrono sur famille sur dernier produit + 1" itemValue="7"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value = "Nombre de caractéres des produits:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.nbrCtrsProOP}"  style="width:300px;">
                                    <f:selectItem itemLabel="3 c" itemValue="3"/>
                                    <f:selectItem itemLabel="4 c" itemValue="4"/>
                                    <f:selectItem itemLabel="5 c" itemValue="5"/>
                                    <f:selectItem itemLabel="6 c" itemValue="6"/>
                                    <f:selectItem itemLabel="7 c" itemValue="7"/>
                                    <f:selectItem itemLabel="8 c" itemValue="8"/>
                                    <f:selectItem itemLabel="9 c" itemValue="9"/>
                                    <f:selectItem itemLabel="10 c" itemValue="10"/>
                                    <f:selectItem itemLabel="11 c" itemValue="11"/>
                                    <f:selectItem itemLabel="12 c" itemValue="12"/>
                                    <f:selectItem itemLabel="13 c" itemValue="13"/>
                                    <f:selectItem itemLabel="14 c" itemValue="14"/>
                                    <f:selectItem itemLabel="15 c" itemValue="15"/>
                                    <f:selectItem itemLabel="16 c" itemValue="16"/>
                                    <f:selectItem itemLabel="17 c" itemValue="17"/>
                                    <f:selectItem itemLabel="18 c" itemValue="18"/>
                                    <f:selectItem itemLabel="19 c" itemValue="19"/>
                                    <f:selectItem itemLabel="20 c" itemValue="20"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value = "Nombre ligne maximum des documents:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.nbLigneMax}" style="width:300px;">
                                    <jsp:include flush="true" page="/commun/decoupageNbLigne.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:outputText value="Descriptif complémentaire:" />
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.descriptifComplementaire}" style="width:300px;" >
                                <f:selectItem itemLabel="Sans" itemValue="0"/>
                                <f:selectItem itemLabel="Avec" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:column><h:outputText value = "Chargement des listes:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.chargementListe}" style="width:300px;">
                                    <f:selectItem itemLabel="Manuel" itemValue="0" />
                                    <f:selectItem itemLabel="Automatique" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:outputText value = "Nb Décimales Quantités:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.nbDecQte}" style="width:300px;">
                                <f:selectItem itemLabel="0" itemValue="0" />
                                <f:selectItem itemLabel="1" itemValue="1"/>
                                <f:selectItem itemLabel="2" itemValue="2"/>
                                <f:selectItem itemLabel="3" itemValue="3"/>
                                <f:selectItem itemLabel="4" itemValue="4"/>
                                <f:selectItem itemLabel="5" itemValue="5"/>
                                <f:selectItem itemLabel="6" itemValue="6"/>
                                <f:selectItem itemLabel="7" itemValue="7"/>
                                <f:selectItem itemLabel="8" itemValue="8"/>
                                <f:selectItem itemLabel="9" itemValue="9"/>
                                <f:selectItem itemLabel="10" itemValue="10"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Nb Décimales P.U.:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.nbDecPu}" style="width:300px;">
                                <f:selectItem itemLabel="0" itemValue="0" />
                                <f:selectItem itemLabel="1" itemValue="1"/>
                                <f:selectItem itemLabel="2" itemValue="2"/>
                                <f:selectItem itemLabel="3" itemValue="3"/>
                                <f:selectItem itemLabel="4" itemValue="4"/>
                                <f:selectItem itemLabel="5" itemValue="5"/>
                                <f:selectItem itemLabel="6" itemValue="6"/>
                                <f:selectItem itemLabel="7" itemValue="7"/>
                                <f:selectItem itemLabel="8" itemValue="8"/>
                                <f:selectItem itemLabel="9" itemValue="9"/>
                                <f:selectItem itemLabel="10" itemValue="10"/>
                            </h:selectOneMenu>
                            <h:column><h:outputText value = "Coef. de majoration des tiers:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.coefMajoration}" style="width:300px;">
                                    <f:selectItem itemLabel="N'impacte aucun tarif" itemValue="0" />
                                    <f:selectItem itemLabel="N'impacte que le tarif Tiers" itemValue="1"/>
                                    <f:selectItem itemLabel="Impacte le tarif Tiers et Patient" itemValue="2"/>
                                    <f:selectItem itemLabel="Impacte le tarif Tiers + écart Patient" itemValue="3"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="idPanGlobal,idCnam1,idCnam2"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value = "Choix tarif société:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.tarifSociete}" style="width:300px;">
                                    <f:selectItem itemLabel="Société avec tarif Assuré" itemValue="0" />
                                    <f:selectItem itemLabel="Société avec tarif non Assuré" itemValue="1"/>
                                    <f:selectItem itemLabel="Société avec tarif spécifique" itemValue="2"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <br>
                        <h:panelGrid  width="100%" style="background-color:white;" columns="2" id="idPanGlobal"  columnClasses="clos20,clos60g" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}">
                            <h:column><h:outputText value = "Utilisation Cnamgs:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.cnamgs}" style="width:300px;">
                                    <f:selectItem itemLabel="Non" itemValue="0" />
                                    <f:selectItem itemLabel="Oui" itemValue="1"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="idPanGlobal,idCnam1,idCnam2"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>

                    </rich:tab>

                    <rich:tab label="Gestion des Ages">
                        <center>
                            <h:panelGrid columns="2">
                                <h:column><h:outputText value="Age Bébé:"/></h:column>
                                <h:column>
                                    <h:outputText value="De:"/>&nbsp;
                                    <h:inputText value="0" style="width:50px;" readonly="true" disabled="true"/>&nbsp;&nbsp;
                                    <h:outputText value="an"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="A:"/>&nbsp;
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.anneeFinBebe}" style="width:50px;"/>
                                    <h:outputText value="an(s)"/>
                                </h:column>
                                <h:column><h:outputText value="Age Enfant:"/></h:column>
                                <h:column>
                                    <h:outputText value="De:"/>&nbsp;
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.anneeDebutEnfant}" style="width:50px;"/>&nbsp;&nbsp;
                                    <h:outputText value="an(s)"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="A:"/>&nbsp;
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.anneeFinEnfant}" style="width:50px;"/>
                                    <h:outputText value="an(s)"/>
                                </h:column>
                                <h:column><h:outputText value="Age Adolescent:"/></h:column>
                                <h:column>
                                    <h:outputText value="De:"/>&nbsp;
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.anneeDebutAdo}" style="width:50px;"/>&nbsp;&nbsp;
                                    <h:outputText value="an(s)"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="A:"/>&nbsp;
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.anneeFinAdo}" style="width:50px;"/>
                                    <h:outputText value="an(s)"/>
                                </h:column>
                                <h:column><h:outputText value="Age Adulte:"/></h:column>
                                <h:column>
                                    <h:outputText value="De:"/>&nbsp;
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.anneeDebutAdulte}" style="width:50px;"/>&nbsp;&nbsp;
                                    <h:outputText value="an(s)"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="A:"/>&nbsp;
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.anneeFinAdulte}" style="width:50px;"/>
                                    <h:outputText value="an(s)"/>
                                </h:column>
                                <h:column><h:outputText value="Age Sénior:"/></h:column>
                                <h:column>
                                    <h:outputText value="De:"/>&nbsp;
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.anneeDebutSenior}" style="width:50px;"/>&nbsp;&nbsp;
                                    <h:outputText value="an(s)"/>
                                </h:column>
                            </h:panelGrid>
                        </center>
                    </rich:tab>     

                    <rich:tab label="Compta.">
                        <center>
                            <h:panelGrid columns="2">
                            <h:column><h:outputText value = "N° compte des patients divers:"/></h:column>
                            <h:column><h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.comptePatient}" size="20"/></h:column>
                            <h:column><h:outputText value = "N° compte des produits std.:"/></h:column>
                            <h:column><h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.compteProduit}" size="20"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:outputText value = "N° compte CNAMGS AP:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.compteCNAMGSAP}" size="20"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:outputText value = "N° compte CNAMGS SP:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.compteCNAMGSSP}" size="20"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:outputText value = "N° compte CNAMGS GEF:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:inputText value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.compteCNAMGSGEF}" size="20"/></h:column>
                                <h:outputText value = "Transfert documents:"/>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.transfertDocument}" style="width:300px;">
                                    <f:selectItem itemLabel="Uniquement les documents validés" itemValue="0" />
                                    <f:selectItem itemLabel="Les documents en Cours et les validés" itemValue="1"/>
                                </h:selectOneMenu>
                                <h:outputText value="Zone Référence 1:"/>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.zoneRef1}" style="width:300px;">
                                    <f:selectItem itemLabel="N° document en cours" itemValue="0" />
                                </h:selectOneMenu>
                                <h:outputText value="Serie Référence 1:"/>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.zoneRef1Serie}" style="width:300px;">
                                    <f:selectItem itemLabel="Avec Série" itemValue="0" />
                                    <f:selectItem itemLabel="Sans Série" itemValue="1"/>
                                </h:selectOneMenu>
                                <h:outputText value="Zone Référence 2:"/>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.zoneRef2}" style="width:300px;">
                                    <f:selectItem itemLabel="N° document en cours" itemValue="0" />
                                </h:selectOneMenu>
                                <h:outputText value="Serie Référence 2:"/>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.zoneRef2Serie}" style="width:300px;">
                                    <f:selectItem itemLabel="Avec Série" itemValue="0" />
                                    <f:selectItem itemLabel="Sans Série" itemValue="1"/>
                                </h:selectOneMenu>
                                <h:outputText value="Zone Libellé:"/>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.optionMedical.zoneLibelle}" style="width:300px;">
                                    <f:selectItem itemLabel="Nom tiers" itemValue="0" />
                                    <f:selectItem itemLabel="Objet" itemValue="1"/>
                                    <f:selectItem itemLabel="Objet + date document en cours" itemValue="2"/>
                                    <f:selectItem itemLabel="Produit + Nom tiers" itemValue="3"/>
                                </h:selectOneMenu>
                            </h:panelGrid>
                        </center>
                    </rich:tab>

                </rich:tabPanel>

            </h:panelGrid>
            <center>
                <br>
                <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />&nbsp;&nbsp;&nbsp;&nbsp;
                <h:commandButton style="color:white;background-color:green;margin:3px 3px 3px 3px;width:180px;cursor:pointer;"  value="VALIDER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsMedical.creerOptionMedical}" onclick="if (!confirm('Voulez-vous enregistrer les modifications ?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
                <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
            </center>
        </rich:panel>

    </a4j:form>

</f:subview>