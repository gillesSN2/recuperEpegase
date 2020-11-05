<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="configAchats">
    <a4j:form id="form1" >

        <center><h2><h:outputText value="OPTIONS DES PARCS" style="color:green;"/></h2></center>

        <rich:panel id="rich2" style="border:0px solid green;width:100%;">
            <h:panelGrid  columns="1" id="pan1" style="border:0px solid green;width:80%;">

                <rich:tabPanel switchType="client" immediate="true"  style="border:0px;" id="idManifeste">

                    <rich:tab label="Type" >
                        <h:panelGrid  columns="2" columnClasses="clos20,clos60g" width="100%">
                            <h:column><h:outputText  value="Type de parc:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.type}" style ="width:200px;">
                                    <f:selectItem itemLabel="Parc Privé" itemValue="0"/>
                                    <f:selectItem itemLabel="Parc Garage" itemValue="1"/>
                                    <f:selectItem itemLabel="Parc Fabriqué" itemValue="2"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="idOr"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:outputText value = "Nombre ligne maximum des documents:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.nbLigneMax}" style="width:300px;">
                                <jsp:include flush="true" page="/commun/decoupageNbLigne.jsp"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Chargement des listes:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.chargementListe}" style="width:300px;">
                                <f:selectItem itemLabel="Manuel" itemValue="0" />
                                <f:selectItem itemLabel="Automatique" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Transport de personnel" rendered="false">
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value ="Affichage dans la fiche parc:" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.affichageTransPersonnel}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Transport de matériel"  rendered="false">
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value ="Affichage dans la fiche parc:" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.affichageTransMateriel}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="TravauxPublics"  rendered="false">
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value ="Affichage dans la fiche parc:" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.affichageTPParc}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>                         
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.libelleMANIFEST}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.moduleTransit}">
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value="Affichage dans la vue globale:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.affichInGlobViewMANIFESTE}" style="width:200px;" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Libellé:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.libelleMANIFEST}" style="width:200px;" >
                                    <f:selectItem itemLabel="Manifeste" itemValue="Manifeste"/>
                                    <f:selectItem itemLabel="Dossier" itemValue="Dossier"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="idManifeste"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Contener:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.contenerMANIFEST}" style="width:200px;" >
                                    <f:selectItem itemLabel="Saisie libre" itemValue="0"/>
                                    <f:selectItem itemLabel="Gérer dans le Parc" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Chauffeur:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.chauffeurMANIFEST}" style="width:200px;" >
                                    <f:selectItem itemLabel="Saisie libre" itemValue="0"/>
                                    <f:selectItem itemLabel="Gérer dans la Paye" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Fonction Spéciale:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.ajoutMANIFESTE}" style="width:200px;" >
                                    <f:selectItem itemLabel="Ajout direct" itemValue="0"/>
                                    <f:selectItem itemLabel="Importation BETTERYARD" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Filtre produit:"   /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.produitMANIFEST}" style="width:200px;" >
                                    <f:selectItem itemLabel="Charge tous produits" itemValue="0"/>
                                    <f:selectItem itemLabel="Libellés liés aux destinations" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Prix minimal:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.minimumMANIFEST}" style="width:200px;" >
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Localisation" >
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value ="Affichage dans la fiche parc:" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.affichageGPSParc}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Consommation" >
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value ="Affichage dans la fiche parc:" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.affichageConParc}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Location">
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value ="Affichage dans la fiche parc:" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.affichageLocParc}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="O.R." id="idOr">
                        <h:panelGrid  columns="2"  columnClasses="clos20,clos60g" width="100%" >
                            <h:column><h:outputText value ="Affichage dans la fiche parc:" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.affichageORParc}" style="width:200px;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:outputText value = "Libellé produits:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.libProduit}" style="width:300px;">
                                <f:selectItem itemLabel="Utilise le libellé client" itemValue="1" />
                                <f:selectItem itemLabel="Utilise le libellé technique en priorité" itemValue="2"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Libellé des produits sur documents:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.libelleProduit}" style="width:300px;">
                                <f:selectItem itemLabel="Majuscule" itemValue="0" />
                                <f:selectItem itemLabel="Capital" itemValue="1"/>
                                <f:selectItem itemLabel="Minuscule" itemValue="2"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Affichage stock:"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.choixStock}" style="width:300px;">
                                <f:selectItem itemLabel="Stock réel" itemValue="0" />
                                <f:selectItem itemLabel="Stock estimé" itemValue="1"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Code TVA sur produits libres:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.type!=0}"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.tvaDefaut}" style="width:300px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.type!=0}">
                                <f:selectItem itemLabel="Sans code" itemValue="" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.mesTvaItem}"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Prix de vente:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.type!=0}"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.decrmtPriVteStock}" style="width:300px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.type!=0}">
                                <f:selectItem itemLabel="Prix de vente en H.T." itemValue="1" />
                                <f:selectItem itemLabel="Prix de vente en T.T.C." itemValue="2"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Rabais/Ristourne:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.type!=0}"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.decrmtRabais}" style="width:300px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.type!=0}">
                                <f:selectItem itemLabel="Gestion des rabais en global" itemValue="1" />
                                <f:selectItem itemLabel="Gestion des rabais par quantité" itemValue="2"/>
                                <f:selectItem itemLabel="Gestion des ristournes" itemValue="3"/>
                            </h:selectOneMenu>
                            <h:outputText value = "Nb Décimales P.U.:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.type!=0}"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.nbDecPu}" style="width:300px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.optionParcs.type!=0}">
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
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>

            </h:panelGrid>
            <center>
                <br>
                <h:commandButton id="idCancel" value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />&nbsp;&nbsp;&nbsp;&nbsp;
                <h:commandButton styleClass="exp_lienmenu"  value="VALIDER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionsParc.creerOptionParc}" onclick="if (!confirm('Voulez-vous enregistrer les modifications ?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
                <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
            </center>
        </rich:panel>

    </a4j:form>

</f:subview>