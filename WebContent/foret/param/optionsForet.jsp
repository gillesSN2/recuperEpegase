<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="configForet">

    <a4j:form id="form1" >

        <center> <h2><h:outputText value="OPTIONS DE LA FORET" style="color:green;"/></h2></center>

        <center>
            <rich:tabPanel switchType="client" immediate="true"  style="border:0px;" id="idPanelOption">

                <rich:tab label="Inventaire forêt">
                    <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                        <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.affichInGlobViewINVENTAIRE}" style="width:200px;" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>
                <rich:tab label="Carnet chantier">
                    <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                        <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.affichInGlobViewCARNET}" style="width:200px;" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:outputText value = "Les arbres sont saisis:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.saisieCarnet}" style="width:200px;">
                            <f:selectItem itemLabel="dans le carnet" itemValue="0" />
                            <f:selectItem itemLabel="dans l'inventaire" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="B.roulage">
                    <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                        <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.affichInGlobViewROULAGE}" style="width:200px;" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:outputText value = "Les grumes sont saisies:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.saisieRoulage}" style="width:200px;">
                            <f:selectItem itemLabel="dans le bordereau de roulage" itemValue="0" />
                            <f:selectItem itemLabel="dans le carnet de chantier" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="B.route">
                    <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                        <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.affichInGlobViewROUTE}" style="width:200px;" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:outputText value = "Les grumes sont saisies:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.saisieRoute}" style="width:200px;">
                            <f:selectItem itemLabel="dans le bordereau de route" itemValue="0" />
                            <f:selectItem itemLabel="dans le bordereau de roulage" itemValue="1"/>
                            <f:selectItem itemLabel="dans le carnet de chantier" itemValue="2"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="B.expédition">
                    <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                        <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.affichInGlobViewEXPEDITION}" style="width:200px;" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:outputText value = "Les grumes sont saisies:"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.saisieExpedition}" style="width:200px;">
                            <f:selectItem itemLabel="dans le bordereau d'expédition" itemValue="0" />
                            <f:selectItem itemLabel="dans le bordereau de route" itemValue="1"/>
                            <f:selectItem itemLabel="dans le bordereau de roulage" itemValue="2"/>
                            <f:selectItem itemLabel="dans le carnet de chantier" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Compta.">
                    <center>
                        <h:panelGrid columns="2">
                            <h:outputText value = "Transfert documents:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.transfertDocument}" style="width:300px;">
                                <f:selectItem itemLabel="Uniquement les documents validés" itemValue="0" />
                                <f:selectItem itemLabel="Les documents en Cours et les validés" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:outputText value="Zone Référence 1:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.zoneRef1}" style="width:300px;">
                                <f:selectItem itemLabel="N° document en cours" itemValue="0" />
                                <f:selectItem itemLabel="N° bail." itemValue="30"/>
                                <f:selectItem itemLabel="N° bien" itemValue="31"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib1ENTETE}" itemValue="11" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib1}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib2ENTETE}" itemValue="12" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib2}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib3ENTETE}" itemValue="13" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib3}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib4ENTETE}" itemValue="14" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib4}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib5ENTETE}" itemValue="15" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib5}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib6ENTETE}" itemValue="16" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib6}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib7ENTETE}" itemValue="17" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib7}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib8ENTETE}" itemValue="18" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib8}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib9ENTETE}" itemValue="19" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib9}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib10ENTETE}" itemValue="20" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib10}"/>
                            </h:selectOneMenu>
                            <h:outputText value="Zone Référence 2:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.zoneRef2}" style="width:300px;">
                                <f:selectItem itemLabel="N° document en cours" itemValue="0" />
                                <f:selectItem itemLabel="N° bail." itemValue="30"/>
                                <f:selectItem itemLabel="N° bien" itemValue="31"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib1ENTETE}" itemValue="11" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib1}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib2ENTETE}" itemValue="12" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib2}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib3ENTETE}" itemValue="13" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib3}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib4ENTETE}" itemValue="14" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib4}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib5ENTETE}" itemValue="15" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib5}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib6ENTETE}" itemValue="16" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib6}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib7ENTETE}" itemValue="17" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib7}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib8ENTETE}" itemValue="18" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib8}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib9ENTETE}" itemValue="19" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib9}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib10ENTETE}" itemValue="20" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib10}"/>
                            </h:selectOneMenu>
                            <h:outputText value="Zone Libellé:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.zoneLibelle}" style="width:300px;">
                                <f:selectItem itemLabel="Nom tiers" itemValue="0" />
                                <f:selectItem itemLabel="Objet" itemValue="1"/>
                                <f:selectItem itemLabel="Objet + date document en cours" itemValue="2"/>
                                <f:selectItem itemLabel="Produit + Nom tiers" itemValue="3"/>
                            </h:selectOneMenu>
                            <h:outputText value="Zone Libellé suite:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.zoneLibelleSuite}" style="width:300px;">
                                <f:selectItem itemLabel="" itemValue="0" />
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib1ENTETE}" itemValue="11" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib1}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib2ENTETE}" itemValue="12" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib2}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib3ENTETE}" itemValue="13" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib3}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib4ENTETE}" itemValue="14" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib4}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib5ENTETE}" itemValue="15" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib5}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib6ENTETE}" itemValue="16" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib6}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib7ENTETE}" itemValue="17" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib7}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib8ENTETE}" itemValue="18" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib8}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib9ENTETE}" itemValue="19" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib9}"/>
                                <f:selectItem itemLabel="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.optionVentes.lib10ENTETE}" itemValue="20" itemDisabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.lib10}"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                    </center>
                </rich:tab>

            </rich:tabPanel>
        </center>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />&nbsp;&nbsp;&nbsp;&nbsp;
            <h:commandButton styleClass="exp_lienmenu" value="VALIDER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsVentes.creerOptionsVentes}" onclick="if (!confirm('Voulez-vous enregistrer les modifications ?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>

    </a4j:form>

</f:subview>