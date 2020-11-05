<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="configOffice">
    <a4j:form id="form1" >

        <center>
            <h2><h:outputText value="OPTIONS DE L'OFFICE" style="color:green;"/></h2>
        </center>

        <center>
            <rich:tabPanel switchType="client" immediate="true"  style="border:0px;">

                <rich:tab label="Mails/Sms">
                    <h:panelGrid  columns="2"  columnClasses="clos25,clos60g" width="100%">
                        <h:column><h:outputText value="Gestion des activités commerciales"/></h:column>
                        <h:column>
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.gestionComm}"  >
                            </h:selectBooleanCheckbox>
                        </h:column>
                        <h:column><h:outputText value ="Affichage dans la fiche tiers " /></h:column>
                        <h:column>
                            <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.affFicheTiers}" style="width:200px;">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Affichage dans la messagerie "   /></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.affMessagerie}"  style="width:200px;" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Affichage dans les cadeaux "   /></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.affCadeaux}"  style="width:200px;" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:outputText value = "Nombre ligne maximum des tiers"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.nbLigneMaxTi}" style="width:300px;">
                            <jsp:include flush="true" page="/commun/decoupageNbLigne.jsp"/>
                        </h:selectOneMenu>
                        <h:outputText value = "Nombre ligne maximum des messages"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.nbLigneMaxMs}" style="width:300px;">
                            <jsp:include flush="true" page="/commun/decoupageNbLigne.jsp"/>
                        </h:selectOneMenu>
                        <h:outputText value = "Nombre ligne maximum des cadeaux"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.nbLigneMaxCad}" style="width:300px;">
                            <jsp:include flush="true" page="/commun/decoupageNbLigne.jsp"/>
                        </h:selectOneMenu>
                        <h:outputText value = "Chargement des listes:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.chargementListe}" style="width:300px;">
                            <f:selectItem itemLabel="Manuel" itemValue="0" />
                            <f:selectItem itemLabel="Automatique" itemValue="1"/>
                        </h:selectOneMenu>
                        <h:outputText value = "Mode de saisie:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.saisieCourrier}" style="width:300px;">
                            <f:selectItem itemLabel="Autorisée" itemValue="0" />
                            <f:selectItem itemLabel="Interdite" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:panelGrid>

                </rich:tab>

                <rich:tab label="Rendez-vous">
                    <h:panelGrid  columns="2"  columnClasses="clos25,clos60g" width="100%">
                        <h:outputText value = "Nb jours passés pour modifier:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.nbJoursPasses}" style="width:300px;">
                            <f:selectItem itemLabel="0 jour" itemValue="0" />
                            <f:selectItem itemLabel="-1 jour" itemValue="-1"/>
                            <f:selectItem itemLabel="-2 jours" itemValue="-2"/>
                            <f:selectItem itemLabel="-3 jours" itemValue="-3"/>
                            <f:selectItem itemLabel="-4 jours" itemValue="-4"/>
                            <f:selectItem itemLabel="-5 jours" itemValue="-5"/>
                            <f:selectItem itemLabel="-6 jours" itemValue="-6"/>
                            <f:selectItem itemLabel="-7 jours" itemValue="-7"/>
                            <f:selectItem itemLabel="-30 jours" itemValue="-30"/>
                            <f:selectItem itemLabel="-365 jours" itemValue="-365"/>
                        </h:selectOneMenu>
                        <h:outputText value = "Onglet Contact:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.ongletContact}" style="width:300px;">
                            <f:selectItem itemLabel="Affichée" itemValue="0" />
                            <f:selectItem itemLabel="Masquée" itemValue="1"/>
                        </h:selectOneMenu>
                        <h:outputText value = "Onglet Collaborateur:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.ongletColaborateur}" style="width:300px;">
                            <f:selectItem itemLabel="Affichée" itemValue="0" />
                            <f:selectItem itemLabel="Masquée" itemValue="1"/>
                        </h:selectOneMenu>
                        <h:outputText value = "Prochains Rdv:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.majTodo}" style="width:300px;">
                            <f:selectItem itemLabel="Aucune Action" itemValue="0" />
                            <f:selectItem itemLabel="Mise à jour Prochain Rdv" itemValue="1"/>
                            <f:selectItem itemLabel="Mise à jour To do" itemValue="2"/>
                            <f:selectItem itemLabel="Mise à jour Prochain Rdv et Mise à jour To do" itemValue="3"/>
                        </h:selectOneMenu>
                        <h:outputText value = "Zones obligatoires:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.zoneObligatoire}" style="width:300px;">
                            <f:selectItem itemLabel="Tiers obligatoires" itemValue="0" />
                            <f:selectItem itemLabel="Tiers obligatoires + Sujet" itemValue="1"/>
                            <f:selectItem itemLabel="Tiers obligatoires + Sujet + prochaine action" itemValue="2"/>
                            <f:selectItem itemLabel="Tiers obligatoires + Sujet + prochaine action + Compte rendu" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Entete">
                    <center>
                        <h:panelGrid columns="2">
                            <h:outputText value="Libellé 1:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.lib1}"/>
                            <h:outputText value="Libellé 2:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.lib2}"/>
                            <h:outputText value="Libellé 3:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.lib3}"/>
                            <h:outputText value="Libellé 4:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.lib4}"/>
                            <h:outputText value="Libellé 5:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.lib5}"/>
                            <h:outputText value="Libellé 6:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.lib6}"/>
                            <h:outputText value="Libellé 7:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.lib7}"/>
                            <h:outputText value="Libellé 8:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.lib8}"/>
                            <h:outputText value="Libellé 9:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.lib9}"/>
                            <h:outputText value="Libellé 10:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.lib10}"/>
                        </h:panelGrid>
                    </center>
                </rich:tab>

                <rich:tab label="Impressions Commerciales" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.afficheAchat||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.afficheVente||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.afficheTreso}">
                    <center>
                        <h:panelGrid columns="2" headerClass="headerTab" width="100%" columnClasses="clos25,clos75" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.afficheAchat}">
                            <f:facet name="header"><h:outputText value="Achats"/></f:facet>
                            <h:column>
                                <h:outputText value="Etat 1:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libAch1}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleAch1}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesAchats}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 2:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libAch2}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleAch2}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesAchats}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 3:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libAch3}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleAch3}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesAchats}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 4:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libAch4}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleAch4}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesAchats}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 5:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libAch5}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleAch5}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesAchats}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 6:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libAch6}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleAch6}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesAchats}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 7:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libAch7}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleAch7}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesAchats}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 8:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libAch8}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleAch8}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesAchats}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 9:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libAch9}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleAch9}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesAchats}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 10:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libAch10}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleAch10}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesAchats}"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                        <h:panelGrid columns="2" headerClass="headerTab" width="100%" columnClasses="clos25,clos75" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.afficheAchat}">
                            <f:facet name="header"><h:outputText value="Stock"/></f:facet>
                            <h:column>
                                <h:outputText value="Etat 1:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libStk1}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleStk1}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesStocks}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 2:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libStk2}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleStk2}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesStocks}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 3:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libStk3}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleStk3}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesStocks}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 4:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libStk4}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleStk4}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesStocks}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 5:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libStk5}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleStk5}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesStocks}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 6:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libStk6}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleStk6}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesStocks}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 7:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libStk7}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleStk7}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesStocks}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 8:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libStk8}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleStk8}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesStocks}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 9:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libStk9}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleStk9}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesStocks}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 10:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libStk10}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleStk10}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesStocks}"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                        <h:panelGrid columns="2" headerClass="headerTab" width="100%" columnClasses="clos25,clos75" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.afficheVente}">
                            <f:facet name="header"><h:outputText value="Ventes"/></f:facet>
                            <h:column>
                                <h:outputText value="Etat 1:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libVte1}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleVte1}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesVentes}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 2:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libVte2}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleVte2}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesVentes}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 3:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libVte3}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleVte3}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesVentes}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 4:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libVte4}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleVte4}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesVentes}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 5:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libVte5}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleVte5}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesVentes}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 6:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libVte6}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleVte6}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesVentes}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 7:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libVte7}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleVte7}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesVentes}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 8:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libVte8}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleVte8}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesVentes}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 9:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libVte9}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleVte9}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesVentes}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 10:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libVte10}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleVte10}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesVentes}"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                        <h:panelGrid columns="2" headerClass="headerTab" width="100%" columnClasses="clos25,clos75" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.afficheTreso}">
                            <f:facet name="header"><h:outputText value="Trésorerie"/></f:facet>
                            <h:column>
                                <h:outputText value="Etat 1:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libTre1}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleTre1}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesTresorerie}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 2:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libTre2}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleTre2}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesTresorerie}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 3:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libTre3}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleTre3}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesTresorerie}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 4:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libTre4}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleTre4}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesTresorerie}"/>
                            </h:selectOneMenu>
                            <h:column>
                                <h:outputText value="Etat 5:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.libTre5}"/>
                            </h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.optionTiers.modeleTre5}" style="width:300px;">
                                <f:selectItem itemLabel="Sans modèle" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.mesModelesTresorerie}"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                    </center>
                </rich:tab>

            </rich:tabPanel>
        </center>
        <br>
        <center>
            <h:commandButton id="idCancel" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" value="RETOUR"styleClass="exp_lienmenu" />&nbsp;&nbsp;&nbsp;&nbsp;
            <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionTiers.creerOptionTiers}" styleClass="exp_lienmenu" value="VALIDER" onclick="if (!confirm('Voulez-vous enregistrer les modifications ?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>

        <center>
            <h:panelGroup id="prgoutpmessage">
                <h:messages infoStyle="color: red;" errorStyle="color: red;" />
            </h:panelGroup>
        </center>

    </a4j:form>

</f:subview>