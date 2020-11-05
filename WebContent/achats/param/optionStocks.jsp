<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="configStocks">

    <a4j:form id="form1" >

        <center><h2><h:outputText value="OPTIONS DES STOCKS" style="color:green;"/></h2></center>

        <rich:panel id="rich2" style="border:0px solid green;width:100%;">
            <h:panelGrid  columns="1" id="pan1" style="border:0px solid green;width:100%;">

                <rich:tabPanel switchType="client" immediate="true"  style="border:0px;">

                    <rich:tab label="Inventaire" >
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsStocks.optionStocks.affichInGlobViewINV}" style="width:200px;" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>                       
                    </rich:tab>

                    <rich:tab label="Bon entrée">
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsStocks.optionStocks.affichInGlobViewBIN}" style="width:200px;" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>                          
                    </rich:tab>

                    <rich:tab label="Bon sortie">
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsStocks.optionStocks.affichInGlobViewBOUT}" style="width:200px;" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>                        
                    </rich:tab>

                    <rich:tab label="Cession">
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsStocks.optionStocks.affichInGlobViewCES}" style="width:200px;" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>                        
                    </rich:tab>

                    <rich:tab label="Production">
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsStocks.optionStocks.affichInGlobViewPRD}" style="width:200px;" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>                        
                    </rich:tab>

                    <rich:tab label="Divers">
                        <center>
                            <h:panelGrid columns="2">
                                <h:outputText value = "Nombre ligne maximum des documents:"/>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsStocks.optionStocks.nbLigneMax}" style="width:300px;">
                                    <jsp:include flush="true" page="/commun/decoupageN  bLigne.jsp"/>
                                </h:selectOneMenu>
                                <h:outputText value = "Gestion Stock négatif:"/>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsStocks.optionStocks.stockNegatif}" style="width:300px;">
                                    <f:selectItem itemLabel="Autorisé sans alerte" itemValue="0" />
                                    <f:selectItem itemLabel="Autorisé avec alerte" itemValue="1" />
                                    <f:selectItem itemLabel="Interdit" itemValue="2" />
                                </h:selectOneMenu>
                                <h:outputText value = "Choix demandeur/rapporteur:"/>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsStocks.optionStocks.demandeurRapporteur}" style="width:300px;">
                                    <f:selectItem itemLabel="Table utilisateur (Tout)" itemValue="0" />
                                    <f:selectItem itemLabel="Table utilisateur (Uniquement Responsables)" itemValue="1" />
                                    <f:selectItem itemLabel="Table utilisateur (Uniquement Autorisés)" itemValue="2" />
                                    <f:selectItem itemLabel="Table salarié" itemValue="3" />
                                    <f:selectItem itemLabel="Texte libre" itemValue="4" />
                                </h:selectOneMenu>
                                <h:outputText value = "Nb Décimales Quantités production:"/>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsStocks.optionStocks.nbDecQteProd}" style="width:300px;">
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
                                    <f:selectItem itemLabel="11" itemValue="11"/>
                                    <f:selectItem itemLabel="12" itemValue="12"/>
                                    <f:selectItem itemLabel="13" itemValue="13"/>
                                    <f:selectItem itemLabel="14" itemValue="14"/>
                                    <f:selectItem itemLabel="15" itemValue="15"/>
                                    <f:selectItem itemLabel="16" itemValue="16"/>
                                    <f:selectItem itemLabel="17" itemValue="17"/>
                                    <f:selectItem itemLabel="18" itemValue="18"/>
                                    <f:selectItem itemLabel="19" itemValue="19"/>
                                    <f:selectItem itemLabel="20" itemValue="20"/>
                                </h:selectOneMenu>
                                <h:outputText value = "Affichage stock:"/>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsStocks.optionStocks.choixStock}" style="width:300px;">
                                    <f:selectItem itemLabel="Stock réel" itemValue="0" />
                                    <f:selectItem itemLabel="Stock estimé" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:panelGrid>
                        </center>
                    </rich:tab>

                    <rich:tab label="Entete">
                        <center>
                            <h:panelGrid columns="2">
                                <h:outputText value="Libellé 1:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsStocks.optionStocks.lib1}"/>
                                <h:outputText value="Libellé 2:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsStocks.optionStocks.lib2}"/>
                                <h:outputText value="Libellé 3:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsStocks.optionStocks.lib3}"/>
                                <h:outputText value="Libellé 4:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsStocks.optionStocks.lib4}"/>
                                <h:outputText value="Libellé 5:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsStocks.optionStocks.lib5}"/>
                                <h:outputText value="Libellé 6:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsStocks.optionStocks.lib6}"/>
                                <h:outputText value="Libellé 7:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsStocks.optionStocks.lib7}"/>
                                <h:outputText value="Libellé 8:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsStocks.optionStocks.lib8}"/>
                                <h:outputText value="Libellé 9:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsStocks.optionStocks.lib9}"/>
                                <h:outputText value="Libellé 10:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsStocks.optionStocks.lib10}"/>
                            </h:panelGrid>
                        </center>
                    </rich:tab>

                </rich:tabPanel>

            </h:panelGrid>
            <br>
            <center>
                <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />&nbsp;&nbsp;&nbsp;&nbsp;
                <h:commandButton styleClass="exp_lienmenu"  value="VALIDER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsStocks.creerOptionStocks}" onclick="if (!confirm('Voulez-vous enregistrer les modifications ?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
                <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
            </center>
        </rich:panel>

    </a4j:form>

</f:subview>