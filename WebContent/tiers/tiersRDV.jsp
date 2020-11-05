<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="tiersRdv">

    <a4j:form id="formRdv">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText styleClass="titre" value="EVENEMENTS : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieraisonsocialenom}" /></h2></center>

        <h:panelGrid  id="cont1" width="100%" >          

            <h:panelGrid width="100%">
                <h:panelGrid columns="4" styleClass="recherche" width="100%" >
                    <h:column> <h:outputText value="       "/></h:column>
                    <h:column> <h:outputText value="Nature:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:150px"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.choixRdv}" >
                            <f:selectItem itemLabel="Toutes les natures" itemValue="99"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.mesNaturesRdvItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <a4j:commandButton  value="RECHERCHER"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.rechercherLesRdv}" reRender="elements,modAttente" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </h:panelGrid>

                <h:panelGrid id="pangrpVisbtMod" columns="4" width="200px" >
                    <a4j:commandButton title="Ajouter Evènement" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ajouterRdv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}" reRender="panelEvent"/>
                    <a4j:commandButton title="Modifier Evènement" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.modifierRdv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testRdv}" reRender="panelEvent"/>
                    <a4j:commandButton title="Supprimer Evènement" image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.deleteRdv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testRdv}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,elements"/>
                    <a4j:commandButton title="Imprimer Evènement" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testRdv}" />
                </h:panelGrid>

                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable rows="100" style="max-height:100%" styleClass="bg" id="elements" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dataModelPlanning}" var="rdv">
                        <a4j:support eventsQueue="maQueue" reRender="pangrpVisbtMod" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.selectionRDV}"/>
                        <rich:column width="10%" sortable="true" >
                            <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                            <h:outputText value="#{rdv.libNature}" />
                        </rich:column>
                        <rich:column width="10%">
                            <f:facet name="header" ><h:outputText value="Date"/></f:facet>
                            <h:outputText value="#{rdv.rdvDteDe}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column width="5%" sortable="true">
                            <f:facet name="header" ><h:outputText value="Heure"/></f:facet>
                            <h:outputText value="#{rdv.rdvHrDe}:#{rdv.rdvMnDe}" />
                        </rich:column>
                        <rich:column width="20%">
                            <f:facet name="header" ><h:outputText value="Objet"/></f:facet>
                            <h:outputText value="#{rdv.rdvSujet}" title="#{rdv.rdvSujet}"/>
                        </rich:column>
                        <rich:column width="25%">
                            <f:facet name="header" ><h:outputText value="Description"/></f:facet>
                            <h:outputText value="#{rdv.rdvDescript}" title="#{rdv.rdvDescript}"/>
                        </rich:column>
                        <rich:column width="30%">
                            <f:facet name="header" ><h:outputText value="Compte rendu"/></f:facet>
                            <h:outputText value="#{rdv.rdvCr}" title="#{rdv.rdvCr}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>

            <h:panelGroup>
                <center>
                    <a4j:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.retourPlanning}" reRender="modAttente,idSubView"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelEvent" width="750" height="550" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelRdv}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelRdv}" var="rdv">
            <f:facet name="header"><h:outputText value="GESTION D'UN EVENEMENT"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.annuleRdv}" image="/images/close.gif" styleClass="hidelink" reRender="panelEvent"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%" id="panelRdvGrid" headerClass="headerTab" >
                    <h:panelGrid style="width:100%;">
                        <h:panelGrid  style="width:100%;" columnClasses="clos20,clos80" columns="2">
                            <h:column><h:outputText value="Nature:" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newRdv.rdvNature}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.mesNaturesRdvItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.choixTypeRdv}" reRender="panelRdvGrid"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGroup id="tiers" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeRdv!=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeRdv!=8}" >
                            <h:panelGrid style="width:100%;" id="idTierTier" columnClasses="clos20,clos80"   columns="2">
                                <h:column><h:outputText style="text-decoration:underline"  value="Utilisateur:" /></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.selectedUserdest}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesUserItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGroup>
                        <h:panelGrid width="100%" columnClasses="clos20,clos80"  columns="2">
                            <h:column><h:outputText value="Date début:" /></h:column>
                            <h:column><rich:calendar style="background-color:green;color:white;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newRdv.rdvDteDe}" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy" /></h:column>
                        </h:panelGrid>
                        <h:panelGroup id="heure" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.typeRdv!=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.typeRdv!=8&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.typeRdv!=9}" >
                            <h:panelGrid width="100%" columnClasses="clos20,clos80" columns="2" >
                                <h:column><h:outputText value="Heure de début:" /></h:column>
                                <h:column>
                                    <h:panelGrid  columns="4">
                                        <h:column>
                                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newRdv.rdvHrDe}">
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}" />
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>h</h:column>
                                        <h:column>
                                            <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newRdv.rdvMnDe}">
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}" />
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>mn</h:column>
                                    </h:panelGrid>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGroup>
                        <h:panelGroup id="date" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeRdv==0}" >
                            <h:panelGrid width="100%" columnClasses="clos20,clos80"  columns="2">
                                <h:column><h:outputText value="Date fin" /></h:column>
                                <h:column><rich:calendar style="background-color:green;color:white;"   value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newRdv.rdvDteFi}" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy" /></h:column>
                            </h:panelGrid>
                            <h:panelGrid width="100%" columnClasses="clos20,clos80"  columns="2">
                                <h:column><h:outputText value="Heure fin:" /></h:column>
                                <h:column>
                                    <h:panelGrid  columns="4">
                                        <h:column>
                                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newRdv.rdvHrFi}">
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}" />
                                            </h:selectOneMenu></h:column>
                                        <h:column>h</h:column>
                                        <h:column>
                                            <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newRdv.rdvMnFi}">
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}" />
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>mn</h:column>
                                    </h:panelGrid>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid style="width:100%;" columnClasses="clos20,clos80"  columns="2">
                                <h:column><h:outputText value="Durée:" /></h:column>
                                <h:column>
                                    <h:panelGrid  columns="4"><h:column>
                                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newRdv.rdvHrDuree}">
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}" />
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>h</h:column>
                                        <h:column>
                                            <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newRdv.rdvMnDuree}">
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}" />
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>mn</h:column>
                                    </h:panelGrid>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGroup>
                        <h:panelGrid style="width:100%;" columnClasses="clos20,clos80"  columns="2">
                            <h:column><h:outputText value="Sujet:" /></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newRdv.rdvSujet}" /></h:column>

                            <h:column><h:outputText value="Description:" /></h:column>
                            <h:column><h:inputTextarea  cols="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newRdv.rdvDescript}" /></h:column>

                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeRdv==0}"><h:outputText style="text-decoration:underline"  value="Tache à faire:" /></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeRdv==0}">
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.choixTache}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesTachesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeRdv==0}"> <h:outputText value="Lieu concerné:" /></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeRdv==0}"><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newRdv.rdvLieu}" /></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeRdv==0}"><h:outputText value="Mode:" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newRdv.rdvMode}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeRdv==0}">
                                    <f:selectItem itemLabel="Non renseigné" itemValue="Non renseigné"/>
                                    <f:selectItem itemLabel="Téléphone" itemValue="Téléphone"/>
                                    <f:selectItem itemLabel="Mailing" itemValue="Mail"/>
                                    <f:selectItem itemLabel="Déplacement" itemValue="Démarchage"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
                <br/>
                <center>
                    <h:panelGroup  id="buttCompte">
                        <a4j:commandButton image="/images/valider_big.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.saveRdv}" reRender="panelEvent,elements"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>